@file:Suppress("NOTHING_TO_INLINE", "ClassName", "UNCHECKED_CAST")

package dev.botta.lang

import kotlin.reflect.KProperty

interface MutableLazy<T> {
    var value: T
    fun isInitialized(): Boolean

    operator fun getValue(thisRef: Any?, property: KProperty<*>) = value

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: T) { this.value = value }
}

fun <T> mutableLazy(initializer: () -> T): MutableLazy<T> = SynchronizedMutableLazy(initializer)

fun <T> mutableLazy(initializer: () -> T, onChange: (newValue: T) -> Unit): MutableLazy<T> =
    SynchronizedMutableLazy(initializer, onChange)

private object UNINITIALIZED_VALUE

private class SynchronizedMutableLazy<T>(
    initializer: () -> T,
    private val onChange: ((newValue: T) -> Unit)? = null,
) : MutableLazy<T> {
    private var initializer: (() -> T)? = initializer

    @Volatile
    private var _value: Any? = UNINITIALIZED_VALUE

    override var value: T
        get() {
            val v1 = _value
            if (v1 !== UNINITIALIZED_VALUE) {
                return v1 as T
            }

            return synchronized(this) {
                val v2 = _value
                if (v2 !== UNINITIALIZED_VALUE) {
                    v2 as T
                } else {
                    val typedValue = initializer!!()
                    _value = typedValue
                    initializer = null
                    typedValue
                }
            }
        }
        set(value) {
            synchronized(this) { _value = value }
            onChange?.invoke(value)
        }

    override fun isInitialized() = _value !== UNINITIALIZED_VALUE

    override fun toString() = if (isInitialized()) value.toString() else "Lazy value not initialized yet."
}

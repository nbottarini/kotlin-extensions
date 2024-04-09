package dev.botta.lang.extensions

inline fun <T> T.alsoIf(condition: Boolean, block: (T) -> Unit): T {
    return this.also { if(condition) block(this) }
}

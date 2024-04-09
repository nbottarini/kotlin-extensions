package dev.botta.lang.extensions

fun Any?.ifNull(block: () -> Unit) {
    if (this == null) block()
}

fun <T: Any> T?.ifNotNull(block: (T) -> Unit) {
    if (this != null) block(this)
}

fun Any?.throwIfNull(block: () -> Throwable) {
    this.ifNull { throw block() }
}

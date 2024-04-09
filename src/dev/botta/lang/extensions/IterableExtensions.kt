package dev.botta.lang.extensions

inline fun <T> Iterable<T>.each(action: (T) -> Unit) = this.forEach(action)

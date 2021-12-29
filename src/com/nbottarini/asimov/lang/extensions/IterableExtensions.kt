package com.nbottarini.asimov.lang.extensions

inline fun <T> Iterable<T>.each(action: (T) -> Unit) = this.forEach(action)

package com.nbottarini.asimov.lang.extensions

fun Boolean.ifTrue(block: () -> Unit) {
    if (this) block()
}

fun Boolean.throwIfTrue(block: () -> Throwable) {
    this.ifTrue { throw block() }
}

fun Boolean.ifFalse(block: () -> Unit) {
    if (!this) block()
}

fun Boolean.throwIfFalse(block: () -> Throwable) {
    this.ifFalse { throw block() }
}

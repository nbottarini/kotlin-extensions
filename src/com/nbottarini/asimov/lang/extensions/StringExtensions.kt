package com.nbottarini.asimov.lang.extensions

fun String.camelToSnakeCase(): String {
    val camelRegex = "(?<=[a-zA-Z])[A-Z]".toRegex()
    return camelRegex.replace(this) { "_${it.value}" }.lowercase()
}

fun String?.throwIfNullOrBlank(block: () -> Throwable) {
    if (this == null || this.isBlank()) block()
}

fun String.lastWord() = this.substringAfterLast(" ")

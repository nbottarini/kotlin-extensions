package dev.botta.lang.extensions

fun List<Any>.stringArray() = this.map { it.toString() }.toTypedArray()

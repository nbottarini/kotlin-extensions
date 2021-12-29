package com.nbottarini.asimov.lang.extensions

fun List<Any>.stringArray() = this.map { it.toString() }.toTypedArray()

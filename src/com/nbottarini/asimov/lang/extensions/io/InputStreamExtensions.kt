package com.nbottarini.asimov.lang.extensions.io

import java.io.InputStream

fun InputStream.readText() = this.readAllBytes().decodeToString()

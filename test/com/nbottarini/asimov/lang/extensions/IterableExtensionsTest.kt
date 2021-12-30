package com.nbottarini.asimov.lang.extensions

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class IterableExtensionsTest {
    @Test
    fun `each iterates each element`() {
        val collection = listOf(1, 2, 3, 4, 5)
        val iterated = mutableListOf<Int>()

        collection.each { iterated.add(it) }

        assertThat(iterated).containsExactlyElementsOf(collection)
    }
}

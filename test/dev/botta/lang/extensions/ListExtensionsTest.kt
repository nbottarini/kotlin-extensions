package dev.botta.lang.extensions

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ListExtensionsTest {
    @Test
    fun `stringArray maps elements to strings`() {
        assertThat(listOf(1, 2, 3).stringArray()).isEqualTo(arrayOf("1", "2", "3"))
    }
}

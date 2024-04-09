package dev.botta.lang.extensions

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class AnyExtensionsTest {
    @Test
    fun `ifNull executes block if receiver is null`() {
        var executed = false
        val value = null

        value.ifNull { executed = true }

        assertThat(executed).isTrue
    }
}

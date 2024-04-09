package dev.botta.lang.extensions

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class GenericExtensionsTest {
    @Test
    fun `alsoIf executes block if condition is true`() {
        var executed = false
        val condition = true

        "".alsoIf(condition) { executed = true }

        assertThat(executed).isTrue
    }

    @Test
    fun `alsoIf doesn't execute block if condition is false`() {
        var executed = false
        val condition = false

        "".alsoIf(condition) { executed = true }

        assertThat(executed).isFalse
    }
}

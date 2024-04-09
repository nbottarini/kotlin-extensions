package dev.botta.lang.extensions

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class BooleanExtensionsTest {
    @Test
    fun `ifTrue executes block if value is true`() {
        var executed = false
        val value = true

        value.ifTrue { executed = true }

        assertThat(executed).isTrue
    }

    @Test
    fun `ifTrue doesn't execute block if value is false`() {
        var executed = false
        val value = false

        value.ifTrue { executed = true }

        assertThat(executed).isFalse
    }

    @Test
    fun `throwIfTrue throws exception if value is true`() {
        val value = true

        assertThrows<Exception> {
            value.throwIfTrue { Exception() }
        }
    }

    @Test
    fun `throwIfTrue doesn't throws exception if value is false`() {
        val value = false

        assertDoesNotThrow {
            value.throwIfTrue { Exception() }
        }
    }

    @Test
    fun `ifFalse executes block if value is false`() {
        var executed = false
        val value = false

        value.ifFalse { executed = true }

        assertThat(executed).isTrue
    }

    @Test
    fun `ifFalse doesn't execute block if value is true`() {
        var executed = false
        val value = true

        value.ifFalse { executed = true }

        assertThat(executed).isFalse
    }

    @Test
    fun `throwIfFalse throws exception if value is false`() {
        val value = false

        assertThrows<Exception> {
            value.throwIfFalse { Exception() }
        }
    }

    @Test
    fun `throwIfFalse doesn't throws exception if value is true`() {
        val value = true

        assertDoesNotThrow {
            value.throwIfFalse { Exception() }
        }
    }
}

package com.nbottarini.asimov.lang.extensions

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class StringExtensionsTest {
    @Test
    fun toSnakeCase() {
        assertThat("camelCased".toSnakeCase()).isEqualTo("camel_cased")
        assertThat("ThisIsAString".toSnakeCase()).isEqualTo("this_is_a_string")
        assertThat("this_is_a_string".toSnakeCase()).isEqualTo("this_is_a_string")
    }

    @Test
    fun lastWord() {
        assertThat("word".lastWord()).isEqualTo("word")
        assertThat("last word".lastWord()).isEqualTo("word")
        assertThat("some last word".lastWord()).isEqualTo("word")
        assertThat("".lastWord()).isEqualTo("")
    }

    @Test
    fun `throwIfNullOrBlank throws exception if string is null`() {
        val value: String? = null

        assertThrows<Exception> {
            value.throwIfNullOrBlank { Exception() }
        }
    }

    @Test
    fun `throwIfNullOrBlank throws exception if string is empty`() {
        val value = ""

        assertThrows<Exception> {
            value.throwIfNullOrBlank { Exception() }
        }
    }

    @Test
    fun `throwIfNullOrBlank throws exception if string is blank`() {
        val value = "  "

        assertThrows<Exception> {
            value.throwIfNullOrBlank { Exception() }
        }
    }

    @Test
    fun `throwIfNullOrBlank doesn't throw exception if string is not null or blank`() {
        val value = "some string"

        assertDoesNotThrow {
            value.throwIfNullOrBlank { Exception() }
        }
    }
}

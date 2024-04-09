@file:Suppress("UNUSED_VARIABLE")

package dev.botta.lang

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MutableLazyTest {
    @Test
    fun `is lazy`() {
        val someVar by mutableLazy { assert(false) }
    }

    @Test
    fun `is initialized only once`() {
        var initCount = 0
        val someVar by mutableLazy { initCount++ }
        val use1 = someVar
        val use2 = someVar

        assertThat(initCount).isEqualTo(1)
    }

    @Test
    fun `is mutable`() {
        var someVar by mutableLazy { "initial value" }
        someVar = "other value"

        assertThat(someVar).isEqualTo("other value")
    }
}

package me.mataha.puzzles.adventofcode.aoc2015

import me.mataha.puzzles.adventofcode.aoc2015.day02.ThereWouldBeNoMath
import me.mataha.puzzles.adventofcode.aoc2015.day02.Box
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class ThereWouldBeNoMathTests
{
    @DisplayName("something something")
    @ParameterizedTest(name = "asdf")
    @MethodSource("boxProvider")
    fun testGetSquareFeetOfWrappingPaper(boxes: List<Box>, expected: Int)
    {
        val day = ThereWouldBeNoMath()

        val actual = day.first(boxes)

        Assertions.assertEquals(expected, actual) {
            "..."
        }
    }

    companion object
    {
        @JvmStatic
        private fun boxProvider() : Stream<Arguments>
                = Stream.of(Arguments.of(listOf(Box(2, 3, 4)), 58),  //58, 34
                            Arguments.of(listOf(Box(1, 1, 10)), 43)) //43, 14
    }
}

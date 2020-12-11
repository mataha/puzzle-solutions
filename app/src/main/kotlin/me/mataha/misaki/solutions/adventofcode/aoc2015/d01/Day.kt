package me.mataha.misaki.solutions.adventofcode.aoc2015.d01

import me.mataha.misaki.domain.NoOpParser
import me.mataha.misaki.domain.adventofcode.AdventOfCode
import me.mataha.misaki.domain.adventofcode.AdventOfCodeDay

/** See [https://adventofcode.com/2015/day/1]. */
@AdventOfCode("Not Quite Lisp", 2015, 1)
class NotQuiteLisp : AdventOfCodeDay<String, Int>(), NoOpParser {
    override fun solveFirst(input: String): Int {
        var floor = 0

        for (char in input) {
            floor = changeFloor(char, floor)
        }

        return floor
    }

    override fun solveSecond(input: String): Int {
        var floor = 0

        for ((index, char) in input.withIndex()) {
            floor = changeFloor(char, floor)

            if (floor < 0) {
                return index + 1
            }
        }

        return BASEMENT_NOT_ENTERED
    }

    companion object {
        const val BASEMENT_NOT_ENTERED = -1
    }
}

private fun changeFloor(char: Char, floor: Int): Int = when (char) {
    '(' -> floor + 1
    ')' -> floor - 1
    else -> floor
}

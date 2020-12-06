package me.mataha.misaki.solutions.adventofcode.aoc2015.d04

import me.mataha.misaki.domain.NoOpParser
import me.mataha.misaki.domain.adventofcode.AdventOfCode
import me.mataha.misaki.domain.adventofcode.AdventOfCodeDay
import me.mataha.misaki.util.annotations.VisibleForTesting
import me.mataha.misaki.util.extensions.md5Hex

/** See [https://adventofcode.com/2015/day/4]. */
@AdventOfCode("The Ideal Stocking Stuffer", 2015, 4)
class IdealStockingStuffer : AdventOfCodeDay<String, Int>(), NoOpParser {
    override fun solveFirst(input: String): Int = md5StartingWith(input, "0".repeat(5))

    override fun solveSecond(input: String): Int = md5StartingWith(input, "0".repeat(6))
}

@VisibleForTesting
internal fun md5StartingWith(key: String, prefix: String, range: IntRange = IntRange.NATURAL): Int {
    require(range.first > 0) {
        "Lower bound must be a positive number (is: ${range.first})"
    }

    for (number in range) {
        val string = key + number

        if (string.md5Hex().startsWith(prefix)) {
            return number
        }
    }

    // Hash starting with that prefix was not found (given supplied range)
    return HASH_NOT_FOUND
}

private const val HASH_NOT_FOUND = -1

private val IntRange.Companion.NATURAL: IntRange by lazy { IntRange(1, Int.MAX_VALUE) }

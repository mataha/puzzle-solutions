package me.mataha.puzzles.solutions.adventofcode.aoc2015.d04

import me.mataha.puzzles.domain.OneLineParser
import me.mataha.puzzles.domain.adventofcode.AdventOfCode
import me.mataha.puzzles.domain.adventofcode.AdventOfCodeDay
import me.mataha.puzzles.util.annotations.VisibleForTesting
import me.mataha.puzzles.util.extensions.md5Hex

@AdventOfCode("The Ideal Stocking Stuffer", 2015, 4)
class IdealStockingStuffer: AdventOfCodeDay<String, Int>(), OneLineParser
{
    override fun first(input: String): Int = md5StartingWith(input, "00000")

    override fun second(input: String): Int = md5StartingWith(input, "000000")

    @VisibleForTesting
    internal companion object
    {
        @VisibleForTesting
        internal fun md5StartingWith(key: String, prefix: String): Int
        {
            for (number in 1..Int.MAX_VALUE)
            {
                val string = key + number

                if (string.md5Hex().startsWith(prefix))
                {
                    return number
                }
            }

            return -1
        }
    }
}

package me.mataha.puzzles.solutions.adventofcode.aoc2015.d07

@ExperimentalUnsignedTypes
class Circuit private constructor()
{
    private val parts: MutableMap<String, Part> = mutableMapOf()

    private fun add(part: Part): Circuit
            = apply { parts[part.identifier] = part }

    fun add(parts: Collection<Part>): Circuit
            = apply { parts.forEach { part -> add(part) } }

    private val signals: MutableMap<String, UShort> by lazy { mutableMapOf() }

    operator fun get(wireIdentifier: String): UShort
            = signals[wireIdentifier] ?: computeSignal(wireIdentifier)

    operator fun set(wireIdentifier: String, signal: UShort): Circuit
            = apply { signals[wireIdentifier] = signal }

    fun reset(): Circuit
            = apply { signals.clear() }

    private fun computeSignal(wireIdentifier: String): UShort
    {
        val signal = parts[wireIdentifier]?.getSignal(this)
            ?: throw IllegalArgumentException("Part with identifier '$wireIdentifier' does not exist.")

        signals[wireIdentifier] = signal

        return signal
    }

    companion object
    {
        fun of(parts: Collection<Part> = setOf()): Circuit = Circuit().add(parts)
    }
}

package org.demo

// Multiplier interface to be able to multiply up any two numbers
interface Multiplier<N : Number> {
    fun multiply(left: N, right: N): N
}

// Singleton instance
object IntMultiplier : Multiplier<Int> {
    override fun multiply(left: Int, right: Int) = left * right
}

// Classes can have Companions. Kotlin has no static but maybe soon https://github.com/Kotlin/KEEP/issues/348
class WithCompanion {
    companion object { // Basically a static inner class
        val day = "bright" // the members of the static inner class
        const val NIGHT = "dark"
    }
}

const val PI_CONSTANT = "3.14" // better option, eg: config, tests

fun main() {
    println(IntMultiplier.multiply(3, 3))
    println(object : Multiplier<Double> {
        override fun multiply(left: Double, right: Double) = left * right
    }.multiply(3.0, 2.0))

    println(WithCompanion.day)
    println(WithCompanion.NIGHT)
    println(PI_CONSTANT)
}
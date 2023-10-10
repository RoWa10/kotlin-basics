package org.demo

// Operator interface to be able to operate any two numbers
interface Operator<N : Number> {
    fun operation(left: N, right: N): N
}

// An `object` is a true Singleton instance
// We can assign them to variables, define their properties and functions, implement interfaces,
// and use them throughout your code as needed
object IntMultiplier : Operator<Int> {
    override fun operation(left: Int, right: Int) = left * right
}

// Classes can have Companions. Kotlin has no static, a possibility soon: https://github.com/Kotlin/KEEP/issues/348
class WithCompanion {
    companion object { // Basically a static inner class
        val day = "bright" // the members of the static inner class
        const val NIGHT = "dark"
    }
}

const val PI_CONSTANT = "3.14" // better option, eg: config, tests

fun main() {
    println(IntMultiplier.operation(3, 3))

    println(object : Operator<Double> {
        override fun operation(left: Double, right: Double) = left + right
    }.operation(3.0, 2.0))

    println(WithCompanion.day)
    println(WithCompanion.NIGHT)
    println(PI_CONSTANT)
}
package org.demo

import org.demo.Color.*

enum class Color {
    RED, GREEN, BLUE
}

fun getColor() = RED

fun main() {

    val a = 2
    val b = 3
    var max = a
    if (a < b) max = b
    // With else
    if (a > b) {
        max = a
    } else {
        max = b
    }
    // As expression. There is no ternary operator condition ? then : else in Kotlin.
    // When using if as an expression, there are no curly braces {}
    max = if (a > b) a else b
    // You can also use `else if` in expressions:
    val maxLimit = 1
    val maxOrLimit = if (maxLimit > a) maxLimit else if (a > b) a else b
    println("max is $max")
    println("maxOrLimit is $maxOrLimit")

    // `when` defines a conditional expression with multiple branches.
    // It is similar to the switch statement in C-like languages. Its simple form looks like this.
    // https://kotlinlang.org/docs/control-flow.html#when-expression

    when (a) {
        1 -> print("x == 1")
        2 -> print("x == 2")
        else -> {
            print("x is neither 1 nor 2")
        }
    }

    when (getColor()) {
        RED -> println("red")
        GREEN -> println("green")
        BLUE -> println("blue")
        // 'else' is not required because all cases are covered
    }

    when (getColor()) {
        RED -> println("red") // no branches for GREEN and BLUE
        else -> println("not red") // 'else' is required
    }

    when (getColor()) {
        RED, GREEN -> println("red-green") // no branches for GREEN and BLUE
        else -> println("not red") // 'else' is required
    }


    // `for` in Kotlin works the same way as in most languages. similar to `forEach` in Java
    val cakes = listOf("carrot", "cheese", "chocolate")
    for (cake in cakes) {
        println("Yummy, it's a $cake cake!")
    }
    println("===============================================")
    for (cake in cakes.withIndex()) { // IndexedValue of the list
        println("Yummy, The shelf ${cake.index} has ${cake.value} cake!")
    }

    // while / do-while loops execute as long as a condition is met

    fun eatACake() = println("Eat a Cake")
    fun bakeACake() = println("Bake a Cake")
    var cakesEaten = 0
    var cakesBaked = 0
    while (cakesEaten < 5) { // Executes the block while the condition is true.
        eatACake()
        cakesEaten++
    }

    // Executes the block first and then checking the condition.
    do {
        bakeACake()
        cakesBaked++
    } while (cakesBaked < cakesEaten)

    println("===============================================")

    for (i in 10 downTo 0 step 2) { // infix fun Int.downTo returns an `IntProgression` with the given step
        println(i)
    }

    println("===============================================")

    for (i in 1..30) {
        when {
            i > 11 -> break // break out of the loop
            i % 2 != 0 -> continue // continue with next iteration
        } // More on when https://play.kotlinlang.org/byExample/02_control_flow/01_When
        println(i) // print `2`, `4`, `6`, `8`, `10`
    }

    // Ranges: https://play.kotlinlang.org/byExample/02_control_flow/03_Ranges
    for (i in 0..3) {             // Iterates over a range starting from 0 up to 3 (inclusive). Like 'for(i=0; i<=3; ++i)' in other programming languages (C/C++/Java).
        print(i)
    }
    print(" ")

    for (i in 0 until 3) {        // Iterates over a range starting from 0 up to 3 (exclusive). Like for loop in Python or like 'for(i=0; i<3; ++i)' in other programming languages (C/C++/Java).
        print(i)
    }
    print(" ")

    for (i in 2..8 step 2) {      // Iterates over a range with a custom increment step for consecutive elements.
        print(i)
    }
    print(" ")

    for (i in 3 downTo 0) {      // Iterates over a range in reverse order.
        print(i)
    }
    print(" ")
    println()
    // Ranges are also useful in if statements:
    val x = 2
    if (x in 1..5) {            // Checks if a value is in the range.
        println("x is in range from 1 to 5")
    }
    println()

    if (x !in 6..10) {          // !in is the opposite of in.
        println("x is not in range from 6 to 10")
    }

}
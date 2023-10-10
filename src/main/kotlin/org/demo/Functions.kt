package org.demo

// Functions can be written as methods of classes
class Pet {
    fun cat() {
        println("cat")
    }
}

// Top-level functions, basically functions without classes and are placed in a file called `<Filename>Kt.class`
fun cat() = Pet().cat()

// return value is inferred, functions as expression
fun hello() = "Hello"

// functions can have default values for the arguments.BTS, compiler creates multiple functions with and without default values.
fun greet(name: String = "Kotlin"): String =
    hello() + " " + name

// every function returns something if nothing useful then Unit
fun printMessage(): Unit =
    println("Hello World, How are you?")

fun sum(x: Int, y: Int) = x + y // functions can have parameters

fun operation(left: Int, right: Int): Int = left * right // return value can be specified

// Extension functions: Kotlin lets you add new members to any class with the extensions mechanism
fun Int.addTwiceOf(y: Int): Int = this + (y * 2)

// Member functions and extensions with a single parameter can be turned into infix functions.
infix fun Int.times(str: String) = str.repeat(this)
val pokeThrice = 3 times "Poke "

// A higher-order function: a function that takes another function as parameter and/or returns a function

// The `calculate` fun takes two integer parameters, x and y. Additionally, it takes another function operation as a parameter.
// The operation parameters and return type are also defined in the declaration.
// Returns the result of operation invocation with the supplied arguments.
fun calculate(
    x: Int,
    y: Int,
    operation: (Int, Int) -> Int
): Int {
    return operation(x, y)
}

// Declares a higher-order function that returns a function.
// (Int) -> Int represents the parameters and return type of the square function.
fun returnsFunction(): (Int) -> Int {
    return ::square
}

fun square(x: Int) = x * x

// `main` is also a Top-level function
fun main() {
    cat()
    println(hello()) // `Hello`
    println(sum(y = 1, x = 2)) // `3`
    println(greet()) // `Hello World`
    println(operation(1, 2)) // `2`
    println(printMessage()) // `Hello World` and `kotlin.Unit`
    println("Add twice of 4 to 2 ${2.addTwiceOf(4)}")
    println("3pokes: $pokeThrice")

    // Invokes the higher-order function passing in two integer values and the function argument ::sum. :: is the notation that references a function by name in Kotlin.
    val sumResult = calculate(4, 5, ::sum)
    // Invokes the higher-order function passing in a lambda as a function argument. Looks clearer, doesn't it?
    val mulResult = calculate(4, 5) { a, b -> a * b }
    println("sumResult $sumResult, mulResult $mulResult")

    // Invokes operation to get the result assigned to a variable. Here func becomes square which is returned by operation.
    val func = returnsFunction()
    println("Square of 2: " + func(2)) // The square function is actually executed.
}




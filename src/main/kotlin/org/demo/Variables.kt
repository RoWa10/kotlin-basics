package org.demo

fun main() {

    // Values is assigned and cannot change. The Type `String` is inferred
    val final = "I am an unchangeable string"
    println(final)

    val one: Int = 1  // immediate assignment
    println(one)

    val two = 2   // `Int` type is inferred
    println(two)

    val nonInitializedInt: Int  // Type required when no initializer is provided
    nonInitializedInt = 3       // deferred assignment
    println(nonInitializedInt)

    var x = 1 // Variables are assigned and can change later
    x += 11
    println("X is: $x")

    // declare variables and assign them later.
    // Type is explicit as it cannot be inferred. Avoid if possible because it could lead to RuntimeException
    // Lazy Initialization, tests etc..
    lateinit var later: String
    //println(later)

}
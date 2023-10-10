package org.demo

import java.math.BigDecimal

// Extension functions create a static function on the declared class.
fun String.hello(): String { // extension function creates a `this` receiver on the object they extend
    return "Hello $this! (length: $length)"
}

// extension functions can also be created on `nullable` types
fun Int?.add(number: Int): Int = this?.and(number) ?: number

// Since extensions do not actually insert members into classes, there's no efficient way for an extension property to have a backing field.
// This is why initializers are not allowed for extension properties.
// Their behavior can only be defined by explicitly providing getters/setters.

// Define an extension property for the String class
val String.customLength: Int
    get() = length

// val String.upperCase = this.uppercase() // error: initializers are not allowed for extension properties

val bigDecimal100 = BigDecimal(100) // Regular way, little tedious
val Int.bd : BigDecimal
    get() = BigDecimal(this)
val bigDecimal200 = 200.bd

val globalStorage = mutableMapOf <Int, String>()
private var Int.description: String
    get() = globalStorage[this] ?: ""
    set(value){
        globalStorage[this] = value
    }

fun main() {
    println("World".hello())
    println((null as Int?).add(5))

    // Infix notation on function https://kotlinlang.org/docs/functions.html#infix-notation
    infix fun Int.multiply (x: Int) = this * x
    // calling the function using the infix notation
     3 multiply 3
    // is the same as
     3.multiply(3)

    open class Shape
    class Rectangle: Shape()

    fun Shape.getName() = "Shape"
    fun Rectangle.getName() = "Rectangle"

    fun printClassName(s: Shape) {
        println(s.getName())
    }

    printClassName(Rectangle())

    // Access the extension property
    val length = "TestString".customLength
    println("Length of the string: $length")

    println("bigDecimal100: $bigDecimal100 , bigDecimal200: $bigDecimal200")

    42.description = """
        |42 test description
        |40+2
    """.trimMargin()
    println(42.description)
}
package org.demo

// Extension functions create a static function on the declared class.
fun String.hello(): String { // extension function creates a `this` receiver on the object they extend
    return "Hello $this! (length: $length)"
}

// extension functions can also be created on `nullable` types
fun Int?.add(number: Int): Int = this?.and(number) ?: number



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
}
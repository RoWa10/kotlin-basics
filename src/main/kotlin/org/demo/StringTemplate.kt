package org.demo

const val greeting = "Fellow Kotlin learners"

fun main() {
    println("Hello $greeting") // Prints a string with a variable reference. References in strings start with $
    println("Hello ${greeting.uppercase()}") // Prints a string with an expression. Expressions start with $ and are enclosed in curly braces.

}
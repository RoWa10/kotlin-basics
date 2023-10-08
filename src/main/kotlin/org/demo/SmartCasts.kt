package org.demo

fun main() {

    // Casts from nullable types to their non-nullable counterparts.
    val string: String? = "Hello World!"
    println(string?.length ?: 0)
    if (string != null) { // Smart cast from `nullable String` to `String`
        print(string.length) // No `?` operator needed
    }

    // Casts from a supertype to a subtype.
    val number: Number = 1 // Instantiating an `Int` as `Number`
    println((number as Int).and(2))
    if (number is Int) { // Smart cast from `Number` to `Int`
        println(number.and(2)) // No additional casting required
    }
}
package org.demo

// https://play.kotlinlang.org/byExample/08_productivity_boosters/04_Smart%20Casts
fun main() {
    // Smart-cast inside a condition (this is possible because, like Java, Kotlin uses short-circuiting).

    // Casts from nullable types to their non-nullable counterparts.
    val string: String? = "Hello World!"
    println(string?.length ?: 0)
    if (string != null) { // Smart cast from `nullable String` to `String`
        print(string.length) // No `?` operator needed, direct access to the length property
    }

    // Casts from a supertype to a subtype.
    val number: Number = 1 // Instantiating an `Int` as `Number`
    // println((number as Int).and(2))
    if (number is Int) { // Smart cast from `Number` to `Int`
        println(number.and(2)) // No additional casting required
    }

}
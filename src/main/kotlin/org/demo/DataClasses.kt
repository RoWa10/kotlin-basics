package org.demo

// Similar to Records in Java 17, examples, Pair, Triple
// Generates getters, setters, toString(), equals(), hasCode, copy()
// When using data classes with OR mapper, override the generated methods to avoid use of lazy loaded fields.
data class DataContact(val id: Int, val email: String)

fun main() {
    // == is same as `.equals()` in java and compares the values
    // === is same as == in Java, for reference comparison
    println(Contact(1, "mary@gmail.com")) // org.demo.Contact@7f63425a
    println(Contact(1, "mary@gmail.com") == Contact(1, "mary@gmail.com")) //false

    println(DataContact(1, "mary@gmail.com")) // DataContact(id=1, email=mary@gmail.com)
    println(DataContact(1, "mary@gmail.com") == DataContact(1, "mary@gmail.com")) // true
    println(DataContact(1, "mary@gmail.com") === DataContact(1, "mary@gmail.com")) // false

    // More on Equality: https://kotlinlang.org/docs/equality.html
}
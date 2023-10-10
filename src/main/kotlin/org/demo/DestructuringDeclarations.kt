package org.demo

// Destructuring declaration syntax can be very handy, especially when you need an instance only for accessing its members.
// It lets you define the instance without a specific name therefore saving a few lines of code.

fun main() {
    // Destructures an Array.
    // The number of variables on the left side matches the number of arguments on the right side.
    val (x, y, z) = arrayOf(5, 10, 15)
    println("X is: $x")
    println("Y is: $y")
    println("Z is: $z")

    // Maps can be destructured as well. name and age variables are mapped to the map key and value.
    val map = mapOf("Alice" to 21, "Bob" to 25)
    for ((name, age) in map) {
        println("$name is $age years old")
    }

    val dataContact = DataContact(1, "mary@gmail.com")
    // Destructures an instance. Declared values are mapped to the instance fields.
    val (id: Int, emailAddress) = dataContact
    // Data class automatically defines the component1() and component2() methods that will be called during destructuring.
    println(id == dataContact.component1())
    // Use underscore if you don't need one of the values, avoiding the compiler hint indicating an unused variable.
    val (_, email) = dataContact
    println(email)
}
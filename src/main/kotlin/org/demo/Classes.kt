package org.demo

// https://kotlinlang.org/docs/classes.html

// Declares a class without any properties or user-defined constructors.
// A non-parameterized default constructor is created by Kotlin automatically. Classes don't need a body e.g. for markers
class Empty

// Declares a class with two properties: immutable id and mutable email, and a constructor with two parameters id and email
class Contact(val id: Int, var email: String)

// No instantiation from outside, builder methods can be used internally to instantiate the class
class Internal private constructor()

// Properties in Kotlin classes can be declared either as mutable, using the var keyword, or as read-only, using the val keyword.
// The initializer, getter, and setter are optional.
// The property type is optional if it can be inferred from the initializer or the getter's return type, as shown below:
class Rectangle(val width: Int, val height: Int) {
    val area: Int // property type is optional since it can be inferred from the getter's return type
        get() = this.width * this.height // example of a custom getter:
}

// Backing fields: Backing field is generated only if a property uses the default implementation of the accessors (getter/setter).
// Thw backing field can be accessed using `field` keyword inside accessors
class User {
    // Property firstName with a backing field, declared using the var keyword, indicating that it has both a getter and a setter.
    var firstName: String = ""
        get() = field
        set(value) {
            field = value
        }
    //  set(value) {firstName = value}
    //  in Kotlin user.firstName = "value” is same as Java’s user.setFirstName("value").
    //  So when set(value) {firstName = "value"} is called, then a recursive call happens and compiler throws a StackOverflow exception because we are calling setter inside the setter.

    var lastName: String = ""
        get() = field
        set(value) {
            field = value
        }
}

fun main() {
    val contact = Contact(1, "mary@gmail.com")
    println(contact.id)
    contact.email = "jane@gmail.com"
    println(contact.email)

    val rectangle = Rectangle(20, 20)
    println(rectangle.area)
    val user = User()
    user.firstName = "John"
    user.lastName = "Doe"
    println("First Name: ${user.firstName}")
    println("Last Name: ${user.lastName}")

}
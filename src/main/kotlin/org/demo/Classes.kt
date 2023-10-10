package org.demo

// https://kotlinlang.org/docs/classes.html

// Declares a class without any properties or user-defined constructors.
// A non-parameterized default constructor is created by Kotlin automatically.
// Classes don't need a body e.g. for markers, Experimental or Future Use purposes
class Empty

// Declares a class with two properties: immutable id and mutable email, and a constructor with two parameters id and email
class Contact (val id: Int, var email: String)

// The primary constructor is declared in the class header, and it goes after the class name and optional type parameters.
// class Contact constructor(val id: Int, var email: String)

// No instantiation from outside, builder methods can be used internally to instantiate the class
// If the constructor has annotations or visibility modifiers, the constructor keyword is required and the modifiers go before it:
class DontCreateMe private constructor()

// The class header can't contain any runnable code.
// If you want to run some code during object creation, use initializer blocks inside the class body.
// Initializer blocks are declared with the init keyword followed by curly braces. Write any code that you want to run within the curly braces.
class InitOrderDemo(name: String) {
    val firstProperty = "First property: $name".also(::println)

    init {
        println("First initializer block that prints $name")
    }

    val secondProperty = "Second property: ${name.length}".also(::println)

    init {
        println("Second initializer block that prints ${name.length}")
    }
}

// If the class has a primary constructor, each secondary constructor needs to delegate to the primary constructor.
// Either directly or indirectly through another secondary constructor(s).
// Delegation to another constructor of the same class is done using the `this` keyword
class FamilyPerson(val name: String) {
    val children: MutableList<FamilyPerson> = mutableListOf()
    constructor(name: String, parent: FamilyPerson) : this(name) {
        parent.children.add(this)
    }
}

class Constructors {
    init {
        println("Init block")
    }

    constructor(i: Int) {
        println("Constructor $i")
    }
}

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
    //  So when set(value) {firstName = "value"} is called,
    //  then a recursive call happens and compiler throws a StackOverflow exception because we are calling setter inside the setter.

    var lastName: String = ""
        get() = field
        set(value) {
            field = value
        }
}

fun main() {
    // To create an instance of a class, call the constructor as if it were a regular function
    // Kotlin does not have a new keyword.
    val contact = Contact(1, "mary@gmail.com")
    println("contact.id ${contact.id}")
    contact.email = "jane@gmail.com"
    println("contact.email ${contact.email}")

    val rectangle = Rectangle(20, 20)
    println("rectangle area: ${rectangle.area}")

    val user = User()
    user.firstName = "John"
    user.lastName = "Doe"
    println("First Name: ${user.firstName}")
    println("Last Name: ${user.lastName}")

    InitOrderDemo("kotlinDemo")

    Constructors(1)

}
package org.demo

// https://play.kotlinlang.org/byExample/06_scope_functions/01_let

data class Person(var name: String, var age: Int, var about: String) {
    constructor() : this("", 0, "")
}

// `apply` executes a block of code on an object and returns the object itself.
// Inside the block, the object is referenced by this. This function is handy for initializing objects.
val jake = Person()                                     // Creates a Person() instance with default property values.
val stringDescription = jake.apply {  // Applies the code block (next 3 lines) to the instance.
    name = "Jake"                                      // Inside apply, it's equivalent to jake.name = "Jake"
    age = 30
    about = "Android developer"
}
    .toString()                                          //The return value is the instance itself, so you can chain other operations.

// `also` works like apply: it executes a given block and returns the object called.
// Inside the block, the object is referenced by it, so it's easier to pass it as an argument.
// This function is handy for embedding additional actions, such as logging in call chains.
val jane = Person("Jane", 30, "Kotlin developer")
    .also {                       // Applies the given code block to the object. The return value is the object itself.
        print(it)                         // Calls the logging function passing the object as an argument.
    }

// `let` can be used for scoping and null-checks. Executes the given block of code and returns the result of its last expression.
val empty = "test".let {               // 1
    println(it)                    // 2
    it.isEmpty()                       // 3
}

class Receiver(var hello: String = "world") {
    init { // default constructor
        this.hello = "there" // `this` receiver
        hello = "world! How are you?" // implicit `this` receiver
        hello.apply {
            println(length) // implicit `this` receiver is moved to `foo`.
        }
        hello.let { // `it` receiver is created
            println(it.length) // `let` does not move the implicit `this` receiver
        }
        hello.map { bar -> // created `it` receiver is renamed to `bar`
            println(bar)
        }
    }
}

fun main() {
    println(jane)
    println(stringDescription)
    println("is empty: $empty")
    Receiver()
}


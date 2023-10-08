package org.demo

// An interface with only one abstract method is called a functional interface, or a Single Abstract Method (SAM) interface
// `fun` modifier on the interface
fun interface IntPredicate {
    fun accept(i: Int): Boolean
}

// SAM conversions help make your code more concise and readable by using lambda expressions.
// Kotlin can convert any lambda expression whose signature matches the signature of the interface's single method into the code,
// which dynamically instantiates the interface implementation
val isEven = IntPredicate { it % 2 == 0 }

// Creating an instance of a class, concrete implementation
val isEvenConcreteImplementation = object : IntPredicate {
    override fun accept(i: Int): Boolean {
        return i % 2 == 0
    }
}

fun main() {
    println("Is 7 even? - ${isEven.accept(7)}")
    println("Is 9 even? - ${isEvenConcreteImplementation.accept(9)}")
}
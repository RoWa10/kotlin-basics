package org.demo

fun main() {

    val final = "bar" // Values is assigned and cannot change. The Type `String` is inferred
    println(final)

    val one: Int = 1  // immediate assignment
    println(one)

    val two = 2   // `Int` type is inferred
    println(two)

    val nonInitializedInt: Int  // Type required when no initializer is provided
    nonInitializedInt = 3       // deferred assignment
    println(nonInitializedInt)

    var x = 1 // Variables are assigned and can change later
    x+= 11
    println(x)

    lateinit var later: String // declare variables and assign them later. Type is explicit as it cannot be inferred. Avoid because it could lead to RuntimeException
    //println(later)

    // Arrays have a known implementation and represented in JVM bytecode with a JVM array
    val countries = arrayOf("Austria", "Germany") // Type `Array<String>` is inferred
    println("countries $countries")
    var intArray = IntArray(3)    // Fixed size to change the size they need to be copied
    intArray[0] = 1 //sets 1 as the value at the 0 index
    println("intArray value at position 0: ${intArray[0]} and size: ${intArray.size}")

    // Lists are implementations of the generic List interface (unknown implementation)
    // Lists or specific implementations of Lists should be preferred
    // Convenience functions like sort etc..
    val capitals = listOf("Vienna", "Berlin") // Type `List<String>` is inferred
    println(capitals)
    // capitals.add("Delhi")
    val mutableCities = capitals.toMutableList()
    mutableCities.add("Delhi")
    println(" mutableCities: $mutableCities")
}
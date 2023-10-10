package org.demo

// https://play.kotlinlang.org/byExample/05_Collections/

fun main() {

    val numbers = listOf(1, -2, 3, -4, 5, -6) // Defines a collection of numbers.
    println("numbers $numbers")

    val anyNegative = numbers.any { it < 0 } // Checks if there are negative elements.
    println("anyNegative $anyNegative")

    val allEven = numbers.all { it % 2 == 0 } // Checks whether all elements are even.
    println("allEven $allEven")

    val allLess6 = numbers.none { it > 6 } // Checks if there are no elements greater than 6.
    println("allLess6 $allLess6")

    val allPositives = numbers.filter { x -> x > 0 }  // Gets positive numbers.
    println("allPositives: $allPositives")

    val doubled = numbers.map { x -> x * 2 } // Doubles numbers.
    println("doubled: $doubled")

    val evenOdd = numbers.partition { it % 2 == 0 }  //Splits numbers into a Pair of lists with even and odd numbers.
    println("evenOdd: $evenOdd")
    // Splits numbers into two lists with positive and negative numbers. Pair destructuring is applied here to get the Pair members.
    val (positives, negatives) = numbers.partition { it > 0 }
    println("positives: $positives  negatives: $negatives" )

    val words = listOf("Lets", "find", "something", "in", "collection", "somehow")
    val first = words.find { it.startsWith("some") }    // Looks for the first word starting with "some".
    println(first)
    val last = words.findLast { it.startsWith("some") } // Looks for the last word starting with "some".
    println(last)

    val longestWord = words.maxBy{it.length}
    println("longestWord $longestWord")

    val fruitsBag = listOf("apple","orange","banana","grapes")
    val clothesBag = listOf("shirts","pants","jeans")
    val cart = listOf(fruitsBag, clothesBag)
    println("cart $cart")
    val flatMapBag = cart.flatMap { it } // Builds a flatMap of cart elements, which is a single list consisting of elements from both lists.
    println("flatMapBag $flatMapBag")


    listOf("Java", "Kotlin", "Rust", null)
        .asSequence()
        .mapNotNull { it } // avoid nullable types down the stream
        .filter { it.length > 5 } //  filters what all should be in the next step
        .map { Pair(it, it.length) }// We map each individual entry of the collection
        .forEach{ println(it)}

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
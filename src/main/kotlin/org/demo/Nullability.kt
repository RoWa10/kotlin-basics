package org.demo

fun main() {

    // neverNull has String type
    var neverNull: String = "This can't be null"

    // Throws a compiler error
    // neverNull = null

    // nullable has nullable String type. Nullability must be declared with `?`
    var nullable: String? = "You can keep a null here"

    // This is OK
    nullable = null

    // By default, null values aren't accepted
    var inferredNonNull = "The compiler assumes non-nullable"

    // Throws a compiler error
    // inferredNonNull = null

    // notNull doesn't accept null values
    fun strLength(notNull: String): Int {
        return notNull.length
    }

    println(strLength(neverNull)) // 18
    // println(strLength(nullable))  // Throws a compiler error

    // Safe call `?.` while accessing nullable. Alternative value for null is provided by `?:` elvis operator.
    println(nullable?.length ?: 0)

    nullable = "You can keep a null here"
    // Non-null assertion operator`!!`.
    // Thus, if you want an NPE, you can have it, but you have to ask for it explicitly and it won't appear out of the blue.
    println(nullable!!.length)

    // Sometimes Kotlin programs need to work with null values, such as when interacting with external Java code or representing a truly absent state.
    // Kotlin provides null tracking to elegantly deal with such situations.
    describeString(null)

}

// A function that takes in a nullable string and returns its description.
fun describeString(maybeString: String?): String {
    if (!maybeString.isNullOrEmpty()) {
        return "String of length ${maybeString.length}"
    } else {
        return "Empty or null string"
    }
}
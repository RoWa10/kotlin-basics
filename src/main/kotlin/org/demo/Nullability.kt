package org.demo

fun main() {
    var neverNull = "This can't be null"
    // neverNull = null // `Null` can not be a value of a `non-null type. When trying to assign null to non-nullable variable, a compilation error is produced`

    var nullable: String? = null // Nullability must be declared with `?`
    println(
        nullable?.length ?: 0
    ) // Safe call while accessing nullable `?.` Alternative value provided by `?:` elvis operator.
    nullable = "You can keep a null here"
    println(nullable!!.length) // Non-null assertion `!!`.

    //Sometimes Kotlin programs need to work with null values, such as when interacting with external Java code or representing a truly absent state.
    // Kotlin provides null tracking to elegantly deal with such situations.
    describeString(null)

}

//A function that takes in a nullable string and returns its description.
fun describeString(maybeString: String?): String {
    if (!maybeString.isNullOrEmpty()) {
        return "String of length ${maybeString.length}"
    } else {
        return "Empty or null string"
    }
}
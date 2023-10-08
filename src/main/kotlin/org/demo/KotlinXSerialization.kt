package org.demo

import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

// https://github.com/Kotlin/kotlinx.serialization/blob/master/README.md
// https://github.com/Kotlin/kotlinx.serialization/blob/master/docs/serialization-guide.md

@Serializable
data class Student(val name: String, val age: Int)

fun main() {
    // Serializing objects
    val data = Student("Jane", 30)
    val string = Json.encodeToString(data)
    println(string) // {"name":"kotlinx.serialization","language":"Kotlin"}
    // Deserializing back into objects
    val obj = Json.decodeFromString<Student>(string)
    println(obj) // Project(name=kotlinx.serialization, language=Kotlin)
}


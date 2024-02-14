package org.example

fun main() {

    val noOfGroup = 1..4

    for (group in noOfGroup) {

        print("Enter your name: ")
        val name = readLine()

        print("Enter your age: ")
        val age = readLine()

        if (age!! < 17.toString()) {
            println("$name is an underage")
        } else if (age < 30.toString()) {
            println("$name is a young adults")
        } else if (age < 59.toString()) {
            println("$name is an adult")
        } else if (age > 60.toString()) {
            println("$name is a senior")
        } else {
            println("Invalid Age.")


        }

    }
}




package org.example

fun main() {

    print("Enter the number of your group members: ")
    val no = readLine()?.toIntOrNull() ?: 0

    println("You have $no members on your group")
    val num = readLine()

    val noOfGroup = 1..no

    for (group in noOfGroup) {

        print("Enter your name: ")
        val name = readLine()

        print("Enter your age: ")
        val age = readLine()

        if (age == null || age < 1.toString()) {
            println("Invalid age")
        }else if (age < 17.toString()){
            println("$name's is a young")
        } else if (age < 30.toString()) {
            println("$name's is a young adults")
        } else if (age < 59.toString()) {
            println("$name's is an adult")
        } else if (age > 60.toString()) {
            println("$name's is a senior")
        }

    }
}

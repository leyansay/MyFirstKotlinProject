package org.example

fun main() {

    var noOfGroup = 1..4

    for(group in noOfGroup) {

    print("Enter your Firstname: ")
    var fname = readLine()

        print("Enter your middle initial: ")
        var mi = readLine()

        print("Enter your lastname: ")
        var lname = readLine()

    print("Enter your age: ")
    var age = readLine()

        println("Your name is $fname $mi. $lname and your age is $age")
    }
}
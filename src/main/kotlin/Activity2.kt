package org.example

fun main() {

    val noOfGroup = 1..4

    for(group in noOfGroup) {

        print("Enter your member's name: ")
        val name = readLine()

        print("Enter your grade in English: ")
        val eng = readLine()!!.toDouble()

        print("Enter your grade in Math: ")
        val math = readLine()!!.toDouble()

        print("Enter your grade in Science: ")
        val sci = readLine()!!.toDouble()

        print("Enter your grade in Filipino: ")
        val fil = readLine()!!.toDouble()

        val ave : Double = eng + math + sci + fil
        val avg : Double = ave .toDouble() /4

        println("$name's final average is $avg")
        println(" Total of grades: $ave")
    }
}
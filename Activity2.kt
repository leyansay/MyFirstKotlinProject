package org.example

fun main() {

    val noOfGroup = 1..4

    for(group in noOfGroup) {

        print("Enter your name: ")
        val name = readLine()

        print("Enter your grade in English: ")
        val eng = readLine()!!.toDouble()

        print("Enter your grade in Math: ")
        val math = readLine()!!.toDouble()

        print("Enter your grade in Science: ")
        val sci = readLine()!!.toDouble()

        print("Enter your grade in Filipino: ")
        val fil = readLine()!!.toDouble()

        val ovg : Double = eng + math + sci + fil
        val avg : Double = ovg .toDouble() /4

        println("$name final average is $avg")
        println(" Total of grades: $ovg")
    }
}
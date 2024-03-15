fun main() {
    println("Enter an integer:")
    val input = readLine()?.toIntOrNull()

    if (input == null) {
        println("Invalid input. Please enter an integer.")
        return
    }

    if (input % 2 == 0) {
        printEvenNumbers(input)
    } else {
        printOddNumbers(input)
    }
}

fun printEvenNumbers(input: Int) {
    print("$input is Even -> ")
    for (num in input downTo 2 step 2) {
        print("$num")
        if (num != 2) {
            print(", ")
        }
    }
}

fun printOddNumbers(input: Int) {
    print("$input is Odd -> ")
    for (num in input downTo 1 step 2) {
        print("$num")
        if (num != 1) {
            print(", ")
        }
    }
}

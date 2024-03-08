fun main() {
    println("Please enter a percentage:")
    val percentage = readLine()?.toDoubleOrNull()

    if (percentage == null || percentage !in 0.0..100.0) {
        println("Invalid input for the percentage. Please enter a valid percentage between 0 and 100.")
        return
    }

    println("Please enter a value to calculate the percentage of:")
    val value = readLine()?.toDoubleOrNull()

    if (value == null) {
        println("Invalid input for the value. Please enter a valid number.")
        return
    }

    val percentageDecimal = percentage / 100
    val result = percentageDecimal * value

    println("The result of ${percentage}% of ${value} is:")
    println(result)
}

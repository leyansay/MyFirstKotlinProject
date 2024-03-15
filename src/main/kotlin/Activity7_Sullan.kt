fun main () {
    var response: String?
    do {
        print("Enter your words:")
        val input = readLine() ?: " "

        var isPalindrome = true

        for (i in 0 until input.length / 2) {
            if (input[i] != input[input.length - 1 - i]) {
                isPalindrome = false
                break
            }
        }
        if (isPalindrome) {
            println("Palindrome")
        } else {
            println("Not Palindrome")
        }

        print("Do you want to continue or exit? [Yes & No]:")
        response = readLine()?.toLowerCase()
    } while (response == "yes")

    if(response != "yes") {
        println("Thank you very much!!!")
    }
}

fun main() {
    var response: String?

    do {
        println("#################################################")
        println("Enter your first thought:")
        val thought1 = readLine() ?: " "

        println("#################################################")
        println("Unique characters in thought 1:")
        val uniqueThought1 = findUniqueCharacters(thought1)
        println(uniqueThought1)

        println("#################################################")
        println("Enter your second thought:")
        val thought2 = readLine() ?: " "

        println("#################################################")
        println("Unique characters in thought 2:")
        val uniqueThought2 = findUniqueCharacters(thought2)
        println(uniqueThought2)

        println("#################################################")
        println("Unique characters in both strings:")


        val combinedString = thought1 + thought2


        val uniqueCombinedString = findUniqueCharacters(combinedString)
        println(uniqueCombinedString)

        println("#################################################")
        print("Do you want to continue or exit? Type [Yes & No]: ")
        response = readLine()?.toLowerCase()
    } while (response == "yes")

    print("Thank you very much!!!")
}

fun findUniqueCharacters(input: String): String {
    var uniqueCharacters = ""

    for (char in input) {
        var found = false


        for (existingChar in uniqueCharacters) {
            if (char == existingChar) {
                found = true
                break
            }
        }


        if (!found && input.count { it == char } == 1) {
            uniqueCharacters += char
        }
    }

    return uniqueCharacters
}

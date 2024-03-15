fun main() {
    
    println("Enter the first integer:")
    val firstInput = readLine()?.toIntOrNull()
    if (firstInput == null) {
       
        println("Invalid input for the first integer.")
        return
    }

   
    println("Enter the second integer:")
    val secondInput = readLine()?.toIntOrNull()
    if (secondInput == null) {
      
        println("Invalid input for the second integer.")
        return
    }

   
    val lower = minOf(firstInput, secondInput)
    val higher = maxOf(firstInput, secondInput)

   
    println("Prime numbers between $lower and $higher:")

   
    val primes = mutableListOf<Int>()

    
    fun isPrime(num: Int): Boolean {
        if (num < 2) {
            return false
        }
        for (i in 2 until num) {
            if (num % i == 0) {
                return false
            }
        }
        return true
    }

  
    fun generatePrimes(start: Int, end: Int) {
        for (num in start..end) {
            if (isPrime(num)) {
                primes.add(num)
            }
        }
    }

  
    generatePrimes(2, 100)

   
    val filteredPrimes = primes.filter { it in lower..higher }

    
    println(filteredPrimes.joinToString(", "))
}

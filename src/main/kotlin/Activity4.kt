package org.example

fun main() {
    var choice: Int = -1
    while (choice != 0) {
        println("1. Enter a beauty product")
        println("2. Exit")
        println("Enter your choice: ")
        val input = readLine()
        if (input != null) {
            choice = input.toIntOrNull() ?: -1
            when (choice) {
                1 -> {
                    print("\nEnter product name: ")
                    var product = readLine()

                    print("Quantity: ")
                    var qty: Int
                    while (true) {
                        try {
                            qty = readLine()!!.toInt()
                            break
                        } catch (e: NumberFormatException) {
                            println("Invalid input. Please enter a number.")
                        }
                    }

                    print("Is the product damage or not?: [YES or NO] ")
                    var damage = readLine()?.toLowerCase()

                    println("\nProduct $product is added to inventory")
                    println("\nProduct Description")
                    print("\nPRODUCT: $product, QUANTITY: $qty")

                    if (damage == "yes") {
                        println("\nDamage")
                    } else if (damage == "no") {
                        println("\nNot Damage")
                    } else {
                        println("Invalid input. Please enter 'yes' or 'no'.")
                    }

                    println("Do you want to add a product? [Yes or No] ")
                    val che = readlnOrNull()?.toLowerCase()

                    if(che == "no") {
                        println("Action performed")
                        break
                    }else{
                        println("Canceled")
                        continue

                    }
                }
                2 -> {
                    println("Are you sure do you want to exit? [YES or NO]")
                    var exit = readLine()?.toLowerCase()

                    if(exit == "yes") {
                        println("Action performed")
                        break
                    }else{
                        println("Canceled")
                        continue

                    }
                }
            }
        }
    }
}
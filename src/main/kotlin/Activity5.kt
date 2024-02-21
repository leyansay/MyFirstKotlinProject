package org.example

fun main() {
    var choice: Int = -1
    while (choice != 0) {
        println("1. Borrow a book.")
        println("2. Exit.")
        println("Enter your choice: ")
        val input = readLine()
        if (input != null) {
            choice = input.toIntOrNull() ?: -1
            when (choice) {
                1 -> {
                    println("\nEnter student's name: ")
                    var name = readLine()

                    println("Enter student's ID: ")
                    var id: Int? = null
                    while (id == null) {
                        try {
                            id = readLine()?.toInt()
                        } catch (e: NumberFormatException) {
                            println("Invalid input. Please enter a number.")
                        }
                    }

                    println("Please enter course attained: ")
                    var course = readLine()

                    println("Enter book name: ")
                    var book = readLine()

                    println("Is this available to borrow?: [YES or NO] ")
                    var available = readLine()?.trim()?.toUpperCase()

                    when (available) {
                        "YES" -> {
                            println("\nBook $book has been borrowed by $name.")
                            println("\nDetails:")
                            println("Student Name: $name")
                            println("Student ID: $id")
                            println("Course: $course")
                            println("Book name: $book")
                        }
                        "NO" -> { println("\nEnter new book.")
                            var book = readLine()
                            println("Is this available to borrow?: [YES or NO] ")
                            var available = readLine()?.trim()?.toUpperCase()
                            if (available=="YES")
                            {
                                println("\nBook $book has been borrowed by $name.")
                                println("\nDetails:")
                                println("Student Name: $name")
                                println("Student ID: $id")
                                println("Course: $course")
                                println("Book name: $book")
                                continue
                            }
                    }
                        else -> println("Invalid input. Please enter 'yes' or 'no'.")
                    }
                }
                2 -> {
                    println("Are you sure you want to exit? [YES or NO]")
                    val exit = readLine()?.trim()?.toUpperCase()
                    if (exit == "YES") {
                        println("Action performed")
                        return
                    } else {
                        println("Canceled")
                    }
                }
                else -> println("Invalid choice. Please enter 1 or 2.")
            }
        }
    }
}


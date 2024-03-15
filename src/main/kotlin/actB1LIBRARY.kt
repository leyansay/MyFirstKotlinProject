import java.time.LocalDate
import java.time.LocalTime

fun main() {
    /* Activity B:1 Automates the school’s library
    GROUP MEMBERS : [DIOCSON, SULLAN, LUMO-OS, LUPUYON]
    */
    val borrowedBooks = Array<Quadruple<String, String, LocalDate, LocalTime, String?, String?, String?>>(100) { Quadruple("", "", LocalDate.MIN, LocalTime.MIN, "", "", "") }
    val validCourses = arrayOf("BSIT", "BEED", "BSED", "BSHM", "BSBA")
    val validBooks = arrayOf("MATH", "ENGLISH", "SCIENCE", "FILIPINO", "VALUES", "HISTORY", "PHYSICS", "LITERATURE")

    var size = 0
    var choice: Int = -1
    while (choice != 0) {
        println("\n1. BORROW A BOOK")
        println("2. DISPLAY BORROWERS")
        println("3. RETURN A BOOK")
        println("4. EXIT")
        println("Enter your choice: ")
        val input = readLine()
        if (input != null) {
            choice = input.toIntOrNull() ?: -1
            when (choice) {
                1 -> {
                    println("\nEnter student's name: ")
                    val name = readLine()?.toString()?.toUpperCase()

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
                    var course: String? = null
                    while (course == null || !validCourses.contains(course.toUpperCase())) {
                        println("Valid courses: ${validCourses.joinToString(", ")}")
                        course = readLine()?.toUpperCase()
                        if (!validCourses.contains(course)) {
                            println("Invalid course. Please enter one of the valid courses.")
                        }
                    }

                    println("Enter book name: ")
                    println("Valid books: ${validBooks.joinToString(", ")}")
                    val book = readLine()?.toUpperCase()
                    if (validBooks.contains(book)) {
                        println("Is this available to borrow? [YES or NO] ")
                        var available = readLine()?.trim()?.toUpperCase()
                        println("Date you want to return the book: ")
                        println("MONTH: ")
                        val month = readLine()?.toUpperCase()
                        println("DATE: ")
                        val date = readLine()?.toUpperCase()
                        println("YEAR: ")
                        val year = readLine()?.toUpperCase()
                        when (available) {
                            "YES" -> {
                                val borrowDate = LocalDate.now()
                                val borrowTime = LocalTime.now()
                                borrowedBooks[size] = Quadruple(book ?: "", name ?: "", borrowDate, borrowTime, month, date, year)
                                size++
                                println("\nBOOK DETAILS:")
                                println("Name: $name | $id  | $course | $book | Borrowed on: $borrowDate at $borrowTime | Return on: $month $date $year")
                            }
                            "NO" -> {
                                println("\nEnter new book.")
                                val newBook = readLine()
                                println("Is this available to borrow? [YES or NO] ")
                                available = readLine()?.trim()?.toUpperCase()
                                if (available == "YES") {
                                    val borrowDate = LocalDate.now()
                                    val borrowTime = LocalTime.now()
                                    borrowedBooks[size] = Quadruple(newBook ?: "", name ?: "", borrowDate, borrowTime, month, date, year)
                                    size++
                                    println("\nBOOK DETAILS:")
                                    println("Name: $name | $id  | $course | $newBook | Borrowed on: $borrowDate at $borrowTime | Return on: $month $date $year")
                                    continue
                                }
                            }
                            else -> println("Invalid input. Please enter 'yes' or 'no'.")
                        }
                    } else {
                        println("Invalid book. Please enter one of the valid books.")
                    }
                }
                2 -> {
                    println("DISPLAY BORROWERS")
                    for (index in 0 until size) {
                        val (book, borrower, borrowDate, borrowTime, month, date, year) = borrowedBooks[index]
                        println("${index + 1}. $borrower | Book: $book | Borrowed on: $borrowDate at $borrowTime | Return on: $month $date $year")
                    }
                    if (size == 0) {
                        println("No borrower")
                    }
                }
                3 -> {
                    println("Do you want to return a book? [YES or NO]")
                    val returnChoice = readLine()?.trim()?.toUpperCase()
                    if (returnChoice == "YES") {
                        println("Enter your name: ")
                        val rName = readLine()?.toUpperCase()
                        println("Enter the book you want to return: ")
                        val rBook = readLine()?.toUpperCase()

                        val index = borrowedBooks.indexOfFirst { it.first == rBook && it.second == rName }
                        if (index != -1) {
                            borrowedBooks[index] = Quadruple("", "", LocalDate.MIN, LocalTime.MIN, "", "", "")
                            println("Book returned successfully")
                        } else {
                            println("Error: No matching record found. Please check the book and borrower name.")
                        }
                    } else {
                        println("Action canceled.")
                    }
                }
                4 -> {
                    println("Are you sure you want to exit? [YES or NO]")
                    val exit = readLine()?.trim()?.toUpperCase()
                    if (exit == "YES") {
                        println("Action performed")
                        return
                    } else {
                        println("Canceled")
                    }
                    // Log exit action
                    println("Exiting the program.")
                }
                else -> println("Invalid choice. Please enter 1, 2, or 3.")
            }
        }
    }
}

data class Quadrple<A, B, C, D, E, F, G>(
    val first: A,
    val second: B,
    val third: C,
    val fourth: D,
    val fifth: E,
    val sixth: F,
    val seventh: G
)
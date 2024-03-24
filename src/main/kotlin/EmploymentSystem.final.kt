import java.time.LocalDate
import java.time.LocalTime

fun main() {
    /* FINAL:  EMPLOYMENT SYSTEM
    GROUP MEMBERS : [DIOCSON, SULLAN, LUPUYON, LUMO-OS]
    USER: Human Resources (HR)
    */
    val employees = mutableListOf<Employee>()

    var choice: Int = -1
    while (choice != 0) {
        println("\u001B[34m=============================")
        println("\u001B[34mPERSONNEL MANAGEMENT DASHBOARD")
        println("\u001B[34m=============================")
        println("\u001B[34m[1.] ADD NEW EMPLOYEE")
        println("\u001B[34m[2.] LIST OF EMPLOYEES")
        println("\u001B[34m[3.] UPDATE EXISTING EMPLOYEE")
        println("\u001B[34m[4.] DEACTIVATE EMPLOYEE")
        println("\u001B[34m[5.] EXIT DASHBOARD")
        println("\u001B[34m=============================")
        println("\u001B[34mEnter your choice: ")
        val input = readLine()
        if (input != null) {
            choice = input.toIntOrNull() ?: -1

            when (choice) {
                1 -> {
                    addNewEmployee(employees)
                }
                2 -> {
                    displayEmployees(employees)
                }
                3 -> {
                    updateEmployee(employees)
                }
                4 -> {
                    deactivateEmployee(employees)
                }
                5 -> {
                    println("\nEXIT DASHBOARD")
                    println("Exiting personnel management dashboard...")
                    choice = 0
                }
                else -> {
                    println("Invalid choice. Please enter a valid option.")
                }
            }
        }
    }
}

fun addNewEmployee(employees: MutableList<Employee>) {
    println("\nADD NEW EMPLOYEE [Please fill all the information needed below.]")

    var firstName: String? = null
    while (firstName.isNullOrEmpty() || firstName.toIntOrNull() != null) {
        print("ENTER FIRST NAME: ")
        firstName = readLine()?.toUpperCase()?.trim()
        if (firstName.isNullOrEmpty() || firstName.toIntOrNull() != null) {
            println("Invalid input. Please enter a valid first name.")
        }
    }

    print("ENTER MIDDLE NAME: ")
    var middleName = readLine()?.toUpperCase()?.trim()

    var lastName: String? = null
    while (lastName.isNullOrEmpty() || lastName.toIntOrNull() != null) {
        print("ENTER LAST NAME: ")
        lastName = readLine()?.toUpperCase()?.trim()
        if (lastName.isNullOrEmpty() || lastName.toIntOrNull() != null) {
            println("Invalid input. Please enter a valid last name.")
        }
    }

    println("ID NUMBER: ")
    var id: Int? = null
    while (id == null) {
        try {
            id = readLine()?.toInt()
        } catch (e: NumberFormatException) {
            println("Invalid input. Please enter a number.")
        }
    }

    var contact: Long? = null
    while (contact == null) {
        print("CONTACT NUMBER: ")
        contact = readLine()?.toLongOrNull()
        if (contact == null) {
            println("Invalid input. Please enter a valid contact number.")
        }
    }

    println("PRESENT ADDRESS: ")
    var presentAd = readLine()?.takeIf { it.isNotBlank() }

    println("PERMANENT ADDRESS: ")
    var permanentAd = readLine()?.takeIf { it.isNotBlank() }

    var sex: String? = null
    while (sex == null) {
        print("SEX [Choose the corresponding number.]\n1. FEMALE\n2. MALE\nEnter your choice: ")
        sex = when (readLine()?.toIntOrNull()) {
            1 -> "FEMALE"
            2 -> "MALE"
            else -> {
                println("Invalid input. Please choose a valid option for sex.")
                null
            }
        }
    }

    var status: String? = null
    while (status == null) {
        print("STATUS [Choose the corresponding number.]\n1. SINGLE\n2. MARRIED\n3. DIVORCED\n4. WIDOWED\n5. SEPARATED\nEnter your choice: ")
        status = when (readLine()?.toIntOrNull()) {
            1 -> "SINGLE"
            2 -> "MARRIED"
            3 -> "DIVORCED"
            4 -> "WIDOWED"
            5 -> "SEPARATED"
            else -> {
                println("Invalid input. Please choose a valid option for status.")
                null
            }
        }
    }

    var job: String? = null
    while (job == null) {
        print("JOB POSITION:\n1. PRODUCTION SUPERVISOR\n2. SUPPLY CHAIN COORDINATOR\n3. LOGISTICS COORDINATOR\n4. INDUSTRIAL ENGINEER\n5. HEALTH AND SAFETY MANAGER\nEnter your choice: ")
        val jobChoice = readLine()?.toIntOrNull()
        job = when (jobChoice) {
            1 -> "PRODUCTION SUPERVISOR"
            2 -> "SUPPLY CHAIN COORDINATOR"
            3 -> "LOGISTICS COORDINATOR"
            4 -> "INDUSTRIAL ENGINEER"
            5 -> "HEALTH AND SAFETY MANAGER"
            else -> {
                println("Invalid input. Please choose a valid job position.")
                null
            }
        }
    }

    // Get current date and time
    val currentDate = LocalDate.now()
    val currentTime = LocalTime.now()
    val employee = Employee(firstName, middleName, lastName, id, contact, presentAd, permanentAd, sex, status, job, currentDate, currentTime)
    employees.add(employee)

    val fullName = "$lastName $firstName $middleName"
    println("\nEmployee $lastName is activated successfully!")
    println("EMPLOYEE'S DETAILS")
    println("Employee: $fullName")
    println("ID: $id")
    println("CONTACT NUMBER: $contact")
    println("PRESENT ADDRESS: $presentAd")
    println("PERMANENT ADDRESS: $permanentAd")
    println("SEX: $sex")
    println("STATUS: $status")
    println("JOB: $job")
    println("DATE REGISTERED: $currentDate")
    println("TIME REGISTERED: $currentTime")
}

fun displayEmployees(employees: List<Employee>) {
    println("\u001B[32m=============================")
    println("\u001B[32mLIST OF REGISTERED EMPLOYEES:")
    employees.forEachIndexed { index, employee ->
        println("\u001B[32m${index + 1}. Employee: ${employee.lastName} | ${employee.firstName} | Sex: ${employee.sex} | Status: ${employee.status} | Job: ${employee.jobPosition} | ID: ${employee.id}, Date Registered: ${employee.currentDate} | Time Registered: ${employee.currentTime}")
    }
    println("\u001B[32m=============================")
}

fun updateEmployee(employees: MutableList<Employee>) {
    println("\u001B[32m=============================")
    println("\u001B[32mUPDATE EXISTING EMPLOYEE")
    println("\u001B[32m=============================")
    println("\u001B[0mEnter the ID of the employee you want to update: ")
    val employeeId = readLine()?.toIntOrNull()
    val employeeToUpdate = employees.find { it.id == employeeId }
    if (employeeToUpdate != null) {
        println("Employee found! What would you like to update?")
        println("[1.] PRESENT ADDRESS")
        println("[2.] PERMANENT ADDRESS")
        println("[3.] CONTACT NUMBER")
        println("[4.] STATUS")
        println("[5.] JOB POSITION")
        println("Enter your choice: ")

        val updateChoice = readLine()?.toIntOrNull()
        when (updateChoice) {
            1 -> {
                println("Enter the new present address: ")
                val newPresentAddress = readLine()
                employeeToUpdate.presentAddress = newPresentAddress
            }
            2 -> {
                println("Enter the new permanent address: ")
                val newPermanentAddress = readLine()
                employeeToUpdate.permanentAddress = newPermanentAddress
            }
            3 -> {
                println("Enter the new contact number: ")
                val newContactNumber = readLine()?.toLongOrNull()
                newContactNumber?.let { employeeToUpdate.contact = it }
            }
            4 -> {
                println("Enter the new status: ")
                val newStatus = readLine()
                employeeToUpdate.status = newStatus
            }
            5 -> {
                println("Enter the new job position: ")
                val newJobPosition = readLine()
                employeeToUpdate.jobPosition = newJobPosition
            }
            else -> println("Invalid choice.")
        }
        println("Employee information updated successfully!")
    } else {
        println("Employee not found.")
    }
}

fun deactivateEmployee(employees: MutableList<Employee>) {
    println("\nDEACTIVATE EMPLOYEE")
    println("Enter the ID of the employee you want to deactivate: ")
    val employeeId = readLine()?.toIntOrNull()
    val employeeToRemove = employees.find { it.id == employeeId }
    if (employeeToRemove != null) {
        println("Are you sure you want to remove ${employeeToRemove.lastName} with the ID number of ${employeeToRemove.id}? (yes/no)")
        val confirmation = readLine()?.trim()?.lowercase()
        if (confirmation == "yes") {
            employees.remove(employeeToRemove)
            println("Employee ${employeeToRemove.lastName} has been deactivated and it's no longer part of the company.")
        } else {
            println("Deactivation cancelled.")
        }
    } else {
        println("Employee not found.")
    }
}

data class Employee(
    val firstName: String,
    val middleName: String?,
    val lastName: String,
    val id: Int,
    var contact: Long,
    var presentAddress: String?,
    var permanentAddress: String?,
    val sex: String?,
    var status: String?,
    var jobPosition: String?,
    val currentDate: LocalDate?,
    val currentTime: LocalTime?,
)


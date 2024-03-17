fun main() {

    /* Activity B:2 Automates the Sales and Inventory system for a grocery.
    GROUP MEMBERS : [DIOCSON, SULLAN, LUPUYON, LUMO-OS]
    */

    val products = mutableMapOf<String, Pair<Int, Double>>()
    var choice: Int

    do {
        println("""
            |MENU 
            |1. Add item
            |2. Grocery cart
            |3. Remove last added item
            |4. Checkout
            |5. Exit
            |Enter your choice: 
        """.trimMargin())

        choice = readLine()?.toIntOrNull() ?: -1

        when (choice) {
            1 -> addProduct(products)
            2 -> displayCart(products)
            3 -> removeLastAddedProduct(products)
            4 -> checkout(products)
            5 -> println("Exiting...")
            else -> println("Invalid choice. Please enter a number between 1 and 5.")
        }
    } while (choice != 5)
}

fun addProduct(products: MutableMap<String, Pair<Int, Double>>) {
    println("\nEnter product name: ")
    val product = readLine()?.toUpperCase() ?: ""

    if (products.keys.contains(product)) {
        println("Product '$product' already exists in the cart. Do you want to update the quantity? [YES or NO]: ")
        val updateChoice = readLine()?.toUpperCase()
        if (updateChoice == "YES") {
            print("Enter new quantity: ")
            val newQty = readLine()?.toIntOrNull() ?: 0
            val price = products[product]?.let { it.second } ?: 0.0
            products[product] = Pair(newQty, price)
            println("Quantity of product '$product' updated to $newQty")
        }
        return
    }

    print("QUANTITY: ")
    val qty = readLine()?.toIntOrNull() ?: 0

    print("PRICE EACH: ")
    val price = readLine()?.toDoubleOrNull()
    if (price == null || price <= 0) {
        println("Invalid price. Please enter a valid positive number.")
        return
    }

    products[product] = Pair(qty, price)
    val totalPrice = qty * price
    println("\nProduct $product is added to your cart")
    println("Product Description")
    println("PRODUCT: $product | QUANTITY: $qty | PRICE EACH: $price | TOTAL PRICE: $totalPrice")
}

fun displayCart(cart: Map<String, Pair<Int, Double>>) {
    println("\nGROCERY CART:")
    if (cart.isEmpty()) {
        println("YOUR CART IS EMPTY!")
        return
    }
    var totalCost = 0.0
    cart.forEach { (product, qtyAndPrice) ->
        val (qty, price) = qtyAndPrice
        val totalPrice = qty * price
        totalCost += totalPrice
        println("PRODUCT: $product | QUANTITY: $qty | PRICE EACH: $price | TOTAL PRICE: $totalPrice")
    }
    println("TOTAL COST: $totalCost")
}

fun removeLastAddedProduct(products: MutableMap<String, Pair<Int, Double>>) {
    if (products.isEmpty()) {
        println("Your cart is already empty.")
        return
    }
    val lastAddedProduct = products.keys.lastOrNull()
    if (lastAddedProduct != null) {
        products.remove(lastAddedProduct)
        println("Last added item '$lastAddedProduct' removed from inventory.")
    }
}

fun checkout(cart: Map<String, Pair<Int, Double>>) {
    println("\nCHECKOUT:")
    if (cart.isEmpty()) {
        println("Your cart is empty. Nothing to checkout.")
        return
    }
    displayCart(cart)

    println("To check out, enter the number corresponding to the product, or '0' to checkout all: ")
    val productKeys = cart.keys.toList()
    productKeys.forEachIndexed { index, product ->
        println("${index + 1}. $product")
    }
    print("Enter your choice: ")
    val choice = readLine()?.toIntOrNull() ?: -1
    when {
        choice == 0 -> confirmAndPrintReceipt(cart)
        choice in 1..productKeys.size -> confirmAndPrintReceipt(mapOf(productKeys[choice - 1] to cart[productKeys[choice - 1]]!!))
        else -> println("Invalid choice. Checkout canceled.")
    }
}

fun confirmAndPrintReceipt(cart: Map<String, Pair<Int, Double>>): Boolean {
    print("Confirm checkout? [YES or NO]: ")
    val confirmChoice = readLine()?.toUpperCase()
    return when (confirmChoice) {
        "YES" -> {
            println("Checkout confirmed. Thank you for your purchase!")
            printReceipt(cart)
            true
        }
        "NO" -> {
            println("Checkout canceled.")
            false
        }
        else -> {
            println("Invalid choice. Checkout canceled.")
            false
        }
    }
}

fun printReceipt(cart: Map<String, Pair<Int, Double>>) {
    println("\nRECEIPT:")
    if (cart.isEmpty()) {
        println("Your cart is empty. No receipt to print.")
        return
    }
    displayCart(cart)
}

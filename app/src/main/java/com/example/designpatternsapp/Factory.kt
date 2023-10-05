package com.example.designpatternsapp

abstract class Pizza {
    var name: String? = null
    var dough: String? = null
    var sauce: String? = null
    var toppings: List<String> = listOf()

    fun prepare() {
        println("Preparing $name")
        println("Tossing $dough")
        println("Adding $sauce sauce")
        println("Adding toppings:")
        toppings.forEach { println("  $it") }
    }

    fun bake() {
        println("Baking for 25 minutes at 350°C")
    }

    fun cut() {
        println("Cutting the pizza into diagonal slices")
    }

    fun box() {
        println("Placing the pizza in an official PizzaStore box")
    }
}

class CheesePizza : Pizza() {
    init {
        name = "Cheese Pizza"
        dough = "Regular Crust"
        sauce = "Marinara Pizza Sauce"
        toppings = listOf("Fresh Mozzarella", "Parmesan")
    }
}

class PepperoniPizza : Pizza() {
    init {
        name = "Pepperoni Pizza"
        dough = "Crust"
        sauce = "Marinara Sauce"
        toppings = listOf("Sliced Pepperoni", "Sliced Onion", "Grated Parmesan Cheese")
    }
}

abstract class PizzaStore {
    abstract fun createPizza(type: String): Pizza

    fun orderPizza(type: String): Pizza {
        val pizza = createPizza(type)

        pizza.prepare()
        pizza.bake()
        pizza.cut()
        pizza.box()

        return pizza
    }
}

class NYStylePizzaStore : PizzaStore() {
    override fun createPizza(type: String): Pizza {
        return when (type) {
            "cheese" -> CheesePizza()
            "pepperoni" -> PepperoniPizza()
            else -> throw IllegalArgumentException("Unknown pizza type: $type")
        }
    }
}

fun main() {
    val nyStore = NYStylePizzaStore()

    val cheesePizza = nyStore.orderPizza("cheese")
    println("Ethan ordered a ${cheesePizza.name}")

    val pepperoniPizza = nyStore.orderPizza("pepperoni")
    println("Joel ordered a ${pepperoniPizza.name}")
}

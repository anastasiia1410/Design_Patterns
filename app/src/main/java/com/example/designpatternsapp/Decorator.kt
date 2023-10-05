package com.example.designpatternsapp

abstract class Beverage {

    abstract fun getDescription(): String

    abstract fun cost(): Double

}

abstract class CondimentDecorator : Beverage()

class Mocha(private val beverage: Beverage) : CondimentDecorator() {

    override fun getDescription(): String {
        return "${beverage.getDescription()}, Mocha"
    }

    override fun cost(): Double {
        return .20 + beverage.cost()
    }

}

class DarkRoastCoffee : Beverage() {
    override fun cost(): Double {
        return 2.8
    }

    override fun getDescription(): String {
        return "Dark Roast Coffee"
    }

}

class Espresso : Beverage() {
    override fun cost(): Double {
        return 1.99
    }

    override fun getDescription(): String {
        return "Espresso"
    }
}

fun main() {
    val beverage = Espresso()
    val beverage2 = DarkRoastCoffee()
    val mocha = Mocha(beverage2)
    println("${beverage.getDescription()} $ ${beverage.cost()}")
    println("${mocha.getDescription()} $ ${mocha.cost()}")
}
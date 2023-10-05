package com.example.designpatternsapp

interface Duck {
    fun quack()
    fun fly()
}

class MallardDuck : Duck {
    override fun quack() {
        println("Quack!")
    }

    override fun fly() {
        println("I am flying!")
    }

}

interface Turkey {
    fun gobble()
    fun fly()
}

class WildTurkey : Turkey {
    override fun gobble() {
        println("Gobble gobble!")
    }

    override fun fly() {
        println("I am flying a short distance!")
    }

}

class Adapter(private val turkey: Turkey) : Duck {

    override fun quack() {
        turkey.gobble()
    }

    override fun fly() {
        turkey.fly()
    }

}

fun main() {
    val mallardDuck = MallardDuck()
    val wildTurkey = WildTurkey()
    val adapter = Adapter(wildTurkey)

    println("Turkey says:")
    adapter.quack()
    adapter.fly()

    println("Duck says:")
    mallardDuck.quack()
    mallardDuck.fly()
}

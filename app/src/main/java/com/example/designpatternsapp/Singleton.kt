package com.example.designpatternsapp

class Singleton {
     var name : String
     private set

    init {
        name = this.javaClass.simpleName
    }
}

class Main{
    companion object {
        private var instance: Singleton? = null

        fun getInstance(): Singleton {
            if (instance == null) {
                instance = Singleton()
            }
            return instance as Singleton
        }
    }
}

fun main() {
    println(Main.getInstance().name)
}
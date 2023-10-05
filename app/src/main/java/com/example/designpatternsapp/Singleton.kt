package com.example.designpatternsapp

class Singleton private constructor() {
    companion object {
        @Volatile
        private var instance: Singleton? = null

        fun getInstance(): Singleton {
            if (instance == null) {
                synchronized(this) {
                    if (instance == null) {
                        instance = Singleton()
                    }
                }
            }
            return instance!!
        }
    }
}

fun main() {
    println(Singleton.getInstance().javaClass.simpleName)
}

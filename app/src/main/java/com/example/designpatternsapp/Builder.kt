package com.example.designpatternsapp

class User private constructor(val id : Int, val name: String){
    data class Builder(var id: Int = 0, var name: String = "") {
        fun setUserId(id: Int) = apply { this.id = id }
        fun setUserName(name: String) = apply { this.name = name }
        fun build() : User = User(id, name)
    }
}

fun main() {
    val user = User.Builder().setUserId(1).setUserName("Anastasiia").build()
    println("id = ${user.id}, name = ${user.name}")
}
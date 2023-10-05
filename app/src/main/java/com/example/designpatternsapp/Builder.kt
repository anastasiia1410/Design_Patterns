package com.example.designpatternsapp

class User private constructor(val id : Int, val name: String){
    data class Builder(var id: Int = 0, var name: String = "") {
        fun getUserId(id: Int) = apply { this.id = id }
        fun getUserName(name: String) = apply { this.name = name }
        fun build() : User = User(id, name)
    }
}

fun main() {
    val user = User.Builder().getUserId(1).getUserName("Anastasiia").build()
    println("id = ${user.id}, name = ${user.name}")
}
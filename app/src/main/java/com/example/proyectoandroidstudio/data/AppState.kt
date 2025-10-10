package com.example.proyectoandroidstudio.data

import com.example.proyectoandroidstudio.model.User

val Users = mutableListOf<User>()

var ActualUser : User? = null
const val specialChars = "!@#$%&*"

fun registerUser(name: String, address: String = "", gmail: String, password: String): Boolean {
    //validaciones basicas y simples sobre el uso de ellas
    if (name.isBlank() || gmail.isBlank()|| password.isBlank()) {
        return false
    } else if (!gmail.contains("@") || !gmail.contains(".")) {
        return false
    } else if (password.length < 4) {
        return false
    } else if (!password.any { it in specialChars }) {
        return false
    } else if (Users.any { it.gmail.equals(gmail,ignoreCase = true)}) {
        return false
    } else {
        val newUser = User(name, address, gmail,password)
        Users.add(newUser)
        return true
    }
}

fun loginUser(gmail: String, password: String): Boolean {
    return if (gmail.isBlank() || password.isBlank()) {
        false
    } else if (!Users.any { it.gmail == gmail }) {
        false
    } else if (Users.find { it.gmail == gmail }?.password != password) {
        false
    } else {
        ActualUser = Users.find { it.gmail == gmail }
        true
    }
}
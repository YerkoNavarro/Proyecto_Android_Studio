package com.example.proyectoandroidstudio.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.proyectoandroidstudio.DAO.AppDatabase
import com.example.proyectoandroidstudio.DAO.dbUser
import com.example.proyectoandroidstudio.Repository.UserRepository


class UserViewModel(application: Application) : AndroidViewModel(application) {

    private val userRepository: UserRepository

    init {
        val dao = AppDatabase.getInstance(application).userDao()
        userRepository = UserRepository(dao)
    }

    suspend fun insert(usuario: dbUser) = userRepository.insert(usuario)

    suspend fun delete(usuario: dbUser) = userRepository.delete(usuario)
    
    suspend fun findBydbCorreo(dbCorreo: String): dbUser? = userRepository.findBydbCorreo(dbCorreo)



    suspend fun dbregisterUser(name: String, address: String = "", gmail: String, password: String): Boolean {

        val specialChars = "!@#$%&*"
        //validaciones basicas y simples sobre el uso de ellas
        if (name.isBlank() || gmail.isBlank()|| password.isBlank()) {
            return false
        } else if (!gmail.contains("@") || !gmail.contains(".")) {
            return false
        } else if (password.length < 4) {
            return false
        } else if (!password.any { it in specialChars }) {
            return false
        } else if (userRepository.booleanFindBydbCorreo(gmail)) {
            return false
        } else {
            val newUser = dbUser(0, name, address,gmail,password)
            userRepository.insert(newUser)
            println("usuario guardado correctamente ")
            return true
        }
    }

    suspend fun dbloginUser(gmail: String, password: String): Boolean {
        val user = userRepository.findBydbCorreo(gmail)

        return if (gmail.isBlank() || password.isBlank()) {
            false
        } else if (user == null || user.dbCorreo != gmail) {
            false
        } else if (user.dbContraseña != password) {
            false
        } else {
            // Login exitoso
            println("usuario guardado en la db")
            true
        }
    }

}
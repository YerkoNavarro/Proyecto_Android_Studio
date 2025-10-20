package com.example.proyectoandroidstudio.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.proyectoandroidstudio.DAO.AppDatabase
import com.example.proyectoandroidstudio.DAO.dbUser
import com.example.proyectoandroidstudio.DAO.dbUserActual
import com.example.proyectoandroidstudio.Repository.UserActualRepository
import com.example.proyectoandroidstudio.Repository.UserRepository

class PerfilViewModel(application: Application) : AndroidViewModel(application) {


    private val userActualRepository: UserActualRepository
    private val userRepository: UserRepository

    init {
        val Actualdao = AppDatabase.getInstance(application).userDaoActual()
        val dao = AppDatabase.getInstance(application).userDao()
        userActualRepository = UserActualRepository(Actualdao)
        userRepository = UserRepository(dao)
    }


    suspend fun getCurrentUser() = userActualRepository.getCurrentUser()
    suspend fun insertActualUser(user: dbUserActual) = userActualRepository.insertActualUser(user)
    suspend fun deleteAllActualUsers() = userActualRepository.deleteAllActualUsers()

    suspend fun buscarPorcorreo(correo: String): dbUser? = userRepository.findBydbCorreo(correo)


}

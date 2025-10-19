package com.example.proyectoandroidstudio.Repository

import com.example.proyectoandroidstudio.DAO.UserDao
import com.example.proyectoandroidstudio.DAO.User

class UserRepository(val userDao: UserDao, usuario: User) {

    suspend fun getAll() = userDao.getAll()

    fun findBydbCorreo(dbCorreo: String) = userDao.findBydbCorreo(dbCorreo)

    suspend fun insert(usuario: User) = userDao.insert(usuario)

    suspend fun delete(usuario: User) = userDao.delete(usuario)
}

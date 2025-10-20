package com.example.proyectoandroidstudio.Repository

import com.example.proyectoandroidstudio.DAO.UserDao
import com.example.proyectoandroidstudio.DAO.dbUser
class UserRepository(private val userDao: UserDao) {

    suspend fun getAll(): List<dbUser> = userDao.getAll()

    suspend fun findBydbCorreo(dbCorreo: String): dbUser? = userDao.findBydbCorreo(dbCorreo)
    suspend fun booleanFindBydbCorreo(dbCorreo: String): Boolean = userDao.booleanFindBydbCorreo(dbCorreo)
    suspend fun insert(usuario: dbUser) = userDao.insert(usuario)

    suspend fun delete(usuario: dbUser) = userDao.delete(usuario)
}

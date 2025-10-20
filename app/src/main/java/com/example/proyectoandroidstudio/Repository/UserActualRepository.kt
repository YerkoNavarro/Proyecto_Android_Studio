package com.example.proyectoandroidstudio.Repository

import com.example.proyectoandroidstudio.DAO.AppDatabase
import com.example.proyectoandroidstudio.DAO.UserDao
import com.example.proyectoandroidstudio.DAO.UserDaoActual
import com.example.proyectoandroidstudio.DAO.dbUser
import com.example.proyectoandroidstudio.DAO.dbUserActual


class UserActualRepository(val userActualDao: UserDaoActual) {


    suspend fun insertActualUser(user: dbUserActual) {
        userActualDao.insertActualUser(user)
    }

    suspend fun deleteAllActualUsers() {
        userActualDao.deleteAllActualUsers()
    }

    suspend fun getCurrentUser(): dbUserActual? {
        return userActualDao.getCurrentUser()
    }
}
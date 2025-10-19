package com.example.proyectoandroidstudio.DAO

import androidx.room.ColumnInfo
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.PrimaryKey
import androidx.room.Query

@Entity
data class User(
    @PrimaryKey(autoGenerate = true)
    val uid: Int = 0, //autogenerado el id en la bd local
    @ColumnInfo(name = "nombre") val dbNombre: String?,
    @ColumnInfo(name = "correo") val dbCorreo: String?,
    @ColumnInfo(name = "contraseña") val dbContraseña: String?
)


@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    fun getAll(): List<User>

    @Query("SELECT * FROM user WHERE uid IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<User>

    @Query("SELECT nombre, correo FROM user WHERE correo LIKE :dbCorreo LIMIT 1")
    fun findBydbCorreo(dbCorreo: String): User

    @Insert
    suspend fun insert(user: User)

    @Delete
    suspend fun delete(user: User)
}
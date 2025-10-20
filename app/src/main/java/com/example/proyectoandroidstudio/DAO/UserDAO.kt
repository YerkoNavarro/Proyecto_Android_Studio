package com.example.proyectoandroidstudio.DAO

import androidx.room.ColumnInfo
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.PrimaryKey
import androidx.room.Query

@Entity
data class dbUser(
    @PrimaryKey(autoGenerate = true)
    val uid: Int = 0, //autogenerado el id en la bd local
    @ColumnInfo(name = "nombre") val dbNombre: String?,
    @ColumnInfo(name = "direccion") val dbDireccion: String?,
    @ColumnInfo(name = "correo") val dbCorreo: String?,
    @ColumnInfo(name = "contraseña") val dbContraseña: String?
)

@Entity
data class dbUserActual(
    @PrimaryKey(autoGenerate = true)
    val uid: Int = 0, //autogenerado el id en la bd local
    @ColumnInfo(name = "correo") val dbCorreo: String?,
)



@Dao
interface UserDao {
    @Query("SELECT * FROM dbuser")
    fun getAll(): List<dbUser>

    @Query("SELECT * FROM dbuser WHERE uid IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<dbUser>

    @Query("SELECT * FROM dbuser WHERE correo = :dbCorreo LIMIT 1")
    suspend fun findBydbCorreo(dbCorreo: String): dbUser?

    @Query("SELECT COUNT(*) > 0 FROM dbuser WHERE correo = :dbCorreo")
    suspend fun booleanFindBydbCorreo(dbCorreo: String): Boolean

    @Insert
    suspend fun insert(user: dbUser)

    @Delete
    suspend fun delete(user: dbUser)
}

@Dao
interface UserDaoActual {
    @Query("DELETE FROM dbUserActual")
    suspend fun deleteAllActualUsers()

    @Insert
    suspend fun insertActualUser(user: dbUserActual)

    @Query("SELECT * FROM dbUserActual LIMIT 1")
    suspend fun getCurrentUser(): dbUserActual?
}

package com.miempresa.semana12.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.miempresa.semana12.database.entities.Mascota

@Dao
interface MascotaDao {
    @Query("Select * from mascota")
    suspend fun getAllMascota(): List<Mascota>

    @Insert
    suspend fun insertMascota(mascota: Mascota)

    @Query("DELETE FROM mascota")
    suspend fun eliminarTodos()
}


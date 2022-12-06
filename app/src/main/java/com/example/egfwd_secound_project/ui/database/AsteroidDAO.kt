package com.example.egfwd_secound_project.ui.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.egfwd_secound_project.ui.model.Asteroid

@Dao
interface AsteroidDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg asteroids: Asteroid)

    @Query("SELECT * FROM ASTEROID ORDER BY closeApproachDate ASC")
    fun getAllAsteroids(): List<Asteroid>


    @Query("DELETE  FROM Asteroid ")
    fun deleteAll()

}

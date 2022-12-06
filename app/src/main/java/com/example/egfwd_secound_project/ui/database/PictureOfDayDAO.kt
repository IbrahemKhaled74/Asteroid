package com.example.egfwd_secound_project.ui.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.egfwd_secound_project.ui.model.PictureOfDay
@Dao
interface PictureOfDayDao {
        @Query("select * from PictureOfDay")
        fun getPictureOfDay(): PictureOfDay

        @Insert(onConflict = OnConflictStrategy.REPLACE)
        fun insertPictureOfDay(picture: PictureOfDay)
        @Query("Delete  from PictureOfDay")
        fun deleteAll()
    }

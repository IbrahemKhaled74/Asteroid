package com.example.egfwd_secound_project.ui.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.egfwd_secound_project.ui.model.Asteroid
import com.example.egfwd_secound_project.ui.model.PictureOfDay

@Database(entities = [Asteroid::class,PictureOfDay::class] , version = 1 )
abstract class DataBaseManager :RoomDatabase(){
    abstract fun asteroidDao():AsteroidDAO
    abstract fun pictureOfDayDao():PictureOfDayDao

}
package com.example.egfwd_secound_project.di.data_base

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.egfwd_secound_project.Constants
import com.example.egfwd_secound_project.ui.database.AsteroidDAO
import com.example.egfwd_secound_project.ui.database.DataBaseManager
import com.example.egfwd_secound_project.ui.database.PictureOfDayDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {

    @Provides
    @Singleton
    fun getDataBase(@ApplicationContext context: Context):DataBaseManager{
         return Room.databaseBuilder(
             context
             ,DataBaseManager::class.java,
             Constants.DATABASE_NAME,
         )
             .fallbackToDestructiveMigration()
             .build()
    }
    @Provides
    @Singleton
    fun provideAsteroidDao (dataBaseManager: DataBaseManager): AsteroidDAO {
        return dataBaseManager.asteroidDao()
    }
    @Provides
    @Singleton
    fun providePicDao(dataBaseManager: DataBaseManager): PictureOfDayDao {
        return dataBaseManager.pictureOfDayDao()
    }

}
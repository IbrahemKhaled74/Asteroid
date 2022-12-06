package com.example.egfwd_secound_project.module

import com.example.egfwd_secound_project.repos.asteroid.AsteroidOnlineDataSource
import com.example.egfwd_secound_project.repos.asteroid.AsteroidOnlineDataSourceImpl
import com.example.egfwd_secound_project.repos.picture.*
import com.example.egfwd_secound_project.ui.api.WebServices
import com.example.egfwd_secound_project.ui.database.PictureOfDayDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)

object PictureOfDayModule {

    @Provides
    fun getPic( webServices: WebServices): PictureOnlineDataSource {
        return PictureOnlineDataSourceImpl(webServices)
    }
    @Provides
    fun getPicDB(pictureOfDayDao: PictureOfDayDao): PictureOfflineDataSource {
        return PictureOfflineDataSourceImpl(pictureOfDayDao)
    }

    @Provides
    fun providePic(pictureOnlineDataSource: PictureOnlineDataSource
                   ,pictureOfflineDataSource: PictureOfflineDataSource
):PictureDataSource{
       return PictureDataSourceImpl(pictureOfflineDataSource,pictureOnlineDataSource)
    }

}
package com.example.egfwd_secound_project.module

import com.example.egfwd_secound_project.repos.asteroid.*
import com.example.egfwd_secound_project.ui.api.WebServices
import com.example.egfwd_secound_project.ui.database.AsteroidDAO
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)

object AsteroidModule {

    @Provides
    fun getAsteroid(webServices: WebServices):AsteroidOnlineDataSource{
        return AsteroidOnlineDataSourceImpl(webServices)
    }
    @Provides
    fun getAsteroidDB(asteroidDAO: AsteroidDAO):AsteroidOfflineDataSource{
        return AsteroidOfflineDataSourceImpl(asteroidDAO)
    }

    @Provides
    fun provideAsteroid(
                        asteroidOnlineDataSource: AsteroidOnlineDataSource,
    asteroidOfflineDataSource: AsteroidOfflineDataSource
)
    :AsteroidDataSource{
        return AsteroidDataSourceImpl(asteroidOnlineDataSource
            ,asteroidOfflineDataSource
        )

    }



}
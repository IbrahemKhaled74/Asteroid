package com.example.egfwd_secound_project.ui.fragment.main

import com.example.egfwd_secound_project.ui.rv.AsteroidAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object Di {
    @Provides
    fun provideAdaptor():AsteroidAdapter{
        return AsteroidAdapter()
    }
}
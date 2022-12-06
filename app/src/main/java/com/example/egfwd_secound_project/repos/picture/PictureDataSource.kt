package com.example.egfwd_secound_project.repos.picture

import com.example.egfwd_secound_project.ui.model.PictureOfDay

interface PictureDataSource {
    suspend fun  getPhotoOfDay(apiKey:String):PictureOfDay
}
interface PictureOnlineDataSource {
    suspend fun getPhotoOfDay(apiKey:String):PictureOfDay
}
interface PictureOfflineDataSource {
    suspend fun getPhotoOfDay():PictureOfDay
    fun insertPictureOfDay(pictureOfDay: PictureOfDay)
    fun deleteAll()
}
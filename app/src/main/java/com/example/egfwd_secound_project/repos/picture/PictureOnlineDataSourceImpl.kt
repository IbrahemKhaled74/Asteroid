package com.example.egfwd_secound_project.repos.picture

import com.example.egfwd_secound_project.Constants
import com.example.egfwd_secound_project.ui.api.WebServices
import com.example.egfwd_secound_project.ui.model.PictureOfDay
import javax.inject.Inject

class PictureOnlineDataSourceImpl @Inject constructor(private val webServices: WebServices):
PictureOnlineDataSource{
    override suspend fun getPhotoOfDay(apiKey:String): PictureOfDay {
        try {
            return webServices.getImageOfDay(apiKey)
        }catch (ex:Exception){
            throw ex
        }
    }
}
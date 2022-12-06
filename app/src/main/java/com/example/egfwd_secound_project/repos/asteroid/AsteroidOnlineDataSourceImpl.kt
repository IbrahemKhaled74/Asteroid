package com.example.egfwd_secound_project.repos.asteroid

import com.example.egfwd_secound_project.ui.api.WebServices
import com.example.egfwd_secound_project.ui.model.Asteroid
import okhttp3.ResponseBody
import javax.inject.Inject

class AsteroidOnlineDataSourceImpl @Inject constructor(private val webServices: WebServices):
    AsteroidOnlineDataSource {
    override suspend fun getAsteroid(startDate:String,
                                     endDate:String,
                                     apiKey:String,
    ): String {
        try {
            return webServices.getAsteroid(startDate, endDate, apiKey)

        } catch (ex: Exception) {
            throw ex
        }
    }


}
package com.example.egfwd_secound_project.ui.api

import com.example.egfwd_secound_project.ui.model.Asteroid
import com.example.egfwd_secound_project.ui.model.PictureOfDay
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Query

interface WebServices {
    @GET("neo/rest/v1/feed")
    suspend fun getAsteroid(
        @Query("start_date")
        start_date: String,
        @Query("end_date")
        end_date: String,
        @Query("api_key")
        apiKey: String
    ): String

    @GET("planetary/apod")
    suspend fun getImageOfDay(
        @Query("api_key") apiKey: String,
    ): PictureOfDay
}
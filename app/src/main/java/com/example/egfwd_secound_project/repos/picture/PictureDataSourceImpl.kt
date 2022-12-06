package com.example.egfwd_secound_project.repos.picture

import com.example.egfwd_secound_project.asAsteroidEntities
import com.example.egfwd_secound_project.parseAsteroidsJsonResult
import com.example.egfwd_secound_project.ui.model.PictureOfDay
import org.json.JSONObject
import javax.inject.Inject

class PictureDataSourceImpl @Inject constructor (
    private val pictureOfflineDataSource: PictureOfflineDataSource,
    private val pictureOnlineDataSource: PictureOnlineDataSource):PictureDataSource {
    override suspend fun getPhotoOfDay(apiKey:String): PictureOfDay {
        try {
           val photo= pictureOnlineDataSource.getPhotoOfDay(apiKey)

            pictureOfflineDataSource.deleteAll()
             pictureOfflineDataSource.insertPictureOfDay(photo)
            return pictureOfflineDataSource.getPhotoOfDay()

        } catch (ex: Exception) {
            throw ex
        }
    }
}
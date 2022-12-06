package com.example.egfwd_secound_project.repos.asteroid

import android.annotation.SuppressLint
import com.example.egfwd_secound_project.asAsteroidEntities
import com.example.egfwd_secound_project.parseAsteroidsJsonResult
import com.example.egfwd_secound_project.ui.model.Asteroid
import org.json.JSONObject
import javax.inject.Inject

class AsteroidDataSourceImpl @Inject constructor (
    private val asteroidOnlineDataSource: AsteroidOnlineDataSource
    , private val asteroidOfflineDataSource: AsteroidOfflineDataSource
    ):AsteroidDataSource {
    @SuppressLint("SuspiciousIndentation")
    override suspend fun getAsteroid(startDate:String,
                                     endDate:String,
                                     apiKey:String,
    ): List<Asteroid> {

        try {
            val asteroid=asteroidOnlineDataSource.getAsteroid(startDate, endDate, apiKey)
            val data = parseAsteroidsJsonResult(
                JSONObject(asteroid)
            )
            asteroidOfflineDataSource.deleteAll()
            asteroidOfflineDataSource.addAsteroid(data.asAsteroidEntities())

            return asteroidOfflineDataSource.refreshAsteroidData()

        } catch (ex: Exception) {
            throw ex

        }
    }
}

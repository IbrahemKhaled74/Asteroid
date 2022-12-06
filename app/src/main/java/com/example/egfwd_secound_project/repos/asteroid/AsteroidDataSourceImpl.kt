package com.example.egfwd_secound_project.repos.asteroid

import android.annotation.SuppressLint
import com.example.egfwd_secound_project.Constants
import com.example.egfwd_secound_project.Constants.DEFAULT_END_DATE_DAYS
import com.example.egfwd_secound_project.asAsteroidEntities
import com.example.egfwd_secound_project.parseAsteroidsJsonResult
import com.example.egfwd_secound_project.ui.model.Asteroid
import dagger.hilt.android.lifecycle.HiltViewModel
import org.json.JSONObject
import java.text.SimpleDateFormat
import java.util.*
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
            return asteroidOfflineDataSource.refreshAsteroidData()

        }
    }

    override suspend fun getWeekAsteroid(
        start: String,
        end:String,
    ): List<Asteroid> {
        try {
            return asteroidOfflineDataSource.getWeekAsteroid(start,end)

        }catch (ex:Exception){
            return asteroidOfflineDataSource.getWeekAsteroid(start,end)

        }
    }

    override suspend fun getTodayAsteroid(
        today: String,
    ): List<Asteroid> {
        try {

            return asteroidOfflineDataSource.getTodayAsteroid(today)

        }catch (ex:Exception){
            return asteroidOfflineDataSource.getTodayAsteroid(today)

        }
    }
}

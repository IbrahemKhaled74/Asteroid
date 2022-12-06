package com.example.egfwd_secound_project.repos.asteroid

import com.example.egfwd_secound_project.ui.database.AsteroidDAO
import com.example.egfwd_secound_project.ui.model.Asteroid
import javax.inject.Inject

class AsteroidOfflineDataSourceImpl @Inject constructor(private val asteroidDAO: AsteroidDAO):
    AsteroidOfflineDataSource {
    override suspend fun refreshAsteroidData(): List<Asteroid> {
        try {
            return asteroidDAO.getAllAsteroids()

        } catch (ex: Exception) {
            throw ex
        }
    }

    override fun deleteAll() {
        try {
            asteroidDAO.deleteAll()
        }catch (ex:Exception){
            throw ex
        }
    }

    override fun addAsteroid(asteroid: Array<Asteroid>) {
        try {
            asteroidDAO.insertAll(*asteroid)
        }catch (ex:Exception){
            throw ex
        }

    }

    override suspend fun getWeekAsteroid(start: String,end:String): List<Asteroid> {
        try {
            return asteroidDAO.getWeekAsteroids(start,end)

        }catch (ex:Exception){
            throw ex
        }
    }

    override suspend fun getTodayAsteroid(startDate: String): List<Asteroid> {
        try {
            return asteroidDAO.getTodayAsteroids(startDate)
        } catch (ex: Exception) {
            throw ex

        }
    }
}
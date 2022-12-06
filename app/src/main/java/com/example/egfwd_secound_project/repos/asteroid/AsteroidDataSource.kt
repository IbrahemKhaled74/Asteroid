package com.example.egfwd_secound_project.repos.asteroid

import com.example.egfwd_secound_project.ui.model.Asteroid

interface AsteroidDataSource {
    suspend fun getAsteroid(startDate:String,
                            endDate:String,
                            apiKey:String,
    ): List<Asteroid>
    suspend fun getWeekAsteroid(start:String,end:String):List<Asteroid>
    suspend fun getTodayAsteroid(today: String):List<Asteroid>

}
interface AsteroidOnlineDataSource{
    suspend fun getAsteroid(startDate:String,
                            endDate:String,
                            apiKey:String,
    ): String
}

interface AsteroidOfflineDataSource{
    suspend fun refreshAsteroidData():List<Asteroid>
    fun deleteAll()
    fun addAsteroid(asteroid: Array<Asteroid>)
    suspend fun getWeekAsteroid(start:String,end:String):List<Asteroid>
    suspend fun getTodayAsteroid(startDate: String):List<Asteroid>


}

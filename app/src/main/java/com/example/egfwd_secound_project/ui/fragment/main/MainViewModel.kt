package com.example.egfwd_secound_project.ui.fragment.main//package com.example.egfwd_secound_project.ui.fragment

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.egfwd_secound_project.*
import com.example.egfwd_secound_project.repos.asteroid.AsteroidDataSource
import com.example.egfwd_secound_project.repos.picture.PictureDataSource
import com.example.egfwd_secound_project.ui.api.WebServices
import com.example.egfwd_secound_project.ui.database.DataBaseManager
import com.example.egfwd_secound_project.ui.model.Asteroid
import com.example.egfwd_secound_project.ui.model.PictureOfDay
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONObject
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
var  asteroidDataSource: AsteroidDataSource,
var pictureDataSource: PictureDataSource
) : ViewModel() {

    private val _asteroid = MutableLiveData<List<Asteroid>>()
    val asteroid: LiveData<List<Asteroid>>
        get() = _asteroid
    private val _image = MutableLiveData<PictureOfDay>()
    val image: LiveData<PictureOfDay>
        get() = _image

    private val _asteroidWeek = MutableLiveData<List<Asteroid>>()
    val asteroidWeek: LiveData<List<Asteroid>>
        get() = _asteroidWeek

    private val _asteroidDaily = MutableLiveData<List<Asteroid>>()
    val asteroidDaily: LiveData<List<Asteroid>>
        get() = _asteroidDaily

    private val _loadingAsteroid = MutableLiveData<Boolean>()
    val loadingAsteroid: LiveData<Boolean>
        get() = _loadingAsteroid
    private val _loadingPic = MutableLiveData<Boolean>()
    val loadingPic: LiveData<Boolean>
        get() = _loadingAsteroid


    init {
        viewModelScope.launch {
            try {
                getAllAsteroid()
                getPicOfDay()
                getWeekAsteroid()
                getDailyAsteroid()
            }catch (ex:Exception){

            }
        }
    }

    private suspend fun getAllAsteroid() {

        withContext(Dispatchers.IO) {
            _loadingAsteroid.postValue(true)
           val asteroid=asteroidDataSource.getAsteroid(
                getToday(),
                getSevenDaysLater(),
                Constants.API_KEY
            )
            _asteroid.postValue(asteroid)



        }
        _loadingAsteroid.postValue(false)
    }

    private suspend fun getPicOfDay() {

        withContext(Dispatchers.IO) {
            _loadingPic.postValue(true)
            val photo=pictureDataSource.getPhotoOfDay(Constants.API_KEY)
            _image.postValue(photo)

        }
        _loadingPic.postValue(false)

    }
    private suspend fun getWeekAsteroid(){
        withContext(Dispatchers.IO) {
            val asteroid=asteroidDataSource.getWeekAsteroid(
              start = getToday(), end =  getSevenDaysLater(),
            )
            _asteroidWeek.postValue(asteroid)

        }
    }
    private suspend fun getDailyAsteroid(){
        withContext(Dispatchers.IO) {
            val asteroid=asteroidDataSource.getTodayAsteroid(
                getToday(),
            )
            _asteroidDaily.postValue(asteroid)

        }
    }




}
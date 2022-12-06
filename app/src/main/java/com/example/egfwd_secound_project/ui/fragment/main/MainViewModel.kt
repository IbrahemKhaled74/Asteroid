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
    var webServices: WebServices,
//    var dataBaseManager: DataBaseManager
var  asteroidDataSource: AsteroidDataSource,
var pictureDataSource: PictureDataSource
) : ViewModel() {

    private val _asteroid = MutableLiveData<List<Asteroid>>()
    val asteroid: LiveData<List<Asteroid>>
        get() = _asteroid
    private val _image = MutableLiveData<PictureOfDay>()
    val image: LiveData<PictureOfDay>
        get() = _image
    private val _loadingAsteroid = MutableLiveData<Boolean>()
    val loadingAsteroid: LiveData<Boolean>
        get() = _loadingAsteroid
    private val _loadingPic = MutableLiveData<Boolean>()
    val loadingPic: LiveData<Boolean>
        get() = _loadingAsteroid


    init {
        viewModelScope.launch {
            setData()
            getPicOfDay()
//            test()
        }
    }

    private suspend fun setData() {

        withContext(Dispatchers.IO) {
            _loadingAsteroid.postValue(true)
           val asteroid=asteroidDataSource.getAsteroid(
                getToday(),
                getSevenDaysLater(),
                Constants.API_KEY
            )
            Log.e("TAG", "$asteroid: ", )
            _asteroid.postValue(asteroid)

//            val asteroid = webServices.getAsteroid(
//                getToday(), getSevenDaysLater(), Constants.API_KEY
//            )
//            val data = parseAsteroidsJsonResult(
//                JSONObject(asteroid)
//            )
//            dataBaseManager.asteroidDao().deleteAll()
//            dataBaseManager.asteroidDao().insertAll(*data.asAsteroidEntities())
//            val asteroidItem = dataBaseManager.asteroidDao().getAllAsteroids()
//            Log.e("TAG", "$asteroidItem: ")
//
//            _asteroid.postValue(asteroidItem)

        }
        _loadingAsteroid.postValue(false)
    }

    private suspend fun getPicOfDay() {

        withContext(Dispatchers.IO) {
            _loadingPic.postValue(true)
            val photo=pictureDataSource.getPhotoOfDay(Constants.API_KEY)
            _image.postValue(photo)

//            val image = webServices.getImageOfDay(Constants.API_KEY)
//            dataBaseManager.pictureOfDayDao().insertPictureOfDay(image)
//            val dbImage = dataBaseManager.pictureOfDayDao().getPictureOfDay()
//            Log.e("TAG", "$dbImage: ")
//
//            _image.postValue(dbImage)
        }
        _loadingPic.postValue(false)

    }
//    suspend fun test(){
//        val test=webServices.getAsteroid(
//            getToday(), getSevenDaysLater(),Constants.API_KEY
//        )
//        val data= parseAsteroidsJsonResult(
//            JSONObject(test)
//        )
//        Log.e("TAG", "test: $data ", )
//
//
//    }


}
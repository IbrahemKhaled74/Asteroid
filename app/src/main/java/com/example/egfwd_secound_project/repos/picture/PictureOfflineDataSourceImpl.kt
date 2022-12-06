package com.example.egfwd_secound_project.repos.picture

import com.example.egfwd_secound_project.ui.database.DataBaseManager
import com.example.egfwd_secound_project.ui.database.PictureOfDayDao
import com.example.egfwd_secound_project.ui.model.PictureOfDay
import javax.inject.Inject

class PictureOfflineDataSourceImpl @Inject constructor(private val pictureOfDayDao: PictureOfDayDao):
PictureOfflineDataSource{
    override suspend fun getPhotoOfDay(): PictureOfDay {
        try {
            return pictureOfDayDao.getPictureOfDay()
        }catch (ex:Exception){
            throw ex
        }
    }

    override fun insertPictureOfDay(pictureOfDay: PictureOfDay) {
        try {
            return pictureOfDayDao.insertPictureOfDay(pictureOfDay)
        }catch (ex:Exception){
            throw ex
        }
    }

    override fun deleteAll() {
        try {
            return pictureOfDayDao.deleteAll()
        }catch (ex:Exception){
            throw ex
        }
    }
}
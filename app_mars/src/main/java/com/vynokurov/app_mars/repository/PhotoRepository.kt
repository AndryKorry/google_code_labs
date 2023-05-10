package com.vynokurov.app_mars.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.vynokurov.app_mars.domain.MarsPhotoDomainModel
import com.vynokurov.app_mars.network.MarsApiService
import com.vynokurov.app_mars.network.asDatabaseModel
import com.vynokurov.app_mars.network.asDomainModel
import com.vynokurov.db_main.dao.MarsPhotoDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Repository for fetching photos from the network and storing them on disk
 */
class PhotoRepository(private val photoDao: MarsPhotoDao) {

    val photos: LiveData<List<MarsPhotoDomainModel>> = Transformations.map(photoDao.getPhotos()) {
        it.asDomainModel()
    }

    suspend fun refreshPhoto() {
        withContext(Dispatchers.IO) {
            val photos = MarsApiService.marsPhotoService.getPhotos()
            photoDao.insertAll(photos.asDatabaseModel())
        }
    }
}
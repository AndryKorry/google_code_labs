package com.vynokurov.app_mars.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vynokurov.app_mars.network.NetworkMarsPhoto
import com.vynokurov.app_mars.repository.PhotoRepository
import com.vynokurov.app_mars.util.MarsApiStatus
import com.vynokurov.db_main.dao.MarsPhotoDao
import kotlinx.coroutines.launch

/**
 * The [ViewModel] that is attached to the [OverviewFragment].
 */
class OverviewViewModel(marsPhotoDao: MarsPhotoDao) : ViewModel() {

    private val repository = PhotoRepository(marsPhotoDao)

    // The internal MutableLiveData that stores the status of the most recent request
    private val _status = MutableLiveData<MarsApiStatus>()
    // The external immutable LiveData for the request status
    val status: LiveData<MarsApiStatus> = _status

    val photos = repository.photos
    /**
     * Call getMarsPhotos() on init so we can display status immediately.
     */
    init {
        getMarsPhotos()
    }

    /**
     * Gets Mars photos information from the Mars API Retrofit service and updates the
     * [MarsPhoto] [List] [LiveData].
     */
    private fun getMarsPhotos() {
        viewModelScope.launch {
            _status.value = MarsApiStatus.LOADING
            try {
                repository.refreshPhoto()
                _status.value = MarsApiStatus.SUCCESS
            } catch (e: Exception) {
                _status.value = MarsApiStatus.ERROR
            }
        }
    }
}

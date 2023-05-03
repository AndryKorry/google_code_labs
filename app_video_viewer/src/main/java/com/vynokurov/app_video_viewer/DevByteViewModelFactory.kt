package com.vynokurov.app_video_viewer

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.vynokurov.app_video_viewer.viewmodels.DevByteViewModel
import com.vynokurov.db_video_app.dao.VideoDao

class DevByteViewModelFactory(private val videoDao: VideoDao) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DevByteViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return DevByteViewModel(videoDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
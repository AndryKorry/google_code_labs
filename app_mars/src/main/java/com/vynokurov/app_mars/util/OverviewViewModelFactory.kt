package com.vynokurov.app_mars.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.vynokurov.app_mars.overview.OverviewViewModel
import com.vynokurov.db_main.dao.MarsPhotoDao

class OverviewViewModelFactory(private val marsPhotoDao: MarsPhotoDao) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(OverviewViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return OverviewViewModel(marsPhotoDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
package com.vynokurov.app_video_viewer.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.vynokurov.app_video_viewer.domain.DevByteVideo
import com.vynokurov.app_video_viewer.network.DevByteNetwork
import com.vynokurov.app_video_viewer.network.asDatabaseModel
import com.vynokurov.app_video_viewer.network.asDomainModel
import com.vynokurov.db_main.dao.VideoDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Repository for fetching devbyte videos from the network and storing them on disk
 */
class VideosRepository(private val videoDao: VideoDao) {

    val videos: LiveData<List<DevByteVideo>> = Transformations.map(videoDao.getVideos()) {
        it.asDomainModel()
    }

    suspend fun refreshVideo() {
        withContext(Dispatchers.IO) {
            val playlist = DevByteNetwork.devbytes.getPlaylist()
            videoDao.insertAll(playlist.asDatabaseModel())
        }
    }

}

package com.vynokurov.db_video_app.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.vynokurov.db_video_app.entity.VideoEntities

@Dao
interface VideoDao {
    @Query("select * from video_table")
    fun getVideos(): LiveData<List<VideoEntities>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll( videos: List<VideoEntities>)
}

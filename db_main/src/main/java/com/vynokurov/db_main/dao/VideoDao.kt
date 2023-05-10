package com.vynokurov.db_main.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface VideoDao {

    @Query("Select * From video_table")
    fun getVideos(): LiveData<List<com.vynokurov.db_main.entity.VideoEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll( videos: List<com.vynokurov.db_main.entity.VideoEntity>)
}

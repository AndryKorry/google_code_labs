package com.vynokurov.db_main.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.vynokurov.db_main.entity.MarsPhotoEntity

@Dao
interface MarsPhotoDao {

    @Query("Select * From mars_photo")
    fun getPhotos(): LiveData<List<MarsPhotoEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll( photos: List<MarsPhotoEntity>)
}
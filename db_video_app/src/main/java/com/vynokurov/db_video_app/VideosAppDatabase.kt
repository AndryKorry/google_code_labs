package com.vynokurov.db_video_app

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.vynokurov.db_video_app.dao.VideoDao
import com.vynokurov.db_video_app.entity.DatabaseVideo

@Database(entities = [DatabaseVideo::class], version = 2, exportSchema = false)
abstract class VideosAppDatabase : RoomDatabase() {

    abstract val videoDao: VideoDao

    companion object {

        @Volatile
        private var INSTANCE: VideosAppDatabase? = null

        fun getDatabase(context: Context): VideosAppDatabase {
            return INSTANCE ?: synchronized(this) {

                val instans = Room.databaseBuilder(
                    context.applicationContext,
                    VideosAppDatabase::class.java,
                    "videos_app_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instans
                return instans
            }

        }
    }
}

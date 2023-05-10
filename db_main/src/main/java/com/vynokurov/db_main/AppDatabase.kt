package com.vynokurov.db_main

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.vynokurov.db_main.dao.InventoryItemDao
import com.vynokurov.db_main.dao.MarsPhotoDao
import com.vynokurov.db_main.dao.ScheduleDao
import com.vynokurov.db_main.dao.VideoDao
import com.vynokurov.db_main.entity.InventoryItemEntity
import com.vynokurov.db_main.entity.MarsPhotoEntity
import com.vynokurov.db_main.entity.ScheduleEntity
import com.vynokurov.db_main.entity.VideoEntity

@Database(
    entities = [
        MarsPhotoEntity::class,
        VideoEntity::class,
        InventoryItemEntity::class,
        ScheduleEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract val marsPhotoDao: MarsPhotoDao
    abstract val videoDao: VideoDao
    abstract val inventoryItemDao: InventoryItemDao
    abstract val scheduleDao: ScheduleDao

    companion object {

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {

                val instans = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "code_labs_app_database"
                )
                    .createFromAsset("database/bus_schedule.db")
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instans
                return instans
            }

        }
    }
}

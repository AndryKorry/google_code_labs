package com.vynokurov.db_bus_schedule

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.vynokurov.db_bus_schedule.schedule.dao.ScheduleDao
import com.vynokurov.db_bus_schedule.schedule.entity.ScheduleEntity


@Database(entities = [ScheduleEntity::class], version = 1)
abstract class BusScheduleDatabase : RoomDatabase() {

    abstract fun scheduleDao(): ScheduleDao

    companion object {

        @Volatile
        private var INSTANCE: BusScheduleDatabase? = null

        fun getDatabase(context: Context): BusScheduleDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    BusScheduleDatabase::class.java,
                    "app_database"
                )
                    .createFromAsset("database/bus_schedule.db")
                    .build()
                INSTANCE = instance

                instance
            }
        }

    }
}
package com.vynokurov.app_bus_schedule.database.schedule

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ScheduleDao {

    @Query("SELECT * FROM schedule ORDER BY arrival_time ASC")
    fun getAllStation(): Flow<List<ScheduleEntity>>

    @Query("SELECT * FROM schedule WHERE stop_name = :stopName ORDER BY arrival_time ASC ")
    fun getAllSScheduleByStationName(stopName: String): Flow<List<ScheduleEntity>>
}
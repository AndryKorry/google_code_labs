package com.vynokurov.app_bus_schedule.database.viewModels

import androidx.lifecycle.ViewModel
import com.vynokurov.app_bus_schedule.database.schedule.ScheduleDao
import com.vynokurov.app_bus_schedule.database.schedule.ScheduleEntity
import kotlinx.coroutines.flow.Flow

class BusScheduleViewModel(private val scheduleDao: ScheduleDao) : ViewModel() {

    fun fullSchedule(): Flow<List<ScheduleEntity>> = scheduleDao.getAllStation()

    fun getScheduleByStationName(stationName: String): Flow<List<ScheduleEntity>> = scheduleDao
        .getAllSScheduleByStationName(stationName)
}
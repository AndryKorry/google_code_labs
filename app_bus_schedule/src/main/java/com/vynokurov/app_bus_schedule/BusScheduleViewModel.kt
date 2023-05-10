package com.vynokurov.app_bus_schedule

import androidx.lifecycle.ViewModel
import com.vynokurov.db_main.dao.ScheduleDao
import com.vynokurov.db_main.entity.ScheduleEntity
import kotlinx.coroutines.flow.Flow

class BusScheduleViewModel(private val scheduleDao: ScheduleDao) : ViewModel() {

    fun fullSchedule(): Flow<List<ScheduleEntity>> = scheduleDao.getAllStation()

    fun getScheduleByStationName(stationName: String): Flow<List<ScheduleEntity>> = scheduleDao
        .getAllSScheduleByStationName(stationName)
}
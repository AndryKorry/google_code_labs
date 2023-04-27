package com.vynokurov.app_bus_schedule

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.vynokurov.db_bus_schedule.schedule.dao.ScheduleDao

class BusScheduleViewModelFactory(private val scheduleDao: ScheduleDao) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(BusScheduleViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return BusScheduleViewModel(scheduleDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
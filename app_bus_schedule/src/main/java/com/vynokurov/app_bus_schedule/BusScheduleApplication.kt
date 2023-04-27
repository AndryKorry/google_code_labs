package com.vynokurov.app_bus_schedule

import android.app.Application
import com.vynokurov.app_bus_schedule.database.AppDatabase

class BusScheduleApplication: Application() {

    val database: AppDatabase by lazy { AppDatabase.getDatabase(this) }
}
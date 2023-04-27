package com.vynokurov.app_bus_schedule

import android.content.Context
import com.vynokurov.db_bus_schedule.BusScheduleDatabase

object BusScheduleDataBaseMaster {

    open fun getBusScheduleDb(context: Context): BusScheduleDatabase {
        val database: BusScheduleDatabase by lazy { BusScheduleDatabase.getDatabase(context) }
        return database
    }
}
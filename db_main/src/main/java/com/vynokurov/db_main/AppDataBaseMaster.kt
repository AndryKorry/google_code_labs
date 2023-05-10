package com.vynokurov.db_main

import android.content.Context

object AppDataBaseMaster {

    fun getMainDB(context: Context): AppDatabase {
        val database: AppDatabase by lazy { AppDatabase.getDatabase(context) }
        return database
    }
}
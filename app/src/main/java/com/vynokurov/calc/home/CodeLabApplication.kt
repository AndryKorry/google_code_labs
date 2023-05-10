package com.vynokurov.calc.home

import android.app.Application
import com.vynokurov.db_main.AppDataBaseMaster
import com.vynokurov.db_main.AppDatabase

class CodeLabApplication : Application() {

    val database: AppDatabase by lazy { AppDataBaseMaster.getMainDB(this) }

}
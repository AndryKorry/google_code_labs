package com.vynokurov.db_video_app

import android.content.Context

object VideoAppDataBaseMaster {

    fun getVideoDB(context: Context): VideosAppDatabase {
        val database: VideosAppDatabase by lazy { VideosAppDatabase.getDatabase(context) }
        return database
    }
}
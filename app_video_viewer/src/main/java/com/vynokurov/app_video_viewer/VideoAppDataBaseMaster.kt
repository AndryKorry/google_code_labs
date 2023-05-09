package com.vynokurov.app_video_viewer

import android.content.Context
import com.vynokurov.db_video_app.VideosAppDatabase

object VideoAppDataBaseMaster {

    open fun getVideoDB(context: Context): VideosAppDatabase {
        val database: VideosAppDatabase by lazy { VideosAppDatabase.getDatabase(context) }
        return database
    }
}
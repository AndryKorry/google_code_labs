package com.vynokurov.db_video_app.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DatabaseVideo constructor(
    @PrimaryKey
    val url: String,
    val updated: String,
    val title: String,
    val description: String,
    val thumbnail: String)
package com.vynokurov.db_main.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "marsPhoto")
data class MarsPhotoEntity(
    @PrimaryKey val id: String,
    val imageSource: String
) {
}
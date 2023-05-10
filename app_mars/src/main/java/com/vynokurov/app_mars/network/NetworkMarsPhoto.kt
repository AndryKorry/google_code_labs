package com.vynokurov.app_mars.network

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NetworkMarsPhoto(
    val id: String,
    val img_src: String
)
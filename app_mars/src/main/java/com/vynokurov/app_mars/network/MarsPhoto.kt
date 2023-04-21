package com.vynokurov.app_mars.network

import com.squareup.moshi.Json

data class MarsPhoto(
    val id: String,
    @Json(name = "img_src")val imageSrcUrl: String
)

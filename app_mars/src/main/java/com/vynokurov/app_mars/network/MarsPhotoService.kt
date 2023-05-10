package com.vynokurov.app_mars.network

import retrofit2.http.GET

interface MarsPhotoService {

    @GET("photos")
    suspend fun getPhotos(): List<NetworkMarsPhoto>
}
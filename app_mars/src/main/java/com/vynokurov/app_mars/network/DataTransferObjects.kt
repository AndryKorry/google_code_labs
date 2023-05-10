package com.vynokurov.app_mars.network

import com.vynokurov.app_mars.domain.MarsPhotoDomainModel
import com.vynokurov.db_main.entity.MarsPhotoEntity

/**
 * Map DatabaseEntity to domain entities
 */
fun List<MarsPhotoEntity>.asDomainModel(): List<MarsPhotoDomainModel> {
    return map {
        MarsPhotoDomainModel(
            id = it.id,
            imageSource = it.imageSource
        )
    }
}

/**
 * Convert Network results to database objects
 */
fun List<NetworkMarsPhoto>.asDatabaseModel(): List<MarsPhotoEntity> {
    return map {
        MarsPhotoEntity(
            id = it.id,
            imageSource = it.img_src
        )
    }
}
package com.arusoft.joseluisrf.taiwanexampleapp.data.mapper

import com.arusoft.joseluisrf.taiwanexampleapp.data.api.model.FeedItem
import com.arusoft.joseluisrf.taiwanexampleapp.data.database.entity.FeedEntity
import com.arusoft.joseluisrf.taiwanexampleapp.domain.model.FeedModel
import javax.inject.Inject


class FeedMapper @Inject constructor() {

    fun convert(model: FeedModel) : FeedEntity
        = FeedEntity(
                model.id,
                model.title,
                model.description,
                model.imageUrl,
                model.imagePath,
                model.type
        )


    fun convert(entity: FeedEntity) : FeedModel
        = FeedModel(
                entity.id,
                entity.title,
                entity.description,
                entity.imageUrl,
                entity.imagePath,
                entity.type
        )

    fun convert(response: FeedItem) : FeedModel
            = FeedModel(
            response.id,
            response.title,
            response.description,
            response.imageUrl,
            null,
            response.type
    )
}
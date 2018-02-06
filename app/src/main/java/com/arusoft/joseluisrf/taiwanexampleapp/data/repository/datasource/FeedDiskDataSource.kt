package com.arusoft.joseluisrf.taiwanexampleapp.data.repository.datasource

import com.arusoft.joseluisrf.taiwanexampleapp.data.database.entity.FeedEntity
import io.reactivex.Flowable


interface FeedDiskDataSource {

    fun insertFeed(entity: FeedEntity) : Flowable<Long>

    fun insertFeeds(entities: List<FeedEntity>) : Flowable<List<Long>>

    fun selectFeeds(page: Int) : Flowable<List<FeedEntity>>
}
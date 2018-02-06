package com.arusoft.joseluisrf.taiwanexampleapp.data.repository.datasource

import android.arch.paging.DataSource
import com.arusoft.joseluisrf.taiwanexampleapp.data.database.entity.FeedEntity
import io.reactivex.Flowable


interface FeedDiskDataSource {

    fun insertFeed(entity: FeedEntity) : Flowable<Long>

    fun insertFeeds(entities: List<FeedEntity>) : Flowable<List<Long>>

    fun selectFeeds() : Flowable<List<FeedEntity>>
}
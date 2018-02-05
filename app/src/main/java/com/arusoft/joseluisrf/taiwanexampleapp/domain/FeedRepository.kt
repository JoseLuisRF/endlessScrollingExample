package com.arusoft.joseluisrf.taiwanexampleapp.domain

import android.arch.paging.DataSource
import com.arusoft.joseluisrf.taiwanexampleapp.data.database.entity.FeedEntity
import com.arusoft.joseluisrf.taiwanexampleapp.domain.model.FeedModel
import io.reactivex.Flowable


interface FeedRepository {

    fun fetchFeeds(page: Int) : Flowable<List<FeedModel>>

    fun saveFeeds(models: List<FeedModel>) : Flowable<List<Long>>

    fun selectAllFeeds() : Flowable<DataSource.Factory<Integer, FeedEntity>>
}
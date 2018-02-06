package com.arusoft.joseluisrf.taiwanexampleapp.domain

import com.arusoft.joseluisrf.taiwanexampleapp.domain.model.FeedModel
import io.reactivex.Flowable


interface FeedRepository {

    fun fetchFeeds(page: Int) : Flowable<List<FeedModel>>

    fun saveFeeds(models: List<FeedModel>) : Flowable<List<Long>>

    fun selectAllFeeds(page: Int) : Flowable<List<FeedModel>>
}
package com.arusoft.joseluisrf.taiwanexampleapp.data.repository.datasource

import com.arusoft.joseluisrf.taiwanexampleapp.data.api.model.FeedResponse
import io.reactivex.Flowable
import retrofit2.Response


interface FeedCloudDataSource {

    fun fetchFeed(url: String) : Flowable<Response<FeedResponse>>
}
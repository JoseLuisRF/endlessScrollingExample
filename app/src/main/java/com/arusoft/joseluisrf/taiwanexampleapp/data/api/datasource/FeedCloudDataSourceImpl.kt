package com.arusoft.joseluisrf.taiwanexampleapp.data.api.datasource

import com.arusoft.joseluisrf.taiwanexampleapp.data.api.TestApiService
import com.arusoft.joseluisrf.taiwanexampleapp.data.api.model.FeedResponse
import com.arusoft.joseluisrf.taiwanexampleapp.data.repository.datasource.FeedCloudDataSource
import io.reactivex.Flowable
import retrofit2.Response
import javax.inject.Inject


class FeedCloudDataSourceImpl @Inject constructor(val api: TestApiService): FeedCloudDataSource {

    override fun fetchFeed(url: String): Flowable<Response<FeedResponse>> = api.fetchFeed(url)
}
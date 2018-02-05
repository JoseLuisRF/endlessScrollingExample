package com.arusoft.joseluisrf.taiwanexampleapp.data.api

import com.arusoft.joseluisrf.taiwanexampleapp.data.api.model.FeedResponse
import io.reactivex.Flowable
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url


interface TestApiService {

    @GET
    fun fetchFeed(@Url url: String) : Flowable<Response<FeedResponse>>
}
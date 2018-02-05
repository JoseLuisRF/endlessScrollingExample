package com.arusoft.joseluisrf.taiwanexampleapp.di.module

import com.arusoft.joseluisrf.taiwanexampleapp.data.api.ServiceFactory
import com.arusoft.joseluisrf.taiwanexampleapp.data.api.TestApiService
import com.arusoft.joseluisrf.taiwanexampleapp.data.api.datasource.FeedCloudDataSourceImpl
import com.arusoft.joseluisrf.taiwanexampleapp.data.api.interceptor.ApiInterceptor
import com.arusoft.joseluisrf.taiwanexampleapp.data.repository.datasource.FeedCloudDataSource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun providesCityGuideApi(apiInterceptor: ApiInterceptor):
            TestApiService = ServiceFactory.createRetrofitService(TestApiService::class.java, apiInterceptor)

    @Singleton
    @Provides
    fun providesFeedCloudDataSource(feedCloudDataSource: FeedCloudDataSourceImpl):
            FeedCloudDataSource = feedCloudDataSource

}
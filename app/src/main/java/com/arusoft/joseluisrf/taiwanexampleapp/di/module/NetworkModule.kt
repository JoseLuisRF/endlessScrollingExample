package com.arusoft.joseluisrf.taiwanexampleapp.di.module

import com.arusoft.joseluisrf.taiwanexampleapp.data.api.datasource.FeedCloudDataSourceImpl
import com.arusoft.joseluisrf.taiwanexampleapp.data.repository.datasource.FeedCloudDataSource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun providesFeedCloudDataSource(feedCloudDataSource: FeedCloudDataSourceImpl):
            FeedCloudDataSource = feedCloudDataSource

}
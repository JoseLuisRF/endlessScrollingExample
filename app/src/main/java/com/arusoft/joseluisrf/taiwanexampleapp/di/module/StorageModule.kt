package com.arusoft.joseluisrf.taiwanexampleapp.di.module

import com.arusoft.joseluisrf.taiwanexampleapp.data.database.datasource.FeedDiskDataSourceImpl
import com.arusoft.joseluisrf.taiwanexampleapp.data.repository.datasource.FeedDiskDataSource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class StorageModule {

    @Singleton
    @Provides
    fun providesFeed(feedDiskDataSource: FeedDiskDataSourceImpl) : FeedDiskDataSource = feedDiskDataSource

}
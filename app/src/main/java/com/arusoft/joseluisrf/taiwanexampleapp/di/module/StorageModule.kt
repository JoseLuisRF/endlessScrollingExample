package com.arusoft.joseluisrf.taiwanexampleapp.di.module

import com.arusoft.joseluisrf.taiwanexampleapp.data.database.datasource.FeedDiskDataSourceImpl
import com.arusoft.joseluisrf.taiwanexampleapp.data.repository.datasource.FeedDiskDataSource
import com.arusoft.joseluisrf.taiwanexampleapp.di.scope.UserScope
import dagger.Module
import dagger.Provides

@Module
class StorageModule {

    @UserScope
    @Provides
    fun providesFeed(feedDiskDataSource: FeedDiskDataSourceImpl) : FeedDiskDataSource = feedDiskDataSource

}
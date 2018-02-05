package com.arusoft.joseluisrf.taiwanexampleapp.di.module

import com.arusoft.joseluisrf.taiwanexampleapp.data.repository.FeedRepositoryImpl
import com.arusoft.joseluisrf.taiwanexampleapp.domain.FeedRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideFeedRepository(feedRepository : FeedRepositoryImpl) : FeedRepository = feedRepository

}
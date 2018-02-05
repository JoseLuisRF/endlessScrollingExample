package com.arusoft.joseluisrf.taiwanexampleapp.di.module

import com.arusoft.joseluisrf.taiwanexampleapp.data.repository.FeedRepositoryImpl
import com.arusoft.joseluisrf.taiwanexampleapp.di.scope.UserScope
import com.arusoft.joseluisrf.taiwanexampleapp.domain.FeedRepository
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @UserScope
    @Provides
    fun provideFeedRepository(feedRepository : FeedRepositoryImpl) : FeedRepository = feedRepository

}
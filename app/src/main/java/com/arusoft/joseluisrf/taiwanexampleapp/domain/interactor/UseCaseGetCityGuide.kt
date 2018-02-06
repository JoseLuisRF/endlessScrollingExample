package com.arusoft.joseluisrf.taiwanexampleapp.domain.interactor

import android.arch.lifecycle.LiveData
import android.arch.paging.DataSource
import android.arch.paging.LivePagedListBuilder
import android.arch.paging.PagedList
import com.arusoft.joseluisrf.taiwanexampleapp.data.database.entity.FeedEntity
import com.arusoft.joseluisrf.taiwanexampleapp.domain.FeedRepository
import com.arusoft.joseluisrf.taiwanexampleapp.domain.executor.PostExecutionThread
import com.arusoft.joseluisrf.taiwanexampleapp.domain.executor.ThreadExecutor
import com.arusoft.joseluisrf.taiwanexampleapp.domain.interactor.base.BaseUseCaseFlowable
import com.arusoft.joseluisrf.taiwanexampleapp.presentation.view.CityGuideViewModel
import com.arusoft.joseluisrf.taiwanexampleapp.util.DeviceUtils
import io.reactivex.Flowable
import javax.inject.Inject


class UseCaseGetCityGuide @Inject constructor(
        private val deviceUtils: DeviceUtils,
        private val feedRepository: FeedRepository,
        threadExecutor: ThreadExecutor?,
        postExecutionThread: PostExecutionThread?) : BaseUseCaseFlowable<LiveData<PagedList<FeedEntity>>, Any>(threadExecutor, postExecutionThread) {

    override fun buildUseCaseObservable(`object`: Any?): Flowable<LiveData<PagedList<FeedEntity>>> {
        if (deviceUtils.isNetworkAvailable) {
            return feedRepository.fetchFeeds(1)
                    .flatMap { feeds -> feedRepository.saveFeeds(feeds) }
                    .flatMap { _ -> feedRepository.selectAllFeeds().map { dataSource ->
                        LivePagedListBuilder(
                                dataSource,
                                PagedList.Config.Builder()
                                        .setPageSize(2)
                                        .setEnablePlaceholders(true)
                                        .build()).build()
                    } }

        } else {
            return Flowable.error(Throwable("Not implemented yet"))
        }
    }

}
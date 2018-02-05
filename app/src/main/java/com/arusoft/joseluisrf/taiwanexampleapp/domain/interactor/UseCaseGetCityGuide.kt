package com.arusoft.joseluisrf.taiwanexampleapp.domain.interactor

import android.arch.paging.DataSource
import com.arusoft.joseluisrf.taiwanexampleapp.data.database.entity.FeedEntity
import com.arusoft.joseluisrf.taiwanexampleapp.domain.FeedRepository
import com.arusoft.joseluisrf.taiwanexampleapp.domain.executor.PostExecutionThread
import com.arusoft.joseluisrf.taiwanexampleapp.domain.executor.ThreadExecutor
import com.arusoft.joseluisrf.taiwanexampleapp.domain.interactor.base.BaseUseCaseFlowable
import com.arusoft.joseluisrf.taiwanexampleapp.domain.model.FeedModel
import com.arusoft.joseluisrf.taiwanexampleapp.util.DeviceUtils
import io.reactivex.Flowable
import javax.inject.Inject


class UseCaseGetCityGuide @Inject constructor(
        private val deviceUtils: DeviceUtils,
        private val feedRepository: FeedRepository,
        threadExecutor: ThreadExecutor?,
        postExecutionThread: PostExecutionThread?) : BaseUseCaseFlowable<DataSource.Factory<Integer, FeedEntity>, Any>(threadExecutor, postExecutionThread) {

    override fun buildUseCaseObservable(`object`: Any?): Flowable<DataSource.Factory<Integer, FeedEntity>> {
        if (deviceUtils.isNetworkAvailable) {
            return feedRepository.fetchFeeds(1)
                    .flatMap { feeds -> feedRepository.saveFeeds(feeds) }
                    .flatMap { _ -> feedRepository.selectAllFeeds() }

        } else {
            return Flowable.error(Throwable("Not implemented yet"))
        }
    }

}
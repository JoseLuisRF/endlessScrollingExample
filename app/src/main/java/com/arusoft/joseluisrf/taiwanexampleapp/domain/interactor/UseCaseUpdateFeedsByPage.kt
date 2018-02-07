package com.arusoft.joseluisrf.taiwanexampleapp.domain.interactor

import com.arusoft.joseluisrf.taiwanexampleapp.domain.FeedRepository
import com.arusoft.joseluisrf.taiwanexampleapp.domain.executor.PostExecutionThread
import com.arusoft.joseluisrf.taiwanexampleapp.domain.executor.ThreadExecutor
import com.arusoft.joseluisrf.taiwanexampleapp.domain.interactor.base.BaseUseCaseFlowable
import com.arusoft.joseluisrf.taiwanexampleapp.util.DeviceUtils
import io.reactivex.Flowable
import javax.inject.Inject


class UseCaseUpdateFeedsByPage @Inject constructor(
        private val feedRepository: FeedRepository,
        private val deviceUtils: DeviceUtils,
        threadExecutor: ThreadExecutor?,
        postExecutionThread: PostExecutionThread?
) : BaseUseCaseFlowable<Any, Int>(threadExecutor, postExecutionThread) {


    override fun buildUseCaseObservable(page: Int): Flowable<Any> {
        if (deviceUtils.isNetworkAvailable) {
            return feedRepository.fetchFeeds(page)
                    .flatMap { items -> feedRepository.saveFeeds(items) }
        } else {
            return Flowable.error(Exception("No Internet connection"))
        }
    }
}
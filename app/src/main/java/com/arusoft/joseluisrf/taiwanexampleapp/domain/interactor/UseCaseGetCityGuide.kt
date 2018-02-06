package com.arusoft.joseluisrf.taiwanexampleapp.domain.interactor

import com.arusoft.joseluisrf.taiwanexampleapp.data.database.entity.FeedEntity
import com.arusoft.joseluisrf.taiwanexampleapp.domain.FeedRepository
import com.arusoft.joseluisrf.taiwanexampleapp.domain.executor.PostExecutionThread
import com.arusoft.joseluisrf.taiwanexampleapp.domain.executor.ThreadExecutor
import com.arusoft.joseluisrf.taiwanexampleapp.domain.interactor.base.BaseUseCaseFlowable
import com.arusoft.joseluisrf.taiwanexampleapp.domain.model.FeedModel
import com.arusoft.joseluisrf.taiwanexampleapp.util.DeviceUtils
import io.reactivex.Flowable
import io.reactivex.functions.BiFunction
import javax.inject.Inject


class UseCaseGetCityGuide @Inject constructor(
        private val deviceUtils: DeviceUtils,
        private val feedRepository: FeedRepository,
        threadExecutor: ThreadExecutor?,
        postExecutionThread: PostExecutionThread?) : BaseUseCaseFlowable<List<FeedModel>, Int>(threadExecutor, postExecutionThread) {

    override fun buildUseCaseObservable(page: Int): Flowable<List<FeedModel>> {

        if (deviceUtils.isNetworkAvailable) {
            val fetchFeedFlowable = feedRepository.fetchFeeds(page)
            val getLocalFeedsFlowable = feedRepository.selectAllFeeds(page)

            return Flowable.combineLatest(fetchFeedFlowable, getLocalFeedsFlowable,
                    BiFunction<List<FeedModel>, List<FeedModel>, List<FeedModel>> { cloudData, localData ->
                        //TODO: Logic for update items
                        cloudData
                    })
                    .flatMap { feeds -> feedRepository.saveFeeds(feeds) }
                    .flatMap { res -> feedRepository.selectAllFeeds(page) }

        } else {
            return feedRepository.selectAllFeeds(page)
        }
    }

}
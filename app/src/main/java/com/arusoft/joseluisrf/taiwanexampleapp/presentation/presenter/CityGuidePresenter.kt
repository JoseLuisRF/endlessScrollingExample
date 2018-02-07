package com.arusoft.joseluisrf.taiwanexampleapp.presentation.presenter

import com.arusoft.joseluisrf.taiwanexampleapp.domain.interactor.UseCaseGetCityGuide
import com.arusoft.joseluisrf.taiwanexampleapp.domain.interactor.UseCaseUpdateFeedsByPage
import com.arusoft.joseluisrf.taiwanexampleapp.domain.model.FeedModel
import com.arusoft.joseluisrf.taiwanexampleapp.presentation.view.CityGuideView
import io.reactivex.subscribers.DisposableSubscriber
import javax.inject.Inject


class CityGuidePresenter @Inject constructor(private val useCaseGetCityGuide: UseCaseGetCityGuide,
                                             private val useCaseUpdateFeedsByPage: UseCaseUpdateFeedsByPage) {

    var view: CityGuideView? = null

    fun loadFeed(page: Int) {
        useCaseGetCityGuide.execute(object : DisposableSubscriber<List<FeedModel>>() {
            override fun onComplete() {

            }

            override fun onError(t: Throwable?) {
                t?.printStackTrace()
                view?.onLoadFeedError()
            }

            override fun onNext(models: List<FeedModel>) {
                val anotherList = mutableListOf<FeedModel>()
                models.forEach { item -> anotherList.add(item) }
                view?.onLoadFeedSuccess(anotherList)
            }
        }, page)
    }

    fun refreshData(currentPage: Int) {

        useCaseUpdateFeedsByPage.execute(object: DisposableSubscriber<Any>() {

            override fun onError(t: Throwable?) {
                view?.onUpdateFeedsCompleteError()
            }

            override fun onNext(t: Any?) {
                view?.onUpdateFeedsCompleteSuccessful()
            }

            override fun onComplete() {
                view?.onUpdateFeedsCompleteSuccessful()
            }

        }, currentPage)
    }
}
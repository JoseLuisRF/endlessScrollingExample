package com.arusoft.joseluisrf.taiwanexampleapp.presentation.presenter

import com.arusoft.joseluisrf.taiwanexampleapp.data.database.entity.FeedEntity
import com.arusoft.joseluisrf.taiwanexampleapp.domain.interactor.UseCaseGetCityGuide
import com.arusoft.joseluisrf.taiwanexampleapp.presentation.view.CityGuideView
import io.reactivex.subscribers.DisposableSubscriber
import javax.inject.Inject


class CityGuidePresenter @Inject constructor(private val useCaseGetCityGuide: UseCaseGetCityGuide) {

    var view: CityGuideView? = null

    fun loadFeed() {
        useCaseGetCityGuide.execute(object: DisposableSubscriber<List<FeedEntity>>() {
            override fun onComplete() {

            }

            override fun onError(t: Throwable?) {
                t?.printStackTrace()
                view?.onLoadFeedError()
            }

            override fun onNext(models: List<FeedEntity>) {
                val anotherList = mutableListOf<FeedEntity>()
                models.forEach { item -> anotherList.add(item) }
                view?.onLoadFeedSuccess(anotherList)
            }
        }, 10)
    }
}
package com.arusoft.joseluisrf.taiwanexampleapp.presentation.view

import com.arusoft.joseluisrf.taiwanexampleapp.domain.model.FeedModel


interface CityGuideView {
    fun onLoadFeedError()
    fun onLoadFeedSuccess(models: MutableList<FeedModel>)
    fun onUpdateFeedsCompleteSuccessful()
    fun onUpdateFeedsCompleteError()

}
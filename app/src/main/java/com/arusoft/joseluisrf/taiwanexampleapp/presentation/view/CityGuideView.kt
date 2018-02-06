package com.arusoft.joseluisrf.taiwanexampleapp.presentation.view

import com.arusoft.joseluisrf.taiwanexampleapp.data.database.entity.FeedEntity


interface CityGuideView {
    fun onLoadFeedError()
    fun onLoadFeedSuccess(models: MutableList<FeedEntity>)

}
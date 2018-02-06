package com.arusoft.joseluisrf.taiwanexampleapp.data.api.model

import com.arusoft.joseluisrf.taiwanexampleapp.data.api.model.base.BaseResponse


data class FeedResponse constructor(val feeds: List<FeedItem>) : BaseResponse()

data class FeedItem constructor(
        val id: Int,
        val title: String?,
        val description: String?,
        val imageUrl: String,
        val type: Int)
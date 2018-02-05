package com.arusoft.joseluisrf.taiwanexampleapp.domain.model


data class FeedModel constructor(val id: Int,
                                 val title: String?,
                                 val description: String?,
                                 val imageUrl: String?,
                                 val imagePath: String?,
                                 val type: Int)
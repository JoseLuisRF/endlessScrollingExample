package com.arusoft.joseluisrf.taiwanexampleapp.domain.model


data class FeedModel constructor(val id: Int = 0,
                                 val title: String? = null,
                                 val description: String? = null,
                                 val imageUrl: String? = null,
                                 val imagePath: String?= null,
                                 val type: Int = 3,
                                 val page: Int = 0)
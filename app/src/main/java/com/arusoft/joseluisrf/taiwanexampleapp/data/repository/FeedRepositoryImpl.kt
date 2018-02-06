package com.arusoft.joseluisrf.taiwanexampleapp.data.repository

import com.arusoft.joseluisrf.taiwanexampleapp.data.database.entity.FeedEntity
import com.arusoft.joseluisrf.taiwanexampleapp.data.mapper.FeedMapper
import com.arusoft.joseluisrf.taiwanexampleapp.data.repository.datasource.FeedCloudDataSource
import com.arusoft.joseluisrf.taiwanexampleapp.data.repository.datasource.FeedDiskDataSource
import com.arusoft.joseluisrf.taiwanexampleapp.domain.FeedRepository
import com.arusoft.joseluisrf.taiwanexampleapp.domain.model.FeedModel
import io.reactivex.Flowable
import javax.inject.Inject


class FeedRepositoryImpl @Inject constructor(private val feedCloudDataSource: FeedCloudDataSource,
                                             private val dataMapper: FeedMapper,
                                             private val feedDiskDataSource: FeedDiskDataSource) : FeedRepository {

    override fun fetchFeeds(page: Int): Flowable<List<FeedModel>> {
        return feedCloudDataSource.fetchFeed("https://demo2761224.mockable.io/taiwanfeeds")
                .map { response ->
                    if (response.isSuccessful) {
                        val body = response.body()
                        if (!body.status.equals("SUCCESS")) {
                            throw Exception(body.errorDescription)
                        }

                        val models: MutableList<FeedModel> = mutableListOf()
                        body.feeds.forEach { item -> models.add(dataMapper.convert(item, page)) }
                        models

                    } else {
                        throw Exception("Oops there was an error on our side. HTTP Error Code: ${response.code()}")
                    }
                }
    }

    override fun saveFeeds(models: List<FeedModel>): Flowable<List<Long>> {
        return feedDiskDataSource.insertFeeds(models.map { model -> dataMapper.convert(model) })
    }

    override fun selectAllFeeds(page: Int): Flowable<List<FeedModel>> {
        return feedDiskDataSource.selectFeeds(page).map { entities -> entities.map { entity-> dataMapper.convert(entity) }}

    }
}
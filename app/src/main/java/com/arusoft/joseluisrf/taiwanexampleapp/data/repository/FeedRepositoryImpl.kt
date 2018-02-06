package com.arusoft.joseluisrf.taiwanexampleapp.data.repository

import android.arch.paging.DataSource
import android.util.Log
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
                        body.feeds.forEach { item -> models.add(dataMapper.convert(item)) }
                        models

                    } else {
                        throw Exception("Oops there was an error on our side. HTTP Error Code: ${response.code()}")
                    }
                }
    }

    override fun saveFeeds(models: List<FeedModel>): Flowable<List<Long>> {
        Log.d("JLRF", "saveFeeds")
        return feedDiskDataSource.insertFeeds(models.map { model ->
            Log.d("JLRF", "entity:" + model.toString())
            dataMapper.convert(model) })
    }

    override fun selectAllFeeds(): Flowable<DataSource.Factory<Integer, FeedEntity>> {
        Log.d("JLRF", "selectAllFeeds")
        return feedDiskDataSource.selectFeeds()

    }
}
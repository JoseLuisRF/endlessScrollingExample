package com.arusoft.joseluisrf.taiwanexampleapp.data.database.datasource

import com.arusoft.joseluisrf.taiwanexampleapp.data.database.AppDataBase
import com.arusoft.joseluisrf.taiwanexampleapp.data.database.entity.FeedEntity
import com.arusoft.joseluisrf.taiwanexampleapp.data.repository.datasource.FeedDiskDataSource
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import javax.inject.Inject


class FeedDiskDataSourceImpl @Inject constructor(private val database: AppDataBase) : FeedDiskDataSource {

    override fun insertFeed(entity: FeedEntity): Flowable<Long> {
        return Flowable.create({ e ->
            e.onNext(database.getFeedDao().insert(entity))
            e.onComplete()
        }, BackpressureStrategy.BUFFER)
    }

    override fun insertFeeds(entities: List<FeedEntity>): Flowable<List<Long>> {
        return Flowable.create({ e ->
            e.onNext(database.getFeedDao().insertFeeds(entities))
            e.onComplete()
        }, BackpressureStrategy.BUFFER)
    }

    override fun selectFeeds(): Flowable<List<FeedEntity>> {
        return Flowable.create({ e ->
            val res = database.getFeedDao().selectFeeds()
            e.onNext(res)
            e.onComplete()
        }, BackpressureStrategy.BUFFER)
    }

}
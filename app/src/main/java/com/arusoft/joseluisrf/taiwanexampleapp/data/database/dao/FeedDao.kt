package com.arusoft.joseluisrf.taiwanexampleapp.data.database.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.arusoft.joseluisrf.taiwanexampleapp.data.database.FEED_TABLE_NAME
import com.arusoft.joseluisrf.taiwanexampleapp.data.database.entity.FeedEntity
import com.arusoft.offermepartner.data.database.dao.base.BaseDao
import io.reactivex.Flowable


@Dao
interface FeedDao : BaseDao<FeedEntity> {

    @Query("SELECT * FROM  $FEED_TABLE_NAME WHERE page = :page")
    fun selectFeeds(page: Int) : Flowable<List<FeedEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFeeds(entities: List<FeedEntity>) : List<Long>
}
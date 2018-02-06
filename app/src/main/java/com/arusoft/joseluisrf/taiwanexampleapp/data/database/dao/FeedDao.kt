package com.arusoft.joseluisrf.taiwanexampleapp.data.database.dao

import android.arch.paging.DataSource
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.arusoft.joseluisrf.taiwanexampleapp.data.database.FEED_TABLE_NAME
import com.arusoft.joseluisrf.taiwanexampleapp.data.database.entity.FeedEntity
import com.arusoft.offermepartner.data.database.dao.base.BaseDao


@Dao
interface FeedDao : BaseDao<FeedEntity> {

    @Query("select * from  $FEED_TABLE_NAME")
    fun selectFeeds() : List<FeedEntity>

    @Insert(onConflict = OnConflictStrategy.ROLLBACK)
    fun insertFeeds(entities: List<FeedEntity>) : List<Long>
}
package com.arusoft.joseluisrf.taiwanexampleapp.data.database.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.arusoft.joseluisrf.taiwanexampleapp.data.database.*

@Entity(tableName = FEED_TABLE_NAME)
data class FeedEntity(

        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = FEED_ID_COLUMN_NAME)
        val id: Int,

        @ColumnInfo(name = FEED_TITLE_COLUMN_NAME)
        val title: String?,

        @ColumnInfo(name = FEED_DESCRIPTION_COLUMN_NAME)
        val description: String?,

        @ColumnInfo(name = FEED_IMAGE_URL_COLUMN_NAME)
        val imageUrl: String?,

        @ColumnInfo(name = FEED_IMAGE_PATH_COLUMN_NAME)
        val imagePath: String?,

        @ColumnInfo(name = FEED_TYPE_COLUMN_NAME)
        val type: Int
)
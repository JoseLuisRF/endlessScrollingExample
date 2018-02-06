package com.arusoft.joseluisrf.taiwanexampleapp.data.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.arusoft.joseluisrf.taiwanexampleapp.data.database.dao.FeedDao
import com.arusoft.joseluisrf.taiwanexampleapp.data.database.entity.FeedEntity


const val DATABASE_NAME = "taiwan_app.db"
const val DATABASE_VERSION = 1

@Database(version = DATABASE_VERSION,
        entities = arrayOf(FeedEntity::class))
abstract class AppDataBase : RoomDatabase() {

    abstract fun getFeedDao() : FeedDao

}
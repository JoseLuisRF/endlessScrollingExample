package com.arusoft.offermepartner.data.database.dao.base

import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Update
import io.reactivex.Single


interface BaseDao<T> {

    @Insert(onConflict = OnConflictStrategy.ROLLBACK)
    fun insert(entity: T) : Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(entity: T) : Long

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(entity: T) : Int

    @Delete
    fun delete(entity: T) : Int

}
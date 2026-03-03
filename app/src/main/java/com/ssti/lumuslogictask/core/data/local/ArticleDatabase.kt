package com.ssti.lumuslogictask.core.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

/**
 * Author: Ravi Soni
 * Date: Mar 3, 2026
 * Desc: Room database for offline article storage.
 */
@Database(entities = [ArticleEntity::class], version = 1, exportSchema = false)
abstract class ArticleDatabase : RoomDatabase() {
    abstract fun articleDao(): ArticleDao
}


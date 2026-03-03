package com.ssti.lumuslogictask.core.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Author: Ravi Soni
 * Date: Mar 3, 2026
 * Desc: Room entity for caching news articles locally.
 */
@Entity(tableName = "articles")
data class ArticleEntity(
    @PrimaryKey val url: String,
    val author: String?,
    val title: String?,
    val description: String?,
    val urlToImage: String?,
    val publishedAt: String?,
    val content: String?,
    val sourceName: String?
)


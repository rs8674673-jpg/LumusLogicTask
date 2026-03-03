package com.ssti.lumuslogictask.core.domain.model

/**
 * Author: Ravi Soni
 * Date: Mar 3, 2026
 * Desc: Domain model for a news article.
 */
data class Article(
    val url: String,
    val author: String?,
    val title: String?,
    val description: String?,
    val urlToImage: String?,
    val publishedAt: String?,
    val content: String?,
    val sourceName: String?
)


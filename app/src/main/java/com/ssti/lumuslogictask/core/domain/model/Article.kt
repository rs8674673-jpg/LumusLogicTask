package com.ssti.lumuslogictask.core.domain.model

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


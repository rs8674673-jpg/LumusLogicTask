package com.ssti.lumuslogictask.core.domain.model

import com.google.gson.annotations.SerializedName
import com.ssti.lumuslogictask.core.data.local.ArticleEntity

data class ArticleResponse(
    val status: String,
    val totalResults: Int,
    val articles: List<ArticleDto>
)

data class ArticleDto(
    val source: SourceDto?,
    val author: String?,
    val title: String?,
    val description: String?,
    val url: String,
    val urlToImage: String?,
    val publishedAt: String?,
    val content: String?
)

data class SourceDto(
    @SerializedName("name") val name: String?
)

// Mappers
fun ArticleDto.toEntity(): ArticleEntity = ArticleEntity(
    url = url,
    author = author,
    title = title,
    description = description,
    urlToImage = urlToImage,
    publishedAt = publishedAt,
    content = content,
    sourceName = source?.name
)

fun ArticleEntity.toDomain(): Article = Article(
    url = url,
    author = author,
    title = title,
    description = description,
    urlToImage = urlToImage,
    publishedAt = publishedAt,
    content = content,
    sourceName = sourceName
)

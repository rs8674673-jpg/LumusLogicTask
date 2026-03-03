package com.ssti.lumuslogictask.core.domain.repository

import androidx.paging.PagingData
import com.ssti.lumuslogictask.core.domain.model.Article
import kotlinx.coroutines.flow.Flow

interface ArticleRepository {
    fun getArticles(): Flow<PagingData<Article>>
}

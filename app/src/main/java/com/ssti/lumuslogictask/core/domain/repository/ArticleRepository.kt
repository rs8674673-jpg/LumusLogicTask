package com.ssti.lumuslogictask.core.domain.repository

import androidx.paging.PagingData
import com.ssti.lumuslogictask.core.domain.model.Article
import kotlinx.coroutines.flow.Flow

/**
 * Author: Ravi Soni
 * Date: Mar 3, 2026
 * Desc: Repository interface for paged article data.
 */
interface ArticleRepository {
    fun getArticles(): Flow<PagingData<Article>>
}

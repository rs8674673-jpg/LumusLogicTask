package com.ssti.lumuslogictask.core.domain.usecase

import androidx.paging.PagingData
import com.ssti.lumuslogictask.core.domain.model.Article
import com.ssti.lumuslogictask.core.domain.repository.ArticleRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Author: Ravi Soni
 * Date: Mar 3, 2026
 * Desc: Use case for fetching paged news articles.
 */
class GetArticlesUseCase @Inject constructor(
    private val repository: ArticleRepository
) {
    operator fun invoke(): Flow<PagingData<Article>> = repository.getArticles()
}

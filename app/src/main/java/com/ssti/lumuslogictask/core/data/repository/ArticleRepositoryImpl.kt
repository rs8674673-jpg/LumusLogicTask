package com.ssti.lumuslogictask.core.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.ssti.lumuslogictask.BuildConfig
import com.ssti.lumuslogictask.core.common.Constants
import com.ssti.lumuslogictask.core.domain.model.toDomain
import com.ssti.lumuslogictask.core.data.local.ArticleDatabase
import com.ssti.lumuslogictask.core.data.remote.NewsApiService
import com.ssti.lumuslogictask.core.data.remote.NewsRemoteMediator
import com.ssti.lumuslogictask.core.domain.model.Article
import com.ssti.lumuslogictask.core.domain.repository.ArticleRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * Author: Ravi Soni
 * Date: Mar 3, 2026
 * Desc: Repository implementation for paged article flow with offline support.
 */
class ArticleRepositoryImpl @Inject constructor(
    private val apiService: NewsApiService,
    private val database: ArticleDatabase
) : ArticleRepository {

    @OptIn(ExperimentalPagingApi::class)
    override fun getArticles(): Flow<PagingData<Article>> {
        val pagingSourceFactory = { database.articleDao().pagingSource() }

        return Pager(
            config = PagingConfig(
                pageSize = Constants.PAGE_SIZE, 
                enablePlaceholders = false
            ),
            remoteMediator = NewsRemoteMediator(
                apiService = apiService,
                database = database,
                apiKey = BuildConfig.NEWS_API_KEY
            ),
            pagingSourceFactory = pagingSourceFactory
        ).flow.map { pagingData -> pagingData.map { it.toDomain() } }
    }
}

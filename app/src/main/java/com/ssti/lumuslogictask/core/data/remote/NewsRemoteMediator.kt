package com.ssti.lumuslogictask.core.data.remote

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.ssti.lumuslogictask.core.data.local.ArticleDatabase
import com.ssti.lumuslogictask.core.data.local.ArticleEntity
import com.ssti.lumuslogictask.core.domain.model.toEntity
import retrofit2.HttpException
import java.io.IOException

@OptIn(ExperimentalPagingApi::class)
class NewsRemoteMediator(
    private val apiService: NewsApiService,
    private val database: ArticleDatabase,
    private val apiKey: String
) : RemoteMediator<Int, ArticleEntity>() {

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, ArticleEntity>
    ): MediatorResult {
        return try {
            val page = when (loadType) {
                LoadType.REFRESH -> 1
                LoadType.PREPEND -> return MediatorResult.Success(endOfPaginationReached = true)
                LoadType.APPEND -> {
                    val lastItem = state.lastItemOrNull()
                    if (lastItem == null) 1 else (state.pages.size + 1)
                }
            }

            val response = apiService.getTopHeadlines(
                page = page,
                pageSize = state.config.pageSize,
                apiKey = apiKey
            )
            val articles = response.articles.map { it.toEntity() }

            database.withTransaction {
                if (loadType == LoadType.REFRESH) {
                    database.articleDao().clearAll()
                }
                database.articleDao().insertAll(articles)
            }

            MediatorResult.Success(endOfPaginationReached = articles.isEmpty())
        } catch (e: IOException) {
            MediatorResult.Error(e)
        } catch (e: HttpException) {
            MediatorResult.Error(e)
        }
    }
}


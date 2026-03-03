package com.ssti.lumuslogictask.core.data.remote

import com.ssti.lumuslogictask.core.domain.model.ArticleResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Author: Ravi Soni
 * Date: Mar 3, 2026
 * Desc: Retrofit API service for fetching news headlines.
 */
interface NewsApiService {
    @GET("top-headlines")
    suspend fun getTopHeadlines(
        @Query("country") country: String = "us",
        @Query("page") page: Int,
        @Query("pageSize") pageSize: Int,
        @Query("apiKey") apiKey: String
    ): ArticleResponse
}


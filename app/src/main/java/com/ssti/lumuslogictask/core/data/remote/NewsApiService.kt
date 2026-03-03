package com.ssti.lumuslogictask.core.data.remote

import com.ssti.lumuslogictask.core.common.Constants
import com.ssti.lumuslogictask.core.domain.model.ArticleResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Author: Ravi Soni
 * Date: Mar 3, 2026
 * Desc: Retrofit API service for fetching news headlines.
 */
interface NewsApiService {
    @GET(Constants.TOP_HEADLINES_ENDPOINT)
    suspend fun getTopHeadlines(
        @Query("country") country: String = Constants.DEFAULT_COUNTRY,
        @Query("page") page: Int,
        @Query("pageSize") pageSize: Int = Constants.PAGE_SIZE,
        @Query("apiKey") apiKey: String
    ): ArticleResponse
}

package com.ssti.lumuslogictask.core.di

import android.content.Context
import com.ssti.lumuslogictask.BuildConfig
import androidx.room.Room
import com.ssti.lumuslogictask.core.data.local.ArticleDatabase
import com.ssti.lumuslogictask.core.data.remote.NewsApiService
import com.ssti.lumuslogictask.core.data.repository.ArticleRepositoryImpl
import com.ssti.lumuslogictask.core.domain.repository.ArticleRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Author: Ravi Soni
 * Date: Mar 3, 2026
 * Desc: Hilt module providing Retrofit, Room, and repository dependencies.
 */
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val logging = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        return OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.NEWS_BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideNewsApiService(retrofit: Retrofit): NewsApiService {
        return retrofit.create(NewsApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): ArticleDatabase {
        return Room.databaseBuilder(
            context,
            ArticleDatabase::class.java,
            "article_db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideArticleRepository(
        apiService: NewsApiService,
        database: ArticleDatabase
    ): ArticleRepository {
        return ArticleRepositoryImpl(apiService, database)
    }
}


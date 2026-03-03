package com.ssti.lumuslogictask.features.news.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.ssti.lumuslogictask.core.common.Result
import com.ssti.lumuslogictask.core.domain.model.Article
import com.ssti.lumuslogictask.core.domain.usecase.GetArticlesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Author: Ravi Soni
 * Date: Mar 3, 2026
 * Desc: ViewModel for news list with paged articles flow.
 */
@HiltViewModel
class NewsViewModel @Inject constructor(
    private val getArticlesUseCase: GetArticlesUseCase
) : ViewModel() {
    private val _articles: Flow<PagingData<Article>> = getArticlesUseCase().cachedIn(viewModelScope)
    val articles: Flow<PagingData<Article>> get() = _articles
}

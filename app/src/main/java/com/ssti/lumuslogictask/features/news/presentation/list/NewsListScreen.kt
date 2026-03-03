package com.ssti.lumuslogictask.features.news.presentation.list

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import com.ssti.lumuslogictask.core.ui.components.EmptyScreen
import com.ssti.lumuslogictask.core.ui.components.ErrorScreen
import com.ssti.lumuslogictask.core.ui.components.LoadingScreen
import com.ssti.lumuslogictask.features.news.presentation.NewsViewModel
import com.ssti.lumuslogictask.features.news.presentation.components.ArticleItem

@Composable
fun NewsListScreen(
    viewModel: NewsViewModel = hiltViewModel(),
    onArticleClick: (String) -> Unit
) {
    val lazyPagingItems = viewModel.articles.collectAsLazyPagingItems()

    when {
        lazyPagingItems.loadState.refresh is LoadState.Loading -> LoadingScreen()
        lazyPagingItems.loadState.refresh is LoadState.Error -> ErrorScreen("Error loading news")
        lazyPagingItems.itemCount == 0 -> EmptyScreen("No news available")
        else -> {
            LazyColumn {
                items(count = lazyPagingItems.itemCount) { index ->
                    val article = lazyPagingItems[index] ?: return@items
                    ArticleItem(article = article) {
                        onArticleClick(article.url)
                    }
                }
                if (lazyPagingItems.loadState.append is LoadState.Loading) {
                    item { LoadingScreen(Modifier.fillMaxWidth()) }
                }
            }
        }
    }
}

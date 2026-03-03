package com.ssti.lumuslogictask.features.news.presentation.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.ssti.lumuslogictask.core.domain.model.Article

@Composable
fun NewsDetailScreen(article: Article) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        AsyncImage(model = article.urlToImage, contentDescription = null)
        Text(text = article.title ?: "")
        Text(text = article.content ?: "")
    }
}

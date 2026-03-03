package com.ssti.lumuslogictask.features.news.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.ssti.lumuslogictask.core.domain.model.Article

/**
 * Author: Ravi Soni
 * Date: Mar 3, 2026
 * Desc: Composable list item for a single news article.
 */
@Composable
fun ArticleItem(article: Article) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        AsyncImage(
            model = article.urlToImage,
            contentDescription = null,
            modifier = Modifier.height(80.dp)
        )
        Column(modifier = Modifier.padding(start = 16.dp)) {
            Text(text = article.title ?: "")
            Text(text = article.description ?: "")
        }
    }
}

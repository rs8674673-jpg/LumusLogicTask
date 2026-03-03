package com.ssti.lumuslogictask.features.news.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.ssti.lumuslogictask.core.domain.model.Article
import java.net.URLDecoder
import java.net.URLEncoder
import com.ssti.lumuslogictask.features.news.presentation.detail.NewsDetailScreen
import com.ssti.lumuslogictask.features.news.presentation.list.NewsListScreen

@Composable
fun NewsApp(navController: NavHostController = rememberNavController()) {
    NavHost(navController = navController, startDestination = "list") {
        composable("list") {
            NewsListScreen(onArticleClick = { url ->
                val encoded = URLEncoder.encode(url, Charsets.UTF_8.name())
                navController.navigate("detail/$encoded")
            })
        }
        composable(
            route = "detail/{url}",
            arguments = listOf(navArgument("url") { type = NavType.StringType })
        ) { backStackEntry ->
            val encodedUrl = backStackEntry.arguments?.getString("url") ?: ""
            val url = URLDecoder.decode(encodedUrl, Charsets.UTF_8.name())
            NewsDetailScreen(
                article = Article(
                    url = url,
                    author = null,
                    title = null,
                    description = null,
                    urlToImage = null,
                    publishedAt = null,
                    content = null,
                    sourceName = null
                )
            )
        }
    }
}

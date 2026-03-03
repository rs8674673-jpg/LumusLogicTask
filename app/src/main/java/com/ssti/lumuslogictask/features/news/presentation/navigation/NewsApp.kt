package com.ssti.lumuslogictask.features.news.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ssti.lumuslogictask.features.news.presentation.list.NewsListScreen

/**
 * Author: Ravi Soni
 * Date: Mar 3, 2026
 * Desc: Navigation host for the news app screens.
 */
@Composable
fun NewsApp(navController: NavHostController = rememberNavController()) {
    NavHost(navController = navController, startDestination = "list") {
        composable("list") {
            NewsListScreen()
        }
    }
}

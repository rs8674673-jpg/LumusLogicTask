package com.ssti.lumuslogictask

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.ui.Modifier
import com.ssti.lumuslogictask.features.news.presentation.navigation.NewsApp
import com.ssti.lumuslogictask.ui.theme.LumusLogicTaskTheme
import dagger.hilt.android.AndroidEntryPoint

/**
 * Author: Ravi Soni
 * Date: Mar 3, 2026
 * Desc: Main activity hosting the news app with edge-to-edge layout.
 */
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // Use enableEdgeToEdge to safely configure system bars and avoid NullPointerException
        // on the WindowInsetsController during activity startup.
        enableEdgeToEdge()

        setContent {
            LumusLogicTaskTheme {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .windowInsetsPadding(WindowInsets.safeDrawing)
                ) {
                    NewsApp()
                }
            }
        }
    }
}

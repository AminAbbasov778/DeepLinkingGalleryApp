package com.example.DeepLinkingGalleryApp
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*


import androidx.compose.animation.*
import androidx.navigation.NavGraph

import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.DeepLinkingGalleryApp.presentation.detail.DetailScreen
import com.example.DeepLinkingGalleryApp.presentation.home.HomeScreen
import com.example.DeepLinkingGalleryApp.presentation.navigation.NavGraph
import com.example.DeepLinkingGalleryApp.presentation.utils.Utils.sampleImages
import com.example.DeepLinkingGalleryApp.ui.theme.GalleryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GalleryTheme {
                val navController = rememberNavController()
                val intentData = intent?.data

                NavGraph(navController,intentData)
            }
        }
    }
}








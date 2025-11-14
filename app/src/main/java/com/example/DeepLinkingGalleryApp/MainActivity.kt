package com.example.DeepLinkingGalleryApp
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*


import androidx.compose.animation.*

import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.DeepLinkingGalleryApp.presentation.detail.DetailScreen
import com.example.DeepLinkingGalleryApp.presentation.home.HomeScreen
import com.example.DeepLinkingGalleryApp.presentation.utils.Utils.sampleImages
import com.example.DeepLinkingGalleryApp.ui.theme.GalleryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GalleryTheme {
                val navController = rememberNavController()
                val intentData = intent?.data

                GalleryApp(navController,intentData)
            }
        }
    }
}

@Composable
fun GalleryApp(navController : NavHostController,intentData : Uri? ) {


    var imageId  by remember { mutableStateOf<String?>(null) }

    LaunchedEffect(intentData) {
         imageId = intentData?.getQueryParameter("id")
        imageId?.let {
            navController.navigate("details/$imageId")
        }

    }

    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            AnimatedVisibility(
                visible = imageId == null,
                enter = fadeIn() + slideInHorizontally(initialOffsetX = { -it }),
                exit = fadeOut() + slideOutHorizontally(targetOffsetX = { -it })
            ) {
                HomeScreen(onImageClick = { navController.navigate("details/${it.id}") })
            }
        }


        composable(
            "details/{id}",
            arguments = listOf(navArgument("id") { type = NavType.StringType })
        ) { backStackEntry ->
            val id  = backStackEntry.arguments?.getString("id")
            var image = sampleImages.find { it.id.toString() == id }

            AnimatedVisibility(
                visible = image != null,
                enter = fadeIn() + slideInHorizontally(initialOffsetX = { it }),
                exit = fadeOut() + slideOutHorizontally(targetOffsetX = { it })
            ) {
                image?.let {
                    DetailScreen(
                        image = it,
                        onBackClick = { navController.popBackStack() }
                    )
                }
            }
        }
    }



}







package com.example.DeepLinkingGalleryApp.presentation.navigation

import android.net.Uri
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavGraph
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.DeepLinkingGalleryApp.presentation.detail.DetailScreen
import com.example.DeepLinkingGalleryApp.presentation.home.HomeScreen
import com.example.DeepLinkingGalleryApp.presentation.utils.Utils.sampleImages

@Composable
fun NavGraph(navController : NavHostController,intentData : Uri? ) {


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

package com.example.androidcodingtest.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.androidcodingtest.MainScreen

@Composable
fun NavigationHost(
    navHostController: NavHostController
) {
    NavHost(
        navController = navHostController,
        startDestination = NavRoutes.MainScreen.route
    ) {
        composable(NavRoutes.MainScreen.route) {
            MainScreen()
        }
    }
}
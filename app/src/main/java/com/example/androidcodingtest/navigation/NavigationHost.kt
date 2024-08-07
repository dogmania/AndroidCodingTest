package com.example.androidcodingtest.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.androidcodingtest.screens.MainScreen
import com.example.androidcodingtest.screens.alltasks.AllTasksScreen

@Composable
fun NavigationHost(
    navHostController: NavHostController
) {
    NavHost(
        navController = navHostController,
        startDestination = NavRoutes.AllTasksScreen.route
    ) {
        composable(NavRoutes.MainScreen.route) {
            MainScreen()
        }

        composable(NavRoutes.AllTasksScreen.route) {
            AllTasksScreen()
        }
    }
}
package com.example.androidcodingtest.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.androidcodingtest.screens.MainScreen
import com.example.androidcodingtest.screens.alltasks.AllTasksScreen
import com.example.androidcodingtest.screens.createtask.CreateTaskScreen

@Composable
fun NavigationHost(
    navHostController: NavHostController
) {
    NavHost(
        navController = navHostController,
        startDestination = NavRoutes.AllTasksScreen.route
    ) {
        val popScreen: () -> Unit = { navHostController.popBackStack() }

        composable(NavRoutes.MainScreen.route) {
            MainScreen()
        }

        composable(NavRoutes.AllTasksScreen.route) {
            AllTasksScreen(
                goToCreateTaskScreen = {
                    navHostController.navigate(NavRoutes.CreateTaskScreen.route)
                }
            )
        }

        composable(NavRoutes.CreateTaskScreen.route) {
            CreateTaskScreen(
                popScreen = popScreen
            )
        }
    }
}
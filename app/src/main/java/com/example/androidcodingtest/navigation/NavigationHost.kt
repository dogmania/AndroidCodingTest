package com.example.androidcodingtest.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.androidcodingtest.screens.MainScreen
import com.example.androidcodingtest.screens.alltasks.AllTasksScreen
import com.example.androidcodingtest.screens.createtask.CreateTaskScreen
import com.example.androidcodingtest.screens.taskdetail.TaskDetailScreen

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
                },
                goToTaskDetailScreen = { id: String ->
                    navHostController.navigate(NavRoutes.TaskDetailScreen.createRoute(id))
                }
            )
        }

        composable(NavRoutes.CreateTaskScreen.route) {
            CreateTaskScreen(
                popScreen = popScreen
            )
        }

        composable(
            "${NavRoutes.TaskDetailScreen.route}/{id}",
            arguments = listOf(navArgument("id") { type = NavType.StringType })
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getString("id") ?: ""

            TaskDetailScreen(id = id, popScreen = popScreen)
        }
    }
}
package com.example.androidcodingtest.navigation

sealed class NavRoutes(val route: String) {
    data object MainScreen: NavRoutes("mainScreen")
}
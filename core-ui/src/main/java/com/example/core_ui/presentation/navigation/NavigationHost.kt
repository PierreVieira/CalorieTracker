package com.example.core_ui.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.core.navigation.Route

@Composable
fun NavigationHost(
    startRoute: Route,
    builder: NavGraphBuilder.(navController: NavHostController) -> Unit
) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = startRoute.name,
        builder = { builder(navController) }
    )
}
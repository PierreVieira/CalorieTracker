package com.example.calorietracker.navigation

import androidx.compose.runtime.Composable
import com.example.core.navigation.AppRoutes
import com.example.core_ui.presentation.navigation.NavigationHost
import com.example.core_ui.presentation.navigation.extensions.composable
import com.example.core_ui.presentation.navigation.extensions.navigate
import com.example.onboarding_presentation.screens.gender.GenderScreen
import com.example.onboarding_presentation.screens.welcome.WelcomeScreen

@Composable
fun NavigationComponent() {
    NavigationHost(startRoute = AppRoutes.WELCOME) { navController ->
        composable(AppRoutes.WELCOME) {
            WelcomeScreen(onNavigate = navController::navigate)
        }
        composable(AppRoutes.AGE) {

        }
        composable(AppRoutes.GENDER) {
            GenderScreen(onNavigate = navController::navigate)
        }
        composable(AppRoutes.HEIGHT) {

        }
        composable(AppRoutes.WEIGHT) {

        }
        composable(AppRoutes.NUTRIENT_GOAL) {

        }
        composable(AppRoutes.ACTIVITY) {

        }
        composable(AppRoutes.GOAL) {

        }
        composable(AppRoutes.TRACKER_OVERVIEW) {

        }
    }
}
package com.example.calorietracker.navigation

import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import com.example.core.navigation.AppRoutes
import com.example.core_ui.presentation.navigation.NavigationHost
import com.example.core_ui.presentation.navigation.extensions.composable
import com.example.core_ui.presentation.navigation.extensions.navigate
import com.example.onboarding_presentation.screens.age.AgeScreen
import com.example.onboarding_presentation.screens.gender.GenderScreen
import com.example.onboarding_presentation.screens.welcome.WelcomeScreen

@Composable
fun NavigationComponent(scaffoldState: ScaffoldState) {
    NavigationHost(startRoute = AppRoutes.WELCOME) { navController ->
        composable(AppRoutes.WELCOME) {
            WelcomeScreen(onNavigate = navController::navigate)
        }
        composable(AppRoutes.AGE) {
            AgeScreen(
                scaffoldState = scaffoldState,
                onNavigate = navController::navigate,
                onBackClick = { navController.popBackStack() }
            )
        }
        composable(AppRoutes.GENDER) {
            GenderScreen(
                onNavigate = navController::navigate,
                onBackClick = { navController.popBackStack() }
            )
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
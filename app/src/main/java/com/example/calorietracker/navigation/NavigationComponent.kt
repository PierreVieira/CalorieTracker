package com.example.calorietracker.navigation

import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import com.example.util.presentation.navigation.AppRoutes
import com.example.ui.presentation.navigation.NavigationHost
import com.example.ui.presentation.navigation.extensions.composable
import com.example.ui.presentation.navigation.extensions.navigate
import com.example.onboarding_presentation.screens.onboarding.input_text.impl.age.AgeScreen
import com.example.onboarding_presentation.screens.onboarding.gender.GenderScreen
import com.example.onboarding_presentation.screens.onboarding.input_text.impl.height.HeightScreen
import com.example.onboarding_presentation.screens.onboarding.input_text.impl.weight.WeightScreen
import com.example.onboarding_presentation.screens.welcome.WelcomeScreen

@ExperimentalComposeUiApi
@Composable
fun NavigationComponent(scaffoldState: ScaffoldState) {
    NavigationHost(startRoute = AppRoutes.WELCOME) { navController ->
        composable(AppRoutes.WELCOME) {
            WelcomeScreen(onNavigate = navController::navigate)
        }
        composable(AppRoutes.GENDER) {
            GenderScreen(
                onNavigate = navController::navigate,
                onBackClick = { navController.popBackStack() }
            )
        }
        composable(AppRoutes.AGE) {
            AgeScreen(
                scaffoldState = scaffoldState,
                onNavigate = navController::navigate,
                onBackClick = { navController.popBackStack() }
            )
        }
        composable(AppRoutes.HEIGHT) {
            HeightScreen(
                scaffoldState = scaffoldState,
                onNavigate = navController::navigate,
                onBackClick = { navController.popBackStack() }
            )
        }
        composable(AppRoutes.WEIGHT) {
            WeightScreen(
                scaffoldState = scaffoldState,
                onNavigate = navController::navigate,
                onBackClick = { navController.popBackStack() }
            )
        }
        composable(AppRoutes.ACTIVITY) {

        }
        composable(AppRoutes.NUTRIENT_GOAL) {

        }
        composable(AppRoutes.GOAL) {

        }
        composable(AppRoutes.TRACKER_OVERVIEW) {

        }
    }
}
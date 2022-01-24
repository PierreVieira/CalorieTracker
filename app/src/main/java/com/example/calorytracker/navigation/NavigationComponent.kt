package com.example.calorytracker.navigation

import androidx.compose.runtime.Composable
import com.example.core.navigation.Route
import com.example.core_ui.navigation.NavigationHost
import com.example.core_ui.navigation.extensions.composable
import com.example.core_ui.navigation.extensions.navigate
import com.example.onboarding_presentation.welcome.WelcomeScreen

@Composable
fun NavigationComponent() {
    NavigationHost(startRoute = Route.WELCOME) { navController ->
        composable(Route.WELCOME) {
            WelcomeScreen(onNavigate = navController::navigate)
        }
        composable(Route.AGE) {

        }
        composable(Route.GENDER) {

        }
        composable(Route.HEIGHT) {

        }
        composable(Route.WEIGHT) {

        }
        composable(Route.NUTRIENT_GOAL) {

        }
        composable(Route.ACTIVITY) {

        }
        composable(Route.GOAL) {

        }
        composable(Route.TRACKER_OVERVIEW) {

        }
    }
}
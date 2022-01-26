package com.example.ui.presentation.navigation.extensions

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.util.presentation.navigation.Route

fun NavGraphBuilder.composable(
    route: Route,
    content: @Composable (NavBackStackEntry) -> Unit
) {
    this.composable(route.name) {
        content(it)
    }
}
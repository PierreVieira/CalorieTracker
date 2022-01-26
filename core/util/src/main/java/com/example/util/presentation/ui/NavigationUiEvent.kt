package com.example.util.presentation.ui

import com.example.util.presentation.navigation.Route

sealed interface NavigationUiEvent {
    abstract class Navigate(val route: Route): NavigationUiEvent
    abstract class NavigateUp: NavigationUiEvent
}

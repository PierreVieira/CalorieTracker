package com.example.core.presentation

import com.example.core.navigation.Route

sealed interface NavigationUiEvent {
    abstract class Navigate(val route: Route): NavigationUiEvent
    abstract class NavigateUp: NavigationUiEvent
}

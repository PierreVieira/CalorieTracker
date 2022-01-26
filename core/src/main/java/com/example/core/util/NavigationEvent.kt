package com.example.core.util

import com.example.core.navigation.Route

sealed interface NavigationEvent {
    abstract class Navigate(val route: Route): NavigationEvent
    object NavigateUp: NavigationEvent
}

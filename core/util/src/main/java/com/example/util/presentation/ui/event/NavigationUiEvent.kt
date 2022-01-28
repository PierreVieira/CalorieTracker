package com.example.util.presentation.ui.event

import com.example.util.presentation.navigation.Route
import com.example.util.presentation.ui.event.base.UiEvent

sealed interface NavigationUiEvent: UiEvent {
    abstract class Navigate(val route: Route): NavigationUiEvent
    abstract class NavigateUp: NavigationUiEvent
}

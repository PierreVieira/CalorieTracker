package com.example.core.util

import com.example.core.navigation.Route

sealed class UiEvent {
    data class Navigate(val route: Route): UiEvent()
    object NavigateUp: UiEvent()
}

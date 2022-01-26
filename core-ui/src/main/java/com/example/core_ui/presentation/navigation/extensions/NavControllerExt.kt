package com.example.core_ui.presentation.navigation.extensions

import androidx.navigation.NavController
import com.example.core.presentation.NavigationUiEvent

fun NavController.navigate(event: NavigationUiEvent.Navigate) {
    this.navigate(event.route.name)
}
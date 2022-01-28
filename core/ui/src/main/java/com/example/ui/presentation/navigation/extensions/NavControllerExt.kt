package com.example.ui.presentation.navigation.extensions

import androidx.navigation.NavController
import com.example.util.presentation.ui.event.NavigationUiEvent

fun NavController.navigate(event: NavigationUiEvent.Navigate) {
    this.navigate(event.route.name)
}
package com.example.core_ui.presentation.navigation.extensions

import androidx.navigation.NavController
import com.example.core.util.NavigationEvent

fun NavController.navigate(event: NavigationEvent.Navigate) {
    this.navigate(event.route.name)
}
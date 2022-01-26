package com.example.core_ui.presentation.navigation.extensions

import androidx.navigation.NavController
import com.example.core.util.UiEvent

fun NavController.navigate(event: UiEvent.Navigate) {
    this.navigate(event.route.name)
}
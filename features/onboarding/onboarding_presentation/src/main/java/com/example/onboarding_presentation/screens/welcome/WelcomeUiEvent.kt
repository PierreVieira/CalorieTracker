package com.example.onboarding_presentation.screens.welcome

import com.example.util.presentation.navigation.AppRoutes
import com.example.util.presentation.ui.event.NavigationUiEvent
import com.example.util.presentation.ui.event.base.UiEvent

sealed interface WelcomeUiEvent: UiEvent {
    object NavigateToGender: NavigationUiEvent.Navigate(AppRoutes.GENDER), WelcomeUiEvent
}
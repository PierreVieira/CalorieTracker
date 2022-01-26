package com.example.onboarding_presentation.screens.welcome

import com.example.core.navigation.AppRoutes
import com.example.core.presentation.NavigationUiEvent

sealed interface WelcomeUiEvent {
    object NavigateToGender: NavigationUiEvent.Navigate(AppRoutes.GENDER)
}
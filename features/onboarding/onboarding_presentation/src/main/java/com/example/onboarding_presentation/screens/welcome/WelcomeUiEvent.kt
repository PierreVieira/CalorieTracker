package com.example.onboarding_presentation.screens.welcome

import com.example.util.presentation.navigation.AppRoutes
import com.example.util.presentation.ui.NavigationUiEvent

sealed interface WelcomeUiEvent {
    object NavigateToGender: NavigationUiEvent.Navigate(AppRoutes.GENDER)
}
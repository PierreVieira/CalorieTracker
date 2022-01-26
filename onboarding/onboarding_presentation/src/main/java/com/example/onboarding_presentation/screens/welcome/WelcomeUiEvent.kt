package com.example.onboarding_presentation.screens.welcome

import com.example.core.navigation.AppRoutes
import com.example.core.util.NavigationEvent

sealed interface WelcomeUiEvent {
    object NavigateToGender: NavigationEvent.Navigate(AppRoutes.GENDER)
}
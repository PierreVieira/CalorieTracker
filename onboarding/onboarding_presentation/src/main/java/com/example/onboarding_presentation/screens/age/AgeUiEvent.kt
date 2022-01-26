package com.example.onboarding_presentation.screens.age

import com.example.core.navigation.AppRoutes
import com.example.core.presentation.AlertUiEvent
import com.example.core.presentation.NavigationUiEvent
import com.example.core.presentation.UiText
import com.example.core.R

sealed interface AgeUiEvent {
    object AgeEnter : AgeUiEvent
    object NavigateToNext : NavigationUiEvent.Navigate(AppRoutes.HEIGHT), AgeUiEvent
    object NavigateToBack: NavigationUiEvent.NavigateUp(), AgeUiEvent
    object ShowInvalidAgeSnackBar :
        AlertUiEvent.ShowSnackbar(UiText.StringResource(R.string.error_age_cant_be_empty)),
        AgeUiEvent
}
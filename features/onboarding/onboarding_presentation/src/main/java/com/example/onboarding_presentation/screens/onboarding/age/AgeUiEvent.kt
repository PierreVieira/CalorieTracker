package com.example.onboarding_presentation.screens.onboarding.age

import com.example.util.presentation.navigation.AppRoutes
import com.example.util.presentation.ui.AlertUiEvent
import com.example.util.presentation.ui.NavigationUiEvent
import com.example.util.presentation.ui.UiText
import com.example.util.R

sealed interface AgeUiEvent {
    object AgeEnter : AgeUiEvent
    object NavigateToNext : NavigationUiEvent.Navigate(AppRoutes.HEIGHT), AgeUiEvent
    object NavigateToBack: NavigationUiEvent.NavigateUp(), AgeUiEvent
    object ShowInvalidAgeSnackBar :
        AlertUiEvent.ShowSnackbar(UiText.StringResource(R.string.error_age_cant_be_empty)),
        AgeUiEvent
}
package com.example.onboarding_presentation.screens.onboarding.age.ui

import com.example.util.presentation.navigation.AppRoutes
import com.example.util.presentation.ui.event.AlertUiEvent
import com.example.util.presentation.ui.event.NavigationUiEvent
import com.example.util.presentation.ui.UiText
import com.example.util.R
import com.example.util.presentation.ui.event.base.UiEvent

sealed interface AgeUiEvent: UiEvent {
    object AgeEnter : AgeUiEvent
    object NavigateToNext : NavigationUiEvent.Navigate(AppRoutes.HEIGHT), AgeUiEvent
    object NavigateToBack: NavigationUiEvent.NavigateUp(), AgeUiEvent
    object ShowInvalidAgeSnackBar :
        AlertUiEvent.ShowSnackbar(UiText.StringResource(R.string.error_age_cant_be_empty)),
        AgeUiEvent
}
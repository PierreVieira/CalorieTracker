package com.example.onboarding_presentation.screens.onboarding.input_text.base

import androidx.annotation.StringRes
import com.example.util.presentation.navigation.AppRoutes
import com.example.util.presentation.ui.UiText
import com.example.util.presentation.ui.event.AlertUiEvent
import com.example.util.presentation.ui.event.NavigationUiEvent
import com.example.util.presentation.ui.event.base.UiEvent
import com.example.util.R

sealed interface OnboardingInputTextUiEvent : UiEvent {
    abstract class ValueEnter : OnboardingInputTextUiEvent

    abstract class ToNext(route: AppRoutes) : OnboardingInputTextUiEvent,
        NavigationUiEvent.Navigate(route)

    abstract class ToBack : NavigationUiEvent.NavigateUp(), OnboardingInputTextUiEvent

    abstract class ShowInvalidInputTextSnackbar(@StringRes alertTextId: Int) :
        AlertUiEvent.ShowSnackbar(
            UiText.StringResource(alertTextId)
        ), OnboardingInputTextUiEvent

    sealed interface AgeUiEvent : OnboardingInputTextUiEvent {
        object AgeEnter : ValueEnter(), AgeUiEvent
        object NavigateToNext : ToNext(AppRoutes.HEIGHT), AgeUiEvent
        object NavigateToBack : ToBack(), AgeUiEvent
        object ShowInvalidAgeSnackBar :
            ShowInvalidInputTextSnackbar(R.string.error_age_cant_be_empty), AgeUiEvent
    }

    sealed interface HeightUiEvent : OnboardingInputTextUiEvent {
        object HeightEnter : ValueEnter(), HeightUiEvent
        object NavigateToNext : ToNext(AppRoutes.WEIGHT), HeightUiEvent
        object NavigateToBack : ToBack(), HeightUiEvent
        object ShowInvalidHeightSnackbar :
            ShowInvalidInputTextSnackbar(R.string.error_height_cant_be_empty), HeightUiEvent
    }
}
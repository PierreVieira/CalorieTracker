package com.example.onboarding_presentation.screens.onboarding.gender.ui

import com.example.util.domain.model.Gender
import com.example.util.presentation.navigation.AppRoutes
import com.example.util.presentation.ui.event.NavigationUiEvent
import com.example.util.presentation.ui.event.base.UiEvent

sealed interface GenderUiEvent : UiEvent {
    object NavigateToNext: GenderUiEvent, NavigationUiEvent.Navigate(AppRoutes.AGE)
    object NavigateToBack: GenderUiEvent, NavigationUiEvent.NavigateUp()
    class SelectGender(val gender: Gender): GenderUiEvent
}
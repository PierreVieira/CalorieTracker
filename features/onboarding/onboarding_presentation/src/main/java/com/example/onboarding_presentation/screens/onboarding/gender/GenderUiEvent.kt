package com.example.onboarding_presentation.screens.onboarding.gender

import com.example.util.domain.model.Gender
import com.example.util.presentation.navigation.AppRoutes
import com.example.util.presentation.ui.NavigationUiEvent

sealed interface GenderUiEvent {
    object NavigateToNext: GenderUiEvent, NavigationUiEvent.Navigate(AppRoutes.AGE)
    object NavigateToBack: GenderUiEvent, NavigationUiEvent.NavigateUp()
    class SelectGender(val gender: Gender): GenderUiEvent
}
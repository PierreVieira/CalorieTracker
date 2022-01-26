package com.example.onboarding_presentation.screens.gender

import com.example.core.domain.model.Gender
import com.example.core.navigation.AppRoutes
import com.example.core.presentation.NavigationUiEvent

sealed interface GenderUiEvent {
    object NavigateToNext: GenderUiEvent, NavigationUiEvent.Navigate(AppRoutes.AGE)
    object NavigateToBack: GenderUiEvent, NavigationUiEvent.NavigateUp()
    class SelectGender(val gender: Gender): GenderUiEvent
}
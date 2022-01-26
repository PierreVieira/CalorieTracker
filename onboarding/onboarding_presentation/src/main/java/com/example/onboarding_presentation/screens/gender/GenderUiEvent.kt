package com.example.onboarding_presentation.screens.gender

import com.example.core.domain.model.Gender
import com.example.core.navigation.AppRoutes
import com.example.core.util.NavigationEvent

sealed interface GenderUiEvent {
    object NavigateToNext: GenderUiEvent, NavigationEvent.Navigate(AppRoutes.AGE)
    class SelectGender(val gender: Gender): GenderUiEvent
}
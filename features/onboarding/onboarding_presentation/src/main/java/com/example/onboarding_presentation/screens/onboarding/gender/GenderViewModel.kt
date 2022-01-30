package com.example.onboarding_presentation.screens.onboarding.gender

import com.example.onboarding_presentation.screens.onboarding.gender.ui.GenderUiEvent
import com.example.util.domain.model.Gender
import com.example.util.domain.preferences.UserPreferences
import com.example.util.presentation.view_model.data.EventSingleDataViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GenderViewModel @Inject constructor(
    private val userPreferences: UserPreferences
) : EventSingleDataViewModel<GenderUiEvent, Gender>(
    firstValue = userPreferences.getGender()
) {
    fun onGenderClick(gender: Gender) {
        updateUiValue(gender)
        sendEvent(GenderUiEvent.SelectGender(gender))
    }

    fun onNextClick() {
        saveGender()
        sendEvent(GenderUiEvent.NavigateToNext)
    }

    fun onBackClick() {
        saveGender()
        sendEvent(GenderUiEvent.NavigateToBack)
    }

    private fun saveGender() {
        userPreferences.saveGender(uiState.value)
    }
}
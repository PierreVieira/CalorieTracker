package com.example.onboarding_presentation.screens.onboarding.gender

import com.example.onboarding_presentation.screens.onboarding.gender.ui.GenderUiEvent
import com.example.onboarding_presentation.screens.onboarding.gender.ui.GenderUiState
import com.example.util.domain.model.Gender
import com.example.util.domain.preferences.Preferences
import com.example.util.presentation.view_model.EventStateViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GenderViewModel @Inject constructor(
    private val preferences: Preferences
) : EventStateViewModel<GenderUiEvent, GenderUiState>(
    GenderUiState(
        selectedGender = preferences.getGender()
    )
) {
    fun onGenderClick(gender: Gender) {
        updateUiState { it.copy(selectedGender = gender) }
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
        preferences.saveGender(uiState.value.selectedGender)
    }
}
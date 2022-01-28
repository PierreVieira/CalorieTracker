package com.example.onboarding_presentation.screens.onboarding.height

import com.example.onboarding_presentation.screens.onboarding.height.ui.HeightUiEvent
import com.example.onboarding_presentation.screens.onboarding.height.ui.HeightUiState
import com.example.util.domain.preferences.Preferences
import com.example.util.presentation.view_model.EventStateViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HeightViewModel @Inject constructor(
    private val preferences: Preferences
) : EventStateViewModel<HeightUiEvent, HeightUiState>(
    HeightUiState(
        height = preferences.getHeight()
    )
) {

}
package com.example.onboarding_presentation.screens.onboarding.input_text.base.ui

import com.example.util.presentation.ui.state.base.UiState

data class OnboardingInputTextUiState(
    override val data: OnboardingInputTextUiData,
    val showDialog: Boolean
) : UiState<OnboardingInputTextUiData>
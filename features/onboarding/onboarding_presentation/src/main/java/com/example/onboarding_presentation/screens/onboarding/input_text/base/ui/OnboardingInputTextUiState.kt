package com.example.onboarding_presentation.screens.onboarding.input_text.base.ui

import com.example.util.presentation.ui.state.base.UiState

data class OnboardingInputTextUiState(
    val editTextValue: String,
    val dialogUiData: OnboardingDialogUiData?,
    val showDialog: Boolean,
    val editTextFocused: Boolean
) : UiState
package com.example.onboarding_presentation.screens.onboarding.input_text.base.ui.model.base

import com.example.onboarding_presentation.screens.onboarding.input_text.base.ui.OnboardingInputTextUiEvent

abstract class OnboardingUiEventsModel(
    val valueEnterEvent: OnboardingInputTextUiEvent.ValueEnter,
    val invalidSnackbarEvent: OnboardingInputTextUiEvent.ShowInvalidInputTextSnackbar,
    val toNextEvent: OnboardingInputTextUiEvent.ToNext,
    val toBackEvent: OnboardingInputTextUiEvent.ToBack,
    val moveFocus: OnboardingInputTextUiEvent.MoveFocusToEditText,
)

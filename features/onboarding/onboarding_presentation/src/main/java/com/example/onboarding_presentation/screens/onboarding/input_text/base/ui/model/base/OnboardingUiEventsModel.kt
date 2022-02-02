package com.example.onboarding_presentation.screens.onboarding.input_text.base.ui.model.base

import com.example.onboarding_presentation.screens.onboarding.input_text.base.ui.OnboardingInputTextUiEvent

abstract class OnboardingUiEventsModel(
    open val valueEnterEvent: OnboardingInputTextUiEvent.ValueEnter,
    open val invalidSnackbarEvent: OnboardingInputTextUiEvent.ShowInvalidInputTextSnackbar,
    open val toNextEvent: OnboardingInputTextUiEvent.ToNext,
    open val toBackEvent: OnboardingInputTextUiEvent.ToBack
)

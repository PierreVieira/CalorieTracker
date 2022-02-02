package com.example.onboarding_presentation.screens.onboarding.input_text.base.ui.model

import com.example.onboarding_presentation.screens.onboarding.input_text.base.ui.OnboardingInputTextUiEvent
import com.example.onboarding_presentation.screens.onboarding.input_text.base.ui.model.base.OnboardingUiEventsModel

data class HeightUiEventsModel(
    override val valueEnterEvent: OnboardingInputTextUiEvent.ValueEnter,
    override val invalidSnackbarEvent: OnboardingInputTextUiEvent.ShowInvalidInputTextSnackbar,
    override val toNextEvent: OnboardingInputTextUiEvent.ToNext,
    override val toBackEvent: OnboardingInputTextUiEvent.ToBack,
) : OnboardingUiEventsModel(
    valueEnterEvent = valueEnterEvent,
    invalidSnackbarEvent = invalidSnackbarEvent,
    toNextEvent = toNextEvent,
    toBackEvent = toBackEvent
)

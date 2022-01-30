package com.example.onboarding_presentation.screens.onboarding.input_text.base.view_model

import com.example.onboarding_presentation.screens.onboarding.input_text.base.OnboardingInputTextUiEvent
import com.example.util.domain.use_case.FilterOutDigits

abstract class OnboardingIntInputTextViewModel<EVENT : OnboardingInputTextUiEvent>(
    firstData: String,
    filterOutDigits: FilterOutDigits,
    maxValue: Int,
    defaultValue: Int,
    valueEnterEvent: OnboardingInputTextUiEvent.ValueEnter,
    invalidSnackbarEvent: OnboardingInputTextUiEvent.ShowInvalidInputTextSnackbar,
    toNextEvent: OnboardingInputTextUiEvent.ToNext,
    toBackEvent: OnboardingInputTextUiEvent.ToBack
) : OnboardingInputTextViewModel<EVENT, Int>(
    firstData = firstData,
    filterOutDigits = filterOutDigits,
    maxValue = maxValue,
    defaultValue = defaultValue,
    invalidSnackbarEvent = invalidSnackbarEvent,
    valueEnterEvent = valueEnterEvent,
    toNextEvent = toNextEvent,
    toBackEvent = toBackEvent
) {
    override fun uiValueToValue(): Int? = uiState.value.toIntOrNull()
}
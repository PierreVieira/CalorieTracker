package com.example.onboarding_presentation.screens.onboarding.input_text.base.view_model

import com.example.onboarding_presentation.screens.onboarding.input_text.base.OnboardingInputTextUiEvent
import com.example.util.domain.use_case.filter_out.float_digits.FilterFloatOutDigits

abstract class OnboardingFloatInputTextViewModel<EVENT : OnboardingInputTextUiEvent>(
    firstData: String,
    filterOutDigits: FilterFloatOutDigits,
    maxValue: Float,
    defaultValue: Float,
    valueEnterEvent: OnboardingInputTextUiEvent.ValueEnter,
    invalidSnackbarEvent: OnboardingInputTextUiEvent.ShowInvalidInputTextSnackbar,
    toNextEvent: OnboardingInputTextUiEvent.ToNext,
    toBackEvent: OnboardingInputTextUiEvent.ToBack
) : OnboardingInputTextViewModel<EVENT, Float>(
    firstData = firstData,
    filterOutDigits = filterOutDigits,
    defaultValue = defaultValue,
    invalidSnackbarEvent = invalidSnackbarEvent,
    valueEnterEvent = valueEnterEvent,
    toNextEvent = toNextEvent,
    toBackEvent = toBackEvent
) {
    override fun uiValueToValue(): Float? = uiState.value.toFloatOrNull()
}
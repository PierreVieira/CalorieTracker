package com.example.onboarding_presentation.screens.onboarding.input_text.base.view_model

import com.example.onboarding_presentation.screens.onboarding.input_text.base.OnboardingInputTextUiEvent
import com.example.util.domain.use_case.filter_out.FilterIntOutDigits

abstract class OnboardingIntInputTextViewModel<EVENT : OnboardingInputTextUiEvent>(
    firstData: String,
    filterOutDigits: FilterIntOutDigits,
    maxValue: Int,
    defaultValue: Int,
    valueEnterEvent: OnboardingInputTextUiEvent.ValueEnter,
    invalidSnackbarEvent: OnboardingInputTextUiEvent.ShowInvalidInputTextSnackbar,
    toNextEvent: OnboardingInputTextUiEvent.ToNext,
    toBackEvent: OnboardingInputTextUiEvent.ToBack
) : OnboardingInputTextViewModel<EVENT, Int>(
    firstData = firstData,
    filterOutDigits = filterOutDigits,
    defaultValue = defaultValue,
    invalidSnackbarEvent = invalidSnackbarEvent,
    valueEnterEvent = valueEnterEvent,
    toNextEvent = toNextEvent,
    toBackEvent = toBackEvent
) {
    override fun uiValueToValue(): Int? = uiState.value.toIntOrNull()
}
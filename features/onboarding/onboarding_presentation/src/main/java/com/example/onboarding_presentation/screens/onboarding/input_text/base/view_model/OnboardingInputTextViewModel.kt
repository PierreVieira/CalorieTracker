package com.example.onboarding_presentation.screens.onboarding.input_text.base.view_model

import com.example.onboarding_presentation.screens.onboarding.input_text.base.OnboardingInputTextUiEvent
import com.example.util.domain.use_case.FilterOutDigits
import com.example.util.presentation.view_model.data.EventSingleDataViewModel

@Suppress("UNCHECKED_CAST")
abstract class OnboardingInputTextViewModel<EVENT : OnboardingInputTextUiEvent, VALUE_TYPE : Any>(
    firstData: String,
    private val filterOutDigits: FilterOutDigits,
    private val maxValue: Int,
    private val defaultValue: VALUE_TYPE,
    private val valueEnterEvent: OnboardingInputTextUiEvent.ValueEnter,
    private val invalidSnackbarEvent: OnboardingInputTextUiEvent.ShowInvalidInputTextSnackbar,
    private val toNextEvent: OnboardingInputTextUiEvent.ToNext,
    private val toBackEvent: OnboardingInputTextUiEvent.ToBack
) : EventSingleDataViewModel<EVENT, String>(
    firstData
) {
    fun onValueEnter(value: String) {
        updateUiValue(filterOutDigits(text = value, maxValue = maxValue))
        sendEvent(valueEnterEvent as EVENT)
    }
    fun onNextClick() {
        uiValueToValue()?.let {
            saveValue(it)
            sendEvent(toNextEvent as EVENT)
        } ?: sendEvent(invalidSnackbarEvent as EVENT)
    }
    fun onBackClick() {
        val value = uiValueToValue() ?: defaultValue
        saveValue(value)
        sendEvent(toBackEvent as EVENT)
    }
    protected abstract fun saveValue(value: VALUE_TYPE)
    protected abstract fun uiValueToValue(): VALUE_TYPE?
}
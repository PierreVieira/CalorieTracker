package com.example.onboarding_presentation.screens.onboarding.input_text.base.view_model

import androidx.lifecycle.viewModelScope
import com.example.onboarding_presentation.screens.onboarding.input_text.base.OnboardingInputTextUiEvent
import com.example.util.domain.use_case.filter_out.FilterOutDigits
import com.example.util.presentation.view_model.data.EventSingleDataViewModel
import kotlinx.coroutines.launch

@Suppress("UNCHECKED_CAST")
abstract class OnboardingInputTextViewModel<EVENT : OnboardingInputTextUiEvent, VALUE_TYPE : Any>(
    firstData: String,
    private val filterOutDigits: FilterOutDigits,
    private val defaultValue: VALUE_TYPE,
    private val valueEnterEvent: OnboardingInputTextUiEvent.ValueEnter,
    private val invalidSnackbarEvent: OnboardingInputTextUiEvent.ShowInvalidInputTextSnackbar,
    private val toNextEvent: OnboardingInputTextUiEvent.ToNext,
    private val toBackEvent: OnboardingInputTextUiEvent.ToBack
) : EventSingleDataViewModel<EVENT, String>(
    firstData
) {
    fun onValueEnter(value: String) {
        viewModelScope.launch {
            updateUiValue(filterOutDigits(value))
        }
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
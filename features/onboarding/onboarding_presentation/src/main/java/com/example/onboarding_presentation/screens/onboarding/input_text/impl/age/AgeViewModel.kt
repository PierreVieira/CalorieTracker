package com.example.onboarding_presentation.screens.onboarding.input_text.impl.age

import com.example.onboarding_presentation.screens.onboarding.input_text.base.OnboardingInputTextUiEvent
import com.example.onboarding_presentation.screens.onboarding.input_text.base.view_model.OnboardingIntInputTextViewModel
import com.example.util.domain.preferences.Preferences
import com.example.util.domain.use_case.FilterOutDigits
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AgeViewModel @Inject constructor(
    private val preferences: Preferences,
    filterOutDigits: FilterOutDigits
) : OnboardingIntInputTextViewModel<OnboardingInputTextUiEvent.AgeUiEvent>(
    firstData = "${preferences.getAge()}",
    filterOutDigits = filterOutDigits,
    maxValue = MAX_AGE,
    defaultValue = Preferences.DEFAULT_AGE,
    valueEnterEvent = OnboardingInputTextUiEvent.AgeUiEvent.AgeEnter,
    invalidSnackbarEvent = OnboardingInputTextUiEvent.AgeUiEvent.ShowInvalidAgeSnackBar,
    toNextEvent = OnboardingInputTextUiEvent.AgeUiEvent.NavigateToNext,
    toBackEvent = OnboardingInputTextUiEvent.AgeUiEvent.NavigateToBack
) {
    companion object {
        private const val MAX_AGE = 120
    }

    override fun saveValue(value: Int) {
        preferences.saveAge(value)
    }
}
package com.example.onboarding_presentation.screens.onboarding.input_text.impl.age

import com.example.onboarding_presentation.screens.onboarding.input_text.base.OnboardingInputTextUiEvent
import com.example.onboarding_presentation.screens.onboarding.input_text.base.view_model.OnboardingIntInputTextViewModel
import com.example.util.domain.preferences.UserPreferences
import com.example.util.domain.use_case.filter_out.FilterIntOutDigits
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AgeViewModel @Inject constructor(
    private val userPreferences: UserPreferences,
    filterOutDigits: FilterIntOutDigits
) : OnboardingIntInputTextViewModel<OnboardingInputTextUiEvent.AgeUiEvent>(
    firstData = "${userPreferences.getAge()}",
    filterOutDigits = filterOutDigits,
    maxValue = MAX_AGE,
    defaultValue = UserPreferences.DEFAULT_AGE,
    valueEnterEvent = OnboardingInputTextUiEvent.AgeUiEvent.AgeEnter,
    invalidSnackbarEvent = OnboardingInputTextUiEvent.AgeUiEvent.ShowInvalidAgeSnackBar,
    toNextEvent = OnboardingInputTextUiEvent.AgeUiEvent.NavigateToNext,
    toBackEvent = OnboardingInputTextUiEvent.AgeUiEvent.NavigateToBack
) {
    companion object {
        private const val MAX_AGE = 120
    }

    override fun saveValue(value: Int) {
        userPreferences.saveAge(value)
    }
}
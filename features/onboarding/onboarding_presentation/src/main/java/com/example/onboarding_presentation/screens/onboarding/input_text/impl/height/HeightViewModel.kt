package com.example.onboarding_presentation.screens.onboarding.input_text.impl.height

import com.example.onboarding_presentation.screens.onboarding.input_text.base.OnboardingInputTextUiEvent
import com.example.onboarding_presentation.screens.onboarding.input_text.base.view_model.OnboardingIntInputTextViewModel
import com.example.util.domain.preferences.Preferences
import com.example.util.domain.use_case.FilterOutDigits
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HeightViewModel @Inject constructor(
    private val preferences: Preferences,
    filterOutDigits: FilterOutDigits,
) : OnboardingIntInputTextViewModel<OnboardingInputTextUiEvent.HeightUiEvent>(
    firstData = "${preferences.getHeight()}",
    filterOutDigits = filterOutDigits,
    maxValue = MAX_HEIGHT,
    defaultValue = Preferences.DEFAULT_AGE,
    valueEnterEvent = OnboardingInputTextUiEvent.HeightUiEvent.HeightEnter,
    invalidSnackbarEvent = OnboardingInputTextUiEvent.HeightUiEvent.ShowInvalidHeightSnackbar,
    toNextEvent = OnboardingInputTextUiEvent.HeightUiEvent.NavigateToNext,
    toBackEvent = OnboardingInputTextUiEvent.HeightUiEvent.NavigateToBack
) {
    companion object {
        private const val MAX_HEIGHT = 280
    }

    override fun saveValue(value: Int) {
        preferences.saveHeight(value)
    }
}
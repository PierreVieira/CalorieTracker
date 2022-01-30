package com.example.onboarding_presentation.screens.onboarding.input_text.impl.height

import com.example.onboarding_presentation.screens.onboarding.input_text.base.OnboardingInputTextUiEvent
import com.example.onboarding_presentation.screens.onboarding.input_text.base.view_model.OnboardingIntInputTextViewModel
import com.example.util.domain.preferences.UserPreferences
import com.example.util.domain.use_case.filter_out.FilterIntOutDigits
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HeightViewModel @Inject constructor(
    private val userPreferences: UserPreferences,
    filterOutDigits: FilterIntOutDigits,
) : OnboardingIntInputTextViewModel<OnboardingInputTextUiEvent.HeightUiEvent>(
    firstData = "${userPreferences.getHeight()}",
    filterOutDigits = filterOutDigits,
    maxValue = MAX_HEIGHT,
    defaultValue = UserPreferences.DEFAULT_AGE,
    valueEnterEvent = OnboardingInputTextUiEvent.HeightUiEvent.HeightEnter,
    invalidSnackbarEvent = OnboardingInputTextUiEvent.HeightUiEvent.ShowInvalidHeightSnackbar,
    toNextEvent = OnboardingInputTextUiEvent.HeightUiEvent.NavigateToNext,
    toBackEvent = OnboardingInputTextUiEvent.HeightUiEvent.NavigateToBack
) {
    companion object {
        private const val MAX_HEIGHT = 280
    }

    override fun saveValue(value: Int) {
        userPreferences.saveHeight(value)
    }
}
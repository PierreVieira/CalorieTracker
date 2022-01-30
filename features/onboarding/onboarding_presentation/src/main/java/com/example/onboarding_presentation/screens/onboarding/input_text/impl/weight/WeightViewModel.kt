package com.example.onboarding_presentation.screens.onboarding.input_text.impl.weight

import com.example.onboarding_presentation.screens.onboarding.input_text.base.OnboardingInputTextUiEvent
import com.example.onboarding_presentation.screens.onboarding.input_text.base.view_model.OnboardingFloatInputTextViewModel
import com.example.util.domain.preferences.UserPreferences
import com.example.util.domain.use_case.filter_out.float_digits.FilterFloatOutDigits
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WeightViewModel @Inject constructor(
    private val userPreferences: UserPreferences,
    filterOutDigits: FilterFloatOutDigits
) : OnboardingFloatInputTextViewModel<OnboardingInputTextUiEvent.WeightUiEvent>(
    firstData = "${userPreferences.getWeight()}",
    filterOutDigits = filterOutDigits,
    maxValue = MAX_WEIGHT,
    defaultValue = UserPreferences.DEFAULT_WEIGHT,
    valueEnterEvent = OnboardingInputTextUiEvent.WeightUiEvent.WeightEnter,
    invalidSnackbarEvent = OnboardingInputTextUiEvent.WeightUiEvent.ShowInvalidWeightSnackBar,
    toNextEvent = OnboardingInputTextUiEvent.WeightUiEvent.NavigateToNext,
    toBackEvent = OnboardingInputTextUiEvent.WeightUiEvent.NavigateToBack
) {

    companion object {
        private const val MAX_WEIGHT = 250f
    }

    override fun saveValue(value: Float) {
        userPreferences.saveWeight(value)
    }
}

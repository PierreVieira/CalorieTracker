package com.example.onboarding_presentation.screens.onboarding.input_text.implementation.weight

import com.example.onboarding_domain.model.InvalidDialogMessages
import com.example.onboarding_domain.model.OnboardingConstValues
import com.example.onboarding_domain.use_case.models.OnboardingFloatUseCases
import com.example.onboarding_presentation.screens.onboarding.input_text.base.ui.OnboardingInputTextUiEvent
import com.example.onboarding_presentation.screens.onboarding.input_text.base.ui.model.WeightUiEventsModel
import com.example.onboarding_presentation.screens.onboarding.input_text.base.view_model.OnboardingFloatInputTextViewModel
import com.example.util.domain.preferences.UserPreferences
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WeightViewModel @Inject constructor(
    private val userPreferences: UserPreferences,
    onboardingFloatUseCases: OnboardingFloatUseCases,
    weightUiEventsModel: WeightUiEventsModel,
) : OnboardingFloatInputTextViewModel<OnboardingInputTextUiEvent.WeightUiEvent>(
    firstData = userPreferences.getWeight(),
    onboardingConstValues = OnboardingConstValues.Weight,
    invalidDialogMessages = InvalidDialogMessages.WEIGHT,
    useCases = onboardingFloatUseCases,
    uiEvents = weightUiEventsModel
) {

    override fun saveValue(value: Float) {
        userPreferences.saveWeight(value)
    }
}

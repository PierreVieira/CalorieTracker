package com.example.onboarding_presentation.screens.onboarding.input_text.impl.height

import com.example.onboarding_domain.model.InvalidDialogMessages
import com.example.onboarding_domain.model.OnboardingConstValues
import com.example.onboarding_domain.use_case.models.OnboardingIntUseCases
import com.example.onboarding_presentation.screens.onboarding.input_text.base.ui.OnboardingInputTextUiEvent
import com.example.onboarding_presentation.screens.onboarding.input_text.base.ui.model.HeightUiEventsModel
import com.example.onboarding_presentation.screens.onboarding.input_text.base.view_model.OnboardingIntInputTextViewModel
import com.example.util.domain.preferences.UserPreferences
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HeightViewModel @Inject constructor(
    private val userPreferences: UserPreferences,
    heightUiEventsModel: HeightUiEventsModel,
    onboardingIntUseCases: OnboardingIntUseCases
) : OnboardingIntInputTextViewModel<OnboardingInputTextUiEvent.HeightUiEvent>(
    firstData = userPreferences.getHeight(),
    invalidDialogMessages = InvalidDialogMessages.HEIGHT,
    onboardingConstValues = OnboardingConstValues.Height,
    useCases = onboardingIntUseCases,
    uiEvents = heightUiEventsModel
) {

    override fun saveValue(value: Int) {
        userPreferences.saveHeight(value)
    }
}
package com.example.onboarding_presentation.screens.onboarding.input_text.impl.age

import com.example.onboarding_domain.model.InvalidDialogMessages
import com.example.onboarding_domain.model.OnboardingConstValues
import com.example.onboarding_domain.use_case.IgnoreInvalidIntUseCase
import com.example.onboarding_domain.use_case.models.OnboardingIntUseCases
import com.example.onboarding_presentation.screens.onboarding.input_text.base.ui.OnboardingInputTextUiEvent
import com.example.onboarding_presentation.screens.onboarding.input_text.base.ui.model.AgeUiEventsModel
import com.example.onboarding_presentation.screens.onboarding.input_text.base.view_model.OnboardingIntInputTextViewModel
import com.example.util.domain.preferences.UserPreferences
import com.example.util.domain.use_case.filter_out.FilterIntOutDigitsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AgeViewModel @Inject constructor(
    private val userPreferences: UserPreferences,
    ageUiEventsModel: AgeUiEventsModel,
    onboardingIntUseCase: OnboardingIntUseCases
) : OnboardingIntInputTextViewModel<OnboardingInputTextUiEvent.AgeUiEvent>(
    firstData = userPreferences.getAge(),
    invalidDialogMessages = InvalidDialogMessages.AGE,
    onboardingConstValues = OnboardingConstValues.Age,
    useCases = onboardingIntUseCase,
    uiEvents = ageUiEventsModel
) {

    override fun saveValue(value: Int) {
        userPreferences.saveAge(value)
    }
}
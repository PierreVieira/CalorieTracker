package com.example.onboarding_presentation.screens.onboarding.input_text.base.view_model

import com.example.onboarding_domain.model.InvalidDialogMessages
import com.example.onboarding_domain.model.OnboardingConstValues
import com.example.onboarding_domain.use_case.models.OnboardingUseCases
import com.example.onboarding_presentation.screens.onboarding.input_text.base.ui.OnboardingInputTextUiEvent
import com.example.onboarding_presentation.screens.onboarding.input_text.base.ui.model.base.OnboardingUiEventsModel

abstract class OnboardingIntInputTextViewModel<EVENT : OnboardingInputTextUiEvent>(
    firstData: Int,
    onboardingConstValues: OnboardingConstValues<Int>,
    useCases: OnboardingUseCases<Int>,
    invalidDialogMessages: InvalidDialogMessages,
    uiEvents: OnboardingUiEventsModel
) : OnboardingInputTextViewModel<Int>(
    firstData = firstData,
    onboardingConstValues = onboardingConstValues,
    useCases = useCases,
    uiEvents = uiEvents,
    invalidDialogMessages = invalidDialogMessages
) {
    override fun uiValueToValue(): Int? = uiState.value.data.editTextValue.toIntOrNull()
}
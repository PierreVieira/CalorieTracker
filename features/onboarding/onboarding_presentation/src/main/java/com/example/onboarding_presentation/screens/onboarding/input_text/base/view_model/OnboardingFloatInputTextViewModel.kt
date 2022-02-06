package com.example.onboarding_presentation.screens.onboarding.input_text.base.view_model

import com.example.onboarding_domain.model.InvalidDialogMessages
import com.example.onboarding_domain.model.OnboardingConstValues
import com.example.onboarding_domain.use_case.models.OnboardingUseCases
import com.example.onboarding_presentation.screens.onboarding.input_text.base.ui.OnboardingInputTextUiEvent
import com.example.onboarding_presentation.screens.onboarding.input_text.base.ui.model.base.OnboardingUiEventsModel

abstract class OnboardingFloatInputTextViewModel<EVENT : OnboardingInputTextUiEvent>(
    firstData: Float,
    onboardingConstValues: OnboardingConstValues<Float>,
    useCases: OnboardingUseCases<Float>,
    invalidDialogMessages: InvalidDialogMessages,
    uiEvents: OnboardingUiEventsModel
) : OnboardingInputTextViewModel<Float>(
    firstData = firstData,
    onboardingConstValues = onboardingConstValues,
    invalidDialogMessages = invalidDialogMessages,
    useCases = useCases,
    uiEvents = uiEvents
) {
    override fun uiValueToValue(): Float? = uiState.value.editTextValue.toFloatOrNull()
}
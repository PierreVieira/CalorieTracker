package com.example.onboarding_presentation.screens.onboarding.input_text.base.ui.model

import com.example.onboarding_presentation.screens.onboarding.input_text.base.ui.OnboardingInputTextUiEvent
import com.example.onboarding_presentation.screens.onboarding.input_text.base.ui.model.base.OnboardingUiEventsModel

class WeightUiEventsModel : OnboardingUiEventsModel(
    valueEnterEvent = OnboardingInputTextUiEvent.WeightUiEvent.WeightEnter,
    invalidSnackbarEvent = OnboardingInputTextUiEvent.WeightUiEvent.ShowInvalidWeightSnackBar,
    toNextEvent = OnboardingInputTextUiEvent.WeightUiEvent.NavigateToNext,
    toBackEvent = OnboardingInputTextUiEvent.WeightUiEvent.NavigateToBack,
    moveFocus = OnboardingInputTextUiEvent.MoveFocusToEditText
)

package com.example.onboarding_presentation.screens.onboarding.input_text.base.ui.model

import com.example.onboarding_presentation.screens.onboarding.input_text.base.ui.OnboardingInputTextUiEvent
import com.example.onboarding_presentation.screens.onboarding.input_text.base.ui.model.base.OnboardingUiEventsModel

class AgeUiEventsModel: OnboardingUiEventsModel(
    valueEnterEvent = OnboardingInputTextUiEvent.AgeUiEvent.AgeEnter,
    invalidSnackbarEvent = OnboardingInputTextUiEvent.AgeUiEvent.ShowInvalidAgeSnackBar,
    toNextEvent = OnboardingInputTextUiEvent.AgeUiEvent.NavigateToNext,
    toBackEvent = OnboardingInputTextUiEvent.AgeUiEvent.NavigateToBack,
    moveFocus = OnboardingInputTextUiEvent.MoveFocusToEditText
)
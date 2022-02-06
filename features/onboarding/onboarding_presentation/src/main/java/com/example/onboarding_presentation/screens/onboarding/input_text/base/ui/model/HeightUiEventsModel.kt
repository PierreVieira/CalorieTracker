package com.example.onboarding_presentation.screens.onboarding.input_text.base.ui.model

import com.example.onboarding_presentation.screens.onboarding.input_text.base.ui.OnboardingInputTextUiEvent
import com.example.onboarding_presentation.screens.onboarding.input_text.base.ui.model.base.OnboardingUiEventsModel

class HeightUiEventsModel : OnboardingUiEventsModel(
    valueEnterEvent = OnboardingInputTextUiEvent.HeightUiEvent.HeightEnter,
    invalidSnackbarEvent = OnboardingInputTextUiEvent.HeightUiEvent.ShowInvalidHeightSnackbar,
    toNextEvent = OnboardingInputTextUiEvent.HeightUiEvent.NavigateToNext,
    toBackEvent = OnboardingInputTextUiEvent.HeightUiEvent.NavigateToBack,
    moveFocus = OnboardingInputTextUiEvent.MoveFocusToEditText
)

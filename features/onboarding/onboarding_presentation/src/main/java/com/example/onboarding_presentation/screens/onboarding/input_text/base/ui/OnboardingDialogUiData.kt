package com.example.onboarding_presentation.screens.onboarding.input_text.base.ui

import androidx.annotation.StringRes

data class OnboardingDialogUiData(
    @StringRes val title: Int,
    @StringRes val message: Int,
    @StringRes val buttonMessage: Int,
    val checked: Boolean,
)

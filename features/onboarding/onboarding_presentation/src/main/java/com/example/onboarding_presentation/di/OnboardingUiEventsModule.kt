package com.example.onboarding_presentation.di

import com.example.onboarding_presentation.screens.onboarding.input_text.base.ui.OnboardingInputTextUiEvent
import com.example.onboarding_presentation.screens.onboarding.input_text.base.ui.model.AgeUiEventsModel
import com.example.onboarding_presentation.screens.onboarding.input_text.base.ui.model.HeightUiEventsModel
import com.example.onboarding_presentation.screens.onboarding.input_text.base.ui.model.WeightUiEventsModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object OnboardingUiEventsModule {

    @Provides
    @Singleton
    fun provideOnboardingAgeUiEvents(): AgeUiEventsModel = AgeUiEventsModel(
        valueEnterEvent = OnboardingInputTextUiEvent.AgeUiEvent.AgeEnter,
        invalidSnackbarEvent = OnboardingInputTextUiEvent.AgeUiEvent.ShowInvalidAgeSnackBar,
        toNextEvent = OnboardingInputTextUiEvent.AgeUiEvent.NavigateToNext,
        toBackEvent = OnboardingInputTextUiEvent.AgeUiEvent.NavigateToBack
    )

    @Provides
    @Singleton
    fun provideOnboardingHeightUiEvents(): HeightUiEventsModel = HeightUiEventsModel(
        valueEnterEvent = OnboardingInputTextUiEvent.HeightUiEvent.HeightEnter,
        invalidSnackbarEvent = OnboardingInputTextUiEvent.HeightUiEvent.ShowInvalidHeightSnackbar,
        toNextEvent = OnboardingInputTextUiEvent.HeightUiEvent.NavigateToNext,
        toBackEvent = OnboardingInputTextUiEvent.HeightUiEvent.NavigateToBack
    )

    @Provides
    @Singleton
    fun provideOnboardingWeightUiEvents(): WeightUiEventsModel = WeightUiEventsModel(
        valueEnterEvent = OnboardingInputTextUiEvent.WeightUiEvent.WeightEnter,
        invalidSnackbarEvent = OnboardingInputTextUiEvent.WeightUiEvent.ShowInvalidWeightSnackBar,
        toNextEvent = OnboardingInputTextUiEvent.HeightUiEvent.NavigateToNext,
        toBackEvent = OnboardingInputTextUiEvent.HeightUiEvent.NavigateToBack
    )
}
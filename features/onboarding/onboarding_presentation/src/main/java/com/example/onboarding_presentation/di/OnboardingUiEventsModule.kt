package com.example.onboarding_presentation.di

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
    fun provideOnboardingAgeUiEvents(): AgeUiEventsModel = AgeUiEventsModel()

    @Provides
    @Singleton
    fun provideOnboardingHeightUiEvents(): HeightUiEventsModel = HeightUiEventsModel()

    @Provides
    @Singleton
    fun provideOnboardingWeightUiEvents(): WeightUiEventsModel = WeightUiEventsModel()
}
package com.example.onboarding_domain.di

import com.example.onboarding_domain.use_case.GetInvalidDialogMessagesUseCase
import com.example.onboarding_domain.use_case.InvalidCurrentValueUseCase
import com.example.onboarding_domain.use_case.NeedsShowInvalidValuesDialogUseCase
import com.example.onboarding_domain.use_case.models.OnboardingFloatUseCases
import com.example.onboarding_domain.use_case.models.OnboardingIntUseCases
import com.example.util.domain.use_case.filter_out.FilterIntOutDigitsUseCase
import com.example.util.domain.use_case.filter_out.float_digits.FilterFloatOutDigitsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object OnboardingUseCaseModule {

    @Provides
    @Singleton
    fun providesInvalidCurrentValueUseCaseInt(): InvalidCurrentValueUseCase<Int> =
        InvalidCurrentValueUseCase()

    @Provides
    @Singleton
    fun providesInvalidCurrentValueUseCaseFloat(): InvalidCurrentValueUseCase<Float> =
        InvalidCurrentValueUseCase()

    @Provides
    @Singleton
    fun providesGetDialogMessagesUseCaseFloat(): GetInvalidDialogMessagesUseCase<Float> =
        GetInvalidDialogMessagesUseCase()

    @Provides
    @Singleton
    fun providesGetDialogMessagesUseCaseInt(): GetInvalidDialogMessagesUseCase<Int> =
        GetInvalidDialogMessagesUseCase()

    @Provides
    @Singleton
    fun providesNedsShowInvalidValuesDialogInt(
        invalidCurrentValueUseCase: InvalidCurrentValueUseCase<Int>,
    ): NeedsShowInvalidValuesDialogUseCase<Int> =
        NeedsShowInvalidValuesDialogUseCase(invalidCurrentValueUseCase)

    @Provides
    @Singleton
    fun providesNedsShowInvalidValuesDialogFloat(
        invalidCurrentValueUseCase: InvalidCurrentValueUseCase<Float>,
    ): NeedsShowInvalidValuesDialogUseCase<Float> =
        NeedsShowInvalidValuesDialogUseCase(invalidCurrentValueUseCase)

    @Singleton
    @Provides
    fun provideOnboardingFloatUseCases(
        filterOutFloatUseCases: FilterFloatOutDigitsUseCase,
        needsShowInvalidValuesDialog: NeedsShowInvalidValuesDialogUseCase<Float>,
        getInvalidDialogMessagesUseCase: GetInvalidDialogMessagesUseCase<Float>
    ): OnboardingFloatUseCases = OnboardingFloatUseCases(
        filterOutDigits = filterOutFloatUseCases,
        needsShowInvalidValuesDialog = needsShowInvalidValuesDialog,
        getInvalidDialogMessages = getInvalidDialogMessagesUseCase
    )

    @Singleton
    @Provides
    fun provideOnboardingIntUseCases(
        filterOutIntUseCase: FilterIntOutDigitsUseCase,
        needsShowInvalidValuesDialog: NeedsShowInvalidValuesDialogUseCase<Int>,
        getInvalidDialogMessagesUseCase: GetInvalidDialogMessagesUseCase<Int>
    ): OnboardingIntUseCases = OnboardingIntUseCases(
        filterOutDigits = filterOutIntUseCase,
        needsShowInvalidValuesDialog = needsShowInvalidValuesDialog,
        getInvalidDialogMessages = getInvalidDialogMessagesUseCase
    )
}
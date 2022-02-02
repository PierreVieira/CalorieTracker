package com.example.onboarding_domain.di

import com.example.onboarding_domain.use_case.IgnoreInvalidFloatUseCase
import com.example.onboarding_domain.use_case.IgnoreInvalidIntUseCase
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
    fun provideIgonreInvalidIntUseCase(): IgnoreInvalidIntUseCase = IgnoreInvalidIntUseCase()

    @Provides
    @Singleton
    fun provideIgonreInvalidFloatUseCase(): IgnoreInvalidFloatUseCase = IgnoreInvalidFloatUseCase()

    @Singleton
    @Provides
    fun provideOnboardingFloatUseCases(
        filterOutFloatUseCases: FilterFloatOutDigitsUseCase,
        ignoreInvalidFloatUseCase: IgnoreInvalidFloatUseCase
    ): OnboardingFloatUseCases = OnboardingFloatUseCases(
        filterOutDigits = filterOutFloatUseCases,
        needsShowDialog = ignoreInvalidFloatUseCase
    )

    @Singleton
    @Provides
    fun provideOnboardingIntUseCases(
        filterOutIntUseCase: FilterIntOutDigitsUseCase,
        ignoreInvalidIntUseCase: IgnoreInvalidIntUseCase
    ): OnboardingIntUseCases = OnboardingIntUseCases(
        filterOutDigits = filterOutIntUseCase,
        needsShowDialog = ignoreInvalidIntUseCase
    )
}
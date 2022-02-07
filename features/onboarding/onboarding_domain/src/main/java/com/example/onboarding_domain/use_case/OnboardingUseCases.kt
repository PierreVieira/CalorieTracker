package com.example.onboarding_domain.use_case

import com.example.util.domain.use_case.filter_out.FilterOutDigitsUseCase

data class OnboardingUseCases<T: Comparable<T>>(
    val filterOutDigits: FilterOutDigitsUseCase,
    val needsShowInvalidValuesDialog: NeedsShowInvalidValuesDialogUseCase<T>,
    val getInvalidDialogMessages: GetInvalidDialogMessagesUseCase<T>
)


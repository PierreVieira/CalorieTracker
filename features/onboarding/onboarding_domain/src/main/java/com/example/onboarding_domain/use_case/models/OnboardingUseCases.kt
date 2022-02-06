package com.example.onboarding_domain.use_case.models

import com.example.onboarding_domain.use_case.GetInvalidDialogMessagesUseCase
import com.example.onboarding_domain.use_case.NeedsShowInvalidValuesDialogUseCase
import com.example.util.domain.use_case.filter_out.FilterOutDigitsUseCase

abstract class OnboardingUseCases<T: Comparable<T>>(
    open val filterOutDigits: FilterOutDigitsUseCase,
    open val needsShowInvalidValuesDialog: NeedsShowInvalidValuesDialogUseCase<T>,
    open val getInvalidDialogMessages: GetInvalidDialogMessagesUseCase<T>
)


package com.example.onboarding_domain.use_case.models

import com.example.onboarding_domain.use_case.GetInvalidDialogMessagesUseCase
import com.example.onboarding_domain.use_case.NeedsShowInvalidValuesDialogUseCase
import com.example.util.domain.use_case.filter_out.FilterIntOutDigitsUseCase

data class OnboardingIntUseCases(
    override val filterOutDigits: FilterIntOutDigitsUseCase,
    override val needsShowInvalidValuesDialog: NeedsShowInvalidValuesDialogUseCase<Int>,
    val getInvalidDialogMessages: GetInvalidDialogMessagesUseCase<Int>
): OnboardingUseCases<Int>(
    filterOutDigits,
    needsShowInvalidValuesDialog,
    getInvalidDialogMessages
)
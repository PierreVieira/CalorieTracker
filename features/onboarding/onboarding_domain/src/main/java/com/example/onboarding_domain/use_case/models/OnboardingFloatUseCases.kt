package com.example.onboarding_domain.use_case.models

import com.example.onboarding_domain.use_case.GetInvalidDialogMessagesUseCase
import com.example.onboarding_domain.use_case.NeedsShowInvalidValuesDialogUseCase
import com.example.util.domain.use_case.filter_out.float_digits.FilterFloatOutDigitsUseCase

data class OnboardingFloatUseCases(
    override val filterOutDigits: FilterFloatOutDigitsUseCase,
    override val needsShowInvalidValuesDialog: NeedsShowInvalidValuesDialogUseCase<Float>,
    override val getInvalidDialogMessages: GetInvalidDialogMessagesUseCase<Float>
): OnboardingUseCases<Float>(
    filterOutDigits = filterOutDigits,
    needsShowInvalidValuesDialog = needsShowInvalidValuesDialog,
    getInvalidDialogMessages = getInvalidDialogMessages
)
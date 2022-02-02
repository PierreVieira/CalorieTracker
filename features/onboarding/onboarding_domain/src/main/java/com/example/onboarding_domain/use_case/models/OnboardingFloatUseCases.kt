package com.example.onboarding_domain.use_case.models

import com.example.onboarding_domain.use_case.NeedsShowDialog
import com.example.util.domain.use_case.filter_out.float_digits.FilterFloatOutDigitsUseCase

data class OnboardingFloatUseCases(
    override val filterOutDigits: FilterFloatOutDigitsUseCase,
    override val needsShowDialog: NeedsShowDialog<Float>
): OnboardingUseCases<Float>(
    filterOutDigits = filterOutDigits,
    needsShowDialog = needsShowDialog
)
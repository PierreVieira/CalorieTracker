package com.example.onboarding_domain.use_case.models

import com.example.onboarding_domain.use_case.NeedsShowDialog
import com.example.util.domain.use_case.filter_out.FilterIntOutDigitsUseCase

data class OnboardingIntUseCases(
    override val filterOutDigits: FilterIntOutDigitsUseCase,
    override val needsShowDialog: NeedsShowDialog<Int>
): OnboardingUseCases<Int>(
    filterOutDigits,
    needsShowDialog
)
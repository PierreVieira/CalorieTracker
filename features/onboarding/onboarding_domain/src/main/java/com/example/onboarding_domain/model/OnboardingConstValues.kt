package com.example.onboarding_domain.model

sealed class OnboardingConstValues<T : Comparable<T>>(
    val default: T,
    val min: T,
    val max: T
) {
    object Age : OnboardingConstValues<Int>(default = 20, min = 0, max = 120)
    object Height : OnboardingConstValues<Int>(default = 170, min = 15, max = 280)
    object Weight: OnboardingConstValues<Float>(default = 68.0f, min = 15f, max = 250f)
}
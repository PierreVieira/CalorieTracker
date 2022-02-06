package com.example.onboarding_domain.use_case

import com.example.use_case.UseCase

class InvalidCurrentValueUseCase<T : Comparable<T>> :
    UseCase<InvalidCurrentValueUseCase.Params<T>, Boolean>() {

    data class Params<T>(
        val maxValue: T,
        val minValue: T,
        val currentValue: T,
    )

    override suspend fun execute(params: Params<T>): Boolean {
        val maxValue = params.maxValue
        val minValue = params.minValue
        val currentValue = params.currentValue
        return currentValue > maxValue || currentValue < minValue
    }
}
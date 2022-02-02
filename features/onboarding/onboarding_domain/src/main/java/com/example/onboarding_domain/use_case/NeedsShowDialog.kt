package com.example.onboarding_domain.use_case

import com.example.use_case.UseCase
import kotlinx.coroutines.Dispatchers

abstract class NeedsShowDialog<T: Comparable<T>> :
    UseCase<NeedsShowDialog.Data<T>, Boolean>(Dispatchers.Default) {
    data class Data<T>(
        val dialogChecked: Boolean?,
        val maxValue: T,
        val minValue: T,
        val currentValue: T,
    )

    override suspend fun execute(params: Data<T>): Boolean {
        val dialogChecked = params.dialogChecked
        val maxValue = params.maxValue
        val minValue = params.minValue
        val currentValue = params.currentValue
        return dialogChecked?.let {
            it && !validCurrentValue(currentValue, maxValue, minValue)
        } ?: !validCurrentValue(currentValue, maxValue, minValue)
    }

    private fun validCurrentValue(currentValue: T, maxValue: T, minValue: T) =
        currentValue > maxValue || currentValue < minValue
}
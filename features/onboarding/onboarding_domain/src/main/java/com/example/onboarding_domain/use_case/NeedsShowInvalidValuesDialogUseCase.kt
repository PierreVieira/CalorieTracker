package com.example.onboarding_domain.use_case

import com.example.use_case.UseCase
import javax.inject.Inject

class NeedsShowInvalidValuesDialogUseCase<T : Comparable<T>> @Inject constructor(
    private val invalidCurrentValue: InvalidCurrentValueUseCase<T>
) : UseCase<NeedsShowInvalidValuesDialogUseCase.Params<T>, Boolean>() {

    data class Params<T>(
        val dialogChecked: Boolean?,
        val maxValue: T,
        val minValue: T,
        val currentValue: T,
    )

    override suspend fun execute(params: Params<T>): Boolean {
        val dialogChecked = params.dialogChecked
        val invalidCurrentValueParams = InvalidCurrentValueUseCase.Params(
            maxValue = params.maxValue,
            minValue = params.minValue,
            currentValue = params.currentValue
        )
        return dialogChecked?.let {
            it && invalidCurrentValue(invalidCurrentValueParams)
        } ?: invalidCurrentValue(invalidCurrentValueParams)
    }

}
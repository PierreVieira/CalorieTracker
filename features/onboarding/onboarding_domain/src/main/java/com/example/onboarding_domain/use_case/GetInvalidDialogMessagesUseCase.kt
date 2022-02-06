package com.example.onboarding_domain.use_case

import androidx.annotation.StringRes
import com.example.onboarding_domain.model.InvalidDialogMessages
import com.example.use_case.UseCase

class GetInvalidDialogMessagesUseCase<T : Comparable<T>> :
    UseCase<GetInvalidDialogMessagesUseCase.Params<T>, Pair<@StringRes Int, @StringRes Int>>() {
    data class Params<T>(
        val editTextValue: T,
        val minValue: T,
        val maxValue: T,
        val invalidDialogMessages: InvalidDialogMessages,
    )

    override suspend fun execute(params: Params<T>): Pair<Int, Int> {
        val editTextValue = params.editTextValue
        val minValue = params.minValue
        val maxValue = params.maxValue
        val invalidDialogMessages = params.invalidDialogMessages
        return when {
            editTextValue > maxValue -> invalidDialogMessages.titleHigh to invalidDialogMessages.messageHigh
            editTextValue < minValue -> invalidDialogMessages.titleLow to invalidDialogMessages.messageLow
            else -> throw IllegalStateException("Edit text value contains a valid value")
        }
    }
}
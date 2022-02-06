package com.example.onboarding_domain.model

import androidx.annotation.StringRes
import com.example.util.R

enum class InvalidDialogMessages(
    @StringRes val titleHigh: Int,
    @StringRes val titleLow: Int,
    @StringRes val messageHigh: Int,
    @StringRes val messageLow: Int,
    @StringRes val changeValue: Int
) {
    AGE(
        titleLow = R.string.low_age,
        titleHigh = R.string.high_age,
        messageLow = R.string.low_age_message,
        messageHigh = R.string.high_age_message,
        changeValue = R.string.change_age
    ),
    HEIGHT(
        titleLow = R.string.low_height,
        titleHigh = R.string.high_height,
        messageLow = R.string.low_height_message,
        messageHigh = R.string.high_height_message,
        changeValue = R.string.change_height
    ),
    WEIGHT(
        titleLow = R.string.low_weight,
        titleHigh = R.string.high_weight,
        messageLow = R.string.weight_low_message,
        messageHigh = R.string.weight_height_message,
        changeValue = R.string.change_weight
    )
}

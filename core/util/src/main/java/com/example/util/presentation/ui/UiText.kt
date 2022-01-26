package com.example.util.presentation.ui

import android.content.Context
import androidx.annotation.StringRes

sealed interface UiText {
    data class DynamicString(val text: String) : UiText
    data class StringResource(@StringRes val resourceId: Int) : UiText {
        fun asString(context: Context) = context.getString(resourceId)
    }
}
package com.example.util.presentation.ui.event

import com.example.util.presentation.ui.UiText
import com.example.util.presentation.ui.event.base.UiEvent

sealed interface AlertUiEvent: UiEvent {
    abstract class ShowSnackbar(val message: UiText): AlertUiEvent
    sealed interface Dialog: AlertUiEvent {
        abstract class Show(val title: UiText, val message: UiText): Dialog
        object ToggleCheck: Dialog
        object OkClick: Dialog
    }
}
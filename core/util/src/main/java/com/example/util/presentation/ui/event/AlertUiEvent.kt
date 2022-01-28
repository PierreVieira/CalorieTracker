package com.example.util.presentation.ui.event

import com.example.util.presentation.ui.UiText
import com.example.util.presentation.ui.event.base.UiEvent

interface AlertUiEvent: UiEvent {
    abstract class ShowSnackbar(val message: UiText): AlertUiEvent
}
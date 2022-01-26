package com.example.core.presentation

interface AlertUiEvent {
    abstract class ShowSnackbar(val message: UiText): AlertUiEvent
}
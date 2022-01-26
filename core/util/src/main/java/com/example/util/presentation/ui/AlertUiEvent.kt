package com.example.util.presentation.ui

interface AlertUiEvent {
    abstract class ShowSnackbar(val message: UiText): AlertUiEvent
}
package com.example.util.presentation.view_model

import com.example.util.presentation.ui.UiState
import com.example.util.presentation.ui.event.base.UiEvent

abstract class EventStateViewModel<P : UiEvent, Q : UiState>(
    firstState: Q
) : EventViewModel<P>() {

    private val stateView = StateView(firstState)
    val uiState = stateView.uiState

    protected fun updateUiState(updateBlock: (currentUiState: Q) -> Q) {
        stateView.updateUiState(updateBlock)
    }
}

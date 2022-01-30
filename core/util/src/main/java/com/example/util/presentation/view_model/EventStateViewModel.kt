package com.example.util.presentation.view_model

import com.example.util.presentation.ui.data.UiData
import com.example.util.presentation.ui.state.base.UiState
import com.example.util.presentation.ui.event.base.UiEvent
import com.example.util.presentation.view_model.observable.UiStateObservable

abstract class EventStateViewModel<DATA: UiData, EVENT : UiEvent, STATE : UiState<DATA>>(
    firstState: STATE
) : EventViewModel<EVENT>() {

    private val stateObservable = UiStateObservable(firstState)
    val uiState = stateObservable.uiState

    protected fun updateUiState(updateBlock: (currentUiState: STATE) -> STATE) {
        stateObservable.update(updateBlock)
    }
}

package com.example.util.presentation.view_model.data

import com.example.util.presentation.ui.event.base.UiEvent
import com.example.util.presentation.view_model.EventViewModel
import com.example.util.presentation.view_model.observable.base.ObservableFlow

abstract class EventDataViewModel<EVENT : UiEvent, DATA : Any> : EventViewModel<EVENT>() {

    protected abstract val dataObservable: ObservableFlow<DATA>

    val uiState get() = dataObservable.uiState

    protected fun updateUiData(updateBlock: (currentUiData: DATA) -> DATA) {
        dataObservable.update(updateBlock)
    }

}
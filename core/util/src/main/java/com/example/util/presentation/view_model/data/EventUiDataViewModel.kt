package com.example.util.presentation.view_model.data

import com.example.util.presentation.ui.data.UiData
import com.example.util.presentation.ui.event.base.UiEvent
import com.example.util.presentation.view_model.observable.UiDataObservable

abstract class EventUiDataViewModel<EVENT : UiEvent, DATA : UiData>(
    firstValue: DATA
) : EventDataViewModel<EVENT, DATA>() {
    override val dataObservable = UiDataObservable(firstValue)
}
package com.example.util.presentation.view_model.data

import com.example.util.presentation.ui.event.base.UiEvent
import com.example.util.presentation.view_model.observable.SingleDataObservable

abstract class EventSingleDataViewModel<EVENT : UiEvent, DATA : Any>(
    firstValue: DATA
) : EventDataViewModel<EVENT, DATA>() {
    override val dataObservable = SingleDataObservable(firstValue)
    fun updateUiValue(newValue: DATA) = super.updateUiData { newValue }
}
package com.example.util.presentation.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.util.presentation.ui.event.base.UiEvent
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

abstract class EventViewModel<EVENT : UiEvent> : ViewModel() {
    private val _uiEvent = Channel<EVENT>()
    val uiEvent = _uiEvent.receiveAsFlow()
    protected fun sendEvent(event: EVENT) {
        viewModelScope.launch {
            _uiEvent.send(event)
        }
    }
}

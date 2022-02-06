package com.example.util.presentation.view_model.observable

import com.example.util.presentation.ui.state.base.UiState
import com.example.util.presentation.view_model.observable.base.ObservableFlow

class UiStateObservable<STATE : UiState>(firstState: STATE) :
    ObservableFlow<STATE>(firstState)
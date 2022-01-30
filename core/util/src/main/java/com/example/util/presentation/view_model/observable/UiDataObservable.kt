package com.example.util.presentation.view_model.observable

import com.example.util.presentation.ui.data.UiData
import com.example.util.presentation.view_model.observable.base.ObservableFlow

class UiDataObservable<DATA : UiData>(firstData: DATA) : ObservableFlow<DATA>(firstData)
package com.example.util.presentation.view_model.observable

import com.example.util.presentation.view_model.observable.base.ObservableFlow

class SingleDataObservable<T: Any>(firstValue: T) : ObservableFlow<T>(firstValue)
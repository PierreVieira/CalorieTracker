package com.example.onboarding_presentation.screens.welcome

import com.example.onboarding_presentation.screens.welcome.ui.WelcomeUiEvent
import com.example.util.presentation.view_model.EventViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WelcomeViewModel @Inject constructor() : EventViewModel<WelcomeUiEvent>() {

    fun onNextClick() {
        sendEvent(WelcomeUiEvent.NavigateToGender)
    }
}
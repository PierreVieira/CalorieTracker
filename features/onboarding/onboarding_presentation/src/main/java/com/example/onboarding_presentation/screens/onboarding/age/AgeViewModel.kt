package com.example.onboarding_presentation.screens.onboarding.age

import com.example.util.domain.preferences.Preferences
import com.example.util.domain.use_case.FilterOutDigits
import com.example.util.presentation.view_model.EventStateViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AgeViewModel @Inject constructor(
    private val preferences: Preferences,
    private val filterOutDigits: FilterOutDigits
) : EventStateViewModel<AgeUiEvent, AgeUiState>(AgeUiState(age = "${preferences.getAge()}")) {

    companion object {
        private const val MAX_AGE = 120
    }

    fun onAgeEnter(age: String) {
        updateUiState {
            it.copy(
                age = filterOutDigits(
                    text = age,
                    maxValue = MAX_AGE
                )
            )
        }
        sendEvent(AgeUiEvent.AgeEnter)
    }

    fun onNextClick() {
        val age = uiState.value.age
        age.toIntOrNull()?.let {
            saveAge(it)
            sendEvent(AgeUiEvent.NavigateToNext)
        } ?: sendEvent(AgeUiEvent.ShowInvalidAgeSnackBar)
    }

    fun onBackClick() {
        val age = uiState.value.age.toIntOrNull() ?: 0
        saveAge(age)
        sendEvent(AgeUiEvent.NavigateToBack)
    }

    private fun saveAge(age: Int) {
        preferences.saveAge(age)
    }
}
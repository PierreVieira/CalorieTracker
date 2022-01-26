package com.example.onboarding_presentation.screens.age

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.domain.preferences.Preferences
import com.example.core.domain.use_case.FilterOutDigits
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AgeViewModel @Inject constructor(
    private val preferences: Preferences,
    private val filterOutDigits: FilterOutDigits
) : ViewModel() {

    companion object {
        private const val MAX_AGE = 120
    }

    private val _uiState = MutableStateFlow(
        AgeUiState(age = "${preferences.getAge()}")
    )
    val uiState: StateFlow<AgeUiState> = _uiState

    private val _uiEvent = Channel<AgeUiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun onAgeEnter(age: String) {
        _uiState.update {
            it.copy(
                age = filterOutDigits(
                    text = age,
                    maxValue = MAX_AGE
                )
            )
        }
        viewModelScope.launch {
            _uiEvent.send(AgeUiEvent.AgeEnter)
        }
    }

    fun onNextClick() {
        val age = uiState.value.age
        viewModelScope.launch {
            age.toIntOrNull()?.let {
                saveAge(it)
                _uiEvent.send(AgeUiEvent.NavigateToNext)
            } ?: _uiEvent.send(AgeUiEvent.ShowInvalidAgeSnackBar)
        }
    }

    fun onBackClick() {
        val age = uiState.value.age.toIntOrNull() ?: 0
        saveAge(age)
        viewModelScope.launch {
            _uiEvent.send(AgeUiEvent.NavigateToBack)
        }
    }

    private fun saveAge(age: Int) {
        preferences.saveAge(age)
    }
}
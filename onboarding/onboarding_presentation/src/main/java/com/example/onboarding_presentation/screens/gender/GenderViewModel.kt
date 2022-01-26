package com.example.onboarding_presentation.screens.gender

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.domain.model.Gender
import com.example.core.domain.preferences.Preferences
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GenderViewModel @Inject constructor(
    private val preferences: Preferences
) : ViewModel() {

    private val _uiState = MutableStateFlow(
        GenderUiState(
            Gender.MALE
        )
    )

    val uiState: StateFlow<GenderUiState> = _uiState

    private val _uiEvent = Channel<GenderUiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun onGenderClick(gender: Gender) {
        _uiState.update {
            it.copy(selectedGender = gender)
        }
        viewModelScope.launch {
            _uiEvent.send(GenderUiEvent.SelectGender(gender))
        }
    }

    fun onNextClick() {
        viewModelScope.launch {
            preferences.saveGender(uiState.value.selectedGender)
            _uiEvent.send(GenderUiEvent.NavigateToNext)
        }
    }
}
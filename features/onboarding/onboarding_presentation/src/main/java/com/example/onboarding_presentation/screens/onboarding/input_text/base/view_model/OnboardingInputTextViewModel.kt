package com.example.onboarding_presentation.screens.onboarding.input_text.base.view_model

import androidx.lifecycle.viewModelScope
import com.example.onboarding_domain.model.InvalidDialogMessages
import com.example.onboarding_domain.model.OnboardingConstValues
import com.example.onboarding_domain.use_case.GetInvalidDialogMessagesUseCase
import com.example.onboarding_domain.use_case.NeedsShowInvalidValuesDialogUseCase
import com.example.onboarding_domain.use_case.OnboardingUseCases
import com.example.onboarding_presentation.screens.onboarding.input_text.base.ui.OnboardingDialogUiData
import com.example.onboarding_presentation.screens.onboarding.input_text.base.ui.OnboardingInputTextUiEvent
import com.example.onboarding_presentation.screens.onboarding.input_text.base.ui.OnboardingInputTextUiState
import com.example.onboarding_presentation.screens.onboarding.input_text.base.ui.model.base.OnboardingUiEventsModel
import com.example.util.presentation.view_model.EventStateViewModel
import kotlinx.coroutines.launch
import com.example.util.R

abstract class OnboardingInputTextViewModel<VALUE_TYPE : Comparable<VALUE_TYPE>>(
    firstData: VALUE_TYPE,
    private val onboardingConstValues: OnboardingConstValues<VALUE_TYPE>,
    private val useCases: OnboardingUseCases<VALUE_TYPE>,
    private val invalidDialogMessages: InvalidDialogMessages,
    private val uiEvents: OnboardingUiEventsModel,
) : EventStateViewModel<OnboardingInputTextUiEvent, OnboardingInputTextUiState>(
    firstState = OnboardingInputTextUiState(
        editTextValue = "$firstData",
        dialogUiData = null,
        showDialog = false,
        editTextFocused = false
    )
) {
    fun onValueEnter(value: String) {
        viewModelScope.launch {
            val newValue = useCases.filterOutDigits(value)
            updateUiState {
                it.copy(
                    editTextValue = newValue,
                    editTextFocused = true
                )
            }
        }
        sendEvent(uiEvents.valueEnterEvent)
    }

    fun onNextClick() {
        uiValueToValue()?.let { editTextValue ->
            dialogValidation(editTextValue, uiEvents.toNextEvent)
        } ?: run {
            updateUiState {
                it.copy(editTextFocused = true)
            }
            sendEvent(uiEvents.invalidSnackbarEvent)
        }
    }

    fun onBackClick() {
        val value = uiValueToValue() ?: onboardingConstValues.default
        dialogValidation(value, uiEvents.toBackEvent)
    }

    fun onToggleDialogCheck() {
        updateUiState { state ->
            state.dialogUiData?.let { dialogData ->
                val newCheckedStatus = !dialogData.checked
                state.copy(
                    dialogUiData = dialogData.copy(
                        checked = newCheckedStatus,
                        buttonMessage = if (newCheckedStatus) R.string.next
                        else invalidDialogMessages.changeValue
                    )
                )
            } ?: state
        }
        sendEvent(OnboardingInputTextUiEvent.Dialog.ToggleCheck)
    }

    fun onDismissRequest() {
        hideDialog()
        sendEvent(OnboardingInputTextUiEvent.Dialog.Dismiss)
    }

    fun onDialogButtonClick() {
        val boxChecked = uiState.value.dialogUiData?.checked == true
        sendEvent(OnboardingInputTextUiEvent.Dialog.ButtonClick)
        if (boxChecked) {
            sendEvent(uiEvents.toNextEvent)
        } else {
            hideDialog()
            changeFocusState(true)
            sendEvent(uiEvents.moveFocus)
        }
    }

    fun changeFocusState(isFocused: Boolean) {
        updateUiState {
            it.copy(editTextFocused = isFocused)
        }
    }

    private fun hideDialog() {
        updateUiState {
            it.copy(showDialog = false)
        }
    }

    private fun dialogValidation(
        editTextValue: VALUE_TYPE,
        navigationUiEvent: OnboardingInputTextUiEvent,
    ) {
        val dialogData = uiState.value.dialogUiData
        viewModelScope.launch {
            val needsShowDialog = useCases.needsShowInvalidValuesDialog(
                NeedsShowInvalidValuesDialogUseCase.Params(
                    maxValue = onboardingConstValues.max,
                    minValue = onboardingConstValues.min,
                    dialogChecked = dialogData?.checked,
                    currentValue = editTextValue
                )
            )
            if (needsShowDialog) {
                showDialog(editTextValue)
            } else {
                saveValue(editTextValue)
                sendEvent(navigationUiEvent)
            }
        }
    }

    private fun showDialog(editTextValue: VALUE_TYPE) {
        viewModelScope.launch {
            val (title, message) = getDialogMessages(editTextValue)
            updateUiState {
                it.copy(
                    showDialog = true,
                    dialogUiData = OnboardingDialogUiData(
                        title = title,
                        message = message,
                        buttonMessage = invalidDialogMessages.changeValue,
                        checked = false
                    )
                )
            }
        }
        sendEvent(OnboardingInputTextUiEvent.Dialog.Show)
    }

    private suspend fun getDialogMessages(editTextValue: VALUE_TYPE) = useCases.getInvalidDialogMessages(
        GetInvalidDialogMessagesUseCase.Params(
            editTextValue = editTextValue,
            minValue = onboardingConstValues.min,
            maxValue = onboardingConstValues.max,
            invalidDialogMessages = invalidDialogMessages
        )
    )

    protected abstract fun saveValue(value: VALUE_TYPE)
    protected abstract fun uiValueToValue(): VALUE_TYPE?
}
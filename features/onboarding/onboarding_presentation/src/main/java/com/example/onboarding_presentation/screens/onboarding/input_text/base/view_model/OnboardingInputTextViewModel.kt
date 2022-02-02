package com.example.onboarding_presentation.screens.onboarding.input_text.base.view_model

import androidx.lifecycle.viewModelScope
import com.example.onboarding_domain.model.InvalidDialogMessages
import com.example.onboarding_domain.model.OnboardingConstValues
import com.example.onboarding_domain.use_case.NeedsShowDialog
import com.example.onboarding_domain.use_case.models.OnboardingUseCases
import com.example.onboarding_presentation.screens.onboarding.input_text.base.ui.OnboardingDialogUiData
import com.example.onboarding_presentation.screens.onboarding.input_text.base.ui.OnboardingInputTextUiData
import com.example.onboarding_presentation.screens.onboarding.input_text.base.ui.OnboardingInputTextUiEvent
import com.example.onboarding_presentation.screens.onboarding.input_text.base.ui.OnboardingInputTextUiState
import com.example.onboarding_presentation.screens.onboarding.input_text.base.ui.model.base.OnboardingUiEventsModel
import com.example.util.presentation.view_model.EventStateViewModel
import kotlinx.coroutines.launch

@Suppress("UNCHECKED_CAST")
abstract class OnboardingInputTextViewModel<VALUE_TYPE : Comparable<VALUE_TYPE>>(
    firstData: VALUE_TYPE,
    private val onboardingConstValues: OnboardingConstValues<VALUE_TYPE>,
    private val useCases: OnboardingUseCases<VALUE_TYPE>,
    private val invalidDialogMessages: InvalidDialogMessages,
    private val uiEvents: OnboardingUiEventsModel,
) : EventStateViewModel<OnboardingInputTextUiData, OnboardingInputTextUiEvent, OnboardingInputTextUiState>(
    firstState = OnboardingInputTextUiState(
        data = OnboardingInputTextUiData(
            editTextValue = "$firstData",
            dialogUiData = null
        ),
        showDialog = false
    )
) {
    fun onValueEnter(value: String) {
        viewModelScope.launch {
            val newValue = useCases.filterOutDigits(value)
            updateUiState { state ->
                val newData = state.data.copy(editTextValue = newValue)
                state.copy(data = newData)
            }
        }
        sendEvent(uiEvents.valueEnterEvent)
    }

    fun onNextClick() {
        uiValueToValue()?.let { editTextValue ->
            dialogValidation(editTextValue, uiEvents.toNextEvent)
        } ?: sendEvent(uiEvents.invalidSnackbarEvent)
    }

    fun onBackClick() {
        val value = uiValueToValue() ?: onboardingConstValues.default
        dialogValidation(value, uiEvents.toBackEvent)
    }

    fun onToggleDialogCheck() {
        updateUiState {
            val data = it.data
            val dialogUiData = data.dialogUiData
            it.copy(
                data = data.copy(
                    dialogUiData = dialogUiData?.copy(
                        checked = !dialogUiData.checked
                    )
                )
            )
        }
        sendEvent(OnboardingInputTextUiEvent.Dialog.ToggleCheck)
    }

    fun onDismissRequest() {
        hideDialog()
        sendEvent(OnboardingInputTextUiEvent.Dialog.Dismiss)
    }

    fun onDialogButtonClick() {
        val boxChecked = uiState.value.data.dialogUiData?.checked == true
        sendEvent(OnboardingInputTextUiEvent.Dialog.ButtonClick)
        if (boxChecked) {
            sendEvent(uiEvents.toNextEvent)
        } else {
            hideDialog()
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
        val dialogData = uiState.value.data.dialogUiData
        viewModelScope.launch {
            val needsShowDialog = useCases.needsShowDialog(
                NeedsShowDialog.Data(
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
        val (title, message) = getDialogMessages(
            editTextValue = editTextValue,
            maxValue = onboardingConstValues.max
        )
        updateUiState {
            val data = it.data
            it.copy(
                showDialog = true,
                data = data.copy(
                    dialogUiData = OnboardingDialogUiData(
                        title = title,
                        message = message,
                        buttonMessage = invalidDialogMessages.changeValue,
                        checked = false
                    )
                )
            )
        }
        sendEvent(OnboardingInputTextUiEvent.Dialog.Show)
    }

    private fun getDialogMessages(
        editTextValue: VALUE_TYPE,
        maxValue: VALUE_TYPE,
    ): Pair<Int, Int> = if (editTextValue > maxValue)
        invalidDialogMessages.titleHigh to invalidDialogMessages.titleLow
    else invalidDialogMessages.messageHigh to invalidDialogMessages.messageLow

    protected abstract fun saveValue(value: VALUE_TYPE)
    protected abstract fun uiValueToValue(): VALUE_TYPE?
}
package com.example.onboarding_presentation.screens.onboarding.input_text.base

import androidx.annotation.StringRes
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalContext
import com.example.onboarding_presentation.screens.onboarding.input_text.base.components.UnitEditTextField
import com.example.onboarding_presentation.screens.onboarding.BaseOnboardScreen
import com.example.onboarding_presentation.screens.onboarding.input_text.base.components.InvalidValuesDialog
import com.example.onboarding_presentation.screens.onboarding.input_text.base.ui.OnboardingInputTextUiEvent
import com.example.onboarding_presentation.screens.onboarding.input_text.base.view_model.OnboardingInputTextViewModel
import com.example.util.presentation.ui.UiText
import com.example.util.presentation.ui.event.AlertUiEvent
import com.example.util.presentation.ui.event.NavigationUiEvent
import kotlinx.coroutines.flow.collectLatest

@ExperimentalComposeUiApi
@Composable
fun <VALUE_TYPE : Comparable<VALUE_TYPE>> OnboardingInputTextScreen(
    viewModel: OnboardingInputTextViewModel<VALUE_TYPE>,
    scaffoldState: ScaffoldState,
    @StringRes appBarTitleResourceId: Int,
    @StringRes questionResourceId: Int,
    @StringRes unitTextResourceId: Int,
    onNavigate: (NavigationUiEvent.Navigate) -> Unit,
    onBackClick: (NavigationUiEvent.NavigateUp) -> Unit

) {
    val context = LocalContext.current
    val uiState by viewModel.uiState.collectAsState()
    val dialogData = uiState.dialogUiData
    LaunchedEffect(key1 = true) {
        viewModel.uiEvent.collectLatest { uiEvent: OnboardingInputTextUiEvent ->
            when (uiEvent) {
                is NavigationUiEvent.Navigate -> onNavigate(uiEvent)
                is NavigationUiEvent.NavigateUp -> onBackClick(uiEvent)
                is AlertUiEvent.ShowSnackbar -> {
                    val message = (uiEvent.message as UiText.StringResource).asString(context)
                    scaffoldState.snackbarHostState.showSnackbar(message)
                }
                else -> {}
            }
        }
    }
    BaseOnboardScreen(
        appBarTitleResource = appBarTitleResourceId,
        questionResource = questionResourceId,
        onNextClick = viewModel::onNextClick,
        onBackClick = viewModel::onBackClick
    ) {
        UnitEditTextField(
            value = uiState.editTextValue,
            focused = uiState.editTextFocused,
            unitId = unitTextResourceId,
            onValueChange = viewModel::onValueEnter,
            changeFocusState = {}
        )
        if (dialogData != null && uiState.showDialog) {
            InvalidValuesDialog(
                title = dialogData.title,
                message = dialogData.message,
                buttonText = dialogData.buttonMessage,
                checkBoxIsChecked = dialogData.checked,
                onCheckChange = viewModel::onToggleDialogCheck,
                onDismissRequest = viewModel::onDismissRequest,
                buttonClick = viewModel::onDialogButtonClick
            )
        }
    }
}
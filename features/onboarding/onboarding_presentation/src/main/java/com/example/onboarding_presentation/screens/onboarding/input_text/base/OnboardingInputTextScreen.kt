package com.example.onboarding_presentation.screens.onboarding.input_text.base

import android.content.Context
import androidx.annotation.StringRes
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalContext
import com.example.onboarding_presentation.components.UnitEditTextField
import com.example.onboarding_presentation.screens.onboarding.BaseOnboardScreen
import com.example.onboarding_presentation.screens.onboarding.input_text.base.view_model.OnboardingInputTextViewModel
import com.example.util.presentation.ui.UiText
import com.example.util.presentation.ui.event.AlertUiEvent
import com.example.util.presentation.ui.event.NavigationUiEvent
import kotlinx.coroutines.flow.collectLatest

@ExperimentalComposeUiApi
@Composable
fun <EVENT : OnboardingInputTextUiEvent, VALUE_TYPE : Any> OnboardingInputTextScreen(
    viewModel: OnboardingInputTextViewModel<EVENT, VALUE_TYPE>,
    scaffoldState: ScaffoldState,
    @StringRes appBarTitleResourceId: Int,
    @StringRes questionResourceId: Int,
    @StringRes unitTextResourceId: Int,
    onNavigate: (NavigationUiEvent.Navigate) -> Unit,
    onBackClick: (NavigationUiEvent.NavigateUp) -> Unit

) {
    val context = LocalContext.current
    val uiData by viewModel.uiState.collectAsState()
    LaunchedEffect(key1 = true) {
        viewModel.uiEvent.collectLatest { uiEvent ->
            when (uiEvent) {
                is NavigationUiEvent.Navigate -> onNavigate(uiEvent)
                is NavigationUiEvent.NavigateUp -> onBackClick(uiEvent)
                is AlertUiEvent.ShowSnackbar -> {
                    val message = (uiEvent.message as UiText.StringResource).asString(context)
                    scaffoldState.snackbarHostState.showSnackbar(message)
                }
                is AlertUiEvent.Dialog.Show -> {
                    val title = (uiEvent.title as UiText.StringResource).asString(context)
                    val message = (uiEvent.message as UiText.StringResource).asString(context)
                }
                /*is AlertUiEvent.Dialog.ToggleCheck -> {

                }
                is AlertUiEvent.Dialog.OkClick -> {

                }*/
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
            value = uiData,
            unitId = unitTextResourceId,
            onValueChange = viewModel::onValueEnter
        )
    }
}
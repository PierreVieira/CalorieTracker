package com.example.onboarding_presentation.screens.onboarding.age

import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.onboarding_presentation.components.UnitTextField
import com.example.onboarding_presentation.screens.onboarding.BaseOnboardScreen
import com.example.util.R
import com.example.util.presentation.ui.UiText
import com.example.util.presentation.ui.event.AlertUiEvent
import com.example.util.presentation.ui.event.NavigationUiEvent
import kotlinx.coroutines.flow.collect

@Composable
fun AgeScreen(
    scaffoldState: ScaffoldState,
    onNavigate: (NavigationUiEvent.Navigate) -> Unit,
    onBackClick: (NavigationUiEvent.NavigateUp) -> Unit,
    viewModel: AgeViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val uiState by viewModel.uiState.collectAsState()
    LaunchedEffect(key1 = true) {
        viewModel.uiEvent.collect { uiEvent ->
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
    AgeScreen(
        age = uiState.age,
        onNextClick = viewModel::onNextClick,
        onAgeEnter = viewModel::onAgeEnter,
        onBackClick = viewModel::onBackClick
    )
}

@Composable
private fun AgeScreen(
    age: String,
    onAgeEnter: (String) -> Unit,
    onNextClick: () -> Unit,
    onBackClick: () -> Unit,
) {
    BaseOnboardScreen(
        appBarTitleResource = R.string.age,
        questionResource = R.string.whats_your_age,
        onNextClick = onNextClick,
        onBackClick = onBackClick
    ) {
        UnitTextField(
            value = age,
            unitId = R.string.years,
            onValueChange = onAgeEnter
        )
    }
}
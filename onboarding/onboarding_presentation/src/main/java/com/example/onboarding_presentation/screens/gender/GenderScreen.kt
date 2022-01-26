package com.example.onboarding_presentation.screens.gender

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.core.R
import com.example.core.domain.model.Gender
import com.example.core.presentation.NavigationUiEvent
import com.example.core_ui.presentation.components.spacers.HorizontalSpacer
import com.example.core_ui.presentation.components.spacers.VerticalSpacer
import com.example.core_ui.presentation.theme.LocalSpacing
import com.example.onboarding_presentation.components.buttons.ActionButton
import com.example.onboarding_presentation.screens.base.BaseOnboardScreen
import com.example.onboarding_presentation.screens.gender.components.GenderButton
import kotlinx.coroutines.flow.collect

@Composable
fun GenderScreen(
    onNavigate: (NavigationUiEvent.Navigate) -> Unit,
    onBackClick: (NavigationUiEvent.NavigateUp) -> Unit,
    viewModel: GenderViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    LaunchedEffect(key1 = true) {
        viewModel.uiEvent.collect { uiEvent ->
            when(uiEvent) {
                is NavigationUiEvent.Navigate -> onNavigate(uiEvent)
                is NavigationUiEvent.NavigateUp -> onBackClick(uiEvent)
                else -> {}
            }
        }
    }
    GenderScreen(
        selectedGender = uiState.selectedGender,
        onGenderClick = { viewModel.onGenderClick(it.gender) },
        onNextClick = viewModel::onNextClick,
        onBackClick = viewModel::onBackClick
    )
}

@Composable
private fun GenderScreen(
    selectedGender: Gender,
    onGenderClick: (GenderUiEvent.SelectGender) -> Unit,
    onNextClick: () -> Unit,
    onBackClick: () -> Unit,
) {
    BaseOnboardScreen(
        appBarTitleResource = R.string.gender,
        questionResource = R.string.whats_your_gender,
        onNextClick = onNextClick,
        onBackClick = onBackClick
    ) {
        Row {
            GenderButton(
                gender = Gender.MALE,
                selectedGender = selectedGender,
                onGenderClick = onGenderClick
            )
            HorizontalSpacer()
            GenderButton(
                gender = Gender.FEMALE,
                selectedGender = selectedGender,
                onGenderClick = onGenderClick
            )
        }
    }
}
package com.example.onboarding_presentation.screens.welcome

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.util.R
import com.example.util.presentation.ui.event.NavigationUiEvent
import com.example.ui.presentation.components.spacers.VerticalSpacer
import com.example.ui.presentation.theme.LocalSpacing
import com.example.onboarding_presentation.components.ActionButton
import kotlinx.coroutines.flow.collect

@Composable
fun WelcomeScreen(
    onNavigate: (NavigationUiEvent.Navigate) -> Unit,
    viewModel: WelcomeViewModel = hiltViewModel()
) {
    LaunchedEffect(key1 = true) {
        viewModel.uiEvent.collect { uiEvent ->
            when(uiEvent) {
                is NavigationUiEvent.Navigate -> onNavigate(uiEvent)
                else -> {}
            }
        }
    }
    WelcomeScreen(viewModel::onNextClick)
}

@Composable
private fun WelcomeScreen(onNavigate: () -> Unit) {
    val spacing = LocalSpacing.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(spacing.medium),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.welcome_text),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h1
        )
        VerticalSpacer()
        ActionButton(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            text = stringResource(id = R.string.next),
            onClick = onNavigate
        )
    }
}
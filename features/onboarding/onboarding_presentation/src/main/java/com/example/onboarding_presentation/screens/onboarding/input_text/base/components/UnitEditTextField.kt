package com.example.onboarding_presentation.screens.onboarding.input_text.base.components

import androidx.annotation.StringRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.layout.LastBaseline
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.ui.presentation.theme.CalorieTrackerTheme
import com.example.ui.presentation.theme.LocalSpacing
import com.example.util.R

@ExperimentalComposeUiApi
@Composable
fun UnitEditTextField(
    value: String,
    @StringRes unitId: Int,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = TextStyle(
        color = MaterialTheme.colors.primaryVariant,
        fontSize = 70.sp
    ),
    focused: Boolean,
    changeFocusState: (Boolean) -> Unit
) {
    val spacing = LocalSpacing.current
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManger = LocalFocusManager.current
    val interactionSource = remember { MutableInteractionSource() }
    val focusRequester = remember { FocusRequester() }
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        BasicTextField(
            modifier = Modifier
                .width(IntrinsicSize.Min)
                .alignBy(LastBaseline)
                .focusRequester(focusRequester)
            ,
            value = value,
            onValueChange = onValueChange,
            textStyle = textStyle,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            ),
            singleLine = true,
            keyboardActions = KeyboardActions(
                onDone = {
                    changeFocusState(false)
                    keyboardController?.hide()
                    focusManger.clearFocus()
                }
            )
        )
        Text(
            modifier = Modifier
                .alignBy(LastBaseline)
                .padding(spacing.small)
                .clickable(
                    indication = null,
                    interactionSource = interactionSource,
                    onClick = {
                        changeFocusState(true)
                    }
                ),
            text = stringResource(id = unitId)
        )
    }
    LaunchedEffect(key1 = Unit) {
        if (focused) {
            keyboardController?.show()
            focusRequester.requestFocus()
        }
    }
}

@ExperimentalComposeUiApi
@Composable
@Preview(showBackground = true)
private fun UnitTextFieldPreview() {
    CalorieTrackerTheme {
        UnitEditTextField(
            value = "20",
            unitId = R.string.years,
            onValueChange = {},
            focused = false,
            changeFocusState = {}
        )
    }
}
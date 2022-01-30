package com.example.onboarding_presentation.components

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.LastBaseline
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.ui.presentation.components.spacers.HorizontalSpacer
import com.example.ui.presentation.theme.CalorieTrackerTheme
import com.example.ui.presentation.theme.LocalSpacing
import com.example.util.R

@ExperimentalComposeUiApi
@Composable
fun UnitTextField(
    value: String,
    @StringRes unitId: Int,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = TextStyle(
        color = MaterialTheme.colors.primaryVariant,
        fontSize = 70.sp
    )
) {
    val spacing = LocalSpacing.current
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManger = LocalFocusManager.current
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center
    ) {
        BasicTextField(
            modifier = Modifier
                .width(IntrinsicSize.Min)
                .alignBy(LastBaseline),
            value = value,
            onValueChange = onValueChange,
            textStyle = textStyle,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            ),
            singleLine = true,
            keyboardActions = KeyboardActions(
                onDone = {
                    keyboardController?.hide()
                    focusManger.clearFocus()
                }
            )
        )
        HorizontalSpacer(spacing.small)
        Text(
            modifier = Modifier.alignBy(LastBaseline),
            text = stringResource(id = unitId)
        )
    }
}

@ExperimentalComposeUiApi
@Composable
@Preview(showBackground = true)
private fun UnitTextFieldPreview() {
    CalorieTrackerTheme {
        UnitTextField(
            value = "20",
            unitId = R.string.years,
            onValueChange = {}
        )
    }
}
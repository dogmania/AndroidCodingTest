package com.example.androidcodingtest.screens.component

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp

@Composable
fun MultiLineInputTextField(
    placeHolder: String = "",
    saveEventHandler: (String) -> Unit = {}
) {
    val text = remember { mutableStateOf("") }

    TextField(
        value = text.value,
        onValueChange = {
            text.value = it
            saveEventHandler(it)
        },
        modifier = Modifier
            .fillMaxSize(),
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = Color.Transparent,
            focusedContainerColor = Color.Transparent,
            unfocusedIndicatorColor = Color.LightGray,
            focusedIndicatorColor = Color.LightGray
        ),
        placeholder = { Text(text = placeHolder) },
        singleLine = false,
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Default
        ),
        keyboardActions = KeyboardActions.Default,
        maxLines = Int.MAX_VALUE
    )
}
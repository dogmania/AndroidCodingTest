package com.example.androidcodingtest.screens.createtask

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun CreateTaskScreen() {
    val viewModel: CreateTaskViewModel = hiltViewModel()

    CreateTaskContent()
}

@Composable
fun CreateTaskContent() {

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CreateTaskPreview() {
    CreateTaskContent()
}
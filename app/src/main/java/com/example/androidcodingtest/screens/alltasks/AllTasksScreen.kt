package com.example.androidcodingtest.screens.alltasks

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun AllTasksScreen() {
    val viewModel: AllTasksViewModel = hiltViewModel()

    AllTasksContent()
}

@Composable
fun AllTasksContent() {
    
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AllTasksPreview() {
    AllTasksContent()
}
package com.example.androidcodingtest.screens.alltasks

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.androidcodingtest.ui.theme.Main

@Composable
fun AllTasksScreen(
    goToCreateTaskScreen: () -> Unit = {}
) {
    val viewModel: AllTasksViewModel = hiltViewModel()

    AllTasksContent(
        goToCreateTaskScreen = goToCreateTaskScreen
    )
}

@Composable
fun AllTasksContent(
    goToCreateTaskScreen: () -> Unit = {}
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        IconButton(
            onClick = {
                goToCreateTaskScreen()
            },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .size(80.dp)
                .padding(10.dp),
            colors = IconButtonDefaults.iconButtonColors(
                containerColor = Main,
                contentColor = Color.White,
                disabledContentColor = Color.Unspecified,
                disabledContainerColor = Color.Unspecified
            )
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "createTask"
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AllTasksPreview() {
    AllTasksContent()
}
package com.example.androidcodingtest.screens.taskdetail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun TaskDetailScreen(
    id: String,
    popScreen: () -> Unit
) {
    val viewModel: TaskDetailViewModel = hiltViewModel()
    val uiState = viewModel.uiState.collectAsState()

    LaunchedEffect(key1 = Unit) {
        viewModel.getTask(id)
    }

    TaskDetailContent(
        title = uiState.value.title,
        content = uiState.value.content,
        status = uiState.value.status,
        popScreen = popScreen
    )
}

@Composable
fun TaskDetailContent(
    title: String = "",
    content: String = "",
    status: String = "",
    popScreen: () -> Unit = {}
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            TaskDetailTopBar(
                popScreen = popScreen,
                status = status
            )

            Text(
                text = title,
                modifier = Modifier.padding(15.dp)
            )

            HorizontalDivider()

            Text(
                text = content,
                modifier = Modifier.padding(15.dp)
            )
        }
    }
}

@Composable
fun TaskDetailTopBar(
    popScreen: () -> Unit = {},
    status: String = ""
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        IconButton(
            onClick = { popScreen() },
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(5.dp)
        ) {
            Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "")
        }

        Text(
            text = "작업 상태: $status",
            modifier = Modifier
                .align(Alignment.Center)
                .padding(5.dp),
            fontWeight = FontWeight.Bold
        )

        HorizontalDivider(modifier = Modifier.align(Alignment.BottomCenter))
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TaskDetailPreview() {
    TaskDetailContent()
}
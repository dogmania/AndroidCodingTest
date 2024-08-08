package com.example.androidcodingtest.screens.alltasks

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.androidcodingtest.Task
import com.example.androidcodingtest.ui.theme.Main

@Composable
fun AllTasksScreen(
    goToCreateTaskScreen: () -> Unit = {}
) {
    val viewModel: AllTasksViewModel = hiltViewModel()
    val uiState = viewModel.uiState.collectAsState()

    LaunchedEffect(key1 = Unit) {
        viewModel.getAllTasks()
    }

    AllTasksContent(
        goToCreateTaskScreen = goToCreateTaskScreen,
        tasks = uiState.value.taskList
    )
}

@Composable
fun AllTasksContent(
    goToCreateTaskScreen: () -> Unit = {},
    tasks: List<Task> = emptyList()
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column {
            AllTasksScreenTopBar()

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                items(tasks) { task ->
                    TaskItem(title = task.title, status = task.status, content = task.content)
                }
            }
        }

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

@Composable
fun AllTasksScreenTopBar() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = "작업 목록",
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            textAlign = TextAlign.Center,
            style = TextStyle(
                fontWeight = FontWeight.Bold
            ),
            fontSize = 20.sp
        )
        HorizontalDivider()
    }
}

@Composable
fun TaskItem(
    title: String = "",
    status: String = "",
    content: String = ""
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(10.dp)
        ) {
            Text(
                text = title,
                style = TextStyle(
                    fontWeight = FontWeight.Bold
                ),
                fontSize = 15.sp,
                maxLines = 1
            )

            Text(
                text = content,
                maxLines = 2
            )

            Text(
                text = status,
                fontSize = 10.sp
            )
        }

        HorizontalDivider()
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AllTasksPreview() {
    AllTasksContent()
}
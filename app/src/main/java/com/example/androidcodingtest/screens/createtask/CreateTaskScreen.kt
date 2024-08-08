package com.example.androidcodingtest.screens.createtask

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.Operation
import androidx.work.WorkManager
import androidx.work.workDataOf
import com.example.androidcodingtest.screens.component.MultiLineInputTextField
import com.example.androidcodingtest.screens.component.SingleLineInputTextField
import com.example.androidcodingtest.ui.theme.Main
import com.example.androidcodingtest.worker.TaskWorker
import java.util.UUID

@Composable
fun CreateTaskScreen(
    popScreen: () -> Unit
) {
    val viewModel: CreateTaskViewModel = hiltViewModel()
    val title = remember { mutableStateOf("") }
    val content = remember { mutableStateOf("") }
    val onClickBtnCreate: () -> Unit = {
        val taskId = UUID.randomUUID().toString()

        viewModel.createTask(id = taskId, title = title.value, content = content.value)

        val workRequest = OneTimeWorkRequestBuilder<TaskWorker>()
            .setInputData(workDataOf("task_id" to taskId))
            .build()
        WorkManager.getInstance().enqueue(workRequest)

        popScreen()
    }

    CreateTaskContent(
        saveTitle = { newTitle: String -> title.value = newTitle },
        saveContent = { newContent: String -> content.value = newContent },
        onClickBtnCreate = onClickBtnCreate
    )
}

@Composable
fun CreateTaskContent(
    saveTitle: (String) -> Unit = {},
    saveContent: (String) -> Unit = {},
    onClickBtnCreate: () -> Unit = {}
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            SingleLineInputTextField(
                placeHolder = "작업을 입력하세요.",
                saveEventHandler = saveTitle
            )

            MultiLineInputTextField(
                placeHolder = "상세 내용을 입력하세요.",
                saveEventHandler = saveContent
            )
        }

        Button(
            onClick = {
                onClickBtnCreate()
            },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 20.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Main
            )
        ) {
            Text(text = "작업 생성")
        }


    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CreateTaskPreview() {
    CreateTaskContent()
}
package com.example.androidcodingtest.screens.taskdetail

import androidx.lifecycle.viewModelScope
import com.example.androidcodingtest.Task
import com.example.androidcodingtest.base.BaseViewModel
import com.example.androidcodingtest.data.repository.TaskRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TaskDetailViewModel @Inject constructor(
    private val repository: TaskRepository
) : BaseViewModel<TaskDetailPageState>(TaskDetailPageState()){

    fun getTask(id: String) {
        viewModelScope.launch {
            repository.getTask(id = id).collect {
                resultResponse(it, ::getTaskSuccessCallback)
            }
        }
    }

    private fun getTaskSuccessCallback(task: Task) {
        updateState(
            uiState.value.copy(
                title = task.title,
                content = task.content,
                status = task.status
            )
        )
    }
}
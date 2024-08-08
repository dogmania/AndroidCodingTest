package com.example.androidcodingtest.screens.alltasks

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidcodingtest.Task
import com.example.androidcodingtest.base.BaseViewModel
import com.example.androidcodingtest.data.repository.TaskRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AllTasksViewModel @Inject constructor(
    private val taskRepository: TaskRepository
): BaseViewModel<AllTasksPageState>(AllTasksPageState()) {

    fun getAllTasks() {
        viewModelScope.launch {
            taskRepository.getAllTasks().collect {
                resultResponse(it, ::getAllTasksSuccessHandler)
            }
        }
    }

    private fun getAllTasksSuccessHandler(data: List<Task>) {
        Log.e("AllTaskList", data.toString())
        updateState(
            uiState.value.copy(
                taskList = data
            )
        )
    }
}
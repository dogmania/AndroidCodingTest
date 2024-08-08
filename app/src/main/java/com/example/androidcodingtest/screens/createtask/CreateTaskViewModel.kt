package com.example.androidcodingtest.screens.createtask

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidcodingtest.base.BaseViewModel
import com.example.androidcodingtest.data.repository.TaskRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CreateTaskViewModel @Inject constructor(
    private val repository: TaskRepository
): BaseViewModel<CreateTaskPageState>(CreateTaskPageState()) {
    fun createTask(id: String, title: String, content: String) {
        viewModelScope.launch {
            repository.createTask(id = id, title = title, content = content)
        }
    }
}
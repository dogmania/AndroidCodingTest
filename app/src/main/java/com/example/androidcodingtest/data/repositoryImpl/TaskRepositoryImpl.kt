package com.example.androidcodingtest.data.repositoryImpl

import androidx.datastore.core.DataStore
import com.example.androidcodingtest.Task
import com.example.androidcodingtest.TaskList
import com.example.androidcodingtest.data.repository.TaskRepository
import javax.inject.Inject

class TaskRepositoryImpl @Inject constructor(
    private val dataStore: DataStore<TaskList>
): TaskRepository {
    override suspend fun createTask(id: String, title: String) {
        dataStore.updateData { taskList ->
            val newTask = Task.newBuilder()
                .setId(id)
                .setTitle(title)
                .setStatus("추가됨")
                .build()
            taskList.toBuilder().addTasks(newTask).build()
        }
    }
}
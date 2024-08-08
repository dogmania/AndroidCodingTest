package com.example.androidcodingtest.data.repositoryImpl

import androidx.datastore.core.DataStore
import com.example.androidcodingtest.Task
import com.example.androidcodingtest.TaskList
import com.example.androidcodingtest.data.repository.TaskRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
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

    override suspend fun getAllTasks(): Flow<List<Task>> {
        return dataStore.data.map { taskList ->
            taskList.tasksList
        }
    }
}
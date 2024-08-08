package com.example.androidcodingtest.data.repository

import com.example.androidcodingtest.Task
import kotlinx.coroutines.flow.Flow

interface TaskRepository {
    suspend fun createTask(id: String, title: String, content: String)
    suspend fun getAllTasks(): Flow<List<Task>>
}
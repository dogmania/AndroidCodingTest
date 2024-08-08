package com.example.androidcodingtest.data.repository

interface TaskRepository {
    suspend fun createTask(id: String, title: String)
}
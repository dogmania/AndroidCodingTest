package com.example.androidcodingtest.screens.alltasks

import com.example.androidcodingtest.Task
import com.example.androidcodingtest.base.PageState

data class AllTasksPageState(
    val taskList: List<Task> = emptyList()
): PageState
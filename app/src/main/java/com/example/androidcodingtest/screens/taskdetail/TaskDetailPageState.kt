package com.example.androidcodingtest.screens.taskdetail

import com.example.androidcodingtest.base.PageState

data class TaskDetailPageState(
    val title: String = "",
    val content: String = "",
    val status: String = ""
): PageState
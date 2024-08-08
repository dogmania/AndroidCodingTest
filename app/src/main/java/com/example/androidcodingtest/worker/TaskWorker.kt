package com.example.androidcodingtest.worker

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.datastore.core.DataStore
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.androidcodingtest.R
import com.example.androidcodingtest.TaskList
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.coroutines.delay

@HiltWorker
class TaskWorker @AssistedInject constructor(
    @Assisted context: Context,
    @Assisted params: WorkerParameters,
    private val dataStore: DataStore<TaskList>,
) : CoroutineWorker(context, params) {

    override suspend fun doWork(): Result {
        val taskId = inputData.getString("task_id") ?: Result.failure()

        // 대기
        updateTaskStatus(taskId.toString(), "대기 중")

        // 5초 동안 대기
        delay(5000)

        // 진행
        updateTaskStatus(taskId.toString(), "진행 중")

        // 5초 동안 대기
        delay(5000)

        // 작업 완료 후 데이터 저장
        updateTaskStatus(taskId.toString(), "완료")

        // 알림 전송
        sendNotification()

        return Result.success()
    }

    private suspend fun updateTaskStatus(taskId: String, status: String) {
        dataStore.updateData { taskList ->
            val updatedTasks = taskList.tasksList.map { task ->
                if (task.id == taskId) {
                    task.toBuilder().setStatus(status).build()
                } else {
                    task
                }
            }
            taskList.toBuilder().clearTasks().addAllTasks(updatedTasks).build()
        }
    }

    private fun sendNotification() {
        val channelId = "task_notification_channel"
        val channelName = "Task Notifications"
        val notificationManager =
            applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                channelId,
                channelName,
                NotificationManager.IMPORTANCE_DEFAULT
            )
            notificationManager.createNotificationChannel(channel)
        }

        val notification = NotificationCompat.Builder(applicationContext, channelId)
            .setSmallIcon(R.drawable.ic_notification)
            .setContentTitle("작업 완료")
            .setContentText("작업이 성공적으로 완료되었습니다.")
            .build()

        notificationManager.notify(1, notification)
    }
}
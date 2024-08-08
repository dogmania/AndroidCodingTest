package com.example.androidcodingtest.util

import android.annotation.SuppressLint
import android.content.Context
import androidx.hilt.work.WorkerAssistedFactory
import androidx.work.ListenableWorker
import androidx.work.Worker
import androidx.work.WorkerFactory
import androidx.work.WorkerParameters
import javax.inject.Inject

class TaskWorkerFactory @Inject constructor(
    @SuppressLint("RestrictedApi") private val workerAssistedFactories: Map<Class<out Worker>,
    @JvmSuppressWildcards WorkerAssistedFactory<out Worker>>
) : WorkerFactory() {
    @SuppressLint("RestrictedApi")
    override fun createWorker(
        appContext: Context,
        workerClassName: String,
        workerParameters: WorkerParameters
    ): ListenableWorker {
        val foundEntry = workerAssistedFactories.entries.find { Class.forName(workerClassName).isAssignableFrom(it.key) }
        val factoryProvider = foundEntry?.value
            ?: throw IllegalArgumentException("unknown worker class name: $workerClassName")
        return factoryProvider.create(appContext, workerParameters)
    }
}
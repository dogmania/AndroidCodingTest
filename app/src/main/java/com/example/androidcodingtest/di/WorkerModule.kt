package com.example.androidcodingtest.di

import android.annotation.SuppressLint
import androidx.hilt.work.WorkerAssistedFactory
import androidx.work.Worker
import androidx.work.WorkerFactory
import com.example.androidcodingtest.util.TaskWorkerFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class WorkerModule {
    @Provides
    @Singleton
    fun provideWorkerFactory(
        @SuppressLint("RestrictedApi") workerAssistedFactories: Map<Class<out Worker>, @JvmSuppressWildcards WorkerAssistedFactory<out Worker>>
    ): WorkerFactory {
        return TaskWorkerFactory(workerAssistedFactories)
    }
}
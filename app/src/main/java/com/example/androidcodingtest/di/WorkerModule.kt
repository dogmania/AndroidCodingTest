package com.example.androidcodingtest.di

import android.annotation.SuppressLint
import androidx.hilt.work.HiltWorkerFactory
import androidx.hilt.work.WorkerAssistedFactory
import androidx.work.Configuration
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
object WorkerModule {
    @Provides
    @Singleton
    fun provideWorkerFactory(
        @SuppressLint("RestrictedApi") workerAssistedFactories: Map<Class<out Worker>, @JvmSuppressWildcards WorkerAssistedFactory<out Worker>>
    ): WorkerFactory {
        return TaskWorkerFactory(workerAssistedFactories)
    }

    @Provides
    @Singleton
    fun provideWorkManagerConfiguration(workerFactory: TaskWorkerFactory): Configuration {
        return Configuration.Builder()
            .setWorkerFactory(workerFactory)
            .build()
    }
}
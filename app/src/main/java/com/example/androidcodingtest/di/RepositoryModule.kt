package com.example.androidcodingtest.di

import com.example.androidcodingtest.data.repository.TaskRepository
import com.example.androidcodingtest.data.repositoryImpl.TaskRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindTaskRepository(repositoryImpl: TaskRepositoryImpl): TaskRepository
}
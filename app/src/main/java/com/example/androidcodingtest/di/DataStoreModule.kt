package com.example.androidcodingtest.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.core.DataStoreFactory
import androidx.datastore.dataStoreFile
import com.example.androidcodingtest.TaskList
import com.example.androidcodingtest.data.TaskSerializer
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataStoreModule {

    @Provides
    @Singleton
    fun provideTaskDataStore(
        context: Context
    ): DataStore<TaskList> {
        return DataStoreFactory.create(
            serializer = TaskSerializer,
            scope = CoroutineScope(Dispatchers.IO)
        ) {
            context.dataStoreFile("tasks.pb")
        }
    }
}
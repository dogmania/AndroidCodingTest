package com.example.androidcodingtest.data

import androidx.datastore.core.CorruptionException
import androidx.datastore.core.Serializer
import androidx.datastore.preferences.protobuf.InvalidProtocolBufferException
import com.example.androidcodingtest.TaskList
import java.io.InputStream
import java.io.OutputStream

object TaskSerializer: Serializer<TaskList> {
    override val defaultValue: TaskList = TaskList.getDefaultInstance()

    override suspend fun readFrom(input: InputStream): TaskList {
        return try {
            TaskList.parseFrom(input)
        } catch (exception: InvalidProtocolBufferException) {
            throw CorruptionException("Cannot read proto.", exception)
        }
    }

    override suspend fun writeTo(t: TaskList, output: OutputStream) {
        t.writeTo(output)
    }
}
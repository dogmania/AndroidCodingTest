package com.example.androidcodingtest.application

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class AndroidCodingTestApplication: Application() {
    override fun onCreate() {
        super.onCreate()
    }
}
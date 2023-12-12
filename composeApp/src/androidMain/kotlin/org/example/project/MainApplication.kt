package org.example.project

import android.app.Application
import di.initKoinAndroid
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger

class MainApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        initKoinAndroid {
            androidContext(this@MainApplication)
            androidLogger()
        }
    }
}
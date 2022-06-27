package com.example.imbd

import android.app.Application
import com.facebook.stetho.Stetho
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class IMDb: Application(){

    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this);
    }
}
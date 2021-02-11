package com.codechallenge.loweather

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class LoweatherApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        configureTimber()
    }

    private fun configureTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        } else {
            TODO("plant crashlytics tree")
        }
    }
}
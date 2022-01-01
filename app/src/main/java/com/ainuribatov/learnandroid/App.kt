package com.ainuribatov.learnandroid

import android.app.Application
import androidx.room.Room
import com.ainuribatov.learnandroid.data.persistent.db.AppDatabase
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        initLogger()
        initDatabase()
    }

    private fun initLogger() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    private fun initDatabase() {
        Room.databaseBuilder(
            this,
            AppDatabase::class.java, "app-database"
        ).build()
    }
}
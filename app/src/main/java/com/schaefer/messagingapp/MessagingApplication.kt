package com.schaefer.messagingapp

import android.app.Application
import com.schaefer.messagingapp.di.appModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

class MessagingApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MessagingApplication)
            modules(appModules)
        }

        setupLogTree()
    }

    private fun setupLogTree() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        } else {
            // TODO create a CrashReportingTree
        }
    }
}

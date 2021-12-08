package com.schaefer.messagingapp

import com.schaefer.messagingapp.di.appModules
import org.junit.Test
import org.koin.dsl.koinApplication
import org.koin.test.KoinTest
import org.koin.test.check.checkModules

class CheckAppModules : KoinTest {

    @Test
    fun verifyKoinApp() {
        koinApplication {
            modules(appModules)
            checkModules()
        }
    }
}

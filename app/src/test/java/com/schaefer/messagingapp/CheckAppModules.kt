package com.schaefer.messagingapp

import androidx.test.core.app.ApplicationProvider
import com.schaefer.messagingapp.di.appModules
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.koin.test.check.checkModules
import org.koin.test.mock.MockProviderRule
import org.mockito.Mockito
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(manifest = Config.NONE)
class CheckAppModules : KoinTest {

    @get:Rule
    val mockProvider = MockProviderRule.create { clazz ->
        Mockito.mock(clazz.java)
    }

    @Before
    fun setup() {
        stopKoin()
    }

    @Test
    fun verifyKoinApp() {
        startKoin {
            androidContext(ApplicationProvider.getApplicationContext())
            modules(appModules)
        }.checkModules()
    }
}

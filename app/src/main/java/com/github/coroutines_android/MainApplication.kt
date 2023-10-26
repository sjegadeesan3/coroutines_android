package com.github.coroutines_android

import android.app.Application
import com.github.coroutines_android.di.appModule
import com.github.coroutines_android.ui.main.MainViewModel
import org.koin.core.context.startKoin

//import org.koin.core.context.GlobalContext.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin{
            modules(appModule)
        }
    }
}
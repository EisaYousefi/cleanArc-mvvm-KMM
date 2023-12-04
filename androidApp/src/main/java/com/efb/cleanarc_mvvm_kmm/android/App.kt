package com.efb.cleanarc_mvvm_kmm.android

import android.app.Application
import com.efb.cleanarc_mvvm_kmm.di.coreModule
import com.efb.cleanarc_mvvm_kmm.di.repositoryModule
import com.efb.cleanarc_mvvm_kmm.di.ruseCaseModule
import com.efb.cleanarc_mvvm_kmm.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(coreModule, repositoryModule, viewModelModule,ruseCaseModule)
        }
    }
}
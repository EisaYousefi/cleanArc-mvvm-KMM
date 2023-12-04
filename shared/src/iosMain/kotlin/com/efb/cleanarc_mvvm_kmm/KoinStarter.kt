package com.efb.cleanarc_mvvm_kmm

import com.efb.cleanarc_mvvm_kmm.di.coreModule
import com.efb.cleanarc_mvvm_kmm.di.viewModelModule
import com.efb.cleanarc_mvvm_kmm.di.repositoryModule
import com.efb.cleanarc_mvvm_kmm.di.ruseCaseModule
import org.koin.core.context.startKoin

fun startKoin() {
    startKoin { modules(coreModule, repositoryModule, viewModelModule,ruseCaseModule) }
}
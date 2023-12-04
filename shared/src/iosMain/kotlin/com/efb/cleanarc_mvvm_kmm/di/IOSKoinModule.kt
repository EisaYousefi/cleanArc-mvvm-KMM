package com.efb.cleanarc_mvvm_kmm.di

import com.efb.cleanarc_mvvm_kmm.viewModel.SharedViewModel
import org.koin.core.definition.Definition
import org.koin.core.definition.KoinDefinition
import org.koin.core.module.Module
import org.koin.core.qualifier.Qualifier

actual inline fun <reified T : SharedViewModel> Module.sharedViewModel(
    qualifier: Qualifier?,
    noinline definition: Definition<T>
): KoinDefinition<T> {
    return factory(qualifier, definition)
}
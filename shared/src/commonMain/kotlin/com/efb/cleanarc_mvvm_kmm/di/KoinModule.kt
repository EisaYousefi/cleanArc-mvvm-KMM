package com.efb.cleanarc_mvvm_kmm.di

import com.efb.cleanarc_mvvm_kmm.data.GithubRepositoryImpl
import com.efb.cleanarc_mvvm_kmm.domian.repository.GithubRepository
import com.efb.cleanarc_mvvm_kmm.domian.secase.GetRepos
import com.efb.cleanarc_mvvm_kmm.httpClient
import com.efb.cleanarc_mvvm_kmm.viewModel.GithubViewModel
import com.efb.cleanarc_mvvm_kmm.viewModel.SharedViewModel
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.core.definition.Definition
import org.koin.core.definition.KoinDefinition
import org.koin.core.module.Module
import org.koin.core.qualifier.Qualifier
import org.koin.dsl.module

expect inline fun <reified T : SharedViewModel> Module.sharedViewModel(
    qualifier: Qualifier? = null,
    noinline definition: Definition<T>
): KoinDefinition<T>

val coreModule = module {
    single {
        httpClient {
            expectSuccess = true // To throw exception in case of error occurrence
            defaultRequest {
                url("https://api.github.com/") // Base URL for all requests
            }
            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true
                })
            }
        }
    }
}

val repositoryModule = module {
    single<GithubRepository> {
        GithubRepositoryImpl(get())
    }
}


val ruseCaseModule = module {
    single {
        GetRepos(get())
    }
}

val viewModelModule = module {
    sharedViewModel { GithubViewModel(get()) }
}
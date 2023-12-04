package com.efb.cleanarc_mvvm_kmm

import io.ktor.client.*
import io.ktor.client.engine.darwin.*

actual fun httpClient(config: HttpClientConfig<*>.() -> Unit): HttpClient = HttpClient(Darwin) {
    config()
}
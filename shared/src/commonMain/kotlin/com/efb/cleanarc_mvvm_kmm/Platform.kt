package com.efb.cleanarc_mvvm_kmm

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
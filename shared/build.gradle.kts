plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    kotlin("plugin.serialization") version "1.9.0"
    id("com.google.devtools.ksp") version "1.9.21-1.0.15"
    id("com.rickclephas.kmp.nativecoroutines") version "1.0.0-ALPHA-22"
}

kotlin {

    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
            isStatic = true
        }
    }

    val coroutineVersion = "1.7.3"
    val viewModelVersion = "2.6.2"
    val ktorVersion = "2.3.3"
    val kotlinxSerializationVersion = "1.5.1"
    val koinVersion = "3.4.3"
    sourceSets {

        all {
            languageSettings.optIn("kotlin.experimental.ExperimentalObjCName")
        }
        commonMain.dependencies {
            implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutineVersion")
            implementation("io.ktor:ktor-client-core:$ktorVersion")
            implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:$kotlinxSerializationVersion")
            implementation("io.ktor:ktor-client-content-negotiation:$ktorVersion")
            implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")
            implementation("io.insert-koin:koin-core:$koinVersion")
        }
        androidMain.dependencies {
            implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$viewModelVersion")
            implementation("io.ktor:ktor-client-okhttp:$ktorVersion")
            implementation("io.insert-koin:koin-android:$koinVersion")
            implementation("androidx.activity:activity-ktx:1.8.1")
        }
        iosMain.dependencies {
            implementation("io.ktor:ktor-client-darwin:$ktorVersion")
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}

android {
    namespace = "com.efb.cleanarc_mvvm_kmm"
    compileSdk = 34
    defaultConfig {
        minSdk = 21
    }
}

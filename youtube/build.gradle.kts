// Built-in YouTube app as an Android library (package com.srizwan.YouTube).
// A real native YouTube client (not a web wrapper): NewPipeExtractor reads feed / search / streams,
// Media3 ExoPlayer plays them. :app opens it as a built-in app (section = "youtube").
plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.srizwan.YouTube"
    compileSdk = 37

    defaultConfig {
        // Same as :app (26)
        minSdk = 26
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
        // NewPipeExtractor needs java.time / nio desugaring below minSdk 33
        isCoreLibraryDesugaringEnabled = true
    }

    buildFeatures {
        viewBinding = true
    }

    lint {
        abortOnError = false
    }
}

kotlin {
    compilerOptions {
        jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_21)
    }
}

dependencies {
    coreLibraryDesugaring("com.android.tools:desugar_jdk_libs_nio:2.1.5")

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.recyclerview:recyclerview:1.3.2")
    implementation("androidx.swiperefreshlayout:swiperefreshlayout:1.1.0")

    // YouTube data (feed, search, streams, channels, playlists) - from JitPack (already in settings.gradle.kts)
    implementation("com.github.TeamNewPipe:NewPipeExtractor:v0.26.5")
    // HTTP downloader used by the extractor
    implementation("com.squareup.okhttp3:okhttp:4.12.0")

    // Player: ExoPlayer + UI + media session (background playback / notification controls)
    implementation("androidx.media3:media3-exoplayer:1.8.0")
    implementation("androidx.media3:media3-exoplayer-dash:1.8.0")
    implementation("androidx.media3:media3-exoplayer-hls:1.8.0")
    implementation("androidx.media3:media3-ui:1.8.0")
    implementation("androidx.media3:media3-session:1.8.0")
}

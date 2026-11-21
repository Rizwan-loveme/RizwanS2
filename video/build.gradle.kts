// Glass video player as its own Android library (package com.srizwan.video).
// Media3 ExoPlayer (4K ready) with the same glass look as the built-in YouTube player: glass controls, gestures,
// speed and resolution chips, floating popup window, background playback. :app opens it from the File Manager
// (every video file), from the Start menu and from the Home screen (built-in "Video" app).
plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.srizwan.video"
    compileSdk = 37

    defaultConfig {
        // Same as :app (26)
        minSdk = 26
    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
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
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("androidx.recyclerview:recyclerview:1.3.2")
    // appcompat 1.6.1 -> lifecycle 2.5.1 asks for coroutines 1.6.1, which CI could not resolve (build #12).
    // The root build.gradle.kts forces 1.8.1 for every module; it is declared here too so :video is explicit.
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.8.1")

    // Player: ExoPlayer + UI (PlayerView surface) + media session (background playback / notification controls).
    // HLS / DASH only matter for network links; local files use the progressive extractors.
    implementation("androidx.media3:media3-exoplayer:1.8.0")
    implementation("androidx.media3:media3-exoplayer-dash:1.8.0")
    implementation("androidx.media3:media3-exoplayer-hls:1.8.0")
    implementation("androidx.media3:media3-ui:1.8.0")
    implementation("androidx.media3:media3-session:1.8.0")
}

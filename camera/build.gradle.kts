// Built-in Camera as its own Android library (package com.srizwan.camera).
// Same pattern as :gallery / :video: own module, resources prefixed "cm_" (nothing clashes with the other modules),
// glass UI, no text of its own (content descriptions only). :app opens it from the Start menu, the Home screen,
// the rizwans2://camera deep link and the built-in Browser (page camera / file upload with capture).
// Only the necessary features: photo, video, front / back, flash, zoom, tap to focus. Built step by step, see README.md.
plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.srizwan.camera"
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
    // CameraX: same version as :j2me (1.6.2), so Gradle resolves one version for the whole app (used from step 2).
    val cameraxVersion = "1.6.2"
    implementation("androidx.camera:camera-core:$cameraxVersion")
    implementation("androidx.camera:camera-camera2:$cameraxVersion")
    implementation("androidx.camera:camera-lifecycle:$cameraxVersion")
    implementation("androidx.camera:camera-view:$cameraxVersion")
    implementation("androidx.camera:camera-video:$cameraxVersion")
    // Same coroutines pin as :video / :gallery (see the root build.gradle.kts, CI build #12).
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.8.1")
}

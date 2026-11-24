// Seal's colour module (Monet tonal palettes + Material color utilities "hct"), package com.kyant.monet / io.material.hct.
// Copied unchanged from https://github.com/JunkFood02/Seal (color/), see seal/README.md and NOTICE-Seal.md.
// Differences from upstream's color/build.gradle.kts: compileSdk 37 / minSdk 26 / Java 21 like the other modules of this project,
// no release minify (upstream turned minify on for a library; :app here does not minify), versions inline (this project has no version catalog).
plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    // Compose compiler plugin (Kotlin 2.x): the colour code uses @Composable / staticCompositionLocalOf
    id("org.jetbrains.kotlin.plugin.compose")
}

android {
    namespace = "com.junkfood.seal.color"
    compileSdk = 37

    defaultConfig {
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
    // Same BOM as upstream Seal (the *alpha* BOM: Seal uses Material 3 APIs that are not in the stable BOM yet)
    api(platform("androidx.compose:compose-bom-alpha:2025.03.01"))
    api("androidx.compose.ui:ui")
    api("androidx.compose.runtime:runtime")
    api("androidx.core:core-ktx:1.15.0")
    api("androidx.compose.foundation:foundation")
    api("androidx.compose.material3:material3")
}

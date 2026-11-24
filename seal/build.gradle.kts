// Seal (video / audio downloader, yt-dlp) as its own Android library, package com.junkfood.seal (upstream package kept).
// Upstream: https://github.com/JunkFood02/Seal, pinned in UPSTREAM_VERSION / UPSTREAM_COMMIT (v2.0.0-alpha.5), GPL-3.0, see NOTICE-Seal.md.
// The Kotlin sources are IN the project (src/main/java, copied by tools/import-upstream.py, resources prefixed "sl_"); the yt-dlp engine
// (Python + yt-dlp + FFmpeg + aria2c) comes from Maven (io.github.junkfood02.youtubedl-android), so nothing is fetched at build time.
//
// Differences from upstream's app/build.gradle.kts (an application module with a version catalog):
//   * com.android.application -> com.android.library (the Win11 :app is the only application)
//   * no flavors (generic / githubPreview / fdroid), no ABI splits, no signing, no version-code maths, no applicationIdSuffix, no ktfmt
//   * compileSdk 37 / minSdk 26 / Java 21 like the other modules (upstream: 35 / 24 / 21); targetSdk is :app's (28)
//   * Kotlin 2.2.10 (root build file) instead of 2.0.20: Compose compiler, serialization and KSP plugins follow it (see the root build file)
//   * versions inline (this project has no version catalog); the list is upstream's libs.versions.toml, changes are marked "differs" below
//   * Room schemas are written to ./schemas through the KSP argument (upstream uses the Room Gradle plugin for the same directory)
plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.plugin.compose")
    id("org.jetbrains.kotlin.plugin.serialization")
    id("com.google.devtools.ksp")
}

android {
    // The Kotlin sources import com.junkfood.seal.R and com.junkfood.seal.BuildConfig, so the namespace stays upstream's.
    namespace = "com.junkfood.seal"
    compileSdk = 37

    defaultConfig {
        minSdk = 26
        consumerProguardFiles("consumer-rules.pro")
        vectorDrawables { useSupportLibrary = true }
        // App.kt (isFDroidBuild) reads BuildConfig.FLAVOR; a library without flavors has no such field, so it is defined here (not the F-Droid build).
        buildConfigField("String", "FLAVOR", "\"\"")
    }

    buildFeatures {
        buildConfig = true
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

    // yt-dlp / ffmpeg / aria2c / python come as libXxx.so / .zip.so files in jniLibs and are run / unpacked from the native library folder at run time: they must be extracted to disk.
    // The setting that counts is the one of the application module (:app: useLegacyPackaging = true + android:extractNativeLibs="true", checked in part 7);
    // AGP ignores packaging options of a library module, so the block below only documents the need.
    packaging {
        jniLibs {
            useLegacyPackaging = true
        }
    }

    lint {
        checkReleaseBuilds = false
        abortOnError = false
        // same list as upstream
        disable += listOf("MissingTranslation", "ExtraTranslation", "MissingQuantity")
    }
}

kotlin {
    compilerOptions {
        jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_21)
        freeCompilerArgs.add("-opt-in=kotlin.RequiresOptIn")
    }
}

// Room schema history (1..5.json, copied from upstream app/schemas): the auto-migrations of AppDatabase read it at compile time
ksp {
    arg("room.schemaLocation", "$projectDir/schemas")
    arg("room.incremental", "true")
}

dependencies {
    implementation(project(":seal-color"))

    // core bundle
    implementation("androidx.activity:activity-compose:1.10.1")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("androidx.core:core-ktx:1.15.0")
    implementation("androidx.lifecycle:lifecycle-runtime-compose:2.8.7")

    // Compose (alpha BOM, same as upstream; androidxCompose bundle)
    implementation(platform("androidx.compose:compose-bom-alpha:2025.03.01"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material:material-icons-extended")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.compose.material3:material3-window-size-class")
    implementation("androidx.compose.foundation:foundation")
    implementation("androidx.compose.animation:animation")
    implementation("androidx.navigation:navigation-compose:2.8.9")
    implementation("androidx.constraintlayout:constraintlayout-compose:1.1.0")
    implementation("androidx.graphics:graphics-shapes:1.0.1")
    // upstream also puts ui-tooling in implementation (previews); kept
    implementation("androidx.compose.ui:ui-tooling")

    // accompanist bundle
    implementation("com.google.accompanist:accompanist-permissions:0.34.0")
    implementation("com.google.accompanist:accompanist-webview:0.34.0")
    implementation("com.google.accompanist:accompanist-pager-indicators:0.34.0")

    implementation("io.coil-kt:coil-compose:2.5.0")

    // differs: upstream 1.7.2 (built for Kotlin 2.0); this project compiles with Kotlin 2.2.10, so the runtime for the serialization plugin is 1.9.0 (built for Kotlin 2.2)
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.9.0")

    implementation("io.insert-koin:koin-android:4.0.0")
    implementation("io.insert-koin:koin-androidx-compose:4.0.0")

    // differs: upstream Room 2.6.1 (KSP1 era); 2.8.5 is the version :j2me already uses in this project and works with KSP2 / Kotlin 2.2
    val roomVersion = "2.8.5"
    implementation("androidx.room:room-runtime:$roomVersion")
    implementation("androidx.room:room-ktx:$roomVersion")
    ksp("androidx.room:room-compiler:$roomVersion")

    // differs: upstream 5.0.0-alpha.10. :youtube (NewPipeExtractor downloader) runs on 4.12.0 and Gradle would otherwise put the whole app on the alpha;
    // Seal's 3 uses of `Response.body` got `!!` (it is nullable in 4.x), see NOTICE-Seal.md.
    implementation("com.squareup.okhttp3:okhttp:4.12.0")

    // yt-dlp engine: Python + yt-dlp (library), FFmpeg, aria2c
    implementation("io.github.junkfood02.youtubedl-android:library:0.17.3")
    implementation("io.github.junkfood02.youtubedl-android:ffmpeg:0.17.3")
    implementation("io.github.junkfood02.youtubedl-android:aria2c:0.17.3")

    // pinned to 1.3.x for 32-bit support (upstream comment)
    implementation("com.tencent:mmkv:1.3.12")
}

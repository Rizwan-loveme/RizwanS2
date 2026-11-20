plugins {
    id("com.android.application")
    // AGP 8.13.2 (needed by the BlackBox engine): Kotlin is NOT built in, so the plugin is applied.
    // (With AGP 9 this line must be removed again.)
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.srizwan.win11"
    compileSdk = 37

    defaultConfig {
        applicationId = "com.srizwan.win11"
        // 26: required by the :winlator library (was 24)
        minSdk = 26
        // 28: Android blocks running programs from the app data folder above 28 (Winlator runs box64 / wine
        // there). Same reason the BlackBox engine prefers 28. See README "Winlator inside Win11", part 3.
        targetSdk = 28
        versionCode = 116
        versionName = "2.4.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
        // Needed by :youtube (NewPipeExtractor uses java.time / nio below minSdk 33)
        isCoreLibraryDesugaringEnabled = true
    }

    // BlackBox needs the native libs extracted to disk (also android:extractNativeLibs in the manifest)
    packaging {
        jniLibs {
            useLegacyPackaging = true
        }
    }
    
    // targetSdk = 28 is intentional (see above), so lint's "ExpiredTargetSdkVersion" (Google Play wants 33+)
    // must not stop the release build. lintVitalRelease is skipped, same as in :winlator.
    lint {
        checkReleaseBuilds = false
        abortOnError = false
        disable += "ExpiredTargetSdkVersion"
    }

    // Compose প্রয়োজন নেই তাই এগুলো ফলস করে দেওয়া হলো
    buildFeatures { 
        compose = false 
        viewBinding = true
    }
}

kotlin {
    compilerOptions {
        jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_21)
    }
}

dependencies {
    // BlackBox virtual-space engine (parallel apps)
    implementation(project(":Bcore"))
    // Winlator engine (Wine + Box64 for PC software), added in v2.3.0 part 1
    implementation(project(":winlator"))
    // Built-in YouTube app (package com.srizwan.YouTube)
    implementation(project(":youtube"))
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
	implementation("androidx.webkit:webkit:1.11.0")
    // এই লাইব্রেরিটি অত্যন্ত গুরুত্বপূর্ণ TabLayout ও BottomNav এর জন্য
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    // Recycled lists for the Messages UI (smooth scrolling, no lag)
    implementation("androidx.recyclerview:recyclerview:1.3.2")
    // Desugaring for :youtube
    coreLibraryDesugaring("com.android.tools:desugar_jdk_libs_nio:2.1.5")
}

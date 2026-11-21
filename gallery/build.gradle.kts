// Glass Gallery as its own Android library (package com.srizwan.gallery).
// Same pattern as :video: own module, resources prefixed "gl_" (nothing clashes with :video / :youtube),
// glass UI, no text of its own (content descriptions only). :app opens it from the File Manager (every image file),
// from the Start menu and from the Home screen (built-in "Gallery" app). Built step by step, see README.md.
plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.srizwan.gallery"
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
    // Photo viewer: swipe between images (step 7).
    implementation("androidx.viewpager2:viewpager2:1.0.0")
    // Own Share sheet (step 7 of the Chooser plan replaces Intent.createChooser in ImageActions).
    implementation(project(":chooser"))
    // Same coroutines pin as :video (see the root build.gradle.kts): appcompat 1.6.1 -> lifecycle 2.5.1 asks for
    // coroutines 1.6.1, which CI could not resolve (build #12). Declared here so :gallery is explicit.
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.8.1")
}

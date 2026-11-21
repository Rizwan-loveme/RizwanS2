plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.srizwan.chooser"
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
    // The app grid of the "Open with" / Share sheets (step 3) and the file list of the picker (step 8).
    implementation("androidx.recyclerview:recyclerview:1.3.2")
    // Same coroutines pin as :video / :gallery (CI build #12): appcompat 1.6.1 -> lifecycle 2.5.1 asks for coroutines 1.6.1,
    // which CI could not resolve. Declared here so :chooser is explicit.
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.8.1")
}

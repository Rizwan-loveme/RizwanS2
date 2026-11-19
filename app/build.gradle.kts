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
        minSdk = 24
        targetSdk = 37
        versionCode = 114
        versionName = "2.2.8"

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
    }

    // BlackBox needs the native libs extracted to disk (also android:extractNativeLibs in the manifest)
    packaging {
        jniLibs {
            useLegacyPackaging = true
        }
    }
    
    // Compose প্রয়োজন নেই তাই এগুলো ফলস করে দেওয়া হলো
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
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
	implementation("androidx.webkit:webkit:1.11.0")
    // এই লাইব্রেরিটি অত্যন্ত গুরুত্বপূর্ণ TabLayout ও BottomNav এর জন্য
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    // Recycled lists for the Messages UI (smooth scrolling, no lag)
    implementation("androidx.recyclerview:recyclerview:1.3.2")
}

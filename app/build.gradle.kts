plugins {
    id("com.android.application")
    // FIX: AGP 9.x-এ Kotlin সাপোর্ট বিল্ট-ইন। আলাদা করে
    // id("org.jetbrains.kotlin.android") দিলে "plugin is no longer required
    // for Kotlin support since AGP 9.0" এরর দিয়ে বিল্ড ফেইল করে — তাই সরানো হয়েছে।
}

android {
    namespace = "com.srizwan.win11"
    compileSdk = 37

    defaultConfig {
        applicationId = "com.srizwan.win11"
        minSdk = 24
        targetSdk = 37
        versionCode = 105
        versionName = "2.1.3"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    
    // Compose প্রয়োজন নেই তাই এগুলো ফলস করে দেওয়া হলো
    buildFeatures { 
        compose = false 
        viewBinding = true
    }
}

// FIX: AGP 9-এ android { kotlinOptions {} } আর নেই; এর বদলে kotlin { compilerOptions {} }।
kotlin {
    compilerOptions {
        jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_1_8)
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
	implementation("androidx.webkit:webkit:1.11.0")
    // এই লাইব্রেরিটি অত্যন্ত গুরুত্বপূর্ণ TabLayout ও BottomNav এর জন্য
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    // Recycled lists for the Messages UI (smooth scrolling, no lag)
    implementation("androidx.recyclerview:recyclerview:1.3.2")
}

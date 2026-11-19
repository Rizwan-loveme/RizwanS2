// Top-level build file.
//
// AGP 8.13.2 + Gradle 8.14.3 (was AGP 9.1.1 / Gradle 9.3.1 before the BlackBox engine was added):
// the engine modules (:Bcore uses Groovy + ndkBuild) are not compatible with AGP 9, so the whole
// project is on AGP 8.13.2. Kotlin is no longer built in, so the Kotlin plugin is applied again
// in :app. Kotlin stays on 2.2.10, the version the app code was already compiled with.
plugins {
    id("com.android.application") version "8.13.2" apply false
    id("com.android.library") version "8.13.2" apply false
    id("org.jetbrains.kotlin.android") version "2.2.10" apply false
}

// Read by :Bcore (Groovy) as rootProject.ext.xxx
extra["compileSdkVersion"] = 37
extra["targetSdkVersion"] = 28
extra["minSdk"] = 21
extra["ndkVer"] = "29.0.13846066"

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

// Release build #12 failed in :video: "Could not find org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.1"
// (required by androidx.lifecycle:lifecycle-viewmodel-savedstate:2.5.1, which appcompat 1.6.1 brings in).
// Every module now uses one coroutines version that is published for sure, so nothing asks for 1.6.1.
val coroutinesVersion = "1.8.1"
allprojects {
    configurations.configureEach {
        resolutionStrategy.eachDependency {
            if (requested.group == "org.jetbrains.kotlinx" && requested.name.startsWith("kotlinx-coroutines-")) {
                useVersion(coroutinesVersion)
                because("1.6.1 (from androidx.lifecycle 2.5.1) could not be resolved in the CI build")
            }
        }
    }
}

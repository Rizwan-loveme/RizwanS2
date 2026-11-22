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

// Release build failed in :app:compileReleaseKotlin: kotlin-stdlib 2.4.20 (pulled in transitively by a
// library) has metadata 2.4.0, but the compiler is 2.2.10 and reads up to 2.3.0 ("Incompatible classes
// were found in dependencies"). Every kotlin-stdlib* artifact is pinned to the compiler version on the
// compile/runtime classpaths. Annotation-processor and Kotlin tooling configurations are left alone.
val kotlinStdlibVersion = "2.2.10"
allprojects {
    configurations.configureEach {
        val cfgName = name
        if ((cfgName.contains("CompileClasspath") || cfgName.contains("RuntimeClasspath")) &&
            !cfgName.startsWith("kotlin")
        ) {
            resolutionStrategy.eachDependency {
                if (requested.group == "org.jetbrains.kotlin" && requested.name.startsWith("kotlin-stdlib")) {
                    useVersion(kotlinStdlibVersion)
                    because("2.4.x stdlib is unreadable by the Kotlin 2.2.10 compiler")
                }
            }
        }
        resolutionStrategy.eachDependency {
            if (requested.group == "org.jetbrains.kotlinx" && requested.name.startsWith("kotlinx-coroutines-")) {
                useVersion(coroutinesVersion)
                because("1.6.1 (from androidx.lifecycle 2.5.1) could not be resolved in the CI build")
            }
        }
    }
}

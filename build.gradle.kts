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
    // :ppsspp (tombstone.proto). 0.9.6 is the AGP 8.x line; 0.10.0 is for AGP 9 (this project stays on AGP 8.13.2).
    id("com.google.protobuf") version "0.9.6" apply false
    // :seal / :seal-color (built-in Seal downloader): Compose compiler, kotlinx.serialization and KSP (Room compiler), all on the project's Kotlin 2.2.10.
    // KSP 2.2.10-2.0.2 is the release for Kotlin 2.2.10 (KSP2; checked against the google/ksp release list). Upstream Seal uses Kotlin 2.0.20 / KSP 2.0.20-1.0.25.
    id("org.jetbrains.kotlin.plugin.compose") version "2.2.10" apply false
    // :mika-core (Mika's pure JVM library): Kotlin JVM plugin on the project's Kotlin 2.2.10 (same kotlin-gradle-plugin artifact as kotlin.android).
    id("org.jetbrains.kotlin.jvm") version "2.2.10" apply false
    id("org.jetbrains.kotlin.plugin.serialization") version "2.2.10" apply false
    id("com.google.devtools.ksp") version "2.2.10-2.0.2" apply false
}

// Read by :Bcore (Groovy) as rootProject.ext.xxx
extra["compileSdkVersion"] = 37
// Same value as :app's targetSdk (37, part 8; -PappTargetSdk=28 goes back). Nothing reads it today (checked: :Bcore does not), it only keeps the old line from lying.
extra["targetSdkVersion"] = (findProperty("appTargetSdk") as String?)?.trim()?.toIntOrNull() ?: 37
extra["minSdk"] = 21
extra["ndkVer"] = "29.0.13846066"

// Release build #12 failed in :video: "Could not find org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.1"
// (required by androidx.lifecycle:lifecycle-viewmodel-savedstate:2.5.1, which appcompat 1.6.1 brings in).
// Every module now uses one coroutines version that is published for sure, so nothing asks for 1.6.1.
// Seal part 3: 1.8.1 -> 1.9.0. Seal's Compose / lifecycle 2.8.x / Koin 4 stack was built and tested on 1.9.0, and the pin forces this version on EVERY
// kotlinx-coroutines artifact, so it must not be lower than what those libraries need. 1.9.0 is published (Aug 2024) and only adds to 1.8.1 (the modules that
// declare 1.8.1 themselves are lifted to 1.9.0 by this pin, as before).
val coroutinesVersion = "1.9.0"

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

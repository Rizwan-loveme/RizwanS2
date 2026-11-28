// :shizuku-server = upstream's root-level `server` project (Shizuku, Apache-2.0): rikka.shizuku.server.ShizukuService and friends, the Shizuku server itself (the process that ADB / root
// starts through app_process, see :shizuku-starter). Step 3D of the Shizuku plan, see shizuku/README.md.
// shizuku/tools/patch-upstream.py changes this module (part A: host package in ServerConstants and ShizukuService, 2 files), so it compiles after the patch.
// Java + 2 Kotlin files (server/src/main/java/rikka/shizuku/server/ApkChangedObservers.kt and ktx/Handler.kt: found when the real sources could be read in 3E, so the module applies the Kotlin plugin
// and gets gson, as upstream), AIDL wired too in case the project has some of its own, no resources, no native code. Applies the Refine plugin. Namespace rikka.shizuku.server = the Java package.
// The server process loads its classes from the host APK, so the module is a library dependency of :shizuku (3E) and through it of :app (3F).
plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("dev.rikka.tools.refine")
}

val shizukuUpstream: File = rootProject.file("shizuku/upstream")
val serverMain = "server/src/main"

extra["shizukuUpstreamPath"] = "server"
extra["shizukuWired"] = listOf("java", "kotlin", "aidl")
extra["shizukuIgnored"] = listOf("manifest")
apply(from = "../after-fetch.gradle.kts")

android {
    namespace = "rikka.shizuku.server"
    compileSdk = 37

    defaultConfig {
        minSdk = 26
    }

    sourceSets {
        getByName("main") {
            java.srcDir("$shizukuUpstream/$serverMain/java")
            aidl.srcDir("$shizukuUpstream/$serverMain/aidl")
        }
    }

    buildFeatures {
        aidl = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }

    lint {
        checkReleaseBuilds = false
        abortOnError = false
    }
}

kotlin {
    compilerOptions {
        jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_21)
    }
}

dependencies {
    // as upstream's server/build.gradle (read in 3E); the server uses no client API (:shizuku-api is NOT needed: only ShizukuApiConstants, from :shizuku-shared)
    implementation(project(":shizuku-aidl"))
    implementation(project(":shizuku-shared"))
    implementation(project(":shizuku-common"))
    implementation(project(":shizuku-server-shared"))
    implementation(project(":shizuku-starter"))
    implementation(project(":shizuku-rish"))
    // BinderContainer (moe.shizuku.api): compile time only here, the class is in the APK through :shizuku
    compileOnly(project(":shizuku-provider"))
    implementation("androidx.annotation:annotation:1.9.1")
    implementation("com.google.code.gson:gson:2.13.1")
    // ParcelableListSlice (lists of PackageInfo over Binder); upstream exposes it with `api`
    api("dev.rikka.rikkax.parcelablelist:parcelablelist:2.0.1")
    compileOnly("dev.rikka.hidden:stub:4.4.0")
    implementation("dev.rikka.hidden:compat:4.4.0")
    implementation("dev.rikka.tools.refine:runtime:4.4.0")
}

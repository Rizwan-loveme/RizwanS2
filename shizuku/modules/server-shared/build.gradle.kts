// :shizuku-server-shared = upstream's api/server-shared (Shizuku-API, MIT): code that the Shizuku server and the starter share (server-side helpers over the AIDL / constants of the API).
// Step 3D of the Shizuku plan, see shizuku/README.md. Used by :shizuku-starter and :shizuku-server.
// Java-only, no resources, no native code. Applies the Refine plugin (it calls hidden Android APIs; the plugin rewrites those calls in the byte code, version from pluginManagement
// in settings.gradle.kts, so it is resolved only with -PincludeShizuku=true).
// Namespace rikka.shizuku.server.shared is a new name (no resources, nothing refers to it).
plugins {
    id("com.android.library")
    id("dev.rikka.tools.refine")
}

val shizukuUpstream: File = rootProject.file("shizuku/upstream")
val serverSharedMain = "api/server-shared/src/main"

extra["shizukuUpstreamPath"] = "api/server-shared"
extra["shizukuWired"] = listOf("java")
extra["shizukuIgnored"] = listOf("manifest")
apply(from = "../after-fetch.gradle.kts")

android {
    namespace = "rikka.shizuku.server.shared"
    compileSdk = 37

    defaultConfig {
        minSdk = 26
    }

    sourceSets {
        getByName("main") {
            java.srcDir("$shizukuUpstream/$serverSharedMain/java")
        }
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

dependencies {
    api(project(":shizuku-aidl"))
    api(project(":shizuku-shared"))
    // as upstream (read in 3E): the server classes use rikka.rish (RishService) too, so :shizuku-rish is an api dependency
    api(project(":shizuku-rish"))
    implementation("androidx.annotation:annotation:1.9.1")
    implementation("androidx.core:core:1.16.0")
    implementation("dev.rikka.rikkax.parcelablelist:parcelablelist:2.0.1")
    compileOnly("dev.rikka.hidden:stub:4.4.0")
    implementation("dev.rikka.hidden:compat:4.4.0")
    implementation("dev.rikka.tools.refine:runtime:4.4.0")
}

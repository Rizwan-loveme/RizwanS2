// :shizuku-common = upstream's root-level `common` project (Shizuku, Apache-2.0): small helpers shared by the manager, the server and the starter (BuildUtils, OsUtils, user-id helpers ...).
// Step 3C of the Shizuku plan, see shizuku/README.md. Not part of the API submodule: the sources are in shizuku/upstream/common (not shizuku/upstream/api/...).
// Java-only, no resources, no native code. It compiles against the hidden-API stubs (compileOnly: the real classes are the system's) but does not apply the Refine plugin
// (only :shizuku-server, -starter, -server-shared, -shell and :shizuku do, see shizuku/README.md "3A").
plugins {
    id("com.android.library")
}

val shizukuUpstream: File = rootProject.file("shizuku/upstream")
val commonMain = "common/src/main"

extra["shizukuUpstreamPath"] = "common"
extra["shizukuWired"] = listOf("java")
extra["shizukuIgnored"] = listOf("manifest")
apply(from = "../after-fetch.gradle.kts")

android {
    namespace = "moe.shizuku.common"
    compileSdk = 37

    defaultConfig {
        minSdk = 26
    }

    sourceSets {
        getByName("main") {
            java.srcDir("$shizukuUpstream/$commonMain/java")
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
    implementation("androidx.annotation:annotation:1.9.1")
    // hidden Android APIs (android.os.UserHandle, android.os.SystemProperties ...), compile time only; same version as upstream
    compileOnly("dev.rikka.hidden:stub:4.4.0")
}

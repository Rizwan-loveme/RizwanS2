// :shizuku-shared = upstream's api/shared (Shizuku-API, MIT): constants that the client API, the provider and the server all read (ShizukuApiConstants: binder extras,
// permission names, request codes ...). Step 3C of the Shizuku plan, see shizuku/README.md. Replaces dev.rikka.shizuku:shared (root build.gradle.kts, step 3F).
// Java-only, no resources, no native code, no dependency on another Shizuku module. Same build-file idea as :shizuku-aidl.
plugins {
    id("com.android.library")
}

val shizukuUpstream: File = rootProject.file("shizuku/upstream")
val sharedMain = "api/shared/src/main"

extra["shizukuUpstreamPath"] = "api/shared"
extra["shizukuWired"] = listOf("java")
extra["shizukuIgnored"] = listOf("manifest")
apply(from = "../after-fetch.gradle.kts")

android {
    namespace = "rikka.shizuku.shared"
    compileSdk = 37

    defaultConfig {
        minSdk = 26
    }

    sourceSets {
        getByName("main") {
            java.srcDir("$shizukuUpstream/$sharedMain/java")
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
}

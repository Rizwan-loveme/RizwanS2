// :shizuku-aidl = upstream's api/aidl (Shizuku-API, MIT): the AIDL interfaces of the Shizuku service (IShizukuService, IShizukuApplication, IRemoteProcess ...) and their parcelables.
// Step 3C of the Shizuku plan, see shizuku/README.md. Replaces the Maven artifact dev.rikka.shizuku:aidl:13.1.5 (root build.gradle.kts, step 3F) so that :mika and the manager use ONE copy.
//
// The build file is ours (upstream's cannot be used: include() is evaluated before the fetch, see settings.gradle.kts); the sources are read from the checkout that
// shizuku/tools/fetch-upstream.sh + patch-upstream.sh leave in shizuku/upstream/ (api/ = the pinned Shizuku-API commit). Nothing of upstream is copied into the project.
// AIDL-only module (4 .aidl files in moe/shizuku/server/, no Java, no Kotlin plugin), no resources, no native code. The upstream manifest of an API library is empty, so it is not used (AGP makes one from the namespace).
plugins {
    id("com.android.library")
}

val shizukuUpstream: File = rootProject.file("shizuku/upstream")
val aidlMain = "api/aidl/src/main"

extra["shizukuUpstreamPath"] = "api/aidl"
// only AIDL: api/aidl has 4 .aidl files and no .java file (checked in 3E); wiring "java" here would make checkShizukuLayout fail ("no .java file")
extra["shizukuWired"] = listOf("aidl")
extra["shizukuIgnored"] = listOf("manifest")
apply(from = "../after-fetch.gradle.kts")

android {
    // new name (no resources, nothing refers to it); it only has to be unique in the project: AGP refuses two modules with the same namespace
    namespace = "rikka.shizuku.aidl"
    compileSdk = 37

    defaultConfig {
        minSdk = 26
    }

    sourceSets {
        getByName("main") {
            // AIDL files, plus the hand-written Java parcelables / helpers that sit beside them (a missing folder is fine for Gradle)
            aidl.srcDir("$shizukuUpstream/$aidlMain/aidl")
            java.srcDir("$shizukuUpstream/$aidlMain/java")
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

dependencies {
    // @NonNull / @Nullable in the generated and hand-written code
    implementation("androidx.annotation:annotation:1.9.1")
}

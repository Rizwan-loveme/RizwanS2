// :shizuku-api = upstream's api/api (Shizuku-API, MIT): the client API (rikka.shizuku.Shizuku, ShizukuBinderWrapper, ShizukuRemoteProcess, SystemServiceHelper ...) that an app
// uses to talk to the Shizuku server. Step 3C of the Shizuku plan, see shizuku/README.md.
//
// This is one of the two modules that :mika already gets from Maven (dev.rikka.shizuku:api:13.1.5, same API version as the pinned Shizuku-API commit). Same class names and the
// same namespace (rikka.shizuku.api) as the Maven copy: with both on the class path AGP stops on the duplicate namespace and D8 on duplicate classes, so the root build file
// (step 3F) substitutes the Maven artifact by this project. The module therefore keeps the Maven artifact's contract: :aidl and :shared are `api` dependencies (the Maven POM
// has them in compile scope), so a consumer that only asks for :shizuku-api still sees IShizukuService and ShizukuApiConstants, as :mika's code needs.
// Java-only, no resources, no native code.
plugins {
    id("com.android.library")
}

val shizukuUpstream: File = rootProject.file("shizuku/upstream")
val apiMain = "api/api/src/main"

extra["shizukuUpstreamPath"] = "api/api"
extra["shizukuWired"] = listOf("java")
extra["shizukuIgnored"] = listOf("manifest")
apply(from = "../after-fetch.gradle.kts")

android {
    namespace = "rikka.shizuku.api"
    compileSdk = 37

    defaultConfig {
        minSdk = 26
    }

    sourceSets {
        getByName("main") {
            java.srcDir("$shizukuUpstream/$apiMain/java")
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
    implementation("androidx.annotation:annotation:1.9.1")
}

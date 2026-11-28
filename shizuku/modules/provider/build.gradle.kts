// :shizuku-provider = upstream's api/provider (Shizuku-API, MIT): rikka.shizuku.ShizukuProvider, the ContentProvider through which the Shizuku server hands its binder to an app.
// Step 3C of the Shizuku plan, see shizuku/README.md. The second module that :mika gets from Maven today (dev.rikka.shizuku:provider:13.1.5, namespace rikka.shizuku.provider):
// replaced by this project in the root build file (step 3F), for the same reason as :shizuku-api.
//
// This is the class that shizuku/tools/patch-upstream.py changes (part A: the hard-coded manager package becomes the host package, 2 places in ShizukuProvider.java), so it must be
// compiled AFTER the patch: after-fetch.gradle.kts makes every compile task wait for :shizuku:patchShizukuUpstream.
// :shizuku-api is an `api` dependency: ShizukuProvider calls Shizuku.* and uses BinderContainer / ShizukuApiConstants, and a consumer of the Maven artifact got them through its POM.
plugins {
    id("com.android.library")
}

val shizukuUpstream: File = rootProject.file("shizuku/upstream")
val providerMain = "api/provider/src/main"

extra["shizukuUpstreamPath"] = "api/provider"
extra["shizukuWired"] = listOf("java")
extra["shizukuIgnored"] = listOf("manifest")
apply(from = "../after-fetch.gradle.kts")

android {
    namespace = "rikka.shizuku.provider"
    compileSdk = 37

    defaultConfig {
        minSdk = 26
        // BinderContainer is read by name through a Parcel: keep it when a consumer shrinks (upstream's consumer-rules.pro, copied)
        consumerProguardFiles("consumer-rules.pro")
    }

    sourceSets {
        getByName("main") {
            java.srcDir("$shizukuUpstream/$providerMain/java")
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
    api(project(":shizuku-api"))
    implementation("androidx.annotation:annotation:1.9.1")
}

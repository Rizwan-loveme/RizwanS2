// :shizuku-starter = upstream's root-level `starter` project (Shizuku, Apache-2.0): moe.shizuku.starter.ServiceStarter, the class that app_process runs to start the Shizuku server
// (from the host APK path: that is why the class has to be in base.apk, which a library dependency of :app guarantees). Step 3D of the Shizuku plan, see shizuku/README.md.
// shizuku/tools/patch-upstream.py changes this module (part A: the host package, 2 places in ServiceStarter.java), so it compiles after the patch (after-fetch.gradle.kts).
// Java-only, no resources, no native code (the native starter, libshizuku.so, belongs to :shizuku, step 3E). Applies the Refine plugin. Namespace moe.shizuku.starter = the Java package.
plugins {
    id("com.android.library")
    id("dev.rikka.tools.refine")
}

val shizukuUpstream: File = rootProject.file("shizuku/upstream")
val starterMain = "starter/src/main"

extra["shizukuUpstreamPath"] = "starter"
extra["shizukuWired"] = listOf("java")
extra["shizukuIgnored"] = listOf("manifest")
apply(from = "../after-fetch.gradle.kts")

android {
    namespace = "moe.shizuku.starter"
    compileSdk = 37

    defaultConfig {
        minSdk = 26
    }

    sourceSets {
        getByName("main") {
            java.srcDir("$shizukuUpstream/$starterMain/java")
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
    // as upstream's starter/build.gradle (read in 3E, checked against the imports of the 2 source files): ServiceStarter uses ShizukuApiConstants (:shizuku-shared),
    // the server-shared classes (UserService ...), moe.shizuku.common.util (:shizuku-common) and moe.shizuku.api.BinderContainer (:shizuku-provider, compile time only:
    // the real class is in the APK through :shizuku). Not :shizuku-api: nothing of the client API is used.
    implementation(project(":shizuku-shared"))
    implementation(project(":shizuku-server-shared"))
    implementation(project(":shizuku-common"))
    compileOnly(project(":shizuku-provider"))
    implementation("androidx.annotation:annotation:1.9.1")
    compileOnly("dev.rikka.hidden:stub:4.4.0")
    implementation("dev.rikka.hidden:compat:4.4.0")
    implementation("dev.rikka.tools.refine:runtime:4.4.0")
}

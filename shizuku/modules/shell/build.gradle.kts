// :shizuku-shell = upstream's root-level `shell` project (Shizuku, Apache-2.0): rikka.shizuku.shell.ShizukuShellLoader, the entry point of the "rish" shell
// (a terminal that runs commands with the Shizuku server's privileges). Step 3C of the Shizuku plan, see shizuku/README.md.
//
// An APPLICATION module on purpose (as upstream): the only thing wanted from it is ONE classes.dex, made by R8 from ShizukuShellLoader + the hidden-API compat code (nothing of
// rish: the loader loads moe.shizuku.manager.shell.Shell from the host APK by name). :shizuku (step 3E, task shizukuRishDex) runs :shizuku-shell:assembleRelease, takes the one
// classes.dex out of the unsigned release APK (outputs/apk/release/, the same way upstream does it) and puts it into the assets of :shizuku as rish_shizuku.dex, which
// ShellTutorialActivity looks for by name.
// The module is not a dependency of :app, so its APK is never part of the Win11 APK (the unsigned release APK it builds is thrown away).
//
// Differences from upstream's shell/build.gradle: the Gradle build file is ours; the version is not git-based (versionCode 1, versionName = shizuku/UPSTREAM_VERSION, decision 6 in
// shizuku/README.md); the manifest is ours (src/main/AndroidManifest.xml: an application module needs one, upstream's is an empty <manifest />); the R8 rules (proguard-rules.pro) are
// upstream's own (read in 3E) plus dontwarn lines for the hidden-API stubs.
// The Java sources are upstream's, read from shizuku/upstream/shell/src/main/java (the file shizuku/tools/patch-upstream.py changes in part A: host package in ShizukuShellLoader).
//
// Applies the Refine plugin (rewrites calls to hidden Android APIs in the byte code); its version comes from pluginManagement in settings.gradle.kts (step 3B), so it is resolved only
// when this module is part of the build (-PincludeShizuku=true).
plugins {
    id("com.android.application")
    id("dev.rikka.tools.refine")
}

val shizukuUpstream: File = rootProject.file("shizuku/upstream")
val shellMain = "shell/src/main"
val shizukuVersionName: String = rootProject.file("shizuku/UPSTREAM_VERSION").readText().trim()

extra["shizukuUpstreamPath"] = "shell"
extra["shizukuWired"] = listOf("java")
extra["shizukuIgnored"] = listOf("manifest")
apply(from = "../after-fetch.gradle.kts")

android {
    namespace = "rikka.shizuku.shell"
    compileSdk = 37

    defaultConfig {
        minSdk = 26
        targetSdk = 37
        versionCode = 1
        versionName = shizukuVersionName
    }

    sourceSets {
        getByName("main") {
            java.srcDir("$shizukuUpstream/$shellMain/java")
            // manifest: ours (src/main/AndroidManifest.xml of this folder, the default location), upstream's is not read
        }
    }

    buildTypes {
        release {
            // R8 shrinks the loader + its dependencies into one small dex: this IS the product of the module
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
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
    // upstream's shell/build.gradle has no project dependency (read in 3E): the loader only asks the system for the Shizuku binder and then loads
    // moe.shizuku.manager.shell.Shell (Rish) BY NAME from the host APK, so the rish classes are not part of this dex.
    // hidden Android APIs: stubs to compile against, compat code + Refine runtime to call them safely (upstream's versions)
    compileOnly("dev.rikka.hidden:stub:4.4.0")
    implementation("dev.rikka.hidden:compat:4.4.0")
    implementation("dev.rikka.tools.refine:runtime:4.4.0")
    implementation("androidx.annotation:annotation:1.9.1")
}

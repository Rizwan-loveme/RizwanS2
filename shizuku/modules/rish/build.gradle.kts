// :shizuku-rish = upstream's api/rish (Shizuku-API, MIT): "rish", the Shizuku shell. A Java part (rikka.rish: Rish, RishConfig, RishService ... the shell-side client and the
// server-side service) and a native part, librish.so (a pty bridge), built by upstream's own CMakeLists.txt. Step 3D of the Shizuku plan, see shizuku/README.md.
// Used by :shizuku-server (RishService), :shizuku-shell (the rish dex) and :shizuku (the manager's terminal tutorial).
//
// Native build (decision 4 of 3C - 3F): the project's one NDK (ext.ndkVer of the root build file), CMake 3.22.1 like :ppsspp, -DANDROID_STL=none with the Prefab package libcxx
// (org.lsposed.libcxx, upstream's version) instead of the NDK's STL; ABIs: all four like upstream, -PshizukuAbis=arm64-v8a,... narrows them (the same property :shizuku uses in 3E).
// Namespace rikka.rish is a new name for the library (no resources, nothing refers to it). Does not apply the Refine plugin (see 3A in shizuku/README.md).
plugins {
    id("com.android.library")
}

val shizukuUpstream: File = rootProject.file("shizuku/upstream")
val rishMain = "api/rish/src/main"
val shizukuAbis: List<String> = ((findProperty("shizukuAbis") as String?) ?: "arm64-v8a,armeabi-v7a,x86,x86_64")
    .split(",").map { it.trim() }.filter { it.isNotEmpty() }

extra["shizukuUpstreamPath"] = "api/rish"
extra["shizukuWired"] = listOf("java", "aidl", "native")
extra["shizukuIgnored"] = listOf("manifest")
extra["shizukuRequired"] = listOf("$rishMain/cpp/CMakeLists.txt")
apply(from = "../after-fetch.gradle.kts")

android {
    namespace = "rikka.rish"
    compileSdk = 37
    ndkVersion = rootProject.extra["ndkVer"] as String

    defaultConfig {
        minSdk = 26
        ndk {
            abiFilters += shizukuAbis
        }
        externalNativeBuild {
            cmake {
                abiFilters += shizukuAbis
                // no NDK STL: libcxx comes from the Prefab package below (as upstream)
                arguments += listOf("-DANDROID_STL=none")
            }
        }
    }

    externalNativeBuild {
        cmake {
            path = file("$shizukuUpstream/$rishMain/cpp/CMakeLists.txt")
            version = "3.22.1"
        }
    }

    sourceSets {
        getByName("main") {
            java.srcDir("$shizukuUpstream/$rishMain/java")
            aidl.srcDir("$shizukuUpstream/$rishMain/aidl")
        }
    }

    buildFeatures {
        aidl = true
        prefab = true
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
    // as upstream's api/rish/build.gradle (read in 3E): implementation project(':api')
    implementation(project(":shizuku-api"))
    // libc++ as a Prefab package for the native code (upstream's CMakeLists.txt: find_package(cxx REQUIRED CONFIG); "cxx" is the Prefab module inside org.lsposed.libcxx:libcxx)
    implementation("org.lsposed.libcxx:libcxx:27.0.12077973")
    implementation("androidx.annotation:annotation:1.9.1")
    // hidden Android APIs used by the Java part, compile time only
    compileOnly("dev.rikka.hidden:stub:4.4.0")
}

// PPSSPP (PSP emulator) as its own Android library (package org.ppsspp.ppsspp, upstream package kept:
// the JNI function names in upstream's C++ depend on it). Upstream: https://github.com/hrydgard/ppsspp,
// pinned in UPSTREAM_VERSION (v1.20.4), GPL-2.0-or-later, see NOTICE-PPSSPP.md.
//
// Differences from upstream's android/build.gradle.kts (an application module):
//   * com.android.application -> com.android.library (the Win11 :app is the only application)
//   * no flavors (gold / legacy / vr), no signing, no git-version logic, no lint baseline
//   * one NDK for the whole project (ext.ndkVer in the root build file), minSdk 26 like :app
//   * the C++ core is built by upstream's own root CMakeLists.txt, from ppsspp/upstream/ (cloned at build time by
//     tools/fetch-upstream.sh, NOT stored in the project zip); the JNI C++ (android/jni) comes with it
//   * -PppssppCcache=true (CI) turns on ccache for this module's C++ build
//   * arm64-v8a only by default; add more with  -PppssppAbis=arm64-v8a,armeabi-v7a  (or in gradle.properties)
//   * assets: upstream/assets (shaders, fonts, ppge / font atlases, flash0, lang, ...) are packed as this library's assets, same as upstream's "../assets"
plugins {
    id("com.android.library")
    id("com.google.protobuf")
}

// CI sets -PppssppCcache=true (env ORG_GRADLE_PROJECT_ppssppCcache) after installing ccache: only PPSSPP's C++ build uses it
val ppssppCcache = (findProperty("ppssppCcache") as String?) == "true"

val ppssppAbis = ((findProperty("ppssppAbis") as String?) ?: "arm64-v8a")
    .split(",").map { it.trim() }.filter { it.isNotEmpty() }

android {
    namespace = "org.ppsspp.ppsspp"
    compileSdk = 37
    // Same NDK as :Bcore / :j2me / :winlator (one NDK for the whole project)
    ndkVersion = rootProject.extra["ndkVer"] as String

    defaultConfig {
        minSdk = 26
        consumerProguardFiles("consumer-rules.pro")

        ndk {
            abiFilters += ppssppAbis
        }
        externalNativeBuild {
            cmake {
                abiFilters += ppssppAbis
                // Same arguments as upstream's "normal" flavor (platform raised to minSdk 26)
                arguments += listOf(
                    "-DANDROID=true",
                    "-DANDROID_PLATFORM=android-26",
                    "-DANDROID_TOOLCHAIN=clang",
                    "-DANDROID_CPP_FEATURES=",
                    "-DANDROID_STL=c++_shared"
                )
                if (ppssppCcache) {
                    arguments += listOf("-DCMAKE_C_COMPILER_LAUNCHER=ccache", "-DCMAKE_CXX_COMPILER_LAUNCHER=ccache")
                }
            }
        }
    }

    externalNativeBuild {
        cmake {
            path = file("upstream/CMakeLists.txt")
            version = "3.22.1"
        }
    }

    // PPSSPP's runtime files (about 22 MB, cloned with the source, NOT in the project zip). The native code reads them
    // through the AssetManager, so they must be in the APK under the same names (no "assets/" prefix, no renaming).
    sourceSets {
        getByName("main") {
            assets.srcDir("upstream/assets")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }

    // libppsspp_jni.so is loaded with System.loadLibrary: extract the native libs to disk (same as :app / :winlator)
    packaging {
        jniLibs {
            useLegacyPackaging = true
        }
    }

    lint {
        checkReleaseBuilds = false
        abortOnError = false
    }
}

dependencies {
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("androidx.documentfile:documentfile:1.1.0")
    // tombstone.proto (crash reports): same versions as upstream
    implementation("com.google.protobuf:protobuf-javalite:4.33.5")
}

protobuf {
    protoc {
        artifact = "com.google.protobuf:protoc:3.25.3"
    }
    generateProtoTasks {
        all().forEach { task ->
            task.builtins {
                create("java") {
                    option("lite")
                }
            }
        }
    }
}

// Clone the C++ core (UPSTREAM_VERSION) before CMake runs. Does nothing when ppsspp/upstream/ is already there
// (offline: put the files there by hand). Needs bash + git (Linux / macOS / CI).
val fetchPpssppUpstream = tasks.register<Exec>("fetchPpssppUpstream") {
    group = "ppsspp"
    description = "Clones PPSSPP (UPSTREAM_VERSION) into ppsspp/upstream/ if it is missing"
    workingDir = projectDir
    commandLine("bash", "tools/fetch-upstream.sh")
}
tasks.configureEach {
    if (name.startsWith("configureCMake") || name.startsWith("buildCMake") ||
        name.startsWith("generateJsonModel") || name.startsWith("externalNativeBuild") ||
        name.matches(Regex("merge.*Assets"))
    ) {
        dependsOn(fetchPpssppUpstream)
    }
}

// MAME (arcade emulator) as its own Android library: MAME4droid (Current) v1.41.2 by Seleuco, MAME core 0.289, GPL-2.0-or-later.
// Upstream: https://github.com/seleuco/MAME4droid-Current, pinned in UPSTREAM_VERSION / UPSTREAM_SHA256, see NOTICE-MAME4droid.md.
//
// Differences from upstream's android-MAME4droid/app/build.gradle (an application module):
//   * com.android.application -> com.android.library (the Win11 :app is the only application); package com.seleuco.mame4droid kept (JNI names depend on it)
//   * minSdk 26 like :app (upstream: 29). The core .so imports no symbol newer than API 21; the Java side was compiled against API 26 in step 3 (see README.md)
//   * one NDK for the whole project (ext.ndkVer in the root build file); arm64-v8a only, like upstream
//   * the small JNI library libmame4droid-jni.so is built here by ndk-build (src/main/jni); the MAME core libMAME4droid.so (367 MB) and
//     res/raw/files.zip (64 MB) are NOT in the project zip: tools/fetch-upstream.sh downloads them (hash-checked) into core/ before every build
//   * all resources are prefixed mm_, assets are under assets/mame/
plugins {
    id("com.android.library")
}

android {
    namespace = "com.seleuco.mame4droid"
    compileSdk = 37
    ndkVersion = rootProject.extra["ndkVer"] as String

    defaultConfig {
        minSdk = 26
        consumerProguardFiles("consumer-rules.pro")
        ndk {
            abiFilters += "arm64-v8a"
        }
        externalNativeBuild {
            ndkBuild {
                abiFilters += "arm64-v8a"
                arguments += listOf("APP_PLATFORM=android-26")
            }
        }
    }

    externalNativeBuild {
        ndkBuild {
            path = file("src/main/jni/Android.mk")
        }
    }

    sourceSets {
        getByName("main") {
            // downloaded by tools/fetch-upstream.sh (git-ignored): core/jniLibs/arm64-v8a/libMAME4droid.so, core/res/raw/mm_files.zip
            jniLibs.srcDir("core/jniLibs")
            res.srcDir("core/res")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    // The JNI code dlopen()s <nativeLibraryDir>/libMAME4droid.so, so the libraries must be extracted to disk (same as :app / :ppsspp / :winlator)
    packaging {
        jniLibs {
            useLegacyPackaging = true
            // already stripped upstream; do not copy / strip a 367 MB file again
            keepDebugSymbols += "**/libMAME4droid.so"
        }
    }

    lint {
        checkReleaseBuilds = false
        abortOnError = false
    }
}

// Download the MAME core and files.zip (UPSTREAM_VERSION, hash-checked against UPSTREAM_SHA256) into mame/core/ before anything is built.
// Does nothing when both files are already there with the right hash (offline: put them there by hand). Needs bash + curl + unzip + sha256sum (Linux / macOS / CI).
val fetchMameCore = tasks.register<Exec>("fetchMameCore") {
    group = "mame"
    description = "Downloads libMAME4droid.so and files.zip (pinned, SHA-256 checked) into mame/core/ if missing"
    workingDir = projectDir
    commandLine("bash", "tools/fetch-upstream.sh")
}
tasks.named("preBuild") {
    dependsOn(fetchMameCore)
}

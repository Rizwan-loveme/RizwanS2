// RetroArch (libretro frontend) as its own Android library: package com.retroarch (upstream package kept: the native code
// calls the Java classes by name, JNI). Upstream: https://github.com/libretro/RetroArch, pinned in UPSTREAM_VERSION +
// UPSTREAM_COMMIT (v1.22.2), GPL-3.0, see README.md, NOTICE-RetroArch.md and LICENSE-RetroArch (step 9); CI steps in both workflows (step 10).
//
// Differences from upstream's pkg/android/phoenix/build.gradle (an application module, AGP 4.2.0, compileSdk 30, NDK r22):
//   * com.android.application -> com.android.library (the Win11 :app is the only application)
//   * no flavors (normal / aarch64 / ra32 / playStoreNormal / playStorePlus), no signing, no versionCode / versionName logic,
//     no dynamic_features.gradle, no Play Core (upstream's play-core-stub PlayCoreManager is copied into src/main/java, step 6)
//   * buildConfigField PLAY_STORE_BUILD = false: upstream's Java (RetroActivityCommon ...) reads BuildConfig.PLAY_STORE_BUILD
//   * one NDK for the whole project (ext.ndkVer in the root build file), minSdk 26 like :app (upstream: 16)
//   * arm64-v8a only by default (like :ppsspp / :mame); add more with  -PretroarchAbis=arm64-v8a,x86_64  (or in gradle.properties)
//   * the native code is built by upstream's own Android.mk (ndk-build), from retroarch/upstream/ (cloned at build time, NOT in the project zip)
//   * upstream's Java has NO library dependency (only the Android framework), so there is no dependencies block
//
// Built step by step (see README.md). State of this file:
//   step 3: empty library module, included in settings.gradle.kts and used by :app, so the wiring is proven first
//   step 4: Gradle task fetchRetroarchUpstream (tools/fetch-upstream.sh clones the pinned tag into retroarch/upstream/, NOT in the zip)
//   step 5 (this file): native build. externalNativeBuild { ndkBuild } on upstream's own pkg/android/phoenix-common/jni/Android.mk (module
//           retroarch-activity -> lib/<abi>/libretroarch-activity.so). Properties (gradle.properties or -P):
//             retroarchAbis=arm64-v8a,x86_64   ABIs (default arm64-v8a)
//             retroarchNative=false            skip the native build (and the clone): module stays empty, nothing of RetroArch is in the APK
//             retroarchCcache=true             CI: ndk-build uses ccache (NDK_CCACHE=ccache)
//             retroarchGles=3                  link GLESv3 / HAVE_OPENGLES3 (upstream's default is GLES2)
//             retroarchCFlags / retroarchCppFlags   extra compiler flags (space separated), e.g. "-Wno-error=implicit-function-declaration" if the NDK's newer clang
//                                              rejects old C code (upstream's tag was written for NDK r22). Empty by default.
//   step 6 (this file, no code change needed): Java sources (src/main/java, copied from upstream's pkg/android/phoenix/src, phoenix-common/src,
//           play-core-stub and libretro-common/vfs/saf/src; 3 files edited, see README.md), resources (src/main/res, prefixed ra_) and the library
//           manifest (src/main/AndroidManifest.xml: own process :retroarch, not exported, no launcher filter, documents provider disabled) are the
//           module's default source set, so they are not part of the zip's "clone at build time" tree. Compare with upstream after a version bump:
//           bash retroarch/tools/diff-upstream-java.sh
//   step 8: no build change. The hooks are in :app (RetroArchLauncher.kt, StartApps.kt, Win11Shell.kt, MainActivity.kt, FileManagerUi.kt); the only change in this
//           module is a small edit of MainMenuActivity.java (it accepts the extras ROM / LIBRETRO).
plugins {
    id("com.android.library")
}

// ABIs of the native library. Default: arm64-v8a only. Example: -PretroarchAbis=arm64-v8a,x86_64
val retroarchAbis = ((findProperty("retroarchAbis") as String?) ?: "arm64-v8a")
    .split(",").map { it.trim() }.filter { it.isNotEmpty() }

// -PretroarchNative=false switches the native build off (and with it the 330 MB clone): an escape hatch if the build of upstream's C code ever
// breaks the whole APK. The module then stays empty and the RetroArch app hooks (step 8) must not be used.
val retroarchNative = (findProperty("retroarchNative") as String?)?.trim() != "false"

// CI sets -PretroarchCcache=true (env ORG_GRADLE_PROJECT_retroarchCcache) after installing ccache: ndk-build prefixes the compilers with it (NDK_CCACHE)
val retroarchCcache = (findProperty("retroarchCcache") as String?)?.trim() == "true"

// -PretroarchGles=3: GLESv3 (HAVE_OPENGLES3) instead of upstream's default GLESv2 (HAVE_OPENGLES2); Android.mk reads the GLES variable
val retroarchGles = (findProperty("retroarchGles") as String?)?.trim() ?: ""

// Extra compiler flags without editing this file (e.g. -PretroarchCFlags="-Wno-error=implicit-function-declaration -Wno-error=int-conversion").
// Empty by default: nothing is silenced unless a real build shows it is needed.
fun flagsOf(name: String): List<String> =
    ((findProperty(name) as String?) ?: "").trim().split(Regex("\\s+")).filter { it.isNotEmpty() }
val retroarchCFlags = flagsOf("retroarchCFlags")
val retroarchCppFlags = flagsOf("retroarchCppFlags")

android {
    namespace = "com.retroarch"
    compileSdk = 37
    // Same NDK as :Bcore / :j2me / :winlator / :ppsspp / :mame (one NDK for the whole project)
    ndkVersion = rootProject.extra["ndkVer"] as String

    defaultConfig {
        minSdk = 26
        consumerProguardFiles("consumer-rules.pro")

        ndk {
            abiFilters += retroarchAbis
        }
        // upstream's Java reads BuildConfig.PLAY_STORE_BUILD; this build is never the Play Store variant
        buildConfigField("boolean", "PLAY_STORE_BUILD", "false")

        if (retroarchNative) {
            externalNativeBuild {
                ndkBuild {
                    abiFilters += retroarchAbis
                    // upstream's Application.mk (APP_STL := c++_static, APP_ABI defaults) normally sits next to Android.mk and is used by AGP; command-line
                    // variables win over it. APP_PLATFORM = minSdk (upstream's own default would be API 21, raised by the NDK). APP_STL is repeated so the
                    // build does not depend on Application.mk being picked up. -j like upstream's build.gradle.
                    arguments += listOf(
                        "APP_PLATFORM=android-26",
                        "APP_STL=c++_static",
                        "-j${Runtime.getRuntime().availableProcessors()}"
                    )
                    if (retroarchGles == "3") {
                        arguments += "GLES=3"
                    }
                    if (retroarchCcache) {
                        arguments += "NDK_CCACHE=ccache"
                    }
                    cFlags += retroarchCFlags
                    cppFlags += retroarchCppFlags
                }
            }
        }
    }

    // The whole RetroArch repo is needed at its relative position (Android.mk: RARCH_DIR := ../../../..), so the path points into the clone made by
    // tools/fetch-upstream.sh. It is not there at configuration time; every native task waits for fetchRetroarchUpstream (below).
    if (retroarchNative) {
        externalNativeBuild {
            ndkBuild {
                path = file("upstream/pkg/android/phoenix-common/jni/Android.mk")
            }
        }
    }

    buildFeatures {
        buildConfig = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    // libretroarch-activity.so is loaded by NativeActivity (android.app.lib_name) and cores are dlopen()ed by the native code:
    // extract the native libs to disk (same as :app / :winlator / :ppsspp / :mame)
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

// Clone RetroArch (UPSTREAM_VERSION, commit checked against UPSTREAM_COMMIT) into retroarch/upstream/ before the native build.
// Does nothing when the right commit is already there (offline: put the files there by hand, without .git the commit is not checked).
// Needs bash + git (Linux / macOS / CI). Run it alone with:  ./gradlew :retroarch:fetchRetroarchUpstream
val fetchRetroarchUpstream = tasks.register<Exec>("fetchRetroarchUpstream") {
    group = "retroarch"
    description = "Clones RetroArch (UPSTREAM_VERSION) into retroarch/upstream/ if it is missing or on another commit"
    workingDir = projectDir
    commandLine("bash", "tools/fetch-upstream.sh")
}
// The clone is needed before anything reads it: the native-build tasks (configureNdkBuild*, buildNdkBuild*, generateJsonModel*, externalNativeBuild*)
// and, like :mame, preBuild (the Java / resources of step 6 are in this module, so nothing else reads the clone; preBuild keeps the order the same as :mame).
// Only when the native build is on.
if (retroarchNative) {
    tasks.configureEach {
        if (name == "preBuild" || name.startsWith("configureNdkBuild") || name.startsWith("buildNdkBuild") ||
            name.startsWith("generateJsonModel") || name.startsWith("externalNativeBuild")
        ) {
            dependsOn(fetchRetroarchUpstream)
        }
    }
}

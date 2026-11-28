plugins {
    id("com.android.application")
    // AGP 8.13.2 (needed by the BlackBox engine): Kotlin is NOT built in, so the plugin is applied.
    // (With AGP 9 this line must be removed again.)
    id("org.jetbrains.kotlin.android")
}

// Shizuku (step 3F, shizuku/README.md "3F"): true only when settings.gradle.kts included the Shizuku projects (includeShizuku, on by default since 8F). The project test, not the property, is the signal
// (the property is read in one place, settings.gradle.kts, so the two can never disagree). With it false nothing below changes: the build is exactly as before.
val shizukuIncluded: Boolean = rootProject.findProject(":shizuku") != null

android {
    namespace = "com.srizwan.win11"
    compileSdk = 37

    defaultConfig {
        applicationId = "com.srizwan.win11"
        // 26: required by the :winlator library (was 24)
        minSdk = 26
        // targetSdk 37 (owner decision, Mika part 8; it was 28 before). One place: -PappTargetSdk=28 (or appTargetSdk=28 in gradle.properties) goes back to the old value
        // without touching this file. WHY 28 WAS USED and what 37 changes for the other built-in apps: Android blocks running programs from the app data folder above 28
        // (Winlator runs box64 / wine there; RetroArch loads the cores it downloaded into <dataDir>/cores). Both are expected to stop working at 37, see docs/CHANGES-mika-part8.md
        // and README "targetSdk 37". Other effects (scoped storage, package visibility, edge-to-edge, foreground service types ...) are listed there too.
        targetSdk = (findProperty("appTargetSdk") as String?)?.trim()?.toIntOrNull() ?: 37
        versionCode = 120
        versionName = "2.5.3"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        // Seal part 7, optional: -PapkAbis=arm64-v8a,armeabi-v7a keeps only these ABIs in the APK (drops the x86 / x86_64 copies of the libraries that ship all four ABIs:
        // the yt-dlp engine of :seal (Python, FFmpeg, aria2c), MMKV, ffmpeg-kit, oboe ...). Not set = nothing is filtered (unchanged build). It only filters what is packaged;
        // the native builds of :ppsspp / :retroarch / :mame / :winlator / :j2me keep their own ABI settings. See seal/README.md "Part 7".
        (findProperty("apkAbis") as String?)?.split(',')?.map { it.trim() }?.filter { it.isNotEmpty() }?.takeIf { it.isNotEmpty() }?.let { abis ->
            ndk { abiFilters += abis }
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    // Shizuku (step 4B-2, shizuku/README.md "4B-2"): Mika's library manifest and the built-in manager both declare a provider with the authority ${applicationId}.shizuku
    // (INSTALL_FAILED_CONFLICTING_PROVIDER). src/shizuku/AndroidManifest.xml removes Mika's rikka.shizuku.ShizukuProvider (tools:node="remove"); a build-type manifest outranks
    // src/main and the libraries. Wired for both build types (`debug` is implicit, `release` is declared above) and ONLY when :shizuku is in the build: with it false nothing is
    // wired and Mika keeps its provider (the only receiver of the binder from an external Shizuku app).
    if (shizukuIncluded) {
        sourceSets.getByName("debug").manifest.srcFile("src/shizuku/AndroidManifest.xml")
        sourceSets.getByName("release").manifest.srcFile("src/shizuku/AndroidManifest.xml")
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
        // Needed by :youtube (NewPipeExtractor uses java.time / nio below minSdk 33)
        isCoreLibraryDesugaringEnabled = true
    }

    // BlackBox needs the native libs extracted to disk (also android:extractNativeLibs in the manifest)
    packaging {
        jniLibs {
            useLegacyPackaging = true
            // :winlator and :j2me (ndk-build, c++_shared) / ffmpeg-kit / oboe each bring a libc++_shared.so
            pickFirsts += "**/libc++_shared.so"
            // Build fix 2: a build WITH :winlator and :j2me failed in :app:mergeReleaseNativeLibs ("2 files found with path 'lib/arm64-v8a/liboboe.so'"):
            // :winlator ships a prebuilt Oboe 1.9.0 (jniLibs, used by its fluidsynth / MIDI audio), :j2me gets Oboe 1.11.0 from the Prefab package. One copy is kept
            // for the whole app (same risk as libc++_shared.so above: audio of the other user of Oboe could misbehave if the versions differ, see docs/CHANGES-mika-fix2.md).
            pickFirsts += "**/liboboe.so"
        }
        // :seal (Seal's libraries ship duplicate licence files; upstream excludes the same two)
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
            // Shizuku (3F): the manager's BouncyCastle 1.70 (bcprov / bcpkix / bcutil, ADB pairing keys) ships the same multi-release files in each jar
            // (META-INF/versions/9/OSGI-INF/MANIFEST.MF, module-info.class): the known "2 files found with path" error of mergeReleaseJavaResource. Android does not read
            // META-INF/versions, so they are not packed. Precaution written without a Gradle run (see shizuku/README.md "Not verified in 3F"); only with Shizuku in the build.
            if (shizukuIncluded) {
                excludes += "/META-INF/versions/**"
            }
        }
    }
    
    // :mika (Rizwan): assets/runtime/rootfs.tar.xz (the Linux sandbox root file system, 50+ MB) is already xz: keep it stored, do not deflate it a second time.
    // AGP counts this setting in the application module only (a library's copy is ignored), so it is here.
    androidResources {
        noCompress += "xz"
    }

    // lint's "ExpiredTargetSdkVersion" (Google Play wants 34+ for new updates) can only fire when -PappTargetSdk goes back to 28, and must not stop the
    // release build then. lintVitalRelease is skipped, same as in :winlator.
    lint {
        checkReleaseBuilds = false
        abortOnError = false
        disable += "ExpiredTargetSdkVersion"
    }

    // Compose প্রয়োজন নেই তাই এগুলো ফলস করে দেওয়া হলো
    buildFeatures { 
        compose = false 
        viewBinding = true
    }
}

kotlin {
    compilerOptions {
        jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_21)
    }
}

dependencies {
    // BlackBox virtual-space engine (parallel apps)
    implementation(project(":Bcore"))
    // Winlator engine (Wine + Box64 for PC software), added in v2.3.0 part 1
    implementation(project(":winlator"))
    // Built-in YouTube app (package com.srizwan.YouTube)
    implementation(project(":youtube"))
    // Glass video player + built-in Video app (package com.srizwan.video), used by the File Manager
    implementation(project(":video"))
    // Glass Gallery + built-in Gallery app (package com.srizwan.gallery), used by the File Manager for images
    implementation(project(":gallery"))
    // Built-in Camera app (package com.srizwan.camera): Start menu, Home icon, rizwans2://camera, Browser camera
    implementation(project(":camera"))
    // Own Open with / Share sheets and file picker (package com.srizwan.chooser)
    implementation(project(":chooser"))
    // J2ME Loader: built-in J2ME app (Java ME games, .jar / .jad), package ru.playsoftware.j2meloader
    implementation(project(":j2me"))
    // PPSSPP: built-in PSP emulator (package org.ppsspp.ppsspp), Start menu, Home icon, rizwans2://ppsspp, File Manager (.iso / .cso / .pbp)
    implementation(project(":ppsspp"))
    // MAME: built-in arcade emulator (MAME4droid, package com.seleuco.mame4droid). Start menu, Home icon and rizwans2://mame (MameLauncher.kt; 64-bit ARM phones only) were added in step 7, see mame/README.md
    implementation(project(":mame"))
    // RetroArch: built-in libretro frontend (package com.retroarch). All 12 steps done (native lib, Java, resources, manifest; runs in its own process :retroarch). Start menu, Home icon, rizwans2://retroarch and File Manager (console ROM files) hooks: RetroArchLauncher.kt (64-bit ARM phones only), see retroarch/README.md
    implementation(project(":retroarch"))
    // Seal: built-in video / audio downloader (yt-dlp), package com.junkfood.seal. Part 3: the module is wired in; start-up code (part 4), manifest (part 5) and the Start menu / Home / deep-link hooks (part 6) follow, see seal/README.md
    implementation(project(":seal"))
    // TUI-ConsoleLauncher: Linux terminal launcher theme (package ohi.andre.consolelauncher, MIT). Step 2: the module is wired in (empty); sources, resources, manifest, terminal screen, theme switch follow, see README.md ("Two launcher themes")
    implementation(project(":tui"))
    // Mika: built-in "Rizwan" AI assistant (package com.wangzan101.mika, Apache-2.0). Part 5: the module is wired in (settings.gradle.kts, -PincludeMika=false leaves it out);
    // App : MikaApp (part 6), manifest merge (part 7) and the Start menu / Home / deep-link hooks (part 8, MikaLauncher.kt) are done, and so is CI (part 9: fetch + patch + checks in all three workflows, tick box include_mika in UltimateBuild_WithoutMe.yml), see mika/README.md
    if ((findProperty("includeMika") as String?) != "false") {
        implementation(project(":mika"))
    }
    // Shizuku: built-in Shizuku manager (package moe.shizuku.manager, Apache-2.0; Shizuku-API MIT). Step 3F: the module is wired in (settings.gradle.kts, -PincludeShizuku; on by default since step 8F).
    // It brings the server / starter / rish / API modules and both native libraries (libshizuku.so, libadb.so, librish.so) with it. Step 4B (provider clash) is done: both :mika and
    // :shizuku declare a provider with the authority ${applicationId}.shizuku, and the build-type overlay src/shizuku/AndroidManifest.xml (see the sourceSets block in android { }) removes
    // Mika's rikka.shizuku.ShizukuProvider, so the two modules no longer clash at install time. The other manifest rows (4C - 4E: permissions, components, the merged-manifest checker) are done too.
    // NOT yet done: the hooks and the init call (step 6), the CI work (step 8); the hooks (6), the init call (6E) and the CI checks (8D) are done and the default is on since 8F. See shizuku/README.md "4B-2", "4B-4" and "4F-2".
    if (shizukuIncluded) {
        implementation(project(":shizuku"))
    }
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
	implementation("androidx.webkit:webkit:1.11.0")
    // এই লাইব্রেরিটি অত্যন্ত গুরুত্বপূর্ণ TabLayout ও BottomNav এর জন্য
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    // Recycled lists for the Messages UI (smooth scrolling, no lag)
    implementation("androidx.recyclerview:recyclerview:1.3.2")
    // Media Grabber step 5: HTML parsing for the Page Grabber crawler (links, <video>/<source>, <a href>); same version as :tui
    implementation("org.jsoup:jsoup:1.17.2")
    // Desugaring for :youtube
    coreLibraryDesugaring("com.android.tools:desugar_jdk_libs_nio:2.1.5")
}

// The Rikka AppCompat fork must not reach the APK (step 3F, decision 1 in shizuku/README.md). Upstream's Shizuku manager uses dev.rikka.rikkax.appcompat:appcompat, a modified copy of
// AndroidX AppCompat with the SAME class names, and removes androidx.appcompat from its build; both in one APK = duplicate classes (and the fork would change AppCompat for every
// module of Win11). :shizuku excludes it itself and uses the stock androidx.appcompat; this is the same exclusion for the final class path of the app, because a rikkax library
// (material, preference ...) may still list the fork in its POM. Every configuration, so compile, runtime and the packaging tasks agree. Only with Shizuku in the build.
if (shizukuIncluded) {
    configurations.configureEach {
        exclude(group = "dev.rikka.rikkax.appcompat", module = "appcompat")
    }
}

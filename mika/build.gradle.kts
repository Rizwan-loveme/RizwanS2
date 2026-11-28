// Mika (on-device AI agent for Android) as its own Android library, shown in Win11 as "Rizwan". Package com.wangzan101.mika (upstream package kept: 837 files
// import com.wangzan101.mika.R / BuildConfig). Upstream: https://github.com/wangzan101/Mika (module ":app"), pinned in UPSTREAM_VERSION + UPSTREAM_COMMIT
// (0.1.52), Apache-2.0, see NOTICE-Mika.md and mika/README.md. The JVM part of Mika is the module :mika-core (../mika-core/build.gradle.kts).
//
// The sources are NOT in the project zip: they are cloned at build time into mika/upstream/ (tools/fetch-upstream.sh + task fetchMikaUpstream, part 3) and patched there
// (tools/patch-upstream.sh, part 4: library manifest, MikaApp made open, mk_ resource names, Rizwan name). This build file only points the source sets at that checkout.
//
// Differences from upstream's app/build.gradle.kts (an application module):
//   * com.android.application -> com.android.library (the Win11 :app is the only application): no applicationId, no versionCode / versionName, no ABI splits,
//     no "perf" / "logs" build types, no applicationIdSuffix / app_name overrides, no androidTest, no `git rev-parse`
//   * BuildConfig: a library has no VERSION_NAME / VERSION_CODE / APPLICATION_ID, but upstream's code reads them (22 + 2 + 2 places), so they are defined here.
//     VERSION_NAME / GIT_HASH come from UPSTREAM_VERSION / UPSTREAM_COMMIT. APPLICATION_ID must be the HOST package (com.srizwan.win11): upstream compares it with
//     context.packageName (ShizukuShellUserService) and looks up the uid by it, and at run time the code runs inside the host app, not in "com.wangzan101.mika"
//   * minSdk 26 like every Win11 module (upstream 29). Mika's own minimum (Android 10+) is enforced at run time by MikaLauncher.isSupported() (part 8), so no
//     tools:overrideLibrary is needed in :app (the part 1 plan expected one). Nothing in the compile depends on minSdk; lint only warns (abortOnError = false)
//   * Kotlin 2.2.10 (root build file; upstream 2.1.20), JVM target 21 (upstream 17), compileSdk 37 (upstream 36)
//   * library versions follow the project, not upstream (a Gradle build resolves one version per library, the highest wins, so an older one would be ignored anyway):
//       Compose: BOM alpha 2025.03.01, the same BOM as :seal (upstream 2024.12.01); compiling against the version that actually runs avoids a link error at run time
//       activity-compose 1.10.1 (upstream 1.9.3, :seal's), kotlinx-serialization 1.9.0 (upstream 1.7.3, :seal's, built for Kotlin 2.2), okhttp 4.12.0 (same)
//       kotlinx-coroutines: the root build file pins every kotlinx-coroutines-* artifact to one version (upstream 1.10.2); not changed here
//       protobuf-javalite 4.36.2 (same as upstream; :ppsspp's 4.33.5 is lifted to it)
//     everything else (window, webkit, xz, commonmark, ML Kit, ZXing, Shizuku) is upstream's version
//   * from upstream's source tree only src/main is used: Java / Kotlin (java/), resources (res/), assets (assets/, 58 MB: Linux sandbox rootfs, web, terminal, mcp, chat),
//     AIDL (aidl/ = IMikaShell), prebuilt native files (jniLibs/arm64-v8a: libmikarun.so, libproot.so, libproot_loader.so) and the manifest. cpp/mikarun is NOT built
//     (upstream does not build it with Gradle either: the .so files are prebuilt). baseline-prof.txt is not used
//
// Settings that count only in the application module (AGP ignores them in a library), so they are done in :app (part 5), not here:
//   * packaging { jniLibs { useLegacyPackaging = true } }: Mika's sandbox runs libmikarun.so / libproot.so from nativeLibraryDir, so they must be extracted to disk (:app has it already)
//   * androidResources { noCompress += "xz" }: assets/runtime/rootfs.tar.xz is already xz (stored, not deflated again)
//
// Wired in settings.gradle.kts and :app (part 5): include(":mika-core") + include(":mika"), implementation(project(":mika")) in :app. -PincludeMika=false leaves it out of both.
plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.plugin.compose")
    id("org.jetbrains.kotlin.plugin.serialization")
}

// Pinned upstream (part 1): shown on Mika's About page and used for plugin compatibility checks (PluginManifest.validate)
val mikaVersionName: String = file("UPSTREAM_VERSION").readText().trim()
val mikaGitHash: String = file("UPSTREAM_COMMIT").readText().trim().take(7)

// Upstream checkout (cloned + patched by mika/tools, part 3 / 4)
val upstreamMain = "upstream/app/src/main"

android {
    // The Kotlin sources import com.wangzan101.mika.R and com.wangzan101.mika.BuildConfig, so the namespace stays upstream's.
    namespace = "com.wangzan101.mika"
    compileSdk = 37

    defaultConfig {
        minSdk = 26

        // BuildConfig of upstream's :app (see the header). GIT_HASH / BETA / ADB_LOGS: same names and values as upstream's release build.
        buildConfigField("String", "GIT_HASH", "\"$mikaGitHash\"")
        buildConfigField("boolean", "BETA", "true")
        buildConfigField("boolean", "ADB_LOGS", "false")
        // not generated for a library, read by upstream's code:
        buildConfigField("String", "VERSION_NAME", "\"$mikaVersionName\"")
        buildConfigField("int", "VERSION_CODE", "53") // upstream versionCode of 0.1.52
        buildConfigField("String", "APPLICATION_ID", "\"com.srizwan.win11\"") // the host app (see header)
    }

    sourceSets {
        getByName("main") {
            // the library manifest is upstream's app manifest AFTER tools/patch-upstream.sh (part 4) has turned it into a library manifest
            manifest.srcFile("$upstreamMain/AndroidManifest.xml")
            java.srcDir("$upstreamMain/java")
            res.srcDir("$upstreamMain/res")
            assets.srcDir("$upstreamMain/assets")
            aidl.srcDir("$upstreamMain/aidl")
            jniLibs.srcDir("$upstreamMain/jniLibs")
        }
    }

    buildFeatures {
        compose = true
        aidl = true
        buildConfig = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }

    // libmikarun.so / libproot.so / libproot_loader.so are executed from nativeLibraryDir: they must be extracted to disk. The setting that counts is the one of
    // :app (useLegacyPackaging = true, already set); AGP ignores it in a library, so the block below only documents the need.
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

kotlin {
    compilerOptions {
        jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_21)
    }
}

dependencies {
    implementation(project(":mika-core"))
    implementation("com.google.protobuf:protobuf-javalite:4.36.2")

    // Compose: same BOM as :seal (see header)
    implementation(platform("androidx.compose:compose-bom-alpha:2025.03.01"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.activity:activity-compose:1.10.1")
    implementation("androidx.window:window:1.3.0")
    implementation("androidx.webkit:webkit:1.12.1")

    // version is set by the project-wide coroutines pin in the root build file
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.9.0")
    implementation("com.squareup.okhttp3:okhttp:4.12.0")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.9.0")
    implementation("org.tukaani:xz:1.10")
    implementation("org.commonmark:commonmark:0.30.1")
    implementation("org.commonmark:commonmark-ext-gfm-tables:0.30.1")
    implementation("org.commonmark:commonmark-ext-gfm-strikethrough:0.30.1")

    // both recognition models ship inside the APK (no Play services download on first use), as upstream
    implementation("com.google.mlkit:text-recognition:16.0.1")
    implementation("com.google.mlkit:text-recognition-chinese:16.0.1")
    // WeChat binding QR code is encoded on the device only
    implementation("com.google.zxing:core:3.5.3")
    implementation("dev.rikka.shizuku:api:13.1.5")
    implementation("dev.rikka.shizuku:provider:13.1.5")
}

// Clone Mika (UPSTREAM_COMMIT, version checked against UPSTREAM_VERSION) into mika/upstream/ before anything reads it (part 3).
// Does nothing when the right commit is already there (offline: put the files there by hand, see tools/fetch-upstream.sh; without .git only the version is checked).
// Needs bash + git (Linux / macOS / CI). Run it alone with:  ./gradlew :mika:fetchMikaUpstream
val fetchMikaUpstream = tasks.register<Exec>("fetchMikaUpstream") {
    group = "mika"
    description = "Clones Mika (UPSTREAM_COMMIT) into mika/upstream/ if it is missing or on another commit"
    workingDir = projectDir
    commandLine("bash", "tools/fetch-upstream.sh")
}
// Turn the checkout into the library (part 4): library manifest, MikaApp open, mk_ resource names, Rizwan name + greeting, icon. Runs right after the fetch and
// before everything that reads the checkout. Idempotent (a marker file in the checkout holds the hash of the script), so a patched checkout is left alone.
// Needs bash + python3 (Linux / macOS / CI). Run it alone with:  ./gradlew :mika:patchMikaUpstream
val patchMikaUpstream = tasks.register<Exec>("patchMikaUpstream") {
    group = "mika"
    description = "Patches mika/upstream/ into an Android library (manifest, MikaApp open, mk_ resources, Rizwan name)"
    dependsOn(fetchMikaUpstream)
    workingDir = projectDir
    commandLine("bash", "tools/patch-upstream.sh")
}
// Everything that reads the checkout waits for fetch + patch: preBuild (the umbrella of all variant tasks) and, to be explicit, the tasks that read the source sets
// directly (resources, assets, jniLibs, manifest, AIDL). :mika-core's tasks wait only for the fetch (see ../mika-core/build.gradle.kts): the patch changes the app side only.
tasks.configureEach {
    if (name == "preBuild" || name.matches(Regex("(merge|package|process|compile|generate|parse|extract).*(Assets|Resources|JniLibFolders|Manifest|Aidl|BuildConfig|Annotations)"))) {
        dependsOn(patchMikaUpstream)
    }
}

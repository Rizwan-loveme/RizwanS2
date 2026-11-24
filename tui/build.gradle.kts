// TUI-ConsoleLauncher (Linux-terminal style launcher) as its own Android library: package ohi.andre.consolelauncher (upstream package kept:
// the upstream sources import its R / BuildConfig). Upstream: https://github.com/fandreuz/TUI-ConsoleLauncher (MIT), see NOTICE-TUI.md
// and the "Two launcher themes" section of README.md.
//
// Differences from upstream's app/build.gradle (an application module, AGP 8.2.0, compileSdk 34, minSdk 21, Java 8, flavors fdroid / playstore):
//   * com.android.application -> com.android.library (the Win11 :app is the only application, and the only HOME activity)
//   * AGP 8.13.2 (the version of the whole project), compileSdk 37, minSdk 26 like :app, Java 21 like the other modules
//   * no flavors, no signing config, no versionCode / versionName, no applicationId (those belong to :app; only the BuildConfig fields VERSION_NAME / VERSION_CODE are kept, step 6)
//   * buildConfigField APPLICATION_ID: upstream's Java reads BuildConfig.APPLICATION_ID (broadcast action names, file provider authority);
//     a library BuildConfig has no such field, so it is added here with the applicationId of :app (com.srizwan.win11)
//   * Java only (no Kotlin plugin needed; :app calls it from Kotlin)
//
// Built step by step (see README.md). State of this file:
//   step 2: empty library module, included in settings.gradle.kts and used by :app, so the wiring is proven first.
//   step 3: dependencies block (same list and versions as upstream's app/build.gradle; appcompat / material / okhttp = the versions
//           of the other modules). Still no sources and no resources, so nothing uses them yet.
//   step 4: upstream Java sources (157 files), assets (lucida_console.ttf) and res copied in unchanged;
//   step 5: resources renamed with the tui_ prefix (files + values + XML references; Java not touched yet);
//   step 6: VERSION_NAME / VERSION_CODE buildConfigFields added (a library BuildConfig has neither, upstream's Java reads both);
//           the Java sources now use the tui_ resource names (R.string.tui_*, R.layout.tui_*, ...) and the upstream `theme` command is `tuitheme`;
//   step 7 (this state): trimmed library manifest (no HOME / LAUNCHER / text VIEW-EDIT filters, no <application> attributes, nothing exported that :app does not need),
//           NOTICE-TUI.md + LICENSE-TUI, consumer ProGuard rules (upstream's proguard-rules.pro). Build settings unchanged since step 6;
//   step 8: no build change; LauncherActivity becomes a normal (non-HOME) activity, see "Step 8 notes" in README.md;
//   step 9: no build change; new file TuiHost.java (home-screen flag for :app's ThemeManager), Back / exit follow the saved theme, see "Step 9 notes";
//   step 10: no build change; new command win11 (win11.java) + TuiHost.Switcher for the launcher-theme switch back to Win11, see "Step 10 notes";
//   step 11: no build change; TuiHost.Share (the launcher's hidden / pinned apps and built-in apps), AppsManager.fill() merges the launcher's hidden list,
//           new commands pinned, builtin, files, gallery, browser, sms, see "Step 11 notes";
//   step 12: no build change; polish (hidden apps on install / uninstall, rotation scroll, keyboard close on hand-over, black start window), see "Step 12 notes".
//   step 13: no build change; final static check, tui/tools/check-merged-manifest.py (run by the three workflows after the APK build), see "Step 13 notes". All 13 steps done.
plugins {
    id("com.android.library")
}

android {
    // Upstream's namespace (the sources use `import ohi.andre.consolelauncher.R;` and its BuildConfig). Different from :app's com.srizwan.win11.
    namespace = "ohi.andre.consolelauncher"
    compileSdk = 37

    defaultConfig {
        // Same as :app (26); upstream: 21
        minSdk = 26
        consumerProguardFiles("consumer-rules.pro")

        // Upstream: BuildConfig.APPLICATION_ID (generated for an application module). Must equal :app's applicationId,
        // because the broadcast actions and the file provider authority (APPLICATION_ID + ".FILE_PROVIDER") are built from it.
        buildConfigField("String", "APPLICATION_ID", "\"com.srizwan.win11\"")

        // Upstream: BuildConfig.VERSION_NAME / VERSION_CODE (ChangelogManager header, `tui -about`). An Android library has no versionName / versionCode,
        // so BuildConfig would lack both fields and the sources would not compile. These are upstream's own values (app/build.gradle: versionCode 301,
        // versionName "v6.15.1-updated-v2"): they describe the embedded TUI code, not the Win11 app (:app has its own 2.5.3 / 120).
        buildConfigField("String", "VERSION_NAME", "\"v6.15.1-updated-v2\"")
        buildConfigField("int", "VERSION_CODE", "301")
    }

    buildFeatures {
        buildConfig = true
    }

    buildTypes {
        release {
            // :app decides about shrinking; the library keeps its code as it is
            isMinifyEnabled = false
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }

    lint {
        abortOnError = false
    }
}

dependencies {
    // Upstream's app/build.gradle has exactly these eight libraries. All are `implementation`: :app will only call :tui's own classes
    // (the terminal screen), none of these types appear in :tui's public API.

    // Same as :app / :youtube / :winlator (appcompat 1.6.1, material 1.11.0). :j2me asks for newer ones (1.8.0 / 1.13.0): Gradle takes the highest.
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    // Upstream uses LocalBroadcastManager for its internal broadcasts (UI <-> managers); not used by the other modules yet.
    implementation("androidx.localbroadcastmanager:localbroadcastmanager:1.1.0")
    // Same as :youtube / :seal (4.12.0). Used by upstream's weather / HTML-extract / update-check code.
    implementation("com.squareup.okhttp3:okhttp:4.12.0")
    // HTML parsing for upstream's "htmlextract" feature (htmlcleaner 2.29 + jsoup 1.17.2) and JSON path queries (json-path 2.9.0).
    implementation("net.sourceforge.htmlcleaner:htmlcleaner:2.29")
    implementation("com.jayway.jsonpath:json-path:2.9.0")
    implementation("org.jsoup:jsoup:1.17.2")
    // Fuzzy string matching for the suggestions / app-name search (it.andreuzzi.comparestring2.*). Upstream's build only has google() + mavenCentral(),
    // so 1.0.9 is on Maven Central (not checked from here: no network). If a CI build ever cannot resolve it, JitPack is already in settings.gradle.kts.
    implementation("it.andreuzzi:CompareString2:1.0.9")
}

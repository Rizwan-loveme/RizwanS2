pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    // এই লাইনটি রিপোজিটরি কনফ্লিক্ট দূর করবে
    repositoriesMode.set(RepositoriesMode.PREFER_SETTINGS)
    repositories {
        google()
        mavenCentral()
        // FreeReflection (used by the BlackBox engine in :Bcore)
        maven { url = uri("https://www.jitpack.io") }
    }
}

rootProject.name = "Win11"
include(":app")
// BlackBox engine (parallel apps / "Open in black box"): see NOTICE-BlackBox.md
include(":Bcore")
include(":black-reflection")
include(":compiler")
// Winlator engine (run PC .exe from the File Manager / Start menu): see NOTICE-Winlator.md
include(":winlator")
// Built-in YouTube app (native client: NewPipeExtractor + Media3), package com.srizwan.YouTube
include(":youtube")
// Glass video player (Media3 ExoPlayer, 4K ready) + the built-in Video app, package com.srizwan.video.
// Used by the File Manager (video files), the Start menu and the Home screen.
include(":video")
// Glass Gallery (photos + albums + full-screen viewer), package com.srizwan.gallery.
// Used by the File Manager (image files), the Start menu and the Home screen.
include(":gallery")
// Own "Open with" / Share sheets and file picker (replaces the system chooser for this app's own calls), package com.srizwan.chooser.
// Own module, resources prefixed "ch_", glass UI, no text of its own. Used by :app, :gallery and :video. Built step by step, see README.md.
include(":chooser")
// J2ME Loader (Java ME games / apps, .jar + .jad) as the built-in "J2ME" app, package ru.playsoftware.j2meloader (upstream package kept).
// Upstream: https://github.com/nikita36078/J2ME-Loader (Apache-2.0), see NOTICE-J2ME-Loader.md. :j2me-dexlib is upstream's ":dexlib".
// Used by the Start menu, the Home screen, the rizwans2://j2me deep link and the File Manager (.jar / .jad files).
include(":j2me")
include(":j2me-dexlib")
// Built-in Camera app (CameraX: photo, video, front / back, flash, zoom, focus), package com.srizwan.camera, resources prefixed "cm_".
// Used by the Start menu, the Home screen, the rizwans2://camera deep link and the built-in Browser (page camera / file upload with capture).
include(":camera")
// PPSSPP (PSP emulator) as the built-in "PPSSPP" app, package org.ppsspp.ppsspp (upstream package kept: the JNI names depend on it).
// Upstream: https://github.com/hrydgard/ppsspp (GPL-2.0-or-later), pinned in ppsspp/UPSTREAM_VERSION (v1.20.4), see NOTICE-PPSSPP.md.
// The C++ core is NOT in the project zip: ppsspp/tools/fetch-upstream.sh clones it into ppsspp/upstream/ at build time.
// Resources prefixed "pp_". Used by the Start menu, the Home screen, the rizwans2://ppsspp deep link and the File Manager (.iso / .cso / .pbp), built step by step, see ppsspp/README.md.
include(":ppsspp")
// MAME (arcade emulator) as the built-in "MAME" app: MAME4droid (Current) v1.41.2 by Seleuco, MAME core 0.289, package com.seleuco.mame4droid (upstream package kept: the JNI names depend on it).
// Upstream: https://github.com/seleuco/MAME4droid-Current (GPL-2.0-or-later: the source headers say "version 2 or any later version"), pinned in mame/UPSTREAM_VERSION + mame/UPSTREAM_SHA256, see NOTICE-MAME4droid.md.
// The Java frontend is in the project; the MAME core libMAME4droid.so (367 MB) and res/raw/files.zip (64 MB) are NOT in the project zip: mame/tools/fetch-upstream.sh downloads them (SHA-256 checked) before every build.
// Resources prefixed "mm_". Built step by step, see mame/README.md. Start menu / Home icon / rizwans2://mame hooks: app/.../MameLauncher.kt (step 7).
include(":mame")
// RetroArch (libretro frontend) as the built-in "RetroArch" app, package com.retroarch (upstream package kept: the native code calls the Java classes by name).
// Upstream: https://github.com/libretro/RetroArch (GPL-3.0), pinned in retroarch/UPSTREAM_VERSION (v1.22.2) + retroarch/UPSTREAM_COMMIT, see retroarch/README.md and NOTICE-RetroArch.md (licence files + GPL-3.0 compatibility note, step 9).
// Cores are NOT bundled: RetroArch's own Online Updater (Core Downloader) fetches them at run time (this worked while :app kept targetSdk 28; at the targetSdk 37 of part 8 Android blocks loading them from the data folder: -PappTargetSdk=28 goes back, see docs/CHANGES-mika-part8.md).
// All 12 steps done (step 12 = final static checks; docs step 11; CI: cache, fetch step, ccache and APK check in both workflows, step 10): the C source is NOT in the project zip: retroarch/tools/fetch-upstream.sh (step 4) clones it into retroarch/upstream/ (commit-checked) before every build.
// The native library libretroarch-activity.so is built from it by upstream's Android.mk (ndk-build, step 5; -PretroarchNative=false switches it off).
// The small Java part (10 files incl. the SAF VFS and the play-core stub), resources (prefix "ra_") and the library manifest are IN the project (step 6): RetroArch runs in its own process ":retroarch" (upstream calls System.exit / exit), activities not exported. App hooks (step 8): app/.../RetroArchLauncher.kt = Start menu entry, Home icon, rizwans2://retroarch and File Manager (console ROM files); 64-bit ARM only.
include(":retroarch")
// Seal (video / audio downloader, yt-dlp) as the built-in downloader app, package com.junkfood.seal (upstream package kept: the sources import its R / BuildConfig).
// Upstream: https://github.com/JunkFood02/Seal (GPL-3.0), pinned in seal/UPSTREAM_VERSION + seal/UPSTREAM_COMMIT (v2.0.0-alpha.5), see NOTICE-Seal.md.
// The Kotlin sources are IN the project (seal/src, seal-color/src); the yt-dlp engine (Python, yt-dlp, FFmpeg, aria2c) is a Maven library, so nothing is fetched at build time.
// Resources prefixed "sl_". Built step by step, see seal/README.md. App hooks (Start menu, Home icon, rizwans2://seal, browser) come in part 6.
include(":seal-color")
include(":seal")
// TUI-ConsoleLauncher (Linux terminal launcher theme) as the built-in "Terminal" theme, package ohi.andre.consolelauncher (upstream package kept: the sources import its R / BuildConfig).
// Upstream: https://github.com/fandreuz/TUI-ConsoleLauncher (MIT), see NOTICE-TUI.md and the "Two launcher themes" section of README.md.
// Only the Java sources, resources (prefix "tui_") and a trimmed library manifest are in the project; :app stays the only HOME activity. Built step by step, see README.md (all 13 steps done: module, dependencies, sources, resources, Java references, manifest + licence, terminal screen as a normal activity, saved theme + routing, switch UI, shared lists + built-in apps, polish, final check; always part of every build, not an optional module).
include(":tui")
// Mika (on-device AI agent) as the built-in "Rizwan" assistant: :mika (Android library, package com.wangzan101.mika, upstream package kept: 837 files import its R / BuildConfig)
// + :mika-core (its pure JVM part). Upstream: https://github.com/wangzan101/Mika (Apache-2.0), pinned in mika/UPSTREAM_VERSION (0.1.52) + mika/UPSTREAM_COMMIT, see NOTICE-Mika.md and mika/README.md.
// The sources are NOT in the project zip: mika/tools/fetch-upstream.sh clones them into mika/upstream/ and mika/tools/patch-upstream.sh turns them into a library, both run by Gradle
// (tasks :mika:fetchMikaUpstream / :mika:patchMikaUpstream, before :mika's preBuild) so every build, local or CI, needs git + python3 + network once (about 83 MB, cached afterwards).
// Resources are not prefixed (only 13 clashing names get "mk_", done by the patch script). Wired in part 5; App (part 6), manifest (part 7) and the Start menu / Home icon / rizwans2://rizwan hooks (part 8, app/.../MikaLauncher.kt) are done, see mika/README.md. :app targets SDK 37 since part 8 (-PappTargetSdk=28 goes back).
// -PincludeMika=false (or includeMika=false in gradle.properties) leaves both modules, and the :app dependency on them, out of the build. It does NOT compile by itself: AppBase extends MikaApp, and MikaLauncher names a Mika class.
// The "without" workflow (UltimateBuild_WithoutMe.yml, input include_mika, part 9) deletes the two modules and swaps AppBase.kt and MikaLauncher.kt for mika/tools/stub/*.stub; do the same by hand for a local build without Mika.
val includeMika = (providers.gradleProperty("includeMika").orNull ?: "true") != "false"
if (includeMika) {
    include(":mika-core")
    include(":mika")
}

# MAME (MAME4droid) — step 1: project and upstream analysis

Date: 2026-11-23. Input zip: `RizwanS2-youtube-step6.zip` (flat, 4336 files, 12.6 MB). Nothing was changed in code or Gradle in this step; only documentation was added.

## 1. This project (read from the zip)

- Root project name `Win11`; AGP 8.13.2, Gradle 8.14.3, Kotlin 2.2.10; compileSdk 37, `:app` minSdk 26, targetSdk 28, version 2.5.3 (code 120).
- One NDK for every native module: `ext.ndkVer = 29.0.13846066`; CMake 3.22.1 (used by `:ppsspp`); `:Bcore`, `:j2me`, `:winlator` use ndk-build.
- Modules: app, Bcore, black-reflection, compiler, winlator, youtube, video, gallery, chooser, j2me, j2me-dexlib, camera, ppsspp.
- Emulator pattern already in the project (`:ppsspp`, `:j2me`): own library module, upstream package kept, resources prefixed (`pp_`), no LAUNCHER icon, library manifest merged into `:app`,
  the big upstream source is NOT in the zip (`tools/fetch-upstream.sh` + `UPSTREAM_VERSION`, git-ignored `upstream/`), hooks in `:app` (`StartApps.kt`, `Win11Shell.kt`, `MainActivity.kt` deep link,
  `FileManagerUi.kt`, a `XxxLauncher.kt`), CI in `.github/workflows/UltimateBuild.yml` and `UltimateBuild_NoWinlator.yml`, licence in `NOTICE-*.md` + `LICENSE-*`.
- The MAME module should copy exactly this pattern (module `:mame`, resources prefix `mm_`, `MameLauncher.kt`, `rizwans2://mame`, `NOTICE-MAME4droid.md`, `LICENSE-MAME4droid`).

## 2. Upstream: MAME4droid (Current)

- Repo: https://github.com/seleuco/MAME4droid-Current (old name `MAME4droid-2024` redirects here). Author David Valdeita (Seleuco). Licence: **GPL-2.0** (`LICENSE` / `COPYING` in the repo).
- Latest release: **v1.41.2** (2026-09-16), MAME core **0.289**. Release asset: `MAME4droid.2026-1.41.2-release.apk` (169 MB).
- Repo size: 135 MB (66 MB git history, 66 MB `res/`). Java: 50 files (about 1 MB), JNI: `mame4droid-jni.c`, ndk-build (`Android.mk`, `Application.mk`), ABI `arm64-v8a` only, NDK 28.2.13676358.
- Upstream app: package `com.seleuco.mame4d2024`, minSdk **29**, targetSdk 37, 7 activities (`MAME4droid`, `UserPreferences`, `WebHelpActivity`, `DefineKeys`, `ListKeys`, `KeySelect`), permissions VIBRATE, INTERNET, ACCESS_WIFI_STATE, WAKE_LOCK, ACCESS_LOCAL_NETWORK.
- Features: touch controls, gamepad, SAF ROM folder (`SAFHelper`), OpenGL view (`EmulatorViewGL`), NetPlay (rollback / lockstep, public rooms), ADPF thermal helper.

## 3. Important findings (they change the plan)

1. **The MAME core is NOT in the repo.** The repo has only the Android frontend and the OSD glue (`src/osd/myosd`, patches for `src/emu`). `mame4droid-jni.c` does `dlopen("<nativeLibDir>/libMAME4droid.so")`;
   `jniLibs/arm64-v8a/` is empty (git-ignored). `howtobuild.txt`: download MAME 0.289 source, copy `src/` over it, edit the makefile / lua scripts, build the OSD. Upstream `build.sh` still points at NDK r10c (stale).
   Building the real core from MAME source in CI is a very large native build (hours, many GB) and not tested here.
2. **Two ways to get `libMAME4droid.so`** (decision for step 2):
   - **A (recommended default):** CI downloads the official release APK `v1.41.2`, takes `lib/arm64-v8a/libMAME4droid.so` out of it and packs it as this module's `jniLibs`. Fast and known to work. GPL-2.0 duty: keep the licence, credit, and a link to the exact source (tag v1.41.2 + MAME 0.289).
   - **B:** build the core from MAME 0.289 + the repo's patches in CI. Full source control, but heavy and risky; can be added later as an optional workflow.
3. **minSdk clash:** upstream minSdk is 29, this project's `:app` is 26. A library with a higher minSdk makes the manifest merge fail. Step 3 must check why 29 is needed (Java uses `Build.VERSION.SDK_INT >= Q / R` guards, so the Java side looks 26-safe;
   the native `.so` is built with `-Wl,-z,max-page-size=16384` and may need API 29 symbols). If the `.so` really needs 29, the options are `tools:overrideLibrary` with a runtime check (MAME hidden below Android 10) or raising `:app` minSdk.
4. **ABI:** `arm64-v8a` only (same as `:ppsspp` / `:winlator`). 32-bit phones will not run MAME.
5. **Package names:** the JNI header `com_seleuco_mame4droid_Emulator.h` ties the native function names to `com.seleuco.mame4droid.Emulator`, so the Java package must be kept (same rule as `:ppsspp`). The module namespace will be `com.seleuco.mame4droid`.
6. **Size:** `res/` is 66 MB (mostly skins / images). Not stored in the zip; fetched with the source. Final APK grows by roughly the `.so` (tens of MB) plus the resources.
7. **Licence correction:** the earlier chat note about an old "non-commercial" MAME licence is out of date for this upstream: MAME4droid (Current) is GPL-2.0, MAME 0.289 itself is GPL-2.0+ / BSD-3-Clause (per file). No non-commercial clause here. Still check before publishing (GPL code in the same process as Apache-2.0 / LGPL parts, same note as PPSSPP).
8. **ROMs:** never included. User picks a folder (SAF). ROM set version must match core 0.289.

## 4. Updated plan (MAME4droid path, 9 steps)

| # | Step | Status |
|---|------|--------|
| 1 | Read this project and the upstream (this file) | done |
| 2 | Choose core source (A prebuilt from release APK / B build) and pin version (`mame/UPSTREAM_VERSION`), licence files (`NOTICE-MAME4droid.md`, `LICENSE-MAME4droid`) | done: plan A, see `mame/README.md` |
| 3 | `:mame` library module: Java (50 files), `mm_` resources, manifest, Gradle (`settings.gradle.kts`, `:app` dependency), minSdk decision, fetch script | done, see `mame/README.md` |
| 4 | ROM folder + game list (SAF, `.zip` / `.7z`), where upstream keeps its data | done, see `mame/README.md` |
| 5 | Emulation screen: GL view, touch controls (vector icons), gamepad, coin / start | done (kept from upstream, checked), see `mame/README.md` |
| 6 | Settings: filters, sizes, audio, frameskip, button map, save / load state | done (kept from upstream, one fix), see `mame/README.md` |
| 7 | Hooks in `:app`: Start menu, Home icon, `rizwans2://mame`, File Manager (`.zip` is risky: only from inside the MAME ROM folder), `MameLauncher.kt` (File Manager not hooked on purpose; `App.kt` guard for the `:mame` process added) | done, see `mame/README.md` |
| 8 | CI: fetch / extract core, APK check (`libMAME4droid.so` present), cache, timeout | done: fetch step + APK size check in both workflows, no cache on purpose, timeout unchanged, see `mame/README.md` |
| 9 | Update all details (README, docs, comments), static checks, final flat zip `RizwanS2-youtube-step7.zip` | done, see `mame/README.md` step 9 |

PS2 (PCSX2 / LRPS2) stays out of this work; it can be a later, separate plan.

## 5. Not verified here

No Gradle, NDK, device or CI run in this environment. Upstream facts above were read from the GitHub repo and API on 2026-11-23 (`MAME4droid-Current` main at commit 9df33ca, tag v1.41.2).
The one claim still unchecked is whether `libMAME4droid.so` really needs API 29 (step 3 checks it by reading the release APK's `.so`).

## 6. Step 2 results (2026-11-23)

- Plan **A** chosen. Pinned: tag v1.41.2, MAME 0.289; release APK and core `.so` sizes and SHA-256 in `mame/UPSTREAM_SHA256` (read from the real downloaded file).
- The core `.so` imports nothing above API 21, so finding 3 (minSdk) is now only about the Java side. New finding: the core is **367 MB** (APK 169 MB): see the size decision in `mame/README.md`.
- Added: `mame/UPSTREAM_VERSION`, `mame/UPSTREAM_SHA256`, `mame/README.md`, `NOTICE-MAME4droid.md`, `LICENSE-MAME4droid`; `.gitignore` lines for `mame/upstream/` and `mame/core/`. `settings.gradle.kts` and all build files are unchanged.

## 7. Step 3 results (2026-11-23)

- Your decision: core inside the APK (like PPSSPP). `:mame` is now a Gradle library module wired into `settings.gradle.kts` and `:app`; details, checks and the "not verified" list: `mame/README.md` (section "Step 3").
- Finding 3 (minSdk) is closed: minSdk stays 26; two unguarded API 28 / 29 calls in the Java code were guarded; the rest was already guarded.
- Finding 5 (package) applied: namespace `com.seleuco.mame4droid`.
- New facts: upstream's `res/raw/files.zip` is 64 MB (the whole upstream `res/` size); the other 50 Java files + resources + assets are only about 6 MB, so they are stored in the project zip and edited in later steps.

## 8. Step 4 results (2026-11-23)

- Upstream already has the SAF ROM folder flow and a game list (MAME's own menu): kept. Added `MameLaunch` (entry point for step 7).
- New finding that corrects step 3: upstream kills its own process on exit and keeps settings in the app-wide default SharedPreferences file. Fixed with process `:mame` + own task and `MamePrefs` (own settings file). Details: `mame/README.md`, section "Step 4".

## 9. Step 5 results (2026-11-23)

- The emulation screen, touch controls and gamepad support are upstream's and stay as they are (checked for use inside Win11). The control skins stay PNG artwork (not converted to vectors).
- New finding: upstream sent the host app's `versionName` to the core and the NetPlay lobby; fixed with `MameLaunch.UPSTREAM_VERSION` (+ a build-time consistency check). Both native libraries are 16 KB page aligned.

## 10. Step 6 results (2026-11-23)

- Settings are upstream's and stay (168 keys). One fix: the 30 slider rows used a hidden platform class; replaced by `MameSeekBarPreference`. XML consistency checked; no Bengali translation exists.

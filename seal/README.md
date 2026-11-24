# :seal — built-in Seal (video / audio downloader, yt-dlp)

Upstream: https://github.com/JunkFood02/Seal, pinned in `UPSTREAM_VERSION` (**v2.0.0-alpha.5**, versionCode 200000150) and `UPSTREAM_COMMIT`
(`7677f61a20fda4210e84215fef9e9b51d25daa47`, 2026-09-25, "docs(readme): update sponsor info"). Licence: GPL-3.0, see `../NOTICE-Seal.md` and `../LICENSE-Seal`.

> **Status: all 10 parts done (static checks passed in part 10, see `../docs/CHANGES-seal-part10.md`; nothing was built or run).** `:seal` and `:seal-color` are in `settings.gradle.kts`, `:app` depends on `:seal`, so **the next CI run compiles Seal for the first time**. Nothing here was built: no Android SDK / NDK / Maven / device in the sandbox, the real build is the GitHub workflow.

## Overview (part 9) — read this first

**What it is.** Seal (video / audio downloader around yt-dlp, FFmpeg, aria2c) built into the launcher as the app **Downloader** (upstream forbids other parties from using the name "Seal" for a downloader, derivatives included; credit stays in the app's About / Credits page and in `NOTICE-Seal.md`). It runs inside the launcher's own process (no second app, no second icon, no share-sheet entry, no link handling).

**How the user gets to it.** Start menu entry "Downloader", Home screen icon "Downloader", deep link `rizwans2://seal` (alias `downloader`; `?url=<http(s) link>` opens its download sheet for that link), Browser link long-press "Download with Downloader", Media Grabber "Downloader" pills and "Page -> Downloader". Files go to the public Downloads folder (video `Download/`, audio `Download/Audio`, temp `Download/.downloader-tmp`); a folder chosen in Seal's own settings wins.

**How to build it.**
| Workflow | Seal | Notes |
|---|---|---|
| `UltimateBuild.yml` | always included | normal signed release |
| `UltimateBuild_NoWinlator.yml` | always included | only Winlator can be left out |
| `UltimateBuild_WithoutMe.yml` | tick box `include_seal` (default on) | unticked = `seal/` + `seal-color/` deleted, `SealLauncher.kt` stub, start-up block / Start menu entry / Home icon removed, in the temporary checkout only |
All three: no fetch / cache step for Seal (sources in the repo, engine from Maven Central); after the build `seal/tools/check-apk-native.sh` and `seal/tools/check-merged-manifest.py` check the APK; optional input `apk_abis` (empty = unchanged; e.g. `arm64-v8a,armeabi-v7a`, `arm64-v8a` required) drops the x86 copies. Local build: `./gradlew :app:assembleDebug` (compiles `:seal`; the optional `-PapkAbis=...` works there too).

**Size.** Expect roughly +50-100 MB (Python, FFmpeg, aria2c for 4 ABIs; an estimate from part 1, **not measured**). `apk_abis` is the biggest saving. The first real APK will tell: the check script prints the sizes.

**What is where.**
| Path | Content |
|---|---|
| `seal/src/main/java` (125 Kotlin files), `seal/src/main/res` (99 files, all names prefixed `sl_`), `seal/schemas` | Seal's code, resources, Room schemas; package `com.junkfood.seal` kept |
| `seal/src/main/AndroidManifest.xml` | library manifest (written in part 5; copy in `seal/tools/overlay-main/`) |
| `seal-color/src/main/java` (11 files) | Seal's colour code (`:color` upstream) |
| `seal/reference/AndroidManifest.upstream.xml` | upstream's manifest, reference only (not merged) |
| `seal/UPSTREAM_VERSION`, `seal/UPSTREAM_COMMIT` | pinned upstream (v2.0.0-alpha.5, `7677f61`) |
| `app/.../SealLauncher.kt` + hooks in `StartApps.kt`, `Win11Shell.kt`, `MainActivity.kt`, `BrowserUi.kt`, `BrowserMediaGrabber.kt`, `App.kt` | the host side (part 6, start-up call part 4) |
| `seal/tools/import-upstream.py`, `win11_patches.py`, `overlay/`, `overlay-main/` | reproduce the tree from an upstream checkout: `python3 -I seal/tools/import-upstream.py UPSTREAM_CHECKOUT` |
| `seal/tools/check-apk-native.sh`, `check-merged-manifest.py` | APK / merged-manifest checks (parts 7, 8) |
| `NOTICE-Seal.md`, `LICENSE-Seal` | GPL-3.0 notice and licence text |
| `docs/CHANGES-seal-part1.md` ... `part9.md` | one file per part (index in part 9's file) |

**Updating Seal later.** Check out the new upstream commit, change `UPSTREAM_VERSION` / `UPSTREAM_COMMIT`, run `import-upstream.py` (it wipes `seal/src`, copies, prefixes, re-applies every Win11 patch), then re-check: new strings / resources get `sl_` automatically; a changed upstream manifest has to be compared with `seal/reference/` by hand; Kotlin / Compose / Room versions in `seal/build.gradle.kts` follow the project's Kotlin 2.2.10.

**Open points and honest risks (nothing here was run on a device).**
1. First compile of `:seal` is untested: Kotlin 2.2.10 + KSP / Room 2.8.5 + Compose compiler on code written for Kotlin 2.0.20. If it fails, send the first error lines.
2. `libc++_shared.so` is `pickFirst` for the whole app (Winlator, J2ME, ffmpeg-kit, oboe, MMKV): if the kept copy is too old for one library, that library fails at run time. The check script prints the kept copy.
3. Android 10 (API 29) only: the host declares `WRITE_EXTERNAL_STORAGE` with `maxSdkVersion=28`, Seal asks for it on API 29 -> "permission denied" there (part 7, not changed).
4. Downloads folder: the public Downloads folder itself instead of a `Download/Downloader` subfolder (one-line alternative in `docs/CHANGES-seal-part6.md`).
5. yt-dlp updates itself from the network at run time (Seal's yt-dlp updater is kept on purpose); Seal's own APK self-update is removed.
6. Licence: Seal and `youtubedl-android` are GPL-3.0; the app already contains GPL-2.0-or-later (PPSSPP, MAME), GPL-3.0 (RetroArch), Apache-2.0 and LGPL parts, so the combined app is normally distributed under GPL-3.0 terms. General note, not legal advice: check before publishing; offer the complete source.

## Plan (10 parts)

| # | Part | Status |
|---|------|--------|
| 1 | Pin the source, analysis, `NOTICE-Seal.md` + `LICENSE-Seal`, list of what is copied / dropped | **done** |
| 2 | Create `:seal` and `:seal-color` folders, copy the sources (package `com.junkfood.seal` kept), `sl_` resource prefix, clash scan | **done** |
| 3 | Gradle: compose-compiler / serialization / ksp plugins (on Kotlin 2.2.10), dependencies, `settings.gradle.kts`, `:app` dependency | **done** |
| 4 | `SealInit` (MMKV, Koin, YoutubeDL / FFmpeg / Aria2c, notification channel) called from the host `App.kt`; no second crash handler, no DynamicColors; app self-update removed | **done** |
| 5 | Manifest merge: activities, service, FileProvider, permissions; no LAUNCHER / http / SEND filters of its own | **done** |
| 6 | Hooks: Start menu, Home screen icon, `rizwans2://seal`, Browser / MediaGrabber "download with Seal", download folder | **done** |
| 7 | targetSdk 28 checks, native libs (`extractNativeLibs`, `libc++_shared`), ABI, APK size | **done** |
| 8 | CI: `UltimateBuild.yml`, `UltimateBuild_NoWinlator.yml`, `UltimateBuild_WithoutMe.yml` | **done** |
| 9 | Root `README.md`, this file, `docs/CHANGES-seal-*.md` | **done** |
| 10 | Static checks and the final flat zip | **done** |

## Part 1 — what Seal is (measured on the pinned commit)

- Kotlin + Jetpack Compose (Material 3), package `com.junkfood.seal`, `applicationId com.junkfood.seal`, minSdk 24, targetSdk 35, compileSdk 35.
- Two Gradle modules upstream: `:app` and `:color` (Kyant0 "Monet" colour code + `io.material.hct`; namespace `com.junkfood.seal.color`, 11 files).
- `:app`: **126 Kotlin files** (1.7 MB), **99 resource files** (2.4 MB; `values/strings.xml` has 430 strings, plus 61 `values-*` translation folders), 5 Room schema files (`schemas/1..5.json`).
- No C/C++ and no assets folder: the download engine comes from the Maven library `io.github.junkfood02.youtubedl-android` **0.17.3** (`library`, `ffmpeg`, `aria2c`: Python, yt-dlp, FFmpeg, aria2c as native libs / zips).
  So — unlike PPSSPP / MAME / RetroArch — **nothing has to be cloned or downloaded at build time**: the Kotlin source goes into the project, the rest comes from Maven.
- Dependencies (versions from upstream's `libs.versions.toml`): Compose BOM `2025.03.01` (alpha BOM), material3 + window-size-class, icons-extended, navigation-compose 2.8.9, lifecycle 2.8.7,
  activity-compose 1.10.1, accompanist 0.34.0 (permissions, webview, pager-indicators), coil-compose 2.5.0, kotlinx-serialization-json 1.7.2, kotlinx-datetime 0.6.1, coroutines 1.9.0,
  Koin 4.0.0 (android + compose), Room 2.6.1 (+ KSP), OkHttp 5.0.0-alpha.10, MMKV 1.3.12 (pinned to 1.3.x for 32-bit), constraintlayout-compose, graphics-shapes, material 1.12.0, appcompat 1.7.0.
- Where it hooks into Android (upstream manifest): `MainActivity` (LAUNCHER, SEND text/plain, VIEW http/https/video/audio), `QuickDownloadActivity` (dialog for shared links), `CrashReportActivity`,
  `DownloadService` (foreground, `specialUse`), `NotificationActionReceiver`, FileProvider `${applicationId}.provider` (paths: external + cache), `AppLocalesMetadataHolderService`.
  Permissions: INTERNET, ACCESS_NETWORK_STATE, FOREGROUND_SERVICE (+ `_SPECIAL_USE`), POST_NOTIFICATIONS (33+), REQUEST_IGNORE_BATTERY_OPTIMIZATIONS, REQUEST_INSTALL_PACKAGES, MANAGE_EXTERNAL_STORAGE, WRITE_EXTERNAL_STORAGE (max 29).

## Part 1 — fit with the Win11 project (checked, nothing changed yet)

| Topic | Win11 now | Seal upstream | What it means (part) |
|-------|-----------|---------------|----------------------|
| Kotlin | 2.2.10 (`kotlin-stdlib` pinned to it) | 2.0.20, KSP `2.0.20-1.0.25` | Compose compiler plugin and KSP must follow 2.2.10; Room 2.6.1 stays (3) |
| AGP | 8.13.2 | 8.7.2 | fine, `com.android.library` (3) |
| minSdk / targetSdk | 26 / 28 | 24 / 35 | 26 is above Seal's 24, so nothing to lower. targetSdk 28 (host) changes some behaviour (notification permission, storage) (7) |
| Compose | `:app` has `compose = false` | Compose everywhere | Compose is switched on **only inside `:seal`** (`buildFeatures.compose`), `:app` stays View-based; `:app` only starts Seal's `MainActivity` (3; the class is called `MainActivity` upstream, there is no `SealActivity`; the host has its own `com.srizwan.win11.MainActivity`, the full names differ so nothing clashes) |
| R class | `android.nonTransitiveRClass=false` (host), `nonFinalResIds=false` | `true` / `true` | library R is non-final already; resource names must not clash with `:app` and other modules (scan in 2) |
| Application class | own `App` (BlackBox, J2ME, MAME / RetroArch processes) | own `App` (Koin, MMKV, yt-dlp init, crash screen, `DynamicColors`) | `App.kt` content moves into `SealInit.init(app)`, called from the host `App.onCreate` in the launcher process only (4) |
| Koin | not used | used for 5 ViewModels + `DownloaderV2` | started inside `SealInit` (4) |
| FileProvider | `.chooser.fileprovider`, `.gallery.fileprovider`, `.winlator.fileprovider`, ... | `${applicationId}.provider` | **authority: no clash** (checked in every manifest). **Class name: would clash** — every module uses its own `FileProvider` subclass, so Seal gets `SealFileProvider` in part 5; `getFileProvider()` in `FileUtil.kt` stays valid (5) |
| `libc++_shared.so` | `pickFirsts` in `:app` | yt-dlp libs ship none of their own to clash | confirm in (7) |
| Package rename in CI | rewrites the *host* old package name | — | Seal's package `com.junkfood.seal` is not the host package, so the rename step does not touch it; verify in (8) |

## Part 1 — what goes into the project and what does not

Copied in part 2 (with the edits of parts 3-5):
- `app/src/main/java/**` (126 files) -> `seal/src/main/java/`
- `app/src/main/res/**` (99 files) -> `seal/src/main/res/` (names that clash with the project get the `sl_` prefix, decided by the scan in part 2)
- `app/schemas/*.json` (Room, 5 files) -> `seal/schemas/`
- `app/proguard-rules.pro` -> `seal/consumer-rules.pro` (yt-dlp, commons-compress and kotlinx-serialization keep rules; `:app` does not minify, so it is only a safety net)
- `color/**` -> `seal-color/` (own module, same namespace)

Dropped on purpose:
- `buildSrc/` (version object), `fastlane/`, `translations/` (README translations), `.github/`, Gradle wrapper, `CHANGELOG.md`, `CONTRIBUTING.md`, `CODE_OF_CONDUCT.md`, `README.md` (upstream's own readme stays at upstream).
- Upstream's build logic: product flavors (`generic` / `githubPreview` / `fdroid`), ABI splits, versionCode maths, keystore signing, `applicationIdSuffix`, ktfmt, APK file naming. One variant, built as a library.
- Upstream's own launcher entry and its `http(s)` / `SEND` / `VIEW video|audio` intent filters (they would add a second launcher icon and make the whole app a handler for every link) — part 5.
- The self-update code: `UpdateUtil` (app update from GitHub), `AppUpdater`, `UpdateDialog`, `UpdatePage` and the app-update parts of `AppEntry` / `TroubleshootingPage` / `GeneralDownloadPreferences`.
  An embedded Seal must never offer to install a different "Seal" APK over Win11 (`REQUEST_INSTALL_PACKAGES` too). The **yt-dlp** updater (`YtdlpUpdater`) stays: yt-dlp breaks when sites change, so it must be able to update.
  **Done in part 4** (what was really cut: see "Part 4" below); the manifest side (`REQUEST_INSTALL_PACKAGES` is simply not written) follows in part 5.
- `BuildConfig.FLAVOR` / `BuildConfig.DEBUG` use in `App.kt` (`isFDroidBuild`, `isDebugBuild`): planned as constants in part 4, **decided against**: part 3 already gives `:seal` a `BuildConfig` with `FLAVOR = ""`, so the two functions are unchanged (`isFDroidBuild()` is always false; `isDebugBuild()` follows the `:seal` build type).

## Part 1 — things you must decide / know (they change later parts)

1. **Name.** Seal's README: *"all other parties are prohibited from using Seal's name as a downloader app, and the same is true for Seal's derivatives (forks, unofficial builds)."*
   Building it in under the name "Seal" is exactly that. Plan for part 6: the Start menu / Home entry gets a **neutral name** (default: **Downloader**), the in-app title and the app-name string
   are changed accordingly, and the credits page keeps "based on Seal by JunkFood02". Say so if you want another name. The source code itself stays GPL-3.0 (that part is allowed).
2. **GPL-3.0 on the whole app.** Seal is GPL-3.0-only-or-later style (full text in `LICENSE-Seal`). The app already holds PPSSPP / MAME (GPL-2.0-or-later), RetroArch (GPL-3.0), J2ME / BlackBox (Apache-2.0), Winlator (LGPL):
   the combined APK is normally distributed under GPL-3.0 terms. Written in `NOTICE-Seal.md`, not legal advice — check before publishing.
3. **APK size.** The yt-dlp library adds Python + yt-dlp + FFmpeg + aria2c (about 50-100 MB for arm64; not measured here).
4. **Not testable here.** No Android SDK / NDK / network for Gradle: static checks only; the real build runs in your GitHub workflow.
5. **Network for downloads.** Seal needs the `INTERNET` permission (the host already has it) and downloads into the folder you choose in its settings; part 6 points the default to the Win11 Downloads folder.

## Part 8 — the three build workflows

Details: `docs/CHANGES-seal-part8.md`. Short form:
- **No fetch / cache step** (Kotlin sources in the repo, engine from Maven). The package rename never touches Seal.
- **New checks after the build** (all three workflows, step "Locate Unsigned APK"): `seal/tools/check-apk-native.sh` (Python + MMKV libraries of arm64-v8a must be in the APK) and `seal/tools/check-merged-manifest.py` (Seal's 3 activities, service, receiver, FileProvider are in the merged manifest, and **no** Seal activity has an intent filter or a LAUNCHER category).
- **`UltimateBuild_WithoutMe.yml`**: tick box `include_seal` (default on). Off = `seal/` + `seal-color/` deleted, `SealLauncher.kt` replaced by a stub, `App.kt` start-up block, Start menu entry, Home icon and one Media Grabber pill removed (temporary checkout only). `UltimateBuild.yml` and `UltimateBuild_NoWinlator.yml` always include Seal.
- **`apk_abis`** (all three, default empty = unchanged build): e.g. `arm64-v8a,armeabi-v7a` drops the x86 copies; `arm64-v8a` is required.
- **Bug fixed** in `WithoutMe`: unticking PPSSPP would have left `),,` in `StartApps.kt` (the Downloader entry follows PPSSPP). Found by running the extracted script on project copies for six tick-box combinations.
- Tested here: YAML, shell syntax, the removal script run on copies, the ABI step, the APK-check block on fake APKs. **Not run:** GitHub Actions, Gradle, a real APK.

## Part 7 — targetSdk 28, native libraries, ABI, APK size

Details: `docs/CHANGES-seal-part7.md`. Short form (all from the sources, nothing was built here):
- **targetSdk 28**: no change needed. Programs may run from the native library folder (blocked only for 29+, the reason the project uses 28 for Winlator); all-files access is forced by the launcher at start, which Seal's "no storage prompt above API 29" relies on. One gap: **Android 10 only** (host declares `WRITE_EXTERNAL_STORAGE` with `maxSdkVersion=28`, Seal asks for it on API 29) — not changed.
- **Native libraries**: `:app` already extracts them (`useLegacyPackaging = true` + `android:extractNativeLibs="true"`); `pickFirsts` already covers `libc++_shared.so` (risk: one kept copy for the whole app, MMKV is one more user; unproven, `seal/tools/check-apk-native.sh` shows the kept copy).
- **ABI / size**: new optional `-PapkAbis=arm64-v8a,armeabi-v7a` (`:app` `ndk.abiFilters`, default off). Size not measured.
- **`seal/tools/check-apk-native.sh APK [abi]`**: reports the engine libraries inside a built APK (run by the three workflows since part 8).

## Part 6 — hooks, download folder, name (`SealLauncher.kt` in the host + patches in `win11_patches.py`)

Everything is listed in `docs/CHANGES-seal-part6.md`; short form:
- **Start menu / Home screen / taskbar section `seal`** -> `openSeal()` -> `com.junkfood.seal.MainActivity` (explicit intent, same task). Shown as **Downloader** (`SEAL_NAME` in `SealLauncher.kt`; `sl_app_name` and the default notification title in `strings.xml` changed by `RES_PATCHES`).
- **Deep link** `rizwans2://seal` (alias `downloader`); `rizwans2://seal?url=<http(s) link>` opens the download sheet for the link.
- **Browser:** link long-press menu "Download with Downloader"; Media Grabber: a "Downloader" pill on media / embed / link rows and "Page -> Downloader" in the action row (rows scroll sideways when narrow).
- **How a link gets in:** explicit `ACTION_SEND` + `EXTRA_TEXT` to `MainActivity`. Patched: `onCreate` reads it too (upstream only `onNewIntent`), so a cold start opens the sheet.
- **Download folder:** `FileUtil.getExternalDownloadDirectory()` is now the public Downloads folder itself (video `Download/`, audio `Download/Audio`, temp `Download/.downloader-tmp`); a folder picked in Seal's settings still wins. Trade-off and the one-line alternative (`Download/Downloader`) are in the CHANGES file.
- **Language page hidden** (it would change the language of the whole launcher); **no share-sheet filter**, **no second icon**.
- Decided against: `QuickDownloadActivity` as the target (its overlay window type is unverified from an in-app start).

## Part 5 — manifest (`seal/tools/overlay-main/AndroidManifest.xml` -> `seal/src/main/AndroidManifest.xml`)

The manifest is kept in `tools/overlay-main/` and copied by `win11_patches.apply()` (`import-upstream.py` wipes `seal/src` first). Library manifest, no `package` (namespace is in `build.gradle.kts`), merged into `:app`.
Starting point: `reference/AndroidManifest.upstream.xml`. Full list of differences is in the comment at the top of the manifest.

| Component | Upstream | Here |
|-----------|----------|------|
| `MainActivity` | `exported=true`, LAUNCHER + SEND text/plain + VIEW http(s)/video/audio filters, `singleTask`, `Theme.Seal` | **no filter, `exported=false`**, `singleTask`, `Theme.Seal`, label `@string/sl_app_name`, icon `@mipmap/sl_ic_launcher` |
| `QuickDownloadActivity` | `exported=true`, SEND + VIEW filters, `singleInstance`, `excludeFromRecents`, `Theme.Seal.Dialog` | **no filter, `exported=false`**, rest unchanged, label `@string/sl_title_activity_share` |
| `CrashReportActivity` | `exported=false` | same (nothing opens it at start-up since part 4) |
| `DownloadService` | `specialUse`, `exported=false` | same + `PROPERTY_SPECIAL_USE_FGS_SUBTYPE` ("yt-dlp video and audio downloads") |
| `NotificationActionReceiver` | no `exported` (implicitly false) | `exported=false` written out |
| FileProvider | `androidx.core.content.FileProvider` | **`com.junkfood.seal.SealFileProvider`** (new, overlay file), authority `${applicationId}.provider`, paths `@xml/sl_provider_paths` — two providers with the class `androidx.core.content.FileProvider` would fail the merge, which is why `ChooserFileProvider`, `GalleryFileProvider` and `WinlatorFileProvider` exist |
| `AppLocalesMetadataHolderService` | declared, `autoStoreLocales=true` | **not declared** (see "Language" below) |

**Why no filters.** With them, "Downloader" would appear in every share sheet and offer to open every link on the phone, and the launcher would get a second icon. Links reach Seal through explicit intents
(`ACTION_SEND` + `EXTRA_TEXT`, or `ACTION_VIEW` + data), and both activities already read exactly those two in `getSharedURL()`; an explicit intent from the same app needs no filter and no `exported=true`.
If you later want "Share to Downloader" from other apps, it is one `<intent-filter>` on `QuickDownloadActivity` (not added in part 6; it would put "Downloader" into every share sheet).

**Permissions.** `INTERNET`, `ACCESS_NETWORK_STATE`, `FOREGROUND_SERVICE`, `POST_NOTIFICATIONS`, `MANAGE_EXTERNAL_STORAGE` are declared by `:app` too (identical, merge without conflict).
**New for the whole launcher APK:** `FOREGROUND_SERVICE_SPECIAL_USE` (normal, no prompt) and `REQUEST_IGNORE_BATTERY_OPTIMIZATIONS` (normal, no prompt; Seal's settings button "ignore battery optimisation" needs it).
**Left out:** `REQUEST_INSTALL_PACKAGES` (self-update removed in part 4) and `WRITE_EXTERNAL_STORAGE` (`:app` has it with `maxSdkVersion 28`, correct for targetSdk 28; upstream's `maxSdkVersion 29` would only be a second value to merge).
Application-level attributes (`allowBackup`, `requestLegacyExternalStorage`, `extractNativeLibs`, `supportsRtl`, `enableOnBackInvokedCallback`, icon, label) stay with `:app`; `:app` already has `useLegacyPackaging` for native libs (part 7 re-checks).

**Language (known, decided in part 6).** Seal's language page calls `AppCompatDelegate.setApplicationLocales(...)` (`LanguageSettings.kt`), which changes the language of the whole launcher process, not only of Seal; on Android 13+ it goes to the system's per-app language.
Without `AppLocalesMetadataHolderService` the choice is not saved by AppCompat on Android 12 and lower. Decided in part 6: the page is hidden (entry removed from the appearance settings).

Static checks (here): manifest is well-formed XML; the 6 component classes exist as Kotlin files; every `@mipmap` / `@style` / `@string` / `@xml` reference exists in `seal/src/main/res`; no `<intent-filter>`, no `LAUNCHER`, no `REQUEST_INSTALL_PACKAGES` left; all 6 components are `exported=false`;
the authority `${applicationId}.provider` is not used by any other module; no other manifest names a `com.junkfood.seal` class; `win11_patches.apply()` run again (12 patches in place, 5 overlay files).
**Not run:** the manifest merge itself (Gradle / `processDebugManifest`), the build, a device. The merge is the first thing the next workflow run tests after the Kotlin compile; if it fails, send me the `Manifest merger failed` lines.
Reachable since part 6 (see "Part 6").

## Part 4 — start-up (`SealInit`) and removal of the self-update

Files: `seal/src/main/java/com/junkfood/seal/SealInit.kt` (new), `App.kt` (rewritten), `util/UpdateUtil.kt` (cut down), 3 screens deleted, 4 files patched, host `app/.../win11/App.kt` (3 lines + comment).
Everything that differs from upstream lives in `seal/tools/win11_patches.py` + `seal/tools/overlay/` and is applied by `tools/import-upstream.py` after the copy, so a re-import gives the same tree.

**1. Seal's `App` is no longer an `Application`.** The launcher's own `App` is the Application (BlackBox, J2ME, MAME / RetroArch processes). Seal's `com.junkfood.seal.App` keeps its **companion unchanged**
(`context`, `applicationScope`, `videoDownloadDir`, `audioDownloadDir`, `clipboard`, `connectivityManager`, `packageInfo`, `startService()`, `stopService()`, `privateDownloadDir`, `updateDownloadDir()`, `getVersionReport()`, `isFDroidBuild()`, `isDebugBuild()`),
because ~45 places in Seal read `App.xxx`; only `: Application()`, `onCreate` and `startCrashReportActivity` are gone (the class has a private constructor).

**2. `SealInit.init(app, onEngineError)`** does what upstream's `App.onCreate` did, in the same order (an `AtomicBoolean` makes a second call a no-op):

| Step | What | Note |
|------|------|------|
| 1 | `MMKV.initialize(app)` | settings storage, must be first (`PreferenceUtil`); nothing else in the project uses MMKV |
| 2 | `App.context`, `packageInfo`, `applicationScope`, `clipboard`, `connectivityManager` | set before `NotificationUtil` / `DownloadUtil` are touched (their `object`s read `App.context` when first used) |
| 3 | `startKoin { ... }` with `DownloaderV2` + 4 ViewModels | skipped if `GlobalContext.getOrNull()` is not null (Koin already started); nothing else in the project uses Koin |
| 4 | download folders `videoDownloadDir` / `audioDownloadDir` / `COMMAND_DIRECTORY` | part 6: the launcher's public Downloads folder (video `Download/`, audio `Download/Audio`); upstream: `Download/Seal` |
| 5 | `NotificationUtil.createNotificationChannel()` | no `SDK_INT` check (minSdk is 26); channels `download_notification` + `download_service` in one group |
| 6 | `YoutubeDL.init`, `FFmpeg.init`, `Aria2c.init`, cookies file from the database | on `Dispatchers.IO`; the first start unpacks Python / yt-dlp / FFmpeg (slow), later starts only check. `SealInit.engineReady` / `engineError` tell the result |

**Not taken over (on purpose):**
- `Thread.setDefaultUncaughtExceptionHandler { startCrashReportActivity }`: the launcher has its own handler (`AppLog.installCrashHandler()`); a second one would replace it and open Seal's crash screen for a crash of the whole launcher. `CrashReportActivity` stays in the sources (the notification action `ACTION_ERROR_REPORT` and part 5 may still use it), nothing starts it at start-up any more.
  An engine failure (step 6) used to open that screen; now it is `Log.e` + `AppLog.e("Seal", ...)` through the callback + `SealInit.engineError`.
- `DynamicColors.applyToActivitiesIfAvailable(this)`: it would recolour every Activity of the launcher. Seal's theme asks for dynamic colour itself (`PreferenceUtil` still reads `DynamicColors.isDynamicColorAvailable()` for its default).
- `UpdateUtil.deleteOutdatedApk()` (self-update, see 3).

**3. Self-update removed (yt-dlp update kept).** An embedded Seal must never offer to download and install another "Seal" APK over Win11.
- Deleted: `ui/page/AppUpdater.kt`, `ui/page/UpdateDialog.kt`, `ui/page/settings/about/UpdatePage.kt`.
- `UpdateUtil.kt` now holds only `updateYtDlp()` (GitHub release check, APK download / install, `Release`, `AssetsItem`, `DownloadStatus` and the `Version` classes are gone). The two OkHttp `!!` patches of part 3 for this file are therefore no longer needed (the `SponsorUtil.kt` one stays).
- `AppEntry.kt`: `AppUpdater()` call, the `AUTO_UPDATE` route and the `onNavigateToUpdatePage` argument removed (`YtdlpUpdater()` stays). `ui/common/Route.kt`: `AUTO_UPDATE` removed.
- `AboutPage.kt`: the "Auto update" switch row, the `onNavigateToUpdatePage` parameter and its state removed. `PreferenceUtil.isAutoUpdateEnabled()` removed. The preference constants `AUTO_UPDATE` / `UPDATE_CHANNEL` stay (harmless defaults); the strings stay (unused).
- Upstream's list in part 1 also named `TroubleshootingPage` / `GeneralDownloadPreferences`: checked, both only call `UpdateUtil.updateYtDlp()` (the yt-dlp update), so they are untouched.
- The Seal source never had a second place that installs an APK (`REQUEST_INSTALL_PACKAGES` / `canRequestPackageInstalls` do not occur any more); part 5 will not write that permission.

**4. Host `App.kt`** (`app/src/main/kotlin/com/srizwan/win11/App.kt`): `import com.junkfood.seal.SealInit` and, at the end of `onCreate` **after the launcher-process check** (so not in `:midlet`, `:mame`, `:retroarch` or BlackBox processes):
`try { SealInit.init(this) { AppLog.e("Seal", "yt-dlp engine init failed", it) } } catch (e: Throwable) { AppLog.e("App", "Seal init failed", e) }`. A Seal failure is logged and never stops the launcher.

**Cost at launcher start:** MMKV + Koin + two channels (milliseconds) and one background thread that checks the yt-dlp engine. The first ever start unpacks the engine (tens of MB on disk); the launcher UI does not wait for it.

Static checks (here): all 135 Seal / seal-color Kotlin files and the host `App.kt` have balanced `{}`, `()`, `[]` (string / comment aware scan; an earlier naive scan flagged 8 files, all false alarms caused by `https://` inside strings);
no reference left to `AppUpdater`, `UpdateDialog`, `UpdatePage`, `UpdateUtil.Release|DownloadStatus|Version|checkForUpdate|installLatestApk|downloadApk|deleteOutdatedApk`, `isAutoUpdateEnabled`, `Route.AUTO_UPDATE`, `startCrashReportActivity`, `: Application()`, `as App`, `App()`;
every symbol `SealInit` uses exists (`PreferenceUtil.containsKey`, `DownloadUtil.getCookiesContentFromDatabase`, `FileUtil.getCookiesFile` / `getExternalDownloadDirectory` (internal, same module), `DownloadService.DownloadServiceBinder`);
`win11_patches.apply()` run twice on the tree: first 11 patches + 3 drops + 3 overlay files, second run 0 applied / 12 already in place (idempotent).
**Not run:** Gradle, the Kotlin compile of `:seal` on 2.2.10, CI, a device. **Not re-run:** `import-upstream.py` itself (no upstream checkout here; its new tail only calls `win11_patches.apply`).
Nothing is visible in the app yet: there is still no manifest and no hook, so no Seal screen can be opened until parts 5-6.

## Part 3 — Gradle wiring

Files: `seal-color/build.gradle.kts` (new), `seal/build.gradle.kts` (new), root `build.gradle.kts`, `settings.gradle.kts`, `app/build.gradle.kts`.

| Where | Change |
|-------|--------|
| root `build.gradle.kts` | 3 plugins, `apply false`: `org.jetbrains.kotlin.plugin.compose` **2.2.10**, `org.jetbrains.kotlin.plugin.serialization` **2.2.10**, `com.google.devtools.ksp` **2.2.10-2.0.2** (KSP release for Kotlin 2.2.10, checked on the google/ksp release list). The Room *Gradle plugin* is not used (see below) |
| root `build.gradle.kts` | coroutines pin **1.8.1 -> 1.9.0** (the pin forces this version on every `kotlinx-coroutines-*`, so it must not be lower than what Seal's Compose / lifecycle 2.8 / Koin 4 need) |
| `settings.gradle.kts` | `include(":seal-color")`, `include(":seal")` (with a comment, like the other modules) |
| `app/build.gradle.kts` | `implementation(project(":seal"))`; `packaging.resources.excludes += "/META-INF/{AL2.0,LGPL2.1}"` (upstream excludes the same two; several of Seal's libraries ship them) |
| `:seal-color` | library, namespace `com.junkfood.seal.color`, compileSdk 37, minSdk 26, Java 21, Compose compiler plugin; `api` on the alpha BOM + ui / runtime / foundation / material3 / core-ktx (upstream's list); no minify |
| `:seal` | library, namespace `com.junkfood.seal` (the sources import its `R` / `BuildConfig`), compileSdk 37, minSdk 26, Java 21, plugins compose + serialization + ksp, `buildConfig = true` plus `buildConfigField("String", "FLAVOR", "\"\"")` (upstream's `App.kt` reads `BuildConfig.FLAVOR`, a library without flavors has none), `useLegacyPackaging = true`, upstream's lint list, `consumer-rules.pro` |

Dependencies of `:seal` (versions inline; upstream's `libs.versions.toml` as base). **Differences from upstream are the 4 below, everything else is identical:**

| Library | Upstream | Here | Why |
|---------|----------|------|-----|
| Kotlin / KSP | 2.0.20 / 2.0.20-1.0.25 | 2.2.10 / 2.2.10-2.0.2 | the project is on Kotlin 2.2.10 (`kotlin-stdlib` is pinned to it) |
| Room | 2.6.1 | **2.8.5** | the version `:j2me` already uses (known to resolve in CI); 2.6.1 is a KSP1-era release |
| kotlinx-serialization-json | 1.7.2 | **1.9.0** | runtime built for Kotlin 2.2 to match the serialization plugin 2.2.10 |
| OkHttp | 5.0.0-alpha.10 | **4.12.0** | `:youtube` uses 4.12.0; Gradle would put the whole app (NewPipe downloader included) on the alpha. Seal's source needed 3 edits: `Response.body` is nullable in 4.x, so `.body` -> `.body!!` (`UpdateUtil.kt` x2, `SponsorUtil.kt` x1; marked "Win11:" in the code and applied by `tools/import-upstream.py`, so a re-import keeps them; since part 4 `UpdateUtil.kt` is replaced by a cut-down overlay file, so only the `SponsorUtil.kt` patch is left) |

Same as upstream: Compose alpha BOM 2025.03.01 (Seal uses Material 3 APIs that are only in the alpha BOM), material3 + window-size-class, icons-extended, navigation-compose 2.8.9, activity-compose 1.10.1, lifecycle-runtime-compose 2.8.7,
constraintlayout-compose 1.1.0, graphics-shapes 1.0.1, accompanist 0.34.0 (permissions, webview, pager-indicators), coil-compose 2.5.0, Koin 4.0.0 (android + compose), MMKV 1.3.12,
material 1.12.0, appcompat 1.7.0, core-ktx 1.15.0, **youtubedl-android 0.17.3** (`library`, `ffmpeg`, `aria2c`, Maven Central `io.github.junkfood02.youtubedl-android`).
Not taken over: the version catalog, `ktfmt`, `androidx.test` / `espresso` / `junit` (no tests here), the `:app`-only ABI split and signing logic.

Why KSP arguments and not the Room Gradle plugin: the plugin is one more plugin on the classpath and only sets the schema directory. `ksp { arg("room.schemaLocation", "$projectDir/schemas") }` gives the same layout
(`schemas/com.junkfood.seal.database.AppDatabase/1..5.json`, which part 2 copied), and the auto-migrations of `AppDatabase` read it at compile time.

**Side effect to know:** Gradle uses the highest version of a library for the whole app, so these `:app` / other-module versions are lifted: appcompat 1.6.1 -> 1.7.0, material 1.11.0 -> 1.12.0, core-ktx 1.12.0 -> 1.15.0,
activity / lifecycle to the 1.10 / 2.8 line, kotlinx-coroutines 1.8.1 -> 1.9.0, kotlinx-serialization (if any) to 1.9.0. All of them need compileSdk 35 or lower (the project uses 37) and minSdk 21+ (the project uses 26).
OkHttp stays 4.12.0 on purpose. The View-based modules (:app, :video, :gallery, ...) should not notice; if a layout or Material component looks different after this part, appcompat 1.7 / material 1.12 are the first suspects.

Static checks (here): the three plugin versions are the same line (Kotlin 2.2.10); both build files have balanced brackets; `settings.gradle.kts` / `app/build.gradle.kts` / root file still parse by the same check;
`seal/tools/import-upstream.py` re-run reproduces the tree byte for byte (patches included); every module named in `settings.gradle.kts` has its build file; `ls seal/schemas/*` shows the 5 schema files.
**Not run:** Gradle, the Kotlin compile of Seal on 2.2.10 (the first real test is your next workflow run; likely failure spots: Compose alpha APIs, Koin 4 + Kotlin 2.2, `BuildConfig`), a device. If the build fails in `:seal`, send me the first error lines and I fix it before part 4.

## Part 2 — sources copied, resources prefixed (`seal/tools/import-upstream.py`)

The copy is done by a script (run from the project root with a checkout of the pinned commit: `python3 -I seal/tools/import-upstream.py <seal-checkout>`), so it can be repeated exactly and the diff to upstream stays small.

| From upstream | To | Result |
|---------------|----|--------|
| `app/src/main/java/**` | `seal/src/main/java/` | 126 Kotlin files, package `com.junkfood.seal` unchanged; the only edit is `R.<type>.<name>` -> `R.<type>.sl_<name>` (847 references in 76 files) |
| `app/src/main/res/**` | `seal/src/main/res/` | 64 `values*` files (430 strings, 3 plurals, 1 colour, 2 styles; 61 translations), 12 drawables, 3 mipmaps, 1 xml: all renamed with `sl_` (34 files), 18005 `name="..."` entries |
| `app/schemas/*.json` | `seal/schemas/` | Room schema history 1..5 (part 3 points the Room plugin here) |
| `app/proguard-rules.pro` + `color/proguard-rules.pro` | `seal/consumer-rules.pro` | merged keep rules |
| `app/src/main/AndroidManifest.xml` | `seal/reference/AndroidManifest.upstream.xml` | **reference only, outside `src/`, never merged**; part 5 writes the real manifest from it |
| `color/src/main/java/**` | `seal-color/src/main/java/` | 11 files, unchanged (namespace `com.junkfood.seal.color`, build file in part 3) |

**Resource-name scan** (every module of this project against Seal's 452 resources, `values` / `drawable` / `mipmap` / `xml` / `color`): **34 clashes before the prefix, 0 after.**
The clashes were real: `app_name`, `cancel`, `settings`, `language`, `version`, `about`, ... (:winlator), `close`, `save`, `search`, `dismiss`, `unlimited` (:j2me), and `ic_launcher`, `ic_launcher_round`, `ic_launcher_foreground` (:app, :winlator).
In a merged build the module that is later in the priority order silently wins, so without the prefix Seal's texts and icons would have replaced (or been replaced by) the other modules' ones.

Rules the script follows (all verified after the run, see "Checks" below):
- Prefix only **Seal's own** names. References to library resources stay as they are (`R.string.abc_action_mode_done` from appcompat in `WebViewPage.kt` is untouched).
- Styles `Theme.Seal` and `Theme.Seal.Dialog` keep their names (unique in the project); `@xml/provider_paths` -> `@xml/sl_provider_paths`, launcher icons -> `sl_ic_launcher*`, notification icon -> `sl_ic_stat_seal` (part 5 uses them in the manifest).
- Not changed in this part on purpose: `App.kt`, update code, `BuildConfig` use, the manifest (parts 4-5). So the code is still "Seal as upstream, plus the prefix", and cannot compile alone before part 3.

What part 3 must provide for this code to compile (found while copying):
- library `namespace = "com.junkfood.seal"` (the sources import `com.junkfood.seal.R`) and `buildFeatures { buildConfig = true; compose = true }` (`BuildConfig.FLAVOR` / `BuildConfig.DEBUG` are used in `App.kt`; part 4 replaces them);
- `android.nonTransitiveRClass=false` is already global in this project, so `R.string.abc_action_mode_done` resolves through appcompat as in upstream;
- plugins `kotlin-serialization`, `ksp`, `room`, Compose compiler (Kotlin 2.2.10); Room schema dir `seal/schemas`; `resources.properties` (`unqualifiedResLocale=en-US`) is in `seal/src/main/res/` (it is read only by an application module: harmless in a library);
- `:seal` depends on `:seal-color`; `:app` depends on `:seal`.

Checks run here (static only): all 64 `values*` files parse as XML and have the same line count as upstream; every `R.<type>.<name>` in Kotlin and every `@type/name` in XML resolves to a prefixed resource of `:seal`
(one library reference left, see above); no unprefixed resource of any type except the two styles; the Java tree and the `:color` tree have the same file list as upstream; scan against all modules: 0 clashes.

## Part 1 — files changed in the project

- new: `seal/README.md`, `seal/UPSTREAM_VERSION`, `seal/UPSTREAM_COMMIT`, `LICENSE-Seal`, `NOTICE-Seal.md`, `docs/CHANGES-seal-part1.md`
- changed: root `README.md` (new "Seal" section with this plan)
- **not changed**: `settings.gradle.kts`, `app/build.gradle.kts`, every `src` of the other modules, every workflow (parts 3-8)

## Part 3 — files changed in the project

- new: `seal/build.gradle.kts`, `seal-color/build.gradle.kts`, `docs/CHANGES-seal-part3.md`
- changed: root `build.gradle.kts`, `settings.gradle.kts`, `app/build.gradle.kts`, `seal/src/main/java/.../util/UpdateUtil.kt` + `SponsorUtil.kt` (3 `!!`), `seal/tools/import-upstream.py` (patch list), `seal/README.md`, root `README.md`, `NOTICE-Seal.md`
- **not changed**: the manifests, `App.kt` of Win11, the workflows (part 8)

## Part 2 — files changed in the project

- new: `seal/src/**` (126 Kotlin + 64 values + 17 other resource files), `seal/schemas/*.json` (5), `seal/consumer-rules.pro`, `seal/reference/AndroidManifest.upstream.xml`, `seal/tools/import-upstream.py`, `seal-color/src/**` (11), `docs/CHANGES-seal-part2.md`
- changed: `seal/README.md`, root `README.md` (table), `NOTICE-Seal.md` (status + changes list)
- **not changed**: `settings.gradle.kts`, `app/build.gradle.kts`, the manifests, the workflows

## Part 8 — files changed in the project
- changed: `.github/workflows/UltimateBuild.yml`, `UltimateBuild_NoWinlator.yml`, `UltimateBuild_WithoutMe.yml`, this file, root `README.md`
- new: `seal/tools/check-merged-manifest.py`, `docs/CHANGES-seal-part8.md`
- not changed: Kotlin sources, manifests, Gradle files

## Part 9 — files changed in the project
- changed: `README.md`, this file, `NOTICE-Seal.md` (status and the change list now cover parts 7 and 8)
- new: `docs/CHANGES-seal-part9.md`
- not changed: sources, manifests, Gradle files, workflows


## Part 10 — static checks, final flat zip
Static check of the whole project and the last flat zip `RizwanS2-main-seal-final.zip`. No source, manifest, Gradle or workflow file changed; one new helper `tools/static-check.py` (`python3 seal/tools/static-check.py <project root>`: XML, YAML, bracket balance). Results, the full table and what was not run: `../docs/CHANGES-seal-part10.md`.
- new: `seal/tools/static-check.py`, `docs/CHANGES-seal-part10.md`; changed: `README.md`, `seal/README.md`, `NOTICE-Seal.md` (status only)
- Next step is yours: run `UltimateBuild.yml`; the first compile of `:seal` is in that run; send me the first error lines if it fails.

# :mame — built-in MAME (arcade emulator), from MAME4droid (Current)

Upstream: https://github.com/seleuco/MAME4droid-Current, pinned in `UPSTREAM_VERSION` (**v1.41.2**, MAME core **0.289**). Licence: GPL-2.0-or-later, see `../NOTICE-MAME4droid.md` and `../LICENSE-MAME4droid`.
Since step 3 this folder is the Gradle library module `:mame` (`include(":mame")` in `settings.gradle.kts`, `implementation(project(":mame"))` in `:app`). Since step 7 MAME opens from the Start menu, the Home screen and `rizwans2://mame` (no launcher icon of its own).

## Plan (9 steps)

| # | Part | Status |
|---|------|--------|
| 1 | Read this project and the upstream (`../docs/MAME4DROID-STEP1-ANALYSIS.md`) | done |
| 2 | Core source = plan A (prebuilt `libMAME4droid.so` from the official release APK), pin version + hashes, licence files | done |
| 3 | `:mame` library module: Java, `mm_` resources, manifest, Gradle, minSdk, `tools/fetch-upstream.sh` | done |
| 4 | ROM folder + game list (SAF), own process, own settings file, `MameLaunch` entry point | done |
| 5 | Emulation screen, touch controls, gamepad: checked for Win11 fit, version fix | done |
| 6 | Settings: upstream's settings screen kept, hidden platform class replaced, checked | done |
| 7 | Hooks in `:app` (Start menu, Home icon, `rizwans2://mame`, `MameLauncher.kt`), `:mame` process guard in `App.kt` | done |
| 8 | CI (fetch + hash check + APK check) in both build workflows | done |
| 9 | Details updated, static checks, final flat zip `RizwanS2-youtube-step7.zip` | done |

## Step 2 — core source decision (plan A)

- **Frontend** (Java, `mame4droid-jni.c`, `res/`, `assets/`): from upstream tag `v1.41.2`, built by this project (ndk-build for the small `libmame4droid-jni.so`, step 3).
- **Core** `libMAME4droid.so`: not built. The build downloads `MAME4droid.2026-1.41.2-release.apk` (169,562,047 bytes) from the upstream release, checks the SHA-256 in `UPSTREAM_SHA256`, extracts `lib/arm64-v8a/libMAME4droid.so` (366,992,944 bytes) into `mame/core/arm64-v8a/`. Different hash = build stops.
- **Why not plan B** (build MAME 0.289 from source in CI): hours of native build, many GB, not testable here. It can be added later as an optional workflow; the pin already names the source tag (`mame0289`).
- **Checked on the real file** (downloaded and read here): the `.so` is stripped aarch64, needs only libc, libdl, libm, libandroid, liblog, libEGL, libGLESv1_CM, libGLESv3, libOpenSLES, and imports no libc / Android symbol newer than API 21 (`statvfs` is the newest).
  So the native side does not need API 29; the Java side is checked in step 3 (upstream minSdk 29 vs this project 26).
- **How it is loaded**: Java passes `libPath` to `Emulator.init(libPath, resPath, ...)` and the JNI code `dlopen`s `<libPath>/libMAME4droid.so`. The folder is chosen by the Java side, so the core may sit in the APK's native-lib folder or in a downloaded folder.
- **Size warning**: the core is **367 MB uncompressed** (the whole release APK is 169 MB). Packed into the APK with `useLegacyPackaging` (as `:app` does), the APK grows by about 170 MB and the installed app by about 367 MB more.
  Decision needed in step 3: pack it in the APK (simple, big APK) **or** download it on first use into the app's files folder (small APK, needs internet once, a download screen and a hash check). Default if you do not choose: pack it in the APK.

## Step 3 — the `:mame` module

Decision from you: the core goes **into the APK** (like PPSSPP). The APK grows by about 170 MB (compressed) and the installed app by about 367 MB.

- **What is in this folder** (all in the project zip): `src/main/java` (the 50 upstream Java files, package `com.seleuco.mame4droid` kept), `src/main/res` (upstream resources, every name prefixed `mm_`), `src/main/assets/mame/` (help pages),
  `src/main/jni` (`mame4droid-jni.c`, `Android.mk`, `Application.mk`: the small `libmame4droid-jni.so`, built here with ndk-build), `src/main/AndroidManifest.xml`, `build.gradle.kts`, `consumer-rules.pro`, `tools/`.
- **What is NOT in the zip** (git-ignored `core/`): `core/jniLibs/arm64-v8a/libMAME4droid.so` (367 MB) and `core/res/raw/mm_files.zip` (64 MB, upstream's `res/raw/files.zip`).
  `tools/fetch-upstream.sh` downloads both (hash-checked against `UPSTREAM_SHA256`; a wrong hash stops the build) and the Gradle task `fetchMameCore` runs it before `preBuild`. Offline: put the two files there by hand.
  The script was run here against the real release: it extracted the `.so`, verified both hashes, skipped the work on a second run, and re-downloaded `mm_files.zip` after it was changed by one byte.
- **Gradle**: library module, namespace `com.seleuco.mame4droid`, compileSdk 37, **minSdk 26** (upstream 29), NDK `ext.ndkVer`, ndk-build (`APP_PLATFORM=android-26`), arm64-v8a only, `useLegacyPackaging = true` (the JNI code `dlopen`s `<nativeLibraryDir>/libMAME4droid.so`; `:app` already extracts native libs),
  `keepDebugSymbols` for the core (no re-strip of 367 MB), Java 17 (like upstream), no dependencies (the Java code uses only the Android framework).
- **Manifest** (library, merged into `:app`; process / task isolation added in step 4, see below): 6 activities (`MAME4droid`, `UserPreferences`, `WebHelpActivity`, `DefineKeys`, `ListKeys`, `KeySelect`), permissions VIBRATE / INTERNET / ACCESS_WIFI_STATE / WAKE_LOCK / ACCESS_LOCAL_NETWORK, gamepad + touchscreen not required.
  No LAUNCHER / LEANBACK filter (no second icon), **no zip / 7z VIEW filter** (it would offer MAME for every zip on the phone), `MAME4droid` is not exported, no `<application>` attributes, no `installLocation` / `supports-screens`.
- **Resources**: all 762 names start with `mm_` (drawable, layout, raw, xml, mipmap, string, array, color, style); ids (`R.id.x`) are not renamed (an id cannot override anything). Checked: no unprefixed name left, no `mm_` name in any other module, every `@type/name` and every `R.type.name` resolves,
  all 31 XML files parse. The unused AdMob `attrs.xml` (attrs like `backgroundColor`, `keywords`) was dropped: its attr names could clash with other modules. `tools/rename-resources.py` is the one-off tool that did the renaming (kept for the record; `tools/resource-names.json` lists the old names).
- **Assets**: moved from the assets root to `assets/mame/` (index.htm, mystyle.css, license.htm ... would clash with other modules' merged assets); `WebHelpActivity` got an `ASSET_ROOT = "mame/"` constant.
- **minSdk 26 check** (JDK 21 + `android.jar` API 26 / 33 from Sable/android-platforms, resources stubbed): the 50 Java files compile; the code that needs a newer API was read one by one:
  guarded already (API 30 window metrics / insets, 31 PerformanceHintManager, 30 `getDirectory()`, 30 `setFrameRate`, 29 WifiLock mode, 29 thermal, `InetAddresses` inside try/catch, 35 insets listener);
  **two unguarded uses fixed**: `TouchController.fireHaptic` (`VibrationEffect.createPredefined`, API 29: below 29 it now uses short one-shot pulses) and `MAME4droid` (`layoutInDisplayCutoutMode`, API 28: now `SDK_INT >= 28`). Both are marked `// Win11:` in the code.
  The core `.so` imports nothing above API 21 (step 2). The only compile errors left against API 33 are the API 35 constants `VANILLA_ICE_CREAM` (inlined at compile time; compileSdk 37 knows them).
- **Not verified here** (no Gradle / SDK / NDK in this environment): the Gradle sync, the ndk-build of `mame4droid-jni.c`, the manifest merge, the 530 MB native packaging, and any run on a device. First real test: your GitHub workflow (step 8 adds the APK check); things to look at first if it fails:
  (1) `fetchMameCore` (needs bash, curl, unzip, sha256sum on the runner); (2) APK / disk size on the runner (free-disk step exists); (3) `ndkBuild` with NDK `29.0.13846066` (upstream used 28.2); (4) a resource or manifest merge message mentioning `mm_` or `com.seleuco`.
- **Nothing starts MAME yet** (state after step 3; changed in step 7, see below): no Start menu entry, Home icon or deep link until step 7, so the app behaved exactly as before except for the bigger APK.

## Step 4 — ROM folder, game list, and two fixes to step 3

**ROM folder and game list: upstream already has both, so they are kept, not rewritten.**
- First start: MAME shows a dialog (`DIALOG_ROMs`): *app folder* (inside the app's own storage) or *choose folder* (system folder picker, `ACTION_OPEN_DOCUMENT_TREE` = SAF). For SAF the permission is saved with `takePersistableUriPermission`
  (`MainHelper`), the folder is scanned (`SAFHelper`, with a cache; lazy mode on direct launch), the path is stored under the key `PREF_ROMsDIR_2`. A ROM that is opened from outside (`ACTION_VIEW` with a `content://` zip / 7z) is copied into `<install dir>/roms` for the run and deleted afterwards (`Emulator.emulate`).
- The game list is MAME's own game menu inside the core (touch-friendly, with optional icons / snapshots from `ScraperHelper`). ROM sets are `.zip` / `.7z` named by MAME short name; the set must match core 0.289. **No ROM is included; you supply them.**
- Not changed: dialog texts, scanning, cache, scraper. A separate Win11-style game list would duplicate the core menu and could not start a game without the core anyway, so none was built. If you want one later (for example "recent games" in the Start menu), it can be added on top of `MameLaunch.rom(...)`.

**Added: `com.seleuco.mame4droid.MameLaunch`** (plain Java, the only class `:app` needs, used by step 7): `isSupported()` (Android 8.0+ and a 64-bit ARM phone; the core is arm64-v8a only), `frontend(context)` (opens the game list),
`rom(context, uri, cliParams)` (starts one `.zip` / `.7z` ROM set from a `content://` Uri, grants read permission, optional MAME command line), `isRomFileName(name)`. Intents are explicit (component = this app's package + `MAME4droid`) and use `FLAG_ACTIVITY_NEW_TASK`.

**Fixed (step 3 had these two defects, found while reading how MAME exits):**
1. **MAME would have closed the whole Win11 app.** Upstream ends MAME with `finishAndRemoveTask()` + `Process.killProcess(myPid())` (5 places: `Emulator`, `DialogHelper` x3, `MainHelper.restartApp`). In the same process that kills the Win11 shell. Now all 6 activities run in the process `:mame`
   and `MAME4droid` has its own `taskAffinity`, so "exit" removes only MAME's task and process (same idea as `:midlet` in `:j2me`). Side effect: the Win11 `Application` class also starts once in the `:mame` process (as it already does for `:midlet`).
2. **Settings file shared by two processes.** Upstream keeps all settings (ROM folder, SAF permission Uri, button layout) in the app-wide default SharedPreferences file; two processes writing it would overwrite each other. New `helpers/MamePrefs` gives MAME its own file `mame4droid_settings`;
   all 11 `PreferenceManager.getDefaultSharedPreferences(...)` calls use it and `UserPreferences` (the settings screen) reads and writes the same file. Keys and values are unchanged. (`GameController` already used its own file `mame4droid_prefs`.)

**Checked here:** all 52 Java files compile against API 26 / 33 stubs (only the already-guarded API 30+ lines and the API 35 constants are reported, as in step 3); manifest parses, 6 activities in `:mame`, 1 task affinity; no `getDefaultSharedPreferences` call is left.
**Not checked here (no device / SDK):** the first-start dialog, the folder picker, the ROM scan, launching a ROM through `MameLaunch.rom`, exit returning to Win11 (the intended result of fix 1), and that the settings screen shows its saved values from the new file.

## Step 5 — emulation screen, touch controls, gamepad

**Kept from upstream (not rewritten):** the OpenGL emulation view (`EmulatorViewGL` / `GLNativeRenderer`), the touch controller (D-pad / analog stick / buttons / lightgun / touch mouse, layouts in `res/raw/mm_controller_*.txt`, skins `res/drawable/mm_*.png`), the gamepad / keyboard / mouse input
(`GameController`, `Keyboard`, `Mouse`, `InputHandler`, button mapping screens `DefineKeys` / `ListKeys` / `KeySelect`), tilt sensor, haptics, HDR / shaders / frame pacing, sound (OpenSL ES + AudioTrack). They already work on phones, tablets, TV boxes and with Bluetooth pads, so a rewrite would only add bugs.
The touch skins stay raster PNGs: they are game artwork (about 3.5 MB), the "vector only" rule of Win11 is about launcher icons, and converting 70 images to vectors would change how the controls look. (`mm_ic_launcher` is already an adaptive icon; it is not shown anywhere because MAME has no launcher entry.)

**What was checked for use inside Win11** (read / grep / compile; not run on a device):
- No dependency on the host app: no `Application` subclass, no `getLaunchIntentForPackage`, no FileProvider, no Play Store link, no package name string of the upstream app. `getApplicationContext()` (9 uses) only gets prefs / sensors / Wi-Fi, which works with Win11's `Application` object.
- Window handling is inside the activity (immersive / cutout / insets, all API-guarded since step 3); the activity theme is upstream's black full-screen theme; the screen is kept on during NetPlay only (as upstream).
- ELF alignment: both `libMAME4droid.so` and `libmame4droid-jni.so` have 16 KB page alignment (all LOAD segments `0x4000`), so they also load on 16 KB-page phones.
- Input: `GameController` keeps its own prefs file (`mame4droid_prefs`, only used in `:mame`); the API 26+ Vibrator code was fixed in step 3.

**Fixed: wrong version sent to the core.** Upstream read `versionName` of the host app. Inside Win11 that is Win11's version (2.5.3), which would (1) unpack MAME's support files again after every Win11 update and never after a MAME update (marker file `dont-delete-<version>.bin`),
(2) tell the core and the NetPlay lobby a wrong version (NetPlay peers compare it), (3) show it in "Launching ROM ..." messages. `MainHelper.getVersion()` and `LobbySession.appVersion()` now return the new constant `MameLaunch.UPSTREAM_VERSION = "1.41.2"`.
`tools/fetch-upstream.sh` stops the build if this constant differs from `UPSTREAM_VERSION` (tested: a changed constant makes it exit with an error), so a later version bump cannot forget it.

**Not checked here (needs a device):** how the emulation screen looks inside the Win11 window setup, touch layouts on your phone, gamepad detection, sound latency, performance (MAME 0.289 is heavy for some games on weak phones), and the exit back to Win11 (step 4 fix).

## Step 6 — settings

**Kept from upstream:** the settings screen `UserPreferences` (`res/xml/mm_userpreferences.xml`, 991 lines: 168 keys in 25 sub-screens: video filter / shaders / CRT / vector HDR, sizes and scaling, sound, frameskip, DRC / speed hacks, touch controller and gamepad options, tilt,
button definition (`DefineKeys`, `ListKeys`, `KeySelect`), ROM folder / SAF cache, scraper (icons, snapshots), NetPlay and lobby, language, save states in the ROM folder, hi-score, cheats) and the confirm-before-change preferences (`*PrefWithWarn`, `SensitivityPrefScreen`).
Settings are stored in MAME's own file `mame4droid_settings` (step 4), so nothing here can touch Win11's own settings (no `clear()` of preferences exists in the module).

**Fixed: a hidden platform class.** 30 settings rows (HDR / vector effect sliders, tilt sensitivity ...) used the tag `<SeekBarPreference>`, which is `android.preference.SeekBarPreference`: not in the public SDK (it is missing from `android.jar`), and upstream only ran on Android 10+.
With minSdk 26 (and future Android versions) it could not be relied on, and the whole settings screen would fail to open if the class were missing. Now `prefs/MameSeekBarPreference` (+ layout `mm_pref_seekbar`) does the same job: `android:max` (default 100), `android:defaultValue`, the value stored as an Int under the same key,
the default written when nothing is stored (as the platform class does), `android:dependency` works, plus a number next to the bar; the value is stored when the finger is lifted, so the settings listener does not run on every step while dragging.

**Checked here (static):** all XML parses; every `@type/name` resolves; every `android:dependency` points to an existing key; the 17 list preferences have entries and values arrays of equal length (one, `PREF_SHADER_EFFECT_3`, is filled in code); all 53 Java files compile against API 26 / 33 stubs.
Observations, not changed (upstream's own): the key `mouse` is used twice in the XML (a sub-screen and a checkbox); 22 stored keys are not in the screen on purpose (button layout, SAF permission, NetPlay session state, ...).

**Not checked here (needs a device):** that the settings screen opens and looks right on your phone (the slider rows have a new layout), saving and reading values across a restart, the "restart needed" dialogs, and the effect of each setting on a running game.
**Language:** the MAME screens and help exist in English, Spanish, Japanese, Korean, Portuguese and Chinese; there is no Bengali. A Bengali translation (about 600 strings) is possible as a separate task.

## Step 7 — hooks in `:app`

**Added (all in `:app`, package `com.srizwan.win11`; nothing in `:mame` itself changed):**
- `MameLauncher.kt`: `MainActivity.openMame()` starts `MameLaunch.frontend(...)` (MAME's own game list; first start asks for the ROM folder) inside try / catch with a short message; `isMameSupported()` = `MameLaunch.isSupported()` (64-bit ARM and Android 8.0+). Same pattern as `PpssppLauncher.kt`.
- **Start menu**: `StartApps.kt` entry **MAME** (section `mame`, vector joystick icon, colour `#F25F5C`), added only when `isMameSupported()` (like Winlator): other phones get no entry that could not work.
- **Home screen**: `Win11Shell.kt` `VectorIconView.MAME` (same vector path, even-odd fill so the button is hollow) and the Home icon under PPSSPP, again only on supported phones.
- **Deep link**: `rizwans2://mame` in `MainActivity.handleDeepLink` (and the Start / Home section click), the link list in the code comment and the Manifest comment updated.
- **Icons are vectors only** (path data, no PNG, no emoji): a ball on a stick, a base and a hollow button.
- **Manifest**: nothing to repeat. The 6 `:mame` activities and the permissions (VIBRATE, INTERNET, ACCESS_WIFI_STATE, WAKE_LOCK, ACCESS_LOCAL_NETWORK) are merged from the library manifest; all permissions except ACCESS_LOCAL_NETWORK were already in `:app`. A comment in `app/src/main/AndroidManifest.xml` says so.
- **ProGuard / R8**: `-keep class com.seleuco.mame4droid.** { *; }` added to `app/proguard-rules.pro` (it is also in `mame/consumer-rules.pro`); JNI, the settings XML and the Manifest name these classes as strings.
- **File Manager: not hooked, on purpose.** MAME's ROM sets are `.zip` / `.7z`; almost every zip on a phone is something else, and a wrong zip would start the emulator. ROMs are opened from MAME's own game list (ROM folder chosen inside MAME). `MameLaunch.rom(...)` is ready if you want it later.

**Found and fixed while checking conflicts: `App.kt` started the BlackBox engine in the `:mame` process.** The `Application` class (`App`) runs in every process of the app. It already skipped everything in the J2ME game process `:midlet`, but the `:mame` process created in step 4 was not skipped: BlackBox would have attached there
and treated the emulator as a cloned app (hooking system services). `App.kt` now returns at once in the process `<package>:mame` (in `attachBaseContext` and `onCreate`): no BlackBox, no J2ME start-up, no launcher log / crash handler. MAME needs nothing from `App` (checked: no use of the Win11 `Application` class in `:mame`).
(Step 4's README line saying the Win11 `Application` "also starts once in the `:mame` process" is still true, but since step 7 it starts nothing there.)

**Conflict check with the other modules (read / grep):** the `:youtube` module has no `mame`, `com.seleuco` or `taskAffinity` entry; MAME uses its own process (`:mame`), own task affinity and own settings file, resources are prefixed `mm_`, the section name `mame` and the class string `builtin.mame` are new. The deep-link numbers (`rizwans2://N`) shift by one for the apps that sort after **MAME** (the list is sorted by name; on phones that are not 64-bit ARM nothing shifts).

**Checked here (static):** `MameLauncher.kt`, `MainActivity.kt`, `StartApps.kt`, `Win11Shell.kt`, `App.kt`: braces and parentheses balance, every changed spot read again; `AndroidManifest.xml` parses; the icon path uses only commands that the other icons use.
**Not checked here (no Gradle / SDK / device):** Kotlin compile, the icon on screen, opening MAME from the three entries, that exit returns to Win11, and that the `:mame` process runs without the engines.

## Step 8 — GitHub Actions (CI)

**Changed:** `.github/workflows/UltimateBuild.yml` and `UltimateBuild_NoWinlator.yml` (the same three changes in both; every other step, input and secret is unchanged).
- **New step "Fetch MAME core"** (after "Fetch PPSSPP source", before the ccache steps, `timeout-minutes: 20`): runs `bash mame/tools/fetch-upstream.sh`, which downloads `libMAME4droid.so` (via the official release APK) and `files.zip` with `curl` retries and checks every SHA-256 against `mame/UPSTREAM_SHA256`; it also stops the run when `MameLaunch.UPSTREAM_VERSION` differs from `mame/UPSTREAM_VERSION`.
  It prints the file sizes and the free disk. The Gradle task `fetchMameCore` (before `:mame` `preBuild`) runs the same script and does nothing when the files are already there, so this step only shows download or hash errors early, as the PPSSPP step does. It runs after the package rename and does not depend on it (the rename touches no MAME file).
- **APK check** (inside "Locate Unsigned APK", after the PPSSPP check): the run fails unless the unsigned APK contains `lib/arm64-v8a/libMAME4droid.so` with exactly the pinned size (`so_core_size`), `lib/arm64-v8a/libmame4droid-jni.so`, an entry with exactly the pinned `files_zip_size` (found by size, not by name, because resource shrinking may rename `res/raw/mm_files.zip` but cannot change its length) and `assets/mame/index.htm`.
- **Disk:** "Free disk space" also removes `/usr/share/swift` and `/opt/hostedtoolcache/CodeQL` (the 367 MB core is copied several times while the APK is merged, packed, aligned and signed); the step comment and the file header comment name MAME.
- **Cache: none, on purpose.** The two downloads are about 230 MB and fast on a GitHub runner; caching the 430 MB result would use the repository's cache quota (PPSSPP source and ccache already use it). If you want it, add `actions/cache` for `mame/core` with the key `hashFiles('mame/UPSTREAM_SHA256','mame/UPSTREAM_VERSION','mame/tools/fetch-upstream.sh')` (the script re-checks the hashes anyway).
- **Timeout:** unchanged, 120 minutes (the PPSSPP C++ build is the long part; the MAME JNI library is one C file). **Release size:** the APK grows by about 170 MB; a GitHub release file may be up to 2 GiB.
- **The "without Winlator" workflow** needed no extra change: its removal step touches only `winlator/`, the Winlator references and `WinlatorLauncher.kt`.

**Checked here:** both files parse as YAML (23 and 24 steps, "Fetch MAME core" in both); the APK check block was cut out of the workflow and run against small fake APKs with `bash -eo pipefail`: it passes when everything is present and fails with the right message for each of five missing / wrong-size cases (no core, core of the wrong size, no files.zip, no help pages, no JNI library).
**Not checked here (no network access to GitHub, no runner):** a real workflow run, the download of the 169 MB release APK, the real sizes in a real APK, and whether the runner has enough disk with all native builds together. If the run fails, look first at: (1) "Fetch MAME core" (hash or download); (2) "No space left on device" while packaging; (3) the APK check message (it says which file is missing).

## Step 9 — final details, static checks, flat zip

**All 9 steps are done.** The zip `RizwanS2-youtube-step7.zip` holds the whole project (flat: every file in the zip root, no sub-folder). Nothing from steps 1-8 was removed; the per-step sections above stay as they were written (their wording "until step 7" and similar describes the state at that step).

**What the MAME app is, in one place**
- Module `:mame` (package `com.seleuco.mame4droid`, resources `mm_`, assets `assets/mame/`), MAME4droid (Current) v1.41.2 with MAME core 0.289, GPL-2.0-or-later (`NOTICE-MAME4droid.md`, `LICENSE-MAME4droid`). arm64-v8a only, Android 8.0+.
- Core `libMAME4droid.so` (367 MB) and `files.zip` (64 MB) are downloaded and hash-checked at build time (`mame/tools/fetch-upstream.sh`, pins in `mame/UPSTREAM_SHA256` and `mame/UPSTREAM_VERSION`); they are packed into the APK (about +170 MB).
- Own process `:mame`, own task, own settings file `mame4droid_settings`; `App.kt` starts no engine in that process.
- Opened from the Start menu, the Home screen and `rizwans2://mame` (`MameLauncher.kt`), only on supported phones. ROMs: you supply them (`.zip` / `.7z`, MAME 0.289 sets), the folder is chosen inside MAME (SAF).
- CI: both workflows fetch the core and fail if the core, JNI library, files.zip or help pages are not in the APK.

**Static checks run in this step (all passed):**
- 113 XML files (module + app) parse; the 6 `:mame` activities all run in `:mame`, have no LAUNCHER filter and their classes exist.
- All 3,735 value resources and all non-values resource files of `:mame` start with `mm_`; no `mm_` file exists in another module; every `@type/name` in the module resolves. Every `R.type.name` in the Java code resolves too, except the Android framework ones (`android.R...`) and `R.raw.mm_files`, which is the downloaded `mm_files.zip` (not in the zip by design).
- `MameLaunch.UPSTREAM_VERSION` equals `mame/UPSTREAM_VERSION` (1.41.2); `settings.gradle.kts` includes `:mame`, `:app` depends on it, `mame/core/` is git-ignored, no file in `mame/` is larger than 20 MB.
- `openMame()` and `isMameSupported()` are defined once; the Start menu, Home and deep-link hooks all use them; braces / parentheses balance in the five changed Kotlin files.
- `fetch-upstream.sh` passes `bash -n`; the 5 workflows parse as YAML; the APK check block passed / failed correctly on fake APKs (step 8). No emoji in any file written for this feature (icons are vector paths only).

**Still not done here (this environment has no Gradle, Android SDK, NDK, GitHub access or phone):** Gradle sync and build, the `ndk-build` of `mame4droid-jni.c`, Kotlin compile of `:app`, the manifest merge, a real workflow run, and every run on a phone.
**First things to try on your phone (Tecno Spark Go 3 or another 64-bit ARM phone):** (1) Start menu -> MAME opens (also the Home icon and `rizwans2://mame`); (2) first start: choose the ROM folder; (3) start a game, use touch controls and a gamepad; (4) exit returns to Win11 and the launcher stays alive; (5) MAME settings open and keep their values after a restart.
**If the build fails, look first at:** "Fetch MAME core" (download / hash), "No space left on device" while packaging, the APK check message, then a manifest / resource merge message mentioning `mm_` or `com.seleuco`, then `ndkBuild` with NDK `29.0.13846066`.
**Possible later work (not started):** a Bengali translation of the MAME screens (about 600 strings), a "recent games" entry in the Start menu on top of `MameLaunch.rom(...)`, an optional workflow that builds MAME 0.289 from source (plan B), a cache for the core.

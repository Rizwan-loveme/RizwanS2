# :ppsspp — built-in PPSSPP (PSP emulator)

Upstream: https://github.com/hrydgard/ppsspp, pinned in `UPSTREAM_VERSION` (**v1.20.4**). Licence: GPL-2.0-or-later, see `../NOTICE-PPSSPP.md` and `../LICENSE-PPSSPP`.

## Plan (10 steps)

| # | Part | Status |
|---|------|--------|
| 1 | Get the source (v1.20.4 + submodules) | done |
| 2 | Split out the Android part into the `:ppsspp` module (this folder) | done |
| 3 | Gradle wiring (settings, module build file, CMake path, ABIs, `:app` dependency) | done |
| 4 | Manifest merge into `:app` | done |
| 5 | Hooks: Start menu, Home screen, `rizwans2://ppsspp`, File Manager (.iso/.cso/.pbp) | done |
| 6 | Assets and NOTICE-PPSSPP.md (GPL-2.0+) | done |
| 7 | CI: fetch upstream, NDK + CMake, ccache | done |
| 8 | README / docs | done |
| 9 | Checks (static only) | done |
| 10 | Final flat zip | done |

## Step 2 — what is in this folder

- `src/main/java/org/ppsspp/ppsspp/` — the 19 upstream Java files, package kept (the native JNI names depend on it).
  Two edits: `ShortcutActivity` uses `R.mipmap.pp_ic_launcher`; `PpssppActivity.isVR()` returns `false` (no `BuildConfig.FLAVOR`, single variant).
- `src/main/proto/tombstone.proto` — upstream crash-report proto (needs the protobuf plugin, step 3).
- `src/main/res/` — upstream "normal" flavor resources, every name prefixed `pp_` so nothing clashes with `:app` / other modules
  (`pp_app_name`, `pp_shortcut_name`, `pp_style`, `pp_theme_proxy_transparent`, `pp_black`, `pp_ic_launcher*`, `pp_ic_banner`).
- `src/main/AndroidManifest.xml` — library manifest: the 4 activities, features and permissions; upstream differences are listed at its top
  (no LAUNCHER filter, no `<application>` attributes, no flavors).
- `tools/fetch-upstream.sh` — clones the C++ core (`UPSTREAM_VERSION`) into `ppsspp/upstream/` (git-ignored, **not in the zip**; CI and local builds run it first).
- Dropped from upstream on purpose: `gold`, `legacy`, `vr` flavors, `debug.keystore`, the app's own git-version Gradle logic, `jniLibs` validation-layer README.
  `android/jni/*.cpp` (the JNI C++) comes with `upstream/` and is built through upstream's root `CMakeLists.txt` (step 3).

## Step 3 — Gradle wiring

- `settings.gradle.kts`: `include(":ppsspp")`. Root `build.gradle.kts`: protobuf plugin `0.9.6` (the AGP 8.x line; `0.10.0` is for AGP 9). `:app`: `implementation(project(":ppsspp"))`.
- `ppsspp/build.gradle.kts`: library module, namespace `org.ppsspp.ppsspp`, compileSdk 37, minSdk 26, NDK `ext.ndkVer` (same as the other native modules),
  CMake 3.22.1 with `path = upstream/CMakeLists.txt` and upstream's "normal" flavor arguments (`-DANDROID=true`, `c++_shared`, platform raised to android-26).
- ABIs: `arm64-v8a` by default. More: `-PppssppAbis=arm64-v8a,armeabi-v7a` (or the same line in `gradle.properties`).
- `fetchPpssppUpstream` task (bash + git) runs `tools/fetch-upstream.sh` before every CMake / `externalNativeBuild` task, so the C++ core is cloned automatically
  when `ppsspp/upstream/` is missing; offline, put the files there by hand and the task does nothing.
- `consumer-rules.pro` keeps `org.ppsspp.ppsspp.**` (JNI) if `:app` ever turns on minify.
- Because `:app` depends on `:ppsspp`, the library manifest (4 activities, permissions, .iso/.cso/.chd/.elf/.pbp filters) is already merged into the app;
  step 4 reviews that merge. Not yet built: the first real build runs in your GitHub workflow (step 7 adds NDK / ccache there).

## Step 4 — manifest merge into `:app`

The library manifest is merged by Gradle (nothing is copied into `:app`'s manifest; it only got a comment saying so). Checked by hand against every other module:

- **Activities**: `PpssppActivity` (VIEW filters for .iso / .cso / .chd / .elf / .pbp / .ppdmp, `singleInstance`, full-screen `pp_style`), `ShortcutActivity` (CREATE_SHORTCUT),
  `ImageResultProxyActivity`, `DocumentResultProxyActivity` (transparent). Names are qualified with `org.ppsspp.ppsspp`, so no clash. No MAIN / LAUNCHER filter, so no second launcher icon.
- **Permissions**: every one already exists in `:app`, `:winlator`, `:Bcore`, `:j2me` or `:camera` (same merge already works there), except `TRANSMIT_IR`
  (normal permission, no prompt) and `archos.permission.FULLSCREEN.FULL` (unknown to Android, ignored). `:app`'s `WRITE_EXTERNAL_STORAGE maxSdkVersion=28` is untouched.
- **Features**: all `android.hardware.*` / `leanback` entries are `required="false"`; the only hard one is OpenGL ES 2.0 (`glEsVersion 0x00020000`), which every supported device has.
- **Application attributes**: none from the library, so `:app` keeps its own (`allowBackup`, `requestLegacyExternalStorage`, `extractNativeLibs`, theme, label, icon).
  `android.max_aspect` (2.4) moved from `<application>` to `PpssppActivity` so it does not change the other apps. icon / label / banner are set on `PpssppActivity`.
- **Resources**: all names start with `pp_`; a scan of every module found no clash.
- **Open-with**: `PpssppActivity`'s file filters make the app a handler for PSP files for the whole system; the File Manager side (own "Open with" sheet) comes in step 5.

## Step 5 — hooks in `:app`

Same pattern as J2ME / Camera (`app/src/main/kotlin/com/srizwan/win11/`):

| Where | What |
|-------|------|
| `PpssppLauncher.kt` (new) | `openPpsspp()`, `isPpssppFile(name)`, `openPpssppFile(file)` |
| Start menu | built-in app **PPSSPP** (handheld-console icon, blue `#4C8DFF`), section `ppsspp` (`StartApps.kt`). The "All apps" list is sorted by name, so app numbers (`rizwans2://5`) of the apps after "PPSSPP" move by one |
| Home screen | desktop icon **PPSSPP** under J2ME (`Win11Shell.kt`, `VectorIconView.PPSSPP`) |
| Deep link | `rizwans2://ppsspp` (`MainActivity.kt`; the list in the code comment and in the manifest comment is updated) |
| File Manager | tap `.iso` / `.cso` / `.chd` / `.pbp` / `.elf` / `.ppdmp` → the game starts in PPSSPP (`FileManagerUi.kt` `openFile`, before the Winlator branch); these files get a blue type chip (`fileTypeColor`) |

- The game path goes in PPSSPP's own shortcut extra (`PpssppActivity.SHORTCUT_EXTRA_KEY`), as a plain absolute path: no `file://` uri (the app targets API 28, where it throws)
  and no `content://` uri (PPSSPP would have no real path). Reading it relies on the all-files permission `:app` already has.
- Upstream limit: when PPSSPP is already running, a second game is not switched to (upstream's `onNewIntent` has a TODO for it); close PPSSPP first.
- To change which extensions open in PPSSPP: `isPpssppFile` (list) and the `fileTypeColor` line; the system-wide open-with list is in `:ppsspp`'s manifest.

## Step 6 — assets and licence

- **Assets**: `assets.srcDir("upstream/assets")` in `ppsspp/build.gradle.kts` (upstream does the same with `../assets`). About 22 MB cloned with the source: fonts, `font_atlas` / `ppge_atlas` / `asciifont_atlas`,
  `flash0`, `lang`, `vfpu`, `debugger`, `compat.ini`, `gamecontrollerdb.txt`, sounds, ... The native code reads them by name through the AssetManager, so nothing is renamed.
  The `fetchPpssppUpstream` task now also runs before every `merge*Assets` task, so the folder exists when assets are merged.
  Like Winlator's big archives, they are not in the project zip.
- **Licence**: `LICENSE-PPSSPP` (upstream's `LICENSE.TXT`: PSPSDK BSD notice + GPL-2.0 text) and `NOTICE-PPSSPP.md` (version, what is fetched, GPL duties, list of changes) in the project root, same place as the other NOTICE files.
- **Heads-up**: GPL-2.0-or-later code now runs in the same process as the Apache-2.0 and LGPL parts; the notice explains the usual way this is handled and asks you to check it before publishing.
- **APK size** grows by `libppsspp_jni.so` (arm64) plus the assets (not measured here).

## Step 7 — CI (`.github/workflows/UltimateBuild.yml` and `UltimateBuild_NoWinlator.yml`)

Both build workflows got the same changes (the other workflows do not build the app and are untouched):

- **Free disk space** (first step): removes the runner's unused .NET / GHC / Boost toolchains (Winlator assets + PPSSPP source + native builds need the room).
- **Cache PPSSPP source** + **Fetch PPSSPP source**: `ppsspp/upstream` is cached on `ppsspp/UPSTREAM_VERSION` + the fetch script, then `fetch-upstream.sh` runs (it does nothing when the tag is already there).
  Both come *after* the package-rename step, so the renamer never touches upstream files. The Gradle task `fetchPpssppUpstream` stays as a second safety net.
- **ccache** (only for PPSSPP's C++): installed with apt, `CCACHE_COMPILERCHECK=content` (the NDK is installed fresh each run, so mtime comparison would never hit),
  cache `~/.cache/ccache` (max 1.5 GB), and `ORG_GRADLE_PROJECT_ppssppCcache=true` makes `:ppsspp` add `-DCMAKE_C/CXX_COMPILER_LAUNCHER=ccache` (`ppsspp/build.gradle.kts`).
  The first run is a cold build; later runs reuse the cache.
- **Timeout** 60 -> 120 minutes (cold PPSSPP build + the other native modules).
- **APK check** (in "Locate Unsigned APK"): the run fails if `lib/arm64-v8a/libppsspp_jni.so` or `assets/ppge_atlas.zim` is missing, and prints the PPSSPP entries and ccache statistics.
- NDK / CMake: nothing new to install: the existing step already installs NDK `29.0.13846066` and `cmake;3.22.1`, the same ones `:ppsspp` uses.
- The no-Winlator workflow still builds PPSSPP (it only removes `:winlator`).
- Not run here (no GitHub access): the first run in your repository is the real test of steps 3-7.

## Step 8 — details updated

- Root `README.md`: new section "PPSSPP — `:ppsspp` module" (plan table, where it is hooked in, changes compared with upstream, not-verified list and device test).
- `settings.gradle.kts` (`include(":ppsspp")` with its comment), `app/build.gradle.kts` (dependency), `:app` manifest (comment about the merge, deep-link list with `ppsspp`),
  `MainActivity` KDoc of `handleDeepLink`, `:ppsspp` manifest header, `NOTICE-PPSSPP.md`, `LICENSE-PPSSPP`, this file: all list PPSSPP.
- Version stays **2.5.3 (code 120)**: nothing in the build files asks for a bump.

## Steps 9 and 10 — checks and final zip

- Static checks only (no SDK / NDK / network here): XML and YAML parse, bracket balance, `pp_` resources unique and resolved, no duplicate manifest entries, hooks and CI steps present. Details: root `README.md`, "Step 9 results".
- Not run: Gradle, the native build, CI, a device. The first real build is your GitHub workflow (`UltimateBuild.yml`).
- Final file: `RizwanS2-main-ppsspp.zip` (flat: `build.gradle.kts`, `app/`, `j2me/` ... at the root). The C++ core is not inside; CI clones `UPSTREAM_VERSION` into `ppsspp/upstream/`.
- ABI: `arm64-v8a` only (default). For 32-bit phones add `ppssppAbis=arm64-v8a,armeabi-v7a` to `gradle.properties` (bigger APK, longer build).

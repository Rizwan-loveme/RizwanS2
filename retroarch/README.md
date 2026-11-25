# :retroarch — built-in RetroArch (libretro frontend), (all 12 steps done; nothing built or run yet)

Upstream: https://github.com/libretro/RetroArch, pinned in `UPSTREAM_VERSION` (**v1.22.2**) and `UPSTREAM_COMMIT` (**69a4f0ea1e8aaf442ae4858f2e7f2b31a1776576**). Licence: GPL-3.0 (see "Licence" below).
Decision from you: **cores are NOT bundled.** Cores, core info files and assets come from RetroArch's own *Online Updater* (Core Downloader) at run time.

## Plan (12 steps)

| # | Part | Status |
|---|------|--------|
| 1 | Inspect upstream (tag, Android project, manifest, native build, clashes) | **done** (results below) |
| 2 | Pin the version (`UPSTREAM_VERSION` + `UPSTREAM_COMMIT`) | **done** (tag and commit checked on GitHub, see "Step 2" below) |
| 3 | `:retroarch` library module (Gradle, `settings.gradle.kts`, `:app` dependency, ABIs) | **done** (empty module, see "Step 3" below) |
| 4 | `tools/fetch-upstream.sh` + Gradle task `fetchRetroarchUpstream` | **done** (script run for real, see "Step 4" below) |
| 5 | Native build (ndk-build, `Android.mk`, ccache) | **done in the build file, not compiled yet** (see "Step 5" below) |
| 6 | Java, resources and manifest of the module (prefix `ra_`, merge check, own process `:retroarch`) | **done, not built yet** (see "Step 6" below) |
| 7 | Core / data handling: online downloader only (nothing bundled) + the launcher picks the downloaded core for a game | **done** (decision checked against upstream, core picker compiled and tested, see "Step 7" below) |
| 8 | Hooks in `:app`: Start menu, Home screen, `rizwans2://retroarch`, File Manager (ROM files) | **done, not compiled yet** (see "Step 8" below) |
| 9 | `NOTICE-RetroArch.md`, `LICENSE-RetroArch`, GPL compatibility note | **done** (files only; 3 open licence items for you, see "Step 9" below) |
| 10 | CI download + build in both workflows | **done in the YAML, not run yet** (see "Step 10" below) |
| 11 | Docs | **done** (overview at the top of this file, `docs/CHANGES-step8-retroarch.md`, step texts checked, see "Step 11" below) |
| 12 | Static checks and final flat zip | **done** (see "Step 12" below) |

## Overview (read this first; the rest of this file is the step-by-step log)

**What it is.** The built-in **RetroArch** app (libretro frontend, GPL-3.0, upstream `v1.22.2`): the `:retroarch` library module, package `com.retroarch` (upstream's package is kept because the C code calls the Java classes by name). 64-bit ARM phones only (Android 8.0+). It runs in its own process `:retroarch`, so upstream's `System.exit` / `exit` never closes Win11. **Nothing was built or run on a device here**: Gradle, the NDK and CI cannot run in this environment, so the first GitHub run is the real test (see "What is not verified" below).

**Where it opens from**
| Entry | Behaviour |
|-------|-----------|
| Start menu **RetroArch**, Home icon, `rizwans2://retroarch` | RetroArch's own menu (or back to the running game). Shown only when the phone reports `arm64-v8a` **and** `libretroarch-activity.so` is in the app's lib folder |
| File Manager, tap a game file | `nes fds sfc smc gb gbc gba n64 z64 v64 nds gen smd 32x sms gg pce sgx a26 a78 lnx ngp` open in RetroArch with the downloaded core picked by `RetroArchCores.kt`. Not these (ambiguous, or PPSSPP's): `bin cue iso chd cso elf pbp zip 7z md vb ws wsc ngc col int`; they still reach RetroArch through *Open with* or RetroArch's own file browser |

The "All apps" numbers (`rizwans2://N`) shift by one for the apps after **RetroArch** in the name-sorted list, **but only on phones where the entry is shown** (the entry is hidden on 32-bit phones), so the numbers differ between devices. Use the named links for a fixed target.

**First use on a phone** (cores are NOT bundled, your decision): Start menu -> **RetroArch** -> *Online Updater* -> **Update Core Info Files** -> **Core Downloader** (for example FCEUmm for NES, Snes9x, Gambatte, mGBA, Genesis Plus GX) -> optionally **Update Assets** (menu icons and font) -> back to Win11 -> File Manager -> tap a ROM. Some cores need BIOS / firmware files in RetroArch's `system` folder (*Settings -> Directory -> System/BIOS* shows where). It only works while `:app` keeps `targetSdk = 28` (from targetSdk 29 Android blocks running downloaded `.so` files from the app's data folder).

**Files** (new = added for this feature, edited = existing file with a RetroArch change)
| Where | What |
|-------|------|
| `retroarch/` | `build.gradle.kts`, `consumer-rules.pro`, `UPSTREAM_VERSION`, `UPSTREAM_COMMIT`, `src/main/AndroidManifest.xml`, 10 Java files (3 edited from upstream, marked `WIN11`), `res/` (6 `ra_` names), `tools/fetch-upstream.sh`, `tools/diff-upstream-java.sh`, this file |
| `retroarch/upstream/` | the cloned C source (about 330 MB): **not in the zip, git-ignored**, made by `fetch-upstream.sh` |
| `app/.../RetroArchLauncher.kt`, `RetroArchCores.kt` | new: the hooks and the core picker |
| `app/.../StartApps.kt`, `Win11Shell.kt`, `MainActivity.kt`, `FileManagerUi.kt`, `FileExplorerUi.kt`, `App.kt` | edited: Start menu entry, Home icon, deep link (+ KDoc list), File Manager hook, file colours, no engine in the `:retroarch` process |
| `app/src/main/AndroidManifest.xml`, `app/build.gradle.kts`, `app/proguard-rules.pro`, `settings.gradle.kts`, `gradle.properties`, `.gitignore`, `.gitattributes` | edited: comment, dependency, keep rules, `include`, switches, ignore / line-ending rules |
| `.github/workflows/UltimateBuild.yml`, `UltimateBuild_NoWinlator.yml` | edited: cache, fetch, ccache, APK check |
| `NOTICE-RetroArch.md`, `LICENSE-RetroArch` | new: notice, changes list, GPL-3.0 text, compatibility note |
| `docs/CHANGES-step8-retroarch.md` (+ `-step1` ... `-step10`) | new: overall change list and one file per step |

**Switches** (all optional, `-P...` or `gradle.properties`): `retroarchNative=false` (no native build and no 330 MB clone; the module stays empty, do not use the hooks), `retroarchAbis=arm64-v8a,x86_64`, `retroarchCcache=true` (CI sets it), `retroarchGles=3`, `retroarchCFlags` / `retroarchCppFlags` (empty by default). Task: `./gradlew :retroarch:fetchRetroarchUpstream`.

**CI** (both workflows, step 10): cache of `retroarch/upstream`, "Fetch RetroArch source" after the package rename (stops on a wrong commit), ccache shared with PPSSPP, and an APK check (native library present and over 1 MB, both activities in the merged manifest in process `:retroarch`). No check for RetroArch assets or cores: none are bundled.

**Moving to a newer RetroArch**: change `UPSTREAM_VERSION` and `UPSTREAM_COMMIT` together (`git ls-remote --tags https://github.com/libretro/RetroArch.git 'v*'`), run `./gradlew :retroarch:fetchRetroarchUpstream`, then `bash retroarch/tools/diff-upstream-java.sh` (3 changed files expected; re-merge by hand if upstream changed them), re-check the manifest against upstream's, compare `Android.mk` flags, and do a full CI build.

**First CI run result (2026-11-23): one C error, fixed.** `:retroarch:buildNdkBuildRelease[arm64-v8a]` failed in `griffin.c` -> `input/drivers/android_input.c:1641`: `'ALooper_pollAll' is unavailable: obsoleted in Android 1` (NDK 29 removed it; upstream v1.22.2 was written for NDK r22). Fix: `tools/fetch-upstream.sh` now runs `apply_ndk_patches` (after a fresh clone, on a cached clone and on a hand-placed one), which changes `ALooper_pollAll(` to `ALooper_pollOnce(` (same signature, inside a `while (... >= 0)` loop, so all events are still drained; same change as upstream master). The commit check is not affected (only the working tree changes). `ASensorManager_getInstance` is only a deprecation warning. The compiler stops at the first failing file, so other NDK 29 errors in files not reached yet are possible: send the next log.

**If the first CI run fails** (most likely first)
| Symptom in the log | Likely cause | First thing to try |
|--------------------|--------------|--------------------|
| `:retroarch:buildNdkBuild...` C errors such as implicit function declaration / int conversion / incompatible function pointer | tag written for NDK r22, project uses NDK 29 (clang 21) | switch on the commented `retroarchCFlags` line in the workflow's ccache step (step 5 and step 10 notes); then a small patch to the clone's `Android.mk`, or pin a master commit |
| "commit ... is not UPSTREAM_COMMIT" in "Fetch RetroArch source" | the tag was moved, or only one of the two pin files was changed | change both files together (see above) |
| out of disk space during the native build or APK packing | PPSSPP + MAME + RetroArch + Winlator on one runner | the `df` lines in "Free disk space" and after the fetch show the numbers; use the NoWinlator workflow, or free more |
| APK check: `libretroarch-activity.so` missing | native build skipped (`retroarchNative=false`) or the ABI filter | do not set `retroarchNative=false` in CI |
| APK check: activity / process missing in the merged manifest | manifest merge problem | compare with `retroarch/src/main/AndroidManifest.xml` and the merged file named in the log |
| build stops on `:retroarch` Gradle configuration (before any C code) | `buildConfig` handling or the empty-at-configuration `Android.mk` path | read the first error; `:ppsspp` has the same pattern and works |

**What is not verified (all steps together)**: that anything builds or runs: of the 8 Kotlin files involved only `RetroArchCores.kt` (real Kotlin compiler) and `RetroArchLauncher.kt` (against stubs of the Android classes) were ever compiled, the 6 edited ones (`App.kt`, `StartApps.kt`, `Win11Shell.kt`, `MainActivity.kt`, `FileManagerUi.kt`, `FileExplorerUi.kt`) were only checked by reading and bracket counts; the Java against the real Android SDK and the NDK build were not compiled either; the restart when another game is opened while RetroArch runs; that the buildbot core names match the preference list in `RetroArchCores.kt` (a miss only means the info-file fallback or the menu hint is used); how RetroArch's menu looks before *Update Assets*; the download of cores over plain `http` from the buildbot; runner disk space, time and cache size; and the three licence items in "Step 9".

## Step 1 — what upstream looks like (checked against the real `v1.22.2` tree, not built)

**Version and size**
- Newest stable tag is `v1.22.2` (tags `v1.22.0`, `v1.22.1` before it). The tag has 11,147 files and **no `.gitmodules`**, so no submodules (`deps/` is inside the repo). One shallow clone is enough.
- `master` (checked 2026-11-23) is far ahead of the tag, so the tag is pinned for stability: see "Tag or master" below.

**Android project** — `pkg/android/phoenix` (app module, Gradle) + `pkg/android/phoenix-common` (shared `jni/`, `src/`, `res/`) + `pkg/android/play-core-stub` + `libretro-common/vfs/saf/src` (Java SAF code).
- At the tag: AGP 4.2.0, compileSdk 30, NDK r22, minSdk 16, targetSdk 28, flavors `normal`, `aarch64`, `ra32`, `playStoreNormal`, `playStorePlus`. We use none of this: `:retroarch` gets its own build file.
- RetroArch is a **NativeActivity**: `RetroActivityFuture` has meta-data `android.app.lib_name = retroarch-activity`, so the native library is `libretroarch-activity.so`.

**Native build** — `ndk-build`, `pkg/android/phoenix-common/jni/Android.mk` (not CMake).
- One module, `retroarch-activity`: `griffin/griffin.c` (the whole C frontend in one unit) + `griffin_cpp.cpp` + `griffin_glslang.cpp` (Vulkan: glslang, SPIRV-Cross, builtin mbedTLS, cheevos, CHD, 7zip, zstd, FLAC ...).
- `RARCH_DIR := ../../../..`: the build needs the **whole repo** at that relative position, so the module's `externalNativeBuild.ndkBuild.path` will point to `retroarch/upstream/pkg/android/phoenix-common/jni/Android.mk` (upstream clone in `retroarch/upstream/`, git-ignored, not in the zip: same idea as `:ppsspp`).
- `Application.mk`: `APP_STL := c++_static`; its own `APP_ABI` / `APP_PLATFORM` defaults are overridden by Gradle (ABI filters, minSdk).
- The makefile asks `git rev-parse --short HEAD` for the version string (`2>/dev/null`, so a missing `.git` is not an error, the version suffix is just empty). The clone keeps its `.git` anyway (step 4 corrected this note: it is wanted, not required).
- Heaviest compile unit is the Vulkan / glslang part; expect a long first CI build, ccache helps later runs (`NDK_CCACHE`).

**Java side (small)** — 9 files + the play-core stub, package `com.retroarch`:
`browser/mainmenu/MainMenuActivity` (launcher: permission check, `UserPreferences.updateConfigFile`, then starts `RetroActivityFuture`), `browser/retroactivity/RetroActivityFuture|Common|Camera|Intent`, `browser/preferences/util/UserPreferences|ConfigFile`, `browser/provider/RetroDocumentsProvider`, `browser/debug/CoreSideloadActivity` (debug only), `playcore/PlayCoreManager` (stub with empty methods, still called by `RetroActivityCommon`).
- Intent extras the native code reads: `ROM` (content path), `LIBRETRO` (core path), `CONFIGFILE`, `IME`, `DATADIR`, `APK` (= app `sourceDir`), `SDCARD`, `EXTERNAL`; also `QUITFOCUS`, `REFRESH`. Starting `RetroActivityFuture` with `ROM` + `LIBRETRO` is how a ROM can be opened from the File Manager later (step 8). Without `ROM` it shows RetroArch's own menu.
- Java uses `BuildConfig.PLAY_STORE_BUILD` (so the module needs `buildFeatures.buildConfig = true` and `buildConfigField("boolean", "PLAY_STORE_BUILD", "false")`) and `R.mipmap.ic_launcher` / `R.string.app_name`.

**Manifest** (to be reduced to a library manifest in step 6)
- Application attributes (`RetroArchApplication` stub, allowBackup, icon, label, isGame, banner, extractNativeLibs, requestLegacyExternalStorage): dropped, `:app` keeps its own.
- Activities: `MainMenuActivity` (remove the MAIN / LAUNCHER / LEANBACK filters: no second launcher icon), `RetroActivityFuture` (exported, `singleInstance`, long `configChanges`, fullscreen theme, the two meta-data lines), `CoreSideloadActivity` (dropped).
- `RetroDocumentsProvider`, authority `${applicationId}.documents`, enabled through a bool (true from API 19): it shows RetroArch's folders in the system file picker. To be decided in step 6 (keep or disable).
- Permissions: storage, INTERNET, VIBRATE. INTERNET and VIBRATE are already in `:app`.

**Assets and cores (your decision: online downloader only)**
- The native side reads an optional `assets/` folder from the app APK (`APK` extra). Upstream's own CI (`Android.yml`: `./gradlew assembleDebug`) builds **without** any `assets/` folder, so an APK without bundled assets is a supported setup.
- First start: the user opens *Online Updater* and downloads *Core Downloader* cores, *Core Info Files*, *Assets* (and shaders / overlays if wanted). INTERNET is already granted.
- Cores are loaded from `<dataDir>/cores/`. Executing downloaded `.so` files from the app's data folder only works while `:app` keeps `targetSdk = 28`. With targetSdk 29+ Android blocks it. **Part 8 of the Mika plan set `:app` to `targetSdk = 37` (owner decision), so expect the Core Downloader's cores to stop loading; `-PappTargetSdk=28` (or `appTargetSdk=28` in `gradle.properties`) brings the old behaviour back. See `docs/CHANGES-mika-part8.md`.**

**Resource clashes with the other modules (checked)**

| Upstream name | Where it clashes | Plan |
|---|---|---|
| `mipmap/ic_launcher` (+ `ic_launcher_foreground`) | `:app` has `mipmap/ic_launcher`, `:winlator` has `ic_launcher_foreground` | rename to `ra_ic_launcher*` |
| `color/ic_launcher_background` | `:app` drawable and `:winlator` color of the same name | `ra_ic_launcher_background` |
| `string/app_name` (flavor `resValue`) | `:winlator` `app_name` | `ra_app_name` |
| `drawable/banner`, `bool/document_provider_enabled` | no clash today, names too generic | `ra_banner`, `ra_document_provider_enabled` |

Because `R.mipmap.ic_launcher` / `R.string.app_name` are used in Java, the Java files are copied into the module and edited (like `:ppsspp`); only the native tree is fetched at build time.

**Tag or master**
- `v1.22.2` is the pin. `master` has moved on: AGP 9.1, NDK 29.0.14206865, minSdk 21, `MainMenuActivity` removed (an `activity-alias` to `RetroActivityFuture` instead), a core-signature check at load time (`HAVE_CORE_LOAD_CHECK`), 16 KB page-size link flags, `-std=gnu++17`, a new `InstalledCoresReceiver`, `MANAGE_EXTERNAL_STORAGE`.
- Risk: the tag's `Android.mk` was written for NDK r22; the project uses NDK 29.0.13846066. The diff to master shows no NDK-29-only compiler fix except `gnu++17` and the 16 KB flags (NDK 28+ aligns to 16 KB by default), so it should build, but this is **not tested**. If the first CI build fails on this, the options are a small patch to the cloned `Android.mk` or pinning a master commit instead.

**Licence**
- RetroArch is GPL-3.0. The app already contains GPL-2.0-or-later (PPSSPP), MAME4droid (its source headers say GPL-2.0 **or any later version**, checked in step 9), Apache-2.0 and LGPL parts. Whether GPL-3.0 and a "GPL-2.0 only" part can ship in one APK depends on the exact "or later" wording of each; the notice (step 9) will say so. Check it before publishing.

**Not verified in step 1:** that `v1.22.2` compiles with this project's NDK, the exact name of the `.so` in the APK (expected `lib/arm64-v8a/libretroarch-activity.so`), and anything on a device. Checked from a partial clone of the tag in a scratch folder; nothing from upstream is stored in this project.

## Step 2 — version pinned and verified (checked against GitHub on 2026-11-23)

| File | Content |
|------|---------|
| `UPSTREAM_VERSION` | `v1.22.2` (one line, no comments: the fetch script reads it with `tr -d '[:space:]'`, same as `ppsspp/UPSTREAM_VERSION`) |
| `UPSTREAM_COMMIT` | `69a4f0ea1e8aaf442ae4858f2e7f2b31a1776576` (comment lines start with `#`, the commit is the only other line) |

What was checked
- `git ls-remote --tags` lists `v1.19.1, v1.20.0, v1.21.0, v1.22.0, v1.22.1, v1.22.2`: **v1.22.2 is the newest stable tag**. (Step 1 only had the date from a mirror site; this is now confirmed on GitHub itself.)
- The tag is a *lightweight* tag: it points straight at commit `69a4f0ea…`, committed **2025-11-20 00:17 UTC** ("Fetch translations from Crowdin").
- The tag's tree has **no `.gitmodules`**, so the fetch script needs no `--recurse-submodules` (differs from `:ppsspp`).
- `master` (`5aec20a6…` when checked) is ahead of the tag and is **not** used: see "Tag or master" above.

Why a commit file next to the tag
- `:mame` pins hashes for what it downloads. For a git clone the same protection is the commit: a tag can be deleted and re-created on another commit, and the build would change without any change in this project.
- Step 4 (`tools/fetch-upstream.sh`) will compare `git rev-parse HEAD` of the clone with `UPSTREAM_COMMIT` and stop with an error if they differ. Step 10 will put both files in the CI cache key, so changing either one refreshes the cache.

How to move to a newer RetroArch later: change both files together (`git ls-remote --tags https://github.com/libretro/RetroArch.git 'v*'` gives the commit), then do a full CI build and check the resource-clash table and `Android.mk` flags again.

Nothing else was changed in step 2: no Gradle, manifest, CI or app code. `:retroarch` is still not included in `settings.gradle.kts` (step 3).

## Step 3 — the `:retroarch` library module (wiring only, still empty)

New / changed files
- `retroarch/build.gradle.kts` — library `com.retroarch`, compileSdk 37, minSdk 26, the project's `ndkVer`, `buildConfig` on with `PLAY_STORE_BUILD = false`, Java 17, `useLegacyPackaging = true`, lint like the other modules.
- `retroarch/consumer-rules.pro` — keeps `com.retroarch.**` and `com.libretro.common.vfs.**` (the native code calls them by name). Same two lines are repeated in `app/proguard-rules.pro` (like `:mame`), because `:app` has minify off today.
- `retroarch/src/main/AndroidManifest.xml` — placeholder `<manifest/>` (the package comes from `namespace`); step 6 replaces it.
- `settings.gradle.kts` — `include(":retroarch")` with a comment (upstream, licence, cores not bundled, step state).
- `app/build.gradle.kts` — `implementation(project(":retroarch"))` after `:mame`.

Decisions in this file (and why)
- **Empty on purpose.** The module has no Java, no resources, no native build yet. Wiring it into `settings.gradle.kts` and `:app` first means a failed first CI run can only be about the wiring, not about 11,000 upstream files. Nothing starts or shows in the app yet (no launcher icon, no menu entry).
- **No `dependencies` block.** Checked the imports of every upstream Java file we will use (`pkg/android/phoenix/src`, `phoenix-common/src`, `libretro-common/vfs/saf/src`, `play-core-stub`): only `android.*` and `java.*`. Upstream's own `build.gradle` only has Play Core, and only for the Play Store flavors, which we drop (the stub is used).
- **ABIs.** `arm64-v8a` only by default, like `:ppsspp` and `:mame`. Override: `-PretroarchAbis=arm64-v8a,x86_64` (or `retroarchAbis=...` in `gradle.properties`). Upstream's `aarch64` flavor also builds `x86_64`, `ra32` builds the 32-bit ABIs; neither is needed on a phone. The filter is set now but only has an effect once step 5 adds the native build.
- **No flavors, signing, version logic.** `:app` is the only application, so its versionCode / versionName / signing apply.
- **Java 17**, like `:mame` (upstream's Java is old, plain Android framework code; 17 compiles it and matches the JDK of CI).
- **`ndkVersion`** is set now (same one NDK for the whole project, `29.0.13846066`); with no native code yet it is not used.
- **Not copied from upstream:** `jniLibs.srcDir ../phoenix-common/libs` (no prebuilt libs are shipped), `jni.srcDirs = []`, `res64` for the aarch64 flavor (only icons / values of that flavor).
- **CI:** both workflows run `./gradlew assembleRelease` for the whole project and have no per-module lists, so no workflow change is needed in this step (step 10 adds the fetch / cache / checks).

Checks done (static only, Gradle / the NDK / CI cannot run here)
- Manifest is well-formed XML; brackets balance in the three edited Gradle files; `include(":retroarch")` appears once; `project(":retroarch")` appears once in `:app`; the root build file already provides `extra["ndkVer"]`.
- Namespace `com.retroarch` is unique among the modules; CI's package-rename step only rewrites the *app's* old package and does not touch it.

Not verified: a real Gradle sync / build. Expected result of the next CI run: it passes exactly as before (the extra module is empty and adds a `BuildConfig` class only). If it fails on `:retroarch`, the most likely causes are `buildConfig` handling or the empty manifest, both easy to fix from the log.

Next: step 4, `tools/fetch-upstream.sh` (shallow clone of the pinned tag, check `git rev-parse HEAD` against `UPSTREAM_COMMIT`) and the Gradle task `fetchRetroarchUpstream`.

## Step 4 — fetch script and Gradle task (script tested for real against GitHub on 2026-11-23)

New / changed files
- `retroarch/tools/fetch-upstream.sh` — clones the tag from `UPSTREAM_VERSION` into `retroarch/upstream/` and checks the commit.
- `retroarch/build.gradle.kts` — Gradle task `fetchRetroarchUpstream` (`bash tools/fetch-upstream.sh`, group `retroarch`), run alone with `./gradlew :retroarch:fetchRetroarchUpstream`.
- `.gitignore` — `retroarch/upstream/` (already added in step 2). `.gitattributes` — `*.sh text eol=lf` (a script checked out with Windows line endings fails in bash; also protects the PPSSPP and MAME scripts).

What the script does (in this order)
1. Reads the tag (`UPSTREAM_VERSION`) and the commit (`UPSTREAM_COMMIT`, comment lines skipped) and rejects anything that is not a `v…` tag or a 40-character hash.
2. If `retroarch/upstream/` is already the pinned commit and has all required paths: prints "already present" and stops (fast second run, this is the CI cache hit).
3. Otherwise a shallow clone of the tag (`--depth 1 --branch`, 3 tries with a pause), **keeping `.git`**, no submodules.
4. `git rev-parse HEAD` must equal `UPSTREAM_COMMIT`, otherwise the clone is deleted and the build stops with an error that says what to change.
5. Layout check: 9 paths the module needs in steps 5 and 6 (`Android.mk`, `Application.mk`, the upstream manifest, the three Java source folders including the SAF VFS, `phoenix-common/res`, `griffin/griffin.c`). A missing one deletes the clone and stops the build: a future version bump with another layout fails early and clearly.

Differences from `ppsspp/tools/fetch-upstream.sh`: no `--recurse-submodules` (no `.gitmodules`), the commit is verified, `.git` is kept, **nothing is deleted from the clone** (PPSSPP drops `pspautotests`; here `Android.mk` reaches the whole repo through `RARCH_DIR := ../../../..`, so pruning is not worth the risk).

Offline / hand-placed: `RETROARCH_REPO_URL` can point to a mirror. A `retroarch/upstream/` without `.git` that holds the Android project is used as it is, with a warning (the commit cannot be checked). One with `.git` must match `UPSTREAM_COMMIT`, otherwise it is fetched again.

Tested (real run, not only reading the script)
| Case | Result |
|------|--------|
| First run, empty folder | clone of `v1.22.2`, 11,147 files, commit matched, layout ok |
| Second run | "already present", instant, exit 0 |
| Pinned commit changed to `000…0` | error message, clone deleted, **exit 1** |
| `UPSTREAM_COMMIT` not a hash / `UPSTREAM_VERSION` not a tag (`master`) | clear error, exit 1 |
| Source without `.git` (hand-placed) | warning, accepted, exit 0 |
| Required path (`griffin/`) removed | error naming the path, exit 1 |

Size of the clone: about **332 MB** (265 MB files + 67 MB `.git`). Step 10 caches `retroarch/upstream` with a key from `UPSTREAM_VERSION`, `UPSTREAM_COMMIT` and this script; the runner's free-space step must be checked there (PPSSPP source + MAME core are already large).

Gradle hook: `fetchRetroarchUpstream` is attached (`dependsOn`) to the native-build tasks (`configureNdkBuild*`, `buildNdkBuild*`, `generateJsonModel*`, `externalNativeBuild*`). **Those tasks do not exist yet** (the module has no native build until step 5), so in this step the task is dormant: CI does **not** clone RetroArch yet and the build is unchanged. Step 6 adds the Java / resource / asset tasks to the hook once `sourceSets` point into `upstream/`.

Not verified: running the script through Gradle (`Exec` + bash) on CI; the script itself was run directly with bash. `git clone` of the tag needs GitHub access on the runner (it has it, like for PPSSPP).

Next: step 5, native build (`externalNativeBuild { ndkBuild }` on `upstream/pkg/android/phoenix-common/jni/Android.mk`, ABIs, `APP_PLATFORM=android-26`, ccache via `NDK_CCACHE`).

## Step 5 — native build (written and checked statically; NOT compiled: the first CI run is the test)

Changed files: `retroarch/build.gradle.kts` (native build, properties, fetch hook), `gradle.properties` (commented switches), `settings.gradle.kts` comment, README files, `docs/CHANGES-step8-retroarch-step5.md`.

What the build file does now
- `externalNativeBuild { ndkBuild { path = upstream/pkg/android/phoenix-common/jni/Android.mk } }` — upstream's own makefile, unchanged, from the clone of step 4. One module, `retroarch-activity`, sources `griffin/griffin.c` + `griffin_cpp.cpp` + `griffin_glslang.cpp` -> **`lib/arm64-v8a/libretroarch-activity.so`** (the file name the APK check of step 10 will look for).
- ndk-build arguments: `APP_PLATFORM=android-26` (like `:mame`), `APP_STL=c++_static` (upstream's `Application.mk` says the same; repeated so the build does not depend on AGP picking that file up), `-j<cpus>` (upstream's build.gradle does the same).
- Fetch hook: `fetchRetroarchUpstream` now runs before `preBuild` (like `:mame`) and before every native task (`configureNdkBuild*`, `buildNdkBuild*`, `generateJsonModel*`, `externalNativeBuild*`). So the first CI run clones the source itself, no workflow change needed.
- Properties (all optional, `-P...` or `gradle.properties`):

| Property | Effect |
|----------|--------|
| `retroarchNative=false` | **escape hatch**: no native build, no clone, module stays empty (APK like before step 5). Use it if the C build ever blocks the whole APK. Do not use the RetroArch app hooks (step 8) with it. |
| `retroarchAbis=arm64-v8a,x86_64` | ABIs (default `arm64-v8a`) |
| `retroarchCcache=true` | `NDK_CCACHE=ccache` (CI turns it on in step 10) |
| `retroarchGles=3` | `GLES=3`: links `-lGLESv3` and defines `HAVE_OPENGLES3` instead of upstream's default GLESv2 / `HAVE_OPENGLES2` |
| `retroarchCFlags`, `retroarchCppFlags` | extra compiler flags, empty by default (nothing is silenced unless a real build needs it) |

What was checked (no NDK here, so no compile)
- `Android.mk` was **evaluated with GNU make** and stubbed NDK variables for arm64-v8a: module `retroarch-activity`, the three source files exist, `-DANDROID_AARCH64`, no `-marm`, `-lGLESv2 -lEGL -lOpenSLES -lz -landroid -ldl -llog`, `-DHAVE_VULKAN` on; with `GLES=3` it switches to `-lGLESv3`. The makefile adds `-DGIT_VERSION=<short hash>` from `git rev-parse` (cosmetic; when run inside the Win11 repo it prints that repo's hash, not RetroArch's).
- **API 26 vs upstream's low API level**: the only API-dependent code is `ifaddrs`. RetroArch ships its own `getifaddrs` (`WANT_IFADDRS`), bionic adds the same from API 24, and griffin is one translation unit. Checked: with `WANT_IFADDRS` nothing includes the system `<ifaddrs.h>`, so there is no struct clash. The other `__ANDROID_API__` tests are for `< 13` / `< 14` (irrelevant).
- No native-name clash: `libretroarch-activity.so` is unique among the modules (they have `blackbox`, `mame4droid-jni`, `ppsspp_jni`, `javam3g`, ...). RetroArch uses `c++_static`, so it adds no `libc++_shared.so` (the `pickFirsts` in `:app` is not involved).
- Gradle file: brackets balance, properties and the DSL calls follow the `:ppsspp` / `:mame` patterns.

Known risks (first CI run decides)
1. **Old code, new clang.** The tag was built with NDK r22 (clang 11); this project has NDK 29 (clang 21). Clang 15/16+ turned some old-C mistakes into errors (implicit function declaration, int conversion, incompatible function pointer types). Master compiles with NDK 29, and the diff to the tag showed only `gnu++17` and 16 KB link flags, so it should work, but it is untested. First lever, no code change: `retroarchCFlags=-Wno-error=implicit-function-declaration -Wno-error=int-conversion -Wno-error=incompatible-function-pointer-types`. If that is not enough: a small patch to the clone's `Android.mk` (e.g. `-std=gnu++17` like master), or pin a master commit instead of the tag.
2. **Time and disk.** The first CI run now clones 330 MB and compiles the whole frontend (Vulkan / glslang part is the slowest); there is no cache or ccache yet (step 10), so every run repeats it. The 120-minute limit and the free-space step already exist; step 10 adds cache + ccache and an APK check.
3. **AGP + missing `Android.mk` at configuration time.** The path does not exist until the fetch task has run. `:ppsspp` does the same with its CMake path and works, so this is expected to be fine.
4. **16 KB pages / ABIs.** NDK 29 aligns to 16 KB by default; `:app` keeps `targetSdk 28` anyway. `:app` has no ABI filter, so on a 32-bit phone the APK has no `libretroarch-activity.so`: the step-8 launcher must check `Build.SUPPORTED_ABIS` for `arm64-v8a` (same as `:mame`).

Behaviour in the app right now: still none (no Java, manifest, launcher or hooks). The APK only gains `lib/arm64-v8a/libretroarch-activity.so`.

Next: step 6 — Java sources, resources and the real library manifest (resources prefixed `ra_`, manifest merge check). (Done, see below.)

## Step 6 — Java, resources and the library manifest (written and checked statically; NOT built here: the first CI run is the test)

Checked against a fresh clone of `v1.22.2` (commit `69a4f0ea…`), so the facts below are from the real tree, not from memory.

New / changed files
- `src/main/java/` — 10 upstream files, **in the project** (they are small, 164 KB, and two of them are edited): `MainMenuActivity`, `RetroActivityFuture`, `RetroActivityCommon`, `RetroActivityCamera`, `RetroActivityIntent`, `UserPreferences`, `ConfigFile`, `RetroDocumentsProvider` (package `com.retroarch.browser.*`), `PlayCoreManager` (upstream's play-core **stub**, `com.retroarch.playcore`) and `VfsImplementationSaf` (`com.libretro.common.vfs`, called by name from `libretro-common`'s C code).
- `src/main/res/` — launcher icons (`ra_ic_launcher`, `ra_ic_launcher_foreground`, adaptive icon XML), `ra_banner`, `ra_ic_launcher_background`, `ra_app_name`, `ra_document_provider_enabled`. Only names changed, the pictures are upstream's.
- `src/main/AndroidManifest.xml` — the real library manifest (was a placeholder).
- `tools/diff-upstream-java.sh` — compares the copied Java with the clone (see "After a version bump").
- `app/.../App.kt` — **required change in `:app`** (see "Own process"). `app/src/main/AndroidManifest.xml` — comment only. `build.gradle.kts`, `settings.gradle.kts`, `app/build.gradle.kts`, `gradle.properties` — comments only (no build logic changed: Java, resources and manifest are the module's default source set).

What was NOT copied, on purpose
- `RetroArchApplication` (upstream's `Application` class, an empty subclass): `:app` has `App`.
- `CoreSideloadActivity` (debug only, exported, loads a core from a path it is given). Nothing in the native code or the other Java refers to it (checked with grep).
- `phoenix/res/values*/bools.xml` (replaced by `ra_bools.xml`), `res64/` (banner of upstream's `aarch64` flavor only), Play Store manifests, `play-core-impl`, `module_template`, `phoenix-legacy`.

Changes to upstream files (all marked `WIN11` in the source, as GPL-3.0 section 5a asks)
| File | Change | Why |
|------|--------|-----|
| `RetroDocumentsProvider.java` | `R.string.app_name` -> `R.string.ra_app_name`, `R.mipmap.ic_launcher` -> `R.mipmap.ra_ic_launcher` (5 places) | resource prefix (step 1 table) |
| `UserPreferences.java` | `updateConfigFile()` no longer sets `bundle_assets_src_path`, `_dst_path`, `_dst_path_subdir`, `_extract_version_current`; it writes `bundle_assets_extract_enable = false` | **Found in the source:** on Android RetroArch's default is to unpack the `assets/` folder **of the APK** into its data folder (`menu_driver.c`, `DEFAULT_BUNDLE_ASSETS_EXTRACT_ENABLE true`). In Win11 that folder holds the files of PPSSPP (about 22 MB), Winlator, MAME, J2ME ... and RetroArch has none of its own, so it would copy other apps' files on first start. |
| everything else | byte-identical to upstream | `bash retroarch/tools/diff-upstream-java.sh` proves it |

Manifest decisions (the file has the same list in its header)
| Upstream | Here | Why |
|----------|------|-----|
| `<application>` attributes (`RetroArchApplication`, `allowBackup`, `requestLegacyExternalStorage`, `extractNativeLibs`, `isGame`, `allowAudioPlaybackCapture`, `icon`, `label`, `banner`), `versionCode`, `versionName`, `installLocation` | dropped | they belong to `:app`; icon / label / banner are set on the two activities instead |
| MAIN + LAUNCHER + LEANBACK_LAUNCHER + OUYA GAME filter on `MainMenuActivity` | removed | no second launcher icon; step 8 starts it |
| `exported="true"` on both activities | `exported="false"` | the `LIBRETRO` extra is the path of a `.so` that the native code `dlopen()`s; another app must not be able to send one. `:app` starts them with explicit Intents of the same uid, which still works |
| no process attribute | `android:process=":retroarch"` + `taskAffinity` on both | see "Own process" |
| `MainMenuActivity` without theme | `@android:style/Theme.DeviceDefault.NoActionBar` | upstream relied on the device default; here `:app`'s application theme would apply to a framework `PreferenceActivity` |
| `CoreSideloadActivity` | dropped | debug only |
| `RetroDocumentsProvider` enabled from API 19 | **kept, disabled** (`ra_document_provider_enabled = false`) | it shows `getFilesDir().getParent()` in the system file picker. In upstream that is RetroArch's data folder; in Win11 it is the data folder of the **whole app** (browser, Winlator, BlackBox, PPSSPP, MAME ... share one package), with read and create rights. To switch it on: set the bool to `true`. Authority `${applicationId}.documents` is unique (checked) |

Own process `:retroarch` (needs the `App.kt` change)
- Upstream ends RetroArch with `System.exit(0)` (`RetroActivityFuture.onNewIntent` when another game is opened, `QUITFOCUS`) and native `exit(0)` (`platform_unix.c`). In one process with the launcher that would close the whole Win11 app. Same problem and same answer as `:mame` (`killProcess`) and `:j2me` (`:midlet`): both activities run in `:retroarch`.
- `App.kt` runs in every process of the app and attaches the BlackBox engine (and J2ME) to anything that is not `:mame` / `:midlet`. Without the change it would have treated `:retroarch` as a cloned-app process and hooked the system services of the emulator. Now `attachBaseContext` and `onCreate` return early for `:retroarch`, like for `:mame`.
- Both activities are in the same process, so upstream's `RetroActivityFuture.isRunning` static still works for `MainMenuActivity`.
- Consequence for step 8: opening a different game while RetroArch runs ends the `:retroarch` process (upstream behaviour: "exit cleanly and let launcher restart us"). That is harmless for Win11 now, but the launcher must start the new game after the old process is gone (or the person taps again). Step 8 will deal with it.

Merge review (static, by script against every other module's manifest and resources)
| Check | Result |
|-------|--------|
| Permissions of `:retroarch` (`READ/WRITE_EXTERNAL_STORAGE`, `INTERNET`, `VIBRATE`) | all four already declared by `:app` (and several modules): nothing new for the person to grant |
| `uses-feature` | `glEsVersion 0x00020000` (also in `:ppsspp`); `type.pc`, `touchscreen`, `leanback`, `gamepad` all `required="false"` |
| Class names of the 3 components | unique in the whole project |
| Provider authority `${applicationId}.documents` | unique (`:j2me` has `.documentProvider`, BlackBox `.blackbox.*`) |
| Resource names (6) vs the 11 other modules with `res/` | **0 clashes**, all start with `ra_`; no `R.*` in Java other than the two renamed ones |
| XML | all manifests and resource files parse; `javac` on the 10 Java files reports only the missing Android SDK symbols (no syntax errors) |

Behaviour in the app after step 6: no way to open RetroArch yet (the hooks came in step 8, see below). The APK gains the two activities, the disabled provider, 6 small resources and `libretroarch-activity.so`.

After a version bump: `./gradlew :retroarch:fetchRetroarchUpstream`, then `bash retroarch/tools/diff-upstream-java.sh`. It prints `ok (same)` / `ok (changed)` per copied file, flags a copied file that differs more than expected, and lists new upstream Java files. Re-merge by hand, re-check the manifest against upstream's `AndroidManifest.xml`, and compare `Android.mk` flags (step 5).

Not verified: a real Gradle sync or build, that `javac` compiles against the Android SDK (only syntax was checked), and anything on a device. Likely first-build surprises are small: a deprecated-API warning (`PreferenceActivity`, `android.hardware.Camera`, `Build.CPU_ABI` are deprecated but present in compileSdk 37) is not an error here (`lint` does not abort).

Next (was): step 8 (done below; step 7 needs nothing to build: cores come from the Online Updater). Step 8 can start `MainMenuActivity` for the plain app, or `RetroActivityFuture` with `ROM` + `LIBRETRO` + `CONFIGFILE` + `DATADIR` + `APK` + `SDCARD` + `EXTERNAL` extras through the public `MainMenuActivity.startRetroActivity(...)` helper.

## Step 8 — hooks in `:app` (written and checked statically; NOT compiled here: no Kotlin compiler or Gradle in this environment)

New / changed files
- `app/.../RetroArchLauncher.kt` (new) — `isRetroarchSupported(ctx)`, `MainActivity.openRetroarch()`, `isRetroarchFile(name)`, `MainActivity.openRetroarchFile(file)`.
- `StartApps.kt` — Start menu entry **RetroArch** (section `retroarch`, game-pad vector icon, teal `#2EC4B6`). `Win11Shell.kt` — Home screen icon (`VectorIconView.RETROARCH`). `MainActivity.kt` — the Start menu section and the deep link **`rizwans2://retroarch`** (also in the KDoc list). `FileManagerUi.kt` — console ROM files open in RetroArch (after PPSSPP, before Windows programs). `FileExplorerUi.kt` — file colour for those extensions.
- `retroarch/src/main/java/.../MainMenuActivity.java` — **third edited upstream file** (marked `WIN11`, see below).
- `retroarch/tools/diff-upstream-java.sh` — now expects 3 changed files. Comments only: `build.gradle.kts`, `settings.gradle.kts`, `app/build.gradle.kts`, `gradle.properties`, `app/src/main/AndroidManifest.xml`.

How each hook behaves
| Hook | Behaviour |
|------|-----------|
| Start menu / Home icon / `rizwans2://retroarch` | start `MainMenuActivity` (explicit Intent, `NEW_TASK`): upstream's permission check + config update, then RetroArch's own menu. If RetroArch already runs, its game screen comes back to the front. First use: *Online Updater -> Core Downloader* (cores are not bundled) |
| Shown only when | `isRetroarchSupported(ctx)`: phone reports `arm64-v8a` **and** `libretroarch-activity.so` is in the app's lib folder (so also hidden for a build with `-PretroarchNative=false`). Same idea as MAME; on other phones the entry and icon are not shown and the deep link shows a short message |
| File Manager, console ROM | the path goes as the extra `ROM`, and since step 7 the core as the extra `LIBRETRO`, to `MainMenuActivity`, which starts `RetroActivityFuture` with RetroArch's usual extras. *(Step 8 first passed no core and assumed RetroArch would show a core list; reading upstream in step 7 showed that is wrong, see "Step 7".)* |
| File Manager, no downloaded core for this file | RetroArch's menu opens with a hint ("Online Updater -> Core Downloader, then Update Core Info Files"), because the game could not start anyway (step 7: `RetroarchCores.pick` found no core) |
| File Manager, RetroArch already running | same game: it just comes to the front. Another game: upstream's `RetroActivityFuture.onNewIntent` ends the `:retroarch` process (`System.exit`, harmless since step 6); the launcher polls (150 ms, up to 3 s) and starts the new game once the process is gone |

Extensions (`isRetroarchFile`): `nes fds sfc smc gb gbc gba n64 z64 v64 nds gen smd 32x sms gg pce sgx a26 a78 lnx ngp`. Left out on purpose: `.bin .cue .iso .chd .cso .elf .pbp` (disc images / ambiguous; `.iso .cso .chd .pbp .elf` already open in PPSSPP), `.zip .7z` (almost every archive on a phone is not a ROM set), `.md` (Markdown; Mega Drive uses `.gen` / `.smd` here), `.vb` (Visual Basic), `.ws .wsc` (script files), `.ngc .col .int`. They still reach RetroArch through *Open with* or RetroArch's own file browser.

The one change in upstream Java (`MainMenuActivity.finalStartup()`): reads the extras `ROM` and `LIBRETRO` from the Intent that started it. Without `ROM` the behaviour is byte-for-byte the old one (running -> reorder to front; else plain start). With `ROM` it always goes through `startRetroActivity(...)` so `RetroActivityFuture.onNewIntent` can compare the game. Why not call `MainMenuActivity.startRetroActivity` from `:app`: it is a static method that uses `PACKAGE_NAME`, which is set in `:retroarch`'s process only (it would be `null` in the launcher's process). `MainMenuActivity` is not exported, so only Win11 can send these extras.

Checked here (static only)
| Check | Result |
|-------|--------|
| Brackets / parentheses of the 6 edited or new Kotlin files | balanced (no Kotlin compiler available) |
| Hand review of `RetroArchLauncher.kt` types: local `fun intent()` passed as `::intent` to `() -> Intent`, `if / else try` as a statement inside the `Runnable` lambda, private `Context` extensions called from the `MainActivity` extensions | compile-correct by reading |
| Hook sites found by `grep` for every place that mentions PPSSPP / MAME (Start menu, Home, two spots in `MainActivity`, File Manager, file colours): all covered; `isPpssppFile` has one caller | yes |
| Extension list vs other handlers in `openFile` (video, txt, pdf, zip, image, J2ME, PPSSPP, Windows programs) and vs file colours | no overlap; the ambiguous ones are excluded |
| Icon path | rendered once (Chromium) and looked at: game pad with hollow d-pad and two buttons |
| `diff-upstream-java.sh` | "only the expected Win11 changes" (3 changed, 7 identical) |

Not verified: that the Kotlin compiles (step 7 later compiled `RetroArchLauncher.kt` against stubs of the Android classes and `RetroArchCores.kt` for real, not the other 5 files), the restart after switching games, and everything on a device. *Correction made in step 7:* this paragraph first said RetroArch "should" show a core list for a `ROM` without a core. It does not: with no `LIBRETRO` extra upstream's `MainMenuActivity` passes the core *folder* (`<dataDir>/cores/`) as the core, the core fails to load, and RetroArch shows its plain menu without the game. Test on a device (64-bit ARM): Start menu -> **RetroArch** (also the Home icon and `rizwans2://retroarch`) -> Online Updater -> Core Downloader -> download e.g. a NES core -> File Manager -> tap a `.nes` file -> choose the core -> the game runs -> back to Win11 -> tap another ROM.

Next (was): step 9 and step 10 (see the end of this file for step 7, which was finished after step 8 because it changes the File Manager hook).

## Step 7 — cores and data files: online downloader only (done; the core picker is compiled and tested, the rest is NOT run on a device)

Your decision: **nothing is bundled**, RetroArch's own *Online Updater* downloads cores, core info files and assets. This step checks that this really works in `v1.22.2` as built by this module, and fixes one problem the check found.

**Checked in the real `v1.22.2` tree** (clone made with `fetch-upstream.sh`, not in the zip)
| Question | Result |
|----------|--------|
| Is the Online Updater compiled into the Android build? | yes: `Android.mk` defines `HAVE_ONLINE_UPDATER`, `HAVE_UPDATE_CORES`, `HAVE_UPDATE_ASSETS`, `HAVE_NETWORKING`, `HAVE_BUILTINMBEDTLS` + `HAVE_SSL` (https works without the system libraries) |
| Where do cores come from? | `config.def.h`: for `ANDROID_AARCH64` the buildbot URL is `http://buildbot.libretro.com/nightly/android/latest/arm64-v8a/` (plain `http`). RetroArch uses its own native sockets for it. `:app` also has `usesCleartextTraffic="true"`. Not tested on a device |
| Menu names (v1.22.2 strings) | *Online Updater* -> **Core Downloader**, **Update Core Info Files**, **Update Assets** |
| Where are things saved? | `DATADIR` extra = the app's data folder, so `<dataDir>/cores`, `info`, `assets`, `shaders`, `overlays`, `autoconfig`, `filters`, `database` (`platform_unix.c`). a `grep` for `dataDir` / parent-folder use and for those folder names in the Kotlin / Java sources found **no other module using them** (I did not trace the storage paths of every module, and native code was not searched) |
| Can a downloaded `.so` be loaded? | yes while `:app` has `targetSdk = 28`. **Since part 8 of the Mika plan `:app` has 37 by default, so expect no** (`-PappTargetSdk=28` goes back). From targetSdk 29 Android blocks executing files from the data folder |
| Does the clone-and-build leave `assets/` out safely? | yes: upstream's own CI builds without it; step 6 also switched off the extraction of the Win11 `assets/` folder |
| Menu without assets | the default menu driver is MaterialUI (first in the driver list); its font and icons are read from the assets folder, and the font driver list contains a built-in bitmap renderer (I did not check that it is used as the fallback). **Not run**: the first start may look plain or lack icons until *Update Assets* was done |
| The backup / restore feature (Part 30) | works on clone data only, not on this module's data folder: nothing to change |

**Problem found: a game with no core does not start.** Step 8 passed only `ROM` and assumed RetroArch would then show a core list. Upstream does not: `MainMenuActivity` puts the saved `libretro_path` (by default the *folder* `<dataDir>/cores/`) into the `LIBRETRO` extra, the native code runs `-L <folder> <game>`, the core cannot load, and RetroArch shows its normal menu without the game. Upstream's own flow always gives game + core together.

**What changed**
- `app/src/main/kotlin/com/srizwan/win11/RetroArchCores.kt` (new, `java.io` only): `RetroarchCores.pick(ext, coresDir, infoDir)` returns the downloaded core for a file extension:
  1. the first downloaded core of a built-in preference list for that extension (works before the info files are downloaded): `nes/fds` fceumm, nestopia, mesen; `sfc/smc` snes9x, bsnes; `gb/gbc` gambatte, mgba, sameboy; `gba` mgba, gpsp, vba_next; `n64/z64/v64` mupen64plus_next (gles3, gles2), parallel_n64; `nds` melonds, desmume, melondsds; `gen/smd` genesis_plus_gx, picodrive; `32x` picodrive; `sms/gg` genesis_plus_gx, smsplus, gearsystem; `pce` mednafen_pce_fast, mednafen_pce; `sgx` mednafen_supergrafx; `a26` stella; `a78` prosystem; `lnx` handy, mednafen_lynx; `ngp` mednafen_ngp, race;
  2. otherwise the first downloaded core (by file name) whose `<dataDir>/info/<name>_libretro.info` lists the extension in `supported_extensions = "a|b|c"` (this is why *Update Core Info Files* is part of the first-use steps);
  3. otherwise `null`.
- `RetroArchLauncher.kt`: `openRetroarchFile` now sends `ROM` + `LIBRETRO` (the picked core's full path). No fitting core: RetroArch's menu opens and a toast names the next step (different text for "no cores at all" and "no core for .ext"). Because the core is the same every time for the same extension, upstream's "same game -> to front, other game -> restart" comparison in `RetroActivityFuture.onNewIntent` keeps working.
- Naming used (from `core_info.c`): core file `fceumm_libretro_android.so` -> name `fceumm` -> info file `fceumm_libretro.info`.
- Not added on purpose: a per-extension core setting in the Win11 UI (the preference list is a start; if you want a different core for an extension, tell me which).

**Checked here**
| Check | Result |
|-------|--------|
| `RetroArchCores.kt` compiled with the real Kotlin compiler **2.2.10** (same as the project) | no errors, no warnings |
| 22 checks run on temporary folders (missing / empty folder, file-name to name, `.SO`, non-core files, preferred order, upper-case extension, info-file fallback, unknown extension, n64 variants, 5 info-file parsing cases, preferred core beats an alphabetically earlier one) | all pass |
| `RetroArchLauncher.kt` + `RetroArchCores.kt` compiled together against small stubs of the Android classes they use | no errors, no warnings |
| Other 5 Kotlin files of step 8, the real Android API, Gradle | **not** compiled here |

**First use on a phone** (64-bit ARM): Start menu -> RetroArch -> *Online Updater* -> **Update Core Info Files** -> **Core Downloader** (pick e.g. FCEUmm for NES, Snes9x, Gambatte, mGBA, Genesis Plus GX) -> optionally **Update Assets** (menu icons) -> back to Win11 -> File Manager -> tap a ROM. Some cores need BIOS / firmware files (for example Nintendo DS, PC Engine CD): copy them into RetroArch's `system` folder (*Settings -> Directory -> System/BIOS* shows where it is).

Not verified: anything on a device (download from the buildbot, loading a downloaded core, the first-start look without assets, core names on the buildbot being exactly the ones in the preference list; a wrong guess only means the info-file fallback or the menu hint is used).

Next: step 10 (CI: cache, fetch step, ccache, APK check, in both workflows). Step 9 is written below.

## Step 9 — licence files and the GPL-3.0 compatibility note (documents only; no code, Gradle or CI change)

New / changed files
- `NOTICE-RetroArch.md` (new, project root, same style as `NOTICE-PPSSPP.md` / `NOTICE-MAME4droid.md`): where the files come from, licence, what to keep when distributing, the list of Win11 changes (GPL-3.0 section 5a) and the compatibility note with a table per part of the app.
- `LICENSE-RetroArch` (new, project root): short header + the standard FSF text of GPL version 3.
- Comments only: `settings.gradle.kts` (step state; the MAME line now says GPL-2.0-or-later, see below), `retroarch/build.gradle.kts`, `app/build.gradle.kts`, `README.md` (RetroArch section), this file, `docs/CHANGES-step8-retroarch-step9.md`.

What was checked in this step
| Check | Result |
|-------|--------|
| License headers of the MAME4droid Java files in `mame/src` | 51 files have a GPL header, all say "version 2 ... or (at your option) any later version", with a special exception for LGPL code. So MAME4droid's frontend is GPL-2.0-**or-later**. (`settings.gradle.kts` said "GPL-2.0", which was upstream's licence *file*, not its headers; comment corrected. `NOTICE-MAME4droid.md` already said "or later".) |
| License headers of PPSSPP's 19 Java files / RetroArch's 10 Java files | none carry a header: the licence rests on upstream's own statements, not on these files |
| Other parts | Winlator LGPL-2.1, J2ME Loader and BlackBox Apache-2.0: taken from the existing notices |

Result: **no GPL-2.0-only part was found** among the parts that can be checked here, so there is no known reason the combined APK cannot go out under GPL-3.0 terms. This is a note, not legal advice.

Open items for you before publishing (details in `NOTICE-RetroArch.md`)
1. **The MAME core binary** (`libMAME4droid.so`, downloaded at build time): not checked. Look for MAME source files that say "version 2" without "or later".
2. **NewPipeExtractor** (`:youtube`, `v0.26.5`): GPL-3.0 as far as I know, not checked, and the project has **no notice file** for it. Worth adding one.
3. **RetroArch's own file headers**: not re-checked in this step (no network). Not blocking.

Also noted: the app has no screen that lists the licences of all included projects (RetroArch's and PPSSPP's own screens are kept). Not changed.

Not verified: anything legal; the build (step 10 is the CI step).

Next: step 10 (written below).

## Step 10 — CI in both workflows (`UltimateBuild.yml` and `UltimateBuild_NoWinlator.yml`; YAML written and checked statically, NOT run: the first GitHub run is the test)

The same edits are in both files (the NoWinlator one only differs in the Winlator removal, which does not touch RetroArch). Timeout stays **120 minutes**; no input, secret or other step was changed.

| What | Where in the workflow | Details |
|------|----------------------|---------|
| Header comment | top of the file | a RetroArch paragraph next to the PPSSPP / MAME ones |
| Free disk space | step "Free disk space" | one line added: `docker image prune --all --force` (the preinstalled Docker images are not used). It still prints `df` before and after |
| Cache RetroArch source | after "Fetch PPSSPP source" (so after the package rename) | `actions/cache@v4`, path `retroarch/upstream`, key `retroarch-upstream-` + hash of `UPSTREAM_VERSION`, `UPSTREAM_COMMIT` and `tools/fetch-upstream.sh` (changing any of the three refreshes the cache) |
| Fetch RetroArch source | next step | `bash retroarch/tools/fetch-upstream.sh` (20 min limit). Cache hit: "already present", instant. Cache miss: clone of the tag + the **commit check** (wrong commit = the run stops here, early). Prints the tag, the commit, the folder size and `df` |
| ccache | step "Set up ccache for PPSSPP and RetroArch" | adds `ORG_GRADLE_PROJECT_retroarchCcache=true` (-> `NDK_CCACHE=ccache` in `:retroarch`'s ndk-build arguments, step 5); `CCACHE_MAXSIZE` 1500M -> **3000M** (one cache folder for both builds) |
| ccache cache key | step "Cache ccache" | `ccache-native-<os>-<hash of ppsspp version + retroarch commit>-<run id>`; the old `ccache-ppsspp-<os>-` prefix stays as the last restore key, so the existing PPSSPP cache is still used the first time |
| APK check | in "Locate Unsigned APK", after the MAME check | **fails** the run if `lib/arm64-v8a/libretroarch-activity.so` is missing or smaller than 1 MB; reads the merged release manifest (found with `find app/build/intermediates -path "*merged_manifests/release*"`) and **fails** if `MainMenuActivity` or `RetroActivityFuture` is missing or `android:process=":retroarch"` is not there. If the merged manifest file cannot be found, only a warning (the path is an AGP detail) |

Differences from the plan, and why
- **No "RetroArch assets" check.** The plan said the APK check would look for the native library or RetroArch assets. Since the step 7 decision (online downloader only, nothing bundled; step 6 even switches off RetroArch's unpacking of the APK `assets/` folder) there are no RetroArch assets and no cores in the APK, so there is nothing of that kind to check. The manifest check replaces it: it proves the manifest merge worked, which was the other big risk.
- **ccache is shared** with PPSSPP (one folder, one cache entry, bigger limit) instead of a second cache.
- A **commented-out line** in the ccache setup step holds `ORG_GRADLE_PROJECT_retroarchCFlags=-Wno-error=implicit-function-declaration ...`. It is **off**: nothing is silenced unless a real build needs it (step 5 decision). If the first run stops on old C code that NDK 29's clang rejects, remove the `#` and run again.
- The escape hatch `-PretroarchNative=false` is **not** wired into the workflows (no workflow input added). If the native build blocks every APK build, add `echo "ORG_GRADLE_PROJECT_retroarchNative=false" >> "$GITHUB_ENV"` to the ccache setup step (then also remove the APK check, it would fail).

Checked here (static only)
| Check | Result |
|-------|--------|
| Both files parse as YAML; 25 / 26 steps; `timeout-minutes` still 120 | yes |
| `bash -n` on every `run:` block of both files | no syntax errors |
| Order: "Validate & Apply Package Rename" before "Cache RetroArch source"; "Fetch RetroArch source" right after "Fetch PPSSPP source" | yes (checked by script) |
| The library test (`awk`) against fake `unzip -l` lists: 1.2 MB library, 500-byte library, wrong file name | PASS / FAIL / FAIL as intended |
| The manifest test (`find` + `grep`) against a fake merged manifest; the strings are the ones in `retroarch/src/main/AndroidManifest.xml` (`com.retroarch.browser.mainmenu.MainMenuActivity`, `...retroactivity.RetroActivityFuture`, `android:process=":retroarch"`) | pass |
| Each edit matched exactly one place in each file (the script asserts it) | yes |

Not verified: that GitHub runs any of this; that the real merged manifest is at that path (a miss only warns); that the cache is big or fast enough (the clone is about 330 MB, the cache quota is shared with PPSSPP's cache and the ccache); free disk space on the runner (the first RetroArch build adds a 330 MB clone plus the compile output; `df` is printed after the fetch so the log will show it); and the build itself (step 5 risks: NDK 29 vs the tag's NDK r22, long first compile with a cold ccache).

Next: step 11 (docs) and step 12 (final static checks and the flat zip). Most of step 11 is already in the README files written along the way; it will collect what is still missing.

## Step 11 — docs (documents and comments only; no code, Gradle logic, manifest or CI change)

What was added / changed
- **Overview** at the top of this file: what it is, where it opens from, first use, a file map, switches, CI, version bump, a "if the first CI run fails" table, and one list of everything that is not verified.
- `docs/CHANGES-step8-retroarch.md` (new): the consolidated change list of steps 1 to 11 (the planned "CHANGES" file); the per-step files `-step1` ... `-step10` stay.
- `README.md` (root): RetroArch section now says steps 1 to 11, has a short step-11 bullet and the note that "All apps" numbers shift (only on phones that show the entry); the MAME paragraph says GPL-2.0-or-later (the step 9 correction, one place was still "GPL-2.0").
- Comments: `settings.gradle.kts`, `app/build.gradle.kts`, `gradle.properties` (now lists `retroarchCcache` and says steps 5 to 10).

Checked that the deep-link lists already name RetroArch (nothing to add): the KDoc of `MainActivity.handleDeepLink` (`... | j2me | ppsspp | mame | retroarch | chooser`), the `when` branch `"retroarch" -> openRetroarch()`, the manifest comment in `app/src/main/AndroidManifest.xml`, the header of `RetroArchLauncher.kt`.

Not verified: nothing new beyond the list in the Overview.

Next: step 12 — final static checks on the whole project (XML / YAML / bracket checks, resource names, hooks, `diff-upstream-java.sh`, file list of the zip) and the final flat zip.

## Step 12 — final static checks and the final flat zip (nothing built: the first GitHub run is the test)

Compared with the zip you uploaded (`RizwanS2-youtube-step82.zip`, which already had steps 1 to 8): **nothing is missing**; new files are `NOTICE-RetroArch.md`, `LICENSE-RetroArch`, `docs/CHANGES-step8-retroarch.md`, `-step9.md`, `-step10.md`; changed files are the two workflows, `README.md`, `retroarch/README.md`, `gradle.properties`, `settings.gradle.kts`, `app/build.gradle.kts`, `retroarch/build.gradle.kts`. A diff of non-comment lines shows **no code change in the three `.kts` files** since step 8 (comments only), and no Kotlin / Java / manifest change at all in steps 9 to 12.

| Check | Result |
|-------|--------|
| `bash -n` on the 4 shell scripts (`retroarch/tools/*.sh`, PPSSPP and MAME fetch scripts) | no errors |
| XML: the 5 files of `:retroarch` (manifest, `ra_bools`, `ra_colors`, `ra_strings`, adaptive icon) + the app manifest | all parse |
| YAML: the 5 workflow files | all parse (the two build workflows were also checked step by step in step 10) |
| Wiring | `include(":retroarch")` once, `project(":retroarch")` once in `:app`; keep rules in `consumer-rules.pro` and `app/proguard-rules.pro` |
| Resources | 6 `ra_` names, **0 clashes** with the other modules (script over every module's `res/`) |
| Hooks | Start menu (`StartApps.kt`), Home icon (`Win11Shell.kt`), deep link (`MainActivity.kt`: KDoc list and the `when` branch), File Manager (`FileManagerUi.kt`, `FileExplorerUi.kt`), no engine in the `:retroarch` process (`App.kt`): all present |
| Extensions | the 22 in `RetroArchLauncher.kt` are exactly the 22 in this file's Overview; all appear in `FileExplorerUi.kt`; none of the excluded ambiguous ones is in the list; no overlap with the PPSSPP / J2ME launcher literals |
| Kotlin brackets | the 8 involved files (6 edited + 2 new) balanced, and so are all 188 Kotlin files of the project, checked with a small lexer that understands strings, `${}` templates, raw strings and comments. (A first, cruder check wrongly flagged `Win11Shell.kt` and `MainActivity.kt`; the cause was the check, not the files, which did not change) |
| Java | 10 files in the module, exactly 3 marked `WIN11`; the three manifest components have their class files |
| Pins | `UPSTREAM_VERSION` one line `v1.22.2`; `UPSTREAM_COMMIT` one 40-character hash; `.gitignore` has `retroarch/upstream/`; `.gitattributes` has `*.sh text eol=lf` |
| Consistency | the `Android.mk` path is the same in `build.gradle.kts` and the fetch script; the strings the workflows look for are the ones in the library manifest; both workflows have the same RetroArch text |
| Zip | flat (files at the root), **no** `retroarch/upstream/`, no build folders |

**Not re-run in this step:** `bash retroarch/tools/diff-upstream-java.sh` (needs the 330 MB clone, and this environment has no network; it was run in steps 6 and 8, "only the expected Win11 changes", 3 changed / 7 identical, and no Java file was touched since), `javac` and the Kotlin compiler (not installed here; the compiles of step 7 stay the last real ones), and of course Gradle, the NDK and CI.

**Result.** All 12 steps are in the zip. The plan's open items are unchanged and listed in the Overview: the three licence items (MAME core binary, NewPipeExtractor notice, RetroArch file headers), the first CI run (NDK 29 vs the tag's NDK r22, disk, time, cache), and the on-device checks (core download, loading a core, switching games, the menu before *Update Assets*).

Do this first: push the zip to GitHub and start `UltimateBuild.yml` (or the NoWinlator one). If it stops, the table "If the first CI run fails" in the Overview says what to try first.

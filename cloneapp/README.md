# Clone App — `:cloneapp` module (prebuilt AAR, package `com.pengyou.cloneapp`)

Request: add the Clone App as a module (AAR) to RizwanS2, keep all details, update, full flat zip. Written permission to use the Clone App was stated by the project owner.
Status: **step 1 (module wired in) and step 3 (engine start-up + Settings entry + process rename) done; step 2 (native libraries) done too: `lib.zip` received, 14 libraries in the AAR as `jni/arm64-v8a/`. Not built or run yet** (the work was done without Android SDK / network access, so only static checks were possible). The libraries are arm64-v8a only: on a 32-bit phone the engine stays off and Settings > Clone App says so.

## What is in the module
| File | What |
|---|---|
| `cloneapp.aar` | The Clone App as a library: `classes.jar` (28,124 classes), `res/` (all 1,151 XML files, drawables, layouts, 6,177 pinned resource ids), `assets/` (all, incl. `microG.pkg`, `cweb.pkg`, `iads`, `template`), merged `AndroidManifest.xml`, `R.txt`, `proguard.txt` (consumer rules) |
| `build.gradle.kts` | No sources. Hands the AAR to `:app` (`default` configuration) and declares the libraries that were taken out of the AAR as normal Gradle dependencies |
| `STRIPPED-CLASSES.txt` | Every class that is not in the AAR, with the reason, plus the dropped `public.xml` entries |
| `tools/patch-processes.py` | Renames the engine's processes `:hs`/`:pN` -> `:chs`/`:cpN` inside the AAR (manifest + two string constants), idempotent. Already applied to the shipped AAR |
| `tools/add-jni.py` | Step 2 in one command (already applied to the shipped AAR; skips the libraries Gradle provides): puts the original APK's `lib/<abi>/*.so` into the AAR as `jni/<abi>/*.so` |
| `tools/build-aar.py` | Rebuilds the AAR from the decoded APK + the dex2jar jars (`python3 cloneapp/tools/build-aar.py --clone <dir> --jars classes*.jar --project . --out cloneapp/cloneapp.aar`), Python 3 only |

Wired in: `settings.gradle.kts` (`include(":cloneapp")`, always built, like `:tui`), `app/build.gradle.kts` (`implementation(project(":cloneapp"))`), `.gitattributes` (`*.aar binary`), `NOTICE-CloneApp.md`, root `README.md`, `docs/CHANGES-cloneapp-aar.md`.

## Source files that were received
`Clone_App_src.zip` (decoded APK: `AndroidManifest.xml`, `res/`, `assets/`; no `lib/`, no `smali`, no `apktool.yml`) and `classes.jar` … `classes5.jar` (dex2jar output of the five `classes*.dex`, R8-obfuscated: most names are `a`, `ab3`, ...).

## What was changed (nothing else was touched)
1. **Libraries that Gradle already provides were taken out of `classes.jar` (817 classes)** — a second copy would stop the build with "Duplicate class": `androidx.*`, `kotlin*`, `org.jetbrains.*`, Material, protobuf, gson, ffmpeg-kit (`com.arthenica`), `org.chromium.support_lib_boundary`. They are declared in `cloneapp/build.gradle.kts` instead (versions of the other modules).
2. **76 hidden-API AIDL stub classes (`android.accounts.*`, `android.app.*`, `android.content.*`, `android.os.*` ...) were taken out** — `:Bcore` (BlackBox) has the same classes (checked class by class against `Bcore/src/main`).
3. **`classes5.jar` was left out** (59 classes). It does not belong to the Clone App; it came from a patching tool: `bin.mt.signature.KillerApplication` (fakes the app signature), a packer stub (`Xpk8a`, `īi.ïi.pk`), a promo dialog (`com.zx.*`) and an unused copy of `org.lsposed.hiddenapibypass`. Two spots in the Clone App's own classes pointed at it and were patched (class files, constant-pool level, same method sizes):
   - `com.bly.chaosapp.application.BLYApplication`: super class `KillerApplication` → `android.app.Application`.
   - `com.pengyou.cloneapp.UserActivity.onResume`: the call `com.zx.LB.ll(this)` (the promo dialog) replaced by four `nop`.
4. **Manifest** (`AndroidManifest.xml` of the AAR, 454 components, 245 permissions kept):
   - `<application>` attributes removed (`name` = BLYApplication, `icon`, `roundIcon`, `label`, `theme`, `allowBackup`, `debuggable`, `largeHeap`, `usesCleartextTraffic`, `requestLegacyExternalStorage`, `hardwareAccelerated`, `resizeableActivity`, `extractNativeLibs`, `appComponentFactory`, `allowNativeHeapPointerTagging`): they would clash with `:app`'s own `<application>`. `:app` decides these now.
   - `compileSdkVersion` / `platformBuildVersion*` attributes (apktool leftovers) removed.
   - Provider authorities, `android:permission` and the custom permission `...DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION` that had `com.pengyou.cloneapp.` baked in now use `${applicationId}.` (65 places), so they cannot clash with an installed original Clone App and the AndroidX Startup / WorkManager / Firebase providers merge with `:app`'s own.
   - The 5 launcher intent filters (`MAIN` + `LAUNCHER`) were removed, so the Clone App adds no second icon to the phone. It must be opened by an explicit intent from `:app`.
5. **`res/values/public.xml`** is kept: the dex code uses the original resource ids as numbers, and `public.xml` pins them (aapt2 keeps pinned ids in the final app). 191 entries whose resource does not exist were dropped (listed in `STRIPPED-CLASSES.txt`). `R.txt` was generated from the remaining 6,177 ids.
6. Added: `proguard.txt` (keep rules for `com.bly.**`, `com.pengyou.cloneapp.**`, `top.canyie.pine.**`, JNI methods; `-dontwarn` for the ad SDKs) and `aar-metadata.properties` (`minCompileSdk=36`).

## Step 3 — what was done (engine start-up, process names, Settings entry)
- **Process clash fixed.** The Clone App and BlackBox (`:Bcore`) both declared the stub processes `:p0` .. `:p49`; in one merged manifest a process could be given to the wrong engine. The Clone App now uses `:chs` and `:cp0` .. `:cp49` (manifest: 20 + 250 attributes; `BLYApplication` and `cn1` compare process names with those strings: patched, the number is parsed with `substring(prefix.length())`, so the longer prefix is safe). BlackBox keeps `:black` / `:p0` .. `:p49`. Tool: `tools/patch-processes.py`.
- **Engine start-up.** `app/.../CloneAppEngine.kt` creates one `BLYApplication` as a plain ContextWrapper and calls its `attachBaseContext` / `onCreate` from `App.attachBaseContext` / `App.onCreate`. In `:chs` / `:cp*` only this engine runs (no BlackBox, no J2ME); in the launcher process it runs after BlackBox (the Clone App's "manager" role: screens and databases; app hooking happens in the `:cp*` processes).
- **No native libraries yet = engine off, no crash.** `CloneAppEngine.nativeReady()` tries `System.loadLibrary("chaos")`; if it fails nothing of the engine is started.
- **Entry: Settings only.** Start menu user menu (the "Settings" menu, `Win11Shell.showUserMenu`) -> **Clone App** -> `CloneAppEngine.open()` -> explicit intent to `com.pengyou.cloneapp.SplashActivity` (its former launcher activity; falls back to `MainActivity`). No Start menu entry, no Home icon, no deep link (on purpose).
- Still open: step 2 (libraries), `NoSuchMethodError` risk of the obfuscated androidx copies, the 15 manifest classes that are not in the jars, and a real build + run on a phone. Test list: open Settings > Clone App clone one app, check `adb shell ps | grep -E ':(chs|cp[0-9]+)'` (Clone App) and `:p[0-9]+` (BlackBox) never mix.

## Things to know (before relying on it)
- **Native libraries (step 2, done).** `lib.zip` had 27 libraries, arm64-v8a only. 14 are in the AAR (`jni/arm64-v8a/`): `libchaos.so` (engine), `libabc.so` (Pine, loaded by `PineConfig` as "abc"), `libnms.so`, `libpygame.so`, the ad / analytics SDK libraries (AppLovin, Pangle `libpglarmor` / `libbuffer_pgl` / `libfile_lock_pgl` / `libtt_ugen_layout`, Unity `libunitycoherencenative`, `libapminsight*`), `libglide-webp.so`, `libdatastore_shared_counter.so`. 13 were **left out on purpose** because Gradle already brings them (a second copy stops the build with "2 files found with path ..."): ffmpeg-kit (`libffmpegkit*`, `libavcodec/avdevice/avfilter/avformat/avutil`, `libswresample/swscale`, from `io.github.nikita36078:ffmpeg-kit` of :j2me), `libmmkv.so` (:seal), `libc++_shared.so`, CameraX (`libimage_processing_util_jni.so`, `libsurface_util_jni.so`). `app/build.gradle.kts` also has `pickFirsts` for the four non-C++ ones as a safety net. No armeabi-v7a / x86 libraries were received: 32-bit phones cannot run the engine.
- **(Done in step 3, see above.) The engine start-up was not done in step 1.** `BLYApplication.attachBaseContext / onCreate` initialise the engine (`CRuntime`, multi-process `:hs` / `:p*` handling, ...). `:app` keeps its own `AppBase : MikaApp`; the same initialisation has to be called from it. Not done here, so nothing in `:app` calls the Clone App yet (no Start menu entry, no Home icon, no deep link).
- **Obfuscated androidx copies were replaced by the real libraries.** The original APK was shrunk with R8 and its bundled `androidx.*` has renamed members; the Clone App code that calls those renamed members (not only the view classes) can fail at run time with `NoSuchMethodError`. The clean fix is to relocate the bundled copies instead of dropping them; not done.
- 15 classes named in the manifest are not in the jars (`CacheCleanActivity`, `ResourceDownloadActivity`, `hide.Splash`…`Splash4`, `HideConfigActivity`, `DownloadGuideActivity`, `InappBillingServiceStub`, the `chaos.share.*` aliases). The screens that use them will not open.
- Permissions: the merged manifest adds 245 `uses-permission` entries to the app (incl. `INSTALL_PACKAGES`, `DELETE_PACKAGES`, `QUERY_ALL_PACKAGES`, `PACKAGE_USAGE_STATS`, location, contacts, calendar, phone). Review them before a Play Store upload.
- The ad / analytics SDKs inside the Clone App (AppLovin, Pangle, Mintegral, Unity Ads, IronSource, Vungle, AdMob, Firebase, Facebook, TikTok) start with their own providers and need their keys from the manifest meta-data; they are kept as received.
- Size: `cloneapp.aar` is about 57 MB; the APK grows by about the same plus the dex of 28,124 classes. `:app` already uses native multidex (minSdk 26).

## Plan
| # | Step | Status |
|---|---|---|
| 1 | AAR + module wiring + docs | done (static checks only) |
| 2 | Native libraries (`jni/<abi>/*.so`) into the AAR | done (arm64-v8a, 14 libraries, `tools/add-jni.py`) |
| 3 | Engine start-up from `App`, process rename, Settings entry (no Start menu / Home / deep link by decision) | done (static checks only) |

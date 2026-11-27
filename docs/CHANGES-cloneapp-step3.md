# Clone App — step 3: engine start-up, process rename, Settings entry

Request: fix the open problems of the Clone App AAR, keep all details, update, full flat zip. Only entry: Settings.

## Changes
- `cloneapp/cloneapp.aar` patched by `cloneapp/tools/patch-processes.py`: `:hs` -> `:chs` (20), `:pN` -> `:cpN` (250) in the manifest; the string constants `:hs` / `:p` in `BLYApplication` and `cn1` (same change). Reason: BlackBox (`:Bcore`) uses `:p0` .. `:p49` too.
- New `app/src/main/kotlin/com/srizwan/win11/CloneAppEngine.kt`: engine attach / create, process check, native library check, `open()`.
- `App.kt`: Clone App processes start only its engine; the launcher process starts it after BlackBox (attach) and after the log setup (create).
- `Win11Shell.kt`: user menu ("Settings" menu) gets the item **Clone App**.
- New tools `cloneapp/tools/patch-processes.py`, `cloneapp/tools/add-jni.py`; `cloneapp/README.md` updated.

## Checks run (no Android SDK / network here)
| Check | Result |
|---|---|
| AAR zip + `classes.jar` integrity after the patch | ok |
| `javap` on `BLYApplication` / `cn1`: constants are `:chs` / `:cp`, `substring(length())` unchanged | ok |
| Whole `classes.jar` scanned for other `:hs` / `:pN` / `:black` constants | none left |
| Manifest: 0 `:pN` / `:hs` process attributes left; BlackBox's manifest untouched | ok |
| Patch run twice | second run changes nothing |
| Kotlin compile, Gradle build, run on a phone | **not done** |

## Step 2 added in the same update: native libraries
- `lib.zip` (27 libraries, arm64-v8a only) -> `cloneapp/tools/add-jni.py` -> 14 libraries in `cloneapp.aar` (`jni/arm64-v8a/`, incl. `libchaos.so` and `libabc.so` = Pine). 13 left out (ffmpeg-kit set, `libmmkv.so`, `libc++_shared.so`, two CameraX libraries): Gradle already brings them, a second copy would fail the build.
- `app/build.gradle.kts`: `pickFirsts` for `libdatastore_shared_counter.so`, `libmmkv.so`, `libimage_processing_util_jni.so`, `libsurface_util_jni.so` (safety net).
- Checked: AAR zip ok, `libchaos.so` is an arm64 ELF needing only libm / liblog / libz / libc / libdl (all system libraries), second run of `add-jni.py` gives the same result.

## Not fixed (needs files or a device)
- No armeabi-v7a / x86 libraries received: 32-bit phones cannot run the engine (it stays off, Settings > Clone App says so).
- 15 manifest classes missing from the jars; possible `NoSuchMethodError` from the obfuscated androidx copies; the 245 permissions review.

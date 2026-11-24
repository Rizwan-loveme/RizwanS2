# Seal — part 7 of 10: targetSdk 28, native libraries, ABI, APK size

Request: add Seal as a built-in app (like `:ppsspp`), update the workflow yml, keep all details, update the full flat zip. This turn: part 7 only.

Steps (each ticked when done):
- [x] 1. Read `app/build.gradle.kts` (packaging, targetSdk, ABI), `:seal` build file, host manifest (`extractNativeLibs`, storage permissions, cleartext), `gradle.properties`, the workflows' APK checks
- [x] 2. targetSdk 28 audit of Seal's code (storage, notifications, foreground service, executing programs, SDK_INT branches)
- [x] 3. Native libraries: `extractNativeLibs`, `libc++_shared.so`, duplicates
- [x] 4. ABI / APK size: optional `-PapkAbis=...` (default off)
- [x] 5. `seal/tools/check-apk-native.sh` (reports what the engine needs inside a built APK; tested on a fake APK)
- [x] 6. Docs: `seal/README.md`, root `README.md`, this file
- [x] 7. Full flat zip

## 1. targetSdk 28 — what I checked (all from the sources; nothing ran)
| Topic | Finding | Action |
|---|---|---|
| Running programs (yt-dlp needs Python, FFmpeg, aria2c as processes) | Android blocks executing files from the app data folder only for targetSdk 29+. At 28 it is allowed, and the engine runs its programs from the native library folder anyway. targetSdk 28 is what the project already uses for Winlator for the same reason | none |
| Storage | `:app` forces the all-files permission at start (`MainActivity.checkPermissionAndShowDialog`), so on Android 11+ Seal can write to Downloads. Seal itself skips its own storage prompt above API 29 (`SDK_INT > 29`), which fits | none |
| Storage on Android 10 (API 29) only | `:app` declares `WRITE_EXTERNAL_STORAGE` with `maxSdkVersion=28`, and Seal asks for that permission itself on API 29, so on Android 10 the system will not grant it and Seal shows "permission denied". Android 10 is the one version where this does not line up | **not changed** (host manifest, outside this part); tell me if you have Android 10 users |
| Notifications | `POST_NOTIFICATIONS` is asked by Seal itself on 13+ (its own dialog); the launcher asks too. Channels created in `SealInit` (minSdk 26) | none |
| Foreground service | `DownloadService` calls the 2-argument `startForeground`; the manifest declares `specialUse` + the subtype property + the `FOREGROUND_SERVICE_SPECIAL_USE` permission (part 5). Type rules of Android 14 are enforced for targetSdk 34+ only; the permission is declared anyway | none |
| Cleartext | the host already has `usesCleartextTraffic="true"`; yt-dlp talks through Python, not through Android's network stack | none |
| Notification tap | the `PendingIntent` is explicit, `FLAG_IMMUTABLE`, to Seal's own `MainActivity` (`exported=false` is fine from the same app) | none |
| Theme | `Theme.Seal` parents are `Theme.Material3.DayNight.NoActionBar` (an AppCompat theme, needed by `AppCompatActivity`) | none |
No source or manifest change was needed for targetSdk 28.

## 2. Native libraries
- **`extractNativeLibs`**: `:app` has `useLegacyPackaging = true` (build file, line ~41) **and** `android:extractNativeLibs="true"` (manifest). The engine needs the libraries as real files. Both are set, so nothing to add. The `packaging` block in `seal/build.gradle.kts` is ignored by AGP for a library module (only the application module counts); its comment now says so.
- **`libc++_shared.so`**: `:app` already has `pickFirsts += "**/libc++_shared.so"` (Winlator, J2ME, ffmpeg-kit, oboe). MMKV 1.3.12 (new with Seal) is one more user of it. Risk, honest: `pickFirst` keeps one copy for the whole app; if the kept copy is older than what a library (for instance the NDK 29 build of RetroArch) needs, that library fails at run time with an `UnsatisfiedLinkError`. I cannot see the AAR contents here (Maven is not reachable from this sandbox), so this is not proven either way. `check-apk-native.sh` prints the copy that was kept; part 8 puts it into the workflows.
- **Other duplicates**: none known (the engine's own files are `libpython*`, `libffmpeg*`, `libaria2c*`; MMKV's is `libmmkv.so`; ffmpeg-kit's names are different). If the merge reports `2 files found with path 'lib/.../libXXX.so'`, send me the line and I add that one name to `pickFirsts`.
- **`META-INF`**: the two duplicate licence files are already excluded (part 3).

## 3. ABI and APK size
- Not measured (no Gradle / SDK / Maven here). From part 1: the yt-dlp engine is about 50-100 MB for arm64 alone; the library ships four ABIs (arm64-v8a, armeabi-v7a, x86, x86_64), so a universal APK carries all of them unless filtered.
- The rest of the project is ARM-only in practice (Winlator, MAME, RetroArch default, PPSSPP check in CI: arm64-v8a; J2ME: arm64 + armeabi-v7a).
- **New, optional:** `-PapkAbis=arm64-v8a,armeabi-v7a` (or a single ABI) sets `ndk.abiFilters` in `:app`, so only those ABIs are packaged. Default: property not set = nothing is filtered, the build is unchanged. Documented in `gradle.properties`. It filters packaging only; the native builds of the other modules keep their own ABI settings. Winlator needs arm64, so do not drop `arm64-v8a`.
- Decision for you / part 8: should the workflows pass `-PapkAbis=arm64-v8a,armeabi-v7a` by default? It drops the x86 / x86_64 copies (emulators and a few Chromebooks) and is the largest saving available. I did **not** switch it on, because it changes every module's output, not only Seal.

## 4. `seal/tools/check-apk-native.sh APK [abi]`
Prints: APK size, the ABIs under `lib/`, the engine libraries (`libpython*`, `libffmpeg*`, `libaria2c*`, `libmmkv*`) of the chosen ABI with sizes, which `libc++_shared.so` was kept, the 8 biggest native files, and how many libraries are stored uncompressed. Exit code 1 only if `libpython*` or `libmmkv*` is missing for the ABI (the Downloader cannot start then); other names only give a note, because file names change between engine versions. Tested here on a small fake APK (found / not found cases; the column parsing had a bug on the first try, fixed). Not run on a real APK.

## Files
- changed: `app/build.gradle.kts` (optional `apkAbis`), `seal/build.gradle.kts` (comment), `gradle.properties` (comment), `seal/README.md`, `README.md`
- new: `seal/tools/check-apk-native.sh`, `docs/CHANGES-seal-part7.md`
- not touched: Kotlin sources, manifests, workflows (the workflow work is part 8)

## Static checks (here)
Kotlin DSL build files balanced; `apkAbis` is read with `findProperty` and does nothing when not set; the shell script passes `bash -n` and the fake-APK test (exit 0 for arm64, exit 1 for an ABI without Python); no Kotlin / XML file changed in this part (the part 6 checks still apply).
Not run: Gradle, CI, a device.

## For part 8 (workflows) — noted now
- `UltimateBuild_NoWinlator.yml` has one tick box per module and turns an unticked module into a stub (folder, `settings.gradle.kts`, `app/build.gradle.kts` edited in the temporary checkout). Seal is not part of that list yet; part 8 should add a "Seal" tick box (default on) the same way, with a stub for `SealLauncher.kt` when it is off.
- Add the APK check (`check-apk-native.sh`) next to the PPSSPP / MAME / RetroArch checks, and decide about `apkAbis`.

Next: part 8 (the three workflow files).

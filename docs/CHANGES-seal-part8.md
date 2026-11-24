# Seal — part 8 of 10: the three build workflows

Request: add Seal as a built-in app (like `:ppsspp`), update the workflow yml, keep all details, update the full flat zip. This turn: part 8 only.
"The yml" was not named, so (as announced) all three build workflows were changed, because the PPSSPP steps are in all three: `UltimateBuild.yml`, `UltimateBuild_NoWinlator.yml`, `UltimateBuild_WithoutMe.yml`. `keystore.yml`, `restore.yml`, `unzip.yml` have nothing to do with modules and are untouched.

Steps (each ticked when done):
- [x] 1. Read the three workflows, the host hooks of part 6 (`SealLauncher.kt`, `StartApps.kt`, `Win11Shell.kt`, `App.kt`, `BrowserMediaGrabber.kt`) and Seal's library manifest
- [x] 2. APK checks for Seal in all three (engine libraries, merged manifest)
- [x] 3. `WithoutMe`: new tick box "Downloader (Seal)" with a stub for `SealLauncher.kt`
- [x] 4. Optional ABI input `apk_abis` in all three (decision from part 7)
- [x] 5. Test the workflow scripts here (extracted from the YAML and run on copies of the project)
- [x] 6. Docs: `seal/README.md`, root `README.md`, this file
- [x] 7. Full flat zip

## 1. What Seal needs in CI (and what it does not)
- **No fetch / cache / ccache step.** The Kotlin sources are in the repo and the yt-dlp engine is a Maven library (Maven Central; the settings already have `mavenCentral()` and JitPack). The "Cache ... source" / "Fetch ... source" steps that PPSSPP, RetroArch and MAME have are not needed.
- **Package rename:** the rename step only touches the app's old package (`com.srizwan.win11` by default). Nothing in `seal/` or `seal-color/` contains it (only `seal/README.md`, which is not in the file types the step scans), so Seal's package `com.junkfood.seal` is never touched.

## 2. New APK checks (all three workflows, in the step "Locate Unsigned APK", after the RetroArch check)
1. `bash seal/tools/check-apk-native.sh "$UNSIGNED_APK" arm64-v8a` (part 7): stops the run if `lib/arm64-v8a/libpython*` or `libmmkv*` is missing; prints the engine libraries, which `libc++_shared.so` was kept (the `pickFirst` risk of part 7 becomes visible in the log), the biggest native files, the stored / deflated count.
2. **New:** `python3 seal/tools/check-merged-manifest.py <merged release manifest>` (the same `find ... merged_manifests/release` as the RetroArch check; if the file is not found only a warning is printed). It fails the run when: `MainActivity`, `QuickDownloadActivity` or `CrashReportActivity` of `com.junkfood.seal` is missing, exported, or has any `intent-filter` (so no own launcher icon, no share-sheet entry, no link handling - the promise of part 5); `DownloadService` is missing or has no `specialUse`; `NotificationActionReceiver` or `SealFileProvider` is missing; any Seal activity has the LAUNCHER category.

## 3. `UltimateBuild_WithoutMe.yml`: tick box "Downloader (Seal)"
- Input `include_seal` (default true). Unticked, in the temporary checkout only:
  - `seal/` and `seal-color/` are deleted and removed from `settings.gradle.kts` / `app/build.gradle.kts` (`drop_module seal seal-color`);
  - `SealLauncher.kt` becomes a stub with the same names (`SEAL_NAME`, `isSealUrl()` = false, `openSeal()`, `openSealWithUrl()`), so `MainActivity` (Start menu click, `rizwans2://seal`), `BrowserUi` and `BrowserMediaGrabber` still compile; because `isSealUrl()` is false the Browser menu item "Download with Downloader" and the Media Grabber pills / "Page -> Downloader" are not shown;
  - `App.kt`: the import and the `SealInit.init(...)` try / catch block are removed (no MMKV / Koin / engine start);
  - `StartApps.kt`: the Start menu entry is removed; `Win11Shell.kt`: the Home screen icon line is removed (its text is `desktopIcon(VectorIconView.SEAL, SEAL_NAME, "seal")`, which the old generic `hide_entry` pattern would not have matched, because the label is a constant, not a string); `BrowserMediaGrabber.kt`: the one unguarded "Downloader" pill of a plain link row is removed;
  - a check that nothing outside the module still names `com.junkfood` or `SealInit` stops the build early; the Gradle check, the summary table and the release text list the Downloader.
- The APK checks of section 2 run only when the box is ticked; Seal is skipped in "Modules in this build" when not.
- **Bug found and fixed on the way (it was in part 6's wiring, not in this part's new code):** the Downloader's Start menu entry was added right after the PPSSPP entry, but the PPSSPP removal pattern in this workflow matched the entry **without its trailing comma**. Unticking PPSSPP would have left `),,` in `StartApps.kt` and stopped Kotlin. The PPSSPP and J2ME patterns now swallow an optional trailing comma (`\),?`). Found by running the script (see section 5), not by reading it.
- Correction to the part 7 notes: it said `UltimateBuild_NoWinlator.yml` has a tick box per module. It does not - only `WithoutMe` does; `NoWinlator` only removes Winlator. So Seal is always built in `UltimateBuild.yml` and `UltimateBuild_NoWinlator.yml`, and optional only in `WithoutMe`.

## 4. Optional ABI filter (decision from part 7)
- New input `apk_abis` in all three (default **empty = nothing is filtered, the build is exactly as before**). Example: `arm64-v8a,armeabi-v7a` keeps only these ABIs in the APK (drops the x86 / x86_64 copies of the engine, MMKV, ffmpeg-kit, oboe ...). Seal's share of the size is the biggest, but the filter changes every module's packaged output, which is why it is **not** switched on by default.
- New step "Check the optional ABI filter" (before the JDK step): spaces are removed, only `arm64-v8a`, `armeabi-v7a`, `x86`, `x86_64` are accepted, `arm64-v8a` is required (Winlator, PPSSPP, MAME, RetroArch and the APK checks are arm64); a valid value is passed to Gradle as `ORG_GRADLE_PROJECT_apkAbis` (read by `findProperty("apkAbis")` in `app/build.gradle.kts`, part 7).
- `WithoutMe` now has 11 inputs. GitHub allowed 10 until December 2025; the limit is 25 since the changelog of 2025-12-04, so 11 is fine (checked online today).

## 5. What was tested here (and what was not)
- All three files parse as YAML; the "Remove the modules" step, the ABI step and the "Locate Unsigned APK" step of every file pass `bash -n`.
- The "Remove the modules that are not ticked" script was **taken out of the YAML and executed** on full copies of the project for: all ticked, Seal off, PPSSPP off, PPSSPP + Seal off, J2ME off, everything off. All exit 0. For "Seal off" the result differs from the original only in the expected lines (3 lines in `settings` / `app/build.gradle.kts`, the Start menu entry, one Home icon line, one pill line, the `App.kt` block; the stub is written). No `,,`, no leftover `com.junkfood` / `SealInit` code, `StartApps.kt` still balanced. The PPSSPP-off case failed before the comma fix and now passes.
- The ABI step: empty, `arm64-v8a`, `arm64-v8a,armeabi-v7a`, with spaces (ok); `x86,x86_64` and `arm64-v8a,foo` (rejected with a clear message).
- The Seal APK-check block was run on fake APKs and manifests: good APK + good manifest = exit 0; APK without Python = exit 1; manifest with a launcher filter and no service = exit 1 with three error lines; no merged manifest = warning only, exit 0; the `INC_SEAL=false` wrapper does nothing.
- **Not run:** GitHub Actions itself, Gradle, the Kotlin compiler (the stub and the edited files are checked for balanced brackets and by diff only), a real APK. The merged-manifest path (`app/build/intermediates/merged_manifests/release/...`) is the one the RetroArch check already uses; if AGP puts it elsewhere the check prints the warning and is skipped, it does not fail the build.

## Files
- changed: `.github/workflows/UltimateBuild.yml`, `UltimateBuild_NoWinlator.yml`, `UltimateBuild_WithoutMe.yml`, `seal/README.md`, `README.md`
- new: `seal/tools/check-merged-manifest.py`, `docs/CHANGES-seal-part8.md`
- not touched: Kotlin sources, manifests, Gradle files (the three workflows edit the temporary checkout only; nothing is committed)

## For part 9 / 10
- Part 9 (docs): root `README.md` + `seal/README.md` get the final overview (how to run the three workflows, the tick box, `apk_abis`, size estimate, GPL note); part 10: static checks over the whole project and the final flat zip.
- Open from earlier parts, still yours to decide: Android 10 storage gap (part 7); the first real CI run will show whether `libc++_shared.so` `pickFirst` is enough (the log now prints it).

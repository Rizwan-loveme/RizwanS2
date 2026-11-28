# Mika (Rizwan) — build fix 2 (after the second GitHub Actions log)

Request: keep every detail, fix the build error from `build-error-log__1_.zip`, full flat zip.

## Steps done
- [x] 1. Noted in memory
- [x] 2. Read the log (28015 lines): every `e:` line, the failed task, the tasks around it
- [x] 3. Compared with the first log (which modules ran) to find why this error is new
- [x] 4. Found the cause (two modules ship the same native library) and checked every module for more duplicates
- [x] 5. Fixed it in `app/build.gradle.kts`; added a check to `static-check.py`
- [x] 6. Updated the docs; flat zip `RizwanS2-main-mika-fix2.zip`

## What the log says
| Task | Result |
|---|---|
| `:mika:compileReleaseKotlin` | **passed** (only `w:` warnings: deprecated Android calls, one deprecated `AnchoredDraggableState` constructor, opt-in notes). No `e:` line. Fix 1 worked and all of Mika's Kotlin compiles with the project's Compose / Kotlin versions |
| **`:app:mergeReleaseNativeLibs`** | **FAILED** |
```
2 files found with path 'lib/arm64-v8a/liboboe.so' from inputs:
 - j2me/build/intermediates/library_jni/release/copyReleaseJniLibsProjectOnly/jni/arm64-v8a/liboboe.so
 - winlator/build/intermediates/library_jni/release/copyReleaseJniLibsProjectOnly/jni/arm64-v8a/liboboe.so
```

## Why it is new
The first log was a build WITHOUT `:winlator` and `:retroarch` (0 tasks of them); this one is the full build (46 tasks of each). With only one of the two modules there was no duplicate. The conflict is between two modules that were already in the project; Mika has nothing to do with it (Mika adds no `liboboe.so`).

## Cause
- `:winlator`: `src/main/jniLibs/arm64-v8a/liboboe.so` (prebuilt, **Oboe 1.9.0**, linked by its fluidsynth / MIDI handler).
- `:j2me`: `implementation("com.google.oboe:oboe:1.11.0")` (Prefab package, **Oboe 1.11.0**, used by the MMAPI sound code).
The APK needs one file for that path.

## Fix
`app/build.gradle.kts`, `packaging { jniLibs { ... } }`: added `pickFirsts += "**/liboboe.so"` next to the existing `pickFirsts += "**/libc++_shared.so"` (same pattern the project already uses for the same kind of conflict). A comment explains why.

## Honest risk
One `liboboe.so` is kept for the whole app. Oboe is a C++ library whose headers and library are meant to match; if the copy that is kept is not the version a user was built against, that user's audio could misbehave (J2ME sound or Winlator MIDI), in the worst case a crash when that feature starts. The rest of the app is not touched. Which copy is kept is decided by AGP's merge order; the error text listed `:j2me` first, which suggests Oboe 1.11.0. If one of the two audio features misbehaves on your phone, tell me which: the next step would be to give one of them its own, renamed copy of Oboe (more work, not done now because it needs building Oboe from source).

## Checked for more duplicates
All native libraries that sit as files in the repository (only `:winlator` has any: 24 files, arm64-v8a) were compared with the other modules' libraries; `liboboe.so` and `libc++_shared.so` (already handled) are the only shared names I can see from here. Libraries that come inside AAR dependencies (ffmpeg-kit, MMKV and so on) and files built by CMake / ndk-build cannot be seen without a build, so another duplicate is still possible: Gradle reports one conflict per run. Send the next log.

## Tested here
| Case | Result |
|---|---|
| `static-check.py` (project) | all groups pass; group 7 now also checks `pickFirsts` for `libc++_shared.so` and `liboboe.so` |
| other workflows | they only delete the line `project(":winlator")` etc. from `app/build.gradle.kts`; the new lines do not contain it |
Not tested: the merge itself, the APK, audio on a phone (no Gradle / Android SDK here).

## Not changed
No Mika file, no patch script change in this fix (edit 14 of fix 1 stays). Step 14 (wake word) is still not done; its feasibility was answered separately (a `SpeechRecognizer` loop is possible, with limits).

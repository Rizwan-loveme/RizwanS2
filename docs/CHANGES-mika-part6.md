# Mika (Rizwan) — part 6 of 15: `App` extends `MikaApp`, process guard

Request: add Mika as a built-in **library** app called **Rizwan** (sources fetched at build time like PPSSPP / MAME / RetroArch), keep all details, update the full flat zip. "Hey Rizwan" will be the voice wake word (step 14). This turn: part 6 only.

Steps (each ticked when done):
- [x] 1. Read the Mika sources that matter for the Application: all of `MikaApp.kt` (761 lines), `MikaQuit.kt`, the helper hand-off, `OWN_PAGE_CLASS`, the eager initialisers; read the current `App.kt` and the places where the "without" workflow edits it by regex
- [x] 2. Patch script edit 7: `MikaApp.onCreate` split (`startOnCreate()` + idempotent main-thread `startMika()`), `onQuitExit()`, `MikaQuit` without process kill / `cancelAll()`; drift guard + self-check
- [x] 3. Tested the patch on a copy of the real upstream: first run, second run, forced re-run (byte-identical), result read
- [x] 4. `AppBase.kt` (new) and `App.kt` (class line, doc comment, last block of `onCreate`); stub for the "without Mika" build
- [x] 5. Docs (`mika/README.md` "Step 6", `README.md`, this file, `gradle.properties` comment), static checks, full flat zip `RizwanS2-main-mika-step6.zip`

## Changed / new files
- changed: `mika/tools/patch-upstream.py`, `app/src/main/kotlin/com/srizwan/win11/App.kt`, `mika/README.md`, `README.md`, `gradle.properties` (comment only)
- new: `app/src/main/kotlin/com/srizwan/win11/AppBase.kt`, `mika/tools/stub/AppBase.kt.stub`, `docs/CHANGES-mika-part6.md`
- not touched: manifest, workflows, any Gradle file, the other modules

## Decisions taken here (say if you want them different)
- **`App : AppBase : MikaApp`, not `App : MikaApp` directly.** All Mika-specific Application code is in one file, so the CI "without Mika" build only swaps `AppBase.kt` for `mika/tools/stub/AppBase.kt.stub` (the way the other launchers are stubbed) instead of editing `App.kt`.
  The file has to stay in `app/src/main/kotlin/...`: the CI package rename only rewrites that folder (and `main/java`, tests).
- **Mika starts only after Rizwan was opened once** (flag in preference `win11_rizwan_state`), then at every launcher start. Reason: its start-up unpacks the 58 MB sandbox in the background and starts the capsule, helper watcher, recovery and proactive code.
  For "always on" delete the `wasMikaUsed` test in `AppBase.startMikaIfUsed()`.
- **"Quit Mika" no longer ends the process** and no longer clears all notifications (it would have closed the Win11 launcher and wiped the app's notifications). Services, capsule and quit flag behave as upstream.
- The supported-phone test is Android 10+ and arm64-v8a (`AppBase.isMikaSupported()`); the step 8 hooks will use it for `MikaLauncher.isSupported()`.

## What changes for you
Nothing visible yet: no hook opens Rizwan before step 8, and `startMikaIfUsed()` does nothing while the flag is not set. The other processes (":black", ":p0", ":midlet", ":mame", ":retroarch") never run Mika code.
**`-PincludeMika=false` does not compile from this step** (the stub is used by step 9).

## Not run
Gradle, a compile, CI, a device (no Android SDK / network here). Expected first failures are listed in `mika/README.md` ("Step 5" and "Step 6" risks). Send the first error lines of the first CI run.
Carried forward to step 7: cut Mika's own self-update (it downloads and installs Mika's APK), and the backup-import "close the app" text.
Next: part 7 (manifest merge into `:app`: permissions, services, providers, network config, share filters).

# Mika (Rizwan) — part 8 of 15: hooks (Start menu, Home icon, `rizwans2://rizwan`) and `targetSdk 37`

Request: Rizwan as a built-in **library** app like PPSSPP / MAME / RetroArch (sources fetched at build time), keep all details and all of Mika's permissions, Mika follows the project's versions, "Hey Rizwan" is the voice wake word (step 14),
**and `targetSdk 37`** (new in this turn). Part 8 only; the user sent the step 7 zip and the uploaded upstream (split zip `ezyZip.zip` + `.z01`-`.z04` = `Mika-main.zip`, 0.1.52) again.

Steps (each ticked when done):
- [x] 1. Unpack the step 7 zip and the upstream; read the hook pattern of RetroArch / MAME / Seal / Winlator (`*Launcher.kt`, `StartApps.kt`, `Win11Shell.kt`, `MainActivity` section dispatch and `handleDeepLink`, `TerminalShare`), `AppBase.kt`, `App.kt`, Mika's manifest and its `MainActivity`
- [x] 2. `MikaLauncher.kt`, Start menu entry, Home icon, `rizwans2://rizwan` (+ alias `assistant`), terminal list, manifest comment, `MikaLauncher.kt.stub`
- [x] 3. `targetSdk 37` in one place (+ `-PappTargetSdk=28` to go back), root `extra`, `gradle.properties`, comments that said 28
- [x] 4. Static scan for what 37 changes (exported, foreground service types, PendingIntent flags, storage, package visibility, edge-to-edge, back, dex loading, process start)
- [x] 5. `check-manifest.py` checks 9 to 11 + 3 negative cases; patch script and checks run on a copy of the real upstream (twice)
- [x] 6. Docs: `mika/README.md` ("Step 8"), `README.md`, this file
- [x] 7. Full flat zip `RizwanS2-main-mika-step8.zip`

## Changed / new files
- new: `app/src/main/kotlin/com/srizwan/win11/MikaLauncher.kt`, `mika/tools/stub/MikaLauncher.kt.stub`, `docs/CHANGES-mika-part8.md`
- changed (hooks): `StartApps.kt` (constants `BUILTIN_CLS_RIZWAN`, `RIZWAN_PATH`, the entry), `Win11Shell.kt` (`VectorIconView.RIZWAN`: type, path, colour; the Home icon), `MainActivity.kt` (section dispatch, deep link, KDoc list), `TerminalShare.kt` (built-in list, header), `app/src/main/AndroidManifest.xml` (deep-link comment only: no tag changed)
- changed (targetSdk): `app/build.gradle.kts`, `build.gradle.kts`, `gradle.properties`, `settings.gradle.kts` (comments)
- changed (checks / docs): `mika/tools/check-manifest.py`, `mika/README.md`, `README.md`
- comments only (they said "targets API 28"): `J2meLauncher.kt`, `PpssppLauncher.kt`, `RetroArchLauncher.kt`, `chooser/.../AppFinder.kt`, `gallery/.../ImageActions.kt`, `gallery/src/main/AndroidManifest.xml`, `ppsspp/.../PpssppActivity.java`, `retroarch/README.md`, `seal/README.md`
- not touched: the patch script (`patch-upstream.py`), any workflow, any other Kotlin / Java / resource file, the other modules' code

## What the user sees
- **Start menu / All apps:** "Rizwan" (violet sparkle icon), pin / recent / hide work as for every built-in app; it also counts in the "All apps" numbers of `rizwans2://N`.
- **Home screen:** a "Rizwan" icon after RetroArch (before Winlator).
- **Deep link:** `rizwans2://rizwan` (alias `rizwans2://assistant`); the terminal theme's `builtin` list has it too.
- **Opening:** Mika is started first (`AppBase.startMikaNow()`), then Rizwan's chat opens in its own task (Recents shows it as a separate window; Back does not close the launcher). Quit Mika in Rizwan keeps Win11 alive (step 6).
- **Phones that are not Android 10+ with arm64-v8a:** no entry, no icon; the deep link shows a short message.
- Not in this part: the wake word "Hey Rizwan" (step 14), the persona / prompts that still say "Mika" (step 14), CI (step 9).

## targetSdk 37

### What changed
`targetSdk = (findProperty("appTargetSdk") as String?)?.trim()?.toIntOrNull() ?: 37` in `app/build.gradle.kts`. Default 37. **To go back to 28 without editing a file:** `-PappTargetSdk=28` on the Gradle command line, or `appTargetSdk=28`
in `gradle.properties` (the line is there, commented out). The root `extra["targetSdkVersion"]` follows the same property; nothing reads it (checked: `:Bcore` does not). CI needs no change: all three workflows already install platform 37.

### Checked here (static, by script or by reading)
| Area (what 37 turns on) | Result |
|---|---|
| `android:exported` explicit (manifest merger, target 31+) | 14 module manifests + Mika's: **0** components with an intent filter or provider without it (now also check 9 of `check-manifest.py`) |
| Foreground service types and `FOREGROUND_SERVICE_<TYPE>` permissions (target 34+) | 5 types in use (`dataSync`, `mediaPlayback`, `mediaProjection`, `microphone`, `specialUse`), **all** have their permission; every class that calls `startForeground` is a typed service in its manifest (check 10) |
| `PendingIntent` mutability flag (target 31+) | **0** calls without `FLAG_IMMUTABLE` / `FLAG_MUTABLE` or a flags helper (all modules but upstream and `:Bcore`) |
| Scoped storage (target 30+) | `MANAGE_EXTERNAL_STORAGE` is declared: plain `File` access keeps working |
| Package visibility (target 30+) | `QUERY_ALL_PACKAGES` is declared: the app lists stay complete (the chooser's `AppFinder` comment was wrong about needing `<queries>`, it is fine) |
| Predictive back (target 36+) | `android:enableOnBackInvokedCallback="false"` is already on `<application>`, so `onBackPressed()` / `KEYCODE_BACK` code keeps working; Mika's `MainActivity` sets its own `true` and uses Compose `BackHandler` |
| Dynamic code loading (target 34+: dex must be read-only) | J2ME already calls `setReadOnly()` on its dex cache (`MicroLoader`) |
| Edge-to-edge (target 35+) | `:app`'s `MainActivity`, `QuickControlsActivity`, `NotificationSettingsActivity`, `CalculatorActivity`, `DebugLogActivity`, `PermissionsActivity`, `FakeLocationActivity`, `ParallelActivity` already use window-insets listeners and transparent system bars |
| `file://` uris in intents | already thrown at 28 (since API 24), the code uses paths / content uris, no change |

### Expected to stop working (the reason the project used 28; not tested, from Android's rules and the project's own notes)
1. **Winlator**: box64 / wine are started with `ProcessBuilder` from the root file system in the app data folder (`ProcessHelper.exec`). Android blocks executing files from the app data folder for apps that target 29 or more, so PC programs are not expected to start.
2. **RetroArch cores** downloaded into `<dataDir>/cores` (Core Downloader): same rule, per `retroarch/README.md`.
3. Not expected to be affected: Seal's engine (upstream Seal targets 35 and runs the same libraries), PPSSPP, MAME (they use the all-files permission the app already holds), J2ME.

### Not verified (needs a real phone, or is outside what a static scan can see)
- Edge-to-edge layout of the **library modules' screens** (video, gallery, camera, tui, winlator, ppsspp, mame, retroarch, seal, Mika's own): target 35+ forces it. `:app`'s main screens were read; the others were not.
- Android 17 behaviour changes for apps that target 37: not reviewed.
- BlackBox (`:Bcore`) behaviour at a higher target (hidden-API use, ProxyService foreground types are declared).
- Runtime permission prompts (notifications, media, exact alarm) for Mika's 13 new permissions at this target.

If Winlator or the cores matter more than the new target: set `appTargetSdk=28` and nothing else changes.

## Decisions taken here (say if you want them different)
- Rizwan's Start menu entry / Home icon / terminal entry are **hidden** on an unsupported phone (like Winlator), instead of showing and failing. The deep link still answers with a toast.
- Icon: a vector sparkle (not Mika's logo), violet `#B185FF`, so it needs no image and matches the other built-in icons.
- `targetSdk` is a property with the default 37, not a bare number, so going back is one flag.
- No `?text=` / share parameter on `rizwans2://rizwan` (Seal has one for URLs; Mika's share path already exists through the share sheet). Say if you want it.

## Not run
Gradle, a compile, CI, a device (no Android SDK / Kotlin compiler / network here). If the first CI run fails, send the first `e: ` line of `:app:compileDebugKotlin`, the lines starting `patch-upstream:` / `check-manifest:`, or `Manifest merger failed`.
Next: part 9 (CI: cache + fetch + patch + manifest check in the three workflows, `include_mika` switch, the two stubs).

# Seal — part 4 of 10: SealInit + self-update removed

Request: add Seal as a built-in app (like `:ppsspp`), keep all details, update the full flat zip. This turn: part 4 only.

Steps (each ticked when done):
- [x] 1. Read the part 3 tree: `:seal` / `:seal-color`, host `App.kt`, upstream `App.kt` (what it starts, who reads `App.xxx`: ~45 places)
- [x] 2. `seal/tools/overlay/SealInit.kt` (new): MMKV, `App` fields, Koin (guarded), download folders, notification channels, yt-dlp / FFmpeg / aria2c in the background; `engineReady` / `engineError`
- [x] 3. `seal/tools/overlay/App.kt`: Seal's `App` is no longer an `Application` (companion unchanged, so the ~45 call sites compile as before); crash-screen start-up removed
- [x] 4. Self-update removed: 3 screens deleted, `UpdateUtil.kt` cut to `updateYtDlp()` (overlay), `AppEntry.kt` / `Route.kt` / `AboutPage.kt` / `PreferenceUtil.kt` patched
- [x] 5. `seal/tools/win11_patches.py` (patch list, drop list, overlay copy; idempotent) called from the end of `import-upstream.py`
- [x] 6. Host `app/src/main/kotlin/com/srizwan/win11/App.kt`: `SealInit.init(this) { ... }` at the end of `onCreate`, launcher process only, in try/catch
- [x] 7. Static checks (see below)
- [x] 8. Docs: `seal/README.md` (status, plan table, "Part 4"), root `README.md` (table + paragraph), `NOTICE-Seal.md` (changes list), this file
- [x] 9. Full flat zip

Changed / new files:
- new: `seal/src/main/java/com/junkfood/seal/SealInit.kt`, `seal/tools/win11_patches.py`, `seal/tools/overlay/{SealInit.kt,App.kt,util/UpdateUtil.kt}`, `docs/CHANGES-seal-part4.md`
- rewritten: `seal/src/main/java/com/junkfood/seal/App.kt`, `.../util/UpdateUtil.kt`
- patched: `.../ui/page/AppEntry.kt`, `.../ui/common/Route.kt`, `.../ui/page/settings/about/AboutPage.kt`, `.../util/PreferenceUtil.kt`
- deleted: `.../ui/page/AppUpdater.kt`, `.../ui/page/UpdateDialog.kt`, `.../ui/page/settings/about/UpdatePage.kt`
- host: `app/src/main/kotlin/com/srizwan/win11/App.kt` (import, 6 lines at the end of `onCreate`, class comment)
- tools: `seal/tools/import-upstream.py` (old PATCHES block replaced by a call to `win11_patches.apply`)
- docs: `seal/README.md`, `README.md`, `NOTICE-Seal.md`

Decisions taken here (say if you want them different):
- Engine init stays eager in the background at launcher start (as upstream), not lazy. Reason: Seal's code calls `YoutubeDL.getInstance()` without checking, so a lazy start would need a hook at every Seal entry point. Cost: one background thread per launcher start, plus the one-time unpack.
- `BuildConfig.FLAVOR` / `DEBUG` kept as they are (the part 1 plan said constants; part 3's `BuildConfig` makes that unnecessary).
- `CrashReportActivity` stays in the sources, but nothing opens it at start-up; an engine failure goes to the log, `AppLog` and `SealInit.engineError`.

Static checks (here): 135 Kotlin files balanced `{}()[]` (string / comment aware); no reference left to the removed update code, `startCrashReportActivity`, `: Application()`, `as App`, `App()`; symbols used by `SealInit` exist; `win11_patches.apply()` is idempotent (11 applied + 12 in place on the second run).
Not run: Gradle, the Kotlin compile of `:seal` (Kotlin 2.2.10), CI, a device, `import-upstream.py` itself (no upstream checkout here). The first real compile of Seal is still your next workflow run; if `:seal` fails, send me the first error lines.
Nothing is visible in the app yet (no manifest, no hook).

Next: part 5 (manifest merge: `SealActivity` / `QuickDownloadActivity` / `CrashReportActivity` / `DownloadService` / `NotificationActionReceiver` / FileProvider / permissions, no LAUNCHER and no http / SEND filters).

# Seal — part 5 of 10: manifest

Request: add Seal as a built-in app (like `:ppsspp`), keep all details, update the full flat zip. This turn: part 5 only.

Steps (each ticked when done):
- [x] 1. Read upstream's manifest, the host manifest (permissions, `MainActivity` name, `allowBackup` ...), the sibling modules' manifests (FileProvider classes, launch modes) and how Seal reads its intents
- [x] 2. `seal/tools/overlay-main/AndroidManifest.xml` (new): 3 activities, 1 service, 1 receiver, 1 provider, 7 permissions; no `intent-filter`, no LAUNCHER, all `exported=false`
- [x] 3. `SealFileProvider.kt` (new, overlay): own FileProvider subclass; `win11_patches.apply()` now also copies `overlay-main/` to `seal/src/main/` (the import script wipes `seal/src`)
- [x] 4. Static checks (below)
- [x] 5. Docs: `seal/README.md` (status, plan table, "Part 5", two corrections to part 1 text), root `README.md`, `NOTICE-Seal.md`, this file
- [x] 6. Full flat zip

Changed / new files:
- new: `seal/src/main/AndroidManifest.xml` (+ source copy `seal/tools/overlay-main/AndroidManifest.xml`), `seal/src/main/java/com/junkfood/seal/SealFileProvider.kt` (+ `seal/tools/overlay/SealFileProvider.kt`), `docs/CHANGES-seal-part5.md`
- changed: `seal/tools/win11_patches.py`, `seal/tools/import-upstream.py` (comment), `seal/README.md`, `README.md`, `NOTICE-Seal.md`
- not touched: any Kotlin code of Seal other than the new provider class, `app/` (host manifest and `App.kt`), Gradle files, workflows

Found while doing this (corrections to earlier text, now fixed in `seal/README.md`):
- Part 1 said the FileProvider "has no clash". The authority has none, but the **class** would: two `androidx.core.content.FileProvider` entries break the merge. All other modules use an own subclass, so Seal got `SealFileProvider`.
- Earlier notes called Seal's main screen `SealActivity`. It is `com.junkfood.seal.MainActivity` (the host has its own `com.srizwan.win11.MainActivity`; the full names differ). Part 6 starts it by that name.

Decisions taken here (say if you want them different):
- No share-sheet entry and no link handling for Seal (no filters). "Share to Downloader" from other apps can be added in part 6 as one filter on `QuickDownloadActivity`.
- Two new permissions for the whole launcher APK: `FOREGROUND_SERVICE_SPECIAL_USE`, `REQUEST_IGNORE_BATTERY_OPTIMIZATIONS` (both normal, no prompt).
- `AppLocalesMetadataHolderService` not declared; Seal's language page changes the language of the whole launcher process (`setApplicationLocales`) — part 6 decides whether to hide that page.
- `MainActivity` keeps upstream's `singleTask` and the default task affinity, so Seal opens in the launcher's own task (like the other built-in apps); its label is still `sl_app_name` = "Seal" and is renamed in part 6.

Static checks (here): manifest well-formed; 6 component classes exist; every `@mipmap` / `@style` / `@string` / `@xml` reference exists; no `intent-filter` / `LAUNCHER` / `REQUEST_INSTALL_PACKAGES`; 6 of 6 components `exported=false`; authority `${applicationId}.provider` unique; no other manifest names a `com.junkfood.seal` class; 5 of the 7 permissions are identical in `:app`.
Not run: the manifest merge, Gradle, the Kotlin compile of `:seal`, CI, a device. If the merge fails, send me the `Manifest merger failed` lines.
Nothing is reachable in the app yet (no hook).

Next: part 6 (hooks: Start menu entry, Home screen icon, `rizwans2://seal`, "download with Seal" from the Browser / MediaGrabber, download folder, neutral display name).

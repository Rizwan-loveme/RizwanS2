# Mika (Rizwan) — part 7 of 15: manifest merge, self-update cut, language, backup text

Request: add Mika as a built-in **library** app called **Rizwan** (sources fetched at build time like PPSSPP / MAME / RetroArch), keep all details, update the full flat zip. Decisions of the owner that apply here:
Mika keeps **all** its permissions; Mika's versions follow the project's; "Hey Rizwan" is the voice wake word (step 14). This turn: part 7 only.

Steps (each ticked when done):
- [x] 1. Unpack the step 6 zip and the uploaded upstream (split zip `ezyZip.zip` + `.z01`-`.z04` = `Mika-main.zip`, version 0.1.52); read upstream's manifest (428 lines), network config, `AppLanguage.kt`, `UpdateChecker.kt`, `MikaApp` update members, `MainActivity`, backup screen and strings; read `:app`'s manifest and the other library manifests
- [x] 2. Patch edit 8 `AppLanguage.kt` (never the host's locale), edit 9 `UpdateChecker.kt` (self-update cut), edit 10 backup text in 13 languages, edit 11 manifest (label, icon, own task), edit 12 `MainActivity` starts Mika first
- [x] 3. Permission rule: `KEEP_PERMISSIONS` (30) checked by the patch
- [x] 4. `mika/tools/check-manifest.py` (static merge check) + 5 negative cases
- [x] 5. Tests on a copy of the real upstream: fresh, on a tree patched by the real step-6 script, second run, forced re-run: identical trees
- [x] 6. Docs: comment block in `app/src/main/AndroidManifest.xml`, `mika/README.md` ("Step 7"), `README.md`, `NOTICE-Mika.md`, this file
- [x] 7. Full flat zip `RizwanS2-main-mika-step7.zip`

## Changed / new files
- changed: `mika/tools/patch-upstream.py` (edits 8 to 12, new checks, header), `app/src/main/AndroidManifest.xml` (comment block only, no tag changed), `mika/README.md`, `README.md`, `NOTICE-Mika.md`
- new: `mika/tools/check-manifest.py`, `docs/CHANGES-mika-part7.md`
- not touched: any Gradle file, any workflow, any Kotlin / resource file of `:app`, the other modules

## What changes in the merged app
- **Permissions:** 30 of Mika are merged, 17 already existed in `:app`, **13 are new** (location, calendar, exact alarm, alarm clock, install packages, media images, promoted notifications, call companion, ongoing calls, special-use foreground services). None removed.
- Components added by the merge: 7 activities, 11 services, 6 providers, 7 receivers (+ `<queries>`, 5 `<uses-feature required="false">`). No duplicate class name, no authority clash (65 authorities checked).
- Rizwan's screens: label "Rizwan", its icon, own task `${applicationId}.rizwan` (Recents shows Rizwan as a separate window); share sheet entry "Rizwan" (filters kept).
- **No update of Mika's own APK can happen** any more; the About page's "check for updates" ends as "up to date".
- Rizwan's language setting no longer changes the language of the Win11 launcher.
- After a backup import the dialog tells the user to close Rizwan and swipe RizwanS2 away (13 languages).

## Decisions taken here (say if you want them different)
- Network security config **not** merged (user-CA trust for the whole app refused; cleartext already on in `:app`). A model server behind a company CA fails TLS until `android:networkSecurityConfig` is added to `:app`.
- SEND / SEND_MULTIPLE filters kept (feature intact, now labelled "Rizwan"); the unsupported-phone case is listed as a risk in `mika/README.md`.
- Own task only (no own process): Mika's state lives in the launcher process (part 6).

## Not run
Gradle, a compile, CI, a device (no Android SDK / network here). If the first CI run fails, send the lines starting at `patch-upstream:` (patch), `Manifest merger failed` (merge) or the first `e: ` line of `:mika:compileDebugKotlin`.
Next: part 8 (hooks: `MikaLauncher.kt`, Start menu, Home icon, `rizwans2://rizwan`, `startMikaNow()`).

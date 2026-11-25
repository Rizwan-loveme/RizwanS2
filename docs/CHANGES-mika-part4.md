# Mika (Rizwan) — part 4 of 15: patch script

Request: add Mika as a built-in **library** app called **Rizwan** (sources fetched at build time like PPSSPP / MAME / RetroArch), keep all details, update the full flat zip; "Hey Rizwan" will be the voice wake word (step 14). This turn: part 4 only.

Steps (each ticked when done):
- [x] 1. Unpack the uploaded split zip (`ezyZip.z01–z04 + .zip` = `Mika-main.zip`, version 0.1.52) and the step 3 project; re-read the manifest, `MikaApp`, resources, greeting code
- [x] 2. `mika/tools/patch-upstream.py` + `patch-upstream.sh`: MikaApp open, library manifest, `mk_` resource names, Rizwan name, "Hey Rizwan" greeting, icon, self-check
- [x] 3. Icon art `mika/rizwan/drawable-nodpi/mika_launcher_art.png`
- [x] 4. Gradle: task `patchMikaUpstream` (after `fetchMikaUpstream`, before everything that reads the checkout)
- [x] 5. Tests on a copy of the real upstream: first run, second run, forced re-run byte-identical, XML well-formed, `mk_` references resolved
- [x] 6. Docs: `mika/README.md` ("Step 4"), root `README.md`, `NOTICE-Mika.md`, this file
- [x] 7. Full flat zip `RizwanS2-main-mika-step4.zip`

## Changed / new files
- new: `mika/tools/patch-upstream.sh`, `mika/tools/patch-upstream.py`, `mika/rizwan/drawable-nodpi/mika_launcher_art.png`, `docs/CHANGES-mika-part4.md`
- changed: `mika/build.gradle.kts` (task + ordering only), `mika/README.md`, `README.md`, `NOTICE-Mika.md`
- not touched: `settings.gradle.kts`, `app/`, workflows, `mika-core/` — the modules are still not in `settings.gradle.kts` (step 5), so the build is as before and nothing runs the scripts yet.

## What the patch does (details and test table: `mika/README.md`, "Step 4")
1. `class MikaApp` -> `open class MikaApp`
2. Manifest: `<application>` attributes removed (8), MAIN + LAUNCHER filter of `MainActivity` removed; everything else untouched (step 7)
3. `mk_` prefix for 12 strings + `mipmap/ic_launcher` (XML, manifest, Kotlin `R.string.x` / `R.mipmap.x`); `android.R.*` never touched
4. "Mika" -> "Rizwan" in all string texts of 13 languages (URLs / github / package / style names kept)
5. `chat_greeting_*` -> "Hey Rizwan" in 13 languages
6. launcher / logo art replaced

## Decisions taken here (say if you want them different)
- All five time-of-day greetings become the same "Hey Rizwan" (Mika's header showed "Good morning" ... "Up late").
- Share-sheet filters (SEND / SEND_MULTIPLE) and the cleartext network config are left as upstream until step 7.
- Prompts / persona keep the name "Mika" for now: renaming what the model calls itself goes with the wake word in step 14.
- The notification small icon is still Mika's logo (white vector, status bar only).

## Not run
Gradle, a compile, CI, a device (no Android SDK / network here). If the first CI run fails in this step, send the lines starting at `patch-upstream:`.
Next: part 5 (Gradle wiring: `settings.gradle.kts`, `:app` dependency, `noCompress xz`, coroutines pin check).

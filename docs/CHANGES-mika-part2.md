# Mika (Rizwan) — part 2 of 15: module build files

Request: add Mika as a built-in **library** app called **Rizwan** (like PPSSPP / MAME / RetroArch, sources fetched at build time), keep all details, update the full flat zip. This turn: part 2 only.
New request in this turn: "Hey Rizwan" should be the voice wake word.

Steps (each ticked when done):
- [x] 1. Unpack the part 1 zip and the uploaded upstream (split zip `ezyZip.zip` + `.z01`-`.z04` = `Mika-main.zip`); read upstream's `build.gradle.kts` files, `libs.versions.toml`, manifest and source layout
- [x] 2. `mika-core/build.gradle.kts` (new): `:mika-core`, pure JVM
- [x] 3. `mika/build.gradle.kts` (new): `:mika`, Android library
- [x] 4. Root `build.gradle.kts`: plugin `org.jetbrains.kotlin.jvm` 2.2.10 `apply false`
- [x] 5. Checks: every path used by the build files exists in the upstream tree, brackets balanced, imports scanned for missing dependencies
- [x] 6. Docs: `mika/README.md` (plan, wake-word decision, "Step 2" section), root `README.md`, `NOTICE-Mika.md`, this file
- [x] 7. Full flat zip `RizwanS2-main-mika-step2.zip`

## Changed / new files
- new: `mika-core/build.gradle.kts`, `mika/build.gradle.kts`, `docs/CHANGES-mika-part2.md`
- changed: `build.gradle.kts` (one plugin line), `mika/README.md`, `README.md`, `NOTICE-Mika.md`
- not touched: `settings.gradle.kts`, `app/`, every manifest, every workflow. The two modules are **not** included in `settings.gradle.kts` (part 5), so Gradle does not read the new files and the build is as before.

## Decisions taken here (say if you want them different)
- Library minSdk **26**, not upstream's 29: no `tools:overrideLibrary` in `:app` (part 1 expected one); Android 10+ is checked at run time by `MikaLauncher.isSupported()` (part 8).
- `BuildConfig.APPLICATION_ID` = `com.srizwan.win11` (the host package), `VERSION_NAME` = 0.1.52, `VERSION_CODE` = 53, `GIT_HASH` = `7ff1703`.
- Compose BOM **alpha 2025.03.01**, the same as `:seal`: Gradle would take it anyway, and compiling against what runs avoids a run-time link error.
- Upstream's `core` tests, test fixtures, `chatgptCheck` source set, README generator, Go relay and Python CLI tests are not part of `:mika-core`.

## Wake word "Hey Rizwan"
Upstream Mika has no wake word (hold-to-talk, live speech recognition, in-app voice calls). It is recorded as the new **step 14** (final zip moves to 15). It needs an always-listening
keyword engine and a microphone foreground service, so the engine has to be chosen first (Vosk small model with a one-phrase grammar / Picovoice Porcupine / system recogniser loop). Until then "Hey Rizwan" is the assistant's name and greeting.

## Risks (details in `mika/README.md`)
Compose alpha vs stable Material 3, the project-wide coroutines pin 1.9.0 (upstream 1.10.2), protoc 4.36.2 not checked against Maven.

Not run: Gradle, CI, a device (no network / Android SDK; nothing was built or compiled).
Next: part 3 (`mika/tools/fetch-upstream.sh` + Gradle task `fetchMikaUpstream`).

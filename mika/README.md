# :mika / :mika-core — built-in "Rizwan" assistant (based on Mika)

Upstream: https://github.com/wangzan101/Mika, pinned in `UPSTREAM_VERSION` (**0.1.52**, versionCode 53) and `UPSTREAM_COMMIT`
(`7ff1703f63b7cbf5741a29345c1b4507802c6b06`). License: Apache-2.0, see `../NOTICE-Mika.md` and `../LICENSE-Mika`.

Goal: Mika as a **library** built-in app, like PPSSPP / MAME / RetroArch: the sources are **not** in the project zip, they are cloned at build time;
Start menu entry, Home icon and `rizwans2://rizwan` open it; the assistant is called **Rizwan** ("Hey Rizwan" greeting in the chat).

## Plan (15 steps)

| # | Part | Status |
|---|------|--------|
| 1 | Pin upstream, read the source, analysis, notices (this file) | done |
| 2 | `:mika-core` (JVM library) and `:mika` (Android library) module build files that point at `mika/upstream/` | done |
| 3 | `tools/fetch-upstream.sh` (shallow clone, commit check) + Gradle task `fetchMikaUpstream` | done |
| 4 | `tools/patch-upstream.sh` (library manifest, `MikaApp` open, `mk_` resources, Rizwan name + greeting + icon), idempotent | done |
| 5 | Gradle wiring (settings, `:app` dependency, `noCompress xz`, coroutines pin check); no `overrideLibrary` needed (library minSdk 26, see step 2) | done |
| 6 | `App : AppBase : MikaApp` with process guard (launcher process only), start only after first use, quit does not kill the launcher (patch edit 7) | done |
| 7 | Manifest merge into `:app` (permissions, services, providers, network config decision) + cut Mika's own self-update, language, backup text | done |
| 8 | Hooks: `MikaLauncher.kt`, Start menu, Home icon, `rizwans2://rizwan` (+ `targetSdk 37`) | done |
| 9 | CI: cache + fetch + patch + APK check in all workflows, `include_mika` switch + stub | done |
| 10 | `.gitignore` audit (`__pycache__` gap closed), `.gitattributes` (LF for `*.py` / `*.stub`), docs: `docs/CHANGES-mika.md`, Overview below, README | done |
| 11 | Licence files in the APK assets (upstream `licenses/` + `NOTICE` + PRoot patches, `RIZWAN-NOTICE.md`), `NOTICE-Mika.md` rewritten, CI APK check, patch edit 13, check 12 | done |
| 12 | README + `docs/CHANGES-mika*.md` refresh (docs only; read again after 13 and 14) | done |
| 13 | Static checks (XML, resource clashes, references, scripts, workflows) + `tools/static-check.py` | done |
| 14 | Wake word "Hey Rizwan" (Mika has none: design + engine decision first, see "Wake word" below) | dropped by you (not done) |
| 15 | Final flat zip `RizwanS2-main-mika-rizwan.zip` | todo |

## Overview (read this first; the rest of this file is the step-by-step log)

**What it is.** The built-in **Rizwan** assistant: Mika 0.1.52 (Apache-2.0) as the library modules `:mika` + `:mika-core`, package `com.wangzan101.mika` (upstream's package kept). The sources are fetched and patched at build time, not stored in the zip.
Mika keeps all 30 permissions; the project's versions win; "Hey Rizwan" is the name and greeting, the spoken wake word is step 14. **Nothing was run on a phone yet; the first CI build (your log, see "Build fix 1" at the end) compiled everything up to `:mika:compileReleaseKotlin` and failed there on 2 lines, now fixed.** One-file summary of everything: `../docs/CHANGES-mika.md`.

**Licences:** the APK carries `assets/licenses/` (Apache-2.0, GPL-2.0, GPL-3.0, LGPL-3.0, Mika's third-party notices and NOTICE, `RIZWAN-NOTICE.md`, the 4 PRoot patches and source locks): step 11, `../NOTICE-Mika.md`. Open points about the GPL source offer are listed there.

**Where it opens from:** Start menu **Rizwan**, Home icon, `rizwans2://rizwan` (alias `rizwans2://assistant`), the terminal theme's built-in list, the Android share sheet. Own task, own window in Recents; "Quit" does not close Win11.
Hidden on phones that are not Android 10+ on 64-bit ARM. Mika starts after a process restart only if Rizwan was opened once before.

**First use on a phone:** Start menu -> Rizwan -> Mika's own first-run screens (what they ask for is upstream's, not changed here; permissions are requested when a feature needs them) -> chat. The first start unpacks the 58 MB Linux sandbox in the background. Phone control needs one wireless-debugging pairing (Android 12+).

**Files**
| Where | What |
|-------|------|
| `mika/` | `build.gradle.kts` (`:mika`), `UPSTREAM_VERSION`, `UPSTREAM_COMMIT`, `rizwan/` (icon art, `licenses/RIZWAN-NOTICE.md`), `tools/` (`fetch-upstream.sh`, `patch-upstream.sh` + `.py`, `check-manifest.py`, `check-merged-manifest.py`, `static-check.py`, `stub/`), this file |
| `mika/upstream/` | the cloned + patched source (about 132 MB with `.git`): **not in the zip, git-ignored** |
| `mika-core/` | `build.gradle.kts` only (`:mika-core`, its sources are `mika/upstream/core/src/main`) |
| `app/.../AppBase.kt`, `MikaLauncher.kt` | new: `App : AppBase : MikaApp`, the hooks (the only two files of `:app` that name a Mika class) |
| `app/.../App.kt`, `StartApps.kt`, `Win11Shell.kt`, `MainActivity.kt`, `TerminalShare.kt` | edited: start after first use, Start menu entry, Home icon, deep link, terminal list |
| `app/build.gradle.kts`, `settings.gradle.kts`, `gradle.properties`, `build.gradle.kts`, `app/src/main/AndroidManifest.xml` | edited: dependency, `noCompress xz`, switches, `targetSdk 37`, Kotlin JVM plugin, comments |
| `.github/workflows/UltimateBuild.yml`, `UltimateBuild_NoWinlator.yml`, `UltimateBuild_WithoutMe.yml` | edited: cache, fetch + patch + checks, APK check, `include_mika` |
| `NOTICE-Mika.md`, `LICENSE-Mika` | new: notice, list of changes, Apache-2.0 text, GPL / LGPL parts and the licence files in the APK (step 11) |
| `docs/CHANGES-mika.md`, `docs/CHANGES-mika-part1.md` ... `part13.md` | new: overview and one file per part |

**Switches:** `-PincludeMika=false` (leaves the modules out; does not compile alone, use the "without" workflow or the two stubs), `-PappTargetSdk=28`, `MIKA_FORCE_PATCH=1`, `MIKA_REPO_URL`. Tasks: `./gradlew :mika:fetchMikaUpstream`, `:mika:patchMikaUpstream`.
Needs once per fresh clone: git (2.35+), python3, network (about 83 MB). By hand: `bash mika/tools/fetch-upstream.sh && bash mika/tools/patch-upstream.sh && python3 mika/tools/check-manifest.py`.

**CI (all three workflows, step 9):** cache of `mika/upstream` (patched copy), "Fetch and patch Mika source" (after the package rename), `check-manifest.py`, then in "Locate Unsigned APK" the native files / `rootfs.tar.xz` size / dex classes and `check-merged-manifest.py` on the merged manifest.
`UltimateBuild_WithoutMe.yml`: tick box `include_mika`.

**Moving to a newer Mika:** change `UPSTREAM_VERSION` and `UPSTREAM_COMMIT` together, run fetch + patch + check on a copy; the drift guard stops on a layout change (see `../docs/CHANGES-mika.md`, section 10).

**If the first CI run fails (most likely first):** the fetch step (`could not fetch commit`), `::error::patch-upstream` / `::error::check-manifest`, `:mika-core:generateProto` (protoc 4.36.2), the first compile of 837 Kotlin files (`:mika:compileReleaseKotlin`: Compose alpha, coroutines 1.9.0 pin, Kotlin 2.2), the manifest merge, then the APK check. Table: `../docs/CHANGES-mika.md`, section 9.

**What is not verified:** that anything compiles or runs; the real GitHub fetch; the APK size; targetSdk 37 behaviour; phone control inside the host app; CI run time. Tested on the real upstream: fetch (hand-placed), patch (identical trees on re-run), `check-manifest.py`, git-ignore audit.

## Step 1 findings (upstream 0.1.52, read here)

### Shape
- Two Gradle modules: **`:core`** = pure JVM Kotlin library (`kotlin.jvm`, 855 files; protobuf-lite generated from OpenTelemetry protos,
  `kotlinx.serialization`, okhttp, commons-compress) and **`:app`** = Android application (1,865 files; 1,410 Kotlin, Compose UI, AIDL
  `IMikaShell`, prebuilt `jniLibs/arm64-v8a`: `libmikarun.so`, `libproot.so`, `libproot_loader.so`; C source of `mikarun` in `cpp/mikarun`, not built by Gradle).
- Assets 58 MB (`assets/runtime/rootfs.tar.xz` = the Linux sandbox root file system, plus web / terminal / mcp / chat files), resources 8.8 MB
  (many `values-xx` languages). Whole upstream checkout is about 133 MB (docs 29 MB, eval, companions, plugins, tools are not needed to build).
- Single process (no `android:process`), 1 launcher activity, 1 accessibility service, 1 notification listener, 1 InCall service, foreground services,
  6 providers (4 file providers + `HelperHandoffProvider` + Shizuku provider), boot receiver.

### Version map (upstream -> this project)
| | Mika | Win11 |
|---|---|---|
| Kotlin | 2.1.20 | 2.2.10 |
| AGP | 8.7.3 | 8.13.2 |
| compileSdk / minSdk / targetSdk | 36 / **29** / 35 | 37 / **26** / **37** (part 8; it was 28 until step 7) |
| JDK | 17 | 21 |
| Compose | BOM 2024.12.01, compiler plugin | `:app` has Compose off; plugin declared (Seal) |
| coroutines | 1.10.2 | **pinned 1.9.0 for every module** (root `build.gradle.kts`) |
| protobuf | javalite 4.36.2, plugin 0.9.5 | plugin 0.9.6 (`:ppsspp`) |
| okhttp / serialization | 4.12.0 / 1.7.3 | to compare in step 5 |

### Decisions taken
1. **`:core` becomes `:mika-core`** (JVM library, Kotlin plugin `org.jetbrains.kotlin.jvm` 2.2.10 added to the root plugins) and **`:app` becomes `:mika`**
   (Android library). We write our **own** build files (like `:ppsspp`) and point `sourceSets` at `upstream/`; upstream's `core/build.gradle.kts` is not reused
   because it reads files from the repo root (`eval/`, `docs/`, `README.md`, `companions/`), runs README generators and Go / Python tests.
   The `knowledgeIndex` task (builds `knowledge/index.json` at build time, fails the build when a knowledge file is invalid) is kept.
2. **Package names stay upstream's** (`com.wangzan101.mika...`): 837 files in `app` import `com.wangzan101.mika.R` and `BuildConfig`. Only visible things change.
3. **`MikaApp` problem (most important).** `MikaApp` is a *final* `Application` subclass (761 lines) and 10 places do `context.applicationContext as MikaApp`
   (`CapsuleController`, `CapsuleInputOps`, `CapsuleTalkOps`, `SelfNotificationActivity`, `TerminalActivity`, ...). In a library the application is Win11's `App`, so
   those casts would crash. Fix (step 4 + 6): the patch makes `MikaApp` `open`; Win11's `App` extends `MikaApp`; `MikaApp.onCreate` is guarded so it only
   runs in the launcher process (Win11's `App` also runs in `:black`, `:p0`..., `:midlet`, `:mame`, `:retroarch`). Open question for step 6: the property initialisers of
   `MikaApp` run in every process too (not only `onCreate`), so read the first 640 lines before deciding if a guard is enough.
   **Answered in step 6:** the initialisers are cheap (see Step 6), so a guard around `onCreate` is enough.
4. **Library manifest.** The `<application>` attributes (`name`, `icon`, `label`, `theme`, `allowBackup`, `localeConfig`, `networkSecurityConfig`) must be removed: they would be
   merged into `:app`. Upstream's `network_security_config.xml` allows **cleartext http and user-installed CAs for the whole app**; this must not become global by accident
   (decide in step 7; local models on `http://192.168.x.x` need cleartext, `:app` with targetSdk 28 has none by default).
   The MAIN/LAUNCHER filter of `MainActivity` is removed (Win11 opens it from its own hooks). The SEND / SEND_MULTIPLE (`*/*`) filters would put Rizwan in every share sheet:
   decide in step 7.
5. **minSdk 29 vs 26.** `tools:overrideLibrary="com.wangzan101.mika"` in `:app`, and `MikaLauncher.isSupported()` = Android 10+ (phone control needs 12+; 14+ recommended,
   according to upstream's README), arm64 for the Linux sandbox.
6. **Resource clashes: only 13 of 4,398 names** clash with the other Win11 modules: `mipmap/ic_launcher` and strings `add`, `app_name`, `backup_export_failed`,
   `backup_import_failed`, `cancel`, `loading`, `more`, `reset`, `retry`, `save`, `search`, `show`. Since `:app` wins on a clash, they are renamed with `mk_` by the patch script
   (step 4) in XML and in `R.xxx.name` references, instead of prefixing all 4,398 names.
7. **APK size.** +58 MB assets (already compressed: `androidResources { noCompress += "xz" }` is needed in `:app`) + 3 small native files + 1,865 files of code / resources
   (Compose, ML Kit text recognition incl. Chinese, ZXing, Shizuku). `useLegacyPackaging = true` (needed by Mika's sandbox) is already set in `:app`.
8. **Fetch size.** Only `core/src/main`, `app/src/main`, `gradle/libs.versions.toml`, `licenses/`, `LICENSE`, `NOTICE` are needed: step 3 uses a shallow clone and deletes the rest.

### New permissions Mika adds to Win11 (13)
`ACCESS_COARSE_LOCATION`, `ACCESS_FINE_LOCATION`, `CALL_COMPANION_APP`, `FOREGROUND_SERVICE_SPECIAL_USE`, `MANAGE_ONGOING_CALLS`, `POST_PROMOTED_NOTIFICATIONS`,
`READ_CALENDAR`, `WRITE_CALENDAR`, `READ_MEDIA_IMAGES`, `READ_MEDIA_VISUAL_USER_SELECTED`, `REQUEST_INSTALL_PACKAGES`, `SCHEDULE_EXACT_ALARM`, `com.android.alarm.permission.SET_ALARM`.
(The other 17 are already declared by Win11.) These become permissions of the whole Win11 app; each is only requested at run time when Rizwan uses the matching feature.

### Other points to remember
- `${applicationId}` in the Mika manifest (provider authorities `.webfiles`, `.attachfiles`, `.reportfiles`, `.updatefiles`, `.helper`, `.shizuku`) becomes `com.srizwan.win11.*`;
  none of them clashes with an existing Win11 provider.
- Hard-coded intent action strings (`com.wangzan101.mika.task.START`, ...) are only strings and stay. `SystemIntents.OWN_PAGE_CLASS` (self-check page class) and the
  helper hand-off (`HelperHub.offer` checks caller uid, one-time token and the APK) must be checked in step 6 against the host's package name.
- Mika's own self-update (About page downloads a new APK and installs it over the app) must be cut out, like Seal's GitHub self-update (it would replace Win11 with Mika).
- The CI build must set the Git hash: upstream's `app/build.gradle.kts` runs `git rev-parse` for `BuildConfig.GIT_HASH`; here it is a constant from `UPSTREAM_COMMIT`.
- **Wake word (decision of the owner after step 1): "Hey Rizwan" is to be the voice wake word.** Upstream Mika has **no** wake word: its voice input is hold-to-talk
  (`voice/HoldToTalk.kt`), live speech recognition through a provider / the system recogniser, and in-app voice calls (`voicecall/`). A spoken wake word needs an
  always-listening keyword detector (microphone foreground service, battery, an offline engine and a keyword model for "Hey Rizwan"). That is new code, not a patch,
  so it is its own step 14, after the app runs: first the engine decision (options: Vosk small model with a one-phrase grammar, Apache-2.0; Picovoice Porcupine,
  needs an access key and a trained keyword; or the system `SpeechRecognizer` in a loop, which is simple but unreliable and noisy). Until then "Hey Rizwan" is the
  assistant's name and greeting only.

Not run here: Gradle, CI, a device (no network / Android SDK; nothing was built, no build file was touched).

## Step 2 (done): module build files

New files: `mika-core/build.gradle.kts` (`:mika-core`, pure JVM) and `mika/build.gradle.kts` (`:mika`, Android library). Root `build.gradle.kts`: plugin
`org.jetbrains.kotlin.jvm` 2.2.10 `apply false` added. **Not wired:** `settings.gradle.kts` is unchanged (part 5), so Gradle does not read the two files yet and the build is
exactly as before. Folder layout: `mika/` = `:mika` (build file, `UPSTREAM_*`, later `tools/`, `upstream/`), `mika-core/` = `:mika-core` (build file only; its sources are `mika/upstream/core/src/main/{kotlin,resources}`).

### `:mika-core` (JVM)
- Plugins: Kotlin JVM + serialization (2.2.10) + protobuf 0.9.6 (root). Sources / resources from `mika/upstream/core/src/main`; JVM target 21.
- Kept from upstream: protobuf-lite classes generated from the 4 OpenTelemetry protos (unpacked from the `opentelemetry-proto:1.11.1-alpha` jar), and the `knowledgeIndex`
  task (validates `knowledge/apps`, `knowledge/sites`, `skills` and generates `knowledge/index.json`; a bad file fails the build).
- Left out: tests and `java-test-fixtures`, the `chatgptCheck` source set, README generator, the Go relay / Python CLI tests (they read repo-root files and need Go / Python).
- Dependencies: protobuf-javalite 4.36.2 (protoc the same), okhttp 4.12.0, kotlinx-serialization-json 1.9.0, kotlinx-coroutines-core, commons-compress 1.28.0.
  Checked by scanning the imports of all core sources: no third-party package outside this list.

### `:mika` (Android library)
- Plugins: `com.android.library`, Kotlin android, Compose compiler, serialization. namespace `com.wangzan101.mika`, compileSdk 37, Java / Kotlin 21.
- Source sets point at `mika/upstream/app/src/main`: `java`, `res`, `assets` (58 MB), `aidl` (`IMikaShell`), `jniLibs` (3 prebuilt arm64 files) and the manifest
  (patched in place by step 4). `cpp/mikarun` and `baseline-prof.txt` are not used. `buildFeatures`: compose, aidl, buildConfig.
- **BuildConfig:** upstream's code reads `VERSION_NAME` (22 places), `VERSION_CODE` (1), `APPLICATION_ID` (2), `GIT_HASH` (5), `BETA` (3), `ADB_LOGS` (1). A library
  does not generate the first three, so they are defined: `VERSION_NAME` = `UPSTREAM_VERSION`, `GIT_HASH` = first 7 characters of `UPSTREAM_COMMIT` (no `git rev-parse`),
  `VERSION_CODE` = 53, and `APPLICATION_ID` = **`com.srizwan.win11`** (the host package: the code runs inside the host app, and `ShizukuShellUserService` compares it with
  `context.packageName`). `BETA` true, `ADB_LOGS` false as in upstream's release build.
- **minSdk 26 (changes the part 1 plan):** part 1 expected `tools:overrideLibrary` for upstream's minSdk 29. With the library at 26 like every other Win11 module the manifest merge
  needs no override; the Android 10+ limit is enforced at run time by `MikaLauncher.isSupported()` (step 8). Nothing in the compile depends on minSdk (lint only warns).
- **Versions (project wins, as decided):** Kotlin 2.2.10 / AGP 8.13.2 / JDK 21 / compileSdk 37 (upstream 2.1.20 / 8.7.3 / 17 / 36); Compose BOM alpha 2025.03.01 = the same BOM as `:seal`
  (upstream 2024.12.01); activity-compose 1.10.1 (1.9.3); kotlinx-serialization 1.9.0 (1.7.3); okhttp 4.12.0 (same); protobuf-javalite 4.36.2 (same). Window 1.3.0, webkit 1.12.1, xz 1.10,
  commonmark 0.30.1, ML Kit text recognition (+ Chinese) 16.0.1, ZXing 3.5.3, Shizuku 13.1.5 are upstream's.
- Not set here because AGP ignores it in a library: `useLegacyPackaging` (already in `:app`) and `androidResources { noCompress += "xz" }` (step 5, `:app`).

### Risks found while doing it (for the first CI compile, send the first error lines)
1. **Compose alpha vs stable.** The build runs on Compose BOM alpha 2025.03.01 (material3 1.4 alpha) because `:seal` already puts the app on it and Gradle takes the highest version; upstream
   was written against 2024.12.01 (material3 1.3.x). If some Material 3 API changed between the two, `:mika:compileDebugKotlin` will show it.
2. **Coroutines pin.** The root build file forces `kotlinx-coroutines-*` to 1.9.0 for every module; upstream uses 1.10.2. Only matters if Mika calls an API added in 1.10.
3. **protoc 4.36.2** is taken from upstream's version catalog and could not be checked against Maven here (no network). If `:mika-core:generateProto` cannot find it, the version is the first thing to check.
4. Nothing was compiled: no Gradle, Android SDK or network here. The build files were checked for balanced brackets and every path they use was checked against the uploaded upstream tree.

## Step 3 (done): fetch script + `fetchMikaUpstream`

New: `mika/tools/fetch-upstream.sh` (executable). Changed: `mika/build.gradle.kts` (task `fetchMikaUpstream`, ordering), `mika-core/build.gradle.kts` (ordering). Still not wired into `settings.gradle.kts` (part 5), so nothing runs it yet.

### What the script does
1. Reads `UPSTREAM_VERSION` (must look like `0.1.52`) and `UPSTREAM_COMMIT` (exactly one 40-character hash; `#` comment lines allowed); anything else stops with an error.
2. **Already there:** if `mika/upstream/.git` exists and `HEAD` equals the pinned commit and all required files exist, it does nothing (so a patched checkout is left alone: the patch script of part 4 is idempotent anyway).
3. **Hand-placed (offline):** if `mika/upstream/` has the upstream files but no `.git` (for example the uploaded `Mika-main.zip` unpacked there, **without** the `Mika-main/` wrapper folder), it is used as it is with a warning. The commit cannot be checked then,
   so `versionName` in `app/build.gradle.kts` is compared with `UPSTREAM_VERSION` and a different version is refused.
4. **Fetch:** `git init` + `git fetch --depth 1 --filter=blob:none origin <commit>` (GitHub serves a commit by hash), then a sparse checkout of only what the build needs: `core/src/main`, `app/src/main`, `gradle/libs.versions.toml`, the three small
   build files (version check), `licenses/`, `LICENSE`, `NOTICE`. Docs (29 MB), `eval/`, `companions/`, `plugins/`, `tools/` are not checked out (about 83 MB of the 133 MB repo are kept). 3 tries with a pause.
5. `HEAD` must equal the pinned commit (else the folder is deleted and the build stops), the version text must match, and 15 required paths must exist (`MikaApp.kt`, `rootfs.tar.xz`, the 3 `jniLibs` files, `licenses/THIRD_PARTY_NOTICES.md` ...): a different layout means a version bump needs a review.
6. It patches nothing. `MIKA_REPO_URL` overrides the repository URL (a mirror, or a local path for tests).

### Gradle
- `:mika:fetchMikaUpstream` (`Exec`, `bash tools/fetch-upstream.sh`, group `mika`). `:mika`: `preBuild` and every task whose name ends in `Assets`, `Resources`, `JniLibFolders`, `Manifest`, `Aidl`, `BuildConfig` or `Annotations` (and starts with merge / package / process / compile / generate / parse / extract) depend on it.
  `:mika-core`: `compileKotlin`, `processResources` and `knowledgeIndex` depend on `:mika:fetchMikaUpstream`.
- Run alone: `./gradlew :mika:fetchMikaUpstream` (after part 5) or `bash mika/tools/fetch-upstream.sh` (now).

### Tested here (local git repository made from the uploaded upstream, file:// URL, bash 5 / git 2.43)
| Case | Result |
|---|---|
| fresh fetch (commit, version, layout) | ready, exit 0; working tree has `core`, `app`, `gradle`, `licenses`, `LICENSE`, `NOTICE`, 3 build files |
| run again | "already present", exit 0, nothing fetched |
| commit that does not exist | 3 tries, folder deleted, exit 1 |
| hand-placed folder, right version | accepted with a warning, exit 0 |
| hand-placed folder, other version | refused, exit 1 |
| malformed `UPSTREAM_COMMIT` | refused, exit 1 |
Also: `bash -n` OK; the real pin `7ff1703f...` equals the comment stored in the uploaded `Mika-main.zip` (GitHub writes the commit there) and its `versionName` is `0.1.52`.

### Not tested
The real GitHub download (no network here): that GitHub serves `git fetch --depth 1 origin <sha>` and the `blob:none` filter is standard behaviour but was not run against github.com. If the first CI run fails in this step, send the log lines starting at "git fetch failed".
The sparse checkout needs git 2.35+ (GitHub's Ubuntu runners have 2.4x).

## Step 4 (done): patch script `tools/patch-upstream.sh`

New: `mika/tools/patch-upstream.sh` (wrapper, executable), `mika/tools/patch-upstream.py` (the work), `mika/rizwan/drawable-nodpi/mika_launcher_art.png` (Rizwan icon art, 1254 x 1254).
Changed: `mika/build.gradle.kts` (task `patchMikaUpstream`, runs after `fetchMikaUpstream`, before everything that reads the checkout). `:mika-core` is not patched (the patch touches the app side only), so it keeps waiting for the fetch only.
Still not wired into `settings.gradle.kts` (step 5). Run it alone: `bash mika/tools/patch-upstream.sh` (now) or `./gradlew :mika:patchMikaUpstream` (after step 5). Needs bash + python3.

### What it changes (inside `mika/upstream/app/src/main`, never in the project zip)
| # | Edit | Detail |
|---|------|--------|
| 1 | `MikaApp.kt` | `class MikaApp` becomes `open class MikaApp`, so Win11's `App` can extend it (step 6). The 10 `applicationContext as MikaApp` casts then keep working. |
| 2 | `AndroidManifest.xml` | the 8 attributes of `<application>` are removed (`name`, `allowBackup`, `icon`, `supportsRtl`, `label`, `localeConfig`, `networkSecurityConfig`, `theme`): in a library they would be merged into `:app` and replace its own. The MAIN + LAUNCHER filter of `MainActivity` is removed (the `<queries>` entry for launchers stays). Permissions, services, providers, receivers and the SEND / SEND_MULTIPLE filters are **not touched**: step 7 decides. |
| 3 | 13 clashing names | `mk_` prefix: 12 strings (`add`, `app_name`, `backup_export_failed`, `backup_import_failed`, `cancel`, `loading`, `more`, `reset`, `retry`, `save`, `search`, `show`) in all 13 language folders, plus `mipmap/ic_launcher` (file). Rewritten: `<string name>`, `@string/x`, `@mipmap/x` in XML and manifest, `R.string.x` / `R.mipmap.x` in Kotlin / Java (also `com.wangzan101.mika.R...`). `android.R.string.x` is never touched. About 207 edits. |
| 4 | visible name | "Mika" becomes "Rizwan" in the text of all strings of all 13 languages (589 files). Not touched: URLs, anything with `github.com` / `wangzan101`, resource names, style names (`themes.xml` is skipped), package names. Latin "Mika" is kept in every language, as upstream does. |
| 5 | greeting | the five `chat_greeting_*` strings (time-of-day greeting at the top of a new chat) become **"Hey Rizwan"** in all 13 languages. |
| 6 | icon | `drawable-nodpi/mika_launcher_art.png` (also the Logo, the welcome and About screens and the share card) is replaced by the Rizwan art (a white "R" on a blue-cyan rounded square, inside the adaptive-icon safe zone). |

### Safety
- **Idempotent.** Every edit finds nothing left on a second run. A marker `mika/upstream/.rizwan-patched` holds the hash of the script and icon: the same hash means "already patched" (`MIKA_FORCE_PATCH=1` runs it anyway, the result is byte-identical). A run that stopped half way is simply run again.
- **Drift guard.** On a new upstream version, a missing clashing name or an `<application>` / `MikaApp` that looks different stops the build with `::error::patch-upstream: ...` instead of a silent half patch.
- **Self-check at the end:** manifest parses and has no application attributes or launcher filter; `MikaApp` is open; no un-prefixed clashing resource in XML, Kotlin or Java; no string still says "Mika" (except URL / github tokens).

### Tested here (on a copy of the uploaded upstream `app/src/main` + `core/src/main`, version 0.1.52)
| Case | Result |
|---|---|
| first run | MikaApp 1, manifest 1, `mk_` edits 207, name 589 files, greeting 13 files, icon 1; self-check OK |
| second run | "already patched" |
| marker deleted, run again | 0 changes, tree hash identical to the first run |
| all 999 XML files + manifest | well-formed; every `R.string.mk_*` used in Kotlin has a definition |
| `mk_` prefix in the other Win11 modules | no clash |
Not run: Gradle, a compile, CI, a device (no Android SDK / network here). `bash -n` and `py_compile` OK.

### Left for later steps (not a bug)
- Prompts and skills in `core/src/main/resources` still say "You are Mika": the persona name is part of step 14 (wake word "Hey Rizwan"), because it changes what the model calls itself and the knowledge files are validated at build time.
- The notification small icon (`ic_notification`, Mika's two-square logo) and the Chinese project texts in comments are unchanged.
- Network config (cleartext + user CAs) and the share-sheet filters: step 7.

## Step 5 (done): Gradle wiring

Changed: `settings.gradle.kts` (`include(":mika-core")`, `include(":mika")`), `app/build.gradle.kts` (`implementation(project(":mika"))`, `androidResources { noCompress += "xz" }`),
`mika-core/build.gradle.kts` (the protobuf `lite` option, see below), `gradle.properties` (comment of the new switch), header notes of both Mika build files. Nothing else (no `App`, manifest, workflow or Kotlin file of `:app`).

### What changed
| File | Change |
|---|---|
| `settings.gradle.kts` | `:mika-core` and `:mika` are included. Switch: `-PincludeMika=false` (or `includeMika=false` in `gradle.properties`) leaves both out. Default: included. |
| `app/build.gradle.kts` | `implementation(project(":mika"))` (same switch). `androidResources { noCompress += "xz" }`: `assets/runtime/rootfs.tar.xz` (50+ MB, already xz) stays stored; AGP counts this setting in the application module only. `useLegacyPackaging = true` (the sandbox runs `libmikarun.so` / `libproot.so` from `nativeLibraryDir`) and `pickFirsts libc++_shared.so` were already there. |
| `mika-core/build.gradle.kts` | `builtins { named("java") { option("lite") } }` became `builtins { maybeCreate("java").option("lite") }`. `:ppsspp` has to `create("java")` in an Android module; whether the plugin has already made the builtin depends on the project type, and `maybeCreate` is right in both cases. |

### Version check (what Gradle will resolve; the highest version of each library wins)
| Library | Mika | other modules | Result |
|---|---|---|---|
| protobuf-javalite | 4.36.2 | `:ppsspp` 4.33.5 | 4.36.2 (same major; `:ppsspp`'s `protoc` 3.25.3 gencode is unchanged) |
| kotlinx-coroutines | 1.9.0 declared (upstream 1.10.2) | root pin 1.9.0 for every module | 1.9.0 (**check**, see risks) |
| kotlinx-serialization-json | 1.9.0 | `:seal` 1.9.0 | 1.9.0 |
| okhttp | 4.12.0 | `:tui` / `:youtube` / `:seal` 4.12.0 | 4.12.0 |
| org.tukaani:xz | 1.10 | `:winlator` 1.12 | 1.12 (API compatible) |
| commons-compress (mika-core) | 1.28.0 | `:winlator` 1.28.0 | 1.28.0 |
| androidx.webkit | 1.12.1 | `:app` 1.11.0 | 1.12.1 (the app's calls exist in both) |
| activity-compose | 1.10.1 | `:seal` 1.10.1 | 1.10.1 |
| Compose BOM alpha | 2025.03.01 | `:seal` / `:seal-color` same | same |
| Kotlin stdlib | - | root pin 2.2.10 | 2.2.10 |
New in the build (no other module has them): androidx.window 1.3.0, commonmark 0.30.1 (+ tables, strikethrough), ML Kit text recognition 16.0.1 (+ Chinese), ZXing core 3.5.3, Shizuku api + provider 13.1.5, protobuf-javalite as a direct dependency of an Android module besides `:ppsspp`.
`android.nonTransitiveRClass=false` (project-wide) means `com.wangzan101.mika.R` is a superset of upstream's (which used the AGP default, non-transitive): harmless, the resources of `:mika` itself are unchanged.

### Checked here
- Brackets balanced in the 4 changed Gradle files; every source path of `:mika` / `:mika-core` exists in the patched checkout (`app/src/main/{AndroidManifest.xml,java,res,assets,aidl,jniLibs}`, `core/src/main/{kotlin,resources}`).
- Every `BuildConfig.X` that Mika's code reads is defined: `ADB_LOGS`, `APPLICATION_ID`, `BETA`, `GIT_HASH`, `VERSION_CODE`, `VERSION_NAME` by `mika/build.gradle.kts`; `DEBUG` and `BUILD_TYPE` are generated by AGP.
- Import scan of Mika's 1,410 Kotlin files: no third-party package outside the dependency list of `mika/build.gradle.kts` (the rest comes in transitively, as upstream).
- Order of tasks: `:mika:fetchMikaUpstream` -> `:mika:patchMikaUpstream` -> everything that reads the checkout of `:mika`; `:mika-core` waits for the fetch only.

### What this means for the build from now on
1. **Every build** (local and CI, both workflows, even before step 9) runs the fetch (git + network, about 83 MB, once per fresh clone) and the patch (python3); the workflows themselves are unchanged until step 9 (cache, commit check, APK check, `include_mika` switch).
2. The APK grows by about 58 MB of assets + 3 small native files + Mika's code and libraries (ML Kit with the Chinese model, Compose pieces). Not measured here. `-PapkAbis=arm64-v8a,...` (existing switch) still thins out the other libraries.
3. **Nothing starts Mika yet.** `App : MikaApp()` (6), the manifest merge decisions (7) and the Start menu / Home / `rizwans2://rizwan` hooks (8) come next. Until step 6 the merged manifest contains Mika's components, but no Win11 code calls them.
4. Manifest merge: Mika's manifest is now a library manifest. The only likely clash is components that two libraries declare (`rikka.shizuku.ShizukuProvider`): identical values, so no error is expected; a real conflict would be reported by `:app:processDebugMainManifest` and fixed in step 7.

### Risks, in the order they can show up in the first CI run (send the first error lines)
1. `:mika:fetchMikaUpstream` / `patchMikaUpstream` (network, git >= 2.35, python3): log lines start with `Mika` / `git fetch failed` / `patch-upstream:`.
2. `:mika-core:generateProto` (protoc 4.36.2 and `opentelemetry-proto:1.11.1-alpha` could not be checked on Maven here), then `:mika-core:knowledgeIndex`.
3. `:mika:compileDebugKotlin`: Compose alpha vs stable (material3 1.4 alpha instead of 1.3.x), and **coroutines 1.9.0 instead of 1.10.2** (the root pin cannot be lowered for Mika alone; if a 1.10-only API is used, the project pin goes to 1.10.2 and the other modules are checked).
4. `:app:processDebugMainManifest` (merge, see 4 above), `:app:mergeDebugAssets` / `packageDebug` (duplicate files between the assets of `:mika` and other modules: `assets/licenses`, `assets/web`, `assets/terminal` are Mika's folder names; a clash would be reported by name).
5. D8 / R8: Mika's classes and kotlin metadata with the project's stdlib pin 2.2.10.
Nothing was compiled or run here (no Gradle, Android SDK, network).

## Step 6 (done): `App` extends `MikaApp`, process guard

Changed: `mika/tools/patch-upstream.py` (new edit 7), `app/src/main/kotlin/com/srizwan/win11/App.kt`, `gradle.properties` (comment). New: `app/src/main/kotlin/com/srizwan/win11/AppBase.kt`,
`mika/tools/stub/AppBase.kt.stub` (the "without Mika" replacement, used by step 9). Nothing else (no manifest, no workflow, no Gradle file).

### What was read first (all 761 lines of `MikaApp.kt`, `MikaQuit.kt`, the helper hand-off, `OWN_PAGE_CLASS`)
- **Property initialisers are cheap.** The only non-lazy members are `scope`, `resources` (`ResourceScheduler`), `sandboxTree`, `tasks`, `taskState`, `foreground`, `selfUi`: plain in-memory objects without a Context, IO or thread
  (everything else is `by lazy`). So they may run in every Win11 process (":black", ":p0", ":midlet", ":mame", ":retroarch"); only the body of `onCreate` has to be kept out of them.
  `onCreate` is the heavy part: legacy-voice migration, the floating capsule, the phone-helper watcher, recovery of unfinished runs, the proactive listener, MCP / WeChat links, **`RuntimePreparer.ensure` (unpacks the 58 MB Linux sandbox)**.
- **`MikaQuit` ("Quit Mika": capsule, Settings, backup import) ends with `Process.killProcess(myPid())` and `NotificationManager.cancelAll()`.** In a library that is the Win11 launcher and every notification of the whole app. Found only by reading, no compiler would say it.
- Host-package checks are runtime lookups (`ShellService.startOwnPage` compares with the packages of the allowed uid, `SelfCheckTargetActivity` uses `context.packageName`, `ShizukuShellUserService` uses `APPLICATION_ID` = the host): no change needed, they already mean `com.srizwan.win11`.

### Design
| Piece | What it does |
|---|---|
| patch edit 7 (`MikaApp.kt`) | `onCreate() { super.onCreate(); if (startOnCreate()) startMika() }`; `protected open fun startOnCreate() = true` (upstream behaviour); public `fun startMika()` = the original body, **idempotent** (`AtomicBoolean`) and **main thread** (a call from another thread is posted); `val isMikaStarted`; `open fun onQuitExit()` (default = the old process kill). |
| patch edit 7 (`MikaQuit.kt`) | no more `cancelAll()` (two places), the delayed exit calls `app.onQuitExit()` instead of killing the process. |
| `AppBase` (`:app`) | `abstract class AppBase : MikaApp()`. `startOnCreate()` = false (Mika never starts by itself), `onQuitExit()` = nothing (**Win11 stays alive**), `startMikaIfUsed()`, `startMikaNow()`, `isMikaSupported()` (Android 10+ and arm64-v8a). |
| `App` (`:app`) | `class App : AppBase()`. `startMikaIfUsed()` is the last call of `onCreate`, after BlackBox, logging, theme, terminal, Winlator bridge and Seal; wrapped in `try/catch` (a Mika failure is only logged). |

### The process guard, exactly
1. `MikaApp.onCreate` starts nothing (it only asks `startOnCreate()`, which says false), so the ":black", ":p0" ..., ":midlet", ":mame", ":retroarch" processes never run Mika code (they also `return` earlier in `App.onCreate`).
2. In the **launcher process** `App.onCreate` calls `startMikaIfUsed()` at its very end (it is only reached when `isLauncherProcess()` is true).
3. `startMikaIfUsed()` starts Mika **only if Rizwan was opened before on this phone** (preference `win11_rizwan_state` / `mika_used`, set by `startMikaNow()`) and the phone is supported. **This is a decision I took** (say if you want it different):
   a user who never opens Rizwan would otherwise pay at every launch for the sandbox unpack (58 MB of assets, in the background), the capsule, the helper watcher and the recovery code. To get "always on", `startMikaIfUsed()` only has to drop the `wasMikaUsed` test.
4. First use: the hooks of step 8 call `(application as AppBase).startMikaNow()` on the main thread before they open Rizwan's screen (flag set, Mika started; returns false on an unsupported phone, where the hook shows a short message).

### Quit behaviour in the host
"Quit Mika" now stops Mika's own services, hides the capsule and sets Mika's quit flag (all as upstream), then calls `onQuitExit()`, which does nothing: **Win11 keeps running**, and its own notifications are untouched.
Opening Rizwan again clears the quit flag (`MikaQuit.resume`, upstream). Mika's task notifications that were already posted stay until dismissed (upstream cleared everything).

### Tested here
| Case | Result |
|---|---|
| patch on a copy of the real upstream (`app/src/main`), first run | MikaApp open 1, manifest 1, `mk_` edits 207, name 589 files, greeting 13, icon 1, **host hooks 2 files**; self-check OK |
| second run | "already patched" |
| forced re-run (`MIKA_FORCE_PATCH=1`) | 0 changes, tree hash identical |
| result read by eye | `MikaApp.kt` has exactly one `onCreate`, `startMika()` starts with the original first comment line, no `return` left inside the old body; `MikaQuit.kt` has no `cancelAll(` / `killProcess(` |
| `App.kt` diff against step 5 | only the import, the class line, the doc comment and the new block; **the Seal block and the two J2ME lines that `UltimateBuild_WithoutMe.yml` edits by regex are byte-identical** |
| name clashes `App` / `AppBase` against `MikaApp` | none (`isMidletProcess`, `isMameProcess`, `isRetroarchProcess`, `currentProcessName`, `isLauncherProcess` do not exist in `MikaApp`) |
Not run: Gradle, a compile, CI, a device (no Android SDK / network here). `py_compile` OK.

### Risks in the order they can show up (send the first error lines)
1. `:mika:compileDebugKotlin` is still the first big test (see Step 5 risks); the edit-7 code is small and uses only `android.os.*` and `java.util.concurrent`.
2. `:app:compileDebugKotlin`: `AppBase` / `App` must see `MikaApp.startMika()` (public), `startOnCreate()` (protected, overridden `final override`), `onQuitExit()` (public open). If an "accidental override" error mentions `getResources` it comes from `MikaApp.resources` (a `ResourceScheduler`) next to `Context.getResources()`: upstream compiles with it, but `App` is a new subclass, so look here first.
3. At run time: opening Rizwan before step 8 exists is impossible (no hook yet), so nothing starts Mika until then; `startMikaIfUsed()` is a no-op for everyone.
4. **`-PincludeMika=false` does not compile from this step on** (`AppBase` needs `:mika`). Step 9 puts `mika/tools/stub/AppBase.kt.stub` in place of `AppBase.kt` in the CI "without" build (and in the Gradle switch if wanted).

### Carried forward (found while reading, not done here)
- **Mika's self-update** (About page, `automaticUpdates`, started from Mika's `MainActivity`, line 307) downloads and installs Mika's own APK. Must be cut out like Seal's (step 7, as a patch edit), else Rizwan would offer a separate "com.wangzan101.mika" install.
- **Backup import** ends with a dialog "close the app" that calls `MikaQuit.quit`; the process is not killed any more, so restored data is only fully used after Win11 is closed and opened again by hand. The dialog text should say so (step 7 / 12).
- Remaining items of the earlier list: network config and share-sheet filters (7), notification small icon, persona prompts (14).

## Step 7 (done): manifest merge, self-update, language, backup text

Changed: `mika/tools/patch-upstream.py` (edits 8 to 11, new checks), `app/src/main/AndroidManifest.xml` (comment block only), `mika/README.md`, `README.md`, `NOTICE-Mika.md`.
New: `mika/tools/check-manifest.py`, `docs/CHANGES-mika-part7.md`. Not touched: any Gradle file, any workflow, any Kotlin file of `:app`.

### What was read first
Upstream `AndroidManifest.xml` (428 lines), `network_security_config.xml`, `AppLanguage.kt`, `UpdateChecker.kt`, `MikaApp.kt` (update members), `MainActivity.kt` (update calls), `BackupScreen.kt` and `strings_backup.xml` of the 13 languages, and the whole `:app` manifest (307 lines) with the manifests of the other library modules (provider authorities, task / process attributes).

### What the merge does by itself (nothing to patch)
- **Permissions:** the 30 `uses-permission` entries of Mika are merged into the app; 17 were already declared, **13 are new** (coarse / fine location, calendar read / write, exact alarms, alarm clock, install packages, media images + selected photos, promoted notifications, call companion, ongoing calls, special-use foreground services).
  **None is removed** (the owner's rule): `KEEP_PERMISSIONS` in the patch script is checked by the patch (`check()`) and by `check-manifest.py`. `READ_EXTERNAL_STORAGE` is declared by `:app` without `maxSdkVersion` and by Mika with 32: the app's declaration wins (stays without limit).
- 7 activities, 11 services, 6 providers, 7 receivers, `<queries>` and the 5 `<uses-feature required="false">` entries. No class name and no provider authority clashes with `:app` or the other libraries (65 authorities checked, `${applicationId}` = `com.srizwan.win11`).
  Mika's accessibility service and `PowerService` of Win11 are two separate entries in Android's accessibility list ("Rizwan" and "Win11 Power and Lock"); the same for the notification listeners (Mika's is disabled until its proactive feature is used).

### Edits 8 to 12 of the patch script
| Edit | What | Why (found by reading) |
|---|---|---|
| 8 `AppLanguage.kt` | `systemManaged` = false (Android 13's `LocaleManager` never used), `keepHostLocale` = true (`applyDefaultLocale` never calls `Locale.setDefault`) | Upstream's language switch sets the **application locales of the whole process** on Android 13+ and the default `Locale` below: picking Arabic in Rizwan would have turned the Win11 launcher right-to-left. Now Mika's own screens are wrapped with the chosen language (upstream's code for Android 11 / 12, used on every version) and nothing else changes. Side effect: Android's per-app language page for Win11 does not show Rizwan's language. |
| 9 `UpdateChecker.kt` | `check()` returns at once (a manual check ends as "up to date") | **Self-update cut.** Upstream downloads and installs its own APK (`com.wangzan101.mika`), a separate app and not an update of Win11. With no release ever found, `AutomaticUpdates`, `ApkUpdater`, the update capsule and the install flow are never reached. The About page still shows "check for updates" and the mirror settings (harmless). `REQUEST_INSTALL_PACKAGES` and `UpdateFilesProvider` stay (permission rule). |
| 10 `strings_backup.xml` x13 | `backup_after_import_body` | The button "Close Rizwan" no longer ends the process (step 6), so the data restored by a backup import is fully used only after Win11 is closed from Recents. The text now says so, in all 13 languages (a new upstream language fails the patch until it is added to `BACKUP_BODY`). |
| 11 manifest | `MainActivity`, `FileViewerActivity`, `TerminalActivity`, `WebTakeoverActivity` get `label` `@string/mk_app_name` and `icon` `@mipmap/mk_ic_launcher`; the first three get `taskAffinity` `${applicationId}.rizwan` | Without a label an activity shows the **app's** label: Recents and the share sheet would say "RizwanS2" with Win11's icon. Without its own affinity, `singleTask` + the default affinity would stack Rizwan's screens on the launcher's task and a `singleTask` restart could clear things above the launcher. |
| 12 `MainActivity.kt` | `(application as MikaApp).startMika()` right after `super.onCreate` | Mika's start is now the host's decision (step 6). A start that does not come from the Win11 hooks (share sheet entry, Quick Settings tile preferences) would run Mika's screen on a process where Mika never started. `startMika()` is idempotent and main-thread, so the hooks of step 8 and this call never double-start. |

### Decisions taken here (say if you want them different)
- **Network security config stays out.** Cleartext http is already allowed app-wide by `:app` (`usesCleartextTraffic`), so local model servers on `http://192.168.x.x` work. Upstream also trusts **user-installed CAs**; adding that to the manifest of the whole app would widen trust for the browser, the downloader and everything else in Win11, so Mika uses system CAs only. A company-CA model server will fail the TLS check; to allow it, add `android:networkSecurityConfig` to `:app` (not done).
- **Share filters kept.** Rizwan is in the share sheet as "Rizwan" with its own icon and task (text, links, files go into its chat draft). To drop it, delete the two SEND filters in a new patch edit.
- **Own task, not `singleInstance`/own process.** Mika's services and `MikaApp` state live in the launcher process (part 6), so no `android:process`; only the task is separate.
- Mika's `localeConfig` is not merged (the app does not publish per-app languages).

### Tested here (copy of the real upstream `app/src/main`, 0.1.52)
| Case | Result |
|---|---|
| patch on a fresh copy | edits 1 to 12 done: language 1, self-update 1, backup text 13 files, manifest 1, MainActivity 1; self-check OK |
| patch on a copy already patched by the step-6 script (the real step-6 script was run first) | only edits 8 to 12 apply (1, 1, 13, 1, 1) |
| second run / forced re-run (`MIKA_FORCE_PATCH=1`) | "already patched" / 0 changes; tree hash identical to the other two |
| the three trees (fresh, fresh + forced re-run, step-6 script + new script) | identical hash |
| 13 backup XML files | well-formed; host manifest well-formed |
| `check-manifest.py` | OK: 30 permissions (17 + 13 new), 7 activities, 11 services, 6 providers, 7 receivers, 65 authorities, all classes and resources found |
| `check-manifest.py` negative cases | missing permission, launcher filter back, own-task attribute lost, duplicate authority, unknown service class: each reported (exit 1) |
Not run: Gradle, a compile, CI, a device (no Android SDK / network here). `py_compile` OK.

### Risks in the order they can show up (send the first error lines)
1. `:mika:compileDebugKotlin`: the new Kotlin lines are tiny (`private val ... get() = true`, an early `return` in a `suspend fun`, `_state.update`); a "unused import" warning (`Build`, `LocaleManager`) is expected and harmless.
2. `:app:processDebugManifest`: merge errors would mention a `tools:replace` hint; the static check found none, but AGP is the real judge (`${applicationId}` in `taskAffinity` is a standard placeholder).
3. **targetSdk (host) vs Mika's 35** (the host's was 28 until step 7, it is 37 from part 8, so this risk is now smaller; see Step 8): foreground-service types, `POST_NOTIFICATIONS`, `READ_MEDIA_IMAGES`, overlay and exact-alarm behaviour follow the host's target; the phone-control helper (wireless debugging) can only be judged on a real phone.
4. Android 13+ language: the wrapped context covers Mika's activities and overlay; texts read through `AppLanguage.resources()` follow the chosen language too; anything Mika draws through the host's context would follow the system language (not a crash).
5. The share sheet shows "Rizwan" even before Rizwan was ever opened; that path now starts Mika itself (edit 12). On a phone that is not supported (Android 9 or older, or no arm64) the entry is still there and Mika's screen will fail: `MikaLauncher.isSupported()` guards only the Win11 hooks (a hidden-share-entry for unsupported phones would be a new edit).

### Carried forward
Notification small icon, persona / prompts that still say "Mika" (step 14, with the wake word), ~~hooks (step 8)~~ (done), CI (step 9).


## Step 8 (done): hooks (Start menu, Home icon, `rizwans2://rizwan`) and `targetSdk 37`

Request: Rizwan as a built-in **library** app like PPSSPP / MAME / RetroArch, keep every detail, **`targetSdk 37`** (owner decision in this turn), part 8 only.
Changed: `app/.../StartApps.kt`, `Win11Shell.kt`, `MainActivity.kt`, `TerminalShare.kt`, `app/src/main/AndroidManifest.xml` (comment only), `app/build.gradle.kts`, `build.gradle.kts`, `gradle.properties`,
`settings.gradle.kts` (comments), `mika/tools/check-manifest.py` (checks 9 to 11), the comments listed in `docs/CHANGES-mika-part8.md`. New: `app/.../MikaLauncher.kt`, `mika/tools/stub/MikaLauncher.kt.stub`, `docs/CHANGES-mika-part8.md`.
Not touched: the patch script, any workflow, any other module's code.

### What opens Rizwan, and how
| Hook | Where | What it does |
|---|---|---|
| Start menu entry **Rizwan** | `StartApps.kt` (`builtin.rizwan`, section `rizwan`), only when `MikaLauncher.isSupported()` | Same list, pin, recent, hide and "All apps" number as every other built-in app (the number deep link counts it). Vector icon: a large four-point sparkle with a small one, violet `#B185FF`. Mika's own logo is not used (Apache-2.0 section 6, `NOTICE-Mika.md`). |
| Home screen icon **Rizwan** | `Win11Shell.kt` (`VectorIconView.RIZWAN`, after RetroArch), same `isSupported()` test | tap = the section callback of `MainActivity` |
| `rizwans2://rizwan` (alias `rizwans2://assistant`) | `MainActivity.handleDeepLink` | `MikaLauncher.open(this)`. The `AndroidManifest.xml` deep-link comment and the KDoc list name it. |
| terminal theme | `TerminalShare.builtInList()` | `builtin` list / command, goes through the same deep link (also hidden on an unsupported phone) |

`MikaLauncher` (an `object`, like `WinlatorLauncher`): `SECTION = "rizwan"`, `NAME = "Rizwan"`, `isSupported()` (= `AppBase.isMikaSupported()`: Android 10+ **and** arm64-v8a), `open(ctx)`:
unsupported phone -> toast "Rizwan needs Android 10+ on a 64-bit ARM phone", nothing starts; otherwise `AppBase.startMikaNow()` (sets the "used" flag, so Mika starts again after a process restart; idempotent, main thread),
then an explicit `Intent(ctx, com.wangzan101.mika.ui.MainActivity::class.java)` with `FLAG_ACTIVITY_NEW_TASK`. Rizwan's task is its own (`taskAffinity ${applicationId}.rizwan`, step 7), Back never closes the Win11 shell.
Errors are caught, logged with `AppLog` (tag `Rizwan`) and shown as a short toast. **This file and `AppBase.kt` are the only two places of `:app` that name a Mika class**, so step 9 only has to stub these two
(`mika/tools/stub/AppBase.kt.stub` and the new `mika/tools/stub/MikaLauncher.kt.stub`, same members, `isSupported()` false so no entry or icon shows, `open()` says "not in this build").

### `check-manifest.py` got three more checks (run by CI in step 9)
9. every component with an intent filter, and every provider, of Mika, `:app` and all other library manifests has an explicit `android:exported` (merger error at targetSdk 31+ otherwise);
10. every foreground service type used anywhere has its `FOREGROUND_SERVICE_<TYPE>` permission in some manifest (`startForeground` throws at targetSdk 34+ otherwise);
11. the class that `MikaLauncher.kt` starts is declared in Mika's manifest (an explicit intent to a missing activity only fails at run time).

### `targetSdk 37`
`:app`'s `targetSdk` is now **37** (it was 28). It is read in one place: `app/build.gradle.kts` (`-PappTargetSdk=28`, or `appTargetSdk=28` in `gradle.properties`, goes back without editing a file); the root `extra["targetSdkVersion"]` follows it (nothing reads it).
**Read `docs/CHANGES-mika-part8.md`, section "targetSdk 37": what was checked here, and what is expected to stop working (Winlator, RetroArch's downloaded cores) or is unverified.**

### Tested here (copy of the real upstream 0.1.52, `app/src/main` + `core/src/main`)
| Case | Result |
|---|---|
| `patch-upstream.py` first run | 13 edit groups as in step 7, no error |
| second run | "already patched" |
| `check-manifest.py` (checks 1 to 11) | OK: 30 permissions, 65 provider authorities, 31 components |
| negative A / B / C | missing `android:exported` on Mika's `MainActivity` / hook class not in the manifest / `foregroundServiceType="camera"` without its permission: each fails with a clear `::error::` line, restored = OK |
| scan of the 14 module manifests (with an `<application>`) + Mika's | 0 components without `android:exported`; 5 foreground service types (`dataSync`, `mediaPlayback`, `mediaProjection`, `microphone`, `specialUse`), all with their permission |
| scan of `PendingIntent.get*` (all modules but upstream / `:Bcore`) | 0 calls without `FLAG_IMMUTABLE` / `FLAG_MUTABLE` or a flags helper |
Not run: Gradle, a compile (no Kotlin compiler / Android SDK / network here), CI, a device. The Kotlin edits are small and were read twice; `py_compile` OK.

### Risks in the order they can show up (send the first error lines)
1. `:app:compileDebugKotlin`: `MikaLauncher` needs `com.wangzan101.mika.ui.MainActivity` (public class, in `:mika`), `AppBase.startMikaNow()` / `isMikaSupported()` (step 6). A `Toast` clash is not possible here (`android.widget.Toast` is imported by name; `WinlatorLauncher` imports the project's own `Toast`).
2. `:app:processDebugManifest` at the new target: a manifest of a library that was fine at 28 and asks for an explicit `exported` would show as "android:exported needs to be explicitly specified"; the static scan found none, AGP is the real judge.
3. **Run time at targetSdk 37**, see the CHANGES file: Winlator and RetroArch cores are the known ones; edge-to-edge screens of library modules, Android 17 behaviour changes and BlackBox hidden-API use are not checked.
4. Opening Rizwan on a phone with Android 10 / 11: phone control (wireless debugging) needs Android 11+ / 12+ for pairing, so only the chat part works there.
5. The wake word "Hey Rizwan" is still step 14 (no hook here listens for it).

## Step 9 (done): CI (cache + fetch + patch + checks in the three workflows, `include_mika` switch, the two stubs)

Request: step 9, keep every detail, full flat zip; Rizwan as a library app, all permissions kept, project versions win, "Hey Rizwan" wake word stays step 14.
Changed: `.github/workflows/UltimateBuild.yml`, `UltimateBuild_NoWinlator.yml`, `UltimateBuild_WithoutMe.yml`; comments in `settings.gradle.kts`, `gradle.properties`, `app/build.gradle.kts`, `tools/check-manifest.py`. New: `tools/check-merged-manifest.py`, `docs/CHANGES-mika-part9.md`.
Not touched: any Kotlin / Java / resource / manifest file, the patch and fetch scripts, the stubs. Full details, tests and risks: `docs/CHANGES-mika-part9.md`.

### In every workflow (after the package rename, before the build)
1. **Cache Mika source**: `mika/upstream`, key = `UPSTREAM_VERSION` + `UPSTREAM_COMMIT` + the fetch / patch scripts + `mika/rizwan/**` (the cache holds the patched copy).
2. **Fetch and patch Mika source**: `tools/fetch-upstream.sh` -> `tools/patch-upstream.sh` -> `tools/check-manifest.py` -> `BuildConfig.APPLICATION_ID` in `mika/build.gradle.kts` must be the **new** package name (the rename reaches it; Mika compares it with the package name at run time).

### In every workflow (after the build, in "Locate Unsigned APK")
- native files `libmikarun.so`, `libproot.so`, `libproot_loader.so` under `lib/arm64-v8a`; `assets/runtime/rootfs.tar.xz` with exactly the size of the fetched file; `MikaApp` and the `:mika-core` package in the dex files;
- `tools/check-merged-manifest.py` on the merged release manifest: all 30 permissions, every component of Mika, no launcher / HOME filter on Mika, explicit `exported`, no open placeholder, own task for its chat screen, no duplicate authority.

### `UltimateBuild_WithoutMe.yml`
Tick box **`include_mika`**. Unticked: `AppBase.kt` and `MikaLauncher.kt` get the two stubs of `tools/stub/` (read before the folders are deleted), `mika/` and `mika-core/` are deleted and unwired, `no_refs` finds nothing, cache / fetch steps are skipped, and the APK check requires that `libmikarun.so` is **absent**.
No Start menu / Home / terminal edit is needed: the stub's `MikaLauncher.isSupported()` is `false`, which those three places already test. The two normal workflows always include Mika.

### Tested here
YAML + `bash -n` of every `run:` step; the removal block and the package rename on copies of the project; `check-merged-manifest.py` on 1 good + 7 bad synthetic manifests; the APK block on fake APKs (6 cases). **Not run:** Gradle, a compile, a GitHub Actions run, the real upstream this turn (the last part of the uploaded split zip, `ezyZip.zip`, was not in the upload).

### Risks in the order they can show up (send the first error lines)
1. "Fetch and patch Mika source" (GitHub must serve the pinned commit; `::error::check-manifest:` lines);
2. the first compile of Mika's 837 Kotlin files with the project's versions (`:mika:compileReleaseKotlin`);
3. the dex check assumes no shrinker (`isMinifyEnabled = false` today);
4. total run time against the 120 minute limit (not measured).

## Step 10 (done): `.gitignore`, `.gitattributes`, docs

Request: step 10, keep every detail; library app, all permissions kept, project versions win, "Hey Rizwan" wake word stays step 14. The real upstream was available again this turn (all 5 parts of the split zip), so the chain was re-run on it.
Changed: `.gitignore`, `.gitattributes`, `mika/README.md` (Overview, plan table, this section), `README.md`. New: `docs/CHANGES-mika.md` (the whole feature in one file), `docs/CHANGES-mika-part10.md`. Not touched: any source / build / manifest / workflow file, the scripts, the stubs.

### `.gitignore` audit (a real `git init` + `git add -A` of the tree with the patched upstream placed inside)
| Question | Result |
|---|---|
| tracked files from `mika/upstream/` | 0 (rule `mika/upstream/`, also covers the `.rizwan-patched` marker) |
| Mika files tracked | 13: this README, the 2 pin files, `mika/build.gradle.kts`, the icon, 5 tool scripts, 2 stubs, `mika-core/build.gradle.kts` |
| `mika/tools/__pycache__/` | **gap found**: running the scripts creates it next to them. Added `**/tools/__pycache__/` (all modules' tools profit; no `*.pyc` rule on purpose, winlator's virglrenderer source has two `.pyc` files of its own) |
| marker | extra rule `.rizwan-patched` (for a checkout copied by hand) |
`.gitattributes`: `*.py` and `*.stub` are `text eol=lf` (like `*.sh`): the scripts run on Linux runners, the stubs are copied over Kotlin sources. Checked in git: all 7 files under `mika/tools/` are `i/lf w/lf`.

### Tested here (real upstream 0.1.52, placed by hand)
`fetch-upstream.sh` (hand-placed, exit 0), `patch-upstream.sh` first run (13 edit groups, same numbers as parts 4 to 8), `check-manifest.py` OK (30 permissions: 17 + 13 new, 7 activities, 11 services, 6 providers, 7 receivers, 65 authorities), git-ignore audit as above.
Not run: Gradle, a compile, CI, a device, the real GitHub fetch.

## Step 11 (done): licence files in the APK, `NOTICE-Mika.md`

Request: step 11, keep every detail; library app, all permissions kept, project versions win, "Hey Rizwan" wake word stays step 14. The real upstream (0.1.52, the 5-part split zip) was available, so everything was run on it.
Changed: `mika/tools/patch-upstream.py` (edit 13), `mika/tools/fetch-upstream.sh` (sparse list + required files), `mika/tools/check-manifest.py` (check 12), the three workflows (APK licence check), `NOTICE-Mika.md`, this file, `README.md`, `docs/CHANGES-mika.md`.
New: `mika/rizwan/licenses/RIZWAN-NOTICE.md`, `docs/CHANGES-mika-part11.md`. Not touched: any Kotlin / Java / Gradle / manifest file, the stubs.

### What was read first
Upstream's `licenses/` (GPL-2.0, GPL-3.0, LGPL-3.0, `THIRD_PARTY_NOTICES.md`), `NOTICE`, `LicensesScreen.kt` (shows `assets/licenses/Apache-2.0.txt` + a hard-coded component list; reads `runtime/packages.json`), `tools/sandbox/` (README, `sources.lock`, 4 PRoot patches, runtime lock), and our other modules' assets (no `licenses` folder, no GPL / THIRD file: **no asset name clash**).
**Finding:** Mika's APK already holds only `Apache-2.0.txt` and `Protocol-Buffers.txt` as licence assets; the GPL / LGPL texts and the notices stay in upstream's repository folder `licenses/`, **outside the APK**, although the APK ships PRoot (GPL-2.0-or-later, patched), talloc (LGPL-3.0-or-later) and a root file system of GPL / LGPL packages. Step 11 closes that.

### Patch edit 13 (`patch_license_assets`)
Copies into `mika/upstream/app/src/main/assets/licenses/` (merges next to Mika's own two files, overwrites nothing of Mika's): `GPL-2.0.txt`, `GPL-3.0.txt`, `LGPL-3.0.txt`, `THIRD_PARTY_NOTICES.md` (from `licenses/`), `MIKA-NOTICE.txt` (from `NOTICE`), `RIZWAN-NOTICE.md` (ours), and `gpl-source/` = `README.md`, `sources.lock`, `runtime-sources.lock`, `patches/*.patch` (from `tools/sandbox/`).
Idempotent (copies only when the bytes differ). The marker hash now also covers `mika/rizwan/licenses/*`, so a changed notice text is applied. Drift guard: a missing source file, or fewer than 4 PRoot patches, stops the build with `::error::patch-upstream: ...`. Self-check: every file in `LICENSE_ASSETS` exists and is not empty.
### Fetch script
Sparse checkout now has `/tools/sandbox/`; `REQUIRED` got `licenses/GPL-2.0.txt`, `GPL-3.0.txt`, `LGPL-3.0.txt`, `NOTICE`, `tools/sandbox/sources.lock`, `tools/sandbox/patches`. An old cached checkout without them fails the layout check and is fetched again (the cache key contains the fetch script's hash anyway).
### Checks
- `check-manifest.py` check 12: all `LICENSE_ASSETS` present and not empty, at least 4 patches, and `GPL-2.0.txt` present because `libproot.so` is shipped.
- the three workflows ("Rizwan (Mika) in the APK"): the 10 files + 4 patch files must be in the APK (`unzip -l` listing), else `::error::assets/licenses/... is not in the APK`. In `UltimateBuild_WithoutMe.yml` this runs only in the `include_mika` branch.
### `NOTICE-Mika.md`
Rewritten third-party section: a table of what is not Apache-2.0 (PRoot, talloc, Alpine file system, `libmikarun.so`), a table of the licence files in the APK and where each comes from, and **three open points for the owner** (GPL source offer, Alpine package sources not checked, Mika's licence screen shows only Apache-2.0). Not legal advice.

### Tested here (real upstream 0.1.52)
| Case | Result |
|---|---|
| patch, fresh tree | 13 edit groups, `licence assets=13`; `assets/licenses/` holds 15 files (Mika's 2 + 13 new), no existing file changed |
| second run / forced re-run | "already patched" / 0 changes; tree hash identical |
| tree already patched by the step 10 script, then the new one | only the licence edit applies (13); tree hash identical to the fresh one |
| `check-manifest.py` (checks 1 to 12) | OK (30 permissions, 65 authorities, 31 components) |
| negative: `GPL-2.0.txt` removed / only 3 patches / checkout without `tools/sandbox` | check 12 reports both GPL lines / the patch count; the patch stops with `licence source tools/sandbox/README.md is missing` |
| fetch script on a local git repo (`file://`): fresh, again | `tools/sandbox/` checked out with `licenses/`; second run "already present"; then the patch on that checkout: 13 groups |
| APK licence block of the 3 workflows on fake `unzip -l` lists | complete list passes (all 3); missing `GPL-3.0.txt` / only 3 patches fail with their own line |
| YAML of the 3 workflows, `bash -n` of every `run:` step, syntax of the Python / shell scripts | OK |
Not run: Gradle, a compile, a real GitHub fetch / Actions run, a device. That AGP merges the new asset folders without a clash is expected (no other module has `assets/licenses`) but not run.

## Step 12 (done): documentation refresh
Docs only; no Kotlin, Gradle, manifest, workflow or script file was changed. The plan table here, the plan table and a "Step 12" paragraph in `../README.md`, `../docs/CHANGES-mika.md` (now parts 1 to 12) and the file list above (`part1` ... `part12`) were brought up to date; `../docs/CHANGES-mika-part12.md` has the checklist and what was tested.
Re-tested on the real upstream 0.1.52 (the `Mika-main.zip` you uploaded, hand-placed): fetch check, patch (13 edits, `licence assets=13`), second run "already patched", `check-manifest.py` OK (30 permissions, 7 activities / 11 services / 6 providers / 7 receivers, 65 authorities). Not run: Gradle, a compile, CI, a device.
Next: step 13 (static checks), step 14 (wake word "Hey Rizwan"), step 15 (final zip); the docs are read once more after 13 and 14.

## Step 13 (done): static checks
New read-only script `tools/static-check.py` (run `python3 mika/tools/static-check.py` from the project root; with `mika/upstream/` present it also checks the patched Mika sources). Nine groups: (1) the 6 workflows (YAML + `bash -n` of all 69 run steps), (2) 9 shell and 10 Python scripts, (3) XML well-formed (627 project files, 1000 patched Mika files), (4) resource names: no clash between any of the 14 modules with resources and `:mika`,
(5) `MikaLauncher.kt.stub` / `AppBase.kt.stub` have every member the app uses, (6) the 7 hook Kotlin files balance `{}` and `()`, (7) `settings.gradle.kts` / `app/build.gradle.kts` wiring and what the "without" workflow's unwiring leaves (balanced, no Mika line), (8) "Hey Rizwan" in all 13 greeting files and no visible "Mika" word left (upstream URLs and `Theme.Mika` stay), (9) LF in `mika/tools`, `*.sh` executable.
Result: **no defect found**, so no project file was changed. (One scare during the work, braces "unbalanced" in three Kotlin files, was my first quick regex; a proper tokenizer that skips strings, comments and char literals shows all balanced; the script uses that one.)
Negative tests: a stray `}` in `AppBase.kt`, a stub without `isSupported`, a greeting file without "Hey Rizwan": each stops the script with `::error::static-check:` and exit code 1. Not run: Gradle, a compile, CI, a device. Details: `../docs/CHANGES-mika-part13.md`.

## Build fix 1 (after your first GitHub Actions log, `build-error-log.zip`)
Request: step 14 dropped; fix the build error; keep every detail; full flat zip.
**What the log showed:** `fetchMikaUpstream` (Mika 0.1.52, commit 7ff1703f63b7, "already present"), `patchMikaUpstream`, `:mika-core` (protobuf, compileKotlin), `:mika` resources / manifest / assets / JNI libs and `:app:mergeReleaseNativeLibs` all passed. Then:
`e: .../mika/chat/ui/ChatDrawerMotion.kt:85:88 Unresolved reference 'minAnchor'` and `:85:109 Unresolved reference 'maxAnchor'` -> `:mika:compileReleaseKotlin FAILED` (the only 2 errors in the log; the only other messages were warnings of other modules).
**Cause:** `:mika` builds with `compose-bom-alpha:2025.03.01` (the project's version, part 5; upstream uses 2024.12.01). In that Compose Foundation `DraggableAnchors.minAnchor()` / `maxAnchor()` no longer exist (renamed in newer Foundation).
**Fix:** patch edit 14 in `tools/patch-upstream.py` (idempotent, checked): `minOf` / `maxOf` of `anchors.positionOf(DrawerValue.Closed)` and `positionOf(DrawerValue.Open)`. The drawer has exactly these two anchors (`Closed at -width`, `Open at 0`), so the clamp is the same, and `positionOf` exists in every Foundation version. The patch stamp includes the script hash, so a cached `mika/upstream/` patched by the old script is patched again on the next run (tested: only `drawer anchors=1` changes). `static-check.py` has a new group 10 for it.
**Tested:** patch on the real upstream 0.1.52: first run `drawer anchors=1`, second run "already patched"; on a checkout patched by the old script: only edit 14 applies; `static-check.py` passes. **Not tested:** the compile itself (no Kotlin / Android SDK here), so the next CI run decides; the compiler may show more errors after this one (a build stops at the first failing task). Send the next log and I fix it the same way. Details: `../docs/CHANGES-mika-fix1.md`.

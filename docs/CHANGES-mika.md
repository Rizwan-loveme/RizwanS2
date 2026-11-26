# Mika → "Rizwan": the whole feature in one file (parts 1 to 13 of 15, step 14 dropped, build fix 1)

Status after part 13 (part 12 = documentation refresh, part 13 = static checks plus the new script `mika/tools/static-check.py`; neither changed a Kotlin, Gradle, manifest or workflow file; this file is read again after part 14). **Build fix 1 (after your first CI log):** the first real build got through fetch, patch, resource and manifest merge and the `:mika-core` compile, and failed only at `:mika:compileReleaseKotlin` with 2 errors (`ChatDrawerMotion.kt`: `minAnchor` / `maxAnchor`, removed in the newer Compose Foundation); fixed by patch edit 14 (section 6), see `docs/CHANGES-mika-fix1.md`. Step 14 (wake word) was dropped by you. **Still not verified:** everything after that compile (the rest of `:mika`, `:app`, R8, APK, a phone). Before the log, nothing had been compiled (no Gradle / Android SDK / network in the environment where it was written); every claim below says whether it was
*tested on the real upstream*, *tested on copies*, *checked by reading* or *not verified*. The per-part files `docs/CHANGES-mika-part1.md` to `part13.md` and `mika/README.md` keep the full detail.

## 1. What it is
**Rizwan** is the built-in on-device AI assistant of the Win11 launcher. It is [Mika](https://github.com/wangzan101/Mika) (wangzan101, Apache-2.0), pinned at **0.1.52**
(versionCode 53, commit `7ff1703f63b7cbf5741a29345c1b4507802c6b06`), added as a **library** app in the same way as PPSSPP / MAME / RetroArch:
- `:mika` (Android library) + `:mika-core` (pure JVM library), package **`com.wangzan101.mika`** (upstream's package is kept: 837 Kotlin files import its `R` / `BuildConfig`)
- the Mika source is **not in the project zip**: it is cloned (`mika/tools/fetch-upstream.sh`) and turned into a library (`mika/tools/patch-upstream.sh`) before every build, local or CI
- the visible name is **Rizwan**, the chat greeting is **"Hey Rizwan"**, the launcher / logo art is our own (Mika's logo is not used)
- Mika keeps **all 30 of its permissions**; the project's versions win over Mika's (Kotlin 2.2.10, AGP 8.13.2, JDK 21, compileSdk 37, minSdk 26, Compose BOM alpha 2025.03.01 like `:seal`)
- "Hey Rizwan" as a **spoken wake word** does not exist yet (upstream has none): it is step 14. Until then "Hey Rizwan" is the name and the greeting only.

## 2. Where Rizwan opens from
| Entry | What happens |
|---|---|
| Start menu **Rizwan** (violet four-point sparkle), Home screen icon **Rizwan** | `MikaLauncher.open()`: `AppBase.startMikaNow()` (first use: sets the "used" flag, starts Mika), then Mika's own `MainActivity` in its **own task** (`taskAffinity ${applicationId}.rizwan`), so Back never closes the Win11 shell |
| `rizwans2://rizwan` (alias `rizwans2://assistant`) | same |
| terminal launcher theme | the built-in list / command goes through the same deep link |
| Android share sheet | "Rizwan" appears for text / links / files (Mika's `SEND` filters are kept); it starts Mika itself (patch edit 12) |
| Quit (Rizwan's "Quit" in the capsule / settings) | stops Mika's services and capsule, **Win11 keeps running** and keeps its notifications |
All hooks are hidden on a phone that is **not Android 10+ on 64-bit ARM** (`MikaLauncher.isSupported()`); on such a phone the deep link shows a short message. Phone control needs wireless-debugging pairing (Android 11+ / 12+); on Android 10 only the chat part works.
The "All apps" numbers (`rizwans2://N`) shift by one for the apps after **Rizwan** in the name-sorted list, only on phones where the entry is shown.
Mika starts again after a process restart **only if Rizwan was opened before** on this phone (decision of part 6: users who never open it do not pay for the 58 MB sandbox unpack, the capsule and the helper watcher). To get "always on", drop the `wasMikaUsed` test in `AppBase.startMikaIfUsed()`.

## 3. Files
| Where | What | Part |
|---|---|---|
| `mika/UPSTREAM_VERSION`, `UPSTREAM_COMMIT` | the pin | 1 |
| `mika/build.gradle.kts` | `:mika` Android library: source sets point at `mika/upstream/app/src/main`, BuildConfig fields, dependencies, tasks `fetchMikaUpstream` / `patchMikaUpstream` | 2, 3, 4 |
| `mika-core/build.gradle.kts` | `:mika-core` JVM library: protobuf-lite from the OpenTelemetry protos, `knowledgeIndex` task, waits for the fetch | 2, 3, 5 |
| `mika/tools/fetch-upstream.sh` | shallow clone of the pinned commit, sparse checkout (about 83 MB kept, plus `tools/sandbox/` 152 KB since part 11), commit / version / layout checks, hand-placed (offline) mode | 3 |
| `mika/tools/patch-upstream.sh` + `patch-upstream.py` | the 13 edits that turn the checkout into the library (section 6), idempotent, self-check | 4, 6, 7, 11 |
| `mika/rizwan/drawable-nodpi/mika_launcher_art.png` | Rizwan icon art, replaces Mika's | 4 |
| `mika/rizwan/licenses/RIZWAN-NOTICE.md` | notice shipped in the APK (what Rizwan is, changes, GPL / LGPL parts, source pointers) | 11 |
| `mika/tools/check-manifest.py` | source-side merge check, 12 checks (12 = licence assets) | 7, 8, 11 |
| `mika/tools/check-merged-manifest.py` | checks the **merged** release manifest after the build, 7 checks | 9 |
| `mika/tools/static-check.py` | read-only static checks of the whole Mika part (9 groups: workflows, scripts, XML, resource clashes, stubs, Kotlin balance, Gradle unwiring, greeting, line endings); exit 1 on a problem | 13 |
| `mika/tools/stub/AppBase.kt.stub`, `MikaLauncher.kt.stub` | replacements for the "without Mika" build | 6, 8, 9 |
| `app/.../AppBase.kt` (new), `App.kt` (edited) | `App : AppBase : MikaApp`, process guard, start after first use | 6 |
| `app/.../MikaLauncher.kt` (new) | open / `isSupported()` | 8 |
| `app/.../StartApps.kt`, `Win11Shell.kt`, `MainActivity.kt`, `TerminalShare.kt` (edited) | Start menu entry, Home icon, `rizwans2://rizwan`, terminal list | 8 |
| `app/build.gradle.kts`, `settings.gradle.kts`, `gradle.properties`, root `build.gradle.kts` | dependency, `noCompress xz`, switches, `targetSdk 37`, Kotlin JVM plugin | 2, 5, 8 |
| `app/src/main/AndroidManifest.xml` | comment block only (what the merge brings) | 7, 8 |
| `.github/workflows/UltimateBuild.yml`, `UltimateBuild_NoWinlator.yml`, `UltimateBuild_WithoutMe.yml` | cache, fetch + patch + checks, APK check, `include_mika` | 9 |
| `NOTICE-Mika.md`, `LICENSE-Mika` | Apache-2.0 text, credits, list of changes, GPL / LGPL parts, licence files in the APK, open points | 1, 4, 7, 11 |
| `.gitignore`, `.gitattributes` | `mika/upstream/`, `**/tools/__pycache__/`, `.rizwan-patched`; LF for `*.py` / `*.stub` | 1, 10 |
| `mika/README.md`, `README.md`, `docs/CHANGES-mika*.md` | documentation | all |

## 4. The build chain
`./gradlew assembleRelease` -> `:mika:fetchMikaUpstream` (git + network, once) -> `:mika:patchMikaUpstream` (bash + python3, marker with the script hash) -> `:mika` / `:mika-core` compile -> `:app`.
`:mika-core` waits only for the fetch. In CI (all three workflows) the same two scripts run **earlier**, after the package rename, with a cache of `mika/upstream` (key = version + commit + scripts + icon), so Gradle finds the checkout ready.

Switches: `-PincludeMika=false` / `includeMika=false` (leaves the modules out; **does not compile alone**, because `AppBase` extends `MikaApp` and `MikaLauncher` names a Mika class: use the "without" workflow or swap the two stubs by hand),
`-PappTargetSdk=28` (old target, needed again for Winlator and RetroArch's downloaded cores), `MIKA_FORCE_PATCH=1` (run the patch although the marker matches), `MIKA_REPO_URL` (mirror / local path for the fetch).
Tasks: `./gradlew :mika:fetchMikaUpstream`, `:mika:patchMikaUpstream`; by hand: `bash mika/tools/fetch-upstream.sh && bash mika/tools/patch-upstream.sh && python3 mika/tools/check-manifest.py && python3 mika/tools/static-check.py`.

## 5. Permissions (all 30 kept; checked by the patch, by `check-manifest.py` and, on the merged manifest, by `check-merged-manifest.py` in CI)
17 are already declared by `:app`: `INTERNET`, `RECEIVE_SMS`, `RECORD_AUDIO`, `CAMERA`, `ACCESS_NETWORK_STATE`, `FOREGROUND_SERVICE`, `FOREGROUND_SERVICE_DATA_SYNC`, `FOREGROUND_SERVICE_MICROPHONE`, `MODIFY_AUDIO_SETTINGS`,
`POST_NOTIFICATIONS`, `CALL_PHONE`, `READ_PHONE_STATE`, `READ_CONTACTS`, `WAKE_LOCK`, `RECEIVE_BOOT_COMPLETED`, `READ_EXTERNAL_STORAGE`, `WRITE_SECURE_SETTINGS`.
**13 are new for the whole Win11 app:** `ACCESS_COARSE_LOCATION`, `ACCESS_FINE_LOCATION`, `CALL_COMPANION_APP`, `FOREGROUND_SERVICE_SPECIAL_USE`, `MANAGE_ONGOING_CALLS`, `POST_PROMOTED_NOTIFICATIONS`, `READ_CALENDAR`, `WRITE_CALENDAR`,
`READ_MEDIA_IMAGES`, `READ_MEDIA_VISUAL_USER_SELECTED`, `REQUEST_INSTALL_PACKAGES`, `SCHEDULE_EXACT_ALARM`, `com.android.alarm.permission.SET_ALARM`.
Each is requested at run time only when Rizwan uses the matching feature. Mika also adds 7 activities, 11 services, 6 providers (authorities `com.srizwan.win11.*`, 65 authorities checked for clashes), 7 receivers, `<queries>` and 5 optional `<uses-feature>`.

## 5b. Licences in the APK (part 11)
The APK ships PRoot (GPL-2.0-or-later, patched by Mika), talloc (LGPL-3.0-or-later) and an Alpine root file system of GPL / LGPL / MIT / BSD / MPL packages next to Mika's Apache-2.0 code. `assets/licenses/` now holds `Apache-2.0.txt`, `GPL-2.0.txt`, `GPL-3.0.txt`, `LGPL-3.0.txt`, `THIRD_PARTY_NOTICES.md`, `MIKA-NOTICE.txt`, `RIZWAN-NOTICE.md` and `gpl-source/` (4 PRoot patches, 2 source locks, README); CI fails when one is missing. Open points for the owner (GPL source offer, Alpine package sources unchecked, Mika's licence screen shows only Apache-2.0): `NOTICE-Mika.md`.

## 6. What the patch changes in upstream: 14 edits (only in the build checkout, never in the zip)
1. `MikaApp` becomes `open` (the 10 `applicationContext as MikaApp` casts keep working with Win11's `App`)
2. library manifest: the 8 `<application>` attributes and `MainActivity`'s MAIN / LAUNCHER filter are removed
3. 13 clashing resource names get the prefix `mk_` (12 strings + `mipmap/ic_launcher`, about 207 edits)
4. "Mika" -> "Rizwan" in all strings of the 13 languages (589 files)
5. the five `chat_greeting_*` strings -> "Hey Rizwan" in 13 languages
6. icon art replaced by ours
7. `MikaApp.onCreate` split into `startOnCreate()` + idempotent main-thread `startMika()`; `MikaQuit` no longer kills the process or cancels all notifications (`onQuitExit()`)
8. `AppLanguage.kt`: Mika's language switch never changes the host's locale (it would have turned the launcher right-to-left)
9. `UpdateChecker.check()` does nothing (Mika's self-update would install `com.wangzan101.mika` as a separate app)
10. the backup-import text (13 languages): closing Rizwan no longer ends the process
11. manifest: label "Rizwan", own icon, own task for the chat screen
12. `MainActivity.onCreate` calls `startMika()` first
13. (part 11) licence assets: upstream's GPL-2.0 / GPL-3.0 / LGPL-3.0 / `THIRD_PARTY_NOTICES.md` / `NOTICE`, our `RIZWAN-NOTICE.md` and the PRoot patches + source locks go into `assets/licenses/` of the APK (Mika's own APK carried only Apache-2.0 and the protobuf licence)
14. (build fix 1) `ChatDrawerMotion.kt`: `anchors.minAnchor()` / `anchors.maxAnchor()` (gone in the Foundation of BOM 2025.03.01) become `minOf` / `maxOf` of `anchors.positionOf(DrawerValue.Closed)` and `positionOf(DrawerValue.Open)`; same meaning (the drawer has these two anchors), works in every Foundation version; `check()` fails if the removed API is left anywhere
Not changed on purpose: Mika's network security config (cleartext is already on in `:app`; trusting user-installed CAs for the whole app was not accepted, so a company-CA model server fails TLS), the share filters, the notification small icon.
The persona / prompt texts in `core/src/main/resources` still say "You are Mika" (step 14, together with the wake word).

## 7. Decisions taken (change them by telling me)
- library, not a separate app; project versions win; **all permissions kept** (owner)
- `targetSdk` of `:app` is **37** since part 8 (owner); expected side effect: Winlator and RetroArch's downloaded cores stop working at 37 unless `-PappTargetSdk=28` is used
- Mika starts only after Rizwan was opened once on the phone (part 6)
- network security config not merged; share filters kept; own task but the same process (Mika's services live in the launcher process)
- "without" build: the two stubs + delete / unwire, not `-PincludeMika=false`; the two normal workflows always include Mika

## 8. Not verified (all parts together)
That anything compiles or runs. Specifically: the first compile of Mika's 837 Kotlin files against Kotlin 2.2.10 / Compose alpha 2025.03.01 / coroutines 1.9.0 (upstream: 2.1.20 / 2024.12.01 / 1.10.2); `:mika-core:generateProto` with protoc 4.36.2;
the real `git fetch --depth 1 origin <sha>` from github.com (tested with `file://` and hand-placed only); the manifest merge by AGP; the APK size (+58 MB assets and more); edge-to-edge screens at targetSdk 37; whether phone control works inside the host app;
the run time of the CI job (120 minute limit). *Tested on the real upstream:* the fetch script's hand-placed mode, the patch (first, second and forced run: identical trees), `check-manifest.py`, (part 10) the git-ignore audit, and (part 13) `static-check.py` on the project and on the patched upstream (all 9 groups pass, 4 negative cases fail as they should), (part 12) the whole chain again on the real upstream 0.1.52 you uploaded (hand-placed: fetch check, patch with all 13 edits, second run "already patched", `check-manifest.py` OK: 30 permissions, 7 / 11 / 6 / 7 components, 65 authorities).

## 9. If the first CI run fails (most likely first)
| Symptom | Likely cause | First thing to try |
|---|---|---|
| "Fetch and patch Mika source": `could not fetch commit` / `git fetch failed` | GitHub refused the by-hash shallow fetch, or no network | send the log lines; fallback: `MIKA_REPO_URL`, or put the upstream files into `mika/upstream/` by hand (no `.git`) |
| `::error::patch-upstream:` | the checkout is not 0.1.52 (drift guard) | check `UPSTREAM_VERSION` / `UPSTREAM_COMMIT` |
| `::error::check-manifest:` | a manifest check failed | the line names the check (permission, authority, exported, ...) |
| `:mika-core:generateProto` cannot resolve protoc | protoc 4.36.2 / opentelemetry-proto jar | check the two versions in `mika-core/build.gradle.kts` |
| `:mika:compileReleaseKotlin` `e:` lines | Compose alpha vs stable, coroutines 1.9.0 vs 1.10.2, Kotlin 2.2 vs 2.1 | send the first error lines; the project pin goes to coroutines 1.10.2 only if a 1.10 API is the cause |
| `:app:processReleaseMainManifest` | merge conflict (`tools:replace` hint) | send the line |
| "Rizwan (Mika) in the APK" | native file / `rootfs.tar.xz` size / dex class missing | the line names which; with R8 on, Mika needs keep rules (not written) |
| "Rizwan (Mika) in the APK": `assets/licenses/... is not in the APK` | the licence assets of patch edit 13 did not get packaged (or `tools/sandbox/` was not fetched) | run `patch-upstream.sh`, look at `mika/upstream/app/src/main/assets/licenses/` |
| `check-merged-manifest.py` | the merged manifest differs from what the source check expected | the `::error::` line names the check |

## 10. Moving to a newer Mika
Change `mika/UPSTREAM_VERSION` and `mika/UPSTREAM_COMMIT` together; run `bash mika/tools/fetch-upstream.sh` and `bash mika/tools/patch-upstream.sh` on a copy; the drift guard stops on a layout change (a new `<application>` shape,
a clashing resource name that disappeared or a new one, a new language not in `BACKUP_BODY`, a moved `licenses/` or `tools/sandbox/` folder, fewer than 4 PRoot patches). Also re-read `licenses/THIRD_PARTY_NOTICES.md` for new GPL / LGPL parts and update `mika/rizwan/licenses/RIZWAN-NOTICE.md`. Then re-run `check-manifest.py`, re-read `MikaApp.kt` / `MikaQuit.kt` / `UpdateChecker.kt` / `AppLanguage.kt` (edits 1, 7, 8, 9) and compare the 30 permissions
(`KEEP_PERMISSIONS` fails if one disappears; add new ones to the list on purpose). The cache key changes with the pin, so CI refetches by itself.

## 11. Part by part
| Part | What | File |
|---|---|---|
| 1 | pin, analysis, notices, `.gitignore` | `CHANGES-mika-part1.md` |
| 2 | `:mika-core` and `:mika` build files | `CHANGES-mika-part2.md` |
| 3 | fetch script + `fetchMikaUpstream` | `CHANGES-mika-part3.md` |
| 4 | patch script (library manifest, `MikaApp` open, `mk_`, name, greeting, icon) | `CHANGES-mika-part4.md` |
| 5 | Gradle wiring | `CHANGES-mika-part5.md` |
| 6 | `App : AppBase : MikaApp`, process guard | `CHANGES-mika-part6.md` |
| 7 | manifest merge, self-update cut, language, backup text | `CHANGES-mika-part7.md` |
| 8 | hooks (Start menu, Home, deep link) + `targetSdk 37` | `CHANGES-mika-part8.md` |
| 9 | CI, `include_mika`, stubs | `CHANGES-mika-part9.md` |
| 10 | `.gitignore`, `.gitattributes`, docs (this file) | `CHANGES-mika-part10.md` |
| 11 | licence files in the APK assets, `NOTICE-Mika.md` rewritten, CI APK check | `CHANGES-mika-part11.md` |
| 12 | README / CHANGES refresh (this file, `mika/README.md`, `README.md`, stale counts and file lists) | `CHANGES-mika-part12.md` |
| 13 | static checks over the whole project + `mika/tools/static-check.py` | `CHANGES-mika-part13.md` |
| 14 | wake word "Hey Rizwan", persona prompts | dropped by you (not done; the greeting "Hey Rizwan" and the name stay as in parts 4 and 6) |
| fix 1 | first CI build error: `ChatDrawerMotion.kt` Compose API (patch edit 14) | `CHANGES-mika-fix1.md` |
| 15 | final zip `RizwanS2-main-mika-rizwan.zip` | todo |

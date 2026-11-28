# :shizuku — built-in Shizuku (manager app + server)

Upstream: https://github.com/RikkaApps/Shizuku, pinned in `UPSTREAM_VERSION` (**v13.6.0**) + `UPSTREAM_COMMIT`.
The `api/` submodule (https://github.com/RikkaApps/Shizuku-API) is pinned in `UPSTREAM_API_COMMIT` (API 13.1.5, the same API version `:mika` already uses).
Licences: Shizuku = **Apache-2.0** (`../LICENSE-Shizuku`), Shizuku-API = **MIT** (`../LICENSE-Shizuku-API`), see `../NOTICE-Shizuku.md`.

Goal (owner decision): the Shizuku **manager app** (UI: start by Wireless debugging / root, authorised apps list, terminal, settings) as a built-in app opened from the
Start menu, plus automatic hook-up with `:mika` (Rizwan assistant), which already contains the Shizuku client library. The source is **not in the project zip**:
`tools/fetch-upstream.sh` clones it at build time (CI and local builds), both commits are verified.

## Plan (10 steps)

| # | Part | Status |
|---|------|--------|
| 1 | Pin upstream (tag + commits), fetch script, licences, analysis (this file) | done |
| 2 | Patch script: library conversion, resource prefix `sh_`, host package in place of the hard-coded manager package (`tools/patch-upstream.py`) | done |
| 3 | Gradle wiring (`settings.gradle.kts`, module build files, CMake for `libshizuku.so`, version without git count, `:app` dependency, fetch task). Split in 8 sub-steps 3A - 3H, see "Step 3" below | **done** (3A - 3H; the Gradle side is complete behind the switch, nothing of it has been built yet: first CI run pending, see "First CI run: what to look at") |
| 4 | Manifest merge into `:app` (provider authority clash with `:mika`, permissions `API_V23` / `MANAGER`, boot receiver). Split in 7 letters / 26 rows 4A - 4G (4B - 4G cut further), see "Step 4" below | **done** (4A, 4B-1 ... 4B-4, 4C-1 ... 4C-4c, 4D-1 ... 4D-4, 4E-1 ... 4E-4c, 4F-1 ... 4F-3, 4G-1, 4G-2: 26 of 26 rows; statically checked, **never built**: the first CI run confirms it, see "4G-2" below for the open list and the hand-over to steps 5 - 8) |
| 5 | Package-name hand-over: done inside the step 2 script (server, starter, shell, native `starter.cpp`, `ShizukuProvider`); step 5 = checking it on the merged build. Split 5A - 5G (5E added in 4D-2, 5F and 5G in 4D-4), see "Steps 5 - 8, sub-steps" | **in progress** (5A, 5B-1, 5B-2, 5C, 5D, 5E, 5F and 5G done, see "5A", "5B-1", "5B-2", "5C", "5D", "5E", "5F" and "5G" below; steps 6 - 10 todo) |
| 6 | Hooks: Start menu, Home icon, `rizwans2://shizuku`, `ShizukuLauncher.kt`, `AppBase` call. Split 6A - 6E | **done** (6A, 6B-1, 6B-2, 6C, 6D and 6E, see "6A" ... "6E" below; the init call is `ShizukuLauncher.initApplication(this)` from `App.onCreate`, not in `AppBase`: see "6E") |
| 7 | `:mika` hook-up (one provider, one permission, `ShizukuShellUserService` check, stale package string). Split 7A-1.1, 7A-1.2, 7A-2.1, 7A-2.2, 7B - 7E | **done** (7A-1.1, 7A-1.2, 7A-2.1, 7A-2.2, 7B, 7C, 7D and 7E: 8 of 8 rows; static only, **never built**, see "7A-1.1" ... "7E" below; combined notes `docs/CHANGES-shizuku-part7.md`) |
| 8 | CI: fetch + cache step in the workflows, APK check (`libshizuku.so`, `starter`/`rish` assets), default switch. Split 8A - 8F | **done** (8A - 8F, see "8A" ... "8F" below; the default is ON since 8F, **never built**: the first CI run decides) |
| 9 | Docs, `NOTICE-Shizuku.md` final, README, `docs/CHANGES-shizuku-partN.md`. Split 9A - 9B | **done** (9A and 9B, see "9A" and "9B" below; the combined notes are `docs/CHANGES-shizuku-part9.md`; both written **before any GitHub build**) |
| 10 | Static checks + final flat zip. Split 10A - 10B | **done** (10A and 10B, see "10A" and "10B" below; final zip `RizwanS2-main-shizuku-final.zip`; **never built**) |

## Step 4 — Manifest merge (7 sub-steps, 4B - 4G split further: 26 rows)

Step 4 is split like step 3, so that one session never has to hold everything. Each sub-step ends in a zip-ready state and flips its own row below. 4B - 4G are each cut into small rows (4B-1 ... 4B-4, 4C-4a ... 4C-4c, 4D-1 ... 4D-4 and so on); one session should take one or two rows, not a whole letter. **All 26 rows are done (4G-2); the summary is in "4G-2" below.**

| # | Sub-step | What it covers | Files touched | Status |
|---|----------|----------------|---------------|--------|
| 4A | Inventory | Read the real patched `:shizuku` manifest and Mika's manifest (both fetched at build time). List every provider, receiver, service, activity and permission that clashes or overlaps; write the list as a table in this file. | docs only | **done** (see "4A" below) |
| 4B-1 | Guard mechanism (decision) | Read AGP / Gradle versions and the manifest set-up, compare five ways to apply `tools:node="remove"` only when `:shizuku` is in the build, pick one. Decision written below ("4B-1 — guard mechanism"): a build-type manifest overlay `app/src/shizuku/AndroidManifest.xml`, wired for `debug` and `release` only when `shizukuIncluded`. | docs only | **done** (see "4B-1" below) |
| 4B-2 | Apply the removal | Create `app/src/shizuku/AndroidManifest.xml` (one `<provider android:name="rikka.shizuku.ShizukuProvider" tools:node="remove" />`, authority repeated as documentation) and wire it in `app/build.gradle.kts` for the `debug` and `release` source sets, inside `if (shizukuIncluded)`. Nothing changes with the switch off. | new overlay file, `app/build.gradle.kts` | **done** (see "4B-2" below) |
| 4B-3 | Match check + Mika checker | (a) Script that reads the real patched Mika manifest and the manager manifest and proves: the marker name equals the name of Mika's provider exactly, the manager's provider keeps the authority, the switch-off path touches nothing. (b) `mika/tools/check-merged-manifest.py` rule 2 ("every component of Mika is in the merged manifest") would fail once the provider is removed on purpose: teach it to accept a missing `rikka.shizuku.ShizukuProvider` when `moe.shizuku.manager.ShizukuManagerProvider` is in the merged manifest. | new check under `shizuku/tools/`, `mika/tools/check-merged-manifest.py` | **done** (see "4B-3" below) |
| 4B-4 | Notes + zip | Fix the comments in `app/build.gradle.kts` (provider clash) and in `app/src/main/AndroidManifest.xml` (the Mika block says "6 providers": 5 with Shizuku built in), README plan row and finding 1 (resolved), `docs/CHANGES-shizuku-part4b.md`; flat zip `RizwanS2-main-shizuku-step4b.zip`. | docs, comments, zip | **done** (see "4B-4" below) |
| 4C-1 | Drop `DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION` removal | Finding 2: in `patch-upstream.py` delete both the `<permission>` and the `<uses-permission>` lines (`tools:node="remove"`) from the generated manager manifest, so the permission stays for the whole app on Android 8 - 12. | `shizuku/tools/patch-upstream.py` | **done** (see "4C-1" below) |
| 4C-2 | Patch self-check + rerun | Add the matching rule to the patch script's self-check (the permission must not carry a remove marker), rerun the patch on the fetched source, confirm the other counts (9 host-package places, 237 resource names, 42 languages) did not move. | `patch-upstream.py`, README numbers | **done** (see "4C-2" below; the rerun on the real source is still open, no network in that session) |
| 4C-3 | Permission ownership | Findings 3 and 4: `API_V23` (dangerous) and `MANAGER` (signature) declared once, by `:shizuku`; keep the manager's `uses-permission API_V23 tools:node="remove"` as a guard and check it is not overridden by Mika's request; the host still asks for `MANAGER`. | `app` manifest (comment only if nothing changes) | **done** (see "4C-3" below; a comment in the `:app` manifest and a second self-check rule in `patch-upstream.py`, no behaviour change) |
| 4C-4a | Duplicate `uses-permission` | Finding 5, first half: read `:app`, Mika and the generated manager manifest (all on disk after fetch + patch) and confirm that `RECEIVE_BOOT_COMPLETED`, `FOREGROUND_SERVICE`, `POST_NOTIFICATIONS`, `INTERNET` and `WRITE_SECURE_SETTINGS` are declared identically (same `maxSdkVersion`, same `tools:ignore`), so each merges to one with no merger conflict. Result table goes into this file. | docs only | **done** (see "4C-4a" below) |
| 4C-4b | New `uses-feature` | Finding 5, second half: `leanback` and `touchscreen` (`required=false`) come only from `:shizuku`. Check whether `:app` already declares them, that `required=false` cannot hide the app on any device, and that `:app`'s own `uses-feature` lines are not overridden. Touch the `:app` manifest only if something differs. | docs, `app` manifest only if needed | **done** (see "4C-4b" below; nothing differed, docs only) |
| 4C-4c | Notes + zip | README plan row (4C done, 4D-1 next), finding 5 marked checked, `docs/CHANGES-shizuku-part4c.md` (covers 4C-1 ... 4C-4, the small `part4c1` - `part4c3` files stay), flat zip `RizwanS2-main-shizuku-step4c.zip`. | docs, zip | **done** (see "4C-4c" below) |
| 4D-1 | Activities | The 9 activities: none has a LAUNCHER filter; only the three exported ones are exported on purpose (`RequestPermissionActivity`, `ShellRequestHandlerActivity`, `LegacyIsNotSupportedActivity`, see the 4A table; the old row said "not exported" for all nine, that was too short). Check `SettingsActivity`'s `APPLICATION_PREFERENCES` filter against `:app` and Mika. | docs, `app` manifest only if needed | **done** (see "4D-1" below; nothing differed, docs only) |
| 4D-2 | `AdbPairingService` | Finding 6: `foregroundServiceType="shortService"` against `:app`'s foreground-service types at targetSdk 37 (needs only `FOREGROUND_SERVICE`). Read the service code: which type it passes to `startForeground`, and that the pairing flow fits the short-service time limit. | docs | **done** (see "4D-2" below; docs only; one new finding, 11, handed to 5E) |
| 4D-3 | Boot receivers | Three receivers get `BOOT_COMPLETED` (`:app` `.BootReceiver`, Mika `.setup.BootRestoreReceiver`, manager `BootCompleteReceiver`; the last one is also `LOCKED_BOOT_COMPLETED` / directBootAware). Read what each does at boot, whether two of them start a foreground service or touch the same setting, and write down that order is undefined and nothing depends on it. | docs, `app` manifest only if needed | **done** (see "4D-3" below; docs only; order is harmless, but two new findings, 12 and 13, handed to 4D-4) |
| 4D-4 | Application class + notes | `ShizukuApplication` is not in the merged manifest, so the app keeps its own `Application`: read what upstream's `ShizukuApplication` initialised and name where that must happen now (finding 9 task / process note goes to 6A). **Also from 4D-3:** finding 13 (the boot receiver needs `ShizukuApplication.onCreate(app)` to have run, so the call must sit early in the launcher-process part of `App.onCreate` and must exist before `includeShizuku` is ever on by default) and finding 12 (direct-boot start of the main process: decide between stripping `directBootAware` + `LOCKED_BOOT_COMPLETED` from the manager's `BootCompleteReceiver` in `patch-upstream.py`, or making `App.onCreate` safe while the user is locked; the owner decides, recommendation in finding 12). Plan row (4D done), `docs/CHANGES-shizuku-part4d.md`. | docs, `app` manifest only if needed | **done** (see "4D-4" below; docs only; `docs/CHANGES-shizuku-part4d.md` written, flat zip `RizwanS2-main-shizuku-step4d.zip`; finding 12 decided, new finding 14, rows 5F and 5G added) |
| 4E-1 | Checker skeleton | New `shizuku/tools/check-merged-manifest.py`, modelled on `mika/tools/check-merged-manifest.py`: argument parsing, finds the merged manifest (`app/build/intermediates/merged_manifests/...`), parse helper, exit codes, a clear "manifest not found, run assemble first" message. | new script | **done** (see "4E-1" below; skeleton, no rule yet; tested on hand-made manifests) |
| 4E-2 | Provider and authority rules | `${applicationId}.shizuku` exactly once and owned by `moe.shizuku.manager.ShizukuManagerProvider`; no `rikka.shizuku.ShizukuProvider` left. | script | **done** (see "4E-2" below; four rules, tested on hand-made manifests and on a pseudo-merge of the real patched Shizuku + Mika manifests) |
| 4E-3 | Permission rules | `DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION` still declared; no `uses-permission API_V23`; `MANAGER` and `API_V23` each declared once. Added beyond the row text (same habit as 4E-2): the levels of the two declared permissions, the host asks for `MANAGER` exactly once, and the `uses-permission` of `DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION` is still there. | script | **done** (see "4E-3" below; five rules, 30 hand-made cases; nothing but the checker script changed) |
| 4E-4a | Component rules | 9 activities, 1 service, 2 receivers, 1 provider from `moe.shizuku.manager`; the exported ones are exactly the expected three activities, the two receivers and the provider; no LAUNCHER filter from them; the service is not exported and its `foregroundServiceType` is exactly `shortService` (4D-2); exactly three components listen to `BOOT_COMPLETED` (`:app` `.BootReceiver`, Mika `.setup.BootRestoreReceiver`, `moe.shizuku.manager.receiver.BootCompleteReceiver`), none of the three filters sets a `priority` (4D-3). The direct-boot rule (none of `BootCompleteReceiver`, `ShizukuReceiver`, `ShizukuManagerProvider` is `directBootAware`, and `BootCompleteReceiver` has no `LOCKED_BOOT_COMPLETED` filter, finding 12) is **not** added here: it would fail until the patch exists, so it comes with row 5F. Added beyond the row text (same habit as 4E-2 / 4E-3): the check compares the component **names** (not only the counts), a component that is not in the expected exported list must not be exported, `LEANBACK_LAUNCHER` and `HOME` count as launcher categories too, and the `:app` boot receiver is matched by its simple name. | script | **done** (see "4E-4a" below; five rules, 40 hand-made cases; nothing but the checker script changed) |
| 4E-4b | String rules | No `moe.shizuku.privileged.api` left (one `<queries>` entry allowed until 7A removes it); `ShizukuApplication` absent; no `rikka.shizuku.ShizukuProvider`. Details fixed in 4E-4b: the allowed `<queries>` entry is a constant in the script (`STALE_QUERY_ALLOWED = 1`, row 7A-1 sets it to 0; **done in 7A-1.2**, the constant is 0 now); "absent" means no `<application android:name>` of the manager and no string containing `ShizukuApplication`; "no old provider" is a string check on top of `4E-2 old provider` (which looks at components). | script | **done** (see "4E-4b" below; three rules, 24 hand-made cases; nothing but the checker script changed) |
| 4E-4c | Self-test + notes | Self-test on a hand-made good and bad manifest for every rule of 4E-1 ... 4E-4b (the 22 cases tried by hand in 4E-2 are listed in its section, the 30 cases of 4E-3, the 40 of 4E-4a and the 24 of 4E-4b in theirs: reuse them); run on the real merged manifest if a build exists; README plan row, `docs/CHANGES-shizuku-part4e.md`. Details fixed in 4E-4c: the self-test is its own file, `shizuku/tools/test-check-merged-manifest.py` (not a flag of the checker, which stays a plain tool for the workflows); 122 cases (22 + 30 + 42 + 24 + 4) numbered like the lists above, each stating exactly which rules fire and how often; a coverage check (every one of the 17 rules is switched off in turn and some case must notice); checks of the rule registry, of the helper classes and of the command line (exit 0 / 1 / 2, the search under `app/build/intermediates`, three runs as a real process); a guard for the switch `STALE_QUERY_ALLOWED` of 7A-1; and, if a Gradle build exists, a run of the checker on its merged manifest (none exists here). Notes: this README and `docs/CHANGES-shizuku-part4e.md` (it covers all of 4E; the small `part4e1` ... `part4e4b` files stay). | script, docs | **done** (see "4E-4c" below; the checker's rules are unchanged, only its header, `--help` text and last output line were updated) |
| 4F-1 | Manifest rules in `check-gradle.py` | Add what can be checked without a build: overlay file present and wired only inside `shizukuIncluded`, no `ShizukuProvider` string in `src/main`, `check-provider-match.py` and `patch-upstream.py --check` callable. Added after 4E-4c: `test-check-merged-manifest.py` (the self-test) present and callable (`--list` exits 0). Details fixed in 4F-1: the overlay must also have exactly the shape of 4B-2 (no `package`, one `<application>` without attributes, one empty `<provider rikka.shizuku.ShizukuProvider tools:node="remove">`); "wired only inside `shizukuIncluded`" means: every mention of `src/shizuku` in `app/build.gradle.kts` sits inside an `if (shizukuIncluded) { }` block, there are exactly two (debug and release), and no other build file of the project mentions it; `app/src/debug` / `app/src/release` must have no manifest (the `srcFile` call would replace it); "no `ShizukuProvider` string" covers every text file of `app/src/main`, comments included; "callable" means the scripts run without the fetched sources (`check-provider-match.py --self-test` exit 0 and without sources exit 2, `patch-upstream.py --help` exit 0, `patch-upstream.py --check` and `patch-upstream.sh --check` on an empty folder exit 1 with their own message and no traceback, `check-merged-manifest.py --help`, `test-check-merged-manifest.py --list`); `check-gradle.py` got its own `--self-test` (33 cases) and `--no-run`. | `shizuku/tools/check-gradle.py` | **done** (see "4F-1" below; seven rule groups in item 9 of the script, 33 self-test cases) |
| 4F-2 | Switch + stale notes | Re-check that `includeShizuku` is still `false` by default (`gradle.properties`, `app`, root); fix the leftover "cannot be installed with `:mika`" notes (README step 3 text, the 3F finding, the first-CI-run list; the `docs/CHANGES-*` files stay as history). Details fixed in 4F-2: the re-check reads every place that can set the switch (`settings.gradle.kts` default string, uncommented lines of `gradle.properties`, the three workflows, every script outside `shizuku/`, `app` and root build files which only test `findProject`) and runs `check-gradle.py`, which already fails if the default is flipped or `includeShizuku` is set in `gradle.properties` (check 8); the stale notes were hunted in **every** file of the zip (not only the three named: also `settings.gradle.kts`, `gradle.properties`, `app/build.gradle.kts` and the root `README.md`), `docs/CHANGES-*` stay; the 4B-4 comment in `app/build.gradle.kts` that said 4C - 4E were "NOT yet done" is brought up to date too. | README, comments | **done** (see "4F-2" below; three comments and the notes changed, no behaviour change) |
| 4F-3 | Root checks | The root checks run all three Shizuku checkers and, since 4E-4c, the self-test of the merged-manifest checker (`python3 -I shizuku/tools/test-check-merged-manifest.py --no-real`: no build needed) and the self-test of `check-gradle.py` (`python3 -I shizuku/tools/check-gradle.py --self-test`, since 4F-1; `check-gradle.py` itself already runs the helper scripts); one failing rule fails the whole check with a clear message. Details fixed in 4F-3: "the root check" is `mika/tools/static-check.py`, the project-wide read-only check (workflows, scripts, XML, resource clashes, Gradle wiring); it got check 11, which calls the new `shizuku/tools/check-all.py`. `check-all.py` runs seven steps, each as its own `python3 -I -B` process, ALL of them even after one failed: S1 `check-gradle.py`, S2 `check-gradle.py --self-test` (33 cases), S3 `test-check-merged-manifest.py --no-real` (122 cases), S4 `check-provider-match.py --self-test` (12 cases), and three steps that need what the zip does not hold: S5 `check-provider-match.py` on the real fetched manifests, S6 `patch-upstream.py --check` on a patched checkout, S7 `check-merged-manifest.py --variant release|debug` on the real merged manifest. S5 - S7 are SKIPPED with a reason when their input is missing (so a bare checkout is green) and a real step that exits 2 is a skip too; `--require-real` turns every skip into a failure (for a CI step after fetch + patch + build), `--no-real` skips S5 - S7 always. The row text said "all three Shizuku checkers": they are `check-gradle.py`, `check-provider-match.py` and `check-merged-manifest.py`; `patch-upstream.py --check` is added as S6 because it is the self-check of the patch and costs one line. `check-gradle.py` is not changed (it already runs its own helper scripts; check-all is not one of them, so there is no loop). `check-all.py` has its own `--self-test` (64 checks on a fake root of stub scripts: all green, each step failing in turn, missing script, timeout, real inputs present / absent / half present, the env override of the upstream folders, `--no-real`, `--require-real`, the command line, three real processes). | `shizuku/tools/check-all.py` (new), `mika/tools/static-check.py` | **done** (see "4F-3" below) |
| 4G-1 | `NOTICE-Shizuku.md` | Permission section: `MANAGER`, `API_V23`, the removed guard, the new `uses-feature`; what is declared once and by whom. Details fixed in 4G-1: new section "Permissions, who declares what" with a table of the two declared permissions and their levels, a list of what the host requests (`MANAGER` once; `API_V23` not, kept out by the guard and by the unmerged API manifest; no `V3_SUPPORT` meta-data), the removed `DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION` markers, the other permission names of the manager manifest, a table of the five shared `uses-permission`, the two `uses-feature`, and what is not changed (with the open rows 5E - 5G); two new items in the list of changes (the dropped markers, the overlay that removes Mika's provider); the two status lines of the notice brought up to date; each statement names the rule that checks it. | `NOTICE-Shizuku.md` | **done** (see "4G-1" below; documentation only) |
| 4G-2 | Step 4 notes + zip | README plan row (step 4 done), step 4 / step 7 notes, `docs/CHANGES-shizuku-part4.md`; flat zip `RizwanS2-main-shizuku-step4.zip`. Details fixed in 4G-2: new section "4G-2" with the 26 rows at a glance (result and files per row, what changed in the project by kind, what was never touched), the final state of the 14 findings, the 15 decisions of step 4 consolidated, the checks that exist now (command, what it proves, size), the open list for the first CI run, the hand-over to steps 5 - 8 (what each later row has to do with what step 4 found, including a correction of row 7C: with the switch on the host no longer requests `API_V23`, so 7C checks the run-time path), what was run; notes of step 4 added to rows 5A, 5F, 7A-1, 7B, 7C, 7D and 8F; `docs/CHANGES-shizuku-part4.md` covers all of step 4 (the small files stay as history). | README, docs, zip | **done** (see "4G-2" below; documentation only) |

Notes: both manifests exist only after fetch + patch; if GitHub is unreachable, 4A is written from the patch script and this README and the first CI run confirms it (4E exists to catch a mismatch). Step 4 does **not** turn `includeShizuku` on by default: that is steps 8 / 10.

## 4A — Inventory of the manifests (what clashes, what overlaps)

**Method.** This time GitHub was reachable, so the real files were read, not guessed: `shizuku/tools/fetch-upstream.sh` + `patch-upstream.sh` (Shizuku v13.6.0, API 510fc98; patch self-check ok, 9 host-package places in 7 files, 237 resource names renamed, 42 languages), and `mika/tools/fetch-upstream.sh` + `patch-upstream.sh` (Mika 0.1.52, 7ff1703). Read: the patched `shizuku/upstream/manager/src/main/AndroidManifest.xml` (the `:shizuku` library manifest), the 11 other upstream manifests (10 are empty `<manifest />`, `api/provider` has two lines, `api/demo` is not built), the patched Mika library manifest `mika/upstream/app/src/main/AndroidManifest.xml`, and `app/src/main/AndroidManifest.xml`. No Gradle run (no Maven / Google access), so the *merged* result is still unseen: that is what 4E checks and the first CI run confirms. Nothing was changed in this part except documentation.

**Who owns which namespace** (relative names like `.MainActivity` are resolved against it, so there is **no** name clash even though three modules have a `MainActivity`): `:app` = `com.srizwan.win11`, `:shizuku` = `moe.shizuku.manager`, `:mika` = `com.wangzan101.mika`. `${applicationId}` is the host package `com.srizwan.win11` in all three.

### Components of `:shizuku` (all 14 of its manifest, nothing else is added by the other ten Shizuku modules)

| Component | Exported / permission / filter | Verdict |
|-----------|-------------------------------|---------|
| activity `MainActivity` | not exported, no filter (Start menu starts it, step 6) | ok |
| activity `management.ApplicationManagementActivity`, `adb.AdbPairingTutorialActivity`, `shell.ShellTutorialActivity`, `starter.StarterActivity` | no `exported`, no filter = not exported | ok |
| activity `settings.SettingsActivity` | `exported=false`, filter `APPLICATION_PREFERENCES` | ok |
| activity `authorization.RequestPermissionActivity` | exported, permission `INTERACT_ACROSS_USERS_FULL`, action `${applicationId}.intent.action.REQUEST_PERMISSION` | ok (the action follows the host package; clients that hard-code `moe.shizuku.privileged.api.intent.action...` are step 5) |
| activity `legacy.ShellRequestHandlerActivity` | exported, **no permission**, action `rikka.shizuku.intent.action.REQUEST_BINDER` | same as upstream |
| activity `legacy.LegacyIsNotSupportedActivity` | exported, permission `moe.shizuku.manager.permission.API` (a permission nobody declares: upstream quirk, only the system can start it), action `${applicationId}.intent.action.REQUEST_AUTHORIZATION` | same as upstream |
| service `adb.AdbPairingService` | not exported, `foregroundServiceType="shortService"` | needs no extra `FOREGROUND_SERVICE_*` permission (Android 14: `shortService` only needs `FOREGROUND_SERVICE`); **checked in 4D-2** (permission and type fine, time limit = finding 11) |
| receiver `receiver.BootCompleteReceiver` | exported, directBootAware, `LOCKED_BOOT_COMPLETED` + `BOOT_COMPLETED` | no clash, but **three** receivers now listen to `BOOT_COMPLETED` (`:app` `.BootReceiver`, Mika `.setup.BootRestoreReceiver`, this one); all three run, order is not defined, none consumes the broadcast; **checked in 4D-3** (order harmless; direct-boot start = finding 12, init before first boot = finding 13) |
| receiver `receiver.ShizukuReceiver` | exported, action `rikka.shizuku.intent.action.REQUEST_BINDER` | ok |
| provider `ShizukuManagerProvider` | exported, directBootAware, `multiprocess=false`, permission `INTERACT_ACROSS_USERS_FULL`, authority **`${applicationId}.shizuku`**, subclass of `rikka.shizuku.ShizukuProvider` | **CLASH 1** |
| no `<application>` attributes, no `ShizukuApplication` entry, no LAUNCHER filter | checked in the generated file (and by the patch self-check) | ok |

### Clashes and risks found

| # | Finding | Severity | Goes to |
|---|---------|----------|---------|
| 1 | **Provider authority.** Mika's manifest has `rikka.shizuku.ShizukuProvider` with the same authority `${applicationId}.shizuku`, exported, same permission, `multiprocess=false`. Two providers, one authority = `INSTALL_FAILED_CONFLICTING_PROVIDER`. The manager's provider is the one to keep: it is a subclass that also answers `sendUserService`, calls `disableAutomaticSuiInitialization()`, and `:mika` only uses the *class* `ShizukuProvider` (no `ShizukuProvider.` static call in Mika's Kotlin), so removing Mika's `<provider>` loses nothing. | blocker — **resolved in 4B-2** (overlay), checked in 4B-3, comments in 4B-4 | 4B |
| 2 | **`DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION` is removed for the whole app.** The manager manifest has both `<permission>` and `<uses-permission>` of `${applicationId}.DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION` with `tools:node="remove"`. In upstream that is an application (it removes what AndroidX core adds); here it is a *library*, and a library's marker applies to everything below it, so the permission would also disappear from `:app` and from every other module that uses `ContextCompat.registerReceiver(..., RECEIVER_NOT_EXPORTED)`. On Android 8 - 12 (minSdk 26) AndroidX then refuses the registration ("Permission ... is required by your application to receive broadcasts") = a crash in code that has nothing to do with Shizuku. | **high** (silent, device-dependent) — **fixed in 4C-1**, self-check rule in 4C-2, merged-manifest rule `4E-3 dynamic receiver` (done) | 4C: take both lines out of the generated manifest in `patch-upstream.py` (the manager does not need the removal) |
| 3 | **`uses-permission API_V23 tools:node="remove"`** (manager) is moot but harmless here: `:shizuku-provider` has `shizukuIgnored = manifest`, so Shizuku-API's own manifest (`uses-permission API_V23` and `meta-data moe.shizuku.client.V3_SUPPORT`) is **not** merged any more, although the Maven artifact it replaces carried both. Consequence: the host does not *request* `API_V23` (right: it is the manager; the server treats the manager app id as always allowed) and does not carry `V3_SUPPORT` (only read for *other* apps: `ShizukuService` line ~447 and `AuthorizationManager`, `LegacyIsNotSupportedActivity`). Keep the `remove` line anyway as a guard against any other library that brings the request back. | info — **checked in 4C-3** (guard kept, rule in the patch self-check; merged-manifest check **done in 4E-3**: rule `4E-3 no API_V23 request`) | 4C, check in 4E |
| 4 | **`<permission>` declarations.** `moe.shizuku.manager.permission.MANAGER` (signature) and `...API_V23` (dangerous, group `moe.shizuku.manager.permission-group.API`) are declared only by `:shizuku`; Mika declares neither (it got `API_V23` as a *request* from the Maven provider AAR, see 3). The names are kept on purpose: every Shizuku client and the server's `BinderSender` use them. Single owner = ok. The host also asks for `MANAGER` itself (`uses-permission`), which is what lets the server send it the binder. | ok — **checked in 4C-3**, merged-manifest rules `4E-3 declared once` / `levels` / `manager request` (done) | 4C |
| 5 | **Duplicate, identical `uses-permission`** (merge to one, no conflict): `RECEIVE_BOOT_COMPLETED` (`:app`, Mika, `:shizuku`), `FOREGROUND_SERVICE` (3x), `POST_NOTIFICATIONS` (3x), `INTERNET` (`:app`, Mika, `:shizuku`), `WRITE_SECURE_SETTINGS` (3x, all `tools:ignore="ProtectedPermissions"`). New to the app from `:shizuku`: only the two `<uses-feature>` (`leanback` and `touchscreen`, both `required=false`) and `permission-group`. **Checked in 4C-4b:** the two `<uses-feature>` are not new to the merged manifest either (`:mame`, `:ppsspp`, `:retroarch`, `:tui` already declare them, all `required=false`), so only the `permission-group` is new. | ok — **checked in 4C-4a (permissions) and 4C-4b (features)**, nothing to change | 4C |
| 6 | **Foreground-service types at targetSdk 37.** `:app` declares `FOREGROUND_SERVICE_DATA_SYNC`, `_MEDIA_PLAYBACK`, `_MEDIA_PROJECTION`, `_MICROPHONE`; Mika adds `_SPECIAL_USE`. `shortService` needs none. Nothing to add, but 4D re-checks against the merged manifest. **Checked in 4D-2** against the real upstream source: the service passes `FOREGROUND_SERVICE_TYPE_MANIFEST`, so the manifest type `shortService` is the only type in play; nothing to add. The same read found a time-limit risk, finding 11. | ok — **checked in 4D-2**, merged-manifest rule `4E-4a service` (done) | 4D |
| 7 | **Stale package in Mika's `<queries>`**: `<package android:name="moe.shizuku.privileged.api" />`, and the same string as `ShizukuController.SHIZUKU_PACKAGE` (Mika's Kotlin, the only place in Mika's `app` / `core` sources). It is the *external* Shizuku app; with the manager built in, the real package is the host. Not a manifest clash (a `<queries>` entry never conflicts), so it stays out of 4B - 4D; the patch for it belongs to step 7 (and the string-free check "no `moe.shizuku.privileged.api` left" of 4E must allow this one entry until then or step 7 must come first). | medium — merged-manifest rule `4E-4b stale package` (done; allows the one `<queries>` entry until 7A-1) | 7 (checker rule in 4E) |
| 8 | **Same action names, different components.** `rikka.shizuku.intent.action.REQUEST_BINDER` is on `ShizukuReceiver` and on `ShellRequestHandlerActivity` (both `:shizuku`, upstream does the same). `com.wangzan101.mika.SCHEDULE` (Mika) and `android.intent.action.BOOT_COMPLETED` are not Shizuku's. No two modules share an action with different meaning. | ok | - |
| 9 | **Process and task.** Shizuku components run in the main process like upstream; `:mika` has its own `taskAffinity="${applicationId}.rizwan"` for its activities, Shizuku's activities have none (they get the app task). The Start menu hook (step 6) decides how they open. | info — **process / task note written in 4D-4** (for 6A) | 6 |
| 10 | **Hard-coded host package in the patched manager.** `HomeViewModel.kt` holds `"com.srizwan.win11"` (written by the patch). The CI rename of the package (`SHIZUKU_HOST_PACKAGE` / the value read from `app/build.gradle.kts`) re-patches, so it follows; step 5 verifies. | info | 5 |
| 11 | **`AdbPairingService` has no `onTimeout` and runs longer than a short service may.** Found in 4D-2. The service is `shortService` (about 3 minutes, counted from `startForeground`), but it starts the mDNS search when the pairing tutorial opens and keeps it until pairing works or the user taps "stop". If that takes longer than the limit, Android 15+ calls `Service.onTimeout`; the service does not override it, so the system raises `RemoteServiceException` ("A foreground service of type ... did not stop within its timeout"). Upstream the crash kills only the Shizuku app; here the manager runs in the **main process**, so it would take down the whole app (emulators, browser, downloads). Fix is small and belongs in the patch script, not in a manifest: patch `AdbPairingService.kt` to override `onTimeout` (both signatures) with `stopForeground(STOP_FOREGROUND_REMOVE)` + `stopSelf()`. | **medium** (only when pairing takes > ~3 min, Android 14+ / 15+) | **fixed in 5E** (patch part F + self-check rule `check_pairing_timeout`, only tried on hand-made files), device check on the list of "4G-2", merged build in 10A |
| 12 | **The built-in manager makes the main process start in direct-boot mode.** Found in 4D-3. `BootCompleteReceiver` is `directBootAware` and listens to `LOCKED_BOOT_COMPLETED`; `ShizukuReceiver` and the provider are `directBootAware` too. Before `:shizuku`, no component of `:app` or of Mika's upstream manifest was `directBootAware` (grep of both manifests: no `directBootAware`, no `defaultToDeviceProtectedStorage`), so the app's process started only after the first unlock. Now, on a phone with a screen lock and file-based encryption, Android starts the **main process before the user unlocks** to deliver `LOCKED_BOOT_COMPLETED`, and runs `App.attachBaseContext` / `App.onCreate` there. Those use credential-protected storage (`AppLog.init` makes a log folder, `ThemeManager.syncHost`, `SealInit.init` with MMKV / Koin, `MikaApp.onCreate`, `wasMikaUsed` reads SharedPreferences); most blocks are in `try/catch`, so nothing crashes, but they can fail silently, and if the process survives the unlock (believed, not verified), the launcher would open half-initialised (no log file, no Seal setup, Mika not restarted) until the process dies. The receiver itself is safe: `ShizukuSettings` reads device-protected storage and catches the locked state. **Options:** (a) in `patch-upstream.py` remove `android:directBootAware` and the `LOCKED_BOOT_COMPLETED` filter from `BootCompleteReceiver` (declarative, small, one self-check rule; cost: Shizuku starts after the first unlock instead of before it, and `ShizukuReceiver` / the provider keep their flag but are only used after the server is up); (b) keep upstream and make the launcher part of `App.onCreate` return early while `UserManager.isUserUnlocked` is false, then finish at `ACTION_USER_UNLOCKED` (more code in `:app`, easy to get wrong). **Recommendation: (a).** Not changed in 4D-3 (docs only). | **medium** (screen-lock phones with encryption; only when Shizuku's boot start can run) | **decided in 4D-4: option (a+)**, patch + self-check rule in row 5F; **done in 5F** (patch part G, `check_direct_boot`, merged rule `5F direct boot`; see "5F") |
| 13 | **The boot receiver needs `ShizukuApplication.onCreate(app)` to have run.** Found in 4D-3. `BootCompleteReceiver` calls `ShizukuSettings.getLastLaunchMode()` (reads `getPreferences()`, which is `null` until `ShizukuSettings.initialize`) and `Starter.internalCommand` (reads `application`, a `lateinit` that throws until set). Both are set only by `ShizukuApplication.onCreate(app)`, the object the patch script makes from upstream's `Application` class. Nothing in `:app` calls it yet (step 6E). If `includeShizuku` were on without that call, the receiver would throw at **every boot** (after the `pingBinder()` check, so whenever no server is running) and close the main process. Safe today: the switch is off by default. Rule: the call goes early in `App.onCreate`, in the launcher-process part only (the other processes never receive boot broadcasts), and 8F must not flip the default before 6E is done. | **high if ordered wrongly** (boot crash), none today | place fixed in 4D-4 (see "4D-4"), 6E (call), 8F (order) |
| 14 | **Shizuku's night-mode setting is process-wide in the host.** Found in 4D-4. Upstream's `ShizukuApplication.onCreate` calls `AppCompatDelegate.setDefaultNightMode(ShizukuSettings.getNightMode())`, and the manager's Settings screen calls the same static when the user picks Light / Dark. `AppCompatDelegate.setDefaultNightMode` is a static of **stock `androidx.appcompat`**, which the host now shares with the manager (decision 1: the Rikka fork is excluded) and which about 26 files of `:app` (`AppCompatActivity`) use. As long as the stored value is the default (follow system, same as AppCompat's own default) nothing changes. Once the user picks Light or Dark inside Shizuku's Settings, every AppCompat screen of the whole host is forced to that mode, and it is applied again at every start (the init call re-reads it). The language setting does not leak: `LocaleDelegate.defaultLocale` is a plain static read only by the Rikka activities (checked in the RikkaX source), not `Locale.setDefault`. **Fix (decided in 4D-4, row 5G):** keep the stored setting but apply it per activity: drop the static call from the patched `ShizukuApplication.onCreate` and from `SettingsFragment`, and set `delegate.localNightMode = ShizukuSettings.getNightMode()` in the one base class `AppActivity` (all nine activities extend it: `MainActivity` -> `HomeActivity` -> `AppBarActivity` -> `AppActivity`; the three that are not app-bar screens extend `AppActivity` directly), plus a self-check rule. | **medium** (only after the user changes Shizuku's night mode, then the whole host changes) | 5G (patch + self-check rule), checked on the merged build in 10A **Done in 5G** (patch part H, `check_night_mode`; the real tree showed that `attachBaseContext` is the right place, not `onCreate`: see "5G"). |
| 15 | **The binder extra key must not be renamed.** Found in 5C. Part A of the patch script replaced every `moe.shizuku.privileged.api` of nine places, and four of them are not a package name but the **key** `moe.shizuku.privileged.api.intent.extra.BINDER`, under which the server hands the binder to a provider and which the provider reads. The key is a wire name shared with every Shizuku client in the world (third-party apps use the stock `rikka.shizuku.ShizukuProvider`, which reads exactly that key). With the key renamed to `<host>.intent.extra.BINDER` the server, the starter, the manager and the patched API provider would still agree with each other (so Mika and the manager itself would work), but no outside client would ever receive the binder. | **high for outside clients** (silent: they would just never connect), none for Mika | **fixed in 5C** (the patch keeps the key; self-check, sweep and `check-gradle.py` rules), see "5C" |
| 16 | **Android 8.0 / 8.1 fallback of the shell loader has no target package.** Found in 5D. `ShizukuShellLoader.requestForBinder` broadcasts `rikka.shizuku.intent.action.REQUEST_BINDER` with `.setPackage(<host>)` (patched by part A, so it reaches only the built-in manager). Only when `broadcastIntent` fails on Android 8.0 / 8.1 with the message "Calling application did not provide package name" it falls back to `Intent.createChooser(new Intent("rikka.shizuku.intent.action.REQUEST_BINDER") ...)` **without** a package, and starts that. The host's exported `ShellRequestHandlerActivity` listens to the same action, so with a **stock Shizuku also installed** the chooser lists two apps (the host alone: one). That is what upstream does too (any other app with that exported activity would appear), and it is a path of Android 8.0 / 8.1 only (minSdk 26, so reachable). Not patched in 5D: the fix would be one `.setPackage(host)` on the inner intent of the fallback, but nobody can run that path here and a chooser around an intent with a package is not known to behave. **Owner decision, default: leave as upstream**; if wanted, the edit joins the 5E patch session (one anchor, one self-check rule; the count of `REQUEST_BINDER` places in `BINDER_ACTION_FILES` stays). **5E (no network, no real source): not added, still "leave"**; if the owner wants it, it is a small new part G of the patch script with its own rule, in a later session on a checkout. | low (Android 8.0 / 8.1 and a second Shizuku manager installed) | device list of "4G-2" (new check), owner decision |

### What 4B - 4G take from this

- **4B** = finding 1 only (remove Mika's provider with `tools:node="remove"`, guarded by `shizukuIncluded`; mechanism decided in 4B-1: a build-type overlay manifest). Correction found in 4B-1: the manifest merger keys a `<provider>` by `android:name` only, so the marker does not need to match the authority; the authority is repeated in the overlay only as documentation.
- **4C** = findings 2 - 5 (finding 2 is a real change in `patch-upstream.py`: drop the `DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION` lines; its self-check gets the matching rule).
- **4D** = findings 6, 8, 9 and the BOOT_COMPLETED order (4D-3 added findings 12 and 13, both handed to 4D-4; 4D-4 decided 12, placed 13 and added 14).
- **4E** checker rules added by this inventory: authority `${applicationId}.shizuku` exactly once and owned by `moe.shizuku.manager.ShizukuManagerProvider`; `DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION` still declared in the merged manifest; no `uses-permission API_V23`; `MANAGER` and `API_V23` each declared once; no LAUNCHER filter from `moe.shizuku.manager.*`; 9 activities, 1 service, 2 receivers, 1 provider from `moe.shizuku.manager`.
- **Step 7** gets finding 7.

## 4B-1 — guard mechanism (decision)

**Question.** `tools:node="remove"` in `app/src/main/AndroidManifest.xml` would delete Mika's `rikka.shizuku.ShizukuProvider` in **every** build. That is wrong when `:mika` is built without `:shizuku`: Mika's provider is the only thing that receives the binder from an external Shizuku app. So the removal must exist exactly when `:shizuku` is in the build, and a Gradle property cannot switch a manifest marker by itself.

**What was read (this part changes nothing but this file).** AGP 8.13.2 (`build.gradle.kts`), Gradle 8.14.3 (wrapper). `:app` declares only a `release` build type (`debug` exists implicitly), has no product flavors, and `app/build.gradle.kts` already has `val shizukuIncluded = rootProject.findProject(":shizuku") != null` (line 10, the single source of truth, 3F). Mika's manifest is generated at build time (`mika/upstream/...`, patched by `mika/tools/patch-upstream.py`; its comments say nothing is removed from it and `mika/tools/check-manifest.py` checks that). `mika/tools/check-merged-manifest.py` requires every Mika component in the merged manifest (rule 2) and no authority twice (rule 7). The workflows call that checker.

| Way | Verdict | Why |
|-----|---------|-----|
| (i) Patch Mika's generated manifest from `:shizuku`'s side | rejected | Stateful: the checkout is cached, so switching `includeShizuku` off later leaves the provider removed. It also needs an ordering link between the two modules' patch tasks, and it breaks Mika's own "nothing is removed" check. |
| (ii) Build-type manifest overlay, selected by `shizukuIncluded` | **chosen** | Done by the manifest merger itself (build type outranks main, main outranks libraries), declarative, nothing stored on disk, the merged manifest is the real result, so the 4E checker and the CI see it. Off = the overlay is not wired = the build is exactly as before. |
| (iii) Unconditional marker in `src/main` | rejected | Breaks Mika-only builds (see above). |
| (iv) Task that edits `MERGED_MANIFEST` (`androidComponents.onVariants`, `artifacts.use(...).wiredWithFiles(...)`) | **fallback** | Works too, but edits the file after the merge, so lint and merger reports describe a different manifest, and it is more code. Used only if the overlay of 4B-2 fails in the first CI run. |
| (v) Product flavor `shizuku` on / off | rejected | Renames every variant task (`assembleDebug` becomes `assembleShizukuOnDebug`): all three workflows and every script would break. |

**Design for 4B-2.**
- New file `app/src/shizuku/AndroidManifest.xml` (the folder name matches no flavor, so AGP never picks it up by itself): `<manifest xmlns:android=... xmlns:tools=...><application><provider android:name="rikka.shizuku.ShizukuProvider" android:authority="${applicationId}.shizuku" tools:node="remove" /></application></manifest>`.
- In `app/build.gradle.kts`, inside `android { }`, only `if (shizukuIncluded)`: `sourceSets.getByName("debug").manifest.srcFile("src/shizuku/AndroidManifest.xml")` and the same for `"release"` (both build types, because `debug` is implicit and has no block).
- The marker cannot hit the manager's provider: that is `moe.shizuku.manager.ShizukuManagerProvider`, a different `android:name`. With `-PincludeMika=false` and Shizuku on, the marker matches nothing.

**Follow-ups this decision creates (already placed in rows):** 4B-3 must change `mika/tools/check-merged-manifest.py` rule 2 (otherwise the CI fails on the provider that was removed on purpose); 4B-4 fixes the "6 providers" count in the `:app` manifest comment (5 with Shizuku built in); 4E-2 stays valid ("no `rikka.shizuku.ShizukuProvider` left").

**Not verified (no Gradle run, no network here; 4B-3 and the first CI run confirm).**
1. That `sourceSets.getByName("debug").manifest.srcFile(...)` is accepted by AGP 8.13.2 as written (believed stable DSL). If not: way (iv).
2. That a `remove` marker which matches nothing is silent (believed; matters for `-PincludeMika=false`).
3. That an overlay manifest without a `package` attribute merges (believed: AGP 8 uses the namespace).
4. That the merger really keys providers by `android:name` only (documented behaviour as far as known; the 4A wording "repeat the authority so the marker matches" was stricter than needed).

## 4B-2 — the removal is applied (done)

Changed: one new file, one edit. Nothing else (no script, workflow, Mika file, other manifest); `includeShizuku` is still off by default, so with the default switch the build is the same as before this part.

1. **New `app/src/shizuku/AndroidManifest.xml`** (exactly the design of 4B-1): `<manifest>` with `xmlns:android` and `xmlns:tools`, no `package` attribute, one `<application>` holding `<provider android:name="rikka.shizuku.ShizukuProvider" android:authority="${applicationId}.shizuku" tools:node="remove" />`. The long comment in the file says why, how, and that the element must never move into `src/main` (it would remove Mika's provider in Mika-only builds too). The name is Mika's provider name exactly as in the 4A inventory (finding 1); the authority is repeated as documentation only.
2. **`app/build.gradle.kts`**, inside `android { }`, right after `buildTypes { }`:
   `if (shizukuIncluded) { sourceSets.getByName("debug").manifest.srcFile("src/shizuku/AndroidManifest.xml"); sourceSets.getByName("release").manifest.srcFile("src/shizuku/AndroidManifest.xml") }`
   Both build types, because `debug` is implicit (no block in the file) and `release` is declared. `shizukuIncluded` is the existing single source of truth (line 10, 3F), so the overlay exists exactly when `:shizuku` is in the build.

| Case | What the merged manifest has |
|------|------------------------------|
| `includeShizuku` off (default) | overlay not wired, never read: Mika's `rikka.shizuku.ShizukuProvider` stays (unchanged build) |
| Shizuku on, Mika on | Mika's provider removed, only `moe.shizuku.manager.ShizukuManagerProvider` owns `${applicationId}.shizuku` |
| Shizuku on, `-PincludeMika=false` | the marker matches nothing (believed silent, point 2 below) |

What this part deliberately did **not** touch (placed in other rows): the comment in `app/build.gradle.kts` that says an APK with both modules "cannot be installed yet" and the "6 providers" comment in `app/src/main/AndroidManifest.xml` = 4B-4; the rule 2 of `mika/tools/check-merged-manifest.py` and the match-check script = 4B-3 (until 4B-3 is done the Mika checker fails on a Shizuku-on merged manifest, but no workflow builds with Shizuku on yet); the manifest rules of the new checker = 4E.

Checked here: the overlay is well-formed XML; the Kotlin edit is a plain statement block (balanced, `tools/check-gradle.py`: 15 `.kts` files fine, 11 unique namespaces, includes <-> folders consistent); the edit changed exactly one place of `app/build.gradle.kts` (the `old` text occurred once).

**Not verified (no Gradle run, no network; first CI run with `-PincludeShizuku=true` confirms, 4E checks the result).** Same four points as in 4B-1:
1. `sourceSets.getByName("debug").manifest.srcFile(...)` accepted by AGP 8.13.2 as written. If not: way (iv) of 4B-1 (edit `MERGED_MANIFEST`).
2. A `remove` marker that matches nothing is silent (Shizuku on, Mika off).
3. An overlay manifest without `package` merges (AGP 8 uses the namespace).
4. The merger keys providers by `android:name` only.
Symptom if the overlay does not work: `INSTALL_FAILED_CONFLICTING_PROVIDER` at install, or the merged manifest (`app/build/intermediates/merged_manifests/<variant>/.../AndroidManifest.xml`) still holds `rikka.shizuku.ShizukuProvider`.

## 4B-3 — match check and Mika checker (done)

**Fetch + patch ran for real this time** (GitHub reachable: Shizuku v13.6.0 `fetch-upstream.sh` + `patch-upstream.sh`, self-check ok, 9 host-package places in 7 files, 237 resource names, 42 languages — unchanged numbers; Mika 0.1.52 `fetch` + `patch`). So the 4A / 4B-1 statements about the two providers are now confirmed on the real files, not only read from the patch scripts:

| | Mika's patched `app/src/main/AndroidManifest.xml` (line 395) | manager's patched manifest (line 64) |
|---|---|---|
| name | `rikka.shizuku.ShizukuProvider` (absolute) | `.ShizukuManagerProvider` = `moe.shizuku.manager.ShizukuManagerProvider` |
| attribute | `android:authorities="${applicationId}.shizuku"` | `android:authorities="${applicationId}.shizuku"` (same) |
| exported / permission | `true` / `INTERACT_ACROSS_USERS_FULL`, `multiprocess=false` | same, plus `directBootAware=true` |

Also confirmed: **no file of Mika's sources mentions `ShizukuProvider` at all** (not only "no static call": no import, no class reference, no ProGuard rule), and `ShizukuManagerProvider.kt` is `class ShizukuManagerProvider : ShizukuProvider()`. The marker removes one element and loses no code path.

### (a) `shizuku/tools/check-provider-match.py` (new)

Reads the real patched manifests plus our overlay, `app/build.gradle.kts` and `app/src/main/AndroidManifest.xml`; needs only python3 (`python3 -I` works); `--self-test` needs no upstream. Env `SHIZUKU_UPSTREAM_DIR` / `MIKA_UPSTREAM_DIR`. Exit 0 ok, 1 = a rule failed (`::error::` lines), 2 = an input is missing ("run the fetch + patch scripts first"). Rules:

1. Mika declares exactly one provider named `rikka.shizuku.ShizukuProvider`.
2. The overlay has exactly one `<application>` child, a `<provider>` with `tools:node="remove"` and the same name as Mika's provider; no `package` attribute; the documentation authority is `${applicationId}.shizuku`.
3. The manager's only provider is `moe.shizuku.manager.ShizukuManagerProvider` (a different name: the marker cannot remove it), with the same authority as Mika's, equal to `${applicationId}.shizuku`; its class extends `ShizukuProvider`.
4. The marker matches one component of Mika and none of the manager; no other Mika provider uses the authority.
5. No Kotlin / Java source of Mika refers to `ShizukuProvider`.
6. Switch-off safety: in `app/build.gradle.kts` (line comments ignored) every mention of `src/shizuku/AndroidManifest.xml` is a `sourceSets.getByName("debug"|"release").manifest.srcFile(...)` line, exactly the two, all inside `if (shizukuIncluded) { }`; `app/src/main/AndroidManifest.xml` mentions no `ShizukuProvider` and declares no `rikka.shizuku.*` / `moe.shizuku.manager.*` component.

Result on the real files: ok (`Shizuku provider match ok: ...`). Self-test: 12 of 12 cases (1 good + 11 bad: wrong marker name, marker not `remove`, marker that would hit the manager's provider, different authorities, two providers in Mika, Mika source using the class, manager provider no longer a subclass, overlay wired outside the guard, wired for debug only, removal in `src/main`, `package` in the overlay) give the expected verdict. It is not wired into a workflow yet (4E / 8D put the manifest checks in the CI); run it by hand after fetch + patch.

### (b) `mika/tools/check-merged-manifest.py`, rule 2

Without the change the Mika checker would fail on the intentional removal ("provider rikka.shizuku.ShizukuProvider is in Mika's manifest but not in the merged manifest"). Now: a missing `rikka.shizuku.ShizukuProvider` is accepted **only if** `moe.shizuku.manager.ShizukuManagerProvider` is a `<provider>` of the merged manifest with an authority ending in `.shizuku`; the summary line then counts 5 providers and says the replacement was on purpose. Nothing else of the script changed (rules 1, 3 - 7 as before; rule 7 still fails if both providers survive with one authority). Tested on 5 merged manifests generated from the REAL patched Mika manifest (placeholders resolved, `:app`'s HOME activity added, provider swapped):

| Merged manifest | Verdict |
|---|---|
| untouched (Mika only; 30 permissions, 31 components: 7 activity, 6 provider, 7 receiver, 11 service) | ok, as before |
| Mika's provider removed + manager provider with `com.srizwan.win11.shizuku` | ok (30 components counted, 5 providers) |
| Mika's provider removed, no manager provider | error (still "not in the merged manifest") |
| Mika's provider removed, manager provider with another authority | error (authority does not end in `.shizuku`) |
| both providers present (overlay did not work) | error (rule 7: authority used twice) |

The workflows are unchanged: they build without Shizuku, so the checker takes the old path.

Not verified (no Gradle run): the real merged manifest of a `-PincludeShizuku=true` build; the four points of 4B-2. 4E turns the Shizuku side of this into a checker for the merged manifest.

## 4B-4 — notes and zip (done)

Only comments and documentation; no code, script, manifest element or workflow changed, nothing was built.

1. **`app/build.gradle.kts`**, comment above `implementation(project(":shizuku"))`: the old text said an APK with both `:mika` and `:shizuku` "cannot be installed yet" because both declare a provider with the authority `${applicationId}.shizuku`. That is no longer true since 4B-2: the build-type overlay `src/shizuku/AndroidManifest.xml` removes Mika's `rikka.shizuku.ShizukuProvider`. The comment now says so and lists what is still open (4C - 4E manifest rows, step 6 hooks, switch stays off until 8F).
2. **`app/src/main/AndroidManifest.xml`**, Mika block: "6 providers (4 file providers, the helper hand-off, Shizuku ...)" now adds that with `:shizuku` built in Mika's Shizuku provider is removed by the overlay, so the merged manifest has 5 (the count 6 stays right for a build without Shizuku; `mika/tools/check-manifest.py` and the 4B-3 Mika checker use the same numbers). The text mentions the class only as "Shizuku provider" and the overlay by path, so `check-provider-match.py` rule 6 (no `ShizukuProvider` in `src/main`) is not touched.
3. **This file**: plan row (4B done, 4C-1 next), row 4B-4 flipped, finding 1 marked resolved, this section.
4. **`docs/CHANGES-shizuku-part4b.md`** (new, covers 4B-1 ... 4B-4 together; the four small files `part4b1` - `part4b3` stay) and the flat zip `RizwanS2-main-shizuku-step4b.zip`.

Checked: `app/src/main/AndroidManifest.xml` is well-formed XML; `shizuku/tools/check-gradle.py` ok (15 `.kts` files, 11 unique namespaces); `shizuku/tools/check-provider-match.py --self-test` 12 of 12; the rule-6 strings (`ShizukuProvider` count in `src/main` = 0, the two `srcFile` lines inside `if (shizukuIncluded)`) were grepped. Not rerun: the real-file mode of `check-provider-match.py` (needs the fetched `upstream/` folders, not in the zip) and any Gradle run.

**What step 4B leaves open for the first CI run** (`-PincludeShizuku=true`): the four points of 4B-2 (`sourceSets...manifest.srcFile` accepted by AGP 8.13.2; a marker that matches nothing is silent with `-PincludeMika=false`; overlay without `package` merges; provider keyed by `android:name` only). Symptom if wrong: `INSTALL_FAILED_CONFLICTING_PROVIDER`, or `rikka.shizuku.ShizukuProvider` still in the merged manifest. Fallback is way (iv) of 4B-1.

## 4C-1 — the `DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION` removal is dropped (done)

Finding 2 of 4A. Changed: `shizuku/tools/patch-upstream.py` only (docstring part B, `patch_manifest`, its print line). No Gradle file, manifest in the project, workflow or Mika file touched.

**What upstream has** (read on the real v13.6.0 checkout, lines 42 - 48 of `manager/src/main/AndroidManifest.xml`): one `<permission android:name="${applicationId}.DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION" android:protectionLevel="signature" tools:node="remove" />` and one `<uses-permission android:name="${applicationId}.DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION" tools:node="remove" />`. In upstream (an application) the markers cut what AndroidX core adds. Here `:shizuku` is a library and a library's marker applies to everything below it, so the permission would vanish from `:app` and from every module calling `ContextCompat.registerReceiver(..., RECEIVER_NOT_EXPORTED)`: on Android 8 - 12 (minSdk 26) AndroidX then throws "Permission ... is required by your application to receive broadcasts".

**What the patch does now.** `patch_manifest` finds the `<permission>` and the `<uses-permission>` of that name among the children of `<manifest>` and deletes both. It **fails loudly** (`die`, same style as the other anchors) unless exactly one of each exists and both carry `tools:node="remove"`, so an upstream change cannot slip through silently. The manager does not need the removal; AndroidX core's own declaration now reaches the merged manifest untouched.

**Result on the real checkout** (fetch + patch + forced re-patch + `--check`, all ok): 0 mentions of `DYNAMIC_RECEIVER` left in the generated manifest; the same file still has `MANAGER` (signature) and `API_V23` (dangerous, group `moe.shizuku.manager.permission-group.API`) declared once each, the `uses-permission API_V23 tools:node="remove"` guard (finding 3, 4C-3), `uses-permission MANAGER`, the 5 shared `uses-permission` and the two `uses-feature`, and 9 activities, 1 service, 2 receivers, 1 provider. Output of the run: "B. manifest: ... DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION markers dropped (2 elements)". The other counts did not move (host package 9 places in 7 files, 237 resource names, 87 files, 42 languages), `check-gradle.py` ok. The patch marker hash changes with the script, so existing checkouts are put back to the pristine state and patched again on the next build (that is the designed behaviour).

**Not done here (4C-2, done since):** the self-check rule "the permission must not carry a remove marker" and a README numbers re-check; 4E-3 checks the merged manifest ("still declared"). **Not verified:** the merged manifest of a real Gradle build (AndroidX core must be the source of the declaration; first CI run, 4E-3).

## 4C-2 — patch self-check rule (done; real-source rerun still open)

Changed: `shizuku/tools/patch-upstream.py` only (docstring part D, new function `check_dynamic_receiver_permission`, one call in `check`, the text of the "D. self-check ok" line). No Gradle file, project manifest, workflow, Mika file or other tool touched.

**The rule.** `check_dynamic_receiver_permission(man_xml, errors)` walks **every** element of the generated manager manifest (not only the children of `<manifest>`, so a marker moved into `<application>` is found too). An element whose `android:name` contains `DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION` and which carries `tools:node` = `remove`, `removeAll` or `replace` is an error ("it would remove the permission from the whole app"). A mention without a marker is allowed on purpose (a later upstream could declare it without a marker; 4C-1 already makes `patch_manifest` die unless the two upstream markers are exactly as known). A manifest that is not well-formed is reported as an error. It takes the XML **text**, so it can be tested without a checkout, and `check` calls it for the patch run **and** for `python3 patch-upstream.py --check`. Other `remove` markers (the `uses-permission API_V23` guard, finding 3 / 4C-3) are not touched by it.

**Self-test (hand-made manifests, no checkout needed): 10 of 10 as expected.** 3 good (no mention; declared without marker; the `API_V23` remove guard and an `INTERNET` request) and 7 bad (`<permission>` remove; `<uses-permission>` remove; both = 2 errors; marker moved into `<application>`; `removeAll`; `replace`; not well-formed). A synthetic upstream-like manifest (both markers, `API_V23` guard, LAUNCHER filter) run through the real `patch_manifest`: 0 `DYNAMIC_RECEIVER` left, the `API_V23` guard kept, 0 rule errors; the same manifest with one marker missing makes the patch die (4C-1 behaviour unchanged). `py_compile` ok; `check-gradle.py` ok (15 `.kts`, 11 namespaces).

**README numbers.** The rule only reads; it patches nothing, so no count can move. The numbers of 4C-1 stay as measured there: host package 9 places in 7 files, 237 resource names, 87 files, 42 languages, 9 activities / 1 service / 2 receivers / 1 provider, 0 `DYNAMIC_RECEIVER` in the generated manifest. The script hash changes (it hashes the script), so an existing checkout is put back to the pristine state and patched again on the next build (designed behaviour, same as after 4C-1).

**Not verified (this session had no network, `shizuku/upstream/` is not in the zip).** The rerun on the real v13.6.0 checkout (`fetch-upstream.sh`, `patch-upstream.sh`, forced re-patch, `--check`, expected output "D. self-check ok (... no remove marker on DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION ...)") and `check-provider-match.py` (it needs both fetched trees). Run these by hand or in the first CI run: if the real run fails, the message names the element. Also unchanged: the merged manifest of a real Gradle build (4E-3).

## 4C-3 — permission ownership (done; real-source rerun still open)

Findings 3 and 4 of 4A. **Nothing had to change in behaviour**: the design of 4A was right, so this part is a check, a rule and a comment. Changed: `shizuku/tools/patch-upstream.py` (docstring part D, new function `check_shizuku_permissions`, one call in `check`, the text of the "D. self-check ok" line) and `app/src/main/AndroidManifest.xml` (one comment, no element). No Gradle file, workflow, Mika file or other tool touched.

**What was checked in the project files (no network needed).**
1. **`:mika` does not touch the Shizuku permissions.** None of the 30 permissions in `KEEP_PERMISSIONS` of `mika/tools/patch-upstream.py` is a `moe.shizuku...` name, and `moe.shizuku.manager.permission.*` appears nowhere in the project outside `shizuku/` (and docs / this README). So a request for `API_V23` cannot come from Mika's own manifest, and the guard has nothing of Mika's to fight with.
2. **The only other source of the `API_V23` request is gone with the switch on.** The Maven `dev.rikka.shizuku:api` / `:provider` AARs carried it; the root `build.gradle.kts` (step 3F) answers every request for the four `dev.rikka.shizuku:*` artifacts with the local `:shizuku-*` projects in every module and configuration, and their manifests are `shizukuIgnored = manifest` (not merged). Only `mika/build.gradle.kts` asks for them. With the switch **off** the Maven AARs are used as before and `:shizuku` (the manager) does not exist, so nothing changes there.
3. **Merge order does not matter for this.** `:mika` comes before `:shizuku` in `app/build.gradle.kts` (lines 139 / 147). Even if that order decided who may remove what, there is nothing from Mika to remove (point 1); and the guard in the manager manifest is only a *safety net* for a future library that would ask for `API_V23`.
4. **The host asks for `MANAGER`, and only through the library.** `:app`'s own manifest declares neither permission (the new comment says so and why); `MANAGER` is requested by the `uses-permission` of the manager manifest, which merges into the app. That request is what lets the server send the manager the binder.

**The new self-check rule** (`check_shizuku_permissions(man_xml, errors)`, on the generated manager manifest, patch run and `--check`; it takes the XML text so it is testable without a checkout): exactly one `<permission>` `moe.shizuku.manager.permission.MANAGER` with `protectionLevel=signature` and exactly one `...API_V23` with `dangerous` and `permissionGroup=moe.shizuku.manager.permission-group.API`, neither carrying a `tools:node` marker; exactly one `<uses-permission>` of `MANAGER` **without** a marker (the host must ask); exactly one `<uses-permission>` of `API_V23` **with** `tools:node="remove"` (the guard must stay, the host must not request it). Any other count or value is an error that names the permission.

**Self-test (hand-made manifests): 15 of 15 as expected** (1 good; 14 bad: `MANAGER` declared twice / not at all, `API_V23` not declared / twice, wrong protection levels, wrong group, a declaration with a remove marker, guard lost, guard without `remove`, guard twice, host no longer asks for `MANAGER`, the `MANAGER` request removed, not well-formed). Together with the 4C-2 rule a good manifest gives 0 errors. `py_compile` ok, `check-gradle.py` ok (15 `.kts`, 11 namespaces), the `:app` manifest is still well-formed and holds no `ShizukuProvider` string (rule 6 of `check-provider-match.py`).

**Not verified (no network in this session, `shizuku/upstream/` is not in the zip).** The rule is written from what 4A read on the real v13.6.0 manifest (names, levels, group, the guard line); it has not run on the real generated file. If the real run fails, the message names the permission and the count found; then either the rule or this README is wrong, not the app. Same open list as 4C-2: rerun of fetch + patch + `--check`, `check-provider-match.py`, the merged manifest of a real Gradle build (4E-3, first CI run).

## 4C-4a — duplicate `uses-permission` (done)

Finding 5, first half. **Docs only, nothing changed in code.** Real files this time: `shizuku/tools/fetch-upstream.sh` + `patch-upstream.sh` (Shizuku v13.6.0, self-check ok, numbers unchanged: 237 resource names, 87 files, 42 languages) and `mika/tools/fetch-upstream.sh` + `patch-upstream.sh` (Mika 0.1.52). Read: `app/src/main/AndroidManifest.xml`, `mika/upstream/app/src/main/AndroidManifest.xml`, `shizuku/upstream/manager/src/main/AndroidManifest.xml` (parsed with an XML parser, every `<uses-permission>` of the five names, with all attributes besides `name`).

| `android.permission.` | `:app` | Mika | `:shizuku` | Verdict |
|---|---|---|---|---|
| `RECEIVE_BOOT_COMPLETED` | yes, no attribute | yes, none | yes, none | identical, merges to one |
| `FOREGROUND_SERVICE` | yes, none | yes, none | yes, none | identical |
| `POST_NOTIFICATIONS` | yes, none | yes, none | yes, none | identical |
| `INTERNET` | yes, none | yes, none | yes, none | identical |
| `WRITE_SECURE_SETTINGS` | yes, `tools:ignore="ProtectedPermissions"` | same | same | identical (the lint ignore is the only attribute) |

Each name appears once per manifest, none has `maxSdkVersion` or a `tools:node` marker, so the merger has nothing to conflict on: the merged manifest holds each once. Merged-manifest proof stays with 4E-3 / the first CI run (no Gradle run here).

Side result for 4C-4b: Mika declares five `<uses-feature>` (camera, microphone, telephony, location, location.gps, all `required=false`); `:app` declares none; `:shizuku` adds `leanback` and `touchscreen` (both `required=false`).

Next: 4C-4b.

## 4C-4b — `uses-feature` (done)

Finding 5, second half. **Docs only, nothing changed in code, manifests, scripts or workflows; nothing built.** Method: every `AndroidManifest.xml` in the project zip (17 files, parsed with an XML parser, every `<uses-feature>` with `name`, `required` and any `tools:node`) plus the two generated manifests as recorded in 4A / 4C-4a (`:shizuku` and Mika are fetched at build time, not in the zip; no network in this session).

**What `:shizuku` brings:** `android.hardware.touchscreen` and `android.software.leanback`, both `required="false"`, no `tools:node`.

| Question | Answer |
|----------|--------|
| Does `:app` already declare them? | No. `:app`'s own manifest has **no** `<uses-feature>` at all (its comment says the features come from the library manifests), so there is nothing of `:app` that `:shizuku` could override, and no `tools:node` marker on any feature anywhere. |
| Are they new to the merged manifest? | **No.** Already declared, both with `required="false"`: `touchscreen` in `:mame`, `:ppsspp`, `:retroarch`, `:tui`; `leanback` in `:ppsspp`, `:retroarch`. The `:shizuku` lines are identical duplicates and merge to one each. Nothing is new to the app from `:shizuku` except the `permission-group` (finding 4). |
| Can `required="false"` hide the app on a device? | No. `required="false"` only says the app can use the feature; it removes a filter, it never adds one. For `touchscreen` it even widens the app (without a declaration Google Play treats a touchscreen as required). `leanback` with `false` means "not only for TV". Neither is checked by the installer, only by store filtering. |
| Any `required="true"` on these two names anywhere? | No. The only `required="true"` in the project is `glEsVersion 0x00020000` in `:winlator` (OpenGL ES 2.0, not related). Different values for the same feature name in two libraries would be a merger conflict; there is none. |
| Is `:app`'s own manifest touched? | No. Nothing differed, so nothing was added (no `tools:node`, no `tools:replace`). |

Features of other modules, read for completeness (all pre-existing, none caused by Shizuku): `camera` is `required="false"` in `:camera`, `:j2me`, `:tui`, `:ppsspp` and Mika, but **`:Bcore` declares `android.hardware.camera` without `required`** (default true). That is the same case as before this step and the build already works with it; it is the only place that could filter devices without a camera on the store side, and it is not part of Shizuku (noted here, not changed).

Merged-manifest proof of the above is still open: 4E (checker) and the first CI run. Self-checks: `shizuku/tools/check-gradle.py` and the other tools were not needed for a docs-only part.

Next: 4C-4c (README plan row 4C done, finding 5 marked checked, `docs/CHANGES-shizuku-part4c.md`, flat zip `RizwanS2-main-shizuku-step4c.zip`).

## 4C-4c — notes and zip (done; 4C is complete)

**Docs only, nothing changed in code, manifests, scripts or workflows; nothing built.** Changed: this file (plan row 4: 4C done, 4D-1 next; row 4C-4c done; finding 5 marked checked; this section) and the new `docs/CHANGES-shizuku-part4c.md`; the small files `part4c1` - `part4c4b` stay as history. Flat zip: `RizwanS2-main-shizuku-step4c.zip`.

| Row | Result |
|-----|--------|
| 4C-1 | `DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION` lines are dropped from the generated manager manifest (finding 2, real change in `patch-upstream.py`) |
| 4C-2 | self-check rule: the permission must not carry a remove marker; counts unchanged (9 places in 7 files, 237 names, 42 languages) |
| 4C-3 | `MANAGER` and `API_V23` have one owner (`:shizuku`); guard kept; second self-check rule; one comment in the `:app` manifest (findings 3, 4) |
| 4C-4a | five shared `uses-permission` identical in `:app`, Mika, `:shizuku`: merge to one each (finding 5, first half) |
| 4C-4b | `touchscreen` / `leanback` `required=false`: not new to the merged manifest, `:app` declares none, cannot hide the app (finding 5, second half) |

Still open from 4C (nothing new): the rerun of fetch + patch + `--check` on the real source after 4C-1 ... 4C-3 (**closed in 4E-2: it ran, self-check ok**), and the merged manifest of a real Gradle build (4E-3, first CI run).

Next: 4D-1 (the 9 activities: three exported on purpose, no LAUNCHER filter, `SettingsActivity` `APPLICATION_PREFERENCES` filter against `:app` and Mika).

## 4D-1 — activities (done)

**Docs only, nothing changed in code, manifests, scripts or workflows; nothing built.** Read: the 4A table (real v13.6.0 manifest), `shizuku/tools/patch-upstream.py` (what it does to the activities), `app/src/main/AndroidManifest.xml`, the `:j2me` manifest, `mika/README.md` and `mika/tools/*.py` (what Mika's manifest keeps), and every `.kt` / `.java` / `.xml` / `.md` in the zip for the string `APPLICATION_PREFERENCES`. The generated Shizuku and Mika manifests are not in the zip (fetched at build time, no network in this session), so what follows rests on 4A, the patch scripts and the other manifests; 4E-4a and the first CI run confirm it.

**The 9 activities of `:shizuku`** (`MainActivity`, `ApplicationManagementActivity`, `AdbPairingTutorialActivity`, `ShellTutorialActivity`, `StarterActivity`, `SettingsActivity`, `RequestPermissionActivity`, `ShellRequestHandlerActivity`, `LegacyIsNotSupportedActivity`):

| Question | Answer |
|----------|--------|
| Which are exported? | Exactly three, on purpose: `RequestPermissionActivity` (permission `INTERACT_ACROSS_USERS_FULL`, action `${applicationId}.intent.action.REQUEST_PERMISSION`), `ShellRequestHandlerActivity` (no permission, action `rikka.shizuku.intent.action.REQUEST_BINDER`) and `LegacyIsNotSupportedActivity` (permission `moe.shizuku.manager.permission.API`, action `${applicationId}.intent.action.REQUEST_AUTHORIZATION`). The other six are not exported. All nine, "not exported", in the old row was too short (corrected in the row text above and in 4E-4a). |
| `MainActivity` | The patch script removes **all** its intent filters (not only LAUNCHER) and writes `android:exported="false"`; it dies if upstream has no LAUNCHER filter. So no MAIN / LAUNCHER and no HOME category from `:shizuku`, and `:app`'s `MainActivity` stays the only HOME activity (lines with MAIN + HOME in the `:app` manifest). The Start menu starts it (step 6). |
| LAUNCHER filter from any of the nine? | No. The other eight have none upstream (4A) and the patch self-check rejects a LAUNCHER filter in the generated manifest. A launcher entry from Shizuku would put a second "Shizuku" icon in the system launcher; none appears. |
| Name clash with `:app` / Mika / others? | No. `MainActivity` exists in `:app`, `:mika` and `:shizuku`, but relative names resolve against each module's own namespace (`com.srizwan.win11`, `com.wangzan101.mika`, `moe.shizuku.manager`), so the merged manifest has three different components. `SettingsActivity` exists in `:j2me` as `ru.playsoftware.j2meloader.settings.SettingsActivity`, a different full name. |
| Theme | Every activity carries the Shizuku theme itself (patch step B: `@style/AppTheme` where none was set), because `:app`'s `<application android:theme>` is not the Shizuku one. |
| `SettingsActivity` `APPLICATION_PREFERENCES` filter | `exported="false"`, action `android.intent.action.APPLICATION_PREFERENCES` + DEFAULT. Against the rest of the app: **`:j2me` already has the same pattern** (`ru.playsoftware.j2meloader.settings.SettingsActivity`, `exported="false"`, same action, same category); `:app` has none; nothing in the project's Kotlin / Java / XML starts anything by that action; in Mika's manifest as documented (`mika/README.md`, `mika/tools/patch-upstream.py`) the `MainActivity` has the SEND / SEND_MULTIPLE share filters and the Quick Settings tile-preferences filter (`QS_TILE_PREFERENCES`, a different action), no `APPLICATION_PREFERENCES`. Result: two non-exported activities with the action in one package; other apps and the system Settings cannot start a non-exported activity of this app, so the filter only matters for in-app resolution, which nothing does; there is no ambiguity and no clash. Nothing to change. |

Not changed on purpose: `:app` manifest (no element, no attribute, no comment: nothing differed), `patch-upstream.py` (the rules for `MainActivity` are already there), the Mika checker.

**Not verified (no network here, no Gradle run).** (1) That the real generated manifest still has these nine activities with exactly those exported flags: that is rule 4E-4a, which also gets "the exported ones are exactly the three" from this part. (2) That Shizuku's code starts `SettingsActivity` by class, not by the `APPLICATION_PREFERENCES` action (the upstream source is not in the zip; if it used the action, the non-exported pair above would still resolve inside the app). (3) Mika's real manifest filters, read from the docs of the patch, not from the generated file. Open items stay as in 4C: merged manifest of a real build (4E, first CI run). Task / launch-mode behaviour of the activities is finding 9, step 6A.

Next: 4D-2 (`AdbPairingService`, finding 6).

## 4D-2 — `AdbPairingService` (done)

**Docs only, nothing changed in code, manifests, scripts or workflows; nothing built.** This time GitHub was reachable, so the **real upstream files at the pinned commit `2650830` (v13.6.0)** were read, not guessed: `manager/src/main/AndroidManifest.xml`, `adb/AdbPairingService.kt` (330 lines), `adb/AdbPairingTutorialActivity.kt`, `adb/AdbMdns.kt`, and the caller `home/StartWirelessAdbViewHolder.kt`. A whole-repo grep of the same checkout found no `onTimeout` anywhere in upstream. Also read here: `app/src/main/AndroidManifest.xml`, `app/build.gradle.kts` (minSdk 26, compileSdk 37, targetSdk 37), `shizuku/tools/patch-upstream.py` (no rule touches this service or its type). The Android rules for `shortService` were checked against the Android developer documentation (service types, FGS timeouts, FGS troubleshooting).

| Question | Answer |
|----------|--------|
| What does the manifest declare? | `<service android:name=".adb.AdbPairingService" enabled="true" exported="false" foregroundServiceType="shortService" />`. Not exported, no intent filter. The patch script leaves it as it is. |
| Which type does the code pass to `startForeground`? | `startForeground(notificationId, notification, ServiceInfo.FOREGROUND_SERVICE_TYPE_MANIFEST)`: the type is taken from the manifest, so `shortService` is the only type in play. It is never combined with another type (Android ignores `shortService` when mixed with another type, not relevant here). |
| Permissions needed? | Only `FOREGROUND_SERVICE` (a short service needs no type-specific permission). It is declared by `:app`, Mika and `:shizuku` identically and merges to one (4C-4a). Notifications need `POST_NOTIFICATIONS` (same: declared three times, one after merge). **Finding 6 is closed: nothing to add at targetSdk 37.** `:app`'s other types (`dataSync`, `mediaPlayback`, `mediaProjection`, `microphone`) and Mika's `specialUse` are on other services; no service has two owners. |
| API level | `@TargetApi(R)` on the service and `@RequiresApi(R)` on the tutorial activity; `StartWirelessAdbViewHolder` opens the tutorial only when `SDK_INT >= R`. The 3-argument `startForeground` exists from API 29, so minSdk 26 is safe: the code is never reached below Android 11. |
| Who starts it? | Only `AdbPairingTutorialActivity.startPairingService()`, from the foreground activity (`onCreate`, and `onResume` when the user has just enabled notifications), with `startForegroundService`. If Android refuses (`ForegroundServiceStartNotAllowedException`) it falls back to `startService`; the service itself falls back to a plain `notify()`. Nothing else starts it: a grep over the whole upstream checkout at the pinned commit (`2650830`) finds only the tutorial activity and the manifest; the zip itself only mentions it in docs. The multi-display case (`displayId > 0`, e.g. Windows Subsystem for Android) uses `AdbPairDialogFragment` instead and never starts the service. The button that opens the tutorial is only wired on Android 11+. |
| Flow and lifetime | `start` action: `startSearch()` (mDNS via `NsdManager.discoverServices`, no timeout of its own) + `startForeground(searching notification)`. When the pairing port is found, the observer only calls `notify()` with the input notification (no `startForeground`). The user types the code (reply action): `onInput` starts the pairing in a coroutine and calls `startForeground(working notification)` again. `handleResult` ends with `stopForeground(REMOVE)` + `stopSelf()`. A "stop" action does the same. `onDestroy` stops the search. There is **no** other timer. |
| Does the flow fit the short-service limit? | **Not always.** The limit is about 3 minutes from `startForeground`. The clock starts when the tutorial screen opens, not when the user taps "pair". A user who has to find Developer options, turn on Wireless debugging and choose "Pair with code" can easily take longer. Whether the second `startForeground` (reply) restarts the clock was not settled by the documentation fragments read here, so it is not relied on. |
| What happens at the limit? | Android 15+ calls `Service.onTimeout(int, int)` and gives the service a few seconds to stop. `AdbPairingService` does not override it. Then the system raises `RemoteServiceException` ("A foreground service of type ... did not stop within its timeout"), the app crashes. Docs: the callback does not exist on Android 13 and lower (no timeout, no ANR there); for Android 14 the docs only say the new callback is not available, the exact behaviour was not confirmed here. |
| Why is it worse here than upstream? | Upstream the manager is its own app: a crash closes Shizuku only. Here `:shizuku` runs in the main process of the host (finding 9), so the same crash closes the whole app. Severity medium: only when pairing takes longer than the limit, on Android 14+ / 15+. |
| Sticky / restart | The service returns `START_REDELIVER_INTENT`; the docs say short services do not support sticky behaviour. If the process dies, the last intent may not be redelivered. Harmless: the user opens the tutorial again. No action. |

**Decision.** Nothing is changed in 4D-2 (the row is docs only and the fix is a source patch, not a manifest edit). The manifest side is fine: type, permission, `exported="false"`. The time-limit risk is new **finding 11** and gets its own row **5E** (patch `AdbPairingService.kt` to override `onTimeout` and stop the service, plus one self-check rule). It could also be left alone if the owner decides the risk is acceptable; the row stays `todo` until then, no other row depends on it. The merged-manifest checker (4E-4a) gets one extra rule: the service is not exported and its type is exactly `shortService`.

**Not verified (no Gradle run, no device).** (1) Real behaviour on Android 14 / 15 / 16 / 17 devices: only the documentation was read, nothing was run. (2) Whether the second `startForeground` extends the limit. (3) Any new Android 17 (targetSdk 37) rule for short services: no change found in the documentation read, but it was not searched for exhaustively. (4) The real generated manifest: the raw upstream manifest was read here, the generated and merged ones are 4E / first CI run. (5) `patch-upstream.py` was not re-run (no change).

Next: 4D-3 (the three `BOOT_COMPLETED` receivers).

## 4D-3 — the three `BOOT_COMPLETED` receivers (done)

**Docs only, nothing changed in code, manifests, scripts or workflows; nothing built.** GitHub was reachable, so the **real files** were read: Shizuku v13.6.0 (`2650830`): `manager/src/main/AndroidManifest.xml`, `receiver/BootCompleteReceiver.kt`, `ShizukuApplication.kt`, `ShizukuSettings.java`; Mika 0.1.52 (`7ff1703`): `app/src/main/AndroidManifest.xml`, `setup/BootRestoreReceiver.kt`, `cap/phone/setup/BootRestoreHandler.kt`, `BuiltinShellRecovery.restoreAfterBoot`, `DeveloperSettings`, `McpRuntime.ensureRunning`, `MikaApp.onCreate`; in the zip: `app/src/main/AndroidManifest.xml`, `BootReceiver.kt`, `App.kt`, `AppBase.kt`, `AppLog.kt` and `shizuku/tools/patch-upstream.py` (the replacement `ShizukuApplication` object). Both fetched checkouts were deleted again before the zip (they are not part of it).

| | `:app` `.BootReceiver` | Mika `.setup.BootRestoreReceiver` | manager `receiver.BootCompleteReceiver` |
|---|---|---|---|
| Actions | `BOOT_COMPLETED`, `QUICKBOOT_POWERON`, `com.htc.intent.action.QUICKBOOT_POWERON` | `BOOT_COMPLETED`, `TIME_SET`, `TIMEZONE_CHANGED`, `SCHEDULE_EXACT_ALARM_PERMISSION_STATE_CHANGED` | `LOCKED_BOOT_COMPLETED` and `BOOT_COMPLETED` (two filters) |
| Exported / `directBootAware` / priority | exported / no / none | exported / no / none | exported / **yes** / none |
| What it does at boot | `startActivity` of the saved theme's home screen (`ThemeManager.homeIntent`), inside `try/catch` (newer Android may refuse a background start) | re-arms scheduled triggers (`TriggerRuntime.rearm`); starts the computer-access foreground service if it is switched on (`McpRuntime.ensureRunning`, `startForegroundService`, type `specialUse`); touches the call runtime if prepared on an earlier boot; and `BootRestoreHandler`: `goAsync`, then `restoreAfterBoot()` | nothing if the user is not user 0 or a Shizuku server already answers; else by the last launch mode: ROOT = run the starter through `su`; ADB (Android 13+, `WRITE_SECURE_SETTINGS` held) = write three settings, search mDNS for at most 3 s (`goAsync`), connect to `127.0.0.1`, run the starter |
| Foreground service | none | yes, only the computer-access service, and only if the user enabled it | none |
| Settings it writes | none | `Settings.Global.adb_wifi_enabled = 1`, only if Mika's helper was paired, the user agreed to "restore after restart", `WRITE_SECURE_SETTINGS` is held, and Mika is not in root / Shizuku mode | `adb_wifi_enabled = 1`, `adb_enabled = 1`, `adb_allowed_connection_time = 0` |

**Findings of the read.**
1. *Same setting, same value.* Mika and the manager both write `adb_wifi_enabled = 1`. Neither writes `0` at boot, so it is idempotent; no clash. Only the manager also writes `adb_enabled` and `adb_allowed_connection_time`. Both need the same `WRITE_SECURE_SETTINGS` (declared by `:app`, Mika and `:shizuku`, one entry after the merge, 4C-4a), so one grant serves both.
2. *Mika steps aside on purpose.* `restoreAfterBoot()` returns early when Mika's own `rootStart` or `shizukuStart` is set or its transport is Shizuku. So when Rizwan uses the built-in Shizuku, only the manager acts at boot; when it uses its own paired helper, only Mika does.
3. *Only one foreground service at boot* (Mika's computer-access service, `specialUse`, declared by Mika). The manager starts none at boot (`AdbPairingService` is only started by the tutorial screen, 4D-2). `:app`'s receiver starts an activity, not a service. No type or permission is needed beyond what the merge already holds.
4. *Order is not defined, and nothing depends on it.* No filter has a `priority`, no receiver calls `abortBroadcast` or `setResultData`, none reads another's result. `:app`'s receiver opens the home screen, Mika's re-arms its own alarms and helper, the manager starts its own server: three independent jobs. A possible effect, not verified: if Android delivers the boot broadcast one receiver at a time, a receiver that holds `goAsync` delays the next one by its run time (manager about 3 s; Mika up to its 50 s budget), so the home screen of `:app`'s receiver could open later. That is a delay, not a failure; Android 10+ often refuses that background start anyway, and the code already catches it.
5. *The QUICKBOOT actions* belong only to `:app`'s receiver. The manager and Mika ignore them; the manager's code returns at once for any action other than the two boot actions.
6. *Protected broadcast.* The boot actions are sent only by the system, so `exported="true"` on all three is the usual pattern (same as upstream, same as Mika's own comment).
7. **New finding 12 (medium): direct boot.** The manager's receiver is `directBootAware` and takes `LOCKED_BOOT_COMPLETED`, which no component of `:app` or Mika ever did. The main process (and so `App.onCreate`) can now start before the user unlocks. See the finding for the options; recommendation (a) strip the flag and the filter in the patch script.
8. **New finding 13 (high if ordered wrongly, none today): init order.** The receiver reads `ShizukuSettings.getPreferences()` and `Starter.internalCommand`, which need `ShizukuApplication.onCreate(app)`; nobody calls it yet. With the switch on and no call, it throws at every boot when no server runs. The call belongs early in the launcher part of `App.onCreate` (6E; place fixed in 4D-4), and 8F (default on) must come after 6E.

*Also checked, nothing to do.* `App extends AppBase extends MikaApp`, so Mika's `applicationContext as MikaApp` in its receiver is valid in the host. `RECEIVE_BOOT_COMPLETED` is declared by all three and merges to one. Mika's receiver is not edited by its patch script (`mika/README.md`, `mika/tools/patch-upstream.py` do not mention it), so it stays in the merged manifest (and `check-merged-manifest.py` rule 2 requires it).

**Decision.** Nothing is changed in 4D-3: the three receivers coexist, the order is harmless, and both real problems are about the *process* (finding 12) and the *init call* (finding 13), which are 4D-4's subject. The merged-manifest checker (4E-4a) gets one rule: exactly three `BOOT_COMPLETED` receivers, no `priority`; plus the conditional rule from option (a).

**Not verified (no Gradle run, no device).** (1) The real generated manifests: the raw upstream manifests were read, the patched and merged ones are 4E / first CI run. (2) Whether Android delivers the boot broadcast serially (so that `goAsync` delays the next receiver) on the target versions. (3) Whether a main process started under direct boot survives the unlock and is reused (finding 12 rests on documentation of Direct Boot, not on a test). (4) That two ADB clients (Mika and the manager) connecting to wireless debugging at the same moment do not disturb each other. (5) Which exact credential-protected calls fail in `App.onCreate` while locked; only the code path was read. (6) `patch-upstream.py` was not re-run (unchanged).

Next: 4D-4 (the `Application` question: where `ShizukuApplication.onCreate(app)` goes, and the decision on finding 12), then 4E-1 ... 4E-4c, 4F-1 ... 4F-3, 4G-1, 4G-2.

## 4D-4 — the `Application` question (done)

**Docs only, nothing changed in code, manifests, scripts or workflows; nothing built.** Read: the real upstream files at the pinned commits (Shizuku v13.6.0 `2650830`; Mika 0.1.52 `7ff1703`; GitHub was reachable): `ShizukuApplication.kt`, `ShizukuSettings.java`, `ShizukuManagerProvider.kt`, `ShizukuProvider.java` (API), `ShizukuReceiver.kt`, `ShellBinderRequestHandler.kt`, `settings/SettingsFragment.kt`, `app/AppActivity.kt` and the activity class list, the manager manifest, `manager/build.gradle` and the RikkaX `LocaleDelegate` source; in the zip: `App.kt`, `AppBase.kt`, the `:app` manifest, `shizuku/build.gradle.kts` and the replacement `ShizukuApplication` object in `patch-upstream.py`. A grep of the whole project (without the fetched checkouts) and of Mika's source for libsu, `HiddenApiBypass`, `setDefaultNightMode`, `Locale.setDefault`. Both fetched checkouts were deleted again before the zip.

**The application class.** The merged manifest keeps `android:name=".App"` (`App` -> `AppBase` -> `MikaApp`); no `ShizukuApplication` entry exists (4A) and the patch turned that class into an `object`, so it could not be one anyway. What upstream's `ShizukuApplication` did, item by item, and what it means in the host:

| Upstream does | Where it runs now | Verdict |
|---|---|---|
| `Shell.setDefaultBuilder(FLAG_REDIRECT_STDERR)` (libsu) | `ShizukuApplication` object `init`, at the first touch | No other libsu user in `:app`, the other modules or Mika (grep), so no second builder, no clash. Keep. |
| `HiddenApiBypass.setHiddenApiExemptions("")` (API 28+) | same `init` | Process-wide, in the main process. Nobody else in the project uses it. Side effect: all code of the main process (BlackBox, Mika, ...) can reach hidden APIs afterwards; permissive, nothing found that depends on the opposite. Needed by `ShizukuSettings.getNightMode()` (hidden `ActivityThread`). Accepted. |
| `System.loadLibrary("adb")` (API 30+) | same `init` | `libadb.so` is packaged by `:shizuku` with a unique name (3E). `AdbPairingClient` loads it itself too, so the early load is redundant. A missing library would be an `Error`, so the call site catches `Throwable`. |
| `application = this` | `ShizukuApplication.onCreate(app)` | Needed by `Starter` (`application.applicationInfo...`, a `lateinit`). Keep. |
| `ShizukuSettings.initialize(app)` | same | Needed by the boot receiver (finding 13). Uses **device-protected** storage (file name `settings`), a different folder from the credential-protected storage the rest of the app uses; no prefs of that name found in `:app`, Seal or Mika, no clash. Keep. |
| `LocaleDelegate.defaultLocale = ShizukuSettings.getLocale()` | same | Plain static read only by the Rikka activities (RikkaX source), not `Locale.setDefault`: the language stays inside the Shizuku screens. "System" = `Locale.getDefault()`, which Mika's `AppLanguage.applyDefaultLocale` has already set in `MikaApp.onCreate`, so "follow system" in Shizuku follows the app language chosen for the host. Info, fine. |
| `AppCompatDelegate.setDefaultNightMode(...)` | same | **Leaks into the whole host** = new **finding 14**; fix decided, row 5G. |

**Where the init call goes (decision, closes the 4D-4 question and finding 13's "place").** `ShizukuApplication.onCreate(this)` is called from `App.onCreate`, **launcher process only** (after `if (!isLauncherProcess()) return`), inside `try { ... } catch (e: Throwable) { AppLog.e("App", "Shizuku init failed", e) }`, right after the `AppLog.i("App", "process start ...")` line and **before** the Seal block; Mika's `startMikaIfUsed()` stays last (its own comment demands it after Seal). Why there: (1) `App.onCreate` ends before any receiver, activity or service of the process runs, so the boot receiver and the screens find `ShizukuSettings` and `application` set; (2) `AppLog` is ready, so a failure is logged and not silent; (3) it depends on neither Seal nor Mika; (4) the Shizuku code runs only in the main process (no Shizuku component has `android:process`, provider `multiprocess=false`), and every other process (`:black`, `:p0`, `:midlet`, `:mame`, `:retroarch`) returns earlier or at `isLauncherProcess()`, so none of them pays for it. The call itself is written in 6E, guarded by the Shizuku switch (`:shizuku` may not be in the build).

**What runs before `App.onCreate`.** Content providers are created after `attachBaseContext` but before `Application.onCreate`. `ShizukuManagerProvider.onCreate` only calls `disableAutomaticSuiInitialization()` and the API's `ShizukuProvider.onCreate`; neither reads `ShizukuSettings` or `application`. `ShizukuReceiver` -> `ShellBinderRequestHandler` does not use them either (grep). So nothing of Shizuku needs the init earlier than `App.onCreate`.

**Finding 12 decided: option (a+).** Take the 4D-3 recommendation (a) one step further: remove `android:directBootAware` from **all** components that carry it (read in 4D-3: `BootCompleteReceiver`, `ShizukuReceiver`, `ShizukuManagerProvider`; **corrected in 5G** after the first run on the real tree: `RequestPermissionActivity` and `ShellRequestHandlerActivity` carry it too, five in all) and the `LOCKED_BOOT_COMPLETED` filter of `BootCompleteReceiver`. Reason: stripping only the receiver would leave a way to start the main process before the unlock (a root-started server handing the binder to the provider, or an app asking through `ShizukuReceiver`). Cost: Shizuku's boot start runs after the first unlock instead of before it (the manager UI is not usable earlier anyway), and the manager's provider and receiver are not reachable during direct boot. Option (b) (make `App.onCreate` locked-safe) is rejected: more code in `:app`, easy to get wrong. This follows the recommendation written in 4D-3; the owner can still reverse it before row 5F (patch) is written. After 5F the host never starts its process in direct boot because of Shizuku, as before `:shizuku`.

**Finding 14 (new, medium) decided: row 5G.** See the finding. Short: keep the setting, apply it per activity through the base class `AppActivity`, never through the process-wide static.

**Finding 9, process / task (note for 6A).** Written into row 6A (no `taskAffinity`, no `launchMode`, no `android:process` in the real manifest; proposal: plain `startActivity`, no `NEW_TASK`). Nothing to change in a manifest.

Changed: `shizuku/README.md` (plan rows 4 and 5, rows 4D-4, 4E-4a, 5F and 5G new, 6A, 6E; findings 9, 12, 13 updated, 14 new; this section) and the new `docs/CHANGES-shizuku-part4d.md` (covers 4D-1 ... 4D-4; the small `part4d1` - `part4d3` files stay).

**Not verified (no Gradle run, no device).** (1) That `delegate.localNightMode` set in `AppActivity` works in the right order with `MaterialActivity`'s theme handling (Rikka `material` 2.7.2); the `LocaleDelegate` source was read from the RikkaX default branch, not from the 2.7.2 tag. (2) Whether the hidden-API exemption changes the behaviour of any host code (BlackBox, Mika); nothing found, nothing tested. (3) That stripping `directBootAware` from the provider and `ShizukuReceiver` loses nothing real: the reasons upstream set it were not found in its history here. (4) Real behaviour on Android 14 - 17 devices. (5) The generated and merged manifests (4E, first CI run). (6) `patch-upstream.py` was not re-run (unchanged).

Next: 4E-1 (checker skeleton `shizuku/tools/check-merged-manifest.py`), then 4E-2 ... 4E-4c, 4F-1 ... 4F-3, 4G-1, 4G-2; step 5 now has 5F and 5G as well.

## 4E-1 — checker skeleton (done)

**New file `shizuku/tools/check-merged-manifest.py`; nothing else in code, manifests, workflows or Gradle changed; no workflow calls it yet; nothing built.** `includeShizuku` is still off by default. The model is `mika/tools/check-merged-manifest.py` (same `::error::` output, exit 1 on a failed rule); Mika's checker is not touched and this one never reads Mika's files.

What the skeleton has:

| Part | What it does |
|---|---|
| Command line | `check-merged-manifest.py [AndroidManifest.xml] [--variant release\|debug] [--root DIR] [--require-shizuku]`. A path is optional. |
| Finding the manifest | Without a path: walks `<root>/app/build/intermediates`, takes the `AndroidManifest.xml` whose path contains `merged_manifests/<variant>` (the same test as the workflows' `find ... -path \"*merged_manifests/release*\"`; AGP 8.x puts it under `.../release/processReleaseManifest/`). Several hits: shortest path first, so the result is the same every run. |
| Exit codes | `0` all rules passed, or Shizuku is not in the build; `1` a rule failed (or `--require-shizuku` and no Shizuku component); `2` the script could not run (bad option, file missing, not XML, root is not `<manifest>`, no `<application>`, no build output). |
| Messages | Not found: \"... run ./gradlew :app:assembleRelease first (with -PincludeShizuku=true to have Shizuku in it)\". Every problem is one `::error::Shizuku manifest: [rule id] text` line. |
| Shizuku off | With no component of `moe.shizuku.manager` in the merged manifest the script prints \"Shizuku is not built in ... nothing to check\" and exits 0, because Shizuku is off by default until 8F and a workflow may call the script before that. `--require-shizuku` turns it into an error (for the workflows after 8F). |
| Parse helper | `parse(path)` returns the `<manifest>` element or raises one `SetupError` (exit 2). |
| Helper classes | `Merged` (components by kind or prefix, `manager_components()`, requested / declared permissions with duplicates kept so a rule can count them, `<uses-feature>`, `<queries>` packages, every string) and `Component` (`exported`, `directBootAware`, `authorities`, `foregroundServiceType`, intent filters with actions / categories / `priority`, `is_launcher()`, `has_category()`). |
| Rule registry | `@rule(\"4E-2\", \"title\")` on a function `fn(m) -> list of error strings`. A new row adds one block and changes nothing else. |
| `check(root, require_shizuku)` | A pure function of the parsed element, returning `(errors, notes, state)`; the self-test of 4E-4c calls it with hand-made manifests. |
| Honest last line | With no rule registered the success line says \"SKELETON: no rule is registered yet, rows 4E-2 ... 4E-4b add them\", so a green run is never read as a real check. |

**Checked here (no Gradle, no network needed).** `py_compile` fine; `check-gradle.py` still ok (15 `.kts` files, 11 unique namespaces). Run on hand-made manifests: no Shizuku component -> exit 0 and the \"not built in\" line; Shizuku components -> exit 0 and \"1 activity, 1 provider, 1 receiver ... 0 rule(s) ran\"; `--require-shizuku` with none -> exit 1; missing file, broken XML, wrong root, no `<application>` -> exit 2 with a clear line each; `--variant foo` -> exit 2; `--help` -> exit 0; a fake `app/build/intermediates/merged_manifests/{release,debug}/process...Manifest/AndroidManifest.xml` tree: release and debug each found, a missing variant and a missing build folder -> exit 2 with the \"run assemble first\" text. A throw-away test of every helper (permissions counted with duplicates, `<permission>`, features, `<queries>`, launcher filter, `exported`, `directBootAware`, `priority`, several authorities, `foregroundServiceType`, an unqualified component) and of the rule registry (a planted rule fails with `[T] boom`, the empty registry passes) passed; those throw-away tests are not part of the zip (4E-4c writes the real self-test).

**Not verified.** (1) The exact folder AGP 8.13.2 writes the merged manifest into: the search is by path part, as the other checkers' workflow steps do, but no build ran here, so the first CI run confirms it. (2) That the real merged manifest uses fully qualified names for all `moe.shizuku.manager` components (the merger resolves `.MainActivity` against the library namespace; Mika's checker relies on the same). (3) Rules: none yet, by design.

Not changed on purpose: the three workflows (the call is added in row 8D-2; `--require-shizuku` only once Shizuku is on by default, 8F), `mika/tools/check-merged-manifest.py`.

Next: 4E-2 (provider and authority rules: `${applicationId}.shizuku` exactly once and owned by `moe.shizuku.manager.ShizukuManagerProvider`, no `rikka.shizuku.ShizukuProvider` left), then 4E-3, 4E-4a ... 4E-4c, 4F-1 ... 4F-3, 4G-1, 4G-2.

## 4E-2 — provider and authority rules (done)

**Changed: `shizuku/tools/check-merged-manifest.py` (four rules added, plus a package helper and a notes list), `shizuku/README.md`, new `docs/CHANGES-shizuku-part4e2.md`.** No workflow, manifest, Gradle or other code touched; no workflow calls the checker yet; nothing built. `includeShizuku` is still off by default. The rules run only when the merged manifest has a `moe.shizuku.manager` component, so a Mika-only build (Shizuku off) is not affected.

The authority is `<applicationId>.shizuku`. The CI may rename the package, so the script reads it from the `package` attribute of the merged manifest and does not write `com.srizwan.win11` into any rule. If that attribute is missing (not expected, see below) the rules fall back to \"an authority ending in `.shizuku`\" and print a note.

| Rule id | Fails when | Why |
|---|---|---|
| `4E-2 authority` | `<applicationId>.shizuku` is declared by no provider; or by more than one provider (counted per use: a provider that lists it twice counts twice); or by a provider other than `moe.shizuku.manager.ShizukuManagerProvider`; or any provider authority still holds `${...}` | Two providers with one authority = `INSTALL_FAILED_CONFLICTING_PROVIDER` (finding 1). A lost authority means no client can reach the binder. |
| `4E-2 owner` | `ShizukuManagerProvider` is not in the merged manifest, or is declared twice, or its authorities are not exactly `[<applicationId>.shizuku]` | The manager's provider is the one that was kept (4B), so it must be there and own only that name. |
| `4E-2 old provider` | any component named `rikka.shizuku.ShizukuProvider` is left | Mika's provider is removed on purpose by `app/src/shizuku/AndroidManifest.xml` (4B-2); if it is back, the overlay did not work (the fallback of 4B-1 is a manifest-editing task). |
| `4E-2 provider guard` | the manager's provider has `exported` other than `true`, `permission` other than `android.permission.INTERACT_ACROSS_USERS_FULL`, or `multiprocess=\"true\"` | From the 4A table (real v13.6.0 manifest): it is exported **only** behind that system permission; without it any app could call the provider. Not in the row text, added because it belongs to the same component and costs one check. |

**What was run (no Gradle needed).**
1. 22 hand-made cases through `check()`: a good manifest passes; clash with Mika's provider (both rules fire); Mika's provider alone owning the authority; the manager's provider without an authority; package renamed but authority not (and the renamed-and-matching case passes); unresolved `${applicationId}`; guard: `exported` false / absent, permission absent / wrong, `multiprocess` true (absent = false passes); manager provider twice; two authorities; another provider owning the name; no manager provider at all; no `package` attribute (passes with a note) and a wrong suffix there (fails twice); whitespace and empty entries in `authorities`; Shizuku not built in (rules do not run even with Mika's provider present) and then `--require-shizuku` (fails). All as expected.
2. **The real source, first time since 4C:** `fetch-upstream.sh` + `patch-upstream.sh` + `patch-upstream.py --check` on Shizuku v13.6.0 (`2650830`): patch ran, `D. self-check ok` (including the rules of 4C-1 ... 4C-3: no remove marker on `DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION`, `MANAGER` / `API_V23` declared once each, the `API_V23` request guarded). That closes the \"real-source rerun still open\" notes of 4C-2 and 4C-3 (the counts printed: 87 resource files renamed, 237 names, 42 languages). Mika 0.1.52 (`7ff1703`) fetched and patched too.
3. **A pseudo-merge** (a throw-away script, not the Android merger): the real patched manager manifest and the real patched Mika manifest, `${applicationId}` replaced by `com.srizwan.win11`, relative names made fully qualified, both put under one `<application>`. With Mika's provider kept it fails exactly as it should (authority used 2 times; old provider left); with it dropped (what the overlay does) it passes: 9 activities, 1 provider, 2 receivers, 1 service from `moe.shizuku.manager`, 4 rules ran and passed. This proves the rules against the real attributes of both providers, not the real merge.
The fetched `shizuku/upstream/` and `mika/upstream/` were deleted again before the zip; the throw-away tests are not in the zip.

**Not verified.** (1) The real merged manifest of a Gradle build (first CI run): that the merger writes the provider with `android:authorities` resolved, and a `package` attribute on `<manifest>` (AGP 8 normally writes it into the merged manifest; if not, the rules still work through the `.shizuku` ending and say so in a note). (2) That the overlay's `tools:node=\"remove\"` really removes Mika's provider in AGP 8.13.2 (the whole point of the `old provider` rule; 4B-1 / first CI run). A detail seen again in the overlay file: it writes `android:authority` (singular) on the marker; the merger keys the provider by `android:name`, as 4B-1 established, so it is harmless, but the first CI run will confirm. (3) No device, no Gradle.

Next: 4E-3 (permission rules: `DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION` still declared, no `uses-permission API_V23`, `MANAGER` and `API_V23` each declared once), then 4E-4a ... 4E-4c, 4F-1 ... 4F-3, 4G-1, 4G-2.

## 4E-3 — permission rules (done)

**Changed: `shizuku/tools/check-merged-manifest.py` (five rules added, plus the constants for the three permission names, `Merged.permission_elements` and `Merged.add_note`), `shizuku/README.md`, new `docs/CHANGES-shizuku-part4e3.md`.** No workflow, manifest, Gradle, patch script or other code touched; no workflow calls the checker yet; nothing built. `includeShizuku` is still off by default. Like the rules of 4E-2, these run only when the merged manifest has a `moe.shizuku.manager` component, so a Mika-only build (Shizuku off) is not affected (exit 0, "not built in"). The names that carry the host package (`<applicationId>.DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION`) are read from the `package` attribute of the merged manifest, as in 4E-2; without it the rule matches the ending and prints a note.

What the rules read: every `<permission>` of the merged manifest (declared) and every `<uses-permission>` / `<uses-permission-sdk-23>` (requested), duplicates counted. The first three rows are the row text of 4E-3; the last two are added from findings 2 and 4 / point 4 of 4C-3, because they belong to the same permissions and cost one check each.

| Rule id | Fails when | Why |
|---|---|---|
| `4E-3 dynamic receiver` | `<applicationId>.DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION` is not declared (`<permission>`), or is declared more than once, or is not requested (`<uses-permission>`); or its name still holds `${...}` | Finding 2. The manager manifest used to remove it for the whole app (4C-1 dropped the markers); AndroidX core brings both elements. Without the request `ContextCompat.registerReceiver(..., RECEIVER_NOT_EXPORTED)` throws on Android 8 - 12 (minSdk 26), in code that has nothing to do with Shizuku. The "requested" half is beyond the row text: finding 2 removed **both** elements, so both must be checked. |
| `4E-3 no API_V23 request` | any `<uses-permission>` (or `-sdk-23`) of `moe.shizuku.manager.permission.API_V23` is in the merged manifest (one error however many) | Finding 3. The host is the manager and must not ask for it. Two things keep it out: the `tools:node="remove"` guard in the manager manifest (kept in 4C-3) and `shizukuIgnored = manifest` on `:shizuku-provider` (its own manifest asks for it and is not merged). If it shows up, one of the two stopped working. |
| `4E-3 declared once` | `moe.shizuku.manager.permission.MANAGER` or `...API_V23` is declared 0 times or more than once | Finding 4. Declared only by `:shizuku`; Mika declares neither. The names are kept on purpose: every Shizuku client and the server's `BinderSender` use them. |
| `4E-3 levels` | `MANAGER` has a `protectionLevel` other than `signature`; `API_V23` other than `dangerous`, or a `permissionGroup` other than `moe.shizuku.manager.permission-group.API` | From the 4A table (real v13.6.0 manifest). A wrong level changes who may hold the permission. Beyond the row text. |
| `4E-3 manager request` | `moe.shizuku.manager.permission.MANAGER` is requested 0 times or more than once | Point 4 of 4C-3. The request comes from the `<uses-permission>` of the manager manifest; it is what lets the server send the manager the binder. Beyond the row text. |

The checker now has 9 rules (4 of 4E-2, 5 of 4E-3); the success line lists them and says that rows 4E-4a and 4E-4b add more.

**What was run (no Gradle needed).**
1. **30 hand-made cases through `check()`, all as expected** (a throw-away script, not in the zip; 4E-4c writes the real self-test and may reuse the list). Good: 1 (all five permission facts as the real merge should give them), 8 (package renamed, the permission names renamed with it), 10 (no `package` attribute, matched by ending, passes), 28 (Shizuku not built in: the rules do not run even though every permission is missing). Bad, with the one rule that must fire each time: dynamic permission removed completely (2), declared but not requested (3), requested but not declared (4), declared twice (5), only under another package prefix (6), unresolved `${applicationId}` in the name (7), package renamed but the names not (9), no package attribute and the permission missing (11); `API_V23` requested through `uses-permission` (12), through `uses-permission-sdk-23` (13), twice (14, still one error); `MANAGER` not declared (15), `API_V23` not declared (16), `MANAGER` twice (17), `API_V23` twice (18), neither declared (19); `MANAGER` level `normal` (20), level missing (21), `signature|privileged` (25); `API_V23` level `signature` (22), wrong group (23), no group (24); `MANAGER` not requested (26), requested twice (27); `--require-shizuku` with no Shizuku component (29, the `present` rule); three faults at once (30: three rules fire, nothing else).
2. **The command line on three files**: a good manifest (exit 0, "9 rule(s) ran and passed"), one that requests `API_V23` (exit 1, one `::error::` line naming rule and permission) and a Mika-only one (exit 0, "not built in").
3. `py_compile` fine; `check-gradle.py` ok (15 `.kts` files, 11 unique namespaces).

**Not run here, and why.** The pseudo-merge of the real patched Shizuku and Mika manifests that 4E-2 did (point 3 of its list) was **not** repeated: this session has no network, and `shizuku/upstream/` and `mika/upstream/` are not in the zip. The rules are written from what 4A, 4C-1 and 4C-3 read on the real v13.6.0 manifest (names, levels, group, the guard line, the host's `MANAGER` request).

**Not verified.** (1) The real merged manifest of a Gradle build (first CI run): that AndroidX core's own `<permission>` and `<uses-permission>` of `DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION` reach the merged file now that no marker removes them (believed from AndroidX core's library manifest and from 4C-1; not read in this session); that the manager's `tools:node="remove"` on `uses-permission API_V23` really leaves no request behind in AGP 8.13.2; that the merger keeps `protectionLevel` / `permissionGroup` as written (normal for a text manifest); and the `package` attribute on `<manifest>` (as in 4E-2). If a rule fails on the real file, the message names the permission and the count found; then either the rule or this README is wrong, not necessarily the app. (2) Device behaviour on Android 8 - 12. No Gradle run, no device.

Next: 4E-4a (component rules: 9 activities, 1 service, 2 receivers, 1 provider from `moe.shizuku.manager`; the exported ones; no LAUNCHER filter; the service not exported with `foregroundServiceType` exactly `shortService`; three `BOOT_COMPLETED` listeners, none with a `priority`), then 4E-4b, 4E-4c, 4F-1 ... 4F-3, 4G-1, 4G-2.

## 4E-4a — component rules (done)

**Changed: `shizuku/tools/check-merged-manifest.py` (five rules added, plus the constants for the expected component names, Mika's and the manager's boot receivers and the launcher categories, and the helpers `full`, `is_exported`, `mika_present`), `shizuku/README.md`, new `docs/CHANGES-shizuku-part4e4a.md`.** No workflow, manifest, Gradle, patch script or other code touched; no workflow calls the checker yet; nothing built. `includeShizuku` is still off by default. The rules run only when the merged manifest has a `moe.shizuku.manager` component, so a Mika-only build is not affected.

| Rule id | Fails when | Why |
|---|---|---|
| `4E-4a inventory` | the components named `moe.shizuku.manager.*` are not exactly the 9 activities, 1 service, 2 receivers and 1 provider of the 4A table (compared by name: the message lists missing, unexpected and doubly declared names), or there is an `activity-alias` from the manager | 4A. A wrong count could hide a swapped or renamed component; the name list is the real check. |
| `4E-4a exported` | of the manager's components the exported ones are not exactly `RequestPermissionActivity`, `ShellRequestHandlerActivity`, `LegacyIsNotSupportedActivity`, `BootCompleteReceiver`, `ShizukuReceiver` and `ShizukuManagerProvider`; a component that is not in that list counts as "must not be exported" (so the other six activities and the service) | 4A / 4D-1 (the old row said "not exported" for all nine activities, that was too short). Without `android:exported` a component counts as exported only if it has an intent filter. |
| `4E-4a launcher` | a manager component has an intent filter with the category `LAUNCHER` (or `LEANBACK_LAUNCHER` or `HOME`) | The manager has no icon of its own, the Start menu opens it (step 6). `LEANBACK_LAUNCHER` and `HOME` are beyond the row text, they cost nothing. |
| `4E-4a service` | `AdbPairingService` is exported, or its `foregroundServiceType` is not exactly `shortService` (absent, another type or a combination all fail) | 4D-2 / finding 6. The service passes `FOREGROUND_SERVICE_TYPE_MANIFEST`, so the manifest type is the only type in play. A missing service is the inventory rule's finding, not reported twice. |
| `4E-4a boot receivers` | not exactly one receiver of each kind listens to `android.intent.action.BOOT_COMPLETED`: `:app`'s `BootReceiver` (matched by its simple name), Mika's `com.wangzan101.mika.setup.BootRestoreReceiver` and the manager's `receiver.BootCompleteReceiver`; or a fourth component listens; or a listener is not a receiver; or any intent filter of these receivers sets `android:priority` | 4D-3. The three all run, the order is undefined and nothing depends on it as long as nobody sets a priority. **When Mika is not in the build** (no component under `com.wangzan101.mika.`, `-PincludeMika=false`) two are expected and a note says so. `LOCKED_BOOT_COMPLETED` listeners are not counted. |

Not added here, on purpose: the direct-boot rule (none of `BootCompleteReceiver`, `ShizukuReceiver`, `ShizukuManagerProvider` is `directBootAware`, no `LOCKED_BOOT_COMPLETED` filter on `BootCompleteReceiver`, finding 12). It would fail on every real manifest until the patch of row 5F exists, so it comes with 5F (**added in 5F**, see "5F"). The checker has 14 rules now (4 of 4E-2, 5 of 4E-3, 5 of 4E-4a); the success line lists them and says that row 4E-4b adds more.

**Two design points worth knowing.** (1) `:app`'s boot receiver is found by its simple name `BootReceiver`, not by `<applicationId>.BootReceiver`: the merger resolves `.BootReceiver` against `:app`'s namespace, which does not have to be the applicationId if the CI renames the package. (2) The manager's names are fixed strings (`moe.shizuku.manager.*`) because the patch script keeps the manager's own namespace; only the host package is replaced (4A).

**What was run (no Gradle needed).**
1. **40 hand-made cases through `check()`, all as expected** (a throw-away script, not in the zip; 4E-4c writes the real self-test and may reuse the list). A full good manifest (13 manager components, the three boot receivers, all permissions of 4E-3) passes with Mika in (1), with Mika out (2) and with the package renamed (3); `:app`'s own `MainActivity` with `LAUNCHER` + `HOME` does not trip the launcher rule (23); Shizuku not built in runs no component rule (39). Inventory: an activity / the service / the provider / a receiver missing (4 - 7), an activity declared twice (8), an extra and a renamed manager activity (9, 10), an `activity-alias` (11). Exported: `StarterActivity` and `SettingsActivity` exported (12, 13), `RequestPermissionActivity` and `ShizukuReceiver` not exported (14, 15), the exported attribute missing on a component with a filter = exported (16, good) and on one without a filter = not exported (17, good), a filter added without the attribute (18), the service exported (19: exported and service rule both fire). Launcher: `LAUNCHER`, `LEANBACK_LAUNCHER`, `HOME` on the manager's `MainActivity` (20 - 22). Service: type `dataSync`, missing, `dataSync|shortService` (24 - 26). Boot: `priority` on each of the three receivers (27 - 29), `:app`'s or Mika's receiver loses `BOOT_COMPLETED` (30, 31), a fourth listener (32), a second `...BootReceiver` (33), the manager's receiver left with `LOCKED_BOOT_COMPLETED` only (34), a service that listens (35), a `LOCKED_BOOT_COMPLETED`-only `:app` receiver (38), Mika out with `:app`'s receiver gone (37); and several faults at once (40: exactly the four rules concerned fire).
2. The command line on a good and a bad file: exit 0 ("14 rule(s) ran and passed") and exit 1 (one `::error::` line naming the rule and the component).
3. `py_compile` fine; `check-gradle.py` ok (15 `.kts` files, 11 unique namespaces).

**A count to check.** The heading of the 4A component table says "all 14 of its manifest", but the rows add up to 13 (9 activities + 1 service + 2 receivers + 1 provider), and 4E-2's pseudo-merge on the real manifests also found 13. The checker uses the 13. I did not change the heading (no network here to read the real file again); if the first CI run on a real merged manifest says a 14th component is missing from the inventory rule, add its name to `MANAGER_EXPECTED`.

**Not run here, and why.** No pseudo-merge on the real patched manifests (no network, `shizuku/upstream/` and `mika/upstream/` are not in the zip). The rules come from 4A, 4D-1, 4D-2 and 4D-3, which read the real v13.6.0 and Mika 0.1.52 manifests.

**Not verified.** (1) The real merged manifest of a Gradle build (first CI run): that the merger writes `android:exported` explicitly on all 13 components and keeps the intent filters as in the source; that Mika's receiver is really named `com.wangzan101.mika.setup.BootRestoreReceiver` after the Mika patch; that `foregroundServiceType` survives as `shortService`. (2) Whether another module of the project adds a `BOOT_COMPLETED` receiver (a grep of every manifest in the zip found only `:app`'s; `Bcore` only has the `RECEIVE_BOOT_COMPLETED` request). (3) Device behaviour. No Gradle run, no device.

Next: 4E-4b (string rules: no `moe.shizuku.privileged.api` left, one `<queries>` entry allowed until 7A removes it; `ShizukuApplication` absent; no `rikka.shizuku.ShizukuProvider`), then 4E-4c, 4F-1 ... 4F-3, 4G-1, 4G-2.

## 4E-4b — string rules (done)

**Changed: `shizuku/tools/check-merged-manifest.py` (three rules added, plus the constants `STALE_PACKAGE`, `STALE_QUERY_ALLOWED`, `APPLICATION_CLASS` and the helpers `Merged.strings_with_context` and `where`), `shizuku/README.md`, new `docs/CHANGES-shizuku-part4e4b.md`.** No workflow, manifest, Gradle, patch script or other code touched; no workflow calls the checker yet; nothing built. `includeShizuku` is still off by default. The rules run only when the merged manifest has a `moe.shizuku.manager` component. They read every attribute value and every element text of the merged file (with the element they sit in), so a stale name is found wherever it hides, not only in the places the other rules look at.

| Rule id | Fails when | Why |
|---|---|---|
| `4E-4b stale package` | the string `moe.shizuku.privileged.api` appears anywhere (an action, a permission, an authority, a meta-data value, an element text, a `<queries>` intent ...), **except** the one exact `<queries><package android:name="moe.shizuku.privileged.api"/>` entry that is allowed; or that entry is there more than once; or a `<queries><package>` has a longer name that merely starts with it | Finding 7. That is the package of the *external* Shizuku app; with the manager built in the real package is the host's, and the manager's own actions already follow it (4A). Mika's `<queries>` entry is the one known leftover: harmless (a `<queries>` entry never conflicts), allowed until row 7A-1. While it is there a note says so. `STALE_QUERY_ALLOWED = 1` is the switch: row 7A-1 sets it to 0 and the same rule then fails on the entry (case 23). **Since 7A-1.2 the constant is 0**: the entry is no longer allowed, the note is never printed, and the error text reads "at most 0 allowed (7A-1.1 writes the host package into Mika's entry)". |
| `4E-4b application class` | `<application android:name>` is a class under `moe.shizuku.manager.`, or any string contains `ShizukuApplication` | 4D-4. The manager's `Application` is turned into an object by the patch script and called from `:app`'s own `App.onCreate` (row 6E). If the merged `<application>` pointed at it, the host would start with the wrong Application and `App.onCreate` (log, themes, Seal, Mika) would not run. A host `<application>` without a name passes. |
| `4E-4b old provider string` | `rikka.shizuku.ShizukuProvider` appears in any string of the merged manifest | Mika's provider is removed on purpose by the 4B overlay. `4E-2 old provider` looks at components; this rule looks at every other place (a meta-data value, a leftover marker, another attribute). A component named exactly that is left to 4E-2 and is not reported twice (case 16). `moe.shizuku.manager.ShizukuManagerProvider` does not contain that string, so the kept provider never trips it. |

The checker has 17 rules now (4 of 4E-2, 5 of 4E-3, 5 of 4E-4a, 3 of 4E-4b). Every rule row of 4E is done; row 4E-4c is the self-test and the notes. The success line lists all rules and says that 4E-4c adds the self-test and 5F the direct-boot rule (**5F added two rules, 19 now**; the 122 cases became 147).

**What was run (no Gradle needed).**
1. **24 hand-made cases through `check()`, all as expected** (a throw-away script, not in the zip; 4E-4c writes the real self-test and may reuse the list; the good manifest has all 13 manager components, the three boot receivers, all permissions of 4E-3 and a host `<application android:name>`). Good: no stale string (1), the one allowed `<queries>` entry (2, with the note; and no note when it is absent), the host `<application>` without a name (15), the manager's provider name (20). Stale package: the entry twice in two `<queries>` blocks (3), in an action name (4), in a `uses-permission` (5), in a meta-data value (6), allowed entry plus a stale value (7, exactly one error, for the value), a `<queries>` entry with a longer name (8), as element text (9), in a `<queries><intent>` action (10). Application class: `<application>` named `moe.shizuku.manager.ShizukuApplication` (11) or another manager class (12), `rikka.shizuku.ShizukuApplication` in a meta-data value (13), as a component name (14). Old provider string: the component left in the manifest (16: only `4E-2 old provider` fires), the name in a meta-data value (17), inside a longer string (18), in an attribute of another element (19). Shizuku not built in, with all three stale strings present (21: no rule runs). Several faults at once (22: the three 4E-4b rules fire, nothing else). With `STALE_QUERY_ALLOWED` set to 0, the way 7A-1 will: the entry fails (23), and without the entry it passes (24).
2. The command line on a good file (with the allowed entry: exit 0, the note, "17 rule(s) ran and passed") and on a bad one (exit 1, one `::error::` line for the Application class; a first version printed the same string twice, fixed in this part).
3. `py_compile` fine; `check-gradle.py` ok (15 `.kts` files, 11 unique namespaces).

**Not run here, and why.** No pseudo-merge on the real patched manifests (no network, `shizuku/upstream/` and `mika/upstream/` are not in the zip). The strings come from findings 4A / 7, 4B and 4D-4, which read the real files.

**Not verified.** (1) The real merged manifest of a Gradle build (first CI run): that the merger keeps Mika's `<queries>` entry exactly as `<package android:name="moe.shizuku.privileged.api"/>`, and that no other module adds the string (a grep of the zip's manifests and of the generated Shizuku and Mika manifests read in 4A found only that entry). (2) That the real merged manifest has no other text containing `ShizukuApplication` (the manager manifest has no `<application>` attributes, checked in 4A). (3) Device behaviour. No Gradle run, no device.

Next: 4E-4c (self-test on a hand-made good and bad manifest for every rule of 4E-1 ... 4E-4b: the 22, 30, 40 and 24 cases above are the material; run on the real merged manifest if a build exists; README plan row, `docs/CHANGES-shizuku-part4e.md`), then 4F-1 ... 4F-3, 4G-1, 4G-2.

## 4E-4c — self-test and notes (done)

**New: `shizuku/tools/test-check-merged-manifest.py` (executable) and `docs/CHANGES-shizuku-part4e.md` (covers all of 4E). Changed: `shizuku/tools/check-merged-manifest.py` (text only: the header, the `--help` description and the last output line now point to the self-test; no rule, constant or helper changed), `shizuku/README.md`.** No workflow, manifest, Gradle, patch script or other code touched; no workflow calls the checker or the self-test yet; nothing built. `includeShizuku` is still off by default. This closes row 4E: the checker has 17 rules, every one with a bad case that proves it.

**How to run** (no Gradle, no network; it writes only into a temp folder):

```
python3 -I shizuku/tools/test-check-merged-manifest.py            # everything; exit 0 = all as expected, 1 = something failed (one ::error:: line each)
python3 -I shizuku/tools/test-check-merged-manifest.py -v         # every case on its own line
python3 -I shizuku/tools/test-check-merged-manifest.py -k 4a-2    # only the cases whose id or title contains the text (coverage, command line and real-manifest steps skipped)
python3 -I shizuku/tools/test-check-merged-manifest.py --list     # the ids and titles of the 122 cases
python3 -I shizuku/tools/test-check-merged-manifest.py --dump-good   # the hand-made good merged manifest every case starts from
python3 -I shizuku/tools/test-check-merged-manifest.py --no-real  # skip the look for a real merged manifest (what a CI step without a build wants)
```

| Part | What it checks | Size |
|---|---|---|
| Cases | A **good** merged manifest is built in code (`good_xml`: the 13 manager components, the three boot receivers, all permissions of 4E-3, `:app`'s `MainActivity` with `LAUNCHER`, Mika's components, `package` = `com.srizwan.win11`, a host `<application android:name>`; parameters for a renamed package, Mika out, Shizuku out). Each case changes it in one place (or a few) and states **exactly** which rule ids must fire and, where it matters, how many errors each gives, the state (`checked` / `failed` / `absent`), a note that must (or must not) be printed, and a piece of the error text. A rule that fires without being named fails the case. | 122 cases |
| Coverage | For each registered rule the self-test switches that rule off and requires some case to report "rule [...] did not fire". A rule with no bad case fails the self-test with "no case needs rule ...". This is what keeps row 5F's direct-boot rule (and any later rule) honest: it cannot be added without its bad case. | 17 rules |
| Registry | An empty registry passes and the success line says SKELETON; a planted rule fails with `[T] boom` and is removed again; with the real rules the line says "17 rule(s) ran and passed", lists every rule id and has no SKELETON. | 6 checks |
| Constants | The checker's switch `STALE_QUERY_ALLOWED` has the value the self-test expects (`EXPECTED_STALE_QUERY_ALLOWED`, **0 since 7A-1.2**, it was 1 before). **Row 7A-1.2 set the checker's constant to 0 and `EXPECTED_STALE_QUERY_ALLOWED` in the same step**; a change of only one of them fails this check on purpose. Every case that depends on the switch sets it itself (`patch=`), so none of them changes when 7A-1 flips it (tried on a copy: only this guard fails). | 1 check |
| Helpers | `Merged` and `Component`: permissions with duplicates kept, `-sdk-23`, `<permission>` elements, `<uses-feature>`, `<queries>` packages, components by kind and prefix, an unqualified name stays as written, `exported` / `directBootAware` / not written, filters with `priority`, `is_launcher`, `has_category`, several authorities (trimmed, empty dropped), `foregroundServiceType`, strings with their element, notes kept once, `expected_authority`, `is_exported`. | 23 checks |
| Command line | `main()` on files in a temp folder: good (exit 0, the success line), bad (exit 1, one `::error::` line naming rule and permission), Mika-only (exit 0, "not built in"), `--require-shizuku` on it (exit 1), a string error printed once (the duplicate fixed in 4E-4b), missing file / broken XML / wrong root / no `<application>` / `--variant foo` (exit 2), `--help` (exit 0); the search under `app/build/intermediates/merged_manifests/<variant>` (release by default, debug, a missing variant -> "run ./gradlew :app:assembleDebug first", no build folder -> exit 2); and three runs of the script as a real process (`python3 -I`): exit 0 / 1 / 2. | 21 checks |
| Real manifest | If `<root>/app/build/intermediates` holds a merged release or debug manifest, the checker runs on it too and a failing rule fails the self-test. No build = "none", skipped (`--no-real` skips the look). | **none here** |

**The 122 cases, by group** (numbering as the lists of the earlier sections; the manifests were made again, because the throw-away tests of 4E-2 ... 4E-4b were not in the zip):

| Group | Cases | Notes |
|---|---|---|
| `2-01` ... `2-22` (4E-2) | 22 | As listed in 4E-2: good; clash with Mika's provider; Mika's provider alone; no authority; package renamed with and without the authority; unresolved `${applicationId}`; guard (`exported` false / not written, permission missing / wrong, `multiprocess` true, written `false`); provider twice, two authorities, another provider owning the name, no provider; no `package` attribute (passes with a note) and a wrong suffix there (fails twice); whitespace in `authorities`; Shizuku not built in, and with `--require-shizuku`. |
| `3-01` ... `3-30` (4E-3) | 30 | Same numbers as the list in 4E-3 (case 30 = dynamic permission not requested + `API_V23` requested + `MANAGER` not requested: three rules, nothing else). |
| `4a-01` ... `4a-42` (4E-4a) | 42 | Same numbers as the list in 4E-4a for 1 - 40. The list gave no text for 36; it is "Mika's receiver renamed" (two errors: one missing, one unexpected). 35 is `:app`'s `BootReceiver` turned into a service (the "expected a receiver" branch). **New:** 41 (`SettingsActivity` has a filter, so without `android:exported` it counts as exported) and 42 (the manager's `BootCompleteReceiver` not exported). |
| `4b-01` ... `4b-24` (4E-4b) | 24 | Same numbers as the list in 4E-4b. 4b-16 gives the old provider component a different authority, so that only `4E-2 old provider` fires, as the list says. 4b-23 / 4b-24 set `STALE_QUERY_ALLOWED = 0` the way 7A-1 will. |
| `x-01` ... `x-04` (new) | 4 | A Mika-only build with Mika's old provider; faults of two different parts at once (4E-2 + 4E-3); package renamed *and* Mika out; a boot-receiver priority next to the allowed `<queries>` entry (only the boot rule fails, the entry stays a note). |

**What was run here.**
1. The self-test on the zip as it is: **122 cases, 17 rules covered, 6 registry, 1 constants, 23 helper, 21 command-line checks, all as expected.** The first run found one mistake, in the self-test itself (case 3-09 renamed the wrong permission); no mistake in the checker was found.
2. **The self-test notices a broken checker** (throw-away copies, not in the zip): `SERVICE_TYPE` changed to `dataSync` -> 144 errors; the `multiprocess` test removed from the provider guard -> 2; `STALE_QUERY_ALLOWED` set to 2 -> 3; the launcher rule registered as a no-op -> its cases report "did not fire"; `STALE_QUERY_ALLOWED` set to 0 (the 7A-1 flip) -> only the constants guard fails.
3. `py_compile` fine for both scripts; `check-gradle.py` ok (15 `.kts` files, 11 unique namespaces). No `__pycache__` is left in the tree (the self-test does not write bytecode).

**What the self-test does not prove.** The good manifest is hand-made from what 4A, 4D-1 ... 4D-3, 4E-2 ... 4E-4b read on the real v13.6.0 and Mika 0.1.52 manifests, so a green run says "the rules do what the rows say", not "the real merged manifest passes". That is the first CI run (rows 8D-2 / 8F), or the real-manifest step above on any machine that has built the app.

**Not run here, and why.** No Gradle build exists in this session (no `app/build`), so the real-manifest step printed "none"; the pseudo-merge on the real patched manifests of 4E-2 was not repeated (no network, `shizuku/upstream/` and `mika/upstream/` are not in the zip).

**Not verified.** (1) The real merged manifest of a Gradle build (first CI run): explicit `android:exported` on all 13 components, fully qualified names, Mika's receiver name after its patch, `foregroundServiceType` kept, the `package` attribute, AndroidX core's `DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION` elements, Mika's `<queries>` entry as written. (2) The 4A heading "all 14 of its manifest" against the 13 rows (4E-4a's open point; unchanged, no network). (3) Device behaviour. No Gradle run, no device.

Next: 4F-1 (manifest rules in `check-gradle.py`, and the self-test callable), then 4F-2, 4F-3, 4G-1, 4G-2.

## 4F-1 — manifest rules in `check-gradle.py` (done)

**Changed: `shizuku/tools/check-gradle.py` (item 9: the rules; `--self-test`; `--no-run`), `shizuku/README.md`; new `docs/CHANGES-shizuku-part4f1.md`.** No workflow, manifest, overlay, `app/build.gradle.kts`, patch script or other code touched; no workflow calls `check-gradle.py` with the new rules yet (row 4F-3 does the root checks); nothing built. `includeShizuku` is still off by default. The rules need no Gradle run, no fetched sources and no network.

| Rule (message prefix) | Fails when | Why |
|---|---|---|
| `4F-1 overlay` | `app/src/shizuku/AndroidManifest.xml` is missing, is not XML, is not rooted in `<manifest>`, has a `package` attribute, holds anything but one `<application>`, the `<application>` has attributes, holds anything but one `<provider>`, the provider is not named `rikka.shizuku.ShizukuProvider`, has no `tools:node="remove"`, or has children | 4B-2 gave the file exactly this shape. Without it Mika's provider and the manager's provider share the authority `${applicationId}.shizuku` (`INSTALL_FAILED_CONFLICTING_PROVIDER`). Attributes on `<application>` or a second element would be merged into the real app. The shape is beyond the row text ("present"), same habit as 4E. Comments are ignored (the file has a long one). |
| `4F-1 wiring` | a mention of `src/shizuku` in `app/build.gradle.kts` is outside an `if (shizukuIncluded) { }` block (an `else`, `if (!shizukuIncluded)` and a bare `run { }` all count as outside); the file does not wire exactly `debug` and `release` (once each, nothing else, nothing twice); any other `.kts` / `.gradle` file of the project mentions `src/shizuku`; `app/src/debug/AndroidManifest.xml` or `app/src/release/AndroidManifest.xml` exists | The overlay must act only when `:shizuku` is in the build; in a Mika-only build Mika's provider is the one thing that receives the binder from an external Shizuku app. Brace matching is done on the file with whole-line comments removed and string bodies blanked, so braces in `"${...}"` do not count. The last case is beyond the row text: `manifest.srcFile(...)` replaces the manifest of that source set, so a manifest in `app/src/debug` would be dropped silently with Shizuku on. |
| `4F-1 src/main` | any text file under `app/src/main` (`.xml .kt .java .kts .gradle .pro .txt .json .md .properties .cfg .yml .yaml .html .js .css`) contains the string `ShizukuProvider`, comments included | A removal there would act in every build (the rule 6 of `check-provider-match.py` already checks the manifest; this one needs no fetched sources and covers all files). "Shizuku provider" with a space is not the string. |
| `4F-1 tools` | one of the helper scripts is missing or does not behave as listed in the row | `check-provider-match.py --self-test` exit 0 ("cases as expected"); `check-provider-match.py` with empty source folders exit 2 ("not found"); `patch-upstream.py --help` exit 0 (mentions `--check`); `patch-upstream.py --check` on an empty folder exit 1 with "fetch-upstream.sh first" and no traceback (so the `--check` branch is really reached); the same through `bash patch-upstream.sh --check` (as the workflows call it; skipped with a note if there is no bash); `check-merged-manifest.py --help` exit 0; `test-check-merged-manifest.py --list` exit 0 (4E-4c). Seven runs, all through `python3 -I`, with `SHIZUKU_UPSTREAM_DIR` and `MIKA_UPSTREAM_DIR` pointing to an empty temp folder. `--no-run` skips them (the static rules still run). |

The script now prints `note: 4F-1: 7 helper script run(s) as expected` before the old success line, which is unchanged (`check-gradle ok: 15 .kts files ... 11 unique namespaces ...`).

**`--self-test` (new, like `check-provider-match.py`).** `python3 -I shizuku/tools/check-gradle.py --self-test` copies the files the script reads (`shizuku/` without `upstream`, the three build files of the root and `:app`, `mika/build.gradle.kts`, `gradle.properties`, the two `app/src` manifests) into a temp folder, breaks one thing at a time and runs the copy of the script: **33 cases, all as expected** (a good copy; the overlay missing / not XML / with a package / marker `merge` / marker missing / another name / a second element / an element outside `<application>` / attributes on `<application>` / children; the wiring outside the block, only debug, only release, a third source set, in an `else`, under `!shizukuIncluded`, mentioned by another build file, a comment about it (fine), a manifest in `app/src/debug` and `app/src/release`; the string in a manifest comment and in a Kotlin file of `src/main`, and "Shizuku provider" (fine); each helper script missing or failing, `patch-upstream.py` without its own message, and a broken tool with `--no-run` (not run)). Each bad case needs exit 1, the right message text and no traceback. A first version of three cases expected the wrong message text; that was a mistake in the self-test, fixed.

**What was run here.** The real project: `check-gradle.py` exit 0 (15 `.kts` files, 11 unique namespaces, 7 helper runs ok), also with `--no-run`; `--self-test` 33 of 33; `py_compile` fine; `test-check-merged-manifest.py` still 122 cases ok; no `__pycache__` left in the tree.

**Overlap with 4B-3, on purpose.** Rule 6 of `check-provider-match.py` (switch off touches nothing) says much the same about the wiring, but it needs the fetched Mika and Shizuku sources; 4F-1 runs on a bare checkout. Both stay.

**Not verified.** (1) That AGP 8.13.2 accepts `manifest.srcFile(...)` as written and the overlay really removes Mika's provider (4B-1 points 1 - 4, first CI run; the merged-manifest rules `4E-2 old provider` / `authority` catch it). (2) `patch-upstream.py --check` on a **real** patched checkout (no network here; it ran green in 4E-2). (3) The other helper scripts only through their help / self-test, not on real inputs. No Gradle run, no device.

Next: 4F-2 (re-check that `includeShizuku` is still `false` by default and fix the leftover "cannot be installed with `:mika`" notes), then 4F-3, 4G-1, 4G-2.

## 4F-2 — switch default and stale notes (done)

**Changed: comments and documentation only. No build logic, script, manifest, overlay, workflow or Kotlin / Java file changed; nothing built.** Files: `gradle.properties` (comment lines of the `includeShizuku` block), `settings.gradle.kts` (two comment lines), `app/build.gradle.kts` (one comment), `README.md` (root: state paragraph and plan row 4), this file, new `docs/CHANGES-shizuku-part4f2.md`. `includeShizuku` is still off by default.

### 1. The switch is still off (re-checked)

| Where | What was read | Result |
|---|---|---|
| `settings.gradle.kts` (the only place that reads the property) | `val includeShizuku = (providers.gradleProperty("includeShizuku").orNull ?: "false") == "true"` | default is the string `"false"`: off |
| `gradle.properties` | a line starting with `includeShizuku` that is not a comment (grep `^[^#]*includeShizuku`) | none: the switch is only a commented example |
| `app/build.gradle.kts` | `val shizukuIncluded: Boolean = rootProject.findProject(":shizuku") != null` | not a property: follows the include list, so it is off when settings is off |
| root `build.gradle.kts` | `if (findProject(":shizuku-api") != null)` around the substitution map | same: off when settings is off |
| the three build workflows, `keystore.yml`, `restore.yml`, `unzip.yml` | grep `includeShizuku` | 0 mentions: no CI run sets it (also not as `ORG_GRADLE_PROJECT_includeShizuku`) |
| every `.sh` / `.py` / `.yml` / `.json` outside `shizuku/` | grep | none |
| `python3 -I shizuku/tools/check-gradle.py` (check 8) | fails if the default string is flipped or if `gradle.properties` sets `includeShizuku` | ok: 15 `.kts` files, 11 unique namespaces, 7 helper runs as expected |

So with the default settings the build is exactly the build before step 3: no Shizuku project exists, no plugin is resolved, the overlay manifest is not wired.

### 2. The stale "cannot be installed" notes

All of them said that an APK with `:mika` and `:shizuku` cannot be installed until step 4. That stopped being true in 4B-2: `app/src/shizuku/AndroidManifest.xml` removes Mika's `rikka.shizuku.ShizukuProvider` when `:shizuku` is in the build, so only `moe.shizuku.manager.ShizukuManagerProvider` owns `${applicationId}.shizuku`. Nothing has been built, so the honest wording is "expected to install; the first CI run confirms". What was found by grep over the whole zip (not only the three places named in the row) and what was done:

| Place | Old statement | Now |
|---|---|---|
| `shizuku/README.md`, 3B decision "Off by default" | "stays off until step 4 ... would make the APK uninstallable" | says the clash is resolved in 4B-2 and that the default also waits for 6E (init call) and step 8 (CI checks) |
| `shizuku/README.md`, 3F decision 7 | "cannot be installed while it contains both" | marked as written in 3F and superseded by 4B-2; the "That is step 4" sentence says it was done in 4B-2 |
| `shizuku/README.md`, 3F table row for `gradle.properties` | "the install limit until step 4" | adds that the limit is gone since 4B-2 |
| `shizuku/README.md`, "First CI run: what to look at", command 3 | "the APK builds but cannot be installed with `:mika` in it until step 4" | the APK is expected to install; what to do if not (the two symptoms, fallback way (iv) of 4B-1) and a pointer to the merged-manifest checker (17 rules) |
| `gradle.properties` | "Until the manifest merge (step 4) and the hooks (step 6) are done, an APK ... cannot be installed" | the overlay removes the clash; hooks and init call are not done, so the switch stays off until 8F |
| `settings.gradle.kts` (2 lines) | "not installable until step 4" / "so an APK built with it could not be installed next to Mika" | same correction; the reasons for "off" are now the hooks (6), the init call (6E) and the CI checks (8). The text deliberately does not name the overlay file: `check-gradle.py` rule `4F-1 wiring` fails if any other build file mentions its path |
| `app/build.gradle.kts` (comment above `implementation(project(":shizuku"))`) | "NOT yet done: the other manifest rows (4C - 4E ...)" | brought up to date: 4C - 4E are done; open are the hooks and init call (6), the patches 5E - 5G and the CI work (8) (5E is done since; its comment now says 5F - 5G) |
| root `README.md` | "Until step 4 an APK ... cannot be installed" and plan row 4 `todo` | corrected; row 4 says in progress (4A - 4E, 4F-1, 4F-2 done) |

**Left as they are on purpose:** the `docs/CHANGES-*` files (history); the 4B-2 / 4B-4 / 4A texts of this file that talk about the clash as it was (they describe what that step did); the strings `INSTALL_FAILED_CONFLICTING_PROVIDER` in `app/build.gradle.kts`, the overlay file, `check-merged-manifest.py` and its self-test: they name the *symptom the clash causes*, which is what the rules guard against, not a claim that the APK cannot be installed.

### 3. What was run

`check-gradle.py` (ok, also with `--no-run`) and its `--self-test` (33 cases), `test-check-merged-manifest.py --no-real` (122 cases), `check-provider-match.py --self-test` (12 cases), `patch-upstream.py --help`, `mika/tools/static-check.py`, `py_compile` of the scripts, XML well-formedness of `app/src/main/AndroidManifest.xml` and the overlay, a second grep for "cannot be installed" / "not installable" outside `docs/CHANGES-*` (only the historical texts named above remain), and no `__pycache__` in the tree.

**Not verified.** That the APK really installs with both modules (needs a Gradle build; the merged-manifest rules `4E-2 authority` / `old provider` and the first CI run decide). Nothing else: no logic was touched.

Next: 4F-3 (the root checks run all three Shizuku checkers and the two self-tests), then 4G-1, 4G-2.

## 4F-3 — root checks run all Shizuku checks (done)

**New: `shizuku/tools/check-all.py` (executable), `docs/CHANGES-shizuku-part4f3.md`. Changed: `mika/tools/static-check.py` (header text, new function `check_shizuku`, one call in `main`), `shizuku/README.md`, `README.md` (root, plan row 4).** No workflow, manifest, overlay, Gradle file, patch script, checker rule or `check-gradle.py` touched; no workflow calls `check-all.py` yet (row 8D-2); nothing built. `includeShizuku` is still off by default.

### Which "root check"

The repository has two project-wide static checks, `mika/tools/static-check.py` and `seal/tools/static-check.py`; the first one is the one 3H called "the project's static check" (workflows, shell and Python scripts, 600+ XML files, resource clashes, Gradle wiring, line endings). It is the root check. It already parsed every `*/tools/*.py` with `ast` (so `check-all.py` is syntax-checked there too) but ran no Shizuku checker. Check 11 does now. The Seal check is not touched (it has nothing to do with Shizuku). The orchestration is in a script of its own, `shizuku/tools/check-all.py`, not inside `static-check.py`, so that one command runs the Shizuku checks on their own (`python3 -I shizuku/tools/check-all.py`) and a workflow can call it later without the rest.

### The steps

| Step | Runs | What it proves | Needs |
|---|---|---|---|
| S1 `gradle` | `check-gradle.py` | structure of all Gradle files, the 4F-1 rules (overlay shape, wiring only inside `shizukuIncluded`, no `ShizukuProvider` in `src/main`, 7 helper-script runs), switch default off | nothing |
| S2 `gradle-self` | `check-gradle.py --self-test` | its 33 cases (the rules above do notice a broken project) | nothing |
| S3 `manifest-self` | `test-check-merged-manifest.py --no-real` | 122 cases, every one of the 17 merged-manifest rules has a bad case that makes it fire | nothing |
| S4 `provider-self` | `check-provider-match.py --self-test` | its 17 cases (12 + 5 of 7B) | nothing |
| S5 `provider-real` | `check-provider-match.py` | provider removal hits exactly Mika's provider on the REAL patched manifests (4B-3) | a fetched + patched Shizuku or Mika manifest (`shizuku/upstream`, `mika/upstream`, or `SHIZUKU_UPSTREAM_DIR` / `MIKA_UPSTREAM_DIR`) |
| S6 `patch-real` | `patch-upstream.py --check` | the patch self-check (rules 4C-2, 4C-3, the host-package places, resource names) on the patched checkout | `shizuku/upstream/settings.gradle` and the marker `.win11-patched` |
| S7 `manifest-real` | `check-merged-manifest.py --variant release` and / or `debug`, `--root` | the 17 rules of 4E on the REAL merged manifest | a merged manifest under `app/build/intermediates/**/merged_manifests/<variant>*` (found with the same test as the checker itself) |

**Behaviour.** Every step is its own process (`python3 -I -B`, working folder = project root, 600 s timeout by default); all steps run even after a failure, so one run shows every problem. A failed step prints one `::error::shizuku checks: [Sn] name: exit N (args)` line and the last 12 lines of its output (a missing script and a timeout are failures with their own message); the summary line says how many steps failed, ran ok and were skipped. Exit 0 = every step ok or skipped; 1 = at least one failed; 2 = the script could not run (bad option, `--no-real` together with `--require-real`, no `shizuku/tools` under `--root`). S5 - S7 are **skipped with the reason and the command that creates the input** when it is missing: a bare checkout (the project zip) is green. `--require-real` makes every skip a failure (the mode for a CI step after fetch + patch + build); `--no-real` skips S5 - S7 even if their inputs exist. A real step that exits 2 (its own "input missing") is a skip, not a failure; exit 1 is always a failure. `-v` shows the last lines of the output of every step, `--list` prints the table, `--timeout`, `--root`.

**In `static-check.py`.** Check 11 `check_shizuku()` runs `check-all.py --root <project>` (1800 s timeout). Success: one line `static-check: OK  shizuku: shizuku checks ok: 4 step(s) ran ok, 3 skipped (S5, S6, S7)`. Failure: every output line of the child is printed with a `static-check:   |` prefix (the child's `::error::` lines are not turned into workflow annotations twice), then `::error::static-check: shizuku checks failed (exit N), see the lines above` and the check exits 1: one failing rule of any Shizuku checker fails the whole root check. Without `shizuku/tools/check-all.py` (a build without the Shizuku part) the check is skipped with a note.

### What was run

1. `python3 -I shizuku/tools/check-all.py` on the real project: S1 - S4 ok, S5 - S7 skipped (no fetched sources, no build in this session); exit 0. `--require-real`: S5 - S7 fail with their reasons, exit 1. `--list`, `--help`: exit 0.
2. `check-all.py --self-test`: **64 checks ok** (fake root of stub scripts in a temp folder; the project tree is compared before and after). The first run found two mistakes of the self-test (an `iso=True` that is `1`, a `-v` that printed nothing for an ok step, fixed) and **one real bug of the script**: the real steps got their argument twice (`--check --check`), fixed.
3. `python3 -I mika/tools/static-check.py` on the real project: all checks passed, including `static-check: OK  shizuku: ...`.
4. **The root check notices broken Shizuku parts** (throw-away copies, not in the zip): the overlay marker changed from `remove` to `merge` -> S1 and S2 fail (`4F-1 overlay` error shown), static-check exit 1; `SERVICE_TYPE` of the merged-manifest checker changed to `dataSync` -> S3 fails (142 problems), static-check exit 1 with `1 problem(s)`.
5. `check-gradle.py` (also `--no-run`) ok; `--self-test` 33 of 33; `test-check-merged-manifest.py --no-real` 122 cases; `check-provider-match.py --self-test` 12 of 12; `py_compile` / `ast` of all scripts; no `__pycache__` in the tree.

**Not run here.** S5 - S7 on real inputs: this session had no network, so `shizuku/upstream/`, `mika/upstream/` and a Gradle build do not exist. Their command lines are tested against stubs (arguments, skip, fail, `--require-real`), not against the real scripts' behaviour on real files (those ran green in 4E-2 / 4B-3). `check-gradle.py`'s rule `4F-1 tools` does not list `check-all.py` (it would need new self-test cases there; `static-check.py` runs it instead).

**Not verified.** That S6 / S7 behave on a real checkout and a real merged manifest: first CI run (rows 8D-2 / 8F). Suggested use there: after fetch + patch + build, `python3 shizuku/tools/check-all.py --require-real`.

Next: 4G-1 (`NOTICE-Shizuku.md`: permission section), then 4G-2.

## 4G-1 — `NOTICE-Shizuku.md`, permission section (done)

**Documentation only: `NOTICE-Shizuku.md`, this file, new `docs/CHANGES-shizuku-part4g1.md`, `README.md` (root, plan row 4).** No code, script, manifest, overlay, Gradle file or workflow changed; nothing built; `includeShizuku` is still off by default.

What the notice got:
1. New section **"Permissions, who declares what (status after step 4G-1)"**: `MANAGER` (signature) and `API_V23` (dangerous, group `moe.shizuku.manager.permission-group.API`) are declared once, by `:shizuku`; what the host requests (`MANAGER` once, `API_V23` not) and the guard that removes the `API_V23` request; why the host has no `V3_SUPPORT` meta-data; `:mika` declares and requests no Shizuku permission; the removed `DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION` markers; the manager's other permission names (`INTERACT_ACROSS_USERS_FULL`, the undeclared `moe.shizuku.manager.permission.API`); the five identical shared `uses-permission` as a table; the two `uses-feature` (`touchscreen`, `leanback`, `required="false"`); a closing note with what Shizuku does not change and the open rows 5E - 5G.
2. Two new items in the list of changes (Apache-2.0 section 4): the two markers the patch script deletes (4C-1) and the overlay that removes Mika's provider (4B-2, our own file).
3. The first paragraph and the last two bullets (the "planned (steps 4 - 7)" one is now "done in step 4" plus "planned (steps 5 - 7)") describe the real state: step 4 statically checked, not built.

Every statement of the section was taken from this file (4A, 4C-1 ... 4C-4b, 4D-2 ... 4D-4, 4E-3), the comment block in `app/src/main/AndroidManifest.xml` and the patch scripts; none is new. The rules that check them are named in the section. The library table and its "to confirm in step 9" licence column are unchanged (step 9A).

Checked: `check-gradle.py` (ok), `check-all.py` (S1 - S4 ok, S5 - S7 skipped, no sources / build here), `mika/tools/static-check.py` (all checks passed), the notice has no CR characters and every section / table is well-formed Markdown (pipes counted per table row). **Not verified:** the merged manifest of a real build (first CI run), the licence column (step 9A).

Next: 4G-2 (step 4 notes: plan row step 4 done, step 4 / step 7 notes, `docs/CHANGES-shizuku-part4.md`, flat zip `RizwanS2-main-shizuku-step4.zip`).

## 4G-2 — step 4 notes and zip (done; step 4 is complete)

**Docs only: `shizuku/README.md` (this file), `README.md` (root, state paragraph and plan row 4), `NOTICE-Shizuku.md` (two status lines), new `docs/CHANGES-shizuku-part4.md` (covers all of step 4; the small files `part4a` ... `part4g1` and `plan-split` stay as history). Flat zip: `RizwanS2-main-shizuku-step4.zip`.** No code, script, manifest, overlay, Gradle file or workflow touched; nothing built. `includeShizuku` is still off by default. This closes row 4: 26 of 26 rows done, statically checked, never built.

### Step 4 at a glance

| Row | Result | Files |
|-----|--------|-------|
| 4A | Inventory of the manifests: components of `:shizuku`, clashes and risks (findings 1 - 10; 11 - 14 were added later) | docs |
| 4B-1 | Guard mechanism decided: build-type manifest overlay wired only when `:shizuku` is in the build (five ways compared; fallback: edit `MERGED_MANIFEST`) | docs |
| 4B-2 | `app/src/shizuku/AndroidManifest.xml` removes Mika's `rikka.shizuku.ShizukuProvider`; wired for `debug` and `release` inside `if (shizukuIncluded)` | new overlay, `app/build.gradle.kts` |
| 4B-3 | `shizuku/tools/check-provider-match.py` (6 rules, 12 self-test cases); Mika's merged-manifest checker accepts the removed provider only when the manager's provider replaces it | new script, `mika/tools/check-merged-manifest.py` |
| 4B-4 | Comments brought up to date ("cannot be installed yet", "6 providers" = 5 with Shizuku) | comments |
| 4C-1 | The patch script drops the two `DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION` remove markers (finding 2) | `patch-upstream.py` |
| 4C-2 | Self-check rule for it (10 hand-made cases) | `patch-upstream.py` |
| 4C-3 | `MANAGER` / `API_V23` have one owner, `:shizuku`; guard kept; second self-check rule (15 hand-made cases); one comment in the `:app` manifest | `patch-upstream.py`, `app` manifest (comment) |
| 4C-4a | Five shared `uses-permission` identical in `:app`, Mika and `:shizuku`: one each after the merge | docs |
| 4C-4b | `touchscreen` / `leanback` (`required="false"`) not new to the merged manifest, cannot hide the app | docs |
| 4C-4c | Notes and zip `step4c` | docs |
| 4D-1 | Nine activities: exactly three exported on purpose, no LAUNCHER filter, `APPLICATION_PREFERENCES` no clash | docs |
| 4D-2 | `AdbPairingService`: manifest fine (`shortService`, only `FOREGROUND_SERVICE`); new finding 11 (no `onTimeout`) | docs |
| 4D-3 | Three `BOOT_COMPLETED` receivers coexist, order harmless; new findings 12 (direct boot) and 13 (init order) | docs |
| 4D-4 | The host keeps `App`; place of the init call fixed; finding 12 decided (a+); new finding 14; rows 5F and 5G added; zip `step4d` | docs |
| 4E-1 | Checker skeleton `shizuku/tools/check-merged-manifest.py` | new script |
| 4E-2 | 4 rules: provider and authority | script |
| 4E-3 | 5 rules: permissions | script |
| 4E-4a | 5 rules: components, exported, launcher, service, boot receivers | script |
| 4E-4b | 3 rules: strings (stale package, `ShizukuApplication`, old provider) | script |
| 4E-4c | Self-test `test-check-merged-manifest.py`: 122 cases, every one of the 17 rules covered | new script |
| 4F-1 | Manifest rules in `check-gradle.py` (overlay shape, wiring, no `ShizukuProvider` in `src/main`, helper scripts callable); `--self-test` (33 cases) | `check-gradle.py` |
| 4F-2 | Switch re-checked (still off); stale "cannot be installed" notes fixed | comments, README |
| 4F-3 | `shizuku/tools/check-all.py` (7 steps) and check 11 of the root check `mika/tools/static-check.py`; `check-all.py --self-test` (64 checks) | new script, `static-check.py` |
| 4G-1 | `NOTICE-Shizuku.md`: permission section, two new items in the list of changes | `NOTICE-Shizuku.md` |
| 4G-2 | This section, plan rows, `docs/CHANGES-shizuku-part4.md`, zip | docs, zip |

**What changed in the project during step 4, by kind.**
- *New files:* `app/src/shizuku/AndroidManifest.xml`; `shizuku/tools/check-provider-match.py`, `check-merged-manifest.py`, `test-check-merged-manifest.py`, `check-all.py`; the `docs/CHANGES-shizuku-part4*.md` files.
- *Behaviour changed (only with `includeShizuku` on, except the Mika checker):* the overlay and its wiring in `app/build.gradle.kts` (4B-2); `patch-upstream.py` (4C-1 deletes two elements of the generated manifest, 4C-2 / 4C-3 add self-check rules); `mika/tools/check-merged-manifest.py` rule 2 (4B-3, takes the old path in every build without Shizuku).
- *Checks only:* `check-gradle.py` (4F-1), `mika/tools/static-check.py` (4F-3, check 11).
- *Comments and documentation only:* `app/build.gradle.kts` (4B-4, 4F-2), `app/src/main/AndroidManifest.xml` (4B-4, 4C-3), `gradle.properties` and `settings.gradle.kts` (4F-2), `NOTICE-Shizuku.md` (4G-1, 4G-2), both READMEs.
- *Never touched in step 4:* the three build workflows, `keystore.yml`, `restore.yml`, `unzip.yml`, any Kotlin / Java file, any resource, and the default of `includeShizuku`.

### The 14 findings, final state after step 4

| # | Finding | State | Who closes what is left |
|---|---------|-------|-------------------------|
| 1 | Provider authority clash with Mika | **resolved** 4B-2; checked 4B-3, 4E-2, 4F-1 | first CI run (the four AGP points of 4B-2) |
| 2 | `DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION` removed for the whole app | **fixed** 4C-1; rule 4C-2; merged-manifest rule `4E-3 dynamic receiver` | first CI run (merged manifest) |
| 3 | `uses-permission API_V23 tools:node="remove"` | **checked** 4C-3 (guard kept); rule `4E-3 no API_V23 request` | 7C (see the correction below) |
| 4 | `<permission>` declarations | **checked** 4C-3; rules `4E-3 declared once` / `levels` / `manager request` | - |
| 5 | Duplicate `uses-permission`, new `uses-feature` | **checked** 4C-4a, 4C-4b, nothing to change | - |
| 6 | Foreground-service types at targetSdk 37 | **checked** 4D-2; rule `4E-4a service` | - |
| 7 | Stale package `moe.shizuku.privileged.api` in Mika's `<queries>` and in `SHIZUKU_PACKAGE` | **manifest side done**: 7A-1.1 writes the host package into the entry (Mika's patch script); 7A-1.2 sets `STALE_QUERY_ALLOWED = 0`, so the rule `4E-4b stale package` allows no entry any more; `SHIZUKU_PACKAGE` (Kotlin): **patch done in 7A-2.1** (Mika's patch script, part 16), the read-only check is **7A-2.2** (`check-manifest.py` check 14); finding 7 is done | - |
| 8 | Same action names on different components | ok, nothing to do | - |
| 9 | Process and task | note written in 4D-4 | 6A |
| 10 | Hard-coded host package in `HomeViewModel.kt` | info, follows the CI rename | 5A, 5B |
| 11 | `AdbPairingService` has no `onTimeout` | **patched in 5E** (not yet run on the real source; device check open) | 5E |
| 12 | The built-in manager starts the main process in direct boot | **decided (a+)** in 4D-4; **done in 5F** (list of components corrected to five in 5G) | 5F (patch, self-check rule, checker rule) |
| 13 | Boot receiver needs the `ShizukuApplication.onCreate(app)` call | **call written in 6E** (`App.onCreate`) | 8F (order: default on only after 6E, now met) |
| 14 | Night-mode setting is process-wide in the host | **decided** in 4D-4; **done in 5G** | 5G (patch part H, self-check rule) |

### Decisions of step 4, consolidated

(Details and reasons are in the section named in the last column.)

| # | Decision | Where |
|---|----------|-------|
| 1 | Mika's provider is removed, the manager's is kept: it is a subclass that also answers `sendUserService`, and no file of Mika's sources mentions `ShizukuProvider` | 4A, 4B-3 |
| 2 | The removal is a build-type manifest overlay wired only inside `if (shizukuIncluded)`, for `debug` and `release`; the merger keys a `<provider>` by `android:name`; fallback is a task that edits `MERGED_MANIFEST` | 4B-1, 4B-2 |
| 3 | The overlay file must never move into `src/main` and its path is named in no other build file; three checks enforce it (`check-provider-match.py` rule 6, `check-gradle.py` `4F-1 wiring`, `4F-1 src/main`) | 4B-3, 4F-1 |
| 4 | The two `DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION` markers are deleted from the generated manager manifest; the patch dies if upstream no longer has exactly these two | 4C-1 |
| 5 | The permission names stay (every Shizuku client and the server's `BinderSender` use them); `:shizuku` is the only owner of `MANAGER` (signature) and `API_V23` (dangerous, group `moe.shizuku.manager.permission-group.API`); the `API_V23` guard stays; the host asks for `MANAGER` once, never for `API_V23` | 4C-3, 4E-3 |
| 6 | Exactly three of the nine activities are exported on purpose; no LAUNCHER filter from `:shizuku`; the Start menu (step 6) is the only way in | 4D-1, 4E-4a |
| 7 | `AdbPairingService` stays `shortService` (no extra permission); its time limit is fixed by a source patch, not by the manifest | 4D-2, row 5E |
| 8 | The three boot receivers stay as they are; no `priority`; the checker requires exactly three | 4D-3, 4E-4a |
| 9 | The host keeps its `App`; `ShizukuApplication.onCreate(this)` goes into the launcher-process part of `App.onCreate`, inside `try/catch (Throwable)`, after the `AppLog.i("process start")` line and before the Seal block | 4D-4, row 6E |
| 10 | Finding 12, option (a+): strip `directBootAware` from `BootCompleteReceiver`, `ShizukuReceiver`, `ShizukuManagerProvider`, `RequestPermissionActivity`, `ShellRequestHandlerActivity` (the last two found in 5G) and the `LOCKED_BOOT_COMPLETED` filter; the owner can still reverse it before 5F is written | 4D-4, row 5F |
| 11 | Finding 14: keep the stored night-mode setting but apply it per activity in `AppActivity`, never through the static `AppCompatDelegate.setDefaultNightMode` | 4D-4, row 5G |
| 12 | One checker per layer: the patch self-check on the generated manifest, `check-provider-match.py` on the fetched manifests, `check-merged-manifest.py` on the merged manifest, `check-gradle.py` on the project files, `check-all.py` runs them all, check 11 of `static-check.py` runs `check-all.py`. Steps that need fetched sources or a build skip with a reason on a bare checkout; `--require-real` makes the skip a failure | 4B-3, 4E, 4F |
| 13 | A rule cannot be added without its bad case: the coverage check of the self-test switches every rule off in turn | 4E-4c |
| 14 | `includeShizuku` stays off by default until 8F, and 8F comes after 6E (the init call) and after the CI checks of 8D (**8F was done after 6E and after the 8D scripts exist, but before any CI run has passed them**, see "8F") | 4D-3, 4F-2 |
| 15 | The `docs/CHANGES-*` files of earlier letters stay as history; each letter has one combined file (`part4b`, `part4c`, `part4d`, `part4e`) and step 4 has `part4` | 4G-2 |

### The checks that exist now (all run without Gradle, network or fetched sources unless stated)

| Command | What it proves | Size |
|---|---|---|
| `python3 -I shizuku/tools/check-all.py` | runs S1 - S7 below and S8 - S11 (added in 10A, see the rows after S7), all of them even after a failure; `--require-real` turns skips into failures, `--no-real` skips S5 - S7 and S11, `--list`, `-v` | 11 steps; `--self-test` 84 checks (64 before 10A) |
| S1 `python3 -I shizuku/tools/check-gradle.py` | structure of all `.kts` files, namespaces, include list, switch default off, the 4F-1 manifest rules, 7 helper-script runs (`--no-run` skips those) | `--self-test` 61 cases (33 of 4F-1 + 11 of 5B-2 + 3 of 5C + 14 of 5D, 5E and 5F) |
| S3 `python3 -I shizuku/tools/test-check-merged-manifest.py --no-real` | the 19 merged-manifest rules on a hand-made good manifest and bad variants | 147 cases, 19 rules covered, 6 + 1 + 23 + 21 further checks (since 5F; 122 cases and 17 rules before) |
| S4 `python3 -I shizuku/tools/check-provider-match.py --self-test` | the provider-match rules on hand-made inputs | 17 cases (12 until 7B) |
| S5 `python3 -I shizuku/tools/check-provider-match.py` | the same rules on the real fetched and patched manifests | needs `shizuku/upstream`, `mika/upstream` |
| S6 `python3 shizuku/tools/patch-upstream.py --check` | the patch self-check (rules of 4C-2 and 4C-3, host-package places, resource names) on a patched checkout | needs the fetched source |
| S7 `python3 shizuku/tools/check-merged-manifest.py --variant release` (or `debug`) | the 17 rules on the real merged manifest | needs a Gradle build |
| `python3 -I shizuku/tools/test-patch-host-package.py` | the host-package rules of `patch-upstream.py` on hand-made files: package name check (5B-1), `starter.cpp` macro (5B-1), `extractNativeLibs` (5B-2), binder extra key kept and package-name uses replaced (5C), the later parts (5D - 5G). **S8 of `check-all.py` since 10A** | 224 cases (60 until 5C) |
| `python3 -I shizuku/tools/sweep-package-strings.py --self-test` | the sweep of 5A (old name, host-package places, namespace sorting) and its 5C rules (kept binder extra key). **S9 of `check-all.py` since 10A**; on a real patched tree it is run without `--self-test`: **S11** (exit 2 = no patched checkout = skip) | 37 cases (30 + 7) |
| `python3 -I shizuku/tools/check-apk-contents.py --self-test` | the APK-content check (8D-1) on hand-made APKs. **S10 of `check-all.py` since 10A**; the real call on the built APK is in the three workflows (8D-2 / 8F) | 33 cases |
| `python3 -I mika/tools/static-check.py` | the root check, project-wide; its check 11 calls `check-all.py` | one failing Shizuku step fails it |
| `mika/tools/check-merged-manifest.py` | Mika's own checker; rule 2 accepts the removed provider when the manager's provider replaces it | unchanged for builds without Shizuku |

The 17 rules of `check-merged-manifest.py`, by id: `4E-2 authority`, `4E-2 owner`, `4E-2 old provider`, `4E-2 provider guard`; `4E-3 dynamic receiver`, `4E-3 no API_V23 request`, `4E-3 declared once`, `4E-3 levels`, `4E-3 manager request`; `4E-4a inventory`, `4E-4a exported`, `4E-4a launcher`, `4E-4a service`, `4E-4a boot receivers`; `4E-4b stale package`, `4E-4b application class`, `4E-4b old provider string`. The success line of the checker prints the same ids.

### What step 4 leaves open (the first CI run decides; nothing here has been built)

1. **The four AGP points of 4B-2:** `sourceSets.getByName("debug"|"release").manifest.srcFile(...)` is accepted by AGP 8.13.2 as written; a `remove` marker that matches nothing is silent (Shizuku on, `-PincludeMika=false`); an overlay manifest without `package` merges; the merger keys providers by `android:name` only. Symptom if wrong: `INSTALL_FAILED_CONFLICTING_PROVIDER`, or `rikka.shizuku.ShizukuProvider` still in the merged manifest. Fallback: way (iv) of 4B-1.
2. **The merged manifest of a real build against the 17 rules** (S7): explicit `android:exported` on all 13 components, fully qualified names, Mika's receiver name after its patch, `foregroundServiceType` kept, the `package` attribute, AndroidX core's `DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION` elements, Mika's `<queries>` entry as written. The 4A heading says "all 14 of its manifest" while its table has 13 rows (the checker uses 13): unchanged, no network in the sessions that could have settled it.
3. **S5 and S6 on real inputs, in the state of this zip.** `check-provider-match.py` ran green on the real fetched manifests in 4B-3; fetch + patch + `--check` ran on the real v13.6.0 source in 4C-1, 4C-4a and, after the last change of `patch-upstream.py` (4C-3), in 4E-2 (self-check ok). Since then no script that reads those files changed, but nothing was run on them in 4F - 4G (no network). If a real run fails, the message names the element or the rule. **Update (5C):** `patch-upstream.py` changed in 5B-1, 5B-2 and 5C (new rules, one attribute dropped, the binder key kept) and has not been run on the real source since; the first run decides (its message names the file and the numbers). **Update (5D):** that run was made in 5D (network available): `fetch-upstream.sh` + `patch-upstream.sh` + `--check` on the real v13.6.0 source (patch output "A. ... in 5 files (5 places); binder extra key ... kept in 4 files", 237 names, 87 files, 42 languages: unchanged; self-check ok with the new 5D rule), `check-provider-match.py` on the real fetched Shizuku + Mika manifests (S5 ok), `sweep-package-strings.py` (7 host places in 7 files, the key 4 in 4 files, one `[review]` line explained in "5D"), and `grep -rn intent.extra.BINDER shizuku/upstream` (4 hits in the 4 files of the table). Still open: S7 and everything that needs a Gradle build.
4. **Device behaviour:** direct boot (finding 12), the short-service limit on Android 14 - 17 (finding 11), the night-mode order with `MaterialActivity` (finding 14), the hidden-API exemption in the main process, two ADB clients at the same moment (Mika and the manager), whether Android delivers the boot broadcast one receiver at a time; **(5C)** a stock Shizuku client app (outside the host) gets the binder from the built-in server: install one, start the server from the built-in manager, the client must report "running"; **(5D)** a client app's `Shizuku.requestPermission` shows the built-in manager's confirmation dialog (server -> `RequestPermissionActivity` with the host action), the shell loader's broadcast reaches the built-in manager (`REQUEST_BINDER`), and on Android 8.0 / 8.1 with a stock Shizuku also installed the fallback chooser lists two apps (finding 16); **(5F)** on a phone with a screen lock, reboot and look at the log folder of the host before and after the first unlock: the process must not start before it, and Shizuku's boot start must run after it (finding 12); **(5E)** open the pairing tutorial on Android 14+ and leave it for more than about 3 minutes: the "searching" notification goes away by itself and the app does not crash (finding 11).
5. **The licence column** of `NOTICE-Shizuku.md` (step 9A).

Suggested use in the first CI run, after fetch + patch + build: `python3 shizuku/tools/check-all.py --require-real` (S5 - S7 on the real sources and the real merged manifest in one go).

### Hand-over to steps 5 - 8 (what step 4 found and what each row has to do with it)

**Step 5.**
- **5A** keeps on purpose: the permission names (`moe.shizuku.manager.permission.*`), the namespace `moe.shizuku.manager`, the action `rikka.shizuku.intent.action.REQUEST_BINDER` (on `ShizukuReceiver` and on `ShellRequestHandlerActivity`, same as upstream), and `moe.shizuku.manager.permission.API` on `LegacyIsNotSupportedActivity` (a permission nobody declares: only the system can start it). Finding 10 (`HomeViewModel.kt`) is verified here.
- **5C** (found in 5C, finding 15): the binder extra key `moe.shizuku.privileged.api.intent.extra.BINDER` stays as upstream has it in `ShizukuService`, `ServiceStarter`, `ShizukuManagerProvider` and the API `ShizukuProvider`; part A therefore writes the host package in **5 places in 5 files** (+2 for `BuildConfig.APPLICATION_ID` = 7 in 7), not 9 in 7 (+2 = 11 in 9). 5D reads the intent actions on the same principle: a name that outside clients know stays, a name only the server and the manager use follows the host.
- **5E** (finding 11): `onTimeout(startId)` and `onTimeout(startId, fgsType)` in `AdbPairingService.kt` stop the foreground state and the service; one self-check rule in `patch-upstream.py`. The manifest side (`shortService`, not exported) is already checked by `4E-4a service` and stays. **Done in 5E** (patch part F, `check_pairing_timeout`, `check-gradle.py` item 13; see "5E").
- **5F** (finding 12): after the patch exists, add the direct-boot rule to `shizuku/tools/check-merged-manifest.py` (none of `BootCompleteReceiver`, `ShizukuReceiver`, `ShizukuManagerProvider` is `directBootAware`, `BootCompleteReceiver` has no `LOCKED_BOOT_COMPLETED` filter). It is **not** in 4E-4a because it would fail before the patch. Together with it: a bad case in `test-check-merged-manifest.py` (the coverage check fails without one), the rule count and the case count wherever they are quoted (the success line, the self-test text, the help text of `check-all.py` for S3 and S7, the README rows 4E-4c / 4F-3 and this section: now 17 rules / 122 cases), and a rule in `check-gradle.py` if the patch needs one. The checker's last output line already says "later: row 5F adds the direct-boot rule". **Done in 5F** (patch part G, `check_direct_boot`, the merged rules `5F direct boot` and `5F custom actions` in one go, 19 rules / 147 cases, `check-gradle.py` item 14; see "5F").
- **5G** (finding 14): the patch self-check gets "no `setDefaultNightMode` left in the manager sources". **Done in 5G** (`check_night_mode`, plus: `AppActivity` applies the mode in a guarded `attachBaseContext`, Settings still recreates, every activity reaches `AppActivity`; `check-gradle.py` item 15).

**Step 6.** **6A** gets the process / task note of finding 9 (written in 4D-4 into the row). **6E** is the only caller of `ShizukuApplication.onCreate(this)`; its exact spot is in the row (finding 13).

**Step 7 (notes from step 4).**
- **7A-1 (7A-1.1 and 7A-1.2 done; the bullet is the original text):** set `STALE_QUERY_ALLOWED = 0` in `shizuku/tools/check-merged-manifest.py` **and** `EXPECTED_STALE_QUERY_ALLOWED = 0` in `shizuku/tools/test-check-merged-manifest.py` in the same step; if only the checker changes, the constants guard of the self-test fails on purpose, and no other case changes (tried in 4E-4c on a copy). Cases `4b-23` / `4b-24` test the flipped value. Mika's patch script must write the host package into the `<queries>` entry only when the manager is built in (the entry is the *external* Shizuku app; a build without the manager still wants the stock name); check that `mika/tools/check-manifest.py` still agrees.
- **7A-2 (split in 7A-2.1 and 7A-2.2; both done):** `ShizukuController.SHIZUKU_PACKAGE` (Mika's Kotlin) follows the host package the same way; the checker's string rule has nothing left to allow since 7A-1.2. Found in 7A-2.1 on the real source: the constant is used twice for `getPackageInfo` and once for `getLaunchIntentForPackage`; the last one would open the Win11 launcher with the host package, so with the manager built in it starts `moe.shizuku.manager.MainActivity` instead.
- **7B (done):** already established in 4B-3 on the real files: no file of Mika's sources mentions `ShizukuProvider` (no import, no class reference, no ProGuard rule), and the manager's provider is `class ShizukuManagerProvider : ShizukuProvider()`. 7B only re-confirms it after the overlay was built.
- **7C (done, docs only; correction of the row text):** the row says "confirm `API_V23` is requested by Mika". After 4C-3 that is no longer the case with the switch on: the host does **not** request `API_V23` (the provider AAR's request is not merged because `:shizuku-provider` has `shizukuIgnored = manifest`, and the manager's guard removes it from anywhere else), and Mika's own `KEEP_PERMISSIONS` holds no Shizuku permission. What 7C has to check is the **run-time** path with the host as the manager: 4A (finding 3) says the server treats the manager's app id as always allowed, so the permission is believed not to be needed; this was read, not run.
- **7D (done, docs only):** the manager's provider also answers `sendUserService` (4A, finding 1), so `ShizukuShellUserService` is expected to bind through it; not run.
- **7E (done):** the notes above are listed in `NOTICE-Mika.md` (new section "Shizuku hook-up") and in `docs/CHANGES-shizuku-part7.md`.

**Step 8.** **8D-2** can use `check-all.py --require-real` (see above) and must know that `--require-shizuku` of the checker is only added after 8F. **8F** flips the default only after 8D passes in a first CI run and **after 6E** (finding 13: without the init call the boot receiver throws at every boot). **8D-1 (done)** is the script; **8D-2 (done)** calls it and the manifest checker from the three workflows (module-on test: the manager's `MainActivity` in the merged manifest; 8F makes both calls unconditional). **8E** (cache key) is unchanged (8A already writes the key: version + both commits + the three scripts; 8E reviews it). **8A (done):** the Shizuku step sits after the Mika step in `UltimateBuild.yml`, 8B and 8C copy it (both done; 8C has one condition more, see "8C"). The first-CI-run list of step 3 and the open list above belong together.

### What was run in 4G-2

1. `python3 -I shizuku/tools/check-all.py`: S1 - S4 ok, S5 - S7 skipped (no fetched sources, no build in this session), exit 0, before and after the edits.
2. The self-tests: `test-check-merged-manifest.py --no-real` 122 cases, 17 rules covered, 6 + 1 + 23 + 21 checks; `check-gradle.py --self-test` 33 of 33; `check-provider-match.py --self-test` 12 of 12; `check-all.py --self-test` 64 checks.
3. `python3 -I mika/tools/static-check.py`: all checks passed, including check 11 (`shizuku checks ok: 4 step(s) ran ok, 3 skipped`).
4. The README tables: every row has the same number of columns as its header; the row counts and rule counts quoted in this section were compared with the scripts' own output (26 rows, 17 rules, 122 / 33 / 12 / 64).
5. No CR characters in the changed Markdown files; no `__pycache__`, no `shizuku/upstream/` and no `mika/upstream/` in the zip.

**Not run, and why.** No Gradle build, no device, no network in this session: S5 - S7 on real inputs, the merged manifest of a real build, and all points of the open list above.

Next: 5A (source sweep of the patched manager, server, starter, shell and `ShizukuProvider` for `moe.shizuku.privileged.api` / `moe.shizuku.manager` strings that must now be the host package; list what stays on purpose), then 5B-1 ... 5G.

## 5B-1 — `pm path` and the host package (done)

**Code: `shizuku/tools/patch-upstream.py` (three additions, no change to what the patch writes into the sources), new `shizuku/tools/test-patch-host-package.py`. Docs: this file, root `README.md`, `NOTICE-Shizuku.md` (one line), new `docs/CHANGES-shizuku-part5b1.md`. Flat zip: `RizwanS2-main-shizuku-step5b1.zip`.** Behind the `includeShizuku` switch (still off by default); nothing built; 5A was not done first (the owner asked for 5B-1 directly); it was done right after, see "5A".

### What the row asked and what is true

The native starter (`libshizuku.so`, source `manager/src/main/jni/starter.cpp`, started by `app_process` / root shell) finds the APK of the manager by running `pm path` with the manager's package name. In upstream that name is the macro `PACKAGE_NAME` (`moe.shizuku.privileged.api`). Inside Win11 the "manager" is the host app, so the lookup has to ask for `com.srizwan.win11` (or whatever the CI rename made of it), otherwise the starter looks for an app that does not exist and the server does not start.

| Question | Answer | Where it is enforced |
|---|---|---|
| Where does the host name come from? | `applicationId` of `app/build.gradle.kts`, read at patch time. The CI package rename (`sed` over the project files) runs before the fetch / patch step, so a renamed package is followed with no change here (the three workflows have no Shizuku step yet: row 8A - 8C must put it after the rename). `--host-package` / `SHIZUKU_HOST_PACKAGE` override it (tests). | `host_package()` in `patch-upstream.py`; marker hash = script + host, so a new name re-patches |
| Is the macro replaced? | Yes, in part A: `manager/src/main/jni/starter.cpp` is in `PACKAGE_FILES` with count 1, and `sub_once` dies if upstream does not have exactly one occurrence of the old name there. | `patch_package()` (unchanged) |
| Is the old name gone? | The self-check walks every `.cpp` / `.java` / `.kt` / `.xml` / ... file and fails on the old name (only `manager/build.gradle` is allowed to keep it). | `check()` (unchanged) |
| Is the *new* value really in the macro? | **New (5B-1):** exactly one `#define PACKAGE_NAME "<host>"` in `starter.cpp` (spacing and a trailing comment allowed; a commented-out define does not count; two defines or another value fail), and the old name nowhere in that file (so a comment cannot hide it either). | `check_native_package()` |
| Can the name break the shell command? | `pm path <package>` is a shell command line and the name is written into it unquoted, and into C / Java / Kotlin literals unescaped. **New (5B-1):** the host name must be a plain Android package name (letters, digits, `_`, at least one dot, each part starting with a letter); anything else (space, quote, `$`, `;`, backslash, backtick, newline, a trailing dot) stops the script with a message. Applies to the value read from the build file and to both overrides. | `check_host_name()` |
| Is there only one name at run time? | `app/build.gradle.kts` has no `applicationIdSuffix`, no `productFlavors` and no `flavorDimensions` today (read in this row; the other modules are libraries). **New (5B-1):** the script stops if an uncommented `applicationIdSuffix` appears there, because a debug suffix would install the app under another name than the one written into `starter.cpp`. | `host_package()` |

### Not read, and why

- The real `starter.cpp` (and the server sources) were **not** opened in this session: no network, `shizuku/upstream/` is not in the zip. What this README knew about the file (step 1: "`#define PACKAGE_NAME`", step 2: "`pm path`", 1 place) is what the new rule is built on. If v13.6.0 spells it differently (for example `constexpr`), S6 (`patch-upstream.py --check` on a patched checkout, first CI run) fails with a message that prints what it found, and the rule is adapted in one line.
- Whether the **server** side also runs `pm path` (or only uses `PackageManager` with `MANAGER_APPLICATION_ID`): not recorded anywhere in the zip. The server's strings (`ServerConstants`, `ShizukuService`: 2 places) are counted by `patch_package()` and the `ServerConstants` value is checked by the old self-check; what they are used for is row 5C (binder extras, `MANAGER` check) and 5D (intent actions).
- Device behaviour: that `pm path <host>` returns the path when started by `adb shell` / root on Android 14 - 17 (the shell user is not subject to package visibility filtering; read from the platform rules, not run), and whether the starter takes the APK path from an argument and only uses `pm path` as a fallback (not recorded here; the real source decides). Both go to the device list of "4G-2" (item 4).

### What was run

1. `python3 -I shizuku/tools/test-patch-host-package.py`: 32 of 32 hand-made cases (13 bad names including a trailing newline, 3 good names, 8 cases of the build-file read, 8 of the starter.cpp rule). One case failed first: a name ending in a newline slipped through `re.match` with `$`; it is `fullmatch` now.
2. `python3 -I shizuku/tools/check-all.py`: S1 - S4 ok, S5 - S7 skipped (no fetched source, no build), exit 0. `python3 -I mika/tools/static-check.py`: all checks passed.
3. `python3 shizuku/tools/patch-upstream.py --check` on an empty folder: exit 1 with its own message and no traceback (the helper check of `check-gradle.py` still sees that).
4. The patch script itself was **not** re-run on the real source (no network): the new rule has only been tried on hand-made files.

### What this row leaves

- Rows 8A - 8C: the Shizuku fetch + patch step goes after the package rename (the patch reads `applicationId` at that moment).
- S6 on the real source decides whether the new rule fits the real `starter.cpp`.
- Row 5B-2 next (native libraries), then 5C - 5G (5A, the source sweep, was done after this row).

## 5A — source sweep for the package strings (done as a tool; the real list comes with the first CI run)

**Code: new `shizuku/tools/sweep-package-strings.py` (with `--self-test`, 30 cases). Docs: this file, root `README.md`, new `docs/CHANGES-shizuku-part5a.md`. Flat zip: `RizwanS2-main-shizuku-step5a.zip`.** No existing script, manifest, Gradle file, workflow, Kotlin / Java file or resource changed; behind the `includeShizuku` switch (off by default); nothing built.

### What could and could not be done

The row says: grep the **patched** manager, server, starter, shell and `ShizukuProvider` for every `moe.shizuku.privileged.api` / `moe.shizuku.manager` string and list what stays on purpose. The patched source is fetched from GitHub at build time and is not in the zip, and this session had no network, so a fresh grep of the real tree was **not possible**. Instead of writing a list from memory, the sweep is a script that makes the list from the real tree whenever one exists (the first CI run, or a local run after fetch + patch), and the list of what stays on purpose below is taken from what this README already recorded from real runs (step 1 grep, step 2 patch runs on v13.6.0, 4A - 4G).

### The tool

`python3 shizuku/tools/sweep-package-strings.py [-v] [--strict] [--report FILE]` reads every text file of `shizuku/upstream/` (java, kt, kts, cpp, h, xml, aidl, gradle, pro, sh, txt, properties, json, cmake, `rish`; not `.git`, `build`, `demo`) of a **patched** checkout (it needs the `.win11-patched` marker, exit 2 otherwise) and reports:

| What | Rule | Fails the run |
|---|---|---|
| `moe.shizuku.privileged.api` (the old run-time name) | allowed only in `manager/build.gradle` (its `applicationId`, not used by our build) | any other place |
| the host package | exactly the places patch part A writes: the 9 of `PACKAGE_FILES` (7 files) plus the 2 that replace `BuildConfig.APPLICATION_ID` (`home/HomeViewModel.kt`, `authorization/AuthorizationManager.kt`): **11 places in 9 files**, nowhere else | a different count in any file |
| `moe.shizuku.manager` | sorted into `namespace` (`package` / `import` lines, `namespace` / `applicationId` of a build file), `class-name` (manifest `android:name`, keep rules, a main class named in a string), `permission` (`moe.shizuku.manager.permission.*`) and `review` (an action, extra, path or authority built from the namespace; the lines are printed) | only with `--strict` (a review item) |

Exit 0 / 1 / 2 (nothing wrong / problem / no patched checkout). It is not part of `check-all.py` and not wired into the workflows: new tools are wired in row 10A, and 8D-2 can call it after the build (`--report` writes the text for the README).

### What stays on purpose (from the records; the sweep confirms it on the real tree)

1. The Java / Kotlin **namespace** `moe.shizuku.manager` (a library may keep it; `R`, databinding and all class names depend on it).
2. The **permission names** `moe.shizuku.manager.permission.API_V23` and `...MANAGER`: every Shizuku client, Mika's manifest and the server's `BinderSender` use exactly these; plus `moe.shizuku.manager.permission.API` on `LegacyIsNotSupportedActivity` (a permission nobody declares: only the system can start it).
3. The action `rikka.shizuku.intent.action.REQUEST_BINDER` (on `ShizukuReceiver` and `ShellRequestHandlerActivity`): it is a `rikka.shizuku` name, not one of the two strings, and stays as upstream has it.
4. The `applicationId "moe.shizuku.privileged.api"` in `manager/build.gradle`: upstream's build file, not used by our Gradle wiring (`PACKAGE_ALLOWED_LEFT` in the patch script).
5. Entry-point class names in `consumer-rules.pro` (`...ShizukuService.main`, `moe.shizuku.starter.ServiceStarter.main`, `moe.shizuku.manager.shell.Shell.main`): `moe.shizuku.starter` and `rikka.shizuku.server` are not the two strings; `moe.shizuku.manager.shell.Shell` is a class name (the `class-name` category).

### Must be the host package (patch part A, all asserted by count)

`server/ServerConstants.java` (1), `server/ShizukuService.java` (1, binder extra), `starter/ServiceStarter.java` (2), `shell/ShizukuShellLoader.java` (1), `manager/src/main/jni/starter.cpp` (1, `pm path`, row 5B-1), `manager/ShizukuManagerProvider.kt` (1), `api/provider/ShizukuProvider.java` (2), and the two `BuildConfig.APPLICATION_ID` replacements.

### Finding 10 verified (`HomeViewModel.kt`)

Finding 10 said "hard-coded host package in `HomeViewModel.kt`". Read in `patch_library_code`: **two** files, not one — `home/HomeViewModel.kt` and `authorization/AuthorizationManager.kt` — each had exactly one `BuildConfig.APPLICATION_ID` (the patch dies if the count is not 1), now the host package as a string literal. It follows the CI rename because the patch runs after it and reads `applicationId` (row 5B-1). Nothing to do; the sweep counts both places.

### What was run

1. `python3 -I shizuku/tools/sweep-package-strings.py --self-test`: 30 of 30 cases (clean tree; old name in a source file and in a resource; old name only in `manager/build.gradle`; an unknown namespace use as `review`, with and without `--strict`; the bare namespace; another permission name; a longer name that only ends in or starts with the searched string; an extra, a missing and a new-file host-package place; `-v`; other extensions not read; unpatched and missing checkout exit 2; `--report`; 10 classification cases). Two cases of my first draft failed and were fixed: an action string `...intent.action.X` was taken for a class name (now `intent` / `action` / `extra` segments and ALL-CAPS endings are `review`), and a wrong expected count in one test.
2. `check-all.py` (S1 - S4 ok, S5 - S7 skipped, exit 0), `mika/tools/static-check.py` (all checks passed), `check-gradle.py` (ok).
3. The sweep was **not** run on the real patched source (no network).

### What this row leaves

- Run the sweep once on the real tree (first CI run or a local fetch + patch): `python3 shizuku/tools/sweep-package-strings.py -v --report sweep.txt`. Every `review` line is a decision for the owner: should it be the host package (then a patch step + a self-check rule, like 5B-1), or does it stay (then a line in the list above)? Row 5C - 5D read the binder extras and actions anyway and will use the same output.
- 5B-2 next, then 5C - 5G.

## 5B-2 — native libraries and packaging (done)

**Code: `shizuku/tools/patch-upstream.py` (one attribute dropped, one self-check rule), `shizuku/tools/check-gradle.py` (new item 10, 11 new self-test cases: 33 -> 44), `shizuku/tools/test-patch-host-package.py` (6 new cases: 32 -> 38), docstring of `check-all.py`. Docs: this file, root `README.md`, new `docs/CHANGES-shizuku-part5b2.md`. Flat zip: `RizwanS2-main-shizuku-step5b2.zip`.** Behind the `includeShizuku` switch (off by default); nothing built; the earlier sections of this file still quote "33" for the `check-gradle.py` self-test as it was when they were written (4F-1 ... 4G-2).

### What the row asked and what is true

`libshizuku.so` (the native starter; an `add_executable` that is named like a library, built from `manager/src/main/jni/CMakeLists.txt` with `libadb.so`) is **run**, not loaded: the manager starts it from the host app's native library folder (`nativeLibraryDir`) through ADB or root. That only works if the library is a real file on disk. With AGP's default for minSdk >= 23 the libraries stay inside the APK (not extracted) and `nativeLibraryDir` would be empty: the start button would fail with "file not found". So the host app must extract its native libraries, and `libshizuku.so` must exist for every ABI the APK ships.

| Question | Answer | Where it is enforced |
|---|---|---|
| Does `:app` extract native libraries? | Yes, both ways: `packaging { jniLibs { useLegacyPackaging = true } }` in `app/build.gradle.kts` and `android:extractNativeLibs="true"` on `<application>` of `app/src/main/AndroidManifest.xml` (BlackBox, Mika's `libmikarun.so` / `libproot.so`, Seal's yt-dlp / ffmpeg already needed it). A library cannot set it (AGP ignores `useLegacyPackaging` in a library, `:shizuku` says so in its header), so the guard is on `:app`. | **new:** `check-gradle.py` item 10 (`5B-2 packaging`, `5B-2 manifest`) |
| Could the library manifest disagree? | The patch script removes 15 `<application>` attributes of upstream's manifest but did **not** list `extractNativeLibs`. If upstream's `<application>` carries it, a value other than `"true"` would fail the manifest merge against `:app`, and `"true"` would be a second place to keep in step. **New:** `extractNativeLibs` is in `APP_ATTRS_DROP` (a missing attribute is not an error), and the self-check fails if any `<application>` tag of the library manifest still has it. | `patch-upstream.py` (`APP_ATTRS_DROP`, `check_application_attrs()`); `check-gradle.py` item 10 (`5B-2 patch`) |
| ABIs | `:shizuku` builds `libshizuku.so` / `libadb.so` for all four ABIs by default (`shizukuAbis`; `:shizuku-rish` builds `librish.so` the same way). `-PshizukuAbis=...` narrows them, `-PapkAbis=...` narrows what the APK ships (Seal part 7). If the APK shipped an ABI without `libshizuku.so`, a device that picks that ABI would install fine and the starter would be missing. **New rules:** the default names all four and feeds both `ndk { abiFilters }` and `cmake { abiFilters }`; an uncommented `shizukuAbis` in `gradle.properties` must cover every ABI of the APK (`apkAbis` if set, else all four). Today both lines are commented out. | `check-gradle.py` item 10 (`5B-2 abis`, `5B-2 abis property`) |
| Name clashes with other modules | None found: no other module of the zip ships `libshizuku.so`, `libadb.so` or `librish.so` (searched the file names, all `CMakeLists` / `*.kts` / `*.gradle` / `*.mk`, and the `.so` files of the project: only `:winlator`'s arm64 prebuilts, none of these names). `libc++_shared.so` is the only shared name that several modules ship and `:app` already has a `pickFirsts` for it; `:shizuku` builds with `-DANDROID_STL=none` and a Prefab libcxx (as upstream), so it adds no `libc++_shared.so` of its own (read from its build file, not seen in a build). | read, not a rule |

### Not read, not run

- The real `CMakeLists.txt` and `Starter.kt` / `ShizukuManagerProvider` code (no network): the facts above about how the manager finds the starter come from the comments of `shizuku/build.gradle.kts` (3E, written from the real v13.6.0 files) and from step 1 / 2 of this README. Whether the manager runs `nativeLibraryDir/libshizuku.so` directly or first copies it somewhere is not recorded here; either way the file must be extracted, so the rules above hold.
- The APK contents: whether `lib/<abi>/libshizuku.so`, `libadb.so`, `librish.so` are really inside the built APK **and stored extracted** is row 8D-1 (the APK content script; add the extracted-storage check for these three there, as the workflows already do for Mika's three files).
- Device behaviour: that the shell / root user can execute a file under the app's `/data/app/.../lib/<abi>/` on Android 14 - 17 (read from how Shizuku works today, not run), and 16 KB page-size alignment of the three libraries at targetSdk 37 (NDK 29 aligns ELF segments to 16 KB by default; not checked on a build; extracted libraries do not need the zip-level alignment). Both go to the device list of "4G-2" (item 4).

### What was run

1. `python3 -I shizuku/tools/check-gradle.py --self-test`: 44 of 44 (the 33 old cases and 11 new ones: `useLegacyPackaging` removed / false, `extractNativeLibs` removed / false in the `:app` manifest, default `shizukuAbis` narrowed, cmake filter not fed, `gradle.properties` narrowing `shizukuAbis` below the APK, a narrowed `apkAbis` that is covered (ok), a wider `apkAbis` (fails), a commented line (ignored), `extractNativeLibs` missing from `APP_ATTRS_DROP`). `check-gradle.py` on the real project: ok (also `--no-run`).
2. `python3 -I shizuku/tools/test-patch-host-package.py`: 38 of 38 (6 new: no attribute passes, `true` fails, `false` on another line fails, the word outside the tag is fine, `APP_ATTRS_DROP` names it, only the `<application>` tag itself is read).
3. `python3 -I shizuku/tools/check-all.py` (S1 - S4 ok, S5 - S7 skipped, exit 0) and `python3 -I mika/tools/static-check.py` (all checks passed).
4. The patch script was **not** re-run on the real source (no network): the new attribute drop and rule were tried on hand-made manifests only; S6 on the first CI run confirms them.

### What this row leaves

- 8D-1: list `lib/<abi>/libshizuku.so`, `libadb.so`, `librish.so` in the built APK and require them stored extracted (not compressed inside the APK).
- Row 5C next (binder extras, `ShizukuReceiver`, `MANAGER` check), then 5D - 5G.

## 5C — binder extras, `ShizukuReceiver` and the `MANAGER` check (done; one finding, fixed in the patch script)

**Code: `shizuku/tools/patch-upstream.py` (part A keeps the binder extra key; new self-check rule `check_binder_protocol()`; the old-name test knows the kept key), `shizuku/tools/sweep-package-strings.py` (expected counts and the kept key; 30 -> 37 self-test cases), `shizuku/tools/check-gradle.py` (new item 11, 3 new self-test cases: 44 -> 47), `shizuku/tools/test-patch-host-package.py` (22 new cases: 38 -> 60), docstring of `check-all.py`. Docs: this file, root `README.md`, `NOTICE-Shizuku.md` (two lines), new `docs/CHANGES-shizuku-part5c.md`. Flat zip: `RizwanS2-main-shizuku-step5c.zip`.** Behind the `includeShizuku` switch (off by default); nothing built; no workflow, manifest, Gradle build logic, Kotlin / Java file or resource of the project changed (the patch script changes what it writes into the *fetched* sources: four of the nine old names are no longer replaced).

### What the row asked and what is true

The row names four things: `BinderSender`, `ShizukuReceiver`, the extras that `ShizukuProvider` takes in `sendBinder`, and the `MANAGER` permission check. This session had **no network**, so the real v13.6.0 files were not opened again; what follows is built from what this README recorded from the real files (step 1 grep, step 2 patch runs with asserted counts, 4A manifests, 4D-4 source reads) plus the new tests.

| Part | What is true | Verdict | Where it is enforced |
|---|---|---|---|
| `BinderSender` (server) | Not in `PACKAGE_FILES`: it holds no old package name. The server's package uses are in `ServerConstants` (`MANAGER_APPLICATION_ID`, 1 place) and `ShizukuService` (1 place, the binder extra key). `ShizukuService` uses `MANAGER_APPLICATION_ID` to find the manager, grant it permissions, send it the binder and decide `isManager` (step 1 record); after part A that is the host package, so "the manager" is the host app and the binder goes to its provider `ShizukuManagerProvider` (authority `${applicationId}.shizuku`, checked by rule 3 of `check-provider-match.py` and `4E-2 authority`). | nothing to patch | `check()`: `ServerConstants` names the host (old rule), `check_binder_protocol()` counts the host places per file (new) |
| `ShizukuReceiver` (manager) | Exported, action `rikka.shizuku.intent.action.REQUEST_BINDER`, hands over to `ShellBinderRequestHandler`; it holds no old package name (not in `PACKAGE_FILES`) and, read in 4D-4, does not use `ShizukuSettings` or `application`. The action is a `rikka.shizuku` name, kept on purpose (5A list, item 3). | nothing to patch | 5A sweep (old name nowhere), `4E-4a exported` |
| `ShizukuProvider.sendBinder` extras | The extra key `moe.shizuku.privileged.api.intent.extra.BINDER` is written in four files (`ShizukuService`, `ServiceStarter`, `ShizukuManagerProvider`, API `ShizukuProvider`). Part A had replaced it by the host package like a package name. **Finding 15 (below): that is wrong.** | **fixed** | `patch_package()`, `check_binder_protocol()`, sweep, `check-gradle.py` item 11 |
| the `MANAGER` permission check | The two permission names stay (5A list, item 2); `MANAGER` (signature) and `API_V23` are declared once, by `:shizuku`; the host asks for `MANAGER` once and does **not** ask for `API_V23` (4C-3; merged rules `4E-3 declared once`, `levels`, `manager request`, `no API_V23 request`). Who the server treats as the manager is decided by the app id of the `MANAGER_APPLICATION_ID` package, not by this permission: with part A that is the host (step 1 record), and the server treats the manager app id as always allowed (4A finding 3). So there is no package string to retarget here. | nothing to change | rules of 4E-3 (already there) |

### Finding 15 — the binder extra key must not be renamed

**What the key is.** When the server (the process started by ADB or root) has a client app, it calls that app's provider (`<package>.shizuku`) and puts the binder into the call's extras under a fixed key; the provider reads the same key. In upstream the key is the text `moe.shizuku.privileged.api.intent.extra.BINDER`. It is **not** looked up from the manager's package at run time: it is a constant that the server, the starter, the manager's provider and the client library's `ShizukuProvider` each spell out. That is why the step 1 grep found it as part of the nine places that contain the old name (`ShizukuService` 1, `ServiceStarter` 2 = `EXTRA_BINDER` + `packageName`, `ShizukuManagerProvider` 1, API `ShizukuProvider` 2 = `MANAGER_APPLICATION_ID` + `EXTRA_BINDER`).

**What went wrong in part A.** It replaced all nine, so after the patch the server sends `<host>.intent.extra.BINDER` and the patched providers read `<host>.intent.extra.BINDER`. Inside the app that works: the manager and Mika (which uses the local patched provider since 3F) agree. But every other Shizuku client on the phone (a third-party app with the stock `dev.rikka.shizuku:provider`) reads the **old** key. The server would hand it the binder under a key it never looks at: the client's `Shizuku.pingBinder()` stays false, "Shizuku is not running" for every outside app, with no error anywhere. The built-in manager would be a Shizuku that only serves the host.

**The fix.** The key is a protocol name, not a package: it stays as upstream has it. Part A now replaces the old name **except** when it is the start of `...intent.extra.BINDER` (regex with a look-ahead, `OLD_NAME_RE`), and asserts per file how many old names there are in total (`PACKAGE_FILES`, unchanged) and how many of them are the key (`BINDER_EXTRA_KEPT`, new):

| File | old names (total) | kept as the binder key | replaced by the host package |
|---|---|---|---|
| `server/.../ServerConstants.java` | 1 | 0 | 1 |
| `server/.../ShizukuService.java` | 1 | 1 | 0 |
| `starter/.../ServiceStarter.java` | 2 | 1 | 1 |
| `shell/.../ShizukuShellLoader.java` | 1 | 0 | 1 |
| `manager/src/main/jni/starter.cpp` | 1 | 0 | 1 |
| `manager/.../ShizukuManagerProvider.kt` | 1 | 1 | 0 |
| `api/provider/.../ShizukuProvider.java` | 2 | 1 | 1 |
| **Sum** | **9** | **4** | **5 (in 5 files)** |

Plus the two `BuildConfig.APPLICATION_ID` replacements of `patch_library_code` (unchanged): **7 host-package places in 7 files** instead of 11 in 9. If a file does not have the numbers of its row, the patch stops with a message that names the file, the expected and the found numbers (same behaviour as every other anchor).

**What does not change.** Package-name uses (`MANAGER_APPLICATION_ID` in the server and in the API provider, `packageName` of the starter, `setPackage` of the shell loader, `PACKAGE_NAME` of `starter.cpp` / `pm path`) still become the host package; Mika is unaffected (key and provider are the same on both sides); nothing in the app's manifests or resources moves; there is no visible change in the app.

**Why not the other way round** (keep renaming and patch the outside clients): impossible, they are other people's apps.

### The new rules

| Rule | Fails when | Where |
|---|---|---|
| per-file count (patch time) | a file of `PACKAGE_FILES` has another number of old names than the table above, or another number of binder keys | `patch_package()` |
| old-name test knows the key | the old name is left anywhere except `manager/build.gradle` and as the start of the binder key (a longer key such as `...BINDER_X` still counts as the old name) | `check()` through `OLD_NAME_RE` |
| `check_binder_protocol` (self-check, S6) | the key is not in exactly the four files of `BINDER_EXTRA_KEPT`; the key is spelled with the host package anywhere in those files; a file names the host package more or less often than the table says; an old name is left outside the key | `patch-upstream.py` `check()` |
| sweep (5A tool) | the old name outside the key, `manager/build.gradle` excepted; the host package not in exactly 7 places in 7 files; the key not exactly once in each of the four files (it also catches a fifth file and a host-spelled key) | `sweep-package-strings.py` |
| `check-gradle.py` item 11 | `BINDER_EXTRA_KEPT` loses one of the four files (`5C binder keys`); `patch_package` no longer goes through `OLD_NAME_RE.sub` (`5C binder patch`: a plain replace would rename the key again); `check()` no longer calls `check_binder_protocol` (`5C binder check`) | `check-gradle.py` |

### Not read, not run

- **The real v13.6.0 sources.** The spelling `moe.shizuku.privileged.api.intent.extra.BINDER`, and that the four files of the table are the ones that spell it, are taken from the step 1 / 2 records (the nine old names per file were asserted against the real tree in step 2) and from how Shizuku's client library works; they were not re-read. If one file differs, the first run of the patch stops with its own message and the fix is one line of `PACKAGE_FILES` / `BINDER_EXTRA_KEPT`. A quick look before the first CI run: `grep -rn "intent.extra.BINDER" shizuku/upstream --include=*.java --include=*.kt` should show 4 files with one hit each (`ServiceStarter` may show the constant on one line and use it elsewhere).
- **Device behaviour.** That an outside client really connects (needs a second app with the stock provider and a running server) goes to the device list of "4G-2" (item 4) as a new check: *install a stock Shizuku client, start the built-in server, the client must report the binder.*
- **`ServerConstants.REQUEST_PERMISSION_ACTION`.** The file has exactly one use of the old name (recorded), so the action is built from `MANAGER_APPLICATION_ID` or defined elsewhere: not recorded; row 5D reads it.

### What was run

1. `python3 -I shizuku/tools/test-patch-host-package.py`: 60 of 60 (the 38 old cases and 22 new ones: the kept key has the right spelling and four files; the old-name test accepts the key alone and rejects the bare name, a longer key and the name next to the key; `patch_package` on a hand-made tree keeps the key and writes the host in 5 places in 5 files; it stops when a file lacks the key, has one old name more, or has the key where upstream had none; `check_binder_protocol` accepts a patched tree and fails on a key renamed to the host, a missing key, a lost host place, an old name outside the key, one host place too many and the key in a file that should not have it). All 22 passed at the first run, so two **throw-away mutations** (copies, not in the zip) checked that they can fail: with the patch renaming the key again 8 cases fail, with `check_binder_protocol` switched off 6 fail.
2. `python3 -I shizuku/tools/sweep-package-strings.py --self-test`: 37 of 37 (30 old, 7 new: 7 places in 7 files, the report counts the kept keys, key spelled with the host, key missing, key in a fifth file, old name next to the key, a longer key). Two slips of my first draft were fixed before: the report called a helper that did not exist, and the self-test tree builder did not write the files that only hold a kept key.
3. `python3 -I shizuku/tools/check-gradle.py --self-test`: 47 of 47 (44 old, 3 new: `BINDER_EXTRA_KEPT` loses `ServiceStarter`, `patch_package` renames the key, `check()` no longer calls the new rule). `check-gradle.py` on the real project: ok (also `--no-run`).
4. `python3 -I shizuku/tools/check-all.py`: S1 - S4 ok, S5 - S7 skipped, exit 0; `check-all.py --self-test` ok (64 checks); `test-check-merged-manifest.py --no-real` 122 cases ok; `python3 -I mika/tools/static-check.py`: all checks passed.
5. The patch script was **not** run on the real source (no network): the new counts and rule have only been tried on hand-made files.

### What this row leaves

- First CI run: S6 (`patch-upstream.py --check`) and `python3 shizuku/tools/sweep-package-strings.py -v --report sweep.txt` confirm the table of "Finding 15" on the real tree (7 host places in 7 files, 4 kept keys in 4 files).
- Device list of "4G-2": one new check (an outside Shizuku client gets the binder).
- Row 5D next (intent actions, same principle: names that outside clients know stay, names that only the server and the manager use follow the host), then 5E - 5G.

## 5D — intent actions (done; no change to the patch output, one new rule, one finding)

**Code: `shizuku/tools/patch-upstream.py` (new constants `ACTION_PERMISSION_SUFFIX`, `ACTION_AUTHORIZATION_SUFFIX`, `ACTION_BINDER`, `ACTION_BINDER_RECEIVED`, `MANIFEST_ACTIONS`, `BINDER_ACTION_FILES`, `ACTION_LITERAL_RE`, `ACTION_LITERALS_ALLOWED`; new functions `action_source_files()` and `check_intent_actions()`; one call in `check()`; docstring part D and the "D. self-check ok" line), `shizuku/tools/test-patch-host-package.py` (28 new cases: 60 -> 88), `shizuku/tools/check-gradle.py` (new item 12, 4 new self-test cases: 47 -> 51), docstring of `check-all.py` (51). Docs: this file, root `README.md`, `NOTICE-Shizuku.md` (one line), new `docs/CHANGES-shizuku-part5d.md`. Flat zip: `RizwanS2-main-shizuku-step5d.zip`.** Behind the `includeShizuku` switch (off by default); nothing built; no workflow, manifest, Gradle build logic, Kotlin / Java file or resource of the project changed, and the patch script writes exactly what it wrote before (the actions needed no edit).

### What was read, and how

This session had network, so, unlike 5A - 5C, the **real v13.6.0 sources** were fetched and read (`shizuku/tools/fetch-upstream.sh`, `patch-upstream.sh`; Mika 0.1.52 fetched and patched too, for the Mika grep and `check-provider-match.py`). Patch output on the real tree: part A "5 files (5 places), binder extra key kept in 4 files", 237 resource names, 87 files, 42 languages (all numbers as in 5C), self-check ok. Read: `ServerConstants`, `ShizukuService.showPermissionConfirmation`, `ShizukuShellLoader`, `ShellBinderRequestHandler`, `ShizukuReceiver`, `RequestPermissionActivity` (first 100 lines and every `intent` use), `LegacyIsNotSupportedActivity`, `ShellRequestHandlerActivity`, the patched manager manifest (actions block), `ShizukuProvider.handleSendBinder`, `AdbPairingService` (action constants), and a grep for `intent.action`, `IntentFilter`, `setAction`, `Intent("` and `ACTION_` in `manager`, `server`, `starter`, `shell` and `api/*`. Greps of the project outside `shizuku/upstream` and of the fetched Mika for `REQUEST_PERMISSION`, `REQUEST_AUTHORIZATION`, `REQUEST_BINDER` and `moe.shizuku.privileged`: no hits (Mika and the other modules talk to the server over the binder, never over these intents).

### The actions, one by one

| Action | Who sends | Who receives | Who else knows it | Verdict |
|--------|-----------|--------------|-------------------|---------|
| `<manager id>.intent.action.REQUEST_PERMISSION` | the **server** (`ShizukuService.showPermissionConfirmation`): `new Intent(ServerConstants.REQUEST_PERMISSION_ACTION).setPackage(MANAGER_APPLICATION_ID)` + extras `uid`, `pid`, `requestCode`, `applicationInfo`; `ServerConstants` builds it as `MANAGER_APPLICATION_ID + ".intent.action.REQUEST_PERMISSION"` | `RequestPermissionActivity` through the manifest filter `${applicationId}.intent.action.REQUEST_PERMISSION` (+ DEFAULT); exported, permission `INTERACT_ACROSS_USERS_FULL`; the activity never reads `intent.action`, only the four extras | nobody outside: a client app calls `requestPermission` **over the binder**, the server then sends the intent; the API library has no such string | **follows the host.** After part A `MANAGER_APPLICATION_ID` is the host and the merged `${applicationId}` is the host, so sender and receiver agree. Nothing to patch. (Answers the open question of 5C: the action is built from `MANAGER_APPLICATION_ID`.) |
| `<manager id>.intent.action.REQUEST_AUTHORIZATION` | **nobody**: not in the server, the API or the manager | `LegacyIsNotSupportedActivity` (manifest only), exported but protected by `moe.shizuku.manager.permission.API`, a permission nobody declares (4A) | pre-v13 clients used the old package in the name; they cannot start the activity (no one holds that permission) and the activity only says "legacy is not supported" | **follows `${applicationId}`**, nothing to patch; dead either way. |
| `rikka.shizuku.intent.action.REQUEST_BINDER` | the **shell loader** (`ShizukuShellLoader`, 2 literals): a broadcast with `.setPackage("<host>")` (part A), and on Android 8.0 / 8.1 a chooser fallback (finding 16) | `ShizukuReceiver` (broadcast) and `ShellRequestHandlerActivity` (fallback), both manifest filters; `ShellBinderRequestHandler.handleRequest` checks the same literal and reads the extra `data` / `binder` | a rikka name, shared with every Shizuku build and with `rish` | **stays** (5A list, item 3, same principle as the binder key). 4 literals in 3 files, checked. |
| `moe.shizuku.api.action.BINDER_RECEIVED` | the API `ShizukuProvider` itself (`handleSendBinder`, only with `enableMultiProcess`): `.setPackage(getContext().getPackageName())` = the host | the same class, registered with `RECEIVER_NOT_EXPORTED` (Android 13+) | `:mika` uses the same (now local, patched) provider class | **stays**, already host-scoped, library name. |
| `start` / `stop` / `reply` | `AdbPairingService` (notification buttons), `Intent(context, AdbPairingService::class.java).setAction(...)` | the same service | nobody | explicit component intents, no clash, nothing to decide. |
| `APPLICATION_PREFERENCES`, `BOOT_COMPLETED`, `LOCKED_BOOT_COMPLETED` | the system | `SettingsActivity`, `BootCompleteReceiver` | everybody | system actions (4D-1, 4D-3). |

**Why the two host-following names agree at run time.** `ServerConstants` holds the host package as a literal written at patch time; the manifest filter holds `${applicationId}`, filled in at merge time with the `applicationId` of `:app`. They are equal as long as the patch reads that same `applicationId` (it does: 5B-1 reads `app/build.gradle.kts`, a CI package rename runs before the patch, an `applicationIdSuffix` stops the script). 5D adds the check on the other side of the pair: the manifest must keep the placeholder (a literal package in an action name fails the rule), so a rename moves both.

**The one `[review]` line of the sweep.** `sweep-package-strings.py` on the real tree prints one review line: `AppConstants.PACKAGE = "moe.shizuku.manager"`. It is private and only builds `EXTRA = PACKAGE + ".extra"`, imported by `StarterActivity`, which uses it as the prefix of its three in-app intent extras `EXTRA_IS_ROOT`, `EXTRA_HOST` and `EXTRA_PORT` (the manager's own dialogs start it with them). It is not a package lookup and not an action. Decision: stays (it is the manager's namespace, like the 263 `namespace` lines). Expect that line in every run.

### Finding 16 (details are in the 4A findings table)

Android 8.0 / 8.1 only: the loader's activity fallback starts a chooser around `REQUEST_BINDER` **without** a package, and the host's exported `ShellRequestHandlerActivity` now listens to it. With a stock Shizuku installed too, the chooser shows two apps. Upstream behaves the same. Not patched (untestable path, behaviour of a chooser around an intent with a package unknown); **owner decision, default: leave**. If the owner wants it: one `.setPackage(<host>)` on the inner intent, one anchor and one self-check line, in the 5E patch session.

### The new rule: `check_intent_actions(root, man_xml, host, errors)`

Runs inside the patch self-check (S6 of `check-all.py`; patch run and `--check`). It takes the manifest text, so it is tested without a checkout.

| Rule | Fails when |
|------|-----------|
| server side | `ServerConstants.REQUEST_PERMISSION_ACTION` is not exactly `MANAGER_APPLICATION_ID + ".intent.action.REQUEST_PERMISSION"`; `ShizukuService` does not have exactly one `new Intent(ServerConstants.REQUEST_PERMISSION_ACTION).setPackage(MANAGER_APPLICATION_ID)`; the permission action is spelled as a literal anywhere in the two files |
| manifest table | a custom action is not in `MANIFEST_ACTIONS`; one of the three is not on exactly its components (`RequestPermissionActivity`; `LegacyIsNotSupportedActivity`; `ShellRequestHandlerActivity` + `ShizukuReceiver`); an action name holds the host or old package literally instead of `${applicationId}` (`android.*` system actions are ignored); the manifest is not well-formed |
| binder literal | `rikka.shizuku.intent.action.REQUEST_BINDER` is not spelled 2x / 1x / 1x in the loader, the handler and the receiver (`BINDER_ACTION_FILES`) |
| loader target | the loader does not have exactly one `new Intent("rikka.shizuku.intent.action.REQUEST_BINDER").setPackage("<host>")` |
| prefix | any Java / Kotlin file of server, starter, shell, manager or the API modules (not the API demo, not build folders) spells an action with the host or the old package in front |
| unknown literal | any string literal that looks like an action name (`...action...`) is not one of the three in `ACTION_LITERALS_ALLOWED` (the binder action, the provider broadcast, the permission tail) |

`check-gradle.py` item 12 keeps the rule from being weakened: the three custom actions stay in `MANIFEST_ACTIONS` (the host-following ones through `${applicationId}`), `BINDER_ACTION_FILES` keeps its three files, `ACTION_LITERALS_ALLOWED` exists, and `check()` calls `check_intent_actions`.

### What was run

1. `python3 -I shizuku/tools/test-patch-host-package.py`: **88 of 88** (60 old, 28 new: five table / constant cases, a good hand-made tree, the same tree with another host name, and 21 more (20 bad ones, each with the number of errors it must give, and one allowed system action): action not built from the host, host literal in the server and in the manifest, old package in a manifest action, a changed action tail, the request not aimed or aimed elsewhere, `REQUEST_AUTHORIZATION` missing and twice, `REQUEST_BINDER` on one component only, another custom action, a system action allowed, a manifest not well-formed, the binder literal missing and one too many, the loader without / with another target, a host-named receiver action, the provider broadcast renamed, a new action literal, an old-package action literal; the API demo file with an action literal is ignored). One case failed at the first run (my expectation of two errors was wrong: the old name alone is the 5C rule, here one error) and was corrected. Three **throw-away mutations** (copies, not in the zip) checked that the new cases can fail: with the rule body switched off 20 of the new cases fail, with the unknown-literal test off 6, with the manifest table not enforced 5.
2. `python3 -I shizuku/tools/check-gradle.py --self-test`: **51 of 51** (47 old + 4 new: `MANIFEST_ACTIONS` loses `REQUEST_AUTHORIZATION`, the permission action named without the placeholder, `BINDER_ACTION_FILES` loses the loader, `check()` no longer calls the rule); `check-gradle.py` on the project: ok.
3. **On the real source:** `patch-upstream.sh` (forced by the new script hash) and `patch-upstream.py --check`: self-check ok, numbers unchanged. `python3 -I shizuku/tools/check-all.py`: S1 - S6 **ok** (S5 `check-provider-match.py` and S6 `--check` on real inputs), S7 skipped (no Gradle build); `check-all.py --self-test` 64 checks; `test-check-merged-manifest.py --no-real` 122 cases (17 rules, unchanged); `sweep-package-strings.py --self-test` 37 and the real run (7 host places in 7 files, key 4 in 4 files, one review line); `python3 -I mika/tools/static-check.py` all checks passed. `grep -rn "intent.extra.BINDER" shizuku/upstream`: 4 hits in the 4 files of the 5C table (closes the "quick look" of 5C).

### What this row leaves

- **Row 5F** adds the merged-manifest rule for the actions (see the note in its row): it needs a build to run for real, and it changes the rule / case counts of `check-merged-manifest.py`, which 5F changes anyway.
- **Device list of "4G-2"** (item 4): a client app's permission request shows the built-in manager's dialog; the shell loader's broadcast reaches the built-in manager; Android 8.0 / 8.1 with a stock Shizuku installed shows a two-entry chooser (finding 16).
- **Owner decision:** finding 16 (default: leave).
- Next: **5E** (pairing-service timeout, finding 11), then 5F, 5G. (5E is done, see below.)


## 5E — pairing-service timeout (done; patch part F, one new rule, tried on hand-made files only)

**Code: `shizuku/tools/patch-upstream.py` (new constants `PAIRING_SERVICE`, `PAIRING_CLASS_RE`, `PAIRING_TIMEOUT_CODE`, `PAIRING_TIMEOUT_SIGS`; new `patch_pairing_service()`, `kotlin_block()` and `check_pairing_timeout()`; one call in `main()` after `patch_library_code`, one call in `check()`; docstring part F and the self-check line), `shizuku/tools/test-patch-host-package.py` (30 new cases), `shizuku/tools/check-gradle.py` (item 13, 5 new self-test cases), `shizuku/tools/check-all.py` (docstring: 56 cases for S2).** Nothing else of the project was touched except one comment in `app/build.gradle.kts` (it said "5E - 5G", now "5F - 5G"); no workflow, manifest, Gradle build logic, Kotlin / Java file or resource; `includeShizuku` is still off by default.

### Why

Finding 11 (4D-2): `AdbPairingService` is a `shortService` (about 3 minutes from `startForeground`), but it keeps the mDNS search open until pairing works or the user stops it. On Android 14+ the system calls `Service.onTimeout` at the limit and raises `RemoteServiceException` if the service does not stop. Upstream that closes the Shizuku app only; here the manager runs in the **main process** of the host, so the same crash would close the whole app (emulators, browser, downloads). The fix is a source patch, not a manifest change: the manifest side (`shortService`, not exported, only `FOREGROUND_SERVICE`) was right all along and stays checked by `4E-4a service`.

### What the patch does (part F)

| Step | Detail |
|------|--------|
| anchors (each one stops the script with a message if missing) | the file `manager/src/main/java/moe/shizuku/manager/adb/AdbPairingService.kt` exists; it has **no** `onTimeout` yet (a new upstream one must be reviewed first); it has an `override fun onDestroy(` (upstream stops the mDNS search there, and `stopSelf()` leads to it); exactly one `class AdbPairingService : Service() {` (the regex allows other spacing and an annotation on the same line) |
| edit | one insertion right after that class line: `override fun onTimeout(startId: Int)` and `override fun onTimeout(startId: Int, fgsType: Int)`, each `stopForeground(STOP_FOREGROUND_REMOVE)` then `stopSelf()`, with a short comment saying why |
| why both signatures | `onTimeout(int)` exists from API 34 (Android 14), `onTimeout(int, int)` from API 35 (Android 15). compileSdk is 37, so both can be overridden; on older systems they are simply never called (minSdk 26, and the service itself only runs on Android 11+) |
| why `stopForeground` first | the notification goes away; `stopSelf()` then ends the service and `onDestroy` stops the search, the same two calls upstream's own `handleResult` and the "stop" action end with |
| effect for the user | after about 3 minutes the "searching for the pairing port" notification disappears; the user opens the tutorial again (nothing is lost, pairing has to start over). No crash. |
| what is not changed | the notification texts, the pairing flow, the sticky behaviour (`START_REDELIVER_INTENT`, harmless for short services), the manifest |

### The self-check rule (`check_pairing_timeout`, also run by `patch-upstream.py --check`, S6 of `check-all.py`)

| Rule | Fails when |
|------|-----------|
| file / class | the file is missing, or there is not exactly one `class AdbPairingService : Service() {` |
| count | the number of `fun onTimeout(` (also as an extension function) is not 2; `//` comments are ignored |
| each signature | `override fun onTimeout(startId: Int)` or `override fun onTimeout(startId: Int, fgsType: Int)` is not there exactly once, or it sits before the class line |
| body | the body (found by brace matching) does not call `stopForeground(STOP_FOREGROUND_REMOVE)` once and `stopSelf()` once (calls inside comments do not count), or calls `stopSelf()` first |
| cleanup | `onDestroy` is gone (the search would never stop) |

`check-gradle.py` item 13 keeps the rule from being weakened: `PAIRING_SERVICE` names the right file, `PAIRING_TIMEOUT_SIGS` holds both signatures, `PAIRING_TIMEOUT_CODE` calls both functions in each override, `main()` calls `patch_pairing_service(root)` after `patch_library_code(root, host)` and `check()` calls `check_pairing_timeout(root, errors)`.

### What was run

1. `python3 -I shizuku/tools/test-patch-host-package.py`: **118 of 118** (88 old, 30 new: constants and inserted-code checks, a good patch on a hand-made file and what it changes, patching twice, the five anchors that must stop the script, odd class-line spacing and an annotation on the class line, and the check on 17 broken copies: one override missing (each), stop call missing (each), wrong order, `stopSelf` twice, calls only in comments, a third `onTimeout` as an extension function, `onDestroy` gone, another class line, overrides before the class, a missing file, the brace matcher). Four **throw-away mutations** (copies, not in the zip) checked that the new cases can fail: patch inserts nothing -> 12 cases fail; order test switched off -> 1; inside-class test switched off -> 1; `onDestroy` anchor switched off -> 1.
2. `python3 -I shizuku/tools/check-gradle.py --self-test`: **56 of 56** (51 old + 5 new: wrong file, one signature gone, `stopSelf` gone in one override, `main()` without the call, `check()` without the rule); `check-gradle.py` on the project: ok.
3. `python3 -I shizuku/tools/check-all.py --no-real`: S1 - S4 ok, S5 - S7 skipped; `check-all.py --self-test` 64 checks; `test-check-merged-manifest.py --no-real` 122 cases (17 rules, unchanged); `sweep-package-strings.py --self-test` 37; `check-provider-match.py --self-test` 12; `python3 -I mika/tools/static-check.py` all checks passed.
4. The patch script was **not** run on the real source (no network in this session: GitHub and the Gradle repositories were not reachable, and `shizuku/upstream/` is not in the zip). The anchors rest on the real read of 4D-2 (v13.6.0, 330 lines). Whether `stopForeground(STOP_FOREGROUND_REMOVE)` / `stopSelf()` compile in that Kotlin file (they are the calls the file already makes in `handleResult`) is for the first `patch-upstream.sh` run and the first CI build.

### What this row leaves

- **First CI run / next session with network:** `patch-upstream.sh` + `--check` on the real tree (part F prints one `F. pairing service` line; the numbers of parts A - E must not move: 5 places in 5 files, 4 kept keys, 237 names, 87 files, 42 languages); `grep -n onTimeout shizuku/upstream/manager/src/main/java/moe/shizuku/manager/adb/AdbPairingService.kt` must show exactly the two overrides.
- **Device list of "4G-2"** (item 4): the 3-minute case, see above.
- **Finding 16** is still the owner's decision (default: leave).
- Next: **5F** (direct-boot patch, finding 12), then 5G.

## 5F — direct boot and custom actions (done; patch part G, two new checker rules, tried on hand-made files only)

### Why

Finding 12 (found in 4D-3, decided in 4D-4 as option (a+)): upstream's `BootCompleteReceiver`, `ShizukuReceiver` and `ShizukuManagerProvider` are `android:directBootAware`, and `BootCompleteReceiver` also listens to `LOCKED_BOOT_COMPLETED`. In the host that makes Android start the **main process before the first unlock**, where `App.attachBaseContext` / `App.onCreate` run on locked, credential-protected storage (`AppLog`, `ThemeManager.syncHost`, Seal, Mika). Before `:shizuku` no component of `:app` or Mika was `directBootAware`. Option (a+) strips the flag from all three components and the `LOCKED_BOOT_COMPLETED` action from the receiver; the cost is that Shizuku's boot start runs after the first unlock instead of before it (the manager UI is not usable earlier anyway).

### What the patch does (part G of `shizuku/tools/patch-upstream.py`, `patch_direct_boot()`, called right after `patch_manifest`)

- reads the manifest that `patch_manifest` has just written (part B), so the XML declaration and the header comment are kept; one sentence about 5F is added inside the comment;
- asserts its anchors (each one stops the script with a message): the header comment of part B is there; each of `.receiver.BootCompleteReceiver`, `.receiver.ShizukuReceiver` and `.ShizukuManagerProvider` exists exactly once and carries `directBootAware="true"` (any capitalisation); **no other element** carries it (an upstream change must be reviewed, then added to `DIRECT_BOOT_COMPONENTS`); `BootCompleteReceiver` has exactly one `LOCKED_BOOT_COMPLETED` action and, after the change, exactly one `BOOT_COMPLETED` action;
- removes the attribute from the three components; removes the `LOCKED_BOOT_COMPLETED` filter of the receiver (when the action shares its filter with others, only the action goes, and the filter stays);
- everything else (exported, permission, authority, `multiprocess`, the `REQUEST_BINDER` actions) is untouched: the self-test compares the file with the version before part G and the only differences are the three attributes, the LOCKED filter and the header sentence.

User effect: the host never starts its process in direct boot because of Shizuku, as before `:shizuku`. `ShizukuReceiver` and the provider are only used after the server is up, so nothing real is lost (not verified, see below).

### The self-check rule (`check_direct_boot`, also run by `patch-upstream.py --check`, S6 of `check-all.py`)

| Rule | Fails when |
|------|-----------|
| flag | any element of the generated manifest is `android:directBootAware` with a value other than `false` (the message names the element) |
| action | a `LOCKED_BOOT_COMPLETED` action is left anywhere |
| boot receiver | there is not exactly one `<receiver .receiver.BootCompleteReceiver>`, or it has not exactly one `BOOT_COMPLETED` action |

`check-gradle.py` item 14 keeps the work from being weakened: `DIRECT_BOOT_COMPONENTS` holds the five names (three in 5F, two more after 5G), `main()` calls `patch_direct_boot(root)` right after `patch_manifest(root)`, `check()` calls `check_direct_boot(man, errors)`, and the merged-manifest checker registers both rules of 5F.

### The two new rules of the merged-manifest checker (`shizuku/tools/check-merged-manifest.py`)

They were held back in 4E-4a / 5D because they would have failed on every real manifest before the patch existed. Now the patch exists, both are added in one go, so the counts change once.

| Rule | Fails when |
|------|-----------|
| `5F direct boot` | a component of `moe.shizuku.manager` is `directBootAware` (a value other than `false`), or listens to `LOCKED_BOOT_COMPLETED`. Only the manager is judged: `:app` and Mika never had the flag, and other libraries may set it on their own components. |
| `5F custom actions` | `<package>.intent.action.REQUEST_PERMISSION` is not on `authorization.RequestPermissionActivity` alone, `<package>.intent.action.REQUEST_AUTHORIZATION` not on `legacy.LegacyIsNotSupportedActivity` alone, `rikka.shizuku.intent.action.REQUEST_BINDER` not on exactly `legacy.ShellRequestHandlerActivity` and `receiver.ShizukuReceiver` (all components of the merged manifest are looked at, each action once per component), or a component of the manager carries any other custom (non-`android.*`) action. Without a `package` attribute any prefix is accepted for the first two. |

The checker now has **19 rules** (14 of 4E-2 ... 4E-4a, 3 of 4E-4b, 2 of 5F); its last output line no longer says "later: row 5F adds the direct-boot rule".

### Changes in the self-test (`test-check-merged-manifest.py`)

- the hand-made **good manifest** now matches the real result of the patch: `BootCompleteReceiver` has only `BOOT_COMPLETED` (it used to have `LOCKED_BOOT_COMPLETED` too, as upstream does), and `ShizukuReceiver` carries `rikka.shizuku.intent.action.REQUEST_BINDER` (it used to carry a made-up `<package>.intent.action.NOTIFY`, which the new action rule rightly refuses);
- three old cases changed on purpose: `4a-07` (a missing `ShizukuReceiver` now also fires the action rule, it carried `REQUEST_BINDER`), `4a-18` (the extra filter uses a system action, so the case stays about `exported`) and `4a-34` (a receiver left with `LOCKED_BOOT_COMPLETED` only now also fires the direct-boot rule);
- **25 new cases `5f-01` ... `5f-25`**: the good manifest; the flag on each of the three components, on all three, `false` written, capital `TRUE`, on another manager component; a second LOCKED filter, LOCKED sharing the filter with `BOOT_COMPLETED`, a manager service that listens; `:app`'s own components not judged; Shizuku not built in (no rule runs); each of the three actions missing, doubled, moved, on a component of `:app`, with the old package, with a renamed package; an unknown custom action on a manager component; no package attribute; two faults at once (exactly the two rules fire);
- the group list of the self-test prints a `5F` line; the check of the command line now requires that the last output line points to the self-test and no longer promises row 5F.

### What was run

1. `python3 -I shizuku/tools/test-patch-host-package.py`: **162 of 162** (118 old, 44 new: constants and wiring, a good patch on a hand-made upstream-like manifest run through `patch_manifest` and then `patch_direct_boot` (what it changes and nothing else), patching twice, the anchors that must stop the script (no file, part B not run, each of the three flags missing, another component flagged, a component declared twice, no / two LOCKED actions, `BOOT_COMPLETED` missing / twice), a LOCKED action that shares its filter, and `check_direct_boot` on 13 small manifests). Three **throw-away mutations** (copies, not in the zip) checked that the new cases can fail: the flag is not removed (4 cases fail), the LOCKED filter is not removed (1 case), `check_direct_boot` ignores the flag (4 cases).
2. `python3 -I shizuku/tools/check-gradle.py --self-test`: **61 of 61** (56 old + 5 new: a component gone from `DIRECT_BOOT_COMPONENTS`, `main()` without the call, `check()` without the rule, each of the two merged rules unregistered); `check-gradle.py` on the project: ok (15 `.kts` files, 11 unique namespaces, 7 helper runs).
3. `python3 -I shizuku/tools/test-check-merged-manifest.py --no-real`: **147 cases** (122 + 25), coverage: switching off any of the **19 rules** breaks a case; registry 6, constants 1, helpers 23, command line 21 checks.
4. `python3 -I shizuku/tools/check-all.py --no-real`: S1 - S4 ok, S5 - S7 skipped; `check-all.py --self-test` 64 checks; `sweep-package-strings.py --self-test` 37; `check-provider-match.py --self-test` 12; `python3 -I mika/tools/static-check.py` all checks passed; `py_compile` of every script of `shizuku/tools`.
5. **Not run:** the patch on the real source (**no network in this session**, `shizuku/upstream/` is not in the zip: the anchors come from the real manifest read of 4A / 4D-3, and the script stops loudly if one is wrong), any Gradle build (S7, the merged manifest), any device. Part G rewrites the manifest with `ElementTree` a second time (part B already does); the attribute order and the indentation of that file are the ones of part B's output, and the self-test checks the diff on a hand-made file only.

### What this row leaves

- **First CI run / next session with network:** `patch-upstream.sh` + `--check` on the real tree: part G prints one `G. direct boot` line; `sed -n '/<manifest/,$p' shizuku/upstream/manager/src/main/AndroidManifest.xml | grep -c -e directBootAware -e LOCKED_BOOT_COMPLETED` must print 0 (the header comment names both words on purpose, so the body after `<manifest` is searched); the numbers of parts A - E must not move; then `check-all.py --require-real` runs the two new merged rules (S7) on the real merged manifest.
- **Device list of "4G-2"** (item 4): with a screen lock, reboot and look at the log folder before and after the first unlock: the host's process must not start before it (finding 12), and Shizuku's boot start must run after it.
- **Decision kept (4D-4, option a+):** `ShizukuReceiver` and the provider lose the flag although only `BootCompleteReceiver` was strictly needed to stop the early start; the reason is in finding 12 (a root-started server or an app asking through the receiver could start the process too). To go back to option (a) the owner removes the two entries from `DIRECT_BOOT_COMPONENTS` in `patch-upstream.py` and relaxes `rule_direct_boot` / the cases `5f-03`, `5f-04`, `5f-05` of the self-test in the same step.
- **Correction in 5G:** the first run on the real tree showed two more `directBootAware` activities (`RequestPermissionActivity`, `ShellRequestHandlerActivity`); `DIRECT_BOOT_COMPONENTS` now has five names and the tests / `check-gradle.py` follow. See "5G".
- Next: **5G** (night-mode patch, finding 14), then steps 6 - 10. (5G is done, see below.)

## 5G — night mode per activity (done; patch part H, checked on the real v13.6.0 tree)

### Why
Finding 14: upstream sets AppCompat's process-wide default night mode in `ShizukuApplication.onCreate` and in the Settings screen. In the host that static is shared with every AppCompat screen of `:app`, so one tap on "Dark" in Shizuku's Settings would force the whole host dark, again at every start. `:app` itself never calls the setter (grep over the host modules), so after 5G nothing but Shizuku's own screens read Shizuku's setting.

### First run on the real source (new in this session)
GitHub was reachable, so `fetch-upstream.sh` + `patch-upstream.py` ran on the real tree for the first time (steps 2 - 5F had only run on hand-made files). Results:
- **5F was wrong for two components.** `RequestPermissionActivity` and `ShellRequestHandlerActivity` are `directBootAware` too; the patch stopped on its own "no other component" anchor, as designed. Fixed: `DIRECT_BOOT_COMPONENTS` has five names (the patch, the test manifest, the 5F test cases, `check-gradle.py` item 14 and its self-test case follow). The merged-manifest rule `5F direct boot` already covered every component, so it did not change (19 rules, 147 cases).
- The `api/` folder is patched too (it is a nested checkout); a manual reset has to reset it as well (`git -C api checkout -f -- . && git -C api clean -fd`), otherwise the next run stops on the binder-key anchor. A failed run that leaves `api/` patched but the root clean cannot happen with the script itself.

### What part H does (`patch_night_mode`)
1. `ShizukuApplication.kt` (part B's template `APPLICATION_KT`): no `AppCompatDelegate` import, no setter call; a comment says where the mode is applied now. Part H asserts it.
2. `SettingsFragment.kt`: the one line `AppCompatDelegate.setDefaultNightMode(value)` is replaced by a comment. `activity?.recreate()` stays. Order checked in the RikkaX source: `IntegerSimpleMenuPreference` calls the change listener, then `setValue` -> `persistInt`, all on the main thread; the relaunch that `recreate()` asks for arrives later, so the new instance reads the new value.
3. `AppActivity.kt` (base class of all nine activities; `MainActivity` is Java upstream): imports `Context`, `Log`, `ShizukuSettings` and an override
   `attachBaseContext(newBase: Context)` that sets `delegate.localNightMode = ShizukuSettings.getNightMode()` inside `try { } catch (e: Throwable)` and then calls `super.attachBaseContext(newBase)`.
   **Why `attachBaseContext` and not `onCreate` (a change from the plan's wording):** in AppCompat's source (`AppCompatDelegateImpl`, androidx-main; the exact release of the build is not checked) `setLocalNightMode` only stores the value while the base context is not attached, and `attachBaseContext2` then wraps the context with it (the first frame is right). After the attach, with the activity created, it calls `recreate()` when the effective mode differs. RikkaX's `ThemedAppCompatActivity.attachBaseContext` calls `super` (`AppCompatActivity`), so an override in the subclass `AppActivity` that runs first is early enough. The try / catch keeps a screen alive when `ShizukuSettings` is not initialised (then it follows the system).
   Anchors (each stops the script): the class line `abstract class AppActivity : MaterialActivity() {`, the three import anchors, no `attachBaseContext` in `AppActivity` yet, exactly one setter line and an `activity?.recreate()` in `SettingsFragment`, no `AppCompatDelegate` in `ShizukuApplication.kt`.

### Self-check (`check_night_mode`, called from `check()`)
No source of `manager/src/main/java` calls the setter (comments do not count); `AppActivity` has exactly one `attachBaseContext(newBase: Context)` in the class, with the call and `super.attachBaseContext(newBase)` once each, the call first and inside `try` / `catch (e: Throwable)`, and the three imports; `SettingsFragment`'s night-mode listener still calls `activity?.recreate()`; `ShizukuApplication.kt` has no `AppCompatDelegate`; every `<activity>` of the manifest reaches `AppActivity` through its superclasses (Kotlin `class A : B(` and Java `class A extends B`, cycles do not loop). `check-gradle.py` item 15 keeps the constants, the inserted code and the two calls from being weakened.

### Tests and numbers
- `test-patch-host-package.py`: **224 cases** (162 before; 4 more for the five-component 5F change, 58 for 5G: good patch, nothing else changed, every anchor, twice, mutations of the self-check, the activity chain). Throw-away mutations of the patch (setter line kept, call after `super`, comments not stripped, chain check off, import kept in the template) each break cases.
- `check-gradle.py --self-test`: **66 cases** (61 + 5 new).
- Real tree: patch parts A - H, `--check` and a second forced patch pass; after the patch the manifest body has 0 `directBootAware` / `LOCKED_BOOT_COMPLETED`, the manager sources have 0 setter calls. `check-all.py`: S1, S2, S3, S4, S6 ok (S6 now runs on the real tree), S5 and S7 skipped (no input / no build).

### Not done / still open
- **Never built.** No Gradle build, no merged manifest (S7), no device: the night-mode order (`attachBaseContext` before the theme, no extra recreate, "Follow system" after "Dark", the host's own screens unaffected after a tap on "Dark" in Shizuku) is read from source only. Add it to the device list of "4G-2".
- `localNightMode` is set per activity, so dialogs and popups made from an activity context follow it; a service or a `Toast` does not use a night mode anyway.
- Next: **6A** (`ShizukuLauncher.kt`), then 6B - 6E, step 7, step 8 (switch stays off until 8D passes and 6E is in), 9, 10.


## Steps 5 - 8, sub-steps (5A, 5B-1, 5B-2, 5C, 5D, 5E, 5F and 5G done, the rest planned)

Same rule as step 3 and step 4: each row ends zip-ready and flips its own status. Steps 9 and 10 are cut in two each (table after step 8). Nothing here turns `includeShizuku` on by default before 8F.

### Step 5 — Host-package hand-over check (static, no Gradle run)

| # | Sub-step | What it covers | Status |
|---|----------|----------------|--------|
| 5A | Source sweep | Grep the patched manager, server, starter, shell and `ShizukuProvider` for every `moe.shizuku.privileged.api` / `moe.shizuku.manager` string that must now be the host package; list what stays on purpose (permission names, namespace). **Note from step 4 (4G-2):** stays on purpose: the permission names `moe.shizuku.manager.permission.*`, the namespace `moe.shizuku.manager`, the action `rikka.shizuku.intent.action.REQUEST_BINDER`, and the never-declared `moe.shizuku.manager.permission.API` on `LegacyIsNotSupportedActivity`; finding 10 (`HomeViewModel.kt`) is verified here. Details fixed in 5A: the grep is a script, `shizuku/tools/sweep-package-strings.py` (30 self-test cases), because the patched source is not in the zip and there was no network; it sorts every `moe.shizuku.manager` use into namespace / class-name / permission / review, requires the old name only in `manager/build.gradle` and the host package in exactly the 11 places (9 files) that patch part A writes; finding 10 verified (two files, `HomeViewModel.kt` and `AuthorizationManager.kt`). The list on the real tree comes with the first CI run. **Changed in 5C:** the binder extra key stays (finding 15), so the expected host-package places are 5 + 2 = 7 in 7 files and the old name is allowed in four files as that key; the sweep and its self-test (37 cases) follow. | **done** (tool; see "5A" below; adapted in 5C) |
| 5B-1 | `pm path` | The server and `starter.cpp` find the manager APK with `pm path <host>`; check the host package is the one passed in, not a literal. Details fixed in 5B-1: the only recorded `pm path` place is `PACKAGE_NAME` in `manager/src/main/jni/starter.cpp` (patch part A, 1 place); the host name comes from `applicationId` of `app/build.gradle.kts` (after the CI rename), is validated as a plain package name (it is written unquoted into a shell command and into literals), and an `applicationIdSuffix` in `app/build.gradle.kts` stops the patch script (a suffix would make the lookup find nothing in that build type); new self-check rule: `starter.cpp` has exactly one `#define PACKAGE_NAME "<host>"` and the old name nowhere; hand-made cases in `shizuku/tools/test-patch-host-package.py` (32). Not read: the real `starter.cpp` and the server sources (no network in the session), so whether the server itself also runs `pm path` is left to the first run of S6 and to 5C. | **done** (see "5B-1" below) |
| 5B-2 | Native libs | `libshizuku.so` and `starter` load from the host's native lib dir; check `extractNativeLibs` / packaging of the host does not stop the starter from finding them. Details fixed in 5B-2: `libshizuku.so` is run from `nativeLibraryDir` (it must be extracted), `:app` already extracts (`useLegacyPackaging = true` + `android:extractNativeLibs="true"`) and a new rule group (item 10 of `check-gradle.py`, 11 self-test cases) keeps it so; the library manifest may not carry `extractNativeLibs` (the patch script drops it, new self-check rule); `shizukuAbis` must cover every ABI the APK ships; no other module ships a library of these names. Not read: the real `CMakeLists.txt` / `Starter.kt`; APK contents are row 8D-1. | **done** (see "5B-2" below) |
| 5C | Binder extras | `BinderSender`, `ShizukuReceiver`, `ShizukuProvider.sendBinder` extras and the `MANAGER` permission check target the host. Details fixed in 5C: `BinderSender` and `ShizukuReceiver` hold no old package name (neither is in `PACKAGE_FILES`; the real runs of steps 2 - 4 had no old name left), so there is nothing to patch in them; the server finds the manager by `MANAGER_APPLICATION_ID` (host after part A) and hands the binder to the manager's provider (authority `${applicationId}.shizuku`); the `MANAGER` / `API_V23` names stay and the host asks for `MANAGER` once (4C-3, 4E-3 rules, nothing new). **Finding 15:** the binder extra key is not a package name and must stay as upstream has it (outside clients read it); part A now keeps it in four files (`BINDER_EXTRA_KEPT`) and writes the host package in 5 places in 5 files; new self-check rule `check_binder_protocol()`; sweep adapted (37 cases); `check-gradle.py` item 11 (47 cases); 22 new cases in `test-patch-host-package.py` (60). Not read: the real v13.6.0 files (no network): the key spelling and the four files come from the records of steps 1 - 2, the first CI run confirms. | **done** (see "5C" below) |
| 5D | Intent actions | `${applicationId}.intent.action.REQUEST_PERMISSION` / `REQUEST_AUTHORIZATION` and the legacy `rikka.shizuku.intent.action.REQUEST_BINDER`: who sends, who receives, with the host package. **Note from 5C:** the same principle as for the binder key: an action name that outside clients or other apps use stays as upstream has it (`rikka.shizuku.intent.action.REQUEST_BINDER`); an action that only the server and the built-in manager use follows the host (`${applicationId}.intent.action.REQUEST_PERMISSION` / `REQUEST_AUTHORIZATION` in the manifest; `ServerConstants` has exactly one use of the old name in total, so the server-side action is built from `MANAGER_APPLICATION_ID` or lives elsewhere: not recorded, 5D reads it). Details fixed in 5D: read on the **real** v13.6.0 tree (fetch + patch ran, network was available): the server builds `ServerConstants.REQUEST_PERMISSION_ACTION` from `MANAGER_APPLICATION_ID` (host after part A) and aims it at that package, the manifest filter of `RequestPermissionActivity` is `${applicationId}.intent.action.REQUEST_PERMISSION` (host after the merge), so sender and receiver agree and nothing needs patching; `REQUEST_AUTHORIZATION` has no sender at all (manifest only, on the permission-protected legacy activity) and follows `${applicationId}`; `rikka.shizuku.intent.action.REQUEST_BINDER` (shell loader -> `ShizukuReceiver` / `ShellRequestHandlerActivity`) and the API provider's own `moe.shizuku.api.action.BINDER_RECEIVED` are library names and stay. Result: **no change to what the patch writes**; one new self-check rule `check_intent_actions()` (S6), `check-gradle.py` item 12 (4 new self-test cases: 47 -> 51), 28 new cases in `test-patch-host-package.py` (60 -> 88); one finding (16, Android 8.0 / 8.1 fallback chooser, low, owner decides); the merged-manifest rule for the actions waits for row 5F (one change of the rule and case counts). | **done** (see "5D" below) |
| 5E | Pairing-service timeout | Finding 11: in `tools/patch-upstream.py` add a patch step for `adb/AdbPairingService.kt` (override `onTimeout(startId)` and `onTimeout(startId, fgsType)` to stop the foreground state and the service) and one self-check rule that the override is present; counts of the other rules stay. Needs the fetched source to test (GitHub reachable). Details fixed in 5E: new part F of the patch script, `patch_pairing_service()` (called after `patch_library_code`): it asserts its anchors (the file exists; no `onTimeout` in it yet; an `onDestroy` exists, because `stopSelf()` relies on it to stop the mDNS search; exactly one `class AdbPairingService : Service() {`) and inserts the two overrides, each `stopForeground(STOP_FOREGROUND_REMOVE)` then `stopSelf()`, right after the class line (member order does not matter in Kotlin, so no anchor on the end of the file is needed); new self-check rule `check_pairing_timeout()` (exactly two `fun onTimeout`, each signature once and inside the class, each body calls `stopForeground(STOP_FOREGROUND_REMOVE)` once and then `stopSelf()` once, comments do not count, `onDestroy` still there); new constants `PAIRING_SERVICE`, `PAIRING_CLASS_RE`, `PAIRING_TIMEOUT_CODE`, `PAIRING_TIMEOUT_SIGS`; `check-gradle.py` item 13 (5 rules, 5 new self-test cases, 51 -> 56) keeps the patch and the rule from being dropped; 30 new hand-made cases in `test-patch-host-package.py` (88 -> 118). Finding 16 was **not** added to this patch (default: leave). **Not run on the real source: no network in this session**; the anchors come from the 4D-2 read of the real file (330 lines, `@TargetApi(R) class AdbPairingService : Service()`, `onDestroy` stops the search, no `onTimeout` in upstream) and the patch stops loudly if one is not there. | **done** (see "5E" below; patch + self-check written and tried on hand-made files only; the first CI run / `patch-upstream.sh` on the real tree confirms it) |
| 5F | Direct-boot patch | Finding 12, option (a+): in `tools/patch-upstream.py` remove `android:directBootAware` from `BootCompleteReceiver`, `ShizukuReceiver`, `ShizukuManagerProvider` (and, found in 5G, `RequestPermissionActivity`, `ShellRequestHandlerActivity`), and the `LOCKED_BOOT_COMPLETED` intent filter of `BootCompleteReceiver` (it keeps `BOOT_COMPLETED`); one self-check rule; then the matching rule in `check-gradle.py` / the merged-manifest checker. Needs the fetched source to test. **Note from step 4 (4G-2):** the direct-boot rule of the merged-manifest checker is added here, not in 4E-4a, together with its bad case in `test-check-merged-manifest.py` (the coverage check fails without one) and the new rule / case counts wherever they are quoted (17 rules, 122 cases today). **Note from 5D:** the rule for the custom actions of the merged manifest (after the merge `${applicationId}` is the real package: `<applicationId>.intent.action.REQUEST_PERMISSION` only on `RequestPermissionActivity`, `<applicationId>.intent.action.REQUEST_AUTHORIZATION` only on `LegacyIsNotSupportedActivity`, `rikka.shizuku.intent.action.REQUEST_BINDER` only on `ShizukuReceiver` and `ShellRequestHandlerActivity`, no other custom action from `moe.shizuku.manager`) is added here too, so the rule and case counts of `check-merged-manifest.py` / `test-check-merged-manifest.py` change once, not twice. | **done** (see "5F" above; patch part G, `check_direct_boot`, two merged rules, 19 rules / 147 cases, `check-gradle.py` item 14; flat zip `RizwanS2-main-shizuku-step5f.zip`) |
| 5G | Night-mode patch | Finding 14: in `tools/patch-upstream.py` drop `AppCompatDelegate.setDefaultNightMode(...)` from the generated `ShizukuApplication.onCreate` and from `SettingsFragment`, add `delegate.localNightMode = ShizukuSettings.getNightMode()` to `AppActivity` (before the theme is applied), one self-check rule (no `setDefaultNightMode` left in the manager sources). Needs the fetched source to test. | **done** (see "5G" below; patch part H, `check_night_mode`, `check-gradle.py` item 15; `attachBaseContext` instead of the plan's "before the theme is applied"). |

### Step 6 — Hooks

| # | Sub-step | What it covers | Status |
|---|----------|----------------|--------|
| 6A | `ShizukuLauncher.kt` | Small launcher object in `:app` that starts `moe.shizuku.manager.MainActivity` (task / flags decided from finding 9), with a safe no-op when `:shizuku` is not in the build. **Process / task note from 4D-4 (finding 9):** the manager's activities have no `taskAffinity`, no `launchMode` and no `android:process` (checked in the real v13.6.0 manifest), so they run in the main process and join the task of the activity that starts them; Mika has its own `taskAffinity="${applicationId}.rizwan"`. Proposal for 6A (not tested): a plain `startActivity` from the Start menu's activity, without `FLAG_ACTIVITY_NEW_TASK`, so Back returns to the Win11 screen; `MainActivity` is not exported, so only the app can start it. | **done** (see "6A" below; `app/src/main/kotlin/com/srizwan/win11/ShizukuLauncher.kt`, reflection, no compile-time Shizuku class) |
| 6B-1 | List and numbered links | Read how the "All apps" list is built and how `rizwans2://N` maps to a position. Write down whether a new item changes existing numbers (docs only). | **done** (docs only, see "6B-1" below: a new item moves the numbers of every app after "Shizuku" in the A - Z list by +1; no code change) |
| 6B-2 | Add the item | "Shizuku" item in the list, placed so existing numbers do not move (or the change is documented); shown only when `:shizuku` is in the build. | **done** (see "6B-2" below: `builtInApps()` entry guarded by `ShizukuLauncher.isAvailable(ctx)`, one taskbar branch in `MainActivity`; normal A - Z place, numbers after it move +1 only where shown; `TerminalShare` line left for 6D) |
| 6C | Home icon | Home screen icon and label, drawable only (no new permission). | **done** (see "6C" below: `VectorIconView.SHIZUKU` + one `desktopIcon` line guarded by `isAvailable`) |
| 6D | Deep link `rizwans2://shizuku` | Manifest filter and routing next to the existing `rizwans2://` handling; no clash with the numeric form. | **done** (see "6D" below: one routing branch, the existing scheme filter already matches, `TerminalShare` line added) |
| 6E | `AppBase` call + guard | The one call in `AppBase`, guarded by the Shizuku switch (`BuildConfig` flag set from `shizukuIncluded`); docs and zip. **Placement from 4D-3 (finding 13):** the call is `ShizukuApplication.onCreate(this)`, early in the launcher-process part of `App.onCreate` (the boot receiver runs in that process and needs `ShizukuSettings` and `application` set); **Spot fixed in 4D-4:** inside `try { ... } catch (e: Throwable)`, in the launcher-process part of `App.onCreate`, right after the `AppLog.i("App", "process start ...")` line and before the Seal block (Mika's `startMikaIfUsed()` stays last). | **done** (see "6E" below: `ShizukuLauncher.initApplication(app)` (reflection, guard = class present) called from `App.onCreate` at the fixed spot; **not** in `AppBase`, because the "without Rizwan" stub replaces that file) |

### Step 7 — `:mika` hook-up

| # | Sub-step | What it covers | Status |
|---|----------|----------------|--------|
| 7A-1.1 | `<queries>` entry: patch | Finding 7, manifest side, Mika's patch script only: with the manager built in, Mika's `<package moe.shizuku.privileged.api>` becomes `<package ${applicationId}>` (the host package); without the manager the stock name is written. The switch is the environment variable `MIKA_SHIZUKU_BUILTIN` (the Gradle task `:mika:patchMikaUpstream` sets it from the project test `:shizuku`), and it is part of the script's stamp. `mika/tools/check-manifest.py` gets check 13 (the entry matches the switch). | **done** (see "7A-1.1" below) |
| 7A-1.2 | `<queries>` entry: checker | **From 4E-4b:** set `STALE_QUERY_ALLOWED = 0` in `shizuku/tools/check-merged-manifest.py`, so the checker fails if the entry is still there (case 23 of 4E-4b tests exactly that). **Note from step 4 (4G-2):** `EXPECTED_STALE_QUERY_ALLOWED = 0` in `shizuku/tools/test-check-merged-manifest.py` in the same step (only its constants guard fails otherwise, on purpose; cases 4b-23 / 4b-24 test the flipped value); rerun `check-all.py`; README, CHANGES, zip. | **done** (see "7A-1.2" below) |
| 7A-2.1 | `SHIZUKU_PACKAGE`: patch | Finding 7, Kotlin side, Mika's patch script only (part 16): with the manager built in (`MIKA_SHIZUKU_BUILTIN=1`), `ShizukuController.kt` asks the package manager for `app.packageName` (twice) and `openShizukuApp()` starts `moe.shizuku.manager.MainActivity` in the host package; the const `SHIZUKU_PACKAGE` becomes `SHIZUKU_MANAGER_ACTIVITY`, so no `moe.shizuku.privileged.api` is left in Mika's Kotlin. Without the manager the stock text is written back. Two-way, idempotent, strict anchors, own self-check in the script. | **done** (see "7A-2.1" below) |
| 7A-2.2 | `SHIZUKU_PACKAGE`: read-only check | The same rule as a read-only check outside the patch: `mika/tools/check-manifest.py` check 14 reads `ShizukuController.kt` of the patched checkout and compares it with the text pairs of part 16 (switch 1 = built-in spelling, 0 = stock, unset = either, never a mixture; with 1 no `moe.shizuku.privileged.api` and no `SHIZUKU_PACKAGE` word may be left, comments included). Never calls the patch, never writes. | **done** (see "7A-2.2" below) |
| 7B | One provider | Confirm after 4B that Mika's `ShizukuProvider` is gone and Mika's code only needs the class. **Note from step 4 (4G-2):** already established in 4B-3 on the real files; 7B re-confirms it. Done in 7B on the real fetched + patched sources (no build possible): the provider-match check ran on them (S5 ok), Mika's sources do not mention `ShizukuProvider` at all, and `check-provider-match.py` got two rules: 7 (no attribute of Mika's provider is lost) and 8 (one copy of the class: the Maven artifact is substituted by `:shizuku-provider`). | **done** (see "7B" below; the merged-manifest confirmation itself still waits for the first CI run, S7) |
| 7C | One permission | Mika keeps all its permissions; confirm `API_V23` is requested by Mika and declared by the host once, and the runtime request path works with the host as manager. **Correction from step 4 (4G-2):** with the switch on the host does **not** request `API_V23` any more (the provider AAR's request is not merged, the manager's guard removes it elsewhere, Mika's own permission list has no Shizuku permission). 7C checks the run-time path with the host as the manager: 4A (finding 3) says the server treats the manager's app id as always allowed, read but not run. **Done in 7C** (docs only, no code changed; see "7C"): the static facts were re-run (30 permissions of Mika, none a Shizuku one; the four permission rules of the merged-manifest checker; `check-all.py`), the run-time path was written down as a chain with what each link rests on; nothing was run on a device. | **done** |
| 7D | `ShizukuShellUserService` | Check the service class resolves and binds through the manager's provider (`sendUserService`). **Note from step 4 (4G-2):** the manager's provider also answers `sendUserService` (4A, finding 1); read, not run. **Done in 7D** (docs only, no code changed; see "7D"): the static facts around the service were re-run (host package in `BuildConfig.APPLICATION_ID` and its guard in the three workflows, one APK, no code shrinking, one provider with `sendUserService`), the bind path was written as a chain with what each link rests on; Mika's real `ShizukuShellUserService` source was not re-read and nothing was run. | **done** |
| 7E | Docs + zip | README, `NOTICE-Mika.md` note, CHANGES file, flat zip. **Done in 7E** (docs only, no code changed; see "7E"): `NOTICE-Mika.md` got the section "Shizuku hook-up" (what is changed in Mika's sources, what is done on the Win11 side, the notes of 7C / 7D, licence line), `docs/CHANGES-shizuku-part7.md` covers all of step 7, plan rows and this README brought up to date; flat zip `RizwanS2-main-shizuku-step7e.zip`. | **done** (see "7E" below) |

### Step 8 — CI and the switch

| # | Sub-step | What it covers | Status |
|---|----------|----------------|--------|
| 8A | `UltimateBuild.yml` | Fetch + patch + cache step for Shizuku. **Note from 5B-1:** it must run **after** the package rename step: `patch-upstream.py` reads the host package from `applicationId` of `app/build.gradle.kts` at that moment and writes it into `starter.cpp` (`pm path`); same for 8B and 8C. **Done in 8A** (see "8A"): two steps after the Mika step, `Cache Shizuku source` and `Fetch and patch Shizuku source`; the module stays off. | **done** |
| 8B | `UltimateBuild_NoWinlator.yml` | Same step. **Done in 8B** (see "8B"): the same two steps and the same header paragraph, copied byte for byte from `UltimateBuild.yml`. | **done** |
| 8C | `UltimateBuild_WithoutMe.yml` | Same step. **Done in 8C** (see "8C"): the same two steps, with one change: the provider check runs only when the Mika tick box is on. | **done** |
| 8D-1 | APK content script | Script that lists the built APK and requires `libshizuku.so` and the `starter` / `rish` assets. **Note from 5B-2:** also `lib/<abi>/libshizuku.so`, `libadb.so`, `librish.so` for every ABI of the APK, stored extracted (not compressed inside the APK), as the workflows already check for Mika's three files. | **done** (see "8D-1": `shizuku/tools/check-apk-contents.py`, self-test 33 cases; not wired into a workflow yet) |
| 8D-2 | Manifest check on the APK | (From 4F-3: `python3 shizuku/tools/check-all.py --require-real` runs S5 - S7 on the real sources and the real merged manifest in one go; it can replace or follow the call below.) Run the 4E merged-manifest checker on the APK's manifest, in each of the three workflows (`python3 shizuku/tools/check-merged-manifest.py`, with the path the workflows already find for Mika, or without a path; add `--require-shizuku` only after 8F; exit 2 = manifest not found, as the Mika step, a warning there). The self-test of 4E-4c needs no build and can run in the same step or in the root checks (4F-3). | **done** (see "8D-2": a block in each of the three workflows; `check-all.py` is not used there, reason in the section) |
| 8E | Cache keys | Cache key from `UPSTREAM_COMMIT` + `UPSTREAM_API_COMMIT`, so a pin change refetches. | **done** (see "8E": reviewed, no change needed; docs only) |
| 8F | Default switch | Flip `includeShizuku` to on by default only after 8D passes in a first CI run; update README and `gradle.properties`. **Not before 6E** (finding 13: without the init call the built-in boot receiver throws at every boot). **Note from step 4 (4G-2):** the first-CI-run list of step 3 and the open list of "4G-2" belong together; after fetch + patch + build run `python3 shizuku/tools/check-all.py --require-real`. | **done, with the condition not met** (see "8F": flipped on request although no CI run has passed 8D; rollback = the step8e zip) |


### Steps 9 and 10

| # | Sub-step | What it covers | Status |
|---|----------|----------------|--------|
| 9A | Docs | `NOTICE-Shizuku.md` final, README plan table and "first CI run" list brought up to date. | **done** (see "9A": `NOTICE-Shizuku.md` brought to the real state, licences checked on the web, the first-CI-run list for steps 3 - 8 in one place) |
| 9B | CHANGES | `docs/CHANGES-shizuku-part9.md` (steps 5 - 8 together). | **done** (see "9B": one file with every row of steps 5 - 8, the areas, the numbers re-measured, findings 9 - 16, decisions, what is not done; documents only) |
| 10A | Static checks | Run every checker (`check-gradle.py`, `check-provider-match.py`, `patch-upstream.py --check`, Mika checks) and fix what fails. **Note from 5A / 5B-1:** decide whether `sweep-package-strings.py` and `test-patch-host-package.py` (both not wired) join `check-all.py`. **Note from 5C:** `sweep-package-strings.py --self-test` (37) and `test-patch-host-package.py` (60) are the two more tools to decide on. | **done** (see "10A": every checker run, the three self-tests and the real sweep joined `check-all.py` as S8 - S11, first full real run of fetch + patch + check on the 8F tree) |
| 10B | Final zip | Flat zip `RizwanS2-main-shizuku-final.zip`. | **done** (see "10B": the 10A state plus the 10B documents; checked again, fetched folders and caches not in the zip) |

## Step 3 — Gradle wiring (8 sub-steps)

Step 3 was too big for one part (upstream is **11 Gradle projects**, two native builds, two Gradle plugins, one application module that only produces a dex), so it is split:

| # | Sub-step | Status |
|---|----------|--------|
| 3A | `ShizukuLocales` generated by the patch script (replaces Rikka's `autoresconfig` plugin), self-check | done |
| 3B | `settings.gradle.kts`: plugin versions, `includeShizuku` switch, include list of the 11 projects | done |
| 3C | Helper modules, API side: `:shizuku-aidl`, `-shared`, `-api`, `-provider`, `-common`, `-shell` + `modules/after-fetch.gradle.kts` | done (written without the upstream sources, see "3C"; corrected in 3E) |
| 3D | Helper modules, native + server side: `:shizuku-rish` (CMake, Prefab), `-server-shared`, `-starter`, `-server` | done (written without the upstream sources, see "3D"; corrected in 3E) |
| 3E | The main module `:shizuku`: build file, CMake (`libshizuku.so`, `libadb.so`), theme builder, `rish_shizuku.dex` task, fetch / patch tasks, `consumer-rules.pro` | done (this part; **upstream was readable this time**, so 3C / 3D were checked against it and corrected, see "3E") |
| 3F | `:app` and root side: dependency, exclusion of the Rikka AppCompat fork, replacement of `:mika`'s Maven `dev.rikka.shizuku:*` artifacts by our modules, `gradle.properties` notes | done (this part, see "3F"; the replacement is a dependency substitution in the root `build.gradle.kts`, not an edit of `mika/build.gradle.kts`) |
| 3G | Docs of step 3 (this file, `NOTICE-Shizuku.md`, `README.md`, `docs/CHANGES-shizuku-part3.md`): step-3 overview, consolidated decisions, first-CI-run checklist, library list | done (this part, see "3G" and "Step 3 at a glance") |
| 3H | Static checks of all Gradle files, patch script run, flat zip | done (this part, see "3H"; the patch-script re-run on the real checkout could not be done: no network) |

### 3A — `ShizukuLocales` (done)

Upstream's `manager/build.gradle` applies three Rikka plugins. Two are needed and one is not usable in a library:

| Plugin | Output | In a library? | Decision |
|--------|--------|---------------|----------|
| `dev.rikka.tools.refine` 4.4.0 | rewrites calls to hidden Android APIs in the byte code (server, starter, server-shared, shell, manager) | yes | apply it (3C - 3E) |
| `dev.rikka.tools.materialthemebuilder` 1.5.1 | `Theme.Material3.Light.Shizuku` / `Dark.Shizuku` (parents of `sh_Base.AppTheme*`), palette attributes, `textColorOnXxx` colour state lists | **yes** (read in the plugin source: it registers for `LibraryAndroidComponentsExtension` too; its README says "application or library module") | apply it (3E) |
| `dev.rikka.tools.autoresconfig` 1.2.2 | `rikka.shizuku.manager.ShizukuLocales` (`LOCALES`, `DISPLAY_LOCALES`), the `resConfig` language filter, `xml/locales_config.xml` | **no**: `AutoResConfigPlugin.apply` throws "Android application extension not found" in a library | generate the class ourselves (this sub-step) |

Read from the plugin sources (MIT, https://github.com/RikkaApps/AutoResConfig, cloned only for reading): the class is a plain two-array Java file, so `tools/patch-upstream.py` now generates it (new **part E**), with the plugin's own rules:
- a language = a folder `values-<modifier>` of the manager's `res/` with a `strings.xml` larger than 62 bytes (not an empty `<resources/>`) and at most 3 dash-separated parts; `en` is always there; sorted without regard to case;
- modifier -> tag: `b+zh+Hans` -> `zh-Hans`, `pt-rBR` -> `pt-BR`, `de` -> `de`; `zh-CN` / `zh-TW` are *shown* as `zh-Hans` / `zh-Hant` (`DISPLAY_LOCALES`), the tag list `LOCALES` keeps `zh-CN` / `zh-TW`;
- `"SYSTEM"` is the first item of both arrays (`SettingsFragment` treats index 0 as "follow system" and compares the stored value with `"SYSTEM"`).

Result on v13.6.0: **42 languages + SYSTEM** (`values-v21`, `-v31`, `-night`, `-sw600dp` have no `strings.xml`; 21 language folders hold an empty `strings.xml`, so they are skipped exactly like the plugin does). File: `upstream/manager/src/main/java/rikka/shizuku/manager/ShizukuLocales.java` (the `rikka/shizuku/manager` folder is created, it does not exist upstream).
The self-check (part D) now also checks: file present, `LOCALES` and `DISPLAY_LOCALES` both start with `SYSTEM`, same length = number of language folders + 1, `en` present, every item is a language tag.
Not generated, on purpose: the `resConfig` filter (a library has none; `:app` decides what it packs) and `locales_config.xml` (it needs `android:localeConfig` on `<application>`, which the patched library manifest does not have; the language setting still works, only the system's per-app language list is not filled).
Tested: forced re-patch, second run ("already patched"), `--check`, comment text without stray escapes. The patch script hash changed, so an existing checkout is put back to the pinned state and patched again on the next run (automatic).

### 3B — `settings.gradle.kts` (done)

Two additions, nothing else in the file changes:

1. **Plugin versions** in `pluginManagement { plugins { ... } }`: `dev.rikka.tools.refine` 4.4.0 and `dev.rikka.tools.materialthemebuilder` 1.5.1 (upstream's versions, both on Maven Central, which `pluginManagement` already has). This is only a *version lookup*: the modules will apply the plugins by id without a version. It is not put in the root `plugins { ... apply false }` block on purpose: that block resolves every plugin at root configuration time, so a plugin problem would break the whole Win11 build even with Shizuku switched off. With the lookup, nothing is downloaded unless a module applies the plugin.
2. **The switch and the include list**, same idea as `includeMika`: `val includeShizuku = (providers.gradleProperty("includeShizuku").orNull ?: "false") == "true"`. `providers.gradleProperty` sees `-PincludeShizuku=true`, `includeShizuku=true` in `gradle.properties` and `ORG_GRADLE_PROJECT_includeShizuku` (what CI uses). When it is true, 11 projects are included:

| upstream project | Gradle project | project folder |
|---|---|---|
| `:manager` | `:shizuku` | `shizuku/` (Gradle's default for the name) |
| `api/aidl` | `:shizuku-aidl` | `shizuku/modules/aidl` |
| `api/shared` | `:shizuku-shared` | `shizuku/modules/shared` |
| `api/api` | `:shizuku-api` | `shizuku/modules/api` |
| `api/provider` | `:shizuku-provider` | `shizuku/modules/provider` |
| `api/rish` | `:shizuku-rish` | `shizuku/modules/rish` |
| `api/server-shared` | `:shizuku-server-shared` | `shizuku/modules/server-shared` |
| `common` | `:shizuku-common` | `shizuku/modules/common` |
| `starter` | `:shizuku-starter` | `shizuku/modules/starter` |
| `server` | `:shizuku-server` | `shizuku/modules/server` |
| `shell` | `:shizuku-shell` | `shizuku/modules/shell` |

Why it is built this way (decisions):
- **One Gradle project per upstream project, with a `shizuku-` prefix.** Upstream's names (`:api`, `:server`, `:shell`, `:common` ...) are too generic for a project with 20 modules. The split also is needed: (a) `:mika` asks for the Maven artifacts `dev.rikka.shizuku:api` / `provider`, which have the same class names and the same namespaces (`rikka.shizuku.api`, `rikka.shizuku.provider`) as our patched copies; AGP refuses duplicate namespaces and D8 refuses duplicate classes, so those two must be replaced by *project* modules through dependency substitution (3F), and a substitution needs a project to point at; (b) `:shell` is an application module, `:rish` and `:manager` have native builds: they cannot be folded into one library.
- **The build files are in our repo, not in `shizuku/upstream/`.** `include(...)` and the project folders are evaluated *before* any task runs, so before the fetch script has cloned anything; a project whose folder or build file does not exist yet is a deprecation warning today and an error in Gradle 9. The build files therefore live in `shizuku/modules/<name>/` (and `shizuku/build.gradle.kts`) and read their sources from `shizuku/upstream/` through source sets, exactly like `:mika` (3C - 3E).
- **Off by default.** With the switch off nothing of Shizuku is configured, no plugin is resolved, no module exists: the build is the same as after step 2. It stays off until the manifest merge (step 4: Mika's `ShizukuProvider` and the manager's provider have the same authority `${applicationId}.shizuku`, which would make the APK uninstallable; **resolved in 4B-2 by the overlay, note corrected in 4F-2**) and the hooks (step 6) are done, and until the init call (6E) and the CI checks (step 8) exist; step 8F flips the default.
- **The switch could be turned on from 3E (all eleven build files exist).** With it on, the modules exist and `./gradlew :shizuku:assembleDebug -PincludeShizuku=true` builds them on their own; the Win11 APK is unchanged until 3F makes `:app` depend on `:shizuku`, and it stays off by default until steps 4 / 6 (manifest, hooks) are done. (Written in 3B as "keep it off until 3E": a switch on with missing build files would have failed with "build file not found".)

Checked: Kotlin syntax of the whole file (tree-sitter), diff against the step 2 zip (only this file and `tools/patch-upstream.py` differ). Not checked: a Gradle run (see below).

### 3C — API-side helper modules (done)

New files only (no existing file of the project is changed except the docs): `shizuku/modules/after-fetch.gradle.kts` and one `build.gradle.kts` for each of six modules.

| Gradle project | upstream project (inside `shizuku/upstream/`) | kind | what it is | depends on |
|---|---|---|---|---|
| `:shizuku-aidl` | `api/aidl` | library, namespace `rikka.shizuku.aidl` | the AIDL interfaces of the Shizuku service + parcelables (AIDL on) | androidx.annotation |
| `:shizuku-shared` | `api/shared` | library, `rikka.shizuku.shared` | constants read by client, provider and server | androidx.annotation |
| `:shizuku-api` | `api/api` | library, `rikka.shizuku.api` | the client API (`Shizuku`, `ShizukuBinderWrapper` ...) | `api` :shizuku-aidl, `api` :shizuku-shared |
| `:shizuku-provider` | `api/provider` | library, `rikka.shizuku.provider` | `ShizukuProvider` (patched by part A of the patch script) | `api` :shizuku-api |
| `:shizuku-common` | `common` (root level, not in `api/`) | library, `moe.shizuku.common` | helpers shared by manager, server, starter | androidx.annotation, compileOnly hidden stub |
| `:shizuku-shell` | `shell` (root level) | **application**, `rikka.shizuku.shell`, Refine plugin | only product: `classes.dex` (R8) that becomes `assets/rish_shizuku.dex` (3E) | hidden stub / compat, Refine runtime (3C had `:shizuku-rish` and `:shizuku-api` too: dropped in 3E, upstream has no project dependency) |

Decisions:
1. **Source sets read the checkout, the build files are ours** (as decided in 3B). Every module points `java` (and for `:shizuku-aidl` also `aidl`) at `shizuku/upstream/<project>/src/main/...` through `rootProject.file("shizuku/upstream")`, so it does not matter how deep the module folder is. Folders that do not exist yet at configuration time are fine for Gradle; the fetch runs at execution time.
2. **`modules/after-fetch.gradle.kts`** (applied by every module, `:shizuku` too in 3E) makes `preBuild` and the task families that read sources (merge / process / generate / compile / kapt / ksp / package / extract / parse / map / copy / CMake / lint) wait for `:shizuku:patchShizukuUpstream`, named by *path* so the configuration order of the projects does not matter. The two tasks themselves are registered in `shizuku/build.gradle.kts` (3E).
3. **Layout check, new**: every module also gets a task `checkShizukuLayout` (runs after the patch, before the compile). It fails with the module name and folder if `src/main` of the upstream project is missing, and warns if the folder holds a kind of source the build file does not wire (Kotlin, AIDL, resources, native, assets, jniLibs, manifest; kinds that are deliberately left out are declared in `extra["shizukuIgnored"]`). Reason: see "Not verified in 3C" below. A module declares `extra["shizukuUpstreamPath"]`, `extra["shizukuWired"]`, optional `extra["shizukuIgnored"]` before the `apply(from = ...)` line.
4. **Java-only, no Kotlin plugin** in these six modules (the patch script's paths show `.java` for server / starter / shell / provider; the check task warns if a `.kt` file shows up). No upstream manifest is used for the five libraries (an API library's manifest is empty; AGP builds one from the namespace). `:shizuku-shell` has its own minimal manifest (an application module needs one) and its own R8 rules.
5. **Namespaces are unique.** `rikka.shizuku.api` and `rikka.shizuku.provider` are the Maven artifacts' namespaces (the reason for the dependency substitution in 3F); `aidl`, `shared`, `common` and `shell` use new names that nothing refers to (no resources, no `R`), they only have to differ from each other.
6. **`api` vs `implementation`.** `:shizuku-api` exposes `:shizuku-aidl` and `:shizuku-shared` with `api(...)`, `:shizuku-provider` exposes `:shizuku-api`: the Maven POMs have those in compile scope, and `:mika` compiles against `IShizukuService` / `ShizukuApiConstants` through the artifact it asks for. After the substitution in 3F it gets the same through our projects.
7. **`:shizuku-shell`**: release build with R8 (`isMinifyEnabled = true`): the dex is started by `app_process` (entry point looked up by name). `versionCode 1` / `versionName` = `UPSTREAM_VERSION` (decision 6 of 3C-3F). *3C wrote `-dontobfuscate`, a dependency on `:shizuku-rish` and the dex path `intermediates/dex/release/minifyReleaseWithR8/classes.dex`; 3E replaced the rules by upstream's own, dropped the dependency and takes the dex from the release APK (see "3E").*
8. **`tools/check-gradle.py`** (new): a structural check that needs neither Gradle nor a Kotlin compiler: balanced brackets and closed strings / comments / `${...}` templates in every `.kts` file of the Shizuku part plus `settings.gradle.kts` and `build.gradle.kts`; include list <-> module folders; every `apply(from = ...)` target exists; every `project(":x")` is an included project; namespaces unique; the `extra[...]` lines come before the `apply`. Modules that are not written yet are reported as "note", not as an error. Tested with 5 deliberate faults (extra brace, unknown project, duplicate namespace, unterminated string, `extra` after `apply`): all found.

#### Not verified in 3C (read this before the first CI run)

> **Resolved in 3E:** the upstream sources could be cloned and read in 3E; every dependency list and namespace below was compared with upstream's `build.gradle` files and the imports of the sources. The differences found are in the table "Corrections to 3C / 3D" in section 3E. What stays open is only what needs a real Gradle run.

- **The upstream sources could not be read in this session** (no network at all: not even GitHub, which earlier sessions could reach). The folders come from the patch script (real paths: `api/provider/src/main/java/rikka/shizuku/ShizukuProvider.java`, `shell/src/main/java/rikka/shizuku/shell/ShizukuShellLoader.java`, `server`, `starter`, `manager`); the **dependency lists and the namespaces of `aidl` / `shared` / `common` are reconstructed** from the layout of Shizuku-API 13.1.5 and its Maven POMs, not from a fresh read of each upstream `build.gradle`. If one is wrong, the first CI run with `-PincludeShizuku=true` shows it as "cannot find symbol" / "package ... does not exist" in that module; the fix is one line in the module's `dependencies { }` (typical suspects: a missing `compileOnly("dev.rikka.hidden:stub:4.4.0")` in `:shizuku-api` / `:shizuku-provider`, a missing `.aidl` folder in `:shizuku-api`).
- `checkShizukuLayout` is the safety net for the folders; the dependency lists have none.
- Nothing was built: no Gradle run (see "Not checked here"). Checked: `check-gradle.py` (structure, cross-references), nothing else.

### 3D — native and server-side helper modules (done)

New files only (plus small additions to `after-fetch.gradle.kts` and `tools/check-gradle.py`, and the docs): one `build.gradle.kts` for each of four modules in `shizuku/modules/`.

| Gradle project | upstream project (inside `shizuku/upstream/`) | kind | what it is | depends on |
|---|---|---|---|---|
| `:shizuku-rish` | `api/rish` | library, `rikka.rish`, **native** (CMake, Prefab) | "rish" shell: Java part + `librish.so` | libcxx (Prefab), androidx.annotation, compileOnly hidden stub |
| `:shizuku-server-shared` | `api/server-shared` | library, `rikka.shizuku.server.shared`, Refine | code shared by server and starter | `api` :shizuku-aidl, `api` :shizuku-shared, hidden stub / compat, Refine runtime |
| `:shizuku-starter` | `starter` (root level) | library, `moe.shizuku.starter`, Refine | `ServiceStarter` (what `app_process` runs; patched by part A) | :shizuku-server-shared, :shizuku-common, :shizuku-api, hidden stub / compat, Refine runtime |
| `:shizuku-server` | `server` (root level) | library, `rikka.shizuku.server`, Refine | `ShizukuService`, the server process (patched by part A) | :shizuku-aidl, -shared, -api, -server-shared, -common, -rish, parcelablelist 2.0.1, hidden stub / compat, Refine runtime |

Decisions:
1. **Native build of `:shizuku-rish`** (decision 4 above): the project's NDK (`ext.ndkVer`), CMake 3.22.1 like `:ppsspp`, `-DANDROID_STL=none` + Prefab package `org.lsposed.libcxx:libcxx:27.0.12077973`; ABIs = all four of upstream, `-PshizukuAbis=arm64-v8a,...` narrows them (the same property `:shizuku` uses since 3E). The CMake file is read from the checkout: `shizuku/upstream/api/rish/src/main/cpp/CMakeLists.txt`.
2. **`extra["shizukuRequired"]`, new in `after-fetch.gradle.kts`**: single files that a build file points at directly (here the CMake file) are checked by `checkShizukuLayout`; if one is missing the build stops with its name instead of a CMake error about a file that "does not exist".
3. **Refine plugin** in exactly the modules named in 3A: `:shizuku-server-shared`, `:shizuku-starter`, `:shizuku-server` (here) + `:shizuku-shell` (3C) + `:shizuku` (3E). `:shizuku-rish` and the 3C libraries do not apply it.
4. **Dependency graph** (no cycle; checked): `aidl`, `shared`, `common` -> `api` -> `provider`; `rish`; `server-shared` -> `aidl`, `shared`; `starter` -> `server-shared`, `common`, `api`; `server` -> `aidl`, `shared`, `api`, `server-shared`, `common`, `rish`; `shell` -> `rish`, `api`. `:shizuku-starter` and `:shizuku-server` do not depend on each other (the server is started by name through `app_process`; both end up in the host APK through `:shizuku`).
5. **`tools/check-gradle.py`** now also finds cycles in the `project(...)` graph (tested with a planted `api -> server -> api`, plus an unknown project, a duplicate namespace and a missing brace in the new files: all found).
6. The manifests of all four are not used (an empty library manifest; AGP makes one from the namespace). Namespaces: `moe.shizuku.starter` and `rikka.shizuku.server` are the Java packages (shown by the patch script's paths), `rikka.rish` and `rikka.shizuku.server.shared` are new names that nothing refers to.

#### Not verified in 3D

> **Resolved in 3E:** see the note under "Not verified in 3C" and the table "Corrections to 3C / 3D" in section 3E (the `libcxx` Prefab package is called `cxx` inside, the CMake path was right, `parcelablelist` is used by upstream's server-shared too).

Same limit as 3C (no network, nothing built, upstream not readable in this session). Reconstructed, not read: the **dependency lists of all four**, the **namespaces of `rish` and `server-shared`**, the **CMake file path and the `libcxx` Prefab package name** of `:shizuku-rish`, and the **`parcelablelist` dependency of `:shizuku-server`** (included as a safe superset; remove it if the server does not use `rikka.parcelablelist`). Typical symptoms in the first CI run with `-PincludeShizuku=true`: "cannot find symbol" / "package does not exist" in one of these modules (add or remove one line in its `dependencies { }`), or a CMake error `libcxx` not found (name of the Prefab package; look at upstream's CMakeLists.txt). `checkShizukuLayout` covers the folders and the CMake file path only.

### 3E — the main module `:shizuku` (done)

New files: `shizuku/build.gradle.kts` (the module, the two tasks that every module waits for, the rish dex task), `shizuku/consumer-rules.pro`, `shizuku/modules/provider/consumer-rules.pro`. Changed: the build files of seven 3C / 3D modules (corrections below), `modules/shell/proguard-rules.pro`, `tools/check-gradle.py`.

**This time the upstream sources could be cloned and read** (GitHub was reachable, Maven / Google / Gradle servers still are not). So 3E started with the real `manager/build.gradle`, the CMake files, the ProGuard rules and the Rikka plugin sources, and 3C / 3D were checked against the real dependency lists and imports.

#### What `shizuku/build.gradle.kts` does (and what it leaves out)

| Upstream `manager/build.gradle` | Here |
|---|---|
| `com.android.application`, `applicationId "moe.shizuku.privileged.api"`, `versionCode` / `versionName` from `git rev-list --count` | `com.android.library`, namespace `moe.shizuku.manager`; no version (the patched code never reads it); `UPSTREAM_VERSION` is only used by `:shizuku-shell` |
| plugins `refine`, `autoresconfig`, `materialthemebuilder`, Kotlin | `refine` + `materialthemebuilder` + Kotlin; `autoresconfig` is replaced by `ShizukuLocales` from the patch script (3A) |
| `buildFeatures { buildConfig, viewBinding, prefab }` | `viewBinding`, `prefab`; `buildConfig = false` (the patch script removed the 2 uses) |
| signing config (`signing.gradle`), `minifyEnabled` + `shrinkResources`, `proguard-rules.pro`, `collapseReleaseResourceNames` (aapt2 on the APK), APK renaming, copying of mapping / APK to `out/` | none of it: a library has no APK; `:app` decides about R8; `consumer-rules.pro` carries the keep rules |
| `externalNativeBuild.cmake.path 'src/main/jni/CMakeLists.txt'`, `-DANDROID_STL=none` | same file (read from the checkout), same argument; project NDK (`ext.ndkVer`), CMake 3.22.1, ABIs all four, `-PshizukuAbis=...` narrows |
| `packagingOptions { jniLibs.useLegacyPackaging true; resources.excludes ** }`, `dependenciesInfo`, `lint` | app-only settings: `useLegacyPackaging` is already set in `:app` (needed to run `libshizuku.so` from the native library dir); lint `abortOnError = false` like the other modules |
| `afterEvaluate { preReleaseBuild.dependsOn(':shell:assembleRelease') }`; `:shell` copies its dex into `manager/src/main/assets` | task `shizukuRishDex` (below) |
| `exclude androidx.appcompat` (all configurations) + `dev.rikka.rikkax.appcompat:appcompat:1.6.1` | **the other way round**: the Rikka fork is excluded, stock `androidx.appcompat:appcompat:1.6.1` is used (decision 1) |
| the dependency list (5 project modules, hidden-API compat / stub, coroutines, 7 AndroidX libraries, Material, libsu, 14 RikkaX libraries, boringssl, libcxx, hiddenapibypass, BouncyCastle, AppIconLoader) | the same, upstream's versions, except lifecycle 2.9.0 -> 2.8.7 and coroutines 1.10.2 -> 1.9.0 (decision 3); `androidx.profileinstaller` exclusion not applied (app-only matter) |

#### Tasks

- `:shizuku:fetchShizukuUpstream` (`Exec`: `bash tools/fetch-upstream.sh`) and `:shizuku:patchShizukuUpstream` (`Exec`: `bash tools/patch-upstream.sh`, depends on the fetch). These are the two tasks that `modules/after-fetch.gradle.kts` names by path, so every `:shizuku-*` module and `:shizuku` itself wait for them (preBuild, resources, manifest, AIDL, compile, CMake, lint ...). Same pattern as `:mika`. Needs bash + git + python3 (Linux / macOS / CI).
- `:shizuku:shizukuRishDex`: runs `:shizuku-shell:assembleRelease` (R8), takes the **one** `classes.dex` out of the unsigned release APK in `shizuku/modules/shell/build/outputs/apk/release/` (the same way upstream's `:shell` does it: from the APK, not from an AGP-internal path) and writes it as `rish_shizuku.dex` into `shizuku/build/generated/shizuku/rishDex/assets/`. That folder is registered with the AGP Variant API (`variant.sources.assets.addGeneratedSourceDirectory`) for every variant, so the merge-assets / lint / package tasks wait for it by themselves and nothing is written into `shizuku/upstream/`. The task fails with a clear message if there is not exactly one APK or not exactly one dex. The release build of `:shizuku-shell` is used for debug variants too (upstream uses the debug build for debug, but it is the same loader; R8 on is what keeps it one dex).
- `:shizuku:checkShizukuLayout` (from `after-fetch.gradle.kts`): additionally requires `manager/src/main/jni/CMakeLists.txt` and `manager/src/main/AndroidManifest.xml`.

#### What the module reads from the checkout

| Kind | Folder (inside `shizuku/upstream/manager/src/main/`) | Notes |
|---|---|---|
| Java + Kotlin | `java/` | the Kotlin plugin compiles the `.kt` files; includes the generated `rikka/shizuku/manager/ShizukuLocales.java` |
| resources | `res/` | 70 locales, all names already `sh_`-prefixed by the patch script |
| assets | `assets/` (upstream's `rish` shell script) + generated `rish_shizuku.dex` | `ShellTutorialActivity` copies both to the user's storage |
| manifest | `AndroidManifest.xml` | the library manifest from the patch script |
| native | `jni/CMakeLists.txt` | `libshizuku.so` (a CMake *executable* named like a library: the server starter) + `libadb.so` (ADB pairing with BoringSSL); Prefab packages `boringssl` (`io.github.vvb2060.ndk:boringssl:20250114`) and `cxx` (inside `org.lsposed.libcxx:libcxx:27.0.12077973`) |
| generated | theme builder: `Theme.Material3.Light.Shizuku` / `Dark.Shizuku` (`primaryColor #3F51B5`, parents `Theme.Material3.*.Rikka`, palette + text colours: upstream's settings) | the plugin supports libraries (3A). The extension is configured with `extensions.configure<MaterialThemeBuilderExtension>` because the plugin registers it from a callback, so the generated accessor is not guaranteed to exist when the script is compiled |

#### `consumer-rules.pro`

The three entry points that something looks up *by name* (`rikka.shizuku.server.ShizukuService.main`, `moe.shizuku.starter.ServiceStarter.main`, `moe.shizuku.manager.shell.Shell.main`), `BinderContainer` (read through a Parcel), the two hidden-API adapters, and the three classes whose natives are registered with `RegisterNatives` by class name (`PairingContext`, `RishHost`, `RishTerminal`). `:app` has `isMinifyEnabled = false`, so nothing is applied today; upstream's global options (`-allowaccessmodification`, `-repackageclasses`, `-assumenosideeffects` ...) are left out on purpose, they would change the whole app.

#### Corrections to 3C / 3D (found by reading the real sources)

| Module | 3C / 3D had | Upstream has | Consequence if left | Fixed |
|---|---|---|---|---|
| `:shizuku-server` | Java only, no gson, no `:shizuku-starter` | **2 Kotlin files** (`ApkChangedObservers.kt`, `ktx/Handler.kt`) + Kotlin plugin, gson 2.13.1, `starter` and `compileOnly provider` (`BinderContainer`); no client API | the two `.kt` files silently not compiled: `HandlerKt` missing, build failure in `ShizukuService` | Kotlin plugin + `jvmTarget 21`, `wired` has `"kotlin"`, deps as upstream, `:shizuku-api` dropped |
| `:shizuku-server-shared` | no `rish`, no `core`, no `parcelablelist` | `api project(':rish')`, `androidx.core`, `parcelablelist` | `rikka.rish.RishConfig` / `RishService` not found | added |
| `:shizuku-starter` | `server-shared`, `common`, `api` | `shared`, `server-shared`, `common`, `compileOnly provider` | `BinderContainer` not found | as upstream |
| `:shizuku-rish` | no project dependency | `implementation project(':api')` | none found in the imports, but upstream has it | added |
| `:shizuku-shell` | depended on `rish` + `api`, own R8 rules (`-dontobfuscate`, keep `rikka.rish.**`) | no project dependency (the loader loads `moe.shizuku.manager.shell.Shell` from the host APK **by name**); rules: keep `main`, `-allowaccessmodification`, `-repackageclasses` | none harmful (R8 would have dropped the unused classes), but the dex was not upstream's | dependencies and rules as upstream (+ `dontwarn` for the stubs) |
| `:shizuku-aidl` | `wired = java, aidl` | 4 `.aidl` files, **no `.java`** | `checkShizukuLayout` stops with "no .java file although the build file wires java sources": **the build could not have started** | `wired = aidl` |
| `:shizuku-provider` | no consumer rules | `consumer-rules.pro` (`BinderContainer` keep rules) | only matters once R8 is on | own copy of the 5-line file (the checkout path does not exist before the fetch) |
| comments | `find_package(libcxx ...)`, "upstream's rules are not readable" | `find_package(cxx ...)` (Prefab module `cxx` of `libcxx`) | none | corrected |

Confirmed unchanged: all namespaces (unique, checked), the CMake path and Prefab packages of `:shizuku-rish`, the source folders of all ten modules (a simulated `checkShizukuLayout` against the real checkout: no unwired kind of source, no missing required file), the Refine plugin set (`server-shared`, `starter`, `server`, `shell`, `:shizuku`: exactly the modules whose sources call hidden APIs), no dependency cycle (`check-gradle.py`, now including `:shizuku`).

#### Decisions of 3E

1. **Release APK of `:shizuku-shell` as the dex source** instead of AGP's `intermediates/dex/.../minifyReleaseWithR8/classes.dex` (decision 2 of "3C - 3F" said the latter): the APK location is public API, the intermediates folder is not. One task, two failure messages (not one APK / not one dex).
2. **Generated assets folder through the Variant API** instead of `sourceSets.assets.srcDir(buildDir/...)` + hand-made `dependsOn` per task name: AGP wires the dependencies itself, including lint and the library's AAR packaging.
3. **`extensions.configure<MaterialThemeBuilderExtension>`** instead of `materialThemeBuilder { }` (accessor risk, see above).
4. **No `resourcePrefix`** on `:shizuku`: it is a lint-only check and the plugin-generated resources (`Theme.Material3.*.Shizuku`, palette attributes) have no prefix.
5. **The fork exclusion is per configuration of `:shizuku`** (`configurations.configureEach { exclude(...) }`). Another rikkax library may still pull the fork in through its POM: 3F adds the same exclusion to `:app`, which is where the final classpath is decided.
6. **`:shizuku` is not a dependency of `:app` yet** (3F). With `-PincludeShizuku=true` the modules exist and can be built on their own, the Win11 APK is unchanged. *(Done in 3F, see below.)*

#### Not verified in 3E (read this before the first CI run)

Still no Gradle run (Maven Central, Google Maven, JitPack, the plugin portal and `services.gradle.org` are unreachable here). What was run:
- `check-gradle.py` (structure, cross-references, namespaces, cycles, new: Kotlin plugin <-> wired `"kotlin"`, proguard files exist, `:shizuku` defines the three tasks);
- **a real Kotlin compile of every build script** with Gradle's own embedded compiler (the Android / Rikka plugin ids replaced by `java-library` in a scratch project): no syntax error, no type error outside the unresolved Android DSL; this found nothing in the old files and nothing in the new one after one fix (a `/*` inside a comment, which Kotlin treats as a nested comment);
- the patch script on the real v13.6.0 checkout (no change needed in 3E);
- the layout check simulated against the real checkout.

Open, needs the first CI run (`./gradlew :shizuku:assembleDebug -PincludeShizuku=true` is the first real test of the Gradle side, it builds all eleven modules, both native libraries and the dex):
- AGP DSL details that no script here exercises: `variant.sources.assets?.addGeneratedSourceDirectory(...)`, `manifest.srcFile` in a library, `consumerProguardFiles`, `ndk.abiFilters` + `cmake.abiFilters` together (the pattern of `:ppsspp` / `:shizuku-rish`);
- whether AGP packs `libshizuku.so`, which is a CMake **executable** (`add_executable(libshizuku.so ...)`), into a *library* the way it does for upstream's application module. If it does not, the symptom is a missing `libshizuku.so` in the APK (the planned APK check of step 8 looks for it); the fix would be to build it as a `SHARED` target or copy it by a task;
- the rikkax libraries without the fork (decision 1): a `NoSuchMethodError` / `ClassNotFoundException` in a rikkax class at run time would point at a fork-only API;
- version lifts that no script here can show (androidx.core 1.16.0, fragment 1.8.7, recyclerview 1.4.0, preference 1.2.1 may be higher than what other modules use today: Gradle takes the highest, so other modules are compiled against newer versions);
- the run-time points of step 10 (targetSdk 37: foreground service of the ADB pairing, notifications).

### 3F — `:app` and root side (done)

Files changed: `build.gradle.kts` (root), `app/build.gradle.kts`, `gradle.properties` (comments only), `settings.gradle.kts` (a comment only), `shizuku/tools/check-gradle.py`, the docs. New: `docs/CHANGES-shizuku-part3f.md`. No Kotlin / Java / resource / manifest / workflow file is touched, `mika/build.gradle.kts` is not touched.
**Everything is behind the switch**: with `includeShizuku` off (default) the three build files evaluate to exactly what they did before (one `Boolean` that is `false`, one empty map, no `if` taken).

| File | Change (only with the Shizuku projects in the build) |
|---|---|
| `app/build.gradle.kts` | `val shizukuIncluded = rootProject.findProject(":shizuku") != null` (the signal is *"does the project exist"*, so the property is read in one place only, `settings.gradle.kts`, and the two can never disagree). `implementation(project(":shizuku"))` behind it. At the end of the file `configurations.configureEach { exclude(group = "dev.rikka.rikkax.appcompat", module = "appcompat") }` behind it. In `packaging { resources { excludes += ... } }`: `"/META-INF/versions/**"` behind it (precaution, see below) |
| root `build.gradle.kts` | a `shizukuSubstitutions` map (`dev.rikka.shizuku:aidl` / `shared` / `api` / `provider` -> `:shizuku-aidl` / `-shared` / `-api` / `-provider`), filled only when `findProject(":shizuku-api") != null`; if it is not empty, `allprojects { configurations.configureEach { resolutionStrategy.dependencySubstitution { substitute(module(artifact)).using(project(path)).because(...) } } }` |
| `gradle.properties` | comment block for `includeShizuku` (what it switches, what it replaces / excludes, the install limit until step 4; the limit is gone since 4B-2, the comment was corrected in 4F-2) and `shizukuAbis`; both stay commented, nothing is set |
| `settings.gradle.kts` | the comment that said "the `:app` side is 3F" says it is done |
| `shizuku/tools/check-gradle.py` | check 8 (below); `app/build.gradle.kts` joins the brackets / strings check |

#### Decisions of 3F

1. **The replacement of `:mika`'s Maven artifacts is a dependency substitution in the root build file, not an edit of `mika/build.gradle.kts`.** (The plan table said "root `build.gradle.kts`": that is where it is. The Maven lines themselves are in `mika/build.gradle.kts`, lines `implementation("dev.rikka.shizuku:api:13.1.5")` / `provider`.) Reasons: (a) `mika/tools/check-manifest.py` fails if `mika/build.gradle.kts` has no `dev.rikka.shizuku` dependency, and the CI package rename edits that file (`BuildConfig.APPLICATION_ID`), so an `if` around the two lines would put a second copy of the switch into Mika's build file and a second thing that those tools have to understand; (b) a substitution also catches a third-party library that asks for one of the four artifacts through its POM, which an edit of one build file never would; (c) with the switch off nothing runs. The substitution matches **any version** (`module("group:name")` without a version), applies in **every project and configuration** (compile, runtime, packaging, annotation processors), and covers `aidl` and `shared` although `:mika` asks for `api` + `provider` only: the Maven `api` POM brings those two in, and `:shizuku-api` exposes the local ones with `api(...)` (3C, decision 6). Why it is needed at all: the Maven artifacts and our patched modules have the same classes and the same namespaces (`rikka.shizuku.api`, `rikka.shizuku.provider`): AGP refuses two modules with one namespace, D8 refuses duplicate classes (and the Maven `ShizukuProvider` would still have the *unpatched* manager package string).
2. **The signal is `findProject(...)`, not the property.** `settings.gradle.kts` decides (`providers.gradleProperty("includeShizuku")`, which sees `-P`, `gradle.properties` and `ORG_GRADLE_PROJECT_includeShizuku`). `:app` uses `rootProject.findProject(":shizuku")`, the root build file `findProject(":shizuku-api")`. (`:app` reads `includeMika` with `findProperty` instead; for Shizuku the project test is used because it cannot drift from the include list.)
3. **The fork exclusion is in `:app` as well as in `:shizuku`** (decision 5 of 3E): the final class path is decided in `:app`, and rikkax libraries (`material`, `preference` ...) may list the fork in their POM. The stock `androidx.appcompat` is already a dependency of `:app` (1.6.1; `:j2me` 1.8.0 and `:seal` 1.7.0 win, one version per library).
4. **Only `:shizuku` is a dependency of `:app`.** The ten helper modules arrive through it (`implementation` dependencies are on the *runtime* class path of `:app`, which is what the APK is made from; `:shizuku-server` / `-starter` / `-rish` are in the host `base.apk` for `app_process`, as step 1 required). `:app` does not compile against any of them yet; step 6 (`ShizukuLauncher.kt`) uses `moe.shizuku.manager` classes, which `:shizuku` provides. **`:shizuku-shell` is never a dependency** (an application module: only its `classes.dex` is wanted, delivered as `assets/rish_shizuku.dex` by `:shizuku:shizukuRishDex`); `check-gradle.py` fails if anything but the dex task refers to it.
5. **`/META-INF/versions/**` is not packed** (a precaution, only with Shizuku in the build). The manager's BouncyCastle 1.70 (`bcprov-jdk15on`, `bcpkix-jdk15on`, and `bcutil-jdk15on`, which `bcpkix` pulls in) ships multi-release files with the same path in each jar (`META-INF/versions/9/OSGI-INF/MANIFEST.MF`, `module-info.class`): the known `mergeReleaseJavaResource` failure "2 files found with path ...". Upstream's own app avoids it with `resources.excludes += '**'`, which is far too broad for Win11 (it would also drop the `META-INF/services` files that other libraries read at run time). Android does not read `META-INF/versions`, so excluding it cannot change behaviour. **Written from knowledge of that error, not seen here** (nothing can be built): if the first CI run reports another duplicate path, the fix is one more entry in `packaging.resources.excludes` of `:app` (the message names the path). No other project module uses BouncyCastle (checked: `grep` over all build files).
6. **`gradle.properties` stays untouched in effect**: both properties are documented as commented examples. Setting `includeShizuku=true` there would be a default flip, which steps 8 / 10 do (after the manifest merge and the hooks). `shizukuAbis` was already read by `:shizuku` and `:shizuku-rish` (3D / 3E); it was only undocumented.
7. **(Written in 3F; superseded by 4B-2, note corrected in 4F-2: the overlay removes Mika's provider, so the APK is expected to install; not built yet.) With the switch on, the APK was built but could not be installed while it contained both `:mika` and `:shizuku`.** Both declare a provider with the authority `${applicationId}.shizuku` (`rikka.shizuku.ShizukuProvider` of Mika's manifest, `moe.shizuku.manager.ShizukuManagerProvider` of the manager): Android refuses the package (`INSTALL_FAILED_CONFLICTING_PROVIDER`). That was step 4 (done in 4B-2: the build-type overlay `app/src/shizuku/AndroidManifest.xml` removes Mika's provider). With `-PincludeMika=false` there is no clash. The switch stays off by default (until 8F); the first CI run confirms that the APK installs.

#### Checked against the real upstream API build files (cloned this time)

The four substituted artifacts are exactly the four modules that Shizuku-API publishes to Maven (`publishLibrary = true` in `api/{aidl,shared,api,provider}/build.gradle`; `rish`, `server-shared` and `demo*` are not published, so nothing can ask for them from Maven). Upstream's `api` exposes `aidl` + `shared` with `api project(...)` (ours too). Two harmless differences, left as they are: upstream's `shared` lists `implementation project(':aidl')` although its only sources (`ShizukuApiConstants`) import nothing but `androidx.annotation` (so `:shizuku-shared` does not need it; the runtime class path gets `:shizuku-aidl` through `:shizuku-api` anyway), and upstream's `provider` has `:api` as `implementation` where ours has `api(...)` (a superset: a client that asks for the provider also sees the API classes, as the Maven POM's compile scope did for `:mika`).

#### What `check-gradle.py` checks now (check 8)

Besides the structure checks of 3C - 3E: `app/build.gradle.kts` is parsed like the other files; the root build file has the substitution map, it is guarded by `findProject(":shizuku-api") != null`, uses `dependencySubstitution` / `substitute(module(..))` / `.using(project(..))`, and every target is an included Shizuku project with the same name as the artifact; **every `dev.rikka.shizuku:<x>` coordinate that any build file of the project asks for (top-level build files and `<folder>/build.gradle.kts`) is in the map** (so a new Maven request for e.g. `dev.rikka.shizuku:foo` is found before it becomes a duplicate-class error), and no shizuku module asks for such a coordinate itself (it would be substituted by a dependency on itself); `:app` defines `shizukuIncluded` from `findProject(":shizuku")`, depends on `:shizuku` and excludes the fork, both exactly inside `if (shizukuIncluded) { ... }`, and on no other `:shizuku-*` project; no file outside the Shizuku modules (and no module but `:shizuku`'s dex task) refers to `:shizuku-shell`; `mika/build.gradle.kts` still has its `dev.rikka.shizuku` lines (`check-manifest.py` needs them); `settings.gradle.kts` still has the switch OFF by default; `gradle.properties` documents `includeShizuku` and `shizukuAbis` and does not set `includeShizuku`.
Tested with six planted faults (substitution entry removed, `:app` dependency without the `if`, an unknown Maven artifact `dev.rikka.shizuku:extra` in `:mika`, default flipped to on, `:app` depending on `:shizuku-shell`, a helper module asking for the Maven `api`): all six found, the unmutated copy passes. Also run: `mika/tools/static-check.py` (it simulates the "without Mika" workflow on `app/build.gradle.kts` and `settings.gradle.kts`: Mika lines removed, files still balanced, the `:shizuku` lines survive), a **tree-sitter Kotlin parse of all 33 `.kts` files** of the project (no error node), and `check-gradle.py` on the real files.

#### Not verified in 3F (read this before the first CI run)

Still no Gradle run (see "Not checked here"). Syntax and structure are checked; behaviour is not. What only the first CI run with `-PincludeShizuku=true` can show:
- **The substitution DSL.** `substitute(module("g:n")).using(project(":x")).because("...")` inside `configurations.configureEach { resolutionStrategy.dependencySubstitution { } }` is the form in Gradle's documentation; the loop around it and `project(localPath)` resolving to `DependencySubstitutions.project` (the innermost receiver) are not exercised here. Symptom if wrong: a script compile error at configuration time (the build stops at once, with the line).
- **`:mika` compiles against our `:shizuku-api` / `:shizuku-provider`** instead of the AAR: both are libraries with `api(...)` dependencies like the POMs, so `IShizukuService` / `ShizukuApiConstants` should still be visible. If `:mika` reports "cannot find symbol" for a `rikka.shizuku.*` class, look at the `api` / `implementation` split of `:shizuku-api` (3C).
- **Duplicate resource paths** besides `META-INF/versions` (decision 5), and any **duplicate class** between the new libraries (rikkax, libsu, hiddenapibypass, BouncyCastle, AppIconLoader, `dev.rikka.hidden`) and the existing ones: the message of D8 / `mergeReleaseJavaResource` names the class / path. None was found by reading the dependency lists, but only a build can prove it.
- **Native libraries in the APK**: `libshizuku.so` (a CMake *executable*, open point of 3E), `libadb.so`, `librish.so`; the three names are unique, and the existing `pickFirsts` of `libc++_shared.so` / `liboboe.so` do not touch them. The planned APK check of step 8 looks for all three.
- **Version lifts** from the new libraries (androidx.core 1.16.0, fragment 1.8.7, recyclerview 1.4.0, preference 1.2.1 ...) on the other modules (open point of 3E, unchanged).
- `./gradlew :app:dependencies -PincludeShizuku=true` is the quickest look: `dev.rikka.shizuku:api -> project :shizuku-api` and no `dev.rikka.rikkax.appcompat` anywhere in `releaseRuntimeClasspath`.

### 3G — docs of step 3 (done)

Documentation only: no build file, script, Kotlin / Java / resource / manifest / workflow file is touched (checked by a file-by-file diff against the `…-shizuku-step3f.zip` that this part started from; the only differences are the four doc files below). Changed: this file, `NOTICE-Shizuku.md`, `README.md` (root), new `docs/CHANGES-shizuku-part3.md`.
(The step-3f zip already contained 3F, including `docs/CHANGES-shizuku-part3f.md`; the plan table in the request that started 3G still listed 3F as remaining. 3G is built on what is in the zip.)

What 3G adds, and where:
| Where | What |
|---|---|
| this file, "Step 3 at a glance" (below) | one-page picture of the whole Gradle side: the 11 projects with their dependency graph, the tasks and their order, what each switch does, which file does what |
| this file, "Step 3 decisions, consolidated" | the 16 decisions of 3A - 3F in one numbered table (they were spread over six sections), each with the sub-step that holds the details |
| this file, "First CI run: what to look at" | the open points of 3C - 3F in one table: symptom -> cause -> one-line fix, plus the three commands to run in order |
| `../NOTICE-Shizuku.md` | status line updated, the list of libraries that the Gradle side now pulls in (with versions and where they are used), the 3A - 3F changes brought up to date; the licence column is **to be confirmed in step 9** |
| `../README.md` | plan row 3 (3A - 3G done), summary of step 3 |
| `../docs/CHANGES-shizuku-part3.md` | step 3 as a whole (3A - 3G): files per sub-step, what is built, what is not verified |

Nothing in the step 3 sub-step sections above was removed; they stay as the detailed record.

### 3H — final checks and zip (done)

Verification only: no build file, script, Kotlin / Java / resource / manifest / workflow file is changed. Changed: this file, `README.md` (root), `NOTICE-Shizuku.md`, `docs/CHANGES-shizuku-part3.md` (status lines). New: `docs/CHANGES-shizuku-part3h.md`. Result: `RizwanS2-main-shizuku-step3.zip` (flat, files at the zip root, without `shizuku/upstream/`).

| Check | Result |
|---|---|
| `python3 shizuku/tools/check-gradle.py` | ok: 15 `.kts` files structurally fine, 11 unique namespaces, include list <-> module folders consistent, no cycle, substitution map complete, switch default off, `:shizuku-shell` only used by the dex task |
| bracket / string / comment / `${}` scanner of `check-gradle.py` over **all 33 `.kts` files** of the project (not only the Shizuku ones) | no error |
| `python3 mika/tools/static-check.py` (6 workflows, 11 shell scripts, 12 Python scripts, 628 XML files, Mika stubs and hooks, Gradle modules, `pickFirsts`, LF endings, executable `*.sh`) | all checks passed (the patched-source checks of `:mika` are skipped without `mika/upstream/`, as always) |
| YAML of the 6 workflows; `bash -n` of the two Shizuku shell scripts; `ast.parse` of `patch-upstream.py` | ok |
| line endings: real CR characters in the `.kts` / `.sh` / `.py` / `.pro` / `.yml` / `.md` / `.properties` files of the project | none (only two third-party README files of `:j2me` have CRLF, as before) |
| workflows | untouched: the only `shizuku` word in them is an old comment about Mika's `ShizukuShellUserService` (CI work is step 8) |

**Not possible in this session (no network in the sandbox: GitHub, Maven, Google Maven, the plugin portal and the Gradle distribution are all unreachable):**
- the **re-run of the patch script on a real v13.6.0 checkout** (`fetch-upstream.sh` stops with "Could not resolve host: github.com"; `patch-upstream.py --check` stops with "upstream is empty"). The script was last run on the real source in 3E / 3A and has not changed since; it is only syntax-checked (`ast`) and its shell wrappers `bash -n` now;
- a **Kotlin parse / compile** of the build scripts (no tree-sitter, no Kotlin compiler, no pip index): the scanner above checks the lexical structure only;
- any **Gradle run**.

So 3H confirms that the files are structurally consistent and that nothing outside the Shizuku part changed in a way the project's own checks can see. It does **not** show that the Gradle side builds. The first CI run (three commands, in this order, in "First CI run: what to look at") is the first real test.

### Step 3 at a glance

**The 11 Gradle projects and how they depend on each other** (only with `-PincludeShizuku=true`; `->` = `api` / `implementation` project dependency, `-.->` = `compileOnly`):

```
:app --> :shizuku (library, the manager UI + both native libs + rish_shizuku.dex asset)
:shizuku --> :shizuku-server, -rish, -starter, -api, -provider      (direct; aidl, shared, common, server-shared arrive through them at run time)
:shizuku-api --> :shizuku-aidl, :shizuku-shared                       (api: exposed, like the Maven POM)
:shizuku-provider --> :shizuku-api                                      (api)
:shizuku-server --> :shizuku-aidl, -shared, -common, -server-shared, -starter, -rish;  -.-> :shizuku-provider   (no client API: upstream's server does not use it)
:shizuku-server-shared --> :shizuku-aidl, :shizuku-shared, :shizuku-rish
:shizuku-starter --> :shizuku-shared, -server-shared, -common;  -.-> :shizuku-provider
:shizuku-common, :shizuku-aidl, :shizuku-shared  (no project dependency)
:shizuku-rish --> :shizuku-api
:shizuku-shell  (application module, no project dependency; only its classes.dex is used)
:mika --> :shizuku-api / :shizuku-provider   (through the dependency substitution of the root build file)
```
(The exact lists are in each `build.gradle.kts`; `tools/check-gradle.py` finds cycles, unknown projects and a dependency on `:shizuku-shell`.)

**Tasks and their order** (every `:shizuku*` module waits for the first two through `modules/after-fetch.gradle.kts`):
1. `:shizuku:fetchShizukuUpstream` (`bash shizuku/tools/fetch-upstream.sh`: clones the pinned tag + API commit into `shizuku/upstream/`, verifies both commits)
2. `:shizuku:patchShizukuUpstream` (`bash shizuku/tools/patch-upstream.sh`: host package, library conversion, `sh_` resources, `ShizukuLocales`, self-check)
3. `checkShizukuLayout` in every module (folders / required files of the checkout exist; warns about a kind of source that the build file does not wire)
4. `:shizuku-shell:assembleRelease` -> `:shizuku:shizukuRishDex` (one `classes.dex` from the release APK -> `assets/rish_shizuku.dex`, generated folder registered through the Variant API)
5. the normal AGP tasks (resources, AIDL, Kotlin / Java, CMake for `libshizuku.so`, `libadb.so`, `librish.so`, packaging)

**What the switches do:**
| Switch | Default | Effect |
|---|---|---|
| `includeShizuku` (`-P`, `gradle.properties`, `ORG_GRADLE_PROJECT_includeShizuku`) | **false** | read in `settings.gradle.kts` only; true = the 11 projects exist; `:app` then depends on `:shizuku`, excludes the Rikka AppCompat fork, does not pack `META-INF/versions/**`; the root build file substitutes the four Maven `dev.rikka.shizuku:*` artifacts. False = no plugin resolved, no module, no change of any other build file's result |
| `shizukuAbis` (`-P`, comma list) | all four ABIs | ABIs of `libshizuku.so`, `libadb.so`, `librish.so` (`:shizuku`, `:shizuku-rish`); the APK filter stays the existing `apkAbis` |
| `SHIZUKU_FORCE_PATCH=1`, `SHIZUKU_HOST_PACKAGE`, `--host-package` | unset | patch script: force a re-patch / override the host package read from `app/build.gradle.kts` |

**Which file does what (Gradle side):**
| File | Role |
|---|---|
| `settings.gradle.kts` | plugin versions (`refine` 4.4.0, `materialthemebuilder` 1.5.1), `includeShizuku`, the include list + project folders |
| `build.gradle.kts` (root) | dependency substitution of `dev.rikka.shizuku:{aidl,shared,api,provider}` -> local projects |
| `app/build.gradle.kts` | `shizukuIncluded`, dependency on `:shizuku`, fork exclusion, packaging precaution |
| `gradle.properties` | the two flags, documented (comments only) |
| `shizuku/build.gradle.kts` | the `:shizuku` library, fetch / patch / rish-dex tasks, theme builder, CMake |
| `shizuku/modules/*/build.gradle.kts` | the ten helper modules |
| `shizuku/modules/after-fetch.gradle.kts` | task ordering + `checkShizukuLayout` |
| `shizuku/consumer-rules.pro`, `modules/provider/consumer-rules.pro`, `modules/shell/proguard-rules.pro`, `modules/shell/src/main/AndroidManifest.xml` | keep rules / the minimal manifest of the dex-only application module |
| `shizuku/tools/check-gradle.py` | static check of all of the above (no Gradle needed) |

### Step 3 decisions, consolidated

(Details and reasons are in the sub-step section named in the last column.)
| # | Decision | Where |
|---|---|---|
| 1 | The build files are ours (in `shizuku/modules/`, `shizuku/build.gradle.kts`); they read the sources from `shizuku/upstream/` through source sets. Reason: `include(...)` is evaluated before the fetch runs | 3B, 3C |
| 2 | One Gradle project per upstream project, prefix `shizuku-`; needed for the substitution (a substitution needs a project to point at) and because `:shell` / `:rish` / `:manager` cannot be folded into one library | 3B |
| 3 | Plugin versions are a *lookup* in `pluginManagement`, not `apply false` in the root `plugins` block, so a plugin problem cannot break a build with the switch off | 3B |
| 4 | The switch is off by default and read in one place (`settings.gradle.kts`); `:app` and the root file test `findProject(...)`, so they cannot disagree with the include list | 3B, 3F |
| 5 | `ShizukuLocales` is generated by the patch script, because `autoresconfig` cannot run in a library; `materialthemebuilder` can and is applied | 3A, 3E |
| 6 | Refine plugin exactly in the modules whose sources call hidden APIs: `server-shared`, `starter`, `server`, `shell`, `:shizuku` | 3A, 3D |
| 7 | `:shizuku-shell` stays an application module; only its `classes.dex` is used (from the release APK, not from an AGP-internal folder) and it is delivered as `assets/rish_shizuku.dex` via the Variant API; it is never a dependency | 3C, 3E, 3F |
| 8 | The Rikka AppCompat fork is excluded in `:shizuku` and in `:app`; stock `androidx.appcompat` is used (visible effect: the settings icon is in the overflow menu) | "Decisions already taken" 1, 3E, 3F |
| 9 | The four Maven `dev.rikka.shizuku:*` artifacts are replaced by dependency substitution in the root build file, not by editing `mika/build.gradle.kts` (`mika/tools/check-manifest.py` needs those lines, the CI rename edits that file) | 3F |
| 10 | Library versions: upstream's, except lifecycle 2.9.0 -> 2.8.7 and coroutines 1.10.2 -> 1.9.0 (what the project already uses) | "Decisions already taken" 3 |
| 11 | No `versionCode` / `versionName` for the library (upstream's come from `git rev-list --count`, 1 in a shallow clone); only `:shizuku-shell` has them | "Decisions already taken" 6 |
| 12 | Native: project NDK (`ext.ndkVer`), CMake 3.22.1, `-DANDROID_STL=none`, Prefab `boringssl` + `cxx`; ABIs all four, `shizukuAbis` narrows | 3D, 3E |
| 13 | Keep rules ship as `consumer-rules.pro` (entry points looked up by name, `BinderContainer`, natives registered by class name); upstream's global R8 options are not copied | 3E |
| 14 | `/META-INF/versions/**` is not packed when Shizuku is in the build (BouncyCastle 1.70 duplicate multi-release files); not `resources.excludes += '**'` like upstream | 3F |
| 15 | `checkShizukuLayout` + `extra["shizukuWired"]` / `["shizukuIgnored"]` / `["shizukuRequired"]`: a wrong folder or a missing file stops the build with the module's name instead of a vague error | 3C, 3D |
| 16 | `tools/check-gradle.py` is the static safety net (structure, cross-references, namespaces, cycles, substitution map, switch default, `:shizuku-shell` use) and runs without Gradle | 3C - 3F |

### First CI run: what to look at

**Since step 8F the switch is on by default, so `-PincludeShizuku=true` below is no longer needed (it does no harm); the whole list for steps 3 - 8 is in "9A".** Nothing of step 3 has been built (no Maven / Google / JitPack / plugin portal / Gradle distribution here). Run these three, in this order; each one tests a bigger part of the Gradle side:
1. `./gradlew :shizuku:assembleDebug -PincludeShizuku=true -PshizukuAbis=arm64-v8a` — the eleven modules, both native libraries, the dex task (one ABI is enough for the first look and faster).
2. `./gradlew :app:dependencies -PincludeShizuku=true --configuration releaseRuntimeClasspath` — expect `dev.rikka.shizuku:api -> project :shizuku-api` and no `dev.rikka.rikkax.appcompat`.
3. `./gradlew :app:assembleDebug -PincludeShizuku=true` — the whole app. Since 4B-2 Mika's provider is removed by the build-type overlay, so the APK is expected to install with `:mika` in it; if it does not (`INSTALL_FAILED_CONFLICTING_PROVIDER`) or the merged manifest still holds `rikka.shizuku.ShizukuProvider`, the overlay did not work (fallback: way (iv) of 4B-1). Then run `python3 shizuku/tools/check-merged-manifest.py --variant debug` (4E; 17 rules). `-PincludeMika=false` has no clash.

| Symptom | Likely cause | Where to fix (one line) |
|---|---|---|
| script compile error, `variant.sources.assets` / `addGeneratedSourceDirectory` / `manifest.srcFile` / `consumerProguardFiles` | AGP DSL detail not exercised here | `shizuku/build.gradle.kts` (3E) |
| `checkShizukuLayout` stops: "no ... file although the build file wires ..." or a missing required file | upstream layout differs from the pinned v13.6.0 | the module's `extra["shizukuWired"]` / `["shizukuRequired"]` |
| "cannot find symbol" / "package ... does not exist" in one helper module | a dependency list differs from upstream | that module's `dependencies { }` (3C - 3E compared with the real sources, but not built) |
| CMake: Prefab package not found | package name / version of `boringssl` or `cxx` | `shizuku/build.gradle.kts` or `modules/rish/build.gradle.kts` |
| no `libshizuku.so` in the APK | AGP does not pack a CMake *executable* into a library | build it as a `SHARED` target or copy it with a task (open since 3E) |
| `mergeReleaseJavaResource`: "2 files found with path ..." | duplicate resource path in a new library | one more entry in `packaging.resources.excludes` of `:app` (the message names the path) |
| D8 duplicate class | a new library overlaps an existing one | exclusion in `:shizuku` / `:app`; the message names the class |
| `:mika`: "cannot find symbol" for a `rikka.shizuku.*` class | `api` / `implementation` split of `:shizuku-api` | `modules/api/build.gradle.kts` (3C) |
| script compile error in the root `build.gradle.kts` at the substitution | `project(localPath)` resolving in `dependencySubstitution` | root `build.gradle.kts` (3F) |
| `NoSuchMethodError` / `ClassNotFoundException` in a rikkax class at run time | an API that only the AppCompat fork has | substitute the fork project-wide (fallback of "Decisions already taken" 1) |
| other modules fail after a version lift (androidx.core 1.16.0, fragment 1.8.7, recyclerview 1.4.0, preference 1.2.1) | Gradle takes the highest version | pin it down in the module that fails, or in `:shizuku` |

If a run fails, send the log: each of these is a one-line change in a known file.

### Decisions already taken for 3C - 3F (found while reading upstream and the Rikka plugin sources; each ships in its own sub-step)

1. **The Rikka AppCompat fork is the biggest integration risk.** Upstream's manager depends on `dev.rikka.rikkax.appcompat:appcompat`, a *modified copy of AndroidX AppCompat with the same class names*, and removes `androidx.appcompat:appcompat` from its build (the fork's own README: "the original version of AppCompat needs to be removed"). Both in one APK = duplicate classes. Swapping the fork into the whole Win11 app would change AppCompat for every module (`:j2me` asks for androidx.appcompat **1.8.0**, `:seal` 1.7.0, all others 1.6.1). Decision: **exclude the fork** (in `:shizuku` and in `:app`) and let the manager use the project's stock `androidx.appcompat`. Evidence: the fork has 4 changes (no status guard under action modes, `SupportMenuInflater` accepts `android:` attributes, `setSupportActionBar` outside an Activity, `AlertDialog#setView` margins); the manager uses only standard AppCompat API (`AlertDialog`, `AppCompatDelegate`, `AppCompatResources`) and calls `setSupportActionBar` only inside activities; the one visible effect is `res/menu/sh_main.xml` (written with `android:showAsAction`): the settings icon will sit in the overflow menu instead of the action bar. To be checked on a device in step 10; fallback if something breaks: substitute the fork project-wide.
2. **`:shizuku-shell` stays an application module** (upstream does the same): R8 shrinks `ShizukuShellLoader` + hidden-API compat into one `classes.dex`; `:shizuku` copies it to `assets/rish_shizuku.dex` (task `shizukuRishDex`, own output folder; upstream wrote it into its source tree). Done in 3E; the dex is taken from the release APK, not from the AGP intermediates folder. `ShellTutorialActivity` looks for exactly that asset name. The module is not a dependency of `:app`, so its APK is never part of the Win11 APK.
3. **Library versions.** One version per library wins (the highest), so only real lifts matter: `androidx.lifecycle` upstream 2.9.0 -> **2.8.7** (what `:seal` already asks for, no new lift); `kotlinx-coroutines` 1.10.2 -> 1.9.0 (the root build file pins every coroutines artifact); everything else upstream's version. Newly added to the project: `dev.rikka.rikkax.*`, libsu 6.0.0 (JitPack, already a repository), hiddenapibypass 6.1, bcpkix-jdk15on 1.70, AppIconLoader 1.5.0, `dev.rikka.hidden:compat/stub` 4.4.0, boringssl 20250114, libcxx 27.0.12077973 (Prefab), gson 2.13.1. No clash found with the existing modules (checked all `build.gradle*` files).
4. **Native.** `libshizuku.so` (the starter, a CMake *executable* named like a library) and `libadb.so` (ADB pairing, BoringSSL) from upstream's `manager/src/main/jni/CMakeLists.txt`; `librish.so` from `api/rish`. Both with `-DANDROID_STL=none` and the Prefab package `libcxx`; the project's NDK (`ext.ndkVer`) and CMake 3.22.1 like `:ppsspp`; ABIs: all four like upstream, `-PshizukuAbis=arm64-v8a,...` narrows them. The extraction of `libshizuku.so` to disk needs `useLegacyPackaging = true`, which `:app` already has.
5. **Keep rules.** `:app` has `isMinifyEnabled = false`, so nothing is needed today; `:shizuku` still ships a `consumer-rules.pro` with the entry points that `app_process` looks up *by name* (`rikka.shizuku.server.ShizukuService.main`, `moe.shizuku.starter.ServiceStarter.main`, `moe.shizuku.manager.shell.Shell.main`) and the two hidden-API adapters. Not copied: upstream's global options (`-allowaccessmodification`, `-repackageclasses`, `-assumenosideeffects` on `Log.d` ...), which would change the whole app.
6. **Version.** Upstream's `versionCode` / `versionName` come from `git rev-list --count HEAD` (1 in a shallow clone). A library has none; the patched code does not read them (the manager shows the host app's version); only `:shizuku-shell` (an application) gets `versionCode 1` / `UPSTREAM_VERSION`.
7. **Duplicate-class guard (3F).** `:mika` keeps `dev.rikka.shizuku:api|provider:13.1.5`; the root build file will replace the four Maven artifacts (`aidl`, `shared`, `api`, `provider`) by our modules (same API version 13.1.5, pinned in `UPSTREAM_API_COMMIT`) when the switch is on. This was planned for step 7; it moves to 3F because the build fails without it as soon as `:app` depends on `:shizuku`. **Done in 3F** (a dependency substitution in the root build file, see "3F").
8. **Tasks.** `:shizuku:fetchShizukuUpstream` -> `:shizuku:patchShizukuUpstream` run before every task that reads the checkout: all `:shizuku*` modules apply `modules/after-fetch.gradle.kts` (3C), which hooks `preBuild` and the resource / manifest / AIDL / compile / native task families (same pattern as `:mika` and `:ppsspp`).

### Not checked here (3A - 3H)

No Gradle run is possible in this environment: Maven Central, Google Maven, JitPack and the Gradle plugin portal are not reachable, and the Gradle distribution cannot be downloaded. What was run: the patch script on the real v13.6.0 source (several times), the Kotlin syntax of `settings.gradle.kts`. 3E added a real Kotlin compile of the build scripts with stubbed plugins (see "Not verified in 3E"). 3F: Gradle's embedded compiler was not available this time, so the build scripts were parsed with tree-sitter Kotlin instead (a grammar check, no type check) plus `check-gradle.py` (see "3F"). 3H added no new tool (the same checks were run again on the whole project, see "3H"; the patch-script re-run needs a network and was not possible). The first CI run with `-PincludeShizuku=true` (`./gradlew :shizuku:assembleDebug -PincludeShizuku=true`, 3E is in the project now) is the first real test of the Gradle side; since 3F the same run with `:app:assembleDebug` also tests the `:app` / root side (substitution, fork exclusion, packaging).

## Step 2 — patch script (what is in `tools/`)

- `tools/patch-upstream.sh` (wrapper, bash + python3 + git) and `tools/patch-upstream.py` (the work). Run: `bash shizuku/tools/patch-upstream.sh` after `fetch-upstream.sh`; `--check` runs only the self-check.
- Nothing in `shizuku/upstream/` is hand-edited: the patch is re-done from the pinned checkout whenever the script or the host package changes (marker `shizuku/upstream/.win11-patched` = SHA-256 of script + host package;
  a different hash first puts the checkout back with `git checkout -f` + `git clean` in `upstream/` and `upstream/api/`; `SHIZUKU_FORCE_PATCH=1` forces it). Every edit asserts its anchor, so an upstream change fails the build with a clear message.
- The **host package** is read from `applicationId` in `app/build.gradle.kts` (override: `--host-package` / `SHIZUKU_HOST_PACKAGE`). The CI package rename runs before this script, so the new package name is followed without any change here (tested with another package name and back).

**Does a library need a different package name? — Two different things:**
- the Java / Kotlin package (`moe.shizuku.manager`) is the library *namespace* (where `R` and `databinding` are generated): **not renamed**, a library may keep it;
- the string `"moe.shizuku.privileged.api"` is a *run-time* package name (`pm path`, PackageManager lookups, binder extras, intent actions). At run time a library is the host app, `context.packageName` = `com.srizwan.win11`,
  so the code would look for an app that does not exist. These 9 places are replaced by the host package (same idea as `BuildConfig.APPLICATION_ID` in `:mika`). Permission names `moe.shizuku.manager.permission.API_V23` / `MANAGER` are also kept: every Shizuku client (Mika's manifest too) asks for exactly these.

What the script changes (all listed in `../NOTICE-Shizuku.md`):

| Part | Change |
|------|--------|
| A. host package | `server/ServerConstants.java`, `server/ShizukuService.java` (binder extra), `starter/ServiceStarter.java` (2), `shell/ShizukuShellLoader.java`, `manager/jni/starter.cpp` (`pm path`), `manager/ShizukuManagerProvider.kt`, `api/provider/ShizukuProvider.java` (2): 9 places in 7 files |
| B. code | `ShizukuApplication` (an `Application`) -> `object ShizukuApplication` with `onCreate(app: Application)`; `Context.application` -> `Application`; `BuildConfig.APPLICATION_ID` (2 uses, a library has none) -> host package |
| B. manifest | generated library manifest: no `<application>` attributes (name, icon, theme, backup, locale config ...), `MainActivity` without LAUNCHER filter and not exported (label set), every activity gets `@style/sh_AppTheme` itself; 9 activities |
| B. styles | 4 styles dropped from `values-v21/themes_override.xml`: `Base.ThemeOverlay.AppCompat.ActionBar`, `...Dark.ActionBar`, `Widget.MaterialComponents.CompoundButton.CheckBox` / `.RadioButton`. They override library styles *by name*: in an app that is the manager's own look, in a library it would restyle every AppCompat toolbar and Material check box / radio button of the whole Win11 app |
| C. resources | 237 names, 87 files: prefix `sh_` on files (drawable, layout, menu, mipmap, color, animator, xml) and value names (string, plurals, array, color, style, dimen, bool, integer) in all 70 locales; 215 `@type/name` references, 105 `R.type.name` references, 4 style parents; the 25 layouts' ViewBinding classes become `Sh...Binding` (68 uses). Dotted style names keep their inheritance (`sh_Card.Light` still extends `sh_Card`; the script writes an explicit parent if an implicit parent would not be ours). Kept: ids, the 2 attrs (`homeCardStyle`, `appColorPrimary`: Shizuku-specific, checked against the whole project), Rikka library resources (`rd_*`, `Theme.Material3.*.Rikka`) |
| D. self-check | XML well-formed; no old name left; every `R.*` / `@type/` reference defined; no `BuildConfig`; the old package string only in `manager/build.gradle` (not used); no LAUNCHER filter; `ShizukuApplication` not a class |

Result on v13.6.0: 96 files modified, 87 renamed, 88 new names; run twice (second run: "already patched"), forced re-patch, package change and back: all fine. Not compiled here (no SDK / network for Gradle): CI does that from step 3 on.

**Update from 5C:** the table above and the counts of this section are what step 2 measured. Since 5C part A keeps the binder extra key (`moe.shizuku.privileged.api.intent.extra.BINDER`, 4 of the 9 uses of the old name) and writes the host package in **5 places in 5 files** (+2 `BuildConfig.APPLICATION_ID` = 7 in 7); see "5C" and finding 15.

**Update from 5D:** the self-check (part D) has one more rule group, `check_intent_actions()`: the patch makes no new edit for it (the intent actions needed none, see "5D"); it fails when the server stops building the permission action from the host package, when a custom manifest action sits on other components than expected or names a package literally, when the `REQUEST_BINDER` literal or the shell loader's `setPackage(<host>)` is gone, or when the sources get an action-looking string literal nobody decided on.

**Update from 5E and 5F:** two parts were added after step 2: part F (5E, `patch_pairing_service`: the two `onTimeout` overrides of `AdbPairingService`) and part G (5F, `patch_direct_boot`: `android:directBootAware` removed from `BootCompleteReceiver`, `ShizukuReceiver` and `ShizukuManagerProvider`, the `LOCKED_BOOT_COMPLETED` filter removed from the receiver; finding 12); the self-check has `check_pairing_timeout` and `check_direct_boot` for them. See "5E" and "5F".

**Carried over to the next steps** (found while writing the script):
1. *Step 3:* `rikka.shizuku.manager.ShizukuLocales` (used by `SettingsFragment`) and the styles `Theme.Material3.Light|Dark.Shizuku` come from Rikka's Gradle plugins (`autoresconfig`, `materialthemebuilder`, config in upstream's `manager/build.gradle`): either apply them to the library (if they support one) or generate the same two things ourselves (a 2-array Kotlin file, one theme builder block). **Answered in 3A / 3B:** `materialthemebuilder` supports libraries (applied in 3E); `autoresconfig` does not, so `ShizukuLocales` is generated by the patch script (part E). Also: BuildConfig is not needed any more, `libshizuku.so` / `libadb.so` CMake build, version without git count, `:shell` output (rish) as asset.
2. *Step 4:* provider authority `${applicationId}.shizuku` (manager `ShizukuManagerProvider`, a subclass of `ShizukuProvider`) vs Mika's `rikka.shizuku.ShizukuProvider`: keep the subclass only. `uses-permission API_V23 tools:node="remove"` in the manager manifest must win over the clients' request: check priority in the merged manifest.
3. *Step 6:* the host `Application` (`AppBase`) must call `ShizukuApplication.onCreate(this)` once; the "without Mika" stub of `AppBase` too (`mika/tools/stub/`). `init` of the object (libsu default builder, `HiddenApiBypass.setHiddenApiExemptions("")`, `System.loadLibrary("adb")`) now runs in the Win11 process; no other module of this project uses libsu or HiddenApiBypass from its own sources.
4. *Step 7 (moved to 3F, **done in 3F**):* `:mika` uses the Maven classes `dev.rikka.shizuku:api|provider:13.1.5` (unpatched package string, same class names as our patched `api/`): both on the class path = duplicate classes. Use Gradle dependency substitution to the local patched modules (same API version 13.1.5).
5. *Step 10:* run-time check at targetSdk 37 (foreground service of the ADB pairing, notifications).

## Step 1 — what was done

New files only (no existing Kotlin / Java / Gradle / manifest file is changed):
- `UPSTREAM_VERSION` (`v13.6.0`), `UPSTREAM_COMMIT` (`2650830c5b099ae0dd34fedf614d4f592ca05d65`), `UPSTREAM_API_COMMIT` (`510fc988c02c3475d8c25db170f96792f105bdf8`)
- `tools/fetch-upstream.sh`: shallow-clones the tag into `shizuku/upstream/`, then fetches the API commit into `shizuku/upstream/api/` (upstream lists that submodule with an
  ssh URL, so it is fetched by hand over https). Fails if the tag or commit differs from the pin; does nothing when the right commits are already there. Tested: first run, second run (skip).
- `../LICENSE-Shizuku` (Apache-2.0), `../LICENSE-Shizuku-API` (MIT), `../NOTICE-Shizuku.md`, `../.gitignore` (`shizuku/upstream/`), `../docs/CHANGES-shizuku-part1.md`, section in `../README.md`.

## Step 1 — analysis of v13.6.0 (what the next steps depend on)

Size and layout: the fetched tree is about 4 MB (manager 2.0 MB, server, starter, shell, common; `api/` = aidl, api, provider, rish, server-shared, shared, hidden-api-stub).
Upstream is a normal Gradle build (AGP 8.10.0, Kotlin 2.1.21, compileSdk 36, minSdk 24, NDK 29.0.13113456, Java 21) with its own version catalog and plugins:
`dev.rikka.tools.refine`, `autoresconfig`, `materialthemebuilder`. Our project: compileSdk 37, minSdk 26, so minSdk is no problem.

1. **Manager = application module.** `:manager` has `applicationId "moe.shizuku.privileged.api"`, Kotlin + View binding, minify + shrink resources, its own signing config (`signing.gradle`), a CMake build (`manager/src/main/jni`: `starter.cpp`, `adb_pairing.cpp`, `selinux.cpp`, `cgroup.cpp`, ... -> `libshizuku.so`, needs prefab `io.github.vvb2060.ndk:boringssl` + `org.lsposed.libcxx`) and depends on `:server`, `:rish`, `:starter`, `:api`, `:provider`, `:shell` (`:shell` is built first, its output goes into the APK).
   It has to become a library like `:ppsspp` / `:camera` (step 2 + 3). Upstream's `versionCode` / `versionName` come from `git rev-list --count HEAD`, which is `1` in a shallow clone, so the module must not use that logic.
2. **The manager package name is hard-coded in 9 places** (server, starter, shell, native, API provider), checked with grep on the fetched tree:
   - `server/.../ServerConstants.java` (`MANAGER_APPLICATION_ID`, `REQUEST_PERMISSION_ACTION`) and `ShizukuService.java` (uses it to find the manager, grant it permissions, send it the binder, decide `isManager`),
   - `starter/.../ServiceStarter.java` (`EXTRA_BINDER`, `packageName`), `shell/.../ShizukuShellLoader.java` (`setPackage`),
   - `manager/src/main/jni/starter.cpp` (`#define PACKAGE_NAME`), `manager/.../ShizukuManagerProvider.kt` (`EXTRA_BINDER`),
   - `api/provider/.../ShizukuProvider.java` (`MANAGER_APPLICATION_ID`, `EXTRA_BINDER`): this is the **same class `:mika` already uses** from the Maven artifact `dev.rikka.shizuku:provider:13.1.5`.
   Inside Win11 the manager runs as `com.srizwan.win11`, so these strings must become the host package (step 5). Decision for step 5: patch with a script at build time (like `mika/tools/patch-upstream.py`), not by hand-editing a copy, so a later upstream bump is one pin change.
3. **Clash with `:mika` (step 4 / 7).** Upstream's manager declares `ShizukuManagerProvider` with authority `${applicationId}.shizuku`; Mika's merged manifest has `rikka.shizuku.ShizukuProvider` with authority `${applicationId}.shizuku` too. Both would become `com.srizwan.win11.shizuku`:
   a real manifest error, so one of them has to go (or get another authority). The permission `moe.shizuku.manager.permission.API_V23` (dangerous) is declared by the manager and requested by every client including `:mika`;
   once the manager is built in, the host app owns it, which is what makes the client side work without a separate Shizuku APK. `moe.shizuku.manager.permission.MANAGER` (signature) is declared too.
4. **Manifest content to merge:** 7 activities (`MainActivity`, app management, ADB pairing tutorial, terminal tutorial, settings, starter, request-permission + 2 legacy ones), `AdbPairingService` (foreground, `shortService`), `BootCompleteReceiver` (auto-start after boot, root), `ShizukuReceiver`, the provider,
   permissions `RECEIVE_BOOT_COMPLETED`, `FOREGROUND_SERVICE`, `INTERNET`, `POST_NOTIFICATIONS`, `WRITE_SECURE_SETTINGS`; `MainActivity` has the LAUNCHER filter, which has to be removed (the Start menu hook starts it instead), `android:name=".ShizukuApplication"` must go (`:app` has its own Application; its init code moves into the launcher, step 6).
5. **Dependencies the manager needs and `:app` may not have yet** (checked in step 3 against `app/build.gradle.kts`): `dev.rikka.rikkax.*` (appcompat, material, preference, recyclerview, insets, ...), `com.github.topjohnwu.libsu:core:6.0.0` (JitPack; `settings.gradle.kts` already has `jitpack.io`),
   `org.lsposed.hiddenapibypass:6.1`, `org.bouncycastle:bcpkix-jdk15on:1.70` (check against `:Bcore`), `me.zhanghai.android.appiconloader`, `dev.rikka.hidden:compat/stub 4.4.0`, `dev.rikka.tools.refine 4.4.0` (Gradle plugin), boringssl + libcxx (native). Version clashes with other modules are step 3's job.
6. **targetSdk.** `:app` targets 37 since Mika part 8; upstream targets 36, so the manager code (foreground services, notification permission, ADB pairing service) needs a runtime check at 37 in step 10; it cannot be run here (no network / emulator).
7. **Licences.** Shizuku: Apache-2.0; Shizuku-API: MIT (own `LICENSE`). Both are kept as `LICENSE-Shizuku` / `LICENSE-Shizuku-API`. Libraries used by the manager have their own licences (Apache-2.0 for rikkax / libsu / hiddenapibypass / bouncycastle MIT-style); listed in step 9.
8. **Not in scope of this module:** Shizuku's own Play Store logic, the sample app and the Magisk starter (not present in v13.6.0 anymore).

Open points for later steps:
- Whether the **server** (the process started by ADB/root, class `rikka.shizuku.server.ShizukuService`) can keep running from the host APK path: the starter script uses `app_process` with the APK path (`moe.shizuku.starter.ServiceStarter`), so `starter` + `server` classes must stay in the host's `base.apk` (they will, as library dependencies).
- Auto-start on boot (`BootCompleteReceiver`) and the notification channel: needs the host's `POST_NOTIFICATIONS` handling (step 6).
- Local build needs `git` + network once (about 4 MB); there is no offline fallback beyond putting the files into `shizuku/upstream/` by hand.


## 6A — `ShizukuLauncher.kt` (Step 6, hook 1 of 5)

Request: 6A, keep all details, update the full flat zip. Based on `RizwanS2-main-shizuku-step5g.zip`.

**New file:** `app/src/main/kotlin/com/srizwan/win11/ShizukuLauncher.kt` (the only new source file; nothing calls it yet, that is 6B - 6E).

| Member | What it does |
|---|---|
| `SECTION = "shizuku"` | Section name for the Start menu entry (class `builtin.shizuku`), Home icon and taskbar callback, same role as `MikaLauncher.SECTION` |
| `NAME = "Shizuku"` | Label for Start menu, Home icon and toasts |
| `isAvailable(ctx)` | true only when `Class.forName("moe.shizuku.manager.MainActivity")` works **and** `getActivityInfo` finds it in the installed merged manifest; never throws. 6B-2 / 6C use it to hide the entry and the icon when `:shizuku` is not in the build |
| `open(ctx)` | Starts the manager's `MainActivity` by `ComponentName`; returns false and shows a short toast when not included or on failure; never throws; logs through `AppLog` |

**Decisions**
1. **Reflection, no compile-time reference.** `:app` depends on `:shizuku` only when `shizukuIncluded` is true (`app/build.gradle.kts`). A direct `moe.shizuku.manager.MainActivity::class.java` would break every default build. A class-name string keeps the default build identical to before; no stub file needed (unlike Mika's "without Rizwan" build). Cost: the name is a run-time string; the keep rules in `shizuku/consumer-rules.pro` do not list `MainActivity`, which is fine while `:app` has `isMinifyEnabled = false`, but **step 10A must note: when R8 is turned on, add a keep rule for this class name**.
2. **Task / process (finding 9, closed).** Plain `startActivity`, no `FLAG_ACTIVITY_NEW_TASK` when the context is an `Activity` (all hooks are clicks or deep links from `MainActivity`), so Back returns to the Win11 screen. `FLAG_ACTIVITY_NEW_TASK` is added only for a non-Activity context, where Android requires it.
3. **No exported surface.** `MainActivity` is not exported (4D-1) and has no LAUNCHER filter, so only this app can start it and no second icon appears.
4. **Class name unchanged by the patch.** The patch script changes host package strings and the resource prefix, not the package `moe.shizuku.manager` (found in `patch-upstream.py` part B: `.MainActivity` is the manifest name, Java source).

**Checked here:** read the sibling launchers (`SealLauncher.kt`, `MikaLauncher.kt`) for the same shape and `AppLog.i / e` signatures. **Not verified:** no Kotlin compile (Gradle cannot run here), no device test, never built with `-PincludeShizuku=true`; the first CI run will compile it.

**Next:** 6B-1 (read how "All apps" and `rizwans2://N` are built, docs only), then 6B-2, 6C, 6D, 6E.


## 6B-1 — The "All apps" list and the numbered links (docs only)

Request: 6B-1, keep all details, update the full flat zip. Based on `RizwanS2-main-shizuku-step6a.zip`. **No code changed**; read from `StartApps.kt`, `Win11Shell.kt`, `MainActivity.kt`, `TerminalShare.kt` and the `:app` manifest.

**How the list is built**
1. `AppRepo.query()` (`StartApps.kt`) takes every launcher activity of other packages, adds `builtInApps()` (the list of built-in entries: Files, Browser, Messages, Calculator, Parallel, YouTube, Video, Gallery, Camera, J2ME, PPSSPP, Downloader, then Winlator / MAME / RetroArch / Rizwan only where supported), removes duplicates by `pkg/cls` and sorts by label.
2. A built-in entry is an `AppEntry(label, ctx.packageName, "builtin.<name>", BuiltInIconDrawable(...), section = "<name>")`. A non-null `section` makes it a built-in: `Win11Shell.launchApp` calls `onNavigate(section)` and `MainActivity`'s taskbar callback maps the section name to the launcher (`MikaLauncher.open(this)`, `openSeal()` and so on; a name it does not know falls to `switchToSection`).
3. The screen list: `Win11Shell.allAppsInOrder()` = `appRepo.visibleApps()` (hidden apps left out) sorted by first letter (the "#" group first, then A - Z), then by label, case-insensitive.

**How `rizwans2://N` maps to a position**
- `MainActivity.deepLinkNumber(uri)` accepts `rizwans2://3`, `rizwans2://#3` and `rizwans2://app/3` (digits only, at most 6).
- `launchAppNumber(n)` calls `shell.allAppsInOrder()` (the same function as the screen) and opens `list[n - 1]` through `shell.launchApp`; out of range logs and does nothing; an empty list on a cold start loads the apps once and retries.
- `handleDeepLink` tests the number **first**, then the names (`files`, `seal`, `rizwan` ...). A new name `shizuku` (6D) cannot clash: it is not digits, `app` is the only other host with a path.

**Answer to the row: does a new item change existing numbers?**
- **Yes, for the apps after it.** The numbers are positions in the A - Z list as shown on screen. An entry "Shizuku" lands in group S, after every label that sorts before `shizuku` (for example "Seal" does not exist: the downloader is "Downloader", under D; a phone app "Settings" sorts before it). Every app after "Shizuku" (later S labels, T - Z such as Video, Winlator, YouTube, and device apps there) moves **+1**; everything before it keeps its number.
- **Only where the entry is shown.** With `:shizuku` out of the build (the default until 8F) nothing is added and no number changes.
- **Numbers were never fixed.** Installing, uninstalling, hiding or unhiding any app already moves them; the contract in `MainActivity` and the manifest comment is "as shown on screen". So 6B-2 keeps the normal alphabetical placement and does **not** add a special slot or a second list; the shift is documented here and in the 6B-2 row.

**Other places a built-in entry touches (for 6B-2 - 6D)**
| Place | Finding |
|---|---|
| `defaultPins()` in `StartApps.kt` | only used once, to clear old auto-seeded pins; it names fixed sections and a package list, then fills from the start of the sorted list up to 12. A new S entry is not auto-pinned (read, not run) |
| Taskbar callback in `MainActivity.buildUi` | needs one branch `section == ShizukuLauncher.SECTION` -> `ShizukuLauncher.open(this)` (6B-2) |
| `TerminalShare.builtInList()` (the terminal theme's `builtin` list, opens `rizwans2://<name>`) | has every other built-in; a `shizuku` line needs the deep link of 6D first (decision for 6B-2 / 6D: add it with the same `isAvailable` test) |
| `Win11Shell` section constants and `desktopIcon` | Home icon, row 6C |
| `:app` manifest comment (line ~151) and `MainActivity.handleDeepLink` doc | list of deep-link names, extended in 6D |
| `ShizukuLauncher.isAvailable(ctx)` | the one test for "shown only when `:shizuku` is in the build" (it needs a `Context`; `builtInApps()` has `ctx`) |

**Not verified:** nothing was run (no Gradle, no device); the A - Z order is read from `allAppsInOrder()`, not tested on a phone.

**Next:** 6B-2 (the entry, the taskbar branch, `TerminalShare` decision).

## 6B-2 — "Shizuku" item in the Start menu list (Step 6, hook 2 of 5)

Request: 6B-2, keep all details, update the full flat zip. Based on `RizwanS2-main-shizuku-step6b1.zip`.

Result: with `:shizuku` in the build, "Shizuku" shows in "All apps" (and in search) and opens the manager. With the flag off (default until 8F) nothing is added and the app behaves exactly as before.

**Code changed (two files)**
| File | Change |
|---|---|
| `app/src/main/kotlin/com/srizwan/win11/StartApps.kt` | new `BUILTIN_CLS_SHIZUKU = "builtin.shizuku"` and `SHIZUKU_PATH` (shield with a hollow check mark, even-odd fill, same style as the other vector icons). `builtInApps()` gets one more `+ ( if (ShizukuLauncher.isAvailable(ctx)) listOf(AppEntry(ShizukuLauncher.NAME, ctx.packageName, BUILTIN_CLS_SHIZUKU, BuiltInIconDrawable(SHIZUKU_PATH, #5C7CFA, evenOdd = true), section = ShizukuLauncher.SECTION)) else emptyList() )` after the Rizwan block |
| `app/src/main/kotlin/com/srizwan/win11/MainActivity.kt` | taskbar callback: `else if (section == ShizukuLauncher.SECTION) { ShizukuLauncher.open(this) }`, placed right after the Rizwan branch and before `parallel` / the `switchToSection` fallback |

**Decisions**
1. **Shown only when available.** The one test is `ShizukuLauncher.isAvailable(ctx)` (class found by name **and** activity in the installed merged manifest). `:shizuku` out of the build -> no entry, no icon, no number change.
2. **Numbers.** As written in 6B-1: no special slot, the entry takes its normal alphabetical place (group S, label "Shizuku"). Every app after it moves +1, only where it is shown. The entry key is `<app package>/builtin.shizuku`.
3. **Not auto-pinned, not hidden.** `defaultPins()` is untouched. A user can pin / hide it like any built-in; a pinned key whose entry is missing (flag off) is simply skipped by `pinned()`.
4. **Opening.** Click -> `Win11Shell.launchApp` -> `onNavigate("shizuku")` -> `ShizukuLauncher.open(this)` from `MainActivity`: plain `startActivity`, Back returns to the Win11 screen (finding 9, 6A). Not available / failed start -> short toast, no crash.
5. **`TerminalShare.builtInList()` left alone on purpose.** Its `builtin` list opens `rizwans2://<name>`; the name `shizuku` does not exist until 6D, so a line now would be a dead entry. 6D adds the deep link and the `TerminalShare` line together (same `isAvailable` test).
6. **Icon.** Vector only, like the other built-ins (Shizuku's own logo is not used). The Home screen icon is 6C.

**Not touched:** `ShizukuLauncher.kt`, `Win11Shell.kt`, manifest, Gradle, workflows, patch scripts, `TerminalShare.kt`, the other built-in entries.

**Not verified.** No Kotlin compile, no Gradle build, no device (no network here): the new code uses only names already in the file (`AppEntry`, `BuiltInIconDrawable`, `Color`, `ctx`) and `ShizukuLauncher` from the same package; the icon path was written by hand and not rendered; the A - Z place was read from `allAppsInOrder()`, not seen on a phone.

**Next:** 6C (Home screen icon: `VectorIconView.SHIZUKU` type + `desktopIcon` line guarded by `isAvailable`).

## 6C — Home screen icon (Step 6, hook 3 of 5)

Request: 6C, keep all details, update the full flat zip. Based on `RizwanS2-main-shizuku-step6b2.zip`.

Result: with `:shizuku` in the build, the Win11 Home screen shows a "Shizuku" icon that opens the manager. Flag off (default until 8F): no icon, nothing changes.

**Code changed (one file): `app/src/main/kotlin/com/srizwan/win11/Win11Shell.kt`**
| Spot | Change |
|---|---|
| `VectorIconView` constants | `const val SHIZUKU = "shizuku"` |
| `data(type)` | path for `SHIZUKU` = the same shield with a hollow check mark as the Start menu entry (6B-2) |
| `colorFor(type)` | `SHIZUKU -> #5C7CFA` (same colour as the Start menu entry) |
| `init` | `SHIZUKU` gets `Path.FillType.EVEN_ODD` (hollow check mark) |
| `buildDesktop()` | `if (ShizukuLauncher.isAvailable(ctx)) column.addView(desktopIcon(VectorIconView.SHIZUKU, ShizukuLauncher.NAME, ShizukuLauncher.SECTION))`, placed after the Rizwan icon, before Winlator |

**Decisions**
1. Drawable only: no new permission, no manifest change, no image resource.
2. Click -> `desktopIcon` -> `onNavigate("shizuku")` -> the taskbar branch added in 6B-2 -> `ShizukuLauncher.open(this)`. No new click code.
3. Same `isAvailable(ctx)` test as the Start menu, so the icon and the list entry always appear together. The desktop column already scrolls, so one more icon fits on short screens.
4. The icon is built once in `buildDesktop()`; the test is evaluated then (class and manifest are fixed for an installed build).

**Not touched:** `ShizukuLauncher.kt`, `StartApps.kt`, `MainActivity.kt`, `TerminalShare.kt`, manifest, Gradle, workflows, patch scripts.

**Not verified.** No Kotlin compile, no Gradle build, no device; icon not rendered.

**Next:** 6D (deep link `rizwans2://shizuku`, plus the `TerminalShare` line left from 6B-2).

## 6D — deep link `rizwans2://shizuku` (Step 6, hook 4 of 5)

Request: 6D, keep all details, update the full flat zip. Based on `RizwanS2-main-shizuku-step6c.zip`.

Result: `rizwans2://shizuku` opens the Shizuku manager. The terminal theme's `builtin` list gets its Shizuku line (left open in 6B-2).

**Code changed**
| File | Change |
|---|---|
| `MainActivity.kt` | `handleDeepLink`: new branch `"shizuku" -> ShizukuLauncher.open(this)` after `rizwan` / `assistant`; the doc comment of the function lists `shizuku` |
| `TerminalShare.kt` | `builtInList()`: `if (ShizukuLauncher.isAvailable(app)) add(BuiltIn(ShizukuLauncher.SECTION, ShizukuLauncher.NAME, "builtin.shizuku"))` after Rizwan; header comment names Shizuku next to the other deep-link screens |
| `app/src/main/AndroidManifest.xml` | **comment only** (the list of deep-link names above the filter); no element or attribute changed |

**Decisions**
1. **No new manifest filter.** The existing filter is scheme-only (`<data android:scheme="rizwans2" />`), so `rizwans2://shizuku` already reaches `MainActivity`. No new exported component, no merged-manifest rule affected.
2. **No clash with numbers.** `handleDeepLink` tests `deepLinkNumber(uri)` first; `shizuku` is not digits and not `app`/`#N` (6B-1).
3. **Flag off.** The branch still exists; `ShizukuLauncher.open` shows the toast "Shizuku is not included in this build" and does nothing else. The `TerminalShare` line uses the same `isAvailable` test as the Start menu and Home icon, so it is absent then.
4. **Terminal theme.** The `builtin` command opens `rizwans2://shizuku` as an explicit start of `MainActivity` (like the other screens of `MainActivity`), so Back returns as for Rizwan / Downloader. Pin / hide keys use `<app package>/builtin.shizuku`, the same key the Start menu entry has (6B-2).
5. Exposure: anyone who can send `rizwans2://shizuku` (another app, a web page) can only open the manager's start screen, which asks for nothing and changes nothing by itself; same as the other names.

**Not touched:** `ShizukuLauncher.kt`, `StartApps.kt`, `Win11Shell.kt`, Gradle, workflows, patch scripts.

**Not verified.** No compile, no Gradle build, no device; the checker for the merged manifest was not re-run (a comment changed, no element).

**Next:** 6E (`ShizukuApplication.onCreate(this)` in `AppBase` with the guard, finding 13).

## 6E — init call `ShizukuApplication.onCreate(app)` (Step 6, hook 5 of 5)

Request: 6E, keep all details, update the full flat zip. Based on `RizwanS2-main-shizuku-step6d.zip`.

Result: the one call that finding 13 demands exists. With `:shizuku` in the build, the launcher process runs upstream's `Application.onCreate` work (`application`, `ShizukuSettings.initialize`, locale) once, at the spot fixed in 4D-4. With `:shizuku` out of the build nothing happens.

**Code changed**
| File | Change |
|---|---|
| `ShizukuLauncher.kt` | new `fun initApplication(app: Application): Boolean`; constant `MANAGER_APPLICATION = "moe.shizuku.manager.ShizukuApplication"`; `@Volatile initDone`; header comment (6E is here now) |
| `App.kt` | one `try { ShizukuLauncher.initApplication(this) } catch (e: Throwable) { AppLog.e("App", "Shizuku init failed", e) }` in `onCreate`, **after** the `AppLog.i("App", "process start ...")` line and **before** the Seal block; class comment names it |

**How it works.** `Class.forName(MANAGER_APPLICATION)`, then `getMethod("onCreate", Application::class.java).invoke(null, app)`. This is a static call because the patched `object ShizukuApplication` declares `@JvmStatic fun onCreate(app: Application)` (patch-upstream.py, part B). Loading the class runs the object's `init` (libsu builder, `HiddenApiBypass`, `System.loadLibrary("adb")` on API 30+); an `Error` from it is caught as `Throwable` and logged with its cause.

**Decisions**
1. **Guard = the class is there**, not a `BuildConfig` flag. The plan row named a flag set from `shizukuIncluded`, but `:app` has no `buildConfigField` and `:app` names no Shizuku class at compile time (decision of 6A). A direct call would not compile with `:shizuku` out of the build; a flag would still need the reflection. `ClassNotFoundException` = "not in this build" = return false, silently (no log line on every start of a normal build).
2. **Not in `AppBase`, in `App.onCreate`.** The row's title said `AppBase`, its placement text said `App.onCreate` (4D-4). The second wins: `UltimateBuild_WithoutMe.yml` replaces `AppBase.kt` with `mika/tools/stub/AppBase.kt.stub`, so a call there would vanish in that build while `:shizuku` is still in it, and the boot receiver would throw at every boot (finding 13). `ShizukuLauncher.kt` is not replaced by any workflow. The stub needs no change.
3. **Spot** (4D-4, unchanged): launcher process only (after `if (!isLauncherProcess()) return`), after `AppLog` is ready, before Seal; `startMikaIfUsed()` stays last. No Shizuku component has `android:process`, so the other processes never need it; the provider and `ShizukuReceiver` do not read `ShizukuSettings` or `application` (checked in 4D-4), so running after providers is early enough.
4. **Once.** `initDone` is set only after a successful call; a failed call may be tried again by a later caller, a successful one is not repeated. `App.onCreate` runs once per process anyway.
5. **Never throws, never blocks the launcher.** Both lookups and the invoke are in `try`; `InvocationTargetException` is unwrapped (`e.cause ?: e`) for the log. Main thread, small work (a few preference reads and one library load).
6. **Order for 8F.** Finding 13 asked that the default switch is not flipped before this call exists. It exists now; 8F still also waits for 8D.

**Not touched:** `AppBase.kt`, the stub, Gradle, workflows, manifests, patch scripts, `StartApps.kt`, `Win11Shell.kt`, `MainActivity.kt`.

**Not verified.** No compile, no Gradle build, no device. The reflection target (`@JvmStatic onCreate(Application)` of `moe.shizuku.manager.ShizukuApplication`) is read from the template in `patch-upstream.py` and from the 5G-checked patch, not from a built class; the first CI run with the switch on shows it (a missing method would appear as `Shizuku init failed` in the app log). R8: `isMinifyEnabled = false` for the release build of `:app` today, so nothing renames or removes the class or method; if minify is ever switched on, `consumer-rules.pro` of `:shizuku` must keep `moe.shizuku.manager.ShizukuApplication.onCreate` (the call is by name).

(Row 7A-1 was split; 7A-1.1 is below.)


## 7A-1.1 — `<queries>` entry: Mika's patch script (Step 7, row 1 of 7)

Request: 7A-1 split into 7A-1.1 / 7A-1.2, do 7A-1.1, keep all details, updated full flat zip (`RizwanS2-main-shizuku-step7a1-1.zip`). Based on `RizwanS2-main-shizuku-step6e.zip`.

**Result.** With `:shizuku` in the build, Mika's one `<queries><package android:name="moe.shizuku.privileged.api"/>` entry (the *external* Shizuku app, finding 7) is written as `<package android:name="${applicationId}"/>` by Mika's patch script, so the merged manifest names the host package (`com.srizwan.win11`, or whatever the rename gives). Without `:shizuku` the stock name stays. Nothing else of `<queries>` is touched.

| File | Change |
|---|---|
| `mika/tools/patch-upstream.py` | new part 15: `SHIZUKU_BUILTIN` (env `MIKA_SHIZUKU_BUILTIN`, `1` = manager built in, unset / `0` = not), `patch_shizuku_queries()`, `check_shizuku_queries()` (called from `check()`), one result key in `main()`, the switch added to the stamp, header item 15 |
| `mika/build.gradle.kts` | `patchMikaUpstream`: `environment("MIKA_SHIZUKU_BUILTIN", if (rootProject.findProject(":shizuku") != null) "1" else "0")` |
| `mika/tools/patch-upstream.sh` | header comment only |
| `mika/tools/check-manifest.py` | check 13: exactly one Shizuku package entry; `1` = host spelling, `0` = stock spelling, unset = either (never both, never none) |
| `shizuku/README.md`, `README.md`, `mika/README.md`, `docs/CHANGES-shizuku-part7a1-1.md` | plan rows, notes, state line |

**Decisions**
1. **Two-way patch.** Input accepts both spellings and the output depends only on the switch, so a checkout patched without the manager (the workflows run `bash mika/tools/patch-upstream.sh` with no variable today) is patched again, to the host name, when Gradle runs with `:shizuku` in the build, and back. A second run with the same switch changes nothing.
2. **The switch is part of the stamp** (`shizuku-builtin=0|1`); without that a cached checkout would keep the wrong spelling. The workflow cache key hashes `patch-upstream.py`, which changed, so the old cached checkouts are not reused.
3. **Signal = the project test**, not the property (same rule as `app/build.gradle.kts`, 3F), so the property and the build cannot disagree.
4. **`${applicationId}`, not the literal `com.srizwan.win11`**: the package rename of the workflows (`new_package_name`) must not leave a stale name. The placeholder is already used in this manifest (`AFFINITY`) and `check-merged-manifest.py` resolves it.
5. **Strict input.** Exactly one entry of either spelling must be found; none, two, or a longer name (`...api.x`) is `::error::` (upstream layout drift), as the other patch parts do.
6. **Kept although redundant:** an app can always see its own package, so with the manager built in the entry no longer changes anything at run time. It is kept (not removed) as the plan row says, so that the stale string is gone and the checker rule `4E-4b stale package` can drop its exception in 7A-1.2.

**Tried here (hand-made manifest, not the real upstream):** 13 cases, all as expected: switch 0 on the stock entry (0 changes); switch 1 (entry -> `${applicationId}`, no `moe.shizuku` left); second run (0 changes); back to 0 (byte-identical to the original); other `<queries>` content untouched; stamp differs by switch and unset equals 0; no entry, two entries, stock + host together, a longer name (all `::error::`); `check_shizuku_queries()` fails on the wrong spelling. `py_compile` OK for both scripts; `python3 -I shizuku/tools/check-all.py` ok (4 ran, S5 - S7 skipped, no fetched sources / build); `python3 -I mika/tools/static-check.py` all checks passed. Check 13 of `check-manifest.py` was tried as logic on 8 combinations only, not on a fetched checkout.

**Not verified.** The real Mika manifest (no network here): that the entry reads exactly `<package android:name="moe.shizuku.privileged.api" />` in the pinned commit (4E-4b read it that way, `patch_shizuku_queries` errors out loudly if not); that the manifest merger resolves `${applicationId}` inside `<queries><package>` (it resolves it in any attribute; S7 shows it on the first CI run). No Gradle build, no device.

**Next:** 7A-1.2 (done, see below).

## 7A-1.2 — `<queries>` entry: the checker (Step 7, row 2 of 7)

Request: do 7A-1.2, keep all details, updated full flat zip (`RizwanS2-main-shizuku-step7a1-2.zip`). Based on `RizwanS2-main-shizuku-step7a1-1.zip`.

**Result.** The rule `4E-4b stale package` of `shizuku/tools/check-merged-manifest.py` no longer allows any `<queries><package android:name="moe.shizuku.privileged.api"/>` entry (`STALE_QUERY_ALLOWED = 0`). With the manager built in, 7A-1.1 has already turned Mika's entry into the host package, so a merged manifest from a correct build has no such string; if the patch did not run, or drifted, the rule fails the build check.

| File | Change |
|---|---|
| `shizuku/tools/check-merged-manifest.py` | `STALE_QUERY_ALLOWED = 1` -> `0` (comment says why); the rule's registry text, docstring, the "at most %d allowed" error text and the note text updated (they spoke of "until row 7A-1"); the code path for a value above 0 stays |
| `shizuku/tools/test-check-merged-manifest.py` | `EXPECTED_STALE_QUERY_ALLOWED = 1` -> `0` (same step, so the constants guard passes); the notes asserted by cases `4b-02`, `4b-23`, `x-04` follow the new note text (`allowed by the switch`); comments and the guard's message updated |
| `shizuku/README.md`, `README.md`, `docs/CHANGES-shizuku-part7a1-2.md` | plan rows, notes, state line |

**Decisions**
1. **Both constants in one step.** If only the checker changed, the constants guard of the self-test fails on purpose (4E-4c); both are 0 now.
2. **The switch stays a constant** (not deleted): cases `4b-02`, `4b-03`, `4b-07`, `x-04` still set it to 1 with `patch=` to keep testing the "one allowed entry" path, so the 147 cases are the same cases; only the shipped value changed. Cases `4b-23` / `4b-24` test the value 0 and now describe the shipped state.
3. **Texts follow the state.** With the value 0 the note "the entry is still there" can never print (the entry is an error then); the message was reworded so that it is correct if someone sets the switch above 0 again.
4. **Rule runs only with the manager built in** (unchanged): a build without `:shizuku` is "Shizuku is not built in" and passes, so the stock `<queries>` name of that build is not an error.

**Tried here.** `python3 -I shizuku/tools/test-check-merged-manifest.py`: 147 cases, 0 failed (22 + 30 + 42 + 24 + 25 + 4), coverage of all 19 rules, registry 6, constants 1, helpers 23, command line 21 (same numbers as before 7A-1.2). `python3 -I shizuku/tools/check-all.py`: 4 steps ok, S5 - S7 skipped (no fetched sources / merged manifest). `python3 mika/tools/static-check.py`: all checks passed.

**Not verified.** The real merged manifest (S7 needs a Gradle build, none here): that `${applicationId}` in Mika's `<queries>` is resolved by the manifest merger and that no other string with the stale package survives. The first CI run with the switch on shows it. No Gradle build, no device.

**Next:** 7A-2 (`ShizukuController.SHIZUKU_PACKAGE`).

## 7A-2.1 — `SHIZUKU_PACKAGE`: Mika's patch script (Step 7, row 3 of 8)

Request: 7A-2 split into 7A-2.1 / 7A-2.2, do 7A-2.1, keep all details, updated full flat zip (`RizwanS2-main-shizuku-step7a2-1.zip`). Based on `RizwanS2-main-shizuku-step7a1-2.zip`.

**What was read.** This time GitHub was reachable: `mika/tools/fetch-upstream.sh` fetched the real Mika 0.1.52 (7ff1703) and the whole patch script was run on it. In Mika's `app` / `core` sources the name appears in one file only, `cap/phone/setup/ShizukuController.kt`: `const val SHIZUKU_PACKAGE = "moe.shizuku.privileged.api"` (companion object), used by `AndroidBridge.isPackageInstalled()` (two `getPackageInfo` calls, API 33+ and older) and by `AndroidBridge.openShizukuApp()` (`getLaunchIntentForPackage`). No other file uses it; the constant is read only through `isPackageInstalled()` (line 156: `installed = running || isPackageInstalled()`) and `openShizukuApp()` (from `openGrantOrApp`).

**Result.** With `:shizuku` in the build (`MIKA_SHIZUKU_BUILTIN=1`, the same switch as 7A-1.1) the patch writes:

| Place | Stock text (switch 0 / unset) | Built-in text (switch 1) |
|---|---|---|
| constant | `const val SHIZUKU_PACKAGE = "moe.shizuku.privileged.api"` | `const val SHIZUKU_MANAGER_ACTIVITY = "moe.shizuku.manager.MainActivity"` |
| `isPackageInstalled()` (2 calls) | `getPackageInfo(SHIZUKU_PACKAGE, ...)` | `getPackageInfo(app.packageName, ...)` (always true: the manager is part of the host) |
| `openShizukuApp()` | `ctx.packageManager.getLaunchIntentForPackage(SHIZUKU_PACKAGE) ?: return false` | `Intent().setClassName(ctx.packageName, SHIZUKU_MANAGER_ACTIVITY)` |

| File | Change |
|---|---|
| `mika/tools/patch-upstream.py` | new part 16: `SHIZUKU_CTRL`, `SHIZUKU_MANAGER_ACTIVITY`, the three (stock, built-in) pairs, `patch_shizuku_package()`, `check_shizuku_package()` (called from `check()`), one result key in `main()`, header item 16 |
| `mika/tools/patch-upstream.sh` | header comment only |
| `shizuku/README.md`, `README.md`, `mika/README.md`, `docs/CHANGES-shizuku-part7a2-1.md` | plan rows, notes, state line |

**Decisions**
1. **Run-time value, not a literal.** `app.packageName` / `ctx.packageName` follow the package rename of the workflows (`new_package_name`) and the cached Mika checkout, so nothing can go stale (same reason as `${applicationId}` in 7A-1.1).
2. **`openShizukuApp()` is not "the same with the host package".** `getLaunchIntentForPackage(host)` would return the Win11 launcher, so "open Shizuku" would open the desktop. With the manager built in it starts the manager's start screen by class name (the same name as `ShizukuLauncher.MANAGER_ACTIVITY` in `:app`; not exported, same app, so allowed). A failed start is caught by the existing `runCatching` (returns false). The existing `FLAG_ACTIVITY_NEW_TASK` stays.
3. **The constant is replaced, not kept.** A kept `SHIZUKU_PACKAGE` with the stock value would leave the stale string in the Kotlin; nothing else in the sources uses it (grep of `app` + `core`).
4. **Two-way, strict, same switch as 7A-1.1.** Either spelling is accepted as input, the output depends only on the switch; each place must be found exactly once (`getPackageInfo`: exactly twice), otherwise `::error::` (upstream drift). The switch is already part of the stamp.
5. **Own self-check** `check_shizuku_package()`: with the manager built in no `moe.shizuku.privileged.api` and no `SHIZUKU_PACKAGE` word may remain in the file (comments count); without it the built-in spelling must not be there.
6. **Not changed:** the Mika UI strings ("Shizuku isn't installed", "Install and start Shizuku ...") stay as they are; with the manager built in `isPackageInstalled()` is always true, so the "not installed" state is not reached when the server is not running; the text of the "not running" state is unchanged.

**Tried here (on the real fetched Mika 0.1.52, not hand-made files).** Full patch script, switch 1: `shizuku package (host)=1`, 4 lines changed, no `privileged` / `SHIZUKU_PACKAGE` left; second run with `MIKA_FORCE_PATCH=1`: 0 edits, byte-identical; back to switch 0: file **byte-identical to upstream**; unset = 0. 22 cases in all (1 - 8 above; 9 - 14 drift: constant missing / twice / both spellings, launch intent changed, one or three `getPackageInfo` calls, each `::error::` with no traceback; 15 - 21 `check_shizuku_package()` on correct and broken files in both switch states; 22 CRLF input is normalised like every other part), 22 of 22 as expected. `py_compile` OK; `mika/tools/check-manifest.py` OK for both switches; `mika/tools/static-check.py` all checks passed (also with a patched checkout in place); `python3 -I shizuku/tools/check-all.py`: 4 ok, S5 - S7 skipped. The fetched checkout is not part of the zip.

**Not verified.** No Kotlin compile (Gradle unreachable): that `Intent().setClassName(String, String)` and the unchanged imports (`Intent` is imported already) compile in `:mika` is read, not built; the first CI run shows it. No device: that `openShizukuApp()` really lands on the manager screen (and in which task, since Mika's activities have their own task affinity and the manager has none) is not run.

**Next:** 7A-2.2 (done, see below).

## 7A-2.2 — `SHIZUKU_PACKAGE`: the read-only check (Step 7, row 4 of 8)

Request: do 7A-2.2, keep all details, updated full flat zip (`RizwanS2-main-shizuku-step7a2-2.zip`). Based on `RizwanS2-main-shizuku-step7a2-1.zip`.

**Result.** `mika/tools/check-manifest.py` has check 14 (it already had 13 for the `<queries>` entry of 7A-1.1): it reads `ShizukuController.kt` of the patched checkout and demands one consistent spelling of the three places of part 16 (the constant, the launch intent of `openShizukuApp()`, the two `getPackageInfo` arguments). It is the counterpart of `check_shizuku_package()` inside the patch script, but separate: the patch checks itself right after patching, this one is what CI and `static-check` run later on whatever is on disk (a cached checkout patched by an older script, a hand-edited file, a switch that changed).

| Switch `MIKA_SHIZUKU_BUILTIN` | What must be in the file |
|---|---|
| `1` | built-in spelling everywhere (`app.packageName` twice, `Intent().setClassName(ctx.packageName, SHIZUKU_MANAGER_ACTIVITY)`, constant `SHIZUKU_MANAGER_ACTIVITY`); no `moe.shizuku.privileged.api`, no `SHIZUKU_PACKAGE` word, comments included |
| `0` | stock spelling everywhere (the original upstream text) |
| unset | either, but never a mixture (the workflows run the check without the variable today) |

| File | Change |
|---|---|
| `mika/tools/check-manifest.py` | check 14 + docstring item 14; reuses the constants of `patch-upstream.py` (`SHIZUKU_CTRL`, `SHIZUKU_CONST`, `SHIZUKU_INTENT`, `SHIZUKU_INFO`, `RX_PKG_INFO`), so the two scripts cannot drift apart |
| `shizuku/README.md`, `README.md`, `docs/CHANGES-shizuku-part7a2-2.md` | plan rows, notes, state line |

**Decisions**
1. **Constants shared, logic separate.** The text pairs come from the patch script (one source of truth); the check has its own comparison and does not call `check_shizuku_package()` (which would `exit 1` through `err()` inside the other script).
2. **Mixture is an error in every state**, also with the variable unset: half of the places patched is the one state that compiles but opens the wrong screen.
3. **Missing file is an error without traceback** (`ShizukuController.kt not found`: upstream layout changed).
4. **Read-only.** Nothing is written; a test compares the file before and after.
5. **No change to `static-check.py`**: it already runs `check-manifest.py` on a patched checkout, so check 14 runs there too. `check-gradle.py` / `check-all.py` are not touched (they do not read the Mika Kotlin).

**Tried here (real Mika 0.1.52, patched in a scratch folder, in place edits, file restored after each case):** 18 cases, 18 of 18 as expected: built-in file with switch 1 / unset = ok, with 0 = error; stock file with 0 / unset = ok, with 1 = error; built-in with one `getPackageInfo` back to stock, launch intent back to stock, stale package in a comment, the word `SHIZUKU_PACKAGE` in a comment, constant removed, wrong activity name, `getPackageInfo` asking for another name; stock with one place patched (mixture), stock with both constants; unset with a mixture; file missing; file unchanged after the check. `py_compile` OK; `python3 -I shizuku/tools/check-all.py`: 4 ok, S5 - S7 skipped; `python3 mika/tools/static-check.py`: all checks passed. The 22 cases of 7A-2.1 were not repeated (the patch script is unchanged). The fetched checkout is not part of the zip.

**Not verified.** No Kotlin compile, no device (same as 7A-2.1). The workflows call `check-manifest.py` without the variable, so in CI check 14 accepts either spelling; to make it demand the built-in one with the switch on, the step would have to export `MIKA_SHIZUKU_BUILTIN=1` (rows 8A - 8C, together with the other Shizuku steps there).

**Next:** 7B (one provider: Mika's `ShizukuProvider` is gone from the merged manifest and Mika's code only needs the class).

## 7B — one provider (Step 7, row 5 of 8)

Request: do 7B, keep all details, updated full flat zip (`RizwanS2-main-shizuku-step7b.zip`). Based on `RizwanS2-main-shizuku-step7a2-2.zip`.

**Question.** With the manager built in, is Mika's `rikka.shizuku.ShizukuProvider` really gone from the app, is nothing lost by that, and does Mika's code need only the class?

**What was read.** GitHub was reachable: Shizuku v13.6.0 (`2650830`) + API (`510fc98`) and Mika 0.1.52 (`7ff1703`) were fetched and patched with the project's scripts, then read.

| Question | Answer (read, not built) |
|---|---|
| Does Mika's code mention `ShizukuProvider`? | No. `grep` over Mika's `app` + `core` sources: only the manifest (`<provider android:name="rikka.shizuku.ShizukuProvider">`, line 397 of the unpatched manifest). Mika's Kotlin uses only `rikka.shizuku.Shizuku` (the API) and never the provider class. So Mika needs not even the class: only the manager's provider needs it (as its super class). |
| What does the removal take away? | Mika's provider has `enabled=true, exported=true, multiprocess=false, permission=INTERACT_ACROSS_USERS_FULL`, authority `${applicationId}.shizuku`. The manager's provider has exactly the same five (name aside) and extends the class. Nothing is lost in who may call it or in which process it runs; the manager's one adds `sendUserService` and `disableAutomaticSuiInitialization()` (4A finding 1). |
| Where does the class `rikka.shizuku.ShizukuProvider` come from? | Mika's build file asks for the Maven artifact `dev.rikka.shizuku:provider:13.1.5`; the root `build.gradle.kts` substitutes it (and `api`, `aidl`, `shared`) by the local projects when `:shizuku-api` exists, so there is one copy, from `:shizuku-provider` (3F). With the switch off the Maven copy is used and Mika's own manifest provider stays (overlay not wired, rule 6). |
| R8 / ProGuard | `:app` has `isMinifyEnabled = false`; no rule of `app/proguard-rules.pro` or `shizuku/consumer-rules.pro` names the provider class. Nothing to keep or drop. |
| Anything else in `:app` using the provider? | No: `app/src/main` has no mention (rule 6 of the checker proves it); the only mentions are the overlay and comments. |

**Result.** Confirmed on the real patched sources. Two rules were added to `shizuku/tools/check-provider-match.py` so that the confirmation is kept by the checkers and not only by this text:

| Rule | What it proves | Self-test cases |
|---|---|---|
| 7 | every attribute of Mika's provider except `android:name` is on the manager's provider with the same value (the manager's may have more) | lost permission, different `multiprocess`, extra attribute allowed |
| 8 | the root `build.gradle.kts` substitutes `"dev.rikka.shizuku:provider"` by `":shizuku-provider"` in code (a comment does not count) | no substitution, substitution only in a comment |

The success line says "no attribute of Mika's provider lost, one copy of the class". The self-test has 17 cases now (12 + 5); the good case of the self-test got the attributes of the real providers.

| File | Change |
|---|---|
| `shizuku/tools/check-provider-match.py` | rules 7 and 8, new optional argument `root_gradle` (the real run passes `build.gradle.kts`), docstring, success line, 5 cases |
| `shizuku/tools/check-all.py` | header text of S4: 17 cases |
| `shizuku/README.md`, `README.md`, `docs/CHANGES-shizuku-part7b.md` | plan rows, notes, tables with the case count (older sections and `docs/CHANGES-*` keep their old counts as history) |

**Decisions**
1. **Attributes as a subset.** The manager may carry more (it is the one that stays); it must not carry less or different. Compared as text, so a literal and a placeholder would count as different on purpose.
2. **Rule 8 is code only** (comments stripped, as rule 6 does), and skipped when the root build file is not passed (self-test cases of the older rules, library use).
3. **No new rule for "Mika code needs only the class"**: rule 5 (no `ShizukuProvider` in Mika's sources) already proves the stronger statement.
4. **No change to `check-merged-manifest.py`**: its rule 2 (accepts the missing provider only with the manager's provider in the merged manifest) and `4E-2` (no `rikka.shizuku.ShizukuProvider` left, one authority, owned by the manager) already check the merged result; they need a build (S7).

**Tried here (real fetched + patched sources).** `python3 shizuku/tools/check-provider-match.py`: ok. `--self-test`: 17 of 17. `python3 -I shizuku/tools/check-all.py`: S1 - S6 ok (S5 and S6 ran on the real sources this time), S7 skipped (no merged manifest). `python3 mika/tools/static-check.py`: passed. The fetched checkouts are not part of the zip.

**Not verified.** The merged manifest of a real Gradle build (S7: that the overlay's `tools:node="remove"` is accepted by AGP 8.13.2 and removes exactly this provider, the four AGP points of 4B-2); that D8 sees one copy of `ShizukuProvider`; nothing at run time. The first CI run shows them.

**Next:** 7C (one permission).


## 7C — one permission (Step 7, row 6 of 8; documentation only)

Request: do 7C, keep all details, updated full flat zip (`RizwanS2-main-shizuku-step7c.zip`). Based on `RizwanS2-main-shizuku-step7b.zip`.

**What the row asks (with the correction of 4G-2).** Mika keeps all its permissions; the host declares `API_V23` once; with the switch on the host does **not** request `API_V23`; the run-time request path has to work with the host as the manager.

**Result: no code changed.** The three static facts hold and are already guarded by existing rules; the run-time path is a chain of reads from earlier rows, written down here once. This session had no network, so `shizuku/upstream/` and `mika/upstream/` were **not** fetched again; nothing below was read from the real sources in this session.

| # | Fact | Where it is guarded | Re-run in 7C |
|---|---|---|---|
| 1 | Mika keeps all its permissions: 30 `uses-permission` entries (`KEEP_PERMISSIONS` in `mika/tools/patch-upstream.py`), none of them a Shizuku name | `check()` of the patch script (fails when one is missing) | counted from the script: 30, no name with "shizuku" |
| 2 | `MANAGER` and `API_V23` are declared once, by `:shizuku`, with the levels of v13.6.0 | merged-manifest rules `4E-3 declared once`, `4E-3 levels`; patch self-check rule of 4C-3 | `test-check-merged-manifest.py --no-real` through S3 of `check-all.py`: ok (147 cases, 19 rules) |
| 3 | The host asks for `MANAGER` once and does not ask for `API_V23` (guard `tools:node="remove"`, `shizukuIgnored = manifest` on `:shizuku-provider`) | merged-manifest rules `4E-3 manager request`, `4E-3 no API_V23 request`; `check-gradle.py` | S1 - S3 ok |

**The run-time path, as a chain (what each link rests on).**
1. Mika's code (Mika's Kotlin, unchanged except the package string of 7A-2.1) asks the Shizuku API class for the permission. That class is the same `rikka.shizuku` API as before: the Maven artifacts are replaced by `:shizuku-api` / `:shizuku-provider` (3F, 7B). *Rests on:* 3F, 7B. *Not re-read here.*
2. The API call goes through the binder the server sent to the host's provider (`${applicationId}.shizuku`, one provider, 7B). *Rests on:* 4B, 5C (binder key unchanged, finding 15), 7B.
3. The server decides by uid: the app id of `MANAGER_APPLICATION_ID` is the host package after part A (step 1 record, 5C table), and the server treats the manager's app id as always allowed (4A, finding 3). So the host (Mika runs inside the host app, 7A-2) needs no `API_V23` grant; this is why the host does not request it. *Rests on:* 4A reading, 5C table. **Read, never run.**
4. If the server did ask for a confirmation, it sends `${applicationId}.intent.action.REQUEST_PERMISSION` to the host's `RequestPermissionActivity` (5D). That path stays as upstream has it. *Rests on:* 5D. Read, never run.

**Decisions**
1. **No new rule.** The three facts are already guarded (rules named above); a copy would only repeat them. The part that cannot be guarded statically (link 3) needs a device.
2. **No permission is added to Mika's list.** The owner's rule (Mika keeps all, adds nothing) stays; adding `API_V23` would bring back the request that the guard removes.
3. **If link 3 is wrong on a device** (Mika reports "permission denied" from inside the host), the first thing to look at is whether `MANAGER_APPLICATION_ID` really is the host package in the built server (the 5C counts) before anything else; the fix would then be a row of its own, not a change to the guard.

**Tried here.** `python3 -I shizuku/tools/check-all.py`: S1 - S4 ok, S5 - S7 skipped (no fetched sources, no build). `python3 -I mika/tools/static-check.py`: all checks passed. `KEEP_PERMISSIONS` counted: 30, none a Shizuku name.

**Not verified.** Everything at run time (links 1 - 4); the merged manifest of a real build (S7); the real sources were not re-read in this session. The first CI run and a phone test show them.

**Next:** 7D (`ShizukuShellUserService`).


## 7D — `ShizukuShellUserService` (Step 7, row 7 of 8; documentation only)

Request: do 7D, keep all details, updated full flat zip (`RizwanS2-main-shizuku-step7d.zip`). Based on `RizwanS2-main-shizuku-step7c.zip`.

**What the row asks.** Check that Mika's service class resolves and binds through the manager's provider (`sendUserService`, 4A finding 1).

**Result: no code changed.** This session had no network, so Mika's real `ShizukuShellUserService` source and the Shizuku server sources were **not** fetched again; the chain below uses what the project files and earlier rows record. Mika's own class is not edited by any of our patches (its only host-package dependency, `BuildConfig.APPLICATION_ID`, is covered by 7A-2.1 / `mika/build.gradle.kts`).

| # | Fact | Where it is recorded or guarded | Re-run in 7D |
|---|---|---|---|
| 1 | `BuildConfig.APPLICATION_ID` of `:mika` is the host package `com.srizwan.win11` (the service compares it with `context.packageName` and looks up the uid by it) | `mika/build.gradle.kts` (header and `buildConfigField`); the grep guard in the three workflows after the package rename; `mika/README.md` lines on host-package checks | read in the files: value is `com.srizwan.win11`; guard present in all three workflows |
| 2 | The class lives in the host APK: `:mika` is a library module merged into `:app` (no second APK), so `pm path <host package>` leads to the APK that holds it | `app/build.gradle.kts` (`:mika` dependency); step 5B-1 (`pm path`, host package) | read, not run |
| 3 | The class is not renamed or removed by shrinking: `:app` release has `isMinifyEnabled = false` and debug has no shrinking | `app/build.gradle.kts` (`buildTypes`); 7B | read in the file |
| 4 | The service process reports back through one provider, the manager's `ShizukuManagerProvider`, authority `${applicationId}.shizuku`; it answers `sendUserService` (a subclass of `ShizukuProvider`) | 4A finding 1, 7B (rules 5, 7, 8 of `check-provider-match.py`), merged rules `4E-2` | `check-all.py` S4 ok (17 cases) |
| 5 | The binder extra key stays `moe.shizuku.privileged.api.intent.extra.BINDER`, so server and provider still agree | 5C (finding 15), `check_binder_protocol` | S1 ok |

**The bind path, as a chain (what each link rests on).**
1. Mika asks the Shizuku API to bind its user service with a component name of the host package and the class `ShizukuShellUserService` (package value from fact 1). *Rests on:* 7A-2, `mika/README.md`. Mika's call was not re-read.
2. The server starts the service process with the APK of that package (fact 2); the class is found by name (fact 3). *Rests on:* 5B-1, `app/build.gradle.kts`. Read, never run.
3. The new process sends its binder to the provider of the same package, `${applicationId}.shizuku` (fact 4); the manager's provider receives it with `sendUserService` and hands it to Mika's connection. *Rests on:* 4A finding 1, 7B. Read, never run.
4. Mika's connection then talks to the shell service as before. Nothing here differs from running with an external Shizuku, except that the package is the host's.

**Decisions**
1. **No new rule.** Facts 1, 4 and 5 are already guarded (workflow grep, `check-provider-match.py`, `check_binder_protocol`); facts 2 and 3 are plain settings of the build files and a copy of them in a script would only repeat the file. The ordering of the chain (links 2 and 3) can only be shown by a run.
2. **No change to Mika's code or manifest.** The class needs no `<service>` entry for this path (a user service runs in a process of the server's making, not as a component of the app); this was read in 4A, not tried.
3. **If the bind fails on a device**, look first at the package the server was asked for (it must be `com.srizwan.win11`, fact 1) and at the `pm path` of that package; only then at the provider. A fix would be a row of its own.

**Tried here.** `python3 -I shizuku/tools/check-all.py`: S1 - S4 ok, S5 - S7 skipped (no fetched sources, no build). `python3 -I mika/tools/static-check.py`: all checks passed. The facts of the table were read in the project files named there.

**Not verified.** Everything at run time (links 1 - 4); Mika's real `ShizukuShellUserService` and the server's service starter were not re-read in this session; the merged manifest of a real build (S7). The first CI run and a phone test show them.

**Next:** 7E (docs: `NOTICE-Mika.md` note, CHANGES file, flat zip).


## 7E — docs and zip (Step 7, row 8 of 8; documentation only)

Request: do 7E, keep all details, updated full flat zip (`RizwanS2-main-shizuku-step7e.zip`). Based on `RizwanS2-main-shizuku-step7d.zip`.

**Result: step 7 is complete (8 of 8 rows), no code changed.**

| Row | Result | Files |
|---|---|---|
| 7A-1.1 | Mika's `<queries>` entry names the host package when `:shizuku` is in the build (env `MIKA_SHIZUKU_BUILTIN`); check 13 | `mika/tools/patch-upstream.py`, `mika/tools/check-manifest.py`, `mika/build.gradle.kts` |
| 7A-1.2 | checker's `STALE_QUERY_ALLOWED` = 0 (and its self-test constant) | `shizuku/tools/check-merged-manifest.py`, `test-check-merged-manifest.py` |
| 7A-2.1 | `SHIZUKU_PACKAGE` follows the host package (part 16), `openShizukuApp()` opens the manager's activity | `mika/tools/patch-upstream.py` |
| 7A-2.2 | read-only check 14 for the same rule | `mika/tools/check-manifest.py` |
| 7B | one provider: rules 7 and 8 of `check-provider-match.py` (17 self-test cases) | `shizuku/tools/check-provider-match.py`, `check-all.py` |
| 7C | one permission: docs only, run-time path as a chain (read, not run) | README, docs |
| 7D | `ShizukuShellUserService`: docs only, bind path as a chain (read, not run) | README, docs |
| 7E | `NOTICE-Mika.md` section, combined CHANGES file, state lines | `NOTICE-Mika.md`, `docs/CHANGES-shizuku-part7.md`, README, `README.md` |

**What changed in this row**
- `NOTICE-Mika.md`: new section "Shizuku hook-up (only when the built-in Shizuku manager is in the build; step 7)" before "Third-party parts that come with Mika": the two changes in Mika's sources (part 16: `<queries>` entry and `ShizukuController.kt`), what is done on the Win11 side (provider overlay, local modules instead of the Maven artifacts, permissions kept), the notes of 7C / 7D marked as read-not-run, the licence line. Nothing in the older text was removed.
- `docs/CHANGES-shizuku-part7.md`: all of step 7 in one file (the small `part7a1-1` ... `part7d` files stay as history).
- This README (plan rows 7 and 7E, step 7 note, this section) and the root `README.md` (state line).

**Decisions**
1. The notice says plainly which statements were read in the project files and not run (`NOTICE-Mika.md` is read by the owner and by reviewers; it must not claim more than was checked).
2. The notice names Mika's changes only for the switch-on case; with the switch off the older text of the file is the whole truth.
3. No change to any script, rule or count.

**Tried here.** `python3 -I shizuku/tools/check-all.py`: S1 - S4 ok, S5 - S7 skipped (no fetched sources, no build). `python3 -I mika/tools/static-check.py`: all checks passed.

**Not verified.** Everything listed under "Not verified" of 7A-1.1 ... 7D: nothing was built, nothing run on a device, the merged manifest of a real build (S7) and the real Mika class sources were not read in this session.

**Next:** step 8 (CI and the switch): 8A, 8B, 8C (the three workflows: fetch + patch + cache), 8D-1, 8D-2, 8E, 8F.


## 8A — `UltimateBuild.yml`: fetch + patch + cache (Step 8, row 1 of 8; first CI file change)

Request: do 8A, keep all details, updated full flat zip (`RizwanS2-main-shizuku-step8a.zip`). Based on `RizwanS2-main-shizuku-step7e.zip`.

**Result.** `.github/workflows/UltimateBuild.yml` has two new steps directly after "Fetch and patch Mika source" (41 lines added, none removed or changed; the file parses as YAML, the step order was read back):

| Step | What it does |
|---|---|
| `Cache Shizuku source` (`actions/cache@v4`) | path `shizuku/upstream`; key `shizuku-upstream-` + `hashFiles` of `shizuku/UPSTREAM_VERSION`, `UPSTREAM_COMMIT`, `UPSTREAM_API_COMMIT` and the three scripts `fetch-upstream.sh`, `patch-upstream.sh`, `patch-upstream.py`. A pin change or a script change refetches / patches again |
| `Fetch and patch Shizuku source` (20 minutes) | 1. guard: `applicationId` of `app/build.gradle.kts` must be `$NEW_PKG` (the patch writes that package into the server, starter and API provider; same idea as Mika's `APPLICATION_ID` guard, the error says the rename did not reach the file). 2. `fetch-upstream.sh` (verifies both commits). 3. `patch-upstream.sh` (marker = hash of the script + host package, so a changed package patches again from the pristine checkout). 4. `patch-upstream.py --check` (self-check on the finished checkout, S6). 5. `check-provider-match.py` (S5, needs Mika's patched manifest, which the step before provides). 6. prints version and both commits, `du -sh`, `df -h` |

The header comment of the workflow got a paragraph about Shizuku (before the Seal paragraph).

**Why after the Mika step and after the rename.** The patch reads the host package at that moment (note from 5B-1); S5 reads Mika's patched manifest (`mika/upstream`). Both are true only after the two earlier steps.

**Decisions**
1. **Runs in every build, also with the module off** (the Mika step does the same). It makes S5 and S6 real on every CI run, and fills the cache for row 8F. The price is one clone (size not measured) when the cache is empty.
2. **The package is not passed as `SHIZUKU_HOST_PACKAGE`.** The patch reads the file, so a rename that did not reach `app/build.gradle.kts` is caught by the guard instead of being hidden by an override.
3. **The key is written here, not in 8E.** A cache step needs a key; 8E reviews it (host package, `runner.os`) and does not rewrite the step.
4. **No Gradle flag, no APK check here.** `includeShizuku` stays off (8F); the APK checks are 8D-1 / 8D-2.
5. **No `--require-real` call yet.** S7 needs a build with the module on; only 8D-2 / 8F run it.

**Tried here.** The file parses (PyYAML); the two steps are in the expected place; the guard command was run on the project's `app/build.gradle.kts` with the right and a wrong package name (passes / fails as intended). `python3 -I shizuku/tools/check-all.py`: S1 - S4 ok, S5 - S7 skipped. `python3 -I mika/tools/static-check.py`: all checks passed.

**Not verified.** No GitHub run: whether the clone works on the runner, the size of the cache, that `actions/cache` restores the `.git` folders so the commit check passes, and that S5 / S6 pass on the real sources inside this workflow (they did in 7B on a local fetch, with the old package). The first CI run shows them.

**Next:** 8B (`UltimateBuild_NoWinlator.yml`, the same two steps).


## 8B — `UltimateBuild_NoWinlator.yml`: fetch + patch + cache (Step 8, row 2 of 8)

Request: do 8B, keep all details, updated full flat zip (`RizwanS2-main-shizuku-step8b.zip`). Based on `RizwanS2-main-shizuku-step8a.zip`.

**Result.** `.github/workflows/UltimateBuild_NoWinlator.yml` has the same two steps as `UltimateBuild.yml` (8A), `Cache Shizuku source` and `Fetch and patch Shizuku source`, directly after "Fetch and patch Mika source", and the same Shizuku paragraph in its header comment. The text was copied from the 8A file by a script (the step block and the header block as written there), not typed again, so the two files cannot differ in these parts. 41 lines added, none removed or changed; the file parses as YAML and the step order was read back.

**Specific to this file (read, nothing to change).** The step "Remove Winlator" runs before the package rename and touches only `winlator/`, the `:winlator` lines of `settings.gradle.kts` and `app/build.gradle.kts`, and the launcher stub; it does not touch `applicationId`, so the guard of the new step still reads the renamed package. The Shizuku cache key and path are the same as in 8A (separate workflow files share the GitHub cache of the repository, and the same key means the same content, so a cache saved by one file is restored by the other).

**Decisions**
1. Same text as 8A, produced by copying (decision 1 - 5 of 8A apply unchanged: runs with the module off, host package read from the file, key written here, no APK check, no `--require-real`).
2. A shared cache key between the workflow files is intended: the cached folder holds the patched checkout, and its patch marker (script + host package) makes the patch run again when the package differs.

**Tried here.** The file parses (PyYAML), the step order is `Cache Mika source`, `Fetch and patch Mika source`, `Cache Shizuku source`, `Fetch and patch Shizuku source`, `Set up ccache ...`; `diff` against the 8A zip shows 41 added and 0 removed lines; `python3 -I shizuku/tools/check-all.py`: S1 - S4 ok, S5 - S7 skipped; `python3 -I mika/tools/static-check.py`: all checks passed.

**Not verified.** No GitHub run (same open points as 8A: clone on the runner, cache size, `.git` in the cache, S5 / S6 on the real sources). GitHub caches are scoped by branch; whether a cache from the default branch is found by a run on another branch is GitHub's rule, not tested here.

**Next:** 8C (`UltimateBuild_WithoutMe.yml`, the same two steps; check first where its package rename and Mika step are).


## 8C — `UltimateBuild_WithoutMe.yml`: fetch + patch + cache (Step 8, row 3 of 8)

Request: do 8C, keep all details, updated full flat zip (`RizwanS2-main-shizuku-step8c.zip`). Based on `RizwanS2-main-shizuku-step8b.zip`.

**Result.** `.github/workflows/UltimateBuild_WithoutMe.yml` has the same two steps as 8A / 8B (`Cache Shizuku source`, `Fetch and patch Shizuku source`) directly after "Fetch and patch Mika source", and the Shizuku paragraph in its header comment. The text was copied from the 8A file by a script and then changed in exactly three places (below). 46 lines added, none removed or changed; the file parses as YAML, the step order was read back.

**What is different in this file, and why.** This workflow has tick boxes (`include_winlator`, `include_ppsspp`, `include_mame`, `include_retroarch`, `include_j2me`, `include_seal`, `include_mika`); the step "Remove the modules that are not ticked" deletes an unticked module's folder before the package rename. The Mika steps carry `if: ${{ inputs.include_mika }}`.
1. **Shizuku has no tick box**, so its two steps have no `if:` (as in 8A / 8B: the sources are fetched and patched in every run).
2. **The provider check needs Mika's patched manifest.** With the Mika tick box off, `mika/` is deleted, so `check-provider-match.py` would stop with exit 2 and, under `set -e`, fail the build. The call is therefore `if [ -d mika/upstream ]; then ... else echo "Mika is not in this build ...: provider match skipped" fi`. With Mika on it runs exactly as in 8A.
3. **Header paragraph:** one more sentence says so; the step comment says "(only when the Mika tick box is on: its manifest must exist)".

**Decisions**
1. The condition is the existence of the folder, not a copy of `inputs.include_mika`: it stays right if the module list changes, and it is the fact the check needs.
2. Shizuku is not made a tick box here (not asked; the module is still off by default until 8F, and a tick box is a design decision for 8F or later).
3. Decisions 1 - 5 of 8A apply unchanged.

**Tried here.** The file parses (PyYAML); the step order is `Cache Mika source`, `Fetch and patch Mika source`, `Cache Shizuku source`, `Fetch and patch Shizuku source`, `Set up ccache ...`; neither new step has an `if`; the `run` block of the second step was cut out of the file and passed `bash -n` (syntax ok, one `mika/upstream` test); `diff` against the 8B zip shows 46 added and 0 removed lines; `python3 -I shizuku/tools/check-all.py`: S1 - S4 ok, S5 - S7 skipped; `python3 -I mika/tools/static-check.py`: all checks passed.

**Not verified.** No GitHub run (open points of 8A, plus: a run with the Mika tick box off, where the step must print the "skipped" line and pass). All three workflows now have the steps, so rows 8D - 8F are next.

**Next:** 8D-1 (a script that lists the built APK and requires `libshizuku.so` and the `starter` / `rish` assets; also `libadb.so`, `librish.so` per ABI, stored extracted). Check first how the three workflows check Mika's native files and where such a script would be called (the call itself must wait for the module to be on, 8F).


## 8D-1 — APK content script (Step 8, row 4 of 8)

Request: do 8D-1, keep all details, updated full flat zip (`RizwanS2-main-shizuku-step8d1.zip`). Based on `RizwanS2-main-shizuku-step8c.zip`.

**Result.** New `shizuku/tools/check-apk-contents.py` (executable, python3 only, reads the APK with `zipfile`; no `unzip`, no Gradle, no network). `python3 -I shizuku/tools/check-apk-contents.py app-release.apk [--abis a,b] [--list] [--strict-align]` and `--self-test`. Exit 0 = ok, 1 = problem (one `::error::` line each, all printed), 2 = APK missing / not a zip. No workflow, Gradle file, manifest or other script was changed.

**What it requires**
1. For every ABI that has any `lib/<abi>/*.so` (or exactly the ABIs of `--abis`, each of which must be shipped): `libshizuku.so`, `libadb.so`, `librish.so`, non-empty, a little-endian ELF of the right class and machine (arm64-v8a = ELF64 AArch64, armeabi-v7a = ELF32 ARM, x86 = ELF32 Intel 80386, x86_64 = ELF64 x86-64), and **not stored** (see below). An ABI that ships other libraries but not these three is the failure 5B-2 named: the app installs and the starter is missing.
2. `assets/rish` (upstream's shell script) and `assets/rish_shizuku.dex` (task `shizukuRishDex`, 3E), both non-empty; the dex has the dex magic and its header's file size equals the real size (one whole dex file).
3. At least one ABI with native libraries in the APK; an unknown ABI directory name is an error.
Warning only (error with `--strict-align`): for arm64-v8a and x86_64, a `PT_LOAD` alignment below 16 KB (targetSdk 37 devices with 16 KB pages). This is the first place where the 5B-2 "not checked on a build" point about 16 KB alignment can be answered, on the first CI run.

**Corrections of the row text (decisions)**
1. **"Stored extracted" was muddled; the check is "not stored".** With `useLegacyPackaging = true` and `extractNativeLibs="true"` (5B-2) AGP writes the `.so` files deflated into the APK and the installer extracts them to `nativeLibraryDir`. A *stored* `.so` is what AGP writes when extraction is off (page-aligned, mapped from the APK): then there is no file for the starter to run. So the script fails on method "stored" for the three libraries. The workflows' Mika check only tests that the files exist; it does not test the method, so "as the workflows already do" was not literally true. This is a proxy: the real attribute is `extractNativeLibs` in the APK's binary manifest, which 8D-2 reads.
2. **There is no `starter` asset.** The starter is `lib/<abi>/libshizuku.so` (3E: an `add_executable` named like a library). The only assets are `rish` and `rish_shizuku.dex`, and the script checks those two.
3. **Not wired into a workflow, on purpose.** The module is off in every build until 8F, so today's APK has none of these files and a call would fail every run. The call goes into the three workflows together with the 8D-2 call, guarded by the same switch as the module (rows 8D-2 / 8F; 10A for the root check). Same rule as `sweep-package-strings.py`: new tools are wired later.
4. **The script is not in `check-all.py`** (its S1 - S7 and the counts in its docstring stay as they are); `check-all.py` has no APK to look at.

**Tried here.** `python3 -I shizuku/tools/check-apk-contents.py --self-test`: 33 of 33 cases (good APK with four ABIs and with one; `--abis` met / not met; each of the three libraries missing; one ABI incomplete; all Shizuku libraries missing, i.e. today's module-off APK; stored library; empty library; non-ELF; ELF of another ABI under the name; 32-bit in a 64-bit directory and the reverse; 4 KB alignment as warning, as error with `--strict-align`, and not looked at on 32-bit ABIs; `rish` / dex missing, empty, no dex magic, wrong header size; APK without `lib/`; not a zip; missing file exits 2; unknown ABI directory; `run()` exit codes 0 and 1). A mutation test (stored check disabled) made exactly the 2 stored cases fail, so the cases do test the rules. `python3 -I shizuku/tools/check-all.py`: S1 - S4 ok, S5 - S7 skipped; `python3 -I mika/tools/static-check.py`: all checks passed; `check-gradle.py --no-run` ok.

**Not verified.** The fake APKs are hand-made (valid ELF / dex headers, nothing else): no real APK was available, so nothing shows that AGP deflates the three libraries in this project's build, that the CMake output of `:shizuku` / `:shizuku-rish` has the machine types above, or what their alignment is. First CI run (rows 8D-2 / 8F). The real `rish` asset name `assets/rish` and the dex name come from 3E / 5B-2, read from the build files, not from an upstream build.

**Next:** 8D-2 (run `check-merged-manifest.py` / `check-all.py --require-real` on the APK's manifest in the three workflows, and call this script there too, both only with the module on; needs the decision how a workflow knows "module on": the Gradle flag `includeShizuku` is not an input of the workflows yet).


## 8D-2 — manifest check and APK check in the three workflows (Step 8, row 5 of 8)

Request: do 8D-2, keep all details, updated full flat zip (`RizwanS2-main-shizuku-step8d2.zip`). Based on `RizwanS2-main-shizuku-step8d1.zip`.

**Result.** `UltimateBuild.yml`, `UltimateBuild_NoWinlator.yml` and `UltimateBuild_WithoutMe.yml` each got the same 15-line block (the same text, inserted by one script) at the end of the step `Locate Unsigned APK`, after the T-UI check and before `ccache -s`, where the checks of Mika, Seal and T-UI already are (the step already has `$UNSIGNED_APK`). The header comment sentence "the APK checks come in rows 8D-1 / 8D-2" now says what runs. No `if` on the block (Shizuku has no tick box). Nothing else in the workflows changed; no script changed.

The block:
1. Finds the merged release manifest exactly like the Mika / Seal / T-UI blocks (`find app/build/intermediates -path "*merged_manifests/release*"`); none found = `::warning::`, checks skipped (same as theirs).
2. `python3 shizuku/tools/check-merged-manifest.py "$MERGED_SHIZUKU"` **without** `--require-shizuku`: with the module off the manifest has no `moe.shizuku.manager` component and the checker prints "not built in" and passes; with it on, all 19 rules run. A failed rule fails the build (`set -e`).
3. If the merged manifest holds `android:name="moe.shizuku.manager.MainActivity"` (the module is in the build), `python3 shizuku/tools/check-apk-contents.py "$UNSIGNED_APK" --list` runs (8D-1); otherwise it prints that it is skipped.

**Decisions**
1. **How the workflow knows "module on".** No workflow passes `includeShizuku` yet (8F), and a copy of a Gradle property in the YAML would be a second place to keep right. The signal is the fact the check needs: the manager's own activity in the merged manifest. This cannot hide a failure: if the module is on but its libraries are missing, the manifest still has the activity and the APK check fails (tried, below). 8F then removes the `if` (and adds `--require-shizuku`).
2. **`check-all.py --require-real` is not used here** (the row said it may replace or follow the call). With the Mika tick box off, S5 (provider-real) has no Mika manifest and `--require-real` turns that skip into a failure; S7 would also look for a debug manifest that a release build does not have. The single checker call is what the Mika / Seal / T-UI blocks do. `check-all.py` stays for people and for 8F / 10A.
3. **The APK's manifest is the merged manifest of the build, not the binary one inside the APK.** That is what the other three checkers read; reading the binary `AndroidManifest.xml` needs `aapt2` / `apkanalyzer` and a second parser. The one thing only the binary manifest can answer, `extractNativeLibs="true"`, stays covered by `check-gradle.py` item 10 (source side) and the "not stored" rule of 8D-1 (APK side).
4. **A missing merged manifest is a warning, not an error** (exit 2 of the checker = manifest not found, as the Mika step).
5. One step, no new step: the three APK checks of the project live in this one step (their `UNSIGNED_APK`, `apk-list` files and `set -e` behaviour are shared).

**Tried here.** All three files parse (PyYAML); the block was cut out of each file's `run` text and passed `bash -n`; it sits after the T-UI echo and before `ccache -s` (one `ccache -s` line per file, unchanged); `diff` against the 8D-1 zip shows added lines only. The block of `UltimateBuild.yml` was then **executed** in a temp tree with `set -eo pipefail`, `UNSIGNED_APK` set, the real scripts linked in, and a hand-made merged manifest from the 4E-4c self-test (`good_xml`) and fake APKs of 8D-1: module off (manifest without the manager) -> exit 0, "not built in", APK check skipped; module on with a good APK -> exit 0, table printed, "in the APK"; module on with `lib/arm64-v8a/libshizuku.so` missing -> exit 1 with the `::error::` line. `python3 -I shizuku/tools/check-all.py`: S1 - S4 ok, S5 - S7 skipped; `python3 -I mika/tools/static-check.py`: all checks passed.

**Not verified.** No GitHub run. A tree without `app/build/intermediates` makes the `find | head` assignment fail under `pipefail` (seen in the simulation); the three existing blocks do the same, and a real build always has that folder. No real merged manifest (`:shizuku` has never been built: S7 / the 19 rules on a real manifest are the first CI run with the module on, 8F); the `MainActivity` test string is the merged name of `moe.shizuku.manager.MainActivity` from 4A, not seen in a real merge. Whether the WithoutMe run with some modules off still finds everything the checker expects of `:app` was not run.

**Next:** 8E (review the cache key: version + both commits + the three scripts, host package, `runner.os`).


## 8E — cache key review (Step 8, row 6 of 8; docs only, no file of the build changed)

Request: do 8E, keep all details, updated full flat zip (`RizwanS2-main-shizuku-step8e.zip`). Based on `RizwanS2-main-shizuku-step8d2.zip`.

**Result.** The key written in 8A and copied to 8B / 8C is correct as it is, so **no workflow, script or Gradle file was changed**. The row asked for a key from `UPSTREAM_COMMIT` + `UPSTREAM_API_COMMIT` so that a pin change refetches; it already is
`shizuku-upstream-${{ hashFiles('shizuku/UPSTREAM_VERSION', 'shizuku/UPSTREAM_COMMIT', 'shizuku/UPSTREAM_API_COMMIT', 'shizuku/tools/fetch-upstream.sh', 'shizuku/tools/patch-upstream.sh', 'shizuku/tools/patch-upstream.py') }}`, path `shizuku/upstream`. The three files have the same cache step text (compared by `diff`).

**What was checked, and the answer**
1. *A pin change refetches.* Both commits and the version are in the key; a new key = no restore = `fetch-upstream.sh` clones. Even a stale restore would be caught: `fetch-upstream.sh` compares `HEAD` of the checkout and of `api/` with the pins and clones again if either differs, and `patch-upstream.py` stops when `HEAD` is not `UPSTREAM_COMMIT`.
2. *A script change repatches.* `patch-upstream.py` is in the key (and in the marker hash); the two shell scripts are in the key. `patch-upstream.py` reads no other project file except `UPSTREAM_COMMIT` and `UPSTREAM_VERSION` (both in the key); `sweep-package-strings.py`, `check-*.py` and the `*.kts` files do not influence what is written into `shizuku/upstream`.
3. *The host package is not in the key, on purpose.* It is in the patch marker hash. A cache restored for another package hits, the marker differs, and `patch-upstream.py` first puts the checkout back (`reset_pristine`: `git checkout -f` + `git clean -fd` in the checkout and in `api/`) and patches again. This needs `.git` in the cached folder: `actions/cache` stores dot folders and `fetch-upstream.sh` makes a normal (shallow) clone, so it is there; the script stops with a clear message if it is not.
4. *The rename cannot change the key.* The package rename step edits only `*.kt *.java *.xml *.gradle *.gradle.kts *.properties *.json *.pro` and C / C++ headers and sources; the key files are `.sh`, `.py` and extension-less pin files, so `hashFiles` sees the same bytes before and after the rename (same key for every package name; one cache serves all three workflows and all package names).
5. *`runner.os` is not added.* All three jobs use `ubuntu-latest`; the cached folder is source text, independent of the OS. Adding it would only change the key once for nothing. If a job ever runs on another OS, add it then.
6. *No `restore-keys`.* A prefix restore would be safe (point 1 and 3 make a wrong restore repair itself), but the saving is one shallow clone, and an exact key keeps "the cache equals what these scripts produce" simple. Mika's cache has none either.
7. *Nothing writes into the cached folder after the step.* The Gradle side writes to `shizuku/build/` and `shizuku/modules/*/build/` (3E: the generated dex folder is outside upstream), and `after-fetch.gradle.kts` runs the same idempotent scripts. `actions/cache` saves only when the job succeeds and the key was a miss, so a half-patched tree is never saved.

**Tried here.** The three cache steps compared by `diff` (identical); the rename's extension list read against the key files; `reset_pristine()` of the real `patch-upstream.py` run on a hand-made checkout that has a nested `api/` repository: a modified tracked file is restored, an added file and the `.win11-patched` marker are deleted, the nested `api/` keeps its `.git` and its modified file is restored (the case of point 3). No project file was changed except the docs.

**Not verified.** The same open points as 8A: no GitHub run, branch scope of the cache (GitHub's rule: a run on another branch may not see a cache from the default branch), real cache size, and the re-patch for a new package on the real v13.6.0 checkout (the test used a hand-made repository; the real run is the first CI run with a changed package after a cache hit). `test-patch-host-package.py` has no case for the re-patch; the one-off run above is not part of any self-test (not added: it would change counts quoted in several notes).

**Next:** 8F (default switch): only after 8D passes on a first CI run and after 6E (done); update `README.md` and `gradle.properties`; the 8D-2 block's module-on condition goes and `--require-shizuku` comes in. Needs a decision: 8F cannot be verified here at all (no CI run), so check what the person wants (flip now, flip behind a workflow input, or wait for the first CI run).


## 8F — default switch (Step 8, row 7 of 8; first change that alters every build)

Request: do 8F, keep all details, updated full flat zip (`RizwanS2-main-shizuku-step8f.zip`). Based on `RizwanS2-main-shizuku-step8e.zip`.

**The condition of the plan was not met, and the row was done anyway.** Rule 14 / the row said: flip only after 8D passes in a first CI run, and not before 6E. 6E is done. **No CI run has happened** (nothing of `:shizuku` has ever been built; this environment has no network, no Gradle, no SDK), so "8D passes" cannot be shown. The row was requested explicitly, so it was done, with the rollback made cheap and written down. Treat this zip as "switch on, unproven": the first GitHub run is the real test of rows 3 - 8, and it is likely to find problems.

**Result**
1. `settings.gradle.kts`: `includeShizuku` defaults to `"true"` (`?: "true") == "true"`); the comments say ON since 8F and name the rollback. `-PincludeShizuku=false` (or `includeShizuku=false` in `gradle.properties`) turns it off.
2. `gradle.properties`: the Shizuku comment block says ON by default, documents the opt-out `includeShizuku=false` (a commented example, not set), says the hooks / init call are done and a real build has not been seen, and that the workflows demand Shizuku.
3. The three workflows: the 8D-2 block lost its condition. It now (a) **fails** when the merged release manifest is not found (before: a warning), (b) runs `check-merged-manifest.py "$MERGED_SHIZUKU" --require-shizuku` (fails if the manager's components are missing), (c) always runs `check-apk-contents.py "$UNSIGNED_APK" --list`. Header comment and the step comment ("module is still off") were brought up to date. Same text in all three files (one script).
4. `shizuku/tools/check-gradle.py`: the old rules "the default is OFF" and "gradle.properties may not set includeShizuku" became "the default is ON" (`8F default`) and "gradle.properties may not set `includeShizuku=false`" (setting `=true` or a commented opt-out is fine). 4 new self-test cases (default flipped back; `=false` set; `=true` set; commented opt-out): 66 -> 70. `check-all.py` docstring says 70.
5. Stale comments fixed: `app/build.gradle.kts` (3 places), root `build.gradle.kts` (2), `check-merged-manifest.py` header, `check-all.py` S7 hint. Old step notes in this README stay as history.

**Decisions**
1. **Flipped despite the gate** (above). The alternative offered in the request notes (a workflow input, or waiting) was not taken because the row was asked for as written; the cost is that a first CI failure will break every build until fixed or rolled back.
2. **Rollback = the `step8e` zip**, not an edit. Switching the default alone back to `false` is not enough: the workflow block now demands Shizuku (`--require-shizuku`, always runs the APK check) and `check-gradle.py` demands the default on. A one-word rollback would have meant keeping the 8D-2 condition, which the row says to remove. Partial rollback for a person building locally: `includeShizuku=false` in `gradle.properties` (the Gradle build then works as before; only the workflow block and `check-gradle.py` object).
3. **A missing merged manifest is now an error** in the Shizuku block (it was a warning while the module was off): with the module on, a build that produced no manifest cannot be accepted.
4. **`check-all.py` is unchanged** (S7 still calls the merged-manifest checker without `--require-shizuku`: it runs on a bare checkout and for people; the workflows call the checker directly).
5. **The root-level Mika Maven lines and `MIKA_SHIZUKU_BUILTIN`**: `mika/tools/check-manifest.py` is not called by any workflow, so no workflow exports `MIKA_SHIZUKU_BUILTIN=1`; the Gradle task `:mika:patchMikaUpstream` sets it when `:shizuku` is in the build (7A-2.2), now always. Unchanged.

**What changes for every build now:** Gradle needs git + network to clone Shizuku (about 4 MB, cached in CI) and python3 to patch; the APK grows by the manager (code, resources, four ABIs of three native libraries); `:app` excludes the Rikka AppCompat fork; Mika's Maven Shizuku artifacts are replaced by local projects; Mika's `ShizukuProvider` is removed from the merged manifest by the overlay; the Start menu / Home icon / `rizwans2://shizuku` hooks (step 6) are live.

**Tried here.** `check-gradle.py --self-test` 70 of 70 and `--no-run` ok; `check-all.py` S1 - S4 ok, S5 - S7 skipped; `static-check.py` passed; `check-apk-contents.py --self-test` 33 of 33; `test-patch-host-package.py` 224 of 224; all workflows parse (PyYAML); the new block of each workflow passes `bash -n`.

**Not verified (this is most of it).** No build of any kind: Gradle configuration with 11 more projects, CMake for four ABIs, R8 of `:shizuku-shell`, D8 duplicate classes, the manifest merge (overlay removal, the 19 rules on a real merged manifest), the 16 KB alignment, the APK size, install and run on a device (starter by ADB / root, boot receiver, pairing). A **WithoutMe** run with the Mika tick box off and Shizuku on is a combination never looked at on a build: the overlay removes a provider that then does not exist (the merger should ignore it), and `check-provider-match.py` is skipped there. Local builds without network now fail at the fetch.

**Next:** 9A (docs), 9B (CHANGES), 10A (static check), 10B (final zip). **Before them, run one GitHub build** and send me the log of the first failure: with the switch on, step 9 / 10 documents should describe what really happened.


## 9A — final documents (Step 9, row 1 of 2; documentation only)

Request: do 9A, keep all details, updated full flat zip (`RizwanS2-main-shizuku-step9a.zip`). Based on `RizwanS2-main-shizuku-step8f.zip`.

**Result.** No code, script, workflow, Gradle file or manifest changed. Changed: `NOTICE-Shizuku.md`, `NOTICE-Mika.md` (one sentence), this file (plan rows 9 and 9A, a pointer in "First CI run", this section), root `README.md` (state line), new `docs/CHANGES-shizuku-part9a.md`.

### What was wrong in `NOTICE-Shizuku.md`, and is fixed
1. The intro said the module is "in preparation ... off by default"; it now says: in every build since 8F, never built.
2. The status list stopped at "planned (steps 5 - 7)"; it now lists steps 3 - 8 as written (hooks and Mika changes included; the two Mika source edits are named and point to `NOTICE-Mika.md`).
3. The permissions section said "off by default" and listed the night-mode problem as "known and not yet fixed"; 5G fixed it. Both lines corrected.
4. **Licence error found:** the library table gave RikkaX as **Apache-2.0**. The RikkaX repository's `LICENSE` is the **MIT** licence, Copyright (c) 2017 Rikka (read on the web in 9A). The row now says MIT and says it was corrected. This matters for what has to travel with the APK (MIT: the notice; Apache-2.0: the licence and the notices).
5. "To confirm in step 9" is gone. What 9A could read: RikkaX `LICENSE` (MIT); POM of `dev.rikka.hidden:stub` (MIT); POM of `io.github.vvb2060.ndk:boringssl`, newest version (OpenSSL + ISC); POM of the sibling `dev.rikka.ndk.thirdparty:cxx` (Apache v2.0); HiddenApiRefinePlugin repository (MIT). **Not confirmed:** the POM of `org.lsposed.libcxx:libcxx` (page could not be fetched), `dev.rikka.hidden:compat`, the pinned BoringSSL version (20250114), and every entry marked "as before" (MIT / Apache-2.0 statements of step 3, e.g. libsu, hiddenapibypass, BouncyCastle, gson, AppIconLoader, MaterialThemeBuilder, AndroidX): not re-read.
6. **Open item written down (not solved):** the built APK carries none of the Shizuku licence texts; only Mika ships licence files inside the APK. The follow-up (assets + an APK check like Mika's + a line in the About page) needs a build to try, so it waits. See the end of the library section of the notice.

### First CI run: everything in one place (steps 3 - 8)
The switch is on by default, so any normal run of one of the three workflows is the first run. Read the log in this order; the first failing line is the one to send.

| # | Log point (workflow step) | Expected | If it fails: likely cause -> where |
|---|---|---|---|
| 1 | `Fetch and patch Shizuku source`: package guard | passes | `applicationId` not the new package: the rename step did not reach `app/build.gradle.kts` -> rename step |
| 2 | same step: `fetch-upstream.sh` | `Shizuku v13.6.0 (2650830...) + API (510fc98...) ready` | "tag moved" / commit differs -> `UPSTREAM_COMMIT` / `UPSTREAM_API_COMMIT`; GitHub unreachable -> runner |
| 3 | same step: `patch-upstream.sh`, then `patch-upstream.py --check` | `D. self-check ok (...)` | the message names the rule and file: upstream differs from the v13.6.0 that 4A / 5A - 5G read -> `patch-upstream.py` (first real run of the patch on the real tree: the last full real run was in 4E-2, before 5A - 5G) |
| 4 | same step: `check-provider-match.py` (skipped in WithoutMe with Mika off) | `Shizuku provider match ok` | rule 1 - 8 in the message -> overlay / Mika patch |
| 5 | `Build Unsigned Release APK`: Gradle configuration | 11 more projects configure | AGP / plugin DSL details of 3C - 3F (table in "First CI run: what to look at", rows 1 - 3, 9, 10) |
| 6 | same step: native build | `libshizuku.so`, `libadb.so`, `librish.so` for 4 ABIs | Prefab package names / versions; a CMake *executable* that AGP does not pack (open since 3E) |
| 7 | same step: R8 of `:shizuku-shell`, D8 | one `classes.dex` -> `rish_shizuku.dex`; no duplicate classes | exclusions in `:shizuku` / `:app`; "not exactly one dex" in `shizukuRishDex` |
| 8 | same step: manifest merge | passes | `Overlay` / `tools:node` problems -> `app/src/shizuku/AndroidManifest.xml` (fallback way (iv) of 4B-1) |
| 9 | `Locate Unsigned APK`: `== Shizuku (built-in manager) in the APK ==`, `check-merged-manifest.py --require-shizuku` | `Shizuku manifest ... ok` (19 rules; first run on a REAL merged manifest) | one `::error::` per rule; either the rule (written from hand-made manifests) or the build is wrong |
| 10 | same step: `check-apk-contents.py --list` | a table: 3 libraries x ABIs (deflated, ELF machine right) + `rish`, `rish_shizuku.dex` | missing library = the CMake / packaging point of row 6; "STORED" = `useLegacyPackaging` / `extractNativeLibs`; alignment warning = 16 KB (first measurement) |
| 11 | later: install the APK | installs next to a previous Win11 | `INSTALL_FAILED_CONFLICTING_PROVIDER` = the overlay did not remove Mika's provider |
| 12 | later: device | see the device list of "4G-2" (item 4) and below | not testable in CI |

Rollback if the first run is unusable: the `step8e` zip (the default is off there and the workflows do not demand Shizuku). A local run without the module: `includeShizuku=false` in `gradle.properties`.

### What is still unproven, by area (consolidated; each item says who closes it)
1. **Build:** Gradle configuration, CMake x 4 ABIs, R8, D8, merged manifest, APK size (CI run, rows 5 - 9 above).
2. **Patch on the real tree after 5A - 5G:** `patch-upstream.py` + `--check` and `sweep-package-strings.py` on the real v13.6.0 checkout (the last full real run was 4E-2; 5A - 5G were written without network) (CI step 3; `sweep-package-strings.py` is not called by any workflow, decision for 10A).
3. **Merged manifest:** the 19 rules on a real manifest (row 9); the merged name `moe.shizuku.manager.MainActivity`.
4. **APK:** extraction, ELF machine, 16 KB alignment (row 10).
5. **Run time on devices (Android 14 - 17):** the starter by wireless debugging and by root; the shell / root user executing `libshizuku.so` from `nativeLibraryDir`; pairing service (`shortService` timeout, 5E); boot receiver and direct boot (5F, finding 12, finding 13 with 6E); night mode isolation (5G); the user-service bind of Mika through the manager's provider (7D); two ADB clients at once (Mika and the manager); the Start menu / Home / deep-link hooks (step 6). None of this was run.
6. **Combinations:** WithoutMe with Mika off and Shizuku on; the `apk_abis` input (fewer ABIs in the APK): `check-apk-contents.py` then checks the ABIs that are present; not run.
7. **Documents:** licence texts in the APK (above); About-page credit for Shizuku; the unconfirmed licence entries (above).

**Tried here.** `check-all.py` S1 - S4 ok (S5 - S7 skipped); `static-check.py` passed (it reads no `.md` file, so the notice edits were not machine-checked: the table rows were re-read after the edit, 6 columns each, and the stale phrases "to confirm in step 9", "step 9 decides" are gone, searched). Web checks listed in point 5 above; one page failed (`org.lsposed.libcxx`), one fetch was rate-limited and a different source was used.

**Next:** 9B (`docs/CHANGES-shizuku-part9.md`, steps 5 - 8 together); but the first GitHub build should come first: with the switch on, 9B / 10 should record what really happened.


## 9B — CHANGES for steps 5 - 8 (Step 9, row 2 of 2; documentation only)

Request: do 9B, keep all details, updated full flat zip (`RizwanS2-main-shizuku-step9b.zip`). Based on `RizwanS2-main-shizuku-step9a.zip`.

**Result.** No code, script, workflow, Gradle file or manifest changed. New: `docs/CHANGES-shizuku-part9.md` (the combined notes) and `docs/CHANGES-shizuku-part9b.md` (the row file). Changed: this file (plan rows 9 and 9B, this section), root `README.md` (state line).

### What `docs/CHANGES-shizuku-part9.md` holds
1. A table per step (5, 6, 7, 8) with every row, its result and whether code changed (29 rows; step 7 is also in `docs/CHANGES-shizuku-part7.md`).
2. What changed by area: the patch script (parts A - H), the tools, the Mika side, `:app`, the workflows, the documents.
3. The numbers of every checker, **measured again in 9B** (224 / 70 / 147 + 19 rules / 37 / 33 / 17 / 64 checks), and the three tools that are not wired (row 10A decides).
4. Findings 9, 11, 12, 13, 14, 15, 16: how each ended (16 left on purpose).
5. Decisions that matter later (reflection and the R8 note, the init call in `App.onCreate`, night mode in `attachBaseContext`, the direct-boot cost, 8F done without a CI run and the rollback zip, S7 without `--require-shizuku`).
6. Not done.

### Decisions
1. The small per-row files stay as history; the combined file does not replace them (same as step 7).
2. Numbers in the combined file are the ones measured in 9B; earlier rows keep the numbers they measured then.
3. 9B was written **before any GitHub build**, so it records what was written and checked, not what a build did. This was the owner's request (the 9A advice was to build first); the first run's result still has to be added to "First CI run" and to the combined file.

### Not done
Tried: the nine commands of the numbers table (all ok, as in the combined file). `static-check.py` reads no `.md` file, so the new texts were re-read by hand (table pipes counted per row, row names checked against the file names in `docs/`). Not verified: everything that needs a build or a device (see "What is still unproven" in "9A", unchanged). Steps left: 10A, 10B. **Next:** 10A (static checks and the decision about the three unwired tools); best after one GitHub build.


## 10A — static checks (Step 10, row 1 of 2)

Request: do 10A, keep all details, updated full flat zip (`RizwanS2-main-shizuku-step10a.zip`). Based on `RizwanS2-main-shizuku-step9b.zip`.

**Result.** Every checker of the project was run, on hand-made files **and, this time, on the real fetched sources** (GitHub was reachable): nothing failed, so nothing had to be fixed. The decision of the row: **the three tools that were not wired join `check-all.py`**, plus the real sweep. Code changed: `shizuku/tools/check-all.py` (steps S8 - S11, self-test 64 -> 84 checks) and four comments that said "not wired / 10A decides".

### The decision: what joined `check-all.py`
| Step | Script | Kind | Why |
|---|---|---|---|
| S8 `patch-self` | `test-patch-host-package.py` | always | 224 cases of the patch rules; no network, 0.3 s; it guards every change of `patch-upstream.py` |
| S9 `sweep-self` | `sweep-package-strings.py --self-test` | always | 37 cases, 0.3 s |
| S10 `apk-self` | `check-apk-contents.py --self-test` | always | 33 cases, 0.1 s; the real APK call stays in the workflows |
| S11 `sweep-real` | `sweep-package-strings.py` | new kind `sweep` | the same input test as S6 (patched checkout, else skip); `--no-real` skips it, `--require-real` fails on a skip |

Reasons: all three were cheap, offline and already green; leaving them out meant a change to the patch script could break them without the root check noticing. Not done: **no workflow calls the sweep** (it needs the patched checkout, which the workflows have, but its only extra over `patch-upstream.py --check` is the counting of host-package places; left for a person to run). The ids S1 - S7 are unchanged; the run order is by id.

Effects: a bare checkout now gives `7 step(s) ran ok, 4 skipped (S5, S6, S7, S11)` (was `4 ... 3`); with the fetched and patched sources `10 ran ok, 1 skipped (S7)`. Check 11 of `mika/tools/static-check.py` prints the last line of that, so its output line changed in the same way; its comment was updated.

### Self-test of `check-all.py` (84 checks)
New: the stubs of the four new scripts; case 1 expects seven script runs (not four) and the arguments of S8 - S10; case 2 fails each new script in turn and expects only its own step to fail while all seven static steps still run; case 5 expects S11 to run once without arguments on a patched checkout; case 7 (`--no-real`, `--require-real`) names S11; case 11 expects five kinds of step. A mutation (S11 called with `--check`) made exactly the new case 5 check fail, so it can fail.

### What was run (10A)
| Command | Result |
|---|---|
| `check-gradle.py` | ok (15 `.kts` files, 11 namespaces, 7 helper runs) |
| `check-gradle.py --self-test` | 70 of 70 |
| `test-patch-host-package.py` | 224 of 224 |
| `test-check-merged-manifest.py --no-real` | 147 cases, 19 rules covered |
| `check-provider-match.py --self-test` | 17 of 17 |
| `sweep-package-strings.py --self-test` | 37 of 37 |
| `check-apk-contents.py --self-test` | 33 of 33 |
| `check-all.py --self-test` | 84 checks ok |
| `check-all.py --no-real` | S1 - S4, S8 - S10 ok; S5 - S7, S11 skipped |
| `mika/tools/static-check.py` (without the Mika source) | all checks passed |

**On the real sources** (`fetch-upstream.sh` for Shizuku v13.6.0 and Mika 0.1.52, then both patch scripts; the Shizuku step of the workflows was run as written, in a scratch copy of the same tree, with `NEW_PKG=com.srizwan.win11`):
| Command | Result |
|---|---|
| Shizuku patch parts A - H, then `patch-upstream.py --check` | self-check ok, numbers as in 5G (5 host places in 5 files, 4 kept binder keys, 237 names, 87 files, 42 languages, five direct-boot components) |
| forced second pass (`SHIZUKU_FORCE_PATCH=1`) | ok |
| `check-provider-match.py` | ok (8 rules, real manifests of Shizuku and Mika) |
| `sweep-package-strings.py` | ok: 357 files, host package in 7 files / 7 places, binder key kept 4 / 4, one `[review]` line (`AppConstants.PACKAGE`, as recorded in 5D) |
| Mika patch (switch unset, then `MIKA_SHIZUKU_BUILTIN=1`) and `mika/tools/check-manifest.py` in both states | OK (30 permissions, 65 provider authorities); queries / package counts `(stock)=0` and `(host)=1` as designed |
| `check-all.py` with the sources | S1 - S6, S8 - S11 ok, S7 skipped |
| `mika/tools/static-check.py` with the Mika source | all checks passed (workflows: 6 files, 72 run steps, YAML + `bash -n`; 1795 XML files; 14 modules, 0 resource clashes) |

This is the first real run of the patch after steps 6 - 9: nothing in them changed the patch script, and the real tree agreed. The fetched folders (`shizuku/upstream`, `mika/upstream`) are git-ignored and were **removed before the zip was made**.

### Notes the row asked for
1. **R8.** `:app` has `isMinifyEnabled = false`. If it is ever switched on, keep rules are needed for `moe.shizuku.manager.MainActivity` (6A: started by class name) and `moe.shizuku.manager.ShizukuApplication.onCreate` (6E: reflection). Nothing to do today.
2. `S7` (merged manifest) is still skipped here: it needs `./gradlew :app:assembleRelease`; the workflows run it on every build since 8F.
3. Finding 16 (Android 8.0 / 8.1 chooser) stays as decided.

### Not done
Everything that needs a build or a device (see "What is still unproven" in "9A"): Gradle configuration, CMake, R8, D8, the real merged manifest (S7), the APK check on a real APK, install and run. **Still no GitHub build.** The sweep is not called by a workflow. Earlier sections keep the numbers and the "not wired" wording they had when written. Steps left: **10B** (final flat zip `RizwanS2-main-shizuku-final.zip`). Next: 10B, ideally after one GitHub build.


## 10B — final flat zip (Step 10, row 2 of 2; documentation only)

Request: do 10B, keep all details, updated full flat zip (`RizwanS2-main-shizuku-final.zip`). Based on `RizwanS2-main-shizuku-step10a.zip`.

**Result.** The plan (steps 1 - 10) is complete. No code, script, workflow, Gradle file or manifest changed in this row. Changed: this file (plan rows 10 and 10B, this section), root `README.md` (heading and state line; the heading said "in preparation"), new `docs/CHANGES-shizuku-part10b.md`.

### What the final zip is
- The state of `step10a` plus the three text changes above. Files at the zip root, no top folder, no `shizuku/upstream`, no `mika/upstream`, no `__pycache__`, no `.git`.
- The file list differs from `step10a` by exactly one file, `docs/CHANGES-shizuku-part10b.md` (compared by `unzip -Z1`).
- Rollback points: `RizwanS2-main-shizuku-step8e.zip` (switch off, workflows do not demand Shizuku); `includeShizuku=false` in `gradle.properties` for a local run without the module.

### Checked again before packing
`check-all.py` (S1 - S4, S8 - S10 ok; S5 - S7, S11 skipped: no fetched source in the zip), `check-all.py --self-test` 84 checks, `mika/tools/static-check.py` all checks passed. The 10A table of real-source runs was not repeated: nothing it covers changed.

### What to do next (the owner's side)
1. Run one of the three workflows. The first failing line decides what is next; the 12 log points with expected result and likely cause are in "9A" ("First CI run: everything in one place").
2. Send that line. A fix belongs in the patch script, the overlay or a Gradle file, and the matching checker rule should follow it.
3. When a run is green: put the real result into "First CI run" and into `docs/CHANGES-shizuku-part9.md`, then the device list of "4G-2" (starter by wireless debugging and root, pairing, boot, night mode, Start menu / Home / deep link, the Mika user-service bind).

### Still open (unchanged, nothing here closes it)
Everything that needs a build or a device; the licence texts are not inside the APK (open item of 9A); some licence entries of `NOTICE-Shizuku.md` are marked unconfirmed; no workflow calls the sweep; finding 16 stays as decided; R8 keep rules only if minify is ever switched on.

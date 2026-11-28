# Shizuku — part 4 of 10 (all rows 4A ... 4G-2): the manifest merge is done

Request: 4G-2, keep all details, update the full flat zip. Based on `RizwanS2-main-shizuku-step4g1.zip` (4A - 4F and 4G-1 done there). This file sums up the whole of step 4. The combined files of the letters (`CHANGES-shizuku-part4b.md`, `part4c`, `part4d`, `part4e`) and the small ones (`part4a`, `part4a2`, `part4b1` - `part4b3`, `part4c1` - `part4c4b`, `part4d1` - `part4d3`, `part4e1` - `part4e4b`, `part4f1` - `part4f3`, `part4g1`, `plan-split`) stay as history.

New: `docs/CHANGES-shizuku-part4.md` (this file).

Changed in 4G-2 (documentation only):
- `shizuku/README.md`: plan row 4 (done, 26 of 26 rows), row 4G-2 (done, details fixed), new section "4G-2" (the 26 rows at a glance, what changed in the project by kind, the final state of the 14 findings, 15 consolidated decisions, the checks that exist now, the open list for the first CI run, the hand-over to steps 5 - 8, what was run), a short note appended to rows 5A, 5F, 7A-1, 7B, 7C (a correction), 7D and 8F.
- `README.md` (root): plan row 4 (done), new paragraph "State after step 4G-2".
- `NOTICE-Shizuku.md`: the two status lines (step 4 is done up to 4G-2).

No code, script, manifest, overlay, Gradle file or workflow touched; nothing built. `includeShizuku` is still off by default. Flat zip: `RizwanS2-main-shizuku-step4.zip` (files at the zip root; no `shizuku/upstream/`, no `mika/upstream/`, no `__pycache__`).

## What step 4 did, letter by letter

**4A — inventory.** The real v13.6.0 manifests (Shizuku `2650830`, API `510fc98`) and Mika 0.1.52 (`7ff1703`) were read. 14 components of `:shizuku` listed (13 rows in the table; the heading says 14, left as it is). Findings 1 - 10 written; 11 (4D-2), 12 and 13 (4D-3) and 14 (4D-4) were added later.

**4B — the provider clash (finding 1).** `:mika` and the manager both declare a provider with the authority `${applicationId}.shizuku` (`INSTALL_FAILED_CONFLICTING_PROVIDER`).
- 4B-1 decided a build-type manifest overlay wired only when `:shizuku` is in the build (rejected: patching Mika's generated manifest, an unconditional marker in `src/main`, a product flavor; kept as fallback: a task that edits `MERGED_MANIFEST`).
- 4B-2 `app/src/shizuku/AndroidManifest.xml` (`<provider android:name="rikka.shizuku.ShizukuProvider" tools:node="remove" />`, no `package`) and the wiring in `app/build.gradle.kts` for `debug` and `release` inside `if (shizukuIncluded)`.
- 4B-3 `shizuku/tools/check-provider-match.py` (6 rules, `--self-test` 12 cases) and rule 2 of `mika/tools/check-merged-manifest.py`: a missing Mika provider is accepted only if `moe.shizuku.manager.ShizukuManagerProvider` replaces it with an authority ending in `.shizuku`.
- 4B-4 comments: "cannot be installed yet" and "6 providers" (5 with Shizuku).

**4C — permissions and features (findings 2 - 5).**
- 4C-1 `patch-upstream.py` deletes the two `DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION` remove markers (in a library they would remove the permission from the whole app and crash AndroidX `registerReceiver(..., RECEIVER_NOT_EXPORTED)` on Android 8 - 12); it dies if upstream no longer has exactly these two.
- 4C-2 and 4C-3 two self-check rules in the patch script (10 and 15 hand-made cases); `MANAGER` (signature) and `API_V23` (dangerous) are declared once, by `:shizuku`; the `API_V23` guard stays; the host asks for `MANAGER` once; one comment in the `:app` manifest.
- 4C-4a five shared `uses-permission` identical, one each after the merge; 4C-4b `touchscreen` / `leanback` (`required="false"`) not new to the merged manifest and cannot hide the app; 4C-4c notes.

**4D — components (findings 6, 8, 9, 11 - 14).**
- 4D-1 nine activities, exactly three exported on purpose (`RequestPermissionActivity`, `ShellRequestHandlerActivity`, `LegacyIsNotSupportedActivity`); no LAUNCHER filter; the `APPLICATION_PREFERENCES` filter of `SettingsActivity` does not clash (`:j2me` has the same non-exported pattern).
- 4D-2 `AdbPairingService`: `shortService` needs only `FOREGROUND_SERVICE`; **finding 11**: no `onTimeout`, so a pairing that takes longer than about 3 minutes can crash the whole app on Android 15+ (the manager runs in the main process).
- 4D-3 the three `BOOT_COMPLETED` receivers (`:app` `.BootReceiver`, Mika `.setup.BootRestoreReceiver`, manager `BootCompleteReceiver`) coexist; order is undefined and harmless; **finding 12** (the manager's receiver is `directBootAware` and takes `LOCKED_BOOT_COMPLETED`, so the main process can start before the unlock) and **finding 13** (the boot receiver needs `ShizukuApplication.onCreate(app)`).
- 4D-4 the host keeps its `App`; the init call goes into the launcher-process part of `App.onCreate` (try/catch, after the `process start` log line, before Seal; Mika stays last); finding 12 decided as option (a+) (strip `directBootAware` from three components and the `LOCKED_BOOT_COMPLETED` filter); **finding 14** (the static `AppCompatDelegate.setDefaultNightMode` would turn the whole host dark or light); rows 5F and 5G added.

**4E — the merged-manifest checker.** `shizuku/tools/check-merged-manifest.py`, 17 rules: `4E-2` authority, owner, old provider, provider guard; `4E-3` dynamic receiver, no `API_V23` request, declared once, levels, manager request; `4E-4a` inventory, exported, launcher, service, boot receivers; `4E-4b` stale package, application class, old provider string. Self-test `test-check-merged-manifest.py` (4E-4c): 122 cases on a hand-made good manifest (22 + 30 + 42 + 24 + 4), a coverage check (each of the 17 rules switched off in turn must be noticed), registry 6, constants 1, helpers 23, command line 21 checks, and a run on a real merged manifest if a build exists (none here).

**4F — project-wide checks.**
- 4F-1 `check-gradle.py` got the manifest rules (`4F-1 overlay`, `4F-1 wiring`, `4F-1 src/main`, `4F-1 tools`) and `--self-test` (33 cases) and `--no-run`.
- 4F-2 the switch was re-read in every place that can set it (still off); the stale "cannot be installed with `:mika`" notes were corrected (comments and README only; `docs/CHANGES-*` stay).
- 4F-3 `shizuku/tools/check-all.py`: seven steps (S1 `check-gradle.py`, S2 its self-test, S3 the 122-case self-test, S4 `check-provider-match.py --self-test`, S5 `check-provider-match.py` on the real manifests, S6 `patch-upstream.py --check`, S7 the checker on the real merged manifest); S5 - S7 skip with a reason when their input is missing, `--require-real` makes a skip a failure; `--self-test` 64 checks; check 11 of `mika/tools/static-check.py` runs it.

**4G — notes.** 4G-1 `NOTICE-Shizuku.md`: new section "Permissions, who declares what", two new items in the list of changes. 4G-2: this part.

## What changed in the project during step 4, by kind
- New files: `app/src/shizuku/AndroidManifest.xml`; `shizuku/tools/check-provider-match.py`, `check-merged-manifest.py`, `test-check-merged-manifest.py`, `check-all.py`.
- Behaviour changed (only with `includeShizuku` on, except the Mika checker): the overlay and its wiring in `app/build.gradle.kts`; `patch-upstream.py` (one deletion, two self-check rules); `mika/tools/check-merged-manifest.py` rule 2 (the old path is taken in every build without Shizuku).
- Checks only: `check-gradle.py`, `mika/tools/static-check.py`.
- Comments and documentation only: `app/build.gradle.kts`, `app/src/main/AndroidManifest.xml`, `gradle.properties`, `settings.gradle.kts`, `NOTICE-Shizuku.md`, both READMEs.
- Never touched: the three build workflows, `keystore.yml`, `restore.yml`, `unzip.yml`, any Kotlin / Java file, any resource, the default of `includeShizuku`.

## The findings after step 4
| # | State |
|---|---|
| 1 | resolved (4B-2), checked in 4B-3, 4E-2, 4F-1 |
| 2 | fixed (4C-1), rule 4C-2, merged-manifest rule `4E-3 dynamic receiver` |
| 3, 4 | checked (4C-3), rules `4E-3` |
| 5 | checked (4C-4a, 4C-4b), nothing to change |
| 6 | checked (4D-2), rule `4E-4a service` |
| 7 | open: rows 7A-1, 7A-2 (the checker allows the one `<queries>` entry until then) |
| 8 | ok |
| 9 | note written (4D-4), row 6A |
| 10 | info, rows 5A / 5B |
| 11 | open, decided to patch: row 5E |
| 12 | decided (a+): row 5F |
| 13 | place fixed (4D-4): row 6E (call), row 8F (order) |
| 14 | decided: row 5G |

## Hand-over to steps 5 - 8 (notes added to the rows)
- 5A: what stays on purpose (permission names, namespace, `REQUEST_BINDER`, the undeclared `moe.shizuku.manager.permission.API`); finding 10 verified there.
- 5F: the direct-boot rule of the checker comes with the patch, with its bad case (the coverage check demands one) and the new rule / case counts.
- 7A-1: `STALE_QUERY_ALLOWED = 0` in the checker and `EXPECTED_STALE_QUERY_ALLOWED = 0` in the self-test in the same step; check `mika/tools/check-manifest.py` still agrees.
- 7B: already established on the real files in 4B-3.
- **7C (correction):** the row said Mika requests `API_V23`; with the switch on the host does not request it (the provider AAR's request is not merged, the manager's guard removes it elsewhere, Mika's own permission list has no Shizuku permission). 7C checks the run-time path with the host as the manager (4A: the server treats the manager's app id as always allowed; read, not run).
- 7D: the manager's provider also answers `sendUserService` (read, not run).
- 8F: after 6E and after a green first CI run; then `python3 shizuku/tools/check-all.py --require-real`.

## Checked here (4G-2)
- `python3 -I shizuku/tools/check-all.py`: S1 - S4 ok, S5 - S7 skipped (no fetched sources, no build), exit 0, before and after the edits.
- Self-tests: `test-check-merged-manifest.py --no-real` 122 cases, 17 rules covered; `check-gradle.py --self-test` 33 of 33; `check-provider-match.py --self-test` 12 of 12; `check-all.py --self-test` 64 checks.
- `python3 -I mika/tools/static-check.py`: all checks passed, including check 11.
- Markdown: equal column count in every table row of the changed files; no CR characters; no `__pycache__`, `shizuku/upstream/` or `mika/upstream/` in the zip.

## Not verified
Nothing of step 4 has been built. Open for the first CI run (`-PincludeShizuku=true`): the four AGP points of 4B-2 (`manifest.srcFile(...)` accepted by AGP 8.13.2; a `remove` marker that matches nothing is silent; an overlay without `package` merges; providers keyed by `android:name`); the real merged manifest against the 17 rules (explicit `android:exported`, fully qualified names, Mika's receiver name, `foregroundServiceType`, the `package` attribute, AndroidX core's elements, Mika's `<queries>` entry as written); S5 - S7 on real inputs; device behaviour (direct boot, the short-service limit on Android 14 - 17, night mode order with `MaterialActivity`, the hidden-API exemption, two ADB clients at the same time, boot broadcast delivery order); the licence column of `NOTICE-Shizuku.md` (step 9A).

Next: 5A (source sweep for `moe.shizuku.privileged.api` / `moe.shizuku.manager` strings that must now be the host package), then 5B-1 ... 5G, step 6 (hooks), step 7 (`:mika` hook-up), step 8 (CI and the switch).

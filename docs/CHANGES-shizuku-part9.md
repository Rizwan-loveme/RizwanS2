# Shizuku — steps 5 - 8 together (row 9B)

Based on the rows 5A, 5B-1, 5B-2, 5C, 5D, 5E, 5F, 5G, 6A, 6B-1, 6B-2, 6C, 6D, 6E, 7A-1.1, 7A-1.2, 7A-2.1, 7A-2.2, 7B, 7C, 7D, 7E, 8A, 8B, 8C, 8D-1, 8D-2, 8E, 8F (the small files `docs/CHANGES-shizuku-part5a.md` ... `part8f.md` stay as history; step 7 also has its own summary, `docs/CHANGES-shizuku-part7.md`; the row 9A file is `docs/CHANGES-shizuku-part9a.md`). Base zip of this row: `RizwanS2-main-shizuku-step9a.zip`.

**Everything below is static only. No build of any kind has ever been made** (no Gradle, no CMake, no R8 / D8, no manifest merge, no APK, no device). The switch `includeShizuku` has been ON by default since 8F, so the first normal GitHub run of one of the three workflows is the first real test.

## 1. Rows

### Step 5 — package-name hand-over and the patch script (parts A - H)
| Row | Result | Code changed |
|---|---|---|
| 5A | `shizuku/tools/sweep-package-strings.py`: reads the patched checkout, reports every `moe.shizuku.privileged.api`, counts the host-package places, sorts every `moe.shizuku.manager` use into namespace / class-name / permission / review; `--self-test` 30 cases (37 after 5C). Not wired into `check-all.py` or a workflow | yes (new tool) |
| 5B-1 | `patch-upstream.py`: `check_host_name()` (plain package name, because it is written unquoted into `pm path`), stop on an `applicationIdSuffix`, self-check `check_native_package()` (exactly one `#define PACKAGE_NAME "<host>"` in `starter.cpp`); new `test-patch-host-package.py` (32 cases) | yes |
| 5B-2 | `extractNativeLibs` dropped from the library manifest + self-check; `check-gradle.py` item 10 (packaging, manifest, ABIs, patch); 33 -> 44 self-test cases; patch tests 38 | yes |
| 5C | finding 15: the binder extra key `moe.shizuku.privileged.api.intent.extra.BINDER` is kept (4 files); part A now writes the host package in **5 places in 5 files**; self-check `check_binder_protocol()`; `check-gradle.py` item 11 (47); sweep 37; patch tests 60 | yes |
| 5D | intent actions read on the real v13.6.0 source: **no edit needed**; self-check `check_intent_actions()` (six rule groups); `check-gradle.py` item 12 (51); patch tests 88; finding 16 (Android 8.0 / 8.1 chooser) left on purpose | yes (checks only) |
| 5E | part F: `AdbPairingService` gets `onTimeout(startId)` and `onTimeout(startId, fgsType)` (finding 11); self-check `check_pairing_timeout()`; item 13 (56); patch tests 118 | yes |
| 5F | part G: `android:directBootAware` and `LOCKED_BOOT_COMPLETED` removed (finding 12); self-check `check_direct_boot()`; merged-manifest checker **17 -> 19 rules, 122 -> 147 cases** (`5F direct boot`, `5F custom actions`); item 14 (61); patch tests 162 | yes |
| 5G | part H: night mode applied per activity in `AppActivity.attachBaseContext` (finding 14); self-check `check_night_mode()`; **first run on the real v13.6.0 tree** (found a mistake in 5F: five components, not three); item 15 (66); patch tests 224 | yes |

### Step 6 — hooks in `:app`
| Row | Result | Code changed |
|---|---|---|
| 6A | `ShizukuLauncher.kt` (reflection, no compile-time reference): `isAvailable(ctx)`, `open(ctx)` | yes (new file) |
| 6B-1 | how "All apps" and `rizwans2://N` are built (same function `allAppsInOrder()`); a new "Shizuku" entry moves later apps by +1 where it is shown | no (docs) |
| 6B-2 | "Shizuku" item in `StartApps.builtInApps()`, taskbar branch in `MainActivity` | yes |
| 6C | Home icon (`VectorIconView.SHIZUKU`, `Win11Shell.buildDesktop()`) | yes |
| 6D | `rizwans2://shizuku` in `handleDeepLink`; `TerminalShare.builtInList()` line; manifest comment | yes |
| 6E | `ShizukuLauncher.initApplication(app)` called from `App.onCreate` (not `AppBase`, see decisions); finding 13 closed | yes |

### Step 7 — `:mika` hook-up (details: `docs/CHANGES-shizuku-part7.md`)
| Row | Result | Code changed |
|---|---|---|
| 7A-1.1 | Mika's `<queries>` entry = `${applicationId}` when `:shizuku` is in the build (`MIKA_SHIZUKU_BUILTIN`); check 13 | yes |
| 7A-1.2 | `STALE_QUERY_ALLOWED = 0` (and its self-test constant) | yes |
| 7A-2.1 | `SHIZUKU_PACKAGE` follows the host package; `openShizukuApp()` opens `moe.shizuku.manager.MainActivity` (Mika patch part 16) | yes |
| 7A-2.2 | check 14 of `mika/tools/check-manifest.py` | yes |
| 7B | one provider: rules 7 and 8 of `check-provider-match.py` (17 self-test cases) | yes |
| 7C | one permission, written down (read, not run) | no (docs) |
| 7D | `ShizukuShellUserService` bind path as a chain of four links (read, not run) | no (docs) |
| 7E | `NOTICE-Mika.md` section "Shizuku hook-up", `docs/CHANGES-shizuku-part7.md` | no (docs) |

### Step 8 — CI and the switch
| Row | Result | Code changed |
|---|---|---|
| 8A | `UltimateBuild.yml`: steps `Cache Shizuku source` and `Fetch and patch Shizuku source` (guard on `applicationId`, fetch, patch, `--check`, `check-provider-match.py`) | yes (workflow) |
| 8B | the same two steps in `UltimateBuild_NoWinlator.yml` (copied by script) | yes (workflow) |
| 8C | the same in `UltimateBuild_WithoutMe.yml`, no `if`, provider check only when `mika/upstream` exists | yes (workflow) |
| 8D-1 | `shizuku/tools/check-apk-contents.py` (3 libraries x ABIs, `rish`, `rish_shizuku.dex`; 33 self-test cases) | yes (new tool) |
| 8D-2 | merged-manifest check + APK-content check in `Locate Unsigned APK` of the three workflows (conditional on the manager's `MainActivity` in the merged manifest) | yes (workflow) |
| 8E | cache key reviewed: nothing to change | no (docs) |
| 8F | **default switch ON**: `settings.gradle.kts`, `gradle.properties`, Shizuku block of the workflows unconditional, `--require-shizuku`, `check-gradle.py` demands the default (+4 cases, 66 -> 70) | yes |

## 2. What changed, by area

**Patch script `shizuku/tools/patch-upstream.py`** (parts A - H, each anchor stops the script when upstream differs):
A host package (5 places in 5 files, binder key kept) - B library conversion - C resource prefix `sh_` - E generated `ShizukuLocales` - F pairing-service timeout (5E) - G direct boot (5F) - H night mode (5G) - D self-check (host name, native starter, native-libs attribute, permission ownership, binder protocol, intent actions, pairing timeout, direct boot, night mode, locales).

**Tools in `shizuku/tools/`:** `sweep-package-strings.py` (5A), `test-patch-host-package.py` (5B-1), `check-apk-contents.py` (8D-1) are new; `check-gradle.py` has items 10 - 15 (5B-2 ... 5G) plus the default-ON demand of 8F; `check-merged-manifest.py` and its test got the two 5F rules; `check-provider-match.py` got rules 7 and 8 (7B); `check-all.py` only has docstring / help text changes (S1 - S7 unchanged).

**Mika side:** `mika/tools/patch-upstream.py` part 15 (queries) and part 16 (`ShizukuController.kt`), `mika/build.gradle.kts` (`MIKA_SHIZUKU_BUILTIN`), `mika/tools/check-manifest.py` checks 13 and 14, `patch-upstream.sh` header comment; the merged-manifest checker's `STALE_QUERY_ALLOWED = 0`.

**`:app`:** new `ShizukuLauncher.kt`; edits in `StartApps.kt`, `MainActivity.kt`, `Win11Shell.kt`, `TerminalShare.kt`, `App.kt`; manifest comment only; `app/build.gradle.kts` comments only.

**Workflows:** the same fetch + patch + cache block (8A - 8C) and the same manifest / APK check block (8D-2) in all three; unconditional since 8F.

**Docs:** `shizuku/README.md` (a section per row), root `README.md` (state lines), `NOTICE-Shizuku.md` and `NOTICE-Mika.md` (9A, 7E), this file.

## 3. Numbers at the end of step 9A (re-measured in 9B, all as written in the rows)
| Tool | Cases / checks |
|---|---|
| `test-patch-host-package.py` | 224 |
| `check-gradle.py --self-test` | 70 |
| `test-check-merged-manifest.py --no-real` | 147 cases, 19 rules (4E-2 22, 4E-3 30, 4E-4a 42, 4E-4b 24, 5F 25, 4E-4c 4) |
| `sweep-package-strings.py --self-test` | 37 |
| `check-apk-contents.py --self-test` | 33 |
| `check-provider-match.py --self-test` | 17 |
| `check-all.py --self-test` | 64 checks |
| `check-all.py --no-real` | S1 - S4 ok, S5 - S7 skipped |
| `mika/tools/static-check.py` | all checks passed |

Earlier rows keep the numbers they measured then (e.g. 9 places in 7 files in 5B, 44 / 47 / 51 / 56 / 61 cases of `check-gradle.py`, 122 manifest cases, 17 rules).

Not wired into `check-all.py` or a workflow: `sweep-package-strings.py`, `test-patch-host-package.py`, `check-apk-contents.py --self-test`. Row 10A decides.

## 4. Findings of steps 5 - 8
| # | Finding | Result |
|---|---|---|
| 9 | task / process of the manager | closed in 6A (plain `startActivity`, same process) |
| 11 | `AdbPairingService` has no `onTimeout` | fixed in 5E |
| 12 | direct boot in the host | fixed in 5F (five components, not three: corrected in 5G) |
| 13 | `ShizukuApplication.onCreate` must run | closed in 6E (`App.onCreate`, class-presence guard) |
| 14 | night mode is process-wide | fixed in 5G |
| 15 | binder extra key must stay | kept in 5C |
| 16 | Android 8.0 / 8.1 chooser | **left on purpose** (untestable), owner decision |

## 5. Decisions that matter later
1. **Reflection, not a compile-time reference**, for everything in `:app` (6A, 6E): a class-name string keeps a build without `:shizuku` identical. If R8 is ever switched on for `:app`, keep rules are needed for `moe.shizuku.manager.MainActivity` and `ShizukuApplication.onCreate` (today `isMinifyEnabled = false`).
2. **The init call is in `App.onCreate`, not in `AppBase`** (6E), because the "without Rizwan" workflow replaces `AppBase.kt` by a stub.
3. **Night mode** is set in `attachBaseContext`, not `onCreate` (5G); read in the AppCompat source, not run.
4. **Direct boot cost** (5F): Shizuku's boot start runs after the first unlock.
5. **8F was done without a passing CI run**, which the plan asked for. Rollback = `RizwanS2-main-shizuku-step8e.zip` (default off, workflows do not demand Shizuku). Local opt-out: `includeShizuku=false` in `gradle.properties`.
6. **`check-all.py` S7** still calls the manifest checker without `--require-shizuku` (8F decision 4).
7. Statements that rest on reading, not on a run (7C, 7D, 5G order of calls, 5B-2 / 8D-1 packaging) are marked as such in the README.

## 6. Not done
Tried (9B): the nine commands of section 3 above, all as listed. This row changes documents only: no code, script, workflow, Gradle file or manifest.

Not verified, as before: everything that needs a build or a device (Gradle configuration of 11 more projects, CMake x 4 ABIs, R8 of `:shizuku-shell`, D8 duplicates, the manifest merge and the 19 rules on a real manifest, APK size, 16 KB alignment, install, starter by wireless debugging and root, pairing, boot, night-mode order, Start menu / Home / deep link, the Mika user-service bind); the patch on the real tree after 5G is only known from the 5G session (parts A - H, `--check`, forced second pass ok); the licence entries of 9A marked unconfirmed.

**9B was done before any GitHub build**, so this file records what was written and checked, not what a build did. When the first run exists, its result belongs in "First CI run" of `shizuku/README.md` and in a short addition to this file.

Steps left: 10A (static checks, and the decision about the three tools that are not wired), 10B (final flat zip `RizwanS2-main-shizuku-final.zip`). Next: 10A (best after one GitHub build).

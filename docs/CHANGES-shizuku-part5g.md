# Shizuku — row 5G (night-mode patch, finding 14) and a correction of 5F

Request: 5G, keep all details, update the full flat zip (the open-steps list at the top of the request: 5G next, then steps 6 - 10). Based on `RizwanS2-main-shizuku-step5f.zip`.

Result: **Shizuku's Light / Dark setting no longer reaches the host's own screens.** Upstream calls AppCompat's process-wide default night-mode setter in `ShizukuApplication.onCreate` and in the Settings screen; in the host that static is shared with all of `:app`. Now the stored setting is applied per activity.

## First run on the real source
GitHub was reachable in this session, so `fetch-upstream.sh` and `patch-upstream.py` ran on the real v13.6.0 tree for the first time. This found:
- **A mistake in 5F.** `RequestPermissionActivity` and `ShellRequestHandlerActivity` are `directBootAware` too (4D-3 had read three components). The patch stopped on its own anchor. `DIRECT_BOOT_COMPONENTS` now has five names; the 5F test manifest, the 5F cases, `check-gradle.py` item 14 and its self-test follow. The merged-manifest rules did not need a change.
- Two mistakes in the new 5G self-check (a regex that stopped at the wrong `if`, and `MainActivity` being Java), both fixed before this zip.
- The nested `api/` checkout is patched as well and must be reset with the root when resetting by hand.

## What part H of `shizuku/tools/patch-upstream.py` does (`patch_night_mode`)
- `ShizukuApplication.kt` (part B's template): no `AppCompatDelegate`, no setter; part H asserts it.
- `SettingsFragment.kt`: the one setter line becomes a comment; `activity?.recreate()` stays (the preference persists the value right after the change listener, the relaunch comes later).
- `AppActivity.kt`: imports plus `override fun attachBaseContext(newBase: Context)` with `delegate.localNightMode = ShizukuSettings.getNightMode()` in `try / catch (e: Throwable)`, then `super.attachBaseContext(newBase)`. **Deviation from the plan text** ("before the theme is applied", read as `onCreate`): AppCompat stores the local mode silently before the attach and applies it while wrapping the base context; set in `onCreate` it would recreate the activity. Read in the AppCompat source (androidx-main; the release in the build is not verified) and RikkaX `ThemedAppCompatActivity`; not run on a device.
- Every anchor stops the script when it is not there.

Self-check `check_night_mode()` (also in `--check` and S6): no setter call in the manager sources (comments do not count), the override is exactly right and in the class, the three imports, Settings still recreates, `ShizukuApplication` free of `AppCompatDelegate`, every manifest activity reaches `AppActivity` (Kotlin and Java superclasses, cycles safe). `check-gradle.py` item 15 guards the constants, the inserted code and the two calls.

## Numbers
| Tool | Before | Now |
|---|---|---|
| `test-patch-host-package.py` | 162 | 224 (4 for the five components, 58 for 5G) |
| `check-gradle.py --self-test` | 61 | 66 |
| merged-manifest checker | 19 rules / 147 cases | unchanged |
Real tree: patch parts A - H, `--check`, forced second pass: ok. `check-all.py`: S1 - S4 and S6 ok, S5 and S7 skipped. Mutations of the patch (setter kept, call after `super`, comments not stripped, chain check off, import kept) each break cases.

## Changed files
`shizuku/tools/patch-upstream.py`, `test-patch-host-package.py`, `check-gradle.py`, `check-all.py` (help text 66), `shizuku/README.md` (rows 5 / 5F / 5G, findings 12 / 14, new section "5G"), `README.md`, `NOTICE-Shizuku.md`, `app/build.gradle.kts` (comment only), this file.

## Not done
No Gradle build, no merged manifest (S7), no device test (night-mode order, no extra recreate, host screens unaffected after "Dark" in Shizuku). Steps left: 6A - 6E, 7A - 7E, 8A - 8F, 9A - 9B, 10A - 10B. Next: 6A (`ShizukuLauncher.kt`).

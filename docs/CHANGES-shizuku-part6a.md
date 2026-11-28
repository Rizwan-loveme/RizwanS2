# Shizuku — row 6A (`ShizukuLauncher.kt`)

Request: 6A, keep all details, update the full flat zip. Based on `RizwanS2-main-shizuku-step5g.zip`.

Result: `:app` has a small launcher object for the built-in Shizuku manager. Nothing calls it yet.

## New file
`app/src/main/kotlin/com/srizwan/win11/ShizukuLauncher.kt`
- `SECTION = "shizuku"`, `NAME = "Shizuku"`
- `isAvailable(ctx)`: class `moe.shizuku.manager.MainActivity` found by name **and** present in the installed merged manifest; never throws
- `open(ctx)`: starts that activity by `ComponentName`; false plus a short toast when Shizuku is not in the build or the start fails; never throws; logs via `AppLog`

## Decisions
1. **Reflection, no compile-time reference.** `:app` depends on `:shizuku` only with `-PincludeShizuku=true`; a direct class reference would break the default build. With the flag off, `isAvailable()` is false and the build is exactly as before.
2. **Task / process (finding 9 closed).** Plain `startActivity`; `FLAG_ACTIVITY_NEW_TASK` only for a non-Activity context. Back returns to the Win11 screen.
3. **Nothing exported.** The manager's `MainActivity` is not exported (4D-1) and has no LAUNCHER filter.
4. **R8 note for step 10A.** The class name is a run-time string; with `isMinifyEnabled = false` (today) nothing is needed, with R8 on a keep rule for `moe.shizuku.manager.MainActivity` must be added.

## Changed files
`app/src/main/kotlin/com/srizwan/win11/ShizukuLauncher.kt` (new), `shizuku/README.md` (plan row 6, row 6A done, new section "6A"), `README.md` (state line), this file. No other code, manifest, Gradle, workflow or patch script touched.

## Not done
No Kotlin compile, no Gradle build, no device test. `includeShizuku` stays off by default. Steps left: 6B-1, 6B-2, 6C, 6D, 6E, 7A - 7E, 8A - 8F, 9A - 9B, 10A - 10B. Next: 6B-1 (how "All apps" and `rizwans2://N` are built; docs only).

# Shizuku — row 6B-2 (the "Shizuku" item in the Start menu list)

Request: 6B-2, keep all details, update the full flat zip. Based on `RizwanS2-main-shizuku-step6b1.zip`.

Result: with `:shizuku` in the build, "Shizuku" appears in "All apps" and search and opens the manager. With the flag off (default until 8F) nothing changes.

## Changed code
- `app/src/main/kotlin/com/srizwan/win11/StartApps.kt`: `BUILTIN_CLS_SHIZUKU`, `SHIZUKU_PATH` (shield with a hollow check, even-odd), and one more block in `builtInApps()` guarded by `ShizukuLauncher.isAvailable(ctx)`.
- `app/src/main/kotlin/com/srizwan/win11/MainActivity.kt`: one taskbar-callback branch `section == ShizukuLauncher.SECTION` -> `ShizukuLauncher.open(this)`.

## Decisions
1. Shown only when the class is there and its activity is in the installed merged manifest.
2. Normal alphabetical place; apps after "Shizuku" move +1 only where it is shown (as documented in 6B-1). Not auto-pinned.
3. `TerminalShare.builtInList()` not changed: its `rizwans2://shizuku` link comes in 6D, the line is added there.
4. Icon is a vector only; the Home screen icon is 6C.

## Changed files
`StartApps.kt`, `MainActivity.kt`, `shizuku/README.md` (plan row 6 and 6B-2, new section "6B-2"), `README.md` (state line), this file. Manifest, Gradle, workflows, patch scripts, `ShizukuLauncher.kt`, `Win11Shell.kt`, `TerminalShare.kt` untouched.

## Not done
No Kotlin compile, no Gradle build, no device test; icon not rendered. Steps left: 6C, 6D, 6E, 7A - 7E, 8A - 8F, 9A - 9B, 10A - 10B. Next: 6C (Home screen icon).

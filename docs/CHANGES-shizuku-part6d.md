# Shizuku — row 6D (deep link `rizwans2://shizuku`)

Request: 6D, keep all details, update the full flat zip. Based on `RizwanS2-main-shizuku-step6c.zip`.

Result: `rizwans2://shizuku` opens the Shizuku manager; the terminal theme's `builtin` list has its Shizuku line.

## Changed code
- `MainActivity.kt`: `"shizuku" -> ShizukuLauncher.open(this)` in `handleDeepLink` (+ doc comment).
- `TerminalShare.kt`: `builtInList()` line guarded by `ShizukuLauncher.isAvailable(app)`; header comment.
- `AndroidManifest.xml`: comment only.

## Decisions
1. The existing scheme-only filter already matches: no new filter, no new exported component.
2. Numbers are tested first; `shizuku` cannot clash.
3. Flag off: the link shows a toast "not included in this build"; the terminal line is absent.
4. Pin / hide key `<app package>/builtin.shizuku` equals the Start menu entry's key.

## Changed files
`MainActivity.kt`, `TerminalShare.kt`, `app/src/main/AndroidManifest.xml` (comment), `shizuku/README.md` (plan row 6 and 6D, new section "6D"), `README.md` (state line), this file.

## Not done
No compile, no Gradle build, no device test; manifest checker not re-run. Steps left: 6E, 7A - 7E, 8A - 8F, 9A - 9B, 10A - 10B. Next: 6E.

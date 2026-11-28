# Shizuku — row 6C (Home screen icon)

Request: 6C, keep all details, update the full flat zip. Based on `RizwanS2-main-shizuku-step6b2.zip`.

Result: with `:shizuku` in the build, the Win11 Home screen shows a "Shizuku" icon that opens the manager. Flag off (default until 8F): nothing changes.

## Changed code
`app/src/main/kotlin/com/srizwan/win11/Win11Shell.kt` only: `VectorIconView.SHIZUKU` (constant, shield path, colour #5C7CFA, even-odd fill) and one guarded `desktopIcon` line in `buildDesktop()` (after Rizwan, before Winlator).

## Decisions
1. Drawable only; no permission, manifest or resource change.
2. Click reuses the 6B-2 taskbar branch (`onNavigate("shizuku")` -> `ShizukuLauncher.open(this)`).
3. Same `isAvailable(ctx)` test as the Start menu entry.

## Changed files
`Win11Shell.kt`, `shizuku/README.md` (plan row 6 and 6C, new section "6C"), `README.md` (state line), this file.

## Not done
No compile, no Gradle build, no device test; icon not rendered. Steps left: 6D, 6E, 7A - 7E, 8A - 8F, 9A - 9B, 10A - 10B. Next: 6D (deep link `rizwans2://shizuku` and the `TerminalShare` line).

# Shizuku — row 6B-1 (the "All apps" list and numbered links, docs only)

Request: 6B-1, keep all details, update the full flat zip. Based on `RizwanS2-main-shizuku-step6a.zip`.

Result: written down how the list and the `rizwans2://N` links work, and whether a new item changes existing numbers. **No code, manifest, Gradle, workflow or script changed.**

## Findings
- The list on screen and the number link use the same function, `Win11Shell.allAppsInOrder()`: visible apps, the "#" group first, then A - Z by label (case-insensitive). Number 1 is the first row on screen.
- `MainActivity.deepLinkNumber` accepts `rizwans2://N`, `#N`, `app/N`; `launchAppNumber` opens `list[n - 1]`; out of range does nothing. Numbers are tested before names, so `rizwans2://shizuku` (6D) cannot clash.
- **A new "Shizuku" entry moves every app after it in A - Z by +1**, only where it is shown (`:shizuku` in the build; default off until 8F). Numbers already move when any app is installed, removed or hidden, so 6B-2 keeps the plain alphabetical place.
- `defaultPins()` does not auto-pin a new S entry (read, not run).
- 6B-2 also needs: one taskbar-callback branch for `ShizukuLauncher.SECTION`, and a decision on `TerminalShare.builtInList()` (needs the 6D deep link first).

## Changed files
`shizuku/README.md` (plan row 6, row 6B-1 done, new section "6B-1"), `README.md` (state line), this file.

## Not done
Nothing run (no Gradle, no device). Steps left: 6B-2, 6C, 6D, 6E, 7A - 7E, 8A - 8F, 9A - 9B, 10A - 10B. Next: 6B-2.

# Seal — part 9 of 10: documentation

Request: add Seal as a built-in app (like `:ppsspp`), update the workflow yml, keep all details, update the full flat zip. This turn: part 9 only (root `README.md`, `seal/README.md`, `docs/CHANGES-seal-*.md`). Documentation only: no source, manifest, Gradle or workflow file changed.

Steps (each ticked when done):
- [x] 1. Re-read `seal/README.md`, the Seal section of the root `README.md`, `NOTICE-Seal.md` and the part 1-8 notes; measure the numbers that go into the docs
- [x] 2. `seal/README.md`: new "Overview (part 9)" at the top (use, build, size, file map, update upstream, open points); status and plan table
- [x] 3. Root `README.md`: Seal section title (no longer "plan"), plan table, a short part 9 paragraph
- [x] 4. `NOTICE-Seal.md`: status line, tense, list of changes now covers parts 7 and 8
- [x] 5. This file: index of all Seal notes, numbers, checks
- [x] 6. Check the file names the docs mention; full flat zip

## Index of the Seal notes
| Part | File | Subject |
|---|---|---|
| 1 | `docs/CHANGES-seal-part1.md` | pin upstream, analysis, notice + licence, what is copied / dropped |
| 2 | `docs/CHANGES-seal-part2.md` | `:seal` / `:seal-color`, sources copied, `sl_` resource prefix (34 clashes -> 0) |
| 3 | `docs/CHANGES-seal-part3.md` | Gradle: plugins on Kotlin 2.2.10, dependencies, `:app` dependency |
| 4 | `docs/CHANGES-seal-part4.md` | `SealInit`, no second crash handler, self-update removed |
| 5 | `docs/CHANGES-seal-part5.md` | library manifest, no intent filters |
| 6 | `docs/CHANGES-seal-part6.md` | hooks, name "Downloader", download folder |
| 7 | `docs/CHANGES-seal-part7.md` | targetSdk 28, native libraries, ABI filter, `check-apk-native.sh` |
| 8 | `docs/CHANGES-seal-part8.md` | the three workflows, tick box, `apk_abis`, `check-merged-manifest.py` |
| 9 | this file | documentation |
Overview for a reader who knows none of it: `seal/README.md`, section "Overview (part 9)".

## Numbers put into the docs (measured on the tree of this zip)
- `seal/src`: 125 Kotlin files (upstream had 126: three self-update files were deleted in part 4, `SealInit.kt` added), 99 resource files; `seal-color/src`: 11 Kotlin files.
- Size of the APK is **not** measured (still "roughly +50-100 MB", an estimate from part 1).

## What changed in the text
- `seal/README.md`: status "parts 1-9 of 10"; the long status paragraph (it still said "next CI run compiles Seal" and described parts 1-6 in detail) is replaced by a short one, the details live in the part sections; plan row 9 done; overview added; file list of part 9 at the end. All older part sections are kept unchanged.
- Root `README.md`: the Seal heading said "(built-in downloader, plan)", now names the app; table row 9 done; a part 9 paragraph with the short version (use, build, open points) in front of the part 8 paragraph.
- `NOTICE-Seal.md`: "planned module" -> module; "Status: parts 1-6" -> "parts 1-9"; "planned list" -> list per part; one line for parts 7-8 (no change to Seal's source, only host build settings, helper scripts and workflows).

## Checked here
- Every file name the Seal docs mention in backticks was looked up in the tree: the unresolved ones (45 hits over all files) are all of four harmless kinds: paths written relative to Seal's package folder (`ui/page/AppEntry.kt`), upstream files that were deliberately deleted (`AppUpdater.kt` ...), the workflow files named without `.github/workflows/`, and this file before it existed. Nothing points to a file that should exist and does not.
- The facts in the new overview were taken from the files, not from memory: deep link and hook list (part 6 code in `SealLauncher.kt`, `MainActivity.kt`), the tick box and `apk_abis` (the workflow files of part 8), the checks (the two scripts), the Kotlin / resource counts (counted above).
- Only `.md` files differ from the part 8 zip (plus the new `docs/CHANGES-seal-part9.md`).
Not run: Gradle, CI, a device (as in every part).

## For part 10
Static check of the whole project (XML / YAML / shell / Python syntax, bracket balance of the Gradle files, resource names, manifest, nothing missing compared with the part 9 zip) and the last flat zip. If you want something changed first (for example the download folder `Download/Downloader`, the Android 10 gap, `apk_abis` on by default), say so before part 10.

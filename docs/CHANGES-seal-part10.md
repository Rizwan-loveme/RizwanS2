# Seal — part 10 of 10: static checks and the final flat zip

Request: add Seal as a built-in app (like `:ppsspp`), update the workflow yml, keep all details, full flat zip. This turn: part 10 (the last).

Steps (each ticked when done):
- [x] 1. Unpack the part 9 zip into a clean folder; count what is there
- [x] 2. XML / YAML / bracket check over the whole project (new reusable script `seal/tools/static-check.py`)
- [x] 3. Seal-specific checks: resources, manifest, imports, host symbols, overlays, patch script, workflows
- [x] 4. Docs: `seal/README.md`, root `README.md`, `NOTICE-Seal.md`, this file
- [x] 5. Final flat zip `RizwanS2-main-seal-final.zip`

## Result: no source, manifest, Gradle or workflow file had to be changed
Part 10 changed documentation only, plus one new helper script. Nothing from parts 1-9 was altered.

## Checks and results (all run on the tree of the part 9 zip)
| Check | Result |
|---|---|
| XML: every `.xml` in the whole project (606 files) parses | 0 errors |
| YAML: all 6 workflows parse; every `run:` step of the 3 build workflows passes `bash -n` (18 / 19 / 20 steps) | 0 errors |
| Brackets `{}()[]` of all 2336 `.kt` / `.kts` / `.java` files (string / comment aware) | Seal / Gradle / host: 0 errors. 2 reports, both **not Seal's** and unchanged old files (`Bcore/.../BundleInfo.java`, `mame/.../NetPlayHelper.java`): `javac` parses both without a syntax error, so they are false positives of the checker (braces inside char literals) |
| Script syntax: 12 `.sh` + 3 Seal `.py` (`bash -n`, `py_compile`) | 0 errors |
| Resources: 398 distinct `R.string / plurals / color / drawable / mipmap / xml / style / array` names used by Seal's Kotlin | all declared in `seal/src/main/res`, except `abc_action_mode_done` (appcompat's own string, kept on purpose since part 2) |
| Resources: `@...` references inside Seal's own `res` and the manifest (`Theme.Seal`, `Theme.Seal.Dialog` ...) | 0 missing |
| Manifest: `seal/tools/check-merged-manifest.py` run on `seal/src/main/AndroidManifest.xml` | exit 0: 3 activities with no intent filter, `DownloadService` `specialUse`, receiver, `SealFileProvider` |
| Imports: every `com.junkfood.*` import in `seal/` and `seal-color/` resolves to a declaration in the tree | 0 unresolved (deleted self-update classes are referenced nowhere) |
| Host -> Seal: `SealInit.init(...)` (`App.kt`), `com.junkfood.seal.MainActivity` (`SealLauncher.kt`), `SEAL_NAME`, `isSealUrl`, `openSeal`, `openSealWithUrl`, `VectorIconView.SEAL` | every use has a definition |
| Overlays: `seal/tools/overlay/*.kt` and `overlay-main/AndroidManifest.xml` against the files in `seal/src` | byte-identical (5 of 5) |
| `win11_patches.apply()` run again on a copy of `seal/` | 0 applied, 18 already in place, the copy is identical to the original (idempotent) |
| Workflows: `check-apk-native.sh`, `check-merged-manifest.py` and `apk_abis` present in all three; `WithoutMe` has 11 inputs, the other two 4 | as designed in part 8 |
| Licence: `LICENSE-Seal` is the GPL-3.0 text; `NOTICE-Seal.md` names upstream, commit, licence and the changes | present |
| Flat zip: no wrapper folder; every file of the part 9 zip is in the new zip (see below) | see below |

## New files
- `seal/tools/static-check.py` (the XML / YAML / bracket check above; run `python3 seal/tools/static-check.py <project root>`)
- `docs/CHANGES-seal-part10.md` (this file)

## Changed files (documentation only)
- `README.md` (plan row 10, a short part 10 paragraph), `seal/README.md` (status, plan row 10, "Part 10"), `NOTICE-Seal.md` (status line)

## Not run (nothing here could be)
Gradle, the Kotlin compile of `:seal` on Kotlin 2.2.10, the manifest merge, GitHub Actions, a real APK, a device. This sandbox has no Android SDK / NDK / Maven access. The static checks above find syntax and reference errors; they cannot find type errors, API changes between Kotlin 2.0.20 and 2.2.10, or run-time problems.

## What happens next (yours)
1. Run `UltimateBuild.yml` (or `UltimateBuild_NoWinlator.yml`). The first compile of `:seal` is in that run. If it fails, send me the first error lines and I fix them.
2. Read the log lines printed by `check-apk-native.sh` (which `libc++_shared.so` was kept, sizes) and `check-merged-manifest.py`.
3. Open points (unchanged, still yours to decide): Android 10 storage gap (part 7); `apk_abis` default (off); download folder (`Download/` root vs `Download/Downloader`, part 6); GPL-3.0 for the combined app (general note in `NOTICE-Seal.md`; check before publishing).

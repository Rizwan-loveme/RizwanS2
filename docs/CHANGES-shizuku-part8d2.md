# Shizuku — row 8D-2 (manifest and APK check in the workflows)

Request: do 8D-2, keep all details, updated full flat zip. Based on `RizwanS2-main-shizuku-step8d1.zip`.

Result: the same 15-line block in `UltimateBuild.yml`, `UltimateBuild_NoWinlator.yml`, `UltimateBuild_WithoutMe.yml`, at the end of the step `Locate Unsigned APK` (after the T-UI check): `check-merged-manifest.py` on the merged release manifest (no `--require-shizuku`: passes while the module is off), and `check-apk-contents.py "$UNSIGNED_APK" --list` only when the merged manifest holds `moe.shizuku.manager.MainActivity`. A missing merged manifest is a warning. Header comment sentence updated in each file.

## Changed files
The three workflow files, `shizuku/README.md` (plan rows 8 and 8D-2, step 8 note, new section "8D-2"), `README.md` (state line), `docs/CHANGES-shizuku-part8d2.md` (new). No script changed.

## Decisions
1. "Module on" = the manager's `MainActivity` in the merged manifest (no Gradle flag is passed by the workflows before 8F; cannot hide a failure). 8F removes the condition and adds `--require-shizuku`.
2. `check-all.py --require-real` not used: with the Mika tick box off S5 skips and `--require-real` makes that a failure; S7 looks for a debug manifest.
3. The manifest is the merged manifest of the build (as Mika / Seal / T-UI), not the binary one in the APK; `extractNativeLibs` stays covered by `check-gradle.py` item 10 and the "not stored" rule of 8D-1.
4. Missing merged manifest = warning; one block in the existing step.

## Not done
Tried: YAML parses (3 files), `bash -n` on each block, the block executed in a temp tree: module off exit 0, module on + good APK exit 0, module on + missing `libshizuku.so` exit 1; `check-all.py` S1 - S4 ok; `static-check.py` passed. Not verified: any GitHub run, a real merged manifest, the merged name of the manager's activity in a real merge. Steps left: 8E, 8F, 9A - 9B, 10A - 10B. Next: 8E.

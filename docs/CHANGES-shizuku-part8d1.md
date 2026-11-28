# Shizuku — row 8D-1 (APK content script)

Request: do 8D-1, keep all details, updated full flat zip. Based on `RizwanS2-main-shizuku-step8c.zip`.

Result: new `shizuku/tools/check-apk-contents.py` (python3 only, `zipfile`). For every ABI with native libraries in the APK (or the ABIs of `--abis`) it requires `lib/<abi>/libshizuku.so`, `libadb.so`, `librish.so`: non-empty, ELF of the right class and machine, not stored; plus `assets/rish` and `assets/rish_shizuku.dex` (dex magic, header size = file size). A `PT_LOAD` alignment below 16 KB on arm64-v8a / x86_64 is a warning (`--strict-align` makes it an error). Exit 0 / 1 / 2.

## Changed files
`shizuku/tools/check-apk-contents.py` (new), `shizuku/README.md` (plan rows 8 and 8D-1, step 8 note, new section "8D-1"), `README.md` (state line), `docs/CHANGES-shizuku-part8d1.md` (new). No workflow, Gradle file, manifest or other script touched.

## Decisions
1. "Stored extracted" in the old row text is checked as "not stored": with `useLegacyPackaging = true` the libraries are deflated in the APK and extracted at install; stored means mapped from the APK, no file for the starter. The Mika check of the workflows tests only that files exist, so the old wording "as the workflows already do" was not literally true. The real attribute (`extractNativeLibs` in the binary manifest) is 8D-2.
2. There is no `starter` asset; the starter is `libshizuku.so`. The assets are `rish` and `rish_shizuku.dex`.
3. Not wired into a workflow and not in `check-all.py`: the module is off until 8F, so a call would fail every run today. The call comes with 8D-2, guarded by the module switch.

## Not done
Tried: `--self-test` 33 of 33 (a mutation with the stored check disabled failed exactly the 2 stored cases), `check-all.py` S1 - S4 ok, `static-check.py` passed, `check-gradle.py --no-run` ok. Not verified: any real APK (the test APKs are hand-made), AGP's packaging of these libraries, their real machine types and alignment, any GitHub run. Steps left: 8D-2, 8E, 8F, 9A - 9B, 10A - 10B. Next: 8D-2.

# Shizuku — row 5B-2 (native libraries and packaging)

Request: 5B-2, keep all details, update the full flat zip. Based on `RizwanS2-main-shizuku-step5a.zip` (5A and 5B-1 done there).

Finding: `libshizuku.so` (the native starter) is run from the host app's `nativeLibraryDir`, so the host must extract native libraries and the library must exist for every ABI the APK ships. `:app` already does the first (`useLegacyPackaging = true`, `android:extractNativeLibs="true"`); nothing guarded it, and the patch script did not drop `extractNativeLibs` from the library manifest. No other module ships `libshizuku.so`, `libadb.so` or `librish.so`.

Changed:
- `shizuku/tools/patch-upstream.py`: `extractNativeLibs` added to `APP_ATTRS_DROP`; new `check_application_attrs()` in the self-check (no `extractNativeLibs` on any `<application>` tag of the library manifest); success line and header comment updated. What the patch writes into the sources is otherwise unchanged.
- `shizuku/tools/check-gradle.py`: new item 10 — `5B-2 packaging` (`useLegacyPackaging = true` in `:app`), `5B-2 manifest` (`android:extractNativeLibs="true"` in the `:app` manifest), `5B-2 abis` (default of `shizukuAbis` names all four ABIs and feeds both `ndk` and `cmake` filters), `5B-2 abis property` (an uncommented `shizukuAbis` covers every ABI of the APK), `5B-2 patch` (the patch script drops the attribute). `--self-test`: 33 -> 44 cases. Header text updated.
- `shizuku/tools/test-patch-host-package.py`: 6 new cases (32 -> 38).
- `shizuku/tools/check-all.py`: docstring says 44 cases for S2 (no behaviour change).
- Docs: `shizuku/README.md` (plan row 5, row 5B-2 done with details, new section "5B-2", the live checks table, note in row 8D-1), `README.md` (plan row 5), this file. Earlier sections keep "33" as written then.

Run: `check-gradle.py --self-test` 44 of 44; `check-gradle.py` (also `--no-run`) ok; `test-patch-host-package.py` 38 of 38; `check-all.py` (S1 - S4 ok, S5 - S7 skipped); `mika/tools/static-check.py` all checks passed.

Not run / not read: the real `CMakeLists.txt`, `Starter.kt` and the patch script on the real source (no network); the APK contents (row 8D-1); device behaviour (execution of the extracted file by the shell user on Android 14 - 17, 16 KB alignment at targetSdk 37). No workflow, manifest, Gradle build logic, Kotlin / Java file or resource touched; `includeShizuku` is still off by default.

Flat zip: `RizwanS2-main-shizuku-step5b2.zip`. Next: 5C (binder extras and the `MANAGER` check), then 5D - 5G.

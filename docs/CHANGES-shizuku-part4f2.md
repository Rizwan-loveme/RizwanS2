# Shizuku — part 4F-2 of 10: switch default and stale notes

Request: 4F-2, keep all details, update the full flat zip. Based on `RizwanS2-main-shizuku-step4f1.zip` (4A - 4E and 4F-1 done there).

New: `docs/CHANGES-shizuku-part4f2.md` (this file).

Changed (comments and documentation only):
- `gradle.properties`: the comment of `includeShizuku` no longer says that an APK with `:mika` and `:shizuku` cannot be installed; it says the clash is removed by the build-type manifest overlay (4B-2), not built yet, switch off until 8F.
- `settings.gradle.kts`: two comment lines, same correction (the overlay path is not named on purpose, `check-gradle.py` rule `4F-1 wiring` forbids it in other build files).
- `app/build.gradle.kts`: one comment (4C - 4E are done; open: hooks and init call, patches 5E - 5G, CI work).
- `README.md` (root): the state paragraph and plan row 4 (in progress, 4A - 4E, 4F-1, 4F-2 done).
- `shizuku/README.md`: plan row 4 (4F-2 done, 4F-3 next), row 4F-2 (done, with the details fixed), the 3B decision "Off by default", the 3F decision 7, the 3F table row for `gradle.properties`, the "First CI run" command 3, new section "4F-2".

No build logic, script, manifest, overlay, workflow or Kotlin / Java file touched; nothing built. `docs/CHANGES-*` of earlier parts stay as history.

Re-check of the switch: default `"false"` in `settings.gradle.kts` (the only place that reads the property); no uncommented `includeShizuku` line in `gradle.properties`; `app` and root test `findProject(...)`; 0 mentions in the six workflows; none in any script outside `shizuku/`; `check-gradle.py` ok.

Checked here: `check-gradle.py` (also `--no-run`) and its `--self-test` 33 of 33; `test-check-merged-manifest.py --no-real` 122 cases; `check-provider-match.py --self-test` 12 of 12; `mika/tools/static-check.py`; `py_compile`; XML well-formedness; no `__pycache__` in the tree.

Not verified: that the APK installs with both modules (needs a Gradle build; first CI run, merged-manifest rules of 4E).

Next: 4F-3 (root checks), then 4G-1, 4G-2.

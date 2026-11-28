# Shizuku — row 8F (default switch ON)

Request: do 8F, keep all details, updated full flat zip. Based on `RizwanS2-main-shizuku-step8e.zip`.

**Warning: the plan's condition (a passing first CI run of 8D) is not met; no build has ever been made. The row was done as requested. Rollback = the `step8e` zip.**

Result: `includeShizuku` defaults to true in `settings.gradle.kts`; `gradle.properties` documents the opt-out `includeShizuku=false`; the Shizuku block of the three workflows is unconditional (error when the merged manifest is missing, `check-merged-manifest.py --require-shizuku`, `check-apk-contents.py` always); `check-gradle.py` now demands the default ON (+4 self-test cases, 66 -> 70); stale "off by default" comments fixed in `app/build.gradle.kts`, root `build.gradle.kts`, `check-merged-manifest.py`, `check-all.py`.

## Changed files
`settings.gradle.kts`, `gradle.properties`, `app/build.gradle.kts` (comments), `build.gradle.kts` (comments), the three workflow files, `shizuku/tools/check-gradle.py`, `shizuku/tools/check-all.py` (docstring, hint), `shizuku/tools/check-merged-manifest.py` (docstring), `shizuku/README.md`, `README.md`, `docs/CHANGES-shizuku-part8f.md` (new).

## Decisions
1. Flipped without a CI run (requested); the first GitHub build is the real test.
2. Rollback is the step8e zip: the default alone is not enough, because the workflows and `check-gradle.py` now demand Shizuku. Local opt-out: `includeShizuku=false` in `gradle.properties`.
3. A missing merged manifest is an error in the Shizuku block.
4. `check-all.py` S7 still calls the manifest checker without `--require-shizuku`.

## Not done
Tried: `check-gradle.py` 70 of 70, `check-all.py` S1 - S4 ok, `static-check.py` passed, `check-apk-contents.py` 33 of 33, `test-patch-host-package.py` 224 of 224, YAML parses, `bash -n` on the new blocks. Not verified: everything that needs a build (Gradle config, CMake, R8, D8, manifest merge, APK size, device behaviour); a WithoutMe run with Mika off and Shizuku on. Steps left: 9A - 9B, 10A - 10B (after one GitHub build). Next: one GitHub build, then 9A.

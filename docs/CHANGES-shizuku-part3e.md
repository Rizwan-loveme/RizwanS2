# Shizuku — part 3E of 10: the main module `:shizuku` (+ corrections to 3C / 3D)

Request: step 3E, **keep all details**, update the full flat zip. Based on `RizwanS2-main-shizuku-step3d.zip` (3A - 3D). Step 3 stays split in 8 sub-steps 3A - 3H (table in `shizuku/README.md`, "Step 3").
Still NOT in the project: 3F (`:app` / root side: dependency, AppCompat fork exclusion, replacement of `:mika`'s Maven Shizuku artifacts, `gradle.properties` notes), 3G (final docs of step 3), 3H (final checks).

Steps (each ticked when done):
- [x] 1. Unpack, run the baseline check (`check-gradle.py`: ok), fetch + patch the real upstream (**GitHub was reachable this time**: tag v13.6.0 + API commit, both commit-checked; patch script: all parts ok)
- [x] 2. Read the real sources: `manager/build.gradle`, root `build.gradle` / `settings.gradle`, the build files of all ten helper projects, both CMake files, the ProGuard rules, `ShizukuShellLoader`, the imports of every helper module, the sources of the two Rikka Gradle plugins (MaterialThemeBuilder, Hidden API Refine)
- [x] 3. `shizuku/build.gradle.kts` (the `:shizuku` library) + `shizuku/consumer-rules.pro`
- [x] 4. Corrections to 3C / 3D where the real sources differ (table below), `check-gradle.py` extended
- [x] 5. Checks: `check-gradle.py`; **real Kotlin compile of all 11 module build scripts** (Gradle's embedded compiler, plugin ids stubbed); layout check simulated against the real checkout; patch script re-run
- [x] 6. Docs: `shizuku/README.md` (plan table, sub-step table, new section "3E", notes in "3C" / "3D" / "Not checked here"), root `README.md`, `NOTICE-Shizuku.md`, `settings.gradle.kts` comment, this file
- [x] 7. Full flat zip `RizwanS2-main-shizuku-step3e.zip` (without `shizuku/upstream/`)

## Changed / new files
- new: `shizuku/build.gradle.kts`, `shizuku/consumer-rules.pro`, `shizuku/modules/provider/consumer-rules.pro`, `docs/CHANGES-shizuku-part3e.md`
- changed (corrections): `shizuku/modules/server/build.gradle.kts`, `server-shared/`, `starter/`, `rish/`, `shell/build.gradle.kts` + `shell/proguard-rules.pro`, `aidl/`, `provider/`
- changed (tooling / docs): `shizuku/tools/check-gradle.py`, `shizuku/README.md`, `README.md`, `NOTICE-Shizuku.md`, `settings.gradle.kts` (a comment only)
- not touched: root `build.gradle.kts`, `gradle.properties`, `app/`, every Kotlin / Java / resource / manifest / workflow file of the app, the patch and fetch scripts, `after-fetch.gradle.kts`, the three 3C modules that needed no correction (`shared`, `api`, `common`); `shizuku/upstream/` is not in the zip
- the build is unchanged while `includeShizuku` is off (default); with it on, the Win11 APK is still unchanged (`:app` does not depend on `:shizuku` before 3F)

## What `:shizuku` is
An Android **library**, namespace `moe.shizuku.manager`, reading `shizuku/upstream/manager/src/main/{java,res,assets,AndroidManifest.xml,jni}`. It also registers the tasks `:shizuku:fetchShizukuUpstream` / `:shizuku:patchShizukuUpstream` (the two that every `:shizuku-*` module waits for) and `:shizuku:shizukuRishDex` (the shell dex as a generated assets folder). Full table of what upstream's `manager/build.gradle` did and what is done instead, the task descriptions and the decisions: `shizuku/README.md`, section "3E".

## Corrections to 3C / 3D (found because the sources could be read)
| Module | Problem | Effect if left | Now |
|---|---|---|---|
| `:shizuku-aidl` | `wired` had `java`, but `api/aidl` has no `.java` file | `checkShizukuLayout` stops the build ("no .java file") before anything compiles | `wired = aidl` |
| `:shizuku-server` | 2 Kotlin files not known | `ApkChangedObservers.kt`, `ktx/Handler.kt` not compiled, `HandlerKt` missing | Kotlin plugin, gson, `starter`, `compileOnly provider`; no `:shizuku-api` |
| `:shizuku-server-shared` | no `rish`, `core`, `parcelablelist` | `rikka.rish.*` not found | added |
| `:shizuku-starter` | `api` instead of `shared` + `compileOnly provider` | `BinderContainer` not found | as upstream |
| `:shizuku-rish` | no `:api` | none seen | as upstream |
| `:shizuku-shell` | extra `rish` / `api` deps, own R8 rules | not harmful, not upstream's dex | upstream's rules and (no) dependencies |
| `:shizuku-provider` | no consumer rules | only with R8 on | own copy of the 5-line file |

## Not verified (read before the first CI run)
- Still no Gradle run (Maven Central, Google Maven, JitPack, plugin portal, Gradle distribution not reachable). The first real test is `./gradlew :shizuku:assembleDebug -PincludeShizuku=true`.
- Open points that only that run can answer (details in `shizuku/README.md`, "Not verified in 3E"): the AGP DSL calls no script here exercises (Variant API for the generated assets folder, `manifest.srcFile` in a library); **whether AGP packs `libshizuku.so` (a CMake executable) into a library**; the rikkax libraries without the AppCompat fork; androidx version lifts.
- What was checked: structure (`check-gradle.py`), a real Kotlin compile of every build script with stubbed plugins (found one real bug in the new file, a `/*` in a comment, fixed), the layout of all modules against the real checkout, the patch script on the real v13.6.0 source.

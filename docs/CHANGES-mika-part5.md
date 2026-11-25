# Mika (Rizwan) — part 5 of 15: Gradle wiring

Request: add Mika as a built-in **library** app called **Rizwan** (sources fetched at build time like PPSSPP / MAME / RetroArch), keep all details, update the full flat zip. "Hey Rizwan" will be the voice wake word (step 14). This turn: part 5 only.

Steps (each ticked when done):
- [x] 1. Read `settings.gradle.kts`, root / `:app` build files, `gradle.properties`, the sibling modules' dependency versions, the fetch script (does it undo the patch?)
- [x] 2. Version comparison Mika vs project (table in `mika/README.md`, "Step 5"); import scan of Mika's Kotlin; `BuildConfig` fields; source paths
- [x] 3. `settings.gradle.kts`: `include(":mika-core")`, `include(":mika")` + switch `-PincludeMika=false`
- [x] 4. `app/build.gradle.kts`: `implementation(project(":mika"))` (same switch), `androidResources { noCompress += "xz" }`
- [x] 5. `mika-core/build.gradle.kts`: protobuf `lite` option made robust (`maybeCreate("java")`); header notes of both Mika build files; `gradle.properties` comment
- [x] 6. Static checks (brackets in 4 Gradle files, paths, BuildConfig, imports), docs, full flat zip `RizwanS2-main-mika-step5.zip`

## Changed / new files
- changed: `settings.gradle.kts`, `app/build.gradle.kts`, `mika-core/build.gradle.kts`, `mika/build.gradle.kts` (header comment only), `gradle.properties` (comment only), `mika/README.md`, `README.md`
- new: `docs/CHANGES-mika-part5.md`
- not touched: any Kotlin / manifest / workflow file, `:mika` sources (none in the zip), the other modules

## Decisions taken here (say if you want them different)
- **Switch `-PincludeMika=false`**, default included. It exists so step 9 can add the CI `include_mika` tick-box without another change of `settings.gradle.kts`; do not use it before the stub of step 9 exists (`App : MikaApp()` in step 6 will not compile without `:mika`).
- Versions follow the project (already decided): coroutines stay on the root pin 1.9.0, xz 1.12 and webkit 1.12.1 win by Gradle's highest-version rule; protobuf runtime 4.36.2 lifts `:ppsspp`'s 4.33.5 (same major).
- No Maven mirror was added to `settings.gradle.kts` (upstream has a Google-storage mirror for Maven Central hiccups on GitHub Actions); say if you want it.
- `noCompress xz` is in `:app` for every build type.

## What changes for you
From this step on every build (also in the existing workflows, which are not changed until step 9) runs `fetchMikaUpstream` + `patchMikaUpstream`: git, python3 and network are needed once (about 83 MB), and the first compile of `:mika` (1,410 Kotlin files + 855 in `:mika-core`) is the first real test of steps 2 to 5. The APK gets bigger by about 58 MB of assets plus Mika's libraries. Nothing starts Mika yet (steps 6 to 8).

## Not run
Gradle, a compile, CI, a device (no Android SDK / network here). Expected first failures, in order, are listed in `mika/README.md` ("Step 5", risks). Send the first error lines of the first CI run.
Next: part 6 (`App : MikaApp()` with a process guard: launcher process only).

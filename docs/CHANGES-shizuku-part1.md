# Shizuku — part 1 of 10: pin upstream, fetch script, licences, analysis

Request: add Shizuku as a built-in app (module), **step 1**, keep all details, update the full flat zip. Owner decisions: the source is fetched at build time by a CI script (not stored in the zip);
scope = the Shizuku manager app (Start menu, start by Wireless debugging / root) **plus** hook-up with Mika (Rizwan). Part 1 only.

Steps (each ticked when done):
- [x] 1. Unpack the project zip; read `settings.gradle.kts`, `:camera` / `:ppsspp` / `:mika` as patterns, the Shizuku mentions already in the project (only `:mika`: client library 13.1.5)
- [x] 2. Find the newest stable tag of RikkaApps/Shizuku (**v13.6.0**; `sort -V`, not the raw `ls-remote` order, which ended at v5.1.0) and its `api` submodule commit
- [x] 3. Clone both, read settings / build files / manifest / JNI, grep the hard-coded manager package (9 places) and the provider authority clash with `:mika`
- [x] 4. Write `shizuku/UPSTREAM_VERSION`, `UPSTREAM_COMMIT`, `UPSTREAM_API_COMMIT`, `shizuku/tools/fetch-upstream.sh` (tested twice on the real GitHub)
- [x] 5. Licences: `LICENSE-Shizuku` (Apache-2.0), `LICENSE-Shizuku-API` (MIT, found different from the main one), `NOTICE-Shizuku.md`
- [x] 6. `.gitignore`, `shizuku/README.md` (plan + analysis), `README.md` section, this file
- [x] 7. Full flat zip `RizwanS2-main-shizuku-step1.zip`

## Changed / new files
- new: `shizuku/UPSTREAM_VERSION`, `shizuku/UPSTREAM_COMMIT`, `shizuku/UPSTREAM_API_COMMIT`, `shizuku/tools/fetch-upstream.sh`, `shizuku/README.md`, `LICENSE-Shizuku`, `LICENSE-Shizuku-API`, `NOTICE-Shizuku.md`, `docs/CHANGES-shizuku-part1.md`
- changed: `.gitignore`, `README.md`
- not touched: every Kotlin / Java / resource / manifest / Gradle / workflow file (the module is not in `settings.gradle.kts` yet, so the build is unchanged)

## Findings that decide the next steps
1. Upstream's manager is an application with a hard-coded package `moe.shizuku.privileged.api` in 9 places (server, starter, shell, native, API provider): step 5 patches them to `com.srizwan.win11` at build time.
2. Provider authority `${applicationId}.shizuku` is declared by both the manager and `:mika`'s `ShizukuProvider`: they would clash in the merged manifest (step 4 / 7).
3. Upstream's version number uses the git commit count (shallow clone = 1): replaced in step 3.
4. Native part: `libshizuku.so` (CMake, needs boringssl + libcxx prefab artifacts): step 3 and the CI APK check in step 8.

## Not checked here (no emulator / SDK / network for Gradle)
Nothing is compiled in part 1. The fetch script was run for real (clone, commit check, skip on second run); Gradle, CMake and the APK are checked by CI in later steps.

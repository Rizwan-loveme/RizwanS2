# Shizuku — part 3H of 10: final checks of step 3 and the flat zip

Request: step 3H, **keep all details**, update the full flat zip. Based on `RizwanS2-main-shizuku-step3g.zip` (3A - 3G inside; the plan table in the request still listed 3F / 3G as remaining, 3H is built on what the zip really contains).
Step 3 is now complete (3A - 3H). Steps 4 - 10 unchanged.

Steps (each ticked when done):
- [x] 1. Unpack, read `shizuku/README.md` (plan, 3A - 3G, decisions, first-CI-run checklist) and the memory of the project state
- [x] 2. `python3 shizuku/tools/check-gradle.py`: ok (15 `.kts` files, 11 unique namespaces, includes <-> folders consistent)
- [x] 3. Bracket / string / comment / `${}` scanner of `check-gradle.py` over all 33 `.kts` files of the project: no error
- [x] 4. `python3 mika/tools/static-check.py`: all checks passed (workflows, shell, Python, XML, stubs, hooks, Gradle modules, line endings, executable `*.sh`)
- [x] 5. YAML of the 6 workflows, `bash -n` of the Shizuku shell scripts, `ast.parse` of `patch-upstream.py`: ok
- [x] 6. Line endings: no real CR characters in the project's own build / script / doc files
- [x] 7. Root wiring read again by eye: `app/build.gradle.kts` (`shizukuIncluded`, dependency, packaging exclude, fork exclusion), root `build.gradle.kts` (substitution map, guarded by `findProject(":shizuku-api")`), `settings.gradle.kts` (switch default `false`), `gradle.properties` (comments only)
- [ ] 8. Re-run of the patch script on a real v13.6.0 checkout: **not possible** (no network: `fetch-upstream.sh` -> "Could not resolve host: github.com")
- [x] 9. Docs brought up to date (list below), full flat zip `RizwanS2-main-shizuku-step3.zip` (files at the zip root, without `shizuku/upstream/`)

## Changed / new files
- changed (status lines only): `shizuku/README.md` (plan row 3 and the 3H row, new section "3H", "Not checked here (3A - 3H)"), `README.md` (root: state paragraph, plan row 3), `NOTICE-Shizuku.md` (3A - 3H), `docs/CHANGES-shizuku-part3.md`
- new: `docs/CHANGES-shizuku-part3h.md` (this file)
- not touched: every build file, script, Kotlin / Java / resource / manifest / workflow file; the build is unchanged and `includeShizuku` is still off by default

## Not verified (read this before the first CI run)
Nothing of step 3 has been built: no Gradle run, no Kotlin parser, no network in the sandbox. The checks above prove structure (brackets, strings, includes, namespaces, cycles, substitution map, switch default), not behaviour. The first CI run with `-PincludeShizuku=true` may show errors; each one is a one-line fix in a known file (table "First CI run: what to look at" in `shizuku/README.md`). Send the log and I will fix it. The three commands, in order:
1. `./gradlew :shizuku:assembleDebug -PincludeShizuku=true -PshizukuAbis=arm64-v8a`
2. `./gradlew :app:dependencies -PincludeShizuku=true --configuration releaseRuntimeClasspath`
3. `./gradlew :app:assembleDebug -PincludeShizuku=true` (installable only without `:mika` until step 4: `INSTALL_FAILED_CONFLICTING_PROVIDER`)

## Next
- Step 4: manifest merge (provider authority clash with `:mika`, permissions `API_V23` / `MANAGER`, boot receiver).

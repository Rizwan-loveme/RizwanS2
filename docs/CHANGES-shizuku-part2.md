# Shizuku — part 2 of 10: patch script (library conversion, `sh_` resources, host package)

Request: step 2, **keep all details**, update the full flat zip. Question of the owner answered first: *does a library need a different package name?* The Java / Kotlin package (library namespace) stays;
only the run-time string `moe.shizuku.privileged.api` (9 places) must become the host package, because a library runs as the host app (see `shizuku/README.md`, "Step 2"). Part 2 only.

Steps (each ticked when done):
- [x] 1. Unpack the step 1 zip, fetch upstream with `fetch-upstream.sh`; list the 9 package places (grep over the whole tree, not only .java / .kt), resources (237 names, 25 layouts, 70 locales), manifest, styles
- [x] 2. Find what a library cannot keep: `Application` subclass, `BuildConfig.APPLICATION_ID`, LAUNCHER filter, `<application>` attributes, styles overriding library styles by name (found in `values-v21/themes_override.xml`)
- [x] 3. `shizuku/tools/patch-upstream.py` (+ `.sh` wrapper): A host package, B library conversion, C `sh_` resources, D self-check; marker + reset to pristine; every edit asserts its anchor
- [x] 4. Run on the real v13.6.0: first run, self-check caught 2 false positives in my own comments (fixed), second run, forced re-patch, host package changed and back, `--check`
- [x] 5. Independent look at the result (manifest, layout, styles, Kotlin, locales, literals, git status), not only the script's own check
- [x] 6. Docs: `shizuku/README.md` (Step 2 section + carried-over list), `NOTICE-Shizuku.md` (changes), `README.md` table, this file
- [x] 7. Full flat zip `RizwanS2-main-shizuku-step2.zip`

## Changed / new files
- new: `shizuku/tools/patch-upstream.py`, `shizuku/tools/patch-upstream.sh`, `docs/CHANGES-shizuku-part2.md`
- changed: `shizuku/README.md`, `NOTICE-Shizuku.md`, `README.md`
- not touched: every Kotlin / Java / resource / manifest / Gradle / workflow file of the project (the module is still not in `settings.gradle.kts`: the build is unchanged); `shizuku/upstream/` is not in the zip

## Decisions
1. Patch in place with a script (not a hand-edited copy): a version bump is one pin change, the changes are listed in one place, the CI package rename is followed.
2. Resource prefix on everything except ids and the 2 Shizuku attrs: renaming layouts changes ViewBinding class names, so those are rewritten too (68 uses).
3. The 4 override styles are dropped, not renamed: renamed they would do nothing, kept they would restyle the whole Win11 app.
4. `ShizukuApplication` becomes an object called from the host Application (step 6), instead of patching every entry point (activities, receivers, provider).

## Not checked here (no SDK / emulator / Gradle network)
Nothing is compiled. Checked: the script on the real source (several runs, package change), XML well-formedness, resource / R / binding reference closure, literals, git status of the checkout. CI compiles from step 3.

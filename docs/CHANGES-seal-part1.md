# Seal — part 1 of 10: source pinned, analysis, notices

Request: add Seal (https://github.com/JunkFood02/Seal) as a built-in app, the same way PPSSPP was added (`:ppsspp`), and update the workflow yml.

Done in this part (no code or build file changed):
- Source pinned: `seal/UPSTREAM_VERSION` = v2.0.0-alpha.5, `seal/UPSTREAM_COMMIT` = 7677f61a20fda4210e84215fef9e9b51d25daa47 (cloned and read here).
- Analysis (modules, 126 Kotlin files, 99 resource files, dependencies, manifest, permissions) and the fit with the Win11 build (Kotlin 2.2.10 / AGP 8.13.2 / targetSdk 28 / Compose off in `:app`): `seal/README.md`.
- `LICENSE-Seal` (GPL-3.0, upstream's file) and `NOTICE-Seal.md`.
- Root `README.md`: new "Seal" section with the 10-part plan.

Findings that change later parts:
- No native source and no assets: Seal needs no fetch step in CI (the yt-dlp engine is a Maven library), so part 8 is smaller than for PPSSPP.
- Upstream forbids other parties from using the name "Seal" for a downloader app (derivatives included): the built-in app will be shown under a neutral name (default "Downloader").
- The GitHub self-update of Seal must be cut out (it would install a different APK over Win11); the yt-dlp updater stays.
- FileProvider authority `${applicationId}.provider` does not clash with any existing provider in the project.

Next: part 2 (create `:seal` / `:seal-color`, copy the sources, resource-name clash scan).
Not run: Gradle, CI, a device (nothing was built; no build file was touched).

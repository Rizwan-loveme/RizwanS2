# Mika (Rizwan) — part 1 of 14: source pinned, analysis, notices

Request: add Mika (https://github.com/wangzan101/Mika) as a built-in **library** app called **Rizwan**, the same way PPSSPP / MAME / RetroArch were added
(sources fetched at build time), update all details and give a full flat zip.

Done in this part (no code or build file changed):
- Source pinned: `mika/UPSTREAM_VERSION` = 0.1.52, `mika/UPSTREAM_COMMIT` = 7ff1703f63b7cbf5741a29345c1b4507802c6b06 (read from the uploaded upstream zip).
- Analysis (modules, versions, manifest, permissions, resource clashes, `MikaApp` problem): `mika/README.md`.
- `LICENSE-Mika` (Apache-2.0, upstream's file) and `NOTICE-Mika.md`.
- `.gitignore`: `mika/upstream/`.
- Root `README.md`: new "Mika / Rizwan" section with the 14-part plan.

Findings that change later parts:
- `:core` is a pure JVM module, so it becomes `:mika-core` (Kotlin JVM plugin), not an Android library.
- `MikaApp` is final and cast to in 10 places -> `App` must extend it (patched open) and only start it in the launcher process.
- Only 13 resource names clash, so a targeted `mk_` rename is enough.
- Upstream's cleartext + user-CA network config and SEND/SEND_MULTIPLE filters must not leak into the whole app.
- minSdk 29 / targetSdk 35 upstream vs 26 / 28 here: `overrideLibrary` + runtime guard.

Next: part 2 (module build files) and part 3 (fetch script).
Not run: Gradle, CI, a device (nothing was built; no build file was touched).

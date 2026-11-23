# Step 8 (RetroArch, part 1 of 12) — upstream inspected, version pinned

New files
- retroarch/UPSTREAM_VERSION   — `v1.22.2`
- retroarch/README.md          — the 12-step plan and the full Step 1 findings (version, Android project, ndk-build, Java, manifest, assets / cores, resource clashes, tag vs master, licence)

No Gradle, manifest, CI or app code was changed yet (`:retroarch` is not included in `settings.gradle.kts` until step 3).
Decision recorded: cores are not bundled; RetroArch's own Online Updater / Core Downloader is used.

# Step 8 (RetroArch, part 7 of 12) — cores: online downloader only, plus the launcher picks the core (compiled for real, tested; NOT run on a device)

Your decision: no cores, info files or assets are bundled; RetroArch's Online Updater downloads them.

New files
- app/src/main/kotlin/com/srizwan/win11/RetroArchCores.kt — `RetroarchCores.pick(ext, coresDir, infoDir)`: which downloaded core opens a game extension (preference list per extension, then the `supported_extensions` of the core info files). `java.io` only.
- docs/CHANGES-step8-retroarch-step7.md — this file

Changed files
- app/src/main/kotlin/com/srizwan/win11/RetroArchLauncher.kt — `openRetroarchFile` sends the extras `ROM` + `LIBRETRO`; helper functions for the `cores` and `info` folders; new hint texts.
- retroarch/README.md — plan table (step 7 done), step-8 table row and "Not verified" paragraph corrected, new "Step 7" section.
- docs/CHANGES-step8-retroarch-step8.md — correction note (see below).
- README.md — RetroArch section (steps 1 to 8 done, step 7 text).

Found by reading upstream v1.22.2 (clone made with fetch-upstream.sh, not in the zip)
- The Online Updater, core updater and asset updater are compiled into the Android build (`Android.mk`); the buildbot URL for arm64 is `http://buildbot.libretro.com/nightly/android/latest/arm64-v8a/`.
- Everything is saved under the app's data folder (`cores`, `info`, `assets`, ...); no other module's use of those names was found.
- **Step 8 was wrong about one thing:** a game given WITHOUT a core does not show a core list. Upstream then passes the `cores/` folder as the core, the core cannot load and RetroArch shows its menu without the game. Fixed here: the launcher names the core.

Checked
- RetroArchCores.kt compiled with the real Kotlin compiler 2.2.10 (the project's version): no errors, no warnings. 22 checks on temporary folders: all pass.
- RetroArchLauncher.kt + RetroArchCores.kt compiled together against stubs of the Android classes they use: no errors, no warnings.
- NOT compiled: the other Kotlin files of step 8 (no Android SDK / Gradle here). NOT run: anything on a device.

Behaviour
- File Manager, console ROM: a fitting downloaded core exists -> the game starts in RetroArch. None -> RetroArch's menu opens and a toast says what to do (Online Updater -> Core Downloader, then Update Core Info Files).
- Start menu / Home icon / deep link: unchanged.

First use: Start menu -> RetroArch -> Online Updater -> Update Core Info Files -> Core Downloader (pick cores) -> optionally Update Assets -> File Manager -> tap a ROM. Some cores need BIOS files in RetroArch's `system` folder.

Effect on CI / APK size: none (no workflow change; one small Kotlin file).

Next: step 9 (NOTICE-RetroArch.md, LICENSE-RetroArch, GPL note), step 10 (CI in both workflows).

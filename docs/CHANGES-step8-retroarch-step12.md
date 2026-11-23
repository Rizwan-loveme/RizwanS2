# Step 12 (RetroArch, part 12 of 12) — final static checks and the final flat zip

Changed (docs and comments only): retroarch/README.md ("Step 12", plan table, title), README.md (RetroArch section), docs/CHANGES-step8-retroarch.md, settings.gradle.kts and app/build.gradle.kts (step counters in comments), this file. No Kotlin / Java / Gradle logic / manifest / workflow change.

Compared with the uploaded RizwanS2-youtube-step82.zip: nothing missing. New: NOTICE-RetroArch.md, LICENSE-RetroArch, docs/CHANGES-step8-retroarch.md, -step9.md, -step10.md (+ this file). Changed: both workflows, README.md, retroarch/README.md, gradle.properties, settings.gradle.kts, app/build.gradle.kts, retroarch/build.gradle.kts. Non-comment diff of the three .kts files: 0 lines.

Checks that passed
- bash -n on 4 shell scripts; XML (5 files of :retroarch + app manifest); YAML (5 workflows).
- include / dependency once; keep rules in both places; 6 ra_ resource names, 0 clashes with the other modules.
- Hooks: StartApps.kt, Win11Shell.kt, MainActivity.kt (KDoc + when), FileManagerUi.kt, FileExplorerUi.kt, App.kt.
- The 22 extensions: same in RetroArchLauncher.kt and in the docs; none of the excluded ones; no overlap with PPSSPP / J2ME literals.
- Kotlin brackets: the 8 involved files and all 188 Kotlin files, with a lexer that understands strings, templates, raw strings and comments. A first crude check flagged Win11Shell.kt and MainActivity.kt wrongly (the check was at fault; those files did not change).
- 10 Java files, exactly 3 marked WIN11; manifest classes exist; pin files well-formed; .gitignore / .gitattributes lines; Android.mk path agrees in the build file and the fetch script; workflow strings match the library manifest.
- Zip is flat and has no retroarch/upstream/.

Not run here: diff-upstream-java.sh (needs the 330 MB clone; no network), javac, the Kotlin compiler, Gradle, the NDK, CI.

Open items (unchanged): licence (MAME core binary, NewPipeExtractor notice, RetroArch file headers); first CI run (NDK 29 vs r22, disk, time, cache); device checks (core download, loading a core, switching games, menu before Update Assets).

Next for you: push the zip to GitHub and start UltimateBuild.yml; if it stops, retroarch/README.md "Overview" has the table of what to try first.

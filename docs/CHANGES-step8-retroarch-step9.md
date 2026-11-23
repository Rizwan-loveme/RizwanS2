# Step 9 (RetroArch, part 9 of 12) — licence files and GPL-3.0 note (documents only)

New files
- NOTICE-RetroArch.md: source and pin (v1.22.2, commit 69a4f0ea...), licence GPL-3.0, what to keep when distributing, the list of Win11 changes (3 edited upstream Java files marked WIN11, resources ra_, manifest, own process, nothing changed in C / makefiles), cores not bundled (own licences), and a compatibility table per part of the app.
- LICENSE-RetroArch: header + standard GPL-3.0 text (FSF).

Changed (comments / docs only)
- settings.gradle.kts: RetroArch comment points to the notice, "Steps 3-9 of 12"; the MAME line said "GPL-2.0" and now says "GPL-2.0-or-later" (corrected, see below).
- retroarch/build.gradle.kts, app/build.gradle.kts: step state / notice pointer. retroarch/README.md: table row 9, "Step 9" section. README.md: RetroArch section. This file.
- No Kotlin, Java, Gradle logic, manifest or CI change.

Checked
- MAME4droid: 51 Java files with a licence header, all "version 2 ... or (at your option) any later version" (+ LGPL linking exception). Upstream's licence FILE is the GPL-2.0 text, which is where "GPL-2.0" came from. -> GPL-2.0-or-later.
- PPSSPP (19 Java files) and RetroArch (10 Java files) carry no headers: their licence rests on upstream's statements.
- Result: no GPL-2.0-only part found among the checkable parts. Not legal advice.

Open for you (before publishing)
1. MAME core binary libMAME4droid.so: not checked (look for MAME files with "version 2" and no "or later").
2. NewPipeExtractor in :youtube (v0.26.5): GPL-3.0 as far as I know, not checked here; the project has no notice file for it.
3. RetroArch's own file headers: not re-checked (no network in this step). Not blocking.

Next: step 10 (CI in UltimateBuild.yml and UltimateBuild_NoWinlator.yml).

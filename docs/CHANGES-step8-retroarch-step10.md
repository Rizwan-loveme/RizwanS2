# Step 10 (RetroArch, part 10 of 12) — CI in both workflows (YAML written and checked statically, NOT run)

Changed files (the same edits in both)
- .github/workflows/UltimateBuild.yml and .github/workflows/UltimateBuild_NoWinlator.yml
- Comments only: settings.gradle.kts, app/build.gradle.kts, retroarch/build.gradle.kts. Docs: retroarch/README.md ("Step 10"), README.md (RetroArch section), this file.
- No Kotlin / Java / Gradle logic / manifest change. Timeout stays 120 minutes.

What the workflows do now
1. Header comment: RetroArch paragraph.
2. Free disk space: + docker image prune (df still printed before / after).
3. Cache RetroArch source: path retroarch/upstream, key retroarch-upstream-<hash of UPSTREAM_VERSION, UPSTREAM_COMMIT, tools/fetch-upstream.sh>.
4. Fetch RetroArch source (after "Fetch PPSSPP source", i.e. after the package rename): bash retroarch/tools/fetch-upstream.sh, 20 min limit; the script stops if the clone is not on UPSTREAM_COMMIT. Prints tag, commit, size, df.
5. ccache: "Set up ccache for PPSSPP and RetroArch" also sets ORG_GRADLE_PROJECT_retroarchCcache=true (NDK_CCACHE=ccache); CCACHE_MAXSIZE 3000M; cache key ccache-native-<os>-<hash(ppsspp version, retroarch commit)>-<run id> with the old ccache-ppsspp-<os>- prefix kept as the last restore key. A commented-out retroarchCFlags line is there for NDK 29 / old C code (off on purpose).
6. APK check ("Locate Unsigned APK", after MAME): fails if lib/arm64-v8a/libretroarch-activity.so is missing or under 1 MB; fails if the merged release manifest lacks MainMenuActivity / RetroActivityFuture or android:process=":retroarch" (only a warning if the merged manifest file is not found).

Not in the plan any more: a check for "RetroArch assets". Nothing is bundled since step 7 (online downloader only), so there are none.

Checked here: both files parse as YAML (25 / 26 steps), bash -n on every run block, step order, each edit matched exactly once per file, the library test and the manifest test run against fake data.
NOT verified: any GitHub run, the real merged-manifest path, cache size / quota, runner disk space, the native build itself (NDK 29 vs the tag's NDK r22).

Next: step 11 (docs), step 12 (final checks and zip).

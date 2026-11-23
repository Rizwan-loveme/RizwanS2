# Step 8 (RetroArch, part 3 of 12) — the `:retroarch` library module (wiring only)

New files
- retroarch/build.gradle.kts            — library `com.retroarch`: compileSdk 37, minSdk 26, project NDK (`ndkVer`), arm64-v8a by default (`-PretroarchAbis=...`), `BuildConfig.PLAY_STORE_BUILD = false`, Java 17, `useLegacyPackaging`, lint like the other modules; no dependencies (upstream's Java uses only the Android framework)
- retroarch/consumer-rules.pro          — keep `com.retroarch.**` and `com.libretro.common.vfs.**` (called by name from native code)
- retroarch/src/main/AndroidManifest.xml — placeholder `<manifest/>` (replaced in step 6)
- docs/CHANGES-step8-retroarch-step3.md — this file

Changed files
- settings.gradle.kts   — `include(":retroarch")` + comment
- app/build.gradle.kts  — `implementation(project(":retroarch"))` after `:mame`
- app/proguard-rules.pro — same keep rules as consumer-rules.pro (like `:mame`), header comment lists retroarch
- retroarch/README.md   — plan table (step 3 done) + "Step 3" section (decisions, checks, what is not verified)
- README.md             — RetroArch section updated (steps 1 to 3 done, next step 4)

Behaviour: none yet. The module is empty (no Java, resources, native code), so the APK is the same as before; no icon, menu entry or deep link was added.
Workflows: not changed (both run `./gradlew assembleRelease` for all modules; fetch / cache / APK checks come in step 10).

Checks (static only): manifest XML parses; brackets balance in the three Gradle files; one `include(":retroarch")`, one `project(":retroarch")`; `ndkVer` exists in the root build file; namespace `com.retroarch` is unique and untouched by CI's package rename.
Not verified: a real Gradle build (cannot run here). The next GitHub run is the test; if it fails on `:retroarch`, the likely suspects are `buildConfig` or the empty manifest.

Next: step 4 — `retroarch/tools/fetch-upstream.sh` (shallow clone of the pinned tag, `git rev-parse HEAD` must equal `UPSTREAM_COMMIT`) + Gradle task `fetchRetroarchUpstream`.

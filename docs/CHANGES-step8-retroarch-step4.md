# Step 8 (RetroArch, part 4 of 12) — fetch script + Gradle task

New files
- retroarch/tools/fetch-upstream.sh — shallow clone of the pinned tag into retroarch/upstream/ (git-ignored, not in the zip), commit checked against UPSTREAM_COMMIT, 9 required paths checked, 3 clone tries, `.git` kept, no submodules, nothing pruned
- docs/CHANGES-step8-retroarch-step4.md — this file

Changed files
- retroarch/build.gradle.kts — Gradle task `fetchRetroarchUpstream` (Exec: `bash tools/fetch-upstream.sh`), attached to configureNdkBuild* / buildNdkBuild* / generateJsonModel* / externalNativeBuild* (these tasks appear in step 5)
- settings.gradle.kts — comment updated (steps 3-4)
- .gitattributes — `*.sh text eol=lf`
- retroarch/README.md — plan table (step 4 done), "Step 4" section (behaviour, differences from PPSSPP's script, test table, size), step-1 note about `.git` corrected (Android.mk uses `git rev-parse ... 2>/dev/null`, so `.git` is wanted, not required)
- README.md — RetroArch section (steps 1 to 4 done, next step 5)

Tested by running the script for real (GitHub reachable from the sandbox)
- empty folder -> clone v1.22.2, 11,147 files, commit 69a4f0ea… matched, layout ok (about 332 MB: 265 MB files + 67 MB .git)
- second run -> "already present"
- wrong pinned commit -> error, clone deleted, exit 1
- bad UPSTREAM_COMMIT / bad UPSTREAM_VERSION -> clear error, exit 1
- hand-placed source without .git -> warning, accepted
- required path removed -> error naming the path, exit 1
The clone made for these tests is NOT in the zip (retroarch/upstream/ was deleted before zipping).

Behaviour in the app / CI: unchanged. The new task is dormant until the module has a native build (step 5), so CI does not clone RetroArch yet (it would add 330 MB and time to every run for nothing).
Not verified: running the script through Gradle's Exec task on CI.

Next: step 5 — native build (externalNativeBuild ndkBuild on upstream/pkg/android/phoenix-common/jni/Android.mk, ABIs, APP_PLATFORM=android-26, ccache).

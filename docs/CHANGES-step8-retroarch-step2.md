# Step 8 (RetroArch, part 2 of 12) — version pinned and verified

Checked on GitHub on 2026-11-23 (nothing was built, nothing from upstream is stored in the project).

Changed / new files
- retroarch/UPSTREAM_VERSION — `v1.22.2` (unchanged content, one line, no comments)
- retroarch/UPSTREAM_COMMIT  — NEW: `69a4f0ea1e8aaf442ae4858f2e7f2b31a1776576` (the commit behind the tag, with the check notes as comments)
- retroarch/README.md        — plan table (step 2 done) + a "Step 2" section: what was checked and how to move to a newer version
- README.md                  — RetroArch section updated (steps 1 and 2 done)
- .gitignore                 — `retroarch/upstream/` added (the clone made by step 4 must never enter git or the zip)
- docs/CHANGES-step8-retroarch-step2.md — this file

What was verified
- `git ls-remote --tags`: v1.19.1, v1.20.0, v1.21.0, v1.22.0, v1.22.1, **v1.22.2** (newest stable). Step 1 only had this from a mirror site.
- v1.22.2 is a lightweight tag -> commit 69a4f0ea…, committed 2025-11-20 00:17 UTC.
- No `.gitmodules` in the tag tree: no submodule clone needed.

Why the commit is pinned too
- A tag can be re-created on another commit. Step 4's fetch script will compare `git rev-parse HEAD` with UPSTREAM_COMMIT and fail the build on a mismatch; step 10 adds both files to the CI cache key.

Not changed yet: Gradle, settings.gradle.kts (`:retroarch` still not included), manifests, CI workflows, app code.
Decision kept from part 1: cores are not bundled; RetroArch's Online Updater downloads them.

# RetroArch (:retroarch) — consolidated change list, all 12 steps (written in step 11, closed in step 12)

Nothing here was built or run on a device: no Gradle, NDK or Android SDK in this environment. The first GitHub run is the test. Per-step files: docs/CHANGES-step8-retroarch-step1.md ... -step10.md. Overview and first-run failure table: retroarch/README.md ("Overview").

Decision from you (step 1, kept in every step): cores, core info files and assets are NOT bundled; RetroArch's Online Updater (Core Downloader) downloads them. It works because :app keeps targetSdk 28.

## New files
- retroarch/ : build.gradle.kts (step 3, native build step 5), consumer-rules.pro, UPSTREAM_VERSION (v1.22.2), UPSTREAM_COMMIT (69a4f0ea1e8aaf442ae4858f2e7f2b31a1776576), src/main/AndroidManifest.xml (step 6), src/main/java (10 upstream files, 3 edited and marked WIN11), src/main/res (ra_ names), tools/fetch-upstream.sh (step 4), tools/diff-upstream-java.sh (step 6, expects 3 changed files), README.md
- app/src/main/kotlin/com/srizwan/win11/RetroArchLauncher.kt (step 8), RetroArchCores.kt (step 7)
- NOTICE-RetroArch.md, LICENSE-RetroArch (step 9)
- docs/CHANGES-step8-retroarch.md (this file) and docs/CHANGES-step8-retroarch-step1.md ... -step10.md
- retroarch/upstream/ is NOT part of the zip: made by retroarch/tools/fetch-upstream.sh (about 330 MB, git-ignored)

## Changed files
| File | Change | Step |
|------|--------|------|
| settings.gradle.kts | include(":retroarch") + comments | 3, 4-11 comments |
| app/build.gradle.kts | implementation(project(":retroarch")) + comment | 3, comments later |
| app/proguard-rules.pro | keep com.retroarch.** and com.libretro.common.vfs.** | 3 |
| gradle.properties | commented retroarch* switches (retroarchCcache added in 11) | 5, 11 |
| .gitignore, .gitattributes | retroarch/upstream/ ; *.sh text eol=lf | 2, 4 |
| app/.../App.kt | no BlackBox / J2ME start-up in the :retroarch process (required) | 6 |
| app/src/main/AndroidManifest.xml | comment only | 6, 8 |
| app/.../StartApps.kt, Win11Shell.kt, MainActivity.kt, FileManagerUi.kt, FileExplorerUi.kt | Start menu entry, Home icon, rizwans2://retroarch (+ KDoc list), File Manager hook, file colours | 8 |
| retroarch/.../MainMenuActivity.java | accepts extras ROM and LIBRETRO (third edited upstream file) | 8 |
| retroarch/.../UserPreferences.java, RetroDocumentsProvider.java | no APK-asset extraction; ra_ resource names | 6 |
| .github/workflows/UltimateBuild.yml, UltimateBuild_NoWinlator.yml | cache, fetch, ccache, Docker prune, APK check | 10 |
| README.md | RetroArch section, MAME licence wording (GPL-2.0-or-later) | 1-11 |

## Behaviour in the app (64-bit ARM phones with libretroarch-activity.so; hidden elsewhere)
- Start menu "RetroArch", Home icon, rizwans2://retroarch: RetroArch's menu, or back to the running game.
- File Manager: nes fds sfc smc gb gbc gba n64 z64 v64 nds gen smd 32x sms gg pce sgx a26 a78 lnx ngp open in RetroArch with the downloaded core picked by RetroArchCores.kt; no fitting core: RetroArch's menu + a hint toast.
- Own process :retroarch; activities not exported; documents provider disabled; no second launcher icon.
- "All apps" numbers (rizwans2://N) shift by one after RetroArch, only where the entry is shown.

## Open items for you
1. Licence (step 9): the MAME core binary was not checked; no notice file exists for NewPipeExtractor (:youtube, GPL-3.0 as far as I know); RetroArch's own file headers were not re-checked. Not legal advice.
2. First CI run: NDK 29 vs the tag's NDK r22 (a commented retroarchCFlags line is ready in the workflows), runner disk space, time, cache size.
3. On a device: core download over http from the buildbot, loading a downloaded core, switching games, the menu before "Update Assets".

## Step 12 (final checks, no file changes except docs): see docs/CHANGES-step8-retroarch-step12.md.
Next for you: push the zip and start UltimateBuild.yml.

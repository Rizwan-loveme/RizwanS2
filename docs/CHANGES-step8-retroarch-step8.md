# Step 8 (RetroArch, part 8 of 12) — hooks in :app (written and checked statically, NOT compiled)

Changed / new files
- app/src/main/kotlin/com/srizwan/win11/RetroArchLauncher.kt (new): isRetroarchSupported(ctx), openRetroarch(), isRetroarchFile(name), openRetroarchFile(file).
- StartApps.kt: Start menu entry "RetroArch" (section "retroarch", game-pad vector icon, #2EC4B6). Win11Shell.kt: Home icon (VectorIconView.RETROARCH). MainActivity.kt: Start menu section + deep link rizwans2://retroarch (KDoc list updated). FileManagerUi.kt: console ROM files open in RetroArch. FileExplorerUi.kt: file colour for those extensions.
- retroarch/src/main/java/com/retroarch/browser/mainmenu/MainMenuActivity.java: finalStartup() accepts the extras ROM / LIBRETRO from the Intent that started it (marked WIN11; third edited upstream file). Not exported, so only Win11 can send them.
- retroarch/tools/diff-upstream-java.sh: expects 3 changed files. Comments only: retroarch/build.gradle.kts, settings.gradle.kts, app/build.gradle.kts, gradle.properties, app manifest. retroarch/README.md ("Step 8"), README.md (RetroArch section), this file.

Behaviour
- Start menu / Home icon / deep link: MainMenuActivity -> RetroArch's menu (or back to the running game). Only shown when the phone is arm64-v8a AND libretroarch-activity.so is in the app's lib folder.
- File Manager: nes fds sfc smc gb gbc gba n64 z64 v64 nds gen smd 32x sms gg pce sgx a26 a78 lnx ngp. Not: bin cue iso chd cso elf pbp (disc images / PPSSPP), zip 7z, md, vb, ws, wsc, ngc, col, int (ambiguous).
- No core is passed: RetroArch shows its own core list. No core downloaded yet -> RetroArch's menu + hint toast (Online Updater -> Core Downloader).
- RetroArch already running: same game -> to front; another game -> upstream onNewIntent ends the :retroarch process, the launcher polls (150 ms x 20) and starts the new game.

Checked here: brackets of the 6 Kotlin files, hand review of types in RetroArchLauncher.kt, all hook sites found by grep, extension list vs other handlers, icon rendered and looked at, diff script ("only the expected Win11 changes").
NOT verified: Kotlin compile (no compiler here), RetroArch's core list for ROM-without-core, the restart after switching games, anything on a device.

Next: step 9 (NOTICE-RetroArch.md, LICENSE-RetroArch, GPL note), step 10 (CI in both workflows).

Correction (made in step 7): the lines above say "No core is passed: RetroArch shows its own core list". That is wrong (checked in upstream's source in step 7): without a core the game does not start and RetroArch shows its plain menu. Since step 7 the launcher passes the extra LIBRETRO too (core chosen from the downloaded ones, see docs/CHANGES-step8-retroarch-step7.md).

# Step 8 (RetroArch, part 6 of 12) — Java, resources, library manifest (written and checked statically, NOT built)

Changed / new files
- retroarch/src/main/java/ — 10 upstream files (MainMenuActivity, RetroActivityFuture / Common / Camera / Intent, UserPreferences, ConfigFile, RetroDocumentsProvider, PlayCoreManager stub, VfsImplementationSaf). Only UserPreferences and RetroDocumentsProvider are edited (marked WIN11).
- retroarch/src/main/res/ — ra_ic_launcher(+_foreground, adaptive xml), ra_banner, ra_ic_launcher_background, ra_app_name, ra_document_provider_enabled (6 names, 0 clashes with the 11 other modules).
- retroarch/src/main/AndroidManifest.xml — real library manifest: MainMenuActivity + RetroActivityFuture in process ":retroarch" (own taskAffinity, singleInstance), exported=false, no launcher filter, RetroDocumentsProvider kept but disabled.
- retroarch/tools/diff-upstream-java.sh — compares the copied Java with the upstream clone (tested: same / changed / unexpected / new file).
- app/src/main/kotlin/com/srizwan/win11/App.kt — ":retroarch" process: no BlackBox attach, no J2ME start-up, no launcher log (same as ":mame"). REQUIRED, otherwise the engine would be attached to the RetroArch process.
- app/src/main/AndroidManifest.xml (comment), retroarch/build.gradle.kts, settings.gradle.kts, app/build.gradle.kts, gradle.properties (comments only), retroarch/README.md ("Step 6"), README.md (RetroArch section), this file.

Why (found in upstream v1.22.2, not assumed)
- System.exit(0) in RetroActivityFuture.onNewIntent / QUITFOCUS and native exit(0): would close the whole app in a shared process -> own process.
- Default on Android: RetroArch unpacks the APK assets/ folder into its data folder (menu_driver.c). In Win11 that folder has the files of PPSSPP, Winlator, MAME, J2ME -> switched off (bundle_assets_extract_enable = false). RetroArch has no assets of its own (Online Updater).
- RetroDocumentsProvider shows getFilesDir().getParent() = the data folder of the whole Win11 app in the system file picker -> disabled (bool).
- The LIBRETRO intent extra is a .so path that native code dlopen()s -> activities not exported.

Checked here: XML of all manifests and resources parses; resource names unique; permissions all already in :app; class names and provider authority unique; javac shows only missing-Android-SDK errors (no syntax errors); diff script result "only the expected Win11 changes".
NOT verified: Gradle sync / compile against the Android SDK / run on a device. Cores are NOT bundled (decision), they come from RetroArch's Online Updater.

Effect on CI: no workflow change. APK gains the two activities, the disabled provider, 6 small resources (156 KB) and the Java (164 KB of source). Effect in the app: none visible yet (no Start menu entry / icon / deep link until step 8).

Next: step 8 — hooks in :app (RetroArchLauncher.kt, Start menu, Home icon, rizwans2://retroarch, File Manager ROM extensions).

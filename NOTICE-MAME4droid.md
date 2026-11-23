# MAME4droid notice

The planned `:mame` module is the Android part of https://github.com/seleuco/MAME4droid-Current (pinned in `mame/UPSTREAM_VERSION`: **v1.41.2**)
by David Valdeita (Seleuco), a port of MAME **0.289** by MAMEDev and contributors. Hashes and sizes of what is fetched are pinned in `mame/UPSTREAM_SHA256`.

Where the files come from (plan A, chosen in step 2):
- the Android frontend (about 50 Java files, `mame4droid-jni.c`, resources, assets) is taken from the upstream tag `v1.41.2` (`android-MAME4droid/app/src/main/`) and built here;
- the MAME core `libMAME4droid.so` (arm64-v8a, about 367 MB) is **not built here**: the build downloads the official release APK `MAME4droid.2026-1.41.2-release.apk` from the upstream GitHub release,
  checks its SHA-256 and copies `lib/arm64-v8a/libMAME4droid.so` out of it. The corresponding source of that binary is upstream tag `v1.41.2` (frontend, OSD glue, patches in `src/`) plus MAME source tag `mame0289`;
- none of these big files is stored in the project zip (git-ignored `mame/upstream/`, `mame/core/`). ROM files are never included: the user supplies them.

License: **GNU General Public License, version 2 or (at your option) any later version** (see `LICENSE-MAME4droid`; individual MAME source files are GPL-2.0+ or BSD-3-Clause per their headers).
MAME's and MAME4droid's names, artwork credits (art by Bryn Thompson) and upstream's in-app credits belong to their authors and are kept.

What this means when you distribute the APK:
- keep this notice, `LICENSE-MAME4droid` and upstream's in-app credits;
- offer the complete corresponding source of the APK: this project, plus a pointer to the exact upstream tags above (the core binary comes from the upstream release, so its source is the upstream tags, not this project);
- the app already links GPL code (PPSSPP) into the same process as Apache-2.0 (J2ME Loader, BlackBox) and LGPL (Winlator) parts; MAME adds GPL-2.0+ code to that. General note, not legal advice: check the combination before publishing.
- no non-commercial clause applies to this upstream (an earlier chat note about one was about old MAME releases and does not apply to MAME 0.289 / MAME4droid Current).

Changes made for Win11 (the GPL "state changes" rule), also listed in `mame/README.md`:
- application module -> library module (`:mame`), minSdk 26 (upstream 29), one NDK for the whole project, ABI arm64-v8a only (as upstream), Java 17;
- all resources renamed with the `mm_` prefix (ids kept); the unused AdMob `attrs.xml` removed; help pages moved to `assets/mame/` and `WebHelpActivity` reads them from there (`ASSET_ROOT`);
- manifest: no `<application>` attributes, no LAUNCHER / LEANBACK filter, no zip / 7z VIEW filter, `MAME4droid` not exported;
- `TouchController.fireHaptic`: `VibrationEffect.createPredefined` only on API 29+, short one-shot pulses below (needed because minSdk is 26); `MAME4droid`: `layoutInDisplayCutoutMode` only on API 28+;
- `libMAME4droid.so` and `res/raw/files.zip` are downloaded at build time (hash-checked) instead of being stored; `R.raw.files` became `R.raw.mm_files`;
- all activities run in the process `:mame` (+ own task for `MAME4droid`) so that upstream's `Process.killProcess` on exit does not kill Win11; all `PreferenceManager.getDefaultSharedPreferences()` calls use the new class `helpers/MamePrefs` (own settings file `mame4droid_settings`); the settings screen is switched to that file;
- `MainHelper.getVersion()` and `LobbySession.appVersion()` return the constant `MameLaunch.UPSTREAM_VERSION` (MAME4droid's version) instead of the host app's versionName;
- the 30 `<SeekBarPreference>` rows of the settings XML use the new class `prefs/MameSeekBarPreference` (+ layout `mm_pref_seekbar`) instead of the hidden platform class `android.preference.SeekBarPreference`;
- new file `MameLaunch.java` (entry point for Win11, not from upstream);
- the C code (`mame4droid-jni.c`, `Android.mk`, `Application.mk`) and the MAME core are not modified.

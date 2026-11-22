# PPSSPP notice

The `:ppsspp` module is the Android part of https://github.com/hrydgard/ppsspp (pinned in `ppsspp/UPSTREAM_VERSION`: **v1.20.4**)
by Henrik Rydgård and the PPSSPP contributors. Its 19 Java files, `tombstone.proto`, icons and manifest are in the `ppsspp/` folder of this project.
The C++ core (CPU / GPU emulation, `android/jni`, `ext/`, FFmpeg libraries) and the runtime `assets/` are **not** stored in the project zip:
`ppsspp/tools/fetch-upstream.sh` clones exactly that tag (with its submodules) into `ppsspp/upstream/` before every build, so the corresponding
source of the shipped native library is always the pinned upstream tag plus the changes listed below.

License: **GNU General Public License, version 2 or (at your option) any later version** (see `LICENSE-PPSSPP`; the file also keeps upstream's
PSPSDK BSD-style notice, because parts of the PSPSDK headers / constants are used). Third-party parts live in upstream's `ext/` and `ffmpeg/` folders
with their own licenses (zstd, libpng, zlib, libzip, glslang, SPIRV-Cross, Vulkan Memory Allocator, rcheevos, armips, cpu_features, FFmpeg libraries and others),
and upstream's in-app credits screen is kept. PPSSPP's name and icon belong to the PPSSPP project.

What this means when you distribute the APK:
- keep this notice, `LICENSE-PPSSPP` and the in-app credits;
- offer the complete corresponding source of the APK, including the pinned upstream tag and the `ppsspp/` folder (the whole project, as in this zip);
- the app now links GPL code into the same process as the Apache-2.0 (J2ME Loader, BlackBox) and LGPL (Winlator) parts, so the combined app is normally distributed
  under GPL terms that are compatible with all of them (GPL-3.0-or-later covers Apache-2.0 and GPL-2.0-or-later parts). This is a general note, not legal advice:
  check it before publishing.

Changes made for Win11 (the GPL "state changes" rule), also listed in `ppsspp/README.md`:
- application module -> library module, one variant (no gold / legacy / vr flavors, no signing, no git-version logic);
- resources renamed with the `pp_` prefix; `LAUNCHER` filters and `<application>` attributes removed from the manifest (`android.max_aspect` moved to the activity);
- `ShortcutActivity` uses `R.mipmap.pp_ic_launcher`; `PpssppActivity.isVR()` returns `false`;
- PPSSPP is started from Win11's Start menu, Home screen, `rizwans2://ppsspp` and File Manager (`app/.../PpssppLauncher.kt`); the C++ source is not modified.
- `PpssppActivity` storage permission: all-files access (`MANAGE_EXTERNAL_STORAGE`) counts as storage access, and asking for storage opens the system "All files access" page on Android 11+ (upstream only checked `WRITE_EXTERNAL_STORAGE`); the C++ source is still not modified.

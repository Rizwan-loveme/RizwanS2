# T-UI (TUI-ConsoleLauncher) notice

The `:tui` module is the Android app https://github.com/fandreuz/TUI-ConsoleLauncher (T-UI Linux-terminal launcher, package `ohi.andre.consolelauncher`)
by Francesco Andreuzzi and its contributors, used here as the built-in **Terminal** theme. Its 157 upstream Java files (plus Win11's own files, see below), the font `lucida_console.ttf`, the resources
(renamed, see below) and a trimmed manifest are in the `tui/` folder of this project. The copy was taken from the `master` archive of the repository
(commit `058f54116c4125ee72732a31d0f83e58c30534ad`). There is no native code.

Licence: the repository's `LICENSE` is the **MIT License**, Copyright (c) 2026 Francesco Andreuzzi. The full text is in `LICENSE-TUI` and must be kept
(copyright notice + permission notice) in every copy of the code.

Parts of the sources carry their own licence in the file header. These headers are kept unchanged in the files:
- **GNU GPL version 2 or (at your option) any later version**, 9 files: the 8 files of `managers/flashlight/` (Copyright (C) 2016 Merbin J Anselm) and `tuils/MimeTypes.java` (Copyright (C) 2013 Simple Explorer).
- **Apache License 2.0**, 14 files: Francesco Andreuzzi's own files with the "Licensed under the Apache License, Version 2.0" header (for example `managers/TerminalManager.java`,
  `tuils/SimpleMutableEntry.java`, `commands/main/raw/donate.java`), the `unbescape` HTML-escape classes in `tuils/html_escape/` (Copyright (c) 2014-2017 The UNBESCAPE team) and
  `tuils/libsuperuser/` (Copyright (C) 2012-2015 Jorrit "Chainfire" Jongma).
- The `LICENSE` file says MIT for the project as a whole, the headers above say GPL / Apache for those files; both are kept as they are. A file with a header is covered by that header.
- `assets/lucida_console.ttf`: the upstream repository states no licence for the font. It is a copy of Lucida Console, which is a commercial font of Bigelow & Holmes / Microsoft.
  **Check the right to ship it before publishing** (or replace it with a free monospaced font in a later step); nothing in this module depends on that particular font file except its name.

Libraries used by `:tui` (downloaded by Gradle, not copied): AndroidX appcompat / localbroadcastmanager and Material Components (Apache-2.0), OkHttp (Apache-2.0),
HtmlCleaner (BSD-style), JsonPath (Apache-2.0), jsoup (MIT), CompareString2 by Francesco Andreuzzi (see its repository for the licence).

What this means when you distribute the APK:
- keep this notice and `LICENSE-TUI` (and the headers inside the files);
- the 9 GPL-2.0-or-later files are linked into the same app as the GPL parts (PPSSPP, MAME4droid, RetroArch, Seal) and the Apache-2.0 / LGPL parts, so the combined app is normally
  distributed under GPL terms that cover all of them (GPL-3.0-or-later covers Apache-2.0 and GPL-2.0-or-later parts); offer the complete corresponding source (the whole project, as in this zip).
  This is a general note, not legal advice: check it before publishing.
- the T-UI name, the "T-UI" texts and its launcher icon belong to the upstream project.

Changes made for Win11 (the "state changes" rule of the GPL), also listed in the "Two launcher themes" section of `README.md`:
- application module -> library module (`tui/build.gradle.kts`): one variant (no fdroid / playstore flavors), no signing, `BuildConfig.APPLICATION_ID` = `com.srizwan.win11`, `VERSION_NAME` / `VERSION_CODE` kept from upstream;
- every resource renamed with the `tui_` prefix (files, values and their references), and the Java sources changed only where they read a resource (`R.string.tui_*`, `R.layout.tui_*`, `R.mipmap.tui_ic_launcher`, `R.style.tui_Custom_*`);
- the upstream `theme` command is called `tuitheme` (the launcher-theme switch has its own command, `win11`, step 10);
- manifest trimmed: no HOME / LAUNCHER filters (`LauncherActivity`, `FakeLauncherActivity`), no VIEW / EDIT filters (`TuixtActivity`), no `<application>` attributes, `LauncherActivity` and `TuixtActivity` not exported;
- step 8: the terminal is a normal activity of the app: `LauncherActivity` (reload restarts itself instead of sending a HOME intent; permission flow: notification refusal not fatal, all-files page after the runtime permissions and once per process),
  `KeeperService` (notification click opens `LauncherActivity`) and the `exit` command (closes the screen) no longer use the HOME intent; the string `tui_help_exit` was reworded;
- step 9: `LauncherActivity.onBackPressed()` closes the screen when it was opened from Win11, the `exit` command prints a message when the terminal is the home screen, and one file was added that is not upstream's:
  `TuiHost.java` (Win11's own helper: home-screen flag and "close the terminal" for the host app; it is part of this project, so 158 Java files in total);
- step 10: the `win11` command (`commands/main/raw/win11.java`, Win11's own file, not upstream: switches the launcher theme back to Win11 through `TuiHost`, which got a `Switcher` hook for it), so **159 Java files** in total;
- step 11: six more commands that are Win11's own files, not upstream's: `commands/main/raw/pinned.java`, `builtin.java`, `files.java`, `gallery.java`, `browser.java`, `sms.java` (the launcher's pinned list and its built-in apps, through `TuiHost.Share`), so **165 Java files** in total; and one logic change in an upstream file: `managers/AppsManager.java` (`fill()` moves the apps that the launcher hides into the hidden list, `hideActivity()` / `showActivity()` tell the launcher, two helper methods `keyOf()` / `findLaunchInfoWithKey()` were added; `TuiHost.java` got the `Share` interface for it);
- step 12 (polish, no new files): `managers/AppsManager.java` (`appInstalled()` keeps an app that the launcher hides in the hidden list, `appUninstalled()` also clears it from the hidden list), `UIManager.java` + `LauncherActivity.java` (after a rotation the output scrolls to the end: `onConfigurationChanged()`), `TuiHost.java` (`hideKeyboard()` before the terminal hands over to another screen), `res/values/styles.xml` (new style `tui_Custom.Start`, black window background) and the manifest (`LauncherActivity` uses it);
- step 13 (final check, no change to the sources): `tui/tools/check-merged-manifest.py` was added (a CI check of the merged manifest, not part of the app), the three workflows run it; the module has **165 Java files** (157 upstream, 8 Win11's own: `TuiHost.java` and the 7 commands `win11`, `pinned`, `builtin`, `files`, `gallery`, `browser`, `sms`);
- `consumer-rules.pro` = upstream's `proguard-rules.pro`.

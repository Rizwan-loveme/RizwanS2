# RetroArch notice

The `:retroarch` module is the Android part of https://github.com/libretro/RetroArch (pinned in `retroarch/UPSTREAM_VERSION`: **v1.22.2**,
exact commit in `retroarch/UPSTREAM_COMMIT`: `69a4f0ea1e8aaf442ae4858f2e7f2b31a1776576`) by the RetroArch / libretro team and contributors.
Its 10 small Java files (`com.retroarch.*`, the SAF VFS class of `libretro-common`, upstream's play-core stub), icons, resources and the library manifest
are in the `retroarch/` folder of this project. The C frontend (`griffin`, Vulkan / glslang, cheevos, CHD, 7zip, mbedTLS and the rest of upstream's tree) is **not**
stored in the project zip: `retroarch/tools/fetch-upstream.sh` clones exactly that tag into `retroarch/upstream/` before every build and stops if the clone is on
another commit, so the corresponding source of the shipped native library `libretroarch-activity.so` is always the pinned upstream tag plus the changes listed below.

License: **GNU General Public License, version 3** (see `LICENSE-RetroArch`, the standard FSF text). Upstream's tree also contains third-party code with its own licenses
(for example `libretro-common`, `deps/`: mbedTLS, glslang, SPIRV-Cross, zlib, zstd, FLAC, LZMA / 7zip, libchdr and others). Those licenses stay with that code
and are not repeated here; they are not individually checked in this project. RetroArch's name and logo belong to the RetroArch project.

**Cores are not part of this APK.** RetroArch's own Online Updater downloads cores, core info files and assets at run time (decision recorded in `retroarch/README.md`, step 7).
Every core has its own license; some are GPL, some are not (a few forbid commercial use). They are not distributed by this project. Keep that in mind if you
tell other people which cores to download.

What this means when you distribute the APK:
- keep this notice and `LICENSE-RetroArch`, and keep RetroArch's own in-app information screens;
- offer the complete corresponding source of the APK: this project (the whole zip / repository) plus the pinned upstream tag and commit above;
- GPL-3.0 section 5a: the changed files are marked and listed below.

## Changes made for Win11 (the GPL "state changes" rule), also listed in `retroarch/README.md`
- application module -> library module `:retroarch` (one variant: no `normal` / `aarch64` / `ra32` / Play Store flavors, no signing, no version logic), minSdk 26, the project's NDK, ABI arm64-v8a only by default;
- the native code is built by upstream's own `Android.mk` (ndk-build) from the clone; **no C / C++ file and no makefile of upstream is modified**;
- resources renamed with the `ra_` prefix (`ra_ic_launcher`, `ra_banner`, `ra_app_name`, ...), pictures unchanged;
- manifest: no `<application>` attributes, no LAUNCHER / LEANBACK filters (no second launcher icon), both activities **not exported**, both run in the own process `:retroarch`, `RetroDocumentsProvider` kept but disabled (`ra_document_provider_enabled = false`);
- not copied: `RetroArchApplication`, `CoreSideloadActivity` (debug only), Play Store parts, `res64`;
- three upstream Java files are edited and marked `WIN11` in the source (`bash retroarch/tools/diff-upstream-java.sh` shows the difference to the clone; the other 7 are byte-identical):
  - `RetroDocumentsProvider.java`: resource names with the `ra_` prefix;
  - `UserPreferences.java`: `updateConfigFile()` writes `bundle_assets_extract_enable = false` instead of the APK-asset paths (the `assets/` folder of this APK belongs to other modules);
  - `MainMenuActivity.java`: `finalStartup()` also accepts the extras `ROM` and `LIBRETRO` from the Intent that started it (without `ROM` the behaviour is unchanged);
- RetroArch is started from Win11's Start menu, Home screen, `rizwans2://retroarch` and File Manager (console ROM files) by `app/.../RetroArchLauncher.kt` and `RetroArchCores.kt` (new files, not from upstream).

## Compatibility note: GPL-3.0 next to the other licenses in this app
This is a working note, **not legal advice**. Check it before you publish the APK.

The app is one APK with several modules. Putting RetroArch (GPL-3.0) into it only works if no other part of the combined work is licensed under terms that cannot go with GPL-3.0
(the typical problem is code that is "GPL-2.0 **only**"). What this project can show about each part:

| Part | License | What this is based on | With GPL-3.0 |
|------|---------|-----------------------|--------------|
| `:retroarch` | GPL-3.0 | upstream's statement; the 10 Java files here carry no license header | the reference point |
| `:ppsspp` (PPSSPP) | GPL-2.0-or-later | upstream's statement, see `NOTICE-PPSSPP.md`; the Java files here carry no header, **not re-checked in this step** | fine ("or later" allows version 3) |
| `:mame` (MAME4droid frontend) | GPL-2.0-or-later, plus a linking exception for LGPL code | **checked in this step:** all 51 Java files that have a license header say "version 2 ... or (at your option) any later version" | fine |
| MAME core `libMAME4droid.so` (downloaded at build time, binary) | GPL-2.0+ or BSD-3-Clause per source file (upstream's statement) | **not checked here:** it is a binary from upstream's release, and its source (MAME `mame0289`) was not read | **open item, see below** |
| `:winlator` | LGPL-2.1 (`winlator/LICENSE-Winlator`) | `NOTICE-Winlator.md`; its Wine / Box64 / Mesa parts have their own licenses, not checked | LGPL-2.1 section 3 allows applying "GPL version 2 or any later version" instead, so it can sit in a GPL-3.0 work; Wine, Box64 etc. are separate programs that Winlator starts |
| `:j2me`, `:j2me-dexlib` (J2ME Loader), `:Bcore` and friends (BlackBox) | Apache-2.0 | `NOTICE-J2ME-Loader.md`, `NOTICE-BlackBox.md` | fine: Apache-2.0 goes into GPL-3.0 (it would **not** go into GPL-2.0-only) |
| `:youtube` uses NewPipeExtractor (`youtube/build.gradle.kts`, `v0.26.5`) | GPL-3.0 as far as I know (**not checked here**) | none in this project: **there is no NOTICE file for it** | the app already contains GPL-3.0 code, so RetroArch does not change the direction; but the notice is missing |

Result of this check
- **No GPL-2.0-only part was found** in the parts that could be checked, so there is no known reason why the combined app cannot be distributed under GPL-3.0 terms.
- **Open item 1: the MAME core binary.** Upstream says GPL-2.0+ or BSD-3-Clause per file, but a binary can contain a few files that are "GPL-2.0 only". Before publishing, look at the MAME source tag `mame0289` (or at upstream's own statement about the release APK) for files with "version 2 of the License" **without** "or later".
- **Open item 2: NewPipeExtractor.** Confirm its license in its own repository and add a `NOTICE-NewPipeExtractor.md` (+ license text) in the style of the other notices. I did not add it here: it is outside the RetroArch task, and I could not check the license text from this environment.
- **Open item 3: RetroArch's own file headers.** Upstream's C files normally say "version 3 ... or (at your option) any later version"; the 10 Java files here have no header. This was not re-checked here (no network in this step). It does not block anything (GPL-3.0 is the strictest version in the app) but you may want to read upstream's `COPYING`.
- Running RetroArch in its own process (`:retroarch`) is a technical decision (upstream calls `System.exit`), **not** a license decision: it is still one APK, and I do not treat it as separating the licenses.
- The in-app side: the Win11 app has no "licenses" screen that lists these projects. RetroArch's and PPSSPP's own screens are kept; for the rest the notices in this project are the only place. If you publish, consider adding one screen or a link to the notices.

# Seal notice

The `:seal` module (built-in downloader, shown as "Downloader", see `seal/README.md`) is based on **Seal** — https://github.com/JunkFood02/Seal — by JunkFood02 and contributors,
pinned in `seal/UPSTREAM_VERSION` (**v2.0.0-alpha.5**) and `seal/UPSTREAM_COMMIT` (`7677f61a20fda4210e84215fef9e9b51d25daa47`).
Status: all 10 parts done, static checks passed (nothing built or run yet) — Seal's Kotlin sources are in `seal/src/main/java` and `seal-color/src/main/java`, built as the Gradle modules `:seal` and `:seal-color`.

License: **GNU General Public License, version 3** (see `LICENSE-Seal`, upstream's `LICENSE`).

Third-party parts Seal uses (their own licenses): yt-dlp (Unlicense) and the `youtubedl-android` library (GPL-3.0, `io.github.junkfood02.youtubedl-android`, forked from yausername) with
FFmpeg, aria2c and Python builds; Material color utilities (Apache-2.0); Monet by Kyant0 (the `:color` code); Jetpack Compose / AndroidX (Apache-2.0); Koin, Room, OkHttp, Coil, MMKV (BSD-3 / Tencent), accompanist, kotlinx libraries.
Upstream's credits list is kept inside the app.

**Name restriction from upstream (README, "License"):** other parties may not use Seal's name for a downloader app, and the same applies to derivatives (forks, unofficial builds).
Therefore the built-in app is shown in Win11 under a **neutral name** and credits "based on Seal by JunkFood02"; the source code remains under GPL-3.0.

What this means when you distribute the APK:
- keep this notice, `LICENSE-Seal` and the in-app credits;
- offer the complete corresponding source of the APK (the whole project as in the zip, plus Maven library sources through their upstream repositories);
- the app links GPL-3.0 code into the same process as GPL-2.0-or-later (PPSSPP, MAME), GPL-3.0 (RetroArch), Apache-2.0 (J2ME Loader, BlackBox) and LGPL (Winlator) parts; the combined app is normally distributed under GPL-3.0 terms.
  This is a general note, not legal advice: check it before publishing.

Changes made for Win11 (the GPL "state changes" rule) — list per part (also in `seal/README.md` and `docs/CHANGES-seal-part*.md`):
- application module -> library module `:seal` (+ `:seal-color`), one variant, no flavors / splits / signing;
- (part 2, done) every Seal resource renamed with the `sl_` prefix (files, `name="..."` entries, `R.x.y` in 76 Kotlin files, `@x/y` in XML) so nothing clashes with the other modules; no other source line changed; upstream's `AndroidManifest.xml` kept only as `seal/reference/AndroidManifest.upstream.xml`;
- (part 3, done) built with Kotlin 2.2.10, Room 2.8.5, kotlinx-serialization 1.9.0 and OkHttp 4.12.0 (upstream: Kotlin 2.0.20, Room 2.6.1, serialization 1.7.2, OkHttp 5.0.0-alpha.10); three source lines changed for OkHttp 4 (`Response.body` -> `Response.body!!` in `UpdateUtil.kt` x2 and `SponsorUtil.kt` x1, marked "Win11:");
- (part 5, done) own launcher entry and link / share intent filters removed (all `intent-filter` elements of `MainActivity` and `QuickDownloadActivity`, both now `exported=false`); upstream's `androidx.core.content.FileProvider` replaced by the subclass `SealFileProvider`; `REQUEST_INSTALL_PACKAGES`, `WRITE_EXTERNAL_STORAGE` and the `AppLocalesMetadataHolderService` entry not declared; `PROPERTY_SPECIAL_USE_FGS_SUBTYPE` added to `DownloadService`; the manifest is `seal/tools/overlay-main/AndroidManifest.xml`, upstream's is kept as `seal/reference/AndroidManifest.upstream.xml`;
- (part 4, done) app self-update removed (yt-dlp update kept): `AppUpdater.kt`, `UpdateDialog.kt`, `UpdatePage.kt` deleted, `UpdateUtil.kt` reduced to `updateYtDlp()`, the "Auto update" entry and its route removed from `AppEntry.kt`, `AboutPage.kt`, `Route.kt`, `PreferenceUtil.kt`; the `UpdateUtil.kt` OkHttp edits of part 3 are gone with the removed code;
- (part 4, done) start-up code moved from Seal's `Application` (`App.kt`) into the new file `SealInit.kt`, called from Win11's `App`; Seal's `App` keeps only the shared fields; Seal's own crash handler / crash-screen start-up and `DynamicColors.applyToActivitiesIfAvailable` are not used; all of it is reproduced by `seal/tools/win11_patches.py` + `seal/tools/overlay/`;
- (part 6, done) shown as **"Downloader"**: `sl_app_name` and the default `sl_service_title` changed (`seal/tools/win11_patches.py`, `RES_PATCHES`); Seal's language page entry removed from the appearance settings; `MainActivity.onCreate` also reads the shared link; `FileUtil.getExternalDownloadDirectory()` returns the public Downloads folder (was its subfolder "Seal") and the temp folder is `.downloader-tmp` (was `tmp`); started from Win11's Start menu, Home screen, `rizwans2://seal` and the Browser (new host file `SealLauncher.kt`). Seal's About page keeps the credit to JunkFood02 and Seal.
- (parts 7 and 8, done) no change to Seal's source: build settings of the host only (optional ABI filter `-PapkAbis`, packaging rules), the helper scripts `seal/tools/check-apk-native.sh` and `seal/tools/check-merged-manifest.py`, and the build workflows (APK checks, tick box to leave Seal out of a build).

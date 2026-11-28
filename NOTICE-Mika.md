# Mika (shown in this app as "Rizwan")

Rizwan, the built-in AI assistant of Win11, is based on **Mika**:

- Upstream: https://github.com/wangzan101/Mika
- Version pinned: 0.1.52 (versionCode 53), commit `7ff1703f63b7cbf5741a29345c1b4507802c6b06` (see `mika/UPSTREAM_VERSION`, `mika/UPSTREAM_COMMIT`)
- License: Apache License 2.0 (`LICENSE-Mika`, upstream's file, unchanged)
- Upstream NOTICE: "Mika - Copyright 2026 wangzan101"

## What is changed here (Apache-2.0 section 4(b))

The upstream sources are not stored in this project. `mika/tools/fetch-upstream.sh` (step 3) clones them at build time, and
`mika/tools/patch-upstream.sh` (step 4) changes them in the build checkout only. The changes are:

- the upstream Android `app` module is built as an Android **library** inside Win11 (manifest `<application>` attributes and the launcher
  activity filter removed, `MikaApp` made extendable, 13 clashing resource names renamed with the prefix `mk_`);
- the visible product name and greeting are "Rizwan" / "Hey Rizwan" instead of "Mika" (all string texts of all languages), and the launcher / logo art (`mika_launcher_art.png`) is replaced by our own
  (`mika/rizwan/`), so Mika's logo is not used;
- Mika's own update check is switched off (`UpdateChecker.check()` does nothing), because an update would install Mika's own APK over Win11; the app-language switch and the process-wide default locale
  are not applied to the whole app (`AppLanguage.kt`); the text shown after a backup import (13 languages) is reworded; Mika's screens get the label "Rizwan", its icon and their own task (manifest); `MainActivity.onCreate` starts Mika first (`startMika()`). No permission is removed;
- the licence texts and notices of what Mika ships are added to the APK assets (`assets/licenses/`, part 11, see below);
- Win11 hooks (Start menu, Home icon, `rizwans2://rizwan`) are added in `:app` (`MikaLauncher.kt`);
- the build files are our own (`mika-core/build.gradle.kts`, `mika/build.gradle.kts`): Kotlin 2.2.10, JDK 21, compileSdk 37, minSdk 26, library versions aligned with the Win11 project
  (Compose BOM alpha 2025.03.01, kotlinx-serialization 1.9.0, activity-compose 1.10.1); the `BuildConfig` fields `VERSION_NAME`, `VERSION_CODE`, `APPLICATION_ID` are defined by the library build
  (`APPLICATION_ID` = the Win11 package).

Every changed file is listed in `mika/README.md`. The name "Mika" and its logo are not used as this app's own brand (Apache-2.0 section 6 gives no
trademark rights).

## Shizuku hook-up (only when the built-in Shizuku manager is in the build; step 7)

With the Shizuku manager in the build (`includeShizuku`, the default since step 8F; `-PincludeShizuku=false` leaves it out) it is built into Win11 (`NOTICE-Shizuku.md`) and Mika uses it instead of an external Shizuku app. Mika's own code is changed in two places by the build-time patch (`mika/tools/patch-upstream.py`, part 16); everything else is done on the Win11 side. With the switch off nothing below applies and Mika is as described above.

- **Changed in Mika's sources (part 16, build checkout only):** the `<queries>` entry of the external Shizuku app in Mika's manifest names the host package instead of `moe.shizuku.privileged.api`; in `ShizukuController.kt` the package constant `SHIZUKU_PACKAGE` is replaced by the host package (two package-manager lookups) and by the manager's activity class (`SHIZUKU_MANAGER_ACTIVITY`, used to open the manager). The patch is two-way: without the manager the stock text is written back. `mika/tools/check-manifest.py` (checks 13 and 14) reads the result.
- **Not changed in Mika's sources, done on the Win11 side:** Mika's `rikka.shizuku.ShizukuProvider` entry is removed from the merged manifest by an overlay in `:app` (`app/src/shizuku/AndroidManifest.xml`), so one provider (the manager's, a subclass of that class) owns the authority `${applicationId}.shizuku`; the Maven artifacts `dev.rikka.shizuku:api` / `provider` are replaced by the local modules; Mika's 30 permissions are kept and none of them is a Shizuku permission.
- **Notes from the check rows (read in the project files, not run on a device):** the host does not request `moe.shizuku.manager.permission.API_V23` (it is the manager; the server is believed to treat the manager's app id as always allowed); `ShizukuShellUserService` is expected to bind through the manager's provider (`sendUserService`) because `BuildConfig.APPLICATION_ID` is the host package, the class is in the one APK and `:app` release does no code shrinking. Details and what each statement rests on: `shizuku/README.md`, sections 7A-1.1 to 7D, and `docs/CHANGES-shizuku-part7.md`.
- **Licence:** Shizuku and Shizuku-API are Apache-2.0 / MIT as listed in `NOTICE-Shizuku.md`; nothing here changes the licence of Mika.

## Third-party parts that come with Mika

Upstream's own notices are in its `licenses/THIRD_PARTY_NOTICES.md` (calls feature from FlashPhone, Apache-2.0; scrcpy, Apache-2.0; the libraries; and the parts below).
**Not everything Mika ships is Apache-2.0.** The Rizwan part of the APK contains, as separate programs (not linked into Win11's or Mika's code, except talloc inside PRoot):

| Component | Licence | Where in the APK |
|---|---|---|
| PRoot 5.4.0, **modified** by Mika with 4 patches | GPL-2.0-or-later | `lib/arm64-v8a/libproot.so`, `libproot_loader.so` |
| talloc 2.4.3, unmodified | LGPL-3.0-or-later (on top of GPL-3.0) | statically linked into `libproot.so` |
| Alpine Linux 3.22.7 root file system + Python 3.12, Node 22, Pillow, pypdf and dependencies | per package: GPL, LGPL, MIT, BSD, MPL ... (`assets/runtime/packages.json`) | `assets/runtime/rootfs.tar.xz` (58 MB, run only as separate processes) |
| `libmikarun.so` (Mika's own native helper, C source in upstream's `app/src/main/cpp/mikarun`) | Apache-2.0 | `lib/arm64-v8a/libmikarun.so` |

### Licence files in the APK (step 11, patch edit 13)
`mika/tools/patch-upstream.py` copies these into the build checkout's assets, so they are in **`assets/licenses/`** of every APK that includes Rizwan (CI checks that each one is in the APK):
| File in the APK | From |
|---|---|
| `Apache-2.0.txt`, `Protocol-Buffers.txt` | already in Mika's assets (Mika's own licence screen shows `Apache-2.0.txt`) |
| `GPL-2.0.txt`, `GPL-3.0.txt`, `LGPL-3.0.txt`, `THIRD_PARTY_NOTICES.md` | upstream `licenses/` |
| `MIKA-NOTICE.txt` | upstream `NOTICE` ("Mika - Copyright 2026 wangzan101", Apache-2.0 section 4(d)) |
| `RIZWAN-NOTICE.md` | this project, `mika/rizwan/licenses/RIZWAN-NOTICE.md`: what Rizwan is, the list of changes (section 4(b)), the GPL / LGPL parts, where their source is |
| `gpl-source/patches/proot-0001 ... 0004-*.patch`, `gpl-source/sources.lock`, `gpl-source/runtime-sources.lock`, `gpl-source/README.md` | upstream `tools/sandbox/` (the 4 PRoot patches, the pinned source archives with SHA-256, Mika's build notes) |
The fetch script now also checks out upstream's `tools/sandbox/` (152 KB) for this.

### Open points for the owner (not decided by this file; this is not legal advice)
1. **GPL source offer.** The APK ships PRoot (GPL-2.0-or-later, modified) and the GPL / LGPL packages of the Alpine file system. What is provided: licence texts, the 4 patches, the pinned source locations with checksums, and URLs
   (`RIZWAN-NOTICE.md`). Whether pointers are enough for how you distribute the APK (GPL-2.0 section 3: accompany the source, or a written offer with your contact) is for you / a lawyer to decide; if a written offer is wanted, put your contact into
   `mika/rizwan/licenses/RIZWAN-NOTICE.md` (it is copied into the APK by the next build).
2. **Alpine package sources.** Upstream says each Mika release carries a `mika-<version>-gpl-sources.tar.gz` for them. That the tarball exists for 0.1.52 was **not checked** (no network here).
3. **Mika's licence screen** (About -> Apache-2.0 open source licence) still shows only `Apache-2.0.txt` and its component list; its footer says the full texts are in the source repository. The new files are in the APK but not shown by that screen.

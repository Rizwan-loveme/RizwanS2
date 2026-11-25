# Mika (Rizwan) — part 9 of 15: CI (cache + fetch + patch + checks in the three workflows, `include_mika` switch, the two stubs)

Request: step 9 of the plan, **keep all details**, full flat zip. Rizwan stays a built-in **library** app like PPSSPP / MAME / RetroArch, Mika keeps all its permissions,
Mika follows the project's versions, "Hey Rizwan" is the voice wake word (still step 14). Part 9 only.
The upstream was **not** read again this turn: the uploaded split zip (`ezyZip.z01` to `.z04`, 80,000,000 bytes) has no `ezyZip.zip` (its last part, with the central directory), so it cannot be opened.
Part 9 needs no upstream source (it edits CI files and adds one checker), and the earlier steps were tested on the real 0.1.52.

Steps (each ticked when done):
- [x] 1. Unpack the step 8 zip; read the three workflows (`UltimateBuild.yml`, `UltimateBuild_NoWinlator.yml`, `UltimateBuild_WithoutMe.yml`), the fetch / patch / check scripts, `AppBase.kt`, `MikaLauncher.kt`, both stubs, the Gradle wiring
- [x] 2. Cache + fetch + patch + source-manifest check + `APPLICATION_ID` check in all three workflows (WithoutMe: only when `include_mika` is ticked)
- [x] 3. After the build: APK check (native files, sandbox root file system by exact size, classes in the dex files) and the merged-manifest check, in all three workflows
- [x] 4. `mika/tools/check-merged-manifest.py` (new)
- [x] 5. `UltimateBuild_WithoutMe.yml`: tick box `include_mika`, removal block with the two stubs, verify / summary / release text
- [x] 6. Tests on copies (below), YAML parse, `bash -n` of every `run:` step
- [x] 7. Comments that said "part 9 will ..." (`settings.gradle.kts`, `gradle.properties`, `app/build.gradle.kts`, `check-manifest.py`), `mika/README.md`, `README.md`, this file
- [x] 8. Full flat zip `RizwanS2-main-mika-step9.zip`

## Changed / new files
- new: `mika/tools/check-merged-manifest.py`, `docs/CHANGES-mika-part9.md`
- changed (CI): `.github/workflows/UltimateBuild.yml`, `UltimateBuild_NoWinlator.yml`, `UltimateBuild_WithoutMe.yml`
- changed (comments / docs only): `settings.gradle.kts`, `gradle.properties`, `app/build.gradle.kts`, `mika/tools/check-manifest.py` (header), `mika/README.md`, `README.md`
- not touched: any Kotlin / Java / resource / manifest file, the patch script, the fetch script, the stubs, `.gitignore` (`mika/upstream/` has been in it since step 1), the other modules

## What the three workflows do now (order inside a run)
1. Checkout, free disk space; **WithoutMe only:** "Remove the modules that are not ticked" (now also Mika, see below)
2. Package rename (unchanged). It reaches `mika/build.gradle.kts` (`BuildConfig.APPLICATION_ID` = the host package), because that file is a `*.gradle.kts` file
3. JDK 21, Gradle, NDK + SDK platform 37 (unchanged)
4. PPSSPP / RetroArch / MAME steps (unchanged)
5. **New: "Cache Mika source"** (`actions/cache@v4`, path `mika/upstream`, key = hash of `UPSTREAM_VERSION`, `UPSTREAM_COMMIT`, `fetch-upstream.sh`, `patch-upstream.sh`, `patch-upstream.py` and `mika/rizwan/**`).
   The cache holds the **patched** copy (and its `.git`); the patch script is idempotent and its marker holds the hash of script + icon, which is also in the key, so a changed script always gets a fresh checkout.
6. **New: "Fetch and patch Mika source"** (20 minute limit): `fetch-upstream.sh` (exact commit, stops on a mismatch) -> `patch-upstream.sh` -> `check-manifest.py` (11 source checks) -> a check that `mika/build.gradle.kts` holds the **new** package name as `APPLICATION_ID`
   (Mika compares it with `context.packageName`; a rename that missed it would fail only at run time) -> size / disk report.
   Runs after the rename on purpose (like RetroArch): the rename never touches Mika's source, only the project's own files.
7. ccache (PPSSPP / RetroArch only: Mika has no native build, its three `.so` files are prebuilt), Gradle wrapper, keystore, `assembleRelease` (unchanged; the Gradle tasks `fetchMikaUpstream` / `patchMikaUpstream` find the checkout ready and do nothing)
8. **New, in "Locate Unsigned APK" (before the T-UI block): "Rizwan (Mika) in the APK":**
   - `lib/arm64-v8a/libmikarun.so`, `libproot.so`, `libproot_loader.so` are in the APK (the sandbox runs them from `nativeLibraryDir`)
   - `assets/runtime/rootfs.tar.xz` is in the APK with exactly the size of the fetched file (it is stored: `noCompress += "xz"`)
   - the dex files contain `Lcom/wangzan101/mika/MikaApp;` (from `:mika`) and the package `Lcom/wangzan101/mika/core/` (from `:mika-core`); the dex is extracted to a file first (no pipe under `pipefail`)
   - `mika/tools/check-merged-manifest.py` on the merged release manifest (below)
9. Zipalign, sign, release (unchanged)

### `mika/tools/check-merged-manifest.py` (new)
The source check (`check-manifest.py`, step 7) cannot see what the manifest merger really produced; this one reads the **merged** release manifest:
1. all 30 permissions of `KEEP_PERMISSIONS` are there (the owner's rule: none removed)
2. every activity / service / receiver / provider / alias of Mika's library manifest is there
3. no Mika component has a `MAIN` + `LAUNCHER` filter or the `HOME` category; exactly one `HOME` activity exists in the whole manifest (`:app`'s `MainActivity`)
4. every Mika component with an intent filter, and every Mika provider, has an explicit `android:exported`
5. no `${...}` placeholder is left in an attribute of a Mika component (authorities, task affinity)
6. `com.wangzan101.mika.ui.MainActivity` has `taskAffinity` ending in `.rizwan` (its own window in Recents, step 7)
7. no provider authority is used twice in the whole merged manifest

## `UltimateBuild_WithoutMe.yml`: the tick box
- New input **`include_mika`** ("Rizwan (Mika, on-device AI assistant, at least +58 MB)", default ticked). Unticked, in the run's temporary checkout only:
  - `AppBase.kt` and `MikaLauncher.kt` are replaced by `mika/tools/stub/AppBase.kt.stub` / `MikaLauncher.kt.stub` (read **before** the folder is deleted; the package line of the original file goes on top, so the rename renames them with the rest)
  - `mika/` and `mika-core/` are deleted and removed from `settings.gradle.kts` and `app/build.gradle.kts` (`drop_module mika mika-core`; the pattern `include(":mika")` does not match `include(":mika-core")`, so both names are given)
  - `no_refs`: nothing outside the module may still say `com.wangzan101` or `MikaApp` (comments are ignored, like for the other modules); the Gradle verify loop now also checks `:mika` and `:mika-core`
  - **no sed for the Start menu / Home icon / terminal entry is needed**: with the stub, `MikaLauncher.isSupported()` is `false`, and all three places already test it, so Rizwan is simply not offered; `rizwans2://rizwan` shows "Rizwan is not in this build"
  - the cache / fetch steps are skipped (`if: ${{ inputs.include_mika }}`), the APK step checks the opposite: **`libmikarun.so` must NOT be in the APK**
  - the summary table, the "Describe the modules" line (`Rizwan(Mika)`) and the header comment list it
- The other two workflows always include Mika (like T-UI).

## Tested here
| Case | Result |
|---|---|
| YAML parse of the three workflows | OK (28 / 29 / 31 steps) |
| `bash -n` on every `run:` block of the three workflows | 0 problems |
| WithoutMe removal block, `INC_MIKA=false`, others ticked, on a copy of the step 8 project | both stubs written with `package com.srizwan.win11` on top, `mika/` and `mika-core/` gone, `settings.gradle.kts` / `app/build.gradle.kts` lines removed, `no_refs` passes, summary table right |
| package rename step on a copy (`com.srizwan.win11` -> `com.example.newapp`) | `mika/build.gradle.kts` `APPLICATION_ID` renamed; the new check passes with the new name and fails with the old one |
| `check-merged-manifest.py`, 1 good + 7 negative merged manifests (synthetic, built from `KEEP_PERMISSIONS`) | good = OK; missing permission / missing service / open `${applicationId}` / wrong task affinity / LAUNCHER filter / no `exported` / duplicate authority: each fails with its own `::error::` line |
| APK block on fake APKs | good APK passes (plain and WithoutMe form); wrong `rootfs.tar.xz` size, no Mika class in the dex, Mika in the APK although left out, Mika missing although ticked: each fails with a clear line; clean APK with Mika left out passes |
| `py_compile` of `check-manifest.py`, `check-merged-manifest.py` | OK |

## Not run
Gradle, a compile, a real GitHub Actions run, a device (no Android SDK / Kotlin compiler / network here), and the real Mika upstream this turn (see the top: its last zip part is missing).
The synthetic manifests test the logic of the new checker, **not** the real merged manifest of the app.

## Risks in the order they can show up (send the first error lines of the failing step)
1. **"Fetch and patch Mika source"**: `git fetch --depth 1 --filter=blob:none origin <sha>` needs GitHub to allow fetching that commit directly (it does for public repos; step 3's local tests used `file://`). The script retries 3 times and prints `could not fetch commit`.
2. `check-manifest.py` in that step (11 checks) runs on the real tree for the first time **after the package rename**; it reads the host namespace from `app/build.gradle.kts`, which the rename has changed too, so it should follow. A line starting `::error::check-manifest:` says which check.
3. `:mika:compileDebugKotlin` / `compileReleaseKotlin` (837 Kotlin files): the first time Mika is compiled with the project's versions (Kotlin 2.2.10, Compose BOM alpha 2025.03.01). Expect the first `e:` lines here (see step 5 notes in `mika/README.md`).
4. **The dex check assumes no shrinker**: `:app` has `isMinifyEnabled = false` today. If R8 is switched on, `MikaApp` stays (the Application chain keeps it) but the package check of `:mika-core` could miss; Mika would also need keep rules (not written, step 13 / later).
5. The exact-size check of `rootfs.tar.xz` assumes AGP stores it as is (`noCompress += "xz"` in `:app`, step 5). If a packaging plugin repacks it, the size in `unzip -l` is still the original length, so the check should hold; a miss prints both numbers.
6. Merged-manifest check: `app/build/intermediates/merged_manifests/release/AndroidManifest.xml` (the same lookup as RetroArch / Seal / T-UI use; if it is not found the step only warns).
7. Cache quota: the Mika cache is about 83 MB (with `.git`); RetroArch's is about 330 MB, ccache up to 3 GB. GitHub keeps 10 GB per repository, so all fit.
8. Run time: the Mika compile adds to the 120 minute limit (PPSSPP + RetroArch native builds are the long parts; the first run has no ccache). Not measured.

## Decisions taken here (say if you want them different)
- The "without" build removes Mika the same way as the other modules (delete + stub), **not** with `-PincludeMika=false` through the environment: it is explicit and verified by the same `no_refs` / Gradle checks as the others.
- The stub approach needed **no** edit of `StartApps.kt` / `Win11Shell.kt` / `TerminalShare.kt` (they already test `MikaLauncher.isSupported()`), so the "without" build changes only two Kotlin files.
- The two normal workflows always include Mika (no tick box), like T-UI; the release text of those two is unchanged. Say if you want "includes Rizwan (Mika 0.1.52)" in it.
- The cache key includes the patch script and the icon, so a patch change never reuses an old patched copy.
- The APK check also asserts the **absence** of Mika in a build that left it out.

Next: part 10 (`.gitignore` is done since step 1; docs), part 11 (licence files in assets), part 12 (README / CHANGES), part 13 (static checks), part 14 (wake word "Hey Rizwan"), part 15 (final zip `RizwanS2-main-mika-rizwan.zip`).

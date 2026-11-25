# Mika (Rizwan) — part 11 of 15: licence files in the APK, `NOTICE-Mika.md`

Request: step 11, **keep all details**, update the full flat zip. Standing decisions of the owner: Rizwan is a built-in **library** app (like PPSSPP / MAME / RetroArch); Mika keeps **all** its permissions;
Mika follows the project's versions; "Hey Rizwan" is the voice wake word (still step 14). Part 11 only. The real upstream (0.1.52, the 5-part split zip joined with `zip -s 0`) was available again and everything below was run on it.

Steps (each ticked when done):
- [x] 1. Unpack the step 10 zip and the upstream; read upstream's `licenses/`, `NOTICE`, `LicensesScreen.kt`, `tools/sandbox/` (README, `sources.lock`, 4 PRoot patches, runtime lock); check our modules' assets for name clashes
- [x] 2. Decide what goes into the APK and where (below)
- [x] 3. `mika/rizwan/licenses/RIZWAN-NOTICE.md` (new), patch edit 13, marker hash, self-check
- [x] 4. `fetch-upstream.sh`: `tools/sandbox/` in the sparse checkout, more required files
- [x] 5. `check-manifest.py` check 12; APK licence check in the three workflows
- [x] 6. `NOTICE-Mika.md` rewritten (third-party section, file table, open points)
- [x] 7. Tests on the real upstream (below), docs (`mika/README.md` "Step 11", `README.md`, `docs/CHANGES-mika.md`, this file)
- [x] 8. Full flat zip `RizwanS2-main-mika-step11.zip`

## Changed / new files
- new: `mika/rizwan/licenses/RIZWAN-NOTICE.md`, `docs/CHANGES-mika-part11.md`
- changed: `mika/tools/patch-upstream.py`, `mika/tools/fetch-upstream.sh`, `mika/tools/check-manifest.py`, `.github/workflows/UltimateBuild.yml`, `UltimateBuild_NoWinlator.yml`, `UltimateBuild_WithoutMe.yml`, `NOTICE-Mika.md`, `mika/README.md`, `README.md`, `docs/CHANGES-mika.md`
- not touched: any Kotlin / Java / resource / manifest / Gradle file of the project, the stubs, `LICENSE-Mika` (identical to upstream's `LICENSE`, checked with `cmp`), `.gitignore`

## Finding (why this part matters)
Mika's APK has only two licence assets: `licenses/Apache-2.0.txt` (shown by its licence screen) and `licenses/Protocol-Buffers.txt`. The GPL-2.0, GPL-3.0 and LGPL-3.0 texts, `THIRD_PARTY_NOTICES.md` and the NOTICE file stay in the repository folder `licenses/`, outside the APK.
But the APK ships **PRoot 5.4.0 (GPL-2.0-or-later, patched by Mika with 4 patches)** and **talloc 2.4.3 (LGPL-3.0-or-later)** inside `libproot.so`, and an **Alpine Linux root file system** (`rootfs.tar.xz`, 58 MB) with Python, Node, Pillow, pypdf and their GPL / LGPL / MIT / BSD / MPL dependencies.
In Win11 that is now part of the Win11 APK, so the texts and the source pointers must travel with it.

## What goes into the APK: `assets/licenses/`
| File | Source | Why |
|---|---|---|
| `Apache-2.0.txt`, `Protocol-Buffers.txt` | Mika's own assets (unchanged) | Mika's licence screen reads `Apache-2.0.txt` |
| `GPL-2.0.txt` | upstream `licenses/` | PRoot |
| `GPL-3.0.txt`, `LGPL-3.0.txt` | upstream `licenses/` | talloc (LGPL-3.0 is additional terms on GPL-3.0, both texts) |
| `THIRD_PARTY_NOTICES.md` | upstream `licenses/` | per-component notices (FlashPhone, scrcpy, commons-compress, xterm.js, Shizuku, ML Kit, ZXing, PRoot, talloc, Alpine ...) |
| `MIKA-NOTICE.txt` | upstream `NOTICE` | Apache-2.0 section 4(d) |
| `RIZWAN-NOTICE.md` | `mika/rizwan/licenses/` (ours) | what Rizwan is, list of changes (section 4(b)), the GPL / LGPL parts, where their source is |
| `gpl-source/patches/proot-0001 .. 0004-*.patch`, `gpl-source/sources.lock`, `gpl-source/runtime-sources.lock`, `gpl-source/README.md` | upstream `tools/sandbox/` | the modification of the GPL program, and the pinned source archives (URL + SHA-256) |
A subfolder name (`licenses`) that no other module uses (checked: no `licenses` folder and no GPL / THIRD file in any other module's assets), so AGP's asset merge has nothing to clash with. The names `MIKA-NOTICE.txt`, `RIZWAN-NOTICE.md`, `gpl-source/` cannot clash with Mika's files either (Mika has only the two above).

## Code
- **Patch edit 13** `patch_license_assets()` in `mika/tools/patch-upstream.py`: table `LICENSE_FILES` (destination -> source in the checkout), the 4 PRoot patches, our notice. Copies only when bytes differ (idempotent). The marker stamp now also hashes `mika/rizwan/licenses/*`. A missing source, or fewer than `LICENSE_PATCHES_MIN` (4) patches, stops with `::error::patch-upstream: ...`. `LICENSE_ASSETS` (the list the checks use) is defined there once.
- **`fetch-upstream.sh`:** sparse checkout `/tools/sandbox/` added (152 KB); `REQUIRED` now has `licenses/GPL-2.0.txt`, `GPL-3.0.txt`, `LGPL-3.0.txt`, `NOTICE`, `tools/sandbox/sources.lock`, `tools/sandbox/patches`. An older cached checkout lacks them, fails the layout check and is fetched again.
- **`check-manifest.py` check 12:** every `LICENSE_ASSETS` file exists and is not empty; at least 4 `.patch` files; `GPL-2.0.txt` must exist because `libproot.so` is shipped.
- **Workflows** (inside "Rizwan (Mika) in the APK", before the dex check): 10 file names + at least 4 `gpl-source/patches/*.patch` must be in the APK listing (`awk` on the name column, exact match). In `UltimateBuild_WithoutMe.yml` it is in the `include_mika` branch only.
- **The CI cache** already keys on `mika/rizwan/**` and the script hashes, so changing `RIZWAN-NOTICE.md` makes a fresh checkout.

## `NOTICE-Mika.md`
The old text said "copied into the APK assets by step 11"; now it says exactly what is copied. New: a table of what in the Rizwan part is **not** Apache-2.0, the file table, and three open points.

## Open points for the owner (not decided here; not legal advice)
1. **GPL source offer.** Provided in the APK: licence texts, the 4 patches, pinned source locations with SHA-256, URLs. Whether pointers satisfy GPL-2.0 section 3 for the way you distribute (accompanying source, or a written offer with your contact) is yours / a lawyer's decision. If a written offer is wanted, add your contact to `mika/rizwan/licenses/RIZWAN-NOTICE.md`.
2. **Alpine package sources.** Upstream's notice says each release has a `mika-<version>-gpl-sources.tar.gz`. Not checked for 0.1.52 (no network here).
3. **Mika's licence screen** shows only `Apache-2.0.txt` and its own component list, and its footer says the texts are "in the source repository". The new files are in the APK but that screen does not list them. A patch to the footer (13 languages) or a link in Win11's own About would be a separate small step if you want it.
4. The licences of the other Win11 modules are untouched (their own NOTICE files).

## Tested here (real upstream 0.1.52)
| Case | Result |
|---|---|
| patch, fresh tree | `licence assets=13` (+ the 12 old groups with the old numbers); `assets/licenses/` has 15 files: Mika's 2, our 13 |
| second run / `MIKA_FORCE_PATCH=1` | "already patched" / all counts 0; tree hash identical |
| tree already patched by the step 10 script, then the new script | only the licence edit applies; tree hash identical to the fresh tree |
| `check-manifest.py` (checks 1 to 12) | OK: 30 permissions, 7 / 11 / 6 / 7 components, 65 authorities |
| negative: `GPL-2.0.txt` removed | two `::error::` lines (missing asset; libproot.so shipped without GPL-2.0) |
| negative: one PRoot patch removed | `has 3 patches, expected at least 4` |
| negative: checkout without `tools/` | patch stops: `licence source tools/sandbox/README.md is missing in the checkout` |
| fetch script, local git repo (`file://`) | `tools/sandbox/` present next to `licenses/`; again: "already present"; the patch then runs on that checkout (13 groups) |
| APK licence block of the 3 workflows, fake `unzip -l` lists | full list passes; missing `GPL-3.0.txt` and 3 patches fail with their own message |
| YAML parse of 3 workflows, `bash -n` of every `run:` step (19 / 20 / 21), `ast.parse` of the 2 changed Python scripts, `bash -n` of the fetch script | OK |
Not run: Gradle, a compile, a real GitHub Actions run, a real fetch from github.com, a device. AGP's merge of the asset folders is expected to be clean (no clash) but was not run.

## Risks in the order they can show up
1. "Fetch and patch Mika source": the sparse checkout of `/tools/sandbox/` (same mechanism as the other paths; a server that cannot filter blobs falls back to a full fetch, as before).
2. `::error::patch-upstream: licence source ... missing` after a version bump that moves the folders.
3. APK step: `assets/licenses/... is not in the APK`: would mean AGP dropped the folder (not expected).
4. APK size: +about 200 KB (texts and patches).

Next: part 12 (README / CHANGES refresh after 11, 13, 14), part 13 (static checks over the whole project), part 14 (wake word "Hey Rizwan", persona prompts), part 15 (final zip `RizwanS2-main-mika-rizwan.zip`).

## Final checks of the zip
`RizwanS2-main-mika-step11.zip` is **flat** (every entry in the zip root). 4494 files; no `.git`, no `mika/upstream/`, no `tools/__pycache__/`; the shell and Python scripts of `mika/tools/` keep their executable mode; `unzip -t` clean; links to `docs/CHANGES-mika-part1..11.md` and every file named in the Mika docs exist. Compared with the step 10 zip: 10 changed files and 2 new files (`mika/rizwan/licenses/RIZWAN-NOTICE.md`, this file).

# Mika (Rizwan) — part 10 of 15: `.gitignore`, line endings, docs, README

Request: step 10, **keep all details**, update the full flat zip. Standing decisions of the owner (they apply to every part): Rizwan is a built-in **library** app like PPSSPP / MAME / RetroArch;
Mika keeps **all** its permissions; Mika follows the project's versions (Kotlin / AGP / JDK / Compose), not the other way round; "Hey Rizwan" is the voice wake word (still step 14).
Part 10 only. No Kotlin / Java / resource / manifest / Gradle / workflow file was changed in this part.

This turn the **real upstream** was available again (the uploaded split zip `ezyZip.z01` to `.z04` + `ezyZip.zip` = `Mika-main.zip`, 0.1.52, all five parts present), so the whole
fetch -> patch -> check chain was run again on it, see "Tested here".

Steps (each ticked when done):
- [x] 1. Unpack the step 9 zip and the upstream (`Mika-main.zip` joined from the 5 split parts with `zip -s 0`); read `mika/README.md`, `README.md` (Mika section), `NOTICE-Mika.md`, `.gitignore`, `.gitattributes`, the nine earlier CHANGES files
- [x] 2. Regression run of the real chain on the real upstream: `fetch-upstream.sh` (hand-placed), `patch-upstream.sh`, `check-manifest.py`
- [x] 3. `.gitignore` audit in a real git repository (what would be committed): found and closed one gap (`__pycache__`)
- [x] 4. `.gitattributes`: `*.py` and `*.stub` are LF (like `*.sh`)
- [x] 5. Docs: `docs/CHANGES-mika.md` (new, one overview of parts 1 to 10), this file, `mika/README.md` (Overview at the top, plan table, "Step 10"), `README.md` (plan table, "Step 10")
- [x] 6. Static checks of the final tree (below), full flat zip `RizwanS2-main-mika-step10.zip`

## Changed / new files
- changed: `.gitignore`, `.gitattributes`, `mika/README.md`, `README.md`
- new: `docs/CHANGES-mika.md`, `docs/CHANGES-mika-part10.md`
- not touched: every source, build, manifest and workflow file; the patch / fetch / check scripts; the stubs; `NOTICE-Mika.md` / `LICENSE-Mika` (step 11)

## `.gitignore` (what was checked and what changed)
Method: the step 10 tree **plus a hand-placed upstream checkout (the real 0.1.52, patched)** was put into a fresh `git init` repository and `git add -A` was run, so the answer is what
a real commit would contain, not what the file looks like.

| Question | Result |
|---|---|
| is anything of `mika/upstream/` tracked (about 132 MB, 4,000+ files once fetched) | **0 files**: the rule `mika/upstream/` (since step 1) holds, including the marker `mika/upstream/.rizwan-patched` (`git check-ignore -v` names the rule) |
| files tracked in total | 4,492 (with the two new docs); of Mika: `mika/README.md`, `UPSTREAM_COMMIT`, `UPSTREAM_VERSION`, `build.gradle.kts`, the icon PNG, the 5 tool scripts, the 2 stubs, `mika-core/build.gradle.kts` (13 files) |
| `mika/tools/__pycache__/` | **was a gap**: running `patch-upstream.sh` / `check-manifest.py` the normal way creates it next to the scripts (it appeared in the working copy during the regression run), and `git add -A` would have committed `*.pyc`. New rule: `**/tools/__pycache__/` (only under a `tools/` folder on purpose: `winlator/.../virglrenderer/.../util/__pycache__/` holds two `.pyc` files that came with upstream and stay exactly as they were, so no `*.pyc` rule) |
| the `.rizwan-patched` marker | already covered by `mika/upstream/`; an extra rule `.rizwan-patched` is added so a checkout that is copied somewhere else by hand never leaks it |
| `build/`, `.gradle/`, `.cxx/`, `*.jks`, `*.keystore`, `local.properties` | unchanged, they already cover `mika/build/`, `mika-core/build/` |

Nothing was removed from `.gitignore`; the three other fetched-at-build-time folders (`ppsspp/upstream/`, `mame/upstream/` + `mame/core/`, `retroarch/upstream/`) are untouched.

## `.gitattributes`
Added `*.py text eol=lf` and `*.stub text eol=lf` next to the existing `*.sh text eol=lf`. Reason: the Mika scripts run on a Linux runner (`#!/usr/bin/env python3`, the stubs are copied
over Kotlin sources by the "without" workflow); a checkout on Windows with `core.autocrlf=true` would otherwise turn them into CRLF files. Verified: all 7 files under `mika/tools/` report `attr/text eol=lf`, index and working tree `lf`.

## Docs
- **`docs/CHANGES-mika.md` (new):** the one file to read about the whole Mika / Rizwan feature: what it is, where it opens from, every file (new / changed), the build chain, the switches, CI, permissions (all 30), what the patch changes in upstream, decisions, what is not verified, how to move to a newer upstream, what the first failed run will most likely be. It does not replace the per-part files (`CHANGES-mika-part1.md` to `part10.md`), it points into them.
- **`mika/README.md`:** a new **Overview** at the top (same idea as `retroarch/README.md`), the plan table (10 done), "Step 10" at the end. Nothing of the step-by-step log was deleted.
- **`README.md`:** the Mika section says "is" instead of "will become", the plan table has step 10 done and a "Step 10" paragraph.

## Tested here
| Case | Result |
|---|---|
| `fetch-upstream.sh` on the real upstream placed by hand (no `.git`) | "Mika 0.1.52 (hand-placed)" found, exit 0, the commit-less warning as designed |
| `patch-upstream.sh`, first run on the real tree | done: MikaApp open 1, library manifest 1, `mk_` edits 207, name in 589 files, greeting 13, icon 1, host hooks 2, language 1, self-update off 1, backup text 13, manifest part 7 1, MainActivity start 1 (same numbers as parts 4 to 8) |
| `check-manifest.py` (checks 1 to 11) on the patched real tree | OK: 30 permissions (17 already in `:app`, 13 added), 7 activities, 6 providers, 7 receivers, 11 services, 65 provider authorities |
| `git add -A` of tree + patched upstream | 0 upstream files, 0 `tools/__pycache__` files tracked (tested with such folders under `mika/tools/`, `seal/tools/` and the root `tools/`); winlator's 2 own `.pyc` files stay tracked |
| `git check-ignore -v` on 3 sample paths | each matched by the intended rule |
| line endings of `mika/tools/*` in git | `attr/text eol=lf`, `i/lf w/lf` for all 7 |
| final tree: every `*.md` link to a `docs/` file points at an existing file, every file named in the Mika tables exists, no `__pycache__` / `upstream` folder in the zip | see "Final checks" in the zip's last section below |
Not run: Gradle, a compile, GitHub Actions, a device (no Android SDK / Kotlin compiler / network here). The real fetch from github.com is still untested (only `file://` and hand-placed).

## Final checks of the zip
`RizwanS2-main-mika-step10.zip` is **flat** (every entry in the zip root: `settings.gradle.kts`, `app/`, `mika/`, `.github/` ...). Checked after zipping: 4492 files; no `.git`; no `mika/upstream/`; no `tools/__pycache__/`;
the 7 tool files of `mika/` keep their modes (`*.sh` executable); winlator's two own `.pyc` files are in it unchanged (as in the step 9 zip); `unzip -t` clean; every `docs/CHANGES-mika-part1..10.md` present; `bash -n` of the 2 shell scripts, syntax of the 3 Python scripts and YAML parse of the 6 workflows OK.

## Open points (unchanged by this part)
1. Step 11: Mika's `licenses/` folder copied into the APK assets (the About page of Mika reads `assets/licenses`), `NOTICE-Mika.md` check.
2. Step 12: final README / CHANGES refresh after steps 11, 13 and 14 (this part wrote the overview; it will need the last facts).
3. Step 13: the full static check over the whole project (XML, resource clashes, references, scripts, workflows).
4. Step 14: wake word "Hey Rizwan" (engine decision first; upstream has none) and the persona prompts that still say "Mika".
5. Step 15: the final zip `RizwanS2-main-mika-rizwan.zip`.

# Mika (Rizwan) — part 3 of 15: fetch script + `fetchMikaUpstream`

Request: add Mika as a built-in **library** app called **Rizwan** (sources fetched at build time like PPSSPP / MAME / RetroArch), keep all details, update the full flat zip. This turn: part 3 only.

Steps (each ticked when done):
- [x] 1. Read the part 2 tree and the sibling fetch scripts / tasks (`retroarch/tools/fetch-upstream.sh`, `ppsspp/tools/fetch-upstream.sh`, their Gradle tasks)
- [x] 2. `mika/tools/fetch-upstream.sh` (new): pinned-commit fetch, sparse checkout, commit / version / layout checks, hand-placed mode
- [x] 3. Gradle: task `fetchMikaUpstream` + ordering in `mika/build.gradle.kts` and `mika-core/build.gradle.kts`
- [x] 4. Tests of the script on a local repository (6 cases, below), bracket check of both build files
- [x] 5. Docs: `mika/README.md` ("Step 3"), root `README.md`, this file
- [x] 6. Full flat zip `RizwanS2-main-mika-step3.zip`

## Changed / new files
- new: `mika/tools/fetch-upstream.sh`, `docs/CHANGES-mika-part3.md`
- changed: `mika/build.gradle.kts`, `mika-core/build.gradle.kts` (task + ordering only), `mika/README.md`, `README.md`
- not touched: `settings.gradle.kts`, `app/`, manifests, workflows (CI steps come in part 9). The modules are still not in `settings.gradle.kts` (part 5), so the build is as before and nothing runs the script yet.

## Decisions taken here (say if you want them different)
- Mika is pinned by **commit**, not by tag: the script fetches the commit directly (`git fetch --depth 1 origin <sha>`), then checks `HEAD == UPSTREAM_COMMIT`, the `versionName` text and 15 required paths.
- **Sparse checkout:** only `core/src/main`, `app/src/main`, `gradle/libs.versions.toml`, 3 build files, `licenses/`, `LICENSE`, `NOTICE` (about 83 MB instead of 133 MB). `.git` is kept, as for RetroArch.
- **Offline mode:** a hand-placed `mika/upstream/` (no `.git`) is accepted after a version check, so the uploaded `Mika-main.zip` can be unpacked there (without its wrapper folder) when GitHub is not reachable.
- The script does **not** patch; part 4's patch script runs after it and is idempotent, so a patched checkout is never re-fetched.

## Tests (local git repository made from the uploaded upstream, file:// URL)
fresh fetch OK / run again "already present" / missing commit: 3 tries, folder removed, exit 1 / hand-placed right version OK / hand-placed other version refused / malformed `UPSTREAM_COMMIT` refused. `bash -n` OK.
The pinned hash equals the comment stored in the uploaded `Mika-main.zip`; its `versionName` is 0.1.52.

Not run: the real download from github.com, Gradle, CI, a device (no network / Android SDK). If the first CI run fails in this step, send the log lines from "git fetch failed".
Next: part 4 (`mika/tools/patch-upstream.sh`: library manifest, `MikaApp` open, `mk_` resources, Rizwan name + greeting; idempotent).

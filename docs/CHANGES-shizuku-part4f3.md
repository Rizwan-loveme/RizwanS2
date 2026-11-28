# Shizuku — part 4F-3 of 10: root checks run all Shizuku checks

Request: 4F-3, keep all details, update the full flat zip. Based on `RizwanS2-main-shizuku-step4f2.zip` (4A - 4E, 4F-1, 4F-2 done there).

New:
- `shizuku/tools/check-all.py` (executable): runs seven steps, each as its own `python3 -I -B` process, all of them even after a failure: S1 `check-gradle.py`, S2 `check-gradle.py --self-test`, S3 `test-check-merged-manifest.py --no-real`, S4 `check-provider-match.py --self-test`, S5 `check-provider-match.py` (real fetched manifests), S6 `patch-upstream.py --check` (patched checkout), S7 `check-merged-manifest.py --variant release|debug` (real merged manifest). S5 - S7 are skipped with a reason when their input is missing; `--require-real` makes a skip a failure, `--no-real` skips them always; `--list`, `-v`, `--root`, `--timeout`; exit 0 / 1 / 2. Own `--self-test` (64 checks on a fake root of stub scripts).
- `docs/CHANGES-shizuku-part4f3.md` (this file).

Changed:
- `mika/tools/static-check.py` (the root check): header text, new check 11 `check_shizuku()` (runs `check-all.py`, prints its lines with a prefix on failure, exit 1 with `::error::static-check: shizuku checks failed ...`), one call in `main`. Skipped with a note if `check-all.py` is absent.
- `shizuku/README.md`: plan row 4 (4F-3 done, 4G-1 next), row 4F-3 (done, details fixed), row 8D-2 (a pointer to `check-all.py --require-real`), new section "4F-3".
- `README.md` (root): plan row 4.

No workflow, manifest, overlay, Gradle file, patch script, checker rule or `check-gradle.py` touched; nothing built. `includeShizuku` is still off by default.

Checked here: `check-all.py` on the real project (S1 - S4 ok, S5 - S7 skipped, exit 0; `--require-real` exit 1); its `--self-test` 64 checks (it found one real bug on the first run: the real steps got their argument twice; fixed); `static-check.py` all checks passed; two throw-away breakages (overlay marker `merge`; `SERVICE_TYPE` `dataSync`) make the root check exit 1; `check-gradle.py` + `--self-test` 33/33; `test-check-merged-manifest.py` 122 cases; `check-provider-match.py --self-test` 12/12; no `__pycache__`.

Not run here: S5 - S7 on real inputs (no network, no Gradle build; tested only against stubs). Not verified: S6 / S7 on a real checkout and a real merged manifest (first CI run).

Next: 4G-1 (`NOTICE-Shizuku.md` permission section), then 4G-2.

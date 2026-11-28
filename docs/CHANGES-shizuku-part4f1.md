# Shizuku — part 4F-1 of 10: manifest rules in `check-gradle.py`

Request: 4F-1, keep all details, update the full flat zip. Based on `RizwanS2-main-shizuku-step4e4c.zip` (4A - 4E done there).

New: `docs/CHANGES-shizuku-part4f1.md` (this file).

Changed:
- `shizuku/tools/check-gradle.py`: item 9 (four rule groups: overlay, wiring, `src/main`, tools), the option `--no-run`, a `--self-test` of 33 cases, the header text; new imports (`shutil`, `subprocess`, `tempfile`, `xml.etree.ElementTree`). Items 1 - 8 unchanged.
- `shizuku/README.md`: plan row 4 (4F-1 done, 4F-2 next), row 4F-1 flipped to done with the decisions, row 4F-3 (also runs the self-test of `check-gradle.py`), new section "4F-1".

No workflow, manifest, overlay, `app/build.gradle.kts`, patch script or other code touched; nothing built. `includeShizuku` is still off by default.

Rules (no Gradle run, no fetched sources, no network):
- `4F-1 overlay`: `app/src/shizuku/AndroidManifest.xml` is present and has exactly the shape of 4B-2: no `package`, one `<application>` without attributes, one empty `<provider rikka.shizuku.ShizukuProvider tools:node="remove">`.
- `4F-1 wiring`: every mention of `src/shizuku` in `app/build.gradle.kts` is inside `if (shizukuIncluded) { }`; exactly one wiring each for `debug` and `release`; no other build file mentions it; no manifest in `app/src/debug` / `app/src/release` (`srcFile` would replace it).
- `4F-1 src/main`: no `ShizukuProvider` string in any text file of `app/src/main`, comments included.
- `4F-1 tools`: seven runs of the helper scripts without the fetched sources: `check-provider-match.py --self-test` (exit 0) and without sources (exit 2), `patch-upstream.py --help` (0), `patch-upstream.py --check` and `patch-upstream.sh --check` on an empty folder (exit 1, own message, no traceback), `check-merged-manifest.py --help` (0), `test-check-merged-manifest.py --list` (0).

Checked here:
- The real project: `check-gradle.py` exit 0 (15 `.kts` files, 11 unique namespaces, 7 helper runs ok), also with `--no-run`.
- `--self-test`: 33 of 33 cases as expected (three cases of the first version expected the wrong message text: a mistake in the self-test, fixed).
- `py_compile` fine; `test-check-merged-manifest.py` still 122 cases ok; no `__pycache__` in the tree.

Not verified: that AGP 8.13.2 accepts the `srcFile` wiring and the overlay removes Mika's provider (first CI run; the merged-manifest rules of 4E catch it); `patch-upstream.py --check` on a real patched checkout (no network); the helper scripts on real inputs. No Gradle run, no device.

Next: 4F-2 (switch default and stale "cannot be installed" notes), then 4F-3, 4G-1, 4G-2.

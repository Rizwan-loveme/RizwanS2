# Shizuku — part 4E of 10: the merged-manifest checker and its self-test

Request: 4E-4c, keep all details, update the full flat zip. Based on `RizwanS2-main-shizuku-step4e4b.zip` (4A - 4D and 4E-1 ... 4E-4b done there). This file sums up the whole of 4E (4E-1 ... 4E-4c); the small files `CHANGES-shizuku-part4e1.md`, `part4e2`, `part4e3`, `part4e4a`, `part4e4b` stay as history.

New in 4E-4c:
- `shizuku/tools/test-check-merged-manifest.py` (executable): the self-test.
- `docs/CHANGES-shizuku-part4e.md` (this file).

Changed in 4E-4c:
- `shizuku/tools/check-merged-manifest.py`: text only. The header (the "coming 4E-4c" lines became the pointer to the self-test), the `--help` description and the last output line ("self-test: shizuku/tools/test-check-merged-manifest.py; later: row 5F adds the direct-boot rule"). No rule, constant or helper changed.
- `shizuku/README.md`: plan row 4 (4E-4c done, 4F-1 next), row 4E-4c flipped to done with the decisions of this part, new section "4E-4c"; row 4F-1 (the self-test must be present and callable), row 4F-3 (the root checks also run the self-test), row 8D-2 (a note that the self-test needs no build).

No workflow, manifest, Gradle, patch script or other code touched; no workflow calls the checker or the self-test yet; nothing built. `includeShizuku` is still off by default.

What 4E built, row by row (the checker `shizuku/tools/check-merged-manifest.py`, 17 rules; they run only when the merged manifest has a `moe.shizuku.manager` component):
- **4E-1:** skeleton (finding the merged manifest, exit codes 0 / 1 / 2, `Merged` / `Component` helpers, the rule registry, `check()` as a pure function).
- **4E-2 (4 rules):** the authority `<applicationId>.shizuku` is used once, by `ShizukuManagerProvider`; that provider owns only it; Mika's `rikka.shizuku.ShizukuProvider` is gone; the provider is exported behind `INTERACT_ACROSS_USERS_FULL`, not multiprocess.
- **4E-3 (5 rules):** `DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION` still declared once and requested; no `API_V23` request; `MANAGER` and `API_V23` declared once; their levels and group; `MANAGER` requested once.
- **4E-4a (5 rules):** the 9 + 1 + 2 + 1 components by name; exactly the six expected components exported; no launcher / leanback / home filter; `AdbPairingService` not exported and `shortService`; exactly three `BOOT_COMPLETED` receivers, no `priority`.
- **4E-4b (3 rules):** no `moe.shizuku.privileged.api` except the one `<queries>` entry (until row 7A-1); no `ShizukuApplication`; no `rikka.shizuku.ShizukuProvider` string.
- **4E-4c:** the self-test (below).

The self-test (`python3 -I shizuku/tools/test-check-merged-manifest.py`; options `-v`, `-k TEXT`, `--list`, `--dump-good`, `--no-real`, `--root DIR`):
- **122 cases** on a hand-made good merged manifest built in code, numbered like the lists of 4E-2 ... 4E-4b: `2-01` ... `2-22` (22), `3-01` ... `3-30` (30), `4a-01` ... `4a-42` (42: the 40 of the list, plus 41 and 42; the list had no text for 36, it is now "Mika's receiver renamed"), `4b-01` ... `4b-24` (24), `x-01` ... `x-04` (4 new). Each case names exactly the rules that must fire (and the number of errors where it matters), the state, notes and a piece of the message; a rule that fires without being named fails the case.
- **Coverage:** every one of the 17 rules is switched off in turn and some case must report that it did not fire. A new rule without a bad case (row 5F's direct-boot rule, say) makes the self-test fail.
- **Registry** (6 checks), **constants** (1: `STALE_QUERY_ALLOWED` is 1 as expected; row 7A-1 sets the checker's constant to 0 and `EXPECTED_STALE_QUERY_ALLOWED` in the self-test in the same step; the cases that depend on the switch set it themselves), **helpers** (23), **command line** (21: exit codes, messages, the search under `app/build/intermediates`, three runs as a real process).
- **Real manifest:** if a Gradle build exists, the checker runs on its merged release / debug manifest and a failing rule fails the run. None exists here (printed "release: none; debug: none").

Checked here:
- The self-test passes: 122 cases, 17 rules covered, 6 + 1 + 23 + 21 checks, all as expected. The one failure of the first run was a mistake in the self-test (case 3-09), not in the checker.
- It notices a broken checker (throw-away copies, not in the zip): `SERVICE_TYPE` changed -> 144 errors; the `multiprocess` test removed -> 2; `STALE_QUERY_ALLOWED` = 2 -> 3; the launcher rule made a no-op -> its cases fail; `STALE_QUERY_ALLOWED` = 0 (the 7A-1 flip) -> only the constants guard fails.
- `py_compile` fine for both scripts; `check-gradle.py` ok (15 `.kts` files, 11 unique namespaces); no `__pycache__` left in the tree.

Not run: the checker on a real merged manifest (no Gradle build here), the pseudo-merge on the real patched manifests of 4E-2 (no network, `shizuku/upstream/` and `mika/upstream/` are not in the zip).

Not verified: the good manifest is hand-made from what 4A, 4D and 4E read, so a green self-test says the rules do what the rows say, not that the real merged manifest passes: that is the first CI run (rows 8D-2 / 8F). Open points for that run: explicit `android:exported` on all 13 components, fully qualified names, Mika's receiver name after its patch, `foregroundServiceType` kept, the `package` attribute, AndroidX core's `DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION` elements, Mika's `<queries>` entry as written; and the 4A heading "all 14" against 13 rows (the checker uses 13). Device behaviour. No Gradle run, no device.

Next: 4F-1 (manifest rules in `check-gradle.py`, and the self-test callable), then 4F-2, 4F-3, 4G-1, 4G-2.

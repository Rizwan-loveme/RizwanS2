# Shizuku — part 4E-4b of 10: string rules

Request: 4E-4b, keep all details, update the full flat zip. Based on `RizwanS2-main-shizuku-step4e4a.zip` (4A - 4D, 4E-1 ... 4E-4a done there).

New: `docs/CHANGES-shizuku-part4e4b.md` (this file).

Changed:
- `shizuku/tools/check-merged-manifest.py`: three rules added (see below), the constants `STALE_PACKAGE`, `STALE_QUERY_ALLOWED`, `APPLICATION_CLASS`, the helpers `Merged.strings_with_context` and `where`, the header text and the last output line ("later: row 4E-4c adds the self-test, row 5F the direct-boot rule").
- `shizuku/README.md`: plan row 4 (4E-4b done, 4E-4c next), row 4E-4b flipped to done, row 4E-4c (the 24 cases may be reused), the status cell of finding 7, rows 7A-1 and 7A-2 (set `STALE_QUERY_ALLOWED = 0` there), new section "4E-4b".

No workflow, manifest, Gradle, patch script or other code touched; no workflow calls the checker yet; nothing built. `includeShizuku` is still off by default.

Rules (they run only when Shizuku is built in; they read every attribute value and element text of the merged manifest):
- `4E-4b stale package`: `moe.shizuku.privileged.api` appears nowhere, except the one exact `<queries><package>` entry of Mika, allowed until row 7A-1 (`STALE_QUERY_ALLOWED = 1`; a note says it is still there).
- `4E-4b application class`: no `<application android:name>` under `moe.shizuku.manager.`, no string containing `ShizukuApplication` (4D-4).
- `4E-4b old provider string`: `rikka.shizuku.ShizukuProvider` appears in no string; a component with exactly that name is left to `4E-2 old provider`.
The checker has 17 rules now; every rule row of 4E is done.

Checked here:
- 24 hand-made good / bad cases through `check()`, all as expected (list in the README section), including the switch `STALE_QUERY_ALLOWED = 0` that row 7A-1 will flip; the command line on a good and a bad file gives exit 0 / 1 (a duplicate error line found there was fixed).
- `py_compile` fine; `check-gradle.py` ok (15 `.kts` files, 11 unique namespaces). The throw-away tests are not in the zip.

Not run: the pseudo-merge on the real patched manifests (no network, `shizuku/upstream/` and `mika/upstream/` are not in the zip).

Not verified: the real merged manifest of a Gradle build (Mika's `<queries>` entry as written, no other module adding the strings); device behaviour. No Gradle run.

Next: 4E-4c (self-test and notes), then 4F-1 ... 4F-3, 4G-1, 4G-2.

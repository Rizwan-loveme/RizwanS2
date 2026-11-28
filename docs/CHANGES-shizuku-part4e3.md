# Shizuku — part 4E-3 of 10: permission rules

Request: 4E-3, keep all details, update the full flat zip. Based on `RizwanS2-main-shizuku-step4e2.zip` (4A - 4D, 4E-1 and 4E-2 done there).

New: `docs/CHANGES-shizuku-part4e3.md` (this file).

Changed:
- `shizuku/tools/check-merged-manifest.py`: five rules added (see below), the constants `PERM_MANAGER`, `PERM_API_V23`, `PERM_GROUP`, `DYNAMIC_RECEIVER_SUFFIX`, the helpers `Merged.permission_elements` and `Merged.add_note`, the header text and the last output line ("more are added by rows 4E-4a, 4E-4b").
- `shizuku/README.md`: plan row 4 (4E-3 done, 4E-4a next), row 4E-3 flipped to done, row 4E-4c (the 30 cases may be reused), the status cells of findings 2, 3 and 4, new section "4E-3".

No workflow, manifest, Gradle, patch script or other code touched; no workflow calls the checker yet; nothing built. `includeShizuku` is still off by default.

Rules (the names with the host package use the `package` attribute of the merged manifest; without it they match the ending and print a note):
- `4E-3 dynamic receiver`: `<applicationId>.DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION` is declared exactly once and requested; no unresolved `${...}` in the name (finding 2; the "requested" half and the count are beyond the row text).
- `4E-3 no API_V23 request`: no `uses-permission` of `moe.shizuku.manager.permission.API_V23` (finding 3).
- `4E-3 declared once`: `moe.shizuku.manager.permission.MANAGER` and `...API_V23` are each declared exactly once (finding 4).
- `4E-3 levels` (beyond the row text): `MANAGER` is `signature`; `API_V23` is `dangerous` in the group `moe.shizuku.manager.permission-group.API`.
- `4E-3 manager request` (beyond the row text, from 4C-3): the host requests `MANAGER` exactly once.
The checker has 9 rules now. They run only when Shizuku is built in; a Mika-only merged manifest still passes (exit 0, "not built in").

Checked here:
- 30 hand-made good / bad cases through `check()`, all as expected (list in the README section); the command line on a good, a bad and a Mika-only file gives exit 0 / 1 / 0.
- `py_compile` fine; `check-gradle.py` ok (15 `.kts` files, 11 unique namespaces). The throw-away tests are not in the zip.

Not run: the pseudo-merge of the real patched manifests (no network, `shizuku/upstream/` and `mika/upstream/` are not in the zip).

Not verified: the real merged manifest of a Gradle build (AndroidX core's `DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION` elements reaching it, the `API_V23` guard leaving no request behind in AGP 8.13.2, the `package` attribute); device behaviour. No Gradle run.

Next: 4E-4a (component rules), then 4E-4b, 4E-4c, 4F-1 ... 4F-3, 4G-1, 4G-2.

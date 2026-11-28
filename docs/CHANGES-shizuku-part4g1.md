# Shizuku — part 4G-1 of 10: `NOTICE-Shizuku.md`, permission section

Request: 4G-1, keep all details, update. Based on `RizwanS2-main-shizuku-step4f3.zip` (4A - 4F done there).

New: `docs/CHANGES-shizuku-part4g1.md` (this file).

Changed (documentation only):
- `NOTICE-Shizuku.md`: new section "Permissions, who declares what (status after step 4G-1)" (declared once by `:shizuku`: `MANAGER` signature, `API_V23` dangerous with its group; what the host requests; the `API_V23` guard; no `V3_SUPPORT`; `:mika` declares nothing; the removed `DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION` markers; the manager's other permission names; table of the five shared `uses-permission`; the two `uses-feature`; what is not changed and the open rows 5E - 5G); two new items in the list of changes (the dropped markers, the overlay removing Mika's provider); the first paragraph and the status bullets brought up to date (step 4 done and statically checked, not built).
- `shizuku/README.md`: plan row 4 (4G-1 done, 4G-2 next), row 4G-1 (done, details fixed), new section "4G-1".
- `README.md` (root): plan row 4.

No code, script, manifest, overlay, Gradle file or workflow touched; nothing built. `includeShizuku` is still off by default. The licence column of the library table stays "to confirm in step 9".

Checked here: `check-gradle.py` ok; `check-all.py` S1 - S4 ok, S5 - S7 skipped (no fetched sources, no build); `static-check.py` all checks passed; no CR in the notice; Markdown table rows have equal column counts. Not verified: the merged manifest of a real build (first CI run).

Next: 4G-2 (step 4 notes and the flat zip `RizwanS2-main-shizuku-step4.zip`).

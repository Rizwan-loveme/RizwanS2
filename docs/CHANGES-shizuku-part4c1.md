# Shizuku — part 4C-1 of 10: the DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION removal is dropped

Request: 4C1, keep all details, update the full flat zip. Based on `RizwanS2-main-shizuku-step4b.zip` (4A and all of 4B done there).

New: `docs/CHANGES-shizuku-part4c1.md` (this file).

Changed:
- `shizuku/tools/patch-upstream.py` — docstring (part B), `patch_manifest` and its print line: the `<permission>` and `<uses-permission>` of `${applicationId}.DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION` (both `tools:node="remove"` upstream, lines 42 - 48) are deleted from the generated manager manifest. It dies unless exactly one of each exists and both carry `tools:node="remove"`. Reason (4A finding 2): in a library the marker would remove the permission from the whole app, so AndroidX `registerReceiver(..., RECEIVER_NOT_EXPORTED)` crashes on Android 8 - 12.
- `shizuku/README.md` — plan row (4C-1 done, 4C-2 next), row 4C-1 flipped, finding 2 marked fixed, new section "4C-1".

Results (real v13.6.0 checkout fetched + patched): 0 `DYNAMIC_RECEIVER` left in the generated manifest; `MANAGER`, `API_V23`, the `API_V23` remove guard, `uses-permission MANAGER`, 5 shared `uses-permission`, 2 `uses-feature` still there; 9 activities / 1 service / 2 receivers / 1 provider. Patch run, forced re-patch and `--check` ok; counts unchanged (9 places in 7 files, 237 names, 87 files, 42 languages); manifest well-formed; `check-gradle.py` ok (15 `.kts`, 11 namespaces).

Not touched: any Gradle file, project manifest, workflow, Mika file, other tool. `includeShizuku` stays off by default. The fetched `upstream/` folder is not in the zip.

Not verified: a Gradle merge (AndroidX core supplying the declaration in the merged manifest: first CI run and 4E-3). Not done on purpose: the self-check rule and numbers re-check = 4C-2.

Next: 4C-2 (self-check rule "permission carries no remove marker", rerun, README numbers), 4C-3 (permission ownership), 4C-4 (duplicates re-check), then 4D, 4E-1 ... 4E-4, 4F, 4G.

# Shizuku — part 4C-3 of 10: permission ownership (MANAGER, API_V23)

Request: 4C3, keep all details, update the full flat zip. Based on `RizwanS2-main-shizuku-step4c2.zip` (4A, 4B, 4C-1 and 4C-2 done there).

New: `docs/CHANGES-shizuku-part4c3.md` (this file).

Changed:
- `shizuku/tools/patch-upstream.py` — docstring part D; new function `check_shizuku_permissions(man_xml, errors)`: `MANAGER` (signature) and `API_V23` (dangerous, group `moe.shizuku.manager.permission-group.API`) declared exactly once each without a `tools:node` marker; exactly one `uses-permission` of `MANAGER` without marker (the host asks for it); exactly one `uses-permission` of `API_V23` with `tools:node="remove"` (the guard). Called from `check` (patch run and `--check`); the "D. self-check ok" line names it.
- `app/src/main/AndroidManifest.xml` — one comment (no element, no attribute) before the debug-log activity: who owns the two permissions, what the app asks for, why it does not ask for `API_V23`, which checks cover it.
- `shizuku/README.md` — plan row (4C-3 done, 4C-4 next), row 4C-3 flipped, findings 3 and 4 marked checked, new section "4C-3".

Checked in the project files (no network): none of Mika's 30 permissions is a Shizuku one and `moe.shizuku.manager.permission.*` appears nowhere outside `shizuku/` and docs; the Maven `api` / `provider` artifacts (the only other source of the `API_V23` request) are replaced by local modules whose manifests are not merged (root `build.gradle.kts`, 3F); with the switch off nothing changes; `:mika` comes before `:shizuku` in `app/build.gradle.kts` and has nothing to remove anyway.

Results: self-test on hand-made manifests 15 of 15 as expected (1 good, 14 bad); both 4C rules together give 0 errors on a good manifest; `py_compile` ok; `check-gradle.py` ok (15 `.kts`, 11 namespaces); `:app` manifest well-formed, no `ShizukuProvider` string in it.

Not touched: any Gradle file, workflow, Mika file, other tool, any manifest element. `includeShizuku` stays off by default. The fetched `upstream/` folder is not in the zip.

Not verified: the rule on the real generated manifest (fetch + patch + `--check`), `check-provider-match.py`, a Gradle merge (4E-3, first CI run); this session had no network access.

Next: 4C-4 (duplicates re-check), then 4D, 4E-1 ... 4E-4, 4F, 4G.

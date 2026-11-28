# Shizuku — part 4C-2 of 10: self-check rule for DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION

Request: 4C2, keep all details, update the full flat zip. Based on `RizwanS2-main-shizuku-step4c1.zip` (4A, 4B and 4C-1 done there).

New: `docs/CHANGES-shizuku-part4c2.md` (this file).

Changed:
- `shizuku/tools/patch-upstream.py` — docstring part D; new function `check_dynamic_receiver_permission(man_xml, errors)` (every element of the generated manager manifest; an element named `...DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION` with `tools:node` = `remove` / `removeAll` / `replace` is an error; not well-formed XML is an error); called from `check` (patch run and `--check`); the "D. self-check ok" line names the new rule.
- `shizuku/README.md` — plan row (4C-2 done, 4C-3 next), row 4C-2 flipped, finding 2 note, "Not done" line of 4C-1, new section "4C-2".

Results: self-test on hand-made manifests 10 of 10 as expected (3 good, 7 bad); synthetic upstream-like manifest through the real `patch_manifest` gives 0 mentions and 0 rule errors, the `API_V23` guard stays, and the patch still dies when an upstream marker is missing (4C-1); `py_compile` ok; `check-gradle.py` ok (15 `.kts`, 11 namespaces). No count can move (the rule reads, it does not patch): 9 places in 7 files, 237 names, 87 files, 42 languages, 9 / 1 / 2 / 1 components stay as measured in 4C-1.

Not touched: any Gradle file, project manifest, workflow, Mika file, other tool. `includeShizuku` stays off by default. The fetched `upstream/` folder is not in the zip.

Not verified: the rerun on the real v13.6.0 checkout (fetch, patch, forced re-patch, `--check`) and `check-provider-match.py`, because this session had no network access; the merged manifest of a real Gradle build (4E-3, first CI run).

Next: 4C-3 (permission ownership), 4C-4 (duplicates re-check), then 4D, 4E-1 ... 4E-4, 4F, 4G.

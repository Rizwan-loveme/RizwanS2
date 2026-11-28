# Shizuku — part 4E-1 of 10: merged-manifest checker skeleton

Request: 4E-1, keep all details, update the full flat zip. Based on `RizwanS2-main-shizuku-step4d.zip` (4A - 4D done there).

New:
- `shizuku/tools/check-merged-manifest.py` (the skeleton, executable).
- `docs/CHANGES-shizuku-part4e1.md` (this file).

Changed: `shizuku/README.md` only (plan row 4: 4E-1 done, 4E-2 next; row 4E-1 flipped to done; new section "4E-1"; row 8D-2 now names the call and the flags). No other code, script, manifest, workflow or Gradle file touched; no workflow calls the new script yet; nothing built. `includeShizuku` is still off by default.

What the script is:
- Command line `[AndroidManifest.xml] [--variant release|debug] [--root DIR] [--require-shizuku]`; without a path it finds `app/build/intermediates/**/merged_manifests/<variant>*/**/AndroidManifest.xml` the way the workflows do (shortest path first, so it is deterministic).
- Exit codes: 0 pass (or Shizuku not built in), 1 a rule failed (or `--require-shizuku` and no Shizuku component), 2 the script could not run (bad option, file missing, not XML, wrong root, no `<application>`, no build output; message tells to run assemble first).
- `::error::Shizuku manifest: [rule id] text` lines, like the other checkers.
- With no `moe.shizuku.manager` component in the merged manifest (includeShizuku off) it says so and exits 0; `--require-shizuku` makes that an error for use after 8F.
- Helper classes `Merged` and `Component` (components by kind / prefix, requested and declared permissions with duplicates kept, features, `<queries>`, `exported`, `directBootAware`, authorities, `foregroundServiceType`, intent filters with actions / categories / priority, launcher test), the `@rule(...)` registry, and `check(root, require_shizuku)` as a pure function for the self-test of 4E-4c.
- It carries **no rule yet**, and its success line says "SKELETON: no rule is registered yet", so a green run is never mistaken for a check. Rules come in 4E-2, 4E-3, 4E-4a, 4E-4b (and 5F for the direct-boot rule).

Checked here: `py_compile` fine; `check-gradle.py` still ok (15 `.kts` files, 11 unique namespaces); run on hand-made manifests and on a fake `merged_manifests/{release,debug}` tree for every exit code and message listed above; a throw-away test of every helper and of the rule registry passed (not part of the zip; 4E-4c writes the real self-test).

Not verified: the exact folder AGP 8.13.2 writes the merged manifest into (search is by path part; first CI run confirms); that the real merged manifest has fully qualified `moe.shizuku.manager` names (the merger resolves them; Mika's checker relies on the same). No Gradle run, no device. The fetched upstream checkouts were not needed in this part.

Next: 4E-2 (provider and authority rules), then 4E-3, 4E-4a ... 4E-4c, 4F-1 ... 4F-3, 4G-1, 4G-2.

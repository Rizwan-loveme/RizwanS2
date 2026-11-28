# Shizuku — part 4E-2 of 10: provider and authority rules

Request: 4E-2, keep all details, update the full flat zip. Based on `RizwanS2-main-shizuku-step4e1.zip` (4A - 4D and 4E-1 done there).

New: `docs/CHANGES-shizuku-part4e2.md` (this file).

Changed:
- `shizuku/tools/check-merged-manifest.py`: four rules added (see below), `Merged.package` and a notes list, small fixes (plural of "activities", the rule list printed on success, the help text).
- `shizuku/README.md`: plan row 4 (4E-2 done, 4E-3 next), row 4E-2 flipped to done, row 4E-4c (the 22 cases may be reused), the "Still open from 4C" line (real-source rerun closed), new section "4E-2".

No workflow, manifest, Gradle or other code touched; no workflow calls the checker yet; nothing built. `includeShizuku` is still off by default.

Rules (all use the `package` attribute of the merged manifest as `<applicationId>`, so a CI rename of the package is followed; without it they fall back to the `.shizuku` ending and print a note):
- `4E-2 authority`: `<applicationId>.shizuku` is declared exactly once, by `moe.shizuku.manager.ShizukuManagerProvider`; no provider authority keeps an unresolved `${...}`.
- `4E-2 owner`: the manager's provider is in the merged manifest once and has exactly that one authority.
- `4E-2 old provider`: `rikka.shizuku.ShizukuProvider` (Mika's, removed on purpose by the 4B overlay) is gone.
- `4E-2 provider guard` (added beyond the row text, from the 4A table): the manager's provider is `exported=true`, behind `android.permission.INTERACT_ACROSS_USERS_FULL`, not `multiprocess`.
The rules run only when Shizuku is built in; a Mika-only merged manifest still passes (exit 0, "not built in").

Checked here:
- 22 hand-made good / bad cases through `check()`, all as expected (list in the README section).
- The real source: `fetch-upstream.sh`, `patch-upstream.sh` and `patch-upstream.py --check` on Shizuku v13.6.0 ran, `D. self-check ok` including the rules of 4C-1 ... 4C-3; this closes the open "real-source rerun" of 4C-2 / 4C-3. Mika 0.1.52 fetched and patched.
- A pseudo-merge of the real patched Shizuku and Mika manifests (throw-away script, not the Android merger): with Mika's provider kept the checker fails with exactly the two expected errors; with it dropped it passes (9 activities, 1 provider, 2 receivers, 1 service; 4 rules).
- `py_compile` fine; `check-gradle.py` unchanged. The fetched upstream folders and the throw-away tests are not in the zip.

Not verified: the real merged manifest of a Gradle build (resolved authority, `package` attribute on `<manifest>`, that the overlay's `tools:node="remove"` removes Mika's provider in AGP 8.13.2; the overlay's marker writes `android:authority`, singular, harmless because the merger keys by `android:name`, 4B-1); device behaviour. No Gradle run.

Next: 4E-3 (permission rules), then 4E-4a ... 4E-4c, 4F-1 ... 4F-3, 4G-1, 4G-2.

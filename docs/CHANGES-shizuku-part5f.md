# Shizuku — row 5F (direct-boot patch, finding 12)

Request: 5F, keep all details, update the full flat zip, and say which steps are left. Based on `RizwanS2-main-shizuku-step5e.zip` (5A, 5B-1, 5B-2, 5C, 5D and 5E done there). The pasted text at the top of the request listed the open steps; the zip's state agreed with it (the next row was 5F).

Result: **the manager no longer makes the host start its main process before the first unlock.** Finding 12 (found in 4D-3, decided in 4D-4 as option a+): upstream's `BootCompleteReceiver`, `ShizukuReceiver` and `ShizukuManagerProvider` are `android:directBootAware`, and `BootCompleteReceiver` listens to `LOCKED_BOOT_COMPLETED`. In the host that would run `App.onCreate` (log, theme, Seal, Mika) on locked storage. Cost of the fix: Shizuku's boot start runs after the first unlock instead of before it.

What the patch does (new part G of `shizuku/tools/patch-upstream.py`, `patch_direct_boot()`, called right after `patch_manifest`):
- asserts its anchors (each one stops the script): the header comment of part B is there; the three components exist once each and carry the flag; no other element carries it; `BootCompleteReceiver` has exactly one `LOCKED_BOOT_COMPLETED` action and keeps exactly one `BOOT_COMPLETED` action;
- removes the flag from the three components and the LOCKED filter (or only the action, when it shares a filter); adds one sentence to the header comment; nothing else of the manifest changes.

Self-check: new rule `check_direct_boot()` (no element `directBootAware` other than `false`, no `LOCKED_BOOT_COMPLETED` action, exactly one `BootCompleteReceiver` with one `BOOT_COMPLETED` action); runs in the patch run, in `patch-upstream.py --check` and so in S6 of `check-all.py`.

Merged-manifest checker (`shizuku/tools/check-merged-manifest.py`): two rules added together, so the counts change once (17 -> **19 rules**, 122 -> **147 cases**):
- `5F direct boot`: no component of `moe.shizuku.manager` is `directBootAware` or listens to `LOCKED_BOOT_COMPLETED` (components of `:app` and Mika are not judged);
- `5F custom actions` (the note from 5D): `<package>.intent.action.REQUEST_PERMISSION` only on `RequestPermissionActivity`, `<package>.intent.action.REQUEST_AUTHORIZATION` only on `LegacyIsNotSupportedActivity`, `rikka.shizuku.intent.action.REQUEST_BINDER` only on `ShellRequestHandlerActivity` and `ShizukuReceiver`, no other custom action on a manager component.
The last output line no longer says "later: row 5F adds the direct-boot rule".

Changed:
- `shizuku/tools/patch-upstream.py`: new constants (`DIRECT_BOOT_COMPONENTS`, `BOOT_RECEIVER_NAME`, `BOOT_ACTION`, `LOCKED_BOOT_ACTION`, `MANIFEST_HEADER_END`, `MANIFEST_HEADER_NOTE`), `patch_direct_boot()`, `check_direct_boot()`, one call in `main()`, one in `check()`, docstring part G, the self-check line. What parts A - F write is unchanged.
- `shizuku/tools/check-merged-manifest.py`: the two rules, three constants, docstring and help text.
- `shizuku/tools/test-check-merged-manifest.py`: the good manifest now looks like the real patched result (the manager's boot receiver has only `BOOT_COMPLETED`; `ShizukuReceiver` carries `REQUEST_BINDER` instead of a made-up action); cases `4a-07`, `4a-18`, `4a-34` adjusted; 25 new cases `5f-01` ... `5f-25`; a `5F` line in the group list.
- `shizuku/tools/test-patch-host-package.py`: 44 new cases (118 -> 162).
- `shizuku/tools/check-gradle.py`: new item 14 (`5F direct boot components`, `5F direct boot patch`, `5F direct boot check`, `5F merged rule`); `--self-test` 56 -> 61 cases; header text updated.
- `shizuku/tools/check-all.py`: help text says 61 / 147 / 19 (no behaviour change).
- `app/build.gradle.kts`: one comment, "(5F - 5G)" -> "(5G)". No behaviour change.
- Docs: `shizuku/README.md` (new section "5F", plan rows 5 and 5F, finding 12 and the decisions table, hand-over bullet, device list, S1 / S3 rows, step 2 update), `README.md` (plan row 5 and a state paragraph), `NOTICE-Shizuku.md` (one bullet in the list of changes, the "not yet fixed" sentence), this file. Earlier sections keep the numbers they measured then (118 / 56 / 122 / 17).

Run: `test-patch-host-package.py` 162 of 162 (three throw-away mutations made 4, 1 and 4 of the new cases fail, so they can fail); `check-gradle.py --self-test` 61 of 61; `check-gradle.py` ok; `test-check-merged-manifest.py --no-real` 147 cases, 19 rules covered; `check-all.py --no-real` S1 - S4 ok (S5 - S7 skipped); `check-all.py --self-test` 64 checks; `sweep-package-strings.py --self-test` 37; `check-provider-match.py --self-test` 12; `mika/tools/static-check.py` all checks passed.

Not run: the patch on the real source (**no network in this session**, `shizuku/upstream/` is not in the zip: the anchors come from the real manifest read of 4A / 4D-3, and the script stops loudly if one is wrong), any Gradle build (S7, the merged manifest), any device (the reboot / first-unlock case is on the device list of 4G-2). No workflow, Gradle build logic, Kotlin / Java file or resource of the project touched; `includeShizuku` is still off by default.

Flat zip: `RizwanS2-main-shizuku-step5f.zip`. Next: 5G (night-mode patch, finding 14), then steps 6 - 10.

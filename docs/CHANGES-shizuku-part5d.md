# Shizuku — row 5D (intent actions)

Request: 5D, keep all details, update the full flat zip. Based on `RizwanS2-main-shizuku-step5c.zip` (5A, 5B-1, 5B-2 and 5C done there). The pasted summary of the request was older than the zip (it still said "next: 4B-1"); the zip's state was used (next row was 5D).

Result: **the intent actions need no edit.** Read on the real v13.6.0 source (network was available this time, so the patch ran for real):
- `<host>.intent.action.REQUEST_PERMISSION`: the server (`ShizukuService.showPermissionConfirmation`) sends `new Intent(ServerConstants.REQUEST_PERMISSION_ACTION).setPackage(MANAGER_APPLICATION_ID)`; `ServerConstants` builds it as `MANAGER_APPLICATION_ID + ".intent.action.REQUEST_PERMISSION"`; `RequestPermissionActivity` has the filter `${applicationId}.intent.action.REQUEST_PERMISSION`. After part A / the merge both are the host package. Outside clients never send it (they use the binder).
- `<host>.intent.action.REQUEST_AUTHORIZATION`: no sender anywhere; manifest only, on `LegacyIsNotSupportedActivity`, which is protected by a permission nobody declares. Follows `${applicationId}`.
- `rikka.shizuku.intent.action.REQUEST_BINDER` (shell loader -> `ShizukuReceiver` / `ShellRequestHandlerActivity`) and the API provider's `moe.shizuku.api.action.BINDER_RECEIVED`: library names, stay.
- The sweep's single `[review]` line (`AppConstants.PACKAGE`) only prefixes `StarterActivity`'s in-app extras: stays.
- Answers the open question of 5C (`REQUEST_PERMISSION_ACTION` is built from `MANAGER_APPLICATION_ID`) and closes its "quick look" (`grep intent.extra.BINDER`: 4 hits in the 4 expected files).

Finding 16 (low, owner decision, default leave): on Android 8.0 / 8.1 the shell loader's fallback starts a chooser around `REQUEST_BINDER` without a package; with a stock Shizuku installed too, the chooser shows two apps (upstream does the same). Not patched: untestable path.

Changed:
- `shizuku/tools/patch-upstream.py`: new constants (`ACTION_PERMISSION_SUFFIX`, `ACTION_AUTHORIZATION_SUFFIX`, `ACTION_BINDER`, `ACTION_BINDER_RECEIVED`, `MANIFEST_ACTIONS`, `BINDER_ACTION_FILES`, `ACTION_LITERAL_RE`, `ACTION_LITERALS_ALLOWED`), new `action_source_files()` and `check_intent_actions()` (six rule groups), one call in `check()`, docstring part D and the "D. self-check ok" line. **What the patch writes is unchanged.**
- `shizuku/tools/test-patch-host-package.py`: 28 new cases (60 -> 88).
- `shizuku/tools/check-gradle.py`: new item 12 (`5D action table`, `5D action names`, `5D binder action`, `5D unknown actions`, `5D action check`); `--self-test` 47 -> 51 cases; header text updated.
- `shizuku/tools/check-all.py`: docstring says 51 cases for S2 (no behaviour change).
- Docs: `shizuku/README.md` (plan row 5, row 5D done with details, row 5F note, new section "5D", finding 16 in the 4A table, device-list and open-list notes of 4G-2, update note in the step 2 section), `README.md` (plan row 5 and a state paragraph), `NOTICE-Shizuku.md` (one bullet), this file. Earlier sections keep the numbers they measured then (47 / 60 cases).

Run: `test-patch-host-package.py` 88 of 88 (three throw-away mutations made 20, 6 and 5 of the new cases fail, so they can fail); `check-gradle.py --self-test` 51 of 51; `check-gradle.py` ok; on the real source: `patch-upstream.sh` + `--check` self-check ok with unchanged numbers (5 places in 5 files, 4 kept keys, 237 names, 87 files, 42 languages), `check-all.py` S1 - S6 ok (S5 / S6 on real inputs), S7 skipped (no build); `check-all.py --self-test` 64 checks; `test-check-merged-manifest.py --no-real` 122 cases; `sweep-package-strings.py` self-test 37 and real run ok; `mika/tools/static-check.py` all checks passed.

Not run: any Gradle build (S7, the merged manifest), any device. The merged-manifest rule for the actions goes into row 5F (it changes the rule / case counts, which 5F changes anyway). No workflow, manifest, Gradle build logic, Kotlin / Java file or resource of the project touched; `includeShizuku` is still off by default.

Flat zip: `RizwanS2-main-shizuku-step5d.zip`. Next: 5E (pairing-service timeout, finding 11), then 5F, 5G.

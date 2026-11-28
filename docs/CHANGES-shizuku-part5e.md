# Shizuku — row 5E (pairing-service timeout, finding 11)

Request: 5E, keep all details, update the full flat zip, and say which steps are left. Based on `RizwanS2-main-shizuku-step5d.zip` (5A, 5B-1, 5B-2, 5C and 5D done there). The pasted text at the top of the request was older than the zip (it still said "next: 4C-4a"); the zip's state was used (the next row was 5E).

Result: **the pairing service now stops itself at the short-service limit.** Finding 11 (found in 4D-2): `AdbPairingService` is a `shortService` (about 3 minutes from `startForeground`) but keeps the mDNS search open until pairing works or the user stops it. On Android 14+ the system calls `Service.onTimeout` at the limit and raises `RemoteServiceException` when the service does not stop. Upstream that closes only the Shizuku app; here the manager runs in the main process of the host, so it would close the whole app.

What the patch does (new part F of `shizuku/tools/patch-upstream.py`, `patch_pairing_service()`, called after `patch_library_code`):
- asserts its anchors (each one stops the script with a message): the file `manager/src/main/java/moe/shizuku/manager/adb/AdbPairingService.kt` exists; it has no `onTimeout` yet; it has an `override fun onDestroy(` (the mDNS search is stopped there and `stopSelf()` leads to it); exactly one `class AdbPairingService : Service() {`;
- inserts, right after the class line, `override fun onTimeout(startId: Int)` and `override fun onTimeout(startId: Int, fgsType: Int)` (API 34 and API 35), each `stopForeground(STOP_FOREGROUND_REMOVE)` then `stopSelf()`;
- user effect: after about 3 minutes the "searching" notification goes away and the pairing has to be started again; no crash.

Self-check: new rule `check_pairing_timeout()` (exactly two `fun onTimeout`, each signature once and inside the class, each body calls `stopForeground(STOP_FOREGROUND_REMOVE)` once and then `stopSelf()` once, comments do not count, `onDestroy` still there). It runs in the patch run, in `patch-upstream.py --check` and so in S6 of `check-all.py`. The manifest side (`shortService`, not exported) is still checked by `4E-4a service`; no manifest rule changed, so the merged-manifest checker keeps its 17 rules and 122 cases.

Changed:
- `shizuku/tools/patch-upstream.py`: new constants (`PAIRING_SERVICE`, `PAIRING_CLASS_RE`, `PAIRING_TIMEOUT_CODE`, `PAIRING_TIMEOUT_SIGS`), `patch_pairing_service()`, `kotlin_block()`, `check_pairing_timeout()`, one call in `main()`, one call in `check()`, docstring part F and the self-check line. What parts A - E write is unchanged.
- `shizuku/tools/test-patch-host-package.py`: 30 new cases (88 -> 118).
- `shizuku/tools/check-gradle.py`: new item 13 (`5E pairing file`, `5E pairing signatures`, `5E pairing code`, `5E pairing patch`, `5E pairing check`); `--self-test` 51 -> 56 cases; header text updated.
- `shizuku/tools/check-all.py`: docstring says 56 cases for S2 (no behaviour change).
- `app/build.gradle.kts`: one comment, "(5E - 5G)" -> "(5F - 5G)". No behaviour change.
- Docs: `shizuku/README.md` (plan row 5, row 5E done with details, new section "5E", findings 11 and 16 notes, device list of 4G-2, hand-over bullet), `README.md` (plan row 5 and a state paragraph), `NOTICE-Shizuku.md` (one bullet in the list of changes, the "not yet fixed" sentence), this file. Earlier sections keep the numbers they measured then (88 / 51 cases).

Run: `test-patch-host-package.py` 118 of 118 (four throw-away mutations made 12, 1, 1 and 1 of the new cases fail, so they can fail); `check-gradle.py --self-test` 56 of 56; `check-gradle.py` ok; `check-all.py --no-real` S1 - S4 ok (S5 - S7 skipped); `check-all.py --self-test` 64 checks; `test-check-merged-manifest.py --no-real` 122 cases; `sweep-package-strings.py --self-test` 37; `check-provider-match.py --self-test` 12; `mika/tools/static-check.py` all checks passed.

Not run: the patch on the real source (**no network in this session**, `shizuku/upstream/` is not in the zip: the anchors come from the real read of 4D-2 and the script stops loudly if one is wrong), any Gradle build (S7, the merged manifest), any device (the 3-minute case is on the device list of 4G-2). Finding 16 (Android 8.0 / 8.1 chooser) was not patched: owner decision, default leave. No workflow, manifest, Gradle build logic, Kotlin / Java file or resource of the project touched; `includeShizuku` is still off by default.

Flat zip: `RizwanS2-main-shizuku-step5e.zip`. Next: 5F (direct-boot patch, finding 12), then 5G (night-mode patch, finding 14), then steps 6 - 10.

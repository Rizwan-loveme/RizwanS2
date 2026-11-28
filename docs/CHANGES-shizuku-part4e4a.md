# Shizuku — part 4E-4a of 10: component rules

Request: 4E-4a, keep all details, update the full flat zip. Based on `RizwanS2-main-shizuku-step4e3.zip` (4A - 4D, 4E-1, 4E-2 and 4E-3 done there).

New: `docs/CHANGES-shizuku-part4e4a.md` (this file).

Changed:
- `shizuku/tools/check-merged-manifest.py`: five rules added (see below), the constants `MIKA_NS`, `MIKA_BOOT`, `MANAGER_BOOT`, `APP_BOOT_SIMPLE`, `BOOT_ACTION`, `LAUNCHER_CATEGORIES`, `MANAGER_EXPECTED`, `MANAGER_EXPORTED`, `SERVICE_TYPE`, the helpers `full`, `is_exported`, `mika_present`, the header text and the last output line ("more are added by row 4E-4b").
- `shizuku/README.md`: plan row 4 (4E-4a done, 4E-4b next), row 4E-4a flipped to done, row 4E-4c (the 40 cases may be reused), the status cell of finding 6, new section "4E-4a".

No workflow, manifest, Gradle, patch script or other code touched; no workflow calls the checker yet; nothing built. `includeShizuku` is still off by default.

Rules (they run only when Shizuku is built in):
- `4E-4a inventory`: exactly the 9 activities, 1 service, 2 receivers, 1 provider of `moe.shizuku.manager`, compared by name, each once, no `activity-alias`.
- `4E-4a exported`: exported = exactly `RequestPermissionActivity`, `ShellRequestHandlerActivity`, `LegacyIsNotSupportedActivity`, the two receivers and the provider; everything else not exported.
- `4E-4a launcher`: no `LAUNCHER` category on a manager component (`LEANBACK_LAUNCHER` and `HOME` too, beyond the row text).
- `4E-4a service`: `AdbPairingService` not exported, `foregroundServiceType` exactly `shortService` (4D-2).
- `4E-4a boot receivers`: exactly three receivers listen to `BOOT_COMPLETED` (`:app` `BootReceiver` by simple name, Mika's `BootRestoreReceiver`, the manager's `BootCompleteReceiver`), none of their filters has a `priority`; two are expected when Mika is not in the build (a note says so) (4D-3).
Not added on purpose: the direct-boot rule (finding 12), it comes with row 5F. The checker has 14 rules now.

Checked here:
- 40 hand-made good / bad cases through `check()`, all as expected (list in the README section); the command line on a good and a bad file gives exit 0 / 1.
- `py_compile` fine; `check-gradle.py` ok (15 `.kts` files, 11 unique namespaces). The throw-away tests are not in the zip.

To check: the 4A table heading says "all 14" components but its rows add up to 13 (so does the 4E-2 pseudo-merge); the checker uses 13. Not changed in the heading (no network).

Not run: the pseudo-merge on the real patched manifests (no network, `shizuku/upstream/` and `mika/upstream/` are not in the zip).

Not verified: the real merged manifest of a Gradle build (explicit `android:exported`, Mika's receiver name after its patch, `foregroundServiceType` kept); device behaviour. No Gradle run.

Next: 4E-4b (string rules), then 4E-4c, 4F-1 ... 4F-3, 4G-1, 4G-2.

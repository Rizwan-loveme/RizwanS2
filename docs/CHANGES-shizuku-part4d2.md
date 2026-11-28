# Shizuku — part 4D-2 of 10: `AdbPairingService` (docs only)

Request: 4D-2, keep all details, update the full flat zip. Based on `RizwanS2-main-shizuku-step4d1.zip` (4A, 4B, 4C and 4D-1 done there).

New: `docs/CHANGES-shizuku-part4d2.md` (this file).

Changed: `shizuku/README.md` only. No code, script, manifest, workflow or Gradle file touched; nothing built. `includeShizuku` is still off by default.

README edits:
- Plan row 4: 4D-1, 4D-2 done, 4D-3 next. Plan row 5: split now 5A - 5E.
- Row 4D-2 flipped to done; new section "4D-2".
- Finding 6 closed ("checked in 4D-2"); 4A component table: service row marked checked.
- New finding 11 (see below) and new row 5E in the step 5 table.
- Row 4E-4a gets one more rule: the service is not exported and its `foregroundServiceType` is exactly `shortService`.

Method: this time GitHub was reachable, so the real upstream source at the pinned commit `2650830` (v13.6.0) was read: the manifest, `AdbPairingService.kt`, `AdbPairingTutorialActivity.kt`, `AdbMdns.kt`, `StartWirelessAdbViewHolder.kt`, and a whole-repo grep for every user of the service and for `onTimeout`. The `shortService` rules were checked against the Android developer documentation.

Result:
- Manifest side is fine. The service is not exported; the code passes `FOREGROUND_SERVICE_TYPE_MANIFEST`, so `shortService` is the only type; it needs only `FOREGROUND_SERVICE`, which `:app`, Mika and `:shizuku` all declare (merges to one, 4C-4a). Nothing to add at targetSdk 37. API level is safe for minSdk 26 (code is only reached on Android 11+). Only `AdbPairingTutorialActivity` starts it.
- **New finding 11 (medium):** a short service may run about 3 minutes from `startForeground`, but this service searches via mDNS until pairing works or the user taps stop, and the clock starts when the tutorial screen opens. At the limit Android 15+ calls `Service.onTimeout`; upstream has no override anywhere, so the system raises `RemoteServiceException` and the app crashes. Upstream that closes only Shizuku; here the manager runs in the host's main process, so the whole app would close. Proposed fix: row **5E**, a small patch of `AdbPairingService.kt` in `patch-upstream.py` (override `onTimeout`, stop foreground + service) with one self-check rule. Not done in 4D-2 because the row is docs only; no other row depends on it.

Not verified: behaviour on real Android 14 / 15 / 16 / 17 devices (docs only, nothing run); whether the second `startForeground` extends the limit; any extra Android 17 rule for short services; the generated and merged manifests (4E, first CI run). `patch-upstream.py` was not re-run (unchanged).

Next: 4D-3 (the three `BOOT_COMPLETED` receivers), then 4D-4, 4E-1 ... 4E-4c, 4F-1 ... 4F-3, 4G-1, 4G-2.

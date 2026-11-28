# Shizuku — part 4D-3 of 10: the three `BOOT_COMPLETED` receivers (docs only)

Request: 4D-3, keep all details, update the full flat zip. Based on `RizwanS2-main-shizuku-step4d2.zip` (4A, 4B, 4C, 4D-1 and 4D-2 done there).

New: `docs/CHANGES-shizuku-part4d3.md` (this file).

Changed: `shizuku/README.md` only. No code, script, manifest, workflow or Gradle file touched; nothing built. `includeShizuku` is still off by default.

README edits:
- Plan row 4: 4D-1 ... 4D-3 done, 4D-4 next. Row 4D-3 flipped to done; new section "4D-3" (comparison table of the three receivers, 8 findings, decision, not-verified list).
- New findings 12 and 13 in the 4A findings table (see below).
- 4A component table: the `BootCompleteReceiver` row marked checked.
- Row 4D-4 gets the two follow-ups (place of the init call, decision on finding 12); row 4E-4a gets two more rules (exactly three `BOOT_COMPLETED` receivers, no `priority`; plus the direct-boot rule if option (a) is chosen); row 6E gets the placement note; row 8F gets "not before 6E".
- "What 4B - 4G take from this": 4D line mentions the new findings.

Method: GitHub was reachable, so the real upstream source at the pinned commits was read (Shizuku v13.6.0 `2650830`, Mika 0.1.52 `7ff1703`): the receivers, their manifest entries, `ShizukuApplication.kt`, `ShizukuSettings.java`, Mika's `BootRestoreHandler`, `BuiltinShellRecovery.restoreAfterBoot`, `DeveloperSettings`, `McpRuntime.ensureRunning`, `MikaApp.onCreate`; and in the zip `BootReceiver.kt`, `App.kt`, `AppBase.kt`, `AppLog.kt`, the `:app` manifest and the replacement `ShizukuApplication` object in `patch-upstream.py`. The fetched `shizuku/upstream/` and `mika/upstream/` folders were removed before zipping (not part of the project zip, same as before).

Result:
- The three receivers coexist. Order is not defined and nothing depends on it: no `priority`, no `abortBroadcast`, three independent jobs (open the home screen / re-arm Mika's alarms and helper / start the Shizuku server).
- Same setting, same value: Mika and the manager both write `adb_wifi_enabled = 1`, neither writes `0` at boot. Mika skips its own recovery when it runs in root / Shizuku mode, so with the built-in Shizuku only the manager acts.
- Only one foreground service starts at boot (Mika's computer-access service, `specialUse`, only if the user enabled it). The manager starts none.
- **New finding 12 (medium):** the manager's receiver is `directBootAware` + `LOCKED_BOOT_COMPLETED`. No component of `:app` or Mika was. The main process, with `App.onCreate`, can now start before the user unlocks the phone, where credential-protected storage is not available (most blocks are in `try/catch`, but the launcher could stay half-initialised). Options: (a) strip the flag and the filter in `patch-upstream.py` (recommended), (b) make `App.onCreate` locked-safe. Decision goes to 4D-4.
- **New finding 13 (high if ordered wrongly, none today):** `BootCompleteReceiver` needs `ShizukuApplication.onCreate(app)` (it reads `ShizukuSettings` preferences and `application`), and nothing in `:app` calls it yet. With the switch on and no call, the receiver would throw at every boot. The call goes early in the launcher part of `App.onCreate` (6E; place fixed in 4D-4); 8F must not flip the default before 6E.

Not verified: the generated and merged manifests (4E, first CI run); whether the boot broadcast is delivered one receiver at a time on the target Android versions; whether a main process started under direct boot survives the unlock; behaviour of two ADB clients at the same moment; which exact calls fail in `App.onCreate` while locked (code read, nothing run on a device). `patch-upstream.py` was not re-run (unchanged).

Next: 4D-4 (where `ShizukuApplication.onCreate(app)` must be called; decision on finding 12), then 4E-1 ... 4E-4c, 4F-1 ... 4F-3, 4G-1, 4G-2.

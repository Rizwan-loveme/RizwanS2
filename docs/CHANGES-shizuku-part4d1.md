# Shizuku — part 4D-1 of 10: the nine activities (docs only)

Request: 4D-1, keep all details, update the full flat zip. Based on `RizwanS2-main-shizuku-step4c.zip` (4A, 4B and 4C done there).

New: `docs/CHANGES-shizuku-part4d1.md` (this file).

Changed: `shizuku/README.md` only (plan row 4: 4D-1 done, 4D-2 next; row 4D-1 flipped to done; new section "4D-1"). No code, script, manifest, workflow or Gradle file touched; nothing built. `includeShizuku` is still off by default.

Result:
- Exactly three of the nine activities are exported, on purpose: `RequestPermissionActivity`, `ShellRequestHandlerActivity`, `LegacyIsNotSupportedActivity`. The other six are not exported (the old row said all nine; corrected).
- No LAUNCHER filter from any of them. The patch script removes all intent filters of `MainActivity` and sets `exported="false"`; `:app`'s `MainActivity` stays the only HOME activity.
- Same simple names (`MainActivity`, `SettingsActivity`) in other modules are different components (own namespaces), no clash.
- `SettingsActivity` `APPLICATION_PREFERENCES` (not exported): `:j2me` has the same pattern, `:app` has none, nothing in the project resolves that action, Mika's manifest has the tile-preferences filter (`QS_TILE_PREFERENCES`) instead. No ambiguity; nothing to change.

Not verified: the real generated Shizuku / Mika manifests (not in the zip, no network); how upstream starts `SettingsActivity`; the merged manifest of a real Gradle build (4E-4a, first CI run).

Next: 4D-2 (`AdbPairingService`, finding 6), then 4D-3, 4D-4, 4E-1 ... 4E-4c, 4F-1 ... 4F-3, 4G-1, 4G-2.

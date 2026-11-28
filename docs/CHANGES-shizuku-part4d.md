# Shizuku — part 4D of 10: activities, pairing service, boot receivers, Application (docs only)

Request: 4D-4, keep all details, update the full flat zip. Based on `RizwanS2-main-shizuku-step4d3.zip` (4A - 4C and 4D-1 ... 4D-3 done there). This file covers all of 4D (4D-1 ... 4D-4); the small `CHANGES-shizuku-part4d1.md` - `part4d3.md` stay as history.

New: `docs/CHANGES-shizuku-part4d.md` (this file).

Changed: `shizuku/README.md` only. No code, script, manifest, workflow or Gradle file touched; nothing built. `includeShizuku` is still off by default.

README edits in 4D-4:
- Plan row 4: 4D done, 4E-1 next. Plan row 5: split now 5A - 5G.
- Row 4D-4 flipped to done; new section "4D-4".
- New rows **5F** (direct-boot patch) and **5G** (night-mode patch) in the step 5 table.
- Finding 12 decided; finding 13 place fixed; finding 9 note written; **new finding 14**.
- 4E-4a: the direct-boot rule moves to row 5F (it would fail before the patch exists). 6A gets the process / task note; 6E gets the exact spot of the init call.

Result of 4D as a whole:
- **4D-1:** exactly three of the nine activities are exported on purpose; no LAUNCHER filter; `SettingsActivity`'s `APPLICATION_PREFERENCES` filter does not clash (`:j2me` has the same non-exported pattern).
- **4D-2:** `AdbPairingService` is fine on the manifest side (`shortService`, only `FOREGROUND_SERVICE`); finding 11 (no `onTimeout`) goes to row 5E.
- **4D-3:** the three boot receivers coexist, order is harmless; findings 12 and 13.
- **4D-4:** the host keeps `App`; `ShizukuApplication.onCreate(this)` goes into the launcher-process part of `App.onCreate`, in `try/catch (Throwable)`, after the `AppLog.i("process start")` line and before the Seal block (Mika stays last). Nothing of Shizuku needs the init earlier (provider and `ShizukuReceiver` do not read `ShizukuSettings` or `application`).
- **Finding 12 decided, option (a+):** strip `directBootAware` from `BootCompleteReceiver`, `ShizukuReceiver` and `ShizukuManagerProvider`, and the `LOCKED_BOOT_COMPLETED` filter; patch + self-check rule in row 5F. The owner can still reverse it before 5F is written.
- **New finding 14 (medium):** upstream's `AppCompatDelegate.setDefaultNightMode(...)` is a static of stock AppCompat, now shared with about 26 `AppCompatActivity` files of `:app`. Once the user picks Light / Dark in Shizuku's Settings, the whole host would follow. Fix: row 5G, apply the setting per activity in the base class `AppActivity`. The language setting does not leak (RikkaX `LocaleDelegate` is a plain static for the Rikka activities).
- No libsu or `HiddenApiBypass` user elsewhere in the project or in Mika: no clash for `Shell.setDefaultBuilder` or the hidden-API exemption (the latter is process-wide, accepted).

Method: GitHub was reachable; the real upstream files at the pinned commits were read (Shizuku `2650830`, Mika `7ff1703`, RikkaX `LocaleDelegate`). The fetched `shizuku/upstream/` and `mika/upstream/` folders were removed before zipping.

Not verified: whether `delegate.localNightMode` in `AppActivity` works in order with `MaterialActivity` (Rikka material 2.7.2; `LocaleDelegate` was read from the default branch, not the tag); whether the hidden-API exemption changes any host behaviour; that stripping `directBootAware` from provider and `ShizukuReceiver` loses nothing real; device behaviour on Android 14 - 17; the generated and merged manifests (4E, first CI run). `patch-upstream.py` was not re-run (unchanged).

Next: 4E-1 (checker skeleton `shizuku/tools/check-merged-manifest.py`), then 4E-2 ... 4E-4c, 4F-1 ... 4F-3, 4G-1, 4G-2; step 5 now has 5F and 5G.

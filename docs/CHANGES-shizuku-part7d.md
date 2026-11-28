# Shizuku — row 7D (`ShizukuShellUserService`)

Request: do 7D, keep all details, updated full flat zip. Based on `RizwanS2-main-shizuku-step7c.zip`.

Result: documentation only, no code changed. The bind path of Mika's user service is written as a chain of four links with what each rests on: host package in `BuildConfig.APPLICATION_ID` (guarded in the three workflows), one APK holding the class (`:mika` is a library of `:app`), no code shrinking (`isMinifyEnabled = false`), one provider, the manager's, that answers `sendUserService`, binder extra key unchanged (finding 15).

## Changed files
- `shizuku/README.md`: plan row 7, row 7D (done), step 7 note, new section "7D".
- `README.md`: state line after row 7D.
- `docs/CHANGES-shizuku-part7d.md`: this file.

## Decisions
1. No new rule (the facts are guarded already or are plain build settings).
2. No change to Mika's code or manifest.
3. If the bind fails on a device, check the package asked for and its `pm path` first, then the provider; a fix would be its own row.

## Not done
Tried: `check-all.py` S1 - S4 ok (S5 - S7 skipped), `static-check.py` passed; the facts were read in the project files. Not verified: run time, Mika's real class and the server's service starter (no network in this session), the merged manifest of a real build (S7). Steps left: 7E, 8A - 8F, 9A - 9B, 10A - 10B. Next: 7E.

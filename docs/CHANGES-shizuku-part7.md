# Shizuku — step 7 (`:mika` hook-up), all rows

Based on the rows 7A-1.1, 7A-1.2, 7A-2.1, 7A-2.2, 7B, 7C, 7D, 7E (the small files `docs/CHANGES-shizuku-part7a1-1.md` ... `part7d.md` stay as history). Static only, never built.

## Rows
| Row | Result | Code changed |
|---|---|---|
| 7A-1.1 | Mika's `<queries>` entry names the host package when `:shizuku` is in the build (env `MIKA_SHIZUKU_BUILTIN`, set by `:mika:patchMikaUpstream`); stock name otherwise; check 13 in `mika/tools/check-manifest.py` | yes |
| 7A-1.2 | `STALE_QUERY_ALLOWED = 0` in the merged-manifest checker and `EXPECTED_STALE_QUERY_ALLOWED = 0` in its self-test | yes |
| 7A-2.1 | `SHIZUKU_PACKAGE` in `ShizukuController.kt` follows the host package (patch part 16); `openShizukuApp()` opens `moe.shizuku.manager.MainActivity` | yes |
| 7A-2.2 | check 14 of `mika/tools/check-manifest.py`: read-only check of the same text pairs | yes |
| 7B | one provider: rules 7 and 8 of `check-provider-match.py` (17 self-test cases) | yes |
| 7C | one permission: Mika's 30 permissions hold no Shizuku name; `MANAGER` / `API_V23` declared once by `:shizuku`; host asks for `MANAGER`, not `API_V23`; run-time path written as a chain (read, not run) | no |
| 7D | `ShizukuShellUserService`: host package in `BuildConfig.APPLICATION_ID` (guarded in the three workflows), one APK, no code shrinking, one provider with `sendUserService`, binder key unchanged; bind path written as a chain (read, not run) | no |
| 7E | `NOTICE-Mika.md` section "Shizuku hook-up", this file, README rows and state lines | no (docs) |

## Decisions of step 7
1. Mika's own sources are changed only where the host package matters (two places, part 16); the provider is removed by an overlay on the Win11 side, not by editing Mika.
2. The checker has no allowance left for Mika's old `<queries>` name.
3. No new rule for 7C and 7D: their facts are guarded by existing rules or are plain build settings.
4. Statements that rest on reading, not on a run, are marked as such in README, NOTICE and here.

## Not done
Tried (7E): `check-all.py` S1 - S4 ok (S5 - S7 skipped), `static-check.py` passed. Not verified: run time (permission path, user-service bind), the merged manifest of a real build (S7), D8 duplicate classes. Steps left: 8A - 8F, 9A - 9B, 10A - 10B. Next: 8A.

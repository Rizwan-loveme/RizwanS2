# Shizuku — row 7C (one permission)

Request: do 7C, keep all details, updated full flat zip. Based on `RizwanS2-main-shizuku-step7b.zip`.

Result: documentation only, no code changed. Mika's `KEEP_PERMISSIONS` has 30 entries and none is a Shizuku name; `MANAGER` and `API_V23` are declared once by `:shizuku` and the host does not request `API_V23` (guard + `shizukuIgnored = manifest`), all three already guarded by the rules `4E-3 declared once`, `levels`, `manager request`, `no API_V23 request`. The run-time path with the host as manager is written as a chain of four links (Mika -> API class -> server binder -> uid decision, optional confirmation activity), each with the row it rests on.

## Changed files
- `shizuku/README.md`: plan row 7 and row 7C (done), step 7 note, new section "7C".
- `README.md`: state line after row 7C.
- `docs/CHANGES-shizuku-part7c.md`: this file.

## Decisions
1. No new rule (the facts are already guarded).
2. No permission added to Mika's list.
3. If the run-time link fails on a device, check `MANAGER_APPLICATION_ID` in the built server first; a fix would be its own row.

## Not done
Tried: `check-all.py` S1 - S4 ok (S5 - S7 skipped), `static-check.py` passed; `KEEP_PERMISSIONS` counted (30, no Shizuku name). Not verified: the run-time path (read from 4A, 5C, 5D, never run), the real sources (no network in this session), the merged manifest of a real build (S7). Steps left: 7D, 7E, 8A - 8F, 9A - 9B, 10A - 10B. Next: 7D.

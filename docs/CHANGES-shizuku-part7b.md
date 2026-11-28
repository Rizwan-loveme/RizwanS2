# Shizuku — row 7B (one provider)

Request: do 7B, keep all details, updated full flat zip. Based on `RizwanS2-main-shizuku-step7a2-2.zip`.

Result: confirmed on the real fetched + patched Shizuku v13.6.0 and Mika 0.1.52 sources: Mika's Kotlin never names `ShizukuProvider`; the manager's provider has every attribute of Mika's (`enabled`, `exported`, `multiprocess`, `permission`, authority) and extends the class; the Maven artifact `dev.rikka.shizuku:provider` is substituted by `:shizuku-provider` (one copy); no ProGuard rule involved (`isMinifyEnabled = false`).

## Changed code
- `shizuku/tools/check-provider-match.py`: rule 7 (no attribute lost), rule 8 (substitution of the provider artifact, code only), optional argument `root_gradle`, 5 new self-test cases (17 in all), docstring and success line.
- `shizuku/tools/check-all.py`: header text of S4.
- `shizuku/README.md` (plan rows, step 7 note, S4 tables, new section "7B"), `README.md` (state line).

## Decisions
1. Manager's attributes must be a superset of Mika's (same values).
2. Rule 8 reads code only and is skipped without the root build file.
3. No new rule for "only needs the class": rule 5 is stronger.
4. `check-merged-manifest.py` unchanged (its rules already cover the merged result).

## Not done
Tried: `check-provider-match.py` ok on real sources, self-test 17 of 17, `check-all.py` S1 - S6 ok / S7 skipped, `static-check.py` passed. Not verified: the merged manifest of a real build (S7), D8 duplicate classes, run time. Steps left: 7C - 7E, 8A - 8F, 9A - 9B, 10A - 10B. Next: 7C.

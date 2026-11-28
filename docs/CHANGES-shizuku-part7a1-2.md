# Shizuku — row 7A-1.2 (`<queries>` entry, the checker)

Request: do 7A-1.2, keep all details, updated full flat zip. Based on `RizwanS2-main-shizuku-step7a1-1.zip`.

Result: the rule `4E-4b stale package` of `shizuku/tools/check-merged-manifest.py` allows no `<queries><package android:name="moe.shizuku.privileged.api"/>` entry any more (`STALE_QUERY_ALLOWED = 0`). With the manager built in, 7A-1.1 already writes the host package there, so a correct merged manifest has no such string.

## Changed code
- `shizuku/tools/check-merged-manifest.py`: `STALE_QUERY_ALLOWED` 1 -> 0; rule registry text, docstring, the "at most %d allowed" error and the note text reworded (they said "until row 7A-1").
- `shizuku/tools/test-check-merged-manifest.py`: `EXPECTED_STALE_QUERY_ALLOWED` 1 -> 0 in the same step; notes asserted by cases `4b-02`, `4b-23`, `x-04` follow the new note text; comments and the guard's message updated.
- `shizuku/README.md` (plan rows 7, 7A-1.2 done, 7A-2 text, finding 7, 4E-4b / 4E-4c texts, new section "7A-1.2"), `README.md` (state line).

## Decisions
1. Checker and self-test constant change in one step (else the constants guard fails on purpose).
2. The switch stays a constant; cases that test the "one allowed entry" path still set it to 1 with `patch=`. Same 147 cases.
3. Texts follow the state (the "still there" note cannot print at 0).
4. The rule still runs only with the manager built in; a build without `:shizuku` is not checked.

## Not done
Not run against a real merged manifest (S7 needs a Gradle build), no device. Tried: self-test 147 cases 0 failed, coverage of 19 rules; `check-all.py` 4 ok / 3 skipped (S5 - S7); `mika/tools/static-check.py` passed. Steps left: 7A-2, 7B - 7E, 8A - 8F, 9A - 9B, 10A - 10B. Next: 7A-2.

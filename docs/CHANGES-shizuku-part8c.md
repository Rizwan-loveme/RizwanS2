# Shizuku — row 8C (`UltimateBuild_WithoutMe.yml`)

Request: do 8C, keep all details, updated full flat zip. Based on `RizwanS2-main-shizuku-step8b.zip`.

Result: `.github/workflows/UltimateBuild_WithoutMe.yml` got the two steps of 8A / 8B after the Mika step and the Shizuku header paragraph (46 lines added, none removed). Differences from the other two files: the steps have no `if` (Shizuku is not a tick box), and the provider check runs only when `mika/upstream` exists (with the Mika tick box off `mika/` is deleted and the check would fail the build with exit 2). One sentence in the header comment and one in the step comment say so.

## Changed files
`.github/workflows/UltimateBuild_WithoutMe.yml`, `shizuku/README.md` (plan rows 8 and 8C, step 8 note, new section "8C"), `README.md` (state line), `docs/CHANGES-shizuku-part8c.md` (new).

## Decisions
1. Condition = the folder exists, not a copy of the input.
2. No tick box for Shizuku here.
3. Decisions of 8A apply.

## Not done
Tried: YAML parses, step order read back, no `if` on the new steps, `bash -n` on the new run block, diff vs 8B zip (46 added, 0 removed), `check-all.py` S1 - S4 ok, `static-check.py` passed. Not verified: any GitHub run, a run with the Mika tick box off. Steps left: 8D-1, 8D-2, 8E, 8F, 9A - 9B, 10A - 10B. Next: 8D-1.

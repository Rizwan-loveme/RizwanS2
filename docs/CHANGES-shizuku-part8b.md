# Shizuku — row 8B (`UltimateBuild_NoWinlator.yml`)

Request: do 8B, keep all details, updated full flat zip. Based on `RizwanS2-main-shizuku-step8a.zip`.

Result: `.github/workflows/UltimateBuild_NoWinlator.yml` got the same two steps as 8A (`Cache Shizuku source`, `Fetch and patch Shizuku source`, after the Mika step) and the same header paragraph, copied from the 8A file by a script (41 lines added, none removed). The Winlator removal step does not touch `applicationId`, so the guard works unchanged.

## Changed files
`.github/workflows/UltimateBuild_NoWinlator.yml`, `shizuku/README.md` (plan rows 8 and 8B, step 8 note, new section "8B"), `README.md` (state line), `docs/CHANGES-shizuku-part8b.md` (new).

## Decisions
1. Same text and decisions as 8A.
2. A shared cache key between the workflow files is intended (the patch marker handles a different package).

## Not done
Tried: YAML parses, step order read back, diff vs 8A zip (41 added, 0 removed), `check-all.py` S1 - S4 ok, `static-check.py` passed. Not verified: any GitHub run, branch scope of the cache. Steps left: 8C - 8F, 9A - 9B, 10A - 10B. Next: 8C.

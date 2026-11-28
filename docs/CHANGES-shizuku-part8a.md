# Shizuku — row 8A (`UltimateBuild.yml`: fetch + patch + cache)

Request: do 8A, keep all details, updated full flat zip. Based on `RizwanS2-main-shizuku-step7e.zip`.

Result: `.github/workflows/UltimateBuild.yml` got two steps after "Fetch and patch Mika source" (41 lines added, none removed) and a paragraph in its header comment: `Cache Shizuku source` (path `shizuku/upstream`, key from `UPSTREAM_VERSION`, `UPSTREAM_COMMIT`, `UPSTREAM_API_COMMIT` and the three scripts) and `Fetch and patch Shizuku source` (guard that `applicationId` is `$NEW_PKG`, fetch, patch, `patch-upstream.py --check`, `check-provider-match.py`, version line). They run in every build; the module stays off (8F).

## Changed files
`.github/workflows/UltimateBuild.yml`, `shizuku/README.md` (plan rows 8 and 8A, step 8 note, new section "8A"), `README.md` (state line), `docs/CHANGES-shizuku-part8a.md` (new).

## Decisions
1. Runs with the module off too (S5 / S6 become real on every run; fills the cache).
2. The host package is read from the file, not passed as an override; a guard catches a rename that did not reach it.
3. The cache key is written here; 8E reviews it.
4. No APK check and no flag here (8D, 8F).

## Not done
Tried: YAML parses, step order read back, guard command run with a right and a wrong package, `check-all.py` S1 - S4 ok, `static-check.py` passed. Not verified: any GitHub run (clone, cache size, cache restores `.git`, S5 / S6 on the real sources in this workflow). Steps left: 8B - 8F, 9A - 9B, 10A - 10B. Next: 8B.

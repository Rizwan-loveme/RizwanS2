# Shizuku — row 8E (cache key review, docs only)

Request: do 8E, keep all details, updated full flat zip. Based on `RizwanS2-main-shizuku-step8d2.zip`.

Result: the key of `Cache Shizuku source` (version + both pin commits + `fetch-upstream.sh`, `patch-upstream.sh`, `patch-upstream.py`; path `shizuku/upstream`) already does what the row asks and is the same in all three workflows. Nothing in the build changed.

## Changed files
`shizuku/README.md` (plan rows 8 and 8E, new section "8E"), `README.md` (state line), `docs/CHANGES-shizuku-part8e.md` (new).

## Decisions
1. Pin change refetches (key, plus the HEAD checks of `fetch-upstream.sh` and `patch-upstream.py` as a second line).
2. Host package stays out of the key: the patch marker + `reset_pristine` repatch from the cached `.git`.
3. The package rename cannot change the key (it edits only source / build / properties extensions, not `.sh`, `.py` or the pin files).
4. No `runner.os` (all jobs `ubuntu-latest`, source-only cache), no `restore-keys`.

## Not done
Tried: the three cache steps identical (`diff`); `reset_pristine()` on a hand-made checkout with a nested `api/` repo (restores modified, deletes added file and marker, keeps `api/.git`). Not verified: any GitHub run, branch scope, real re-patch on the v13.6.0 checkout. Steps left: 8F, 9A - 9B, 10A - 10B. Next: 8F.

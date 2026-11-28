# Shizuku — row 9B (CHANGES for steps 5 - 8)

Request: do 9B, keep all details, updated full flat zip. Based on `RizwanS2-main-shizuku-step9a.zip`.

Result: new `docs/CHANGES-shizuku-part9.md` puts steps 5 - 8 in one file: a table per step (29 rows, with "code changed"), the changes by area, the numbers of every checker measured again, findings 9 - 16 and how each ended, decisions that matter later, and what is not done. Documents only: no code, script, workflow, Gradle file or manifest changed.

## Changed files
`docs/CHANGES-shizuku-part9.md` (new), `docs/CHANGES-shizuku-part9b.md` (new, this file), `shizuku/README.md` (plan rows 9 and 9B, new section "9B"), `README.md` (state line).

## Decisions
1. The small per-row files stay as history (as in step 7).
2. Numbers in the combined file are the ones measured in 9B; earlier rows keep theirs.
3. Written before any GitHub build (owner's request; the 9A advice was to build first). The first run's result still has to be added to "First CI run" and to the combined file.

## Not done
Tried: `test-patch-host-package.py` 224 of 224, `check-gradle.py --self-test` 70 of 70 and `check-gradle.py` ok, `test-check-merged-manifest.py --no-real` 147 cases / 19 rules, `sweep-package-strings.py --self-test` 37, `check-apk-contents.py --self-test` 33, `check-provider-match.py --self-test` 17, `check-all.py --self-test` 64 checks and `--no-real` S1 - S4 ok, `static-check.py` passed. Not verified: everything that needs a build or a device; `static-check.py` reads no `.md`, so the new texts were re-read by hand. Steps left: 10A, 10B. Next: 10A (best after one GitHub build).

# Shizuku — row 10A (static checks)

Request: do 10A, keep all details, updated full flat zip. Based on `RizwanS2-main-shizuku-step9b.zip`.

Result: every checker of the project was run, also on the real fetched Shizuku v13.6.0 and Mika 0.1.52 sources; nothing failed. Decision of the row: `test-patch-host-package.py` (S8), the sweep self-test (S9), the APK-check self-test (S10) and the real sweep (S11, new kind `sweep`) now run inside `shizuku/tools/check-all.py`. The self-test of `check-all.py` grew from 64 to 84 checks.

## Changed files
`shizuku/tools/check-all.py` (steps S8 - S11, docstring, help text, self-test), comments only in `shizuku/tools/check-apk-contents.py`, `shizuku/tools/sweep-package-strings.py`, `shizuku/tools/test-patch-host-package.py`, `mika/tools/static-check.py` (check 11 comment), `shizuku/README.md` (plan rows 10 and 10A, live-checks table, new section "10A"), `README.md` (state line), `docs/CHANGES-shizuku-part10a.md` (new). No workflow, Gradle file, manifest, Kotlin file or patch script changed.

## Decisions
1. The three offline tools join `check-all.py` (cheap, already green, guard the patch script). The real sweep joins as S11, skipped without a patched checkout.
2. No workflow calls the sweep.
3. Ids S1 - S7 unchanged; a bare checkout now reports `7 ran ok, 4 skipped (S5, S6, S7, S11)`.
4. Earlier README sections keep the numbers and "not wired" wording they had when written; section "10A" and the live table are current.
5. R8 note (keep rules for `MainActivity` and `ShizukuApplication.onCreate` if minify is ever on) written in "10A".

## Not done
Tried: all commands of the table in "10A" (hand-made and real sources; the workflow's Shizuku step run as written, forced second patch pass ok; a mutation of S11 broke exactly one new self-test check). Not verified: any build, merged manifest (S7), real APK, device. Still no GitHub build. Steps left: 10B. Next: 10B.

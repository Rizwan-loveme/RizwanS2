# Shizuku — row 5A (source sweep for the package strings)

Request: 5A, keep all details, update the full flat zip. Based on `RizwanS2-main-shizuku-step5b1.zip` (row 5B-1 done there).

New:
- `shizuku/tools/sweep-package-strings.py` — reads the PATCHED checkout `shizuku/upstream/` and reports every `moe.shizuku.privileged.api` (allowed only in `manager/build.gradle`), checks that the host package is written in exactly the 11 places of 9 files that patch part A produces, and sorts every `moe.shizuku.manager` use into namespace / class-name / permission / review (`--strict` fails on review items, `-v`, `--report FILE`). `--self-test`: 30 cases. Exit 0 / 1 / 2. Not wired into `check-all.py` or a workflow (row 10A decides).
- `docs/CHANGES-shizuku-part5a.md` (this file).

Docs: `shizuku/README.md` (plan row 5, row 5A done with details, new section "5A": what could not be done and why, the tool, what stays on purpose, what must be the host package, finding 10 verified, what was run; note in row 10A; two sentences of the 5B-1 section brought up to date), `README.md` (plan row 5).

Found while reading the patch script: finding 10 named one file (`HomeViewModel.kt`); the patch replaces `BuildConfig.APPLICATION_ID` in two (`HomeViewModel.kt` and `AuthorizationManager.kt`). Both are counted by the sweep; nothing to change.

Not done: the grep on the real patched source (no network, `shizuku/upstream/` is not in the zip). The "stays on purpose" list is taken from what the README recorded from real runs in earlier rows; the sweep confirms or corrects it on the first CI run. No existing script, manifest, Gradle file, workflow or source file changed; `includeShizuku` is still off by default; nothing built.

Run: the 30 self-test cases, `check-all.py` (S1 - S4 ok, S5 - S7 skipped), `mika/tools/static-check.py`, `check-gradle.py`.

Flat zip: `RizwanS2-main-shizuku-step5a.zip`. Next: 5B-2 (native libraries), then 5C - 5G.

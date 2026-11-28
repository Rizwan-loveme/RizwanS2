# Shizuku — row 9A (final documents)

Request: do 9A, keep all details, updated full flat zip. Based on `RizwanS2-main-shizuku-step8f.zip`. Documentation only: no code, script, workflow, Gradle file or manifest changed.

Result: `NOTICE-Shizuku.md` brought to the real state (in every build since 8F, never built; steps 3 - 8 listed; permissions section and library table updated); licences checked on the web where possible; one error found and fixed (**RikkaX is MIT, Copyright (c) 2017 Rikka, not Apache-2.0**); `shizuku/README.md` got section "9A" with the first-CI-run list for steps 3 - 8 in one place (12 log points, expected result, likely cause) and the consolidated list of what is unproven.

## Changed files
`NOTICE-Shizuku.md`, `NOTICE-Mika.md` (one sentence: the switch is on by default), `shizuku/README.md` (plan rows 9 and 9A, pointer in "First CI run", section "9A"), `README.md` (state line), `docs/CHANGES-shizuku-part9a.md` (new).

## Decisions
1. Licence entries are marked "confirmed" (read in 9A) or "as before" (not re-read); nothing was upgraded without reading it.
2. Not confirmed and said so: `org.lsposed.libcxx:libcxx` (page not fetched; sibling artifact says Apache v2.0), `dev.rikka.hidden:compat`, BoringSSL 20250114 (newest version's POM says OpenSSL + ISC).
3. The missing licence texts in the APK are written down as an open item, not fixed: it needs a build, and it is a project-wide question (only Mika ships licence files). Not legal advice.
4. 9B and 10 should come after one GitHub build, so that they record what happened.

## Not done
Tried: `check-all.py` S1 - S4 ok, `static-check.py` passed (it reads no `.md`, so the notice edits were re-read by hand: table rows have 6 columns, the old "to confirm in step 9" phrases are gone). Not verified: the unconfirmed licence entries, every point of the unproven list. Steps left: 9B, 10A - 10B. Next: 9B (best after one GitHub build).

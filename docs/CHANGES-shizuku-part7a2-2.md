# Shizuku — row 7A-2.2 (`SHIZUKU_PACKAGE`, the read-only check)

Request: do 7A-2.2, keep all details, updated full flat zip. Based on `RizwanS2-main-shizuku-step7a2-1.zip`.

Result: `mika/tools/check-manifest.py` check 14 reads `ShizukuController.kt` of the patched checkout and requires one consistent spelling (switch 1 built-in, 0 stock, unset either; never a mixture; with 1 no `moe.shizuku.privileged.api` / `SHIZUKU_PACKAGE` left). Finding 7 (stale package) is closed: manifest side 7A-1, Kotlin side 7A-2.

## Changed code
- `mika/tools/check-manifest.py`: check 14 + docstring item 14 (constants shared with `patch-upstream.py` part 16).
- `shizuku/README.md` (plan rows, finding 7, step 7 notes, new section "7A-2.2"), `mika/README.md` (row 16 note), `README.md` (state line).

## Decisions
1. Constants shared, logic separate (no `exit` through the patch script's `err()`).
2. A mixture is an error in every state.
3. Missing file: error, no traceback.
4. Read-only (tested).
5. `static-check.py`, `check-gradle.py`, `check-all.py` unchanged.

## Not done
Tried on the real Mika 0.1.52: 18 cases ok; `check-all.py` 4 ok / 3 skipped; `static-check.py` passed. No Kotlin compile, no device. In CI the workflows run `check-manifest.py` without `MIKA_SHIZUKU_BUILTIN`, so check 14 accepts either spelling there (rows 8A - 8C). Steps left: 7B - 7E, 8A - 8F, 9A - 9B, 10A - 10B. Next: 7B.

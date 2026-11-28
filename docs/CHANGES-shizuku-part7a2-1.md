# Shizuku — row 7A-2.1 (`SHIZUKU_PACKAGE`, Mika's patch script)

Request: 7A-2 split into 7A-2.1 / 7A-2.2, do 7A-2.1, keep all details, updated full flat zip. Based on `RizwanS2-main-shizuku-step7a1-2.zip`.

Result: with `:shizuku` in the build (`MIKA_SHIZUKU_BUILTIN=1`) Mika's `ShizukuController.kt` asks the package manager for `app.packageName` (2 calls) and `openShizukuApp()` starts `moe.shizuku.manager.MainActivity` in the host package. The const `SHIZUKU_PACKAGE` (`moe.shizuku.privileged.api`) becomes `SHIZUKU_MANAGER_ACTIVITY`. Without the manager the stock text is written back.

## Changed code
- `mika/tools/patch-upstream.py`: part 16 (`patch_shizuku_package`, `check_shizuku_package`, result key, header item 16).
- `mika/tools/patch-upstream.sh`: header comment.
- `shizuku/README.md` (plan rows 7 / 7A-2.1 / 7A-2.2, finding 7, step 7 notes, new section "7A-2.1"), `mika/README.md` (row 16), `README.md` (state line).

## Decisions
1. Run-time value (`app.packageName`), so the package rename cannot leave a stale name.
2. `openShizukuApp()` starts the manager's start screen by class name; the host's launch intent would open the Win11 launcher.
3. The constant is replaced, not kept (no other user in `app` / `core`).
4. Two-way, strict anchors, same switch and stamp as 7A-1.1.
5. Own self-check in the script.
6. Mika UI strings unchanged.

## Not done
Tried on the real Mika 0.1.52: 22 cases ok, roundtrip byte-identical to upstream; `check-manifest.py`, `static-check.py`, `check-all.py` ok. No Kotlin compile, no device. Steps left: 7A-2.2, 7B - 7E, 8A - 8F, 9A - 9B, 10A - 10B. Next: 7A-2.2.

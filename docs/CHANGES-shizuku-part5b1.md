# Shizuku — row 5B-1 (`pm path` and the host package)

Request: 5B-1, keep all details, update the full flat zip. Based on `RizwanS2-main-shizuku-step4.zip` (step 4 complete there; the pasted summary of the request was older and said "next 4B-1", the zip was followed). 5A (source sweep) was not done first; the owner asked for 5B-1 directly.

New:
- `shizuku/tools/test-patch-host-package.py` — 32 hand-made cases for the three new rules below (no network, no fetched source; it copies the patch script into a temp folder). Run by hand: `python3 -I shizuku/tools/test-patch-host-package.py`. Not wired into `check-all.py` (row 10A decides about new tools).
- `docs/CHANGES-shizuku-part5b1.md` (this file).

Changed (`shizuku/tools/patch-upstream.py`; what the patch writes into the Shizuku sources is **unchanged**):
1. `check_host_name()`: the host package must be a plain Android package name; it is written unquoted into `pm path <package>` and into string literals. Applied to the value of `applicationId`, to `--host-package` and to `SHIZUKU_HOST_PACKAGE`.
2. `host_package()` stops if `app/build.gradle.kts` has an uncommented `applicationIdSuffix` (a suffix would install the app under another name than the one in `starter.cpp`). `app/build.gradle.kts` has none today.
3. `check_native_package()` in the self-check: exactly one `#define PACKAGE_NAME "<host>"` in `manager/src/main/jni/starter.cpp`, the old name nowhere in that file. The success line of the self-check names it. Header comment of the script updated.

Docs: `shizuku/README.md` (plan row 5 in progress, row 5B-1 done with details, new section "5B-1", note in row 8A: fetch + patch after the package rename, section title of steps 5 - 8), `README.md` (plan row 5, new state paragraph), `NOTICE-Shizuku.md` (status line).

Run: the 32 cases (one failed first: a name ending in a newline passed `re.match` with `$`, now `fullmatch`); `shizuku/tools/check-all.py` (S1 - S4 ok, S5 - S7 skipped, exit 0); `mika/tools/static-check.py` (all checks passed); `patch-upstream.py --check` on an empty folder (exit 1, own message).

Not run / not read: the real `starter.cpp` and server sources (no network), the patch script on the real v13.6.0 source, any Gradle build, any device. Whether the server also runs `pm path` is not recorded; rows 5C / 5D look at the server's use of the name. No workflow, manifest, Gradle file, Kotlin / Java file or resource touched; `includeShizuku` is still off by default.

Flat zip: `RizwanS2-main-shizuku-step5b1.zip` (files at the zip root). Next: 5B-2 (native libraries), then 5C - 5G; 5A is still open.

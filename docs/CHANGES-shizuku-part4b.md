# Shizuku — part 4B of 10 (4B-1 ... 4B-4): the provider clash with :mika is solved

Request: 4B-4, keep all details, update the full flat zip. Based on `RizwanS2-main-shizuku-step4b3.zip` (4A, 4B-1, 4B-2, 4B-3 already done there; their own notes stay as `CHANGES-shizuku-part4a.md`, `part4a2`, `part4b1`, `part4b2`, `part4b3`).

## What step 4B did, in one place
- **Problem (4A finding 1):** `:mika` and the built-in `:shizuku` manager both declare a provider with the authority `${applicationId}.shizuku` = `INSTALL_FAILED_CONFLICTING_PROVIDER` with both in one APK.
- **Decision (4B-1):** a build-type manifest overlay, wired only when `:shizuku` is in the build (rejected: patching Mika's generated manifest, an unconditional marker in `src/main`, a task editing the merged manifest (kept as fallback), a product flavor).
- **Applied (4B-2):** new `app/src/shizuku/AndroidManifest.xml` (`<provider android:name="rikka.shizuku.ShizukuProvider" ... tools:node="remove" />`, no `package`), wired in `app/build.gradle.kts` for `debug` and `release` inside `if (shizukuIncluded)`.
- **Checked (4B-3):** `shizuku/tools/check-provider-match.py` (6 rules, `--self-test` 12 cases); `mika/tools/check-merged-manifest.py` rule 2 accepts the removed provider only when `moe.shizuku.manager.ShizukuManagerProvider` replaces it with an authority ending in `.shizuku` (5 providers counted).
- **Notes (4B-4, this part):** comments only.

## This part (4B-4)
New: `docs/CHANGES-shizuku-part4b.md` (this file).

Changed (comments / docs only):
- `app/build.gradle.kts` — the comment above `implementation(project(":shizuku"))` no longer says an APK with both modules "cannot be installed yet"; it describes the overlay and what is still open (4C - 4E, step 6, switch off until 8F).
- `app/src/main/AndroidManifest.xml` — Mika block: "6 providers" now notes that with `:shizuku` built in the overlay removes Mika's Shizuku provider (5 in the merged manifest).
- `shizuku/README.md` — plan row (4B done, 4C-1 next), row 4B-4 done, finding 1 marked resolved, new section "4B-4".

Not touched: any code, manifest element, script, workflow, Mika file. `includeShizuku` is still off by default; the default build is unchanged.

Checked: manifest XML well-formed; `check-gradle.py` ok (15 `.kts`, 11 namespaces); `check-provider-match.py --self-test` 12 of 12; rule-6 strings grepped (0 `ShizukuProvider` in `src/main`, both `srcFile` lines inside the guard).

Not verified: any Gradle run or real merged manifest of a Shizuku-on build; the real-file mode of `check-provider-match.py` this time (the fetched `upstream/` folders are not in the zip). The four points of 4B-2 are repeated in README "4B-4".

Next: 4C-1 (`patch-upstream.py`: stop removing `DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION`, finding 2), then 4C-2 ... 4C-4, 4D, 4E-1 ... 4E-4, 4F, 4G.

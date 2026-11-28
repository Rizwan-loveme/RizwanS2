# Shizuku — part 4B-2 of 10: Mika's provider is removed when :shizuku is in the build

Request: 4B2, keep all details, update the full flat zip. Based on `RizwanS2-main-shizuku-step4b1.zip` (4A and 4B-1 already done there).

New: `app/src/shizuku/AndroidManifest.xml` — build-type overlay with `<provider android:name="rikka.shizuku.ShizukuProvider" android:authority="${applicationId}.shizuku" tools:node="remove" />` (finding 1 of the 4A inventory).

Changed:
- `app/build.gradle.kts` — inside `android { }`, after `buildTypes`: `if (shizukuIncluded) { sourceSets.getByName("debug")... / ("release").manifest.srcFile("src/shizuku/AndroidManifest.xml") }`.
- `shizuku/README.md` — plan row (4B-2 done, 4B-3 next), row 4B-2 flipped to done, new section "4B-2".
- `docs/CHANGES-shizuku-part4b2.md` — this file.

Not touched: scripts, workflows, Mika files, `app/src/main/AndroidManifest.xml`. `includeShizuku` stays off by default; with it off the overlay is not wired and the build is unchanged.

Checked: overlay is well-formed XML; `shizuku/tools/check-gradle.py` ok (15 `.kts` files, 11 unique namespaces). Not checked: any Gradle run (no network); the four unverified points of 4B-1 are repeated in README "4B-2".

Known until 4B-3: `mika/tools/check-merged-manifest.py` rule 2 would flag the removed provider on a Shizuku-on build (no workflow builds that yet).

Next: 4B-3 (match-check script + teach the Mika checker), then 4B-4 (comments, `CHANGES-shizuku-part4b.md`, zip `RizwanS2-main-shizuku-step4b.zip`).

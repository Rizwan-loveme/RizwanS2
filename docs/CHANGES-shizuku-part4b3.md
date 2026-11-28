# Shizuku — part 4B-3 of 10: match check + Mika checker accepts the removed provider

Request: 4B3, keep all details, update the full flat zip. Based on `RizwanS2-main-shizuku-step4b2.zip`.

New:
- `shizuku/tools/check-provider-match.py` — reads the REAL fetched + patched Mika and manager manifests, the 4B-2 overlay, `app/build.gradle.kts` and `app/src/main/AndroidManifest.xml`; 6 rules (marker name = Mika's provider name, one match, manager provider keeps the authority and extends the class, Mika's sources never use `ShizukuProvider`, switch-off wiring only inside `if (shizukuIncluded)` for debug + release, `src/main` untouched). `--self-test`: 12 cases.
- `docs/CHANGES-shizuku-part4b3.md` — this file.

Changed:
- `mika/tools/check-merged-manifest.py` — rule 2 accepts a missing `rikka.shizuku.ShizukuProvider` only when `moe.shizuku.manager.ShizukuManagerProvider` is a provider of the merged manifest with an authority ending in `.shizuku`; docstring and summary line updated. Everything else unchanged.
- `shizuku/README.md` — plan row (4B-3 done, 4B-4 next), row 4B-3 flipped, new section "4B-3".

Results: Shizuku fetch + patch on the real source (v13.6.0, same counts as before: 9 places / 7 files, 237 names, 42 languages) and Mika fetch + patch (0.1.52): `check-provider-match.py` ok on the real files, self-test 12 of 12; Mika checker tested on 5 merged manifests made from the real Mika manifest (untouched ok, replaced ok, no manager error, wrong authority error, both providers error). Confirmed on the real files: both providers carry `${applicationId}.shizuku`; no Mika source mentions `ShizukuProvider`.

Not touched: workflows, `app/` files (comments are 4B-4), Mika's patch scripts. `includeShizuku` stays off by default. The fetched `upstream/` folders are not in the zip.

Not verified: any Gradle run / real merged manifest of a Shizuku-on build (4E + first CI run).

Next: 4B-4 (comments in `app/build.gradle.kts` and `app/src/main/AndroidManifest.xml`, README finding 1 resolved, `docs/CHANGES-shizuku-part4b.md`, zip `RizwanS2-main-shizuku-step4b.zip`).

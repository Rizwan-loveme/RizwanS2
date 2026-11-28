# :shizuku — part 4C-4b (docs only)

Finding 5, second half: the two `<uses-feature>` that `:shizuku` brings (`android.hardware.touchscreen`, `android.software.leanback`, both `required="false"`).

Result, read on all 17 manifests in the project zip: `:app` declares no `<uses-feature>` of its own, so nothing is overridden; both features are already declared with `required="false"` by `:mame`, `:ppsspp`, `:retroarch`, `:tui` (touchscreen) and `:ppsspp`, `:retroarch` (leanback), so the `:shizuku` lines merge as identical duplicates and are not new to the app. `required="false"` cannot hide the app from any device (it only removes a store filter; without it a touchscreen would be treated as required). No `required="true"` exists on these names; the only `required="true"` feature in the project is `glEsVersion` in `:winlator`. Side note (pre-existing, not Shizuku): `:Bcore` declares `android.hardware.camera` without `required`.

Changed: `shizuku/README.md` only (plan row 4 status, row 4C-4b done, finding 5 gets a "checked in 4C-4b" addendum, new section "4C-4b"). No code, script, manifest, workflow or Gradle file touched; nothing built. `includeShizuku` is still off by default.

Not verified: the merged manifest of a real Gradle build (4E / first CI run).

Next: 4C-4c (notes + `docs/CHANGES-shizuku-part4c.md` + zip `RizwanS2-main-shizuku-step4c.zip`).

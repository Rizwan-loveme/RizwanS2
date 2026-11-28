# Shizuku — part 4B-1 of 10: guard mechanism for the provider removal (decision only)

Request: 4B1, keep all details, update the full flat zip. Based on `RizwanS2-main-shizuku-step4a-split.zip`.

Changed: `shizuku/README.md` only (plan row, 4B rows, 4A correction, new section "4B-1 — guard mechanism (decision)"). No code, manifest, script or workflow was touched; `includeShizuku` stays off by default.

Decision: a build-type overlay manifest `app/src/shizuku/AndroidManifest.xml` with `tools:node="remove"` for `rikka.shizuku.ShizukuProvider`, wired for `debug` and `release` only when `shizukuIncluded`. Fallback: edit `MERGED_MANIFEST`. Rejected: patching Mika's cached manifest, an unconditional marker, product flavors.

Found while reading: `mika/tools/check-merged-manifest.py` rule 2 would fail after the intentional removal (fix placed in 4B-3); the merger keys providers by `android:name`, so the marker needs no matching authority (4A wording corrected); the Mika comment in the `:app` manifest says 6 providers (5 with Shizuku built in, fixed in 4B-4).

Next: 4B-2.

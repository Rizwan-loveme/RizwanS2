# Shizuku — part 4C (all rows 4C-1 ... 4C-4c): permissions and features

Request: 4C-4c, keep all details, update the full flat zip. Based on `RizwanS2-main-shizuku-step4c4b.zip`. This file sums up the whole of 4C; the small files `CHANGES-shizuku-part4c1.md`, `part4c2`, `part4c3`, `part4c4a`, `part4c4b` stay as history.

New: `docs/CHANGES-shizuku-part4c.md` (this file).

What 4C did (findings 2 - 5 of the 4A inventory):
- 4C-1 (finding 2): `shizuku/tools/patch-upstream.py` deletes the `<permission>` and `<uses-permission>` of `${applicationId}.DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION` from the generated manager manifest. In a library the upstream `tools:node="remove"` would remove it from the whole app and crash AndroidX `registerReceiver(..., RECEIVER_NOT_EXPORTED)` on Android 8 - 12.
- 4C-2: matching self-check rule in the patch script (the permission must not carry a remove marker); 10 of 10 hand-made cases as expected; counts unchanged (9 host-package places in 7 files, 237 resource names, 42 languages).
- 4C-3 (findings 3, 4): `MANAGER` (signature) and `API_V23` (dangerous) are declared once, by `:shizuku`; the manager keeps `uses-permission API_V23 tools:node="remove"` as a guard; the host still asks for `MANAGER`. Second self-check rule (15 of 15 cases as expected) and one comment in `app/src/main/AndroidManifest.xml`, no element or attribute.
- 4C-4a (finding 5, first half): `RECEIVE_BOOT_COMPLETED`, `FOREGROUND_SERVICE`, `POST_NOTIFICATIONS`, `INTERNET`, `WRITE_SECURE_SETTINGS` are identical in `:app`, Mika and `:shizuku`; they merge to one each.
- 4C-4b (finding 5, second half): `touchscreen` and `leanback` (`required="false"`) are already declared by `:mame`, `:ppsspp`, `:retroarch`, `:tui`; `:app` declares no `uses-feature`; `required="false"` cannot hide the app from any device; no conflicting `required="true"`.
- 4C-4c: README plan row (4C done, 4D-1 next), row 4C-4c done, finding 5 marked checked, new section "4C-4c", this file.

Changed in this part (4C-4c): `shizuku/README.md` and this file only. No code, script, manifest, workflow or Gradle file touched; nothing built. `includeShizuku` is still off by default.

Not verified: the rerun of fetch + patch + `--check` on the real source (no network in the 4C-2 / 4C-3 sessions) and the merged manifest of a real Gradle build (4E-3, first CI run).

Next: 4D-1 (activities), then 4D-2 ... 4D-4, 4E-1 ... 4E-4c, 4F-1 ... 4F-3, 4G-1, 4G-2.

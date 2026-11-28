# Shizuku, step 4A — inventory of the manifests

Documentation only. Changed: `shizuku/README.md` (plan row 4 "in progress", row 4A done, new section "4A — Inventory of the manifests"), this file. No build file, script, Kotlin / Java / resource / manifest / workflow file is touched.

Read for real (GitHub reachable; Maven / Google still not, so no Gradle run): Shizuku v13.6.0 + API 510fc98 fetched and patched (self-check ok), Mika 0.1.52 (7ff1703) fetched and patched, then the patched `:shizuku` manifest, the 11 other Shizuku manifests, Mika's library manifest and `app/src/main/AndroidManifest.xml`.

## Findings (details and verdicts: `shizuku/README.md` "4A")

1. Blocker: provider authority `${applicationId}.shizuku` is used by Mika's `rikka.shizuku.ShizukuProvider` and the manager's `ShizukuManagerProvider` -> 4B.
2. High: the manager manifest removes `${applicationId}.DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION` with `tools:node="remove"`. In a library that removes it for the whole app (AndroidX `ContextCompat.registerReceiver` with `RECEIVER_NOT_EXPORTED` fails on Android 8 - 12) -> 4C changes `patch-upstream.py`.
3. `:shizuku-provider` ignores Shizuku-API's manifest, so `uses-permission API_V23` and `V3_SUPPORT` are no longer merged; right for the manager host; keep the `remove` guard -> 4C / 4E.
4. Permission owners: `MANAGER` + `API_V23` declared only by `:shizuku`; the rest of the permissions are identical duplicates that merge to one.
5. `shortService` needs no extra permission; three receivers on `BOOT_COMPLETED` (app, Mika, manager) all run -> 4D.
6. Mika's `<queries><package moe.shizuku.privileged.api>` + `ShizukuController.SHIZUKU_PACKAGE` are stale -> step 7 (and a rule in the 4E checker).
7. Names do not clash: three `MainActivity`, but in three namespaces.

## Not verified

The merged manifest itself (needs AGP): 4E's checker and the first CI run confirm it. Finding 2 is derived from AndroidX source behaviour and the manifest-merger marker rules, not from a device run.

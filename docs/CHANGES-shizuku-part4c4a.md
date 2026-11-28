# :shizuku — part 4C-4a (docs only)

Finding 5, first half: the five shared `uses-permission` (`RECEIVE_BOOT_COMPLETED`, `FOREGROUND_SERVICE`, `POST_NOTIFICATIONS`, `INTERNET`, `WRITE_SECURE_SETTINGS`) read on the real fetched + patched manifests of `:app`, Mika 0.1.52 and Shizuku v13.6.0: identical in all three (`WRITE_SECURE_SETTINGS` carries `tools:ignore="ProtectedPermissions"` everywhere), one declaration each per manifest, no `maxSdkVersion` / `tools:node`. They merge to one each; no merger conflict.

Changed: `shizuku/README.md` only (plan row 4 status, row 4C-4a done, new section "4C-4a"). No code, script, manifest, workflow or Gradle file touched; nothing built.

Not verified: the merged manifest of a real Gradle build (4E-3 / first CI run).

Next: 4C-4b (`uses-feature`).

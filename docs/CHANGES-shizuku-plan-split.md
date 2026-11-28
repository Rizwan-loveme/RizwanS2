# :shizuku — plan split before 4C-4 (docs only)

Only `shizuku/README.md` changed. No code, script, manifest, workflow or Gradle file was touched; nothing was built.

Split into smaller rows (each ends zip-ready):

- 4C-4 -> 4C-4a (duplicate `uses-permission`), 4C-4b (new `uses-feature`), 4C-4c (notes + zip `step4c`)
- 4D -> 4D-1 (activities), 4D-2 (`AdbPairingService`), 4D-3 (boot receivers), 4D-4 (Application class + notes)
- 4E-4 -> 4E-4a (components), 4E-4b (strings), 4E-4c (self-test + notes)
- 4F -> 4F-1 (rules in `check-gradle.py`), 4F-2 (switch + stale notes), 4F-3 (root checks)
- 4G -> 4G-1 (`NOTICE-Shizuku.md`), 4G-2 (notes + zip `step4`)
- 5B -> 5B-1 (`pm path`), 5B-2 (native libs)
- 6B -> 6B-1 (list + numbered links), 6B-2 (add the item)
- 7A -> 7A-1 (`<queries>` entry), 7A-2 (`SHIZUKU_PACKAGE`)
- 8D -> 8D-1 (APK content script), 8D-2 (manifest check on the APK)
- 9 -> 9A (docs), 9B (CHANGES); 10 -> 10A (static checks), 10B (final zip)

Correction found while splitting: the old 4D row said all 9 activities are "not exported"; the 4A table shows three are exported on purpose (`RequestPermissionActivity`, `ShellRequestHandlerActivity`, `LegacyIsNotSupportedActivity`). 4D-1 and 4E-4a now say so.

Next: 4C-4a.

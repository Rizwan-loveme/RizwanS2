# Seal — part 2 of 10: modules' sources copied, `sl_` resource prefix

Request: add Seal as a built-in app (like `:ppsspp`), update the workflow yml, keep all details, full flat zip.

Done in this part (`seal/tools/import-upstream.py`, run on the pinned commit 7677f61):
- `seal/src/main/java`: Seal's 126 Kotlin files (package `com.junkfood.seal`), `seal-color/src/main/java`: the 11 `:color` files.
- `seal/src/main/res`: all resources renamed with `sl_` (430 strings, 3 plurals, 1 colour, 12 drawables, 3 mipmaps, 1 xml; the 2 styles keep their names); 61 translations kept.
- `seal/schemas` (Room 1..5), `seal/consumer-rules.pro`, `seal/reference/AndroidManifest.upstream.xml` (reference, not merged).
- Resource scan against every module: 34 clashes (`app_name`, `cancel`, `settings`, `language`, `version`, `ic_launcher*`, `close`, `save`, ...) before the prefix, 0 after.
- Docs: `seal/README.md` (part 2 section), root `README.md` (table), `NOTICE-Seal.md`.

Fixed while doing it: the first run also prefixed `R.string.abc_action_mode_done` (an appcompat string used by `WebViewPage.kt`); the script now renames only names that Seal declares itself.

Not changed: `settings.gradle.kts`, `app/build.gradle.kts`, all manifests, all workflows. The two new folders have no build file yet, so Gradle does not see them and the build is exactly as before.
Not run: Gradle, CI, a device.
Next: part 3 (build files for `:seal` / `:seal-color`, plugins on Kotlin 2.2.10, dependencies, `settings.gradle.kts`, `:app` dependency).

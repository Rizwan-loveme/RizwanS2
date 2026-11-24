# Seal — part 3 of 10: Gradle wiring

Request: add Seal as a built-in app (like `:ppsspp`), update the workflow yml, keep all details, full flat zip.

Done:
- `seal-color/build.gradle.kts`, `seal/build.gradle.kts` (new): libraries, namespaces `com.junkfood.seal.color` / `com.junkfood.seal`, compileSdk 37, minSdk 26, Java 21; `:seal` has Compose compiler + serialization + KSP plugins, `buildConfig` with `FLAVOR = ""`, Room schemas to `seal/schemas` through KSP, the youtubedl-android engine 0.17.3 (library + ffmpeg + aria2c) from Maven.
- Root `build.gradle.kts`: plugins `kotlin.plugin.compose` 2.2.10, `kotlin.plugin.serialization` 2.2.10, `ksp` 2.2.10-2.0.2 (version checked on the google/ksp releases page); coroutines pin 1.8.1 -> 1.9.0.
- `settings.gradle.kts`: `:seal-color`, `:seal`. `app/build.gradle.kts`: `implementation(project(":seal"))` and the `META-INF/{AL2.0,LGPL2.1}` packaging exclude.
- Versions that differ from upstream: Kotlin 2.2.10 (2.0.20), Room 2.8.5 (2.6.1, same as `:j2me`), kotlinx-serialization 1.9.0 (1.7.2), OkHttp 4.12.0 (5.0.0-alpha.10, because `:youtube` runs on 4.12.0). Everything else is upstream's version.
- OkHttp 4 needed 3 source edits (`Response.body` -> `body!!`); they are marked "Win11:" and added to the patch list of `seal/tools/import-upstream.py` (a re-import reproduces the tree exactly).

Side effect (documented in `seal/README.md`): appcompat 1.7.0, material 1.12.0, core-ktx 1.15.0, activity / lifecycle 1.10 / 2.8 and coroutines 1.9.0 now apply to the whole app.

Not changed: manifests, Win11's `App.kt`, workflows. Seal has no manifest yet, so it adds no screen and no permission in this part.
Not run: Gradle, the Kotlin compile of Seal on 2.2.10, CI, a device. The next workflow run is the first compile of Seal; send me the first error lines if `:seal` fails and I fix them before part 4.
Next: part 4 (`SealInit`: MMKV, Koin, YoutubeDL / FFmpeg / Aria2c, notification channel, called from Win11's `App`; no second crash handler; the app self-update removed).

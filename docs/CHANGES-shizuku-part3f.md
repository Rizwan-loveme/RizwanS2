# Shizuku — part 3F of 10: `:app` and root side (dependency, AppCompat fork exclusion, replacement of `:mika`'s Maven artifacts)

Request: step 3F, **keep all details**, update the full flat zip. Based on `RizwanS2-main-shizuku-step3e.zip` (3A - 3E). Step 3 stays split in 8 sub-steps 3A - 3H (table in `shizuku/README.md`, "Step 3").
Still NOT in the project: 3G (final docs of step 3), 3H (final checks + `…-shizuku-step3.zip`). Steps 4 - 10 unchanged.

Steps (each ticked when done):
- [x] 1. Unpack, baseline checks (`check-gradle.py`: ok, `mika/tools/static-check.py`: ok)
- [x] 2. Read every file that 3F touches or that reads them: root `build.gradle.kts`, `app/build.gradle.kts`, `mika/build.gradle.kts`, `settings.gradle.kts`, `gradle.properties`, `mika/tools/check-manifest.py` + `static-check.py` (they read `mika/build.gradle.kts` and `app/build.gradle.kts`), the workflows (they do not touch these files for Shizuku yet)
- [x] 3. Root `build.gradle.kts`: replacement of the Maven `dev.rikka.shizuku:*` artifacts by the local modules (dependency substitution)
- [x] 4. `app/build.gradle.kts`: dependency on `:shizuku`, exclusion of the Rikka AppCompat fork, `META-INF/versions` packaging precaution
- [x] 5. `gradle.properties`: `includeShizuku` and `shizukuAbis` documented (comments only)
- [x] 6. `shizuku/tools/check-gradle.py`: check 8 for the root / `:app` side, tested with six planted faults
- [x] 7. Checks: `check-gradle.py`, `mika/tools/static-check.py` (incl. the "without Mika" unwiring simulation), tree-sitter Kotlin parse of all 33 `.kts` files
- [x] 8. Docs: `shizuku/README.md` (plan table, sub-step table, new section "3F", notes in "3E" / "Decisions already taken" / "Not checked here"), root `README.md`, `NOTICE-Shizuku.md`, `settings.gradle.kts` comment, this file
- [x] 9. Full flat zip `RizwanS2-main-shizuku-step3f.zip` (without `shizuku/upstream/`)

## Changed / new files
- changed: `build.gradle.kts` (root), `app/build.gradle.kts`, `gradle.properties` (comments only), `settings.gradle.kts` (a comment only), `shizuku/tools/check-gradle.py`, `shizuku/README.md`, `README.md`, `NOTICE-Shizuku.md`
- new: `docs/CHANGES-shizuku-part3f.md`
- not touched: `mika/build.gradle.kts` (on purpose, see below), every module build file of `shizuku/` (3C - 3E), the patch / fetch scripts, `after-fetch.gradle.kts`, every Kotlin / Java / resource / manifest / workflow file, `mika/tools/*`; `shizuku/upstream/` is not in the zip
- **the build is unchanged while `includeShizuku` is off (default)**: `shizukuIncluded` is `false`, the substitution map is empty, no `if` is taken

## What changed

### Root `build.gradle.kts` — the replacement of `:mika`'s Maven artifacts
`:mika` asks for `dev.rikka.shizuku:api:13.1.5` and `:provider:13.1.5` (Maven). Our `:shizuku-api` / `:shizuku-provider` have **the same classes in the same namespaces** (built from the pinned API commit, API 13.1.5, with the host-package patch). Both on one class path = duplicate-class / duplicate-namespace failure. So, when `findProject(":shizuku-api") != null`:

```
dev.rikka.shizuku:aidl      -> :shizuku-aidl
dev.rikka.shizuku:shared    -> :shizuku-shared
dev.rikka.shizuku:api       -> :shizuku-api
dev.rikka.shizuku:provider  -> :shizuku-provider
```
is applied as a dependency substitution in every project and configuration, for any version number. `aidl` / `shared` are included because the Maven `api` POM brings them in. Why a substitution and not an edit of `mika/build.gradle.kts`: `mika/tools/check-manifest.py` requires the two Maven lines in that file, the CI package rename edits that file, and a substitution also catches a library that asks for one of the artifacts through its POM. With the switch off nothing runs.

### `app/build.gradle.kts`
| Change | Detail |
|---|---|
| `val shizukuIncluded = rootProject.findProject(":shizuku") != null` | the signal is the existence of the project, so only `settings.gradle.kts` reads the property |
| `implementation(project(":shizuku"))` behind `if (shizukuIncluded)` | the ten helper modules arrive through it (runtime class path); `:shizuku-shell` is never a dependency (only its dex is used) |
| `configurations.configureEach { exclude(group = "dev.rikka.rikkax.appcompat", module = "appcompat") }` behind `if (shizukuIncluded)` | the Rikka AppCompat fork (same class names as AndroidX AppCompat) must not reach the APK; `:shizuku` excludes it too, this is the final class path |
| `excludes += "/META-INF/versions/**"` in `packaging.resources`, behind `if (shizukuIncluded)` | precaution against the known "2 files found with path META-INF/versions/9/OSGI-INF/MANIFEST.MF" error of BouncyCastle 1.70 (`bcprov` / `bcpkix` / `bcutil`, ADB pairing keys). Android does not read `META-INF/versions`. Not seen here, written from knowledge of the error: if the first build names another duplicate path, one more entry here fixes it |

The "without Mika" workflow removes lines that contain `project(":mika")`; the new lines do not match, and the simulation in `mika/tools/static-check.py` (Mika lines removed, files still balanced) still passes with the `:shizuku` lines kept.

### `gradle.properties`
Comment block (no property is set): `includeShizuku=true` (what it includes, replaces and excludes; **an APK that contains both `:mika` and `:shizuku` cannot be installed until step 4**, both declare a provider with the authority `${applicationId}.shizuku`) and `shizukuAbis=arm64-v8a` (ABIs of `libshizuku.so`, `libadb.so`, `librish.so`; default all four; the APK filter is the existing `apkAbis`).

### `shizuku/tools/check-gradle.py` — check 8
`app/build.gradle.kts` is parsed like the other files. The root build file has a guarded substitution map whose targets are included projects with matching names. **Every `dev.rikka.shizuku:<x>` coordinate any build file asks for is in the map** (a new Maven request is found before it becomes a duplicate-class error); no shizuku module asks for such a coordinate itself. `:app` defines `shizukuIncluded` from `findProject(":shizuku")`, depends on `:shizuku` and excludes the fork, both exactly inside `if (shizukuIncluded)`, and on no other `:shizuku-*`. Nothing but `:shizuku`'s dex task refers to `:shizuku-shell`. `mika/build.gradle.kts` still has its two Maven lines. The switch is still OFF by default and `gradle.properties` documents the two flags without setting `includeShizuku`.
Tested with six planted faults (substitution entry removed; `:app` dependency without the `if`; unknown Maven artifact `dev.rikka.shizuku:extra` in `:mika`; default flipped on; `:app` depending on `:shizuku-shell`; a helper module asking for the Maven `api`): all found; unmutated copy passes.

## What happens with the switch on (`-PincludeShizuku=true`)
- `:app` depends on `:shizuku` -> the Win11 APK now contains the manager, server, starter, rish, the API modules, `libshizuku.so`, `libadb.so`, `librish.so` and `assets/rish_shizuku.dex`.
- `:mika` is compiled against `:shizuku-api` / `:shizuku-provider` (same API 13.1.5) instead of the AAR.
- **Not done yet (steps 4 / 6):** manifest merge (the two providers with one authority make the APK uninstallable while `:mika` is in it; with `-PincludeMika=false` there is no clash) and the hooks (Start menu, Home icon, `rizwans2://shizuku`, `ShizukuApplication.onCreate`). The switch therefore stays **off by default**; steps 8 / 10 flip it.

## Not verified (read before the first CI run)
- Still no Gradle run (Maven Central, Google Maven, JitPack, the plugin portal and the Gradle distribution are not reachable). Gradle's embedded Kotlin compiler (used in 3E) was not available this time: all 33 `.kts` files of the project were parsed with tree-sitter Kotlin (grammar only, no type check: no error node), plus `check-gradle.py` and `static-check.py`.
- Open points that only the first run can answer (details in `shizuku/README.md`, "Not verified in 3F"): the substitution DSL (the loop and `project(localPath)` resolving to the substitutions' `project`); `:mika` compiling against our modules (`api` / `implementation` split); duplicate resource paths or classes between the new libraries (rikkax, libsu, hiddenapibypass, BouncyCastle, AppIconLoader, `dev.rikka.hidden`) and the existing ones; the three native libraries in the APK (`libshizuku.so` is a CMake executable, open since 3E); version lifts of androidx libraries.
- Quickest look after the first run: `./gradlew :app:dependencies -PincludeShizuku=true` should show `dev.rikka.shizuku:api -> project :shizuku-api` and no `dev.rikka.rikkax.appcompat` in `releaseRuntimeClasspath`.

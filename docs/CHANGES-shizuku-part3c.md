# Shizuku — part 3C of 10: API-side helper modules (`:shizuku-aidl`, `-shared`, `-api`, `-provider`, `-common`, `-shell`) + `after-fetch.gradle.kts`

Request: step 3C, **keep all details**, update the full flat zip. Based on `RizwanS2-main-shizuku-step3b.zip` (3A + 3B). Step 3 stays split in 8 sub-steps 3A - 3H (table in `shizuku/README.md`, "Step 3").
Note: the 3B zip contained no module files at all (only 3A and 3B), so 3C was written from scratch in this part; 3D (native + server side), 3E (`:shizuku`), 3F (`:app` / root side) are still NOT in the project.

Steps (each ticked when done):
- [x] 1. Unpack the 3B zip, review `settings.gradle.kts`, `shizuku/README.md`, the patch script, `:mika` / `:ppsspp` build files (the fetch-hook pattern)
- [x] 2. Try to fetch upstream: **not possible in this session** (no network, not even GitHub); take the real source paths from the patch script instead
- [x] 3. `shizuku/modules/after-fetch.gradle.kts`: hook the source-reading task families on `:shizuku:patchShizukuUpstream` (by path) + the `checkShizukuLayout` task
- [x] 4. Build files: `aidl`, `shared`, `api`, `provider`, `common` (libraries, Java only) and `shell` (application module: R8 dex, own manifest, own `proguard-rules.pro`)
- [x] 5. `shizuku/tools/check-gradle.py`: structural check without Gradle / Kotlin compiler; run, plus 5 deliberate faults (all found), files restored byte for byte
- [x] 6. Docs: `shizuku/README.md` (plan table, sub-step table, new section "3C" with decisions and "Not verified in 3C"), root `README.md` table, `NOTICE-Shizuku.md`, this file
- [x] 7. Full flat zip `RizwanS2-main-shizuku-step3c.zip`

## Changed / new files
- new: `shizuku/modules/after-fetch.gradle.kts`, `shizuku/modules/{aidl,shared,api,provider,common,shell}/build.gradle.kts`, `shizuku/modules/shell/src/main/AndroidManifest.xml`, `shizuku/modules/shell/proguard-rules.pro`, `shizuku/tools/check-gradle.py`, `docs/CHANGES-shizuku-part3c.md`
- changed (docs only): `shizuku/README.md`, `README.md`, `NOTICE-Shizuku.md`
- not touched: `settings.gradle.kts`, `build.gradle.kts`, `gradle.properties`, `app/`, every Kotlin / Java / resource / manifest / workflow file, `shizuku/tools/patch-upstream.py`, `fetch-upstream.sh`; `shizuku/upstream/` is not in the zip
- the build is unchanged while `includeShizuku` is off (default): none of these files is read

## What each module reads
| Gradle project | source folder (inside `shizuku/upstream/`) | namespace |
|---|---|---|
| `:shizuku-aidl` | `api/aidl/src/main/{aidl,java}` | `rikka.shizuku.aidl` |
| `:shizuku-shared` | `api/shared/src/main/java` | `rikka.shizuku.shared` |
| `:shizuku-api` | `api/api/src/main/java` | `rikka.shizuku.api` |
| `:shizuku-provider` | `api/provider/src/main/java` | `rikka.shizuku.provider` |
| `:shizuku-common` | `common/src/main/java` | `moe.shizuku.common` |
| `:shizuku-shell` | `shell/src/main/java` | `rikka.shizuku.shell` |

## Decisions
1. Build files are ours, sources come from the checkout (3B decision), through `rootProject.file("shizuku/upstream")`.
2. One shared script (`after-fetch.gradle.kts`) instead of the same hook block in 11 build files; tasks named by path (`:shizuku:patchShizukuUpstream`), so the order in which projects are configured is irrelevant.
3. `checkShizukuLayout` in every module, because the upstream folders could not be looked at in this session: a moved folder fails with a clear message, an unwired kind of source (Kotlin, AIDL, resources ...) only warns.
4. `:shizuku-api` exposes `:shizuku-aidl` / `:shizuku-shared` with `api(...)`, `:shizuku-provider` exposes `:shizuku-api`: the same compile-scope dependencies the Maven artifacts have, which `:mika` relies on (3F replaces the artifacts by these projects).
5. `:shizuku-shell` stays an application module (R8, `-dontobfuscate`, entry point and rish classes kept by name); the dex to copy in 3E is `build/intermediates/dex/release/minifyReleaseWithR8/classes.dex` of the module.
6. The Refine plugin is applied only where hidden-API calls are rewritten and only in `:shizuku-shell` so far (server, starter, server-shared, shizuku follow in 3D / 3E).

## Not verified (read before the first CI run)
- No upstream source could be read (no network): the **dependency lists and the namespaces of `aidl`, `shared`, `common`** are reconstructed (Shizuku-API 13.1.5 layout, Maven POMs), not read from upstream's `build.gradle` files. A wrong one shows up in the first CI run with `-PincludeShizuku=true` as a compile error in that module; each fix is one line.
- No Gradle run, no Kotlin compiler: `check-gradle.py` checks structure and cross-references only (not Kotlin semantics, not DSL accessors such as `aidl.srcDir`).
- Keep `includeShizuku` **off** until 3E: `:shizuku-shell` depends on `:shizuku-rish` (3D) and the fetch / patch tasks live in `:shizuku` (3E).

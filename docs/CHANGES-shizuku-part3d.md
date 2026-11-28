# Shizuku — part 3D of 10: native and server-side helper modules (`:shizuku-rish`, `-server-shared`, `-starter`, `-server`)

Request: step 3D, **keep all details**, update the full flat zip. Based on `RizwanS2-main-shizuku-step3c.zip` (3A - 3C). Step 3 stays split in 8 sub-steps 3A - 3H (table in `shizuku/README.md`, "Step 3").
Still NOT in the project: 3E (`:shizuku` build file, its CMake, theme builder, rish dex task, fetch / patch tasks), 3F (`:app` / root side).

Steps (each ticked when done):
- [x] 1. Check the 3C state and run the baseline check (`check-gradle.py`: ok)
- [x] 2. `after-fetch.gradle.kts`: new optional `extra["shizukuRequired"]` (single files, e.g. the CMake file); build files for `rish`, `server-shared`, `starter`, `server`
- [x] 3. `check-gradle.py`: new cycle check on the `project(...)` graph; run; 4 deliberate faults in the new files (cycle, unknown project, duplicate namespace, missing brace): all found, files restored byte for byte
- [x] 4. Docs: `shizuku/README.md` (plan table, sub-step table, new section "3D" with decisions and "Not verified in 3D"), root `README.md`, `NOTICE-Shizuku.md`, this file
- [x] 5. Full flat zip `RizwanS2-main-shizuku-step3d.zip`

## Changed / new files
- new: `shizuku/modules/{rish,server-shared,starter,server}/build.gradle.kts`, `docs/CHANGES-shizuku-part3d.md`
- changed: `shizuku/modules/after-fetch.gradle.kts` (`shizukuRequired`), `shizuku/tools/check-gradle.py` (cycle check), `shizuku/README.md`, `README.md`, `NOTICE-Shizuku.md`
- not touched: `settings.gradle.kts`, `build.gradle.kts`, `gradle.properties`, `app/`, every Kotlin / Java / resource / manifest / workflow file, the patch and fetch scripts, the six 3C modules; `shizuku/upstream/` is not in the zip
- the build is unchanged while `includeShizuku` is off (default)

## What each module reads
| Gradle project | source (inside `shizuku/upstream/`) | namespace |
|---|---|---|
| `:shizuku-rish` | `api/rish/src/main/{java,aidl}`, native: `api/rish/src/main/cpp/CMakeLists.txt` | `rikka.rish` |
| `:shizuku-server-shared` | `api/server-shared/src/main/java` | `rikka.shizuku.server.shared` |
| `:shizuku-starter` | `starter/src/main/java` | `moe.shizuku.starter` |
| `:shizuku-server` | `server/src/main/{java,aidl}` | `rikka.shizuku.server` |

## Decisions
1. `:shizuku-rish`: project NDK, CMake 3.22.1, `-DANDROID_STL=none` + Prefab `libcxx`, ABIs all four, `-PshizukuAbis` narrows (shared with `:shizuku` in 3E).
2. Refine plugin on `server-shared`, `starter`, `server` (with `shell` from 3C and `:shizuku` in 3E): exactly the set found in 3A.
3. Starter and server do not depend on each other; both reach the host APK through `:shizuku` (3E).
4. `shizukuRequired` check for single files, because a wrong CMake path would otherwise surface only as a CMake error.
5. Cycle check in `check-gradle.py` now that there are 10 modules with real dependency chains.

## Not verified (read before the first CI run)
- No network in this session either: upstream not readable, nothing built. The **dependency lists of all four modules, the namespaces of `rish` / `server-shared`, the CMake file path, the Prefab package name `libcxx` and the `parcelablelist` dependency of `:shizuku-server` are reconstructed**, not read. A wrong one shows up in the first CI run with `-PincludeShizuku=true`; each fix is one line (details in `shizuku/README.md`, "Not verified in 3D").
- `check-gradle.py` is a structural check (brackets, strings, includes, paths, namespaces, cycles), not a Kotlin compile.
- Keep `includeShizuku` **off** until 3E: the fetch / patch tasks that every module waits for are registered in `:shizuku`.

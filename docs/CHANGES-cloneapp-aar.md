# Clone App as an AAR module — step 1 of 3

Request: add the Clone App (`RizwanS2` main project) as a module (AAR), keep all details, update, full flat zip. Written permission stated by the owner.

Steps (each ticked when done):
- [x] 1. Unpack `RizwanS2-main.zip`, `Clone_App_src.zip` and the five `classes*.jar`; count and classify what is there
- [x] 2. Find what must not be inside an AAR (duplicate libraries, `:Bcore` clashes, patching-tool leftovers, manifest attributes)
- [x] 3. `cloneapp/tools/build-aar.py` and `cloneapp/cloneapp.aar`
- [x] 4. Module wiring: `cloneapp/build.gradle.kts`, `settings.gradle.kts`, `app/build.gradle.kts`, `.gitattributes`
- [x] 5. Docs: `cloneapp/README.md`, `NOTICE-CloneApp.md`, root `README.md`, this file
- [x] 6. Static checks, flat zip
- [ ] 7. Native libraries (`lib/<abi>/*.so`) — not received
- [ ] 8. Engine start-up from `AppBase` + Start menu / Home / deep link

## Files
New: `cloneapp/` (`cloneapp.aar`, `build.gradle.kts`, `README.md`, `STRIPPED-CLASSES.txt`, `tools/build-aar.py`), `NOTICE-CloneApp.md`, this file.
Changed: `settings.gradle.kts` (+`include(":cloneapp")`), `app/build.gradle.kts` (+`implementation(project(":cloneapp"))`), `.gitattributes` (+`*.aar binary`), `README.md` (new section at the end).
Nothing else in the project was touched (no source, manifest, workflow or other module).

## Checks run (no Android SDK / network here, so nothing was built)
| Check | Result |
|---|---|
| Classes: 28,124 in `classes.jar`; 817 library copies + 76 `:Bcore` duplicates left out; 0 duplicate entries between the four jars | ok |
| Class patches: `BLYApplication` super class, `UserActivity.onResume` | `javap` shows `extends android.app.Application` and four `nop` |
| Manifest: parses, 0 `LAUNCHER` filters, 65 `${applicationId}` replacements, no `<application>` attributes | ok |
| Resources: 1,151 XML files parse; `public.xml` 6,177 ids kept, 191 undefined entries dropped; `R.txt` 6,177 lines | ok |
| Wiring: `cloneapp` is in `settings.gradle.kts` and `:app`; no workflow lists modules that must include it (it is always built like `:tui`) | ok |
| Gradle build / APK run | **not done** |

## Risks to look at in the first CI build
1. Duplicate classes with a library that is not visible in the build files (transitive). Add the package to `STRIP_PREFIXES` in `build-aar.py` and rebuild.
2. aapt2 on the old resources (`values-in-rID`, `drawable-watch`, pinned ids). If `public.xml` is refused, delete it and `R.txt` from the AAR (the dex code then needs the ids re-mapped, see README).
3. Manifest merger: a component or permission of the Clone App that clashes with another module (`tools:replace` goes in `app/src/main/AndroidManifest.xml`).

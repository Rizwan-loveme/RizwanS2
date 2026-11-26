# Mika (Rizwan) — build fix 1 (after the first GitHub Actions log)

Request: step 14 (wake word) dropped; fix the build errors from `build-error-log.zip`; keep every detail; full flat zip.

## Steps done
- [x] 1. Noted in memory: step 14 dropped, build fix requested
- [x] 2. Read the log (1657 lines): every `e:` line, the failed task, the tasks before it
- [x] 3. Found the cause (Compose Foundation API removed) and the only place that uses it
- [x] 4. Fixed it as patch edit 14 (the upstream checkout is fetched at build time, so the fix lives in the patch script, not in a copied source file)
- [x] 5. Tested on the real upstream (pristine and already-patched), added `static-check.py` group 10
- [x] 6. Updated the docs, flat zip `RizwanS2-main-mika-fix1.zip`

## What the log says
| Task | Result |
|---|---|
| `:mika:fetchMikaUpstream` | "Mika 0.1.52 (7ff1703f63b7...) already present" (cache) |
| `:mika:patchMikaUpstream` | passed (the 13 edits of the old script) |
| `:mika-core` protobuf + `compileKotlin` | passed |
| `:mika` resources, manifest, assets, JNI libs, `verifyReleaseResources` | passed (so the `mk_` renames, the manifest and the merged resources are accepted by AAPT2) |
| `:app:mergeReleaseNativeLibs`, `stripReleaseDebugSymbols` | passed (a normal "Unable to strip ..." notice) |
| **`:mika:compileReleaseKotlin`** | **FAILED, 2 errors** |
```
ChatDrawerMotion.kt:85:88  Unresolved reference 'minAnchor'.
ChatDrawerMotion.kt:85:109 Unresolved reference 'maxAnchor'.
```
All other lines with `w:` are warnings of other modules (chooser etc.), not related.

## Cause
`:mika` uses `compose-bom-alpha:2025.03.01` (the project's version; the plan decided "the project's versions win", part 5). Upstream builds with BOM 2024.12.01. In the newer Compose Foundation `DraggableAnchors.minAnchor()` / `maxAnchor()` are gone. The only use in the whole upstream is `ChatDrawerMotion.kt:85` (the chat side drawer clamping a drag):
`anchoredScope.dragTo((currentOffset + pixels).coerceIn(anchors.minAnchor(), anchors.maxAnchor()))`

## Fix (patch edit 14, `mika/tools/patch-upstream.py`)
`anchors.minAnchor(), anchors.maxAnchor()` becomes
`minOf(anchors.positionOf(DrawerValue.Closed), anchors.positionOf(DrawerValue.Open)), maxOf(anchors.positionOf(DrawerValue.Closed), anchors.positionOf(DrawerValue.Open))`.
Same value: the drawer is built with exactly two anchors (`Closed at -width`, `Open at 0f`, `resize()`), so min / max of the two positions is what `minAnchor()` / `maxAnchor()` returned. `positionOf` exists in every Foundation version, so the same code also works with the old BOM.
- Idempotent; fails with `::error::` if the line is found more than once (upstream layout changed); does nothing when the old call is not there.
- `check()` fails if `.minAnchor(` / `.maxAnchor(` is left anywhere in Mika's sources.
- The patch stamp contains the hash of the script, so the cached `mika/upstream/` of your CI (already patched by the old script) is patched again; only edit 14 changes (`drawer anchors=1`, all others 0).

## Tested here
| Case | Result |
|---|---|
| patch on the real upstream 0.1.52 (pristine) | `done ... licence assets=13, drawer anchors=1`; the line shows the new code; no `minAnchor` / `maxAnchor` left in any `.kt` |
| patch again | "already patched (same script), nothing to do" |
| patch on a checkout patched by the old script (what your CI cache holds) | only `drawer anchors=1` changes, everything else 0 |
| `static-check.py` (project) | all groups pass; group 10 is new (needs `mika/upstream/`) |
Not tested: the compile itself (no Kotlin compiler, Android SDK or network here).

## What can still happen
A Gradle build stops at the first failing task. Everything after `:mika:compileReleaseKotlin` (the rest of `:mika`, `:app` compile, R8 / minify of the release build, dex merge, APK packaging, the Mika class check in CI) has not run yet, so more errors are possible. Send the next log (the `e:` lines and the `What went wrong` block are enough) and I fix it the same way.

## Not changed
No Kotlin, Gradle, manifest, workflow or resource file of the project. Step 14 (wake word and persona prompts) is dropped, not done: Mika's prompts still say "Mika" internally, the visible name and the chat greeting are "Rizwan" / "Hey Rizwan" (parts 4 and 6).

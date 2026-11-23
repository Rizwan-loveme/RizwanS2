# RetroArch: NDK 29 build fix (2026-11-23)

Build log: `:retroarch:buildNdkBuildRelease[arm64-v8a]` FAILED.

```
retroarch/upstream/input/drivers/android_input.c:1641:13: error: 'ALooper_pollAll' is unavailable: obsoleted in Android 1 -
ALooper_pollAll may ignore wakes. Use ALooper_pollOnce instead.
```

## Change
- `retroarch/tools/fetch-upstream.sh`: new function `apply_ndk_patches` (idempotent), called in all three paths (fresh clone, clone already present / cached, hand-placed).
  It replaces `ALooper_pollAll(` with `ALooper_pollOnce(` in `input/drivers/android_input.c` and fails if any `ALooper_pollAll` is left.
- `retroarch/README.md`: note under "If the first CI run fails".

## Why this is safe
- Same signature `(int timeoutMillis, int* outFd, int* outEvents, void** outData)`.
- The call is the condition of `while ((ident = ...) >= 0)`, so the loop keeps draining events.
- Only the working tree of the clone changes; `git rev-parse HEAD` still equals `UPSTREAM_COMMIT`.
- A `-D` macro cannot be used: it would also rewrite the declaration in NDK's `looper.h`.

## Not changed
- `ASensorManager_getInstance` (line 1918): deprecation warning only.
- Workflows: the fetch step already runs the script; the cache key includes the script, so the old unpatched cache is dropped automatically.

## Open
The compiler stopped at the first failing file (`griffin.c`). Other NDK 29 errors may appear in later files: send the next log.

## Update 2 (second build log)
- `:retroarch` native build now passes (ALooper fix worked).
- New error, `:app:compileReleaseKotlin`: `BrowserPopup.kt:562` the `View.OnLayoutChangeListener` lambda had 10 parameters, the interface has 9
  (`v, left, top, right, bottom, oldLeft, oldTop, oldRight, oldBottom`). Removed the extra trailing `_`.

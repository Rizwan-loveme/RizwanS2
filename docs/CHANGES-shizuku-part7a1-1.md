# Shizuku — row 7A-1.1 (`<queries>` entry, Mika's patch script)

Request: 7A-1 split into 7A-1.1 / 7A-1.2, do 7A-1.1, keep all details, updated full flat zip. Based on `RizwanS2-main-shizuku-step6e.zip`.

Result: with `:shizuku` in the build, Mika's `<queries><package>` entry of the external Shizuku app (`moe.shizuku.privileged.api`) is written as `${applicationId}` (the host package) by `mika/tools/patch-upstream.py`; without `:shizuku` the stock name stays.

## Changed code
- `mika/tools/patch-upstream.py`: part 15 (`SHIZUKU_BUILTIN`, `patch_shizuku_queries`, `check_shizuku_queries`), result key in `main()`, switch in the stamp, header item 15.
- `mika/build.gradle.kts`: `patchMikaUpstream` sets `MIKA_SHIZUKU_BUILTIN` from `rootProject.findProject(":shizuku") != null`.
- `mika/tools/check-manifest.py`: check 13 (the entry matches the switch; unset = either spelling, exactly one).
- `mika/tools/patch-upstream.sh`: header comment.

## Decisions
1. Two-way, idempotent patch (both spellings accepted as input, output depends only on the switch).
2. The switch is part of the stamp; the workflow cache key already hashes `patch-upstream.py`, so old caches are not reused.
3. Signal = the project test, like `app/build.gradle.kts`.
4. `${applicationId}`, not a literal package, so the workflow rename cannot leave a stale name.
5. Strict input: none, two, or a longer name is `::error::`.
6. The entry is redundant at run time with the manager built in (an app sees itself) but kept, as the plan row says.

## Not done
Not run against the real Mika manifest, no Gradle build, no device. `STALE_QUERY_ALLOWED` stays 1 and `EXPECTED_STALE_QUERY_ALLOWED` stays 1 (7A-1.2). Tried on a hand-made manifest: 13 cases as expected; `check-all.py` and `static-check.py` pass. Steps left: 7A-1.2, 7A-2, 7B - 7E, 8A - 8F, 9A - 9B, 10A - 10B. Next: 7A-1.2.

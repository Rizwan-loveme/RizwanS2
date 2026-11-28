# Shizuku — row 6E (init call `ShizukuApplication.onCreate(app)`)

Request: 6E, keep all details, update the full flat zip. Based on `RizwanS2-main-shizuku-step6d.zip`.

Result: with `:shizuku` in the build, the launcher process runs upstream's Application work once at start (`application`, `ShizukuSettings.initialize`, locale), as finding 13 requires. With `:shizuku` out of the build, nothing happens. Step 6 is complete.

## Changed code
- `ShizukuLauncher.kt`: `initApplication(app: Application): Boolean` (reflection on the `@JvmStatic onCreate` of `moe.shizuku.manager.ShizukuApplication`), constant `MANAGER_APPLICATION`, `@Volatile initDone`, header comment.
- `App.kt`: one guarded `try / catch (Throwable)` call in `onCreate`, after the "process start" log line, before the Seal block; class comment.

## Decisions
1. Guard = the class is present (`ClassNotFoundException` -> silent false). No `BuildConfig` flag: `:app` has none, and `:app` names no Shizuku class at compile time (6A).
2. The call is in `App.onCreate` (spot of 4D-4), not in `AppBase`: the "without Rizwan" workflow replaces `AppBase.kt` by a stub, which would drop the call while Shizuku stays in the build (boot crash, finding 13).
3. Launcher process only; before Seal; `startMikaIfUsed()` stays last.
4. Runs once (`initDone`); never throws; `InvocationTargetException` unwrapped for the log.
5. 8F (default on) must still wait for 8D; the 6E condition of finding 13 is met.

## Changed files
`ShizukuLauncher.kt`, `App.kt`, `shizuku/README.md` (plan rows 6 and 6E, finding 13 line, new section "6E"), `README.md` (state line), this file.

## Not done
No compile, no Gradle build, no device test; manifest checker not re-run (no manifest change). R8 is off for `:app` (`isMinifyEnabled = false`); a keep rule for `ShizukuApplication.onCreate` is needed only if minify is switched on. Steps left: 7A - 7E, 8A - 8F, 9A - 9B, 10A - 10B. Next: 7A-1.

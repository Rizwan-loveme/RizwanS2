# Part 26 — Force-stop button and running indicator

Part 25 (per-app toggles) was skipped on request, so this is the next part after 24.

## What changed
- **Engine (`Bcore`)**: new `isPackageRunning(packageName, userId)` goes through
  `IBPackageManagerService.aidl` → `BPackageManagerService` → `BProcessManagerService.isPackageRunningAsUser`
  → `BPackageManager` → `BlackBoxCore`. It is true when the clone has a process record whose pid still
  exists in `/proc`, so background-only apps count as running (unlike the old task-based `isRunningApplication`).
- **Parallel screen**: every clone card shows a green **● চলছে** pill next to the name while it runs, and a
  **⏹️** button. The button is dimmed and disabled when the clone is not running. Tapping it asks for
  confirmation, then calls `Engine.forceStop` (= `BlackBoxCore.killApp`: kills all processes of the clone,
  clears the failure notification, keeps the data) and shows the result.
- The card now has two lines: icon + name on top, the six action buttons in a strip below (six buttons did not fit beside the name).
- The running state is polled every 2 s while the screen is open (off the main thread) and stops in `onPause`.

## Done when
Starting a clone makes the pill appear within about 2 s; ⏹️ → confirm makes the pill disappear and the app's process is gone.

## Test
1. Open a clone with ▶️, come back to Parallel: pill visible, ⏹️ bright.
2. Tap ⏹️ → confirm: toast "বন্ধ হয়েছে", pill gone, ⏹️ dimmed.
3. Open the clone, press Home (app keeps running in background): pill stays.
4. Check with `adb shell ps -A | grep <package>` that the box process is gone after stop.

# Part 23 — Play Store check (`getNetworkInfoForUid` hook)

Status: the hook is in `IConnectivityManagerProxy.GetNetworkInfoForUid`. It has **not** been run on a
real device yet; this file is the test to do that. Part 23 added a log marker to the hook so the result
can be read from logcat.

## What the hook should do
Inside a clone, `ConnectivityManager.getNetworkInfo(Network)` asks the system about the clone's virtual
uid. The system refuses that (only the own uid is allowed). Cronet in Play Store / Play Services treats
the refusal as fatal and the process dies a few seconds after start. The hook swaps the uid for the
host uid, and if the system still says no it returns a connected WIFI `NetworkInfo`.

## Needs
- A real device (Android 12 and 14 if you have both, see part 33), with real Google Play Services.
- USB debugging, `adb` on the computer.
- The build of this zip installed.

## Steps
1. Start a log filter on the computer:
   `adb logcat -s IConnectivityManagerProxy:V | grep PARALLEL_NETHOOK`
2. In Parallel tap **➕ ক্লোন করুন**, clone **Google Play Store** (`com.android.vending`). Google Play
   Services is added to the space by the app when the phone has it.
3. Tap ▶️ on the clone and keep it open for **60 seconds**.
4. Open the Play Store search and let a page load (this makes network calls).
5. Check the app list of the phone: `adb shell ps -A | grep -i vending` — a `com.android.vending`
   process of the box must still be there after 60 seconds.

## Reading the log
| Line | Meaning |
|---|---|
| `PARALLEL_NETHOOK ok uid A->B result=...` | The uid swap worked and the system answered. Best case. |
| `PARALLEL_NETHOOK system returned null ... fallback` | The system answered nothing; the fallback was used. App should still live. |
| `PARALLEL_NETHOOK refused (...) fallback` | The system still refused; the fallback was used. App should still live. |
| no `PARALLEL_NETHOOK` line at all | The hook was not called (the app did not ask), or the filter is wrong. |

## Pass / fail
- **Pass:** the Play Store clone is alive after 60 s, a page loads, and the log shows `ok` or a fallback line.
- **Fail:** the process is gone within seconds. Then run `adb logcat -b crash` and look for `SIGTRAP`
  or `CronetInit`; send that part of the log.

## Also try
- Turn Wi-Fi off, mobile data on, and repeat steps 3–5 (the fallback reports WIFI; the app should not
  care, but confirm).
- Repeat with the independent copy switch (part 20) on and off.

## Result log (fill in)
| Date | Device / Android | Result (pass/fail) | Log line seen | Notes |
|---|---|---|---|---|
|  |  |  |  |  |

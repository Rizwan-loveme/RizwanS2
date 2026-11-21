# Part 31 — Install from inside the box (`requestInstallPackage`)

Parts 25, 27, 28 and 29 were skipped on request. This follows Part 30.

## The problem
A cloned app (browser, file manager, an app with an "update" button) that wants to install an APK starts the
system package installer. The new app then lands on the **phone**, not inside the box.

## What it does now
The start of that installer is redirected to the box's own dialog (`InstallRequestActivity`, runs in the host process):

1. **Ask**: "<clone> (স্পেস N) একটি অ্যাপ ইনস্টল করতে চায়" with the file name and size, buttons ইনস্টল / বাতিল.
2. **Install**: with `BundleInstaller` (same code as "📂 ফাইল থেকে"): `.apk`, `.apks`, `.xapk`, `.apkm`, splits, native libs and OBB all work. Progress bar with stage text.
3. **Where**: always the **same space as the clone that asked**. An app that is already in that space is **updated and keeps its data** (the installer only recreates the folders and the `lib` folder).
4. **Answer**: result codes of the system installer (`RESULT_OK` installed, `RESULT_CANCELED` cancelled, `RESULT_FIRST_USER` failed, plus `EXTRA_INSTALL_RESULT`), so `startActivityForResult()` in the clone works as normal.
5. After success: **খুলুন** starts the new app in that space, or ঠিক আছে.
6. Errors are shown in Bengali by kind (wrong CPU type, bad file, no APK, no space, broken APK, OBB copy failed ...) with the engine's English text underneath.

## Which requests are caught (`ComponentUtils.isRequestInstall`)
- intent type `application/vnd.android.package-archive` (as before)
- action `android.intent.action.INSTALL_PACKAGE` (new)
- `ACTION_VIEW` of a `file://` or `content://` uri whose name ends in `.apk`, `.xapk`, `.apks` or `.apkm` (new)

Order inside the `startActivity` hook: block the launcher's own APK → `ClientConfiguration.requestInstallPackage(file, userId)`
(a host can still handle it itself, default `false`) → the box dialog → old behaviour (system installer) when the switch is off.

Other details:
- The clone's own FileProvider uri is mapped to the real file inside the clone's process; other content uris (Downloads, etc.) are copied by the dialog through the content resolver.
- `PackageManager.canRequestPackageInstalls()` answers **true** inside the box while the switch is on, so apps do not send the user to the phone's "install unknown apps" settings first.
- The launcher's own APK is refused ("নিজের ভেতরে নিজেকে ইনস্টল করা যায় না").
- Not covered: apps that install through the `PackageInstaller` session API. They still go to the system.

## Switch
Parallel screen → **📥 বক্সের ভেতরে ইনস্টল** (default on). It is a marker file (`parallel_install_in_box.off` in the app's files folder, file = off),
because the cloned apps run in other processes and read it through `ClientConfiguration.isInstallInsideBox()`.
The option cards now scroll together with the clone list, so more cards never push the list off a small screen.

## Changed files
`Bcore`: `InstallRequestActivity` (new, + manifest entry), `InstallRequestRedirect` (new), `ActivityManagerCommonProxy`,
`IPackageManagerProxy`, `ComponentUtils`, `ClientConfiguration`, `BlackBoxCore`.
`app`: `InstallInBoxSetting` (new), `App.kt`, `ParallelActivity`.

## Test
1. Clone a browser (Chrome/Via) or a file manager. Download or open an `.apk` inside it.
2. The box dialog appears, not the system installer. Tap ইনস্টল: progress, then "ইনস্টল হয়েছে (স্পেস N)". The app shows in the Parallel list in that space and **not** in the phone's app list.
3. Install a newer version of the same app the same way: it updates, its data stays.
4. Open a `.xapk` with OBB from the clone's file manager: the OBB files are copied, a game opens without a download prompt.
5. Switch 📥 off, repeat: the system installer opens (old behaviour). Switch back on.
6. Try to install the Parallel app's own APK from the clone: refused.

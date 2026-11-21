# Part 30 — Backup and restore of clone data

Parts 27, 28 and 29 were skipped on request (as was 25), so this follows Part 26.

## What it does
Every clone card on the Parallel screen has a **💾** button (the button strip now scrolls sideways when the
screen is narrow). It opens a menu:

| Item | What happens |
|---|---|
| 💾 নতুন ব্যাকআপ নিন | Force-stops the clone (so databases are consistent), then zips its data. |
| ♻️ ব্যাকআপ থেকে রিস্টোর | Lists the backups of that app (newest first, any space), asks to confirm, stops the clone, replaces its data. |
| 🗑️ ব্যাকআপ মুছুন | Lists the backups and deletes the chosen file after confirmation. |

A progress bar and a `done/total` file counter show on the status card while it works.

## File format (`CloneBackup.kt`)
- Name: `<package>_space<N>_<yyyyMMdd-HHmmss>.rzbak` (a normal zip).
- Place: `/sdcard/RizwanS2/Backups/` (all-files access is already asked for by the Parallel screen); if that is not
  writable, the app's own external folder `Android/data/<host>/files/backups/`. Both places are searched when listing.
- Inside: `meta.json` (package, label, space, versionName/Code, time) and the folders
  `i/` internal data, `d/` device-encrypted data, `e/` `Android/data/<package>` of the virtual storage.
- Not saved: `cache`, `code_cache`, `lib` (rebuilt / belongs to the installed APK) and symbolic links. The APK itself is
  **not** in the backup, so the app must be installed in the target space before restoring.

## Safety
- Backup is written to a `.part` file and renamed only when complete; failures delete the partial file.
- Free-space check before both backup and restore.
- Restore unpacks into `*.rzstage` folders first and swaps them in only after everything unpacked, so a full disk or a
  damaged file leaves the current data untouched. `lib` is never touched. Zip entries that try to leave the folder are rejected.
- A backup can be restored into another space of the same app (paths are stored relative to the clone).

## Test
1. Open a clone, create some data (log in / make a note). Back in Parallel tap 💾 → নতুন ব্যাকআপ. Check the toast path and that the `.rzbak` file exists.
2. Change or clear the data (🧹 or log out in the app). Tap 💾 → রিস্টোর → pick the backup → confirm. Open the clone: the old data is back.
3. Restore a backup of space 1 into the same app in space 2 (clone the app twice first).
4. Delete a backup from the same menu; the file disappears.
5. Try a restore with a renamed non-backup zip placed in the folder: it must not appear in the list.

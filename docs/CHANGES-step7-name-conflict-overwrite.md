# Step 7 — Same file name: Rename / Overwrite dialog

Changed files (app/src/main/kotlin/com/srizwan/win11/)
- BrowserUi.kt — `resolveNameConflict()` + `showNameConflictDialog()` (new); the Download dialog calls them after "Download"
- DlEngine.kt  — `nameTaken()`, `freeName()`, `overwriteOnce`, `DlTask.overwrite`, `deleteExisting()`

Behaviour
- After you press Download, the file name is checked against the save folder (Downloads or the folder you picked)
  and against downloads that are still running / paused with the same name.
- No clash: the download starts as before.
- Clash: "File already exists" dialog
  * Rename — the box is filled with a free name ("name (1).ext", "name (2).ext" ...). Edit it if you like and press
    Rename. If the new name also exists the check runs again.
  * Overwrite (red button) — the download starts; when it has finished completely the old file is deleted and the
    new one is saved under the original name. A failed or cancelled download therefore never destroys the old file.
    The old entry of that file disappears from the Downloads list.
  * Cancel — nothing is downloaded.
- Works for normal, blob and media-grabber downloads, and together with batch numbering (the number moves on after
  the clash is resolved).
- The overwrite choice is saved with the task, so it survives pause / resume / app restart.

Limits
- A file that belongs to another app and cannot be deleted by this app (Android 10+ without all-files access) is not
  overwritten; the new file then gets a " (1)" name. Files in a folder you picked, and files this app made, work.
- "Download again" from the list does not ask; it keeps the old behaviour.

Note: not compiled or run on a device in this session. Test: download the same file twice (Rename, then Overwrite),
once into Downloads and once into a picked folder.

# Step 6 — ".bin" file names fixed, own download folder, batch numbering

Changed files (app/src/main/kotlin/com/srizwan/win11/)
- BrowserUi.kt   — `guessDownloadName()` (new), `showDownloadDialog()` rewritten, two `URLUtil.guessFileName` calls replaced
- DlEngine.kt    — save folder + batch settings, `saveToTree()`, SAF-aware delete / rename / storage check, `DlTask.destTree`
- MainActivity.kt — `dlFolderLauncher` (system folder picker) + `dlFolderCallback`

1. ".bin" extension bug
   - Cause: `URLUtil.guessFileName` replaces a file's real extension with the one of the MIME type. GitHub release
     files arrive as application/octet-stream, so "Surah-045-4K.mp4" became "Surah-045-4K.bin".
   - Fix: `guessDownloadName()` takes the name from Content-Disposition (filename* / filename), then from the
     `response-content-disposition` query parameter (GitHub / S3 redirects), then from the URL path. The name's own
     extension is always kept; a MIME extension is added only when the name has none and the type is a real one.

2. Choose the download folder
   - The Download dialog shows "Saved to: ..." with a "Change" button (system folder picker, Storage Access
     Framework) and a "Default" button (back to Downloads). The choice is remembered for all later downloads
     (browser, blob, media grabber) and the permission is persisted.
   - Files are written into that folder (`DlEngine.saveToTree`); a name that already exists becomes "name (1).ext".
     If the folder permission is lost or the folder is gone, the file is saved to Downloads instead.
   - Delete, rename, open, share and the storage sync work for files in the picked folder too.
   - Android 11+ does not let apps pick the storage root or the Download folder itself; pick a sub-folder.

3. Batch numbering (000.mp3, 001.mp3, 002.mp3 ...)
   - Tick "Batch numbering" in the Download dialog. Fields: Prefix (optional) and "Start from".
     Zero padding = number of digits typed in "Start from" ("000" -> 3 digits). The extension comes from the file
     name field. A live line shows "Will save as: 000.mp3 (next: 001)".
   - After you press Download the number moves on by one and the tick stays on, so the next download's dialog
     already shows the next number. Change "Start from" any time; untick to go back to normal names.

Note: not compiled or run on a device in this session (no Android SDK here). Please build and test:
a GitHub release .mp4 (must stay .mp4), picking a folder, and three downloads in a row with batch numbering.

# Step 3 — Download manager: refresh the list with the storage

Changed files
- DlEngine.kt
  - `refreshFromStorage(onDone)` — background sync of every finished download with the real storage
    - file gone -> the entry is removed from the list (the file itself is never touched)
    - file renamed outside the app -> new name and path are taken over
    - file size changed -> real size is shown
    - "cannot tell" (no permission, provider error, no path) -> nothing is changed, so no false removals
  - `isFileMissing(task)` — quick check used before opening a file
  - a media row without its file is detected by trying to open the file descriptor
- DownloadsUi.kt
  - refresh button in the title bar (spins while syncing) and pull-down-from-top on the list
  - sync runs every time the Downloads screen opens
  - summary line under the filter chips: "N files · total size · free space"
  - toast when entries were removed ("... no longer in storage: removed from the list")
- BrowserUi.kt — `openDownloaded()` checks the file first; if it is gone: toast + list clean-up
- MainActivity.kt — `onResume()` re-syncs while the Downloads screen is visible (back from a file manager / gallery)

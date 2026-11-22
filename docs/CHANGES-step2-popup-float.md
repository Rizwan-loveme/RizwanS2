# Step 2 — Full-size popup, floating window, open as tab, background playback

New files
- app/src/main/kotlin/com/srizwan/win11/PopupPlaybackService.kt — foreground service (mediaPlayback) that runs while a popup is minimized
- app/src/main/res/drawable/ic_popup_minimize.xml, ic_popup_maximize.xml, ic_popup_restore.xml, ic_popup_tab.xml — title-bar icons

Changed files
- BrowserPopup.kt — rewritten around `PopupMode { DIALOG, FULL, FLOAT }`
  - title bar: Minimize · Full size / Restore · Open as tab · Close
  - FLOAT: small window above the whole app; drag by its header, resize with the corner grip, buttons Restore / Open as tab / Close
  - the same WebView is moved between modes, so the page keeps running
  - `expandPopupToTab()` moves the WebView into a normal tab (page, cookies and login are kept)
  - `updatePopupService()` runs PopupPlaybackService exactly while a popup is floating
  - floating popups are not paused on tab switch or when the app goes to the background; KEEP_ALIVE_JS stops pages from pausing video when they think they are hidden
- BrowserUi.kt — `addNewTab(url, switch, existing: WebView?)` can adopt an existing WebView
- AndroidManifest.xml — FOREGROUND_SERVICE_MEDIA_PLAYBACK permission and the PopupPlaybackService declaration

Notes
- The floating window stays inside the app (no overlay permission needed).
- Back key closes / steps back in dialog and full-size popups; floating popups do not take the Back key.

# Step 4 — window.open opens a new tab, per-tab pop-out icon, audio keeps playing in other tabs

## New files
- app/src/main/kotlin/com/srizwan/win11/BrowserMedia.kt — page "is playing" detection (MEDIA_HOOK_JS + AndroidMedia bridge), `mediaPlayingViews`, `onMediaStateChanged()`
- app/src/main/res/drawable/ic_tab_popout.xml, ic_tab_audio.xml — tab icons

## Changed
- BrowserPopup.kt
  - `openPopupWindow` replaced by `openWindowAsTab`: window.open() / target="_blank" now opens a NEW TAB (same WebViewTransport, so window.opener / postMessage / window.close() still work; no user gesture = blocked; burst limit; max 30 tabs). The new tab inherits desktop mode.
  - `popOutTab(tab)`: tab → floating popup (same WebView, page and audio keep running). If it is the only tab, a new Google tab is created first.
  - popup "Open as tab" keeps the desktop-mode flag (`BrowserPopup.desktop`); `BrowserPopup.owner` is now `var`.
  - dialog popups of other tabs and the app going to the background no longer pause a page that is playing; foreground service runs while a popup floats OR something plays.
- BrowserUi.kt
  - `WebTab.openerWebView / openedByScript / navigated`; `addNewTab(..., desktop, openerWebView)`
  - `TabChip`: pop-out icon + speaker icon (shown while that tab plays)
  - onCreateWindow → new tab; onCloseWindow closes a tab that a page opened; a tab opened only to start a download closes itself
  - `switchTab`: a hidden tab that is playing is NOT paused (KEEP_ALIVE_JS keeps the page from pausing itself)
  - `closeTab`: returns to the opener tab; fixes current index when an earlier tab is closed
- MainActivity.kt — `onPause` does not pause playing tabs
- PopupPlaybackService.kt — generic "playing in the background" notification

## Step 4b — audio keeps playing when the app goes to the background
- BrowserMedia.kt: `parkPlayingInBackground()` (Activity.onStop) moves every playing tab's WebView into a 1x1 px invisible TYPE_APPLICATION_OVERLAY window, `unparkFromBackground()` (onStart / onDestroy) moves it back. Dialog pop-ups that are playing are switched to floating. Pages that stop playing go back to sleep.
- MEDIA_HOOK_JS also tracks Web Audio (`AudioContext` in state "running").
- The "Display over other apps" question is now also asked (once per run) when sound starts and the permission is missing. Without the permission the audio can still stop in the background.
- MainActivity.kt: onStart / onStop / onDestroy call the new functions.

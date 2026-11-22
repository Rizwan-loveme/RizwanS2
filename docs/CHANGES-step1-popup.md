# Step 1 — Browser popups in a custom dialog

New file
- app/src/main/kotlin/com/srizwan/win11/BrowserPopup.kt — popup dialog (BrowserPopup), open/close/back/lifecycle helpers, `webViewFriendlyUa()`

Changed files
- BrowserUi.kt
  - `setSupportMultipleWindows(true)`
  - `WebChromeClient.onCreateWindow` -> `openPopupWindow()`
  - `switchTab()` -> `refreshPopupVisibility()`; `closeTab()` -> `closePopupsOf()`
  - mobile user agent without "; wv" / "Version/x.y" (Google sign-in rejects plain WebViews)
- MainActivity.kt
  - `popupWindows` list; `pausePopups()` / `resumePopups()` / `destroyAllPopups()` in onPause / onResume / onDestroy
  - Back button: closes (or steps back in) the top popup of the current tab first

Behaviour
- window.open() / target="_blank" opens a dialog over the browser area; the page below is not replaced.
- window.opener, postMessage and window.close() work (OAuth flows).
- Popups without a user gesture are blocked; max 3 popups per tab, max 3 opens in 3 seconds.
- A popup opened only to start a download closes itself when the download starts.
- Address bar of the popup shows the host (green = https, orange = not secure).
- Popups belong to their tab: hidden on tab switch, closed with the tab.

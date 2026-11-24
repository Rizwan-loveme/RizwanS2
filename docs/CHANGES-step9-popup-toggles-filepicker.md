# Browser pop-up — step 9: Keyboard / Touch toggles, file picker inside the pop-up, a pop-up never closes by itself

Request: two more icon-only toggle buttons in the browser pop-up (no text): **Keyboard** on/off and **Touch** on/off, colour blue = on, red = off. Keyboard off = the pop-up never brings up the keyboard; Touch off = touch inside the pop-up's page view is off. Also: opening the (system / file) file opener must not hide or destroy the pop-up, and the pop-up must not close by itself for any reason.

Steps (each ticked when done):
- [x] 1. Read `BrowserPopup.kt` (title bar, floating header, keyboard code of step 5, lifecycle), `BrowserUi.kt` (tab file chooser, `closeTab`), `MainActivity.kt` (`fileChooserLauncher`, `onPause` / `onDestroy`), the manifest (`configChanges`)
- [x] 2. Two vector icons: `ic_popup_keyboard.xml`, `ic_popup_touch.xml` (same stroke style as the other `ic_popup_*`, rendered and looked at)
- [x] 3. Toggles in both bars (dialog / full title bar and the floating header), state per pop-up, kept across DIALOG / FULL / FLOAT
- [x] 4. File picker inside the pop-up (it had none)
- [x] 5. Every automatic close removed
- [x] 6. Static checks, docs, full flat zip

## 1. The two toggles (`BrowserPopup.kt`)
| | Where | On (blue `#4CC2FF`) | Off (red `#FF5252`) |
|---|---|---|---|
| Keyboard (vector keyboard icon, no text) | title bar (36 dp button, 17 dp icon) and floating header (27 dp, 13 dp), left of the existing buttons | as before: tapping a field opens the keyboard (floating overlay: the step 5 focus switch) | the keyboard is hidden at once and **cannot open**: the page view is made unfocusable (`isFocusable = false`, `isFocusableInTouchMode = false`), so no input connection can attach to it, also for a field the page focuses by itself (`autofocus`, `.focus()`); in a floating overlay window `enterTyping()` returns early, so the window stays non-focusable (touch outside / Back go to the app below, as for any floating window) |
| Touch (vector hand icon, no text) | next to it | normal | every touch on the page view is swallowed by one touch gate (`installTouchGate()`: returns true), so no scroll, tap, zoom or long press; the touch that is in progress is cancelled with a synthetic `ACTION_CANCEL`. The header buttons, dragging the header and the resize grip still work, so the window can always be moved, restored or closed |

- Order of the buttons now: [Keyboard] [Touch] [Minimize] [Full size / Restore] [Open as tab] [Close]; floating header: [Keyboard] [Touch] [Restore] [Open as tab] [Close]. The title / host text gets about 20 dp less in the title bar (a 360 dp phone still leaves roughly 90 dp, shortened with an ellipsis).
- The state belongs to the pop-up object, so minimize / restore / full size keep it; both bars show the same colour (`paintToggles()`). Both start **on**. They are not remembered for the next pop-up and not after the app restarts (say if you want that).
- Accessibility text (not shown): "Keyboard on" / "Keyboard off", "Touch on" / "Touch off".
- "Open as tab" (popup -> tab) gives the page its normal focus back (`detachWebView()` sets focusable again) and removes the touch gate, so a tab is never left without keyboard or touch.
- The old touch listener of the floating window (keyboard focus on touch) is now part of the touch gate; there is one listener for all three modes (before, DIALOG / FULL had none).

## 2. File opener inside a pop-up
- **Found:** the WebChromeClient of a pop-up had no `onShowFileChooser`, so `<input type=file>` did nothing there (only tabs had the picker).
- `BrowserUi.kt`: the body of the tab's `onShowFileChooser` moved unchanged into `MainActivity.openFileChooser(callback, params)`; the tab's client now calls it. Pop-ups call the same function: own :chooser picker with accept types / multiple / Camera button, `capture` goes to the built-in camera, fallback to the system GET_CONTENT screen. The result still arrives in `fileChooserLauncher` (MainActivity), which answers the page's callback.
- A floating pop-up in an **overlay window** may be on screen while the app is in the background: `bringAppToFront()` runs first (as for Restore / Open as tab), then the picker opens.
- The pop-up is not touched while the picker is open: `pausePopups()` does nothing while a file picker is pending (`fileUploadCallback != null`), so a dialog / full pop-up is not paused or hidden when the app goes to the picker and comes back. A floating pop-up was never paused. An overlay pop-up stays on top of the picker (move it by its header if it covers something).

## 3. A pop-up no longer closes by itself
Every automatic path found in the code:
| Was | Now |
|---|---|
| `window.close()` of the page (`onCloseWindow`) closed the pop-up | ignored (a line in the log); only the Close button / Back (dialog / full) close it |
| a pop-up that "had not navigated" closed itself when a download started | removed (this case cannot happen any more: pop-ups only come from "pop out" / "restore" of a tab with a page) |
| closing the tab that owns the pop-up closed the pop-up too (`closePopupsOf`) | replaced by `reassignPopupsOf(tab, newOwner)`: the pop-ups move to the tab that is shown next (`closeTab` in `BrowserUi.kt`) |
| `pausePopups()` while a picker was open | skipped (section 2) |
User actions that still close it: its Close button, Back on a dialog / full pop-up, and leaving the app for good.

**What cannot be prevented (honest limit):** if Android kills the app process (memory pressure while the picker or another app is in front) or `MainActivity` is destroyed, `onDestroy` releases the pop-ups, as before. The activity handles rotation / size changes itself (`configChanges` in the manifest), so those do not destroy it. A crash of the WebView renderer is not handled here either.

## Files
- changed: `app/src/main/kotlin/com/srizwan/win11/BrowserPopup.kt`, `BrowserUi.kt`
- new: `app/src/main/res/drawable/ic_popup_keyboard.xml`, `ic_popup_touch.xml`, `docs/CHANGES-step9-popup-toggles-filepicker.md`
- docs: `README.md` (section "Browser pop-ups — step 9")
- not touched: `MainActivity.kt`, manifest, Gradle files, workflows, the Seal module

## Checked here
XML of the two icons parses and both were rendered to an image and looked at; brackets of the changed Kotlin files balanced (whole-project script: 0 new reports); every import the new code needs is present (`ValueCallback`, `SystemClock`, `MotionEvent`, `InputMethodManager`); `fileUploadCallback` / `fileChooserLauncher` are `internal` in `MainActivity`; the only call site of the removed `closePopupsOf` is replaced; resource names `ic_popup_keyboard` / `ic_popup_touch` exist once.
**Not built or run** (no Android SDK / Gradle here). Test on a phone: (1) tap Keyboard (red), tap a text field in the pop-up: no keyboard; blue again: keyboard opens; (2) the same in a minimized overlay window over another app; (3) tap Touch (red): the page does not scroll or react, header buttons / drag / resize still work; (4) in a pop-up open a page with an upload button: the picker opens, choose a file, the pop-up is still there and the page got the file; (5) close the tab the pop-up was made from: the pop-up stays.

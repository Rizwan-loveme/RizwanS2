# Step 5 — Keyboard in the floating pop-up (pop-out window)

Changed file
- app/src/main/kotlin/com/srizwan/win11/BrowserPopup.kt

Problem
- The pop-out window (FLOAT) is a system overlay window when "Display over other apps" is allowed. It was created
  with FLAG_NOT_FOCUSABLE, so Android never opened the soft keyboard in it (no typing in login / search fields).

Fix
- Overlay mode: touching the page makes the window focusable (`enterTyping`), the keyboard opens
  (`onOverlayFocused`), and the window moves to the top of the screen so the keyboard does not cover it.
  Touch outside the window, Back, or another app taking focus ends typing (`leaveTyping`): keyboard hidden, window
  non-focusable again (so touches / Back reach the app below), old position restored.
- New private view `FloatFrame` reports window focus, outside touches (FLAG_WATCH_OUTSIDE_TOUCH) and Back.
- In-app mode (no overlay permission): the activity window already has focus; the floating window now follows the
  shrunken app area (adjustResize) so the keyboard does not hide it (`fitInAppFloat`).
- Dialog / full-size popups were not affected.

Note: not compiled or run on a device in this session; test on a phone with and without the overlay permission.

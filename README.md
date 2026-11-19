# Win11
## Windows-style Quick Settings & Notification Center

A Quick Settings shortcut (gear / notification glyph) is added to the taskbar. It opens a Windows-inspired control panel with Wi-Fi and Bluetooth settings, Location, ring modes, display/rotation settings, volume controls, Airplane Mode settings, flashlight toggle, Power Popup (Android 5.0+; requires enabling the app's Accessibility service), and a Windows-style notification center: live list of the phone's dismissible notifications grouped by app (app icon, title, text, time), tap to open, ✕ to dismiss, Clear per app and Clear all (these dismiss on the phone too). It needs Notification access to be turned on for the app.

Android security restrictions apply: Wi-Fi/Bluetooth/Location/Airplane Mode and rotation controls open the relevant system settings rather than silently changing protected system state. Screen recording works from the panel's recorder tile: Android's system screen-capture consent dialog appears first (it cannot be skipped), then the whole screen is recorded (optionally with microphone audio) and saved to Movies/RizwanS2; tap the tile again or the notification's Stop action to finish. Screenshot: with the "Win11 Power and Lock" Accessibility service enabled (Android 9+) it is a single tap; otherwise Android's system screen-capture consent dialog appears and a PNG is saved to Pictures/RizwanS2. Nothing is captured silently. The flashlight turns on at the brightest level the device reports (Android 13+ devices that expose torch strength); other devices use plain on/off. The tile reflects the real torch state.

## Debug & crash log (v2.0.1)

The app now keeps its own log so problems can be diagnosed on the phone itself:

- **View it:** Quick Settings (gear at the left of the taskbar) → *Debug log* tile → Refresh / Copy / Share / Clear.
- **File location:** `Android/data/com.srizwan.win11/files/logs/app.log` (rotates at 512 KB; `app.old.log` is the previous one).
- **Crashes:** any uncaught exception is saved and shown in a dialog the next time the app opens, with a button to open the full log.
- **Startup is fault-tolerant:** every startup step is guarded. If one screen (Files / Browser / Phone / Messages) fails to build, a small error panel replaces it and the rest of the app still opens. If the whole UI fails, an on-screen "Startup error" page shows the stack trace with *Open log* and *Retry*.
- Logcat tag prefix: `Win11/` (e.g. `adb logcat -s Win11/Main Win11/Quick Win11/CRASH`).

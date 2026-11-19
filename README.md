# Win11
## Windows-style Quick Settings & Notification Center

A Quick Settings shortcut (gear / notification glyph) is added to the taskbar. It opens a Windows-inspired control panel with Wi-Fi and Bluetooth settings, Location, ring modes, display/rotation settings, volume controls, Airplane Mode settings, flashlight toggle, Power Popup (Android 5.0+; requires enabling the app's Accessibility service), and a Windows 11 style notification center: live list of the phone's dismissible notifications grouped by app (app icon + name in a group header, rounded bordered cards with title, time and message), tap a card to open it, vector X to dismiss, collapse/expand arrow per app group, Show more / Show less when a group has more than 3, Clear per app and a Clear all pill (these dismiss on the phone too), and an empty state with a bell icon. Below the notifications sits a Win11-style calendar: today's full date, a month grid with the current day highlighted, and up/down arrows to change the month (tap the month title to jump back to today). All icons are vector drawables, no emoji. **Glass UI:** the panel uses a translucent theme (Theme.Win11.Glass) so the screen behind shows through, with real background blur on Android 12+ devices that support it, and frosted rounded tiles and cards with a thin light border. **Do Not Disturb:** the bell at the top of the notification section turns pop-ups and sounds off (the bell changes to a slashed bell and a note appears); notifications are still collected in the center. **Toast:** a new chat message slides in as a glass card at the top right with the app icon, name, sender and message, fades after 5 seconds, tap opens the notification center, X dismisses it. It needs Notification access to be turned on for the app.

Android security restrictions apply: Wi-Fi/Bluetooth/Location/Airplane Mode and rotation controls open the relevant system settings rather than silently changing protected system state. Screen recording works from the panel's recorder tile: Android's system screen-capture consent dialog appears first (it cannot be skipped), then the whole screen is recorded (optionally with microphone audio) and saved to Movies/RizwanS2; tap the tile again or the notification's Stop action to finish. Screenshot: with the "Win11 Power and Lock" Accessibility service enabled (Android 9+) it is a single tap; otherwise Android's system screen-capture consent dialog appears and a PNG is saved to Pictures/RizwanS2. Nothing is captured silently. The flashlight turns on at the brightest level the device reports (Android 13+ devices that expose torch strength); other devices use plain on/off. The tile reflects the real torch state.

## Quick Settings flyout (v2.1.0)

- **Windows 11 layout, docked to the right** just above the taskbar. **Notifications and calendar are on top, Quick Settings are at the bottom** (tiles, then brightness and volume sliders). There is no close button: tap anywhere outside the panel (or press Back) to dismiss it. The tray clock opens it (the taskbar gear is hidden).
- **Win11 sliders:** a brightness slider and a volume slider (tap the speaker icon to mute / unmute). The volume slider follows the hardware volume keys.
- **Tiles show real state** (accent fill when on): Wi-Fi, Bluetooth, Airplane, Location, Auto-rotate, Flashlight, Normal / Vibrate / Silent, Screen recorder.
- **Settings are applied automatically where Android allows it:**
  - Brightness and Auto-rotate: allow **Modify system settings** once. The app asks, opens the right screen, and finishes the action when you come back.
  - Silent mode: allow **Do Not Disturb access** once (same flow).
  - Wi-Fi: switched directly on Android 9 and older; Android 10+ shows the system Internet panel (apps cannot toggle Wi-Fi there).
  - Bluetooth: switched directly up to Android 12L (asks for *Nearby devices* once); Android 13+ shows the system "turn on Bluetooth" prompt.
  - Location: switched directly once you run `adb shell pm grant com.srizwan.win11 android.permission.WRITE_SECURE_SETTINGS` a single time; otherwise it opens Location settings.
  - Airplane mode: opens the system screen (Android only lets system apps switch radios).
- **Start search fix:** with the keyboard open the Start panel now shrinks to the free space (search box stays visible) and turns more opaque while searching.
- **Glass everywhere:** the popup menus (Start / app long-press / Messages long-press) are now glass `GlassMenu` cards, the remaining system dialogs are `W11Dialog`, all search boxes (Start, Contacts, Messages, in-file search) use the same glass pill, and text fields inside dialogs are glass too. The text viewer is dark glass.

## Debug & crash log (v2.0.1)

The app now keeps its own log so problems can be diagnosed on the phone itself:

- **View it:** Quick Settings (tap the tray clock at the right of the taskbar) → *Debug log* tile → Refresh / Copy / Share / Clear.
- **File location:** `Android/data/com.srizwan.win11/files/logs/app.log` (rotates at 512 KB; `app.old.log` is the previous one).
- **Crashes:** any uncaught exception is saved and shown in a dialog the next time the app opens, with a button to open the full log.
- **Startup is fault-tolerant:** every startup step is guarded. If one screen (Files / Browser / Phone / Messages) fails to build, a small error panel replaces it and the rest of the app still opens. If the whole UI fails, an on-screen "Startup error" page shows the stack trace with *Open log* and *Retry*.
- Logcat tag prefix: `Win11/` (e.g. `adb logcat -s Win11/Main Win11/Quick Win11/CRASH`).

## Glass UI and vector icons (latest)

- **No emoji anywhere:** every emoji and symbol glyph used as an icon (phone, contacts, recent calls, torch, zip, download, warning, play/pause, close, refresh, settings, orientation buttons, etc.) is now a vector drawable (`ic_w_*`, plus the existing `ic_qs_*`) set through the `Ico.kt` helpers (`iconOnly`, `iconStart`). Toasts and list items that only had a leading emoji now show plain text. `W11Dialog.Builder.setIcon()` puts a vector icon before a dialog title.
- **Full glass look:** the main window draws the wallpaper bloom behind a translucent taskbar; the Start menu, search boxes, dialogs (frosted card, light border, blur behind on Android 12+ devices that support it), the Quick Settings / Notification panel, the Notification settings screen and the toast card all use translucent surfaces with a thin light border. Android 8.0 uses an opaque dark window instead of a translucent one (platform crash with locked orientation).

## Deep link (rizwans2://)

The launcher opens from links that use the custom scheme `rizwans2://` (no domain needed):

- `rizwans2://open` opens the desktop; `files`, `browser`, `sms`, `start` and `quick` open that screen (`dialer` opens the system Phone app) (e.g. `rizwans2://quick` opens Quick Settings; `rizwans2://calculator` opens the Calculator).
- Works from an HTML link (`<a href="rizwans2://open">`), another app, or `adb shell am start -a android.intent.action.VIEW -d "rizwans2://open"`.
- Plain browser address bars treat it as a search, so a typed `rizwans2://open` may not launch; use a link on a web page instead.

## Calculator (built-in)

A built-in **Calculator** app appears in Start (pinned after Notifications) and in All apps. Floating glass panel docked above the taskbar (like the Quick Settings flyout; tap outside it to close) with vector icons only, centered in their keys: digits, `+ - × ÷`, `%` (`200 + 10%` = 220), `±`, backspace (long-press = clear), `C`, `=`, a live result preview line, divide-by-zero error, and hardware-keyboard support. Code: `CalculatorActivity.kt`.

## Taskbar toggle, centered icons, glass Phone / Messages

- **Taskbar toggle (Windows 11 behaviour):** tapping a pinned taskbar app that is **not** open opens it; tapping the one that is **already in front** minimizes it back to the desktop (its state, e.g. an open conversation or browser tabs, is kept). Opening an app from the Start menu or the desktop never minimizes. Code: `Win11Shell.onMinimize` (set in `MainActivity`).
- **Centered icons:** icon-only buttons (and icon + text buttons with centered text) used to draw their vector icon at the left edge. `Ico.kt` now centers them (`iconOnly` / `iconStart` add a layout listener; wrap_content views are untouched). This fixes the Calculator keys and the Phone buttons (backspace, contacts, Call, call-back).
- **Glass Phone & Messages:** both screens were made translucent (the Phone screen is now hidden, see below) (glass bars, cards, keys with a thin light border and ripple; sent / received bubbles and the composer too) and the wallpaper bloom shows through behind them. The other sections keep their solid backgrounds.

## System Phone instead of the built-in Phone

- **Phone now opens the device's own Phone (dialer) app** from the taskbar Phone icon, the desktop Phone icon, the Start menu / All apps and `rizwans2://dialer`. The icon is unchanged: the same green built-in phone vector, in the taskbar, on the desktop and in Start (the system Phone app is listed as "Phone" with that icon).
- **The built-in Phone screen is hidden** (no entry in Start / All apps, no taskbar switch). Its code (`createDialerView`, recent calls, contacts picker) is kept in `MainActivity.kt` but is never shown.
- **Messages:** "Call" in a conversation (header phone button and the long-press menu) opens the system dialer with that number pre-filled (`ACTION_DIAL`, nothing is called until you press call there).
- **Existing installs:** if the built-in Phone was pinned in Start, that pin is moved to the system Phone app at the same position (a hidden built-in Phone becomes a hidden system Phone). The system Phone app is the device's default dialer (`TelecomManager.getDefaultDialerPackage`, falling back to whatever handles `ACTION_DIAL`).
- Since the Phone is an external app, it has no "running" dot on the taskbar and tapping its icon always opens it (the minimize toggle applies to Files, Browser and Messages).

# Win11
## BlackBox engine added: Parallel manager + working "Open in black box" (v2.2.8)

The `ParallelRizwan` project (BlackBox engine + manager UI) is now part of this project.

- **New modules** (copied unchanged from `ParallelRizwan`): `:Bcore` (BlackBox virtual-space engine, Java + native code built with `ndkBuild`), `:black-reflection`, `:compiler`. Licence and changes: `LICENSE-BlackBox` (Apache 2.0) and `NOTICE-BlackBox.md` (engine taken from NewBlackbox; logcat upload to a third-party server removed; `ClientConfiguration.getLogSenderChatId()` returns an empty string, and `App` overrides it too).
- **"Open in black box (parallel)"** (long-press menu, see below) now really works: `ParallelApps.open()` -> `Engine.openOrClone(pkg)`: waits for the engine, uses the space that already holds the app or clones it into the first free space (also installs Google Play Services support when the phone has it), then starts it.
- **New Start app "Parallel"** (built-in, violet copy icon; also `rizwans2://parallel`): the manager screen from `ParallelRizwan`: list of all copies, start, clear data, remove, and **clone an app** with a search picker. It asks for the permissions cloned apps need (runtime permissions, all-files access, display over other apps, notifications). Code: `parallel/ParallelActivity.kt`, `parallel/ParallelEngine.kt` (`Engine`), `parallel/ParallelUi.kt`, package `com.srizwan.win11.parallel` (own package so its small UI helpers `dp`, `tv`, `Palette` do not clash with the launcher's). Up to 10 copies (spaces).
- **`App.kt`:** attaches the engine in `attachBaseContext` and calls `doCreate()` in `onCreate`. `App` also runs in every cloned-app process (`:black`, `:p0`, ...), so `AppLog` and the crash handler start **only in the launcher's own process** (process name == package name).
- **Manifest:** `android:extractNativeLibs="true"`, `android:largeHeap="true"`, new `ParallelActivity`. The engine's own manifest (stub activities / services / providers for cloned apps) is merged automatically.
- **Build changes (important):** the engine is not compatible with AGP 9, so the whole project is now on **AGP 8.13.2, Gradle 8.14.3, Kotlin plugin 2.2.10** (Kotlin is no longer built in, so `id("org.jetbrains.kotlin.android")` is applied in `:app`; with AGP 9 it must be removed again). `compileSdk` / `targetSdk` stay 37 (`android.suppressUnsupportedCompileSdk=36,37,37.0`). Java / Kotlin target 21 (JDK 21), NDK `29.0.13846066`, `jniLibs.useLegacyPackaging = true`, JitPack added for FreeReflection. The workflows already used JDK 21 and install the NDK + API 37; their wrapper fallback is now Gradle 8.14.3. `gradle-wrapper.properties` -> 8.14.3. Root `build.gradle.kts` holds `compileSdkVersion`, `targetSdkVersion`, `minSdk`, `ndkVer` for the Groovy engine modules.
- **Not verified here:** this was integrated without a network, so it was **not compiled**. First build on GitHub: expect the build to take longer (native code). If it fails, send the log. Things to check on a device: that the engine works with `targetSdk` 37 (the original Parallel README says the engine prefers `targetSdk` 28), the clone + start of a real app, and that the launcher itself still behaves as before after the AGP downgrade.
- **Limits of this kind of engine:** apps that detect virtual spaces (banking, some games, Play Integrity / Google login) may not work; pictures messages, notifications and some permissions of cloned apps can behave differently; the engine can break on new Android versions. The cloned app's data lives inside this app (clearing this app's data removes the copies).
- Changed files: `build.gradle.kts`, `settings.gradle.kts`, `gradle.properties`, `gradle/wrapper/gradle-wrapper.properties`, `app/build.gradle.kts` (versionCode 114, versionName 2.2.8), `app/src/main/AndroidManifest.xml`, `App.kt`, `ParallelApps.kt`, `StartApps.kt`, `MainActivity.kt`, `README.md`, `.github/workflows/UltimateBuild.yml`, `UltimateBuild0.yml`; new: `Bcore/`, `black-reflection/`, `compiler/`, `LICENSE-BlackBox`, `NOTICE-BlackBox.md`, `.gitignore`, `parallel/*.kt`.

## Parallel apps: "Open in black box (parallel)" (v2.2.7, engine added in v2.2.8)

- **Long-press any app** in Start (Pinned, Recent) or All apps: the menu has **Open in black box (parallel)** (not for built-in apps). It starts a second copy of that app in a virtual space, with its own data and accounts. The first time, the app is copied into the space in the background ("Preparing ... in the black box"), then it starts; later taps just start the copy. Start closes after the tap.
- *(v2.2.7 note, no longer true:)* the engine was first called by reflection and was not bundled. Since v2.2.8 the BlackBox engine is part of the project (see the v2.2.8 section above) and `ParallelApps.kt` calls it directly.
- Code: `ParallelApps.kt`, `Win11Shell.kt` (`showAppMenu`, `showRecentMenu`, `showPinMenu`, `openParallel`). Other menu entries are unchanged.
- Changed files (v2.2.7): new `ParallelApps.kt`; `Win11Shell.kt`, `README.md`, `app/build.gradle.kts` (versionCode 113, versionName 2.2.7).

## Own pop-up look per app: style, colour, time, position, on/off (v2.2.6, part 10 of 10)

- **Settings > Notifications > "Pop-up per app":** one card for WhatsApp (and for every app later added to `NotifPrefs.customAlertApps`) and one card, **All other apps**, for every app without its own look. Each card has:
  - **Show pop-ups from this app** (app cards only): the same switch as in the app list; it covers all of the app's packages (`com.whatsapp`, `com.gbwhatsapp`) and the list rows and this switch stay in step.
  - **Style:** Glass (the original card), Solid (opaque dark), Light (white card, dark text), Compact (one slim row: icon, sender, one line of text).
  - **Accent colour:** Default (no accent) or Blue, Green, Amber, Red, Purple, Pink, plus the app's own colour. An accent gives the card a 2dp border and colours the app name (Compact: the sender).
  - **Stays for:** 2, 3, 5, 8, 12 seconds or **Until dismissed** (stays until you tap the card or the X).
  - **Position:** Top right, Top center, Top left, Bottom right, Bottom center, Bottom left. The card slides in from the edge it sits on. Inside the launcher bottom positions sit above the taskbar.
  - **Preview** shows the pop-up with the saved look right in the settings screen (also after every style, colour or position change). **Reset to default** restores glass, no accent, 5 seconds, top right.
- **Both modes work:** the same saved look is used by the card inside the launcher (`GlassToast.show`) and by the card drawn over other apps (`GlassToast.showOverlay`, needs *Display over other apps*). The look is read from the package that posted the notification (`NotifPrefs.popupStyleFor(ctx, pkg)`), so no call site changed. The system Toast fallback (no overlay permission) has no custom look.
- **Defaults equal the old pop-up exactly:** glass card, top right, 5 seconds, no accent. Nothing changes until you pick something.
- **Saved per profile** in `notif_settings`: `pop_style_<id>`, `pop_color_<id>` (ARGB, absent = none), `pop_dur_<id>` (ms, `0` = until dismissed), `pop_pos_<id>`. `<id>` is the app profile id (for example `whatsapp`) or `default`. An invalid saved value falls back to the default.
- **Add another app with the same settings:** put its `NotifApp` into `NotifPrefs.customAlertApps` (for example `apps[2]` for Messenger). Its sound, vibration and pop-up cards, saved keys and playback all follow that list; no other code changes.
- Code: `PopupStyle`, `PopupOption`, `PopupDuration`, `PopupColor`, `NotifPrefs.getPopupStyle / setPopup... / resetPopup / popupStyleFor` in `NotificationSettings.kt`; `GlassToast.kt` (style palette, positions, duration, both modes); `buildPopupCard()` and helpers in `NotificationSettingsActivity.kt`.
- Changed files: `GlassToast.kt`, `NotificationSettings.kt`, `NotificationSettingsActivity.kt`, `README.md`, `app/build.gradle.kts` (versionCode 112, versionName 2.2.6).

## Own sound and vibration per app, WhatsApp first (v2.2.5, part 9 of 10)

- **Settings > Notifications > "Sound & vibration per app":** a card for WhatsApp with **Sound** (the system notification-sound picker: Default, Silent, any installed or added sound), **Vibration** (Default, Off, Short, Long, Double, Triple, Heartbeat; picking one vibrates once as a preview), **Preview** (plays the app's sound + vibration whatever the ring mode is) and **Reset to default**.
- **Saved per app:** `snd_<id>` (absent = default sound, `silent`, or a sound URI) and `vib_<id>` (pattern id) in `notif_settings`. WhatsApp's packages (`com.whatsapp`, `com.gbwhatsapp`) share one profile.
- **How it plays (`NotifPrefs.feedback(ctx, pkg)`):** Ring mode = the app's sound (needs *Play notification sound* on; Silent = no sound) plus its vibration pattern if one is chosen. Vibrate mode = the pattern (Default = the old short buzz). Mute = nothing. Vibration **Default** keeps the old behaviour (vibrates in Vibrate mode only); **Off** never vibrates. Apps without a profile use the general settings exactly as before.
- **Add another app with the same settings:** put its `NotifApp` into `NotifPrefs.customAlertApps` (for example `apps[2]` for Messenger). The card, the saved keys, the picker and the playback follow that list; no other code changes.
- The pop-up path passes the package everywhere: the in-launcher card (`MainActivity` chat receiver) and the over-other-apps card (`NotifPrefs.alert`).
- Changed files: `NotificationSettings.kt`, `NotificationSettingsActivity.kt`, `MainActivity.kt`, `README.md`, `app/build.gradle.kts` (versionCode 111, versionName 2.2.5).

## Notification settings: fast app list (v2.2.4, part 8 of 10)

- **RecyclerView:** the per-app list in Settings > Notifications is now a `RecyclerView` instead of one view per installed app inside a `ScrollView`. The whole page is one list: header (access, security, master switch, overlay, search, Turn all on / off), the app rows, and a footer (sound, test button, note). Only the rows on screen exist as views and they are recycled while you scroll.
- **Lazy icons:** the app list (name + package) loads in the background first; icons are loaded only when a row appears, on a 2-thread pool, converted to a small bitmap and kept in an `LruCache` (about 1/16 of the app's memory limit). A recycled row never shows another app's icon (checked by tag).
- **Search** filters by name or package and updates the list with `DiffUtil` (the search box keeps its focus and keyboard); the counter shows `N of M apps`.
- **Turn all on / Turn all off** still change every installed app (not only the filtered ones), saved as `pkg_<package>`.
- **Master switch** off dims and disables all app switches, also for rows scrolled into view later.
- Behaviour of saved settings (`NotifPrefs`) is unchanged.
- Changed files: `NotificationSettingsActivity.kt`, `README.md`, `app/build.gradle.kts` (versionCode 110, versionName 2.2.4).

## Default SMS app: send and receive properly (v2.2.3, part 7 of 10)

- **Default SMS app role:** Messages shows a banner "Make this your default SMS app..." while the app is not the default. Tap it: Android 10+ uses `RoleManager` (`ROLE_SMS`), older versions use `Telephony.Sms.Intents.ACTION_CHANGE_DEFAULT`. The banner disappears once the role is held. Code: `SmsRole`, `smsRequestDefaultRole()` in `SmsDefault.kt`.
- **Incoming SMS (`SmsDeliverReceiver`, `SMS_DELIVER`):** writes each incoming SMS to the provider (inbox, unread), then shows its own system notification (channel `sms_incoming`, only when the launcher is not in front) and the glass pop-up (inside the launcher or over other apps). Nothing depends on another app's notification any more; the Messages screen refreshes through its provider observer.
- **Sending (`smsSendAndRecord`):** as default app the message is written to the provider as Outbox, sent, and `SmsSentReceiver` turns it into Sent (or Failed with the error code). Multi-part messages are handled. When another app is the default, sending works as before (the just-sent bubble is kept locally).
- **Chat bubbles:** Sent, Outbox, Failed and Queued messages are all drawn as outgoing (right side), so a message being sent does not flip to the left.
- **`RespondViaMessageService` (`RESPOND_VIA_MESSAGE`):** "reject call with message" sends the reply as SMS and records it.
- **`MmsDeliverReceiver` (`WAP_PUSH_DELIVER`):** required for the SMS role. **MMS (picture messages / group MMS) is not downloaded or shown by this app**: while it is the default SMS app, incoming MMS are not received. If you need MMS, keep another app as the default.
- **`sms:` / `smsto:` / `mms:` / `mmsto:` links** (`ACTION_SENDTO`) open the New message dialog with the number (and `sms_body`) filled in.
- New permissions: `RECEIVE_MMS`, `RECEIVE_WAP_PUSH`. New icon: `ic_stat_sms`.
- Changed files: new `SmsDefault.kt`; `SmsUi.kt`, `MainActivity.kt`, `AndroidManifest.xml`, `res/drawable/ic_stat_sms.xml`, `README.md`, `app/build.gradle.kts` (versionCode 109, versionName 2.2.3).

## Faster SMS conversation list (v2.2.2, part 6 of 10)

- The conversation list no longer reads every SMS of the phone. It reads **one row per thread** from `content://mms-sms/conversations?simple=true` (thread id, date, snippet, recipient), sorted newest first.
- **Unread badges** come from a small query on unread rows only (`read = 0`), counted per thread; the "opened after" rule (`smsReadAt`) is kept.
- **Paging kept (20 per page):** only the rows of the shown page are resolved (address, newest body, type via a `thread_id = ? ... LIMIT 1` query), then contact names are looked up. Next pages load on scroll. MMS-only threads get their address from `mms-sms/canonical-addresses`.
- **Search** uses a filtered query (`address LIKE ? OR body LIKE ?`) grouped by address, as before. If a device does not support the threads table, the old scan (now filtered, with `thread_id`) is used automatically.
- Code: `smsLoadThreadStubs()`, `smsResolveStubs()`, `smsLoadByScan()`, `refreshSmsView()`, `smsLoadMoreConversations()` in `SmsUi.kt`; `SmsConversation` got `threadId`, `recipientId`, `resolved`. Nothing else changed (list, live refresh, thread view, send, delete, search behave the same).
- Changed files: `SmsUi.kt`, `README.md`, `app/build.gradle.kts` (versionCode 108, versionName 2.2.2).

## Code structure: MainActivity split into files (v2.2.1, parts 1-5 of 10)

No behaviour change. `MainActivity.kt` (4823 lines) is now ~1100 lines; the rest moved to:

| File | Content |
|---|---|
| `NotificationListener.kt` | `WhatsAppNotificationListener` (notification pop-ups for every app) |
| `PhoneUi.kt` | dialer, contact picker, recent calls |
| `SmsUi.kt` | SMS list / thread / live refresh / compose / send / delete, plus `SmsConversation`, `SmsItem`, `SmsMessage` and the RecyclerView adapters |
| `FileManagerUi.kt` | file manager, text / image / PDF / video viewers, zip, file PiP |
| `BrowserUi.kt` | tabs (`WebTab`, `TabChip`), WebView setup, custom URL schemes, downloads |

How it works: the moved functions are Kotlin extension functions of `MainActivity` (`internal fun MainActivity.xxx()`); all state (fields) stays in `MainActivity`, whose `private` members became `internal` so the new files can use them. Inner adapters became top-level classes that take the activity (`SmsThreadAdapter(act)`). `act` is `this`; `xxxInit` properties wrap `::xxx.isInitialized`.

## Realtime messages, all-app notification pop-ups, one Ring / Vibrate / Mute button (v2.2.0)

- **Realtime Messages (SMS):** the Messages screen now updates by itself the moment an SMS arrives or is sent, with no manual refresh.
  - Two triggers, both debounced: a `ContentObserver` on `content://sms` and the `SMS_RECEIVED` broadcast (registered in `onStart`, removed in `onStop`).
  - *Conversation list:* new preview text, unread badge and newest-on-top order refresh live.
  - *Open chat:* only the newest page is merged in (older pages stay, no reload, no flicker). If you are at the bottom it scrolls to the new message like a chat app; if you scrolled up to read history it does not jump. An incoming message in an open chat is marked read.
  - The just-sent bubble (`SmsMessage.local = true`) is kept until the SMS provider has the same message, so it does not vanish on phones where this app is not the default SMS app.
  - Coming back from the background catches up on anything received meanwhile. Code: `registerSmsLive()`, `smsLiveRefresh()`, `smsMergeLatest()` in `MainActivity.kt`.
- **Pop-ups from every app (not only chat apps):** `WhatsAppNotificationListener` now shows the glass pop-up for any app's notification (WhatsApp, Messenger, Gmail, SMS, ...).
  - Skipped on purpose: this app's own notifications, ongoing / foreground-service, media (transport), progress, system / status, group summaries, and silent (low-importance) notifications. A re-post with the same title and text (progress or counter updates) does not pop up twice. Notifications already showing when the listener connects do not pop up again.
  - Launcher in front: the glass card slides in inside the launcher (`GlassToast.show`). Launcher in background: the same glass card is drawn over the other app (`GlassToast.showOverlay`) when **Display over other apps** is allowed; otherwise a normal system toast is used. Tap opens the notification center, X dismisses, auto-hides after 5 seconds.
- **Notification on / off system (Settings > Notifications screen):**
  - **Show notification pop-ups**: master switch for everything.
  - **Do Not Disturb**: the bell in the notification center (no pop-ups, no sound; notifications are still collected).
  - **Per-app switch for every installed app**: real app icon, name and package, search box, *Turn all on* / *Turn all off*. Stored as `pkg_<package>` in `notif_settings` (default on). The old chat-app switches (`app_<id>`) are still honoured until a per-app choice is saved.
  - **Per-app bell in the notification center**: each app group header has a bell; tap it to turn pop-ups from that app off / on without leaving the panel.
  - **Pop-up over other apps**: card with the permission status and a button to allow *Display over other apps* (`SYSTEM_ALERT_WINDOW`).
  - **Send test notification** button.
- **One Ring / Vibrate / Mute button (Quick Settings):** the three tiles are now one tile. Tap to cycle **Ring > Vibrate > Mute > Ring**; the icon shows the current mode (bell / vibrate / muted speaker), the tile is highlighted while Vibrate or Mute is active, and a small toast names the new mode. Mute still needs *Do Not Disturb access* once (same flow as before). The tile follows changes made with the hardware buttons too.
- **Pop-up feedback follows that button:** Ring = notification sound (if *Play notification sound* is on), Vibrate = short vibration, Mute = nothing (`NotifPrefs.feedback()`). The pop-up card is shown in every mode.
- New permissions: `VIBRATE`, `SYSTEM_ALERT_WINDOW`. Version 2.2.0 (versionCode 106).
- Changed files: `MainActivity.kt`, `NotificationSettings.kt`, `NotificationSettingsActivity.kt`, `GlassToast.kt`, `QuickControlsActivity.kt`, `AndroidManifest.xml`, `app/build.gradle.kts`.

## Windows-style Quick Settings & Notification Center

A Quick Settings shortcut (gear / notification glyph) is added to the taskbar. It opens a Windows-inspired control panel with Wi-Fi and Bluetooth settings, Location, one Ring / Vibrate / Mute button, display/rotation settings, volume controls, Airplane Mode settings, flashlight toggle, Power Popup (Android 5.0+; requires enabling the app's Accessibility service), and a Windows 11 style notification center: live list of the phone's dismissible notifications grouped by app (app icon + name in a group header, rounded bordered cards with title, time and message), tap a card to open it, vector X to dismiss, collapse/expand arrow per app group, Show more / Show less when a group has more than 3, Clear per app and a Clear all pill (these dismiss on the phone too), and an empty state with a bell icon. Below the notifications sits a Win11-style calendar: today's full date, a month grid with the current day highlighted, and up/down arrows to change the month (tap the month title to jump back to today). All icons are vector drawables, no emoji. **Glass UI:** the panel uses a translucent theme (Theme.Win11.Glass) so the screen behind shows through, with real background blur on Android 12+ devices that support it, and frosted rounded tiles and cards with a thin light border. **Do Not Disturb:** the bell at the top of the notification section turns pop-ups and sounds off (the bell changes to a slashed bell and a note appears); notifications are still collected in the center. **Toast:** a new notification from any app slides in as a glass card at the top right with the app icon, name, sender and message, fades after 5 seconds, tap opens the notification center, X dismisses it. It needs Notification access to be turned on for the app.

Android security restrictions apply: Wi-Fi/Bluetooth/Location/Airplane Mode and rotation controls open the relevant system settings rather than silently changing protected system state. Screen recording works from the panel's recorder tile: Android's system screen-capture consent dialog appears first (it cannot be skipped), then the whole screen is recorded (optionally with microphone audio) and saved to Movies/RizwanS2; tap the tile again or the notification's Stop action to finish. Screenshot: with the "Win11 Power and Lock" Accessibility service enabled (Android 9+) it is a single tap; otherwise Android's system screen-capture consent dialog appears and a PNG is saved to Pictures/RizwanS2. Nothing is captured silently. The flashlight turns on at the brightest level the device reports (Android 13+ devices that expose torch strength); other devices use plain on/off. The tile reflects the real torch state.

## Quick Settings flyout (v2.1.0)

- **Windows 11 layout, docked to the right** just above the taskbar. **Notifications and calendar are on top, Quick Settings are at the bottom** (tiles, then brightness and volume sliders). There is no close button: tap anywhere outside the panel (or press Back) to dismiss it. The tray clock opens it (the taskbar gear is hidden).
- **Win11 sliders:** a brightness slider and a volume slider (tap the speaker icon to mute / unmute). The volume slider follows the hardware volume keys.
- **Tiles show real state** (accent fill when on): Wi-Fi, Bluetooth, Airplane, Location, Auto-rotate, Flashlight, one Ring / Vibrate / Mute button (tap to cycle), Screen recorder.
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

A built-in **Calculator** app appears in All apps (and in Start > Recent once opened; you can pin it). Floating glass panel docked above the taskbar (like the Quick Settings flyout; tap outside it to close) with vector icons only, centered in their keys: digits, `+ - × ÷`, `%` (`200 + 10%` = 220), `±`, backspace (long-press = clear), `C`, `=`, a live result preview line, divide-by-zero error, and hardware-keyboard support. Code: `CalculatorActivity.kt`.

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

## Start menu: Recent apps (Pinned only when you pin)

- **Recent is the default Start page.** Apps you open from Start (pinned grid, Recent grid, All apps or search) are remembered, most recent first (up to 12, 6 per row). Pinned and hidden apps are not repeated in Recent.
- **Pinned appears only when something is pinned.** Nothing is auto-pinned any more. Long-press an app in All apps > *Pin to Start* (or long-press a Recent app > *Pin to Start*) and a **Pinned** section shows above Recent; unpin the last one and it disappears again.
- **Long-press menus:** Recent app = Pin to Start, Remove from recent, Hide app, App info. Pinned app = Unpin from Start, Move to front, Hide app, App info.
- The **All apps ›** button sits on the first section header (Pinned if shown, otherwise Recent).
- **Existing installs:** one time only, a pinned list that is just the old auto-seeded defaults (Files, Browser, Phone, Messages, Notifications, Calculator, Chrome, Gmail, YouTube, Play Store, Settings, ...) is cleared; apps you pinned yourself outside that default set are kept.
- Code: `AppRepository.recent()/addRecent()/removeRecent()` in `StartApps.kt`; `refreshPinnedGrid()`, `showRecentMenu()` in `Win11Shell.kt`. Prefs key `start_menu/recent`.

## Messages: loading animation, pagination, read state

- **Loading animation:** the conversation list shows an accent-coloured spinner from the first frame until the first page is ready (no more blank pane on first open). Opening a conversation shows a spinner while its first page loads, and a small spinner row at the top while older messages load.
- **Pagination, 20 at a time:**
  - *Conversation list:* the first 20 conversations are shown (contact names are looked up only for the visible page); the next 20 load when you scroll near the bottom. A refresh keeps the pages already shown unless the search text changed.
  - *Conversation:* opens at the newest 20 messages, scrolled to the bottom like a chat app. Scrolling up near the oldest loaded message fetches 20 older ones; the view stays in place (no jump) and day separators are merged across pages. If the first page does not fill the screen, older pages are fetched automatically. The header shows "20+ messages" while more exist.
  - Queries use `date < oldest loaded` (not an offset), so new / sent messages do not cause duplicates. The old fixed 500-message cap is gone.
- **Read behaviour:** opening a conversation marks it read: the unread badge and bold text clear immediately and stay cleared; only messages that arrive later count as unread again. The SMS provider is updated too when this app is allowed to (default SMS app); otherwise a local per-conversation "read at" marker is used (`sms_ui` prefs, key `readat:<address>`).
- Code: `MainActivity.kt` (`smsQueryPage`, `smsLoadOlder`, `smsLoadMoreConversations`, `smsMarkRead`, `smsSpinner`).

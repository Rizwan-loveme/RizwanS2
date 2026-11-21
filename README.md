# Win11 — built-in YouTube player (`youtube` module)

## Player plan (10 parts)

| # | Part | Status |
|---|------|--------|
| 1 | Player engine and player screen (`YtPlayer`, `StreamSources`, `PlayerActivity`) | done |
| 2 | Speed control: 0.25x – 2x | done |
| 3 | Quality control: Auto plus each height the video has | done |
| 4 | Fullscreen | done |
| 5 | Background playback service (`PlaybackService`) | done |
| 6 | Notification and lock-screen controls (custom) | skipped (Media3's default notification is used) |
| 7 | ~~Picture-in-picture~~ → floating popup window over any app (`FloatingPlayer`) | done |
| 8 | Touch gestures: double-tap seek, volume and brightness swipes (`PlayerGestures`) | done |
| 9 | Remember settings and resume position (`PlayerPrefs`) | done |
| 10 | Hook it into `:app`, final checks and docs | done |

## Update — floating popup, no text, glass UI

**Picture-in-picture is removed** (`supportsPictureInPicture`, the PiP chip, receivers and params are gone).
It is replaced by a **floating popup window** (`player/FloatingPlayer.kt`, `res/layout/float_player.xml`):

- The video of the shared `YtPlayer` appears in a small glass window over ANY app, sliding in from the top like a
  heads-up notification. It shows only the picture, the compact controls (play / pause, -10 s / +10 s, a thin seek
  bar) and a **cross** that closes the window and stops the video.
- Drag it anywhere; pinch to resize; the window takes the shape of the video (wide, square or tall); tap the picture
  to show / hide the controls.
- How it starts: the **float chip** on the player screen (closes the player screen so the app behind it shows), or
  leaving the app (home gesture) while a video plays. Opening the player screen again (for example from the
  notification) brings the picture back there.
- It needs **Display over other apps** (`SYSTEM_ALERT_WINDOW`, added to the `:youtube` manifest). Without it the chip
  opens that settings page; tap the chip again after allowing. It is the only extra permission.
- While it is on screen `YtPlayer.floating` is true, so `PlaybackService` does not free the player.

**No text in the YouTube app.** Every control is a vector icon (`res/drawable/ic_*.xml`). Numbers that must be shown
(speed `1.5x`, quality `720p`, times `12:34`, `10s`, `50%`) are drawn as **glyph outlines** by
`ui/VectorLabelDrawable.kt` (`Paint.getTextPath`), so they are paths too. Media3's text controller is replaced by
`ui/GlassControls.kt` (icons, vector times, drawn seek bar); `YouTubeActivity` is a logo, a link field, paste and
play icons. `strings.xml` only has content descriptions for screen readers. Left as real text on purpose: the link
you type in `YouTubeActivity`, and the system notification of background playback (Android draws it).

**Glass UI** (`ui/GlassDrawable.kt`): smoked translucent body, light gradient and a bright rim.
- `ui/GlassToast.kt` replaces every `Toast` of this module: a glass pill with an icon (and optional vector label),
  floating at the top of the player screen, or over other apps when the popup permission is on.
- `ui/GlassSheet.kt` replaces the speed / quality `AlertDialog`s: a glass card at the bottom over a dimmed, blurred
  backdrop (system window blur on Android 12+).

Scope: only the `:youtube` module. The other screens of `:app` still use their own `Toast`s.

## Update — 360p default, weak-network drop

- **Auto = 360p** (`StreamSources.AUTO_CAP`). HLS / DASH videos adapt by themselves below that cap.
- **Weak network** (merged streams, Auto only): 2 stalls (buffering after playing, not a seek) within 40 s switch the
  video to its lowest height at the same position, once per video, with a glass toast. Picking a height by hand
  turns this off; picking Auto again re-enables it. Not for live streams.

## Fix — ForegroundServiceDidNotStartInTimeException

`PlaybackService.onStartCommand()` now calls `startForeground()` first (a plain notification with the same id
Media3 uses, so Media3's own one replaces it) and only then decides whether to continue or stop. Before, the
"no player" path stopped the service without ever calling `startForeground()`, and the normal path waited for
Media3's asynchronous notification.

## Part 10 — built into :app

- **Start menu entry** (`StartApps.kt`): built-in app "YouTube" (`section = "youtube"`), drawn by
  `BuiltInIconDrawable` from a vector path (rounded screen with a play triangle). No bitmap or emoji.
- **Launch** (`MainActivity.kt`): section `youtube` and deep link `rizwans2://youtube` start
  `com.srizwan.YouTube.YouTubeActivity`.
- **`YouTubeActivity`**: until the feed and search screens exist it is a "paste a video link" screen
  that calls `PlayerActivity.start(context, url)`.
- `:app` already depends on `:youtube`; the module manifest (activities, service, permissions) is merged
  automatically, so `app/src/main/AndroidManifest.xml` only got the deep-link comment updated.

## Part 9 — remembered settings and resume position

Saved in SharedPreferences `yt_player` by `PlayerPrefs`:

- **Speed** — saved whenever it changes (speed chip or Media3's own menu), applied when the player is created.
- **Quality** — the chosen cap (`Auto` or a height such as 720), used for every next video; a video without
  that height plays the nearest lower one.
- **Background playback** on / off, and the "notification permission already asked" flag.
- **Resume position** per video (key = page url): the last 100 videos are kept, older ones are dropped.
  - Written every 5 s while the player exists (also in the background), when the screen is left,
    when the video ends and when the player is freed (`YtPlayer.saveResume()`).
  - Not saved for live streams, and not while the player is still preparing (position 0 would erase it).
  - Less than 5 s watched, or within 10 s of the end (or finished) = no saved position, the video starts over.
  - `YtPlayer.load(..., startPositionMs = YtPlayer.RESUME)` (default) continues from it; a quality change
    reloads at the current position instead.
  - The player screen shows "Continuing from 12:34 | Start over" for 7 s (`YtPlayer.resumedFromMs`,
    `resume_box` in `activity_player.xml`); "Start over" seeks to 0.

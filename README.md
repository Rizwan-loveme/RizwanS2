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
| 7 | Picture-in-picture | done |
| 8 | Touch gestures: double-tap seek, volume and brightness swipes (`PlayerGestures`) | done |
| 9 | Remember settings and resume position (`PlayerPrefs`) | done |
| 10 | Hook it into `:app`, final checks and docs | done |

## Update — 360p default, weak-network drop, PiP robustness

- **Auto = 360p** (`StreamSources.AUTO_CAP`). HLS / DASH videos adapt by themselves below that cap.
- **Weak network** (merged streams, Auto only): 2 stalls (buffering after playing, not a seek) within 40 s switch the
  video to its lowest height at the same position, once per video, with a short message. Picking a height by hand
  turns this off; picking Auto again re-enables it. Not for live streams.
- **PiP**: errors from `setPictureInPictureParams` / `enterPictureInPictureMode` were swallowed (auto-enter could stay
  off with no sign). Now they are logged (tag `PlayerActivity`), retried without the +-10s/play buttons, and the PiP chip
  shows the error text. Leaving the screen also calls `enterPip()` on Android 12+ as a second path.

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

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

## YouTube screens — step 3: search

The home screen has a glass **search button** (top right). It opens `search/SearchActivity` (own entry in the manifest).

- **Suggestions** (field focused): a glass panel with your past searches (the ones that match what you typed, or the
  latest 15 when the field is empty) and YouTube's own suggestions (`YtRepository.suggestions`, 220 ms after you stop
  typing). Tap a row = search; the arrow copies the text into the field; the cross removes a past search; the bin row
  clears the whole search history.
- **Filters**: chips All / Videos / Channels / Playlists (glass; the chosen one is a light pill). Changing a chip
  searches again with that filter (`YtRepository.Filter`).
- **Results**: videos use the same glass card as the home feed (`VideoCardAdapter.create` / `bind`), channels show a
  round avatar, name, subscribers and description, playlists a 16:9 thumbnail with the video count. More rows load when
  you reach the end (spinner footer). Failure shows the wifi-off icon with a retry button; no result shows a dim search icon.
- **Back**: from the suggestions it returns to the results; tapping the field again from the results opens the suggestions.
- Every search you run is stored in `YtHistory` (local, no account).
- `YtNav` is the one place that decides where a tap goes (video -> player). **Channel and playlist rows only show a glass
  hint for now**; their screens are step 5.
- Shared pieces: `ui/Format.kt` (counts, durations), new vector icons `ic_search`, `ic_back`, `ic_history`,
  `ic_fill_query`, `ic_playlist`, `ic_delete`, `ic_person`. Still no text views: chips and card text are vector outlines;
  the search field is the only real text.
- The home feed, the link bar, the player, the floating window and background playback are unchanged.

## YouTube screens — step 4: history

A glass **history button** next to the search button on the home screen opens `history/HistoryActivity`.

- Two tabs in the top bar: **Watched** and **Searches** (the chosen one is a light pill).
- **Watched**: glass rows (thumbnail with duration, title, channel, "5 min ago" / "Yesterday" / a date). Tap plays the
  video again, the cross removes that one row (`YtHistory.removeWatch`).
- **Searches**: past searches (`YtHistory.searchHistory`). Tap runs the search again (`YtNav.openSearch(query)`), the
  cross removes one.
- The bin at the top right clears the open tab after a glass confirmation sheet (`GlassSheet`: bin = confirm, cross = cancel).
- Lists reload in `onResume`; an empty tab shows a dim clock icon.
- `SuggestionAdapter` got a `showFill` option (the history screen hides the arrow); `Format.ago()` is new.
- **Search history fills up already** (step 3). **Watch history is filled by step 7** (the player will call
  `YtHistory.addWatch`), so the Watched tab stays empty until then.

## YouTube screens — step 5: channel and playlist

`YtNav.openChannel` / `openPlaylist` now open real screens (the glass hint of step 3 is gone). Search result rows
for channels and playlists lead to them.

- **Channel** (`channel/ChannelActivity`): back, round avatar, name, subscribers; the description under it (two lines,
  tap to open it up); tabs **Videos / Playlists** (the ones the channel has); the open tab is a list with the same glass
  rows as search (`SearchResultAdapter`) and loads more at the end. Each tab is loaded once and kept while the screen is open.
- **Playlist** (`playlist/PlaylistActivity`): back and a glass header (thumbnail, title, owner, video count), then the
  videos as the home-feed cards (`VideoCardAdapter`), more at the end. A tap plays the video.
- Both: wifi-off icon + retry on failure, dim icon when empty, no text views (vector icons and vector-outline text).
- Not done yet: the channel name on a video card / in the player is not a link to the channel (only search results lead there).

## YouTube screens — step 6: bottom navigation

Home, search and history now share a **glass navigation bar** (`ui/GlassNavBar.kt`, tabs `YtTab`) at the bottom.

- Three vector icons (home, search, history). The open screen shows its icon with a vector-outline label inside a light
  pill; the other icons are dim. No text views.
- It replaces the two small search / history buttons of the home top bar. **The link bar stays on the home screen**
  (paste or type a link and play it, as before).
- `YtNav.switchTab(activity, from, to)` does the switching: home is the bottom of the stack, search and history replace
  each other, so Back always returns to home; tabs switch without a slide animation.
- On the search screen the bar hides while the keyboard is up; tapping the search tab there puts the cursor in the field.
- Channel, playlist and player screens have no bar (they are detail screens). History rows still open a search on top of history.

## YouTube screens — step 7: watching saves to history

`PlayerActivity.fetchAndPlay()` now calls `YtHistory.addWatch(...)` (url, title, thumbnail, channel, channel link,
duration) as soon as the video has loaded into the player. The video appears at the top of **History > Watched**;
watching it again moves it to the top (one row per video, max 300, local only). A video that failed to load is not saved.
Reopening the player screen for a video that is already playing (notification, floating window) does not add a row again.
Everything else in the player is unchanged.

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

## Video player — `:video` module (package `com.srizwan.video`)

The File Manager's old `VideoView` dialog is replaced by the same glass player as the built-in YouTube app, in its own
Gradle module (`:video`, resources prefixed `vp_`, so nothing clashes with `:youtube`). `:app` depends on it.

- **Engine** (`player/VideoEngine`): one shared Media3 ExoPlayer for any file path, `content://` uri or link.
  **4K ready**: no viewport / size / bitrate cap in the track selector (Media3 would otherwise limit the picture to the
  display size), decoder fallback on, `resolutionLabel()` names the picture "8K" / "4K" / "2K" / "1080p" ...
- **Player screen** (`player/VideoPlayerActivity`): glass controls, double-tap seek (chained), middle double-tap play /
  pause, volume (right) and brightness (left) swipes, fullscreen with orientation handling, file name (vector outlines),
  chips: floating popup, background playback, resolution (4K badge; an HLS / DASH link lets you cap the height), speed
  0.25x - 2x. Saved: speed, background playback, resume position per file ("Continuing from 12:34 | Start over").
- **Popup window** (`player/FloatingPlayer`): glass window over any app (drag, pinch to resize, slide-in, cross closes
  it); needs "Display over other apps". Home gesture while playing floats the video automatically.
- **Background playback** (`player/PlaybackService`): foreground media service + notification controls.
- **Video app** (`home/VideoHomeActivity`): glass list of the device's videos (frame, length, resolution badge, "continue"
  badge, name, size | date). Start menu entry "Video" (`section = "video"`), **Home (desktop) icon**, deep link
  `rizwans2://video`. Other apps can also open videos in it (VIEW intent for `video/*`, `file` / `content`).
- **File Manager**: `playVideo()` starts `VideoPlayerActivity`; mp4, m4v, mkv, webm, 3gp, mov, avi, flv, wmv, mpg, mpeg,
  ogv are opened (what ExoPlayer cannot decode shows the error icon). The old file-player PiP state in `MainActivity` and
  `supportsPictureInPicture` in the manifest were removed (the popup window replaces it).
- `:youtube` is unchanged; the UI classes were copied (not shared) into `:video` so both modules stay independent.
- Version 2.5.2 (code 119).

### Video player — next / previous (part 6)

- A video opened from the File Manager knows the other videos of its folder (name order); one opened from the Video app knows
  the whole list. `VideoPlayerActivity.start(context, source, title, playlist)` hands the list to `VideoEngine.setQueue()`
  (not through the intent, so a long list cannot overflow it).
- Two glass chips (previous / next, in the chip row) appear for a video that belongs to a list; one with nothing to go to is dimmed.
- When a video ends, the next one of the list starts by itself, also while the app is in the background or in the popup.
- Opening a video that is not in the list drops the list.

### Video player — final review (parts 7 and 8)

Static review of every file of `:video` plus its hooks in `:app` (this environment has no Android SDK and no network, so a
Gradle build was **not** run; build once on your side with `./gradlew :app:assembleDebug`).

- **Fixed: wrong title / source after next, previous or auto-play.** `VideoEngine.load()` used to put the item into ExoPlayer
  first and set `currentSource` / `title` / `resumedFromMs` afterwards. ExoPlayer calls its listeners from inside
  `setMediaItem()` (`onMediaItemTransition`), so the player screen read the *previous* video's name and source. The state is
  now set before the item goes into the player.
- **Fixed: retry after next / previous** used the title extra of the first video; the extra is now only used while the intent's
  own video is the one on screen (otherwise the file name is shown).
- **Fixed:** opening the player from the notification uses `VideoEngine.currentSource` (the original path) instead of the
  `file://` key, so the queue is matched.
- **Consistency:** the File Manager's colour tag for video files (`fileTypeColor`) now knows the same extensions as
  `isVideoFile()` and the thumbnail decoder (m4v, 3gpp, 3g2, mpg, mpeg, ogv added).
- Manifest comment of the deep links lists `video`; deep link `rizwans2://video`, Start menu entry and Home icon were checked.
- Checked and left as is: resources all prefixed `vp_` (no clash with `:youtube`; every referenced drawable / string exists),
  `targetSdk = 28` (storage permission and edge-to-edge behave like the other built-in apps), Media3 1.8.0 in both modules.
- Unused (kept): `vp_ic_delete`, `vp_ic_search`.

### Build fix (CI run #12, release)

`:video:dataBindingMergeDependencyArtifactsRelease` failed with *Could not find org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.1*
(required by `androidx.lifecycle:lifecycle-viewmodel-savedstate:2.5.1`, pulled in by appcompat 1.6.1). Fix: the root
`build.gradle.kts` forces one coroutines version (1.8.1) for all modules, and `:video` declares
`kotlinx-coroutines-android:1.8.1` explicitly. No source code changed. Version 2.5.2 (code 119).


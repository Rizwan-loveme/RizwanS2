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
- Version 2.5.3 (code 120).

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
`kotlinx-coroutines-android:1.8.1` explicitly. No source code changed. Version 2.5.3 (code 120).

### Popup controls, controller buttons, title overlap (v2.5.3) — `:video` and `:youtube`

**Popup window (`FloatingPlayer`, both modules)**
- **Volume and brightness by swipe.** Swipe up / down on the **right third** of the picture = volume (music stream), on the
  **left third** = screen brightness. A small glass hint (icon + percent, glyph outlines) shows the value for a moment.
  A swipe that starts in the **middle**, or goes mostly sideways, still drags the window, and pinch still resizes it.
  A tap shows / hides the controls as before.
- Brightness is set on the popup window itself (`WindowManager.LayoutParams.screenBrightness`), so no "write settings"
  permission is needed. It lasts while the popup is on screen and starts from the system value every time the popup opens.
- **Expand button** (top left, appears and fades with the controls, mirror of the cross): opens the player screen in
  **fullscreen** for the loaded video (`VideoPlayerActivity.fullscreenIntent()` / `PlayerActivity.fullscreenIntent()`,
  extra `EXTRA_FULLSCREEN`). The player screen's `onStart` takes the picture from the popup, nothing restarts. A wide video turns
  the screen to landscape. Starting the screen from the popup is allowed because the app holds "Display over other apps".

**Controller (`:video` `GlassControls`)**
- Centre row is now **previous | -10 s | play / pause | +10 s | next**. The two skip buttons show only for a video that
  belongs to a list (folder / Video app list), a button with nothing to go to is dimmed. In the popup they show only when
  the window is at least 230 dp wide (they come and go when you pinch-resize it). Sizes were reduced a little so five
  buttons fit a 360 dp screen.
- The two previous / next chips were removed from the chip row of the player screen (`vp_activity_player.xml`).

**Title overlap (player screen)**
- The file name no longer has a fixed 220 dp end margin. `VideoPlayerActivity.placeTitleAboveOrBeside()` measures the chip
  row: if at least 120 dp stay free beside it, the name sits beside the row, otherwise it moves to **its own line below the
  row**. It is re-checked whenever the row or the screen changes size, so it never overlaps a chip (portrait or landscape).

Not run here (no Android SDK / network): build once with `./gradlew :app:assembleDebug`. Version 2.5.3 (code 120).


## Gallery — `:gallery` module (package `com.srizwan.gallery`)

A glass Gallery in its own Gradle module, built in the same pattern as `:video` (resources prefixed `gl_`, no text of its
own, content descriptions only). Images tapped in the File Manager will open in it. `:app` depends on it.

### Gallery plan (13 steps)

| # | Step | Status |
|---|------|--------|
| 1 | Module setup (`:gallery`, manifest, theme, `:app` dependency) | done |
| 2 | Glass UI kit (`GlassDrawable`, `GlassSheet`, `GlassToast`, `GlassControls`) and `gl_` vector icons | done |
| 3 | Image data layer (`GalleryRepository`: MediaStore + folder scan, albums, sorting) | done |
| 4 | Thumbnail and image loader (memory + disk cache, downsampled decoding) | done |
| 5 | Gallery home screen (`GalleryHomeActivity`: Photos grid with date headers, Albums tab, pinch columns) | done |
| 6 | Album screen (one folder, sort options) | done |
| 7 | Full-screen photo viewer (`GalleryViewerActivity`: swipe, zoom, filmstrip, EXIF orientation, GIF) | done |
| 8 | Viewer actions: share, delete, rename, wallpaper, rotate, info sheet, favorite, slideshow | done |
| 9 | Multi-select mode (long-press, drag range, share / delete / select all) | done |
| 10 | File Manager hook: `openImageFile()` starts the viewer with the folder's images; `VIEW image/*` intent filter | done |
| 11 | Launcher integration: Start menu entry, Home icon, deep link `rizwans2://gallery` | done |
| 12 | Saved settings (columns, sort, last tab, slideshow interval, favorites), permissions, rotation | done |
| 13 | Final review, README, flat zip | done |

### Step 1 — module setup

- `gallery/build.gradle.kts`: Android library, `namespace = "com.srizwan.gallery"`, minSdk 26, compileSdk 37, Java / Kotlin 21,
  view binding, same coroutines 1.8.1 pin as `:video` (CI build #12 fix). Dependencies: core-ktx, appcompat, recyclerview,
  viewpager2 (for the viewer, step 7).
- `settings.gradle.kts`: `include(":gallery")`. `app/build.gradle.kts`: `implementation(project(":gallery"))`.
- Manifest: `READ_MEDIA_IMAGES` and `READ_EXTERNAL_STORAGE`; two activities, `home/GalleryHomeActivity` and
  `viewer/GalleryViewerActivity` (both `exported="false"` for now; the `VIEW image/*` filter comes in step 10).
- Resources: `gl_bg`, `gl_text`, `gl_text_dim`, `gl_accent` colours, `Theme.Gallery` (dark, same as `Theme.Video`),
  `gl_cd_*` content descriptions.
- Code: both activities are empty dark screens for now. `GalleryViewerActivity.start(context, path, folderImages)` already
  exists with the shape the File Manager will use in step 10 (like `VideoPlayerActivity.start`).
- `:app`, `:video`, `:youtube` and every other module are unchanged apart from the one dependency line. Version stays
  2.5.3 (code 120).
- No Android SDK / network in this environment: a Gradle build was **not** run. Build once with `./gradlew :app:assembleDebug`.

### Step 2 — glass UI kit (`gallery/ui`)

Same glass look as `:video`; the classes are copied, not shared, so `:gallery` stays independent (package
`com.srizwan.gallery.ui`, resources `gl_`). There is no TextView anywhere: labels are glyph outlines, icons are vectors.

- `GlassDrawable`: smoked translucent body, light sheen, thin bright rim; `radiusDp` large = pill / circle, `strong` = denser body.
- `GlassSheet`: bottom list sheet over a blurred, dimmed backdrop (system blur on Android 12+). Rows = icon + label + check.
  Used for sort order, slideshow interval and confirm.
- `GlassToast`: glass pill with an icon and an optional label; floats inside the visible Gallery screen (`GlassToast.host`),
  else over other apps only when "display over other apps" is already allowed, else skipped.
- `VectorLabelDrawable` / `VectorText`: icon + outline text as a drawable, and multi-line outline text with an ellipsis.
- `GlassControls.kt`:
  - `GlassUi`: `dp()`, `iconButton()` (bare or on its own round glass), `setIcon()`, `padForInsets()`.
  - `GlassBar`: floating glass top bar (back, one-line title, action icons); pads itself below the status bar.
  - `GlassToolbar`: floating glass bottom bar, buttons share the width; pads itself above the navigation bar.
  - `GlassTabs`: Photos / Albums pill switch, the chosen tab is a lighter pill.
  - `GlassConfirm`: confirm / cancel sheet (delete).
- Icons (`gl_ic_*`, 24 dp vectors): back, close, check, search, delete, lock, retry, error, play, pause (copied from `:video`);
  share, info, favorite, favorite_outline, rotate, edit, slideshow, grid, check_circle, circle, select_all, sort,
  photo_library, image, folder, more, wallpaper (new).
- Strings: more `gl_cd_*` content descriptions (rename, wallpaper, sort, more, select all, photos, albums, slideshow
  play / pause, grid size, error).
- The two activities are still empty screens; the kit is used from step 5 on. `:app` and the other modules are unchanged.
  Version stays 2.5.3 (code 120). No Android SDK here, so no Gradle build was run: build once with `./gradlew :app:assembleDebug`.

### Step 3 — image data layer (`gallery/data`)

No UI yet; the screens of steps 5 to 9 read everything through these classes.

- `GalleryImage`: id (MediaStore `_ID`, 0 for a folder-scan file), path, name, folder path / name, size, date
  (taken, else modified), width, height, mime; `uri` (`content://` or `file://`), `isGif`. `GalleryAlbum` (folder, name,
  count, newest picture as cover, total size) and `DayGroup` (one calendar day of pictures) are in the same file.
- `GalleryRepository` (object):
  - `load(context, forceRefresh, scanFolders)` (suspend, runs on `Dispatchers.IO`, one load at a time, cancellable):
    1. **MediaStore** query (path, name, size, date taken / modified, width, height, mime). Skips hidden files / folders
       (`/.thumbnails`, `/.trash` ...), `Android/data` and `Android/obb`, empty files and duplicates.
    2. **Folder scan** for pictures MediaStore does not know (only with all-files access): iterative walk from the
       internal storage root, depth 12, max 20 000 folders / 20 000 new pictures, skips hidden folders, folders with a
       `.nomedia` file and the top-level `Android` folder. Scan files have width / height 0 until the viewer decodes them.
    3. Result sorted newest first and kept in memory: `cached()`, `invalidate()`. No permission = empty list.
  - Types: jpg, jpeg, png, webp, gif, bmp, heic, heif (`EXTENSIONS`, `isImageName()`).
  - `albums(images, by, ascending)`: one album per folder (the storage root is named "Internal storage").
  - `groupByDay(images)`: date headers for the Photos grid (pass a date-sorted list).
  - `imagesInFolder()`, `search()` (name and folder), `sorted()`.
  - `fromFile()` / `fromPaths()`: pictures described by their files only, for the list the File Manager hands over
    (step 10).
- `GallerySort` (`SortBy` DATE / NAME / SIZE, `ascending`; default newest first): ties and names use a natural order
  ("IMG_2" before "IMG_10", case and leading zeros ignored). `AlbumSortBy` DATE / NAME / COUNT.
- `GalleryPermission`: `has()`, `toRequest()` (READ_MEDIA_IMAGES when the app targets 33+, else READ_EXTERNAL_STORAGE),
  `hasAllFilesAccess()`, `canScanFolders()`.
- Note for step 10: the File Manager's `isImageFile()` does not know heic / heif yet (the Gallery does).
- `:app` and the other modules are unchanged. Version stays 2.5.3 (code 120). No Android SDK here, so no Gradle build was
  run: build once with `./gradlew :app:assembleDebug`.

### Step 4 — thumbnail and image loader (`gallery/loader`)

Still no screen; the grids (steps 5, 6) and the viewer (step 7) fill their pictures through `ImageLoader`.

- `ImageLoader.load(view, image, sizePx)`: call it for every bind of a RecyclerView row. The view remembers the request that
  owns it (`gl_tag_request`): a rebound row cancels the old request, a late result never lands in the wrong row, the
  newest request is decoded first (the rows you look at, not the ones you flew past), cancelled tasks are purged from the
  queue. A picture that arrives from disk / decode fades in (160 ms); one that is already in memory appears at once.
  `cancel(view)` for a recycled row. The view's background is a soft glass tint until the picture arrives
  (`placeholderColor`, 0 = none); a picture that cannot be decoded shows the error icon (`IconPlaceholder`, centred, small).
- **Downsampled decoding** (`decode`): ImageDecoder on Android 9+ (also HEIC / HEIF, first frame of GIF / WebP, EXIF
  orientation applied by the system, software bitmaps so they can be saved to the disk cache); BitmapFactory with
  `inSampleSize` + EXIF orientation (all 8 cases) + a final exact scale below that. A thumbnail is decoded so its **short**
  side fills the bucket (sharp under CENTER_CROP), the long side is capped at 3x the bucket (panoramas), nothing is enlarged.
- **Buckets**: 128, 192, 256, 384, 512, 768 px (`bucketFor`), so 2 to 5 grid columns reuse the same cached files.
- **Memory cache**: `LruCache` in bytes (1/8 of the heap, at most 96 MB), halved on `TRIM_MEMORY_RUNNING_LOW`, emptied on
  `TRIM_MEMORY_BACKGROUND` and `onLowMemory` (registered once as an application `ComponentCallbacks2`).
- **Disk cache**: `cache/gallery_thumbs`, file name = SHA-1 of the key (path | size | date | version | bucket), JPEG q85
  (PNG for pictures with alpha), written to a `.tmp` file and renamed. A read refreshes the file date; every 100 writes
  the folder is trimmed to 72 MB when it is over 96 MB, oldest files first. The system may also clear it any time.
- `thumb(context, image, sizePx)`: the same pipeline as a blocking call for a background thread (album covers, notifications).
  `cachedThumb()` peeks at the memory cache. `decodeFull(path, maxSide)`: the full-screen version (no cache, longest side
  <= `maxSide`, orientation applied) for the viewer in step 7.
- `invalidate(path)`: call after a picture changed on disk (rotate saved, edited): the version in the key is bumped and its
  thumbnails leave the memory cache. `clearMemory()`, `clearDisk(context)`, `diskBytes(context)`.
- Decoding runs on 2 to 4 daemon threads (CPU count - 1) at background priority.
- `:app` and the other modules are unchanged. Version stays 2.5.3 (code 120). No Android SDK here, so no Gradle build was
  run: build once with `./gradlew :app:assembleDebug`.

### Step 5 — Gallery home screen (`gallery/home`)

`GalleryHomeActivity` is now the real home screen (still `exported="false"`; the Start menu / Home icon / deep link come in step 11).

- **Layout**: edge to edge, the lists run under floating glass bars (soft dark scrim behind them). Top area = `GlassBar`
  (title, search button, view-mode button) + optional search row + `GlassTabs` (Photos / Albums). List padding follows the bars
  and the system insets (status / navigation bar, cut-out).
- **Photos tab** (`PhotosAdapter`): `GridLayoutManager`, date headers span every column ("Today", "Yesterday", "Tue, 18 Nov",
  "18 Nov 2025" — outline text), square cells (`SquareFrame`) filled by `ImageLoader.load` at the cell size, GIF badge.
  **Pinch** (`PinchColumnsListener`) changes the columns 2 to 5 (spread = fewer / bigger, about 30 % per step, haptic tick,
  keeps the first visible row); one-finger scrolling is untouched. The choice is saved.
- **Albums tab** (`AlbumsAdapter`): one card per folder — rounded cover (newest picture), name, "12 photos". Columns follow the
  screen width (2 on a phone, more on tablets / landscape).
- **View-mode menu** (glass sheet): Group by date (on / off = one flat grid), 2 / 3 / 4 / 5 columns, Refresh.
- **Search**: glass search row under the top bar, filters name and folder on both tabs (200 ms debounce, on a background
  thread, list scrolls to top). Back closes the search first. Albums are built from the matching pictures.
- **Loading / empty states**: `GlassShimmerView` skeleton (photo grid or album cards, shimmer only while visible) while the
  list loads; `GlassEmptyState` card for "No photos yet" (Refresh button), "No matches" and "Allow access to your photos"
  (button asks for the permission; after "don't ask again" it becomes "Open settings").
- **Data flow**: `GalleryRepository.load` on `Dispatchers.IO`; filtering / grouping / albums on `Dispatchers.Default`; the
  UI only gets the finished lists. On every start the list loads when nothing is loaded, or reloads quietly (no skeleton)
  when it is older than 60 s (new photos taken meanwhile); granting the permission reloads at once.
- **Opening a picture**: `GalleryViewerActivity.start(context, path, neighbours)` with at most 1000 neighbouring paths (keeps
  the intent small for huge libraries; step 7 reads the full list from `GalleryRepository.cached()`). Tapping an album opens
  the album screen (step 6).
- New: `data/GalleryPrefs` (columns, group by date, last tab — step 12 adds sort, slideshow interval, favorites),
  `ui/GlassShimmerView`, `ui/GlassEmptyState`, `VectorText.set(..., center = true)`, strings (`gl_title`, `gl_today`,
  `gl_menu_*`, `gl_empty_*`, `gl_perm_*`, plural `gl_n_photos` ...).
- `:app` and the other modules are unchanged. Version stays 2.5.3 (code 120). No Android SDK here, so no Gradle build was
  run: build once with `./gradlew :app:assembleDebug`.

### Step 6 — album screen (`gallery/album`)

`GalleryAlbumActivity.start(context, folderPath, name)` (declared in the manifest, `exported="false"`) opens ONE folder's pictures.
The Albums tab of the home screen calls it (the "first picture in the viewer" stand-in of step 5 is gone).

- **Same grid as home**: `PhotosAdapter` (date headers, square thumbnails, GIF badge), columns 2 to 5 shared with the home screen
  (`GalleryPrefs.columns`), pinch to change them, edge to edge under a floating glass header with the same scrim.
- **Header**: `GlassBar` with back, folder name, a **sort** button and the view-mode button; the picture count ("12 photos") sits
  under the bar.
- **Sort** (glass sheet, saved in `GalleryPrefs.albumSortIndex`): Newest first (default), Oldest first, Name (A to Z, natural order),
  Size (biggest first). Date headers appear for the two date orders when "Group by date" is on; name / size give one flat grid.
  A new sort scrolls the list to the top.
- **View-mode menu**: Group by date, 2 to 5 columns (same as home).
- **States**: shimmer skeleton while loading; glass "No photos yet" card when the folder has no pictures left; if the storage
  permission is taken away the screen closes (the home screen asks again).
- **Data**: pictures come from the shared `GalleryRepository` list (`imagesInFolder` + `sorted`, built on `Dispatchers.Default`);
  every `onStart` re-reads it, so coming back from the viewer after a delete / rename (steps 8) shows the fresh list.
- **Opening a picture**: viewer gets the folder's pictures in the order shown (at most 1000 neighbours, as on home).
- New / changed: `album/GalleryAlbumActivity`, `home/GalleryNav` (shared `openPhoto`, `buildItems`, `edgeToEdge`; the home screen
  now uses it too), `GalleryPrefs.albumSortIndex / albumSort`, strings `gl_sort_*`, manifest entry.
- `:app` and the other modules are unchanged. Version stays 2.5.3 (code 120). No Android SDK here, so no Gradle build was run:
  build once with `./gradlew :app:assembleDebug`.

### Step 7 — full-screen photo viewer (`gallery/viewer`)

`GalleryViewerActivity.start(context, path, folderImages)` (same shape the File Manager will use in step 10) opens the picture
with the other pictures of the folder, in the order the caller shows them. Still `exported="false"`; the `VIEW image/*`
filter comes in step 10. The theme is the new translucent `Theme.Gallery.Viewer`, so the screen behind shows through while a
picture is dragged down to close.

- **Swipe**: `ViewPager2` (a small gap between pages, one neighbour on each side kept ready). Each page is a `ZoomImageView`.
- **Zoom** (`ZoomImageView`, a plain View that draws with a canvas matrix): pinch around your fingers (a little rubber band past the
  limits, then it settles back; two fingers moving together pan), **double tap** toggles fit and a close-up at the tapped point, pan,
  **fling** (`OverScroller`). At the left / right edge of a zoomed picture the next horizontal drag is handed to the pager, so you
  swipe on to the neighbour; a fitted picture always lets the pager swipe. The page you left is set back to fit.
- **Swipe down to close**: while not zoomed, a vertical drag moves the picture away (it also shrinks a little); the black backdrop
  and the bars fade with it. Past ~16 % of the height, or with a quick flick, it closes; otherwise it springs back.
- **Tap** hides / shows the glass top bar (file name and "3 / 120"), the bottom area and the system bars together (immersive,
  swipe from the edge shows them for a moment). The cut-out area is used in landscape. **Back** first sets a zoomed picture back to
  fit, then closes.
- **Glass filmstrip** (`GlassFilmstrip`): a glass pill of small rounded thumbnails (`ImageLoader`, so they come from the grid's cache),
  the current one kept in the CENTRE with an accent ring; tap to go there (near pictures slide, far ones jump). Hidden when there is
  one picture. The bottom area is a vertical stack, so the actions toolbar of step 8 goes in next to it.
- **Big pictures** (`ViewerLoader`, `TileSource`): the base bitmap is decoded with its long side at most 2048 px
  (`ImageLoader.decodeFull`, EXIF applied; a cached thumbnail is drawn first so there is no black flash). If the picture is bigger, a
  `BitmapRegionDecoder` decodes 512 px tiles of just the visible part at the sharpness the zoom needs (`inSampleSize` 1, 2, 4 ...);
  about 36 tiles are kept (JPEG tiles as RGB_565), decoded on two background threads, queued tiles that scrolled away are skipped.
  A 4K / 12 MP photo is therefore sharp when zoomed and never sits in memory at full size. A format with no region decoder on the
  device (HEIC on older Android) simply shows the base bitmap.
- **EXIF orientation**: the base bitmap is oriented by the loader; tiles are decoded from the stored picture, so a requested
  rectangle is mapped back through the orientation and the tile is turned the same way (`ImageGeometry.orientationMatrix`, all eight
  orientations). If the decoder and EXIF ever disagree about which way the picture stands, tiling is turned off for it.
- **Animated GIF**: Android 9+ uses `AnimatedImageDrawable` (decoded at most 1600 px, loops forever); Android 8 / 8.1 uses a `Movie`
  (`MovieDrawable`, the page switches to a software layer for it). Animation stops when the window is hidden or the page is
  recycled. A one-frame GIF is shown as a still picture. (Animated WebP shows its first frame.)
- **Loading / error**: a thin spinner while nothing can be shown yet; a glass error icon when the file cannot be decoded.
- **Memory**: nothing is recycled by hand (a frame that is still being drawn can never hit a recycled bitmap); a page that is recycled
  drops its picture, tiles, decoder and animation.
- **Which pictures**: the paths the caller sends (at most 1000 around the tapped one, `GalleryViewerActivity.MAX_PATHS`). When the home
  grid sends 1000 and they are a straight run of `GalleryRepository.cached()`, the viewer swipes through the whole shared list. With no
  list (a single file) it uses the folder's pictures from the shared list, newest first. Files that are gone are skipped. The tapped
  picture is always accepted even if its extension is unusual.
- **State**: `configChanges` covers rotation (pages re-fit, the filmstrip re-centres); the current path is saved for a process restart;
  `onNewIntent` loads a new picture if the viewer is already on top (`singleTop`).
- New: `viewer/GalleryViewerActivity` (rewritten), `ZoomImageView`, `ViewerPagerAdapter`, `GlassFilmstrip`, `ViewerLoader`, `TileSource`,
  `ImageGeometry`, `MovieDrawable`; `Theme.Gallery.Viewer`, string `gl_viewer_counter`; manifest entry uses the new theme;
  `GalleryNav` now takes its 1000-path limit from the viewer. Step 8 adds the actions toolbar, step 9 multi-select.
- `:app` and the other modules are unchanged. Version stays 2.5.3 (code 120). No Android SDK here, so no Gradle build was run:
  build once with `./gradlew :app:assembleDebug`.

### Step 8 — viewer actions (`gallery/viewer`, `gallery/ui`, `gallery/data`)

A glass **toolbar of eight icon buttons** now sits at the bottom of the viewer, under the filmstrip (both hide / show with a tap):
**Share, Favorite, Slideshow, Rotate, Rename, Set as wallpaper, Info, Delete**. The buttons are `compact` (more icon, less padding) so
eight fit on a 360 dp phone. Taps are ignored while a file action is still working (`busy`). All file work is in
`viewer/ImageActions` and runs on `Dispatchers.IO`; afterwards MediaStore is told (`MediaScannerConnection`), the old thumbnails are
dropped (`ImageLoader.invalidate`) and the shared list is edited (`GalleryRepository.removeFromCache / replaceInCache`, the list is
replaced, not changed in place). The home grid notices that the list changed and rebuilds in `onStart` (`cached() !== all`); the album
screen already compared by identity.

- **Share**: `ACTION_SEND` with the file's `content://` uri from `data/GalleryFileProvider` (own FileProvider subclass, authority
  `${applicationId}.gallery.fileprovider`, `res/xml/gl_file_paths.xml` = `root-path`, so any folder or SD card works). Read grant on the
  intent and on its `ClipData`. A failure shows a glass toast.
- **Delete**: glass confirm sheet (`GlassConfirm`: bin row + cancel row). `File.delete()`, with MediaStore's `delete` as the second try and
  to drop the row. The picture leaves the pager and the filmstrip, the next one (or the previous one, at the end) is shown; deleting the last
  picture closes the viewer. The heart of a deleted picture is removed too.
- **Rename**: `GlassPrompt` (glass sheet with the only real text field, keyboard opens, the name without its extension is selected, check button
  or Done confirms). The **extension is always kept** (a name typed without it gets it appended). Refused with a toast: empty name, a leading dot,
  `/ \ : * ? " < > |`, control characters, more than 255 bytes (`BAD_NAME`), a name already used (`EXISTS`); a case-only change is allowed.
  The favorite moves to the new path; the title, the pager page and the filmstrip update.
- **Set as wallpaper**: glass sheet Home screen / Lock screen / Home and lock screen -> `WallpaperManager.setBitmap(..., which)`. The picture is
  decoded at most twice the screen size (and at most 4096 px); if it was turned in the viewer, it becomes the wallpaper as seen. Manifest:
  `SET_WALLPAPER` (normal permission).
- **Rotate**: one tap turns the picture 90 degrees clockwise **in the viewer only** (`ZoomImageView.setTurns`: the canvas is rotated, the fit /
  zoom / pan maths use the turned size, and tiles stay in the picture's own coordinates, so big pictures stay sharp). The turn is kept per path
  while the viewer is open (`ViewerPagerAdapter`), the rotate icon turns accent-coloured, and the **top bar shows two icons: check = save into
  the file, cross = undo**. Saving: **JPEG** is lossless (only the EXIF orientation tag changes, correct also for mirrored orientations,
  `ImageActions.turnOrientation`); **PNG / WebP** are decoded, rotated and written again through a temp file (refused above 16 megapixels; WebP is
  lossless on Android 11+, quality 100 before); GIF, BMP, HEIC / HEIF can only be turned in the viewer (toast). After a save the page, the
  filmstrip thumbnail and the shared list's width / height / size are refreshed and the view-only turn is dropped.
- **Info**: glass sheet (`GlassInfoSheet`, glyph-outline text only) with name, path, size, resolution (from the file, EXIF orientation applied,
  with megapixels), date, and when present camera (make + model), ISO, aperture, exposure, focal length and location (`data/ImageInfo`). A
  location row is tappable and opens a `geo:` intent (toast when no map app exists).
- **Favorite**: the heart toggles (filled, pink when on) and is stored on the device in `GalleryPrefs` (`isFavorite / setFavorite / favorites /
  moveFavorite`, a string set of paths). Step 12 will add a favorites filter / settings UI on top of this.
- **Slideshow**: tap -> glass sheet with 2 / 3 / 5 / 10 / 15 seconds (the choice is saved: `GalleryPrefs.slideshowSeconds`, default 3) ->
  the bars hide, the screen stays on, the pager advances (smooth slide, wraps to the first picture after the last). The slideshow icon becomes
  pause (accent). A finger on the pager holds the timer; a zoomed-in picture waits; Back, the pause button, leaving the screen and any other
  action stop it. A single picture gives a toast instead.
- **Shared UI changes**: `GlassSheet.showContent(activity, keyboard) { dismiss -> view }` (the sheet card for any content; `show` is built on it
  and behaves as before), `GlassToolbar.addButton(..., compact)` and `GlassToolbar.withoutOwnInsets()` (the viewer's bottom area already keeps
  clear of the system bars), `GlassFilmstrip.refresh(index)`, `GalleryRepository.removeFromCache / replaceInCache`.
- New files: `viewer/ImageActions`, `data/GalleryFileProvider`, `data/ImageInfo`, `ui/GlassPrompt`, `ui/GlassInfoSheet`, `res/xml/gl_file_paths.xml`;
  about 45 `gl_*` strings (labels and toasts; the icons were all added in step 2). `:app` and the other modules are unchanged.
- Not done on purpose: rotate-save does not re-encode JPEGs (other apps that ignore EXIF will still show the old orientation); deleting goes
  straight to `File.delete()` (there is no trash; the confirm sheet is the safety net). Multi-select share / delete is step 9 and reuses
  `ImageActions` and `GalleryFileProvider`.
- Version stays 2.5.3 (code 120). No Android SDK here, so no Gradle build was run: **build once with `./gradlew :app:assembleDebug`**.

### Step 9 — multi-select mode (`gallery/home`, `gallery/viewer`, `gallery/data`)

The Photos grid of the home screen and the grid of the album screen now have a selection mode. Both screens use the same
`home/SelectionController`, so they behave the same.

- **Start**: long-press a picture. It is picked, the glass **selection bar** (`GlassBar`: close cross, "N selected", select all, share, delete)
  floats over the top bar, and every cell shows a round check mark (empty circle, or a filled accent check when picked; a picked thumbnail is
  tinted and drawn at 88 %). The system's long-press haptic is the feedback. The top bar and the Photos / Albums tabs are hidden (not removed, so
  the list padding does not jump) until the mode ends.
- **Pick more**: a tap toggles a picture (while selecting a tap never opens the viewer); dropping the last pick ends the mode. **Drag to select**
  (`home/DragSelectListener`, a `RecyclerView.OnItemTouchListener`): keep the finger down after the long press and slide; every picture between the
  long-pressed one and the finger is picked, moving back shrinks the range (picks made before the drag are kept). The grid auto-scrolls when the
  finger is within 72 dp of its top / bottom edge, faster nearer the edge. Date headers are skipped. A long press on a picture while already
  selecting starts a new drag from it: from an unpicked picture it picks the range, from a picked one it drops the range.
- **Select all**: picks every picture of the grid as shown (after search / sort); a second tap on it drops everything and leaves the mode.
- **Share**: `ImageActions.shareMany` -> `ACTION_SEND_MULTIPLE` with `content://` uris from `GalleryFileProvider`, read grant on the intent and its
  `ClipData`, in grid order, mime type of the pictures (or `image/*` when mixed). One picture is shared like the viewer does. At most
  `ImageActions.MAX_SHARE` (300) pictures (a bigger intent can overflow the binder limit): a toast says so. The selection stays after sharing.
- **Delete**: glass confirm sheet ("Delete N photos"), then `ImageActions.deleteMany` on `Dispatchers.IO`: the same `delete()` as the viewer for each
  file (File.delete, MediaStore as second try, scan, thumbnails dropped, favorite removed), but the shared list is edited once at the end
  (`GalleryRepository.removeAllFromCache`, one pass instead of one per picture). A picture that cannot be deleted does not stop the rest, stays picked,
  and a toast says how many failed. While it works the bar is dimmed and taps are ignored (`busy`). Then the screen rebuilds from the shared list.
- **List changes while selecting** (search text, sort, reload, a delete): `SelectionController.onListChanged()` keeps the picks as paths and drops
  only those that are gone; an empty selection ends the mode.
- **Back**: leaves the selection first (a callback added after the search one), then closes the search, then the screen.
- **Adapter**: `PhotosAdapter(onClick, onLongPress)`, `setSelection(selecting, paths)` (rebinds only the overlays with a payload, no thumbnail is
  loaded again), `photoIndexAt(position)`. Both screens now set `GlassToast.host` in `onStart` / clear it in `onStop`, so toasts float inside them.
- Shared changes: `GlassBar.setBackIcon()` (the close cross), `ImageActions.delete(..., updateCache)`, `ImageActions.deleteMany / shareMany / MAX_SHARE`.
- New files: `home/SelectionController.kt`, `home/DragSelectListener.kt`; new strings: `gl_cd_exit_selection`, `gl_n_selected`,
  `gl_delete_many_confirm`, `gl_toast_deleted_many`, `gl_toast_delete_some_failed`, `gl_toast_share_too_many`. No manifest change; `:app` and the
  other modules are unchanged.
- Not done on purpose: the Albums tab has no selection mode (albums are folders, not files); there is no "select a whole day" tap on a date header.
- Version stays 2.5.3 (code 120). No Android SDK here, so no Gradle build was run: **build once with `./gradlew :app:assembleDebug`**.

### Step 10 — open from the File Manager (`app/FileManagerUi.kt`, `app/FileExplorerUi.kt`, `gallery/viewer`, manifest)

Tapping a picture in the File Manager now opens the glass Gallery viewer, and other apps can open pictures in it too.

- **`openImageFile()`** (`FileManagerUi.kt`) calls `GalleryViewerActivity.start(context, path, folderImageList)`. The list is the pictures **on
  screen in the File Manager's own order**: `ExplorerUi.shownFiles()` (new, `internal`; returns the adapter's current items, so the folder's
  sort and the hidden-files choice apply), filtered to pictures. Swiping therefore moves through the folder the same way `playVideo()` passes
  `around`. If the tapped file is not in the folder on screen, the folder's pictures in name order are used. `start()` cuts a list longer than
  1000 paths around the tapped picture (unchanged from step 7).
- **The old dialog viewer is removed**: the full-screen `Dialog` with its pinch-only `ImageView`, the "Pinch to zoom" hint and `loadBitmapSafe()`
  (it had no other caller). `isImageFile()` now also knows `heic` / `heif` (the Gallery already did).
- **Other apps** (`AndroidManifest.xml` of `:gallery`): `GalleryViewerActivity` is now `exported="true"` with an intent filter `VIEW` +
  `DEFAULT`, schemes `file` and `content`, mime type `image/*`. New file `viewer/ViewUri.kt` turns the intent's uri into a path (blocking, run on
  `Dispatchers.IO` inside `loadImages()`):
  - `file://` -> the path (must be a file, not inside this app's private data folder);
  - `content://` -> the real path from the `_data` column when there is one (MediaStore and most file managers; readable, not private data),
    so the folder's neighbours can be swiped; otherwise the picture is **copied to `cache/gallery_view/`** (one picture at a time, the folder is
    emptied first, at most 256 MB, file name taken from `DISPLAY_NAME` and cleaned, an extension is added from the mime type when missing; a
    non-image mime type is refused). Delete / rename of such a copy changes only the copy.
  - A picture that cannot be opened shows a glass toast and the viewer closes.
- **Neighbours for a single file**: with no picture list (an `ACTION_VIEW` from outside), the viewer takes the folder's pictures from the shared
  list as before; when the file is not in it (the Gallery was not opened yet, or MediaStore does not know the file) it lists the folder itself, in
  name order, at most 1000 around the file. A temp copy gets no neighbours.
- **Safety of the exported screen**: `start()` puts a per-process random token (`EXTRA_TOKEN`) in its intent. `readIntent()` takes `EXTRA_PATH`
  and `EXTRA_PATHS` only from an intent with that token; an intent from another app can only bring a `data` uri, so it cannot make the viewer
  open an arbitrary path or list. After a process restart the saved page path (`KEY_PATH`) still restores the picture.
- **Needs**: reading `file://` paths still needs the storage permission the app already asks for; `content://` uris carry their own grant.
- Not done on purpose: the viewer does not ask for the storage permission itself (the launcher / File Manager does); the Start menu entry,
  Home icon and `rizwans2://gallery` link are step 11.
- Version stays 2.5.3 (code 120). No Android SDK here, so no Gradle build was run: **build once with `./gradlew :app:assembleDebug`**.

### Step 11 — launcher integration (`app`: `StartApps.kt`, `MainActivity.kt`, `Win11Shell.kt`, manifest)

The Gallery is now a built-in app of the launcher, wired exactly like Video and YouTube. `GalleryHomeActivity` stays `exported="false"`: it is
started with an explicit intent from `:app`.

- **Start menu** (`StartApps.kt`): a new `AppEntry("Gallery", ..., BUILTIN_CLS_GALLERY = "builtin.gallery", section = "gallery")` after Video. The
  icon is a vector (`BuiltInIconDrawable`, `GALLERY_PATH` = the Material "image" frame with a mountain, same path as `gl_ic_image`), mint green
  `#4FD1A5`; nothing is a bitmap. Tapping it goes through `Win11Shell.launchApp` -> `onNavigate("gallery")` like every other built-in app (recent
  list, pin menu and hide work as for the others). It is not a default pin.
- **Opening it** (`MainActivity.kt`): the taskbar / Start callback has a `section == "gallery"` branch that starts
  `com.srizwan.gallery.home.GalleryHomeActivity` (a failure is logged with `AppLog`, not thrown). The home screen asks for the photo permission
  itself (step 5).
- **Deep link `rizwans2://gallery`**: `handleDeepLink()` has a `"gallery"` case with the same intent; the KDoc list of hosts and the manifest comment
  of the `rizwans2` filter now list `gallery`. The filter itself needed no change (it matches the scheme).
- **Home screen icon** (`Win11Shell.kt`): `VectorIconView.GALLERY` (path + colour, drawn with `Canvas` / `Path` like the other desktop icons), and a
  "Gallery" icon in the desktop column after Video, section `gallery`. With seven icons the column may be taller than a short screen (landscape,
  split screen), so it now sits in a `ScrollView` (no scrollbar, no overscroll glow).
- Resources, strings and the `:gallery` module code are unchanged; the gallery manifest comment about step 11 was updated.
- Not done on purpose: no default pin for Gallery (Start pins stay as they were); no dedicated taskbar button (the taskbar shows the same apps as for
  Video).
- Version stays 2.5.3 (code 120). No Android SDK here, so no Gradle build was run: **build once with `./gradlew :app:assembleDebug`**.

### Step 12 — saved settings, permissions, rotation (`gallery/data`, `gallery/home`, `gallery/album`, manifest)

Most settings were stored since steps 5 to 8; this step checked every one, added what was missing and put a settings UI on top.

- **What is saved** (`GalleryPrefs`, file `gallery_prefs`; every getter clamps its value): grid columns 2 to 5 (pinch or menu, shared by the home and
  album screens), group by date, last tab (Photos / Albums), album sort order (newest, oldest, name, size), slideshow interval (2 / 3 / 5 / 10 / 15 s,
  default 3), the favorites (set of paths) and, new, **favorites only** (`favoritesOnly / setFavoritesOnly`).
- **Settings menu** (the grid button of the home screen, a `GlassSheet`; the rows are built with a parallel action list, so no index arithmetic):
  Group by date, **Favorites only**, 2 to 5 columns, **Slideshow interval** (second sheet with the five choices), **All files access** and Refresh.
  - *Favorites only* filters both tabs (the Albums tab then shows only folders that hold hearts) in the same background `rebuild()`; the set of hearts is read
    on `Dispatchers.Default`. Coming back from the viewer rebuilds the list, so a heart added or removed there shows up at once. With no hearts a glass card
    ("No favorites yet", with a "Show all photos" button) is shown.
  - *All files access* appears only on Android 11+ while it is not allowed; it opens `ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION` (falls back to the
    general list). When the user comes back with the setting changed (`lastAllFiles`), the list is reloaded with the folder scan.
- **Favorites cleanup**: after a load, `GalleryPrefs.pruneFavorites()` (on `Dispatchers.IO`) drops the hearts of files another app deleted. A path is dropped
  only when its folder exists but the file does not, so an SD card that is merely not mounted keeps its favorites.
- **Permissions**: unchanged flow (checked again): `GalleryPermission.has()` = "all files access" or the media permission; the request is
  `READ_MEDIA_IMAGES` only when the app targets 33+, else `READ_EXTERNAL_STORAGE`. The home screen asks once on start, a glass card with an Allow button
  asks again, and after "don't ask again" the button becomes "Open settings". The album screen closes when the permission is gone. The `:gallery`
  manifest now declares the same storage lines as `:app` (`WRITE_EXTERNAL_STORAGE` maxSdk 28, `MANAGE_EXTERNAL_STORAGE`), so the module is complete on its
  own; the merge with `:app` is a no-op.
- **targetSdk = 28, like the other modules**: no scoped-storage rules apply, so plain `File` paths work everywhere once access is granted (the viewer, delete,
  rename and rotate-save use files; the MediaStore `DATA` column is read; `requestLegacyExternalStorage` is already set in `:app`). On Android 13+ the system
  shows its normal photos prompt for the old storage permission. There is no partial-photo-access (Android 14) flow because it only exists for targets 34+.
  Deleted pictures also have their MediaStore row removed, so the other galleries notice.
- **Rotation / split screen** (all three screens declare `configChanges`, nothing is recreated): the home screen already re-laid itself out; the album screen
  got `onConfigurationChanged` (insets and skeleton), and both grids now ask for their thumbnails again when the list gets a new width
  (`PhotosAdapter.updateWidth`, done after the layout pass, so rotation never leaves blurry thumbnails). The viewer, selection mode and an open search survive a
  rotation as they are. If the system kills the process, the home screen restores an open search text; the other settings come from the prefs and the viewer
  restores its picture (step 7).
- New strings: `gl_menu_favorites`, `gl_menu_slideshow`, `gl_menu_all_files`, `gl_no_fav_title`, `gl_no_fav_text`, `gl_show_all`. `:app` is unchanged.
- Not done on purpose: no separate settings screen (the menu holds everything); the sort order of the Photos tab is fixed (newest first; only albums sort);
  a selection is not restored after the system kills the process.
- Version stays 2.5.3 (code 120). No Android SDK here, so no Gradle build was run: **build once with `./gradlew :app:assembleDebug`**.

### Step 13 — final review and delivery

Static review of the whole `:gallery` module (about 7,000 lines in 46 Kotlin files, plus resources and manifest) and of its four hook points in `:app`.
No Android SDK or Kotlin compiler is available in this environment, so the checks were done with scripts and by reading; **a Gradle build was not run**.

- **Checked, no problems found**
  - Every `R.drawable / R.string / R.color / R.style / R.xml / R.id` reference in the module resolves to a declared resource (the three scripted
    "misses" are `android.R.id.content` and `android.R.attr.selectableItemBackground[Borderless]`, which are platform resources).
  - Every file that uses `R` imports `com.srizwan.gallery.R`; every `com.srizwan.gallery.*` import points at a declared class; no class is used
    from another package without an import.
  - Every `package` line matches its folder; braces and parentheses balance in all files.
  - Manifest: the three activities and `GalleryFileProvider` exist; `@xml/gl_file_paths`, `@style/Theme.Gallery[.Viewer]` exist; the `VIEW image/*`
    filter (`file` + `content`) is on the viewer only; the home and album activities stay `exported="false"`.
  - Members called on `GalleryPrefs`, `GalleryRepository`, `ImageLoader`, `ViewUri` and the other objects / companions are all declared.
  - `:app` hook points exist and match the module's API: `GalleryViewerActivity.start(context, path, list)` in `FileManagerUi.openImageFile()`
    (`explorerUi.shownFiles()` exists), `GalleryHomeActivity` in `MainActivity` (taskbar section `gallery` and the `rizwans2://gallery` deep link),
    the Start menu entry in `StartApps.kt` and the Home icon in `Win11Shell.kt`.
  - `settings.gradle.kts` has `include(":gallery")`, `app/build.gradle.kts` has `implementation(project(":gallery"))`; `targetSdk = 28`,
    `requestLegacyExternalStorage` and the storage permissions are as in the other modules.
  - Safety of the exported viewer: a path or picture list is only read from an intent that carries this process's token; an outside `VIEW` intent
    brings only a data uri, which `ViewUri` resolves (files inside the app's private data are refused; a `content://` picture without a real path is
    copied into `cache/gallery_view/`, 256 MB max).
- **Left as is on purpose**: a few resources are declared but not used yet (`gl_ic_folder`, `gl_ic_image`, `gl_ic_more`, and the strings `gl_cd_empty`,
  `gl_cd_lock`, `gl_cd_more`, `gl_cd_play`, `gl_cd_refresh`, `gl_cd_select`). They are harmless, and `gl_ic_image` mirrors `GALLERY_PATH` in `StartApps.kt`.
- **No code changed in this step** (only this README). The plan table now shows all 13 steps done.
- **Please build once**: `./gradlew :app:assembleDebug`. If the compiler reports anything, it will most likely be a small type or nullability detail
  that static reading cannot prove; send the log and it will be fixed.
- Version stays 2.5.3 (code 120).

## Deep link by number — `rizwans2://N` (`app`: `MainActivity.kt`, `Win11Shell.kt`, manifest comment)

Any app of the Start menu can be opened by its serial number.

- **Links**: `rizwans2://1`, `rizwans2://#1` and `rizwans2://app/1` all open app number 1. `rizwans2://3` opens number 3, and so on.
  The plain `rizwans2://N` and `rizwans2://app/N` forms are the reliable ones: some browsers and launchers drop a `#fragment`.
  The named links (`rizwans2://gallery`, `files`, `start` ...) work as before.
- **Which number is which app**: the order of the Start menu's **All apps** list as shown on screen: the `#` group first, then A to Z by name.
  It includes the built-in apps (Files, Browser, Gallery, Video ...) and the apps installed on the device; **hidden apps are not counted**.
  Counting starts at 1 and does not include the letter headers.
- **One source of truth**: `Win11Shell.allAppsInOrder()` is used both to draw the list (`refreshAllApps()`) and to resolve the number, so the
  screen and the numbers cannot disagree. Opening goes through `Win11Shell.launchApp()`, like a tap on the list (built-in apps open inside the
  launcher, "Black box (default opener)" apps open in the virtual space, the app is added to Recent).
- **Out of range** (`rizwans2://99` with 40 apps), `0`, or more than 6 digits: nothing opens, nothing crashes; a line goes to `AppLog`.
- **Cold start**: if the app list is still loading when the link arrives, it is loaded first and the number is resolved right after.
- **Numbers move** when apps are installed, uninstalled, hidden or unhidden, or renamed, because the list is always the current one. A saved
  shortcut with a number should be checked after such a change; use the named links for the built-in apps if a fixed target is needed.
- Version stays 2.5.3 (code 120). No Android SDK here, so no Gradle build was run: **build once with `./gradlew :app:assembleDebug`**.


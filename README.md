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

## Fix — release build error in `FileManagerUi.kt` (CI run, `:app:compileReleaseKotlin`)

- **Error**: `FileManagerUi.kt:433: Backing field of 'var explorerUi: ExplorerUi' is not accessible at this point.` `openImageFile()` (step 10) is an
  extension function of `MainActivity`, and `::explorerUi.isInitialized` on a `lateinit` property only compiles inside the class that declares it.
- **Fix**: `MainActivity.shownExplorerFiles()` (new, next to `explorerUi`) does the `isInitialized` check and returns what the File Manager list shows
  (empty while it is not built yet). `openImageFile()` calls it. Behaviour is the same as before: the viewer gets the folder's pictures in the order
  the list shows them, or the folder's pictures in name order when the file is not in the list on screen.
- That was the only error in the log (`:gallery` and every other module compiled; the log shows `:gallery:assembleRelease` succeeding). Other uses of
  `::x.isInitialized` in `:app` were checked: they are all inside the class that owns the property.
- Version stays 2.5.3 (code 120). No Android SDK here, so the build was not re-run locally: **rebuild with `./gradlew :app:assembleDebug`** (or push to CI).

## Chooser — `:chooser` module (package `com.srizwan.chooser`)

Own "Open with" and Share sheets, and an own file picker, for this app's own calls. Why: `Intent.createChooser(...)` starts the **system** chooser
(on Tecno / Infinix / itel phones that is the Transsion `TranResolver`, which showed "App is not available" when it was disabled), and Android does not
let an app replace it for other apps. When our own code opens or shares something it can skip it instead: ask `PackageManager` which apps can handle the
intent, show a glass sheet, and start the chosen app directly. The module also becomes a file picker and an Open-with / Share target for other apps.
Same pattern as `:gallery` and `:video`: own module, resources prefixed `ch_`, glass UI, no text of its own (content descriptions only).

### Chooser plan (13 steps)

| # | Step | Status |
|---|------|--------|
| 1 | Module setup (`:chooser`, manifest, theme, glass UI kit, dependencies) | done |
| 2 | App finder (`AppFinder`: `queryIntentActivities` for view / send) | done |
| 3 | Own "Open with" sheet (grid of apps, just once / always) | done |
| 4 | Open-with launcher (explicit intent, FileProvider grant, failure handling) | done |
| 5 | File Manager hook (`openFile()` unsupported branch, "Open with" menu item, `BrowserUi`) | done |
| 6 | Own Share sheet (files, many files, text) | done |
| 7 | Replace the old share calls (`:gallery`, `:video`, `DebugLogActivity`, File Manager) | done |
| 8 | Own file picker (`FilePickerActivity`, used for the browser's file upload) | done |
| 9 | Be the system picker for other apps (`GET_CONTENT`, `OPEN_DOCUMENT`, `PICK`) | done |
| 10 | Be an Open-with / Share target for other apps (`VIEW`, `SEND`, `SEND_MULTIPLE`), glass UI | done |
| 11 | Prefs and polish (saved "always" choices, recent targets, list / grid style, columns, rotation) | done |
| 12 | Fallback to the system chooser when our sheet cannot be built | done |
| 13 | Final review, README, flat zip | done |

### Step 1 — module setup (`chooser/`, `settings.gradle.kts`, `app`, `gallery`, `video`)

- `chooser/build.gradle.kts`: Android library, `namespace = "com.srizwan.chooser"`, minSdk 26, compileSdk 37, Java / Kotlin 21, view binding, same coroutines
  1.8.1 pin as `:video` / `:gallery` (CI build #12 fix). Dependencies: core-ktx, appcompat, recyclerview (the app grid of step 3, the file list of step 8).
- `settings.gradle.kts`: `include(":chooser")`. `implementation(project(":chooser"))` in `app/build.gradle.kts`, `gallery/build.gradle.kts` and
  `video/build.gradle.kts` (`:gallery` and `:video` cannot depend on `:app`, which is why this is a module of its own).
- Manifest: empty on purpose (no permissions, no activities yet). The picker activity comes in step 8, the intent filters in steps 9 and 10.
- Resources: `ch_bg`, `ch_text`, `ch_text_dim`, `ch_accent` colours (same values as `gl_*`), `Theme.Chooser` (dark, like `Theme.Gallery`), `ch_cd_*`
  content descriptions (`back`, `close`, `confirm`), and the vector icons `ch_ic_back`, `ch_ic_close`, `ch_ic_check`. More icons and strings are added by the
  step that uses them.
- **Glass UI kit** (`chooser/ui`): an independent copy of the `:gallery` classes, renamed to `com.srizwan.chooser.ui` and to the `ch_` resources:
  `GlassDrawable`, `GlassSheet` (list picker), `GlassToast`, `GlassControls` (`GlassUi`, `GlassBar`, `GlassToolbar`, `GlassTabs`, `GlassConfirm`),
  `VectorText` and `VectorLabelDrawable` (text drawn as vector outlines, so there is no `TextView`), `GlassEmptyState`, `GlassPrompt` and
  `GlassShimmerView`. Not copied: `GlassInfoSheet` (it shows gallery's `ImageInfo`). The class names equal the `:gallery` ones but live in another
  package, so nothing clashes in `:app`.
- Checked (static): every `R.*` reference resolves, packages match folders, braces balance, no `gl_` / gallery leftovers in code, no `ch_` name used by
  another module.
- `:app` code, `:gallery` code, `:video` code and `:youtube` are unchanged apart from the one dependency line in each build file. Version stays 2.5.3 (code 120).
- No Android SDK / network in this environment: a Gradle build was **not** run. Build once with `./gradlew :app:assembleDebug`.

### Step 2 — app finder (`chooser/data`)

The list the system chooser would build, built by us. No UI yet: the sheets of steps 3 and 6 show it, step 4 starts the chosen app.

- **`Target`** (+ `ChooserKind { VIEW, SEND }`): one app / activity that can handle an intent: `label`, `component` (`ComponentName`), `icon`, `isSelf` (an activity of
  this app, for example the Gallery viewer), `packageName`, and `key` (`package/class`, the key used for the saved choices).
- **`AppFinder`** (`object`):
  - `queryView(context, uri, mime)` / `queryViewName(context, fileName)`: apps that can open a file (`ACTION_VIEW`). With no uri a stand-in
    `content://com.srizwan.chooser.probe/file` is used: matching a `VIEW` filter only looks at the scheme (`content`, what step 4 opens files with) and the type,
    so the list is built without touching any file.
  - `querySend(context, mime, count)`: apps that can receive one file / text (`ACTION_SEND`) or several files (`ACTION_SEND_MULTIPLE` for `count > 1`).
  - `findView`, `findViewName`, `findSend`: the same as `suspend` functions on `Dispatchers.IO`. The `query*` functions block (package manager + icon loading), so
    they belong on a background thread.
  - `viewIntent()` / `sendIntent()` build the intents used for matching (step 4 reuses them).
  - **What is filtered**: only activities with `CATEGORY_DEFAULT` (`MATCH_DEFAULT_ONLY`, what an implicit intent needs); disabled activities (the package manager does not return
    them); not-exported activities unless they are ours; the system choosers themselves (`android`, `com.android.intentresolver`, `com.google.android.intentresolver`,
    `com.transsion.resolver` = TranResolver); duplicates (the same component, or the same package with the same label).
  - `includeSelf = false` hides this app's own activities (for a Share sheet that should not offer the launcher to itself; for Open with it stays `true`).
  - **Order**: the apps chosen before for this kind and MIME family first (most recent first), then the rest by name (case-insensitive).
  - A `PackageManager` failure is logged (`AppFinder`) and gives an empty list, never an exception.
- **`MimeTypes`**: `forName(name)` (platform table, then a small table for `apk`, `mkv`, `heic`, `exe`, `lnk`, `md` ... , else `*/*`), `forNames(list)` (the one type for several files:
  the same type, else `family/*`, else `*/*`; this is the type `ACTION_SEND_MULTIPLE` needs), `family(mime)`.
- **`ChooserPrefs`** (file `chooser_prefs`): the recent choices per kind and MIME family, at most 12 each: `recent()`, `recordChoice()` (step 4 calls it after a pick), `forget()` (for an app
  that can no longer be started). Step 3 added the saved "always" choices (see below); step 11 adds the settings here.
- **Package visibility**: `targetSdk = 28`, so every app is visible without `<queries>`. If targetSdk is raised to 30 or more, `:app` needs `<queries>` for `VIEW` and `SEND`,
  or the list comes back (nearly) empty. Noted in the `AppFinder` KDoc.
- Not done on purpose: no "default app" marker yet (step 3 / 11), no UI, no manifest change. `:app`, `:gallery`, `:video`, `:youtube` are unchanged. Version stays 2.5.3 (code 120).
- Checked (static): packages match folders, braces balance, no unused imports, no `gl_` leftovers. No Android SDK here, so no Gradle build was run: **build once with `./gradlew :app:assembleDebug`**.

### Step 3 — own "Open with" sheet (`chooser/openwith`, `chooser/ui`, `chooser/data`)

A glass bottom sheet with the apps that can open a file, instead of the system chooser. It only **chooses**: starting the app is step 4. Nothing in `:app`, `:gallery`,
`:video` calls it yet (step 5 hooks it into the File Manager and the browser), so this step changes no behaviour of the existing apps.

- **`OpenWithSheet.show(activity, fileName, mime = null, includeSelf = true, onCancel = null) { target, always -> ... }`** (package `com.srizwan.chooser.openwith`):
  - Opens at once with a loading skeleton, then fills the grid from `AppFinder.findView` (on `Dispatchers.IO`; the work is cancelled when the sheet closes).
  - The type is `mime`, else the one of `fileName`'s extension, else `*/*`. The file name is shown under the title.
  - **Grid**: app icon + name (two lines at most, vector outlines). Columns fit the screen (76 dp per tile, 3 to 6). The last row keeps the same tile width.
  - **Choosing**: tap an app to select it (accent outline); **Just once** and **Always** are greyed out until one is selected. Tapping the selected app again = Just once.
    The result goes to `onChoose(target, always)` and the sheet closes. Tap outside / Back calls `onCancel` instead.
  - **Long-press** an app: haptic tick + the system "App info" screen of that app (`ACTION_APPLICATION_DETAILS_SETTINGS`). A failure is only logged.
  - **Empty state** (nothing can open the file): "No app can open this", "None of your installed apps can open PDF files." and **Find in store**. The store search is the Play Store
    with an explicit package (`market://search?q=pdf viewer`, so no chooser can appear), else the web page of the same search, else a glass toast "No store app is available".
  - Not done here on purpose: the sheet does not start the app and does not save "Always" or the recent list. The launcher of step 4 does both, and only after the app really started,
    so an app that fails is never remembered.
- **`ChooserPrefs`**: new "always" API, one app per kind and exact MIME type (`always_<kind>_<mime>`): `always()`, `setAlways()`, `clearAlways()`, `allAlways()`, `clearAllAlways()`.
  Step 4 checks that the saved component still exists before using it and clears it when it does not; step 11 shows the list in the settings.
- **New UI pieces** (`chooser/ui`): `GlassButtons` (`pill()` accent / glass text button with an optional icon, `setEnabled()`), `GlassShimmerView.Style.APPS` (icon grid skeleton),
  `GlassToast.showOn(activity, ...)` (shows a toast on a screen that never set the toast host, which is every screen the sheets run on).
- **Resources**: icons `ch_ic_open_with`, `ch_ic_info`, `ch_ic_error`, `ch_ic_apps`, `ch_ic_store`; strings `ch_open_with`, `ch_just_once`, `ch_always`, `ch_open_hint`, `ch_open_empty_title`,
  `ch_open_empty_text`, `ch_find_in_store`, `ch_toast_no_store`.
- **Bug fixed from step 2**: the KDoc of `MimeTypes.forNames()` contained two `/*` sequences. Kotlin comments nest, so the comment never closed and `chooser` would not have compiled.
  Reworded; the string literals `"*/*"` and `"/*"` in code are fine. A scan of all `chooser` sources now finds no `/*` inside a comment.
- Known limits, handled later: the sheet is a dialog, so a rotation closes it (step 11 sets the `configChanges` / re-opens it); the grid is built from all apps at once (no recycling),
  fine for the usual few dozen apps; the Play Store web fallback uses a normal `startActivity` (only reached when the Play Store is missing).
- Checked (static): packages match folders, braces balance, comments balance, every `R.*` resolves, no unused imports in the new files. No Android SDK here, so no Gradle build was run:
  **build once with `./gradlew :app:assembleDebug`**. Version stays 2.5.3 (code 120).

### Step 4 — open-with launcher (`chooser/openwith`, `chooser/data`, manifest)

The call the rest of the app will use: it finds the app (saved "Always" app or the sheet of step 3), starts it with an explicit intent and looks after failures.
Still not called from `:app`, `:gallery`, `:video` (step 5), so existing behaviour is unchanged.

- **`OpenWith.show(activity, file, mime = null, includeSelf = true, forceSheet = false, authority = null, onResult = null)`** and
  **`OpenWith.show(activity, uri, fileName = null, mime = null, ...)`** (package `com.srizwan.chooser.openwith`). Main thread.
  1. **Saved "Always" app** for the MIME type: checked with `AppFinder.canStartView` (installed, enabled, exported or ours, not a system chooser) and started at once, no sheet.
     If it is gone, the saved choice is deleted and the sheet opens. `forceSheet = true` skips this (the "Open with" menu item of step 5).
  2. Otherwise the glass `OpenWithSheet` opens and the chosen app is started with an **explicit intent** (`ACTION_VIEW` + `setComponent`): no resolver, no chooser, so TranResolver is never involved.
  3. **File access**: a `File` goes out as `content://` through `ChooserFileProvider` (or the caller's own provider when `authority` is given); a `content://` uri is passed on unchanged;
     a `file://` uri is turned into a `File` first. The intent carries `FLAG_GRANT_READ_URI_PERMISSION` and a `ClipData` with the uri.
  4. **After a successful start**: the app goes to the front of the recent list, and when **Always** was pressed it is saved as the default for that MIME type. Nothing is saved before the start works.
  5. **Failures** (never an exception to the caller): the app cannot be started (`ActivityNotFoundException`, `SecurityException`, a crash while starting) -> glass toast "This app could not open the file",
     the app leaves the recent list, and if it was the saved default the default is deleted (when it was a saved default the sheet then opens so the user can pick another app). A missing file ->
     toast "The file is not available"; the saved choices are not touched (the app is not to blame).
  - `onResult(OpenWith.Result)`: `Outcome.STARTED` (+ the component), `CANCELLED` (sheet closed without a choice) or `FAILED` (the toast was already shown).
- **`ChooserFileProvider`** (`chooser/data`): own `FileProvider` subclass, authority `${applicationId}.chooser.fileprovider`, `res/xml/ch_file_paths.xml` (`root-path`, like the Gallery's).
  Declared in the **`:chooser` manifest** (not exported, `grantUriPermissions`), so every module gets it through the manifest merge. Own class name, so it cannot clash with
  `GalleryFileProvider` / `WinlatorFileProvider` / the plain `androidx` one.
- **`AppFinder.canStartView(context, component, mime)`**: one `resolveActivity` call, no icons.
- **`ChooserPrefs`**: `recordChoice` and `setAlways` also take a component key (a saved app is started without a `Target`).
- **Strings**: `ch_toast_open_failed`, `ch_toast_file_missing`.
- Known limits: an app that only accepts `file://` paths (very old apps) fails with a toast, since Android 7+ forbids handing out `file://` uris; an app that starts and then
  closes by itself cannot be detected. The Share launcher (step 6) will reuse `ChooserFileProvider`.
- Checked (static): packages match folders, braces balance, every `R.*` resolves, no unused imports, no nested `/*` in comments. No Android SDK here, so no Gradle build was run:
  **build once with `./gradlew :app:assembleDebug`**. Version stays 2.5.3 (code 120).

### Step 5 — File Manager and browser hooks (`:app`)

First step that changes what the app does: `:app` now calls `OpenWith` (step 4). Three small edits, nothing else in `:app` changed.

- **`FileManagerUi.openFile()`**: the last branch (a file with no built-in viewer, which showed the toast "Unsupported file") is now `OpenWith.show(this, file)`. The order of the other
  branches is unchanged (folders, video, `.txt`, `.pdf`, `.zip`, images, Windows programs run in Winlator), so those still open in the built-in apps. For everything else a saved
  "Always" app opens at once; otherwise the glass sheet appears.
- **`FileManagerUi.showFileOptions()`** (long-press menu): new first item **"Open with..."** for files (not folders), `OpenWith.show(this, file, forceSheet = true)`: it always shows the
  sheet, also for types the app opens itself, and ignores a saved "Always" app (this is how a saved choice can be bypassed). Winlator items and the rest of the menu are as before.
- **`BrowserUi.openDownloaded()`** (the old `BrowserUi.kt:499`, opening a finished download): `Intent.createChooser(view, "Open with")` is replaced by
  `OpenWith.show(this, uri, fileName = t.fileName, mime = mime)`. "File not available" for a download without a saved uri is unchanged.
  The `uri` may be `content://` (passed on as it is) or `file://` (turned into a `File` and served through `ChooserFileProvider`).
- Imports: `com.srizwan.chooser.openwith.OpenWith` in both files. No manifest change in `:app` (the provider comes from the `:chooser` manifest).
- Still using the system chooser (on purpose, steps 6 and 7): `DebugLogActivity.share()` and the Gallery's share calls.
- Behaviour to know: the Open with list includes this app's own activities (`includeSelf` stays true), so for example a picture can also be sent to the Gallery viewer from there.
- Checked (static): the three anchors matched exactly once, imports resolve, no `createChooser` left in `BrowserUi`. No Android SDK here, so no Gradle build was run:
  **build once with `./gradlew :app:assembleDebug`**. Version stays 2.5.3 (code 120).

### Step 6 — own Share sheet and launcher (`chooser/share`, `chooser/ui`)

The Share twin of steps 3 and 4. Not called from `:app`, `:gallery`, `:video` yet (step 7 does that), so existing behaviour is unchanged.

- **`Share`** (launcher, package `com.srizwan.chooser.share`, main thread):
  - `Share.file(activity, file, mime = null, includeSelf = false, authority = null, onResult = null)`, `Share.files(activity, files, ...)`,
    `Share.uris(activity, uris, names, mime, ...)`, `Share.text(activity, text, subject = null, ...)`.
  - One file / uri = `ACTION_SEND`; several = `ACTION_SEND_MULTIPLE` with the common type (`MimeTypes.forNames`, or `mime` when given); text = `ACTION_SEND` `text/plain` (+ `EXTRA_SUBJECT`).
  - Files go out as `content://` through `ChooserFileProvider` or the caller's own provider (`authority`, for example the Gallery's); a `file://` uri is turned into a `File` first;
    the intent has `FLAG_GRANT_READ_URI_PERMISSION` plus a `ClipData` holding every uri. Files that do not exist are left out; none left = toast "The file is not available".
  - The chosen app is started with an **explicit intent** (`setComponent`), no system chooser. After a successful start it goes to the front of the recent list (kind `SEND`, per MIME family).
    A failure (`ActivityNotFoundException`, `SecurityException`, too-large text, a crash while starting) = glass toast "This app could not receive it" and the app leaves the recent list.
    Nothing throws to the caller. No "Always" for sharing.
  - Result: the same `OpenWith.Result` as the open-with launcher (`STARTED` + component, `CANCELLED`, `FAILED`).
  - This app's own activities are hidden by default (`includeSelf = false`); step 10 makes the File Manager a share target for other apps.
- **`ShareSheet`**: the glass sheet. **Header**: thumbnail (the first picture, decoded off the main thread into a rounded square, else a file / text icon), "Share", and one line: the file name,
  "3 files", or the first line of the text (120 characters). **Recent first**: the apps used for earlier shares of this kind (one row at most) under "Recent", the rest under "All apps"
  (no headings when nothing was shared before). **One tap sends**; press and hold shows the App info. **Copy** button for text (clipboard + toast "Copied"). Nothing can receive it:
  message "No app can receive this" (with Copy for text).
- **`AppGrid`** (`chooser/ui`, new): the grid (tile, rows, columns, App info on long-press), section label, selected / ripple backgrounds and the empty state, moved out of `OpenWithSheet` so both
  sheets share them. The Open with sheet looks and behaves exactly as in step 3.
- Resources: icons `ch_ic_share`, `ch_ic_file`, `ch_ic_text`, `ch_ic_copy`; strings `ch_share`, `ch_share_recent`, `ch_share_all`, `ch_share_count`, `ch_copy`, `ch_toast_copied`,
  `ch_share_empty_title`, `ch_share_empty_text`, `ch_toast_share_failed`. Also removed an unused import in `GlassToast`.
- Not done on purpose: the "Save to device" action of the plan (a share target that is a folder). It is better placed with the picker (step 8), where a folder choice exists. Thumbnails are
  only made for picture **files** (`Share.file(s)`), not for `Share.uris`.
- Checked (static): packages match folders, braces and comments balance (string literals ignored), every `R.*` resolves, no unused imports. No Android SDK here, so no Gradle build was run:
  **build once with `./gradlew :app:assembleDebug`**. Version stays 2.5.3 (code 120).

### Step 7 — all share calls use the own Share sheet (`:gallery`, `:video`, `:app`)

Every `Intent.createChooser` of the project is gone (a search of `:app`, `:gallery`, `:video`, `:youtube`, `:winlator` finds none; only `ACTION_SENDTO` links for `mailto:` / `sms:` in the browser remain, which are not choosers).

- **`:gallery` `ImageActions.share()` / `shareMany()`**: same signatures and the same checks (file exists, at most `MAX_SHARE` = 300 pictures, one usable picture = `share()`), but they now call
  `Share.file(...)` / `Share.files(...)` with `authority = GalleryFileProvider.authority(activity)`: the Gallery keeps its own FileProvider, as planned. The mixed-type rule is unchanged (one type, else `image/*`).
  The viewer and the selection bar call them as before. The Boolean means "the sheet was started"; errors after that (an app that cannot receive) are shown by the Share sheet's own glass toast.
  Unused imports (`ClipData`, `Intent`, `Uri`) removed.
- **`:video` `VideoPlayerActivity`**: new **Share chip** (icon `vp_ic_share`, description `vp_cd_share`) first in the chip row at the top right, glass like the others, hidden with the controls. A local
  file is shared as a file (through `ChooserFileProvider`, the video module has no provider of its own), a `content://` video as a uri (`video/*`), an online video (`http` / `https`) as its
  **link** (text, with the Copy button), so a stream can be shared too. The title / chip placement code measures the row, so the extra chip needs no other change.
- **`:app` `DebugLogActivity.share()`**: `Share.text(this, log.takeLast(100_000), subject = "Win11 debug log")`. The old "Share log" chooser title is gone (the sheet's title is "Share"); the Copy button is new.
- **`:app` File Manager**: it had no share action. The long-press menu of a file now starts with **"Open with..."** and **"Share"** (`Share.file(this, file)`); the rest of the menu is unchanged.
- The Share sheets hide this app's own activities (`includeSelf = false`), so the launcher does not offer itself yet (step 10 changes that on purpose).
- Needs `:gallery` and `:video` to depend on `:chooser`: both do since step 1.
- Known limits: the Video app's list screen (`VideoHomeActivity`) has no share action (it never had one); a very large text still can overflow the binder limit, in which case the app is reported with the failure toast.
- Checked (static): braces and parentheses balance in every edited file, imports resolve, no `createChooser` left. No Android SDK here, so no Gradle build was run:
  **build once with `./gradlew :app:assembleDebug`**. Version stays 2.5.3 (code 120).

### Step 8 — own file picker (`chooser/picker`, `:app` browser upload)

A glass file picker that replaces the system `ACTION_GET_CONTENT` screen for this app's own calls. Package `com.srizwan.chooser.picker`. Not exported yet: other apps get it in step 9.

- **`FilePicker`** (public API): `FilePicker.intent(context, multiple, mimeTypes, foldersOnly, startDir, title)` builds the explicit intent (no resolver, no chooser); start it with any `StartActivityForResult` launcher.
  `FilePicker.uris(data)` reads the result (clip first, else `data`), `FilePicker.paths(data)` the plain paths. `mimeTypes` may hold MIME types, families (`image/` + star) or extensions (`.pdf`), the way a web page's `accept` attribute gives them.
- **Result**: `content://` uris from `ChooserFileProvider` with `FLAG_GRANT_READ_URI_PERMISSION` and a `ClipData` (the grant covers every uri when several files are chosen); `data` is the first one.
  Only when the caller is **this app** the result also carries the paths (`EXTRA_RESULT_PATHS`), and only then are `startDir` and the folder mode honoured (`PickerOptions.fromIntent(intent, trusted)`). A foreign caller can set `multiple` and the types, nothing else.
- **`FilePickerActivity`** (theme `Theme.Chooser`, `configChanges` like the Gallery's, so rotation keeps the screen):
  - **Storage screen** (house icon in the breadcrumb): internal storage (free space shown), removable cards / USB drives the app can see, and the usual folders (Downloads, DCIM, Pictures, Movies, Music, Documents) when they exist.
  - **Breadcrumb** under the bar: tap a part to jump there. **List or grid** (icon in the bar; pictures and videos show thumbnails). **Search** (icon in the bar): recursive name search below the folder on screen, parent folder shown under each hit.
  - **Options sheet** (sort icon): sort by name (numbers in natural order), date, size or type (folders always first), show hidden files, and "only the files the app asked for" (shown only when the caller gave types; on by default, so the user can still reach any file).
  - **One file**: a tap returns it. **Many files**: a tap (or press and hold) ticks, the bottom bar shows "n selected" and **Select**. **Folder mode** (own callers only): bottom bar shows the folder name and **Use this folder**; the result is a path.
  - **Back** closes the search, then clears ticks, then goes up a folder, then to the storage screen, then closes (the top-left icon is a cross on the storage screen).
  - **Storage access**: lists with `java.io.File`, so it needs the access `:app` already holds. Without it a glass card with an **Allow** button opens the all-files access screen (Android 11+) or asks for the read permission, and the list reloads when the user comes back. No permission line was added to the `:chooser` manifest.
  - Remembers the last folder, the list / grid choice, the sort order and the hidden-files switch in `ChooserPrefs` (`picker_*` keys; step 11 puts them in the settings).
- **Supporting classes**: `PickerOptions`, `PickerEntry` / `PickerSort`, `PickerLister` (listing, filter, natural sort, search with limits: 400 hits, 8 levels, 20 000 folders, symbolic links not followed), `PickerRoots`, `PickerThumbs` (3 background threads, memory cache, EXIF rotation, first frame of a video; a file that cannot be decoded keeps its icon), `PickerAdapter` (list and tile rows, all vector drawing like the rest of the kit).
- **Resources**: 13 new `ch_ic_*` icons (folder, search, grid, list, sort, filter, image, video, audio, storage, lock, chevron, home) and the `ch_picker_*` strings; the manifest gets the `FilePickerActivity` entry.
- **`:app`**: `BrowserUi` `onShowFileChooser` (the old `BrowserUi.kt:696`) starts the picker with the page's accept types and its "multiple" flag; if the picker cannot start it falls back to the old system screen (so an upload never silently dies).
  `MainActivity.fileChooserLauncher` now passes on every returned uri (several files when the page allows it), not only the first.
- Known limits: the picker lists real files only (no cloud or "Recent" sources); `OPEN_DOCUMENT_TREE` (a folder for other apps) needs a `DocumentsProvider` and comes with step 9; video thumbnails are the first frame, so a black first frame gives a black tile.
- Checked (static): braces / parentheses balance in every new file, every `R.string`, `R.drawable` and `R.color` used exists, the three `:app` anchors matched exactly once. No Android SDK here, so no Gradle build was run:
  **build once with `./gradlew :app:assembleDebug`**. Version stays 2.5.3 (code 120).

### Step 9 — be the file picker for other apps (`chooser` manifest, `picker`)

Other apps that ask Android for a file now list this picker next to the system ones. The screen is the one from step 8; this step exports it and makes it safe for strangers.

- **Manifest**: `FilePickerActivity` is `exported="true"` with filters for `GET_CONTENT` and `OPEN_DOCUMENT` (category `OPENABLE`, type `*/*`), `PICK` (type `*/*`) and `PICK` on the media store (`vnd.android.cursor.dir/image`, `/video`, `/audio`, the gallery-style "choose a picture").
- **What a foreign app can ask for**: `EXTRA_ALLOW_MULTIPLE`, and the types (`EXTRA_MIME_TYPES`, else the intent's type). Every type is checked (a MIME type, a family or `.ext`, at most 60 + 60 characters, 256 entries read, 64 kept); anything else is dropped. The media-store directory types become `image/*`, `video/*`, `audio/*`.
  The picker applies them as the "only the files the app asked for" filter, which the user can switch off in the options sheet.
- **What a foreign app never gets** (unchanged rule from step 8, now live): plain file paths, a start folder, the folder mode, a custom title. It gets `content://` uris from `ChooserFileProvider` with `FLAG_GRANT_READ_URI_PERMISSION` and a `ClipData`, for the files the user ticked. A caller is "this app" only when `callingActivity` is our own package.
  A foreign caller can have at most **200** files ticked at once.
- **Not offered**: `OPEN_DOCUMENT_TREE` (a folder for another app) needs a `DocumentsProvider`; the optional `DocumentsProvider` (so the storage also shows in the system "Files" screen) is left for later.
- **Known limit** (replaced by the overlay step below): the minimized pop-up used to float only inside this app.

### Step 10 — be an Open-with / Share target for other apps (`chooser/receive`, manifest, `:app`)

This app now appears in other apps' "Open with" and Share lists. What opens is a glass sheet over a see-through screen, not a plain screen.

- **Manifest** (`:chooser`): `ReceiveActivity` is **not exported**; two exported `activity-alias` entries give other apps two clear names: **"Win11 Open with"** (`VIEW`, scheme `content`, type any) and **"Save to Win11 Files"** (`SEND` and `SEND_MULTIPLE`, type any). Own theme `Theme.Chooser.Receive` (translucent, no animation), `taskAffinity=""`, `excludeFromRecents`.
- **`ReceiveActivity`** (glass sheet: header with thumbnail or icon, title, name and size, then pill buttons):
  - one file: **Open with** (our own glass app sheet), **Save to Files**, **Share**; many files: **Save to Files**, **Share**; text or a link: **Copy**, **Save as text file**, **Share**.
  - a `VIEW` for which an "Always" app is saved opens in that app at once (the sheet shows busy while the private copy is made, and the app list only if that app fails).
  - **Save to Files**: streams into `Download/Received` (checked with a real write; else the app's own `Received` folder), never overwrites (`name (1).ext`), rescans public files for the gallery, then shows "Saved to ..." with **Show in Files** (opens the File Manager in that folder) and **Done**. "Saved 2 of 3" when some failed.
  - Open with and Share work on a private copy in `cache/received/` (the sender's access ends with this screen); copies older than 24 hours are removed at the next start.
  - Tapping outside or Back cancels a running copy and deletes the partial file.
- **Safety** (`ReceiveParser`, `ReceiveSaver`): only `content://` uris are accepted (`file://` never); uris of this app's own providers are dropped (`ChooserFileProvider` serves any path, so a stranger could otherwise make us copy private files to a public folder); at most 200 files and 200,000 characters of text; MIME types must look like `type/subtype`; file names are cleaned (no path, control characters or leading dot, at most 120 characters) and checked to stay inside the folder.
- **No loops**: `AppFinder` hides the receive screen and its aliases from this app's own lists (also a saved "Always" for it is refused), so our own sheets never offer it.
- **`:app`**: deep link `rizwans2://files?path=<folder>` opens the File Manager in that folder (only an existing folder on the shared storage). `QuickControlsActivity`: the "Debug log" tile now has its own vector icon `ic_qs_log` (a document with lines) instead of the bell.
- Strings: `ch_recv_*`, `ch_label_*_alias`. New icon `ch_ic_save`.
- Not done yet (steps 11 to 13): settings screen, rotation re-layout of the app grid, system-chooser fallback, final review.
- Checked (static): braces, parentheses and comments balance in every `:chooser` source, all XML parses. No Android SDK here, so no Gradle build was run: **build once with `./gradlew :app:assembleDebug`**. Test: in Chrome or Files share a file, choose "Save to Win11 Files"; or open a PDF from another app and choose "Win11 Open with". Version stays 2.5.3 (code 120).

### Step 11 — settings and polish (`chooser/settings`, `chooser/data`, `chooser/ui`, `chooser/openwith`, `chooser/share`, manifest, `:app`)

Only this step was done in this round (steps 12 and 13 followed in the next round).

- **Settings screen** `ChooserSettingsActivity` (glass screen like the picker: floating bar, cards under it, at most 640 dp wide on a tablet; not exported; rotation handled with `configChanges`). Opened by the **gear** in the header of the Open with and Share sheets, by `ChooserSettings.open(context)`, and by the deep link **`rizwans2://chooser`** (`:app` `MainActivity.handleDeepLink`; the Start menu list is not changed, so the numbers of `rizwans2://N` stay as they were).
  - **Open with and Share**: *Style* = Grid / List; *Apps per row* = Auto, 3, 4, 5, 6 (grid only; never more than fit the screen, tiles stay at least 56 dp wide).
  - **Recent apps**: switch *Remember recent apps* (off: nothing new is remembered, and the Recent row and the ordering by last choice are hidden; the stored lists are kept), how many are remembered, **Clear recent apps**.
  - **Saved apps**: every "Always" choice with the app's icon and name, the kind (Open / Share) and the file type, a remove button each, and **Clear all saved apps** (asks first). An app that is no longer installed shows as "This app is not installed any more" so it can be removed.
  - **File picker**: **Reset file picker** forgets the last folder, sort order, hidden-files switch and list / grid choice.
- **`ChooserPrefs`** (keys of the new settings start with `opt_`, so they never clash with `recent_`, `always_`, `picker_`): `recentEnabled`, `sheetList`, `sheetColumns`, `recentCount`, `clearAllRecent`, `alwaysEntries` (+ `AlwaysEntry`), `resetPicker`. `forget` still drops a dead app from the stored list when remembering is off.
- **Sheets** (`AppGrid`, `OpenWithSheet`, `ShareSheet`, `GlassSheet`):
  - the list style (`AppGrid.isList`) shows one app per row; `AppGrid.columnsFor` reads the saved column count; the Share sheet shows up to three recent apps in the list style (one row of them in the grid).
  - **very long app list**: the apps sit in their own scroll area (`AppGrid.scroller`, as tall as the screen allows minus the rest of the sheet, 72 % of the height in portrait, 92 % in landscape), so **Just once / Always** and **Copy** never scroll out of reach. A short list does not scroll.
  - **rotation**: `AppListHost` rebuilds the list with the new number of columns, keeps the selected app, and `GlassSheet.showContent(maxFraction = ...)` reads its height limit again on every measure.
  - **apps that disappear while the sheet is open**: `PackageWatcher` (a receiver for package added / removed / replaced / changed, one call 400 ms after the last broadcast) makes the sheet ask `AppFinder` again; the selected app is dropped from the selection when it is gone. The sheet also asks again when its window gets the focus back (after the settings or an App info screen). The receiver is stopped when the window goes away, however that happens.
- New: `ui/GlassSwitch.kt` (the on / off switch), `ui/AppListHost.kt`, `data/PackageWatcher.kt`, `settings/ChooserSettings.kt`, `settings/ChooserSettingsActivity.kt`; vector icons `ch_ic_settings`, `ch_ic_delete`, `ch_ic_history` (vector drawables only, no emoji); strings `ch_set_*`, `ch_kind_*`, `ch_toast_cleared / removed / reset`, `ch_cd_settings`, `ch_cd_remove`.
- Not done yet (steps 12 and 13): fallback to the system chooser when our sheet cannot be built, final review.
- Checked (static): braces, parentheses and comments balance in every `:chooser` source and in `MainActivity.kt`, all XML parses, every `R.string.ch_*` and `R.drawable.ch_*` that is used exists. No Android SDK here, so no Gradle build was run: **build once with `./gradlew :app:assembleDebug`**. Test: open `rizwans2://chooser`, choose List and 4 columns, then open a PDF from the File Manager; press Always for an app, see it under Saved apps and remove it; rotate the phone while the Open with sheet is open; uninstall an app while a sheet is open. Version stays 2.5.3 (code 120).

### Step 12 — fallback to the system chooser (`chooser/data`, `chooser/openwith`, `chooser/share`)

The own sheets never depend on the system chooser, but when one of them cannot be built at all, the action is not lost: the same intent goes to `Intent.createChooser`, inside a try / catch, as the last resort.

- **When it triggers** (both Open with and Share, text included):
  - building the sheet throws (for example a window error): `OpenWith.run` / `Share.run` catch it;
  - the package manager cannot give the **first** app list: `AppFinder` has new strict twins (`queryViewStrict`, `querySendStrict`, `findViewStrict`, `findSendStrict`) that throw `AppFinder.QueryFailedException`; the plain `query*` / `find*` still return an empty list, as before. The sheets use the strict ones, so "no app can open this" now means really none, and a failed query is told apart from it. The sheet closes itself (without the cancel callback) and calls its new `onFailure` parameter (`OpenWithSheet.show`, `ShareSheet.show`; when it is null the sheet shows the "no app" state instead).
  - a failed **refresh** (an app was installed or removed while the sheet is open) never triggers it: the list on screen stays.
- **What it does**: `OpenWith.systemChooser` builds the `ACTION_VIEW` (content uri, read grant, clip data) and `Share.systemChooser` the send intent without a component (`makeIntent` now takes a `ComponentName?`; `null` = no component), and starts `Intent.createChooser(intent, null)`. The result is `STARTED` without a component and nothing is remembered (the system picks the app). When even that fails a glass toast says so and the result is `FAILED`. A missing file is still reported as a missing file. Both write a line to the log.
- **Not changed on purpose**: the saved "Always" app still starts at once without any sheet; the file picker already had its own fallback (`BrowserUi`: `FilePicker` first, then `ACTION_GET_CONTENT`, then the page gets `null`).
- Note: the system chooser that is used here is the one this module exists to avoid (on Tecno / Infinix / itel it can be the "TranResolver"). It is only reached when our own sheet is broken, which should be very rare.

### Step 13 — final review and delivery

- **Review** (static, no Android SDK here): braces, parentheses and brackets balance in all 37 checked Kotlin sources (`:chooser` and `MainActivity.kt`); all XML parses (resources, `:chooser` manifest, `:app` manifest); every `R.string.ch_*` and `R.drawable.ch_*` that the code uses exists; every call of the form `Object.function(...)` on a `:chooser` object points at a function that exists; the only callers of the sheets are the two launchers; `:app`, `:gallery` and `:video` use only the launchers (`OpenWith`, `Share`, `FilePicker`, `ChooserSettings`), whose public signatures did not change (new parameters have defaults).
- **Module map** (`:chooser`, package `com.srizwan.chooser`): `data` (`AppFinder`, `ChooserPrefs`, `MimeTypes`, `Target`, `PackageWatcher`, `ChooserFileProvider`), `openwith` (`OpenWith`, `OpenWithSheet`), `share` (`Share`, `ShareSheet`), `picker` (`FilePicker`, `FilePickerActivity`, adapter, lister, roots, thumbs, options), `receive` (`ReceiveActivity`, `ReceiveSaver`, `ReceivedContent`), `settings` (`ChooserSettings`, `ChooserSettingsActivity`), `ui` (the glass kit: sheet, bar, toolbar, tabs, switch, buttons, toast, text, app grid, app list host, empty state, shimmer, prompt).
- **How the pieces are used**: File Manager, Browser, Debug log, Gallery and Video call `OpenWith` / `Share`; the browser's file upload calls `FilePicker`; other apps reach this app through the picker filters (`GET_CONTENT`, `OPEN_DOCUMENT`, `PICK`) and the two `ReceiveActivity` aliases ("Win11 Open with", "Save to Win11 Files"); the settings open from the gear of the sheets or `rizwans2://chooser`.
- **Known limits**:
  - `targetSdk` is 28, so `queryIntentActivities` sees every app. If it is raised to 30 or more, `:app` needs `<queries>` entries for `VIEW` and `SEND`, or the app lists come back (nearly) empty (and the strict queries will not report that as a failure).
  - Android cannot make other apps use our chooser when they call the system one; only this app's own calls are covered.
  - `OPEN_DOCUMENT_TREE` is not offered (it needs a `DocumentsProvider`); not done.
  - The `ReceiveActivity` sheet (step 10) is not covered by the settings of step 11 (it has its own fixed buttons).
- **Fixes after step 13** (found on a Tecno / Transsion phone, not tested on a device here):
  - *Notification sound picker showed TranResolver*: `NotificationSettingsActivity.pickSound()` started `ACTION_RINGTONE_PICKER` as an implicit intent, which the `:chooser` sheets never covered (they only replace Open with, Share and file picking). `findRingtonePicker()` now picks one handler (AOSP `RingtonePicker` first, then any system app, resolver / chooser classes skipped) and starts it with `setComponent`; no handler found = the old implicit intent.
  - *No Bluetooth in the Share sheet*, even for pictures, videos and audio: `queryIntentActivities` did not return the system Bluetooth sender. `AppFinder.withBluetooth()` (used by `querySendStrict`) now looks up `BluetoothOppLauncherActivity` directly in the installed packages with "bluetooth" in the name when the normal query has none, and adds it when it is exported, enabled and has no permission. Log tag `AppFinder` says what was found / skipped (`adb logcat -s AppFinder`). Does not help when the phone has no Bluetooth sender at all.
  - *Play Store (`com.android.vending`) died ~6 s after start inside BlackBox* (Tecno KN3, Android 15): `IConnectivityManagerProxy` had no hook for `getNetworkInfoForUid`; the system refuses that call for any uid but the caller's real one (SecurityException "Requires ACCESS_DOWNLOAD_MANAGER / NETWORK_STACK ..."), the sandbox passed the virtual uid, and Cronet (HttpEngine) in the Play process turned the exception into a native abort (SIGTRAP in `CronetInit`). New hook `GetNetworkInfoForUid`: the uid argument becomes `BlackBoxCore.getHostUid()`, and a connected fallback `NetworkInfo` is returned if the system still refuses. Not tested on a device here.
  - *Does BlackBox start Play Services / Play Store by itself?* Not on opening. `ParallelEngine` installs the Google apps (`GmsCore.installGApps`: gms, gsf, Play Store and friends) into a clone's space right after a clone is installed, only when the phone has real Play Services (`isSupportGms()`). They run only when started by the user or by an app.
- **Version** stays 2.5.3 (code 120).
- **Build once** with `./gradlew :app:assembleDebug` (no Android SDK here). Test list: open a PDF, a picture and an unknown file type from the File Manager (sheet, Just once, Always, then remove it in `rizwans2://chooser`); share one picture, many pictures and a link from the Gallery and the Debug log; upload a file in the browser; from Chrome share a file to "Save to Win11 Files"; switch List / 4 columns and rotate while a sheet is open; uninstall an app while a sheet is open. To see the Step 12 fallback, temporarily make `AppFinder.query` throw.

## BlackBox — split bundles (`.apks` / `.xapk` / `.apkm`), parts 1–3 (`:Bcore`)
- **Part 1 — install model**: `InstallOption.FLAG_SPLIT` + `splitPaths` (Parcel read/write; the old layout is kept for non-split installs so `package.conf` of existing apps still loads).
- **Part 2 — unpacker**: `utils/bundle/BundleUnpacker` unzips a bundle to a temp folder and fills `BundleInfo` (base APK, splits, OBB list, package/version, declared ABIs).
- **Part 3 — split picker**: `utils/bundle/SplitPicker` (+ `SplitManifestReader`, `DeviceProfile`). `SplitPicker.pick(bundleInfo)` returns a `Selection` and `selection.applyTo(info, true)` leaves only the chosen splits in `info.splitApks`.
  - Per module (base and each feature module) it keeps: the module's own split, the ABI split for the device (first match in the device ABI order, only ABIs with the same bitness as the box process, same rule as `AbiUtils.isSupport`), **one** density split (smallest density not below the screen, else the biggest), **one** language split (exact locale, then language, then same language with another region; next device language if none) **plus `en`**, and every other split (feature splits, unknown config splits such as `tcf_astc`).
  - What a split is comes from its binary `AndroidManifest.xml` (`split`, `configForSplit`, `isFeatureSplit`); if that cannot be read, the file name is used (`config.xxhdpi.apk`, `split_config.en.apk`, `base-arm64_v8a.apk`, `ar-master.apk`).
  - **Wrong architecture**: if a module has ABI splits and none runs on this phone, or `info.json` lists only other ABIs, a `BundleException` says so, e.g. *"This app does not run on this phone: the bundle only has native code for x86, x86_64, but the box needs arm64-v8a, armeabi-v7a."*
  - Tests: `Bcore/src/test/.../SplitPickerTest.java` (24 cases; run on a plain JVM, `:Bcore:testDebugUnitTest`). They were run here with a JDK and stubs for the two Android-only classes; the Gradle build itself was not run (no Android SDK here).

### BlackBox — split bundles, part 4: parsing (`:Bcore`)
- `BPackageManagerService.parserApk(file, option)`: with `FLAG_SPLIT` the base APK and all splits are parsed together by the system `PackageParser` (cluster / folder mode) through `utils/bundle/SplitPackageParser`. Without splits it is the old single-APK parse.
  - `SplitCluster` first links (hard link, then symlink, then copy) base + splits into one flat temp folder, because the parser needs all APKs at the top level of one folder (a bundle has `splits/` sub folders and other files). The folder is deleted right after parsing, also on failure.
  - After parsing, `baseCodePath`, `splitCodePaths` and the `ApplicationInfo` paths (`sourceDir`, `publicSourceDir`, `splitSourceDirs`, `splitPublicSourceDirs`, `splitNames`) are set back to the real files, not the temp folder. If the parser does not find every split (other package or version code in a split) the install stops with *"Cannot read the split files of this app: ..."*.
- `BPackage` now keeps `splitNames` and `splitCodePaths` (copied from the parsed package). They are written to `package.conf` **after** `installOption` and only when `FLAG_SPLIT` is set, so the file of an app installed earlier is still read the same way.
- `BPackageManager`: the two empty `splitNames = new String[]{}` in the fallback `ApplicationInfo` / `PackageInfo` are removed (null = no splits, like the real framework).
- Not done here (next parts): copying the split files into the app folder (part 5), `generateApplicationInfo` (part 7), the system-reinstall parse in `Settings.parserApk` (part 10).
- Tests: `SplitClusterTest` (4 cases, plain JVM). The parcel change and the parser call need a device.

### BlackBox — split bundles, part 5: copy the splits (`:Bcore`)
- `CopyExecutor` now copies every split into the app folder (`data/app/<package>/split_<splitName>.apk`, for example `split_config.arm64_v8a.apk`) through `utils/bundle/SplitFileCopier`. Files are read-only. A file inside the BlackBox temp folder (the unpacked bundle) is **moved** (instant, no second copy of a big game), any other file is **copied**. If one file fails, everything done so far is undone (copies deleted, moved files put back), the app folder is removed and the install fails.
- The new paths are saved in the package settings before `save()`: `pkg.splitCodePaths`, the `ApplicationInfo` split fields, and `InstallOption.splitPaths` (so `package.conf` no longer points at the temp folder).
- With splits the **base APK is copied too**, also when `FLAG_STORAGE` is not set, because the bundle's temp folder is deleted after the install. Installs "by system" (`FLAG_SYSTEM`) are not copied and keep the real paths of the phone.
- `FileUtils.copyFile(File, File)` buffer 1 KB -> 256 KB (big APKs were slow).
- Native libraries (part 6), `generateApplicationInfo` (part 7) and the temp-folder cleanup (part 19) are not part of this change.
- Tests: `SplitFileCopierTest` (4 cases, plain JVM). The executor itself needs a device.

### BlackBox — split bundles, part 6: native libraries (`:Bcore`)
- New `utils/bundle/NativeLibInstaller` (called from `CopyExecutor` after the splits are copied, from the **final** files in the app folder). It scans the base APK and every split, then:
  - picks **one ABI for the whole app**: the first ABI of the device list (same bitness as the box, from `DeviceProfile`) that has libraries in *any* APK, like the Android installer (libraries of two ABIs are never mixed). A device with `armeabi-v7a` also accepts old `armeabi` libraries, tried last.
  - extracts only that ABI's `lib/<abi>/*.so` from the base **and** the ABI split into `data/app/<package>/lib/`. Old files of a previous version are removed first, files are written through a `.tmp` and renamed, and the result is read-only.
  - **wrong architecture**: if the APKs have native code but none for this phone the install fails with *"This app does not run on this phone: it only has native code for x86, x86_64, but the box needs arm64-v8a."* (logged; the install UI shows messages in part 11). The app folder is removed.
  - an app with no native code is fine (lib folder is just emptied).
- **`extractNativeLibs="false"` apps** (flag read from the parsed `ApplicationInfo`, API 23+): when all libraries of an APK are STORED and start on a page boundary, nothing is extracted for that APK (no second copy of a big game's libraries) and the app loads them from `<apk>!/lib/<abi>`. If a library is compressed or not aligned the APK is extracted normally, so the app always starts. Alignment is read from the zip central directory / local header (`ApkNativeLibs`; zip64 files fall back to extraction).
- New `NativeLibPaths.build(libDir, codePaths, abi, extractNativeLibs)` gives the library search path the framework would build (`lib` folder, then `base.apk!/lib/<abi>` and each split). **Part 8 passes it to the `PathClassLoader`**; the framework's own `LoadedApk` already builds the same list from `primaryCpuAbi` + `splitSourceDirs`.
- The chosen ABI is saved in `pkg.applicationInfo.primaryCpuAbi` (so it is in `package.conf`) and `PackageManagerCompat.generateApplicationInfo` uses it for split installs (before it always wrote `Build.CPU_ABI`, wrong for a 32-bit box on a 64-bit phone). Non-split apps keep the old value and the old extraction (`NativeUtils.copyNativeLib`), so nothing changes for apps installed before.
- Safety: only entries named exactly `lib/<abi>/<name>.so` are used (no sub folders, `..`, back slashes), and the target is checked to stay inside the lib folder.
- `SplitPicker.canonicalAbi` is now `public` (shared ABI naming).
- Not done here: `splitSourceDirs` in `generateApplicationInfo` (part 7), class loader and resources (part 8), the "supported" check over all splits (part 9), clone from phone (part 10).
- Tests: `NativeLibInstallerTest` (11 cases, plain JVM: extraction from base + ABI split, one ABI only, ABI decided across APKs, wrong architecture, no native code, update removes old libs, `extractNativeLibs=false` with aligned / compressed / unaligned libraries, legacy `armeabi`, search paths, zip with comment). All 45 bundle tests pass here (JDK + stubs for the Android-only classes). The Gradle build and the executor itself were not run (no Android SDK here), so `CopyExecutor` / `PackageManagerCompat` need a device build.

### BlackBox — split bundles, part 7: ApplicationInfo (`:Bcore`)
- `PackageManagerCompat.generateApplicationInfo` now sets `splitSourceDirs`, `splitPublicSourceDirs` and `splitNames` from the stored package (`splitCodePaths` / `splitNames`, filled in parts 4–5), one entry per split in the same order. Because every `ActivityInfo`, `ServiceInfo`, `ProviderInfo` and `PackageInfo` the box hands out gets its `ApplicationInfo` from this method, `getApplicationInfo` inside the box returns the split paths everywhere, not only for one call.
- `generatePackageInfo` also sets `PackageInfo.splitNames` (public API), which Play Core / SplitCompat style code reads.
- The arrays are only handed out when names and paths match one to one and every path is set (`utils/bundle/SplitFields.usable`). Otherwise the fields stay null, exactly like an app with a single APK, because a half filled set crashes `LoadedApk` / `AssetManager`. The arrays are copied, so an app cannot change the stored package.
- `ApplicationInfo.splitNames` is a hidden field, so it is now written through the reflection interface (`ApplicationInfoL.splitNames()` -> `_set_splitNames`) in `generateApplicationInfo` **and** in `CopyExecutor` (part 5 assigned it directly, which may not compile against the public SDK; fixed).
- Apps installed without splits are unchanged (null arrays). Apps installed by system keep the real split paths of the phone.
- Not done here: class loader and resources use of these paths (part 8), ABI check over all splits (part 9), reading the real `splitSourceDirs` for "clone from phone" (part 10).
- Tests: `SplitFieldsTest` (3 cases). All 48 bundle tests pass on a plain JVM; the framework calls need a device (Gradle build not run, no Android SDK here).

### BlackBox — split bundles, part 8: class loader and resources (`:Bcore`)
- **Class loader** (`BActivityThread.getClassLoader`, the one built from `ApplicationInfo` when the framework's own loader is not used): the `PathClassLoader` now gets a **library search path** as its second argument. It comes from `NativeLibPaths.build(nativeLibraryDir, base + splits, installed ABI, extractNativeLibs)`: the extracted `lib` folder, and for `extractNativeLibs="false"` apps also `base.apk!/lib/<abi>` and `split_*.apk!/lib/<abi>`. The dex path (base + all splits) comes from the new `utils/bundle/CodePaths`. The installed ABI is read from `primaryCpuAbi` (set in part 6); `extractNativeLibs` from the hidden `FLAG_EXTRACT_NATIVE_LIBS` (API 23+, true below).
- **Resources** (`PackageManagerCompat.getResources`, used by the activity stack and the account services parser): the `AssetManager` now gets the base APK first and then every split (`addAssetPath`), so density / language / feature split resources are found. Before, only the base APK was added, which crashes on a bundle app with missing resources.
- **Framework `LoadedApk` path** (normal start): `LoadedApk` copies `mLibDir`, `mSplitAppDirs` and `mSplitResDirs` from the `ApplicationInfo` when it is created, so with part 7 it already gets the splits. As a safety net `handleBindApplication` calls `syncLoadedApkSplits`: if the `LoadedApk` was created from an older `ApplicationInfo` and its class loader is not built yet, those three fields are updated. Every field access is guarded (fields differ per Android version) and a failure is only logged. New reflection fields in `LoadedApk.java`: `mClassLoader`, `mSplitAppDirs`, `mSplitResDirs`.
- Apps without splits behave as before (dex path = base APK, library path = lib folder, resources = base APK).
- Not done here: ABI check over all splits (part 9), clone from phone (part 10).
- Tests: `CodePathsTest` (5 cases, plain JVM, includes the library path for a split app). All 53 bundle tests pass; the class loader / resource code and the `LoadedApk` sync need a device (Gradle build not run, no Android SDK here).

### BlackBox — split bundles, part 9: ABI check over all splits (`:Bcore`, `:app`)
- One rule for "can the box run this app", `utils/bundle/AbiCheck`, used by the installer, the "clone from phone" list and the native library installer (part 6, which now takes its decision and its error text from the same code), so they cannot disagree:
  - the native libraries of the base APK **and every split** are read (a Play Store app has them only in `split_config.<abi>.apk`; the base APK looks like pure Java);
  - no native code anywhere = supported; otherwise supported when one of the ABIs the box can run (same bitness as the box; `armeabi` also counts on a v7a device) has libraries.
- `AbiUtils` was rewritten on top of it (old `isSupport(File)` is kept; new `isSupport(ApplicationInfo)`, `isSupport(File, List<String>)`, `check(...)` returning the reason). Bugs fixed on the way: only the base APK was scanned; an app with **only x86 libraries** counted as supported (and crashed later); the cache was keyed by file only, so an updated app kept its old answer (the key now includes size and modification time of every file; the cache is limited to 64 entries).
- `BPackageManagerService.installPackageAsUserLocked`: checks the base APK plus `option.splitPaths`. For an install "by system" without splits in the option (clone from phone) the real `splitSourceDirs` of the phone's copy are used. The error now says why, e.g. *"... it only has native code for arm64-v8a, but the box needs armeabi-v7a."* instead of only "does not support 32-bit".
- `ParallelEngine.deviceApps()` calls `AbiUtils.isSupport(ApplicationInfo)`, so an app whose libraries are in a split is no longer listed when the box cannot run it, and one that can run is not hidden.
- Tests: `AbiCheckTest` (7 cases: libs only in the ABI split, pure Java, x86 only, v7a in 32/64-bit box, legacy armeabi, check and installer agree, unreadable file). All 60 bundle tests pass on a plain JVM; the service and Kotlin changes need a device build (Gradle not run, no Android SDK here).
- Not done here: reading the real split files for the copy itself (part 10).

### BlackBox — split bundles, part 10: clone installed apps with splits (`:Bcore`)
- **The bug**: "clone from phone" (`BlackBoxCore.installPackageAsUser(packageName, userId)`, the Play Services / Play Store preinstall and `ParallelEngine.clone`) installs "by system" from the phone's `sourceDir` only. A Play Store app on the phone is a base APK plus `split_config.<abi>.apk`, density / language and feature splits, so the clone had no native code, no screen resources and no feature code, and crashed. Part 9 already read the real splits for the ABI check, but nothing else did.
- **Read the real splits** (`utils/bundle/PhoneSplits`, plain Java): `read(package, sourceDir, splitSourceDirs)` returns the split files the phone lists (null / empty / duplicate / base entries skipped). A listed file that is missing or unreadable stops the install with *"Cannot read the split file split_x.apk of com.x on this phone (file not found). Update the original app and try again."* instead of a clone that crashes later.
- `BPackageManagerService.installPackageAsUserLocked`: for an install by system without splits in the option it now reads the phone's `ApplicationInfo` and puts the splits into the option (`FLAG_SPLIT` + `splitPaths`) **before** the ABI check and the parse. Only when the file passed in is the phone's own base APK of that package. After that the existing parts do the work: part 4 parses base + splits together (`splitNames` / `splitCodePaths` filled), part 7 hands the split paths out in `ApplicationInfo`, part 8 builds class loader and resources from them. One place covers every caller (UI, Play Services install, pre-install list).
- **The clone keeps using the phone's own files** (no copy, same as before for apps without splits), so it follows updates of the original; `CopyExecutor` already skips copying and native library extraction for `FLAG_SYSTEM`, and the phone's extracted libraries are used. Copying all files so the clone survives an update or removal of the original is the independent copy mode (part 20, `FLAG_STORAGE`). Uninstalling a clone only deletes the box's own app folder, never the phone's files.
- **Bitness guard**: the clone loads the libraries the phone extracted for its own ABI (`primaryCpuAbi`). If the phone runs the app as 64-bit and the box is 32-bit (or the other way round) the install now stops with *"This app does not run in the box: the phone runs it as arm64-v8a, but the box needs armeabi-v7a. Install the app from its file (.apk / .xapk) instead."* instead of an `UnsatisfiedLinkError` at start (`PhoneSplits.runsInBox`, same ABI rules as part 9).
- **After the original app is updated** (`Settings.updatePackageLP`, run when the box starts): the old check compared only the base APK path. It now compares base + split files (`PhoneSplits.changed`) and `reInstallBySystem` parses the new base + splits again. This also repairs clones made **before** this part (no splits stored, original has splits): they are read again the next time the box starts. An original that dropped its splits becomes a normal single-APK clone.
- Tests: `PhoneSplitsTest` (12 cases: order, skipped entries, missing split message, unchanged / moved / added / removed splits, clone made before split support, bitness rules). Run here on a plain JVM with a minimal JUnit stand-in (no JUnit jar, no Android SDK in this environment): 12 / 12 pass. The service, `Settings` and the install on a phone were **not** built or run (no Gradle / Android SDK here).
- **Test on a device**: clone Play Store, a Play Store game and a Play Store app with feature modules from the phone and open them; then update the original from the Play Store, restart the box and open the clone again (log tag `Settings`: `reInstallBySystem`).
- Not done here: the copy mode for these clones (part 20), the install UI messages (part 11).

### BlackBox — split bundles, part 11: install from file (`:Bcore`, `:app`)
- **Button** in the Parallel screen: next to "➕ ক্লোন করুন" there is now "📂 ফাইল থেকে". It opens the own file picker (`:chooser`, `FilePicker`) filtered to `.apk`, `.xapk`, `.apks`, `.apkm`. The picker returns the plain path for this app's own calls, so nothing is copied then; if only a `content://` uri comes back it is copied to a temp file first (with progress).
- **One entry point for the screen**: `utils/bundle/BundleInstaller` (`install(File, ...)` and `install(Context, Uri, size, ...)`). Blocking, never throws, returns a `Result` (`success`, `packageName`, `userId`, `message`, `kind`, `splitCount`, `obbCount`, `format`). Steps: copy (uri only) → look inside the file → unpack → `SplitPicker` → ask the screen which space to use → `BlackBoxCore.installBundleAsUser` → clean up.
  - **The file is looked at, not its name** (`FileKind.sniff`): a zip with `AndroidManifest.xml` is a plain APK, a zip with `.apk` files is a bundle, a zip without APK and a non-zip file get their own error. A `.xapk` named `.zip` still works.
  - **Space**: the first space that does not have the app yet (`Engine.freeSpaceFor`, the same rule as "clone"); none left -> *"All spaces already have this app."* The bundle needs about its own size free in the box cache; the uri copy about twice that for a moment. Too little -> *"Not enough free space on the phone to unpack this bundle."* before anything is written.
  - **Clean up**: the temp copy, the unpacked folder and the skipped splits are deleted at the end, also when the install failed. The file the user chose is never changed or deleted. (The URI flow of the old `installPackageAsUser(Uri)` and the rest of the temp folders are part 19.)
  - Play Services / Play Store support packages are installed into the space after a successful install, like after a clone (`installGmsBestEffort`, shared by `clone`).
- **Progress**: `BundleUnpacker.unpack(..., Progress)` reports bytes written (at most every 256 KB). The screen shows a bar with "x / y MB" for copy and unpack, and an indeterminate bar for check and install. Only one install at a time (the buttons say so).
- **Readable errors**: `InstallErrors.classify(message)` sorts the engine texts into kinds (wrong architecture, not a zip, no APK inside, no space, split unreadable, no free space slot, broken APK, cannot read, host app itself). The screen shows a Bengali title and explanation (`InstallText.error`) and, below, the original English text (selectable) for the log / bug reports.
- **Bug fixed on the way**: `BPackageManagerService.installPackageAsUserLocked` caught every `Throwable`, printed it and returned the `InstallResult` that starts as *success*. A crash during the install (parse, copy, native libraries) was shown as a good install. It now returns the exception as the error.
- **OBB**: an `.xapk` with OBB files is unpacked and counted (`obbCount`); the success message says the OBB files were **not copied yet**. Copying them to the virtual OBB folder is part 12.
- Tests: `InstallFromFileTest` (3 cases: error kinds from the real engine texts, file kind by content, unpack progress goes up to the total and the temp folder is removed). Run here on a plain JVM with a minimal JUnit stand-in and stubs for the Android classes: 3 / 3 pass; `BundleInstaller` and `InstallErrors` / `FileKind` compile against those stubs. The Kotlin screen (`ParallelActivity`, `ParallelEngine`, `InstallUi`) and the install on a phone were **not** built or run (no Gradle / Kotlin / Android SDK here), so do a Gradle build first.
- **Test on a device**: install a plain `.apk`, a Play Store bundle (`.apks` / `.xapk`) from storage by tapping; a wrong-architecture bundle (expect the "does not run on this phone" dialog); a renamed text file (expect "cannot be read"); a second install of the same app (goes to space 2); an `.xapk` with OBB (expect the "OBB not copied yet" line).
- Not done here: OBB copy (part 12), cache cleanup of old temp folders and URI copies (part 19).

### BlackBox — split bundles, part 12: OBB (`:Bcore`, `:app`)
- **Where the files go**: `BEnvironment.getExternalObbDir(package, space)` = `<box external root>/storage/emulated/<space>/Android/obb/<package>/`. Inside the box `/sdcard` and `/storage/emulated/<host user>` are redirected to that space's folder (`IOCore.enableRedirect`), so the game sees its OBB at `/sdcard/Android/obb/<package>/main.<n>.<package>.obb`, the place it checks before it asks for a download.
- **`utils/bundle/ObbInstaller`** (plain Java): copies the OBB files the unpacker found (part 2, `BundleInfo.obbFiles`).
  - Each file is written as `<name>.part` and renamed when complete, so a game never finds a half copy that looks finished. A move is tried first (instant when the storage allows), else copy + delete the source.
  - A file already there with the **same size is kept** (installing the same bundle again, or into a second space of a bundle whose temp files are gone); a different size is replaced.
  - File names are checked (letters, digits, `. _ + - space`, no path, no leading dot), so an entry like `../../x` cannot leave the OBB folder. The folder always belongs to the **installed package** (the only folder an app can read).
  - Free space is checked per file before copying: *"Not enough free space on the phone to copy the OBB files."*
  - Any failure deletes everything this call wrote, and the OBB folder if this call created it.
- **Order in `BundleInstaller`**: OBB is copied **before** the app is installed (new stage `COPYING_OBB`, with byte progress). If the copy fails the app is not installed (nothing to undo but files); if the install fails the OBB files are deleted again. `Result.obbCount` is now the number of OBB files in the app's OBB folder.
- **Uninstall**: new `RemoveObbExecutor`, added to `uninstallPackageAsUser` only. A clone that is removed takes its OBB with it (these are gigabytes). It is **not** part of "clear data" (`RemoveUserExecutor` is shared with it): Android keeps the OBB on clear data too, and a game must not ask for a re-download after "🧹". Deleting a whole space still deletes its folder (`BUserManagerService`).
- **Screen**: stage text "🎮 গেমের OBB ফাইল কপি হচ্ছে…" with the MB bar; the success message shows "🎮 OBB ফাইল কপি হয়েছে (N টি)"; a new error kind `OBB_COPY` with its own Bengali text (*"app was not installed"*).
- Tests: `ObbInstallerTest` (6 cases: files arrive and the source is gone, no `.part` left, progress ends at the total; same size kept / different size replaced; unsafe names refused and the new folder removed again; rollback; no OBB = nothing done; the space errors are sorted as OBB errors). With part 11's 3 tests: 9 / 9 pass on a plain JVM (JUnit stand-in + Android stubs). `BundleInstaller`, `ObbInstaller`, `InstallErrors` compile against the stubs; `RemoveObbExecutor`, the service change and the Kotlin screen were **not** built (no Gradle / Kotlin / Android SDK here).
- **Test on a device**: install an `.xapk` game with OBB from storage; check `…/storage/emulated/0/Android/obb/<package>/` under the box's external files folder; open the game (no download prompt); tap 🧹 (OBB must stay); remove the clone (OBB folder must be gone); try with the phone almost full (expect the OBB error and no clone left).
- Not done here: a clone made **from the phone** (part 10) does not copy the phone's own `/sdcard/Android/obb/<package>`; a game cloned that way still asks for its data. Not needed for "install from file". Cache cleanup of other temp folders is part 19.

### BlackBox — per-app permissions, parts 13–16 (`:Bcore`, `:app`) — short summary of what is in the code
- **Part 13, store**: `core/system/permission/PermissionStore` (plain Java) keeps Allow (1) / Ask (2) / Deny (3) per space, package and permission, plus a package default (`*`) and a global default (Allow = the old behaviour). It is saved to `permission.conf` in the box system folder (`BEnvironment.getPermissionConf()`), one `rule|<space>|<package>|<permission>|<mode>` line each, written as `.tmp` and renamed. `BPermissionService` (system process, `ServiceManager.PERMISSION_MANAGER`) serves it over Binder (`IBPermissionService.aidl`); `BPermissionManager` is the client with a 1.5 s cache. Rules of a removed clone or space are deleted. `PermissionCatalog` lists the 12 groups the store controls (camera, microphone, location, contacts, calendar, phone, SMS, storage/media, notifications, sensors, activity, nearby). Everything else (INTERNET, foreground-service types, MIUI helper permissions) keeps its old behaviour.
- **Part 14, hooks**: `fake/service/PermissionPolicy` is the one place that answers "is this permission granted for the running clone?". The package manager, activity manager and permission manager hooks use it instead of the old "always granted" returns. Allow keeps the old forced grants; Ask and Deny answer `PERMISSION_DENIED`.
- **Part 15, MIUI and AppOps**: `IAppOpsManagerProxy` (`checkOp*` / `noteOp*` / `startOp*`) and `IMiuiSecurityManagerProxy` use the same policy (AppOps op code → permission), so camera and microphone checks follow the store too.
- **Part 16, screen**: ⚙️ on a clone opens `parallel/PermissionsActivity`: one Allow / Ask / Deny selector per group the app asks for, a global default, "reset this clone" and "reset all". Changes are saved at once.

### BlackBox — per-app permissions, part 17: the "Ask" dialog (`:Bcore`, `:app`)
- **What happens now**: when a clone calls `requestPermissions()` and a permission's mode is **Ask**, the user gets a dialog (Bengali, in the host process) instead of the system permission controller. The app then gets a normal `onRequestPermissionsResult()`. Allow / Deny modes are answered **without a dialog**.
- **How the request is caught**: `Activity.requestPermissions()` starts the system activity with action `android.content.pm.action.REQUEST_PERMISSIONS` and waits for its result. `ActivityManagerCommonProxy.StartActivity` now calls `PermissionRequestRedirect.redirect(intent)` first. If the clone asks for **at least one managed permission** (see `PermissionCatalog`), the intent is rewritten in place to open `app/PermissionRequestActivity` (the clone package, space and label travel as extras) and is started as it is, so the result comes back to the clone's own activity. Requests with no managed permission, and every request made by the host app itself (no clone process), keep the old flow.
- **`PermissionRequestActivity`** (new, `exported=false`, translucent, own empty task affinity, declared in the `:Bcore` manifest):
  1. builds a `PermissionRequestPlan` from the store (on a worker thread, because the store is a Binder call);
  2. asks **once per group**, so fine + coarse location are one question; several groups are asked one after the other ("প্রশ্ন 2/3");
  3. four choices: **✅ সবসময় দিন** (writes Allow for the whole group), **🕒 শুধু এবার দিন** (temporary grant), **❌ এবার দেব না** (nothing stored), **⛔ কখনো দেব না** (writes Deny for the whole group). Back or a touch outside = "এবার দেব না";
  4. applies the answers **before** it finishes, then returns `EXTRA_REQUEST_PERMISSIONS_NAMES` and `..._RESULTS` (and the Android 14 device ids if they were in the request) in request order. Permissions the store does not manage are answered like before: the forced grants (audio, storage/media, notifications) are granted, any other permission gets what the host app really holds.
- **"Allow this time"**: `core/system/permission/TemporaryGrants` (plain Java). Kept in memory in `BPermissionService`, **30 minutes**, never written to `permission.conf`. It only lifts an Ask (`getMode` returns Allow while the grant is valid); a stored Allow / Deny always wins. It is dropped when a rule of that clone is changed (permissions screen), the clone or space is removed, or when the global default or "reset" is used. New Binder method `IBPermissionService.grantTemporary`, client `BPermissionManager.grantTemporary`.
- **Cache fix that the dialog needs**: the clone process cached answers for 1.5 s. A cached "Ask" would still be read as "denied" right after the dialog said "always". `BPermissionManager` now **never caches Ask**; Allow and Deny are cached as before.
- **Screen text**: the note in `PermissionsActivity` no longer says the dialog "comes in the next step".
- **Not in this part**: the host bridge (part 18). If the **host app** itself does not hold a permission (for example the camera), a clone that is set to Allow still cannot use it; the dialog does not ask the host for it yet. That, and the MIUI "Camera, Microphone" dialog loop, is part 18.
- Tests: `TemporaryGrantsTest` (6 cases: expiry on the exact millisecond, scope by space / package / permission, `clearPackage` does not touch `com.ab` when `com.a` is cleared, `clearUser(1)` does not touch space 10, bad input, 30 minute default) and `PermissionRequestPlanTest` (8 cases: Allow / Deny without dialog, one question per group in request order, answers per group, unanswered = denied, unmanaged permissions left to the old flow, mixed requests, null / empty request, duplicate permission asked once). Run here on a plain JVM with a minimal JUnit stand-in: 14 / 14 pass. `PermissionRequestActivity`, `PermissionRequestRedirect`, the hook change, the service change and the AIDL change were **not** built (no Gradle / Android SDK here), so do a Gradle build first.
- **Test on a device**: set a clone's Camera to ❓ and open an app that asks for the camera → the dialog appears. Try each button: "সবসময়" (the permissions screen now shows ✅ and the app does not ask again), "শুধু এবার" (the app works; after 30 minutes or after changing the setting it asks again), "এবার না" (the screen still shows ❓, next request asks again), "কখনো না" (screen shows ⛔, no more dialogs). An app that asks for location (fine + coarse) must show one question. Rotate the phone while the dialog is open. Set the clone to ✅ / ⛔ and check that no dialog appears and the result is granted / denied.

### BlackBox — per-app permissions, part 18: host bridge (`:Bcore`, `:app`)
- **The bug (the MIUI "Camera, Microphone" dialog loop)**: a clone runs inside the host app's process with the host's uid, so Android and MIUI judge every camera / microphone / location use by what the **host app** really holds. Parts 14–17 answered the clone "granted" (store = Allow, or the old forced grant of the microphone) while the host itself had nothing, so the clone opened the camera, MIUI blocked it and showed its dialog again and again. Asking the user in the Ask dialog (part 17) did not help, because nobody asked the host.
- **Rule of the bridge**: *the clone only gets "granted" for a permission the host really holds.* The clone's own Allow / Ask / Deny rules are not changed.
- **Request path** (`app/PermissionRequestActivity`): after the answers of part 17 are applied, every permission that is about to be granted (store Allow, "always", "this time") is checked against the host:
  1. host holds it → nothing more;
  2. host does not → the **host's system permission dialog** is shown first (`ActivityCompat.requestPermissions`). From Android 11 background location is asked in a **second** request, and only if foreground location is held (the system would otherwise refuse the whole request);
  3. the system will not ask again (denied and no rationale = "don't ask again") → a prompt **"⚠️ ফোনের অনুমতি বন্ধ আছে"** with **⚙️ সেটিংস খুলুন** / **এখন না**. On Xiaomi / HyperOS the MIUI permission editor (`com.miui.securitycenter`) opens first, then the normal app-details page. When the user comes back, the host is checked again (no second prompt); "approximate location" counts as enough for a fine + coarse request;
  4. still not held → the clone gets `PERMISSION_DENIED`, never a "granted" the system contradicts.
  Permissions the **host manifest does not declare** can never get a system dialog, so they are answered "denied" straight away (before, the dialog said "granted" and the real use failed). Permissions that do not exist on this Android version (for example `POST_NOTIFICATIONS` on Android 12) are left alone.
- **Check path** (`PermissionPolicy.decide`): the old forced grant of the **microphone** (and of `POST_NOTIFICATIONS` on Android 13+) used to hide that the host lacks the permission, so the app never asked. Now a bridged permission that the store allows but the host does not hold is answered "denied" (a recent "granted" is reused for 3 s, "denied" is never cached). The app then calls `requestPermissions()`, which part 17 already sends to the dialog above. **Storage / media is not bridged** (the clone's files are redirected into the box, the host never needs the real permission), and everything the store does not manage keeps its old behaviour.
- **"What does the host really hold?"** (`fake/service/HostPermissionCheck`): the hooks lie by design, so this class sets a per-thread "real check" flag, runs the normal `Context.checkPermission` and clears the flag. While it is set `PermissionPolicy` has no opinion and the hooks pass the call to the system with the host uid. The forced `SEND_SMS` / `ACCOUNT_MANAGER` grant in `IActivityManagerProxy.checkPermission` is skipped during such a check too (otherwise the bridge would think the host holds `SEND_SMS`). `declared()` reads the host manifest.
- **Decision code** (`core/system/permission/HostBridgePlan`, plain Java): which permissions are bridged, SDK table (`appliesOnSdk`), what to ask in which round, "blocked" (`isBlocked(granted, rationale)`), which groups need the settings prompt (each group once; background location always counts separately), and the final answer for the clone (`apply`).
- **Screen text**: the help dialog of the permissions screen says that the host app needs the phone permission too and what happens when the phone stops asking.
- **Note**: the phone permission the host receives stays after the clone's rule changes (it belongs to the host app, shared by all spaces). Per-clone control is still the store: Deny / Ask keep the clone from using it. To take the host permission away, use the phone's settings.
- Tests: `HostBridgePlanTest` (17 cases: storage and unmanaged not bridged, held = nothing to do, missing asked and answered by what the host holds afterwards, a store-Deny is never turned into a grant, not declared = denied, SDK gating for `POST_NOTIFICATIONS` / Bluetooth, background location separate from Android 11 / together on Android 10 / alone when foreground is held, blocked rule, one prompt per group, approximate location, background prompt, cancelled request = no prompt, back from settings = granted, null / empty input, duplicates). With `PermissionRequestPlanTest` and `TemporaryGrantsTest`: **31 / 31 pass** on a plain JVM (JUnit 4.13.2). `HostPermissionCheck`, the `PermissionPolicy` / `IActivityManagerProxy` change, `PermissionRequestActivity` and the Kotlin text were **not** built or run here (no Gradle / Android SDK), so do a Gradle build first.
- **Test on a device (Xiaomi / HyperOS first)**: remove the camera and microphone permission of the host app in the phone settings, open a clone with the camera set to ✅ and start its camera → the **phone's own** permission dialog must appear first, then the camera works and the MIUI "Camera, Microphone" dialog must **not** come back. Then: tap "don't allow" twice → the "ফোনের অনুমতি বন্ধ আছে" prompt appears; "⚙️ সেটিংস খুলুন" opens the permission editor; allow there and press back → the app gets "granted". Microphone-only app (voice recorder) with the old forced grant: must ask the host once. A location request with "approximate" chosen → the app gets coarse granted / fine denied and no prompt. Clone set to ⛔ → no host dialog at all. Android 13+: an app that posts notifications asks the host for `POST_NOTIFICATIONS`. An app that only needs storage must behave as before (no host dialog).
- Not done here: part 19 (cache cleanup) and the rest of the list.

## J2ME — `:j2me` + `:j2me-dexlib` modules (J2ME Loader, package `ru.playsoftware.j2meloader`)

[J2ME Loader](https://github.com/nikita36078/J2ME-Loader) (v1.8.2, upstream commit `360681d`, Apache-2.0) runs Java ME games and apps (`.jar` / `.jad`) with
virtual keyboard, per-game settings, Mascot Capsule 3D, M3G, MMAPI sound, soundbanks, JSR-82 Bluetooth, JSR-179 location and more. It is now a built-in
app of Win11 in the same style as Video / Gallery. Licence and credits: `NOTICE-J2ME-Loader.md`, `LICENSE-J2ME-Loader`.

### Where it is hooked in

| Place | What |
|---|---|
| Start menu | built-in app **J2ME** (gamepad icon, orange), section `j2me` (`StartApps.kt`) |
| Home screen | desktop icon **J2ME** under Gallery (`Win11Shell.kt`, `VectorIconView.J2ME`) |
| Deep link | `rizwans2://j2me` (`MainActivity.kt`, manifest comment) |
| File Manager | tap a `.jar` / `.jad` / `.kjx` → the J2ME installer opens (`FileManagerUi.kt` `openFile`, `J2meLauncher.kt`); these files get an orange type chip (`fileTypeColor`) |
| Other apps | `.jar` / `.jad` / `.kjx` opened from any app (browser download, other file manager, the own "Open with" sheet) can be installed here (VIEW filters of upstream kept) |
| Settings | `settings.gradle.kts` (`:j2me`, `:j2me-dexlib`), `app/build.gradle.kts` (`implementation(project(":j2me"))`, `pickFirsts += "**/libc++_shared.so"`) |

Games, saves and settings live in `/storage/emulated/0/J2ME-Loader` (upstream "legacy storage" layout, visible in the File Manager).
The J2ME screens keep their own settings (theme, language, virtual keyboard, shaders, backup / restore, key mapper, profiles) and their own translations (40 languages).

### What changed compared with upstream (Apache-2.0 "changes" list)

- **Library, not an app**: `:j2me` is an Android library (`namespace ru.playsoftware.j2meloader`, minSdk 26, ndk-build, ABIs arm64-v8a + armeabi-v7a, NDK `ext.ndkVer`
  like `:Bcore`). `:j2me-dexlib` is upstream's `:dexlib` unchanged (Gradle file converted to Kotlin DSL). Java package names, JNI names and `R` are unchanged.
- **No Application class**: `EmulatorApplication` is now a plain helper. `App.kt` calls `EmulatorApplication.attach(this)` (launcher process) or
  `EmulatorApplication.attachMidletProcess(this)` (the `:midlet` process: crash dialog (ACRA) + saved theme). The saved day / night theme is applied by
  `BaseActivity` when a J2ME screen opens, so J2ME's "Theme" setting does not change the launcher at start-up.
- **The `:midlet` process and BlackBox**: each running game is `MicroActivity` in the process `com.srizwan.win11:midlet` (upstream design; the game ends by killing
  that process). `App.kt` does **not** attach / create the BlackBox engine there, otherwise BlackBox would treat the process as a cloned app.
- **No launcher icon**: the `MAIN` / `LAUNCHER` filter of upstream is gone (no second "J2ME Loader" icon in the system app list). Every activity has its own theme and label
  (`jl_app_name`), because the host's application theme is not J2ME's.
- **Manifest**: only the permissions the host does not declare are added (fine / coarse location, Bluetooth scan / advertise, install shortcut); the rest merge from `:app`
  without touching its flags (`maxSdkVersion`).
- **Storage permission**: `:app` declares `WRITE_EXTERNAL_STORAGE` only up to Android 9, so J2ME's start-up permission dialog could never succeed on newer phones.
  `MainActivity` now uses "All files access" (already declared by `:app`) on Android 11+, with a retry / exit dialog; Android 10 and older ask `WRITE_EXTERNAL_STORAGE` as before.
- **Build flavors dropped**: `play` / `open` / `fdroid` / `dev` / `midlet` do not exist; `BuildConfig.FULL_EMULATOR` is `true` and `BuildConfig.J2ME_VERSION_NAME` replaces
  `VERSION_NAME`. The "create a standalone Android port of one game" flavor (`src/midlet`) and the instrumented test (`src/androidTest`) were not copied.
- **Resources**: the names that clashed with `:app` / `:winlator` got the prefix `jl_` (`about add browse edit exit reset version` strings, `ic_launcher`,
  `ic_launcher_foreground`, `ic_launcher_background`, `ic_delete`, `simple_list_item_multiple_choice`), plus the new string `jl_app_name` (upstream generated `app_name` with a Gradle
  `resValue`). Without this the app's own resources would have silently replaced them. All other upstream resource names are unique in the project.
- **Language list**: upstream built it from `generateLocaleConfig` (application modules only); it is now `res/xml/jl_locale_config.xml`.
- **Duplicate native lib**: `:winlator`, ffmpeg-kit, Oboe and `:j2me` all ship `libc++_shared.so` → `pickFirsts` in `:app`.
- **APK size**: grows by the native libraries of ffmpeg-kit, Oboe and J2ME (not measured here).

### Versions

`:j2me` keeps upstream's library versions (appcompat 1.8.0, activity 1.13.0, material 1.13.0, recyclerview 1.4.0, constraintlayout 2.2.2, room 2.8.5, camerax 1.6.2, preference 1.2.1,
ffmpeg-kit 6.0.LTS (Maven Central), pngj / filepicker / ambilwarna (JitPack, already a repository in `settings.gradle.kts`), ACRA 5.14.2). Gradle resolves each library to the highest version asked for, so
`:app` and the other modules now compile against these newer AndroidX / Material versions too. The coroutines pin in the root `build.gradle.kts` (1.8.1) still applies.
Upstream builds with AGP 9.4.1; this project stays on AGP 8.13.2 (`:Bcore`).

### Not verified here

This environment has no Android SDK, NDK or Maven access, so **no Gradle build, native build or device test was run**. Checked by hand instead: every `R.x.y` and `@type/name`
of the module resolves inside the module or its libraries; no resource name clashes with `:app`, `:Bcore`, `:winlator`, `:youtube`, `:video`, `:gallery`, `:chooser`; no duplicate class names
with any other module; all XML parses. **Build once with `./gradlew :app:assembleDebug`.** Things to look at first if it fails: (1) an AndroidX library asking for a newer AGP than 8.13.2
(`checkAarMetadata`) → lower that version in `j2me/build.gradle.kts`; (2) `libc++_shared.so` picked from `:winlator` instead of the NDK one (symptom: `UnsatisfiedLinkError` when a 3D / MIDI game starts)
→ ship only one copy; (3) the ndk-build step (NDK `29.0.13846066`, upstream used `29.0.14206865`).
Test on a device: open **J2ME** from the Start menu → allow "All files access" → install a `.jar` from the File Manager → start it (separate process, back button ends it) → rotate, virtual keyboard,
sound, settings screen, language / theme change. "All apps" numbers (`rizwans2://N`) shift by one after the entry **J2ME** (the list is sorted by name).
Version stays 2.5.3 (code 120).

## Camera — `:camera` module (package `com.srizwan.camera`)

A built-in Camera app in its own Gradle module, same pattern as `:gallery` (resources prefixed `cm_`, no text of its own,
content descriptions only). Only the necessary features: photo, video, front / back, flash, pinch zoom, tap to focus.
Photos and videos are saved to `DCIM/Camera`, so the Gallery and Video apps show them. The built-in Browser opens it for
page uploads with `capture` and for a website's live camera. `:app` depends on it.

### Camera plan (9 steps)

| # | Step | Status |
|---|------|--------|
| 1 | Module setup (`:camera`, manifest, theme, `:app` dependency) | done |
| 2 | Camera engine (CameraX: preview, photo, video, front / back) | done |
| 3 | Controls (flash, pinch zoom, tap to focus, photo / video mode, rotation) | done |
| 4 | Glass UI (shutter, switch, flash, last-shot thumbnail, video timer) | done |
| 5 | Saving to `DCIM/Camera` (MediaStore) and camera / microphone permissions | done |
| 6 | Launcher integration: Start menu entry, Home icon, deep link `rizwans2://camera`, thumbnail opens Gallery / Video | done |
| 7 | Browser link: `capture` uploads, website live camera (`getUserMedia`), "Camera" option in the file picker |done |
| 8 | Update all details (README, manifest and `MainActivity` deep-link lists) | done |
| 9 | Final review, flat zip | done |

### Step 1 — module setup

- `camera/build.gradle.kts`: Android library, `namespace = "com.srizwan.camera"`, minSdk 26, compileSdk 37, Java / Kotlin 21,
  view binding, coroutines 1.8.1 pin like the other modules. CameraX `1.6.2` (core, camera2, lifecycle, view, video): the same
  version `:j2me` already uses, so Gradle resolves one version for the whole app.
- `settings.gradle.kts`: `include(":camera")`. `app/build.gradle.kts`: `implementation(project(":camera"))`.
- Manifest: `CAMERA` and `RECORD_AUDIO` (same lines as `:app`, the merge is a no-op); `uses-feature` camera / camera.front with
  `required="false"`; one activity, `CameraActivity` (`exported="false"`, started with an explicit intent from the same app).
- Resources: `cm_bg`, `cm_text`, `cm_text_dim`, `cm_accent` colours, `Theme.Camera` (dark), `cm_cd_*` content descriptions.
- Code: `CameraActivity` is an empty black screen for now. `CameraActivity.start(context, mode)` already exists with the shape
  the launcher and the Browser will use (`MODE_PHOTO` / `MODE_VIDEO`).
- `:app` and every other module are unchanged apart from the one dependency line. Version stays 2.5.3 (code 120).
- No Android SDK / network in this environment: a Gradle build was **not** run. Build once with `./gradlew :app:assembleDebug`.

### Step 2 — camera engine (`CameraEngine`, `CameraActivity`)

- `CameraEngine(context, lifecycleOwner, previewView)` talks to CameraX only; it draws nothing and does not choose where files go
  (the caller passes the output options, step 5 passes MediaStore ones). Main thread in, main thread out.
  - `start(mode, front)`: gets the `ProcessCameraProvider`, binds the use cases. `mode` is `Mode.PHOTO` (Preview + ImageCapture,
    minimize-latency) or `Mode.VIDEO` (Preview + VideoCapture with a `Recorder`, HD, falls back to SD or higher). The use cases are
    bound per mode, not all three at once: that combination is not supported on legacy-level devices.
  - `switchLens()` (front <-> back) and `setMode()` rebind; both are ignored while recording. `canSwitchLens()` says whether the
    device has both lenses.
  - `takePhoto(OutputFileOptions, OnImageSavedCallback)`.
  - `startRecording(FileOutputOptions | MediaStoreOutputOptions, audio, onEvent)` and `stopRecording()`; audio only when
    RECORD_AUDIO is granted, the `Finalize` event reaches `onEvent`. `isRecording`.
  - `camera` (CameraX `Camera`, used by flash / zoom / focus in step 3), `onBound`, `onError`, `release()`.
- `CameraActivity`: full-screen `PreviewView` (fill-center), asks for the CAMERA permission, opens the camera in the mode given by
  `CameraActivity.start(context, mode)`. `engine` is public for steps 3 to 5. No buttons yet; a denied permission or a missing
  camera just closes the screen (replaced in steps 4 and 5 by the glass error / lock states).
- No new dependency: `camera-video` was already in the Step 1 `build.gradle.kts`.
- Not run here (no Android SDK / network): build once with `./gradlew :app:assembleDebug`. Version stays 2.5.3 (code 120).

### Step 3 — controls (`CameraEngine`, `CameraActivity`)

- **Flash**: `Flash.OFF / AUTO / ON`, `cycleFlash()`, `hasFlash` (false for most front cameras: the button is dimmed / ignored).
  Photo uses `ImageCapture` flash modes (off / auto / on); video uses the torch (on / off only, so auto becomes off when the mode
  changes to video). The setting is kept when the mode or the lens changes and re-applied after every bind.
- **Zoom**: `zoomBy(factor)`, `setZoom(ratio)` (clamped to the lens' min / max), `zoomRatio`. It resets to 1.0 on a mode or lens change.
  `CameraActivity`: pinch on the preview zooms.
- **Tap to focus**: `focusAt(x, y)` (focus + exposure metering point from `PreviewView.meteringPointFactory`, back to auto after 3 s).
  `CameraActivity`: a single tap on the preview focuses (not while a pinch is running). The focus ring itself is drawn in step 4.
- **Photo / video mode**: `setMode()` / `start(mode)` from step 2 (ignored while recording); the buttons come in step 4.
- **Rotation**: an `OrientationEventListener` (enabled only between onStart and onStop of the screen) sets `targetRotation` of
  `ImageCapture` and `VideoCapture`, so the saved photo / video is upright however the phone is held, also with the screen
  rotation locked. The first value is the display rotation.
- Not run here (no Android SDK / network): build once with `./gradlew :app:assembleDebug`. Version stays 2.5.3 (code 120).

### Step 4 — glass UI (`camera/ui`, `CameraActivity`)

Same glass look as `:gallery` / `:video` (the classes are copied, not shared, so `:camera` stays independent); no text of its own:
labels are content descriptions, icons are vectors (`cm_ic_*`), the only visible characters are the digits of the video timer.

- `ui/GlassDrawable` (copied from `:gallery`), `ui/CameraViews.kt`:
  - `glassIconButton` – round glass button with one icon (back, flash, switch camera).
  - `ShutterButton` – ring + white disc (photo), red disc (video ready), red rounded square (recording); shrinks while pressed.
  - `ModePill` – glass pill with a photo icon and a video icon, the chosen one lit (accent colour).
  - `TimerPill` – red dot + `mm:ss` (`h:mm:ss` after an hour), visible only while recording.
  - `FocusRingView` – ring at the tapped point, shrinks and fades in 1 s, never takes touches (touches pass to the preview).
- `ui/ThumbLoader` – square thumbnail of the last photo (EXIF-rotated) or video (first frame), loaded off the main thread.
- `CameraActivity` layout (built in code): preview, focus ring, shutter-flash overlay, top row (back | timer | flash), bottom
  (mode pill above thumbnail | shutter | switch camera) on a soft dark fade.
  - Flash button cycles the engine's flash and shows off / auto / on (lit when on); dimmed when the lens has no flash unit.
  - Switch button is dimmed when the device has only one lens. While a video records, switch / mode / thumbnail are dimmed and
    ignored; the shutter turns into a stop square and the timer runs (from CameraX's recording stats).
  - Shutter: photo mode takes a photo (short white flash, haptic tick), video mode starts / stops the recording.
  - If the camera cannot be opened, a glass error icon replaces the controls (the screen stays open, back still works).
  - Pinch zoom and tap to focus (with the ring) from step 3.
- (Replaced later) Until step 5 the files were written to `cache/camera`; step 5 moved them to `DCIM/Camera`. The thumbnail tap
  was wired in step 6 (Gallery / Video).
- Not run here (no Android SDK / network): build once with `./gradlew :app:assembleDebug`. Version stays 2.5.3 (code 120).

### Step 5 — saving to `DCIM/Camera` and permissions (`CameraStorage`, `CameraActivity`)

- `CameraStorage` (internal object) decides where a photo / video goes, so the Gallery, the Video app and every other gallery show it:
  - **Android 10+**: MediaStore (`RELATIVE_PATH = DCIM/Camera`, `IMG_yyyyMMdd_HHmmss` / `VID_…`), no storage permission. Photo:
    `ImageCapture.OutputFileOptions(contentResolver, …)`; video: `MediaStoreOutputOptions` (the engine overload from step 2).
  - **Android 8 / 9**: a plain file in `DCIM/Camera`; needs `WRITE_EXTERNAL_STORAGE` (declared with `maxSdkVersion="28"`, same line as
    `:gallery` / `:app`), asked together with the camera. After saving, `MediaScannerConnection.scanFile` lists it at once. If the user
    denies it, the file goes to the app's own folder (`Android/data/<app>/files/DCIM/Camera`): saved, but other apps do not see it.
  - `discard()` removes the half-written result of a recording that ended with an error.
- `ui/ThumbLoader` now takes a uri (`content://` or `file://`) instead of a file.
- **Permissions** (`CameraActivity`):
  - Opening the screen asks for CAMERA (+ storage on Android 9 and older). Only CAMERA decides: granted → the camera opens.
  - Denied → a glass **lock** icon replaces the controls. Tap: ask again while Android still asks, otherwise open the app's settings page;
    coming back with the permission granted opens the camera (`onResume`).
  - RECORD_AUDIO is asked once, when the first video starts. Granted or not, the recording starts (without sound when denied).
- The `cache/camera` folder of step 4 is no longer used.
- Not run here (no Android SDK / network): build once with `./gradlew :app:assembleDebug`. Version stays 2.5.3 (code 120).

### Step 6 — launcher integration (`:app`) and thumbnail tap

- **Start menu / "All apps"**: new built-in entry **Camera** (`StartApps`: `BUILTIN_CLS_CAMERA`, vector icon `CAMERA_PATH`, yellow `#FFD34E`,
  `section = "camera"`), placed after Gallery. `MainActivity` opens `CameraActivity.start(this)` for that section.
  Note: the "All apps" list is sorted by name, so the numbers of `rizwans2://N` after "Camera" shift by one.
- **Home screen icon**: `VectorIconView.CAMERA` (same path and colour) and `desktopIcon(…, "Camera", "camera")` in `Win11Shell`.
- **Deep link**: `rizwans2://camera` opens the Camera in photo mode, `rizwans2://camera?mode=video` in video mode (`MainActivity.handleDeepLink`;
  the comment list in `AndroidManifest.xml` and the KDoc are updated).
- **Thumbnail tap** (`CameraActivity`): a plain `ACTION_VIEW` intent with `setPackage(packageName)` and the saved `content://` uri:
  `image/*` reaches the Gallery viewer, `video/*` the Video player (both already have that filter), so `:camera` needs no dependency on
  `:gallery` or `:video`. On Android 8 / 9 (file written to DCIM) the uri comes from the media scanner a moment after saving
  (`CameraStorage.scan(..., onDone)`); a `file://` uri is never sent to another screen. Ignored while recording.
  **Fix (explicit component):** the implicit intent made some phones (Tecno / Transsion) show the system resolver and the error
  "TranResolver is not available right now". `openLast()` now uses `setClassName(packageName, ...)` with
  `com.srizwan.gallery.viewer.GalleryViewerActivity` (photo) or `com.srizwan.video.player.VideoPlayerActivity` (video), so the tap always
  opens the built-in Gallery / Video player directly. Same uri, mime type and read-permission flag; `:camera` still has no module dependency.
- Not run here (no Android SDK / network): build once with `./gradlew :app:assembleDebug`. Version stays 2.5.3 (code 120).

### Step 7 — Browser link (`:camera`, `:chooser`, `:app` `BrowserUi` / `MainActivity`)

Three ways the built-in Browser uses the Camera. `:camera` still depends on no other module.

1. **`<input type=file capture>`**: `onShowFileChooser` checks `FileChooserParams.isCaptureEnabled`. If the page takes photos / videos it opens
   `CameraActivity` in **capture mode** (`CameraActivity.captureIntent(context, mode, lockMode)`, started for a result):
   one photo / video, saved to `DCIM/Camera` like any other, returned as `data` (a `content://` uri with a read grant, `CameraActivity.resultUri`)
   and the screen closes. The thumbnail is hidden; the photo / video switch is hidden too when the page accepts only one kind. The mode is
   video when the page accepts only videos, photo otherwise (the `accept` list may hold MIME types, families or extensions). The result goes
   through the same `fileChooserLauncher` / `FilePicker.uris` as a picked file. If the camera cannot start, the file picker opens as before.
2. **Camera button in the file picker** (page upload without `capture`, accepting photos / videos or anything): `FilePicker.intent(..., cameraButton = true)`
   shows a camera icon in the picker's top bar (`ch_ic_camera`, `ch_cd_camera`; own callers only, `PickerOptions.cameraButton`). Tapping it
   ends the picker with `FilePicker.RESULT_CAMERA` (no data); `MainActivity.fileChooserLauncher` then opens the capture camera for the same
   upload. `:chooser` knows nothing about `:camera`: it only reports the tap. Pages that accept only e.g. PDF get no Camera button.
3. **Website live camera / microphone** (`getUserMedia`: QR scan, video call, photo booth): `WebChromeClient.onPermissionRequest` (before,
   the Browser never answered it, so such pages got nothing). Flow: a glass dialog "Allow camera / microphone / camera and microphone?" naming the
   site (Allow / Block) -> Android's own CAMERA / RECORD_AUDIO permission when missing (`webPermissionLauncher`) -> `request.grant` with what is
   now allowed, `deny` otherwise. Other resources (protected media id, MIDI) are denied. `MODIFY_AUDIO_SETTINGS` was already in the manifest.
   A site is asked each time (nothing is remembered); only secure pages (https / localhost) can call `getUserMedia` in a WebView at all.

Where the code is: `BrowserUi.kt` (`onShowFileChooser`, `onPermissionRequest`, helpers `uploadAcceptsMedia`, `uploadCameraIntent`, `handleWebPermission`,
`finishWebPermission` at the end of the file), `MainActivity.kt` (`uploadAccept`, `pendingWebPermission`, `webPermissionLauncher`, the `RESULT_CAMERA` branch).
- Not run here (no Android SDK / network): build once with `./gradlew :app:assembleDebug`. Version stays 2.5.3 (code 120).

### Step 8 — details updated

- `README.md`: this section, the plan table (all 9 steps done) and the notes of steps 2 and 4 that later steps replaced.
- `settings.gradle.kts` (`include(":camera")` with its comment), `app/build.gradle.kts` (dependency), `AndroidManifest.xml` of `:app`
  (deep-link comment: `camera`, `camera?mode=video`) and of `:camera`, `MainActivity` KDoc of `handleDeepLink`: all list the Camera.
- Start menu entry **Camera** (after Gallery) shifts the numbers of `rizwans2://N` for the apps after it by one (the list is sorted by name).
- Version stays **2.5.3 (code 120)**: nothing in the build files asks for a bump; change `versionName` / `versionCode` in `app/build.gradle.kts` if you want one.

### Step 9 — final review

Read-through of every new / changed file (no Android SDK or network here, so **no Gradle build was run**):
- XML of the module (manifest, values, 9 vector icons) parses; every `R.string / R.drawable / R.color` used by `:camera` exists; `ch_ic_camera` /
  `ch_cd_camera` exist in `:chooser`.
- `:camera` has no dependency on `:gallery`, `:video` or `:chooser`; `:app` talks to it through `CameraActivity.start()` and `captureIntent()`.
- Changed outside `:camera`: `settings.gradle.kts`, `app/build.gradle.kts`, `:app` (`StartApps`, `Win11Shell`, `MainActivity`, `BrowserUi`, manifest comment),
  `:chooser` (`FilePicker`, `FilePickerActivity`, `PickerOptions`, one icon, one string). Nothing else.

Build and test once: `./gradlew :app:assembleDebug` (CI: `UltimateBuild.yml`). Then on a device:
1. Start menu -> **Camera** (also the Home icon and `rizwans2://camera`, `rizwans2://camera?mode=video`): preview appears after the permission.
2. Photo: shutter -> white flash, thumbnail appears; tap the thumbnail -> Gallery viewer. File is in `DCIM/Camera` (Gallery app lists it).
3. Video: mode pill -> video, shutter -> timer runs, shutter again -> thumbnail; tap -> Video player. First time asks for the microphone.
4. Flash button (off / auto / on), pinch zoom, tap to focus (ring), front / back switch. Rotate the phone while shooting: the picture is upright.
5. Deny the camera permission -> glass lock; tap it -> asks again, or opens the app settings after "don't ask again".
6. Browser: a page with `<input type=file accept="image/*" capture>` -> Camera opens, one shot returns to the page. A page with a plain file
   input -> picker with a camera icon in the top bar. A page that calls `getUserMedia` (https) -> Allow / Block dialog, then the stream.
7. Android 8 / 9 (if you have one): the first start also asks for storage; denied storage saves to the app's own folder.

Known limits (kept small on purpose): no filters / HDR / timer / grid / QR mode; the icons do not rotate with the phone; the capture camera for
uploads ignores the page's front / back hint (`capture="user"`), because WebView does not pass it on; the torch of the Quick controls and the
Camera's flash use the same hardware, so use one at a time.

## Downloads — step 4: multi-select, Select all, batch delete (`:app`: `DownloadsUi.kt`, `DlEngine.kt`, `MainActivity.kt`)

- **Start**: long-press a download row. The title bar is replaced by a selection bar (X, "N selected", Select all, Delete, more). Rows get a checkbox and a soft accent tint; tapping a row toggles it, and the pause / cancel buttons are hidden so no tap does something else.
- **Select all** selects every row of the current filter (All / Downloading / Completed); tapped again, when everything is selected, it clears the selection. The more menu also has **Invert selection**.
- **Delete** (trash icon): deletes the finished files from the phone **and** the list entries; unfinished downloads are stopped and their partial data removed. **Remove from list** (more menu) keeps the files. Both ask first, with the counts in the message.
- **`DlEngine.deleteMany(ids, deleteFiles, onDone)`**: stops the running ones, removes all entries, saves the list **once** for the whole batch (not once per item), then deletes the files on a background thread (MediaStore / SAF `savedUri`, then the plain `savedPath`). `onDone` runs on the main thread.
- **Back** leaves selection mode first (`DownloadsUi.handleBack()`, called from `MainActivity.onBackPressed`); changing the filter chip, hiding the screen, or deselecting the last row also leaves it. Rows that disappear during a storage refresh drop out of the selection. Pull-to-refresh is off while selecting.
- The old per-item menu is still there: with exactly one row selected, the more menu has **This item…**.
- New icons: `ic_w_delete.xml`, `ic_w_select_all.xml`. Not built or run here (no Android SDK / Gradle in this environment): build once and test long-press, Select all, Delete with a mix of finished / running items, and Back.

## Downloads — step 5: rename, share, file info, re-download, search, sort (`:app`: `DownloadsUi.kt`, `DlEngine.kt`, `BrowserUi.kt`, `MainActivity.kt`)

- **Menu of a finished download** (long-press a row, then "This item…" when it is the only one selected, see step 4): Open, **Rename**, **Share**, **File info**, Show in Downloads folder, **Re-download**, Delete file, Remove from list, Copy link. Unfinished / failed rows get **File info** too. "Open" is still the own "Open with" sheet of `:chooser` (unchanged), so there is no second "Open with" item.
- **`DlEngine.rename(id, newName, onDone)`**: background thread. With a MediaStore `savedUri` (Android 10+) it updates `DISPLAY_NAME` (`uniqueMediaName` first looks for a clash in the same `RELATIVE_PATH`: `name (1).ext`); with a plain path (Android 9 and older) it renames the `File`, rescans old and new path and takes the new `savedUri` from the scanner. `savedPath`, `fileName` and (if the extension changed) the MIME type are updated and saved. A name typed without an extension keeps the old one. `DlEngine.cleanFileName()` turns `\ / : * ? " < > |` and control characters into `_`, trims dots / spaces, max 200 characters with the extension kept.
- **Share**: `MainActivity.shareDownloaded()` (`BrowserUi.kt`): `ACTION_SEND` with the file's content uri and `FLAG_GRANT_READ_URI_PERMISSION`; "File not available" / "File is no longer in storage" like Open.
- **File info**: name, size, type, date added, status, location, link (with a "Copy link" button).
- **Re-download** (`DlEngine.redownload`): a new queue entry with the same link, cookies, user agent and referer (the old file stays; the new one gets `(1)`). Not offered for blob / data downloads.
- **Search**: magnifier in the title bar opens a search field (file name or link, as you type); X or Back closes it and clears the text. It works together with the All / Downloading / Completed chips and with selection (rows that no longer match leave the selection).
- **Sort**: "Newest / Oldest / Name A–Z / Name Z–A / Largest / Smallest" chip at the right of the chip row; the choice is kept (`DlEngine.sortMode`).
- Not built or run here (no Android SDK / Gradle): test rename of a file in Downloads (also to a name that already exists), Share to another app, search while selecting, and sort after a few downloads.

## Downloads and browser pop-ups — step 6: integration check and change list

**Checked by hand** (no Android SDK / Gradle in this environment, so no build and no device test):
- All `.xml` files parse (layouts, drawables, values, manifest).
- `DownloadsUi.kt`: every `R.drawable.*` it uses exists, brackets balance, imports cover `EditText`, `ImageView`, `TextWatcher`, `EditorInfo`, `InputMethodManager`, `DateFormat`, `Date`. `DlEngine.kt` already imports `Uri`, `OpenableColumns`, `MediaStore`, `ContentValues`, `MediaScannerConnection`. In `DlEngine.kt`, `BrowserUi.kt` and `MainActivity.kt` the bracket counts are identical to the files before steps 4 and 5 (nothing added or lost).
- Manifest: `DownloadService` (`dataSync`) and `PopupPlaybackService` (`mediaPlayback`) are declared; `FOREGROUND_SERVICE`, `FOREGROUND_SERVICE_DATA_SYNC`, `FOREGROUND_SERVICE_MEDIA_PLAYBACK`, `POST_NOTIFICATIONS`, `SYSTEM_ALERT_WINDOW` and the storage permissions are present. Nothing new was needed for steps 4 and 5.
- Delete of finished files goes through the app's own MediaStore rows / its own files, so it needs no extra permission; share uses the file's content uri with a read grant.

**Files changed in steps 4 and 5** (everything else is untouched):
- `app/.../DownloadsUi.kt`: multi-select, Select all, Invert, batch Delete / Remove, search, sort chip, Rename / Share / File info / Re-download menu items.
- `app/.../DlEngine.kt`: `deleteMany`, `rename` (+ `doRename`, `uniqueMediaName`, `applyRenamed`), `cleanFileName`, `redownload`, `sortMode` and the `SORT_*` constants.
- `app/.../MainActivity.kt`: Back goes through `DownloadsUi.handleBack()` first; `onShare` passed to `DownloadsUi`.
- `app/.../BrowserUi.kt`: `MainActivity.shareDownloaded()`.
- `app/src/main/res/drawable/ic_w_delete.xml`, `ic_w_select_all.xml` (new).
- `README.md`: the step 4, step 5 and this section.

**Known limit**: the minimized pop-up window (`FLOAT`, `BrowserPopup.kt`) floats above every screen *of this app* and keeps playing through `PopupPlaybackService`; it is not a `TYPE_APPLICATION_OVERLAY` window, so it is not drawn over other apps. `SYSTEM_ALERT_WINDOW` is declared and the "Display over other apps" grant already exists in Notifications settings, so an overlay version is possible as a separate change.

## Browser pop-ups — step 7: minimized pop-up floats over other apps (`BrowserPopup.kt`)

- **Overlay window**: with "Display over other apps" granted, a minimized pop-up (FLOAT) is added with `WindowManager` as `TYPE_APPLICATION_OVERLAY` (`TYPE_PHONE` before Android 8, `FLAG_NOT_FOCUSABLE | FLAG_NOT_TOUCH_MODAL`, so touches outside the window go to the app below). It stays on screen over other apps and the home screen, and audio / video keeps playing (`PopupPlaybackService`, keep-alive JS, WebView not paused). Drag by the header and resize with the corner grip work the same in the overlay (screen coordinates; size and position are kept between app layer and overlay).
- **No permission**: it floats inside the app as before. The first time a pop-up is minimized without the permission a dialog explains it once per run ("Allow" opens the system "Display over other apps" screen for this app, "Not now" keeps the in-app float). When the user comes back with the permission granted, `resumePopups()` moves every in-app floating window into the overlay (`refreshFloatHost()`). If the system refuses the overlay window, the pop-up falls back to the app layer.
- **Restore / Open as tab** from an overlay window first brings the app to the front (`bringAppToFront()`, a plain explicit launch of `MainActivity`, which is `singleTask`; its `onNewIntent` does nothing for an intent without extras or the HOME category), then restores the pop-up as a dialog or turns it into a tab. Close just removes the overlay window.
- **Teardown**: `release()`, `detachWebView()` and leaving FLOAT all go through one `removeFloatView()` (overlay: `removeViewImmediate`; app layer: `removeView`), so no overlay window is left behind when the pop-up closes, becomes a tab or the activity is destroyed.
- **Limit**: the overlay window is not focusable, so the keyboard does not open in it; use Restore to type (login, forms). Playing and scrolling a page work.
- Not built or run here (no Android SDK / Gradle). Test: minimize a pop-up (permission prompt, Allow), press Home (window stays, audio keeps playing), drag and resize it over another app, tap Restore (app comes to the front, pop-up is a dialog again), tap Open as tab, tap Close, and rotate the phone while it floats (a window outside the new screen can be dragged back by its header).

## Browser pop-ups — step 9: Keyboard / Touch toggles, file picker in the pop-up, no automatic close (`BrowserPopup.kt`, `BrowserUi.kt`)

- **Two icon-only toggle buttons** (no text) in the pop-up title bar and in the floating header, blue = on, red = off: **Keyboard** (off: the keyboard cannot open in this pop-up; the page view is made unfocusable and a floating overlay window stays non-focusable) and **Touch** (off: touches on the page view are swallowed; header buttons, drag and resize still work). State per pop-up, kept across dialog / full / floating, both start on. New icons `ic_popup_keyboard.xml`, `ic_popup_touch.xml`.
- **File picker inside a pop-up** (it had none): the tab's `onShowFileChooser` body is now `MainActivity.openFileChooser()`, used by tabs and pop-ups; nothing is paused while a picker is open; an overlay pop-up brings the app to the front first.
- **A pop-up never closes by itself:** page `window.close()` ignored, the "download-only pop-up" auto-close removed, closing the owner tab moves its pop-ups to the next tab instead of closing them. Still closes: its Close button, Back (dialog / full), the app being destroyed (Android killing the process cannot be prevented).
- Details, table of what was found, test list: `docs/CHANGES-step9-popup-toggles-filepicker.md`. Not built or run (no SDK / Gradle here).

## PPSSPP — `:ppsspp` module (PPSSPP v1.20.4, package `org.ppsspp.ppsspp`)

[PPSSPP](https://github.com/hrydgard/ppsspp) (pinned tag **v1.20.4**, GPL-2.0-or-later) is a PSP emulator. It is now a built-in app of Win11 in the same style as J2ME / Camera:
own Gradle module, resources prefixed `pp_`, no launcher icon of its own. Licence and credits: `NOTICE-PPSSPP.md`, `LICENSE-PPSSPP`. The module's own notes (more detail per step) are in `ppsspp/README.md`.

The Android part (19 Java files, `tombstone.proto`, icons, manifest) is in `ppsspp/`. The C++ core (`android/jni`, `ext/`, FFmpeg libraries) and the runtime `assets/` are **not in the project zip**:
`ppsspp/tools/fetch-upstream.sh` clones the tag from `ppsspp/UPSTREAM_VERSION` into `ppsspp/upstream/` (git-ignored) before every build.

### PPSSPP plan (10 steps)

| # | Step | Status |
|---|------|--------|
| 1 | Get the source (v1.20.4 + submodules) | done |
| 2 | `:ppsspp` module: Java, proto, `pp_` resources, library manifest, fetch script | done |
| 3 | Gradle wiring: `settings.gradle.kts`, protobuf plugin, CMake path, NDK, ABIs, `:app` dependency, `fetchPpssppUpstream` task | done |
| 4 | Manifest merge into `:app` (reviewed against every other module) | done |
| 5 | Hooks: Start menu, Home icon, `rizwans2://ppsspp`, File Manager | done |
| 6 | Assets and licence files (`NOTICE-PPSSPP.md`, `LICENSE-PPSSPP`) | done |
| 7 | CI: source cache, ccache, disk space, timeout, APK check | done |
| 8 | Update all details (this section, `ppsspp/README.md`, comments) | done |
| 9 | Checks (static only, see "Step 9 results" below) | done |
| 10 | Final flat zip `RizwanS2-main-ppsspp.zip` | done |

### Where it is hooked in

| Place | What |
|---|---|
| Start menu | built-in app **PPSSPP** (handheld-console icon, blue), section `ppsspp` (`StartApps.kt`) |
| Home screen | desktop icon **PPSSPP** under J2ME (`Win11Shell.kt`, `VectorIconView.PPSSPP`) |
| Deep link | `rizwans2://ppsspp` (`MainActivity.kt` `handleDeepLink`, the KDoc list and the manifest comment) |
| File Manager | tap `.iso` / `.cso` / `.chd` / `.pbp` / `.elf` / `.ppdmp` → the game starts in PPSSPP (`FileManagerUi.kt` `openFile`, `PpssppLauncher.kt`); blue type chip (`fileTypeColor`) |
| Other apps | the same file types opened from any app can start in PPSSPP (VIEW filters of upstream kept in `:ppsspp`'s manifest) |
| Settings | `settings.gradle.kts` (`:ppsspp`), `app/build.gradle.kts` (`implementation(project(":ppsspp"))`), root `build.gradle.kts` (protobuf plugin 0.9.6) |

`PpssppLauncher.kt` passes the game as a plain absolute path in PPSSPP's own shortcut extra (`PpssppActivity.SHORTCUT_EXTRA_KEY`): a `file://` uri would throw (target API 28) and a `content://` uri would leave PPSSPP without a real path.
It relies on the all-files permission `:app` already declares. PPSSPP's own first-start choices (where to keep its data, its permission prompts) are upstream behaviour, unchanged.

### What changed compared with upstream (GPL "changes" list, also in `NOTICE-PPSSPP.md`)

- **Library, not an app**: `:ppsspp` is an Android library (`namespace org.ppsspp.ppsspp`, compileSdk 37, minSdk 26, NDK `ext.ndkVer`, CMake 3.22.1, upstream's root `CMakeLists.txt` with the "normal" flavor arguments, platform android-26).
  Java package names and JNI names are unchanged (the native code depends on them).
- **One variant**: no gold / legacy / vr flavors, no signing, no git-version logic, no lint baseline. `PpssppActivity.isVR()` returns `false` (it used `BuildConfig.FLAVOR`).
- **Resources**: all names start with `pp_` (`pp_app_name`, `pp_shortcut_name`, `pp_style`, `pp_theme_proxy_transparent`, `pp_black`, `pp_ic_launcher*`, `pp_ic_banner`); `ShortcutActivity` uses `R.mipmap.pp_ic_launcher`. A scan found no clash with another module.
- **Manifest**: no `MAIN` / `LAUNCHER` filter (no second icon), no `<application>` attributes (`:app` keeps its own), icon / label / banner on `PpssppActivity`, `android.max_aspect` moved from `<application>` to the activity,
  no `uses-sdk tools:overrideLibrary`. All permissions already exist in other modules except `TRANSMIT_IR` (no prompt) and `archos.permission.FULLSCREEN.FULL` (ignored).
- **ABIs**: `arm64-v8a` only by default (like `:winlator`); more with `-PppssppAbis=arm64-v8a,armeabi-v7a`. On a 32-bit phone PPSSPP cannot load its library (upstream shows its own "no native binary" message).
- **Source and assets at build time**: `fetchPpssppUpstream` (bash + git) runs before CMake and asset merging; offline, put the files in `ppsspp/upstream/` by hand. `upstream/assets` (about 22 MB) is the module's assets folder.
- **CI**: `UltimateBuild.yml` and `UltimateBuild_NoWinlator.yml` cache the source, use ccache for PPSSPP only, free disk space first, run up to 120 minutes and fail if `libppsspp_jni.so` or the assets are missing from the APK.
- **Library versions** (same as upstream): appcompat (project uses 1.6.1), documentfile 1.1.0, protobuf-javalite 4.33.5, protoc 3.25.3, protobuf Gradle plugin 0.9.6 (the AGP 8.x line; 0.10.0 is for AGP 9).
- **APK size**: grows by the arm64 `libppsspp_jni.so` plus about 22 MB of assets (not measured here).
- **Licence**: GPL-2.0-or-later code now runs in the same process as the Apache-2.0 and LGPL parts. `NOTICE-PPSSPP.md` explains the usual handling; check it before publishing.
- Version stays 2.5.3 (code 120).

### Step 9 results (static checks, run on this zip)

- All 482 `.xml` files parse (manifests, layouts, values, drawables); all 7 workflow files parse as YAML; none has a duplicate step name.
- Bracket balance with a real tokenizer (comments / strings / templates skipped): 68 files (4 Gradle files, 19 PPSSPP Java files, all `:app` Kotlin files), 0 problems.
- Resources: every `pp_` name is unique inside `:ppsspp` and does not exist in any other module; every `@type/name` in `:ppsspp`'s manifest and every `R.x.y` in its Java files resolves
  (`Theme_Material_Dialog_Alert` is `android.R`, not ours); all 4 manifest class names exist as files.
- `:app` manifest: no duplicate component or permission; the PPSSPP entries come from the merged library manifest, `:app` only has comments.
- Hooks present and consistent: Start menu (`StartApps.kt`), Home icon (`Win11Shell.kt`), `rizwans2://ppsspp` (`MainActivity.kt`), File Manager (`FileManagerUi.kt` + `FileExplorerUi.kt`), `PpssppLauncher.kt`.
- CI: both build workflows have the same PPSSPP steps (cache, fetch, ccache, APK check) and a 120 minute timeout; `ppsspp/upstream/` is git-ignored.
- Gradle: `include(":ppsspp")`, `implementation(project(":ppsspp"))`, protobuf plugin in the root file, `ndkVer` defined, compileSdk 37 / minSdk 26 equal to `:app`.
- **Device-test fix**: PPSSPP showed "Give PPSSPP permission to access storage" (upstream only checks `WRITE_EXTERNAL_STORAGE`, never granted at API 28 on Android 11+). `PpssppActivity` now also accepts all-files access (`MANAGE_EXTERNAL_STORAGE`, already used by the File Manager) and opens the system "All files access" page when asked; see `ppsspp/README.md`.
- Behaviour note: a tap on a PSP file starts the game directly (same as J2ME / video / gallery); the own **"Open with..."** sheet (`:chooser`) is shown through the file's "Open with..." action, where PPSSPP is listed through its VIEW filters.

### Not verified here

No Android SDK, NDK, Gradle download or GitHub access in this environment, so **no Gradle build, native build, CI run or device test was run**. Checked by hand: all XML parses, every `@type/name` of the module resolves, no resource clash,
both workflow files parse as YAML, bracket balance of the Gradle files. **Build once with `./gradlew :app:assembleDebug` or run `UltimateBuild.yml`.** Things to look at first if it fails:
(1) the protobuf plugin 0.9.6 with AGP 8.13.2 (`generateProto` task; `builtins { create("java") }` syntax); (2) a CMake / NDK error in upstream's build (NDK `29.0.13846066`, upstream used `29.0.14206865`);
(3) `libc++_shared.so` picked from another module (already `pickFirsts` in `:app`); (4) disk space on the runner.
Test on a device: Start menu → **PPSSPP** (also the Home icon and `rizwans2://ppsspp`) → PPSSPP's game browser opens → pick a `.iso` / `.cso` → the game runs; File Manager → tap a `.iso` → the game starts directly;
rotate, back button, close and open again. Keep PPSSPP closed before starting a second game from the File Manager (upstream does not switch games while running).
"All apps" numbers (`rizwans2://N`) shift by one for the apps after **PPSSPP** (the list is sorted by name).

## RetroArch — `:retroarch` module (all 12 steps done, not built or run yet; details: `retroarch/README.md`)

- Upstream https://github.com/libretro/RetroArch, pinned `v1.22.2` in `retroarch/UPSTREAM_VERSION` and its commit `69a4f0ea1e8aaf442ae4858f2e7f2b31a1776576` in `retroarch/UPSTREAM_COMMIT` (GPL-3.0). Same idea as `:ppsspp`: the source is cloned at build time (not in the zip).
- Step 1 (done): upstream checked. NativeActivity frontend, native lib `retroarch-activity` built with ndk-build (`pkg/android/phoenix-common/jni/Android.mk`, needs the whole repo), 9 small Java files, no submodules, resource names that clash with `:app` / `:winlator` (`ic_launcher`, `app_name`, ...) to be prefixed `ra_`.
- Step 2 (done): version pinned and checked on GitHub. `v1.22.2` is the newest stable tag (lightweight tag, commit date 2025-11-20, no `.gitmodules`). The commit is stored next to the tag; the fetch script (step 4) will stop the build if the clone is on another commit, so a moved tag cannot change the build silently.
- Step 3 (done): the `:retroarch` library module exists and is in `settings.gradle.kts` and `:app`, but it is **empty** (namespace `com.retroarch`, compileSdk 37, minSdk 26, project NDK, arm64-v8a by default, `-PretroarchAbis=...` to override, `PLAY_STORE_BUILD=false`, keep rules for the JNI classes). No Java, resources, native build or app hooks yet, so the APK behaves as before. Upstream's Java needs no library dependency.
- Step 4 (done): `retroarch/tools/fetch-upstream.sh` shallow-clones the tag into `retroarch/upstream/` (about 332 MB, 11,147 files, git-ignored), **stops the build if the commit is not `UPSTREAM_COMMIT`**, and checks 9 paths the module needs. Gradle task `fetchRetroarchUpstream` (`./gradlew :retroarch:fetchRetroarchUpstream`). The script was run for real (first run, second run, wrong commit, bad files, hand-placed copy, missing path). The task is attached to the native-build tasks, which only exist from step 5, so CI is not changed and does not clone yet.
- Step 5 (done in the build file, **not compiled yet**): native build with upstream's own `Android.mk` via `externalNativeBuild { ndkBuild }` -> `lib/arm64-v8a/libretroarch-activity.so` (`APP_PLATFORM=android-26`, `APP_STL=c++_static`). The fetch task now runs before `preBuild` and every native task, so the first CI run clones and compiles RetroArch by itself (about 330 MB, long compile, no cache / ccache until step 10). Optional properties: `retroarchNative=false` (escape hatch: no native build, no clone), `retroarchAbis`, `retroarchCcache`, `retroarchGles=3`, `retroarchCFlags` / `retroarchCppFlags` (see `retroarch/README.md`, also commented in `gradle.properties`). `Android.mk` was evaluated with GNU make (flags and sources as expected); the API-26 `ifaddrs` clash was checked and does not happen. Main risk: tag written for NDK r22, project has NDK 29.
- Decision: cores, core info and assets are **not** bundled; RetroArch's Online Updater (Core Downloader) fetches them. Works because `:app` keeps `targetSdk = 28`.
- Open risk: the tag was written for NDK r22, the project uses NDK 29; first CI build decides. GPL-3.0 vs the GPL-2.0 parts: licence check before publishing.
- Step 6 (done, **not built yet**): the 10 small upstream Java files, the `ra_` resources and the real library manifest are in the module (checked against the real `v1.22.2` tree). Decisions: RetroArch runs in its own process `:retroarch` (upstream calls `System.exit` / `exit`, which would close the whole app; `App.kt` starts no engine there, like for `:mame`); both activities are **not exported** (the `LIBRETRO` extra is a `.so` path); the documents provider is kept but **disabled** (in Win11 it would show the data folder of the whole app); RetroArch's own unpacking of the APK `assets/` folder is **switched off** (that folder holds PPSSPP / Winlator / MAME files). Only 3 upstream files are edited after step 8, `bash retroarch/tools/diff-upstream-java.sh` shows it.
- Step 7: nothing to build (decision: online core downloader only).
- Step 8 (done, **not compiled yet**): `app/.../RetroArchLauncher.kt`: Start menu entry **RetroArch**, Home screen icon and `rizwans2://retroarch` (game-pad vector icon, shown only on 64-bit ARM phones with the native library), and the File Manager opens console ROMs (`.nes .sfc .smc .gb .gbc .gba .n64 .z64 .nds .gen .smd .32x .sms .gg .pce .sgx .a26 .a78 .lnx .ngp ...`) in RetroArch. Disc images, `.zip`, `.md` and other ambiguous files are left out on purpose. The core is chosen by the launcher from the downloaded ones (step 7); with no fitting core RetroArch's menu opens with a hint. Another game while RetroArch runs: the old `:retroarch` process ends (upstream's `System.exit`) and the launcher starts the new game. One small edit in upstream's `MainMenuActivity` (accepts the extras `ROM` / `LIBRETRO`).
- Step 7 (done, core picker compiled with Kotlin 2.2.10 and tested, **not run on a device**): your decision stays: **no cores bundled**, RetroArch's Online Updater downloads them (checked in the real `v1.22.2` source: updater compiled in, arm64 buildbot URL, folders under the app's data folder, `targetSdk 28` lets the downloaded `.so` load). Reading upstream also showed that step 8 was wrong: a game given without a core does **not** show a core list, RetroArch shows its plain menu. New `app/.../RetroArchCores.kt` picks the downloaded core for a file extension (preference list, then the core info files) and the launcher now sends `ROM` + `LIBRETRO`. First use: RetroArch -> Online Updater -> Update Core Info Files -> Core Downloader -> then tap a ROM in the File Manager.
- Step 9 (done, documents only): `NOTICE-RetroArch.md` (source, licence GPL-3.0, what to keep when distributing, list of Win11 changes, compatibility table for every part of the app) and `LICENSE-RetroArch` (standard GPL-3.0 text). Checked: the 51 licence headers of MAME4droid's Java files say GPL "version 2 or any later version", so no GPL-2.0-only part was found among the checkable parts (the `settings.gradle.kts` comment that said "GPL-2.0" is corrected). **Open for you before publishing:** the MAME core binary (not checked), a missing notice file for NewPipeExtractor in `:youtube` (GPL-3.0 as far as I know, not checked), RetroArch's own file headers (not re-checked). Not legal advice.
- Step 10 (done in the YAML, **not run yet**): both workflows (`UltimateBuild.yml`, `UltimateBuild_NoWinlator.yml`) got the same changes: cache of `retroarch/upstream` (key from `UPSTREAM_VERSION`, `UPSTREAM_COMMIT` and the fetch script), a "Fetch RetroArch source" step after the package rename (runs `retroarch/tools/fetch-upstream.sh`, stops on a wrong commit), `retroarchCcache` on (ccache shared with PPSSPP, limit 1500M -> 3000M, old PPSSPP cache still a restore key), a Docker-image prune in "Free disk space", and an APK check that **fails** if `lib/arm64-v8a/libretroarch-activity.so` is missing / under 1 MB or if the merged manifest lacks the two RetroArch activities in the process `:retroarch`. No "RetroArch assets" check: nothing is bundled (step 7). Timeout stays 120 minutes. A commented-out `retroarchCFlags` line is ready if NDK 29 rejects old C code. Static checks only (YAML, `bash -n`, the APK test on fake lists); details and the open risks in `retroarch/README.md`, "Step 10".
- Step 11 (done, documents only): `retroarch/README.md` starts with an **Overview** (where RetroArch opens from, first use, file map, switches, CI, version bump, a table of likely first-CI-run failures, one list of everything not verified) and `docs/CHANGES-step8-retroarch.md` lists every changed and new file of steps 1 to 11. Note for `rizwans2://N`: the "All apps" numbers shift by one for apps after **RetroArch** in the sorted list, but only on phones where the entry is shown (64-bit ARM with the native library), so numbers can differ between devices; named links are fixed. The deep-link lists (KDoc of `handleDeepLink`, manifest comment, `RetroArchLauncher.kt` header) already name `retroarch`.
- Step 12 (done): final static checks on the whole project, nothing missing compared with the uploaded `step82` zip, no code change in steps 9 to 12. XML / YAML / shell syntax, resource names (0 clashes), hooks, the 22 file extensions (same in the code and the docs), Kotlin brackets (all 188 files, with a string-template-aware check), the 3 `WIN11`-marked Java files, the pin files, workflow strings vs the library manifest: all pass. Not run here: `diff-upstream-java.sh` (needs the clone / network), the compilers, Gradle, the NDK, CI. **Next for you:** push the zip and start `UltimateBuild.yml`; the failure table in `retroarch/README.md` ("Overview") lists what to try first. Open items: three licence checks (MAME core binary, a notice for NewPipeExtractor, RetroArch's file headers), the first CI run, and the device checks.

## MAME (MAME4droid) — plan, all 9 steps done (details: `docs/MAME4DROID-STEP1-ANALYSIS.md`)

Planned built-in app **MAME** (arcade emulator) from [MAME4droid (Current)](https://github.com/seleuco/MAME4droid-Current) (GPL-2.0-or-later: the source headers say "version 2 or any later version", v1.41.2, MAME core 0.289), same pattern as `:ppsspp` (module `:mame`, resources `mm_`, source fetched at build time, not in the zip).
Step 1 (reading this project and the upstream) is done; no code or Gradle file was changed. Findings: the MAME core `libMAME4droid.so` is not in the upstream repo (it is built separately; plan: take it from the official release APK in CI),
upstream minSdk is 29 (this project 26), arm64-v8a only, Java package `com.seleuco.mame4droid` must stay (JNI names), licence is GPL-2.0 (no non-commercial clause). Steps 2-9 are listed in the docs file.
Step 2 (done): core source = plan A, the prebuilt `libMAME4droid.so` (367 MB) is taken from the official v1.41.2 release APK at build time and checked against the SHA-256 in `mame/UPSTREAM_SHA256`; version pinned in `mame/UPSTREAM_VERSION`;
`NOTICE-MAME4droid.md` and `LICENSE-MAME4droid` added; still no Gradle change. Details and the size decision for step 3: `mame/README.md`.

Step 3 (done): module `:mame` (`mame/`, namespace `com.seleuco.mame4droid`, minSdk 26) added to `settings.gradle.kts` and `:app` (`implementation(project(":mame"))`): upstream Java (50 files), resources renamed `mm_`, help pages under `assets/mame/`,
library manifest (6 activities, no launcher icon, no zip filter), ndk-build of the small JNI library, `mame/tools/fetch-upstream.sh` + Gradle task `fetchMameCore` (downloads and hash-checks the 367 MB core and the 64 MB `files.zip` into git-ignored `mame/core/`, packed into the APK).
Two unguarded API 28 / 29 calls were guarded for minSdk 26. Not built here (no SDK / NDK / device). Nothing opened MAME after step 3 (step 7 added the hooks). Details: `mame/README.md`.

Step 4 (done): ROM folder (SAF folder picker, kept from upstream) and MAME's own game list are kept as they are; added `MameLaunch` (entry point for step 7). Fixed two step-3 defects: MAME now runs in its own process `:mame` + own task (upstream kills the process on exit, which would have closed Win11),
and its settings use their own file `mame4droid_settings` (`MamePrefs`) instead of the app-wide default one. Details and what was not checked: `mame/README.md`.

Step 5 (done): emulation screen, touch controls and gamepad are upstream's and were kept (checked for use inside Win11: no host-app dependence, 16 KB-aligned libraries). Fixed: the version sent to the core / NetPlay lobby was Win11's `versionName`; it is now `MameLaunch.UPSTREAM_VERSION`
(= `mame/UPSTREAM_VERSION`, enforced by `fetch-upstream.sh`). Details and what needs a device: `mame/README.md`.

Step 6 (done): upstream's settings screen kept (168 keys, own file `mame4droid_settings`). Fixed: the 30 slider rows used the hidden platform class `android.preference.SeekBarPreference` (not in the SDK, unsure below Android 10); replaced by `MameSeekBarPreference`.
XML consistency checked (keys, dependencies, lists). Not seen on a device. No Bengali translation exists (possible later). Details: `mame/README.md`.

Step 7 (done): hooks in `:app`: `MameLauncher.kt` (`openMame()`), Start menu entry **MAME**, Home icon and `rizwans2://mame`, all with a vector joystick icon, only on 64-bit ARM phones (like Winlator). ProGuard keep rule added; the 6 `:mame` activities and permissions merge from the library manifest.
File Manager does not open `.zip` / `.7z` in MAME on purpose (too many non-ROM zips). Fixed: `App.kt` would have attached the BlackBox engine in the `:mame` process; it now starts nothing there (like `:midlet`). "All apps" numbers (`rizwans2://N`) shift by one for the apps sorting after **MAME**.
Not built or run here (no SDK / device). Details and checks: `mame/README.md` step 7.

Step 8 (done): both build workflows (`UltimateBuild.yml`, `UltimateBuild_NoWinlator.yml`) got a step "Fetch MAME core" (`mame/tools/fetch-upstream.sh`, SHA-256 checked, 20-minute limit) and an APK check: the run fails unless `libMAME4droid.so` (exact pinned size), `libmame4droid-jni.so`, `files.zip` (by size) and the help pages are inside the APK.
Also more disk is freed on the runner. No cache for the core (quota), timeout unchanged (120 minutes). The check was tested on fake APKs; no real run here. Details: `mame/README.md` step 8.

Step 9 (done): details updated, static checks run (XML, `mm_` prefixes, resource references, version constant, manifest, hooks, scripts, workflows), final flat zip `RizwanS2-youtube-step7.zip`. All 9 steps are done; the app was not built or run here (no Gradle / SDK / NDK / GitHub / phone).
Summary, what to test on a phone first and what to look at if the build fails: `mame/README.md` step 9.

---

# Seal — `:seal` module (built-in downloader "Downloader")

Upstream https://github.com/JunkFood02/Seal, pinned in `seal/UPSTREAM_VERSION` (v2.0.0-alpha.5) + `seal/UPSTREAM_COMMIT`, GPL-3.0 (`NOTICE-Seal.md`, `LICENSE-Seal`). Same pattern as `:ppsspp`, built part by part, details in `seal/README.md`.

| # | Part | Status |
|---|------|--------|
| 1 | Pin the source, analysis, notice + licence | done |
| 2 | `:seal` / `:seal-color` folders, copy sources, `sl_` resource prefix, clash scan (34 -> 0) | done |
| 3 | Gradle (plugins on Kotlin 2.2.10, dependencies, `:app` dependency) | done |
| 4 | `SealInit` called from `App.kt`; no second crash handler; self-update removed | done |
| 5 | Manifest merge (no own launcher / link filters) | done |
| 6 | Hooks: Start menu, Home icon, `rizwans2://seal`, browser, download folder | done |
| 7 | targetSdk 28, native libs, ABI, APK size | done |
| 8 | CI yml (3 build workflows) | done |
| 9 | README / docs | done |
| 10 | Static checks, final flat zip | done |

Part 10 (done): static checks over the whole project and the final flat zip `RizwanS2-main-seal-final.zip`. Documentation only (plus the new script `seal/tools/static-check.py`): XML (606 files), YAML (6 workflows, every `run:` step `bash -n`), brackets of 2336 `.kt` / `.kts` / `.java` files, resources (398 names), manifest, imports, host-to-Seal symbols, overlays, patch-script idempotency all pass; the 2 bracket reports are old non-Seal Java files that `javac` accepts (checker false positives). No source, manifest, Gradle or workflow file changed. Not built or run (no SDK / Gradle / CI here): the first compile of `:seal` is your next workflow run. Details: `docs/CHANGES-seal-part10.md`.

Part 9 (done): documentation only. `seal/README.md` now starts with an overview (what it is, how the user reaches it, which workflow includes it, size estimate, file map, how to update upstream, open points), `NOTICE-Seal.md` lists parts 7 and 8, `docs/CHANGES-seal-part9.md` has the index of all Seal notes and the checks made. Short version for this README:
- **Use:** Start menu / Home screen "Downloader", `rizwans2://seal[?url=<link>]`, Browser link menu and Media Grabber. Downloads go to the public Downloads folder (`Download/`, audio `Download/Audio`).
- **Build:** `UltimateBuild.yml` and `UltimateBuild_NoWinlator.yml` always include it; `UltimateBuild_WithoutMe.yml` has the tick box `include_seal`; all three accept `apk_abis` (empty = unchanged) and check the APK after the build. Nothing is fetched at build time. Size about +50-100 MB (estimate, not measured).
- **Open points (not run anywhere yet):** the first compile of `:seal` on Kotlin 2.2.10; `libc++_shared.so` `pickFirst`; Android 10 storage permission gap; GPL-3.0 for the combined app (general note, check before publishing).

Part 8 (done): all three build workflows (`UltimateBuild.yml`, `UltimateBuild_NoWinlator.yml`, `UltimateBuild_WithoutMe.yml`) now check Seal inside the built APK: `seal/tools/check-apk-native.sh` (Python + MMKV libraries for arm64-v8a) and the new `seal/tools/check-merged-manifest.py` (Seal's activities / service / receiver / FileProvider are merged, none of its activities has an intent filter or a launcher category). No fetch / cache step is needed (engine from Maven). `UltimateBuild_WithoutMe.yml` has a new tick box **Downloader (Seal)** (default on; off = module folders deleted, `SealLauncher.kt` stub, start-up block, Start menu entry, Home icon removed in the temporary checkout), and all three have the optional input `apk_abis` (e.g. `arm64-v8a,armeabi-v7a`; empty = unchanged build; `arm64-v8a` required). A bug in `WithoutMe` was fixed on the way: unticking PPSSPP would have left `),,` in `StartApps.kt`. Tested here by running the workflow scripts on project copies and on fake APKs; GitHub Actions / Gradle / a real APK were not run. Details: `docs/CHANGES-seal-part8.md`.

Part 7 (done): no source change was needed for targetSdk 28 (one gap: Android 10 only, see `seal/README.md` "Part 7"); native libraries are already extracted (`useLegacyPackaging` + `extractNativeLibs`) and `libc++_shared.so` is already `pickFirst`; new optional `-PapkAbis=arm64-v8a,armeabi-v7a` drops the x86 copies of the engine (default off); new `seal/tools/check-apk-native.sh APK [abi]` reports the engine libraries inside a built APK. Size not measured. Details: `docs/CHANGES-seal-part7.md`.

Part 6 (done): the built-in app is shown as **Downloader** and can be opened from the Start menu, the Home screen, `rizwans2://seal` (`?url=<link>` opens its download sheet for that link) and the Browser (link long-press menu "Download with Downloader"; Media Grabber: a "Downloader" pill on every media / embed / link row and "Page -> Downloader"). Files now go to the public Downloads folder (audio `Download/Audio`, hidden temp `Download/.downloader-tmp`); Seal's language page is hidden; no share-sheet entry and no second icon. A link handed over by the launcher also opens the sheet on a cold start (patched in Seal's `MainActivity`). Details and caveats: `seal/README.md` "Part 6", `docs/CHANGES-seal-part6.md`.

Part 5 (done): `seal/src/main/AndroidManifest.xml` (kept in `seal/tools/overlay-main/`): `MainActivity`, `QuickDownloadActivity`, `CrashReportActivity`, `DownloadService`, `NotificationActionReceiver` and `SealFileProvider` (own FileProvider subclass like the other modules), **all `exported=false`, no `intent-filter` at all** (no launcher icon, no share-sheet entry, no link handling; links come in through explicit intents). New permissions for the launcher: `FOREGROUND_SERVICE_SPECIAL_USE`, `REQUEST_IGNORE_BATTERY_OPTIMIZATIONS`; no `REQUEST_INSTALL_PACKAGES`. Details: `seal/README.md` "Part 5", `docs/CHANGES-seal-part5.md`.

Part 4 (done): `SealInit` (MMKV, Koin, download folders, notification channels, yt-dlp / FFmpeg / aria2c engine in the background) is called from the launcher's `App.onCreate` (launcher process only, wrapped in try/catch); Seal's `App` is now only the holder of its shared fields; no second crash handler, no `DynamicColors`; the Seal self-update (AppUpdater, UpdateDialog, UpdatePage, GitHub release check / APK install) is removed, the yt-dlp updater stays. Details: `seal/README.md` "Part 4", `docs/CHANGES-seal-part4.md`. Nothing is visible yet (manifest = part 5, hooks = part 6).

Part 1 (nothing built, no build file touched): Seal is Kotlin + Compose with the yt-dlp engine from Maven (no C++ and no assets, so no fetch step in CI).
Upstream's README forbids other parties from using the name "Seal" for a downloader app (derivatives included), so the built-in app has a neutral display name, **"Downloader"** (done in part 6).


# Browser Media Grabber + Page Grabber (`:app`, steps 5 - 6c)

The Browser's **Media Grabber** sheet (toolbar button, `BrowserMediaGrabber.kt`) lists what a page loads: network sniffing, a script hook, a page scan, "Scan site", YouTube extractor
(details: `docs/CHANGES-step6-newtab-dialog-mediagrabber.md`). Its **Page Grabber** pill opens a native crawler (`PageGrabberCore.kt` + `PageGrabberUi.kt`, jsoup 1.17.2).
Licence and credits: `NOTICE-PageGrabber.md`, `LICENSE-jsoup`. Details per step: `docs/CHANGES-step6-pagegrabber-6a-6c.md`.

| Step | What | Status |
|---|---|---|
| 5 | Dependency check, jsoup 1.17.2 added to `:app` | done |
| 6a | `PageGrabberCore.kt`: level tree, type / size / duration filters, jsoup link finding, crawler with Level and same-site limit, cancel | done |
| 6b | `PageGrabberUi.kt`: dialog (Level, types, filters, sort, results list, selection) and the "Page Grabber" pill in `BrowserMediaGrabber` | done |
| 6c | Google Drive (files, Docs / Sheets / Slides, public folders) and Mega links, cookie fix, `NOTICE-PageGrabber.md`, `LICENSE-jsoup`, this section | done |

- **Level:** 1 = the links of the start page, 2 = also the pages linked from it, 3 = one more hop ... (UI 1 - 6). "Same site only" follows pages on the start host and its sub-domains; files may be anywhere.
- **Filters:** All / Video / Audio / Image / Document / Compressed / Program / Subtitle / Torrent / Custom extensions, size window, duration window (only where the server tells it), sort, full file name.
- **Per row:** Play (video, audio), Download (browser download engine: Downloads folder, progress, pause / resume), Downloader (yt-dlp), Copy. Select all / None, Download selected, Copy selected, Copy all.
- **Google Drive (6c):** file links give name, type and size and download through the direct address; Docs / Sheets / Slides are exported as .docx / .xlsx / .pptx; a public folder is listed
  (folders inside it need a higher Level); a private file or a quota block shows as a link row. Check box "Include Google Drive and Mega links" (on by default).
- **Mega (6c):** shown as link rows only (Open, Mega app, Copy). Mega files are encrypted in the client, so they cannot be downloaded with a plain request; Downloader (yt-dlp) has no Mega support either.
- **Fix in 6c:** the crawler no longer sends the start page's cookies to other hosts; each request gets the cookie of its own address.
- **Open points (not built or run yet):** the first Gradle build of `PageGrabberCore.kt` / `PageGrabberUi.kt` (no compiler was available while writing them); the Drive folder view and "can't scan" form are Google pages, not an API,
  and can change; `NOTICE-PageGrabber.md` asks you to check the licence position of the reference app whose behaviour the filter rules follow.


# Two launcher themes: Win11 + Linux terminal (`:tui` module)

Goal: the launcher gets two built-in themes, **Win11** (the current shell, unchanged) and **Linux terminal**
(upstream TUI-ConsoleLauncher, embedded as the module `:tui`), with a switch between them.
Upstream: https://github.com/fandreuz/TUI-ConsoleLauncher (the `LICENSE` file in the checked copy is **MIT**, see Step 1 findings).
Rule for every step: all existing details of the Win11 theme stay as they are; an updated full flat zip is delivered after each step. **All 13 steps are done** (see "Step 13 notes" for the final checks and what is still open).

## Plan (13 steps)

Each step ends with an updated full flat zip `RizwanS2-tui-stepN.zip` (all files in the zip root); the next step is only started when asked.
The module is wired in the same way as :ppsspp / :retroarch: own library module, `include(":tui")` in `settings.gradle.kts`, `implementation(project(":tui"))` in `:app`.

| # | Step | Status |
|---|------|--------|
| 1 | Inspect the upstream repo and this project, find every clash, fix the plan (no code changes) | done |
| 2 | Module skeleton: `tui/build.gradle.kts` (library, compileSdk 37, minSdk 26, Java 21, AGP 8.13.2, no flavors, `buildConfigField APPLICATION_ID`), `include(":tui")`, `:app` depends on it, empty manifest; the project must still build | done |
| 3 | Dependencies: appcompat, material, okhttp (same versions as the other modules), localbroadcastmanager, htmlcleaner, json-path, jsoup, CompareString2 (JitPack fallback); packaging excludes if needed | done |
| 4 | Source copy: the upstream Java files (157 files found in the checked copy; the plan said 158), `assets/lucida_console.ttf` and the resources copied into `:tui` unchanged (R / BuildConfig errors are expected here) | done |
| 5 | Resource prefix: every TUI resource file and value renamed with `tui_` (`app_name`, `ic_launcher`, `cursor`, `ic_back`, `ic_paste`, ...), references inside the XML fixed | done |
| 6 | Java reference fix: 70 of the 73 files that use `R.*` rewritten to the `tui_` names (318 references), `BuildConfig` fields checked (`VERSION_NAME` / `VERSION_CODE` added in `tui/build.gradle.kts`), the upstream `theme` command renamed to `tuitheme`; goal: `:tui` compiles on its own | done |
| 7 | Manifest trim + licence: no HOME filter (`LauncherActivity`, `FakeLauncherActivity`), no `text/*` filter (`TuixtActivity`), decisions for the notification listener / device admin / file provider; `NOTICE-TUI.md` + `LICENSE-TUI` (MIT, plus the GPL / Apache file headers), consumer ProGuard rules; merged-manifest check against `:app` | done |
| 8 | Terminal screen as a normal (non-HOME) activity that `:app` can start; permissions + app list work inside it | done |
| 9 | `ThemeManager` (saved choice WIN11 / TERMINAL) + routing in `MainActivity` (the only HOME activity); Home, Back, boot receiver | done |
| 10 | Switch UI: Win11 side (Start menu > user menu > Launcher theme, two glass cards) and terminal side (the `win11` command) | done |
| 11 | Share features: the terminal uses the launcher's hidden apps (one list), pinned apps (`pinned` command) and the built-in apps as commands (`files`, `gallery`, `browser`, `sms`, `builtin`) | done |
| 12 | Polish: first-run theme choice, small / short screens, keyboard, rotation, wallpaper (start window), install / uninstall updates | done |
| 13 | Final check (manifest merge, resources, ProGuard, CI workflows incl. the module list in `UltimateBuild_WithoutMe.yml`), README, full flat zip | done (static checks only; the first real compile is the CI build) |

## Step 2 notes (module skeleton, no TUI code yet)

- `tui/build.gradle.kts`: `com.android.library` only (upstream is Java only, so no Kotlin plugin), namespace `ohi.andre.consolelauncher` (upstream's, so the copied sources keep their `R` / `BuildConfig` imports), compileSdk 37, minSdk 26, Java 21, no flavors, no signing, `isMinifyEnabled = false` (`:app` decides about shrinking), `lint.abortOnError = false` like the other modules, `consumerProguardFiles("consumer-rules.pro")`.
- `buildConfigField("String", "APPLICATION_ID", "\"com.srizwan.win11\"")` + `buildFeatures.buildConfig = true`: upstream's Java reads `BuildConfig.APPLICATION_ID`; the value is the `applicationId` of `:app` on purpose, because the broadcast actions and the file provider authority are built from it. If `:app`'s applicationId ever changes, change it here too.
- `tui/src/main/AndroidManifest.xml`: empty `<manifest/>`; the trimmed content came in step 7. `tui/consumer-rules.pro`: comment only.
- `settings.gradle.kts`: `include(":tui")` (last line, with a comment like the other modules). `app/build.gradle.kts`: `implementation(project(":tui"))` after `:seal`.
- Nothing else changed: no Win11 code, no resources, no workflow. The only expected effect on the build is one more (empty) library module. Not built here (no Android SDK / network in this sandbox): check with a normal CI build.

## Step 3 notes (dependencies, still no TUI code)

- `tui/build.gradle.kts` got a `dependencies` block with the eight libraries of upstream's `app/build.gradle`, all as `implementation`:
  appcompat 1.6.1, material 1.11.0, localbroadcastmanager 1.1.0, okhttp 4.12.0, htmlcleaner 2.29, json-path 2.9.0, jsoup 1.17.2, `it.andreuzzi:CompareString2:1.0.9`.
- Versions: appcompat / material / okhttp are the ones the other modules use (`:app`, `:youtube`, `:winlator`, `:seal`), so Gradle resolves one version for the whole app (`:j2me` asks for appcompat 1.8.0 / material 1.13.0, the highest wins, as before). The root build file's pins (kotlin-stdlib 2.2.10, coroutines 1.9.0) also apply to okhttp's Kotlin dependencies; no change needed there.
- CompareString2: upstream's root `build.gradle` only has `google()` + `mavenCentral()`, and upstream builds, so 1.0.9 is on Maven Central. Not verified from this sandbox (no access to Maven Central / JitPack); JitPack stays in `settings.gradle.kts` as the fallback.
- Packaging excludes: not added. Duplicate-file excludes are applied in the application module, and `:app` already has the `META-INF` excludes of `:seal`; upstream builds with the default packaging. If the CI APK step reports a duplicate `META-INF` file from json-path / slf4j / htmlcleaner, add the exclude to `:app`'s `packaging.resources` (not to `:tui`).
- Upstream's ProGuard file (`app/proguard-rules.pro`: keep `commands.main.raw.**`, `commands.main.specific.**`, `commands.tuixt.raw.**`, `managers.**`, `GenericFileProvider`, the two IO receivers, `libsuperuser`, `it.andreuzzi.comparestring2.**`, `-dontwarn` for okhttp / htmlcleaner / jsoup / json-path / slf4j / jdom2) is needed for the reflection-based command loading. It goes into `tui/consumer-rules.pro` in step 7 (kept as a note here so it is not forgotten); `:app` has `isMinifyEnabled = false` today.
- Nothing else changed. Not built here (no Android SDK / network): check with a normal CI build; the only new thing in the build is the dependency resolution of these eight libraries.

## Step 13 notes (final check, CI, README, full flat zip `RizwanS2-tui-final.zip`)

Nothing of the Win11 theme was changed in this step. No Android SDK, Gradle, `javac` or network access was available while checking, so **nothing here was compiled or run**: the first real build is the CI run, and the points marked "device" below need a phone.

- **Fix after the first CI build (`:tui:packageReleaseResources` failed: "Found item String/tui_help_sms more than one time")**: upstream's `values/strings.xml` has an unused string `help_sms` ("Send an SMS ...", renamed `tui_help_sms` in step 5; upstream has no `sms` command), and the Win11 `sms` command of step 11 added a second string with the same name. The Win11 string is now `tui_help_win11_sms` (`values/strings.xml` and `commands/main/raw/sms.java`, `helpRes()`); upstream's own string is untouched. The step 13 resource check had compared names with other modules and with the Java references but not names inside `:tui` against each other: that was the gap. Re-checked now: no duplicate value name in any `values*` folder of any module of the project, every `R.string.*` used by the Java files exists. This was the only error in the log; the build stopped there, so later tasks (`:tui` Java compile, `:app`, APK checks) have still not run and may show more.
- **Manifest merge (static)**: `tui/src/main/AndroidManifest.xml` and `:app`'s manifest parse; the 9 components of `:tui` have no name clash with `:app` (full names compared: `:app` has `WhatsAppNotificationListener` / `AppDeviceAdmin`, `:tui` has `NotificationService` / `PolicyReceiver`); there is no `<application>` attribute and no `tools:replace` in the library; the only provider is `${applicationId}.FILE_PROVIDER` and no other manifest uses that authority; no HOME / LAUNCHER category and no VIEW / EDIT filter is left in `:tui`'s manifest (the one `text/*` hit is the comment that lists what was removed). Exported: only `PolicyReceiver` and `NotificationService` (the system binds them), everything else `exported="false"`.
- **Permissions that `:tui` adds to the whole app**: the library declares 28 permissions; 8 of them were not declared by `:app` before and are now in the merged manifest: `FLASHLIGHT`, `WRITE_INTERNAL_STORAGE`, `WRITE_CONTACTS`, `CHANGE_NETWORK_STATE`, `ACCESS_FINE_LOCATION`, `ACCESS_COARSE_LOCATION`, `FOREGROUND_SERVICE_SPECIAL_USE`, `REQUEST_DELETE_PACKAGES`. They are upstream's own list (kept in step 7 on purpose: commands such as `flash`, `location`, `cntcts`, `tuiweather` and `uninstall` need them). The dangerous ones are requested by the terminal's own permission flow in `LauncherActivity` (step 8), not by Win11's screens; which of them the system dialog lists on the first start was not checked here (device). If a build should not carry one of them, remove its line from `tui/src/main/AndroidManifest.xml` and the matching command stops working.
- **New CI check, `tui/tools/check-merged-manifest.py`** (like `seal/tools/check-merged-manifest.py`): run by `UltimateBuild.yml`, `UltimateBuild_NoWinlator.yml` and `UltimateBuild_WithoutMe.yml` after the APK is built. It stops the run when `LauncherActivity` / `TuixtActivity` / `FakeLauncherActivity` is missing, exported or has an intent filter, when a `:tui` service / receiver / provider is missing or has the wrong `exported`, when the file provider authority is not a resolved `<applicationId>.FILE_PROVIDER`, when any `ohi.andre.consolelauncher.*` activity has the HOME or LAUNCHER category, or when the merged file does not have exactly one HOME activity. The same step also fails when `assets/lucida_console.ttf` is not in the APK. The script was tested here against a manifest built from the two real manifests (passes) and against a copy with a HOME filter added to `LauncherActivity` (fails with three errors). The three workflows also got a header note.
- **`UltimateBuild_WithoutMe.yml` (module list)**: `:tui` is **not** an optional module (no tick box): `:app` depends on it, it is small (Java only, no native code) and it is the Terminal theme itself, so it is in every build; the summary table says "Terminal theme (T-UI): always". What changed is the other direction: the terminal lists the built-in apps as commands (`TerminalShare.kt`), so a module that is ticked off must not stay in that list. New helper `hide_terminal NAME` (next to `hide_entry`) deletes the `BuiltIn("name", ...)` line of `ppsspp`, `mame`, `retroarch`, `j2me` and `seal` when their module is removed, and stops the run if the line is still there; Winlator needs nothing (its entry is guarded by `WinlatorLauncher.isSupported()`, which the stub answers with `false`). Checked by running the same `sed` on a copy of `TerminalShare.kt` (9 entries are left: files, browser, sms, calculator, parallel, youtube, video, gallery, camera). The package rename of that workflow also rewrites `tui/build.gradle.kts` (it is a `*.gradle.kts` file), so `BuildConfig.APPLICATION_ID` follows the new package name; the Java sources of `:tui` do not contain the package name.
- **Resources (static)**: all 212 files of `:tui`; every resource file and every value name has the `tui_` prefix (ids stay as they are); none of the names exists in another module of the project; all 387 `R.*` references in the 165 Java files resolve (the `exclude_app`, `exclude_notification` and `reply_notification` ids come from `tui_notification_menu.xml`); all XML references resolve (the only one outside `:tui` is AppCompat's `Theme.AppCompat.Light`); every XML file is well-formed (`xmllint`).
- **Java / Kotlin (static)**: all 165 Java files of `:tui` parse (javalang, 0 errors); the three Kotlin hooks in `:app` (`ThemeManager.kt`, `TerminalLauncher.kt`, `TerminalShare.kt`) have balanced braces, brackets and parentheses; every Kotlin call into `:tui` was re-read against `TuiHost.java` in step 11 / 12. This is a syntax check, not a compile.
- **ProGuard / R8**: `tui/consumer-rules.pro` keeps what is found by name. The commands are loaded in `CommandGroup.buildCommand()` with `Class.forName` + `getConstructor().newInstance()` after `Tuils.getClassesInPackage()` lists the package; all 54 + 4 + 3 command classes (including the 7 added in steps 10 / 11: `win11`, `pinned`, `builtin`, `files`, `gallery`, `browser`, `sms`, and the renamed `tuitheme`) are `public` with a public no-argument constructor and live in `commands.main.raw|specific` / `commands.tuixt.raw`, which the rules keep. The other reflection in the sources (`getDeclaredField("mCursorDrawableRes")`, `getMobileDataEnabled`, `SELinux`, `mColors`) is on framework classes, not on our own. `:app` has `isMinifyEnabled = false` today, so the rules are **not proven by a shrunk build**; if `:app` ever turns shrinking on, test `help` (all commands listed) and `tuitheme` first.
- **Device points** (cannot be proven here): (1) `Tuils.getClassesInPackage()` reads the classes with `new DexFile(getPackageCodePath())`, i.e. the dex files of the base APK only. That is what the CI builds (one signed APK, `assembleRelease`); an app bundle with split APKs would list no commands, so do not ship this app as a bundle without changing that method. (2) Lucida Console licence (below). (3) The theme switch, Back / Home, the boot start and the first-run choice on a real phone, as listed in the notes of steps 8-12.
- **Packaging**: no `packaging` exclude was added for `:tui`'s libraries (json-path / slf4j / htmlcleaner / jsoup). `:app` already excludes `/META-INF/{AL2.0,LGPL2.1}` and AGP excludes the usual licence files by default; if the CI APK step reports a duplicate `META-INF` file, add it to `:app`'s `packaging.resources.excludes`, not to `:tui`.
- **Still open (not a build problem)**: `assets/lucida_console.ttf` has no licence statement upstream and Lucida Console is a commercial font: replace it with a free monospaced font (the file name is the only thing the code depends on) or confirm the right to ship it before publishing. Said in `NOTICE-TUI.md` as well.
- **Docs**: `settings.gradle.kts`, `tui/build.gradle.kts` and `NOTICE-TUI.md` say "all 13 steps done"; the plan table above is complete. Final delivery: `RizwanS2-tui-final.zip`, the whole project as a flat zip (all entries in the zip root: `settings.gradle.kts`, `:app`, `:tui`, the other modules, `.github/workflows`, README, notices, licences).

## Step 12 notes (polish: first-run choice, small screens, keyboard, rotation, wallpaper, install / uninstall)

- **First-run theme choice** (`ThemeManager.kt`, `ThemeSwitchUi.kt`, `MainActivity.kt`): new key `chosen` in the `launcher_theme` preferences (`ThemeManager.hasChosen()` / `markChosen()`; `set()` also marks it). `MainActivity.maybeAskTheme()` (called at the end of `restoreState()`, i.e. when the UI is ready) opens the same two cards as the Start menu, `ThemeSwitchUi.show(ctx, firstRun = true)`: title "Choose your launcher", button "Keep Win11". Conditions: never chosen, a plain launcher start (`isLauncherEntry`: icon / Home, **not** a `rizwans2://` link, share or notification tap), once per process. Closing it in any way (button, Back, outside tap, a card) counts as seen, so it is not asked again; tapping Terminal goes through `switchTo()` as always. **After an update** from step 11 the key does not exist either, so everybody sees the choice once. It can overlap with the one-time "default launcher" request that `onCreate` already makes on the very first start (the dialog is posted after the UI is built; the system role dialog may come on top of it): to be seen on a device.
- **Small / short screens** (`ThemeSwitchUi.kt`): the dialog content is in a `ScrollView` (a landscape phone is about 360 dp high: the cards scroll instead of running off the dialog) and the two cards are stacked, one under the other, when the content is narrower than 300 dp (`88 %` of the width, at most 420 dp, minus 44 dp of padding). Before: always side by side (about 130 dp each at 320 dp). `MainActivity` itself stays portrait-locked (unchanged).
- **Keyboard** (`TuiHost.hideKeyboard(Activity)`): the terminal's window is `stateAlwaysVisible` (kept), so the soft keyboard used to stay open over the next screen for a moment when the terminal handed over to another one. `win11` (`switchToWin11`) and the built-in app commands (`files`, `gallery`, `builtin ...`, `pinned -open` for a built-in app: `TuiHost.openBuiltIn`) now close it first (`hideSoftInputFromWindow`, failures ignored). Not changed: the `auto_show_keyboard` option, the keyboard handling inside the terminal.
- **Rotation** (`UIManager.onConfigurationChanged()`, called from `LauncherActivity.onConfigurationChanged()`): the screen handles rotation itself (`configChanges`, no restart; the Win11 `MainActivity` is portrait-locked and is not involved). The output list is not rebuilt, so after a rotation it is scrolled to the end again (200 ms, after the new layout) instead of staying at a random line. The orientation option of the terminal (`Behavior.orientation`) is untouched.
- **Wallpaper / start window** (`tui/res/values/styles.xml`, manifest): `LauncherActivity` now has the manifest theme `tui_Custom.Start` = `tui_Custom.Solid` + `android:windowBackground` black. Before, the first window the system draws while the screen starts was Theme.AppCompat.Light's white, a white flash before the terminal's colours. `onCreate` still switches with `setTheme()` to `tui_Custom.SystemWP` (the system wallpaper, `system_wallpaper` = true by default, `windowShowWallpaper`) or `tui_Custom.Solid` as upstream; `TuixtActivity` keeps `tui_Custom.Solid`. The terminal's wallpaper is the real system wallpaper; Win11's own background is its bloom view, so the two themes are not pixel-identical by design.
- **Install / uninstall** (`AppsManager.appInstalled()` / `appUninstalled()` in `:tui`): (1) an app that is in the launcher's hidden list and gets (re)installed or updated while the terminal is open now goes into the hidden list, not into the shown list (closes the open point of step 11); (2) an uninstalled app is also removed from the hidden list (`apps -lsh` kept it before). The package receiver itself is upstream's (registered while the terminal runs; at the next start `fill()` reads everything again, so nothing is lost while it is closed). Win11's `AppRepository` reloads its list on its own and skips pinned apps that are not installed any more; its pinned / hidden keys of an uninstalled app are left in the preferences on purpose (a reinstall comes back hidden / pinned).
- **Looked at, not changed**: `LauncherActivity.onPause()` (it disposes the managers as upstream does); the notification / device-admin / file-provider parts of the manifest (step 7); the permission flow (step 8); `exit` / Back (step 9). Nothing here needs a Gradle, manifest-component or ProGuard change.
- **Test list for the first device build** (nothing could be run here): (1) fresh install, tap the launcher icon: Win11 with the "Choose your launcher" dialog; "Keep Win11" and relaunch: no dialog; (2) clear data, choose Terminal in the dialog: the terminal opens, Win11 is gone; (3) a `rizwans2://files` link on a fresh install shows no dialog; (4) the dialog on a 320 dp wide phone / in a split-screen window: the cards are stacked, everything can be scrolled; (5) the terminal: open the keyboard, type `gallery` or `win11`: the keyboard closes before the next screen; (6) rotate the terminal with a long output: it ends at the last line (the terminal is free to rotate unless `orientation` is set in `behavior.xml`); (7) cold start of the terminal from the icon: no white flash; (8) hide an app in Start, install an update of it while the terminal is open: `apps -lsh` shows it, `apps -ls` does not; (9) uninstall a hidden app: `apps -lsh` no longer lists it.
- Checks done here (no Android SDK / Kotlin compiler / Gradle / network): the changed Java files pass a `javac` syntax check (the only errors left are missing Android / project classes), `styles.xml` and the manifest are well-formed, the Kotlin was re-read (`ScrollView` import, `Boolean` default argument, the `themeAsked` property in `MainActivity`, `window.decorView.post`), the Java file count is still 165. Not compiled: CI is the first real build.

## Step 11 notes (shared lists and built-in apps: `pinned`, `builtin`, `files`, `gallery`, `browser`, `sms`)

- **One interface between the two modules** (`TuiHost.java`, step 11 part): `interface Share` with `hiddenKeys()`, `pinnedKeys()`, `setHidden(key, hidden)`, `setPinned(key, pinned)`, `builtIns()` (each entry `{command name, label, key}`) and `openBuiltIn(activity, name)`, plus `setShare()` / `getShare()` and three safe helpers (`hiddenKeys()`, `setHidden()`, `openBuiltIn()`; they do nothing when no host is registered, so `:tui` without `:app` still behaves like upstream). Keys are the launcher's own text `"package/activity"` (= `AppEntry.key`).
- **`:app` side, new `app/.../TerminalShare.kt`** (`object TerminalShare : TuiHost.Share`, registered in `App.onCreate()` after the theme switcher, launcher process only). **There is one list, not a copy**: it reads / writes the Start menu's own preferences file `start_menu`, keys `hidden` and `pinned` (one `package/activity` per line), the same file and format as `AppRepository` and `AppControl`. Hiding also unpins (like `AppRepository.hide()`). `AppRepository.load()` re-reads both lists (`reloadPrefs()`), so a change made from the terminal shows in the Start menu the next time it loads its apps (opening Start does that).
- **Hidden apps** (`AppsManager.fill()` in `:tui`, the only upstream file with a logic change): after upstream's own `apps.xml` pass, every app whose key is in the launcher's hidden list is moved from the shown list to the hidden list (`apps -lsh` shows it, typing its name does not launch it, exactly like an app hidden with `apps -hide`). `apps -hide` / `apps -show` (`hideActivity` / `showActivity`) now also tell the launcher (`TuiHost.setHidden`), so the two stay equal both ways. Read at every `fill()`: at the start of the terminal and on `refresh`. New helpers in `AppsManager`: `keyOf(LaunchInfo)` and `findLaunchInfoWithKey(key)`. Not done: apps that are hidden only in the terminal's `apps.xml` from before are not copied to the launcher (they stay hidden in the terminal; `apps -show` shows them in both); an app installed while it is in the launcher's hidden list is shown by the terminal until the next `refresh`.
- **`pinned` command** (new, `ParamCommand` like upstream's `apps`; `pinned.java`): `-ls` the pinned apps of the Start menu in their order with numbers, `-open [n]` opens the n-th one (a normal app through `AppsManager.getIntent`, so it counts as launched, a built-in app through the host), `-add [appName]` pins an app (name as in `apps -ls`), `-rm [appName]` unpins one (also built-in ones, by their label). Hidden apps are not in the list (like in Start); an app that is not installed any more is skipped. Texts: `tui_help_pinned`, `tui_pinned_empty`, `tui_pinned_nonumber`.
- **Built-in apps as commands**: `files`, `gallery`, `browser`, `sms` (one small class each) and the generic **`builtin`** (no argument: the list of all names; `builtin [name]` opens one). All names: files, browser, sms (Messages), calculator, parallel, youtube, video, gallery, camera, j2me, ppsspp, seal (the Downloader), winlator (only on 64-bit ARM, like the Start menu), mame, retroarch. Notifications is left out (a settings screen, no deep link). The keys in `TerminalShare` must stay equal to the `BUILTIN_CLS_*` constants of `StartApps.kt` (commented in both places).
- **How a built-in app opens**: Gallery, Video, YouTube, Camera, Calculator, Parallel are their own activities and start directly from the terminal screen (the terminal stays below, Back returns). Files, Browser, Messages, Winlator, J2ME, PPSSPP, MAME, RetroArch and the Downloader are screens / launchers of `MainActivity`, so they use its deep link (`rizwans2://<name>`, an explicit start, never forwarded back to the terminal). TERMINAL theme: `MainActivity` is created on top of the terminal; Back returns to the terminal, a Home press shows the terminal again (step 9). Win11 theme: `MainActivity` is already in the task (singleTask), so Android brings it to the front and closes the terminal above it (open it again with the Terminal card or `rizwans2://terminal`); its output history is lost then.
- **Name clash (open point)**: commands are matched before app names, so the command `files` / `gallery` / `browser` / `sms` hides an installed app with exactly that label (Google "Files", the system "Gallery", ...). Launch such an app with `apps -frc [appName]` (upstream's "force launch") or give it an alias. The command comment of each class says so; renaming (for example `wfiles`) is a one-line change of the file name if you prefer.
- **Commands and ProGuard**: commands are found by scanning `commands.main.raw` and the name is the class name, the existing keep rule `commands.main.raw.**` covers them. Strings: `tui_help_pinned`, `tui_pinned_*`, `tui_help_builtin`, `tui_builtin_unknown`, `tui_builtin_unavailable`, `tui_help_files|gallery|browser|sms`. No manifest, resource-file or Gradle change.
- **Not shared on purpose** (a decision for step 12 if wanted): the launcher's "recent apps", the terminal's suggestions / launch counts / groups / default apps (they stay the terminal's own), the Start menu's order of "All apps".
- **Test list for the first device build** (nothing could be run here): (1) hide an app in the Win11 Start menu (the app's context menu > Hide), open the terminal: `apps -lsh` lists it, typing its name does not launch it; (2) `apps -show [name]` in the terminal, then the Start menu shows it again; (3) `apps -hide [name]` in the terminal: it is hidden in Start after Start reloads; (4) pin two apps in Start: `pinned -ls` lists them in order, `pinned -open 1` opens the first, `pinned -rm [name]` removes it from Start; `pinned -add [name]` pins; (5) pin the built-in Gallery in Start: `pinned -ls` shows "Gallery", `pinned -open N` opens it; (6) `builtin` lists the names, `builtin camera`, `gallery`, `files` (TERMINAL theme: Win11 Files on top, Back returns to the terminal), `sms`, `browser`; (7) in the Win11 theme `files` from the terminal: Win11 Files opens and the terminal closes; (8) `builtin nothing` prints "No built-in app called nothing" and the list; (9) `help pinned`, `help builtin`; (10) `refresh` after hiding in Start: the terminal's lists update.
- Checks done here (no Android SDK / Kotlin compiler / Gradle / network): the new and changed Java files pass a `javac` syntax check (the only errors left are missing Android / project classes), `strings.xml` is well-formed, every `R.string.tui_*` used by the new commands exists, the Java file count is 165 (159 after step 10 + the 6 new commands of this step), the Kotlin was re-read (SAM / interface overrides `List<Array<String>>`, `Set<String>`, `buildList`, `lateinit` context, all called members exist: `WinlatorLauncher.isSupported/SECTION`, `SEAL_NAME`, `CameraActivity.start/MODE_PHOTO`, `AppLog.i/e`). Not compiled: CI is the first real build.

## Step 10 notes (switch UI: two theme cards + the `win11` command)

- **Win11 side, new `app/.../ThemeSwitchUi.kt`** (`ThemeSwitchUi.show(context)`): a glass `W11Dialog` "Launcher theme" with two cards side by side, **Win11** ("Start menu, taskbar and apps") and **Terminal** ("T-UI, commands and a text screen"). Each card has a small preview drawn in code (Win11: blue wallpaper, Start-style panel, taskbar with four icons; Terminal: black screen, green monospace prompt lines), a title, a one-line description and a label: the saved theme has the accent border (`#60CDFF`, 2 dp) and "✓ Current", the other says "Tap to switch". A line under the cards explains that the chosen theme answers the Home button, the launcher icon and the start after a restart, and that `win11` brings you back. Button: "Close". No new resource files (everything is built in Kotlin, like `W11Dialog` / `GlassMenu`).
- **Tapping a card**: the dialog closes; the already-current card does nothing more; the other one calls `ThemeManager.switchTo()` (step 9: saves, opens the target, closes the other screen). After a switch to TERMINAL a toast says "Terminal theme is on. Type  win11  to switch back."
- **Where it opens from**: Start menu > the user menu (the one with "Settings") got a second item **"Launcher theme"** (`Win11Shell.showUserMenu`: closes the Start menu, then `ThemeSwitchUi.show(ctx)`; `ctx` is `MainActivity`, so a switch to TERMINAL also finishes it as before). The deep link **`rizwans2://theme/choose`** opens the same dialog (`MainActivity.handleDeepLink`). The step 9 links `rizwans2://theme`, `theme/terminal`, `theme/win11` and `rizwans2://terminal` are unchanged.
- **Terminal side, name decided: `win11`** (new `tui/.../commands/main/raw/win11.java`, Win11's own file like `TuiHost.java`, so **159 Java files** in `:tui` now). Why this name: the plan wanted the switch command to name the target; `theme` is free since step 6 but upstream users know it as the colour command (now `tuitheme`), `launcher` / `home` would say nothing about the direction. No arguments; `help win11` text: `tui_help_win11`. Commands are found by scanning the package and the command name is the class name, and the ProGuard rule already keeps `commands.main.raw.**`, so nothing else registers it. Strings (`values/strings.xml`): `tui_help_win11`, `tui_win11_switching` ("Switching to Win11..."), `tui_win11_unavailable` ("The launcher theme cannot be switched from here.").
- **How `:tui` switches without knowing `:app`** (`TuiHost.java`, step 10 part): new `interface Switcher { void toWin11(Activity from); }`, `setSwitcher(...)` and `switchToWin11(Activity)` (runs the switcher on the UI thread; returns false when none is registered, the command then prints `tui_win11_unavailable`). `:app` registers it once in `App.onCreate()` (launcher process only, right after `syncHost()`): `ThemeManager.registerHostSwitcher()` = `switchTo(from, WIN11)`. `switchTo(WIN11)` from the terminal: saves WIN11, `TuiHost.setHomeMode(false)`, starts `MainActivity` (singleTask: an existing one comes to the front, otherwise it is created; the start is an explicit one, so it is not forwarded back) and closes the terminal.
- **One behaviour change in `ThemeManager.switchTo(TERMINAL)`**: step 9 returned early when the terminal screen was already open (for example opened with `rizwans2://terminal` over Win11). Then `MainActivity` stayed alive under the terminal in the TERMINAL theme, which step 9 says must never happen. Now it always starts the terminal (singleTask: it only comes to the front, `onNewIntent` without a command) and finishes `MainActivity`.
- **Unchanged on purpose**: `exit` (still closes the screen in the Win11 theme, prints a message in the TERMINAL theme: `exit` is "go back", `win11` is "change theme"), Back, Home, boot receiver, manifest of `:tui` and `:app` (no component added: a command and a dialog), ProGuard, `tuitheme`.
- **Test list for the first device build** (nothing could be run here): (1) Start menu > user menu > Launcher theme: two cards, Win11 marked "Current"; (2) tap Terminal: the terminal opens, Win11 is gone, toast shows; Home -> terminal; (3) in the terminal type `help win11`, then `win11`: Win11 opens, the terminal is closed, Back from Win11 does not show a terminal; (4) reopen the cards: Win11 "Current"; tapping the Current card only closes the dialog; (5) `rizwans2://theme/choose` (adb) opens the dialog; (6) Win11 theme, `rizwans2://terminal`, then `win11` in the terminal: Win11 comes to the front, theme stays WIN11; (7) TERMINAL theme saved, kill the app, tap the icon: terminal (step 9), `win11` there works after a fresh process start (`registerHostSwitcher()` runs in `App.onCreate`); (8) two cards fit on a 320 dp wide phone (each card gets about 130 dp).
- **Known limits / open points**: texts of the dialog are English like the rest of the Start menu; the terminal preview text is fixed; the dialog has no keyboard focus handling beyond `isFocusable` on the cards; a switch from a non-`MainActivity` context other than the terminal (none exists today) would only save and open the target. Step 11 (shared app list, pinned / hidden apps, built-in apps as commands) and step 12 (first-run theme choice, polish) are untouched.
- Checks done here (no Android SDK / Kotlin compiler / Gradle / network): the two changed / new Java files pass a `javac` syntax check (the only errors left are the missing Android / project classes, no javac, no Android SDK jar here for a full compile), the Kotlin files were re-read (imports, `lateinit` dialog captured by the local function, every function used exists: `ThemeManager.get/switchTo`, `W11Dialog.Builder.setTitle/setView/setNegativeButton/create`, `AppLog.e`), `strings.xml` is well-formed and every `R.string.tui_*` used by `win11.java` exists, the Java file count is 159. Not compiled: CI is the first real build.

## Step 9 notes (saved theme + routing: Home, Back, boot)

- **New `app/.../ThemeManager.kt`**: `enum LauncherTheme { WIN11, TERMINAL }` + `object ThemeManager`. The theme is saved in the private preferences file `launcher_theme`, key `theme` (default WIN11; an unknown value also reads as WIN11). It is a different thing from upstream T-UI's own colour-theme manager (`ohi.andre.consolelauncher.managers.ThemeManager`, the `tuitheme` command), which stays in `:tui` untouched. Functions: `get`, `isTerminal`, `set` (saves + tells the terminal), `syncHost`, `homeIntent`, `terminalIntent`, `isLauncherEntry`, `forwardIfTerminal`, `switchTo`.
- **New `tui/.../TuiHost.java`** (Win11's own file, 158th Java file, not upstream): `homeMode` (true = the terminal is the home screen = the TERMINAL theme is saved), `closeTerminal()` / `isTerminalOpen()` (a weak reference to the open `LauncherActivity`). `:tui` stores nothing and knows nothing about `:app`'s preferences; `:app` sets the flag (`ThemeManager.set()` and `App.onCreate()` -> `syncHost()`, launcher process only, so it is right again after a process restart).
- **Forward from `MainActivity`** (the only HOME + LAUNCHER activity): when TERMINAL is saved and the start is a *launcher entry* (`ACTION_MAIN` + category HOME or LAUNCHER, no data: Home button, launcher icon, recents restore), `onCreate` opens the terminal screen and finishes before any Win11 state is built (`forwardedToTerminal`: `onDestroy` then does nothing); `onNewIntent` does the same when Win11 was opened some other way and Home is pressed. **Not forwarded** (they ask for Win11 itself): `rizwans2://...` deep links, notification taps, `DlEngine` / `PopupPlaybackService` / `SmsDefault` / `BrowserPopup` starts of `MainActivity` (explicit, no MAIN action), file `VIEW` / `SEND` intents.
- **Why `MainActivity` closes when it forwards**: in the TERMINAL theme Win11 is never kept under the terminal, because both are `singleTask` in the same task and a Home press would clear the terminal above Win11 and rebuild it (output history lost). With Win11 closed, the terminal is the root of the task and Home just brings it back (or, if the system starts `MainActivity` again, it forwards to the existing terminal, which only gets `onNewIntent`).
- **Back**: `LauncherActivity.onBackPressed()`: `TuiHost.isHomeMode()` false (Win11 theme, terminal opened from Win11) -> `finish()`, Win11 comes back; true (terminal is home) -> upstream's behaviour (ignored unless `back_button_enabled`, then `ui.onBackPressed()`; the long-press Back is unchanged). `MainActivity`'s Back is unchanged.
- **`exit` command**: Win11 theme -> closes the screen (step 8); TERMINAL theme -> prints "The terminal is your home screen, there is nothing to go back to." (new string `tui_exit_home`), because finishing the home screen would only make Android start HOME again.
- **Boot**: `BootReceiver` starts `ThemeManager.homeIntent()` (still `NEW_TASK | CLEAR_TOP`, still guarded): `MainActivity` for Win11, `LauncherActivity` directly for TERMINAL. When Win11 is the default Home app Android opens `MainActivity` at boot itself, and that start is forwarded by the rule above.
- **Switching (by deep link; the UI and the terminal command came in step 10, see "Step 10 notes")**: `rizwans2://theme/terminal`, `rizwans2://theme/win11`, `rizwans2://theme` (a toast with the saved theme). `switchTo(TERMINAL)` saves, opens the terminal and finishes `MainActivity`; `switchTo(WIN11)` saves, starts `MainActivity` when called from elsewhere and closes the open terminal.
- **Test list for the first device build** (nothing could be run here): (1) fresh install: Home / launcher icon open Win11 as before; (2) `adb shell am start -a android.intent.action.VIEW -d rizwans2://terminal` opens the terminal over Win11, Back returns to Win11; (3) `...-d rizwans2://theme/terminal`: the terminal opens, Win11 is gone; Home -> terminal again (its output is still there); Back does nothing; `exit` prints the message; (4) kill the app, tap the launcher icon: the terminal opens (no Win11 flash); (5) reboot with TERMINAL saved: the terminal opens (Android 10+ may refuse a background start: then Home opens it through the forward); (6) from the terminal send `...-d rizwans2://theme/win11` (adb): Win11 opens and the terminal is closed; Back from Win11 does not show a terminal; (7) a download-complete notification tap in the TERMINAL theme opens Win11's downloads (not forwarded).
- **Known limits / open points**: no UI to switch yet (added in step 10); a rizwans2:// deep link in the TERMINAL theme shows Win11 on top and closes it again at the next Home press (by design); the first start of the terminal from boot asks for its permissions in the background (upstream behaviour); `onKeyLongPress(Back)` of the terminal is untouched.
- Checks done here (no Android SDK / Kotlin compiler / network): the changed Java files parse (javalang), the Kotlin was re-read, every identifier it uses exists (`LauncherActivity`, `TuiHost`, `AppLog.i/e`, `MainActivity.isUIInitialized`), manifest still well-formed. Not compiled: CI is the first real build.

## Step 8 notes (terminal screen = a normal activity of `:app`)

- **What the screen is now**: `ohi.andre.consolelauncher.LauncherActivity` (unchanged class name) is an ordinary activity: no intent filter, `exported="false"`, theme `@style/tui_Custom.Solid` set on the component. `:app` opens it with an explicit intent: new file `app/.../TerminalLauncher.kt` (`MainActivity.openTerminal()`) and the deep link **`rizwans2://terminal`** (also `adb shell am start -a android.intent.action.VIEW -d rizwans2://terminal`). No Start-menu entry or Home icon yet (step 10 / 11); the routing from `MainActivity` is step 9.
- **Task / launch mode** (manifest, `LauncherActivity`): removed `clearTaskOnLaunch`, `excludeFromRecents`, `stateNotNeeded`, `resumeWhilePausing` and `taskAffinity=""` (all were launcher-only; the empty affinity put the screen in a task of its own). It now lives in `:app`'s task, so Back / `exit` return to the Win11 screen below. Kept: `singleTask` (one instance; a notification click or shortcut brings it to the front and the command arrives in `onNewIntent()`), `configChanges`, `windowSoftInputMode`.
- **No HOME intent any more** (the only place that started one was upstream's `stopActivity` and the `KeeperService` notification):
  - `LauncherActivity.stopActivity` (used by `reload()`, e.g. `tui -reset`): closes the instance and starts a **fresh `LauncherActivity`** with the reload message (before: finish + HOME). New `closeScreen` (dispose + finish) is used when the storage permission is refused.
  - `KeeperService.buildNotification`: the notification click (option "show home") opens `LauncherActivity` directly; the command still goes in the `PrivateIOReceiver.TEXT` extra.
  - `exit` command: finishes the screen (on the UI thread) instead of enabling the dummy HOME app and opening the system launcher chooser; help text `tui_help_exit` = "Close the terminal and go back". `Tuils.resetPreferredLauncherAndOpenChooser()` and `FakeLauncherActivity` are now **unused** (kept: untouched code, the class stays declared, disabled, private).
- **Permissions inside the screen** (`LauncherActivity`): runtime permissions first (`READ/WRITE_EXTERNAL_STORAGE` below Android 13, `POST_NOTIFICATIONS` on 13+). Refusing storage = toast + the screen closes after 2 s (as upstream, but it returns to Win11 and not to HOME). **Refusing the notification permission no longer stops the terminal** (upstream's fork-added request treated it like storage; it only matters for the keeper notification). The all-files-access page (Android 11+) moved from `onCreate` (it opened together with the runtime dialog) to the end of `finishOnCreate`, is shown **once per process** and only when not granted (`requestAllFilesAccess()`). The commands' own requests (`call`, `cntcts`, `flash`, location, contacts suggestions) are unchanged: they use `(Activity) pack.context`, which is this activity, and the request codes `COMMAND_REQUEST_PERMISSION` etc. still land in its `onRequestPermissionsResult`.
- **App list inside Win11** (read, not changed): `AppsManager` lists `ACTION_MAIN` + `CATEGORY_LAUNCHER` activities with `PackageManager.queryIntentActivities`, which works with `QUERY_ALL_PACKAGES` (in the merged manifest, also declared by `:app`). It does not hide its own package, so the Win11 app is in the list (a way back). When Win11 is the default launcher, `Tuils.isMyLauncherDefault()` (which compares with `BuildConfig.APPLICATION_ID` = `com.srizwan.win11`) is true and the app shortcuts are loaded too. Install / uninstall updates come from `AppsManager`'s own package receiver.
- **Answers to the "still to check" list of Step 1**: (1) config folder = `Tuils.init()` -> `context.getExternalFilesDir(null)` = `Android/data/com.srizwan.win11/files` (falls back to `getFilesDir()`): app-specific, **needs no storage permission**, shared with nothing else of Win11; (2) no `Application` subclass or `getApplication()` in the sources, only `Tuils.init(context)` with the first activity context, so `:app`'s `App` class is not touched; (3) `CustomExceptionHandler` chains to the previous default handler, so `:app`'s `AppLog` crash handler still runs; (4) targetSdk 28 of `:app`: the `RECEIVER_EXPORTED` registration for Android 13+ and the foreground-service types are only read on the OS versions that have them, so nothing to change; to be proven on a device.
- Not changed on purpose (step 9): Back button (`onBackPressed` keeps upstream behaviour: ignored unless `back_button_enabled`; use `exit` or Home meanwhile), Home, boot receiver, `ThemeManager` and the saved theme. `rizwans2://terminal` is the only way in for now.
- Checks done here (no Android SDK / network): the 3 edited Java files parse (javalang), manifest well-formed, every `@...` reference still resolves, no `CATEGORY_HOME` left in the sources except `Tuils.resetPreferredLauncherAndOpenChooser` / `isMyLauncherDefault` (unused / read-only). Not compiled: the first real compile is the CI build.

## Step 7 notes (manifest trim, licence, ProGuard)

- `tui/src/main/AndroidManifest.xml` is now the upstream manifest, trimmed (the top comment of the file lists every change). Everything uses the `tui_` names; all 8 `@...` references were checked against `tui/src/main/res` (all exist), the 10 component classes exist, the file is well-formed XML.
- **Removed**: `<supports-screens>` (only the defaults, would apply to the whole app); every `<application>` attribute (`allowBackup="false"`, `usesCleartextTraffic="false"` would be merger errors against `:app`'s `true`; icon / label / theme are now on the components); the MAIN + HOME + LAUNCHER + LAUNCHER_APP filter of `LauncherActivity`; the HOME filter of `FakeLauncherActivity`; both VIEW / EDIT filters of `TuixtActivity` (`text/*` and the 12 file-scheme patterns).
- **Kept** (nothing dropped from the features): all 29 `<uses-permission>` and 12 `<uses-feature>` (all `required="false"`), the signature permission `ohi.andre.consolelauncher.permission.RECEIVE_CMD` (`LauncherActivity` registers its public command receiver with it), the file provider, `PolicyReceiver` (device admin), `KeeperService`, `MusicService`, `NotificationService` (notification listener), `NotificationMonitorService`, `FakeLauncherActivity` (declared, still disabled).
- **Exported**: only what the system must bind stays `exported="true"`: `PolicyReceiver` (BIND_DEVICE_ADMIN) and `NotificationService` (BIND_NOTIFICATION_LISTENER_SERVICE). `LauncherActivity`, `TuixtActivity` and `FakeLauncherActivity` are `exported="false"` (`:app` and the `tuixt` command use explicit intents); provider and the other services were already private.
- **Per-component theme**: `LauncherActivity`, `TuixtActivity` = `@style/tui_Custom.Solid` (upstream had it on `<application>`), icon `@mipmap/tui_ic_launcher`, labels `tui_app_name` / `tui_tuixt_label`. The other TUI window styles are set from Java as before. Other activities of the app (Win11) are not touched.
- `TuixtActivity` `PARENT_ACTIVITY` is now the full name `ohi.andre.consolelauncher.LauncherActivity`: the value is a plain string and androidx resolves a leading dot against the *application* package (`com.srizwan.win11`), which would point to a class that does not exist.
- **Merge check against `:app` (static; Gradle's manifest merger was not run, no SDK here)**: the file provider authority `${applicationId}.FILE_PROVIDER` = `com.srizwan.win11.FILE_PROVIDER` is used by no other manifest of the project (the others are `.documentProvider`, `.blackbox.*`, `.proxy_content_provider_N`); no component name clashes (`:app` has `WhatsAppNotificationListener` and `AppDeviceAdmin`, TUI has `NotificationService` and `PolicyReceiver`, different classes and different services, so the two listeners and the two device admins are independent); no `<application>` attribute in the library, so no `tools:replace` is needed; permissions and features repeated by `:app` merge without conflict. Real proof = the CI merged manifest (step 13).
- Android 8+: a second notification listener and a second device admin appear in the system settings list as "T-UI notification reader" / "Lock the screen on double tap"; they only matter when the terminal's own features are used (asked from the terminal screen, step 8).
- **Still to do for the HOME-related code** (not changed in step 7 on purpose): `Tuils.resetPreferredLauncherAndOpenChooser()` (used by the `exit` command) enables `FakeLauncherActivity` and starts a HOME intent; with the HOME filter gone it no longer makes Android forget the default launcher. `exit` is reworked together with the Home / Back routing (steps 8 / 9). `LauncherActivity` still has its upstream HOME-style attributes (`clearTaskOnLaunch`, `excludeFromRecents`, `taskAffinity=""`, `singleTask`); step 8 decides which stay for a normal activity.
- `LICENSE-TUI` (MIT text of upstream) and `NOTICE-TUI.md` added at the project root, like `NOTICE-PPSSPP.md`. **Correction to the Step 1 finding** "MIT, no new licence obligation": the repository `LICENSE` is MIT, but 9 source files have a **GPL-2.0-or-later** header (8 in `managers/flashlight/`, `tuils/MimeTypes.java`) and 14 have an **Apache-2.0** header (`TerminalManager`, `SimpleMutableEntry`, `donate`, `unbescape` in `tuils/html_escape/`, `libsuperuser`, ...). The headers are kept; the project already ships GPL modules, so the combined-app note in `NOTICE-TUI.md` applies, and it is not legal advice. Open point: the font `assets/lucida_console.ttf` has no licence statement upstream (Lucida Console is a commercial font): check before publishing, or swap it for a free monospaced font later.
- `tui/consumer-rules.pro` = upstream's `app/proguard-rules.pro` (keep `commands.main.raw|specific.**`, `commands.tuixt.raw.**`, `managers.**`, `GenericFileProvider`, both IO receivers, `libsuperuser`, `HideSuggestionViewValues`, CompareString2; `-dontwarn` for okhttp, okio, htmlcleaner, json-path, slf4j, jdom2). `:app` has `isMinifyEnabled = false` today, so the rules are only proven in step 13.
- Not changed: the Java sources, resources, `build.gradle.kts` settings, `:app`, the workflows. Nothing of the Win11 theme was touched. Not built here (no Android SDK / network): the CI build is the first real merge + compile.

## Step 6 notes (Java references, `:tui` should now compile on its own)

- **`R.*` references**: every `R.<type>.<name>` in `tui/src/main/java` was rewritten with a script that looks the name up in the resources of `:tui` itself (so a name that does not exist can not be produced). Result: 318 references in 70 files changed, 0 unresolved, 359 `R.*` references in total all resolve now.
  - `R.string.X` -> `R.string.tui_X`: 303 uses (148 distinct names); `R.string.tui_reset` (1 use) already had the prefix and is untouched.
  - `R.layout.base_view|input_down_layout|input_up_layout|tuixt_view_input_down|tuixt_view_input_up` -> `tui_...` (5 uses), `R.menu.notification_menu` -> `tui_notification_menu` (1), `R.mipmap.ic_launcher` -> `tui_ic_launcher` (6), `R.style.Custom_Solid|Custom_SystemWP` -> `tui_Custom_Solid|tui_Custom_SystemWP` (3).
  - `R.id.*` (40 uses) unchanged on purpose (ids are not prefixed; all 29 names exist in `:tui`'s layouts, `suggestion_id` is the `<item type="id">` in `values/integers.xml`). `android.R.id.content` (`Assist.java`) is the platform's and was not touched (the script ignores `android.R`).
  - `ohi.andre.consolelauncher.R` imports stay (the namespace is still upstream's); `UIManager` and `LauncherActivity` are in that package and need no import, as before.
- **Checked against step 5**: the 157 Java files are the same files (same list, same line counts); the only differing lines are `R.*` tokens and the one class line below (312 lines in 70 files, 0 other differences).
- **`BuildConfig`** (a library `BuildConfig` is generated with `DEBUG`, `BUILD_TYPE`, `LIBRARY_PACKAGE_NAME` plus our own fields): the sources use `APPLICATION_ID` (59 uses, exists since step 2 = `com.srizwan.win11`, so the broadcast actions, the notification channel id, the file provider authority and `Tuils`' "is my launcher the default" check all point at `:app`), `DEBUG`, `BUILD_TYPE` (both generated) and `VERSION_NAME` (2 uses: `ChangelogManager`, `tui -about`) / `VERSION_CODE` (1 use: `tui -about`). The last two do **not** exist in a library `BuildConfig`, so they were added to `tui/build.gradle.kts` as `buildConfigField`s with upstream's own values (`"v6.15.1-updated-v2"`, `301`): they describe the embedded TUI code, not the Win11 app. No Java line needed a change for this. KeeperService's channel id (`com.srizwan.win11`) does not clash with `:app`'s channels (`popup_playback`, `sms_incoming`).
- **`theme` command renamed to `tuitheme`** (as the plan says; upstream's colour-theme command with `-apply -set -preset -standard -old`): commands are found by scanning the classes of `commands.main.raw` and the command name is the class name, so the file `commands/main/raw/theme.java` became `tuitheme.java` (class `tuitheme`, nothing else inside changed) and nothing else needs registering. Naming follows upstream's own `tui`, `tuiweather`, `tuixt`. The three user-visible texts that name it (`hint_theme`, `hint_theme2` and the tutorial item in `values/strings.xml`) now say `tuitheme`; the resource names (`tui_help_theme`, `tui_theme_*`), the `ThemeManager` class, the `theme.xml` config file and the `Theme` option enum are unchanged (they are not the command name). Now the word `theme` is free in the terminal; the name of the Win11 / terminal switch command is still decided in step 10.
- Left as it is on purpose: `hint_theme2` and one tutorial item still mention `-create` / `-view`, which upstream's own text already referred to although the command has no such parameters (only the command name was changed there).
- Not changed (steps 7+): the library manifest is still empty (step 7 uses the `tui_` names listed in the step 5 notes), `LauncherActivity` / `FakeLauncherActivity` / `Tuils` HOME-related code, ProGuard rules, `NOTICE-TUI.md`.
- **Not compiled here** (no Android SDK, no network in this sandbox). What was checked instead: every `R.*` name resolves against `:tui`'s resources, every `BuildConfig.*` field exists, the sources parse with `javac` (only "cannot find symbol / package does not exist" errors for the missing `android.jar` and libraries, no syntax errors). The first real compile is the CI build; a remaining error would most likely come from compileSdk 37 / Java 21 against code written for 34 / Java 8, and would be fixed in step 6 follow-up before step 7.

## Step 5 notes (resource prefix `tui_`, Java and manifest not touched yet)

- Rule used: every resource of `tui/src/main/res` got the prefix `tui_`, except names that already start with `tui_` (`tui_running`, `tui_reset`, `tui_busy`: no `tui_tui_`). Ids are not renamed (`@+id/...`, `<item type="id" name="suggestion_id"/>`), and the `name="hint_*"` attributes of the items inside `<string-array>` are not resources, so they stay.
- Files renamed (43 files, same content): `drawable*/ic_back|ic_clear|ic_enter|ic_next|ic_paste.png`, `drawable/cursor.xml`, `layout/about_device_view|base_view|input_down_layout|input_up_layout|tuixt_view_input_down|tuixt_view_input_up.xml`, `menu/notification_menu.xml`, `mipmap*/ic_launcher.png`, `xml/policy.xml|provider_paths.xml` -> all `tui_<old name>`.
- Values renamed (inside `values/`, `values-h320dp`, `values-h720dp`, `values-h1024dp`): 175 `string` (incl. `app_name` -> `tui_app_name`), 2 `string-array` (`hints`, `tutorial`), 4 `color`, 2 `dimen` (`cursor_width`, `tools_height`), 5 `integer`, 5 `style`: `Custom.Solid` -> `tui_Custom.Solid`, `Custom.SystemWP` -> `tui_Custom.SystemWP`, `Theme.AppCompat.Light.NoActionBar.FullScreen` -> `tui_Theme.AppCompat.Light.NoActionBar.FullScreen`, `ToolsBar` -> `tui_ToolsBar`, `OverlayDialog` -> `tui_OverlayDialog`. The 5 clashing names of step 1 (`app_name`, `ic_launcher`, `cursor`, `ic_back`, `ic_paste`) are gone.
- All `@drawable|layout|menu|mipmap|xml|string|color|dimen|integer|style/...` references inside the res XML files were rewritten (51 references checked: every one resolves; the only one outside `:tui` is `@style/Theme.AppCompat.Light`, AppCompat's own). All XML files still parse.
- What the next steps must use (found by scanning the Java sources and upstream's manifest, not changed yet):
  - Step 6, Java (73 files use `R.*`): `R.string.X` (304 uses) -> `R.string.tui_X` (the only one that already has the prefix: `R.string.tui_reset`), `R.layout.base_view|input_down_layout|input_up_layout|tuixt_view_input_down|tuixt_view_input_up` -> `tui_...`, `R.menu.notification_menu` -> `tui_notification_menu`, `R.mipmap.ic_launcher` (6 uses) -> `tui_ic_launcher`, `R.style.Custom_Solid` / `Custom_SystemWP` (3 uses) -> `tui_Custom_Solid` / `tui_Custom_SystemWP`. `R.id.*` (41 uses) stay. No Java use of `R.drawable`, `R.color`, `R.dimen`, `R.integer`, `R.array`, `R.xml`, no `getIdentifier`.
  - Step 7, manifest: `@mipmap/ic_launcher` -> `@mipmap/tui_ic_launcher`, `@string/app_name` -> `tui_app_name`, `@style/Custom.Solid` (2 uses) -> `@style/tui_Custom.Solid`, `@xml/provider_paths` -> `tui_provider_paths`, `@xml/policy` -> `tui_policy`, `@string/admin_permission|tuixt_label|notification_reader` -> `tui_...`.
- Expected right now: `:tui` does not compile yet (the Java still uses the old `R.*` names; that is step 6, now done). Not built here (no Android SDK / network): check with a normal CI build only after step 6.

## Step 4 notes (source copy, nothing changed in the files)

- Copied from `TUI-ConsoleLauncher-master/app/src/main/` into `tui/src/main/`, byte for byte (`diff -r` against upstream: identical):
  - `java/` -> `tui/src/main/java/` : 157 files, package `ohi.andre.consolelauncher` (the plan said 158; the checked copy has 157 `.java` files and no Kotlin).
  - `assets/` -> `tui/src/main/assets/` : `lucida_console.ttf` (the font).
  - `res/` -> `tui/src/main/res/` : 43 files, still with the upstream names (the `tui_` prefix is step 5). They are copied now so the sources have something to resolve against.
- Not copied: upstream's `AndroidManifest.xml` (the library manifest stays empty until step 7), `app/build.gradle`, `proguard-rules.pro`, `app/src/main` is the only upstream source set (no flavor folders).
- Imports checked: every non-SDK import of the sources (androidx core / appcompat / localbroadcastmanager / annotation, okhttp3, jsoup, htmlcleaner, json-path, CompareString2) is covered by the step 3 dependencies.
- Known and expected: resource names clash with other modules (`app_name`, `ic_launcher`, `cursor`, `ic_back`, `ic_paste`); `:app` wins and `:tui` is last in its dependency list, so nothing of the other modules changes, but the TUI would show wrong values until step 5. `BuildConfig.APPLICATION_ID` already exists (step 2). No Java file is edited, so a compile error in `:tui` is possible here and is fixed in steps 5 and 6.
- Nothing else changed: no Win11 code, no workflow. Not built here (no Android SDK / network): check with a normal CI build.

## Step 1 findings (upstream `TUI-ConsoleLauncher-master`)

- **License**: `LICENSE` = MIT (Francesco Andreuzzi, 2026). Keep the copyright + permission notice in `NOTICE-TUI.md`.
  This project already ships GPL modules (PPSSPP, MAME4droid, RetroArch, Seal), so TUI adds no new licence obligation.
- **Size**: 158 Java files (about 38,000 lines), no Kotlin, 20 XML files (6 layouts, 1 menu, 2 xml, 5 value files + 3 size variants, 5 bitmap drawables in 4 densities, launcher mipmaps), font `assets/lucida_console.ttf`.
- **Build**: application module (`ohi.andre.consolelauncher`), compileSdk 34, minSdk 21, targetSdk 34, Java 8, AGP 8.2.0, flavors fdroid / playstore.
  Here: library, compileSdk 37, minSdk 26, Java 21, AGP 8.13.2 (same as the other modules); no flavors.
- **Dependencies**: appcompat 1.6.1, material 1.11.0, okhttp 4.12.0 (same as `:youtube`), localbroadcastmanager 1.1.0, htmlcleaner 2.29, json-path 2.9.0, jsoup 1.17.2, `it.andreuzzi:CompareString2:1.0.9`.
  Not checked here (no network): that CompareString2 resolves from Maven Central; JitPack is already in `settings.gradle.kts` as a fallback. json-path / slf4j may need `packaging` excludes.
- **Manifest parts that must change**:
  - `LauncherActivity` has MAIN + HOME + LAUNCHER filters -> remove them (`:app` stays the only HOME activity).
  - `FakeLauncherActivity` (HOME filter, used by `Tuils.java` to reset the default-launcher choice) -> remove or rework.
  - `TuixtActivity` has VIEW / EDIT filters for `text/*` and many file endings -> remove, so it does not appear in the system "Open with" list.
  - `NotificationService` (second notification listener next to the launcher's own `NotificationListener`), `PolicyReceiver` (second device admin next to `AppDeviceAdmin`), `KeeperService`, `MusicService`, file provider -> decide per item in step 7 / 8.
  - File provider authority comes from `BuildConfig.APPLICATION_ID + ".FILE_PROVIDER"`; `BuildConfig.APPLICATION_ID` is also used in broadcast action names (`MainManager`, `ThemeManager`, `HTMLExtractManager`). A library `BuildConfig` has no such field -> add it with `buildConfigField`.
- **Resource clashes** with the rest of this project (by name): `app_name` (`:winlator`), `ic_launcher` (`:app`, `:winlator`), `cursor` (`:winlator`), `ic_back`, `ic_paste` (`:youtube`). Fix: prefix every TUI resource with `tui_` (about 73 Java files use `R.*`; ids stay unprefixed). No `case R.id.xxx` in TUI, so the library "non-final ids" rule is not a problem.
- **Name clash in commands**: upstream already has a `theme` command (its own colour themes, `ThemeManager`). The launcher-theme switch command therefore needs another name (decided in step 10).
- **Theme routing design**: only `MainActivity` keeps the HOME filter and forwards to the terminal screen when the saved theme is TERMINAL. Enabling / disabling HOME components at run time is not used, because it can reset the user's default-launcher choice.
- **Still to check in step 7 / 8** (not read in step 1): where TUI keeps its config (`Tuils.getFolder()`), its `Application` / static-context use, and how it behaves with `targetSdk = 28` of `:app`.

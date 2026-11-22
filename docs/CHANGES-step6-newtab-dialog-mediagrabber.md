# Step 6 — New-tab Allow/Block dialog + Media Grabber "catch everything"

Files changed: `BrowserPopup.kt`, `BrowserUi.kt`, `BrowserMediaGrabber.kt` (everything else is unchanged).

## 1. New tab: Allow / Block dialog (`BrowserPopup.kt` → `openWindowAsTab`)

Before: a tap on a `target="_blank"` link / `window.open()` opened the new tab at once.
Now, after a user tap:

* a dialog **"Open a new tab?"** — `<site> wants to open a new tab.` with **Allow** / **Block** and a check box
  **"Remember for this site (until the app is closed)"**;
* Allow → the tab opens exactly as before (opener, `postMessage`, `window.close()` and "Sign in with Google" keep working);
* Block → `window.open()` returns `null` on the page and a short "Pop-up blocked" toast is shown;
* "Remember" is kept in memory only (reset when the app is closed), so a wrong "Block" is never permanent;
* while the dialog is open further requests are refused (no dialog spam).

Unchanged rules: no user tap → blocked ("Pop-up blocked" toast); more than 3 requests in 3 s → blocked; 30 tabs → blocked.
When the request comes from a floating pop-up over other apps, the app is brought to the front first so the dialog is visible.

## 2. Media Grabber (`BrowserMediaGrabber.kt`)

Everything of step 5 is kept (YouTube MP4 360p / audio only / live, Play in the built-in players, Download through DlEngine,
blue dot on the toolbar button). New:

### Catching (all sources feed one de-duplicated list)
| Source | What it catches |
|---|---|
| network (`shouldInterceptRequest`) | many more file types (mp4 m4v webm mov mkv 3gp flv avi wmv mpg mpeg ogv mp3 m4a aac ogg oga opus wav flac wma weba amr mka m4b), HLS `.m3u8`, DASH `.mpd`, Smooth `.ism/manifest`, also when the address is inside a query string; segments (`.ts`, `.m4s`, `seg123`, `chunk1`) and YouTube range requests are ignored |
| script hook (`GRAB_HOOK_JS`) | runs at document start in every frame (`WebViewCompat.addDocumentStartJavaScript`, plus `onPageStarted` / `onPageFinished` as a fallback). Hooks `fetch()` and `XMLHttpRequest` and reports responses whose **Content-Type** is video / audio / mpegurl / dash — so media **without a file extension** is caught. Hooks `<video>` / `<audio>` (`src` setter, `play()`, `load()`, load events, `new Audio(url)`), `MediaSource` and `URL.createObjectURL` (shown as "Blob media") |
| page scan (`SCAN_JS`) | `<video> <audio> <source> <embed> <object> <link> <a href>`, og:video / og:audio / twitter:player:stream / JSON-LD `contentUrl` / `embedUrl`, iframes (embedded players; a YouTube embed can be played in the built-in YouTube player), open shadow roots, same-origin iframes, the browser's resource timing list, and a text scan of the page source (absolute **and relative** addresses) |
| site scan (`CRAWL_JS`, "Scan site") | reads up to 60 pages of the same site (links of the page + `sitemap.xml`, 3 at a time, 12 s each) and collects their media, embeds and links without opening them |

### The dialog
* **This page / Whole site** (the whole-site list keeps everything found on that site until the app is closed)
* type filter: **All, Video, Audio, Streams, Embeds, Links** (with counts) + a text **Filter…** box
* **Links** = every link of the page / site, each with **Open** (new tab) and **Copy**
* each media row: **Play**, **Download**, **Copy** (embeds: Play for YouTube, Open, Copy)
* file **size and type** of direct files (small HEAD request in the background); the size is passed to the download
* **HLS quality variants** (720p, 480p … and audio renditions) listed under the master playlist
* **Rescan**, **Scan site / Stop scan**, **Copy all** (all addresses of the current list, one per line)
* file names now come from the address (`movie.mp4`) instead of always the page title

### Limits (honest list)
* DRM streams cannot be read. `blob:` media exists only inside the page (the row says so; its real stream is normally in Streams).
* Streams (`.m3u8` / `.mpd`) can be played or copied, not saved as one file. No MP3 encoder (audio keeps its format).
* "Scan site" can read only pages of the same origin (browser rule); a strict Content-Security-Policy on the site can block it.
* The `W11Grab` JS bridge only fills bounded lists (400 per page, 1500 per site, 3000 / 6000 links); a page script cannot do anything else with it.

## Files / places
* `BrowserUi.kt`: `installGrabHooks(webView)` next to the other JS bridges; `shouldInterceptRequest` clears the page list on a main-frame request and sniffs sub-resources; `GRAB_HOOK_JS` evaluated in `onPageStarted` / `onPageFinished`.
* No new permission, no new dependency (`androidx.webkit:webkit:1.11.0` was already there).
* Not compiled in this environment (no Gradle / Android SDK here): please build once and tell me any error.

# Step 6 (a, b, c) - Page Grabber: native crawler, dialog, Google Drive / Mega

Files: `app/src/main/kotlin/com/srizwan/win11/PageGrabberCore.kt` (6a, 6c), `PageGrabberUi.kt` (6b, 6c), `BrowserMediaGrabber.kt` (one pill, 6b),
`app/build.gradle.kts` (jsoup 1.17.2, step 5). New in 6c: `NOTICE-PageGrabber.md`, `LICENSE-jsoup`, this file, the README section "Browser Media Grabber + Page Grabber".
Not compiled in the authoring environment (no Gradle / Android SDK / network there): please build once and send me any error.

## What the Page Grabber is
The Media Grabber sheet listens to what the page loads inside the WebView. The Page Grabber is different: it reads a page with its own HTTP requests
(HEAD, or a GET that is closed before the body), without playing anything, and can go several levels deep.
Opened by the "Page Grabber" pill in the action row of the Media Grabber sheet (next to Rescan / Scan site).

## 6a - core (`PageGrabberCore.kt`)
* Link finding (`pgExtractLinks`): addresses written in the text, media / subtitle names inside scripts and JSON (also relative), and with jsoup
  `<video> <audio> <source> <track> <img> <embed>` `src` and every `<a href>`.
* Types: Compressed, Document, Audio, Video, Image, Program, Subtitle, Torrent, Other (codes 1 2 3 4 5 6 8 9 as in the reference app), by extension first, then Content-Type.
* Filters: types (All / ticked types / Custom extensions), size window, duration window (a size or duration the server does not tell never hides a file; 0 = no limit).
* Level: 1 = the links of the start page, 2 = also the pages linked from it, 3 = one more hop ... (UI: 1 - 6). "Same site only" follows pages only on the start host and its sub-domains.
* Caps and safety: 2000 requests per run, 6 threads, 12 s timeouts, 1.5 MB read per page, `.js .css .woff ...` never requested, one failing address never stops the run, cancel is immediate.

## 6b - dialog (`PageGrabberUi.kt`)
Address field, Level - / +, Same site only, type check boxes, size and duration windows (KB / MB / GB, sec / min / hour), sort (found order, name, size, type),
"Full file name", Grab / Stop, live counters, a filter box, per row: select box, Play (video / audio), Download, Downloader, Copy; Select all / None,
Download selected (asks above 10 files), Copy selected, Copy all. The choices are remembered (`SharedPreferences "page_grabber"`). Closing the dialog stops the crawl.

## 6c - Google Drive and Mega (this step)
New option **"Include Google Drive and Mega links"** (on by default, remembered). Off = both providers are skipped (an address typed as the start address is always handled).

### Google Drive
| Link found | What happens |
|---|---|
| file (`/file/d/ID`, `open?id=`, `uc?id=`, `drive.usercontent.google.com/download?id=`) | one request to `drive.usercontent.google.com/download?id=ID&export=download&confirm=t`; if Google answers with its "can't scan this file" page, the form of that page is followed. Name from `Content-Disposition`, type and size from the headers, so the type / size filters work. Row: Play, Download, Downloader, Open, Copy |
| Docs / Sheets / Slides | exported as `.docx` / `.xlsx` / `.pptx` (`.../export?format=...`); row: Download, Open, Copy |
| public folder (`/drive/folders/ID`, `folderview?id=`) | listed through `embeddedfolderview?id=ID`; every entry is handled like a link found on a page (files are probed, sub-folders opened by Level). Folder entries are numbered one level deeper |
| `open?id=` | tried as a file first, then as a folder |
| private file, quota block, sign-in page | a plain link row (Open, Copy) with the reason |
| other Google pages (forms, login, help ...) | dropped (6a showed them as link rows) |

* The same file in different link forms (`view`, `open?id=`, `uc?id=`) is listed once (`pgCanon`).
* Folder depth: a folder found on the page is always opened; a folder inside it needs Level 2, the next one Level 3 ...; deeper folders appear as a folder row ("raise Level").
* Download goes through the browser's own engine (`enqueueDownload`) with the direct address and the cookies of that address, Referer `https://drive.google.com/`.
* Downloader (yt-dlp) is offered for Drive file links only (not for Docs, folders or Mega).

### Mega
* Links (`mega.nz/file/ID#KEY`, `mega.nz/folder/ID#KEY`, old `#!ID!KEY` / `#F!ID!KEY`; hosts `mega.nz`, `mega.co.nz`, `mega.io`) are shown as **link rows**: "Mega file link" / "Mega folder link",
  with a note when the link has no key. **The #fragment is kept** for Mega links (it holds the key); every other address still loses its fragment.
* No request is sent to Mega: files are encrypted in the client, so a plain HTTP request can neither name nor download them. Row buttons: **Open** (new tab), **Mega app** (explicit intent to
  `mega.privacy.android.app`; if it is not installed a new tab opens), **Copy**. Not offered: Download, Downloader (yt-dlp has no Mega support), Play.
* Other Mega pages (login, pricing ...) are dropped.

### Other changes in 6c
* **Cookie fix (found while reading 6a):** the crawler sent the start page's cookie string to every host it requested (CDNs, third parties). Now `PgConfig.cookieFor` gives the cookie of each
  address from the browser's cookie jar, and the single `cookies` string goes only to the start host and its sub-domains.
* Download selected skips Mega links and folders and says so; downloads use `enqueueOne` (same code as the single Download).
* `PgFile` got `kind`, `directUrl`, `note`; `PgFilter` got `providers`; `PgConfig` got `cookieFor` (all with defaults, nothing else changes for ordinary files).

## Limits (honest list)
* Drive: the folder listing and the "can't scan" form use Google pages that are not an official API; Google can change them. A public folder shows what its embedded view lists
  (it may be only the first part of a very large folder). Large files can hit the daily download quota (shown as a link row). Files that need a sign-in work only when the browser itself is signed in.
* Duration filter: the duration of a remote file is normally unknown, so that filter helps only where known.
* Streams (`.m3u8` / `.mpd`) are not crawled here; use the Media Grabber lists for them.
* The Page Grabber does not run JavaScript: links created by scripts at run time are found only when their address is visible in the page source.

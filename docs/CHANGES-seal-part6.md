# Seal — part 6 of 10: hooks (Start menu, Home screen, deep link, Browser), download folder, name

Request: add Seal as a built-in app (like `:ppsspp`), update the workflow yml, keep all details, update the full flat zip. This turn: part 6 only.

Steps (each ticked when done):
- [x] 1. Read the part 5 tree and every place PPSSPP is hooked in the host (`StartApps`, `Win11Shell`, `MainActivity` x2, `PpssppLauncher`, manifest comment), plus the Browser (`showLinkDialog`) and the Media Grabber dialog
- [x] 2. `SealLauncher.kt` (new): `SEAL_NAME = "Downloader"`, `isSealUrl()`, `openSeal()`, `openSealWithUrl()`
- [x] 3. Start menu entry, Home screen icon, taskbar section `seal`, deep link `rizwans2://seal` (alias `downloader`, optional `?url=`)
- [x] 4. Browser: "Download with Downloader" in the link long-press menu; Media Grabber: "Downloader" pill on every media / embed / link row and "Page -> Downloader" in the action row
- [x] 5. Inside `:seal` (all in `seal/tools/win11_patches.py`, so a re-import reproduces them): cold-start link, download folder, language page hidden, display name
- [x] 6. Static checks (below)
- [x] 7. Docs: `seal/README.md`, root `README.md`, `NOTICE-Seal.md`, this file
- [x] 8. Full flat zip

## What the user gets
| Where | What |
|---|---|
| Start menu (All apps, Recent, Pin) | new built-in app **Downloader** (cloud-with-arrow icon, section `seal`, key `<pkg>/builtin.seal`) |
| Home screen | icon **Downloader**, after PPSSPP |
| Deep link | `rizwans2://seal` (or `rizwans2://downloader`) opens Seal's home; `rizwans2://seal?url=https://...` opens its download sheet for that link (http / https only) |
| Browser, long-press on a link | new entry **Download with Downloader** (http / https links only; blob: / data: links do not get it) |
| Browser, Media Grabber | every video / audio / stream / embed row gets a **Downloader** pill (a YouTube row goes by its watch page, so yt-dlp picks the formats; a stream row `.m3u8` / `.mpd` gets a filled pill because the built-in download cannot save streams); every row of the Links list gets one; the action row gets **Page -> Downloader** (the open page itself: a video page, playlist, channel) |
| Media Grabber layout | the pill rows (4 pills now) and the action row scroll sideways on a narrow phone |

## Files
- new: `app/src/main/kotlin/com/srizwan/win11/SealLauncher.kt`, `docs/CHANGES-seal-part6.md`
- host, changed: `StartApps.kt` (entry + icon path), `Win11Shell.kt` (`VectorIconView.SEAL`, Home icon), `MainActivity.kt` (taskbar section, deep link, KDoc), `BrowserUi.kt` (`showLinkDialog`), `BrowserMediaGrabber.kt` (pills, helper, scroll rows), `app/src/main/AndroidManifest.xml` (comment of the deep-link filter only)
- `:seal`, changed through `seal/tools/win11_patches.py` (new `RES_PATCHES` list + 4 new `PATCHES`): `MainActivity.kt`, `util/FileUtil.kt` (2 places), `ui/page/settings/appearance/AppearancePreferences.kt`, `res/values/strings.xml` (2 strings); overlay `SealInit.kt` (comment only; the `src` copy is identical)
- docs: `seal/README.md`, `README.md`, `NOTICE-Seal.md`

## Decisions taken here (say if you want them different)
1. **Name "Downloader"** (part 1 plan). `sl_app_name` (not translatable, so one place) and the default `sl_service_title` ("Downloader is downloading…", the notification text) changed. Translated copies of the notification text and a few help texts still say "Seal" (about 60 languages, free text, e.g. the custom-command help); the About page keeps the credit to Seal. The rule in Seal's README is about the app name, which is no longer "Seal".
2. **Download folder = the public Downloads folder itself** (the one the Browser saves to), not `Download/Seal`. Video goes to `Download/`, audio to `Download/Audio` (upstream's rule: video folder + `/Audio`). A folder the user picks in Seal's settings still wins (kept in MMKV). The temp folder is the hidden `Download/.downloader-tmp`; Seal's "clear temp files" only touches that folder (checked: `clearTempFiles` is only called with the temp / cache folders, never with the download folder).
   Trade-off, honest: two Seal functions walk the whole download folder after a finished download (`scanFileToMediaLibraryPostDownload` finds the file by "path contains the title", the media scan for custom commands scans everything). With the Downloads root this walks all of Downloads (fast for a few thousand files, but wider than upstream's private subfolder). If you prefer isolation, change the one patch in `win11_patches.py` to `File(Download, "Downloader")` instead of the root.
3. **Link into Seal = explicit `ACTION_SEND` intent to Seal's own `MainActivity`**, not `QuickDownloadActivity`. The quick dialog sets a `TYPE_APPLICATION_OVERLAY` window and I could not verify here that it works from an in-app start; `MainActivity` shows the same download sheet inside the app. Upstream reads the shared link only in `onNewIntent`, so on a cold start the sheet would not have opened: patched (`MainActivity.onCreate` reads the intent too).
4. **Language page hidden.** The entry is removed from Seal's appearance settings (its page calls `AppCompatDelegate.setApplicationLocales`, which would change the language of the whole launcher). `Route.LANGUAGES` / `LanguagePage` stay in the code, unreachable.
5. **No "Share to Downloader" filter** (part 5 offered it): it would add an entry to every share sheet of the phone. Not added; it stays a one-element change if you want it.
6. **No second launcher icon**, no http / https handler: unchanged from part 5.

## Known caveats
- `rizwans2://` is a BROWSABLE deep link (it was before this part), so a web page can now open `rizwans2://seal?url=...` and make the launcher show Seal's download sheet for that link. The sheet needs a tap to download; I did not check on a device whether it already asks yt-dlp for the link's info when it opens (if it does, a page could trigger that one info request). If you do not want this, delete the `?url=` branch in `MainActivity.handleDeepLink` (3 lines); the other hooks do not depend on it.
- The "All apps" list has one more entry, so the numbers of `rizwans2://N` shift for the apps after it.
- yt-dlp needs the engine from `SealInit` to be ready (first start unpacks Python / yt-dlp / FFmpeg, slow). A link sent in the first seconds of the very first start can fail; Seal's own screen shows the error.
- Not verified here: any of this on a device, the Kotlin compile of `:seal` on 2.2.10, the manifest merge, Gradle.

## Static checks (here)
193 Kotlin files (host + `:seal` + `:seal-color` + tools) balanced `{}()[]` (string / raw-string / comment aware); 4 XML files well-formed (host manifest, `:seal` manifest + its source copy, `strings.xml`); every new symbol (`SEAL_NAME`, `isSealUrl`, `openSeal`, `openSealWithUrl`, `VectorIconView.SEAL`) defined once and used; section `"seal"` handled in the taskbar callback and in the deep link; `win11_patches.apply()` run twice: first 6 applied + 12 in place, second 0 applied + 18 in place (idempotent); overlay `SealInit.kt` == `src` copy; `Route.LANGUAGES` no longer referenced from the settings page.
Not run: Gradle, CI, a device. The next workflow run is still the first compile of `:seal`; send me the first error lines if it fails.

Next: part 7 (targetSdk 28 checks, native libs `extractNativeLibs` / `libc++_shared`, arm64 ABI, APK size).

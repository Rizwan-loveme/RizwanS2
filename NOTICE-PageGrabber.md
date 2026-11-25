# Page Grabber notice

The **Page Grabber** (`app/src/main/kotlin/com/srizwan/win11/PageGrabberCore.kt` and `PageGrabberUi.kt`, opened from the Browser's Media Grabber sheet) is Win11's own Kotlin code.
It is not a copy of another project's source. See `docs/CHANGES-step6-pagegrabber-6a-6c.md` and the README section "Browser Media Grabber + Page Grabber".

## Library
- **jsoup 1.17.2** (`org.jsoup:jsoup`), added to `:app` in step 5 (it was already used by `:tui`). **MIT License**, Copyright (c) 2009-2024 Jonathan Hedley (https://jsoup.org).
  The licence text is in `LICENSE-jsoup` and must be kept with every distribution of the app. Downloaded by Gradle, not copied into this project.

## Google Drive and Mega (step 6c)
- Win11 is **not affiliated with, endorsed by or sponsored by Google or Mega Limited**. "Google Drive", "Google Docs", "Google Sheets", "Google Slides" and "Mega" are trademarks of their owners and are used only to name what a link points to.
- Drive: the Page Grabber asks the public download and export addresses of Google Drive / Docs and the embedded folder view of a public folder, the same pages a browser opens. These are not an official API and can change.
  Use it only for files you may download; Google's terms of service apply to your use of their service.
- Mega: nothing is downloaded or decrypted. Links are only listed and handed to the Mega app or the browser. Mega's terms apply there.
- The app sends no data to Win11's author or any third party because of this feature; the requests go from the phone straight to the site that was grabbed.

## Open point (not a build problem)
- The file type codes and the filter rules (type / size / duration windows) were written to behave like a reference download manager the project was compared with (the comments in `PageGrabberCore.kt` say "port of the original").
  The code is written from scratch, but **check before publishing** that the behaviour you copied from that reference is yours to use. Not legal advice.

package com.srizwan.win11

import android.util.Patterns
import org.jsoup.Jsoup
import org.jsoup.parser.Parser
import java.io.ByteArrayOutputStream
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLDecoder
import java.net.URLEncoder
import java.util.Locale
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.RejectedExecutionException
import java.util.concurrent.atomic.AtomicBoolean
import java.util.concurrent.atomic.AtomicInteger

// =====================================================================
// PAGE GRABBER - core (Media Grabber, steps 6a + 6c)
//
// A native page crawler: it reads a web page, collects every link / <video> / <audio> / <source> / <img> / <track>
// address on it (also addresses written inside scripts and JSON), asks the server what each address is (a HEAD
// request, or a GET that is closed before the body when HEAD is refused), keeps the files that pass the filters
// and - when the level allows - follows the HTML pages it found and does the same there.
//
// It complements BrowserMediaGrabber.kt (which listens to what the page loads inside the WebView): this one works
// without the page being played, goes several levels deep, and filters by type / size / duration.
//
// LEVEL: 1 = only the links of the start page, 2 = also the pages linked from it, 3 = one more hop ... (a level never
//        follows more than the request cap, see PgConfig.maxRequests).
// SUB-DOMAIN ONLY: pages are followed only on the start host and its sub-domains; files may live anywhere (CDN).
// FILTERS: file type (Compressed, Document, Audio, Video, Image, Program, Subtitle, Torrent, Custom extensions or All),
//          size (min / max) and duration (min / max). A size or duration the server does not tell is NOT used to hide a
//          file (0 = no limit). Duration of remote files is normally unknown, so that filter only helps where known.
// PROVIDERS (step 6c):
//   Google Drive - a file link (/file/d/ID, open?id=, uc?id=), a Docs / Sheets / Slides link and a folder link are understood.
//                  A file is asked for through its direct address (drive.usercontent.google.com/download?id=ID&export=download&confirm=t;
//                  when Google answers with its "can't scan this file" page the form of that page is followed), so name, type and size
//                  come from the real response headers and the normal type / size filters apply. Docs / Sheets / Slides are exported as
//                  .docx / .xlsx / .pptx. A public folder is listed through its embedded view (embeddedfolderview) and the entries are
//                  handled like links found on a page. Private files, a quota block or a sign-in page give a plain "link" row instead.
//   Mega         - links are kept as link rows (file / folder, with or without the key): Mega encrypts files in the client, so no plain
//                  HTTP request can download or even name them. The row offers Open (new tab), Mega app and Copy.
//   The #fragment of a Mega link (it holds the key) is kept; every other address loses its fragment.
//   Folder depth: a Drive folder found on a page is always opened; a folder inside it needs Level 2, the next one Level 3 ...
//   "Include Drive / Mega links" (PgFilter.providers) switches both providers off (the start address itself is always handled).
//
// COOKIES: PgConfig.cookieFor gives the cookie of each address (the browser's cookie jar); the single PgConfig.cookies string is
//          sent only to the start host and its sub-domains, never to other hosts (6a sent it everywhere).
//
// Threads: the crawler runs its own pool; PgListener is called from worker threads (post to the main thread in UI).
// Nothing here touches the UI. Needs jsoup (app/build.gradle.kts).
// =====================================================================

/** The file type codes are the ones the original Grabber uses (1 compressed, 2 document, 3 audio, 4 video, 5 image, 6 program, 8 torrent, 9 subtitle). */
internal enum class PgType(val code: Int, val label: String) {
    OTHER(0, "Other"),
    COMPRESSED(1, "Compressed"),
    DOCUMENT(2, "Document"),
    AUDIO(3, "Audio"),
    VIDEO(4, "Video"),
    IMAGE(5, "Image"),
    PROGRAM(6, "Program"),
    TORRENT(8, "Torrent"),
    SUBTITLE(9, "Subtitle")
}

internal enum class PgProvider { NONE, DRIVE, MEGA }

/** what a provider row is: a downloadable file (Drive file, exported Doc), a folder, or only a link */
internal enum class PgProviderKind { NONE, FILE, FOLDER, DOC, LINK }

internal enum class PgSort { FOUND, NAME_ASC, NAME_DESC, SIZE_ASC, SIZE_DESC, TYPE }

/** one file the crawler found */
internal class PgFile(
    val url: String,
    val name: String,
    val ext: String,
    val type: PgType,
    /** bytes, -1 = the server did not tell */
    val size: Long,
    val mime: String,
    /** the page the address was found on */
    val foundOn: String,
    /** 1 = start page, 2 = a page linked from it ... */
    val level: Int,
    val provider: PgProvider = PgProvider.NONE,
    /** order of discovery, for PgSort.FOUND */
    val order: Int = 0,
    /** Drive / Mega rows: what the link is (NONE for ordinary files) */
    val kind: PgProviderKind = PgProviderKind.NONE,
    /** the address to download / play: for Drive the direct address, otherwise the same as url */
    val directUrl: String = url,
    /** a short remark for the row ("" = none) */
    val note: String = ""
)

/** true when the row can be saved through the download engine (ordinary files, Drive files, exported Docs); Mega and folders cannot */
internal fun pgCanDownload(f: PgFile): Boolean =
    f.provider == PgProvider.NONE ||
        (f.provider == PgProvider.DRIVE && (f.kind == PgProviderKind.FILE || f.kind == PgProviderKind.DOC))

internal interface PgListener {
    /** a file passed the filters */
    fun onFile(file: PgFile)
    /** requests = sent, responses = answered (or failed), found = files kept */
    fun onProgress(requests: Int, responses: Int, found: Int)
    /** called exactly once; canceled = stopped by cancel() */
    fun onFinished(canceled: Boolean, requests: Int, found: Int)
}

internal class PgFilter(
    /** "All" ticked */
    val all: Boolean = true,
    /** "Custom" ticked: only customExts count */
    val custom: Boolean = false,
    val customExts: Set<String> = emptySet(),
    /** the ticked types (ignored when all or custom) */
    val types: Set<PgType> = emptySet(),
    val torrentEnabled: Boolean = true,
    /** keep Google Drive and Mega links (step 6c) */
    val providers: Boolean = true,
    /** bytes, 0 = no limit */
    val minSize: Long = 0L,
    val maxSize: Long = 0L,
    /** seconds, 0 = no limit */
    val minDurationSec: Double = 0.0,
    val maxDurationSec: Double = 0.0
) {
    /** port of the original isValidContentType: Custom first, then All, then each ticked type */
    fun typeOk(type: PgType, ext: String): Boolean {
        if (custom) return ext.isNotEmpty() && customExts.contains(ext.lowercase(Locale.ROOT))
        if (all) return type != PgType.TORRENT || torrentEnabled
        if (type == PgType.TORRENT) return torrentEnabled && types.contains(PgType.TORRENT)
        return types.contains(type)
    }

    /** port of the original isFilterOk: both the duration and the size window must hold (unknown values pass) */
    fun sizeTimeOk(size: Long, durationSec: Double): Boolean {
        if (durationSec > 0.0) {
            if (minDurationSec > 0.0 && durationSec < minDurationSec) return false
            if (maxDurationSec > 0.0 && durationSec > maxDurationSec) return false
        }
        if (size > 0L) {
            if (minSize > 0L && size < minSize) return false
            if (maxSize > 0L && size > maxSize) return false
        }
        return true
    }
}

internal class PgConfig(
    val startUrl: String,
    /** 1 = only the start page's links; see the header */
    val level: Int = 1,
    val subdomainOnly: Boolean = false,
    val filter: PgFilter = PgFilter(),
    /** one cookie string: sent only to the start host and its sub-domains (see cookieFor for the rest) */
    val cookies: String = "",
    /** cookie of one address (the browser's cookie jar); when set it decides for every request */
    val cookieFor: ((String) -> String)? = null,
    val userAgent: String = "",
    val referer: String = "",
    /** hard cap of requests in one run */
    val maxRequests: Int = 2000,
    val threads: Int = 6,
    val timeoutMs: Int = 12000,
    /** true: also ask about addresses without a known file extension (they may be files, like download.php?id=3) */
    val probeUnknown: Boolean = true
)

// ---------------------------------------------------------------------
// tables and small helpers
// ---------------------------------------------------------------------

private val PG_EXT: Map<String, PgType> = HashMap<String, PgType>().apply {
    fun add(t: PgType, vararg e: String) { for (x in e) put(x, t) }
    add(PgType.VIDEO, "mp4", "m4v", "webm", "mov", "mkv", "3gp", "3g2", "flv", "avi", "wmv", "mpg", "mpeg", "ogv", "ts", "vob", "f4v", "asf", "rm", "rmvb", "divx")
    add(PgType.AUDIO, "mp3", "m4a", "aac", "ogg", "oga", "opus", "wav", "flac", "wma", "weba", "amr", "mka", "m4b", "mid", "midi", "aif", "aiff", "ac3", "ape")
    add(PgType.IMAGE, "jpg", "jpeg", "png", "gif", "webp", "bmp", "svg", "ico", "heic", "heif", "tif", "tiff", "avif")
    add(PgType.SUBTITLE, "srt", "vtt", "ass", "ssa", "sub", "sbv", "ttml", "dfxp", "lrc")
    add(PgType.COMPRESSED, "zip", "rar", "7z", "tar", "gz", "tgz", "bz2", "xz", "z", "lz", "lzma", "cab", "iso", "img", "zst")
    add(PgType.DOCUMENT, "pdf", "doc", "docx", "xls", "xlsx", "ppt", "pptx", "odt", "ods", "odp", "txt", "rtf", "csv", "epub", "mobi", "azw3", "djvu", "xps", "pages", "key", "numbers")
    add(PgType.PROGRAM, "apk", "apks", "xapk", "apkm", "exe", "msi", "dmg", "pkg", "deb", "rpm", "appimage", "jar", "bat", "sh", "bin", "ipa")
    add(PgType.TORRENT, "torrent")
}

/** never a result and never worth a request (the original skips .js / .css / .mjs) */
private val PG_SKIP_EXT = setOf("js", "mjs", "css", "map", "woff", "woff2", "ttf", "otf", "eot")

private val PG_TEXT_MEDIA: Regex = run {
    val exts = PG_EXT.filterValues { it == PgType.VIDEO || it == PgType.AUDIO || it == PgType.SUBTITLE }
        .keys.sortedByDescending { it.length }.joinToString("|")
    Regex("[\"'(=\\s]([^\"'()\\s<>\\\\]{1,600}?\\.(?:$exts)(?:[?#][^\"'()\\s<>\\\\]{0,400})?)(?=[\"')\\s<>\\\\,;]|\$)", RegexOption.IGNORE_CASE)
}

private const val PG_HTML_CAP = 1_500_000

/** most entries read from one Drive folder listing */
private const val PG_FOLDER_CAP = 2000

internal fun pgHostOf(url: String): String =
    try { URL(url).host.orEmpty().lowercase(Locale.ROOT) } catch (e: Exception) { "" }

internal fun pgExtOf(url: String): String {
    val path = url.substringBefore('#').substringBefore('?')
    val seg = path.substringAfterLast('/')
    val dot = seg.lastIndexOf('.')
    if (dot < 0 || dot == seg.length - 1) return ""
    val e = seg.substring(dot + 1).lowercase(Locale.ROOT)
    return if (e.length in 1..8 && e.all { it.isLetterOrDigit() }) e else ""
}

internal fun pgProviderOf(url: String): PgProvider {
    val h = pgHostOf(url)
    return when {
        h == "drive.google.com" || h == "docs.google.com" || h == "drive.usercontent.google.com" -> PgProvider.DRIVE
        h == "mega.nz" || h == "mega.co.nz" || h == "mega.io" -> PgProvider.MEGA
        else -> PgProvider.NONE
    }
}

// ---------------------------------------------------------------------
// Google Drive / Mega addresses (step 6c)
// ---------------------------------------------------------------------

internal enum class PgDriveKind { FILE, FOLDER, DOC, SHEET, SLIDES, UNKNOWN }

/** a Drive address understood: what it is and its id ([PgDriveKind.UNKNOWN] = open?id=..., file or folder) */
internal class PgDrive(val kind: PgDriveKind, val id: String)

private val PG_DRIVE_ID = Regex("^[A-Za-z0-9_-]{10,}$")
private val PG_DRIVE_PATH_ID = Regex("/(file|document|spreadsheets|presentation)/(?:u/\\d+/)?d/([A-Za-z0-9_-]{10,})")
private val PG_DRIVE_FOLDER_ID = Regex("/folders/([A-Za-z0-9_-]{10,})")
private val PG_DRIVE_QUERY_ID = Regex("[?&]id=([A-Za-z0-9_-]{10,})")

/** null = a Google page that is not a file or folder (login, forms, help ...) */
internal fun pgParseDrive(url: String): PgDrive? {
    if (pgProviderOf(url) != PgProvider.DRIVE) return null
    val noFrag = url.substringBefore('#')
    val path = noFrag.substringBefore('?')
    PG_DRIVE_PATH_ID.find(path)?.let { m ->
        val kind = when (m.groupValues[1]) {
            "file" -> PgDriveKind.FILE
            "document" -> PgDriveKind.DOC
            "spreadsheets" -> PgDriveKind.SHEET
            else -> PgDriveKind.SLIDES
        }
        return PgDrive(kind, m.groupValues[2])
    }
    PG_DRIVE_FOLDER_ID.find(path)?.let { return PgDrive(PgDriveKind.FOLDER, it.groupValues[1]) }
    val id = PG_DRIVE_QUERY_ID.find("?" + noFrag.substringAfter('?', ""))?.groupValues?.get(1) ?: return null
    return when {
        path.endsWith("/folderview") || path.endsWith("/embeddedfolderview") -> PgDrive(PgDriveKind.FOLDER, id)
        path.endsWith("/uc") || path.endsWith("/download") -> PgDrive(PgDriveKind.FILE, id)
        path.endsWith("/open") -> PgDrive(PgDriveKind.UNKNOWN, id)
        else -> null
    }
}

/** one address per file / folder, whatever form the link had (so the same file is never listed twice) */
internal fun pgCanonOf(d: PgDrive): String = when (d.kind) {
    PgDriveKind.FILE -> "https://drive.google.com/file/d/${d.id}/view"
    PgDriveKind.FOLDER -> "https://drive.google.com/drive/folders/${d.id}"
    PgDriveKind.DOC -> "https://docs.google.com/document/d/${d.id}/edit"
    PgDriveKind.SHEET -> "https://docs.google.com/spreadsheets/d/${d.id}/edit"
    PgDriveKind.SLIDES -> "https://docs.google.com/presentation/d/${d.id}/edit"
    PgDriveKind.UNKNOWN -> "https://drive.google.com/open?id=${d.id}"
}

internal fun pgCanon(url: String): String {
    val d = pgParseDrive(url) ?: return url
    return pgCanonOf(d)
}

/** the address that returns the file itself (Docs / Sheets / Slides: the export address); "" for a folder */
internal fun pgDriveDirect(d: PgDrive): String = when (d.kind) {
    PgDriveKind.FILE, PgDriveKind.UNKNOWN -> "https://drive.usercontent.google.com/download?id=${d.id}&export=download&confirm=t"
    PgDriveKind.DOC -> "https://docs.google.com/document/d/${d.id}/export?format=docx"
    PgDriveKind.SHEET -> "https://docs.google.com/spreadsheets/d/${d.id}/export?format=xlsx"
    PgDriveKind.SLIDES -> "https://docs.google.com/presentation/d/${d.id}/export/pptx"
    PgDriveKind.FOLDER -> ""
}

internal enum class PgMegaKind { FILE, FOLDER }

/** a Mega address understood; [hasKey] = the link carries the decryption key (after the #) */
internal class PgMega(val kind: PgMegaKind, val id: String, val hasKey: Boolean)

private val PG_MEGA_NEW = Regex("^(file|folder|embed)/([A-Za-z0-9_-]{6,})")
private val PG_MEGA_OLD = Regex("^(F?)!([A-Za-z0-9_-]{6,})(?:!([A-Za-z0-9_-]+))?")

/** new links: mega.nz/file/ID#KEY, mega.nz/folder/ID#KEY; old links: mega.nz/#!ID!KEY, mega.nz/#F!ID!KEY. null = another Mega page (login, pricing ...) */
internal fun pgParseMega(url: String): PgMega? {
    if (pgProviderOf(url) != PgProvider.MEGA) return null
    val frag = url.substringAfter('#', "")
    val path = url.substringBefore('#').substringBefore('?').substringAfter("://").substringAfter('/', "")
    PG_MEGA_NEW.find(path)?.let { m ->
        val kind = if (m.groupValues[1] == "folder") PgMegaKind.FOLDER else PgMegaKind.FILE
        return PgMega(kind, m.groupValues[2], frag.substringBefore('/').length >= 16)
    }
    PG_MEGA_OLD.find(frag)?.let { m ->
        val kind = if (m.groupValues[1] == "F") PgMegaKind.FOLDER else PgMegaKind.FILE
        return PgMega(kind, m.groupValues[2], m.groupValues[3].isNotEmpty())
    }
    return null
}

/** type by extension first (octet-stream says nothing), then by Content-Type */
internal fun pgTypeOf(ext: String, mime: String): PgType {
    PG_EXT[ext.lowercase(Locale.ROOT)]?.let { return it }
    val m = mime.lowercase(Locale.ROOT).substringBefore(';').trim()
    return when {
        m.startsWith("video/") -> PgType.VIDEO
        m.startsWith("audio/") -> PgType.AUDIO
        m.startsWith("image/") -> PgType.IMAGE
        m == "text/vtt" || m == "application/x-subrip" || m == "text/srt" -> PgType.SUBTITLE
        m == "application/pdf" || m == "application/msword" || m == "application/rtf" || m == "text/plain" || m == "text/csv" ||
            m == "application/epub+zip" || m.startsWith("application/vnd.ms-") || m.startsWith("application/vnd.openxmlformats") ||
            m.startsWith("application/vnd.oasis.opendocument") -> PgType.DOCUMENT
        m == "application/zip" || m == "application/x-rar-compressed" || m == "application/x-7z-compressed" || m == "application/gzip" ||
            m == "application/x-tar" || m == "application/x-bzip2" || m == "application/x-xz" -> PgType.COMPRESSED
        m == "application/vnd.android.package-archive" || m == "application/x-msdownload" || m == "application/x-apple-diskimage" ||
            m == "application/java-archive" -> PgType.PROGRAM
        m == "application/x-bittorrent" -> PgType.TORRENT
        else -> PgType.OTHER
    }
}

/** value + unit ("B", "KB", "MB", "GB", "TB") -> bytes; unknown unit = bytes */
internal fun pgUnitBytes(value: Double, unit: String): Long {
    if (value <= 0.0) return 0L
    val f = when (unit.trim().uppercase(Locale.ROOT)) {
        "KB", "KIB" -> 1024.0
        "MB", "MIB" -> 1024.0 * 1024
        "GB", "GIB" -> 1024.0 * 1024 * 1024
        "TB", "TIB" -> 1024.0 * 1024 * 1024 * 1024
        else -> 1.0
    }
    return (value * f).toLong()
}

/** value + unit ("sec", "min", "hour") -> seconds; unknown unit = seconds */
internal fun pgUnitSeconds(value: Double, unit: String): Double {
    if (value <= 0.0) return 0.0
    val u = unit.trim().lowercase(Locale.ROOT)
    return when {
        u.startsWith("h") -> value * 3600.0
        u.startsWith("m") -> value * 60.0
        else -> value
    }
}

internal fun pgSizeText(bytes: Long): String {
    if (bytes < 0) return "Unknown size"
    if (bytes < 1024) return "$bytes B"
    val kb = bytes / 1024.0
    if (kb < 1024) return String.format(Locale.US, "%.1f KB", kb)
    val mb = kb / 1024.0
    if (mb < 1024) return String.format(Locale.US, "%.1f MB", mb)
    return String.format(Locale.US, "%.2f GB", mb / 1024.0)
}

internal fun pgSorted(list: List<PgFile>, sort: PgSort): List<PgFile> = when (sort) {
    PgSort.FOUND -> list.sortedBy { it.order }
    PgSort.NAME_ASC -> list.sortedBy { it.name.lowercase(Locale.ROOT) }
    PgSort.NAME_DESC -> list.sortedByDescending { it.name.lowercase(Locale.ROOT) }
    PgSort.SIZE_ASC -> list.sortedBy { if (it.size < 0) Long.MAX_VALUE else it.size }
    PgSort.SIZE_DESC -> list.sortedByDescending { it.size }
    PgSort.TYPE -> list.sortedWith(compareBy<PgFile> { it.type.code }.thenBy { it.name.lowercase(Locale.ROOT) })
}

/** absolute http(s) address without #fragment, or null (javascript:, mailto:, data:, blob: ... are dropped) */
internal fun pgResolve(base: String, ref: String): String? {
    val r = ref.trim().replace("\\/", "/")
    if (r.isEmpty() || r.length > 2000) return null
    val low = r.lowercase(Locale.ROOT)
    if (low.startsWith("#") || low.startsWith("javascript:") || low.startsWith("mailto:") || low.startsWith("tel:") ||
        low.startsWith("data:") || low.startsWith("blob:") || low.startsWith("about:") || low.startsWith("intent:")
    ) return null
    return try {
        val abs = if (low.startsWith("http://") || low.startsWith("https://")) URL(r)
        else URL(URL(base), r)
        val full = abs.toExternalForm()
        // a Mega link keeps its #fragment (it holds the key); everything else loses it
        val s = if (pgProviderOf(full) == PgProvider.MEGA) full else full.substringBefore('#')
        val p = s.lowercase(Locale.ROOT)
        if (p.startsWith("http://") || p.startsWith("https://")) s else null
    } catch (e: Exception) { null }
}

private fun pgDecode(s: String): String =
    try { URLDecoder.decode(s.replace("+", "%2B"), "UTF-8") } catch (e: Exception) { s }

private fun pgDispositionName(cd: String?): String? {
    if (cd.isNullOrBlank()) return null
    Regex("filename\\*\\s*=\\s*[^']*'[^']*'([^;]+)", RegexOption.IGNORE_CASE).find(cd)?.let {
        val n = pgDecode(it.groupValues[1].trim().trim('"'))
        if (n.isNotEmpty()) return n
    }
    Regex("filename\\s*=\\s*\"?([^\";]+)\"?", RegexOption.IGNORE_CASE).find(cd)?.let {
        val n = it.groupValues[1].trim()
        if (n.isNotEmpty()) return n
    }
    return null
}

private fun pgNameFromUrl(url: String): String {
    val seg = url.substringBefore('#').substringBefore('?').trimEnd('/').substringAfterLast('/')
    val n = pgDecode(seg).trim()
    return if (n.isEmpty()) "file" else n
}

private fun pgCleanName(n: String): String =
    n.replace(Regex("[\\\\/:*?\"<>|\\u0000-\\u001f]"), "_").trim().ifEmpty { "file" }

/**
 * Port of the original processDocument: every address a page offers.
 *  1. addresses written in the text (WEB_URL; "\/" fixed, HTML entities opened, javascript: dropped, "...?a=view" also added without it)
 *  2. media / subtitle file names in scripts and JSON, also relative ones (resolved against the page)
 *  3. jsoup: <video> / <audio> / <source> / <track> / <img> src and every <a href> (absolute first, then resolved by hand)
 */
internal fun pgExtractLinks(base: String, html: String, canceled: () -> Boolean = { false }): List<String> {
    val out = LinkedHashSet<String>()
    fun add(raw: String?) {
        if (raw.isNullOrBlank()) return
        val abs = pgResolve(base, raw) ?: return
        out.add(abs)
        if (abs.lowercase(Locale.ROOT).endsWith("?a=view") && abs.length > 7) out.add(abs.substring(0, abs.length - 7))
    }

    // 1. text addresses
    try {
        val m = Patterns.WEB_URL.matcher(html)
        var guard = 0
        while (m.find() && guard++ < 20000) {
            if (canceled()) return out.toList()
            var s = html.substring(m.start(), m.end()).trim().replace("\\/", "/")
            s = Parser.unescapeEntities(s, true)
            val low = s.lowercase(Locale.ROOT)
            if (low.startsWith("http://") || low.startsWith("https://")) add(s)
        }
    } catch (e: Exception) { /* a bad page must not stop the crawl */ }

    // 2. media names inside scripts / JSON
    try {
        val text = html.replace("\\/", "/")
        var guard = 0
        for (m in PG_TEXT_MEDIA.findAll(text)) {
            if (guard++ > 5000 || canceled()) break
            add(Parser.unescapeEntities(m.groupValues[1], true))
        }
    } catch (e: Exception) { }

    // 3. the document
    try {
        val doc = Jsoup.parse(html, base)
        for (sel in listOf("video[src]", "audio[src]", "source[src]", "track[src]", "img[src]", "embed[src]")) {
            for (el in doc.select(sel)) {
                if (canceled()) return out.toList()
                add(el.absUrl("src").ifEmpty { el.attr("src") })
            }
        }
        for (el in doc.select("a[href]")) {
            if (canceled()) return out.toList()
            add(el.absUrl("href").ifEmpty { el.attr("href") })
        }
    } catch (e: Exception) { }
    return out.toList()
}

// ---------------------------------------------------------------------
// the crawler
// ---------------------------------------------------------------------

internal class PgCrawler(private val cfg: PgConfig, private val listener: PgListener) {

    private val canceled = AtomicBoolean(false)
    private val finished = AtomicBoolean(false)
    private val started = AtomicBoolean(false)
    private val pending = AtomicInteger(0)
    private val requests = AtomicInteger(0)
    private val responses = AtomicInteger(0)
    private val found = AtomicInteger(0)
    private val order = AtomicInteger(0)
    private val seen: MutableSet<String> = ConcurrentHashMap.newKeySet()
    /** names read from a Drive folder listing, used when the file response has no Content-Disposition */
    private val nameHints = ConcurrentHashMap<String, String>()
    private val rootHost = pgHostOf(cfg.startUrl)
    private val maxLevel = cfg.level.coerceIn(1, 10)
    @Volatile private var exec: ExecutorService? = null

    val isRunning: Boolean get() = started.get() && !finished.get()

    fun start() {
        if (!started.compareAndSet(false, true)) return
        val start = pgResolve(cfg.startUrl, cfg.startUrl)?.let { pgCanon(it) }
        if (start == null) { finish(false); return }
        exec = Executors.newFixedThreadPool(cfg.threads.coerceIn(1, 12))
        seen.add(start)
        submit(start, 1)
    }

    fun cancel() {
        if (finished.get()) return
        canceled.set(true)
        exec?.shutdownNow()
        finish(true)
    }

    private fun finish(wasCanceled: Boolean) {
        if (!finished.compareAndSet(false, true)) return
        try { exec?.shutdown() } catch (e: Exception) { }
        try { listener.onProgress(requests.get(), responses.get(), found.get()) } catch (e: Exception) { }
        try { listener.onFinished(wasCanceled, requests.get(), found.get()) } catch (e: Exception) { }
    }

    private fun progress() {
        try { listener.onProgress(requests.get(), responses.get(), found.get()) } catch (e: Exception) { }
    }

    private fun submit(url: String, level: Int) {
        if (canceled.get() || finished.get()) return
        if (requests.get() >= cfg.maxRequests) return
        val pool = exec ?: return
        requests.incrementAndGet()
        pending.incrementAndGet()
        try {
            pool.execute { work(url, level) }
        } catch (e: RejectedExecutionException) {
            pending.decrementAndGet()
        }
        progress()
    }

    private fun work(url: String, level: Int) {
        try {
            if (canceled.get() || Thread.currentThread().isInterrupted) return
            val provider = pgProviderOf(url)
            if (provider == PgProvider.DRIVE) {
                if (handleDrive(url, level)) return
                if (level > 1) return          // another Google page (login, forms, help ...): not a file
            } else if (provider == PgProvider.MEGA) {
                if (handleMega(url, level)) return
                if (level > 1) return          // another Mega page (login, pricing ...): not a file
            }
            fetch(url, level)
        } catch (e: Throwable) {
            // one address failing never stops the rest
        } finally {
            responses.incrementAndGet()
            progress()
            if (pending.decrementAndGet() == 0) finish(canceled.get())
        }
    }

    private fun open(url: String, method: String, range: Boolean): HttpURLConnection {
        val c = URL(url).openConnection() as HttpURLConnection
        c.requestMethod = method
        c.connectTimeout = cfg.timeoutMs
        c.readTimeout = cfg.timeoutMs
        c.instanceFollowRedirects = true
        c.setRequestProperty("Accept", "*/*")
        c.setRequestProperty("Accept-Encoding", "identity")
        if (cfg.userAgent.isNotEmpty()) c.setRequestProperty("User-Agent", cfg.userAgent)
        val cookie = cfg.cookieFor?.invoke(url) ?: (if (sameSite(pgHostOf(url))) cfg.cookies else "")
        if (cookie.isNotEmpty()) c.setRequestProperty("Cookie", cookie)
        val ref = cfg.referer.ifEmpty { cfg.startUrl }
        if (ref.isNotEmpty()) c.setRequestProperty("Referer", ref)
        if (range) c.setRequestProperty("Range", "bytes=0-0")
        return c
    }

    private fun totalSize(c: HttpURLConnection): Long {
        val cr = c.getHeaderField("Content-Range")
        if (!cr.isNullOrEmpty()) {
            val t = cr.substringAfterLast('/').trim()
            t.toLongOrNull()?.let { if (it > 0) return it }
        }
        if (c.responseCode == 206) return -1L
        return c.contentLengthLong
    }

    private fun isHtml(mime: String): Boolean {
        val m = mime.lowercase(Locale.ROOT)
        return m.contains("text/html") || m.contains("application/xhtml")
    }

    private fun isScriptOrStyle(mime: String): Boolean {
        val m = mime.lowercase(Locale.ROOT)
        return m.contains("javascript") || m.contains("text/css") || m.contains("ecmascript")
    }

    private fun fetch(url: String, level: Int) {
        val ext = pgExtOf(url)
        if (ext in PG_SKIP_EXT) return
        val isRoot = level == 1
        val knownFile = PG_EXT.containsKey(ext)
        if (!isRoot && !knownFile && !cfg.probeUnknown) {
            // not asked about unknown addresses: still follow it as a page when the level allows
            if (level >= maxLevel) return
        }
        val followPages = level < maxLevel && (!cfg.subdomainOnly || sameSite(pgHostOf(url)))

        // 1. a file by its extension: only the headers are needed (HEAD, GET + Range 0-0 when HEAD is refused)
        if (!isRoot && knownFile) {
            var conn: HttpURLConnection? = null
            try {
                conn = open(url, "HEAD", false)
                var code = conn.responseCode
                if (code !in 200..299) {
                    conn.disconnect()
                    conn = open(url, "GET", true)
                    code = conn.responseCode
                }
                if (code in 200..299) {
                    val mime = conn.contentType.orEmpty()
                    if (isHtml(mime) || isScriptOrStyle(mime)) return
                    reportFromHeaders(url, conn, mime, url, level)
                }
            } finally { try { conn?.disconnect() } catch (e: Exception) { } }
            return
        }

        // 2. anything else: GET, read the body only when it is an HTML page we are going to follow
        var conn: HttpURLConnection? = null
        try {
            conn = open(url, "GET", false)
            val code = conn.responseCode
            if (code !in 200..299) return
            val mime = conn.contentType.orEmpty()
            val finalUrl = conn.url?.toString() ?: url
            if (isScriptOrStyle(mime)) return
            if (isHtml(mime) || (mime.isEmpty() && isRoot)) {
                if (!isRoot && !followPages) return
                val html = readBody(conn, mime)
                if (canceled.get()) return
                for (raw in pgExtractLinks(finalUrl, html) { canceled.get() }) {
                    if (canceled.get()) return
                    val link = pgCanon(raw)
                    if (!seen.add(link)) continue
                    val le = pgExtOf(link)
                    if (le in PG_SKIP_EXT) continue
                    val known = PG_EXT.containsKey(le)
                    val provider = pgProviderOf(link)
                    if (!known && provider == PgProvider.NONE && !cfg.probeUnknown && level + 1 > maxLevel) continue
                    submit(link, level + 1)
                }
            } else {
                reportFromHeaders(url, conn, mime, finalUrl, level)
            }
        } finally { try { conn?.disconnect() } catch (e: Exception) { } }
    }

    private fun readBody(conn: HttpURLConnection, mime: String, cap: Int = PG_HTML_CAP): String {
        val bos = ByteArrayOutputStream()
        conn.inputStream.use { ins ->
            val buf = ByteArray(16 * 1024)
            while (bos.size() < cap) {
                if (canceled.get()) break
                val n = ins.read(buf)
                if (n < 0) break
                bos.write(buf, 0, n)
            }
        }
        val cs = Regex("charset=([A-Za-z0-9_\\-]+)", RegexOption.IGNORE_CASE).find(mime)?.groupValues?.get(1)
        return try { bos.toString(cs ?: "UTF-8") } catch (e: Exception) { bos.toString("UTF-8") }
    }

    private fun sameSite(host: String): Boolean {
        if (host.isEmpty() || rootHost.isEmpty()) return false
        return host == rootHost || host.endsWith(".$rootHost")
    }

    private fun reportFromHeaders(url: String, conn: HttpURLConnection, mime: String, finalUrl: String, level: Int) {
        val size = totalSize(conn)
        val disp = pgDispositionName(conn.getHeaderField("Content-Disposition"))
        val name = pgCleanName(disp ?: pgNameFromUrl(finalUrl))
        val ext = pgExtOf(name).ifEmpty { pgExtOf(finalUrl) }
        val type = pgTypeOf(ext, mime)
        report(url, name, ext, type, size, mime.substringBefore(';').trim(), cfg.startUrl, level, PgProvider.NONE)
    }

    private fun report(
        url: String, name: String, ext: String, type: PgType, size: Long, mime: String,
        foundOn: String, level: Int, provider: PgProvider
    ) {
        if (canceled.get()) return
        if (provider == PgProvider.NONE) {
            // an HTML or script address that slipped through the headers check is not a file
            if (type == PgType.OTHER && (mime.contains("html", true) || mime.contains("javascript", true) || mime.contains("css", true))) return
            if (!cfg.filter.typeOk(type, ext)) return
            if (!cfg.filter.sizeTimeOk(size, 0.0)) return
        }
        emit(PgFile(url, name, ext, type, size, mime, foundOn, level, provider, order.incrementAndGet()))
    }

    private fun emit(file: PgFile) {
        if (canceled.get()) return
        found.incrementAndGet()
        listener.onFile(file)
    }

    // -----------------------------------------------------------------
    // Google Drive (step 6c)
    // -----------------------------------------------------------------

    /** true = the address is a Drive file / folder / Doc (handled, a row or the folder's entries were produced or it was skipped on purpose) */
    private fun handleDrive(url: String, level: Int): Boolean {
        val d = pgParseDrive(url) ?: return false
        if (!cfg.filter.providers && level > 1) return true
        val done = when (d.kind) {
            PgDriveKind.FOLDER -> driveFolder(d, level)
            PgDriveKind.UNKNOWN -> driveFile(d, level) || driveFolder(d, level)   // open?id= can be a file or a folder
            else -> driveFile(d, level)
        }
        if (!done) {
            // private file, quota block, sign-in page: still show the link so the person can open it
            driveRow(d, level, PgProviderKind.LINK, "Could not read it (private, over quota or sign-in needed)")
        }
        return true
    }

    private fun driveRow(d: PgDrive, level: Int, kind: PgProviderKind, note: String) {
        val canon = pgCanonOf(d)
        val base = when (d.kind) {
            PgDriveKind.FOLDER -> "Drive folder"
            PgDriveKind.DOC -> "Google Doc"
            PgDriveKind.SHEET -> "Google Sheet"
            PgDriveKind.SLIDES -> "Google Slides"
            else -> "Drive file"
        }
        val name = nameHints[canon]?.let { pgCleanName(it) } ?: "$base ${d.id.take(8)}"
        emit(PgFile(canon, name, "", PgType.OTHER, -1L, "", cfg.startUrl, level, PgProvider.DRIVE, order.incrementAndGet(), kind, canon, note))
    }

    /** the real download address inside Google's "can't scan this file for viruses" page, or null */
    private fun driveFormUrl(html: String, base: String): String? {
        try {
            val doc = Jsoup.parse(html, base)
            val form = doc.selectFirst("form#download-form") ?: doc.selectFirst("form[action*=download]") ?: return null
            val action = form.absUrl("action")
            if (action.isEmpty()) return null
            val sb = StringBuilder(action)
            sb.append(if (action.contains('?')) '&' else '?')
            var first = true
            for (inp in form.select("input[name]")) {
                if (!first) sb.append('&')
                first = false
                sb.append(URLEncoder.encode(inp.attr("name"), "UTF-8")).append('=').append(URLEncoder.encode(inp.attr("value"), "UTF-8"))
            }
            return sb.toString()
        } catch (e: Exception) {
            return null
        }
    }

    /** one Drive file or exported Doc: ask for the direct address, read only the headers. false = could not be read. */
    private fun driveFile(d: PgDrive, level: Int): Boolean {
        val direct = pgDriveDirect(d)
        if (direct.isEmpty()) return false
        var conn: HttpURLConnection? = null
        try {
            conn = open(direct, "GET", false)
            if (conn.responseCode !in 200..299) return false
            var mime = conn.contentType.orEmpty()
            var finalUrl = direct
            if (isHtml(mime)) {
                // the "can't scan for viruses" page: its form carries the real address
                val html = readBody(conn, mime, 300_000)
                conn.disconnect()
                val form = driveFormUrl(html, direct) ?: return false
                if (canceled.get()) return false
                conn = open(form, "GET", false)
                if (conn.responseCode !in 200..299) return false
                mime = conn.contentType.orEmpty()
                if (isHtml(mime)) return false
                finalUrl = form
            }
            if (canceled.get()) return true
            val canon = pgCanonOf(d)
            val disp = pgDispositionName(conn.getHeaderField("Content-Disposition"))
            var name = pgCleanName(disp ?: nameHints[canon] ?: "drive-${d.id.take(8)}")
            val wantExt = when (d.kind) {
                PgDriveKind.DOC -> "docx"
                PgDriveKind.SHEET -> "xlsx"
                PgDriveKind.SLIDES -> "pptx"
                else -> ""
            }
            if (wantExt.isNotEmpty() && pgExtOf(name).isEmpty()) name = "$name.$wantExt"
            val ext = pgExtOf(name)
            val type = pgTypeOf(ext, mime)
            val size = totalSize(conn)
            if (!cfg.filter.typeOk(type, ext)) return true
            if (!cfg.filter.sizeTimeOk(size, 0.0)) return true
            val kind = if (d.kind == PgDriveKind.FILE || d.kind == PgDriveKind.UNKNOWN) PgProviderKind.FILE else PgProviderKind.DOC
            emit(
                PgFile(
                    canon, name, ext, type, size, mime.substringBefore(';').trim(), cfg.startUrl, level,
                    PgProvider.DRIVE, order.incrementAndGet(), kind, finalUrl, ""
                )
            )
            return true
        } catch (e: Exception) {
            return false
        } finally {
            try { conn?.disconnect() } catch (e: Exception) { }
        }
    }

    /** a public folder: list it through the embedded view and handle every entry like a link found on a page. false = nothing could be listed. */
    private fun driveFolder(d: PgDrive, level: Int): Boolean {
        if (level > maxLevel + 1) {
            driveRow(d, level, PgProviderKind.FOLDER, "Folder: raise Level to open it")
            return true
        }
        val view = "https://drive.google.com/embeddedfolderview?id=${d.id}"
        var conn: HttpURLConnection? = null
        try {
            conn = open(view, "GET", false)
            if (conn.responseCode !in 200..299) return false
            val mime = conn.contentType.orEmpty()
            if (!isHtml(mime)) return false
            val html = readBody(conn, mime)
            val entries = driveEntries(html, view, d.id)
            if (entries.isEmpty()) return false
            for ((u, title) in entries) {
                if (canceled.get()) break
                if (title.isNotBlank()) nameHints.putIfAbsent(u, title)
                if (!seen.add(u)) continue
                submit(u, level + 1)
            }
            return true
        } catch (e: Exception) {
            return false
        } finally {
            try { conn?.disconnect() } catch (e: Exception) { }
        }
    }

    /** (canonical address, title) of the entries of a folder's embedded view; the folder itself is left out */
    private fun driveEntries(html: String, base: String, selfId: String): List<Pair<String, String>> {
        val out = LinkedHashMap<String, String>()
        try {
            val doc = Jsoup.parse(html, base)
            for (el in doc.select("div.flip-entry")) {
                if (out.size >= PG_FOLDER_CAP) break
                var d = pgParseDrive(el.selectFirst("a[href]")?.absUrl("href").orEmpty())
                if (d == null && el.id().startsWith("entry-")) {
                    val id = el.id().removePrefix("entry-")
                    if (PG_DRIVE_ID.matches(id)) d = PgDrive(PgDriveKind.UNKNOWN, id)
                }
                if (d == null || d.id == selfId) continue
                out.putIfAbsent(pgCanonOf(d), el.selectFirst(".flip-entry-title")?.text().orEmpty())
            }
            if (out.isEmpty()) {
                // the page layout changed: take every Drive link on it
                for (a in doc.select("a[href]")) {
                    if (out.size >= PG_FOLDER_CAP) break
                    val d = pgParseDrive(a.absUrl("href")) ?: continue
                    if (d.id == selfId) continue
                    out.putIfAbsent(pgCanonOf(d), a.text())
                }
            }
        } catch (e: Exception) { }
        return out.map { it.key to it.value }
    }

    // -----------------------------------------------------------------
    // Mega (step 6c): links only, nothing is requested (the files are encrypted in the client)
    // -----------------------------------------------------------------

    /** true = the address is a Mega file / folder link (a row was produced or it was skipped on purpose) */
    private fun handleMega(url: String, level: Int): Boolean {
        val m = pgParseMega(url) ?: return false
        if (!cfg.filter.providers && level > 1) return true
        val folder = m.kind == PgMegaKind.FOLDER
        val name = (if (folder) "Mega folder " else "Mega file ") + m.id
        val note = if (m.hasKey) "" else "The link has no key: Mega cannot open it without one"
        emit(
            PgFile(
                url, name, "", PgType.OTHER, -1L, "", cfg.startUrl, level, PgProvider.MEGA, order.incrementAndGet(),
                if (folder) PgProviderKind.FOLDER else PgProviderKind.FILE, url, note
            )
        )
        return true
    }
}

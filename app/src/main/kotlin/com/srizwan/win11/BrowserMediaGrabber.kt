package com.srizwan.win11

import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.GradientDrawable
import android.net.Uri
import android.text.TextUtils
import android.view.Gravity
import android.view.View
import android.webkit.CookieManager
import android.webkit.WebView
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import com.srizwan.YouTube.LinkDetector
import com.srizwan.YouTube.LinkType
import com.srizwan.YouTube.data.StreamDetails
import com.srizwan.YouTube.data.YtRepository
import com.srizwan.YouTube.player.PlayerActivity
import com.srizwan.video.player.VideoPlayerActivity
import org.json.JSONArray
import org.json.JSONTokener
import java.lang.ref.WeakReference
import java.util.Collections
import java.util.WeakHashMap
import kotlin.math.abs

// =====================================================================
// MEDIA GRABBER (Browser, step 5 of the YouTube plan)
//
// A button in the browser toolbar (a small blue dot shows when something was found on the page). It lists what
// the open page offers and lets you PLAY it (streaming, nothing is saved) or DOWNLOAD it:
//  * YouTube watch pages (youtube.com / m.youtube.com / youtu.be): read with the same extractor as the built-in
//    YouTube app. "MP4 · 360p" (video + audio in one file; the closest size when 360p is not offered), "Audio only"
//    (the original audio stream, M4A when YouTube has it) and, for a live stream, "Live stream" (play only).
//    MP4 Play opens the built-in YouTube player (quality, speed, floating window ...).
//  * any other page: media addresses the page loads (sniffed in WebViewClient.shouldInterceptRequest) and the
//    <video> / <audio> / <source> / og:video elements found by a small script. Play opens the built-in Video
//    player (streams: .m3u8 HLS and .mpd DASH too); Download uses the browser's own download engine (DlEngine),
//    so the file lands in Downloads with the usual progress / pause / resume.
// Not covered: blob: videos (they only exist inside the page), DRM streams, and streams (.m3u8 / .mpd) cannot be
// saved as one file. There is no MP3 encoder in the app: audio is saved in its original format, not converted.
// All state is touched on the main thread, except the sniffed set (synchronized).
// =====================================================================

internal enum class GrabKind { VIDEO, AUDIO, STREAM }

internal class GrabItem(
    val kind: GrabKind,
    val label: String,
    val detail: String,
    /** the address to play / download */
    val url: String,
    /** null = cannot be saved (a stream) */
    val fileName: String?,
    val mime: String,
    /** set: Play opens the built-in YouTube player for this watch link instead of the Video player */
    val youtubePage: String? = null
)

private val MEDIA_EXT: Map<String, GrabKind> = mapOf(
    "mp4" to GrabKind.VIDEO, "m4v" to GrabKind.VIDEO, "webm" to GrabKind.VIDEO, "mov" to GrabKind.VIDEO,
    "mkv" to GrabKind.VIDEO, "3gp" to GrabKind.VIDEO, "flv" to GrabKind.VIDEO,
    "mp3" to GrabKind.AUDIO, "m4a" to GrabKind.AUDIO, "aac" to GrabKind.AUDIO, "ogg" to GrabKind.AUDIO,
    "oga" to GrabKind.AUDIO, "opus" to GrabKind.AUDIO, "wav" to GrabKind.AUDIO, "flac" to GrabKind.AUDIO,
    "m3u8" to GrabKind.STREAM, "mpd" to GrabKind.STREAM
)

private const val SCAN_JS = """
(function(){
  var r=[];
  function add(u,t){
    if(!u||typeof u!=='string'||u.indexOf('blob:')===0||u.indexOf('data:')===0) return;
    try{u=new URL(u,location.href).href}catch(e){return}
    r.push([u,t]);
  }
  document.querySelectorAll('video,audio').forEach(function(m){
    var t=m.tagName.toLowerCase();
    add(m.currentSrc||m.src,t);
    m.querySelectorAll('source').forEach(function(s){add(s.src,t)});
  });
  document.querySelectorAll('meta[property="og:video"],meta[property="og:video:url"],meta[property="og:video:secure_url"],meta[property="og:audio"]')
    .forEach(function(m){add(m.content,'meta')});
  return JSON.stringify(r);
})()
"""

/** Media addresses each page loaded (newest tab page only: cleared when a page starts). */
private val sniffed = Collections.synchronizedMap(WeakHashMap<WebView, LinkedHashSet<String>>())
private var grabAct: WeakReference<MainActivity>? = null
private var grabDot: View? = null

private fun extOf(url: String): String =
    url.substringBefore('#').substringBefore('?').substringAfterLast('/').substringAfterLast('.', "").lowercase()

/** Called for every request of a page (any thread): remembers addresses that look like media. Never blocks or changes the request. */
internal fun sniffMediaRequest(view: WebView?, url: String) {
    if (view == null || !url.startsWith("http")) return
    if (MEDIA_EXT[extOf(url)] == null) return
    val set = synchronized(sniffed) { sniffed.getOrPut(view) { LinkedHashSet() } }
    val added = synchronized(set) { set.size < 40 && set.add(url) }
    if (added) grabAct?.get()?.let { a -> a.runOnUiThread { a.refreshGrabDot() } }
}

/** A new page starts in [view]: what the old page loaded is forgotten. */
internal fun clearSniffedMedia(view: WebView) {
    synchronized(sniffed) { sniffed.remove(view) }
}

private fun sniffedFor(view: WebView): List<String> {
    val set = synchronized(sniffed) { sniffed[view] } ?: return emptyList()
    return synchronized(set) { set.toList() }
}

private fun youtubeVideoLink(url: String?) = LinkDetector.detect(url).takeIf { it.type == LinkType.VIDEO }

/** The toolbar button (add it to the browser toolbar). */
internal fun MainActivity.makeMediaGrabberButton(): FrameLayout {
    grabAct = WeakReference(this)
    val icon = VectorIconView(this, VectorIconView.VIDEO).apply { setIconColor(Color.parseColor("#B0B0B0")) }
    val holder = makeToolBtn(icon, "Media Grabber") { showMediaGrabber() }
    val dot = View(this).apply {
        background = GradientDrawable().apply { shape = GradientDrawable.OVAL; setColor(Color.parseColor("#4CC2FF")) }
        visibility = View.GONE
    }
    holder.addView(dot, FrameLayout.LayoutParams(dp(8), dp(8), Gravity.TOP or Gravity.END).apply {
        topMargin = dp(6); rightMargin = dp(6)
    })
    grabDot = dot
    return holder
}

/** Shows the blue dot while the open page has something to grab. */
internal fun MainActivity.refreshGrabDot() {
    val dot = grabDot ?: return
    val wv = webTabs.getOrNull(currentTabIndex)?.webView
    val has = wv != null &&
        (sniffedFor(wv).isNotEmpty() || youtubeVideoLink(runCatching { wv.url }.getOrNull()) != null)
    dot.visibility = if (has) View.VISIBLE else View.GONE
}

internal fun MainActivity.showMediaGrabber() {
    val tab = webTabs.getOrNull(currentTabIndex) ?: return
    val wv = tab.webView
    val pageUrl = runCatching { wv.url }.getOrNull().orEmpty()
    val pageTitle = tab.title.takeIf { it.isNotBlank() && it != "Loading…" } ?: "video"

    val ytItems = ArrayList<GrabItem>()
    val pageItems = LinkedHashMap<String, GrabItem>()
    var pending = 0
    var ytError = false
    var dialogRef: W11Dialog? = null
    val list = LinearLayout(this).apply { orientation = LinearLayout.VERTICAL }

    fun label(text: String, size: Float, color: Int, bold: Boolean = false) = TextView(this).apply {
        this.text = text; textSize = size; setTextColor(color)
        if (bold) typeface = Typeface.DEFAULT_BOLD
    }

    fun pill(text: String, filled: Boolean, onClick: () -> Unit) = TextView(this).apply {
        this.text = text
        textSize = 13f
        typeface = Typeface.DEFAULT_BOLD
        gravity = Gravity.CENTER
        setTextColor(if (filled) Color.BLACK else Color.WHITE)
        setPadding(dp(16), dp(8), dp(16), dp(8))
        background = GradientDrawable().apply {
            cornerRadius = dp(18).toFloat()
            if (filled) setColor(Color.parseColor("#4CC2FF"))
            else { setColor(Color.parseColor("#333333")); setStroke(1, Color.parseColor("#4A4A4A")) }
        }
        isClickable = true
        setOnClickListener { onClick() }
    }

    fun play(g: GrabItem) {
        dialogRef?.dismiss()
        if (g.youtubePage != null) PlayerActivity.start(this, g.youtubePage)
        else VideoPlayerActivity.start(this, g.url, pageTitle)
    }

    fun download(g: GrabItem) {
        val name = g.fileName ?: return
        dialogRef?.dismiss()
        val cookies = CookieManager.getInstance().getCookie(g.url) ?: ""
        val ua = runCatching { wv.settings.userAgentString }.getOrDefault("")
        showDownloadDialog("Unknown size", name) { fileName ->
            enqueueDownload(g.url, fileName, g.mime, cookies, ua, pageUrl)
        }
    }

    fun row(g: GrabItem): View = LinearLayout(this).apply {
        orientation = LinearLayout.VERTICAL
        setPadding(dp(12), dp(10), dp(12), dp(10))
        background = GradientDrawable().apply {
            cornerRadius = dp(12).toFloat()
            setColor(Color.parseColor("#262626"))
            setStroke(1, Color.parseColor("#3A3A3A"))
        }
        layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT
        ).apply { bottomMargin = dp(8) }
        addView(label(g.label, 14f, Color.WHITE, bold = true))
        addView(label(g.detail, 11f, Color.parseColor("#9D9D9D")).apply {
            maxLines = 1; ellipsize = TextUtils.TruncateAt.END
        })
        addView(LinearLayout(context).apply {
            orientation = LinearLayout.HORIZONTAL
            setPadding(0, dp(8), 0, 0)
            addView(pill("Play", filled = false) { play(g) })
            if (g.fileName != null) {
                addView(pill("Download", filled = true) { download(g) }, LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT
                ).apply { marginStart = dp(8) })
            }
        })
    }

    fun render() {
        list.removeAllViews()
        val all = ytItems + pageItems.values
        for (g in all) list.addView(row(g))
        if (all.isEmpty() && pending > 0) {
            list.addView(label("Looking for media on this page…", 13f, Color.parseColor("#B0B0B0")))
        } else if (all.isEmpty()) {
            list.addView(label(
                if (ytError) "Could not read this YouTube video. Check the connection and try again."
                else "No media found yet. Start the video on the page, then open the Media Grabber again.",
                13f, Color.parseColor("#B0B0B0")
            ))
        }
        if (ytItems.any { it.kind == GrabKind.AUDIO }) {
            list.addView(label(
                "Audio is saved in its original format (M4A); it is not converted to MP3.",
                11f, Color.parseColor("#8A8A8A")
            ).apply { setPadding(0, dp(4), 0, 0) })
        }
        if (all.any { it.fileName == null }) {
            list.addView(label(
                "Streams (live / HLS / DASH) can be played but not saved as one file.",
                11f, Color.parseColor("#8A8A8A")
            ).apply { setPadding(0, dp(4), 0, 0) })
        }
    }

    // ---- a media address found in the page -> a row ----
    fun direct(url: String, hint: String?): GrabItem? {
        val ext = extOf(url)
        val kind = MEDIA_EXT[ext] ?: when (hint) {
            "audio" -> GrabKind.AUDIO
            "video", "meta" -> GrabKind.VIDEO
            else -> return null
        }
        val host = runCatching { Uri.parse(url).host }.getOrNull().orEmpty()
        return when (kind) {
            GrabKind.STREAM -> GrabItem(
                kind, "Stream · ${ext.uppercase()}", host.ifEmpty { url }, url, null,
                if (ext == "mpd") "application/dash+xml" else "application/vnd.apple.mpegurl"
            )
            else -> {
                val fext = if (MEDIA_EXT[ext] == kind) ext else if (kind == GrabKind.AUDIO) "mp3" else "mp4"
                val mime = DlEngine.guessMime("x.$fext")
                GrabItem(
                    kind,
                    (if (kind == GrabKind.AUDIO) "Audio · " else "Video · ") + fext.uppercase(),
                    host.ifEmpty { url }, url, sanitizeFileName("$pageTitle.$fext"), mime
                )
            }
        }
    }

    // ---- a YouTube watch page ----
    fun addYoutube(d: StreamDetails, pageLink: String) {
        if (d.isLive) {
            ytItems.add(GrabItem(
                GrabKind.STREAM, "Live stream", "Plays in the YouTube player", d.hlsUrl ?: pageLink, null,
                "application/vnd.apple.mpegurl", youtubePage = pageLink
            ))
            return
        }
        val mp4 = d.muxed.filter {
            val n = it.format.orEmpty().lowercase(); n.contains("mpeg") || n.contains("mp4")
        }.ifEmpty { d.muxed }
        val v = mp4.minByOrNull { abs(it.height - 360) }
        if (v != null) {
            val webm = v.format.orEmpty().lowercase().contains("webm")
            val ext = if (webm) "webm" else "mp4"
            val q = v.label.ifBlank { "${v.height}p" }
            ytItems.add(GrabItem(
                GrabKind.VIDEO, "${ext.uppercase()} · $q · video + audio",
                if (v.height == 360) "Plays in the YouTube player" else "360p is not offered; closest size",
                v.url, sanitizeFileName("${d.title} ($q).$ext"),
                if (webm) "video/webm" else "video/mp4", youtubePage = pageLink
            ))
        }
        val a = d.audio.filter { it.format.orEmpty().lowercase().contains("m4a") }.maxByOrNull { it.bitrate }
            ?: d.audio.maxByOrNull { it.bitrate }
        if (a != null) {
            val m4a = a.format.orEmpty().lowercase().contains("m4a")
            val ext = if (m4a) "m4a" else "webm"
            ytItems.add(GrabItem(
                GrabKind.AUDIO, "Audio only · ${ext.uppercase()} · ${a.bitrate} kbps",
                "Original audio stream", a.url, sanitizeFileName("${d.title}.$ext"),
                if (m4a) "audio/mp4" else "audio/webm"
            ))
        }
    }

    val scroll = ScrollView(this).apply {
        setPadding(dp(16), dp(8), dp(16), dp(8))
        addView(list)
    }
    render()
    dialogRef = W11Dialog.Builder(this)
        .setTitle("Media Grabber")
        .setIcon(R.drawable.ic_w_download)
        .setView(scroll)
        .setNegativeButton("Close", null)
        .show()

    // 1) addresses the page already loaded
    for (u in sniffedFor(wv)) direct(u, null)?.let { pageItems.putIfAbsent(it.url, it) }

    // 2) <video> / <audio> / <source> / og:video in the page
    pending++
    wv.evaluateJavascript(SCAN_JS) { value ->
        pending--
        runCatching {
            val text = JSONTokener(value ?: "null").nextValue() as? String ?: return@runCatching
            val arr = JSONArray(text)
            for (i in 0 until arr.length()) {
                val p = arr.getJSONArray(i)
                direct(p.getString(0), p.getString(1))?.let { pageItems.putIfAbsent(it.url, it) }
            }
        }
        render()
    }

    // 3) a YouTube watch page: read its streams
    val yt = youtubeVideoLink(pageUrl)
    val ytUrl = yt?.url
    if (ytUrl != null) {
        pending++
        YtRepository.async({ YtRepository.stream(ytUrl) }) { result ->
            pending--
            result.onSuccess { addYoutube(it, ytUrl) }.onFailure { ytError = true }
            render()
        }
    }
    render()
}

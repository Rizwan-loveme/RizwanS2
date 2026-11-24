package com.srizwan.win11

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.GradientDrawable
import android.net.Uri
import android.os.Handler
import android.os.Looper
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.view.Gravity
import android.view.View
import android.webkit.CookieManager
import android.webkit.JavascriptInterface
import android.webkit.WebView
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.HorizontalScrollView
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import android.widget.Toast
import androidx.webkit.WebViewCompat
import androidx.webkit.WebViewFeature
import com.srizwan.YouTube.LinkDetector
import com.srizwan.YouTube.LinkType
import com.srizwan.YouTube.data.StreamDetails
import com.srizwan.YouTube.data.YtRepository
import com.srizwan.YouTube.player.PlayerActivity
import com.srizwan.video.player.VideoPlayerActivity
import org.json.JSONArray
import org.json.JSONObject
import org.json.JSONTokener
import java.lang.ref.WeakReference
import java.net.HttpURLConnection
import java.net.URI
import java.net.URL
import java.util.WeakHashMap
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.Executors
import kotlin.math.abs

// =====================================================================
// MEDIA GRABBER (Browser, step 5 of the YouTube plan; step 5b = "catch everything")
//
// A button in the browser toolbar (a small blue dot shows when something was found on the page). It lists what
// the open page - or the whole site - offers and lets you PLAY it (streaming, nothing is saved), DOWNLOAD it,
// COPY its address or OPEN it in a new tab.
//
// WHERE MEDIA IS CAUGHT (all of them feed the same list, de-duplicated):
//  1. network   every request the page makes (WebViewClient.shouldInterceptRequest): by file type (mp4, webm, mp3,
//               m4a, ogg, wav, flac, avi, wmv ...), HLS / DASH / Smooth manifests (.m3u8, .mpd, .ism/manifest),
//               also when the address is hidden inside a query string. Segments (.ts, .m4s, seg123 ...) are ignored.
//  2. script    GRAB_HOOK_JS runs at document start in every frame (WebViewCompat.addDocumentStartJavaScript, and
//               again from onPageStarted / onPageFinished): hooks fetch() and XMLHttpRequest and reports every
//               response whose Content-Type is video / audio / mpegurl / dash - so media with NO file extension is
//               caught too - and hooks the <video> / <audio> elements (src setter, play, load events, new Audio()),
//               MediaSource and URL.createObjectURL (blob: media is reported as "Blob media", it cannot be saved).
//  3. page      SCAN_JS (on opening the Media Grabber and on "Rescan"): <video>, <audio>, <source>, <embed>,
//               <object>, <link>, <a href> to media files, og:video / twitter:player:stream / JSON-LD contentUrl,
//               iframes (embedded players; a YouTube embed can be played in the built-in YouTube player), open
//               shadow roots and same-origin iframes, the performance resource list (requests made before the hook
//               existed) and a text scan of the page source for media addresses (also relative ones).
//  4. site      "Scan site": CRAWL_JS fetches up to 60 pages of the same site (links of this page + sitemap.xml,
//               3 at a time, 12 s each) and collects their media / embeds / links without opening them. Only pages
//               of the same origin can be read (browser rule); a page with a strict Content-Security-Policy may
//               block it. Results stay in the "Whole site" list until the app is closed.
//  5. YouTube watch pages (youtube.com / m.youtube.com / youtu.be): same extractor as the built-in YouTube app.
//               "MP4 - 360p" (video + audio in one file), "Audio only" (M4A when YouTube has it), "Live stream".
//
// WHAT THE LIST SHOWS: This page / Whole site, a type filter (Video, Audio, Streams, Embeds, Links), a text filter,
// the file size and type of direct files (a small HEAD request in the background), the quality variants of an HLS
// master playlist, and every link of the page / site (Links) with Open and Copy.
// Download uses the browser's own download engine (DlEngine): Downloads folder, progress, pause / resume.
// Not covered: DRM streams, blob: media (only inside the page), and streams (.m3u8 / .mpd) cannot be saved as one
// file (play or copy the address). There is no MP3 encoder: audio is saved in its original format.
// State: the stores are guarded by gLock (the JS bridge calls from WebView threads); the UI is main-thread only.
// =====================================================================

internal enum class GrabKind { VIDEO, AUDIO, STREAM, EMBED, BLOB }

internal class GrabItem(
    val kind: GrabKind,
    val label: String,
    val detail: String,
    /** the address to play / download */
    val url: String,
    /** null = cannot be saved (a stream, an embed) */
    val fileName: String?,
    val mime: String,
    /** set: Play opens the built-in YouTube player for this watch link instead of the Video player */
    val youtubePage: String? = null,
    /** how it was found: net / script / page / site / variant */
    val from: String = "",
    /** the page it was found on (download referer) */
    val page: String = ""
)

/** one raw find, before it is turned into a row */
internal class GrabHit(val url: String, val hint: String, val from: String, val page: String)

private class GrabVariant(val url: String, val label: String, val bandwidth: Long)
private class GrabProbe(val size: Long, val mime: String?)

private val MEDIA_EXT: Map<String, GrabKind> = mapOf(
    "mp4" to GrabKind.VIDEO, "m4v" to GrabKind.VIDEO, "webm" to GrabKind.VIDEO, "mov" to GrabKind.VIDEO,
    "mkv" to GrabKind.VIDEO, "3gp" to GrabKind.VIDEO, "flv" to GrabKind.VIDEO, "avi" to GrabKind.VIDEO,
    "wmv" to GrabKind.VIDEO, "mpg" to GrabKind.VIDEO, "mpeg" to GrabKind.VIDEO, "ogv" to GrabKind.VIDEO,
    "mp3" to GrabKind.AUDIO, "m4a" to GrabKind.AUDIO, "aac" to GrabKind.AUDIO, "ogg" to GrabKind.AUDIO,
    "oga" to GrabKind.AUDIO, "opus" to GrabKind.AUDIO, "wav" to GrabKind.AUDIO, "flac" to GrabKind.AUDIO,
    "wma" to GrabKind.AUDIO, "weba" to GrabKind.AUDIO, "amr" to GrabKind.AUDIO, "mka" to GrabKind.AUDIO,
    "m4b" to GrabKind.AUDIO,
    "m3u8" to GrabKind.STREAM, "mpd" to GrabKind.STREAM
)

private val RE_HLS = Regex("\\.m3u8(?:[?#&/;]|\$)", RegexOption.IGNORE_CASE)
private val RE_DASH = Regex("\\.mpd(?:[?#&/;]|\$)", RegexOption.IGNORE_CASE)
private val RE_SEGMENT = Regex(
    "(?:seg(?:ment)?|chunk|frag(?:ment)?)[-_.]?\\d+|\\.(?:ts|m4s)(?:[?#]|\$)", RegexOption.IGNORE_CASE
)
private val RE_YT_EMBED = Regex("youtube(?:-nocookie)?\\.com/embed/([A-Za-z0-9_-]{11})")

// ---------------------------------------------------------------------
// JavaScript
// ---------------------------------------------------------------------

/**
 * Injected at document start (every frame) and again from onPageStarted / onPageFinished (it runs only once per
 * document). Reports to W11Grab.report('[[url, hint, from, pageUrl], ...]'). No dollar sign in here (Kotlin raw string).
 */
internal const val GRAB_HOOK_JS = """
(function(){
  if (window.__w11grab) return; window.__w11grab = true;
  var seen = {}, q = [], timer = 0;
  var SEG = /(?:seg(?:ment)?|chunk|frag(?:ment)?)[-_.]?\d+|\.(?:ts|m4s)(?:[?#]|$)/i;
  function abs(u){ try { return new URL(u, location.href).href; } catch(e){ return null; } }
  function flush(){
    timer = 0; if (!q.length) return;
    var b = q; q = [];
    try { W11Grab.report(JSON.stringify(b)); } catch(e){}
  }
  function rep(u, hint, from){
    try {
      if (!u || typeof u !== 'string') return;
      if (u.indexOf('blob:') === 0 || u === 'blob-mse') { hint = 'blob'; }
      else { u = abs(u); if (!u || u.indexOf('http') !== 0) return; u = u.split('#')[0]; if (SEG.test(u)) return; }
      var k = hint + '|' + u; if (seen[k]) return; seen[k] = 1;
      if (q.length < 200) q.push([u, hint, from, location.href]);
      if (!timer) timer = setTimeout(flush, 250);
    } catch(e){}
  }
  function ctHint(ct){
    if (!ct) return null; ct = String(ct).toLowerCase();
    if (ct.indexOf('mp2t') >= 0 || ct.indexOf('iso.segment') >= 0) return null;
    if (ct.indexOf('video/') === 0) return 'video';
    if (ct.indexOf('audio/') === 0) return 'audio';
    if (ct.indexOf('mpegurl') >= 0 || ct.indexOf('dash+xml') >= 0) return 'stream';
    return null;
  }
  // fetch(): the response type tells media even when the address has no file extension
  try {
    var of = window.fetch;
    if (of) window.fetch = function(){
      var p = of.apply(this, arguments);
      try {
        p.then(function(r){
          try { var h = ctHint(r.headers.get('content-type')); if (h && r.url) rep(r.url, h, 'fetch'); } catch(e){}
        }, function(){});
      } catch(e){}
      return p;
    };
  } catch(e){}
  // XMLHttpRequest
  try {
    var os = XMLHttpRequest.prototype.send;
    XMLHttpRequest.prototype.send = function(){
      var x = this;
      try {
        x.addEventListener('readystatechange', function(){
          if (x.readyState === 2) {
            try { var h = ctHint(x.getResponseHeader('content-type')); if (h && x.responseURL) rep(x.responseURL, h, 'xhr'); } catch(e){}
          }
        });
      } catch(e){}
      return os.apply(this, arguments);
    };
  } catch(e){}
  // <video> / <audio> elements
  function el(m){
    try {
      var t = m.tagName === 'AUDIO' ? 'audio' : 'video';
      var u = m.currentSrc || m.src; if (u) rep(u, t, 'dom');
      if (m.querySelectorAll) m.querySelectorAll('source').forEach(function(s){ if (s.src) rep(s.src, t, 'dom'); });
    } catch(e){}
  }
  ['loadstart','loadedmetadata','durationchange','play','playing'].forEach(function(ev){
    document.addEventListener(ev, function(e){
      var t = e.target; if (t && t.tagName && (t.tagName === 'VIDEO' || t.tagName === 'AUDIO')) el(t);
    }, true);
  });
  try {
    var d = Object.getOwnPropertyDescriptor(HTMLMediaElement.prototype, 'src');
    if (d && d.set) Object.defineProperty(HTMLMediaElement.prototype, 'src', {
      get: d.get, configurable: true, enumerable: d.enumerable,
      set: function(v){ try { rep(v, this.tagName === 'AUDIO' ? 'audio' : 'video', 'dom'); } catch(e){} return d.set.call(this, v); }
    });
  } catch(e){}
  try {
    var op = HTMLMediaElement.prototype.play;
    HTMLMediaElement.prototype.play = function(){ el(this); return op.apply(this, arguments); };
    var ol = HTMLMediaElement.prototype.load;
    HTMLMediaElement.prototype.load = function(){ el(this); return ol.apply(this, arguments); };
  } catch(e){}
  // blob: media
  try {
    var oc = URL.createObjectURL;
    URL.createObjectURL = function(o){
      var u = oc.apply(this, arguments);
      try {
        if (o && o.constructor && o.constructor.name === 'MediaSource') rep('blob-mse', 'blob', 'mse');
        else if (o && o.type && /^(video|audio)\//.test(o.type)) rep(u, 'blob', 'blob');
      } catch(e){}
      return u;
    };
  } catch(e){}
})();
"""

/** On demand (opening the Media Grabber / Rescan): everything the page document shows. Returns JSON {"m":[[url,hint,from]],"l":[[url,text]]}. */
private const val SCAN_JS = """
(function(){
  var M = [], L = [], sm = {}, sl = {};
  var EXT = /\.(?:mp4|m4v|webm|mov|mkv|3gp|flv|avi|wmv|mpe?g|ogv|mp3|m4a|aac|ogg|oga|opus|wav|flac|wma|weba|amr|mka|m4b|m3u8|mpd)(?:[?&;,#]|$)/i;
  function abs(u, b){ try { return new URL(u, b || location.href).href; } catch(e){ return null; } }
  function m(u, h, f){
    if (!u || typeof u !== 'string') return;
    if (u.indexOf('blob:') === 0) { if (!sm['b' + u]) { sm['b' + u] = 1; M.push([u, 'blob', f]); } return; }
    if (u.indexOf('data:') === 0) return;
    u = abs(u); if (!u || u.indexOf('http') !== 0) return;
    u = u.split('#')[0]; var k = h + '|' + u; if (sm[k]) return; sm[k] = 1; M.push([u, h, f]);
  }
  function l(u, t){
    if (!u || typeof u !== 'string') return;
    u = abs(u); if (!u || u.indexOf('http') !== 0) return;
    u = u.split('#')[0]; if (sl[u]) return; sl[u] = 1;
    if (L.length < 3000) L.push([u, (t || '').replace(/\s+/g, ' ').trim().slice(0, 80)]);
  }
  function walk(root, depth){
    try {
      root.querySelectorAll('video,audio').forEach(function(e){
        var t = e.tagName.toLowerCase();
        m(e.currentSrc || e.src, t, 'page'); m(e.getAttribute('src'), t, 'page'); m(e.getAttribute('data-src'), t, 'page');
        e.querySelectorAll('source').forEach(function(s){ m(s.src, t, 'page'); m(s.getAttribute('data-src'), t, 'page'); });
      });
      root.querySelectorAll('source[src]').forEach(function(s){ m(s.src, (s.type || '').indexOf('audio') === 0 ? 'audio' : 'video', 'page'); });
      root.querySelectorAll('a[href]').forEach(function(a){ l(a.href, a.textContent); if (EXT.test(a.href)) m(a.href, 'url', 'page'); });
      root.querySelectorAll('embed[src]').forEach(function(e){ m(e.src, 'embed', 'page'); });
      root.querySelectorAll('object[data]').forEach(function(e){ m(e.data, 'embed', 'page'); });
      root.querySelectorAll('iframe[src],frame[src]').forEach(function(f){
        m(f.src, 'embed', 'page');
        try { if (f.contentDocument && depth < 3) walk(f.contentDocument, depth + 1); } catch(e){}
      });
      root.querySelectorAll('link[href]').forEach(function(k){
        var r = (k.rel || '').toLowerCase(), as = k.getAttribute('as') || '';
        if (r === 'video_src' || as === 'video' || as === 'audio' || EXT.test(k.href)) m(k.href, 'url', 'page');
      });
      root.querySelectorAll('meta').forEach(function(x){
        var p = (x.getAttribute('property') || x.getAttribute('name') || x.getAttribute('itemprop') || '').toLowerCase();
        if (/^(?:og:(?:video|audio)(?::(?:url|secure_url))?|twitter:player:stream|contenturl)${'$'}/.test(p)) m(x.content, p.indexOf('audio') >= 0 ? 'audio' : 'meta', 'page');
        else if (p === 'embedurl' || p === 'twitter:player') m(x.content, 'embed', 'page');
      });
      if (depth < 6) root.querySelectorAll('*').forEach(function(e){ if (e.shadowRoot) walk(e.shadowRoot, depth + 1); });
    } catch(e){}
  }
  walk(document, 0);
  try {
    document.querySelectorAll('script[type="application/ld+json"]').forEach(function(s){
      try {
        (function w(o){
          if (!o || typeof o !== 'object') return;
          if (Array.isArray(o)) { o.forEach(w); return; }
          if (o.contentUrl) m(o.contentUrl, 'meta', 'page');
          if (o.embedUrl) m(o.embedUrl, 'embed', 'page');
          for (var k in o) w(o[k]);
        })(JSON.parse(s.textContent));
      } catch(e){}
    });
  } catch(e){}
  try {
    performance.getEntriesByType('resource').forEach(function(e){
      var n = e.name;
      if (EXT.test(n) || e.initiatorType === 'video' || e.initiatorType === 'audio')
        m(n, e.initiatorType === 'audio' ? 'audio' : (e.initiatorType === 'video' ? 'video' : 'url'), 'page');
    });
  } catch(e){}
  try {
    var html = document.documentElement.innerHTML;
    if (html.length > 3000000) html = html.slice(0, 3000000);
    html = html.replace(/\\\//g, '/').replace(/&amp;/g, '&');
    var re1 = /https?:\/\/[^\s"'<>\\()\[\]{}`]+/gi, mt, n = 0;
    while ((mt = re1.exec(html)) && n < 6000) { n++; if (EXT.test(mt[0])) m(mt[0], 'url', 'page'); }
    var re2 = /["']([^"'\s<>\\]{1,400}?\.(?:mp4|m4v|webm|mov|mkv|m3u8|mpd|mp3|m4a|aac|ogg|opus|wav|flac)(?:\?[^"'\s<>\\]{0,300})?)["']/gi;
    n = 0;
    while ((mt = re2.exec(html)) && n < 3000) { n++; m(mt[1], 'url', 'page'); }
  } catch(e){}
  return JSON.stringify({m: M, l: L});
})()
"""

/** "Scan site": __LIMIT__ is replaced by the number of pages. Reports through W11Grab.report / links / progress / finished. */
private const val CRAWL_JS = """
(function(){
  if (window.__w11crawl && window.__w11crawl.running) return 'busy';
  var LIMIT = __LIMIT__, origin = location.origin;
  var st = window.__w11crawl = {running: true, stop: false};
  var queue = [], seen = {}, done = 0, active = 0, ended = false;
  var SKIP = /\.(?:jpe?g|png|gif|svg|webp|ico|bmp|css|js|json|xml|pdf|zip|rar|7z|apk|exe|dmg|woff2?|ttf|otf|eot|mp4|m4v|webm|mov|mkv|3gp|flv|avi|wmv|mpe?g|ogv|mp3|m4a|aac|ogg|oga|opus|wav|flac|wma|weba|m3u8|mpd|doc|docx|xls|xlsx|ppt|pptx|iso|torrent)(?:[?#]|$)/i;
  var EXT = /\.(?:mp4|m4v|webm|mov|mkv|3gp|flv|avi|wmv|mpe?g|ogv|mp3|m4a|aac|ogg|oga|opus|wav|flac|wma|weba|amr|mka|m4b|m3u8|mpd)(?:[?&;,#]|$)/i;
  function norm(u){
    try { var x = new URL(u, location.href); if (x.origin !== origin) return null; x.hash = ''; return x.href; } catch(e){ return null; }
  }
  function push(u){
    u = norm(u); if (!u || seen[u] || SKIP.test(u)) return;
    if (queue.length + done + active >= LIMIT * 4) return;
    seen[u] = 1; queue.push(u);
  }
  seen[norm(location.href) || ''] = 1;
  function parse(u, html){
    var out = [], ls = [], doc;
    try { doc = new DOMParser().parseFromString(html, 'text/html'); } catch(e){ return; }
    function ab(h){ try { var r = new URL(h, u).href.split('#')[0]; return r.indexOf('http') === 0 ? r : null; } catch(e){ return null; } }
    doc.querySelectorAll('a[href]').forEach(function(a){
      var r = ab(a.getAttribute('href')); if (!r) return;
      if (ls.length < 400) ls.push([r, (a.textContent || '').replace(/\s+/g, ' ').trim().slice(0, 80)]);
      if (EXT.test(r)) out.push([r, 'url', 'site', u]); else push(r);
    });
    doc.querySelectorAll('video,audio').forEach(function(e){
      var t = e.tagName.toLowerCase();
      var a = [e.getAttribute('src'), e.getAttribute('data-src')];
      e.querySelectorAll('source').forEach(function(s){ a.push(s.getAttribute('src')); });
      a.forEach(function(s){ var r = s && ab(s); if (r) out.push([r, t, 'site', u]); });
    });
    doc.querySelectorAll('iframe[src],embed[src]').forEach(function(f){ var r = ab(f.getAttribute('src')); if (r) out.push([r, 'embed', 'site', u]); });
    doc.querySelectorAll('meta').forEach(function(x){
      var p = (x.getAttribute('property') || x.getAttribute('name') || x.getAttribute('itemprop') || '').toLowerCase();
      var r = x.getAttribute('content') && ab(x.getAttribute('content'));
      if (r && /^(?:og:(?:video|audio)(?::(?:url|secure_url))?|twitter:player:stream|contenturl)${'$'}/.test(p)) out.push([r, p.indexOf('audio') >= 0 ? 'audio' : 'meta', 'site', u]);
    });
    try {
      var t = html.replace(/\\\//g, '/').replace(/&amp;/g, '&'), mt, n = 0;
      var re1 = /https?:\/\/[^\s"'<>\\()\[\]{}`]+/gi;
      while ((mt = re1.exec(t)) && n < 4000) { n++; if (EXT.test(mt[0])) out.push([mt[0], 'url', 'site', u]); }
      var re2 = /["']([^"'\s<>\\]{1,400}?\.(?:mp4|m4v|webm|mov|mkv|m3u8|mpd|mp3|m4a|aac|ogg|opus|wav|flac)(?:\?[^"'\s<>\\]{0,300})?)["']/gi;
      n = 0;
      while ((mt = re2.exec(t)) && n < 2000) { n++; var r2 = ab(mt[1]); if (r2) out.push([r2, 'url', 'site', u]); }
    } catch(e){}
    if (out.length) { try { W11Grab.report(JSON.stringify(out.slice(0, 300))); } catch(e){} }
    if (ls.length) { try { W11Grab.links(JSON.stringify(ls)); } catch(e){} }
  }
  function finish(){
    if (ended) return; ended = true; st.running = false;
    try { W11Grab.finished(done); } catch(e){}
  }
  function next(){
    if (st.stop) { if (active === 0) finish(); return; }
    while (active < 3 && queue.length && done + active < LIMIT) run(queue.shift());
    if (active === 0 && (!queue.length || done >= LIMIT)) finish();
  }
  function run(u){
    active++;
    var ctl = null; try { ctl = new AbortController(); } catch(e){}
    var to = setTimeout(function(){ try { if (ctl) ctl.abort(); } catch(e){} }, 12000);
    var opts = {credentials: 'include'}; if (ctl) opts.signal = ctl.signal;
    fetch(u, opts).then(function(r){
      var ct = (r.headers.get('content-type') || '').toLowerCase();
      if (ct.indexOf('html') < 0) return '';
      return r.text();
    }).then(function(t){ if (t) parse(u, t.length > 2000000 ? t.slice(0, 2000000) : t); })
    .catch(function(){})
    .then(function(){
      clearTimeout(to); active--; done++;
      try { W11Grab.progress(done, Math.min(LIMIT, done + active + queue.length)); } catch(e){}
      next();
    });
  }
  Array.prototype.forEach.call(document.querySelectorAll('a[href]'), function(a){ push(a.href); });
  try {
    fetch(origin + '/sitemap.xml', {credentials: 'include'})
      .then(function(r){ return r.ok ? r.text() : ''; })
      .then(function(t){
        var re = /<loc>\s*([^<\s]+)\s*<\/loc>/gi, mt, n = 0;
        while ((mt = re.exec(t || '')) && n < 150) { n++; push(mt[1].replace(/&amp;/g, '&')); }
      })
      .catch(function(){})
      .then(next);
  } catch(e){ next(); }
  return 'started';
})()
"""

// ---------------------------------------------------------------------
// Stores (guarded by gLock) and classification
// ---------------------------------------------------------------------

private const val PAGE_CAP = 400
private const val SITE_CAP = 1500
private const val LINK_PAGE_CAP = 3000
private const val LINK_SITE_CAP = 6000
private const val SITE_COUNT_CAP = 20
private const val CRAWL_PAGES = 60
private const val ROW_CAP = 150

private val gLock = Any()
private val pageHits = WeakHashMap<WebView, LinkedHashMap<String, GrabHit>>()
private val siteHits = LinkedHashMap<String, LinkedHashMap<String, GrabHit>>()
private val pageLinks = WeakHashMap<WebView, LinkedHashMap<String, String>>()
private val siteLinks = LinkedHashMap<String, LinkedHashMap<String, String>>()
private val viewHost = WeakHashMap<WebView, String>()

private var grabAct: WeakReference<MainActivity>? = null
private var grabDot: View? = null
/** set while the Media Grabber dialog is open: called (on the main thread) when something new arrives */
private var grabListener: (() -> Unit)? = null

@Volatile private var crawlRunning = false
@Volatile private var crawlDone = 0
@Volatile private var crawlTotal = 0
private var crawlView: WeakReference<WebView>? = null

private val probes = ConcurrentHashMap<String, GrabProbe>()
private val probing: MutableSet<String> = ConcurrentHashMap.newKeySet()
private val hlsVariants = ConcurrentHashMap<String, List<GrabVariant>>()
private val hlsFetching: MutableSet<String> = ConcurrentHashMap.newKeySet()
private val grabExec = Executors.newFixedThreadPool(3)

private fun extOf(url: String): String =
    url.substringBefore('#').substringBefore('?').substringAfterLast('/').substringAfterLast('.', "").lowercase()

private fun hostOf(url: String): String =
    runCatching { Uri.parse(url).host }.getOrNull().orEmpty()

private fun hostKey(url: String?): String =
    hostOf(url.orEmpty()).lowercase().removePrefix("www.")

/** What kind of media an address is (null = not media). [hint] comes from where it was found. */
private fun classify(url: String, hint: String): GrabKind? {
    MEDIA_EXT[extOf(url)]?.let { return it }
    if (RE_HLS.containsMatchIn(url) || RE_DASH.containsMatchIn(url) || url.contains(".ism/manifest", ignoreCase = true)) {
        return GrabKind.STREAM
    }
    return when (hint) {
        "audio" -> GrabKind.AUDIO
        "video", "meta" -> GrabKind.VIDEO
        "stream" -> GrabKind.STREAM
        "embed" -> GrabKind.EMBED
        "blob" -> GrabKind.BLOB
        else -> null
    }
}

/** Media segments and YouTube's own range requests are not worth listing. */
private fun isNoise(url: String): Boolean {
    val lower = url.lowercase()
    if (lower.contains("googlevideo.com") || lower.contains("/videoplayback")) return true
    return RE_SEGMENT.containsMatchIn(url)
}

private fun putHit(m: LinkedHashMap<String, GrabHit>, hit: GrabHit): Boolean {
    val old = m[hit.url]
    if (old == null) { m[hit.url] = hit; return true }
    if (old.hint == "url" && hit.hint != "url") m[hit.url] = hit
    return false
}

private fun addHit(view: WebView, hit: GrabHit): Boolean {
    if (hit.hint != "blob" && isNoise(hit.url)) return false
    if (classify(hit.url, hit.hint) == null) return false
    return synchronized(gLock) {
        var added = false
        if (hit.from != "site") {
            val pm = pageHits.getOrPut(view) { LinkedHashMap() }
            if (pm.size < PAGE_CAP) added = putHit(pm, hit)
        }
        val h = viewHost[view]
        if (!h.isNullOrEmpty()) {
            val sm = siteHits.getOrPut(h) { LinkedHashMap() }
            if (sm.size < SITE_CAP && putHit(sm, hit) && hit.from == "site") added = true
            while (siteHits.size > SITE_COUNT_CAP) siteHits.remove(siteHits.keys.first())
        }
        added
    }
}

private fun addLink(view: WebView, url: String, text: String, toPage: Boolean): Boolean {
    return synchronized(gLock) {
        var added = false
        if (toPage) {
            val pm = pageLinks.getOrPut(view) { LinkedHashMap() }
            if (pm.size < LINK_PAGE_CAP && !pm.containsKey(url)) { pm[url] = text; added = true }
        }
        val h = viewHost[view]
        if (!h.isNullOrEmpty()) {
            val sm = siteLinks.getOrPut(h) { LinkedHashMap() }
            if (sm.size < LINK_SITE_CAP && !sm.containsKey(url)) { sm[url] = text; if (!toPage) added = true }
            while (siteLinks.size > SITE_COUNT_CAP) siteLinks.remove(siteLinks.keys.first())
        }
        added
    }
}

/** [[url, hint, from, page], ...] -> stores. true when something new was added. */
private fun ingestHits(view: WebView, json: String?, defaultFrom: String, defaultPage: String): Boolean {
    if (json.isNullOrEmpty()) return false
    var any = false
    try {
        val arr = JSONArray(json)
        for (i in 0 until arr.length()) {
            val p = arr.optJSONArray(i) ?: continue
            val url = p.optString(0, "")
            if (url.isEmpty() || url.length > 2000) continue
            val hint = p.optString(1, "url").ifEmpty { "url" }
            val from = p.optString(2, defaultFrom).ifEmpty { defaultFrom }
            val page = p.optString(3, "").ifEmpty { defaultPage }
            if (addHit(view, GrabHit(url.substringBefore('#'), hint, from, page))) any = true
        }
    } catch (e: Exception) { }
    return any
}

/** [[url, text], ...] -> link stores. */
private fun ingestLinks(view: WebView, arr: JSONArray?, toPage: Boolean): Boolean {
    if (arr == null) return false
    var any = false
    try {
        for (i in 0 until arr.length()) {
            val p = arr.optJSONArray(i) ?: continue
            val url = p.optString(0, "")
            if (url.isEmpty() || url.length > 2000) continue
            if (addLink(view, url, p.optString(1, ""), toPage)) any = true
        }
    } catch (e: Exception) { }
    return any
}

private fun notifyGrab() {
    val a = grabAct?.get() ?: return
    a.runOnUiThread { a.refreshGrabDot(); grabListener?.invoke() }
}

/** JavaScript bridge "W11Grab" (one per tab WebView). Called on WebView threads; only fills bounded stores. */
internal class GrabBridge(private val wv: WebView) {
    @JavascriptInterface
    fun report(json: String?) {
        val any = if (json != null && json.length < 400_000) ingestHits(wv, json, "script", "") else false
        if (any) notifyGrab()
    }

    @JavascriptInterface
    fun links(json: String?) {
        if (json == null || json.length > 600_000) return
        val any = try { ingestLinks(wv, JSONArray(json), false) } catch (e: Exception) { false }
        if (any) notifyGrab()
    }

    @JavascriptInterface
    fun progress(done: Int, total: Int) {
        crawlDone = done; crawlTotal = total
        notifyGrab()
    }

    @JavascriptInterface
    fun finished(done: Int) {
        crawlDone = done; crawlRunning = false
        notifyGrab()
    }
}

/** Call once for every tab WebView (before it loads a page): the JS bridge + the document-start hook. */
internal fun MainActivity.installGrabHooks(wv: WebView) {
    grabAct = WeakReference(this)
    try { wv.addJavascriptInterface(GrabBridge(wv), "W11Grab") } catch (e: Exception) {
        AppLog.e("MediaGrabber", "cannot add the W11Grab bridge", e)
    }
    try {
        if (WebViewFeature.isFeatureSupported(WebViewFeature.DOCUMENT_START_SCRIPT)) {
            WebViewCompat.addDocumentStartJavaScript(wv, GRAB_HOOK_JS, setOf("*"))
        }
    } catch (e: Exception) {
        AppLog.e("MediaGrabber", "cannot add the document-start script", e)
    }
}

/** Called for every sub-resource request of a page (any thread): remembers addresses that look like media. Never blocks or changes the request. */
internal fun sniffMediaRequest(view: WebView?, url: String) {
    if (view == null || !url.startsWith("http")) return
    if (classify(url, "") == null) return
    if (addHit(view, GrabHit(url.substringBefore('#'), "url", "net", ""))) notifyGrab()
}

/** A new main-frame page starts in [view] (any thread): what the old page loaded is forgotten; the site list is kept. */
internal fun clearSniffedMedia(view: WebView?, url: String?) {
    if (view == null) return
    synchronized(gLock) {
        pageHits.remove(view)
        pageLinks.remove(view)
        viewHost[view] = hostKey(url)
    }
    if (crawlView?.get() == view) crawlRunning = false
    grabAct?.get()?.runOnUiThread { grabAct?.get()?.refreshGrabDot() }
}

private fun hitsFor(view: WebView, site: Boolean): List<GrabHit> = synchronized(gLock) {
    if (site) {
        val h = viewHost[view]
        if (h.isNullOrEmpty()) pageHits[view]?.values?.toList().orEmpty() else siteHits[h]?.values?.toList().orEmpty()
    } else pageHits[view]?.values?.toList().orEmpty()
}

private fun linksFor(view: WebView, site: Boolean): List<Pair<String, String>> = synchronized(gLock) {
    val m = if (site) {
        val h = viewHost[view]
        if (h.isNullOrEmpty()) pageLinks[view] else siteLinks[h]
    } else pageLinks[view]
    m?.entries?.map { it.key to it.value }.orEmpty()
}

private fun youtubeVideoLink(url: String?) = LinkDetector.detect(url).takeIf { it.type == LinkType.VIDEO }

// ---------------------------------------------------------------------
// Background lookups: size / type of direct files, quality variants of HLS playlists
// ---------------------------------------------------------------------

private fun HttpURLConnection.prepare(cookies: String, ua: String, referer: String): HttpURLConnection {
    connectTimeout = 7000; readTimeout = 7000; instanceFollowRedirects = true
    if (ua.isNotEmpty()) setRequestProperty("User-Agent", ua)
    if (cookies.isNotEmpty()) setRequestProperty("Cookie", cookies)
    if (referer.isNotEmpty()) setRequestProperty("Referer", referer)
    return this
}

private fun doProbe(url: String, cookies: String, ua: String, referer: String): GrabProbe {
    for (attempt in 0..1) {
        var c: HttpURLConnection? = null
        try {
            c = (URL(url).openConnection() as HttpURLConnection).prepare(cookies, ua, referer)
            if (attempt == 0) c.requestMethod = "HEAD" else c.setRequestProperty("Range", "bytes=0-0")
            val code = c.responseCode
            if (code in 200..299) {
                var len = c.contentLengthLong
                val cr = c.getHeaderField("Content-Range")
                if (code == 206 && cr != null) len = cr.substringAfterLast('/').toLongOrNull() ?: -1L
                val mime = c.contentType?.substringBefore(';')?.trim()?.lowercase()
                return GrabProbe(len, mime)
            }
        } catch (e: Exception) {
        } finally {
            try { c?.disconnect() } catch (e: Exception) { }
        }
    }
    return GrabProbe(-1L, null)
}

private fun resolveUrl(base: String, ref: String): String? =
    try { URI(base).resolve(ref).toString() } catch (e: Exception) { null }

private fun readHlsVariants(url: String, cookies: String, ua: String, referer: String): List<GrabVariant> {
    var c: HttpURLConnection? = null
    try {
        c = (URL(url).openConnection() as HttpURLConnection).prepare(cookies, ua, referer)
        if (c.responseCode !in 200..299) return emptyList()
        val text = c.inputStream.use { ins ->
            val buf = ByteArray(8192)
            val out = java.io.ByteArrayOutputStream()
            var total = 0
            while (total < 400_000) {
                val n = ins.read(buf)
                if (n < 0) break
                out.write(buf, 0, n); total += n
            }
            out.toString("UTF-8")
        }
        val lines = text.lines()
        val found = ArrayList<GrabVariant>()
        var i = 0
        while (i < lines.size) {
            val ln = lines[i].trim()
            if (ln.startsWith("#EXT-X-STREAM-INF:")) {
                val bw = Regex("BANDWIDTH=(\\d+)").find(ln)?.groupValues?.get(1)?.toLongOrNull() ?: 0L
                val res = Regex("RESOLUTION=(\\d+)x(\\d+)").find(ln)
                var j = i + 1
                while (j < lines.size && (lines[j].isBlank() || lines[j].startsWith("#"))) j++
                if (j < lines.size) {
                    val u = resolveUrl(url, lines[j].trim())
                    if (u != null) {
                        val q = if (res != null) "${res.groupValues[2]}p" else "${bw / 1000} kbps"
                        found.add(GrabVariant(u, if (res != null && bw > 0) "$q · ${bw / 1000} kbps" else q, bw))
                    }
                }
                i = j
            } else if (ln.startsWith("#EXT-X-MEDIA:") && ln.contains("TYPE=AUDIO")) {
                val uri = Regex("URI=\"([^\"]+)\"").find(ln)?.groupValues?.get(1)
                val name = Regex("NAME=\"([^\"]*)\"").find(ln)?.groupValues?.get(1).orEmpty()
                val u = uri?.let { resolveUrl(url, it) }
                if (u != null) found.add(GrabVariant(u, "Audio" + if (name.isNotEmpty()) " · $name" else "", 0L))
            }
            i++
        }
        return found.distinctBy { it.url }.sortedByDescending { it.bandwidth }.take(12)
    } catch (e: Exception) {
        return emptyList()
    } finally {
        try { c?.disconnect() } catch (e: Exception) { }
    }
}

// ---------------------------------------------------------------------
// Toolbar button
// ---------------------------------------------------------------------

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

/** Shows the blue dot while the open page has video / audio / a stream to grab. */
internal fun MainActivity.refreshGrabDot() {
    val dot = grabDot ?: return
    val wv = webTabs.getOrNull(currentTabIndex)?.webView
    var has = false
    if (wv != null) {
        has = hitsFor(wv, false).any {
            val k = classify(it.url, it.hint)
            k == GrabKind.VIDEO || k == GrabKind.AUDIO || k == GrabKind.STREAM
        } || youtubeVideoLink(runCatching { wv.url }.getOrNull()) != null
    }
    dot.visibility = if (has) View.VISIBLE else View.GONE
}

// ---------------------------------------------------------------------
// The dialog
// ---------------------------------------------------------------------

internal fun MainActivity.showMediaGrabber() {
    val tab = webTabs.getOrNull(currentTabIndex) ?: return
    val wv = tab.webView
    val pageUrl = runCatching { wv.url }.getOrNull().orEmpty()
    val pageTitle = tab.title.takeIf { it.isNotBlank() && it != "Loading…" } ?: "video"
    val pageHost = hostKey(pageUrl)
    synchronized(gLock) { if (viewHost[wv].isNullOrEmpty() && pageHost.isNotEmpty()) viewHost[wv] = pageHost }
    if (crawlRunning && crawlView?.get() != wv) crawlRunning = false

    val ytItems = ArrayList<GrabItem>()
    var scanPending = 0
    var ytLoading = false
    var ytError = false
    var scope = 0                 // 0 = this page, 1 = whole site
    var cat = 0                   // 0 all, 1 video, 2 audio, 3 streams, 4 embeds, 5 links
    var query = ""
    var visibleUrls: List<String> = emptyList()
    var dialogRef: W11Dialog? = null
    val ui = Handler(Looper.getMainLooper())
    var renderRef: (() -> Unit)? = null
    var scanRef: (() -> Unit)? = null
    val renderTask = Runnable { if (dialogRef?.isShowing == true) renderRef?.invoke() }
    fun requestRender() { ui.removeCallbacks(renderTask); ui.postDelayed(renderTask, 120) }

    fun cookiesFor(url: String) = CookieManager.getInstance().getCookie(url) ?: ""
    val ua = runCatching { wv.settings.userAgentString }.getOrDefault("")

    fun toast(t: String) = Toast.makeText(this, t, Toast.LENGTH_SHORT).show()

    fun copy(text: String, what: String) {
        try {
            (getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager)
                .setPrimaryClip(ClipData.newPlainText("media", text))
            toast(what)
        } catch (e: Exception) { toast("Cannot copy") }
    }

    fun label(text: String, size: Float, color: Int, bold: Boolean = false) = TextView(this).apply {
        this.text = text; textSize = size; setTextColor(color)
        if (bold) typeface = Typeface.DEFAULT_BOLD
    }

    fun pill(text: String, filled: Boolean, small: Boolean = false, onClick: () -> Unit) = TextView(this).apply {
        this.text = text
        textSize = if (small) 12f else 13f
        typeface = Typeface.DEFAULT_BOLD
        gravity = Gravity.CENTER
        setTextColor(if (filled) Color.BLACK else Color.WHITE)
        if (small) setPadding(dp(12), dp(6), dp(12), dp(6)) else setPadding(dp(16), dp(8), dp(16), dp(8))
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
        val cookies = cookiesFor(g.url)
        val referer = g.page.ifEmpty { pageUrl }
        val size = probes[g.url]?.size ?: -1L
        showDownloadDialog(if (size > 0) getSize(size) else "Unknown size", name) { fileName ->
            enqueueDownload(g.url, fileName, g.mime, cookies, ua, referer, size)
        }
    }

    fun openInTab(url: String) {
        dialogRef?.dismiss()
        addNewTab(url, switch = true)
    }

    // Seal part 6: hand an address to the built-in Downloader (:seal, yt-dlp). A YouTube row goes by its watch page (yt-dlp picks the formats itself).
    fun sealUrlOf(g: GrabItem): String = g.youtubePage ?: g.url
    fun toDownloader(url: String) {
        if (!isSealUrl(url)) { toast("$SEAL_NAME needs an http or https link"); return }
        dialogRef?.dismiss()
        openSealWithUrl(url)
    }

    // ---- a raw find -> a row ----
    fun fileNameFor(url: String, ext: String): String {
        val seg = runCatching { Uri.decode(Uri.parse(url).lastPathSegment.orEmpty()) }.getOrDefault("")
        return if (seg.length > ext.length + 1 && seg.endsWith(".$ext", ignoreCase = true)) seg
        else "$pageTitle.$ext"
    }

    fun toItem(h: GrabHit): GrabItem? {
        val kind = classify(h.url, h.hint) ?: return null
        val ext = extOf(h.url)
        val host = hostOf(h.url).ifEmpty { h.url }
        return when (kind) {
            GrabKind.STREAM -> {
                val dash = RE_DASH.containsMatchIn(h.url)
                val smooth = h.url.contains(".ism/manifest", ignoreCase = true)
                GrabItem(
                    kind, "Stream · " + (if (dash) "DASH" else if (smooth) "Smooth" else "HLS"), host, h.url, null,
                    if (dash) "application/dash+xml" else "application/vnd.apple.mpegurl", from = h.from, page = h.page
                )
            }
            GrabKind.EMBED -> {
                val yt = RE_YT_EMBED.find(h.url)?.groupValues?.get(1)?.let { "https://www.youtube.com/watch?v=$it" }
                GrabItem(
                    kind, if (yt != null) "Embedded YouTube player" else "Embedded player", host, h.url, null,
                    "text/html", youtubePage = yt, from = h.from, page = h.page
                )
            }
            GrabKind.BLOB -> GrabItem(
                kind, "Blob media (inside the page)",
                "Not a real address: the page builds it itself. Look for a Stream or Video row, or play it on the page.",
                h.url, null, "", from = h.from, page = h.page
            )
            GrabKind.VIDEO, GrabKind.AUDIO -> {
                val fext = if (MEDIA_EXT[ext] == kind) ext else if (kind == GrabKind.AUDIO) "mp3" else "mp4"
                GrabItem(
                    kind, (if (kind == GrabKind.AUDIO) "Audio · " else "Video · ") + fext.uppercase(),
                    host, h.url, sanitizeFileName(fileNameFor(h.url, fext)), DlEngine.guessMime("x.$fext"),
                    from = h.from, page = h.page
                )
            }
        }
    }

    fun fromName(f: String) = when (f) {
        "net" -> "network"
        "fetch", "xhr", "dom", "mse", "blob", "script" -> "script"
        "site" -> "site scan"
        "variant" -> "quality"
        else -> "page"
    }

    // ---- views ----
    val list = LinearLayout(this).apply { orientation = LinearLayout.VERTICAL }
    val chipRow = LinearLayout(this).apply { orientation = LinearLayout.HORIZONTAL }
    val statusView = label("", 11f, Color.parseColor("#8A8A8A")).apply { setPadding(0, dp(4), 0, dp(2)) }
    val scopeRow = LinearLayout(this).apply { orientation = LinearLayout.HORIZONTAL }
    val actionRow = LinearLayout(this).apply { orientation = LinearLayout.HORIZONTAL; setPadding(0, dp(6), 0, 0) }
    val filterBox = EditText(this).apply {
        hint = "Filter…"; textSize = 13f; setSingleLine(true)
        addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, st: Int, c: Int, a: Int) {}
            override fun onTextChanged(s: CharSequence?, st: Int, b: Int, c: Int) {}
            override fun afterTextChanged(s: Editable?) { query = s?.toString().orEmpty().trim().lowercase(); requestRender() }
        })
    }.glassStyle()

    fun rowBox(): LinearLayout = LinearLayout(this).apply {
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
    }

    // Seal part 6: a row can now hold four pills (Play, Download, Downloader, Copy): it scrolls sideways on a narrow phone instead of cutting the last one off
    fun pillRow(vararg pills: View): View = HorizontalScrollView(this).apply {
        isHorizontalScrollBarEnabled = false
        overScrollMode = View.OVER_SCROLL_NEVER
        setPadding(0, dp(8), 0, 0)
        addView(LinearLayout(context).apply {
            orientation = LinearLayout.HORIZONTAL
            pills.forEachIndexed { i, p ->
                addView(p, LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT
                ).apply { if (i > 0) marginStart = dp(8) })
            }
        })
    }

    fun detailOf(g: GrabItem): String {
        val parts = ArrayList<String>()
        val pr = probes[g.url]
        if (pr != null) {
            if (pr.size > 0) parts.add(getSize(pr.size))
            if (!pr.mime.isNullOrEmpty()) parts.add(pr.mime)
        }
        parts.add(g.detail)
        if (g.from.isNotEmpty()) parts.add(fromName(g.from))
        return parts.joinToString(" · ")
    }

    fun row(g: GrabItem): View = rowBox().apply {
        addView(label(g.label, 14f, Color.WHITE, bold = true))
        addView(label(detailOf(g), 11f, Color.parseColor("#9D9D9D")).apply {
            maxLines = if (g.kind == GrabKind.BLOB) 3 else 2; ellipsize = TextUtils.TruncateAt.END
        })
        val pills = ArrayList<View>()
        when (g.kind) {
            GrabKind.BLOB -> { }
            GrabKind.EMBED -> {
                if (g.youtubePage != null) pills.add(pill("Play", filled = true, small = true) { play(g) })
                pills.add(pill("Open", filled = g.youtubePage == null, small = true) { openInTab(g.url) })
                if (isSealUrl(sealUrlOf(g))) pills.add(pill(SEAL_NAME, filled = false, small = true) { toDownloader(sealUrlOf(g)) })
                pills.add(pill("Copy", filled = false, small = true) { copy(g.url, "Link copied") })
            }
            else -> {
                pills.add(pill("Play", filled = false, small = true) { play(g) })
                if (g.fileName != null) pills.add(pill("Download", filled = true, small = true) { download(g) })
                // streams (.m3u8 / .mpd) cannot be saved by the built-in download; yt-dlp can, so they get the Downloader pill too
                if (isSealUrl(sealUrlOf(g))) pills.add(pill(SEAL_NAME, filled = g.fileName == null, small = true) { toDownloader(sealUrlOf(g)) })
                pills.add(pill("Copy", filled = false, small = true) { copy(g.url, "Link copied") })
            }
        }
        if (pills.isNotEmpty()) addView(pillRow(*pills.toTypedArray()))
    }

    fun linkRow(url: String, text: String): View = rowBox().apply {
        addView(label(text.ifEmpty { url }, 13f, Color.WHITE, bold = true).apply {
            maxLines = 1; ellipsize = TextUtils.TruncateAt.END
        })
        if (text.isNotEmpty()) addView(label(url, 11f, Color.parseColor("#9D9D9D")).apply {
            maxLines = 1; ellipsize = TextUtils.TruncateAt.END
        })
        addView(pillRow(
            pill("Open", filled = true, small = true) { openInTab(url) },
            pill(SEAL_NAME, filled = false, small = true) { toDownloader(url) },
            pill("Copy", filled = false, small = true) { copy(url, "Link copied") }
        ))
    }

    // ---- the list the user sees ----
    fun buildItems(): List<GrabItem> {
        val out = LinkedHashMap<String, GrabItem>()
        for (g in ytItems) out.putIfAbsent(g.url, g)
        val site = scope == 1
        for (h in hitsFor(wv, site)) {
            val g = toItem(h) ?: continue
            val pr = probes[g.url]
            if (pr?.mime?.startsWith("text/") == true && (g.kind == GrabKind.VIDEO || g.kind == GrabKind.AUDIO)) continue
            if (out.putIfAbsent(g.url, g) == null && g.kind == GrabKind.STREAM && RE_HLS.containsMatchIn(g.url)) {
                hlsVariants[g.url]?.forEach { v ->
                    out.putIfAbsent(v.url, GrabItem(
                        GrabKind.STREAM, "Stream · ${v.label}", "HLS quality · ${hostOf(v.url)}", v.url, null,
                        "application/vnd.apple.mpegurl", from = "variant", page = g.page
                    ))
                }
            }
        }
        return out.values.toList()
    }

    fun launchLookups(items: List<GrabItem>) {
        for (g in items.take(ROW_CAP)) {
            val referer = g.page.ifEmpty { pageUrl }
            if ((g.kind == GrabKind.VIDEO || g.kind == GrabKind.AUDIO) && g.youtubePage == null &&
                !probes.containsKey(g.url) && probing.add(g.url)
            ) {
                val cookies = cookiesFor(g.url)
                grabExec.execute {
                    probes[g.url] = doProbe(g.url, cookies, ua, referer)
                    probing.remove(g.url)
                    runOnUiThread { requestRender() }
                }
            } else if (g.kind == GrabKind.STREAM && RE_HLS.containsMatchIn(g.url) && g.from != "variant" &&
                !hlsVariants.containsKey(g.url) && hlsFetching.add(g.url)
            ) {
                val cookies = cookiesFor(g.url)
                grabExec.execute {
                    hlsVariants[g.url] = readHlsVariants(g.url, cookies, ua, referer)
                    hlsFetching.remove(g.url)
                    runOnUiThread { requestRender() }
                }
            }
        }
    }

    fun styleChip(v: TextView, selected: Boolean) {
        v.setTextColor(if (selected) Color.BLACK else Color.WHITE)
        v.background = GradientDrawable().apply {
            cornerRadius = dp(16).toFloat()
            if (selected) setColor(Color.parseColor("#4CC2FF"))
            else { setColor(Color.parseColor("#333333")); setStroke(1, Color.parseColor("#4A4A4A")) }
        }
    }

    fun render() {
        val allItems = buildItems()
        val links = linksFor(wv, scope == 1)
        val nVideo = allItems.count { it.kind == GrabKind.VIDEO }
        val nAudio = allItems.count { it.kind == GrabKind.AUDIO }
        val nStream = allItems.count { it.kind == GrabKind.STREAM }
        val nEmbed = allItems.count { it.kind == GrabKind.EMBED || it.kind == GrabKind.BLOB }

        // scope + chips
        scopeRow.removeAllViews()
        scopeRow.addView(pill("This page", scope == 0, small = true) { scope = 0; requestRender() })
        scopeRow.addView(pill("Whole site", scope == 1, small = true) { scope = 1; requestRender() },
            LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply { marginStart = dp(8) })
        chipRow.removeAllViews()
        val names = listOf(
            "All ${allItems.size}", "Video $nVideo", "Audio $nAudio", "Streams $nStream",
            "Embeds $nEmbed", "Links ${links.size}"
        )
        names.forEachIndexed { i, n ->
            val chip = TextView(this).apply {
                text = n; textSize = 12f; typeface = Typeface.DEFAULT_BOLD
                gravity = Gravity.CENTER
                setPadding(dp(12), dp(6), dp(12), dp(6))
                isClickable = true
                setOnClickListener { cat = i; requestRender() }
            }
            styleChip(chip, cat == i)
            chipRow.addView(chip, LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply { if (i > 0) marginStart = dp(6) })
        }

        // action row
        actionRow.removeAllViews()
        actionRow.addView(pill("Rescan", filled = false, small = true) { scanRef?.invoke() })
        val crawling = crawlRunning && crawlView?.get() == wv
        actionRow.addView(
            pill(if (crawling) "Stop scan" else "Scan site", filled = !crawling, small = true) {
                if (crawlRunning && crawlView?.get() == wv) {
                    wv.evaluateJavascript("window.__w11crawl&&(window.__w11crawl.stop=true)", null)
                } else {
                    crawlView = WeakReference(wv)
                    crawlRunning = true; crawlDone = 0; crawlTotal = 0
                    scope = 1
                    wv.evaluateJavascript(CRAWL_JS.replace("__LIMIT__", CRAWL_PAGES.toString()), null)
                    toast("Scanning the site…")
                }
                requestRender()
            },
            LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply { marginStart = dp(8) }
        )
        // Seal part 6: the open page itself (a video page, a playlist, a channel ...) to the Downloader
        if (isSealUrl(pageUrl)) actionRow.addView(pill("Page → $SEAL_NAME", filled = false, small = true) { toDownloader(pageUrl) },
            LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply { marginStart = dp(8) })
        actionRow.addView(pill("Copy all", filled = false, small = true) {
            if (visibleUrls.isEmpty()) toast("Nothing to copy")
            else copy(visibleUrls.joinToString("\n"), "${visibleUrls.size} links copied")
        }, LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT
        ).apply { marginStart = dp(8) })

        // status
        statusView.text = when {
            crawling -> "Scanning the site… $crawlDone / ${crawlTotal.coerceAtLeast(crawlDone)} pages"
            crawlView?.get() == wv && crawlDone > 0 -> "Site scan finished: $crawlDone pages read"
            scope == 1 -> "Whole site: everything found on $pageHost in this session. Use “Scan site” to read more pages."
            else -> "This page: ${allItems.size} media, ${links.size} links"
        }

        // list
        list.removeAllViews()
        if (cat == 5) {
            val shown = links.filter { query.isEmpty() || it.first.lowercase().contains(query) || it.second.lowercase().contains(query) }
            visibleUrls = shown.map { it.first }
            for ((u, t) in shown.take(ROW_CAP)) list.addView(linkRow(u, t))
            if (shown.isEmpty()) list.addView(label(
                if (links.isEmpty()) "No links found yet. Tap Rescan." else "No link matches the filter.",
                13f, Color.parseColor("#B0B0B0")
            ))
            if (shown.size > ROW_CAP) list.addView(label(
                "Showing the first $ROW_CAP of ${shown.size}. Use the filter, or “Copy all” for the full list.",
                11f, Color.parseColor("#8A8A8A")
            ).apply { setPadding(0, dp(4), 0, 0) })
        } else {
            val byCat = allItems.filter {
                when (cat) {
                    1 -> it.kind == GrabKind.VIDEO
                    2 -> it.kind == GrabKind.AUDIO
                    3 -> it.kind == GrabKind.STREAM
                    4 -> it.kind == GrabKind.EMBED || it.kind == GrabKind.BLOB
                    else -> true
                }
            }
            val shown = byCat.filter {
                query.isEmpty() || it.url.lowercase().contains(query) || it.label.lowercase().contains(query) ||
                    (it.fileName ?: "").lowercase().contains(query)
            }
            visibleUrls = shown.filter { it.kind != GrabKind.BLOB }.map { it.url }
            for (g in shown.take(ROW_CAP)) list.addView(row(g))
            launchLookups(shown)
            if (shown.isEmpty()) {
                list.addView(label(
                    when {
                        scanPending > 0 || ytLoading -> "Looking for media…"
                        ytError && allItems.isEmpty() -> "Could not read this YouTube video. Check the connection and try again."
                        allItems.isNotEmpty() -> "Nothing in this filter."
                        else -> "No media found yet. Start the video on the page (or tap Scan site), then tap Rescan."
                    }, 13f, Color.parseColor("#B0B0B0")
                ))
            }
            if (shown.size > ROW_CAP) list.addView(label(
                "Showing the first $ROW_CAP of ${shown.size}. Use the filter, or “Copy all” for the full list.",
                11f, Color.parseColor("#8A8A8A")
            ).apply { setPadding(0, dp(4), 0, 0) })
            if (ytItems.any { it.kind == GrabKind.AUDIO }) {
                list.addView(label(
                    "Audio is saved in its original format (M4A); it is not converted to MP3.",
                    11f, Color.parseColor("#8A8A8A")
                ).apply { setPadding(0, dp(4), 0, 0) })
            }
            if (shown.any { it.kind == GrabKind.STREAM }) {
                list.addView(label(
                    "Streams (live / HLS / DASH) can be played or copied, but not saved as one file.",
                    11f, Color.parseColor("#8A8A8A")
                ).apply { setPadding(0, dp(4), 0, 0) })
            }
        }
    }
    renderRef = { render() }

    // ---- a page scan ----
    fun runScan() {
        scanPending++
        requestRender()
        wv.evaluateJavascript(SCAN_JS) { value ->
            scanPending--
            runCatching {
                val text = JSONTokener(value ?: "null").nextValue() as? String ?: return@runCatching
                val obj = JSONObject(text)
                val m = obj.optJSONArray("m")
                if (m != null) ingestHits(wv, m.toString(), "page", pageUrl)
                ingestLinks(wv, obj.optJSONArray("l"), true)
            }
            refreshGrabDot()
            requestRender()
        }
    }

    scanRef = { runScan() }

    // ---- a YouTube watch page ----
    fun addYoutube(d: StreamDetails, pageLink: String) {
        if (d.isLive) {
            ytItems.add(GrabItem(
                GrabKind.STREAM, "Live stream", "Plays in the YouTube player", d.hlsUrl ?: pageLink, null,
                "application/vnd.apple.mpegurl", youtubePage = pageLink, from = "page", page = pageLink
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
                if (webm) "video/webm" else "video/mp4", youtubePage = pageLink, from = "page", page = pageLink
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
                if (m4a) "audio/mp4" else "audio/webm", from = "page", page = pageLink
            ))
        }
    }

    // ---- build and show ----
    val header = LinearLayout(this).apply {
        orientation = LinearLayout.VERTICAL
        setPadding(dp(16), dp(4), dp(16), 0)
        addView(scopeRow)
        addView(HorizontalScrollView(context).apply {
            isHorizontalScrollBarEnabled = false
            setPadding(0, dp(8), 0, 0)
            addView(chipRow)
        })
        addView(filterBox, LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT
        ).apply { topMargin = dp(8) })
        addView(HorizontalScrollView(context).apply { // four pills with "Page → Downloader": scrolls sideways when narrow
            isHorizontalScrollBarEnabled = false
            overScrollMode = View.OVER_SCROLL_NEVER
            addView(actionRow)
        })
        addView(statusView)
    }
    val scroll = ScrollView(this).apply {
        setPadding(dp(16), dp(4), dp(16), dp(8))
        addView(list)
    }
    val body = LinearLayout(this).apply {
        orientation = LinearLayout.VERTICAL
        addView(header)
        addView(scroll, LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT, (resources.displayMetrics.heightPixels * 0.42f).toInt()
        ))
    }

    render()
    dialogRef = W11Dialog.Builder(this)
        .setTitle("Media Grabber")
        .setIcon(R.drawable.ic_w_download)
        .setView(body)
        .setNegativeButton("Close", null)
        .show()
    grabListener = { requestRender() }
    dialogRef?.setOnDismissListener { grabListener = null; ui.removeCallbacks(renderTask) }

    // 1) everything the page shows now (also the first look at addresses loaded before the hook existed)
    runScan()

    // 2) a YouTube watch page: read its streams
    val yt = youtubeVideoLink(pageUrl)
    val ytUrl = yt?.url
    if (ytUrl != null) {
        ytLoading = true
        YtRepository.async({ YtRepository.stream(ytUrl) }) { result ->
            ytLoading = false
            result.onSuccess { addYoutube(it, ytUrl) }.onFailure { ytError = true }
            requestRender()
        }
    }
}

package com.srizwan.win11

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.PixelFormat
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.RippleDrawable
import android.net.Uri
import android.os.Build
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.os.SystemClock
import android.provider.Settings
import android.text.TextUtils
import android.view.Gravity
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.view.ViewOutlineProvider
import android.view.WindowManager
import android.webkit.CookieManager
import android.webkit.JsPromptResult
import android.webkit.JsResult
import android.webkit.WebChromeClient
import android.webkit.WebResourceRequest
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat

// =====================================================================
// BROWSER POPUPS (Step 1)
//
// A page that calls window.open() / target="_blank" (Google sign-in, "Download" buttons that
// open an ad site, payment pages, ...) used to load into the SAME tab and overwrite the page the
// user was on. Now the request is answered with a separate WebView that is shown in a custom
// dialog on top of the browser area, so the page underneath stays untouched.
//
//  * The popup WebView is handed back through WebViewTransport, so window.opener, postMessage and
//    window.close() keep working (needed by OAuth / "Sign in with Google" flows).
//  * Popups opened without a user gesture are blocked, and a page cannot spam popups.
//  * A popup that was opened only to start a download closes itself when the download starts.
//  * Popups belong to the tab that opened them: they are hidden when another tab is selected
//    and are closed together with their tab.
//
// Step 2 — a popup has three sizes (PopupMode) and can become a normal tab:
//  * DIALOG  the card over the browser area
//  * FULL    the same popup filling the whole browser area (maximize / restore)
//  * FLOAT   minimized to a small window that can be dragged and resized (corner grip) and keeps playing
//            audio / video in the background (foreground service PopupPlaybackService).
//            With "Display over other apps" granted it is a real overlay window (TYPE_APPLICATION_OVERLAY)
//            that stays on screen over other apps and the home screen; without the permission it floats
//            above every screen of this app only (the user is asked once, and a window that was already
//            floating inside the app moves to the overlay as soon as the permission is there)
//  * "Open as tab" moves the popup's WebView into a normal browser tab (page and login are kept)
// =====================================================================

private const val MAX_POPUPS_PER_TAB = 3
private const val BURST_WINDOW_MS = 3000L
private const val BURST_LIMIT = 3
private var playbackServiceOn = false
private var overlayAsked = false

/** True when this app may draw over other apps ("Display over other apps"). */
internal fun Context.canDrawOverApps(): Boolean =
    Build.VERSION.SDK_INT < Build.VERSION_CODES.M || Settings.canDrawOverlays(this)

/** Asked once per run, the first time a popup is minimized without the permission. The window floats inside the app meanwhile. */
private fun MainActivity.askOverlayPermissionOnce() {
    if (overlayAsked || canDrawOverApps()) return
    overlayAsked = true
    W11Dialog.Builder(this).setTitle("Float over other apps?")
        .setMessage("To keep the minimized pop-up on screen when you switch to another app or the home screen, allow \"Display over other apps\" for this app. Until then it floats inside this app only.")
        .setPositiveButton("Allow") { _, _ ->
            try { startActivity(Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION, Uri.parse("package:$packageName"))) }
            catch (e: Exception) { Toast.makeText(this, "Open Settings > Apps > Display over other apps", Toast.LENGTH_LONG).show() }
        }
        .setNegativeButton("Not now", null).show()
}

internal enum class PopupMode { DIALOG, FULL, FLOAT }

/** Pages pause video when they think they are hidden; a floating popup is always "visible" to them. */
internal const val KEEP_ALIVE_JS = """
(function(){
  if (window.__popupKeepAlive) return; window.__popupKeepAlive = true;
  try {
    Object.defineProperty(document, 'hidden', {get: function(){ return false; }, configurable: true});
    Object.defineProperty(document, 'visibilityState', {get: function(){ return 'visible'; }, configurable: true});
  } catch (e) {}
  document.addEventListener('visibilitychange', function(e){ e.stopImmediatePropagation(); }, true);
})();
"""
private val popupOpenTimes = ArrayList<Long>()
private var lastBlockedToast = 0L

/** The default WebView user agent contains "; wv" and "Version/x.y", which Google sign-in rejects
 *  ("disallowed_useragent"). Removing them makes the WebView look like Chrome Mobile. */
internal fun webViewFriendlyUa(ua: String): String =
    ua.replace("; wv)", ")").replace(Regex("Version/\\d+(\\.\\d+)? "), "")

/** Small diagonal grip drawn in the corner of a floating popup; dragging it resizes the window. */
private class GripView(ctx: Context) : View(ctx) {
    private val d = resources.displayMetrics.density
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.parseColor("#CCFFFFFF"); strokeWidth = 1.6f * d; strokeCap = Paint.Cap.ROUND
    }
    override fun onDraw(c: Canvas) {
        val w = width.toFloat(); val h = height.toFloat(); val m = 7 * d
        for (i in 1..3) c.drawLine(w - m - i * 4 * d, h - m, w - m, h - m - i * 4 * d, paint)
    }
}

/**
 * One popup window. DIALOG / FULL: scrim + card with a title bar (title, host, minimize, maximize / restore,
 * open as tab, close) and the WebView. FLOAT: a small draggable, resizable window above the whole app.
 */
internal class BrowserPopup(
    private val act: MainActivity,
    val owner: WebTab,
    val webView: WebView
) {
    val root = FrameLayout(act)
    private val card = LinearLayout(act)
    private val cardBg = GradientDrawable()
    private val titleView = TextView(act)
    private val hostView = TextView(act)
    private val progress = ProgressBar(act, null, android.R.attr.progressBarStyleHorizontal)
    private val maxBtn = TextView(act)

    // floating window (built on first minimize)
    private var floatView: FrameLayout? = null
    private var floatBody: FrameLayout? = null
    private var floatTitle: TextView? = null
    private var floatPlaced = false
    private var floatW = 0
    private var floatH = 0
    private var floatX = 0
    private var floatY = 0
    private var overlayLp: WindowManager.LayoutParams? = null

    /** true while the floating window is a system overlay window (over other apps), false when it sits inside the app */
    var floatInOverlay = false
        private set

    var mode = PopupMode.DIALOG
        private set

    /** true once a real page (not about:blank) has started loading */
    var navigated = false
    private var released = false

    private fun btn(res: Int, sizeDp: Int, boxDp: Int, desc: String, onClick: () -> Unit): TextView =
        TextView(act).apply {
            iconOnly(res, sizeDp, Color.WHITE)
            layoutParams = LinearLayout.LayoutParams(act.dp(boxDp), act.dp(boxDp))
            isClickable = true
            background = RippleDrawable(
                ColorStateList.valueOf(Color.parseColor("#33FFFFFF")), null,
                GradientDrawable().apply { shape = GradientDrawable.OVAL; setColor(Color.WHITE) }
            )
            contentDescription = desc
            setOnClickListener { onClick() }
        }

    init {
        root.setBackgroundColor(Color.parseColor("#99000000"))
        root.isClickable = true      // swallow touches so the page below cannot be tapped through
        root.isFocusable = true

        card.orientation = LinearLayout.VERTICAL
        cardBg.setColor(Color.parseColor("#FF1E2230"))
        cardBg.cornerRadius = act.dp(14).toFloat()
        cardBg.setStroke(act.dp(1), Color.parseColor("#40FFFFFF"))
        card.background = cardBg
        card.outlineProvider = ViewOutlineProvider.BACKGROUND
        card.clipToOutline = true
        card.elevation = act.dp(12).toFloat()

        // ── title bar ──
        val bar = LinearLayout(act).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER_VERTICAL
            setPadding(act.dp(14), 0, act.dp(2), 0)
        }
        val texts = LinearLayout(act).apply {
            orientation = LinearLayout.VERTICAL
            layoutParams = LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1f)
        }
        titleView.apply {
            text = "Loading…"
            textSize = 13.5f
            setTextColor(Color.WHITE)
            setSingleLine(true)
            ellipsize = TextUtils.TruncateAt.END
        }
        hostView.apply {
            textSize = 11f
            setTextColor(Color.parseColor("#B3FFFFFF"))
            setSingleLine(true)
            ellipsize = TextUtils.TruncateAt.END
        }
        texts.addView(titleView)
        texts.addView(hostView)
        bar.addView(texts)
        bar.addView(btn(R.drawable.ic_popup_minimize, 18, 40, "Minimize to a floating window") { setMode(PopupMode.FLOAT) })
        maxBtn.apply {
            iconOnly(R.drawable.ic_popup_maximize, 18, Color.WHITE)
            layoutParams = LinearLayout.LayoutParams(act.dp(40), act.dp(40))
            isClickable = true
            background = RippleDrawable(
                ColorStateList.valueOf(Color.parseColor("#33FFFFFF")), null,
                GradientDrawable().apply { shape = GradientDrawable.OVAL; setColor(Color.WHITE) }
            )
            contentDescription = "Full size / restore"
            setOnClickListener {
                setMode(if (mode == PopupMode.FULL) PopupMode.DIALOG else PopupMode.FULL)
            }
        }
        bar.addView(maxBtn)
        bar.addView(btn(R.drawable.ic_popup_tab, 18, 40, "Open as a tab") { act.expandPopupToTab(this) })
        bar.addView(btn(R.drawable.ic_qs_close, 16, 40, "Close pop-up") { act.closePopup(this) })
        card.addView(bar, LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, act.dp(52)))

        progress.apply {
            max = 100
            progressTintList = ColorStateList.valueOf(Color.parseColor("#4CC2FF"))
            progressBackgroundTintList = ColorStateList.valueOf(Color.TRANSPARENT)
            visibility = View.INVISIBLE
        }
        card.addView(progress, LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, act.dp(2)))

        webView.setBackgroundColor(Color.WHITE)
        card.addView(webView, LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0, 1f))

        root.addView(card, FrameLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT
        ).apply {
            setMargins(act.dp(10), act.dp(28), act.dp(10), act.dp(20))
        })
    }

    // ── page info ──

    /** Shows the address of the page, in colour: green = https, orange = not secure. Helps spot a fake login window. */
    fun onUrl(url: String?) {
        if (url.isNullOrEmpty() || url == "about:blank") return
        val uri = try { Uri.parse(url) } catch (e: Exception) { null }
        val host = uri?.host ?: url
        val secure = uri?.scheme.equals("https", ignoreCase = true)
        hostView.text = if (secure) host else "Not secure · $host"
        hostView.setTextColor(Color.parseColor(if (secure) "#6CCB5F" else "#FFB74D"))
    }

    fun onTitle(title: String?) {
        if (title.isNullOrBlank()) return
        titleView.text = title
        floatTitle?.text = title
    }

    fun onProgress(p: Int) {
        progress.progress = p
        progress.visibility = if (p in 1..99) View.VISIBLE else View.INVISIBLE
    }

    // ── modes ──

    /** The view that is on screen for the current mode (used for the fade animations). */
    private fun shownView(): View = if (mode == PopupMode.FLOAT) (floatView ?: root) else root

    /** Switches between DIALOG, FULL and FLOAT. The same WebView is moved, so the page keeps running. */
    fun setMode(m: PopupMode) {
        if (m == mode || released) return
        val old = mode
        mode = m
        if (m == PopupMode.FLOAT) {
            moveWebViewTo(ensureFloat().second)
            (root.parent as? ViewGroup)?.removeView(root)
            attachFloat()
            webView.evaluateJavascript(KEEP_ALIVE_JS, null)
            if (!floatInOverlay) act.askOverlayPermissionOnce()
        } else {
            if (old == PopupMode.FLOAT) {
                removeFloatView()
                moveWebViewTo(card)
                act.webContainer.addView(root, FrameLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT))
                root.visibility = View.VISIBLE
                animateIn()
            }
            applyDialogLook()
        }
        act.updatePopupService()
    }

    private fun moveWebViewTo(target: ViewGroup) {
        (webView.parent as? ViewGroup)?.removeView(webView)
        target.addView(webView, if (target is LinearLayout)
            LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0, 1f)
        else FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT))
    }

    private fun applyDialogLook() {
        val full = mode == PopupMode.FULL
        val lp = card.layoutParams as FrameLayout.LayoutParams
        if (full) lp.setMargins(0, 0, 0, 0) else lp.setMargins(act.dp(10), act.dp(28), act.dp(10), act.dp(20))
        card.layoutParams = lp
        cardBg.cornerRadius = if (full) 0f else act.dp(14).toFloat()
        maxBtn.iconOnly(if (full) R.drawable.ic_popup_restore else R.drawable.ic_popup_maximize, 18, Color.WHITE)
    }

    // ── floating window ──

    private fun floatLayer(): ViewGroup = act.window.decorView.findViewById(android.R.id.content)

    /** Builds the floating window once: a header (drag area + restore / open as tab / close), the body and a resize grip. */
    private fun ensureFloat(): Pair<FrameLayout, FrameLayout> {
        val existing = floatView
        val body0 = floatBody
        if (existing != null && body0 != null) return existing to body0

        val fv = FrameLayout(act).apply {
            background = GradientDrawable().apply {
                setColor(Color.parseColor("#FF1E2230"))
                cornerRadius = act.dp(10).toFloat()
                setStroke(act.dp(1), Color.parseColor("#55FFFFFF"))
            }
            outlineProvider = ViewOutlineProvider.BACKGROUND
            clipToOutline = true
            elevation = act.dp(16).toFloat()
        }
        val column = LinearLayout(act).apply { orientation = LinearLayout.VERTICAL }

        val header = LinearLayout(act).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER_VERTICAL
            setPadding(act.dp(8), 0, act.dp(2), 0)
            setBackgroundColor(Color.parseColor("#FF2A2F40"))
        }
        val t = TextView(act).apply {
            text = titleView.text
            textSize = 11f
            setTextColor(Color.WHITE)
            setSingleLine(true)
            ellipsize = TextUtils.TruncateAt.END
            layoutParams = LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1f)
        }
        header.addView(t)
        header.addView(btn(R.drawable.ic_popup_maximize, 14, 30, "Restore pop-up") { act.restorePopup(this@BrowserPopup) })
        header.addView(btn(R.drawable.ic_popup_tab, 14, 30, "Open as a tab") { act.expandPopupToTab(this@BrowserPopup) })
        header.addView(btn(R.drawable.ic_qs_close, 12, 30, "Close pop-up") { act.closePopup(this@BrowserPopup) })
        column.addView(header, LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, act.dp(30)))

        val body = FrameLayout(act)
        column.addView(body, LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0, 1f))
        fv.addView(column, FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT))

        // resize grip (bottom-right corner)
        val grip = GripView(act)
        fv.addView(grip, FrameLayout.LayoutParams(act.dp(34), act.dp(34), Gravity.BOTTOM or Gravity.END))
        var sx = 0f; var sy = 0f; var sw = 0; var sh = 0
        grip.setOnTouchListener { _, ev ->
            when (ev.actionMasked) {
                MotionEvent.ACTION_DOWN -> {
                    sx = ev.rawX; sy = ev.rawY; sw = fv.width; sh = fv.height
                    fv.parent?.requestDisallowInterceptTouchEvent(true)
                }
                MotionEvent.ACTION_MOVE -> {
                    val (lw, lh) = layerSize()
                    val maxW = (lw - floatX).coerceAtLeast(act.dp(170))
                    val maxH = (lh - floatY).coerceAtLeast(act.dp(120))
                    resizeFloat(
                        (sw + ev.rawX - sx).toInt().coerceIn(act.dp(170), maxW),
                        (sh + ev.rawY - sy).toInt().coerceIn(act.dp(120), maxH)
                    )
                }
            }
            true
        }

        // drag by the header (in screen coordinates, so it is the same in the app layer and in the overlay window)
        var ox = 0f; var oy = 0f
        header.setOnTouchListener { _, ev ->
            when (ev.actionMasked) {
                MotionEvent.ACTION_DOWN -> { ox = floatX - ev.rawX; oy = floatY - ev.rawY }
                MotionEvent.ACTION_MOVE -> {
                    val (lw, lh) = layerSize()
                    val minY = act.dp(24)
                    moveFloat(
                        (ev.rawX + ox).toInt().coerceIn(0, (lw - fv.width).coerceAtLeast(0)),
                        (ev.rawY + oy).toInt().coerceIn(minY, (lh - fv.height).coerceAtLeast(minY))
                    )
                }
            }
            true
        }

        floatView = fv; floatBody = body; floatTitle = t
        return fv to body
    }

    /** Size of the area the floating window can move in: the screen (overlay) or the app layer. */
    private fun layerSize(): Pair<Int, Int> {
        val dm = act.resources.displayMetrics
        if (floatInOverlay) return dm.widthPixels to dm.heightPixels
        val layer = floatLayer()
        return (if (layer.width > 0) layer.width else dm.widthPixels) to (if (layer.height > 0) layer.height else dm.heightPixels)
    }

    private fun moveFloat(x: Int, y: Int) {
        floatX = x; floatY = y
        val fv = floatView ?: return
        val lp = overlayLp
        if (floatInOverlay && lp != null) {
            lp.x = x; lp.y = y
            try { act.applicationContext.windowManager().updateViewLayout(fv, lp) } catch (e: Exception) { }
        } else { fv.x = x.toFloat(); fv.y = y.toFloat() }
    }

    private fun resizeFloat(w: Int, h: Int) {
        floatW = w; floatH = h
        val fv = floatView ?: return
        val lp = overlayLp
        if (floatInOverlay && lp != null) {
            lp.width = w; lp.height = h
            try { act.applicationContext.windowManager().updateViewLayout(fv, lp) } catch (e: Exception) { }
        } else {
            val l = fv.layoutParams ?: return
            l.width = w; l.height = h
            fv.layoutParams = l
        }
    }

    /** Takes the floating window off the screen, wherever it is (overlay window or app layer). */
    private fun removeFloatView() {
        val fv = floatView ?: return
        if (floatInOverlay) {
            try { act.applicationContext.windowManager().removeViewImmediate(fv) } catch (e: Exception) { }
        } else {
            try { (fv.parent as? ViewGroup)?.removeView(fv) } catch (e: Exception) { }
        }
        floatInOverlay = false
        overlayLp = null
    }

    /** Overlay window over other apps. Returns false when the system refuses it (permission gone ...). */
    private fun addOverlay(fv: FrameLayout): Boolean {
        return try {
            val type = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY
            else @Suppress("DEPRECATION") WindowManager.LayoutParams.TYPE_PHONE
            val lp = WindowManager.LayoutParams(
                floatW, floatH, type,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE or WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL,
                PixelFormat.TRANSLUCENT
            ).apply { gravity = Gravity.TOP or Gravity.START; x = floatX; y = floatY }
            act.applicationContext.windowManager().addView(fv, lp)
            overlayLp = lp
            floatInOverlay = true
            true
        } catch (e: Exception) {
            AppLog.e("BrowserPopup", "overlay window refused, floating inside the app", e)
            false
        }
    }

    /**
     * Puts the floating window on screen: as an overlay over other apps when "Display over other apps" is granted,
     * otherwise on the layer above the whole app. The first time it gets a size and a start position; after that
     * size and position are kept, also when the window changes from the app layer to the overlay.
     */
    private fun attachFloat() {
        val fv = ensureFloat().first
        removeFloatView()
        val dm = act.resources.displayMetrics
        val overlay = act.canDrawOverApps()
        val layer = floatLayer()
        val lw = if (overlay || layer.width <= 0) dm.widthPixels else layer.width
        val lh = if (overlay || layer.height <= 0) dm.heightPixels else layer.height
        if (floatW <= 0 || floatH <= 0) {
            val w = (lw * 0.6f).toInt().coerceIn(act.dp(200), act.dp(320))
            floatW = w; floatH = (w * 0.75f).toInt() + act.dp(30)
        }
        if (!floatPlaced) {
            floatPlaced = true
            val n = act.popupWindows.count { it.mode == PopupMode.FLOAT && it !== this }
            floatX = (lw - floatW - act.dp(12) - n * act.dp(22)).coerceAtLeast(0)
            floatY = (lh - floatH - act.dp(76) - n * act.dp(22)).coerceAtLeast(act.dp(24))
        }
        if (!(overlay && addOverlay(fv))) {
            layer.addView(fv, FrameLayout.LayoutParams(floatW, floatH))
            fv.x = floatX.toFloat(); fv.y = floatY.toFloat()
        }
        fv.alpha = 0f
        fv.animate().alpha(1f).setDuration(140).start()
    }

    /** Permission was granted while this window floats inside the app: move it to the overlay (called when the app comes back). */
    fun refreshFloatHost() {
        if (mode == PopupMode.FLOAT && !released && !floatInOverlay && act.canDrawOverApps()) attachFloat()
    }

    // ── animation / teardown ──

    fun animateIn() {
        root.alpha = 0f
        card.scaleX = 0.94f; card.scaleY = 0.94f
        root.animate().alpha(1f).setDuration(160).start()
        card.animate().scaleX(1f).scaleY(1f).setDuration(160).start()
    }

    fun animateOut(end: () -> Unit) {
        val v = shownView()
        v.animate().alpha(0f).setDuration(120).withEndAction { end() }.start()
        if (mode != PopupMode.FLOAT) card.animate().scaleX(0.96f).scaleY(0.96f).setDuration(120).start()
    }

    /** Removes all popup views and gives the WebView back without destroying it (popup → tab). */
    fun detachWebView(): WebView {
        released = true
        try { root.animate().cancel(); floatView?.animate()?.cancel() } catch (e: Exception) { }
        try { (webView.parent as? ViewGroup)?.removeView(webView) } catch (e: Exception) { }
        try { (root.parent as? ViewGroup)?.removeView(root) } catch (e: Exception) { }
        removeFloatView()
        return webView
    }

    /** Detaches and destroys the WebView. Safe to call more than once. */
    fun release() {
        if (released) return
        released = true
        try { root.animate().cancel(); floatView?.animate()?.cancel() } catch (e: Exception) { }
        try { webView.stopLoading() } catch (e: Exception) { }
        try { (webView.parent as? ViewGroup)?.removeView(webView) } catch (e: Exception) { }
        try { (root.parent as? ViewGroup)?.removeView(root) } catch (e: Exception) { }
        removeFloatView()
        try { webView.destroy() } catch (e: Exception) { }
    }
}

// ── opening ─────────────────────────────────────────────────────────

private fun MainActivity.popupBlockedToast() {
    val now = SystemClock.uptimeMillis()
    if (now - lastBlockedToast < 2000) return
    lastBlockedToast = now
    Toast.makeText(this, "Pop-up blocked", Toast.LENGTH_SHORT).show()
}

/**
 * Answers WebChromeClient.onCreateWindow. Returns true when the request was taken (a popup dialog is
 * shown), false when it was blocked.
 */
@SuppressLint("SetJavaScriptEnabled")
internal fun MainActivity.openPopupWindow(opener: WebView, isUserGesture: Boolean, resultMsg: Message?): Boolean {
    val transport = resultMsg?.obj as? WebView.WebViewTransport ?: return false
    val owner = webTabs.firstOrNull { it.webView == opener }
        ?: popupWindows.firstOrNull { it.webView == opener }?.owner
        ?: return false

    if (!isUserGesture) { popupBlockedToast(); return false }
    val now = SystemClock.uptimeMillis()
    popupOpenTimes.removeAll { now - it > BURST_WINDOW_MS }
    if (popupOpenTimes.size >= BURST_LIMIT || popupWindows.count { it.owner == owner } >= MAX_POPUPS_PER_TAB) {
        popupBlockedToast(); return false
    }
    popupOpenTimes.add(now)

    return try {
        val wv = WebView(this)
        val popup = BrowserPopup(this, owner, wv)
        configurePopupWebView(popup, opener)
        popupWindows.add(popup)
        webContainer.addView(popup.root, FrameLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT))
        // opened from a floating popup (or while another tab / screen is showing): bring the owner tab forward
        if (activeSection != "browser" || webTabs.getOrNull(currentTabIndex) != owner) {
            switchToSection("browser")
            val idx = webTabs.indexOf(owner)
            if (idx >= 0) switchTab(idx)
        }
        popup.root.visibility = View.VISIBLE
        popup.animateIn()
        transport.webView = wv
        resultMsg.sendToTarget()
        true
    } catch (e: Exception) {
        AppLog.e("BrowserPopup", "cannot open popup", e)
        false
    }
}

@SuppressLint("SetJavaScriptEnabled")
private fun MainActivity.configurePopupWebView(p: BrowserPopup, opener: WebView) {
    val wv = p.webView
    val act = this
    wv.settings.apply {
        javaScriptEnabled = true
        domStorageEnabled = true
        databaseEnabled = true
        setSupportZoom(true)
        builtInZoomControls = true
        displayZoomControls = false
        useWideViewPort = true
        loadWithOverviewMode = true
        cacheMode = WebSettings.LOAD_DEFAULT
        mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
        mediaPlaybackRequiresUserGesture = false
        javaScriptCanOpenWindowsAutomatically = true
        setSupportMultipleWindows(true)
        // same identity as the page that opened it (mobile / desktop), without the WebView markers
        userAgentString = webViewFriendlyUa(try { opener.settings.userAgentString } catch (e: Exception) {
            WebSettings.getDefaultUserAgent(act)
        })
    }
    CookieManager.getInstance().setAcceptCookie(true)
    CookieManager.getInstance().setAcceptThirdPartyCookies(wv, true)
    wv.addJavascriptInterface(BlobBridge(), "AndroidBlobDl")

    wv.setDownloadListener { dlUrl, ua, cd, mime, len ->
        handleDownload(dlUrl, ua, cd, mime, len, wv)
        // a popup that was opened only to start the download is no longer needed
        if (!p.navigated) wv.post { closePopup(p) }
    }

    wv.webViewClient = object : WebViewClient() {
        override fun shouldOverrideUrlLoading(view: WebView, request: WebResourceRequest): Boolean {
            val scheme = request.url.scheme?.lowercase() ?: ""
            // normal pages load inside the popup itself (keeps referrer / POST data for login flows)
            if (scheme == "http" || scheme == "https" || scheme == "about" || scheme == "data" || scheme == "blob") return false
            return handleCustomScheme(view, request.url.toString())
        }
        override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
            if (!url.isNullOrEmpty() && url != "about:blank") p.navigated = true
            p.onUrl(url)
            view?.evaluateJavascript(BLOB_HOOK_JS, null)
        }
        override fun onPageFinished(view: WebView?, url: String?) {
            p.onUrl(url)
            p.onProgress(100)
            view?.evaluateJavascript(BLOB_HOOK_JS, null)
            if (p.mode == PopupMode.FLOAT) view?.evaluateJavascript(KEEP_ALIVE_JS, null)
            try { CookieManager.getInstance().flush() } catch (e: Exception) { }
        }
    }

    wv.webChromeClient = object : WebChromeClient() {
        override fun onProgressChanged(view: WebView?, newProgress: Int) = p.onProgress(newProgress)
        override fun onReceivedTitle(view: WebView?, title: String?) = p.onTitle(title)
        override fun onCloseWindow(window: WebView?) {
            // window.close() — e.g. the Google sign-in window closes itself when finished
            wv.post { closePopup(p) }
        }
        override fun onCreateWindow(
            view: WebView?, isDialog: Boolean, isUserGesture: Boolean, resultMsg: Message?
        ): Boolean = if (view == null) false else act.openPopupWindow(view, isUserGesture, resultMsg)

        override fun onJsAlert(view: WebView?, url: String?, message: String?, result: JsResult?): Boolean {
            runOnUiThread {
                W11Dialog.Builder(act).setTitle("Alert").setMessage(message)
                    .setPositiveButton("OK") { _, _ -> result?.confirm() }
                    .setCancelable(false).show()
            }
            return true
        }
        override fun onJsConfirm(view: WebView?, url: String?, message: String?, result: JsResult?): Boolean {
            runOnUiThread {
                W11Dialog.Builder(act).setTitle("Confirm").setMessage(message)
                    .setPositiveButton("OK") { _, _ -> result?.confirm() }
                    .setNegativeButton("Cancel") { _, _ -> result?.cancel() }
                    .setCancelable(false).show()
            }
            return true
        }
        override fun onJsPrompt(
            view: WebView?, url: String?, message: String?, defaultValue: String?, result: JsPromptResult?
        ): Boolean {
            runOnUiThread {
                val input = EditText(act).apply { setText(defaultValue) }.glassStyle()
                W11Dialog.Builder(act).setTitle("Input").setMessage(message).setView(input)
                    .setPositiveButton("OK") { _, _ -> result?.confirm(input.text.toString()) }
                    .setNegativeButton("Cancel") { _, _ -> result?.cancel() }
                    .setCancelable(false).show()
            }
            return true
        }
    }
}

// ── closing / lifecycle ─────────────────────────────────────────────

/** Closes one popup with a short fade; the WebView is destroyed after the animation (never inside its own callback). */
internal fun MainActivity.closePopup(p: BrowserPopup) {
    if (!popupWindows.remove(p)) return
    try { CookieManager.getInstance().flush() } catch (e: Exception) { }
    updatePopupService()
    p.root.isClickable = false
    p.animateOut { p.release() }
    // safety net: if the animation never ends (view detached), still free the WebView
    Handler(Looper.getMainLooper()).postDelayed({ p.release() }, 400)
}

/** Closes all popups of a tab at once (tab closed). */
internal fun MainActivity.closePopupsOf(tab: WebTab) {
    val mine = popupWindows.filter { it.owner == tab }
    popupWindows.removeAll(mine.toSet())
    mine.forEach { it.release() }
    updatePopupService()
}

/** Activity is going away. */
internal fun MainActivity.destroyAllPopups() {
    val all = popupWindows.toList()
    popupWindows.clear()
    all.forEach { it.release() }
    updatePopupService()
}

/** The topmost dialog / full-size popup of the current tab, if any. Floating popups do not take the Back key. */
internal fun MainActivity.topPopupOfCurrentTab(): BrowserPopup? {
    val tab = webTabs.getOrNull(currentTabIndex) ?: return null
    return popupWindows.lastOrNull { it.owner == tab && it.mode != PopupMode.FLOAT }
}

/** Back button: step back inside the popup first, then close it. Returns true if a popup handled the key. */
internal fun MainActivity.handleBackInPopup(): Boolean {
    val p = topPopupOfCurrentTab() ?: return false
    val canGoBack = try { p.webView.canGoBack() } catch (e: Exception) { false }
    if (canGoBack) p.webView.goBack() else closePopup(p)
    return true
}

/** Shows only the dialog popups of the selected tab (those of hidden tabs are paused). Floating popups always stay on. */
internal fun MainActivity.refreshPopupVisibility() {
    val current = webTabs.getOrNull(currentTabIndex)
    for (p in popupWindows) {
        if (p.mode == PopupMode.FLOAT) continue
        val show = p.owner == current
        p.root.visibility = if (show) View.VISIBLE else View.GONE
        try { if (show) p.webView.onResume() else p.webView.onPause() } catch (e: Exception) { }
    }
}

/** App goes to the background: pause dialog popups, but NOT floating ones — they keep playing. */
internal fun MainActivity.pausePopups() {
    popupWindows.filter { it.mode != PopupMode.FLOAT }
        .forEach { try { it.webView.onPause() } catch (e: Exception) { } }
}

internal fun MainActivity.resumePopups() {
    popupWindows.toList().forEach { it.refreshFloatHost() }
    val current = webTabs.getOrNull(currentTabIndex)
    popupWindows.filter { it.mode != PopupMode.FLOAT && it.owner == current }
        .forEach { try { it.webView.onResume() } catch (e: Exception) { } }
}

// ── Step 2: restore / open as tab / background playback ─────────────

private fun Context.windowManager(): WindowManager = getSystemService(Context.WINDOW_SERVICE) as WindowManager

/** An overlay window can be tapped while this app is in the background: bring the app back before it shows the page. */
private fun MainActivity.bringAppToFront() {
    try {
        startActivity(Intent(this, MainActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_SINGLE_TOP))
    } catch (e: Exception) { AppLog.e("BrowserPopup", "cannot bring the app to the front", e) }
}

/** Floating window → dialog again, on the browser screen of the tab that owns it. */
internal fun MainActivity.restorePopup(p: BrowserPopup) {
    if (!popupWindows.contains(p)) return
    if (p.floatInOverlay) bringAppToFront()
    switchToSection("browser")
    val idx = webTabs.indexOf(p.owner)
    if (idx >= 0) switchTab(idx)
    p.setMode(PopupMode.DIALOG)
}

/** "Open as tab": the popup's WebView (page, cookies, login) becomes a normal browser tab. */
internal fun MainActivity.expandPopupToTab(p: BrowserPopup) {
    if (!popupWindows.remove(p)) return
    val wasOverlay = p.floatInOverlay
    val wv = p.detachWebView()
    if (wasOverlay) bringAppToFront()
    updatePopupService()
    switchToSection("browser")
    addNewTab(wv.url ?: "about:blank", switch = true, existing = wv)
    if (webTabs.none { it.webView == wv }) { // the tab could not be created: do not leak the WebView
        try { wv.destroy() } catch (e: Exception) { }
    }
}

/** Runs the foreground service exactly while at least one popup is minimized to a floating window. */
internal fun MainActivity.updatePopupService() {
    val need = popupWindows.any { it.mode == PopupMode.FLOAT }
    if (need == playbackServiceOn) return
    try {
        val i = Intent(this, PopupPlaybackService::class.java)
        if (need) ContextCompat.startForegroundService(this, i) else stopService(i)
        playbackServiceOn = need
    } catch (e: Exception) {
        AppLog.e("BrowserPopup", "playback service", e)
    }
}

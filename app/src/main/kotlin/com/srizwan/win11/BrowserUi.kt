package com.srizwan.win11

import com.srizwan.chooser.openwith.OpenWith
import com.srizwan.chooser.picker.FilePicker
import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.app.Dialog
import android.app.role.RoleManager
import android.app.DownloadManager
import android.app.Notification
import android.content.BroadcastReceiver
import android.content.ComponentName
import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.SharedPreferences
import android.content.pm.ActivityInfo
import android.content.res.ColorStateList
import android.text.InputType
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import android.graphics.Matrix
import android.graphics.Rect
import android.hardware.camera2.CameraAccessException
import android.hardware.camera2.CameraManager
import android.net.Uri
import android.os.*
import android.provider.ContactsContract
import android.provider.MediaStore
import android.provider.Settings
import android.provider.Telephony
import android.service.notification.NotificationListenerService
import android.service.notification.StatusBarNotification
import android.telephony.SmsManager
import android.text.format.DateUtils
import android.util.Base64
import android.util.Log
import android.view.*
import android.view.MotionEvent
import android.view.ScaleGestureDetector
import android.graphics.Typeface
import android.graphics.pdf.PdfRenderer
import android.media.AudioAttributes
import android.media.RingtoneManager
import android.webkit.*
import android.widget.*
import android.widget.VideoView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*
import java.util.zip.ZipInputStream

// Browser: tabs, WebView setup, downloads, custom URL schemes (split out of MainActivity).
// All functions are extensions of MainActivity; state lives in MainActivity.

data class WebTab(
    val webView: WebView,
    var title: String = "New Tab",
    var url: String = "",
    var isDesktopMode: Boolean = false
) {
    /** The page that opened this tab with window.open() / target="_blank" (null for a normal tab). */
    var openerWebView: WebView? = null
    val openedByScript: Boolean get() = openerWebView != null
    /** true once a real page (not about:blank) has started loading */
    var navigated = false
}

// ── File upload ──────────────────────────────────────────────

internal fun MainActivity.handleCustomScheme(view: WebView, url: String): Boolean {
    val uri = try { Uri.parse(url) } catch (e: Exception) { return false }
    val scheme = uri.scheme?.lowercase() ?: return false
    if (scheme == "http" || scheme == "https" || scheme == "about" || scheme == "data") return false
    if (scheme == "javascript") return true
    if (scheme == "intent") return handleIntentScheme(url)

    val launchIntent: Intent? = when (scheme) {
        "market" -> try { Intent(Intent.ACTION_VIEW, uri) } catch (e: Exception) { null }
        "tel" -> Intent(Intent.ACTION_DIAL, uri)
        "mailto" -> Intent(Intent.ACTION_SENDTO, uri)
        "sms", "smsto", "mms", "mmsto" -> Intent(Intent.ACTION_SENDTO, uri)
        "geo", "maps" -> Intent(Intent.ACTION_VIEW, uri)
        "fb", "facebook" -> Intent(Intent.ACTION_VIEW, uri).apply {
            `package` = "com.facebook.katana"
        }
        "instagram" -> Intent(Intent.ACTION_VIEW, uri).apply {
            `package` = "com.instagram.android"
        }
        "twitter", "x" -> Intent(Intent.ACTION_VIEW, uri).apply {
            `package` = "com.twitter.android"
        }
        "whatsapp" -> Intent(Intent.ACTION_VIEW, uri).apply { `package` = "com.whatsapp" }
        "tg" -> Intent(Intent.ACTION_VIEW, uri).apply {
            `package` = "org.telegram.messenger"
        }
        "youtube", "vnd.youtube" -> Intent(Intent.ACTION_VIEW, uri).apply {
            `package` = "com.google.android.youtube"
        }
        "snssdk1128", "snssdk1233" -> Intent(Intent.ACTION_VIEW, uri).apply {
            `package` = "com.zhiliaoapp.musically"
        }
        "snapchat" -> Intent(Intent.ACTION_VIEW, uri).apply {
            `package` = "com.snapchat.android"
        }
        "linkedin" -> Intent(Intent.ACTION_VIEW, uri).apply {
            `package` = "com.linkedin.android"
        }
        "spotify" -> Intent(Intent.ACTION_VIEW, uri).apply { `package` = "com.spotify.music" }
        else -> Intent(Intent.ACTION_VIEW, uri)
    }
    return tryLaunchIntent(launchIntent, url, scheme)
}


internal fun MainActivity.handleIntentScheme(intentUrl: String): Boolean {
    return try {
        val intent = Intent.parseUri(intentUrl, Intent.URI_INTENT_SCHEME)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        val pm = packageManager
        val resolved = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            pm.resolveActivity(
                intent,
                PackageManager.ResolveInfoFlags.of(PackageManager.MATCH_DEFAULT_ONLY.toLong())
            )
        } else {
            @Suppress("DEPRECATION")
            pm.resolveActivity(intent, PackageManager.MATCH_DEFAULT_ONLY)
        }
        if (resolved != null) {
            startActivity(intent); true
        } else {
            val fallbackUrl = intent.getStringExtra("browser_fallback_url")
            if (!fallbackUrl.isNullOrEmpty()) {
                webTabs.getOrNull(currentTabIndex)?.webView?.loadUrl(fallbackUrl)
                return true
            }
            val pkg = intent.`package`
            if (!pkg.isNullOrEmpty()) tryLaunchIntent(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://play.google.com/store/apps/details?id=$pkg")
                ),
                intentUrl,
                "market"
            )
            else true
        }
    } catch (e: Exception) { true }
}


internal fun MainActivity.tryLaunchIntent(intent: Intent?, originalUrl: String, scheme: String): Boolean {
    if (intent == null) return false
    return try {
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
        true
    } catch (e: android.content.ActivityNotFoundException) {
        val fallback = buildFallbackUrl(originalUrl, scheme)
        if (fallback != null) webTabs.getOrNull(currentTabIndex)?.webView?.loadUrl(fallback)
        else Toast.makeText(
            this, "প্রয়োজনীয় অ্যাপ পাওয়া যায়নি", Toast.LENGTH_SHORT
        ).show()
        true
    } catch (e: Exception) {
        Toast.makeText(
            this, "লিংক খুলতে সমস্যা: ${e.message}", Toast.LENGTH_SHORT
        ).show()
        true
    }
}


internal fun MainActivity.buildFallbackUrl(originalUrl: String, scheme: String): String? = when (scheme) {
    "market" -> {
        val id = Uri.parse(originalUrl).getQueryParameter("id")
        if (!id.isNullOrEmpty()) "https://play.google.com/store/apps/details?id=$id"
        else "https://play.google.com"
    }
    "fb", "facebook" -> "https://www.facebook.com"
    "instagram" -> "https://www.instagram.com"
    "twitter", "x" -> "https://twitter.com"
    "whatsapp" -> "https://web.whatsapp.com"
    "tg" -> "https://web.telegram.org"
    "youtube", "vnd.youtube" -> "https://www.youtube.com"
    "linkedin" -> "https://www.linkedin.com"
    "spotify" -> "https://open.spotify.com"
    else -> null
}

// =====================================================================
// ██████████  DIALER SECTION  ██████████
// =====================================================================


internal class TabChip(private val act: MainActivity, val tab: WebTab) : LinearLayout(act) {
    val title = TextView(act)
    val close = TextView(act)
    /** turns this tab into a floating pop-up window (the page keeps running) */
    val popout = TextView(act)
    /** small speaker icon, visible while the tab plays audio / video */
    private val audio = TextView(act)

    init {
        orientation = LinearLayout.HORIZONTAL
        gravity = Gravity.CENTER_VERTICAL
        layoutParams = LinearLayout.LayoutParams(act.dp(178), act.dp(36)).apply { rightMargin = act.dp(2) }
        setPadding(act.dp(10), 0, act.dp(2), 0)
        audio.apply {
            iconOnly(R.drawable.ic_tab_audio, 12, Color.parseColor("#4CC2FF"))
            layoutParams = LinearLayout.LayoutParams(act.dp(18), ViewGroup.LayoutParams.MATCH_PARENT)
            visibility = View.GONE
        }
        title.apply {
            textSize = 12.5f
            setSingleLine(true)
            ellipsize = android.text.TextUtils.TruncateAt.END
            layoutParams = LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1f)
        }
        popout.apply {
            iconOnly(R.drawable.ic_tab_popout, 13, Color.parseColor("#9D9D9D"))
            setTextColor(Color.parseColor("#9D9D9D"))
            layoutParams = LinearLayout.LayoutParams(act.dp(28), ViewGroup.LayoutParams.MATCH_PARENT)
            contentDescription = "Pop out this tab"
        }
        close.apply {
            iconOnly(R.drawable.ic_qs_close, 12, Color.parseColor("#9D9D9D"))
            setTextColor(Color.parseColor("#9D9D9D"))
            layoutParams = LinearLayout.LayoutParams(act.dp(30), ViewGroup.LayoutParams.MATCH_PARENT)
        }
        addView(audio)
        addView(title)
        addView(popout)
        addView(close)
        setActive(false)
    }

    fun setPlaying(playing: Boolean) {
        audio.visibility = if (playing) View.VISIBLE else View.GONE
    }

    fun setActive(active: Boolean) {
        val r = act.dp(8).toFloat()
        background = android.graphics.drawable.GradientDrawable().apply {
            cornerRadii = floatArrayOf(r, r, r, r, 0f, 0f, 0f, 0f)
            setColor(Color.parseColor(if (active) "#2B2B2B" else "#262626"))
        }
        title.setTextColor(if (active) Color.WHITE else Color.parseColor("#B0B0B0"))
    }
}


internal fun MainActivity.createBrowserView(): LinearLayout {
    val accent = Color.parseColor("#4CC2FF")
    val layout = LinearLayout(this).apply {
        orientation = LinearLayout.VERTICAL
        layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT
        )
        setBackgroundColor(Color.parseColor("#191919"))
    }

    // ── Tab strip ───────────────────────────────────────────
    val tabBar = LinearLayout(this).apply {
        orientation = LinearLayout.HORIZONTAL
        gravity = Gravity.BOTTOM
        setBackgroundColor(Color.parseColor("#202020"))
        layoutParams = LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, dp(42))
        setPadding(dp(6), dp(6), dp(4), 0)
    }
    tabScroll = HorizontalScrollView(this).apply {
        layoutParams = LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, 1f)
        isHorizontalScrollBarEnabled = false
        overScrollMode = View.OVER_SCROLL_NEVER
    }
    tabContainer = LinearLayout(this).apply {
        orientation = LinearLayout.HORIZONTAL
        gravity = Gravity.BOTTOM
    }
    tabScroll.addView(
        tabContainer,
        FrameLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT
        )
    )
    val newTabBtn = TextView(this).apply {
        text = "+"
        textSize = 22f
        setTextColor(Color.WHITE)
        gravity = Gravity.CENTER
        layoutParams = LinearLayout.LayoutParams(dp(40), dp(36))
        background = rippleBg(8)
        isClickable = true
        contentDescription = "New tab"
        setOnClickListener { addNewTab("https://www.google.com", switch = true) }
    }
    tabBar.addView(tabScroll)
    tabBar.addView(newTabBtn)

    // ── Toolbar: back, forward, address pill, desktop, downloads ──
    val toolbar = LinearLayout(this).apply {
        orientation = LinearLayout.HORIZONTAL
        gravity = Gravity.CENTER_VERTICAL
        setBackgroundColor(Color.parseColor("#2B2B2B"))
        setPadding(dp(4), dp(6), dp(4), dp(6))
    }
    backNavIcon = VectorIconView(this, VectorIconView.BACK)
    fwdNavIcon = VectorIconView(this, VectorIconView.BACK).apply { rotation = 180f }
    toolbar.addView(makeToolBtn(backNavIcon, "Back") {
        try { webTabs.getOrNull(currentTabIndex)?.webView?.let { if (it.canGoBack()) it.goBack() } } catch (e: Exception) { }
    })
    toolbar.addView(makeToolBtn(fwdNavIcon, "Forward") {
        try { webTabs.getOrNull(currentTabIndex)?.webView?.let { if (it.canGoForward()) it.goForward() } } catch (e: Exception) { }
    })

    val pill = LinearLayout(this).apply {
        orientation = LinearLayout.HORIZONTAL
        gravity = Gravity.CENTER_VERTICAL
        layoutParams = LinearLayout.LayoutParams(0, dp(40), 1f).apply {
            leftMargin = dp(2); rightMargin = dp(2)
        }
        background = android.graphics.drawable.GradientDrawable().apply {
            cornerRadius = dp(20).toFloat()
            setColor(Color.parseColor("#1F1F1F"))
            setStroke(1, Color.parseColor("#3A3A3A"))
        }
        setPadding(dp(12), 0, dp(2), 0)
    }
    pill.addView(VectorIconView(this, VectorIconView.SEARCH).apply {
        setIconColor(Color.parseColor("#9D9D9D"))
        layoutParams = LinearLayout.LayoutParams(dp(16), dp(16))
    })
    urlBar = EditText(this).apply {
        hint = "Enter URL or search"
        setHintTextColor(Color.parseColor("#8A8A8A"))
        setTextColor(Color.WHITE)
        textSize = 14f
        background = null
        setPadding(dp(8), 0, dp(4), 0)
        layoutParams = LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, 1f)
        setSingleLine(true)
        inputType = android.text.InputType.TYPE_CLASS_TEXT or
                android.text.InputType.TYPE_TEXT_VARIATION_URI
        imeOptions = android.view.inputmethod.EditorInfo.IME_ACTION_GO
        setSelectAllOnFocus(true)
        setOnEditorActionListener { _, _, _ -> submitUrl(); true }
        setOnFocusChangeListener { _, _ -> updateReloadIcon() }
    }
    pill.addView(urlBar)
    reloadBtn = TextView(this).apply {
        iconOnly(R.drawable.ic_w_refresh, 20, Color.WHITE)
        setTextColor(Color.WHITE)
        gravity = Gravity.CENTER
        layoutParams = LinearLayout.LayoutParams(dp(38), dp(38))
        background = rippleBg(19)
        isClickable = true
        setOnClickListener {
            val wv = webTabs.getOrNull(currentTabIndex)?.webView
            when {
                urlBar.hasFocus() -> submitUrl()
                isPageLoading -> try { wv?.stopLoading() } catch (e: Exception) { }
                else -> try { wv?.reload() } catch (e: Exception) { }
            }
        }
    }
    pill.addView(reloadBtn)
    toolbar.addView(pill)

    desktopIcon = VectorIconView(this, VectorIconView.PC).apply {
        setIconColor(Color.parseColor("#B0B0B0"))
    }
    toolbar.addView(makeToolBtn(desktopIcon, "Desktop site") {
        val tab = webTabs.getOrNull(currentTabIndex) ?: return@makeToolBtn
        tab.isDesktopMode = !tab.isDesktopMode
        updateDesktopBtnIcon()
        Toast.makeText(
            act,
            if (tab.isDesktopMode) "Desktop Mode ON" else "Desktop Mode OFF",
            Toast.LENGTH_SHORT
        ).show()
        updateDesktopModeForTab(tab)
        tab.webView.reload()
    })

    val dlHolder = FrameLayout(this).apply {
        layoutParams = LinearLayout.LayoutParams(dp(38), dp(40))
        background = rippleBg(19)
        isClickable = true
        contentDescription = "Downloads"
        setOnClickListener { showDownloads() }
        addView(
            VectorIconView(act, VectorIconView.DOWNLOAD),
            FrameLayout.LayoutParams(dp(20), dp(20), Gravity.CENTER)
        )
    }
    dlBadge = TextView(this).apply {
        textSize = 9f
        setTextColor(Color.BLACK)
        gravity = Gravity.CENTER
        typeface = Typeface.DEFAULT_BOLD
        background = android.graphics.drawable.GradientDrawable().apply {
            shape = android.graphics.drawable.GradientDrawable.OVAL
            setColor(accent)
        }
        visibility = View.GONE
    }
    dlHolder.addView(dlBadge, FrameLayout.LayoutParams(dp(15), dp(15), Gravity.TOP or Gravity.END).apply {
        topMargin = dp(3); rightMargin = dp(2)
    })
    toolbar.addView(makeMediaGrabberButton()) // Media Grabber (BrowserMediaGrabber.kt)
    toolbar.addView(dlHolder)

    progressBar =
        ProgressBar(this, null, android.R.attr.progressBarStyleHorizontal).apply {
            layoutParams = LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, dp(2))
            max = 100
            progressTintList = android.content.res.ColorStateList.valueOf(accent)
            progressBackgroundTintList =
                android.content.res.ColorStateList.valueOf(Color.parseColor("#2B2B2B"))
            visibility = View.GONE
        }
    webContainer = FrameLayout(this).apply {
        layoutParams = LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0, 1f)
        setBackgroundColor(Color.parseColor("#191919"))
    }
    layout.addView(tabBar)
    layout.addView(toolbar)
    layout.addView(progressBar)
    layout.addView(webContainer)
    return layout
}


internal fun MainActivity.submitUrl() {
    loadUrlInCurrentTab()
    try {
        urlBar.clearFocus()
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as android.view.inputmethod.InputMethodManager
        imm.hideSoftInputFromWindow(urlBar.windowToken, 0)
    } catch (e: Exception) { }
    updateReloadIcon()
}


internal fun MainActivity.updateReloadIcon() {
    if (!reloadBtnInit) return
    reloadBtn.iconOnly(
        when {
            urlBar.hasFocus() -> R.drawable.ic_w_arrow_forward
            isPageLoading -> R.drawable.ic_qs_close
            else -> R.drawable.ic_w_refresh
        }, 20, Color.WHITE
    )
}


internal fun MainActivity.updateNavButtons() {
    refreshGrabDot() // Media Grabber: the dot follows the open tab / page
    if (!backNavIconInit) return
    val wv = webTabs.getOrNull(currentTabIndex)?.webView
    try {
        backNavIcon.alpha = if (wv?.canGoBack() == true) 1f else 0.35f
        fwdNavIcon.alpha = if (wv?.canGoForward() == true) 1f else 0.35f
    } catch (e: Exception) { }
}


internal fun MainActivity.updateDownloadBadge() {
    if (!dlBadgeInit) return
    val n = DlEngine.activeCount()
    dlBadge.visibility = if (n > 0) View.VISIBLE else View.GONE
    dlBadge.text = if (n > 9) "9+" else n.toString()
}

// ── Downloads screen ──────────────────────────────────────────

internal fun MainActivity.showDownloads() {
    if (!downloadsViewInit) return
    downloadsView.visibility = View.VISIBLE
    downloadsUi.onShow()
}


internal fun MainActivity.hideDownloads() {
    if (!downloadsViewInit) return
    if (downloadsView.visibility == View.VISIBLE) {
        downloadsView.visibility = View.GONE
        downloadsUi.onHide()
    }
}


internal fun MainActivity.showDownloadsFolder() {
    try {
        val dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
        hideDownloads()
        switchToSection("files")
        loadFiles(dir)
    } catch (e: Exception) { }
}


internal fun MainActivity.openDownloaded(t: DlTask) {
    try {
        val uri = t.savedUri.takeIf { it.isNotEmpty() }?.let { Uri.parse(it) }
        if (uri == null) {
            Toast.makeText(this, "File not available", Toast.LENGTH_SHORT).show()
            return
        }
        if (DlEngine.isFileMissing(t)) { // deleted / moved outside the app: tell the user and clean the list
            Toast.makeText(this, "File is no longer in storage", Toast.LENGTH_SHORT).show()
            DlEngine.refreshFromStorage()
            return
        }
        val mime = t.mime.ifBlank { DlEngine.guessMime(t.fileName) }
        // Chooser step 5: our own glass "Open with" sheet instead of Intent.createChooser (the system chooser / TranResolver)
        OpenWith.show(this, uri, fileName = t.fileName, mime = mime)
    } catch (e: Exception) {
        Toast.makeText(this, "No app can open this file", Toast.LENGTH_SHORT).show()
    }
}


/** Step 5: shares a finished download through the system share sheet (read access to the file is granted for the share). */
internal fun MainActivity.shareDownloaded(t: DlTask) {
    try {
        val uri = t.savedUri.takeIf { it.isNotEmpty() }?.let { Uri.parse(it) }
        if (uri == null) {
            Toast.makeText(this, "File not available", Toast.LENGTH_SHORT).show()
            return
        }
        if (DlEngine.isFileMissing(t)) {
            Toast.makeText(this, "File is no longer in storage", Toast.LENGTH_SHORT).show()
            DlEngine.refreshFromStorage()
            return
        }
        val mime = t.mime.ifBlank { DlEngine.guessMime(t.fileName) }
        val send = Intent(Intent.ACTION_SEND).apply {
            type = mime
            putExtra(Intent.EXTRA_STREAM, uri)
            putExtra(Intent.EXTRA_SUBJECT, t.fileName)
            clipData = android.content.ClipData.newRawUri(t.fileName, uri)
            addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
        }
        startActivity(Intent.createChooser(send, "Share ${t.fileName}"))
    } catch (e: Exception) {
        Toast.makeText(this, "Cannot share this file", Toast.LENGTH_SHORT).show()
    }
}


internal fun MainActivity.copyText(text: String) {
    val cm = getSystemService(Context.CLIPBOARD_SERVICE) as android.content.ClipboardManager
    cm.setPrimaryClip(android.content.ClipData.newPlainText("Link", text))
    Toast.makeText(this, "Link copied", Toast.LENGTH_SHORT).show()
}


internal fun MainActivity.updateDesktopModeForTab(tab: WebTab) {
    val ua = if (tab.isDesktopMode)
        "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36"
    else webViewFriendlyUa(WebSettings.getDefaultUserAgent(this)) // no "; wv" marker: Google sign-in refuses plain WebViews
    try { tab.webView.settings.userAgentString = ua } catch (e: Exception) { }
}


@SuppressLint("SetJavaScriptEnabled")
/** [existing]: an already loaded WebView (a popup that was expanded to a tab) — it keeps its page instead of loading [url] again. */
internal fun MainActivity.addNewTab(
    url: String, switch: Boolean = true, existing: WebView? = null,
    desktop: Boolean = false, openerWebView: WebView? = null
) {
    try {
        // FIX: Use 'this' Activity context for WebView — not applicationContext
        val webView = (existing ?: WebView(this)).apply {
            layoutParams = FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            visibility = View.GONE
        }
        webView.settings.apply {
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
            allowFileAccess = true
            allowContentAccess = true
            @Suppress("DEPRECATION") setSavePassword(true)
            @Suppress("DEPRECATION") setSaveFormData(true)
            javaScriptCanOpenWindowsAutomatically = true
            setSupportMultipleWindows(true) // window.open / target=_blank -> onCreateWindow -> a new tab (openWindowAsTab, BrowserPopup.kt)
        }
        CookieManager.getInstance().setAcceptThirdPartyCookies(webView, true)
        CookieManager.getInstance().setAcceptCookie(true)

        val tab = WebTab(webView, title = existing?.title?.takeIf { it.isNotBlank() } ?: "Loading…", url = url, isDesktopMode = desktop)
        tab.openerWebView = openerWebView
        webTabs.add(tab)
        updateDesktopModeForTab(tab)

        webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(
                view: WebView, request: WebResourceRequest
            ): Boolean {
                val reqUrl = request.url.toString()
                val scheme = request.url.scheme?.lowercase() ?: ""
                if (scheme == "http" || scheme == "https" || scheme == "about") {
                    // a tab opened by window.open() loads normally (keeps referrer / POST data for login flows)
                    if (tab.openedByScript) return false
                    view.loadUrl(reqUrl); return true
                }
                if (scheme == "data") return false
                return handleCustomScheme(view, reqUrl)
            }
            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                val idx = webTabs.indexOfFirst { it.webView == view }
                if (idx == currentTabIndex) {
                    progressBar.visibility = View.VISIBLE; urlBar.setText(url)
                }
                if (idx != -1) webTabs[idx].url = url ?: ""
                if (idx != -1 && !url.isNullOrEmpty() && url != "about:blank") webTabs[idx].navigated = true
                view?.evaluateJavascript(BLOB_HOOK_JS, null)
                view?.evaluateJavascript(MEDIA_HOOK_JS, null)
                view?.evaluateJavascript(GRAB_HOOK_JS, null) // Media Grabber: fetch / XHR / <video> hooks (also added at document start)
                updateNavButtons()
            }
            // Media Grabber: remember the media addresses a page loads (the request itself is left alone).
            // A main-frame request = a new page: the old page's list is forgotten (the whole-site list is kept).
            override fun shouldInterceptRequest(view: WebView?, request: WebResourceRequest?): WebResourceResponse? {
                request?.let { r ->
                    val u = r.url.toString()
                    if (r.isForMainFrame) clearSniffedMedia(view, u) else sniffMediaRequest(view, u)
                }
                return super.shouldInterceptRequest(view, request)
            }
            override fun onPageFinished(view: WebView?, url: String?) {
                val idx = webTabs.indexOfFirst { it.webView == view }
                if (idx == currentTabIndex) {
                    progressBar.visibility = View.GONE; urlBar.setText(url)
                }
                if (idx != -1) webTabs[idx].url = url ?: ""
                view?.let { injectImageLongClickSave(it) }
                view?.evaluateJavascript(BLOB_HOOK_JS, null)
                view?.evaluateJavascript(MEDIA_HOOK_JS, null)
                view?.evaluateJavascript(GRAB_HOOK_JS, null)
                // a page that plays in a hidden tab must think it is still visible, or it pauses itself
                if (idx != currentTabIndex && view != null && isMediaPlaying(view)) view.evaluateJavascript(KEEP_ALIVE_JS, null)
                updateNavButtons()
            }
            override fun onReceivedError(
                view: WebView?,
                request: WebResourceRequest?,
                error: WebResourceError?
            ) {
                if (request?.isForMainFrame == true) {
                    val code =
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) error?.errorCode
                            ?: -1 else -1
                    if (code == -10) return
                }
            }
        }

        webView.webChromeClient = object : WebChromeClient() {
            override fun onProgressChanged(view: WebView?, newProgress: Int) {
                if (webTabs.indexOfFirst { it.webView == view } == currentTabIndex) {
                    progressBar.progress = newProgress
                    progressBar.visibility =
                        if (newProgress < 100) View.VISIBLE else View.GONE
                    isPageLoading = newProgress < 100
                    updateReloadIcon()
                }
            }
            override fun onReceivedTitle(view: WebView?, title: String?) {
                val i = webTabs.indexOfFirst { it.webView == view }
                if (i != -1 && !title.isNullOrEmpty()) {
                    webTabs[i].title = title; updateTabTitles()
                }
            }
            // window.open() / target="_blank" open in a NEW TAB instead of replacing this page
            override fun onCreateWindow(
                view: WebView?, isDialog: Boolean, isUserGesture: Boolean, resultMsg: Message?
            ): Boolean {
                if (view == null) return false
                return this@addNewTab.openWindowAsTab(view, isUserGesture, resultMsg)
            }
            // window.close() — e.g. the Google sign-in tab closes itself when finished (only tabs opened by a page)
            override fun onCloseWindow(window: WebView?) {
                val w = window ?: return
                w.post {
                    val i = webTabs.indexOfFirst { it.webView == w }
                    if (i >= 0 && webTabs[i].openedByScript) closeTab(i)
                }
            }
            override fun onJsAlert(
                view: WebView?, url: String?, message: String?, result: JsResult?
            ): Boolean {
                runOnUiThread {
                    W11Dialog.Builder(act).setTitle("Alert")
                        .setMessage(message)
                        .setPositiveButton("OK") { _, _ -> result?.confirm() }
                        .setCancelable(false).show()
                }
                return true
            }
            override fun onJsConfirm(
                view: WebView?, url: String?, message: String?, result: JsResult?
            ): Boolean {
                runOnUiThread {
                    W11Dialog.Builder(act).setTitle("Confirm")
                        .setMessage(message)
                        .setPositiveButton("OK") { _, _ -> result?.confirm() }
                        .setNegativeButton("Cancel") { _, _ -> result?.cancel() }
                        .setCancelable(false).show()
                }
                return true
            }
            override fun onJsPrompt(
                view: WebView?, url: String?, message: String?,
                defaultValue: String?, result: JsPromptResult?
            ): Boolean {
                runOnUiThread {
                    val input = EditText(act).apply { setText(defaultValue) }.glassStyle()
                    W11Dialog.Builder(act).setTitle("Input")
                        .setMessage(message).setView(input)
                        .setPositiveButton("OK") { _, _ ->
                            result?.confirm(input.text.toString())
                        }
                        .setNegativeButton("Cancel") { _, _ -> result?.cancel() }
                        .setCancelable(false).show()
                }
                return true
            }
            override fun onShowCustomView(view: View?, callback: CustomViewCallback?) {
                if (customView != null) { callback?.onCustomViewHidden(); return }
                customView = view; customViewCallback = callback
                originalOrientation = requestedOrientation
                val decorView = window.decorView as FrameLayout
                decorView.addView(
                    customView,
                    FrameLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT
                    )
                )
                requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
                @Suppress("DEPRECATION")
                window.decorView.systemUiVisibility =
                    (View.SYSTEM_UI_FLAG_FULLSCREEN or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)
                tabLayout.visibility = View.GONE
            }
            override fun onHideCustomView() {
                if (customView == null) return
                (window.decorView as FrameLayout).removeView(customView)
                customView = null
                requestedOrientation = originalOrientation
                @Suppress("DEPRECATION")
                window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_VISIBLE
                tabLayout.visibility = View.VISIBLE
                if (rootLayoutInit) ViewCompat.requestApplyInsets(rootLayout)
                customViewCallback?.onCustomViewHidden()
                customViewCallback = null
            }
            // Camera step 7: a website's live camera / microphone (getUserMedia: QR scan, video call, photo booth)
            override fun onPermissionRequest(request: PermissionRequest?) {
                if (request == null) return
                runOnUiThread { handleWebPermission(request) }
            }
            override fun onPermissionRequestCanceled(request: PermissionRequest?) {
                if (request != null && request == pendingWebPermission) pendingWebPermission = null
            }
            override fun onShowFileChooser(
                webView: WebView?,
                filePathCallback: ValueCallback<Array<Uri>>?,
                fileChooserParams: FileChooserParams?
            ): Boolean = openFileChooser(filePathCallback, fileChooserParams) // shared with the pop-up windows (BrowserPopup.kt)
        }

        webView.addJavascriptInterface(BlobBridge(), "AndroidBlobDl")
        webView.addJavascriptInterface(MediaBridge(this, webView), "AndroidMedia")
        installGrabHooks(webView) // Media Grabber: W11Grab bridge + document-start hook (BrowserMediaGrabber.kt)
        webView.setDownloadListener { dlUrl, ua, cd, mime, len ->
            handleDownload(dlUrl, ua, cd, mime, len, webView)
            // a tab that was opened only to start the download is no longer needed
            if (tab.openedByScript && !tab.navigated) webView.post {
                val i = webTabs.indexOf(tab); if (i >= 0) closeTab(i)
            }
        }
        webView.setOnLongClickListener { v ->
            val hit = (v as WebView).hitTestResult
            val extra = hit.extra
            if (hit.type == WebView.HitTestResult.SRC_ANCHOR_TYPE && !extra.isNullOrEmpty()) {
                showLinkDialog(extra, webView); true
            } else false
        }
        webContainer.addView(webView)
        val tabIndex = webTabs.size - 1
        val chip = TabChip(act, tab)
        chip.title.text = "New Tab"
        chip.setOnClickListener { switchTab(webTabs.indexOf(tab)) }
        chip.setOnLongClickListener { confirmCloseTab(tab); true }
        chip.close.setOnClickListener { confirmCloseTab(tab) }
        chip.popout.setOnClickListener { popOutTab(tab) }
        tabContainer.addView(chip)
        if (existing == null) webView.loadUrl(url)
        if (switch) switchTab(tabIndex)
    } catch (e: Exception) {
        Toast.makeText(
            this, "Error creating tab: ${e.message}", Toast.LENGTH_SHORT
        ).show()
    }
}


internal fun MainActivity.switchTab(index: Int) {
    if (index < 0 || index >= webTabs.size) return
    webTabs.forEachIndexed { i, tab ->
        if (i == index) {
            tab.webView.visibility = View.VISIBLE
            try { tab.webView.onResume() } catch (e: Exception) { }
        } else {
            tab.webView.visibility = View.GONE
            if (isMediaPlaying(tab.webView)) {
                // keep playing in the background: no onPause, and the page must not think it is hidden
                try { tab.webView.evaluateJavascript(KEEP_ALIVE_JS, null) } catch (e: Exception) { }
            } else {
                try { tab.webView.onPause() } catch (e: Exception) { }
            }
        }
    }
    currentTabIndex = index
    urlBar.setText(
        try { webTabs[index].webView.url ?: "" } catch (e: Exception) { "" }
    )
    progressBar.visibility = View.GONE
    updateTabTitles()
    updateDesktopBtnIcon()
    updateNavButtons()
    updateReloadIcon()
    refreshPopupVisibility()
}


internal fun MainActivity.updateDesktopBtnIcon() {
    if (!desktopIconInit) return
    val tab = webTabs.getOrNull(currentTabIndex) ?: return
    desktopIcon.setIconColor(
        if (tab.isDesktopMode) Color.parseColor("#4CC2FF") else Color.parseColor("#B0B0B0")
    )
}

/** A tab is only closed after the user confirms in a dialog. */

internal fun MainActivity.confirmCloseTab(tab: WebTab) {
    if (webTabs.size <= 1) {
        Toast.makeText(this, "Cannot close last tab", Toast.LENGTH_SHORT).show()
        return
    }
    val name = tab.title.ifBlank { "New Tab" }
    W11Dialog.confirm(this, "Close tab", "Close \"$name\"?", "Close") {
        closeTab(webTabs.indexOf(tab))
    }
}


internal fun MainActivity.closeTab(index: Int): Boolean {
    if (index < 0 || index >= webTabs.size) return false
    if (webTabs.size <= 1) {
        Toast.makeText(this, "Cannot close last tab", Toast.LENGTH_SHORT).show()
        return false
    }
    val closing = webTabs[index]
    val wasCurrent = index == currentTabIndex
    mediaPlayingViews.remove(closing.webView)
    try {
        closing.webView.stopLoading()
        webContainer.removeView(closing.webView)
        closing.webView.destroy()
    } catch (e: Exception) { }
    webTabs.removeAt(index)
    if (index < tabContainer.childCount) tabContainer.removeViewAt(index)
    if (!wasCurrent && index < currentTabIndex) currentTabIndex--
    // closing the tab you are on: go back to the tab that opened it (if it still exists)
    val openerIdx = if (wasCurrent) webTabs.indexOfFirst { it.webView == closing.openerWebView } else -1
    if (openerIdx >= 0) currentTabIndex = openerIdx
    currentTabIndex = currentTabIndex.coerceIn(0, webTabs.size - 1)
    // popups of the closed tab are not closed with it (a popup never closes by itself): they move to the tab shown next
    reassignPopupsOf(closing, webTabs[currentTabIndex])
    switchTab(currentTabIndex)
    updatePopupService()
    return true
}


internal fun MainActivity.updateTabTitles() {
    for (i in 0 until tabContainer.childCount) {
        val chip = tabContainer.getChildAt(i) as? TabChip ?: continue
        chip.title.text =
            if (i < webTabs.size) webTabs[i].title.ifBlank { "New Tab" } else "Tab ${i + 1}"
        chip.setActive(i == currentTabIndex)
        chip.setPlaying(i < webTabs.size && mediaPlayingViews.contains(webTabs[i].webView))
    }
}


internal fun MainActivity.loadUrlInCurrentTab() {
    if (webTabs.isEmpty()) return
    var url = urlBar.text.toString().trim()
    if (url.isEmpty()) url = "https://www.google.com"
    if (!url.startsWith("http://") && !url.startsWith("https://") && !url.startsWith("about:")) {
        url = if (url.contains(".") && !url.contains(" ")) "https://$url"
        else "https://www.google.com/search?q=${Uri.encode(url)}"
    }
    try { webTabs[currentTabIndex].webView.loadUrl(url) } catch (e: Exception) {
        Toast.makeText(this, "Failed to load URL", Toast.LENGTH_SHORT).show()
    }
}


internal fun MainActivity.injectImageLongClickSave(webView: WebView) {
    val js = """
            (function() {
                if (window._imgSaveInjected) return;
                window._imgSaveInjected = true;
                document.addEventListener('contextmenu', function(e) {
                    var t = e.target;
                    if (t && t.tagName === 'IMG') {
                        var src = t.src || t.currentSrc || '';
                        if (src) { e.preventDefault(); AndroidImageSave.onImageLongClick(src, t.alt || ''); }
                    }
                }, true);
                document.addEventListener('touchstart', function(e) {
                    if (e.touches.length !== 1) return;
                    var t = e.target;
                    if (!t || t.tagName !== 'IMG') return;
                    var src = t.src || t.currentSrc || '';
                    if (!src) return;
                    var timer = setTimeout(function() { AndroidImageSave.onImageLongClick(src, t.alt || ''); }, 600);
                    document.addEventListener('touchend', function cancel() { clearTimeout(timer); document.removeEventListener('touchend', cancel); });
                    document.addEventListener('touchmove', function cancel2() { clearTimeout(timer); document.removeEventListener('touchmove', cancel2); });
                }, true);
            })();
        """.trimIndent()
    try { webView.removeJavascriptInterface("AndroidImageSave") } catch (e: Exception) { }
    webView.addJavascriptInterface(object {
        @JavascriptInterface
        fun onImageLongClick(imageUrl: String, alt: String) {
            runOnUiThread { showImageSaveDialog(imageUrl, webView) }
        }
    }, "AndroidImageSave")
    webView.evaluateJavascript(js, null)
}


internal fun MainActivity.showImageSaveDialog(imageUrl: String, webView: WebView) {
    val options = arrayOf("ছবি সেভ করুন", "লিংক কপি করুন", "নতুন ট্যাবে খুলুন")
    W11Dialog.Builder(this).setTitle("ছবির অপশন").setItems(options) { _, which ->
        when (which) {
            0 -> downloadImage(imageUrl, webView)
            1 -> {
                val cm =
                    getSystemService(Context.CLIPBOARD_SERVICE) as android.content.ClipboardManager
                cm.setPrimaryClip(
                    android.content.ClipData.newPlainText("Image URL", imageUrl)
                )
                Toast.makeText(this, "লিংক কপি হয়েছে", Toast.LENGTH_SHORT).show()
            }
            2 -> addNewTab(imageUrl, switch = true)
        }
    }.setNegativeButton("বাতিল", null).show()
}


internal fun MainActivity.downloadImage(imageUrl: String, webView: WebView) {
    when {
        imageUrl.startsWith("data:") -> downloadDataUrl(imageUrl)
        imageUrl.startsWith("blob:") -> downloadBlobUrl(imageUrl, webView)
        else -> {
            val cookies = CookieManager.getInstance().getCookie(imageUrl) ?: ""
            val ua = try { webView.settings.userAgentString } catch (e: Exception) { "" }
            val ext = imageUrl.substringAfterLast(".").substringBefore("?").lowercase()
                .takeIf { it.length in 2..5 } ?: "jpg"
            val referer = try { webView.url ?: "" } catch (e: Exception) { "" }
            enqueueDownload(
                imageUrl, "image_${System.currentTimeMillis()}.$ext", "",
                cookies, ua, referer
            )
        }
    }
}

// =====================================================================
// COMMON HELPERS
// =====================================================================


internal fun MainActivity.handleDownload(
    url: String, userAgent: String, contentDisposition: String,
    mimetype: String, contentLength: Long, webView: WebView
) {
    when {
        url.startsWith("blob:") -> downloadBlobUrl(url, webView)
        url.startsWith("data:") -> downloadDataUrl(url)
        else -> downloadWithManager(url, userAgent, contentDisposition, mimetype, contentLength, webView)
    }
}


internal fun MainActivity.ensureNotifPermission() {
    if (Build.VERSION.SDK_INT >= 33 &&
        ContextCompat.checkSelfPermission(this, "android.permission.POST_NOTIFICATIONS")
        != PackageManager.PERMISSION_GRANTED &&
        !prefs.getBoolean("asked_notif_perm", false)
    ) {
        prefs.edit().putBoolean("asked_notif_perm", true).apply()
        ActivityCompat.requestPermissions(this, arrayOf("android.permission.POST_NOTIFICATIONS"), 301)
    }
}


internal fun MainActivity.enqueueDownload(
    url: String, fileName: String, mime: String, cookies: String,
    ua: String, referer: String, total: Long = -1L
) {
    ensureNotifPermission()
    val t = DlEngine.enqueue(url, fileName, mime, cookies, ua, referer, total)
    Toast.makeText(this, "Download started: ${t.fileName}", Toast.LENGTH_SHORT).show()
    updateDownloadBadge()
}

/**
 * File name for a download. Replaces URLUtil.guessFileName, which swaps a real extension for the one of the MIME type:
 * GitHub release files (served as application/octet-stream) became "Surah-045-4K.bin" instead of "Surah-045-4K.mp4".
 * Order: Content-Disposition (filename* / filename), the "response-content-disposition" query parameter that
 * GitHub / S3 style redirects carry, then the last part of the URL path. The name's own extension is always kept;
 * an extension from the MIME type is added only when the name has none (and the type is a real one).
 */
internal fun guessDownloadName(url: String, contentDisposition: String?, mimetype: String?): String {
    fun fromDisposition(cd: String?): String {
        if (cd.isNullOrBlank()) return ""
        Regex("filename\\*\\s*=\\s*([^']*)'[^']*'([^;]+)", RegexOption.IGNORE_CASE).find(cd)?.let { m ->
            val v = m.groupValues[2].trim().trim('"')
            val dec = try { java.net.URLDecoder.decode(v.replace("+", "%2B"), m.groupValues[1].ifBlank { "UTF-8" }) } catch (e: Exception) { v }
            if (dec.isNotBlank()) return dec
        }
        Regex("filename\\s*=\\s*\"?([^\";]+)\"?", RegexOption.IGNORE_CASE).find(cd)?.let { m ->
            val v = m.groupValues[1].trim()
            if (v.isNotBlank()) return try { Uri.decode(v) } catch (e: Exception) { v }
        }
        return ""
    }
    var name = fromDisposition(contentDisposition)
    if (name.isBlank()) {
        name = try { fromDisposition(Uri.parse(url).getQueryParameter("response-content-disposition")) } catch (e: Exception) { "" }
    }
    if (name.isBlank()) {
        name = try { Uri.decode(Uri.parse(url).path.orEmpty().trimEnd('/').substringAfterLast('/')) } catch (e: Exception) { "" }
    }
    name = name.substringAfterLast('/').substringAfterLast('\\').trim().trim('.')
    if (name.isBlank()) name = "download"
    if (!name.contains('.')) {
        val type = mimetype.orEmpty().substringBefore(';').trim().lowercase()
        if (type.isNotEmpty() && type != "application/octet-stream" && type != "binary/octet-stream") {
            val ext = MimeTypeMap.getSingleton().getExtensionFromMimeType(type)
            if (!ext.isNullOrEmpty()) name = "$name.$ext"
        }
    }
    return name
}

private fun EditText.onTextChanged(cb: () -> Unit) {
    addTextChangedListener(object : android.text.TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, st: Int, c: Int, a: Int) {}
        override fun onTextChanged(s: CharSequence?, st: Int, b: Int, c: Int) { cb() }
        override fun afterTextChanged(s: android.text.Editable?) {}
    })
}

/**
 * Dialog with size, save folder (the user can pick any folder; it is remembered), editable file name and
 * optional batch numbering (000.mp3, 001.mp3, 002.mp3 ... the number moves on after every download).
 * Shared by normal and blob downloads; [onConfirm] gets the final file name.
 */

internal fun MainActivity.showDownloadDialog(
    sizeText: String, defaultName: String, onConfirm: (String) -> Unit
) {
    val muted = Color.parseColor("#B8C0D0")
    val accent = Color.parseColor("#4CC2FF")
    val dialogView = LinearLayout(this).apply {
        orientation = LinearLayout.VERTICAL
        setPadding(dp(20), dp(16), dp(20), dp(8))
    }
    dialogView.addView(TextView(this).apply {
        text = "Size: $sizeText"
        iconStart(R.drawable.ic_w_box, 14, muted, 6)
        textSize = 13f
        setTextColor(muted)
        setPadding(0, 0, 0, dp(4))
    })

    // ── save folder: shows where the file goes, "Change" opens the system folder picker ──
    val folderText = TextView(this).apply {
        iconStart(R.drawable.ic_w_folder, 14, muted, 6)
        textSize = 13f
        setTextColor(muted)
        layoutParams = LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1f)
    }
    fun chip(label: String, onClick: () -> Unit) = TextView(this).apply {
        text = label; textSize = 12.5f; setTextColor(accent)
        typeface = Typeface.DEFAULT_BOLD
        setPadding(dp(10), dp(6), dp(10), dp(6))
        setOnClickListener { onClick() }
    }
    var refreshFolder: () -> Unit = {}
    val changeBtn = chip("Change") {
        dlFolderCallback = { refreshFolder() }
        try {
            dlFolderLauncher.launch(Intent(Intent.ACTION_OPEN_DOCUMENT_TREE).addFlags(
                Intent.FLAG_GRANT_READ_URI_PERMISSION or Intent.FLAG_GRANT_WRITE_URI_PERMISSION or
                    Intent.FLAG_GRANT_PERSISTABLE_URI_PERMISSION or Intent.FLAG_GRANT_PREFIX_URI_PERMISSION))
        } catch (e: Exception) {
            Toast.makeText(this, "No folder picker found on this phone", Toast.LENGTH_SHORT).show()
        }
    }
    val resetBtn = chip("Default") { DlEngine.destTree = ""; refreshFolder() }
    refreshFolder = {
        folderText.text = "Saved to: " + DlEngine.folderLabel()
        resetBtn.visibility = if (DlEngine.activeDestTree().isEmpty()) View.GONE else View.VISIBLE
    }
    refreshFolder()
    dialogView.addView(LinearLayout(this).apply {
        orientation = LinearLayout.HORIZONTAL
        gravity = Gravity.CENTER_VERTICAL
        setPadding(0, 0, 0, dp(8))
        addView(folderText)
        addView(resetBtn)
        addView(changeBtn)
    })

    dialogView.addView(TextView(this).apply {
        text = "File name (editable):"
        textSize = 13f
        setTextColor(Color.parseColor("#E6E9F0"))
        typeface = Typeface.DEFAULT_BOLD
        setPadding(0, 0, 0, dp(4))
    })
    val fileNameInput = EditText(this).apply {
        setText(defaultName); textSize = 14f; setSingleLine(true); post { selectAll() }
    }.glassStyle()
    dialogView.addView(fileNameInput)

    // ── batch numbering ──
    fun digitsOnly(t: CharSequence) = t.filter { it.isDigit() }.take(9).toString()
    fun padded(n: Long, pad: Int) = n.toString().padStart(pad, '0')
    val batchCheck = CheckBox(this).apply {
        text = "Batch numbering (000, 001, 002 …)"
        textSize = 13f
        setTextColor(Color.parseColor("#E6E9F0"))
        buttonTintList = ColorStateList.valueOf(accent)
        isChecked = DlEngine.batchOn
        setPadding(dp(4), dp(6), 0, dp(6))
    }
    dialogView.addView(batchCheck, LinearLayout.LayoutParams(
        ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT).apply { topMargin = dp(8) })

    val prefixInput = EditText(this).apply {
        hint = "Prefix (optional)"; setText(DlEngine.batchPrefix); textSize = 14f; setSingleLine(true)
    }.glassStyle()
    val startInput = EditText(this).apply {
        hint = "Start from"; inputType = InputType.TYPE_CLASS_NUMBER
        setText(padded(DlEngine.batchNext, DlEngine.batchPad)); textSize = 14f; setSingleLine(true)
    }.glassStyle()
    val preview = TextView(this).apply {
        textSize = 12.5f; setTextColor(accent); setPadding(0, dp(6), 0, 0)
    }
    val batchBox = LinearLayout(this).apply {
        orientation = LinearLayout.VERTICAL
        addView(LinearLayout(this@showDownloadDialog).apply {
            orientation = LinearLayout.HORIZONTAL
            addView(prefixInput, LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1f).apply { rightMargin = dp(8) })
            addView(startInput, LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1f))
        })
        addView(preview)
    }
    dialogView.addView(batchBox)

    /** Final name for batch mode: prefix + number (zero padding = the digits typed in "Start from") + the extension above. */
    fun batchName(): Pair<String, Long>? {
        val digits = digitsOnly(startInput.text)
        if (digits.isEmpty()) return null
        val n = digits.toLongOrNull() ?: return null
        val ext = fileNameInput.text.toString().trim().substringAfterLast('.', "")
        val base = prefixInput.text.toString().trim() + padded(n, digits.length)
        return (if (ext.isNotEmpty() && ext.length <= 10) "$base.$ext" else base) to n
    }
    fun updateBatchUi() {
        batchBox.visibility = if (batchCheck.isChecked) View.VISIBLE else View.GONE
        val bn = batchName()
        preview.text = if (bn == null) "Type the number to start from" else "Will save as: ${bn.first}  (next: ${padded(bn.second + 1, digitsOnly(startInput.text).length)})"
        fileNameInput.alpha = if (batchCheck.isChecked) 0.6f else 1f
    }
    batchCheck.setOnCheckedChangeListener { _, _ -> updateBatchUi() }
    fileNameInput.onTextChanged { updateBatchUi() }
    prefixInput.onTextChanged { updateBatchUi() }
    startInput.onTextChanged { updateBatchUi() }
    updateBatchUi()

    val scroller = ScrollView(this).apply { addView(dialogView) }
    W11Dialog.Builder(this).setTitle("Download File").setIcon(R.drawable.ic_w_download).setView(scroller)
        .setPositiveButton("Download") { _, _ ->
            val bn = if (batchCheck.isChecked) batchName() else null
            val wanted = if (bn != null) sanitizeFileName(bn.first)
            else sanitizeFileName(fileNameInput.text.toString().trim().ifBlank { defaultName })
            val digits = digitsOnly(startInput.text)
            val prefix = prefixInput.text.toString().trim()
            // same name already in the folder (or being downloaded)? -> rename / overwrite dialog first
            resolveNameConflict(wanted) { finalName, overwrite ->
                if (bn != null) {
                    DlEngine.batchOn = true
                    DlEngine.batchPrefix = prefix
                    DlEngine.batchPad = digits.length
                    DlEngine.batchNext = bn.second + 1
                } else DlEngine.batchOn = false
                DlEngine.overwriteOnce = overwrite
                try { onConfirm(finalName) } finally { DlEngine.overwriteOnce = false }
            }
        }.setNegativeButton("Cancel", null).show()
}

/**
 * Checks [name] against the save folder (and against downloads that are still running). No clash: [onResolved] gets
 * (name, false) at once. Clash: a dialog offers Rename (type a new name, " (1)" is suggested), Overwrite
 * (the old file is replaced when the new download has finished) or Cancel; [onResolved] is not called on Cancel.
 */
internal fun MainActivity.resolveNameConflict(name: String, onResolved: (finalName: String, overwrite: Boolean) -> Unit) {
    Thread {
        val taken = try { DlEngine.nameTaken(name) } catch (e: Exception) { false }
        if (!taken) { runOnUiThread { onResolved(name, false) }; return@Thread }
        val free = try { DlEngine.freeName(name) } catch (e: Exception) { name }
        runOnUiThread { showNameConflictDialog(name, free, onResolved) }
    }.start()
}

private fun MainActivity.showNameConflictDialog(
    name: String, suggested: String, onResolved: (finalName: String, overwrite: Boolean) -> Unit
) {
    val muted = Color.parseColor("#B8C0D0")
    var dlg: W11Dialog? = null
    val box = LinearLayout(this).apply {
        orientation = LinearLayout.VERTICAL
        setPadding(dp(20), dp(12), dp(20), dp(8))
    }
    box.addView(TextView(this).apply {
        text = "\"$name\" already exists in ${DlEngine.folderLabel()} (or is being downloaded right now)."
        textSize = 13.5f; setTextColor(Color.parseColor("#E6E9F0")); setPadding(0, 0, 0, dp(10))
    })
    box.addView(TextView(this).apply {
        text = "Rename the new file:"; textSize = 12.5f; setTextColor(muted); setPadding(0, 0, 0, dp(4))
    })
    val nameInput = EditText(this).apply { setText(suggested); textSize = 14f; setSingleLine(true) }.glassStyle()
    box.addView(nameInput)
    box.addView(TextView(this).apply {
        text = "Overwrite"
        textSize = 13.5f; typeface = Typeface.DEFAULT_BOLD; gravity = Gravity.CENTER
        setTextColor(Color.WHITE)
        background = android.graphics.drawable.GradientDrawable().apply {
            cornerRadius = dp(8).toFloat(); setColor(Color.parseColor("#C0392B"))
        }
        setPadding(dp(12), dp(10), dp(12), dp(10))
        setOnClickListener { dlg?.dismiss(); onResolved(name, true) }
    }, LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT).apply { topMargin = dp(14) })
    box.addView(TextView(this).apply {
        text = "Overwrite replaces the old file once the new download has finished."
        textSize = 11.5f; setTextColor(muted); setPadding(0, dp(4), 0, 0)
    })
    dlg = W11Dialog.Builder(this).setTitle("File already exists").setIcon(R.drawable.ic_w_download).setView(box)
        .setPositiveButton("Rename") { _, _ ->
            val typed = sanitizeFileName(nameInput.text.toString().trim().ifBlank { suggested })
            resolveNameConflict(typed, onResolved)   // the new name may clash too: check again
        }
        .setNegativeButton("Cancel", null).show()
}


internal fun MainActivity.downloadWithManager(
    url: String, userAgentStr: String, contentDisposition: String,
    mimetype: String, contentLength: Long, webView: WebView
) {
    try {
        val rawName = guessDownloadName(url, contentDisposition, mimetype)
        val defaultFileName = sanitizeFileName(rawName)
        val cookies = CookieManager.getInstance().getCookie(url) ?: ""
        val ua = if (userAgentStr.isBlank()) {
            try { webView.settings.userAgentString } catch (e: Exception) { userAgentStr }
        } else userAgentStr
        val referer = try { webView.url ?: "" } catch (e: Exception) { "" }
        val sizeText = if (contentLength > 0) getSize(contentLength) else "Unknown size"
        showDownloadDialog(sizeText, defaultFileName) { fileName ->
            enqueueDownload(url, fileName, mimetype, cookies, ua, referer, contentLength)
        }
    } catch (e: Exception) {
        Toast.makeText(this, "Download error: ${e.message}", Toast.LENGTH_SHORT).show()
    }
}

/** blob: URLs only exist inside the page, so the page streams the bytes to us. */

internal fun MainActivity.downloadBlobUrl(blobUrl: String, webView: WebView) {
    val q = "(function(u){try{var n=(window.__w11names||{})[u]||'';" +
            "var i=(window.__w11types||{})[u]||{};" +
            "return JSON.stringify({n:n,t:i.type||'',s:i.size||0});}" +
            "catch(e){return JSON.stringify({n:'',t:'',s:0});}})(" +
            org.json.JSONObject.quote(blobUrl) + ")"
    webView.evaluateJavascript(q) { raw ->
        var name = ""; var mime = ""; var size = 0L
        try {
            val str = org.json.JSONTokener(raw).nextValue() as? String
            if (str != null) {
                val o = org.json.JSONObject(str)
                name = o.optString("n"); mime = o.optString("t"); size = o.optLong("s")
            }
        } catch (e: Exception) { }
        val ext = MimeTypeMap.getSingleton().getExtensionFromMimeType(mime) ?: ""
        if (name.isBlank()) name = "download_${System.currentTimeMillis()}" + (if (ext.isNotEmpty()) ".$ext" else "")
        else if (!name.contains('.') && ext.isNotEmpty()) name = "$name.$ext"
        val finalName = sanitizeFileName(name)
        showDownloadDialog(if (size > 0) getSize(size) else "Unknown size", finalName) { chosen ->
            ensureNotifPermission()
            val task = DlEngine.beginBlob(chosen, mime, size)
            webView.evaluateJavascript(blobTransferJs(org.json.JSONObject.quote(blobUrl), task.id), null)
            Toast.makeText(this, "Download started: $chosen", Toast.LENGTH_SHORT).show()
            updateDownloadBadge()
        }
    }
}


internal fun MainActivity.downloadDataUrl(dataUrl: String, overrideMime: String = "") {
    Thread {
        try {
            val commaIdx = dataUrl.indexOf(',')
            if (commaIdx == -1) {
                runOnUiThread {
                    Toast.makeText(this, "Invalid data URL", Toast.LENGTH_SHORT).show()
                }; return@Thread
            }
            val header = dataUrl.substring(0, commaIdx)
            val payload = dataUrl.substring(commaIdx + 1)
            val mimeType = if (overrideMime.isNotEmpty()) overrideMime
            else header.substringAfter("data:").substringBefore(";")
                .ifBlank { "application/octet-stream" }
            val ext = MimeTypeMap.getSingleton().getExtensionFromMimeType(mimeType) ?: "bin"
            val fileName = "download_${System.currentTimeMillis()}.$ext"
            val bytes = if (header.contains("base64")) Base64.decode(payload, Base64.DEFAULT)
            else Uri.decode(payload).toByteArray(Charsets.UTF_8)
            DlEngine.saveBytes(fileName, mimeType, bytes)
            runOnUiThread {
                ensureNotifPermission()
                Toast.makeText(this, "Saving: $fileName", Toast.LENGTH_SHORT).show()
                updateDownloadBadge()
            }
        } catch (e: Exception) {
            runOnUiThread {
                Toast.makeText(
                    this, "Data URL save failed: ${e.message}", Toast.LENGTH_SHORT
                ).show()
            }
        }
    }.start()
}


internal fun MainActivity.showLinkDialog(link: String, webView: WebView) {
    // Seal part 6: "Download with Downloader" (the built-in :seal app, yt-dlp) only for http / https links
    val withSeal = isSealUrl(link)
    val options = if (withSeal) arrayOf("Open in new tab", "Download link", "Download with $SEAL_NAME", "Copy link")
    else arrayOf("Open in new tab", "Download link", "Copy link")
    W11Dialog.Builder(this).setTitle(link).setItems(options) { _, which ->
        when (options[which]) {
            "Open in new tab" -> addNewTab(link, switch = true)
            "Download link" -> {
                if (link.startsWith("blob:")) downloadBlobUrl(link, webView)
                else if (link.startsWith("data:")) downloadDataUrl(link)
                else downloadWithManager(link, "", "", "", -1L, webView)
            }
            "Download with $SEAL_NAME" -> openSealWithUrl(link)
            "Copy link" -> copyText(link)
        }
    }.setNegativeButton("Cancel", null).show()
}


internal fun MainActivity.downloadManually(
    url: String, cookies: String, userAgent: String,
    contentDisposition: String, mimetype: String, customFileName: String? = null
) {
    val fileName = customFileName
        ?: sanitizeFileName(guessDownloadName(url, contentDisposition, mimetype))
    Toast.makeText(this, "Manual download: $fileName", Toast.LENGTH_SHORT).show()
    Thread {
        var connection: HttpURLConnection? = null
        var inputStream: InputStream? = null
        try {
            connection = URL(url).openConnection() as HttpURLConnection
            connection.connectTimeout = 30_000
            connection.readTimeout = 60_000
            connection.setRequestProperty("User-Agent", userAgent)
            if (cookies.isNotEmpty()) connection.setRequestProperty("Cookie", cookies)
            connection.setRequestProperty("Accept", "*/*")
            connection.instanceFollowRedirects = true
            connection.connect()
            val code = connection.responseCode
            if (code !in 200..299) {
                runOnUiThread {
                    Toast.makeText(
                        this, "Server error: HTTP $code", Toast.LENGTH_LONG
                    ).show()
                }; return@Thread
            }
            inputStream = connection.inputStream
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                val cv = ContentValues().apply {
                    put(MediaStore.Downloads.DISPLAY_NAME, fileName)
                    put(
                        MediaStore.Downloads.MIME_TYPE,
                        mimetype.ifBlank { "application/octet-stream" }
                    )
                    put(
                        MediaStore.Downloads.RELATIVE_PATH,
                        Environment.DIRECTORY_DOWNLOADS
                    )
                    put(MediaStore.Downloads.IS_PENDING, 1)
                }
                val uri =
                    contentResolver.insert(MediaStore.Downloads.EXTERNAL_CONTENT_URI, cv)
                if (uri != null) {
                    contentResolver.openOutputStream(uri)
                        ?.use { inputStream.copyTo(it, 8192) }
                    cv.clear()
                    cv.put(MediaStore.Downloads.IS_PENDING, 0)
                    contentResolver.update(uri, cv, null, null)
                    runOnUiThread {
                        Toast.makeText(
                            this, "ডাউনলোড সম্পন্ন: $fileName", Toast.LENGTH_LONG
                        ).show()
                    }
                } else runOnUiThread {
                    Toast.makeText(this, "Storage write failed", Toast.LENGTH_SHORT).show()
                }
            } else {
                val destDir =
                    Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
                destDir.mkdirs()
                FileOutputStream(File(destDir, fileName)).use {
                    inputStream.copyTo(it, 8192)
                }
                runOnUiThread {
                    Toast.makeText(
                        this, "ডাউনলোড সম্পন্ন: $fileName", Toast.LENGTH_LONG
                    ).show()
                }
            }
        } catch (e: Exception) {
            runOnUiThread {
                Toast.makeText(
                    this, "Download failed: ${e.message}", Toast.LENGTH_LONG
                ).show()
            }
        } finally {
            try { inputStream?.close() } catch (e: Exception) { }
            try { connection?.disconnect() } catch (e: Exception) { }
        }
    }.start()
}


internal fun MainActivity.registerDownloadReceiver() {
    if (downloadReceiver != null) return
    downloadReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            val id =
                intent?.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, -1L) ?: return
            val fileName = activeDownloads.remove(id) ?: return
            val dm = getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
            val cursor = dm.query(DownloadManager.Query().setFilterById(id))
            if (cursor.moveToFirst()) {
                val statusCol = cursor.getColumnIndex(DownloadManager.COLUMN_STATUS)
                when (if (statusCol >= 0) cursor.getInt(statusCol) else -1) {
                    DownloadManager.STATUS_SUCCESSFUL ->
                        Toast.makeText(
                            act,
                            "ডাউনলোড সম্পন্ন: $fileName",
                            Toast.LENGTH_LONG
                        ).show()
                    DownloadManager.STATUS_FAILED -> {
                        val rc =
                            cursor.getColumnIndex(DownloadManager.COLUMN_REASON)
                        val reason = if (rc >= 0) cursor.getInt(rc) else 0
                        Toast.makeText(
                            act,
                            "ব্যর্থ (${downloadFailReason(reason)})",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
            cursor.close()
        }
    }
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        registerReceiver(
            downloadReceiver,
            IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE),
            Context.RECEIVER_NOT_EXPORTED
        )
    } else {
        @Suppress("UnspecifiedRegisterReceiverFlag")
        registerReceiver(
            downloadReceiver,
            IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE)
        )
    }
}


internal fun MainActivity.downloadFailReason(reason: Int): String = when (reason) {
    DownloadManager.ERROR_CANNOT_RESUME -> "Resume করা যাচ্ছে না"
    DownloadManager.ERROR_DEVICE_NOT_FOUND -> "Storage পাওয়া যাচ্ছে না"
    DownloadManager.ERROR_FILE_ALREADY_EXISTS -> "ফাইল আগে থেকে আছে"
    DownloadManager.ERROR_FILE_ERROR -> "ফাইল error"
    DownloadManager.ERROR_HTTP_DATA_ERROR -> "HTTP data error"
    DownloadManager.ERROR_INSUFFICIENT_SPACE -> "স্টোরেজ কম"
    DownloadManager.ERROR_TOO_MANY_REDIRECTS -> "অনেক redirect"
    DownloadManager.ERROR_UNHANDLED_HTTP_CODE -> "Unsupported HTTP code"
    DownloadManager.ERROR_UNKNOWN -> "অজানা error"
    else -> "Error code: $reason"
}


internal fun MainActivity.sanitizeFileName(name: String): String {
    val cleaned = name.replace(Regex("[\\\\/:*?\"<>|]"), "_").trim()
    return if (cleaned.length > 200) cleaned.substring(0, 200)
    else cleaned.ifBlank { "download_${System.currentTimeMillis()}" }
}

// =====================================================================
// BACK BUTTON
// =====================================================================


internal fun MainActivity.createTabButton(
    text: String, selected: Boolean, onClick: () -> Unit
): TextView {
    return TextView(this).apply {
        this.text = text
        setTextColor(Color.WHITE)
        gravity = Gravity.CENTER
        typeface = Typeface.DEFAULT_BOLD
        textSize = 12f
        layoutParams = LinearLayout.LayoutParams(
            0, ViewGroup.LayoutParams.MATCH_PARENT, 1f
        )
        setBackgroundColor(
            if (selected) Color.parseColor("#333333") else Color.TRANSPARENT
        )
        setOnClickListener {
            for (i in 0 until tabLayout.childCount) {
                tabLayout.getChildAt(i)?.setBackgroundColor(Color.TRANSPARENT)
            }
            setBackgroundColor(Color.parseColor("#333333"))
            onClick()
        }
    }
}


// ── Camera step 7: Browser <-> built-in Camera ───────────────────────────────────────────────────────

private val IMAGE_EXT = setOf(".jpg", ".jpeg", ".png", ".gif", ".webp", ".heic", ".heif", ".bmp")
private val VIDEO_EXT = setOf(".mp4", ".mov", ".3gp", ".webm", ".mkv", ".m4v")

/** "image", "video" or null (anything else) for one `accept` entry of a page (MIME type, family or extension). */
private fun acceptKind(type: String): String? {
    val t = type.trim().lowercase()
    return when {
        t.startsWith("image/") || t in IMAGE_EXT -> "image"
        t.startsWith("video/") || t in VIDEO_EXT -> "video"
        else -> null
    }
}

/** True when the page takes photos / videos: no `accept` at all, or at least one image / video entry. */
internal fun uploadAcceptsMedia(accept: List<String>): Boolean =
    accept.isEmpty() || accept.any { acceptKind(it) != null }

/**
 * The built-in Camera in capture mode for a page's upload: video when the page accepts only videos, photo otherwise; the
 * photo / video switch is hidden when the page accepts only one of the two kinds.
 */
internal fun MainActivity.uploadCameraIntent(accept: List<String>): Intent {
    val kinds = accept.map { acceptKind(it) }
    val onlyOneKind = accept.isNotEmpty() && kinds.all { it != null } && kinds.toSet().size == 1
    val mode = if (onlyOneKind && kinds.first() == "video") com.srizwan.camera.CameraActivity.MODE_VIDEO
    else com.srizwan.camera.CameraActivity.MODE_PHOTO
    return com.srizwan.camera.CameraActivity.captureIntent(this, mode, lockMode = onlyOneKind)
}

/**
 * A website wants the camera and / or the microphone. The user is asked first (which site, which device), then Android's own
 * permission if the app does not hold it yet; only then the page gets the stream.
 */
internal fun MainActivity.handleWebPermission(request: PermissionRequest) {
    val wantsVideo = PermissionRequest.RESOURCE_VIDEO_CAPTURE in request.resources
    val wantsAudio = PermissionRequest.RESOURCE_AUDIO_CAPTURE in request.resources
    if (!wantsVideo && !wantsAudio) { request.deny(); return } // other resources (protected media id, MIDI) are not offered
    val what = when {
        wantsVideo && wantsAudio -> "camera and microphone"
        wantsVideo -> "camera"
        else -> "microphone"
    }
    val site = request.origin?.host ?: request.origin?.toString().orEmpty()
    try {
        W11Dialog.Builder(this)
            .setTitle("Allow $what?")
            .setMessage("$site wants to use your $what.")
            .setPositiveButton("Allow") { _, _ -> askAndroidPermissionForWeb(request, wantsVideo, wantsAudio) }
            .setNegativeButton("Block") { _, _ -> request.deny() }
            .setCancelable(false)
            .show()
    } catch (e: Exception) {
        request.deny()
    }
}

private fun MainActivity.askAndroidPermissionForWeb(request: PermissionRequest, video: Boolean, audio: Boolean) {
    val missing = ArrayList<String>()
    if (video && ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED)
        missing += Manifest.permission.CAMERA
    if (audio && ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED)
        missing += Manifest.permission.RECORD_AUDIO
    pendingWebPermission?.deny() // an older request that never got its answer
    pendingWebPermission = request
    if (missing.isEmpty()) finishWebPermission() else webPermissionLauncher.launch(missing.toTypedArray())
}

/** Android answered (or nothing was missing): give the page what is now allowed, deny the rest. */
internal fun MainActivity.finishWebPermission() {
    val request = pendingWebPermission ?: return
    pendingWebPermission = null
    val granted = ArrayList<String>()
    if (PermissionRequest.RESOURCE_VIDEO_CAPTURE in request.resources &&
        ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED
    ) granted += PermissionRequest.RESOURCE_VIDEO_CAPTURE
    if (PermissionRequest.RESOURCE_AUDIO_CAPTURE in request.resources &&
        ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) == PackageManager.PERMISSION_GRANTED
    ) granted += PermissionRequest.RESOURCE_AUDIO_CAPTURE
    try {
        if (granted.isEmpty()) request.deny() else request.grant(granted.toTypedArray())
    } catch (e: Exception) {
        AppLog.e("BrowserUi", "web permission answer failed", e)
    }
}

/**
 * <input type=file> of a page (a tab or a pop-up window): opens the own :chooser file picker (or the camera for `capture`).
 * The page's accept types and its "multiple" flag are passed on; the result comes back through [MainActivity.fileChooserLauncher].
 * Used by the WebChromeClient of the tabs (addNewTab) and of the pop-ups (configurePopupWebView in BrowserPopup.kt).
 */
internal fun MainActivity.openFileChooser(
    filePathCallback: ValueCallback<Array<Uri>>?,
    fileChooserParams: WebChromeClient.FileChooserParams?
): Boolean {
    fileUploadCallback?.onReceiveValue(null)
    fileUploadCallback = filePathCallback
    // Own glass file picker (:chooser, step 8) instead of the system's GET_CONTENT screen. The page's accept types and its
    // "multiple" flag are passed on; the result is content:// uris from ChooserFileProvider, which the WebView reads.
    val accept = fileChooserParams?.acceptTypes
        ?.flatMap { it.split(',') }?.map { it.trim() }?.filter { it.isNotEmpty() }.orEmpty()
    val multiple = fileChooserParams?.mode == WebChromeClient.FileChooserParams.MODE_OPEN_MULTIPLE
    uploadAccept = accept
    // Camera step 7: <input type=file capture> goes straight to the built-in Camera (one photo / video back to the page);
    // if the camera cannot start, the file picker below opens as before.
    if (fileChooserParams?.isCaptureEnabled == true && uploadAcceptsMedia(accept)) {
        try {
            fileChooserLauncher.launch(uploadCameraIntent(accept))
            return true
        } catch (e: Exception) {
            AppLog.e("BrowserUi", "cannot open the camera for a capture upload", e)
        }
    }
    try {
        // the picker gets a Camera button when the page accepts photos / videos (it ends with RESULT_CAMERA, see MainActivity)
        fileChooserLauncher.launch(
            FilePicker.intent(
                this, multiple = multiple, mimeTypes = accept,
                cameraButton = uploadAcceptsMedia(accept)
            )
        )
    } catch (e: Exception) {
        // the picker could not start: the system screen as before
        try {
            fileChooserLauncher.launch(
                Intent(Intent.ACTION_GET_CONTENT).apply {
                    addCategory(Intent.CATEGORY_OPENABLE); type = "*/*"
                }
            )
        } catch (e2: Exception) {
            fileUploadCallback = null
            filePathCallback?.onReceiveValue(null)
            return false
        }
    }
    return true
}

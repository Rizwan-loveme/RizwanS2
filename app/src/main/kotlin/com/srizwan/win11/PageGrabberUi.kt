package com.srizwan.win11

import android.content.ClipData
import android.content.ClipboardManager
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.GradientDrawable
import android.net.Uri
import android.os.Handler
import android.os.Looper
import android.text.Editable
import android.text.InputType
import android.text.TextUtils
import android.text.TextWatcher
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.webkit.CookieManager
import android.widget.CheckBox
import android.widget.EditText
import android.widget.HorizontalScrollView
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.srizwan.video.player.VideoPlayerActivity

// =====================================================================
// PAGE GRABBER - dialog (Media Grabber, steps 6b + 6c)
//
// Opened from the "Page Grabber" pill of the Media Grabber sheet. It drives PgCrawler (PageGrabberCore.kt):
//   - address field (starts with the open page), Level (1 = this page's links, 2 = + linked pages ...), "Same site only"
//   - file types: All, Video, Audio, Image, Document, Compressed, Program, Subtitle, Torrent, Custom (own extensions)
//   - size window (min / max, KB / MB / GB) and duration window (min / max, sec / min / hour; used only where the
//     server tells a duration), sort (found order, name, size, type), "Full file name" (show the whole address)
//   - Grab / Stop, live counters, a filter box over the results
//   - "Include Google Drive and Mega links" (step 6c): Drive files / Docs show their real name, type and size and download through
//     their direct address; a Drive folder is listed (see PageGrabberCore.kt); Mega links are shown as links (Open, Mega app, Copy)
//   - every result: select box, name, type / size / level / host and Play (video, audio), Download, Downloader, Open (Drive / Mega),
//     Mega app (Mega), Copy
//   - selection: Select all / None, Download selected, Copy selected
// The choices are remembered (SharedPreferences "page_grabber"). Closing the dialog stops the crawl.
// Downloads go through the browser's own engine (enqueueDownload: Downloads folder, progress, pause / resume).
// =====================================================================

private const val PG_PREFS = "page_grabber"
private const val PG_ROW_NOTE_CAP = 5000

internal fun MainActivity.showPageGrabber(startUrl: String, referer: String, userAgent: String) {
    val act = this
    val prefs = getSharedPreferences(PG_PREFS, Context.MODE_PRIVATE)
    val ui = Handler(Looper.getMainLooper())
    val lock = Any()

    // ---- state ----
    var level = prefs.getInt("level", 1).coerceIn(1, 6)
    var sameSite = prefs.getBoolean("same_site", false)
    var typeAll = prefs.getBoolean("t_all", true)
    var typeCustom = prefs.getBoolean("t_custom", false)
    val typeOn = LinkedHashMap<PgType, Boolean>()
    for (t in listOf(PgType.VIDEO, PgType.AUDIO, PgType.IMAGE, PgType.DOCUMENT, PgType.COMPRESSED, PgType.PROGRAM, PgType.SUBTITLE, PgType.TORRENT)) {
        typeOn[t] = prefs.getBoolean("t_" + t.name, false)
    }
    var customText = prefs.getString("custom_exts", "").orEmpty()
    var minSizeTxt = prefs.getString("min_size", "").orEmpty()
    var maxSizeTxt = prefs.getString("max_size", "").orEmpty()
    var minSizeUnit = prefs.getString("min_size_unit", "MB").orEmpty()
    var maxSizeUnit = prefs.getString("max_size_unit", "MB").orEmpty()
    var minTimeTxt = prefs.getString("min_time", "").orEmpty()
    var maxTimeTxt = prefs.getString("max_time", "").orEmpty()
    var minTimeUnit = prefs.getString("min_time_unit", "min").orEmpty()
    var maxTimeUnit = prefs.getString("max_time_unit", "min").orEmpty()
    var sort = try { PgSort.valueOf(prefs.getString("sort", "FOUND").orEmpty()) } catch (e: Exception) { PgSort.FOUND }
    var fullName = prefs.getBoolean("full_name", false)
    var providers = prefs.getBoolean("providers", true)

    val results = ArrayList<PgFile>()
    val selected = HashSet<String>()
    var shown: List<PgFile> = emptyList()
    var query = ""
    var running = false
    var wasCanceled = false
    var finishedOnce = false
    var cReq = 0
    var cResp = 0
    var cFound = 0
    var crawler: PgCrawler? = null
    var dialogRef: W11Dialog? = null
    var optionsOpen = true
    var renderRef: (() -> Unit)? = null
    val renderTask = Runnable { if (dialogRef?.isShowing == true) renderRef?.invoke() }
    fun requestRender() { ui.removeCallbacks(renderTask); ui.postDelayed(renderTask, 150) }

    fun toast(t: String) = Toast.makeText(act, t, Toast.LENGTH_SHORT).show()

    fun save() {
        val e = prefs.edit()
        e.putInt("level", level).putBoolean("same_site", sameSite)
            .putBoolean("t_all", typeAll).putBoolean("t_custom", typeCustom)
            .putString("custom_exts", customText)
            .putString("min_size", minSizeTxt).putString("max_size", maxSizeTxt)
            .putString("min_size_unit", minSizeUnit).putString("max_size_unit", maxSizeUnit)
            .putString("min_time", minTimeTxt).putString("max_time", maxTimeTxt)
            .putString("min_time_unit", minTimeUnit).putString("max_time_unit", maxTimeUnit)
            .putString("sort", sort.name).putBoolean("full_name", fullName)
            .putBoolean("providers", providers)
        for ((t, on) in typeOn) e.putBoolean("t_" + t.name, on)
        e.apply()
    }

    fun copy(text: String, what: String) {
        try {
            (getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager)
                .setPrimaryClip(ClipData.newPlainText("links", text))
            toast(what)
        } catch (e: Exception) { toast("Cannot copy") }
    }

    // ---- small view helpers (same look as the Media Grabber sheet) ----
    fun label(text: String, size: Float, color: Int, bold: Boolean = false) = TextView(act).apply {
        this.text = text; textSize = size; setTextColor(color)
        if (bold) typeface = Typeface.DEFAULT_BOLD
    }

    fun pill(text: String, filled: Boolean, small: Boolean = true) = TextView(act).apply {
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
    }

    fun wrap() = LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
    fun gap(start: Int = 8) = wrap().apply { marginStart = dp(start) }

    fun check(text: String, checked: Boolean, onChange: (Boolean) -> Unit) = CheckBox(act).apply {
        this.text = text
        textSize = 12.5f
        setTextColor(Color.WHITE)
        isChecked = checked
        buttonTintList = ColorStateList.valueOf(Color.parseColor("#4CC2FF"))
        setOnCheckedChangeListener { _, b -> onChange(b) }
    }

    fun field(hintText: String, value: String, numeric: Boolean, onText: (String) -> Unit) = EditText(act).apply {
        hint = hintText
        textSize = 13f
        setSingleLine(true)
        if (numeric) inputType = InputType.TYPE_CLASS_NUMBER or InputType.TYPE_NUMBER_FLAG_DECIMAL
        setText(value)
        addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, st: Int, c: Int, a: Int) {}
            override fun onTextChanged(s: CharSequence?, st: Int, b: Int, c: Int) {}
            override fun afterTextChanged(s: Editable?) { onText(s?.toString().orEmpty().trim()) }
        })
    }.glassStyle()

    fun unitChip(options: Array<String>, initial: String, onChange: (String) -> Unit): TextView {
        var idx = options.indexOfFirst { it.equals(initial, true) }.coerceAtLeast(0)
        val chip = pill(options[idx], filled = false)
        chip.setOnClickListener {
            idx = (idx + 1) % options.size
            chip.text = options[idx]
            onChange(options[idx])
        }
        onChange(options[idx])
        return chip
    }

    val sizeUnits = arrayOf("KB", "MB", "GB")
    val timeUnits = arrayOf("sec", "min", "hour")

    // ---- option widgets ----
    val urlBox = field("Page address (https://…)", startUrl, false) { }
    urlBox.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_URI

    val levelValue = label(level.toString(), 15f, Color.WHITE, true).apply { gravity = Gravity.CENTER }
    val levelRow = LinearLayout(act).apply {
        orientation = LinearLayout.HORIZONTAL
        gravity = Gravity.CENTER_VERTICAL
        addView(label("Level", 12.5f, Color.WHITE, true))
        addView(pill("−", filled = false).apply {
            setOnClickListener { if (level > 1) { level--; levelValue.text = level.toString() } }
        }, gap(10))
        addView(levelValue, LinearLayout.LayoutParams(dp(30), ViewGroup.LayoutParams.WRAP_CONTENT))
        addView(pill("+", filled = false).apply {
            setOnClickListener { if (level < 6) { level++; levelValue.text = level.toString() } }
        })
    }
    val levelHelp = label("1 = links of this page only, 2 = also the pages linked from it, 3 = one more hop …", 11f, Color.parseColor("#8A8A8A"))
        .apply { setPadding(0, dp(2), 0, dp(4)) }
    val sameSiteBox = check("Same site only (follow pages on this host and its sub-domains)", sameSite) { sameSite = it }

    val boxes = LinkedHashMap<String, CheckBox>()
    var syncing = false
    fun setBox(key: String, v: Boolean) {
        val b = boxes[key] ?: return
        if (b.isChecked != v) { syncing = true; b.isChecked = v; syncing = false }
    }
    fun onType(key: String, on: Boolean) {
        if (syncing) return
        when (key) {
            "all" -> {
                typeAll = on
                if (on) {
                    typeCustom = false; setBox("custom", false)
                    for (t in typeOn.keys.toList()) { typeOn[t] = false; setBox(t.name, false) }
                }
            }
            "custom" -> {
                typeCustom = on
                if (on) {
                    typeAll = false; setBox("all", false)
                    for (t in typeOn.keys.toList()) { typeOn[t] = false; setBox(t.name, false) }
                }
            }
            else -> {
                typeOn[PgType.valueOf(key)] = on
                if (on) { typeAll = false; typeCustom = false; setBox("all", false); setBox("custom", false) }
            }
        }
        if (!typeAll && !typeCustom && typeOn.values.none { it }) { typeAll = true; setBox("all", true) }
    }
    val typeDefs = listOf(
        "all" to "All", PgType.VIDEO.name to "Video", PgType.AUDIO.name to "Audio", PgType.IMAGE.name to "Image",
        PgType.DOCUMENT.name to "Document", PgType.COMPRESSED.name to "Compressed", PgType.PROGRAM.name to "Program",
        PgType.SUBTITLE.name to "Subtitle", PgType.TORRENT.name to "Torrent", "custom" to "Custom"
    )
    val typeGrid = LinearLayout(act).apply { orientation = LinearLayout.VERTICAL }
    for (rowDefs in typeDefs.chunked(3)) {
        val row = LinearLayout(act).apply { orientation = LinearLayout.HORIZONTAL }
        for ((key, text) in rowDefs) {
            val initial = when (key) { "all" -> typeAll; "custom" -> typeCustom; else -> typeOn[PgType.valueOf(key)] == true }
            val cb = check(text, initial) { onType(key, it) }
            boxes[key] = cb
            row.addView(cb, LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1f))
        }
        typeGrid.addView(row)
    }
    val customBox = field("Custom extensions: mp4, pdf, zip", customText, false) { customText = it }

    fun rangeRow(title: String, minHint: String, minInit: String, maxInit: String,
                 units: Array<String>, minUnitInit: String, maxUnitInit: String,
                 onMin: (String) -> Unit, onMax: (String) -> Unit,
                 onMinUnit: (String) -> Unit, onMaxUnit: (String) -> Unit): View = LinearLayout(act).apply {
        orientation = LinearLayout.VERTICAL
        setPadding(0, dp(6), 0, 0)
        addView(label(title, 12.5f, Color.WHITE, true))
        addView(LinearLayout(act).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER_VERTICAL
            addView(field(minHint, minInit, true, onMin), LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1f))
            addView(unitChip(units, minUnitInit, onMinUnit), gap(6))
            addView(label("–", 14f, Color.WHITE).apply { setPadding(dp(8), 0, dp(8), 0) })
            addView(field("max", maxInit, true, onMax), LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1f))
            addView(unitChip(units, maxUnitInit, onMaxUnit), gap(6))
        })
    }
    val sizeRow = rangeRow("File size", "min", minSizeTxt, maxSizeTxt, sizeUnits, minSizeUnit, maxSizeUnit,
        { minSizeTxt = it }, { maxSizeTxt = it }, { minSizeUnit = it }, { maxSizeUnit = it })
    val timeRow = rangeRow("Duration (only where the server tells it)", "min", minTimeTxt, maxTimeTxt, timeUnits, minTimeUnit, maxTimeUnit,
        { minTimeTxt = it }, { maxTimeTxt = it }, { minTimeUnit = it }, { maxTimeUnit = it })

    fun sortName(s: PgSort) = when (s) {
        PgSort.FOUND -> "Found order"
        PgSort.NAME_ASC -> "Name A → Z"
        PgSort.NAME_DESC -> "Name Z → A"
        PgSort.SIZE_ASC -> "Size small → large"
        PgSort.SIZE_DESC -> "Size large → small"
        PgSort.TYPE -> "Type"
    }
    val sortPill = pill("Sort: " + sortName(sort), filled = false)
    val fullNameBox = check("Full file name (show the whole address)", fullName) { fullName = it; requestRender() }
    val providersBox = check("Include Google Drive and Mega links", providers) { providers = it }
    val providersHelp = label(
        "Drive files and Docs are read for name, type and size and can be downloaded; a public Drive folder is listed. Mega files are encrypted, so Mega links are shown as links only (Open / Mega app / Copy).",
        11f, Color.parseColor("#8A8A8A")
    ).apply { setPadding(dp(4), 0, 0, dp(4)) }

    val optionsBox = LinearLayout(act).apply {
        orientation = LinearLayout.VERTICAL
        setPadding(dp(16), dp(4), dp(16), dp(6))
        addView(urlBox, LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT))
        addView(levelRow.also { it.setPadding(0, dp(8), 0, 0) })
        addView(levelHelp)
        addView(sameSiteBox)
        addView(label("File types", 12.5f, Color.WHITE, true).apply { setPadding(0, dp(6), 0, 0) })
        addView(typeGrid)
        addView(customBox, LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT))
        addView(sizeRow)
        addView(timeRow)
        addView(providersBox.apply { setPadding(paddingLeft, dp(6), paddingRight, paddingBottom) })
        addView(providersHelp)
        addView(LinearLayout(act).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER_VERTICAL
            setPadding(0, dp(8), 0, 0)
            addView(sortPill)
        })
        addView(fullNameBox)
    }
    val screenH = resources.displayMetrics.heightPixels
    val optionsScroll = ScrollView(act).apply {
        isVerticalScrollBarEnabled = false
        addView(optionsBox)
    }

    // ---- results list ----
    val statusView = label("", 11f, Color.parseColor("#8A8A8A")).apply { setPadding(dp(16), dp(4), dp(16), dp(2)) }
    val selView = label("", 11f, Color.parseColor("#4CC2FF")).apply { setPadding(dp(16), 0, dp(16), dp(2)) }
    val actionRow = LinearLayout(act).apply { orientation = LinearLayout.HORIZONTAL; setPadding(dp(16), dp(6), dp(16), 0) }
    val filterBox = EditText(act).apply {
        hint = "Filter results…"; textSize = 13f; setSingleLine(true)
        addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, st: Int, c: Int, a: Int) {}
            override fun onTextChanged(s: CharSequence?, st: Int, b: Int, c: Int) {}
            override fun afterTextChanged(s: Editable?) { query = s?.toString().orEmpty().trim().lowercase(); requestRender() }
        })
    }.glassStyle()

    fun playFile(f: PgFile) { VideoPlayerActivity.start(act, f.directUrl, f.name) }

    /** one file into the download engine; Drive rows go by their direct address, with the cookies of that address */
    fun enqueueOne(f: PgFile, name: String) {
        val cookies = CookieManager.getInstance().getCookie(f.directUrl) ?: ""
        val ref = if (f.provider == PgProvider.DRIVE) "https://drive.google.com/" else referer
        enqueueDownload(f.directUrl, name, f.mime.ifEmpty { DlEngine.guessMime(name) }, cookies, userAgent, ref, f.size)
    }

    fun downloadFile(f: PgFile) {
        val name = sanitizeFileName(f.name)
        showDownloadDialog(pgSizeText(f.size), name) { fileName -> enqueueOne(f, fileName) }
    }

    fun openInTab(f: PgFile) {
        dialogRef?.dismiss()
        addNewTab(f.url, switch = true)
    }

    /** Mega link: the Mega app when it is installed, otherwise a new tab (mega.nz in the browser) */
    fun openMega(f: PgFile) {
        try {
            val i = Intent(Intent.ACTION_VIEW, Uri.parse(f.url)).apply { setPackage("mega.privacy.android.app") }
            act.startActivity(i)
        } catch (e: ActivityNotFoundException) {
            toast("Mega app not installed: opening in a tab")
            openInTab(f)
        } catch (e: Exception) {
            toast("Cannot open the Mega app")
        }
    }

    fun toDownloader(f: PgFile) {
        if (!isSealUrl(f.url)) { toast("$SEAL_NAME needs an http or https link"); return }
        dialogRef?.dismiss()
        openSealWithUrl(f.url)
    }

    fun detailOf(f: PgFile): String {
        val host = pgHostOf(f.url).ifEmpty { f.url }
        val note = if (f.note.isNotEmpty()) "\n" + f.note else ""
        return when (f.provider) {
            PgProvider.DRIVE -> when (f.kind) {
                PgProviderKind.FILE, PgProviderKind.DOC ->
                    (if (f.kind == PgProviderKind.DOC) "Google Doc export · " else "Google Drive · ") + f.type.label +
                        (if (f.ext.isNotEmpty()) " · " + f.ext.uppercase() else "") + " · " + pgSizeText(f.size) + " · level " + f.level
                PgProviderKind.FOLDER -> "Google Drive folder · level ${f.level}$note"
                else -> "Google Drive link · level ${f.level}$note"
            }
            PgProvider.MEGA ->
                (if (f.kind == PgProviderKind.FOLDER) "Mega folder link" else "Mega file link") + " · level ${f.level}$note"
            else -> f.type.label + (if (f.ext.isNotEmpty()) " · " + f.ext.uppercase() else "") +
                " · " + pgSizeText(f.size) + " · level " + f.level + " · " + host
        }
    }

    fun updateSelection() {
        var n = 0
        var total = 0L
        var unknown = 0
        synchronized(lock) {
            for (f in results) if (selected.contains(f.url)) { n++; if (f.size > 0) total += f.size else unknown++ }
        }
        selView.text = if (n == 0) "" else "Selected $n · " + pgSizeText(total) + (if (unknown > 0) " + $unknown unknown" else "")
        selView.visibility = if (n == 0) View.GONE else View.VISIBLE
    }

    class RowHolder(
        val root: LinearLayout, val check: CheckBox, val name: TextView, val detail: TextView,
        val play: TextView, val dl: TextView, val seal: TextView, val openPill: TextView, val megaPill: TextView, val copyPill: TextView
    ) : RecyclerView.ViewHolder(root) {
        var item: PgFile? = null
        var binding = false
    }

    val rowAdapter = object : RecyclerView.Adapter<RowHolder>() {
        override fun getItemCount(): Int = shown.size

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowHolder {
            val root = LinearLayout(act).apply {
                orientation = LinearLayout.VERTICAL
                setPadding(dp(10), dp(8), dp(10), dp(8))
                background = GradientDrawable().apply {
                    cornerRadius = dp(12).toFloat()
                    setColor(Color.parseColor("#262626"))
                    setStroke(1, Color.parseColor("#3A3A3A"))
                }
                layoutParams = RecyclerView.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT
                ).apply { bottomMargin = dp(8) }
            }
            val cb = CheckBox(act).apply { buttonTintList = ColorStateList.valueOf(Color.parseColor("#4CC2FF")) }
            val name = label("", 13f, Color.WHITE, true).apply { maxLines = 2; ellipsize = TextUtils.TruncateAt.END }
            val top = LinearLayout(act).apply {
                orientation = LinearLayout.HORIZONTAL
                gravity = Gravity.CENTER_VERTICAL
                addView(cb)
                addView(name, LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1f))
            }
            val detail = label("", 11f, Color.parseColor("#9A9A9A")).apply {
                maxLines = 2; ellipsize = TextUtils.TruncateAt.END; setPadding(dp(4), dp(2), 0, 0)
            }
            val play = pill("Play", filled = true)
            val dl = pill("Download", filled = false)
            val seal = pill(SEAL_NAME, filled = false)
            val openBtn = pill("Open", filled = true)
            val megaBtn = pill("Mega app", filled = false)
            val cp = pill("Copy", filled = false)
            val pills = LinearLayout(act).apply {
                orientation = LinearLayout.HORIZONTAL
                addView(play); addView(openBtn, gap()); addView(dl, gap()); addView(seal, gap()); addView(megaBtn, gap()); addView(cp, gap())
            }
            root.addView(top)
            root.addView(detail)
            root.addView(HorizontalScrollView(act).apply {
                isHorizontalScrollBarEnabled = false
                overScrollMode = View.OVER_SCROLL_NEVER
                setPadding(0, dp(8), 0, 0)
                addView(pills)
            })
            val h = RowHolder(root, cb, name, detail, play, dl, seal, openBtn, megaBtn, cp)
            cb.setOnCheckedChangeListener { _, b ->
                if (h.binding) return@setOnCheckedChangeListener
                val f = h.item ?: return@setOnCheckedChangeListener
                if (b) selected.add(f.url) else selected.remove(f.url)
                updateSelection()
            }
            name.setOnClickListener { cb.toggle() }
            play.setOnClickListener { h.item?.let { playFile(it) } }
            dl.setOnClickListener { h.item?.let { downloadFile(it) } }
            seal.setOnClickListener { h.item?.let { toDownloader(it) } }
            openBtn.setOnClickListener { h.item?.let { openInTab(it) } }
            megaBtn.setOnClickListener { h.item?.let { openMega(it) } }
            cp.setOnClickListener { h.item?.let { copy(it.url, "Link copied") } }
            return h
        }

        override fun onBindViewHolder(h: RowHolder, position: Int) {
            val f = shown.getOrNull(position) ?: return
            h.item = f
            h.name.text = if (fullName) f.url else f.name
            h.detail.text = detailOf(f)
            h.binding = true
            h.check.isChecked = selected.contains(f.url)
            h.binding = false
            val canGet = pgCanDownload(f)
            val driveFile = f.provider == PgProvider.DRIVE && f.kind == PgProviderKind.FILE
            h.play.visibility = if (canGet && f.kind != PgProviderKind.DOC && (f.type == PgType.VIDEO || f.type == PgType.AUDIO)) View.VISIBLE else View.GONE
            h.dl.visibility = if (canGet) View.VISIBLE else View.GONE
            // the Downloader (yt-dlp) takes ordinary links and Drive file links; it has no Mega, folder or Docs support
            h.seal.visibility = if (f.provider == PgProvider.NONE || driveFile) View.VISIBLE else View.GONE
            h.openPill.visibility = if (f.provider != PgProvider.NONE) View.VISIBLE else View.GONE
            h.megaPill.visibility = if (f.provider == PgProvider.MEGA) View.VISIBLE else View.GONE
        }
    }
    val recycler = RecyclerView(act).apply {
        layoutManager = LinearLayoutManager(act)
        this.adapter = rowAdapter
        setPadding(dp(16), dp(4), dp(16), dp(4))
        clipToPadding = false
        overScrollMode = View.OVER_SCROLL_NEVER
    }

    // ---- crawl control ----
    fun buildFilter(): PgFilter? {
        val exts = customText.split(',', ';', ' ').map { it.trim().trimStart('.').lowercase() }.filter { it.isNotEmpty() }.toSet()
        if (typeCustom && exts.isEmpty()) { toast("Type the extensions for Custom, e.g. mp4, pdf"); return null }
        val types = HashSet<PgType>()
        for ((t, on) in typeOn) if (on) types.add(t)
        if (!typeAll && !typeCustom && types.isEmpty()) { toast("Choose a file type"); return null }
        return PgFilter(
            all = typeAll, custom = typeCustom, customExts = exts, types = types, torrentEnabled = true, providers = providers,
            minSize = pgUnitBytes(minSizeTxt.toDoubleOrNull() ?: 0.0, minSizeUnit),
            maxSize = pgUnitBytes(maxSizeTxt.toDoubleOrNull() ?: 0.0, maxSizeUnit),
            minDurationSec = pgUnitSeconds(minTimeTxt.toDoubleOrNull() ?: 0.0, minTimeUnit),
            maxDurationSec = pgUnitSeconds(maxTimeTxt.toDoubleOrNull() ?: 0.0, maxTimeUnit)
        )
    }

    fun startGrab() {
        var url = urlBox.text.toString().trim()
        if (url.isEmpty()) { toast("Type a page address"); return }
        if (!url.contains("://")) url = "https://$url"
        if (!isSealUrl(url)) { toast("Only http and https addresses"); return }
        val filter = buildFilter() ?: return
        save()
        crawler?.cancel()
        synchronized(lock) { results.clear() }
        selected.clear()
        cReq = 0; cResp = 0; cFound = 0
        running = true; wasCanceled = false; finishedOnce = false
        optionsOpen = false
        val cfg = PgConfig(
            startUrl = url, level = level, subdomainOnly = sameSite, filter = filter,
            cookies = CookieManager.getInstance().getCookie(url) ?: "",
            cookieFor = { u -> CookieManager.getInstance().getCookie(u) ?: "" },
            userAgent = userAgent, referer = referer.ifEmpty { url }
        )
        val c = PgCrawler(cfg, object : PgListener {
            override fun onFile(file: PgFile) {
                synchronized(lock) { if (results.size < PG_ROW_NOTE_CAP) results.add(file) }
                ui.post { requestRender() }
            }
            override fun onProgress(requests: Int, responses: Int, found: Int) {
                cReq = requests; cResp = responses; cFound = found
                ui.post { requestRender() }
            }
            override fun onFinished(canceled: Boolean, requests: Int, found: Int) {
                ui.post {
                    running = false; wasCanceled = canceled; finishedOnce = true
                    cReq = requests; cFound = found
                    requestRender()
                }
            }
        })
        crawler = c
        c.start()
        renderRef?.invoke()
    }

    fun stopGrab() {
        crawler?.cancel()
        running = false
        wasCanceled = true
        finishedOnce = true
        renderRef?.invoke()
    }

    // ---- render ----
    fun render() {
        // the results: filter, then sort
        val snapshot = synchronized(lock) { ArrayList(results) }
        val filtered = if (query.isEmpty()) snapshot
        else snapshot.filter { it.name.lowercase().contains(query) || it.url.lowercase().contains(query) }
        shown = pgSorted(filtered, sort)
        rowAdapter.notifyDataSetChanged()

        // the panel sizes: options open leave less room for the list
        optionsScroll.visibility = if (optionsOpen) View.VISIBLE else View.GONE
        optionsScroll.layoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT, (screenH * 0.30f).toInt()
        )
        recycler.layoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT, (screenH * (if (optionsOpen) 0.20f else 0.40f)).toInt()
        )
        sortPill.text = "Sort: " + sortName(sort)

        // the action row
        actionRow.removeAllViews()
        actionRow.addView(
            pill(if (running) "Stop" else "Grab", filled = !running, small = false).apply {
                setOnClickListener { if (running) stopGrab() else startGrab() }
            }
        )
        actionRow.addView(pill(if (optionsOpen) "Hide options" else "Options", filled = false).apply {
            setOnClickListener { optionsOpen = !optionsOpen; renderRef?.invoke() }
        }, gap())
        actionRow.addView(pill("Select all", filled = false).apply {
            setOnClickListener { for (f in shown) selected.add(f.url); rowAdapter.notifyDataSetChanged(); updateSelection() }
        }, gap())
        actionRow.addView(pill("None", filled = false).apply {
            setOnClickListener { selected.clear(); rowAdapter.notifyDataSetChanged(); updateSelection() }
        }, gap())
        actionRow.addView(pill("Download selected", filled = false).apply {
            setOnClickListener {
                val picks = synchronized(lock) { results.filter { selected.contains(it.url) && pgCanDownload(it) } }
                if (picks.isEmpty()) { toast("Select files first (Mega links and folders cannot be downloaded here)"); return@setOnClickListener }
                fun go() {
                    for (f in picks) enqueueOne(f, sanitizeFileName(f.name))
                }
                if (picks.size > 10) {
                    W11Dialog.confirm(act, "Download ${picks.size} files?", "All selected files are added to the download list.", "Download", "Cancel") { go() }
                } else go()
            }
        }, gap())
        actionRow.addView(pill("Copy selected", filled = false).apply {
            setOnClickListener {
                val picks = synchronized(lock) { results.filter { selected.contains(it.url) } }
                if (picks.isEmpty()) toast("Select files first")
                else copy(picks.joinToString("\n") { it.url }, "${picks.size} links copied")
            }
        }, gap())
        actionRow.addView(pill("Copy all", filled = false).apply {
            setOnClickListener {
                if (shown.isEmpty()) toast("Nothing to copy")
                else copy(shown.joinToString("\n") { it.url }, "${shown.size} links copied")
            }
        }, gap())

        // the status
        val total = synchronized(lock) { results.size }
        statusView.text = when {
            running -> "Grabbing… requests $cReq · answered $cResp · files $cFound"
            finishedOnce && wasCanceled -> "Stopped. Requests $cReq · files $total"
            finishedOnce -> if (total == 0) "Finished: no file matched the filters. Requests $cReq. Try All types or a higher level."
                else "Finished: $total files from $cReq requests" + (if (total >= PG_ROW_NOTE_CAP) " (list capped at $PG_ROW_NOTE_CAP)" else "")
            else -> "Set the options and tap Grab. Level 1 reads this page only. Drive and Mega links are included."
        }
        updateSelection()
    }
    renderRef = { render() }

    sortPill.setOnClickListener {
        val values = PgSort.values()
        W11Dialog.Builder(act).setTitle("Sort").setItems(
            Array(values.size) { sortName(values[it]) }
        ) { _, which -> sort = values[which]; save(); renderRef?.invoke() }.show()
    }

    // ---- build and show ----
    val body = LinearLayout(act).apply {
        orientation = LinearLayout.VERTICAL
        addView(optionsScroll)
        addView(statusView)
        addView(selView)
        addView(HorizontalScrollView(act).apply {
            isHorizontalScrollBarEnabled = false
            overScrollMode = View.OVER_SCROLL_NEVER
            addView(actionRow)
        })
        addView(filterBox, LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT
        ).apply { topMargin = dp(8); leftMargin = dp(16); rightMargin = dp(16) })
        addView(recycler)
    }

    render()
    dialogRef = W11Dialog.Builder(act)
        .setTitle("Page Grabber")
        .setIcon(R.drawable.ic_w_download)
        .setView(body)
        .setNegativeButton("Close", null)
        .show()
    dialogRef?.setOnDismissListener {
        save()
        crawler?.cancel()
        ui.removeCallbacks(renderTask)
    }
}

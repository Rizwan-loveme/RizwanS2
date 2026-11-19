package com.srizwan.win11

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.graphics.Rect
import android.graphics.RectF
import android.graphics.Typeface
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.RippleDrawable
import android.os.Handler
import android.os.Looper
import android.text.TextUtils
import android.view.Gravity
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.HorizontalScrollView
import android.widget.LinearLayout
import android.widget.TextView
import java.io.File
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.concurrent.Executors
import androidx.core.graphics.PathParser
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListUpdateCallback
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SimpleItemAnimator

// =====================================================================
// WINDOWS 11 "THIS PC" / FILE EXPLORER STYLE UI  (mobile friendly)
// Pure Kotlin views – no XML / drawable resources, same as the rest of
// the project. All behaviour (open, delete, rename, ZIP, PDF …) stays in
// MainActivity and is reached through the callbacks below.
// =====================================================================

internal object WX {
    val BG = Color.parseColor("#191919")          // explorer content area
    val BAR = Color.parseColor("#202020")         // title / command bar (same as taskbar)
    val CARD = Color.parseColor("#2B2B2B")
    val CARD_BORDER = Color.parseColor("#383838")
    val TRACK = Color.parseColor("#454545")
    val TEXT = Color.WHITE
    val DIM = Color.parseColor("#9D9D9D")
    val ACCENT = Color.parseColor("#4CC2FF")
    val WARN = Color.parseColor("#FF6B6B")
    val RIPPLE = Color.parseColor("#33FFFFFF")
    // Step 4.4: glass row (frosted card on the dark content area)
    val GLASS = Color.parseColor("#14FFFFFF")          // row fill
    val GLASS_EDGE = Color.parseColor("#1FFFFFFF")     // row 1dp border
    val GLASS_TILE = Color.parseColor("#14FFFFFF")     // icon tile fill
}

/** Small "N items" / size helpers shared by the explorer. */
private fun fmtSize(size: Long): String {
    if (size <= 0) return "0 B"
    val units = arrayOf("B", "KB", "MB", "GB", "TB")
    val dg = (Math.log10(size.toDouble()) / Math.log10(1024.0)).toInt().coerceIn(0, units.size - 1)
    return DecimalFormat("#,##0.#").format(size / Math.pow(1024.0, dg.toDouble())) + " " + units[dg]
}

internal fun fileTypeColor(ext: String): Int = when (ext) {
    "mp4", "mkv", "avi", "mov", "webm", "3gp", "flv", "wmv" -> Color.parseColor("#A78BFA")
    "jpg", "jpeg", "png", "gif", "bmp", "webp", "heic" -> Color.parseColor("#29A3E0")
    "mp3", "m4a", "wav", "ogg", "flac", "aac", "opus" -> Color.parseColor("#E8579B")
    "pdf" -> Color.parseColor("#E5484D")
    "txt", "log", "md", "json", "xml", "html" -> Color.parseColor("#6E7B8B")
    "doc", "docx" -> Color.parseColor("#2B7CD3")
    "xls", "xlsx", "csv" -> Color.parseColor("#21A366")
    "ppt", "pptx" -> Color.parseColor("#D24726")
    "zip", "rar", "7z", "tar", "gz" -> Color.parseColor("#E8A33D")
    "apk" -> Color.parseColor("#4CAF50")
    else -> Color.parseColor("#8A8A8A")
}


// ---------------------------------------------------------------------
// File / folder icon (drawn with Canvas, tinted by file type)
// ---------------------------------------------------------------------

class FileIconView(context: Context) : View(context) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply { style = Paint.Style.FILL }
    private val textPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.WHITE
        textAlign = Paint.Align.CENTER
        typeface = Typeface.DEFAULT_BOLD
    }
    private val rect = RectF()
    private val doc = Path().apply {
        moveTo(6f, 2f); lineTo(14f, 2f); lineTo(20f, 8f); lineTo(20f, 20f)
        quadTo(20f, 22f, 18f, 22f); lineTo(6f, 22f); quadTo(4f, 22f, 4f, 20f)
        lineTo(4f, 4f); quadTo(4f, 2f, 6f, 2f); close()
    }
    private val fold = Path().apply {
        moveTo(14f, 2f); lineTo(14f, 6f); quadTo(14f, 8f, 16f, 8f); lineTo(20f, 8f); close()
    }

    private var isFolder = false
    private var hasItems = false
    private var tint = Color.parseColor("#8A8A8A")
    private var label = ""

    /** [filled] (4.12): the folder has items, so a paper sheet peeks out of it; empty / unknown stays plain. */
    fun setFolder(hidden: Boolean, filled: Boolean = false) {
        isFolder = true
        hasItems = filled
        label = ""
        alpha = if (hidden) 0.6f else 1f
        invalidate()
    }

    fun setFile(color: Int, ext: String, hidden: Boolean) {
        isFolder = false
        tint = color
        label = ext
        alpha = if (hidden) 0.6f else 1f
        invalidate()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val s = minOf(width, height) / 24f
        canvas.save()
        canvas.translate((width - 24f * s) / 2f, (height - 24f * s) / 2f)
        canvas.scale(s, s)
        if (isFolder) {
            // back tab + back panel (darker), front panel (lighter) – Win11 folder look
            paint.color = Color.parseColor("#E5A100")
            rect.set(2f, 3.5f, 11f, 9f); canvas.drawRoundRect(rect, 1.6f, 1.6f, paint)
            rect.set(2f, 6f, 22f, 20.5f); canvas.drawRoundRect(rect, 2f, 2f, paint)
            if (hasItems) {                                    // 4.12: paper sheet = the folder is not empty
                paint.color = Color.parseColor("#F4F4F4")
                rect.set(12.6f, 4.2f, 19.6f, 12f); canvas.drawRoundRect(rect, 1.2f, 1.2f, paint)
            }
            paint.color = Color.parseColor("#FFD25E")
            rect.set(2f, 8.5f, 22f, 20.5f); canvas.drawRoundRect(rect, 2f, 2f, paint)
        } else {
            paint.color = tint
            canvas.drawPath(doc, paint)
            paint.color = Color.parseColor("#66FFFFFF")
            canvas.drawPath(fold, paint)
            if (label.isNotEmpty()) {
                textPaint.textSize = 5.4f
                val w = textPaint.measureText(label)
                if (w > 12.5f) textPaint.textSize = 5.4f * 12.5f / w
                canvas.drawText(label, 12f, 17.4f, textPaint)
            }
        }
        canvas.restore()
    }
}

/**
 * Step 4.4: vector icons of the list row, drawn from path data (replaces the text glyphs "›" and "⋮").
 * [CHEVRON] = rounded stroke arrow (same path as `ic_w_chevron_right`), [MORE] = three vertical dots.
 */
internal class RowIconView(context: Context, private val kind: Int) : View(context) {

    companion object {
        const val CHEVRON = 0
        const val MORE = 1
    }

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val chevron: Path? =
        if (kind == CHEVRON) PathParser.createPathFromPathData("M9,6L15,12L9,18") else null

    var tint: Int = WX.DIM
        set(v) { field = v; invalidate() }

    override fun onDraw(canvas: Canvas) {
        val s = minOf(width, height) / 24f
        canvas.save()
        canvas.translate((width - 24f * s) / 2f, (height - 24f * s) / 2f)
        canvas.scale(s, s)
        paint.color = tint
        if (kind == CHEVRON) {
            paint.style = Paint.Style.STROKE
            paint.strokeWidth = 2f
            paint.strokeCap = Paint.Cap.ROUND
            paint.strokeJoin = Paint.Join.ROUND
            chevron?.let { canvas.drawPath(it, paint) }
        } else {
            paint.style = Paint.Style.FILL
            canvas.drawCircle(12f, 5f, 1.9f, paint)
            canvas.drawCircle(12f, 12f, 1.9f, paint)
            canvas.drawCircle(12f, 19f, 1.9f, paint)
        }
        canvas.restore()
    }
}

/** Rounded storage-usage bar (like the drive bar in Windows "This PC"). */
internal class UsageBar(context: Context) : View(context) {
    var fraction = 0f
        set(v) { field = v.coerceIn(0f, 1f); invalidate() }
    var fillColor = WX.ACCENT
        set(v) { field = v; invalidate() }

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val r = RectF()

    override fun onDraw(canvas: Canvas) {
        val w = width.toFloat()
        val h = height.toFloat()
        paint.color = WX.TRACK
        r.set(0f, 0f, w, h)
        canvas.drawRoundRect(r, h / 2f, h / 2f, paint)
        if (fraction > 0f) {
            paint.color = fillColor
            r.set(0f, 0f, maxOf(w * fraction, h), h)
            canvas.drawRoundRect(r, h / 2f, h / 2f, paint)
        }
    }
}

// ---------------------------------------------------------------------
// The explorer screen
// ---------------------------------------------------------------------

/**
 * How the explorer shows its items: [LIST] rows (4.4), [GRID] small cells (4.5) and
 * [LARGE] big preview cards (4.6, made for photos / videos).
 */
enum class ExplorerViewMode { LIST, GRID, LARGE }

class ExplorerUi(
    private val ctx: Context,
    private val onUp: () -> Unit,
    private val onNewFolder: () -> Unit,
    private val onOpenFolder: (File) -> Unit,
    private val onItemClick: (File) -> Unit,
    private val onItemMenu: (File) -> Unit
) {
    private val density = ctx.resources.displayMetrics.density
    private fun dp(v: Int): Int = (v * density).toInt()

    private val dateFmt = SimpleDateFormat("dd/MM/yy HH:mm", Locale.getDefault())

    // ── Step 4.1: background loading ─────────────────────────────
    private val mainHandler = Handler(Looper.getMainLooper())
    private val loader = FolderLoader()
    private var lastDir: File? = null
    private var lastRoot: File? = null
    private val showLoadingRunnable = Runnable { showLoadingState() }

    // ── Step 4.13: shimmer skeleton ──────────────────────────────
    // While a folder loads, ghost items (list row / grid cell / large card, whichever mode is active)
    // with a light band sweeping over them replace the old spinner. A result that arrives right after
    // the skeleton appeared waits until it was visible for SKELETON_MIN_MS, so it never just flashes.
    private var loadGen = 0
    private var skeletonShownAt = 0L
    private var deliverRunnable: Runnable? = null

    // ── Step 4.8: thumbnail cache engine (ThumbCache.kt) ─────────
    // One loader (worker threads, newest request first) per ExplorerUi; the bitmap memory itself is
    // shared (ThumbMemory). Decoders are registered here: images (4.9), video (4.10), APK / audio / PDF
    // (4.11). A file type without a decoder, or a file the decoder has no picture for, keeps its file icon.
    private val thumbs = ThumbLoader(ctx).also {
        ThumbEnv.app = ctx.applicationContext     // 4.11: the APK decoder needs a PackageManager
        ThumbLoader.register(ImageThumbDecoder)   // 4.9 (register() ignores a decoder that is already added)
        ThumbLoader.register(VideoThumbDecoder)   // 4.10
        ThumbLoader.register(ApkThumbDecoder)     // 4.11 real APK icon
        ThumbLoader.register(AudioThumbDecoder)   // 4.11 album art
        ThumbLoader.register(PdfThumbDecoder)     // 4.11 first page
    }

    // ── Step 4.12: folder item counts (FolderCount.kt) ───────────
    // "12 items" of a folder is counted on a background thread, newest request first; a row that leaves
    // the screen cancels its request. The numbers live in a shared memory keyed by folder + its date.
    private val counter = FolderCounter()
    private var refreshQueued = false
    private val refreshRunnable = Runnable {
        refreshQueued = false
        adapter.refreshMeta()
    }

    val root: LinearLayout
    private val crumbRow: LinearLayout
    private val crumbScroll: HorizontalScrollView
    private val pathCaption: TextView
    private val itemsLabel: TextView
    private val recycler: RecyclerView
    private val loadingBox: LinearLayout
    private val skeleton: SkeletonView
    private val stateCard: StateCardView      // 4.14: glass empty / permission / error card
    private val driveTitle: TextView
    private val driveSub: TextView
    private val usageBar: UsageBar
    private val adapter = ExplorerAdapter()

    // ── Step 4.5 / 4.6: List / Grid / Large ──────────────────────
    /** Span count of the grid layout manager: columns of the Grid (4.5) or Large (4.6) mode. */
    private var gridCols = 3
    private val listLm = LinearLayoutManager(ctx)
    private val gridLm = GridLayoutManager(ctx, gridCols).apply {
        spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            // drive card (top) and empty / loading / error box (bottom) take the whole row
            override fun getSpanSize(position: Int): Int =
                when (adapter.getItemViewType(position)) {
                    VT_GRID, VT_LARGE -> 1
                    else -> gridCols
                }
        }
    }
    private var mode = ExplorerViewMode.LIST
    /** Step 4.7: the mode the user asked for last (a fade may still be running towards it). */
    private var pendingMode = ExplorerViewMode.LIST
    /** Step 4.7: the three buttons of the List / Grid / Large switcher. */
    private val modeButtons = LinkedHashMap<ExplorerViewMode, Pair<FrameLayout, ModeIconView>>()
    private val modePrefs by lazy { ctx.getSharedPreferences("explorer_ui", Context.MODE_PRIVATE) }
    /** Step 4.3: the folder whose rows are on screen now (null while loading / after an error). */
    private var shownDir: File? = null

    init {
        root = LinearLayout(ctx).apply {
            orientation = LinearLayout.VERTICAL
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT
            )
            setBackgroundColor(WX.BG)
        }

        // ── Title row: up button + address bar ───────────────────
        val titleRow = LinearLayout(ctx).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER_VERTICAL
            setBackgroundColor(WX.BAR)
            setPadding(dp(8), dp(8), dp(12), dp(4))
        }
        val up = FrameLayout(ctx).apply {
            layoutParams = LinearLayout.LayoutParams(dp(44), dp(44))
            background = ripple(22)
            isClickable = true
            contentDescription = "Up"
            setOnClickListener { onUp() }
            addView(
                VectorIconView(ctx, VectorIconView.BACK),
                FrameLayout.LayoutParams(dp(22), dp(22), Gravity.CENTER)
            )
        }
        titleRow.addView(up)

        val addressBar = LinearLayout(ctx).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER_VERTICAL
            layoutParams = LinearLayout.LayoutParams(0, dp(40), 1f).apply { leftMargin = dp(4) }
            background = GradientDrawable().apply {
                cornerRadius = dp(20).toFloat()
                setColor(WX.CARD)
                setStroke(1, WX.CARD_BORDER)
            }
            setPadding(dp(12), 0, dp(6), 0)
        }
        addressBar.addView(VectorIconView(ctx, VectorIconView.PC).apply {
            layoutParams = LinearLayout.LayoutParams(dp(20), dp(20))
        })
        crumbRow = LinearLayout(ctx).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER_VERTICAL
        }
        crumbScroll = HorizontalScrollView(ctx).apply {
            isHorizontalScrollBarEnabled = false
            overScrollMode = View.OVER_SCROLL_NEVER
            layoutParams = LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, 1f)
                .apply { leftMargin = dp(4) }
            addView(
                crumbRow,
                FrameLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT
                )
            )
        }
        addressBar.addView(crumbScroll)
        titleRow.addView(addressBar)
        root.addView(titleRow)

        // ── Command bar: New folder … N items ────────────────────
        val commandBar = LinearLayout(ctx).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER_VERTICAL
            setBackgroundColor(WX.BAR)
            setPadding(dp(8), dp(0), dp(16), dp(6))
        }
        val newFolder = LinearLayout(ctx).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER_VERTICAL
            layoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, dp(40)
            )
            setPadding(dp(10), 0, dp(14), 0)
            background = ripple(8)
            isClickable = true
            setOnClickListener { onNewFolder() }
        }
        newFolder.addView(FileIconView(ctx).apply {
            layoutParams = LinearLayout.LayoutParams(dp(22), dp(22))
            setFolder(false)
        })
        newFolder.addView(TextView(ctx).apply {
            text = "+ New folder"
            setTextColor(WX.TEXT)
            textSize = 14f
            setPadding(dp(8), 0, 0, 0)
        })
        commandBar.addView(newFolder)
        commandBar.addView(View(ctx).apply {
            layoutParams = LinearLayout.LayoutParams(0, 1, 1f)
        })
        // Step 4.7: List / Grid / Large switcher (one pill, the active mode is highlighted)
        val switcher = LinearLayout(ctx).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER_VERTICAL
            setPadding(dp(2), dp(2), dp(2), dp(2))
            background = GradientDrawable().apply {
                cornerRadius = dp(18).toFloat()
                setColor(WX.CARD)
                setStroke(1, WX.CARD_BORDER)
            }
            layoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT
            ).apply { rightMargin = dp(10) }
        }
        for ((m, kind, desc) in listOf(
            Triple(ExplorerViewMode.LIST, ModeIconView.LIST, "List view"),
            Triple(ExplorerViewMode.GRID, ModeIconView.GRID, "Grid view"),
            Triple(ExplorerViewMode.LARGE, ModeIconView.LARGE, "Large thumbnails")
        )) {
            val icon = ModeIconView(ctx, kind)
            val b = FrameLayout(ctx).apply {
                layoutParams = LinearLayout.LayoutParams(dp(34), dp(30))
                isClickable = true
                contentDescription = desc
                setOnClickListener { setViewMode(m, animate = true) }
                addView(icon, FrameLayout.LayoutParams(dp(18), dp(18), Gravity.CENTER))
            }
            modeButtons[m] = Pair(b, icon)
            switcher.addView(b)
        }
        commandBar.addView(switcher)
        itemsLabel = TextView(ctx).apply {
            setTextColor(WX.DIM)
            textSize = 12f
        }
        commandBar.addView(itemsLabel)
        root.addView(commandBar)

        root.addView(View(ctx).apply {
            setBackgroundColor(WX.CARD_BORDER)
            layoutParams = LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 1)
        })

        // ── Exact path (kept from the old UI) ────────────────────
        pathCaption = TextView(ctx).apply {
            setTextColor(WX.DIM)
            textSize = 10.5f
            setSingleLine(true)
            ellipsize = TextUtils.TruncateAt.START
            setPadding(dp(16), dp(6), dp(16), 0)
        }
        root.addView(pathCaption)

        // ── Drive card (header of the list, scrolls with it) ─────
        val card = LinearLayout(ctx).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(dp(14), dp(12), dp(14), dp(14))
            background = GradientDrawable().apply {
                cornerRadius = dp(12).toFloat()
                setColor(WX.CARD)
                setStroke(1, WX.CARD_BORDER)
            }
        }
        val cardTop = LinearLayout(ctx).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER_VERTICAL
        }
        cardTop.addView(VectorIconView(ctx, VectorIconView.PC).apply {
            layoutParams = LinearLayout.LayoutParams(dp(34), dp(34))
        })
        driveTitle = TextView(ctx).apply {
            text = "Internal storage"
            setTextColor(WX.TEXT)
            textSize = 15f
            typeface = Typeface.create("sans-serif-medium", Typeface.NORMAL)
            setPadding(dp(12), 0, 0, 0)
        }
        cardTop.addView(driveTitle)
        card.addView(cardTop)
        usageBar = UsageBar(ctx).apply {
            layoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, dp(8)
            ).apply { topMargin = dp(10) }
        }
        card.addView(usageBar)
        driveSub = TextView(ctx).apply {
            setTextColor(WX.DIM)
            textSize = 12f
            setPadding(0, dp(8), 0, 0)
        }
        card.addView(driveSub)
        val cardHolder = FrameLayout(ctx).apply {
            setPadding(dp(12), dp(10), dp(12), dp(6))
            addView(
                card,
                FrameLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT
                )
            )
        }

        // Step 4.14: glass state card (empty folder / permission denied / load failed)
        stateCard = StateCardView(
            ctx,
            onRetry = { retry() },
            onNewFolder = { onNewFolder() },
            onAllowAccess = { openStorageAccessSettings(ctx) }
        )

        // Loading state (shown only if a folder takes longer than ~150 ms): step 4.13 shimmer skeleton
        skeleton = SkeletonView(ctx)
        loadingBox = LinearLayout(ctx).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(0, dp(4), 0, 0)
            layoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT
            )
            visibility = View.GONE
            addView(skeleton, LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT))
        }

        val stateBox = LinearLayout(ctx).apply {
            orientation = LinearLayout.VERTICAL
            addView(loadingBox)
            addView(stateCard)
        }

        // ── Step 4.3: RecyclerView instead of ListView ───────────
        // Row 0 = drive card (was addHeaderView), last row = empty / loading / error
        // box (was addFooterView). Rows in between are FileItems.
        adapter.header = cardHolder
        adapter.footer = stateBox
        recycler = RecyclerView(ctx).apply {
            layoutParams = FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT
            )
            layoutManager = listLm
            setHasFixedSize(true)
            // 4.15.1: rows just scrolled off stay attached a little longer (no re-bind when the user
            // flicks back a few rows); the default of 2 re-binds almost every row on a direction change
            setItemViewCacheSize(10)
            setBackgroundColor(WX.BG)
            clipToPadding = false
            setPadding(0, 0, 0, dp(8))
            // a row whose text changes (folder item count) must not blink
            (itemAnimator as? SimpleItemAnimator)?.supportsChangeAnimations = false
            recycledViewPool.setMaxRecycledViews(VT_ITEM, 24)
            recycledViewPool.setMaxRecycledViews(VT_GRID, 48)
            recycledViewPool.setMaxRecycledViews(VT_LARGE, 24)
            addItemDecoration(GridGap())
            // 4.15.1: no new thumbnail decodes while a fling runs; they start the moment it stops
            addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrollStateChanged(rv: RecyclerView, newState: Int) {
                    if (newState == RecyclerView.SCROLL_STATE_SETTLING) thumbs.hold(2500L)
                    else thumbs.release()
                }
            })
            // column count follows the width (rotation, split screen, fold)
            addOnLayoutChangeListener { _, l, t, r, b, ol, ot, or_, ob ->
                val widthChanged = (r - l) != (or_ - ol)
                val heightChanged = (b - t) != (ob - ot)
                if (mode != ExplorerViewMode.LIST && widthChanged) updateColumns(r - l)
                // 4.15.4: the skeleton must refill the new height / width in every mode (also List),
                // and the address bar must still show the current folder (last crumb)
                if ((widthChanged || heightChanged) && loadingBox.visibility == View.VISIBLE) syncSkeleton()
                if (widthChanged) crumbScroll.post { crumbScroll.fullScroll(View.FOCUS_RIGHT) }
            }
            this.adapter = this@ExplorerUi.adapter
        }
        val listFrame = FrameLayout(ctx).apply {
            layoutParams = LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0, 1f)
            addView(recycler)
            // RecyclerView has no ready-made fast scroller: small draggable thumb on top of it
            addView(
                FastScrollBar(ctx, recycler) { dragging ->
                    if (dragging) thumbs.hold(3000L) else thumbs.release()
                },
                FrameLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT
                )
            )
        }
        root.addView(listFrame)

        // Step 4.7: start in the mode the user used last time
        val saved = try { modePrefs.getString("view_mode", null) } catch (e: Exception) { null }
        val startMode = ExplorerViewMode.values().firstOrNull { it.name == saved } ?: ExplorerViewMode.LIST
        pendingMode = startMode
        if (startMode != ExplorerViewMode.LIST) applyMode(startMode)
        updateSwitcher()
    }

    /** Highlight the active mode button of the switcher (accent icon on a soft accent pill). */
    private fun updateSwitcher() {
        for ((m, pair) in modeButtons) {
            val on = m == pendingMode
            pair.second.tint = if (on) WX.ACCENT else WX.DIM
            pair.first.background = if (on) {
                GradientDrawable().apply {
                    cornerRadius = dp(16).toFloat()
                    setColor((WX.ACCENT and 0x00FFFFFF) or 0x33000000)
                }
            } else ripple(16)
        }
    }

    /** Clip [v] and everything inside it (a thumbnail) to rounded corners. */
    private fun clipRound(v: View, radiusDp: Int) {
        v.clipToOutline = true
        v.outlineProvider = object : android.view.ViewOutlineProvider() {
            override fun getOutline(view: View, outline: android.graphics.Outline) {
                outline.setRoundRect(0, 0, view.width, view.height, dp(radiusDp).toFloat())
            }
        }
    }

    /** 4.10: the small dark pill with the video length ("3:25"), put in a corner of a picture. */
    private fun durationBadge(sizeSp: Float, padH: Int, padV: Int, radiusDp: Int): TextView =
        TextView(ctx).apply {
            setTextColor(Color.WHITE)
            textSize = sizeSp
            typeface = Typeface.DEFAULT_BOLD
            setSingleLine(true)
            includeFontPadding = false
            setPadding(dp(padH), dp(padV), dp(padH), dp(padV))
            background = GradientDrawable().apply {
                cornerRadius = dp(radiusDp).toFloat()
                setColor(Color.parseColor("#B3000000"))
            }
            visibility = View.GONE
        }

    private fun ripple(radiusDp: Int): RippleDrawable {
        val mask = GradientDrawable().apply {
            cornerRadius = dp(radiusDp).toFloat()
            setColor(Color.WHITE)
        }
        return RippleDrawable(ColorStateList.valueOf(WX.RIPPLE), null, mask)
    }

    /** Glass card (soft fill + 1dp edge) with a ripple that follows the rounded corners. Used by list rows and grid cells. */
    private fun glassRipple(radiusDp: Int): RippleDrawable {
        val glass = GradientDrawable().apply {
            cornerRadius = dp(radiusDp).toFloat()
            setColor(WX.GLASS)
            setStroke(dp(1), WX.GLASS_EDGE)
        }
        val mask = GradientDrawable().apply {
            cornerRadius = dp(radiusDp).toFloat()
            setColor(Color.WHITE)
        }
        return RippleDrawable(ColorStateList.valueOf(WX.RIPPLE), glass, mask)
    }

    // ── Public API ───────────────────────────────────────────────

    /**
     * Step 4.1 entry point: update the address bar right away, read [dir] on a
     * background thread, then show Content / Empty / Denied / Error.
     * Calling this again cancels the load that is still running.
     */
    fun load(dir: File, storageRoot: File) {
        lastDir = dir
        lastRoot = storageRoot
        renderCrumbs(dir, storageRoot)
        pathCaption.text = dir.absolutePath.replace(storageRoot.absolutePath, "/storage/emulated/0")

        val gen = ++loadGen
        val tStart = android.os.SystemClock.uptimeMillis()   // 4.15.2: timing for the big-folder test
        deliverRunnable?.let { mainHandler.removeCallbacks(it) }
        deliverRunnable = null
        mainHandler.removeCallbacks(showLoadingRunnable)
        mainHandler.postDelayed(showLoadingRunnable, 150L)
        loader.load(dir) { result ->
            mainHandler.removeCallbacks(showLoadingRunnable)
            val deliver = Runnable {
                if (gen != loadGen) return@Runnable      // a newer load / cancel came meanwhile
                deliverRunnable = null
                applyResult(dir, storageRoot, result)
                if (result is FolderResult.Content && result.items.size >= 1000) {
                    try {
                        AppLog.d("ExplorerUi", "${result.items.size} files: tap -> list handed to RecyclerView " +
                            "${android.os.SystemClock.uptimeMillis() - tStart} ms")
                    } catch (e: Throwable) { }
                }
            }
            // 4.13: the skeleton is already on screen -> keep it at least SKELETON_MIN_MS (no flash)
            val wait = if (skeletonShownAt > 0L)
                SKELETON_MIN_MS - (android.os.SystemClock.uptimeMillis() - skeletonShownAt) else 0L
            if (wait > 0L) {
                deliverRunnable = deliver
                mainHandler.postDelayed(deliver, wait)
            } else {
                deliver.run()
            }
        }
    }

    private fun applyResult(dir: File, storageRoot: File, result: FolderResult) {
        when (result) {
            is FolderResult.Content ->
                show(dir, storageRoot, result.items, result.free, result.total)
            is FolderResult.Denied -> showErrorState(
                StateKind.DENIED,
                "Permission denied",
                "This app isn't allowed to open this folder. Allow storage access and try again."
            )
            is FolderResult.Failed -> showErrorState(
                StateKind.FAILED,
                "Couldn't load this folder",
                result.message
            )
        }
    }

    /** Current list mode ([ExplorerViewMode.LIST], [ExplorerViewMode.GRID] or, step 4.6, [ExplorerViewMode.LARGE]). */
    val viewMode: ExplorerViewMode get() = mode

    /**
     * Switch between list, grid and large thumbnails (the three buttons of the switcher call this
     * with [animate] = true). The same items stay on screen and the first visible item stays first.
     * The choice is saved and restored the next time the explorer opens. With [animate] the items
     * fade out, change layout and fade back in with a slight zoom.
     */
    fun setViewMode(newMode: ExplorerViewMode, animate: Boolean = false) {
        pendingMode = newMode
        try { modePrefs.edit().putString("view_mode", newMode.name).apply() } catch (e: Exception) { }
        updateSwitcher()
        recycler.animate().cancel()
        if (!animate || !recycler.isShown || recycler.width == 0) {
            recycler.alpha = 1f
            recycler.scaleX = 1f
            recycler.scaleY = 1f
            applyMode(newMode)
            return
        }
        if (newMode == mode) {           // tapped the active mode again (or came back before the swap)
            recycler.alpha = 1f
            recycler.scaleX = 1f
            recycler.scaleY = 1f
            return
        }
        recycler.animate().alpha(0f).setDuration(90L).withEndAction {
            applyMode(pendingMode)
            recycler.scaleX = 0.96f
            recycler.scaleY = 0.96f
            recycler.animate().alpha(1f).scaleX(1f).scaleY(1f).setDuration(180L).start()
        }.start()
    }

    /** The actual switch: layout manager, row type, columns. */
    private fun applyMode(newMode: ExplorerViewMode) {
        if (newMode == mode) return
        val first = (recycler.layoutManager as? LinearLayoutManager)
            ?.findFirstVisibleItemPosition()?.coerceAtLeast(0) ?: 0
        mode = newMode
        adapter.cellType = when (newMode) {
            ExplorerViewMode.LIST -> VT_ITEM
            ExplorerViewMode.GRID -> VT_GRID
            ExplorerViewMode.LARGE -> VT_LARGE
        }
        if (newMode != ExplorerViewMode.LIST) {
            updateColumns(if (recycler.width > 0) recycler.width else ctx.resources.displayMetrics.widthPixels)
            recycler.layoutManager = gridLm
        } else {
            recycler.layoutManager = listLm
        }
        adapter.notifyDataSetChanged()      // row type changed for every item
        recycler.scrollToPosition(first)
        if (loadingBox.visibility == View.VISIBLE) syncSkeleton()   // 4.13: mode switched during a load
    }

    /**
     * Columns for a list [widthPx] wide. Grid: about one 120dp cell each, 2..8.
     * Large (4.6): about one 170dp card each, 2..5 (two big cards on a phone).
     */
    private fun updateColumns(widthPx: Int) {
        val n = if (mode == ExplorerViewMode.LARGE)
            (widthPx / dp(LARGE_CELL_DP)).coerceIn(2, 5)
        else
            (widthPx / dp(GRID_CELL_DP)).coerceIn(2, 8)
        if (n == gridCols) return
        // 4.15.4: remember the first visible item and its offset, so a rotation / split-screen change
        // keeps the user at the same place in the folder (only while the grid manager is the active one)
        var keepPos = -1
        var keepOff = 0
        if (recycler.layoutManager === gridLm && recycler.childCount > 0) {
            keepPos = gridLm.findFirstVisibleItemPosition()
            if (keepPos >= 0) {
                val v = gridLm.findViewByPosition(keepPos)
                keepOff = if (v != null) v.top - recycler.paddingTop else 0
            }
        }
        try {
            AppLog.d("ExplorerUi", "config: columns $gridCols -> $n (list ${widthPx}px, " +
                "${if (mode == ExplorerViewMode.LARGE) "large" else "grid"}, keep item $keepPos)")
        } catch (e: Throwable) { }
        gridCols = n
        gridLm.spanCount = n
        // 4.15.4: GridGap offsets depend on the span index / count. A row that stays attached keeps its
        // old cached insets (wrong left / right gap after rotation) unless the decorations are refreshed.
        recycler.invalidateItemDecorations()
        if (keepPos >= 0) gridLm.scrollToPositionWithOffset(keepPos, keepOff)
        if (loadingBox.visibility == View.VISIBLE) syncSkeleton()   // 4.13: rotation during a load
    }

    /** Reload the folder that failed (Retry button). */
    fun retry() {
        val d = lastDir ?: return
        val r = lastRoot ?: return
        load(d, r)
    }

    /** Stop any running load (e.g. when the section is closed). */
    fun cancelLoad() {
        loader.cancel()
        loadGen++
        deliverRunnable?.let { mainHandler.removeCallbacks(it) }
        deliverRunnable = null
        mainHandler.removeCallbacks(showLoadingRunnable)
        hideSkeleton()
    }

    /** Release the worker threads for good. Call from Activity.onDestroy(). */
    fun destroy() {
        loadGen++
        deliverRunnable?.let { mainHandler.removeCallbacks(it) }
        deliverRunnable = null
        skeleton.setActive(false)
        // 4.15.3: this handler is private to ExplorerUi, so everything still queued on it
        // (loading delay, count refresh, a diff result) is ours: drop all of it at once.
        mainHandler.removeCallbacksAndMessages(null)
        refreshQueued = false
        loader.shutdown()
        thumbs.shutdown()
        counter.shutdown()
        adapter.release()
        // 4.15.3: running view animations (mode switch fade, state card, loading box) hold the views
        try {
            recycler.animate().cancel()
            loadingBox.animate().cancel()
            stateCard.animate().cancel()
        } catch (e: Exception) { }
        try { AppLog.d("ExplorerUi", "destroy: ${ThumbMemory.describe()}") } catch (e: Throwable) { }
    }

    private fun showLoadingState() {
        counter.cancelAll()
        shownDir = null
        adapter.clear()
        itemsLabel.text = "Loading\u2026"
        stateCard.hide()
        showSkeleton()
    }

    /** 4.13: shape the ghosts like the active mode, fade the skeleton in and start the sweep. */
    private fun showSkeleton() {
        syncSkeleton()
        if (loadingBox.visibility != View.VISIBLE) {
            loadingBox.alpha = 0f
            loadingBox.visibility = View.VISIBLE
            loadingBox.animate().cancel()
            loadingBox.animate().alpha(1f).setDuration(120L).start()
            skeletonShownAt = android.os.SystemClock.uptimeMillis()
        }
        skeleton.setActive(true)
    }

    private fun hideSkeleton() {
        skeleton.setActive(false)
        loadingBox.animate().cancel()
        loadingBox.alpha = 1f
        loadingBox.visibility = View.GONE
        skeletonShownAt = 0L
    }

    /** Ghost shape + column count follow the list mode and the current column count. */
    private fun syncSkeleton() {
        skeleton.configure(
            when (mode) {
                ExplorerViewMode.LIST -> SkeletonView.LIST
                ExplorerViewMode.GRID -> SkeletonView.GRID
                ExplorerViewMode.LARGE -> SkeletonView.LARGE
            },
            gridCols
        )
        val h = recycler.height
        // the drive card sits above the skeleton, so it needs about a screen minus that card
        skeleton.fillHeightPx = (if (h > 0) h else ctx.resources.displayMetrics.heightPixels) - dp(96)
    }

    /** 4.14: [kind] DENIED (no permission) or FAILED (anything else) on the glass state card. */
    private fun showErrorState(kind: StateKind, title: String, message: String) {
        counter.cancelAll()
        shownDir = null
        adapter.clear()
        itemsLabel.text = ""
        hideSkeleton()
        stateCard.show(kind, title, message)
    }

    /**
     * Show [dir] with its [files]. [storageRoot] is /storage/emulated/0.
     * Step 4.2: rows come as [FileItem]s whose size/date were read on the
     * loader thread, so binding a row never touches the disk.
     */
    fun show(dir: File, storageRoot: File, files: List<FileItem>, free: Long, total: Long) {
        // Same folder reloaded (after delete / rename / new folder): DiffUtil animates only the
        // rows that changed and the scroll position stays. A different folder starts at the top.
        val sameFolder = shownDir?.absolutePath == dir.absolutePath
        if (!sameFolder) counter.cancelAll()   // every row is re-bound below: they ask again
        shownDir = dir
        renderCrumbs(dir, storageRoot)

        val storagePath = storageRoot.absolutePath
        pathCaption.text = dir.absolutePath.replace(storagePath, "/storage/emulated/0")

        itemsLabel.text = if (files.size == 1) "1 item" else "${files.size} items"

        if (total > 0) {
            val used = (total - free).coerceAtLeast(0)
            val frac = used.toFloat() / total.toFloat()
            usageBar.fraction = frac
            usageBar.fillColor = if (frac > 0.9f) WX.WARN else WX.ACCENT
            driveSub.text = "${fmtSize(free)} free of ${fmtSize(total)}"
        } else {
            usageBar.fraction = 0f
            driveSub.text = ""
        }

        hideSkeleton()
        if (files.isEmpty()) stateCard.showEmpty() else stateCard.hide()   // 4.14
        adapter.submit(files, animate = sameFolder)
        if (!sameFolder) recycler.scrollToPosition(0)
    }

    private fun renderCrumbs(dir: File, storageRoot: File) {
        crumbRow.removeAllViews()
        val crumbs = ArrayList<Pair<String, File>>()
        val rootPath = storageRoot.absolutePath
        val path = dir.absolutePath
        val under = path == rootPath || path.startsWith("$rootPath/")
        var cur: File
        val rest: String
        if (under) {
            cur = storageRoot
            crumbs.add("Internal storage" to cur)
            rest = path.removePrefix(rootPath)
        } else {
            cur = File("/")
            crumbs.add("/" to cur)
            rest = path
        }
        rest.split("/").filter { it.isNotEmpty() }.forEach { part ->
            cur = File(cur, part)
            crumbs.add(part to cur)
        }

        crumbs.forEachIndexed { i, (label, file) ->
            if (i > 0) {
                crumbRow.addView(TextView(ctx).apply {
                    text = "›"
                    setTextColor(WX.DIM)
                    textSize = 16f
                    gravity = Gravity.CENTER
                })
            }
            val last = i == crumbs.lastIndex
            crumbRow.addView(TextView(ctx).apply {
                text = label
                setTextColor(if (last) WX.TEXT else Color.parseColor("#CFCFCF"))
                textSize = 14f
                if (last) typeface = Typeface.create("sans-serif-medium", Typeface.NORMAL)
                gravity = Gravity.CENTER_VERTICAL
                setSingleLine(true)
                setPadding(dp(8), 0, dp(8), 0)
                layoutParams = LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT
                )
                background = ripple(16)
                isClickable = true
                setOnClickListener { if (!last) onOpenFolder(file) }
            })
        }
        crumbScroll.post { crumbScroll.fullScroll(View.FOCUS_RIGHT) }
    }

    // ── Folder item count (background) ───────────────────────────

    private fun folderMeta(date: String, count: Int): String {
        val countText = folderCountLabel(count)
        return if (countText.isEmpty()) date else "$date  \u2022  $countText"
    }

    /** A count arrived: redraw the count text of the rows on screen (many results become one redraw). */
    private fun scheduleMetaRefresh() {
        if (refreshQueued) return
        refreshQueued = true
        mainHandler.postDelayed(refreshRunnable, 60L)
    }

    // ── Row view + ViewHolder + adapter (step 4.3) ───────────────

    /**
     * Step 4.4 glass row: a frosted rounded card (soft fill + 1dp edge, ripple on touch), the file
     * icon on a small tinted glass tile, name / "date • size" text, a vector chevron (folders only)
     * and a vector "more" button. Click, long-click and the more button behave exactly as before.
     */
    private inner class Row : LinearLayout(ctx) {
        val tile = FrameLayout(ctx)
        val icon = FileIconView(ctx)
        private val thumb = ImageView(ctx)
        private val badge = durationBadge(8f, 3, 1, 4)
        private val counts = FolderCountSlot(counter) { scheduleMetaRefresh() }
        private val slot = ThumbSlot(thumbs, thumb, badge) { shown ->
            icon.visibility = if (shown) View.INVISIBLE else View.VISIBLE
        }
        val name = TextView(ctx)
        val meta = TextView(ctx)
        val chevron = RowIconView(ctx, RowIconView.CHEVRON)
        val more = FrameLayout(ctx)
        private val tileBg = GradientDrawable().apply {
            cornerRadius = dp(10).toFloat()
            setColor(WX.GLASS_TILE)
        }

        init {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER_VERTICAL
            minimumHeight = dp(64)
            setPadding(dp(10), dp(8), dp(2), dp(8))
            layoutParams = RecyclerView.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT
            ).apply { setMargins(dp(12), dp(3), dp(12), dp(3)) }

            background = glassRipple(12)

            tile.background = tileBg
            tile.addView(icon, FrameLayout.LayoutParams(dp(28), dp(28), Gravity.CENTER))
            // 4.8: the real picture (when a decoder made one) covers the tile; hidden until then
            thumb.scaleType = ImageView.ScaleType.CENTER_CROP
            thumb.visibility = View.GONE
            tile.addView(thumb, FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT))
            // 4.10: video duration, bottom corner of the small tile
            tile.addView(badge, FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT,
                Gravity.BOTTOM or Gravity.END).apply { setMargins(0, 0, dp(2), dp(2)) })
            clipRound(tile, 10)
            addView(tile, LinearLayout.LayoutParams(dp(44), dp(44)))

            val texts = LinearLayout(ctx).apply {
                orientation = LinearLayout.VERTICAL
                layoutParams = LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1f)
                    .apply { leftMargin = dp(12); rightMargin = dp(4) }
            }
            name.apply {
                setTextColor(WX.TEXT)
                textSize = 15f
                typeface = Typeface.create("sans-serif-medium", Typeface.NORMAL)
                setSingleLine(true)
                ellipsize = TextUtils.TruncateAt.MIDDLE
            }
            meta.apply {
                setTextColor(WX.DIM)
                textSize = 12f
                setSingleLine(true)
                ellipsize = TextUtils.TruncateAt.END
                setPadding(0, dp(2), 0, 0)
            }
            texts.addView(name)
            texts.addView(meta)
            addView(texts)

            chevron.apply {
                tint = WX.DIM
                layoutParams = LinearLayout.LayoutParams(dp(18), dp(18))
            }
            addView(chevron)

            more.apply {
                layoutParams = LinearLayout.LayoutParams(dp(44), dp(44))
                background = ripple(22)
                isClickable = true
                isFocusable = false
                contentDescription = "More options"
                addView(
                    RowIconView(ctx, RowIconView.MORE),
                    FrameLayout.LayoutParams(dp(22), dp(22), Gravity.CENTER)
                )
            }
            addView(more)
        }

        private fun dateText(item: FileItem): String =
            try { dateFmt.format(Date(item.modified)) } catch (e: Exception) { "" }

        fun bind(item: FileItem) {
            val hidden = item.hidden
            name.text = item.name
            name.alpha = if (hidden) 0.7f else 1f
            if (!item.isDir) counts.clear()
            val date = dateText(item)
            if (item.isDir) {
                tileBg.setColor(FOLDER_TILE)
                chevron.visibility = View.VISIBLE
                val c = counts.bind(item)
                icon.setFolder(hidden, c != null && c > 0)
                meta.text = if (c != null) folderMeta(date, c) else date
            } else {
                val ext = item.ext
                val tint = fileTypeColor(ext)
                icon.setFile(tint, ext.uppercase(Locale.ROOT).take(4), hidden)
                tileBg.setColor((tint and 0x00FFFFFF) or 0x24000000)   // file-type colour at ~14%
                chevron.visibility = View.GONE
                val size = try { fmtSize(item.size) } catch (e: Exception) { "" }
                meta.text = if (size.isEmpty()) date else "$date  •  $size"
            }
            if (item.isDir) slot.clear() else slot.bind(item, dp(THUMB_LIST_DP))
        }

        /** The row goes back to the pool: cancel its thumbnail job, drop the picture (4.8). */
        fun recycle() { slot.clear(); counts.clear() }

        /** Light re-bind: only the "date • N items" line of a folder (its count just arrived). */
        fun bindMeta(item: FileItem) {
            if (!item.isDir) return
            val cached = counter.peek(item) ?: return
            icon.setFolder(item.hidden, cached > 0)
            meta.text = folderMeta(dateText(item), cached)
        }
    }

    /**
     * Step 4.5 grid cell: a glass card with a big icon tile (the more button in its corner), the
     * name, then a size / "N items" line and the date. Same data and behaviour as [Row].
     */
    private inner class Cell : LinearLayout(ctx) {
        val icon = FileIconView(ctx)
        val name = TextView(ctx)
        val info = TextView(ctx)
        val date = TextView(ctx)
        val more = FrameLayout(ctx)
        private val moreIcon = RowIconView(ctx, RowIconView.MORE)
        private val thumb = ImageView(ctx)
        private val badge = durationBadge(10f, 5, 2, 6)
        private val counts = FolderCountSlot(counter) { scheduleMetaRefresh() }
        private val slot = ThumbSlot(thumbs, thumb, badge) { shown ->
            icon.visibility = if (shown) View.INVISIBLE else View.VISIBLE
            styleMore(shown)
        }
        private val tileBg = GradientDrawable().apply {
            cornerRadius = dp(10).toFloat()
            setColor(WX.GLASS_TILE)
        }

        /** Over a picture the more button gets a dark round back and white dots, like the large card. */
        private fun styleMore(onPicture: Boolean) {
            if (onPicture) {
                val dark = GradientDrawable().apply {
                    shape = GradientDrawable.OVAL
                    setColor(Color.parseColor("#66000000"))
                }
                val mask = GradientDrawable().apply {
                    shape = GradientDrawable.OVAL
                    setColor(Color.WHITE)
                }
                more.background = RippleDrawable(ColorStateList.valueOf(WX.RIPPLE), dark, mask)
                moreIcon.tint = Color.WHITE
            } else {
                more.background = ripple(16)
                moreIcon.tint = WX.DIM
            }
        }

        init {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER_HORIZONTAL
            setPadding(dp(8), dp(8), dp(8), dp(10))
            // outer gaps come from GridGap, so the cells line up with the list rows
            layoutParams = RecyclerView.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT
            )
            background = glassRipple(12)

            val tile = FrameLayout(ctx).apply { background = tileBg }
            tile.addView(icon, FrameLayout.LayoutParams(dp(44), dp(44), Gravity.CENTER))
            // 4.8: picture layer between the icon and the more button
            thumb.scaleType = ImageView.ScaleType.CENTER_CROP
            thumb.visibility = View.GONE
            tile.addView(thumb, FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT))
            // 4.10: video duration, bottom corner of the tile (the more button is in the top corner)
            tile.addView(badge, FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT,
                Gravity.BOTTOM or Gravity.END).apply { setMargins(0, 0, dp(4), dp(4)) })
            clipRound(tile, 10)
            more.apply {
                background = ripple(16)
                isClickable = true
                isFocusable = false
                contentDescription = "More options"
                addView(moreIcon, FrameLayout.LayoutParams(dp(20), dp(20), Gravity.CENTER))
            }
            tile.addView(more, FrameLayout.LayoutParams(dp(32), dp(32), Gravity.TOP or Gravity.END))
            addView(tile, LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, dp(76)))

            name.apply {
                setTextColor(WX.TEXT)
                textSize = 13f
                typeface = Typeface.create("sans-serif-medium", Typeface.NORMAL)
                gravity = Gravity.CENTER
                setSingleLine(true)
                ellipsize = TextUtils.TruncateAt.MIDDLE
                setPadding(0, dp(8), 0, 0)
            }
            info.apply {
                setTextColor(WX.DIM)
                textSize = 11.5f
                gravity = Gravity.CENTER
                setSingleLine(true)
                ellipsize = TextUtils.TruncateAt.END
                setPadding(0, dp(2), 0, 0)
            }
            date.apply {
                setTextColor(WX.DIM)
                textSize = 10.5f
                alpha = 0.8f
                gravity = Gravity.CENTER
                setSingleLine(true)
                ellipsize = TextUtils.TruncateAt.END
            }
            addView(name, LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT))
            addView(info, LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT))
            addView(date, LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT))
        }

        private fun countText(count: Int): String = folderCountLabel(count).ifEmpty { "Folder" }

        fun bind(item: FileItem) {
            val hidden = item.hidden
            name.text = item.name
            name.alpha = if (hidden) 0.7f else 1f
            if (!item.isDir) counts.clear()
            date.text = try { dateFmt.format(Date(item.modified)) } catch (e: Exception) { "" }
            if (item.isDir) {
                icon.setFolder(hidden)
                tileBg.setColor(FOLDER_TILE)
                val c = counts.bind(item)
                icon.setFolder(hidden, c != null && c > 0)
                info.text = countText(c ?: -1)
            } else {
                val ext = item.ext
                val tint = fileTypeColor(ext)
                icon.setFile(tint, ext.uppercase(Locale.ROOT).take(4), hidden)
                tileBg.setColor((tint and 0x00FFFFFF) or 0x24000000)
                info.text = try { fmtSize(item.size) } catch (e: Exception) { "" }
            }
            if (item.isDir) slot.clear() else slot.bind(item, dp(THUMB_GRID_DP))
        }

        /** The cell goes back to the pool: cancel its thumbnail job, drop the picture (4.8). */
        fun recycle() { slot.clear(); counts.clear() }

        /** Light re-bind: only the "N items" line of a folder (its count just arrived). */
        fun bindMeta(item: FileItem) {
            if (!item.isDir) return
            val cached = counter.peek(item) ?: return
            icon.setFolder(item.hidden, cached > 0)
            info.text = countText(cached)
        }
    }

    /** Holder of one grid cell; wired exactly like [ItemVH]. */
    private inner class GridVH(val cell: Cell) : RecyclerView.ViewHolder(cell) {
        init {
            cell.setOnClickListener {
                adapter.itemAt(bindingAdapterPosition)?.file?.let { f ->
                    if (f.isDirectory) onOpenFolder(f) else onItemClick(f)
                }
            }
            cell.setOnLongClickListener {
                adapter.itemAt(bindingAdapterPosition)?.let { onItemMenu(it.file) }
                true
            }
            cell.more.setOnClickListener {
                adapter.itemAt(bindingAdapterPosition)?.let { onItemMenu(it.file) }
            }
        }
    }

    /**
     * Step 4.6 large preview card: a tall rounded preview area (folder / file icon for now; the real
     * photo, video frame and so on come in 4.8 - 4.11 through [thumb]), a type chip in its corner and
     * a round "more" button, then the name, the size / "N items" line and the date. Same data and
     * behaviour as [Row] and [Cell].
     */
    private inner class LargeCard : LinearLayout(ctx) {
        val preview = RatioFrame(ctx, 0.8f)
        val thumb = android.widget.ImageView(ctx)
        val icon = FileIconView(ctx)
        private val badge = durationBadge(11f, 6, 2, 7)
        private val counts = FolderCountSlot(counter) { scheduleMetaRefresh() }
        private val slot = ThumbSlot(thumbs, thumb, badge) { shown ->
            // the picture covers the preview; the file icon is only the placeholder
            icon.visibility = if (shown) View.INVISIBLE else View.VISIBLE
        }
        val chip = TextView(ctx)
        val name = TextView(ctx)
        val info = TextView(ctx)
        val date = TextView(ctx)
        val more = FrameLayout(ctx)
        private val previewBg = GradientDrawable().apply {
            cornerRadius = dp(12).toFloat()
            setColor(WX.GLASS_TILE)
        }

        init {
            orientation = LinearLayout.VERTICAL
            setPadding(dp(6), dp(6), dp(6), dp(10))
            // outer gaps come from GridGap, same as the small grid cells
            layoutParams = RecyclerView.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT
            )
            background = glassRipple(14)

            preview.background = previewBg
            preview.clipToOutline = true
            preview.outlineProvider = object : android.view.ViewOutlineProvider() {
                override fun getOutline(v: View, outline: android.graphics.Outline) {
                    outline.setRoundRect(0, 0, v.width, v.height, dp(12).toFloat())
                }
            }
            // real picture (4.8+); stays empty / hidden while only the icon is shown
            thumb.apply {
                scaleType = android.widget.ImageView.ScaleType.CENTER_CROP
                visibility = View.GONE
            }
            preview.addView(thumb, FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT))
            preview.addView(icon, FrameLayout.LayoutParams(dp(60), dp(60), Gravity.CENTER))
            // 4.10: video duration, bottom-end corner (the type chip is bottom-start)
            preview.addView(badge, FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT,
                Gravity.BOTTOM or Gravity.END).apply { setMargins(0, 0, dp(8), dp(8)) })

            chip.apply {
                setTextColor(Color.WHITE)
                textSize = 10f
                typeface = Typeface.DEFAULT_BOLD
                setSingleLine(true)
                setPadding(dp(7), dp(2), dp(7), dp(2))
                background = GradientDrawable().apply {
                    cornerRadius = dp(8).toFloat()
                    setColor(Color.parseColor("#80000000"))
                }
            }
            preview.addView(chip, FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT,
                Gravity.BOTTOM or Gravity.START
            ).apply { setMargins(dp(8), 0, 0, dp(8)) })

            // round dark button so it stays readable on top of a bright photo
            more.apply {
                val dark = GradientDrawable().apply {
                    shape = GradientDrawable.OVAL
                    setColor(Color.parseColor("#66000000"))
                }
                val mask = GradientDrawable().apply {
                    shape = GradientDrawable.OVAL
                    setColor(Color.WHITE)
                }
                background = RippleDrawable(ColorStateList.valueOf(WX.RIPPLE), dark, mask)
                isClickable = true
                isFocusable = false
                contentDescription = "More options"
                addView(
                    RowIconView(ctx, RowIconView.MORE).apply { tint = Color.WHITE },
                    FrameLayout.LayoutParams(dp(18), dp(18), Gravity.CENTER)
                )
            }
            preview.addView(more, FrameLayout.LayoutParams(dp(32), dp(32), Gravity.TOP or Gravity.END)
                .apply { setMargins(0, dp(6), dp(6), 0) })
            addView(preview, LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT))

            name.apply {
                setTextColor(WX.TEXT)
                textSize = 13.5f
                typeface = Typeface.create("sans-serif-medium", Typeface.NORMAL)
                setSingleLine(true)
                ellipsize = TextUtils.TruncateAt.MIDDLE
                setPadding(dp(4), dp(8), dp(4), 0)
            }
            info.apply {
                setTextColor(WX.DIM)
                textSize = 11.5f
                setSingleLine(true)
                ellipsize = TextUtils.TruncateAt.END
                setPadding(dp(4), dp(2), dp(4), 0)
            }
            date.apply {
                setTextColor(WX.DIM)
                textSize = 10.5f
                alpha = 0.8f
                setSingleLine(true)
                ellipsize = TextUtils.TruncateAt.END
                setPadding(dp(4), 0, dp(4), 0)
            }
            addView(name, LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT))
            addView(info, LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT))
            addView(date, LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT))
        }

        private fun countText(count: Int): String = folderCountLabel(count).ifEmpty { "Folder" }

        fun bind(item: FileItem) {
            val hidden = item.hidden
            name.text = item.name
            name.alpha = if (hidden) 0.7f else 1f
            if (!item.isDir) counts.clear()
            date.text = try { dateFmt.format(Date(item.modified)) } catch (e: Exception) { "" }
            if (item.isDir) slot.clear() else slot.bind(item, dp(THUMB_LARGE_DP))   // 4.8
            if (item.isDir) {
                icon.setFolder(hidden)
                previewBg.setColor(FOLDER_TILE)
                chip.visibility = View.GONE
                val c = counts.bind(item)
                icon.setFolder(hidden, c != null && c > 0)
                info.text = countText(c ?: -1)
            } else {
                val ext = item.ext
                val tint = fileTypeColor(ext)
                icon.setFile(tint, ext.uppercase(Locale.ROOT).take(4), hidden)
                previewBg.setColor((tint and 0x00FFFFFF) or 0x24000000)
                if (ext.isEmpty()) {
                    chip.visibility = View.GONE
                } else {
                    chip.text = ext.uppercase(Locale.ROOT).take(5)
                    chip.visibility = View.VISIBLE
                }
                info.text = try { fmtSize(item.size) } catch (e: Exception) { "" }
            }
        }

        /** The card goes back to the pool: cancel its thumbnail job, drop the picture (4.8). */
        fun recycle() { slot.clear(); counts.clear() }

        /** Light re-bind: only the "N items" line of a folder (its count just arrived). */
        fun bindMeta(item: FileItem) {
            if (!item.isDir) return
            val cached = counter.peek(item) ?: return
            icon.setFolder(item.hidden, cached > 0)
            info.text = countText(cached)
        }
    }

    /** Holder of one large card; wired exactly like [ItemVH] and [GridVH]. */
    private inner class LargeVH(val card: LargeCard) : RecyclerView.ViewHolder(card) {
        init {
            card.setOnClickListener {
                adapter.itemAt(bindingAdapterPosition)?.file?.let { f ->
                    if (f.isDirectory) onOpenFolder(f) else onItemClick(f)
                }
            }
            card.setOnLongClickListener {
                adapter.itemAt(bindingAdapterPosition)?.let { onItemMenu(it.file) }
                true
            }
            card.more.setOnClickListener {
                adapter.itemAt(bindingAdapterPosition)?.let { onItemMenu(it.file) }
            }
        }
    }

    /** Grid / large-card spacing: 4dp around each cell, 12dp at the screen edges (same as the list rows). */
    private inner class GridGap : RecyclerView.ItemDecoration() {
        override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
            val vt = parent.getChildViewHolder(view).itemViewType
            if (vt != VT_GRID && vt != VT_LARGE) return
            val lp = view.layoutParams as? GridLayoutManager.LayoutParams ?: return
            val first = lp.spanIndex == 0
            val last = lp.spanIndex + lp.spanSize >= gridCols
            outRect.left = dp(if (first) 12 else 4)
            outRect.right = dp(if (last) 12 else 4)
            outRect.top = dp(4)
            outRect.bottom = dp(4)
        }
    }

    /** Holder of one file / folder row. Click, long-click and the more (vector) button are wired once, here. */
    private inner class ItemVH(val row: Row) : RecyclerView.ViewHolder(row) {
        init {
            row.setOnClickListener {
                adapter.itemAt(bindingAdapterPosition)?.file?.let { f ->
                    if (f.isDirectory) onOpenFolder(f) else onItemClick(f)
                }
            }
            row.setOnLongClickListener {
                adapter.itemAt(bindingAdapterPosition)?.let { onItemMenu(it.file) }
                true
            }
            row.more.setOnClickListener {
                adapter.itemAt(bindingAdapterPosition)?.let { onItemMenu(it.file) }
            }
        }
    }

    /** Holder for the drive card (top) and the empty / loading / error box (bottom). */
    private class StaticVH(v: View) : RecyclerView.ViewHolder(v)

    /** Maps DiffUtil positions (0 = first file) to adapter positions (0 = drive card). */
    private class OffsetUpdates(
        private val target: RecyclerView.Adapter<*>,
        private val offset: Int
    ) : ListUpdateCallback {
        override fun onInserted(position: Int, count: Int) =
            target.notifyItemRangeInserted(position + offset, count)
        override fun onRemoved(position: Int, count: Int) =
            target.notifyItemRangeRemoved(position + offset, count)
        override fun onMoved(fromPosition: Int, toPosition: Int) =
            target.notifyItemMoved(fromPosition + offset, toPosition + offset)
        override fun onChanged(position: Int, count: Int, payload: Any?) =
            target.notifyItemRangeChanged(position + offset, count, payload)
    }

    private inner class ExplorerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
        lateinit var header: View
        lateinit var footer: View
        /** Row type of the file items: [VT_ITEM] list row, [VT_GRID] small cell (4.5), [VT_LARGE] big card (4.6). */
        var cellType = VT_ITEM

        private var items: List<FileItem> = emptyList()
        private var diffGen = 0
        private val diffPool = Executors.newSingleThreadExecutor { r ->
            Thread(r, "explorer-diff").apply { isDaemon = true }
        }

        /** File at adapter [position] (header / footer / stale positions give null). */
        fun itemAt(position: Int): FileItem? = items.getOrNull(position - 1)

        override fun getItemCount(): Int = items.size + 2

        override fun getItemViewType(position: Int): Int = when (position) {
            0 -> VT_HEADER
            items.size + 1 -> VT_FOOTER
            else -> cellType
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
            when (viewType) {
                VT_HEADER -> StaticVH(wrap(header))
                VT_FOOTER -> StaticVH(wrap(footer))
                VT_GRID -> GridVH(Cell())
                VT_LARGE -> LargeVH(LargeCard())
                else -> ItemVH(Row())
            }

        private fun wrap(v: View): FrameLayout {
            (v.parent as? ViewGroup)?.removeView(v)
            return FrameLayout(ctx).apply {
                layoutParams = RecyclerView.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT
                )
                addView(
                    v,
                    FrameLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT
                    )
                )
            }
        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            when (holder) {
                is ItemVH -> itemAt(position)?.let { holder.row.bind(it) }
                is GridVH -> itemAt(position)?.let { holder.cell.bind(it) }
                is LargeVH -> itemAt(position)?.let { holder.card.bind(it) }
                else -> {}
            }
        }

        /** 4.8: a row that leaves the screen stops waiting for its picture and forgets the old one. */
        override fun onViewRecycled(holder: RecyclerView.ViewHolder) {
            when (holder) {
                is ItemVH -> holder.row.recycle()
                is GridVH -> holder.cell.recycle()
                is LargeVH -> holder.card.recycle()
                else -> {}
            }
            super.onViewRecycled(holder)
        }

        override fun onBindViewHolder(
            holder: RecyclerView.ViewHolder, position: Int, payloads: MutableList<Any>
        ) {
            if (payloads.isNotEmpty() && (holder is ItemVH || holder is GridVH || holder is LargeVH)) {
                val item = itemAt(position) ?: return
                when (holder) {
                    is ItemVH -> holder.row.bindMeta(item)
                    is GridVH -> holder.cell.bindMeta(item)
                    is LargeVH -> holder.card.bindMeta(item)
                    else -> {}
                }
            } else {
                super.onBindViewHolder(holder, position, payloads)
            }
        }

        /**
         * Show [newItems]. With [animate] (same folder reloaded) the difference is worked out on a
         * worker thread by DiffUtil and only the changed rows move / refresh; otherwise the list
         * is swapped at once with no animation (a different folder).
         */
        fun submit(newItems: List<FileItem>, animate: Boolean) {
            val gen = ++diffGen
            val old = items
            if (!animate || old.isEmpty() || newItems.isEmpty()) {
                items = newItems
                notifyDataSetChanged()
                return
            }
            try {
                diffPool.execute {
                    val result = DiffUtil.calculateDiff(object : DiffUtil.Callback() {
                        override fun getOldListSize(): Int = old.size
                        override fun getNewListSize(): Int = newItems.size
                        override fun areItemsTheSame(o: Int, n: Int): Boolean =
                            old[o].path == newItems[n].path
                        override fun areContentsTheSame(o: Int, n: Int): Boolean =
                            old[o] == newItems[n]
                    }, false)   // 4.15.1: no move detection - much faster on 5000+ files, same result
                    mainHandler.post {
                        if (gen != diffGen) return@post   // a newer list / clear() came meanwhile
                        items = newItems
                        result.dispatchUpdatesTo(OffsetUpdates(this, 1))
                    }
                }
            } catch (e: java.util.concurrent.RejectedExecutionException) {
                // screen destroyed: nobody left to show the list to
            }
        }

        /** Drop all rows (loading / error state); a diff still running is thrown away. */
        fun clear() {
            diffGen++
            items = emptyList()
            notifyDataSetChanged()
        }

        /** A folder item count arrived: re-bind only the "date • N items" text of the rows on screen. */
        fun refreshMeta() {
            if (items.isNotEmpty()) notifyItemRangeChanged(1, items.size, PAYLOAD_META)
        }

        fun release() {
            diffGen++
            diffPool.shutdownNow()
        }
    }
}

private const val VT_HEADER = 0
private const val VT_ITEM = 1
private const val VT_FOOTER = 2
private const val VT_GRID = 3
private const val VT_LARGE = 4
private const val THUMB_LIST_DP = 48    // 4.8: wanted picture edge (dp) per mode; part of the cache key
private const val THUMB_GRID_DP = 112
private const val THUMB_LARGE_DP = 180
private const val LARGE_CELL_DP = 170  // target large-card width; columns = list width / this (2..5)
private const val GRID_CELL_DP = 120   // target cell width; columns = list width / this (2..8)
private const val PAYLOAD_META = "meta"
private const val SKELETON_MIN_MS = 280L   // 4.13: once shown, the skeleton stays at least this long
private val FOLDER_TILE = Color.parseColor("#24FFC83D")   // folder icon tile (amber, ~14%)

/** Step 4.7: the three view-mode icons of the switcher (stroke style, tinted by [tint]). */
internal class ModeIconView(context: Context, private val kind: Int) : View(context) {

    companion object {
        const val LIST = 0
        const val GRID = 1
        const val LARGE = 2
    }

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.STROKE
        strokeWidth = 1.9f
        strokeCap = Paint.Cap.ROUND
        strokeJoin = Paint.Join.ROUND
    }
    private val rect = RectF()

    var tint: Int = WX.DIM
        set(v) { field = v; invalidate() }

    override fun onDraw(canvas: Canvas) {
        val s = minOf(width, height) / 24f
        canvas.save()
        canvas.translate((width - 24f * s) / 2f, (height - 24f * s) / 2f)
        canvas.scale(s, s)
        paint.color = tint
        when (kind) {
            LIST -> {
                for (y in floatArrayOf(6f, 12f, 18f)) canvas.drawLine(4f, y, 20f, y, paint)
            }
            GRID -> {
                for (x in floatArrayOf(4f, 14f)) for (y in floatArrayOf(4f, 14f)) {
                    rect.set(x, y, x + 6f, y + 6f)
                    canvas.drawRoundRect(rect, 1.6f, 1.6f, paint)
                }
            }
            else -> {
                rect.set(4f, 4f, 20f, 15f)
                canvas.drawRoundRect(rect, 2.4f, 2.4f, paint)
                canvas.drawLine(4f, 19.5f, 14f, 19.5f, paint)
            }
        }
        canvas.restore()
    }
}

/** FrameLayout whose height is always [ratio] x its width (large-card preview area, step 4.6). */
internal class RatioFrame(context: Context, private val ratio: Float) : FrameLayout(context) {
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val w = MeasureSpec.getSize(widthMeasureSpec)
        super.onMeasure(
            widthMeasureSpec,
            MeasureSpec.makeMeasureSpec((w * ratio).toInt(), MeasureSpec.EXACTLY)
        )
    }
}

// ---------------------------------------------------------------------
// Fast-scroll thumb for the RecyclerView (the old ListView had one built in)
// Appears while scrolling in a long list, fades out after ~1.2 s, and can be
// dragged by its right-edge handle. Touches elsewhere pass through to the list.
// ---------------------------------------------------------------------

internal class FastScrollBar(
    context: Context,
    private val rv: RecyclerView,
    /** 4.15.1: true while the thumb is dragged (the explorer pauses thumbnail decoding meanwhile). */
    private val onDragState: (Boolean) -> Unit = {}
) : View(context) {

    private val density = context.resources.displayMetrics.density
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val rect = RectF()
    private val thumbH = 52f * density
    private var lastPos = -1
    private val hitW = 32f * density
    private var dragging = false
    private var dragFraction = 0f
    private val hideRunnable = Runnable {
        if (!dragging) animate().alpha(0f).setDuration(220L).start()
    }

    init {
        alpha = 0f
        rv.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if (dy != 0 && scrollable()) reveal()
                if (alpha > 0f) invalidate()
            }
        })
    }

    private fun scrollable(): Boolean =
        rv.computeVerticalScrollRange() > rv.computeVerticalScrollExtent() * 2

    private fun reveal() {
        removeCallbacks(hideRunnable)
        animate().cancel()
        alpha = 1f
        if (!dragging) postDelayed(hideRunnable, 1200L)
    }

    private fun fraction(): Float {
        if (dragging) return dragFraction
        val range = rv.computeVerticalScrollRange()
        val extent = rv.computeVerticalScrollExtent()
        val offset = rv.computeVerticalScrollOffset()
        return if (range > extent) (offset.toFloat() / (range - extent)).coerceIn(0f, 1f) else 0f
    }

    private fun thumbTop(): Float = fraction() * (height - thumbH).coerceAtLeast(0f)

    override fun onDraw(canvas: Canvas) {
        if (alpha <= 0f) return
        val w = (if (dragging) 8f else 4f) * density
        val right = width - 2f * density
        val top = thumbTop()
        paint.color = if (dragging) WX.ACCENT else Color.parseColor("#99FFFFFF")
        rect.set(right - w, top, right, top + thumbH)
        canvas.drawRoundRect(rect, w / 2f, w / 2f, paint)
    }

    override fun onTouchEvent(e: MotionEvent): Boolean {
        when (e.actionMasked) {
            MotionEvent.ACTION_DOWN -> {
                if (alpha < 0.05f || !scrollable()) return false
                if (e.x < width - hitW) return false
                val top = thumbTop()
                if (e.y < top - 12f * density || e.y > top + thumbH + 12f * density) return false
                dragging = true
                lastPos = -1
                removeCallbacks(hideRunnable)
                parent?.requestDisallowInterceptTouchEvent(true)
                rv.stopScroll()
                onDragState(true)
                dragTo(e.y)
                return true
            }
            MotionEvent.ACTION_MOVE -> if (dragging) { dragTo(e.y); return true }
            MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> if (dragging) {
                dragging = false
                onDragState(false)
                invalidate()
                postDelayed(hideRunnable, 1200L)
                return true
            }
        }
        return dragging
    }

    private fun dragTo(y: Float) {
        val travel = (height - thumbH).coerceAtLeast(1f)
        dragFraction = ((y - thumbH / 2f) / travel).coerceIn(0f, 1f)
        val count = rv.adapter?.itemCount ?: return
        val pos = (dragFraction * (count - 1)).toInt().coerceIn(0, count - 1)
        // only re-layout when the target row really changed (a finger move of a few pixels is not one)
        if (pos != lastPos) {
            lastPos = pos
            (rv.layoutManager as? LinearLayoutManager)?.scrollToPositionWithOffset(pos, 0)
            onDragState(true)   // keeps the thumbnail pause alive for the whole drag
        }
        invalidate()
    }

    /** 4.15.4: rotation / split-screen / fold changed the height: the thumb position is recalculated. */
    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        if (alpha > 0f) invalidate()
    }

    override fun onDetachedFromWindow() {
        removeCallbacks(hideRunnable)
        if (dragging) { dragging = false; onDragState(false) }
        super.onDetachedFromWindow()
    }
}

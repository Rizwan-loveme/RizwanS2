package com.srizwan.win11

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.Matrix
import android.graphics.Paint
import android.graphics.RectF
import android.graphics.Shader
import android.view.View
import android.view.animation.LinearInterpolator

// =====================================================================
// STEP 4.13 – SHIMMER / LOADING SKELETON
// While a folder is being read the explorer shows grey "ghost" items in
// the shape of the real ones, with a soft light band sweeping over them:
//   * LIST  – glass row: icon tile + name bar + "date • size" bar
//   * GRID  – glass cell: icon tile + name / info / date bars
//   * LARGE – glass card: tall preview + name / info / date bars
// One custom View draws everything on a single Canvas (no child views,
// no allocations while animating) and ONE shared gradient sweeps across
// all shapes, so the band moves smoothly from item to item.
// Measures match Row / Cell / LargeCard of FileExplorerUi.kt so the real
// items replace the ghosts without a jump.
// =====================================================================

internal class SkeletonView(context: Context) : View(context) {

    companion object {
        const val LIST = 0
        const val GRID = 1
        const val LARGE = 2

        private const val SWEEP_MS = 1300L
        private const val MAX_ROWS = 40               // safety cap (very tall / split-screen windows)

        // Bar widths (fraction of the available text width) – varied so it does not look like a barcode.
        private val NAME_W = floatArrayOf(0.62f, 0.48f, 0.74f, 0.55f, 0.68f, 0.42f, 0.58f)
        private val META_W = floatArrayOf(0.40f, 0.52f, 0.34f, 0.46f, 0.38f, 0.50f, 0.44f)
    }

    private val density = context.resources.displayMetrics.density
    private fun dp(v: Float): Float = v * density

    /** One of [LIST], [GRID], [LARGE]; set with [configure]. */
    private var mode = LIST
    private var cols = 1

    /** Height the ghosts should fill (px); the view is a whole number of item rows tall. */
    var fillHeightPx: Int = 0
        set(v) {
            if (field != v) { field = v; requestLayout() }
        }

    private val cardPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply { style = Paint.Style.FILL }
    private val edgePaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.STROKE
        strokeWidth = dp(1f)
        color = WX.GLASS_EDGE
    }
    private val shapePaint = Paint(Paint.ANTI_ALIAS_FLAG).apply { style = Paint.Style.FILL }
    private val rect = RectF()

    // ── shimmer gradient: base grey – light band – base grey, moved with a Matrix ──
    private val baseColor = Color.parseColor("#1FFFFFFF")     // ghost shapes (~12% white)
    private val bandColor = Color.parseColor("#47FFFFFF")     // sweep highlight (~28% white)
    private val bandW = dp(220f)
    private val gradient = LinearGradient(
        0f, 0f, bandW, 0f,
        intArrayOf(baseColor, bandColor, baseColor),
        floatArrayOf(0f, 0.5f, 1f),
        Shader.TileMode.CLAMP
    )
    private val gradMatrix = Matrix()
    private var phase = 0f                                    // 0..1 along the sweep

    private var animator: ValueAnimator? = null
    private var wantRunning = false

    init {
        shapePaint.shader = gradient
        // read as a single "loading" element by screen readers
        contentDescription = "Loading"
        importantForAccessibility = IMPORTANT_FOR_ACCESSIBILITY_YES
    }

    /** Choose the ghost shape and the column count (1 for the list). */
    fun configure(newMode: Int, newCols: Int) {
        val c = if (newMode == LIST) 1 else newCols.coerceAtLeast(1)
        if (newMode == mode && c == cols) return
        mode = newMode
        cols = c
        requestLayout()
        invalidate()
    }

    /** Start / stop the sweep. Safe to call repeatedly; it also pauses while the view is not on screen. */
    fun setActive(active: Boolean) {
        wantRunning = active
        syncAnimator()
    }

    // ── geometry (all in px, derived from the real item layouts) ──────────────

    private fun edge(): Float = dp(12f)                       // list-row margin / screen gutter
    private fun gap(): Float = dp(8f)                         // between grid / large cells

    private fun cellWidth(w: Float): Float {
        if (cols <= 1) return w - 2 * edge()
        return (w - 2 * edge() - gap() * (cols - 1)) / cols
    }

    /** Height of one item (without the gap below it). */
    private fun itemHeight(w: Float): Float = when (mode) {
        GRID -> dp(8f + 76f + 8f + 17f + 2f + 15f + 14f + 10f)
        LARGE -> {
            val inner = cellWidth(w) - dp(12f)
            dp(6f) + inner * 0.8f + dp(8f + 17f + 2f + 15f + 14f + 10f)
        }
        else -> dp(64f)
    }

    private fun gapBelow(): Float = if (mode == LIST) dp(6f) else gap()

    private fun rowsToFill(w: Float): Int {
        val pitch = itemHeight(w) + gapBelow()
        val fill = if (fillHeightPx > 0) fillHeightPx.toFloat() else dp(480f)
        return Math.ceil((fill / pitch).toDouble()).toInt().coerceIn(1, MAX_ROWS)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val w = MeasureSpec.getSize(widthMeasureSpec)
        val rows = rowsToFill(w.toFloat())
        val h = (rows * (itemHeight(w.toFloat()) + gapBelow()) + dp(4f)).toInt()
        setMeasuredDimension(w, h)
    }

    // ── drawing ───────────────────────────────────────────────────────────────

    override fun onDraw(canvas: Canvas) {
        val w = width.toFloat()
        if (w <= 0f) return

        // sweep position: from just left of the view to just right of it (shared by every shape)
        val travel = w + bandW
        gradMatrix.setTranslate(-bandW + travel * phase, 0f)
        gradient.setLocalMatrix(gradMatrix)

        val rows = rowsToFill(w)
        val cw = cellWidth(w)
        val ih = itemHeight(w)
        val pitch = ih + gapBelow()
        var n = 0
        for (r in 0 until rows) {
            val top = r * pitch + dp(2f)
            for (c in 0 until cols) {
                val left = edge() + c * (cw + gap())
                when (mode) {
                    GRID -> drawCell(canvas, left, top, cw, ih, n)
                    LARGE -> drawCard(canvas, left, top, cw, ih, n)
                    else -> drawRow(canvas, left, top, cw, ih, n)
                }
                n++
            }
        }
    }

    private fun glass(canvas: Canvas, l: Float, t: Float, w: Float, h: Float, radius: Float) {
        rect.set(l, t, l + w, t + h)
        cardPaint.color = WX.GLASS
        canvas.drawRoundRect(rect, radius, radius, cardPaint)
        rect.inset(edgePaint.strokeWidth / 2f, edgePaint.strokeWidth / 2f)
        canvas.drawRoundRect(rect, radius, radius, edgePaint)
    }

    private fun bar(canvas: Canvas, l: Float, t: Float, w: Float, h: Float) {
        rect.set(l, t, l + w, t + h)
        canvas.drawRoundRect(rect, h / 2f, h / 2f, shapePaint)
    }

    private fun tile(canvas: Canvas, l: Float, t: Float, w: Float, h: Float, radius: Float) {
        rect.set(l, t, l + w, t + h)
        canvas.drawRoundRect(rect, radius, radius, shapePaint)
    }

    /** List row: 12dp glass, 44dp tile at 10dp, two text bars, small round "more" dot at the end. */
    private fun drawRow(canvas: Canvas, l: Float, t: Float, w: Float, h: Float, n: Int) {
        glass(canvas, l, t, w, h, dp(12f))
        val tileSize = dp(44f)
        tile(canvas, l + dp(10f), t + (h - tileSize) / 2f, tileSize, tileSize, dp(10f))
        val tx = l + dp(10f) + tileSize + dp(12f)
        val avail = w - (tx - l) - dp(52f)
        val nameH = dp(12f)
        val metaH = dp(9f)
        val total = nameH + dp(8f) + metaH
        val y = t + (h - total) / 2f
        bar(canvas, tx, y, avail * NAME_W[n % NAME_W.size], nameH)
        bar(canvas, tx, y + nameH + dp(8f), avail * META_W[n % META_W.size], metaH)
        val dot = dp(5f)
        rect.set(l + w - dp(22f) - dot, t + h / 2f - dot, l + w - dp(22f) + dot, t + h / 2f + dot)
        canvas.drawOval(rect, shapePaint)
    }

    /** Grid cell: 8dp padding, 76dp tall tile, centered name / info / date bars. */
    private fun drawCell(canvas: Canvas, l: Float, t: Float, w: Float, h: Float, n: Int) {
        glass(canvas, l, t, w, h, dp(12f))
        val pad = dp(8f)
        val inner = w - 2 * pad
        tile(canvas, l + pad, t + pad, inner, dp(76f), dp(10f))
        var y = t + pad + dp(76f) + dp(12f)
        centeredBar(canvas, l, w, y, inner * (NAME_W[n % NAME_W.size] + 0.1f).coerceAtMost(0.9f), dp(10f))
        y += dp(10f) + dp(9f)
        centeredBar(canvas, l, w, y, inner * META_W[n % META_W.size], dp(8f))
        y += dp(8f) + dp(8f)
        centeredBar(canvas, l, w, y, inner * (META_W[(n + 3) % META_W.size] * 0.9f), dp(7f))
    }

    /** Large card: 6dp padding, tall 0.8-ratio preview, left-aligned name / info / date bars. */
    private fun drawCard(canvas: Canvas, l: Float, t: Float, w: Float, h: Float, n: Int) {
        glass(canvas, l, t, w, h, dp(14f))
        val pad = dp(6f)
        val inner = w - 2 * pad
        val previewH = inner * 0.8f
        tile(canvas, l + pad, t + pad, inner, previewH, dp(12f))
        val tx = l + pad + dp(4f)
        val avail = inner - dp(8f)
        var y = t + pad + previewH + dp(12f)
        bar(canvas, tx, y, avail * NAME_W[n % NAME_W.size], dp(11f))
        y += dp(11f) + dp(9f)
        bar(canvas, tx, y, avail * META_W[n % META_W.size], dp(8f))
        y += dp(8f) + dp(8f)
        bar(canvas, tx, y, avail * META_W[(n + 3) % META_W.size] * 0.9f, dp(7f))
    }

    private fun centeredBar(canvas: Canvas, l: Float, w: Float, t: Float, bw: Float, bh: Float) {
        bar(canvas, l + (w - bw) / 2f, t, bw, bh)
    }

    // ── animation lifecycle ───────────────────────────────────────────────────

    /** ValueAnimator.areAnimatorsEnabled() exists from API 26; below that animations are simply on. */
    private fun animationsOn(): Boolean =
        if (android.os.Build.VERSION.SDK_INT >= 26) ValueAnimator.areAnimatorsEnabled() else true

    private fun syncAnimator() {
        val shouldRun = wantRunning && isAttachedToWindow && isShown && animationsOn()
        if (shouldRun) {
            if (animator == null) {
                animator = ValueAnimator.ofFloat(0f, 1f).apply {
                    duration = SWEEP_MS
                    repeatCount = ValueAnimator.INFINITE
                    interpolator = LinearInterpolator()
                    addUpdateListener {
                        phase = it.animatedValue as Float
                        invalidate()
                    }
                    start()
                }
            }
        } else {
            animator?.cancel()
            animator = null
            // reduced motion: keep the ghosts, centre the band so they still look "lit"
            if (wantRunning && !animationsOn()) {
                phase = 0.5f
                invalidate()
            }
        }
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        syncAnimator()
    }

    override fun onDetachedFromWindow() {
        animator?.cancel()
        animator = null
        super.onDetachedFromWindow()
    }

    override fun onVisibilityChanged(changedView: View, visibility: Int) {
        super.onVisibilityChanged(changedView, visibility)
        syncAnimator()
    }

    override fun onWindowVisibilityChanged(visibility: Int) {
        super.onWindowVisibilityChanged(visibility)
        syncAnimator()
    }
}

package com.srizwan.chooser.ui

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.LinearGradient
import android.graphics.Matrix
import android.graphics.Paint
import android.graphics.RectF
import android.graphics.Shader
import android.util.AttributeSet
import android.view.View
import android.view.animation.LinearInterpolator

/**
 * The loading skeleton: soft rounded blocks laid out like the real grid, with a light band sweeping over them.
 *
 *  - [Style.PHOTOS]: a short date-header bar, then rows of square cells, repeated (the Photos tab).
 *  - [Style.ALBUMS]: two-column cards with a square cover and two text bars (the Albums tab).
 *  - [Style.APPS]: a grid of rounded icons with a text bar under each (the "Open with" / Share sheets while the app list loads).
 *
 * It fills the area it is given, animates only while attached and visible, and draws nothing else, so it is cheap.
 * Use [configure] to change the style or the column count.
 */
class GlassShimmerView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : View(context, attrs) {

    enum class Style { PHOTOS, ALBUMS, APPS }

    private val d = resources.displayMetrics.density
    private var style = Style.PHOTOS
    private var columns = 3

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply { style = Paint.Style.FILL }
    private val shaderMatrix = Matrix()
    private var gradient: LinearGradient? = null
    private val rect = RectF()
    private var phase = 0f
    private var animator: ValueAnimator? = null

    init {
        // not interactive and not announced: the screen reads its own state
        importantForAccessibility = IMPORTANT_FOR_ACCESSIBILITY_NO
    }

    fun configure(style: Style, columns: Int) {
        this.style = style
        this.columns = columns.coerceIn(1, 6)
        invalidate()
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        val band = (w * 0.7f).coerceAtLeast(1f)
        gradient = LinearGradient(
            0f, 0f, band, 0f,
            intArrayOf(BASE, HIGHLIGHT, BASE),
            floatArrayOf(0f, 0.5f, 1f),
            Shader.TileMode.CLAMP
        )
        paint.shader = gradient
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        updateAnimation()
    }

    override fun onDetachedFromWindow() {
        stopAnimation()
        super.onDetachedFromWindow()
    }

    override fun onVisibilityChanged(changedView: View, visibility: Int) {
        super.onVisibilityChanged(changedView, visibility)
        updateAnimation()
    }

    override fun onWindowVisibilityChanged(visibility: Int) {
        super.onWindowVisibilityChanged(visibility)
        updateAnimation()
    }

    private fun updateAnimation() {
        if (isAttachedToWindow && isShown && windowVisibility == VISIBLE) startAnimation() else stopAnimation()
    }

    private fun startAnimation() {
        if (animator != null) return
        animator = ValueAnimator.ofFloat(0f, 1f).apply {
            duration = 1300L
            repeatCount = ValueAnimator.INFINITE
            interpolator = LinearInterpolator()
            addUpdateListener {
                phase = it.animatedValue as Float
                invalidate()
            }
            start()
        }
    }

    private fun stopAnimation() {
        animator?.cancel()
        animator = null
    }

    override fun onDraw(canvas: Canvas) {
        val w = width.toFloat()
        val h = height.toFloat()
        if (w <= 0f || h <= 0f) return
        // the band travels from left of the view to right of it
        val band = w * 0.7f
        shaderMatrix.setTranslate(-band + phase * (w + band), 0f)
        gradient?.setLocalMatrix(shaderMatrix)
        when (style) {
            Style.PHOTOS -> drawPhotos(canvas, w, h)
            Style.ALBUMS -> drawAlbums(canvas, w, h)
            Style.APPS -> drawApps(canvas, w, h)
        }
    }

    private fun drawPhotos(canvas: Canvas, w: Float, h: Float) {
        val gap = 2f * d
        val cell = (w - gap * (columns + 1)) / columns
        var y = gap
        val barH = 14f * d
        while (y < h) {
            // date header bar
            rect.set(12f * d, y + 10f * d, 12f * d + 110f * d, y + 10f * d + barH)
            canvas.drawRoundRect(rect, barH / 2f, barH / 2f, paint)
            y += 10f * d + barH + 10f * d
            for (row in 0 until 3) {
                if (y >= h) break
                for (c in 0 until columns) {
                    val x = gap + c * (cell + gap)
                    rect.set(x, y, x + cell, y + cell)
                    canvas.drawRect(rect, paint)
                }
                y += cell + gap
            }
        }
    }

    private fun drawAlbums(canvas: Canvas, w: Float, h: Float) {
        val cols = columns
        val pad = 12f * d
        val gap = 12f * d
        val cell = (w - pad * 2 - gap * (cols - 1)) / cols
        val corner = 16f * d
        val bar = 12f * d
        var y = pad
        while (y < h) {
            for (c in 0 until cols) {
                val x = pad + c * (cell + gap)
                rect.set(x, y, x + cell, y + cell)
                canvas.drawRoundRect(rect, corner, corner, paint)
                rect.set(x + 4f * d, y + cell + 10f * d, x + 4f * d + cell * 0.7f, y + cell + 10f * d + bar)
                canvas.drawRoundRect(rect, bar / 2f, bar / 2f, paint)
                rect.set(x + 4f * d, y + cell + 10f * d + bar + 8f * d, x + 4f * d + cell * 0.4f, y + cell + 10f * d + bar * 2f + 8f * d)
                canvas.drawRoundRect(rect, bar / 2f, bar / 2f, paint)
            }
            y += cell + 10f * d + bar * 2f + 8f * d + gap
        }
    }

    private fun drawApps(canvas: Canvas, w: Float, h: Float) {
        val cols = columns
        val cell = w / cols
        val icon = 48f * d
        val bar = 10f * d
        var y = 10f * d
        while (y < h) {
            for (c in 0 until cols) {
                val cx = c * cell + cell / 2f
                rect.set(cx - icon / 2f, y, cx + icon / 2f, y + icon)
                canvas.drawRoundRect(rect, icon * 0.28f, icon * 0.28f, paint)
                rect.set(cx - cell * 0.30f, y + icon + 8f * d, cx + cell * 0.30f, y + icon + 8f * d + bar)
                canvas.drawRoundRect(rect, bar / 2f, bar / 2f, paint)
            }
            y += icon + 8f * d + bar + 22f * d
        }
    }

    private companion object {
        const val BASE = 0x14FFFFFF
        const val HIGHLIGHT = 0x30FFFFFF
    }
}

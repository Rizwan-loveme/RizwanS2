package com.srizwan.YouTube.ui

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.ColorFilter
import android.graphics.LinearGradient
import android.graphics.Paint
import android.graphics.PixelFormat
import android.graphics.RectF
import android.graphics.Rect
import android.graphics.Shader
import android.graphics.drawable.Drawable
import kotlin.math.min

/**
 * The glass look of the YouTube app: a smoked translucent body, a soft light-to-clear gradient on top of it
 * and a thin bright rim that fades along the diagonal (light catching the edge of the glass).
 * [radiusDp] larger than half the side makes a pill / circle. [strong] is a denser body for sheets that sit
 * over busy content.
 *
 * Real background blur is not possible for a plain view; the sheet dialog ([GlassSheet]) adds the system's
 * window blur on Android 12+ on top of this.
 */
class GlassDrawable(
    context: Context,
    private val radiusDp: Float = 16f,
    private val strong: Boolean = false
) : Drawable() {

    private val density = context.resources.displayMetrics.density
    private val rect = RectF()
    private val body = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.FILL
        color = if (strong) 0xB8101418.toInt() else 0x8C101418.toInt()
    }
    private val sheen = Paint(Paint.ANTI_ALIAS_FLAG).apply { style = Paint.Style.FILL }
    private val rim = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.STROKE
        strokeWidth = 1.2f * density
    }

    override fun onBoundsChange(b: Rect) {
        val inset = rim.strokeWidth / 2f
        rect.set(b.left + inset, b.top + inset, b.right - inset, b.bottom - inset)
        sheen.shader = LinearGradient(
            0f, rect.top, 0f, rect.bottom,
            intArrayOf(Color.argb(if (strong) 70 else 54, 255, 255, 255), Color.argb(10, 255, 255, 255)),
            null, Shader.TileMode.CLAMP
        )
        rim.shader = LinearGradient(
            rect.left, rect.top, rect.right, rect.bottom,
            intArrayOf(
                Color.argb(190, 255, 255, 255),
                Color.argb(28, 255, 255, 255),
                Color.argb(110, 255, 255, 255)
            ),
            floatArrayOf(0f, 0.55f, 1f), Shader.TileMode.CLAMP
        )
    }

    override fun draw(canvas: Canvas) {
        if (rect.isEmpty) return
        val r = min(radiusDp * density, min(rect.width(), rect.height()) / 2f)
        canvas.drawRoundRect(rect, r, r, body)
        canvas.drawRoundRect(rect, r, r, sheen)
        canvas.drawRoundRect(rect, r, r, rim)
    }

    override fun setAlpha(alpha: Int) {
        body.alpha = (alpha * Color.alpha(body.color) / 255)
        sheen.alpha = alpha
        rim.alpha = alpha
        invalidateSelf()
    }

    override fun setColorFilter(colorFilter: ColorFilter?) {
        body.colorFilter = colorFilter
        invalidateSelf()
    }

    @Deprecated("Deprecated in Java")
    override fun getOpacity(): Int = PixelFormat.TRANSLUCENT
}

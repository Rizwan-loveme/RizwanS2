package com.srizwan.chooser.ui

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.ColorFilter
import android.graphics.Paint
import android.graphics.Path
import android.graphics.PixelFormat
import android.graphics.Rect
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import kotlin.math.max

/**
 * A label that is pure vector: an optional vector icon followed by [text] drawn as glyph OUTLINES
 * (`Paint.getTextPath`), not as text. No TextView is needed anywhere in the Chooser: names, dates and numbers such as
 * "12 photos", "2026-11-21" or "4000 x 3000" are paths, exactly like the icons beside them.
 *
 * Use it as the drawable of an ImageView. [text] and [iconRes] are both optional.
 */
class VectorLabelDrawable(
    context: Context,
    text: String? = null,
    @DrawableRes iconRes: Int = 0,
    textSizeDp: Float = 14f,
    iconSizeDp: Float = 20f,
    private val tint: Int = Color.WHITE
) : Drawable() {

    private val density = context.resources.displayMetrics.density
    private val icon: Drawable? = if (iconRes != 0) {
        ContextCompat.getDrawable(context, iconRes)?.mutate()?.also { DrawableCompat.setTint(it, tint) }
    } else null
    private val iconPx = (iconSizeDp * density).toInt()
    private val gapPx = (6 * density).toInt()

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = tint
        style = Paint.Style.FILL
        textSize = textSizeDp * density
        typeface = Typeface.create(Typeface.DEFAULT, Typeface.BOLD)
    }
    private val path = Path()
    private val hasText = !text.isNullOrEmpty()
    private val textWidth: Float
    private val capHeight: Float

    init {
        if (hasText) {
            paint.getTextPath(text, 0, text!!.length, 0f, 0f, path)
            textWidth = paint.measureText(text)
        } else {
            textWidth = 0f
        }
        val r = Rect()
        paint.getTextBounds("0", 0, 1, r)
        capHeight = r.height().toFloat()
    }

    private val width: Int =
        (if (icon != null) iconPx else 0) +
            (if (icon != null && hasText) gapPx else 0) +
            Math.ceil(textWidth.toDouble()).toInt()
    private val height: Int = max(if (icon != null) iconPx else 0, if (hasText) Math.ceil(capHeight.toDouble()).toInt() else 0)

    override fun getIntrinsicWidth(): Int = width
    override fun getIntrinsicHeight(): Int = height

    override fun draw(canvas: Canvas) {
        val b = bounds
        // content is centred in the bounds
        var x = b.left + (b.width() - width) / 2f
        val cy = b.top + b.height() / 2f
        if (icon != null) {
            val top = (cy - iconPx / 2f).toInt()
            val left = x.toInt()
            icon.setBounds(left, top, left + iconPx, top + iconPx)
            icon.draw(canvas)
            x += iconPx + (if (hasText) gapPx else 0)
        }
        if (hasText) {
            val save = canvas.save()
            canvas.translate(x, cy + capHeight / 2f)
            canvas.drawPath(path, paint)
            canvas.restoreToCount(save)
        }
    }

    override fun setAlpha(alpha: Int) {
        paint.alpha = alpha
        icon?.alpha = alpha
        invalidateSelf()
    }

    override fun setColorFilter(colorFilter: ColorFilter?) {
        paint.colorFilter = colorFilter
        icon?.colorFilter = colorFilter
        invalidateSelf()
    }

    @Deprecated("Deprecated in Java")
    override fun getOpacity(): Int = PixelFormat.TRANSLUCENT
}

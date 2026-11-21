package com.srizwan.gallery.loader

import android.content.Context
import android.graphics.Canvas
import android.graphics.ColorFilter
import android.graphics.PixelFormat
import android.graphics.drawable.Drawable
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat

/**
 * A vector icon centred in whatever size the view gives it, at a fixed size and a soft alpha. It has no intrinsic
 * size, so a CENTER_CROP grid cell shows the small icon instead of blowing it up to the whole cell.
 * Used by [ImageLoader] for a picture that could not be decoded.
 */
class IconPlaceholder(
    context: Context,
    @DrawableRes res: Int,
    private val sizeDp: Float = 28f,
    private val softness: Float = 0.45f
) : Drawable() {

    private val density = context.resources.displayMetrics.density
    private val icon: Drawable? = ContextCompat.getDrawable(context, res)?.mutate()

    override fun draw(canvas: Canvas) {
        val ic = icon ?: return
        val b = bounds
        val s = (sizeDp * density).toInt()
        val left = b.centerX() - s / 2
        val top = b.centerY() - s / 2
        ic.setBounds(left, top, left + s, top + s)
        ic.alpha = (255 * softness).toInt()
        ic.draw(canvas)
    }

    override fun setAlpha(alpha: Int) {
        invalidateSelf()
    }

    override fun setColorFilter(colorFilter: ColorFilter?) {
        icon?.colorFilter = colorFilter
        invalidateSelf()
    }

    @Deprecated("Deprecated in Java")
    override fun getOpacity(): Int = PixelFormat.TRANSLUCENT
}

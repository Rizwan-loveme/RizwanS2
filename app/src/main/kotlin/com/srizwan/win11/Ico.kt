package com.srizwan.win11

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.Gravity
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources

/** Vector-icon helpers: the app uses vector drawables only (no emoji, no text glyphs as icons). */
object Ico {
    fun drawable(ctx: Context, res: Int, sizeDp: Int, tint: Int): Drawable? = try {
        val d = AppCompatResources.getDrawable(ctx, res)?.mutate()
        if (d == null) null else {
            val px = (sizeDp * ctx.resources.displayMetrics.density).toInt()
            d.setBounds(0, 0, px, px)
            d.setTint(tint)
            d
        }
    } catch (e: Throwable) {
        AppLog.e("Ico", "icon $res failed", e)
        null
    }
}

/** Icon only (no text), centered in the view. */
fun TextView.iconOnly(res: Int, sizeDp: Int = 22, tint: Int = currentTextColor) {
    text = ""
    gravity = Gravity.CENTER
    setCompoundDrawables(Ico.drawable(context, res, sizeDp, tint), null, null, null)
    compoundDrawablePadding = 0
}

/** Vector icon before the text (replaces a leading emoji). */
fun TextView.iconStart(res: Int, sizeDp: Int = 18, tint: Int = currentTextColor, gapDp: Int = 8) {
    setCompoundDrawables(Ico.drawable(context, res, sizeDp, tint), null, null, null)
    compoundDrawablePadding = (gapDp * resources.displayMetrics.density).toInt()
}

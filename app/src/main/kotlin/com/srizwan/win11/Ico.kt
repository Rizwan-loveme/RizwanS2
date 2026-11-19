package com.srizwan.win11

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
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

/**
 * A TextView draws its compound drawable at the left padding edge, not in the middle, so an icon-only
 * key / button with a fixed or weighted width ended up glued to the left. This layout listener adds the
 * extra padding that puts the icon (or the icon + text group) in the middle. It does nothing for
 * wrap_content views, and for [groupWithText] views only when the text is horizontally centered.
 */
private class CenterIconListener(
    private val tv: TextView,
    var iconPx: Int,
    var gapPx: Int,
    var groupWithText: Boolean
) : View.OnLayoutChangeListener {
    private var baseL = -1
    private var baseR = 0

    override fun onLayoutChange(
        v: View?, l: Int, t: Int, r: Int, b: Int, ol: Int, ot: Int, or_: Int, ob: Int
    ) {
        val lp = tv.layoutParams
        if (lp != null && lp.width == ViewGroup.LayoutParams.WRAP_CONTENT) return
        if (groupWithText && (tv.gravity and Gravity.HORIZONTAL_GRAVITY_MASK) != Gravity.CENTER_HORIZONTAL) return
        if (baseL < 0) { baseL = tv.paddingLeft; baseR = tv.paddingRight }
        val w = r - l
        val text = tv.text?.toString().orEmpty()
        val textW = if (groupWithText && text.isNotEmpty()) Math.ceil(tv.paint.measureText(text).toDouble()).toInt() else 0
        val content = iconPx + if (textW > 0) gapPx + textW else 0
        val extra = ((w - baseL - baseR - content) / 2).coerceAtLeast(0)
        val newL = baseL + extra
        val newR = baseR + extra
        if (tv.paddingLeft != newL || tv.paddingRight != newR) {
            tv.setPadding(newL, tv.paddingTop, newR, tv.paddingBottom)
        }
    }
}

private fun TextView.installCenterIcon(iconPx: Int, gapPx: Int, groupWithText: Boolean) {
    val existing = getTag(R.id.tag_center_icon) as? CenterIconListener
    if (existing != null) {
        existing.iconPx = iconPx; existing.gapPx = gapPx; existing.groupWithText = groupWithText
    } else {
        val l = CenterIconListener(this, iconPx, gapPx, groupWithText)
        setTag(R.id.tag_center_icon, l)
        addOnLayoutChangeListener(l)
    }
    requestLayout()
}

/** Icon only (no text), centered in the view. */
fun TextView.iconOnly(res: Int, sizeDp: Int = 22, tint: Int = currentTextColor) {
    text = ""
    gravity = Gravity.CENTER
    setCompoundDrawables(Ico.drawable(context, res, sizeDp, tint), null, null, null)
    compoundDrawablePadding = 0
    installCenterIcon((sizeDp * resources.displayMetrics.density).toInt(), 0, false)
}

/** Vector icon before the text (replaces a leading emoji). Centered together with the text when the view's text is centered. */
fun TextView.iconStart(res: Int, sizeDp: Int = 18, tint: Int = currentTextColor, gapDp: Int = 8) {
    setCompoundDrawables(Ico.drawable(context, res, sizeDp, tint), null, null, null)
    val gap = (gapDp * resources.displayMetrics.density).toInt()
    compoundDrawablePadding = gap
    installCenterIcon((sizeDp * resources.displayMetrics.density).toInt(), gap, true)
}

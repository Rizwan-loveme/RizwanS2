package com.srizwan.chooser.ui

import android.content.Context
import android.graphics.drawable.GradientDrawable
import android.view.View
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import com.srizwan.chooser.R

/**
 * Text buttons of the Chooser sheets ("Just once", "Always", "Find in store"): a pill with a vector-outline label (and an optional
 * vector icon). [pill] with `primary = true` is the accent button, `false` is a plain glass pill.
 */
object GlassButtons {

    fun pill(
        context: Context,
        label: String,
        primary: Boolean,
        @DrawableRes icon: Int = 0,
        onClick: () -> Unit
    ): ImageView = ImageView(context).apply {
        scaleType = ImageView.ScaleType.CENTER
        setImageDrawable(VectorLabelDrawable(context, label, icon, textSizeDp = 15f, iconSizeDp = 20f))
        contentDescription = label
        isClickable = true
        isFocusable = true
        val ph = GlassUi.dp(context, 22f)
        val pv = GlassUi.dp(context, 12f)
        setPadding(ph, pv, ph, pv)
        background = if (primary) {
            val accent = ContextCompat.getColor(context, R.color.ch_accent)
            GradientDrawable().apply {
                cornerRadius = GlassUi.dp(context, 24f).toFloat()
                setColor(accent and 0x00FFFFFF or 0x59000000)
                setStroke(GlassUi.dp(context, 1f), accent)
            }
        } else {
            GlassDrawable(context, 24f)
        }
        GlassUi.borderless(context)?.let { foreground = it }
        setOnClickListener { if (isEnabled) onClick() }
    }

    /** Greys a pill out (and makes it ignore taps) or brings it back. */
    fun setEnabled(button: View, enabled: Boolean) {
        button.isEnabled = enabled
        button.isClickable = enabled
        button.alpha = if (enabled) 1f else 0.38f
    }
}

package com.srizwan.chooser.ui

import android.content.Context
import android.graphics.drawable.GradientDrawable
import android.util.AttributeSet
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import com.srizwan.chooser.R

/**
 * A centred glass card for "nothing to show": a round glass icon, a title, a short text and (optionally) one button.
 * Used for "no photos", "no matches" and "permission needed". Text is drawn as glyph outlines ([VectorText]).
 * Call [show] to change what it says; the card is invisible until then (the screen shows / hides the view itself).
 */
class GlassEmptyState @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : FrameLayout(context, attrs) {

    private val card = LinearLayout(context).apply {
        orientation = LinearLayout.VERTICAL
        gravity = Gravity.CENTER_HORIZONTAL
        background = GlassDrawable(context, 28f)
        val p = GlassUi.dp(context, 24f)
        setPadding(p, p, p, p)
    }
    private val icon = ImageView(context).apply {
        scaleType = ImageView.ScaleType.CENTER_INSIDE
        background = GlassDrawable(context, 40f)
        val p = GlassUi.dp(context, 20f)
        setPadding(p, p, p, p)
    }
    private val title = VectorText(context)
    private val text = VectorText(context)
    private val button = ImageView(context).apply {
        scaleType = ImageView.ScaleType.CENTER
        isClickable = true
        isFocusable = true
        val ph = GlassUi.dp(context, 22f)
        val pv = GlassUi.dp(context, 12f)
        setPadding(ph, pv, ph, pv)
        background = GradientDrawable().apply {
            cornerRadius = GlassUi.dp(context, 24f).toFloat()
            setColor(ContextCompat.getColor(context, R.color.ch_accent) and 0x00FFFFFF or 0x59000000)
            setStroke(GlassUi.dp(context, 1f), ContextCompat.getColor(context, R.color.ch_accent))
        }
        GlassUi.borderless(context)?.let { foreground = it }
    }

    init {
        val w = GlassUi.dp(context, 300f)
        card.addView(icon, LinearLayout.LayoutParams(GlassUi.dp(context, 84f), GlassUi.dp(context, 84f)))
        card.addView(
            title,
            LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
                .apply { topMargin = GlassUi.dp(context, 18f) }
        )
        card.addView(
            text,
            LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
                .apply { topMargin = GlassUi.dp(context, 8f) }
        )
        card.addView(
            button,
            LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
                .apply { topMargin = GlassUi.dp(context, 20f) }
        )
        addView(card, LayoutParams(w, ViewGroup.LayoutParams.WRAP_CONTENT, Gravity.CENTER))
    }

    /** [buttonLabel] null hides the button. */
    fun show(
        @DrawableRes iconRes: Int,
        titleText: String,
        bodyText: String,
        buttonLabel: String? = null,
        onButton: (() -> Unit)? = null
    ) {
        icon.setImageDrawable(VectorLabelDrawable(context, null, iconRes, iconSizeDp = 40f))
        title.set(titleText, 18f, 0xFFFFFFFF.toInt(), bold = true, maxLines = 3, center = true)
        text.set(bodyText, 14f, 0xB3FFFFFF.toInt(), maxLines = 4, center = true)
        if (buttonLabel != null) {
            button.visibility = View.VISIBLE
            button.setImageDrawable(VectorLabelDrawable(context, buttonLabel, 0, textSizeDp = 15f))
            button.contentDescription = buttonLabel
            button.setOnClickListener { onButton?.invoke() }
        } else {
            button.visibility = View.GONE
            button.setOnClickListener(null)
        }
    }
}

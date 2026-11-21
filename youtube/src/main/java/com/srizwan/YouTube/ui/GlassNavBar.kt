package com.srizwan.YouTube.ui

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.view.Gravity
import android.widget.ImageView
import android.widget.LinearLayout
import com.srizwan.YouTube.R

/** The three main screens of the YouTube app. */
enum class YtTab { HOME, SEARCH, HISTORY }

/**
 * The bottom navigation of the YouTube app: a glass pill with one vector icon per main screen (home, search,
 * history). The open screen shows its icon with a vector-outline label inside a light pill; the others are dim
 * icons. A tap on any tab calls [onSelect] (also on the open one, so the search screen can focus its field).
 * Add it as the last child of a screen's root; [YtNav.switchTab] does the switching.
 */
class GlassNavBar(
    context: Context,
    private val selected: YtTab,
    private val onSelect: (YtTab) -> Unit
) : LinearLayout(context) {

    private class Def(val tab: YtTab, val icon: Int, val label: String, val cd: Int)

    init {
        val d = resources.displayMetrics.density
        fun dp(v: Int) = (v * d).toInt()
        orientation = HORIZONTAL
        gravity = Gravity.CENTER_VERTICAL
        background = GlassDrawable(context, 30f, strong = true)
        setPadding(dp(6), dp(6), dp(6), dp(6))

        val defs = listOf(
            Def(YtTab.HOME, R.drawable.ic_home, "Home", R.string.yt_cd_home),
            Def(YtTab.SEARCH, R.drawable.ic_search, "Search", R.string.yt_cd_search),
            Def(YtTab.HISTORY, R.drawable.ic_history, "History", R.string.yt_cd_history)
        )
        for (def in defs) {
            val open = def.tab == selected
            val tab = ImageView(context).apply {
                scaleType = ImageView.ScaleType.CENTER // draw at its own size, never scaled up
                setImageDrawable(
                    VectorLabelDrawable(
                        context, if (open) def.label else null, def.icon,
                        textSizeDp = 13f, iconSizeDp = 22f,
                        tint = if (open) Color.WHITE else 0xFFAAAAAA.toInt()
                    )
                )
                contentDescription = context.getString(def.cd)
                if (open) {
                    background = GradientDrawable().apply {
                        setColor(0x3DFFFFFF)
                        cornerRadius = 40f * d
                    }
                }
                isClickable = true
                setOnClickListener { onSelect(def.tab) }
            }
            addView(tab, LayoutParams(0, dp(44), 1f).apply {
                marginStart = dp(3)
                marginEnd = dp(3)
            })
        }
    }

    /** Layout params for a root LinearLayout: full width with a small margin all round. */
    fun rootParams(): LayoutParams {
        val d = resources.displayMetrics.density
        return LayoutParams(-1, -2).apply {
            setMargins((14 * d).toInt(), (4 * d).toInt(), (14 * d).toInt(), (8 * d).toInt())
        }
    }
}

package com.srizwan.YouTube.home

import android.content.Context
import android.graphics.Color
import android.graphics.Outline
import android.graphics.drawable.GradientDrawable
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.view.ViewOutlineProvider
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.srizwan.YouTube.data.YtItem
import com.srizwan.YouTube.ui.Format
import com.srizwan.YouTube.ui.GlassDrawable
import com.srizwan.YouTube.ui.ThumbLoader
import com.srizwan.YouTube.ui.VectorLabelDrawable
import com.srizwan.YouTube.ui.VectorText

/**
 * The cards of the home feed: a glass panel with a rounded 16:9 thumbnail (duration or LIVE badge in the
 * corner), the title (two lines) and one meta line (channel, views, age). All text is vector ([VectorText]).
 * A tap calls [onClick] (the screen opens the player).
 * [create] and [bind] are public so other lists (the search results) draw exactly the same card.
 */
class VideoCardAdapter(
    private val onClick: (YtItem.Video) -> Unit
) : RecyclerView.Adapter<VideoCardAdapter.VH>() {

    private val items = ArrayList<YtItem.Video>()

    class VH(
        val card: LinearLayout,
        val thumb: ImageView,
        val badge: ImageView,
        val title: VectorText,
        val meta: VectorText
    ) : RecyclerView.ViewHolder(card)

    /** A frame that is always 16:9 for the width it gets. */
    private class RatioFrame(context: Context) : FrameLayout(context) {
        override fun onMeasure(widthSpec: Int, heightSpec: Int) {
            val w = MeasureSpec.getSize(widthSpec)
            super.onMeasure(widthSpec, MeasureSpec.makeMeasureSpec(w * 9 / 16, MeasureSpec.EXACTLY))
        }
    }

    fun setAll(list: List<YtItem.Video>) {
        items.clear()
        items.addAll(list)
        notifyDataSetChanged()
    }

    fun append(list: List<YtItem.Video>) {
        if (list.isEmpty()) return
        val start = items.size
        items.addAll(list)
        notifyItemRangeInserted(start, list.size)
    }

    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH = create(parent)

    override fun onBindViewHolder(h: VH, position: Int) = bind(h, items[position], onClick)

    companion object {

        /** Builds one empty card; give it a video with [bind]. */
        fun create(parent: ViewGroup): VH {
            val ctx = parent.context
            val d = ctx.resources.displayMetrics.density
            fun dp(v: Int) = (v * d).toInt()

            val thumb = ImageView(ctx).apply {
                scaleType = ImageView.ScaleType.CENTER_CROP
                setBackgroundColor(0xFF1A1A1A.toInt())
            }
            val badge = ImageView(ctx).apply {
                setPadding(dp(6), dp(4), dp(6), dp(4))
                visibility = View.GONE
            }
            val thumbBox = RatioFrame(ctx).apply {
                clipToOutline = true
                outlineProvider = object : ViewOutlineProvider() {
                    override fun getOutline(view: View, outline: Outline) {
                        outline.setRoundRect(0, 0, view.width, view.height, 14f * d)
                    }
                }
                addView(thumb, FrameLayout.LayoutParams(-1, -1))
                addView(badge, FrameLayout.LayoutParams(-2, -2, Gravity.END or Gravity.BOTTOM).apply {
                    setMargins(0, 0, dp(6), dp(6))
                })
            }

            val title = VectorText(ctx)
            val meta = VectorText(ctx)
            val info = LinearLayout(ctx).apply {
                orientation = LinearLayout.VERTICAL
                setPadding(dp(8), dp(9), dp(8), dp(5))
                addView(title, LinearLayout.LayoutParams(-1, -2))
                addView(meta, LinearLayout.LayoutParams(-1, -2).apply { topMargin = dp(4) })
            }

            val card = LinearLayout(ctx).apply {
                orientation = LinearLayout.VERTICAL
                background = GlassDrawable(ctx, 18f)
                setPadding(dp(6), dp(6), dp(6), dp(4))
                isClickable = true
                addView(thumbBox, LinearLayout.LayoutParams(-1, -2))
                addView(info, LinearLayout.LayoutParams(-1, -2))
                layoutParams = RecyclerView.LayoutParams(-1, -2).apply {
                    setMargins(dp(10), dp(6), dp(10), dp(6))
                }
            }
            return VH(card, thumb, badge, title, meta)
        }

        fun bind(h: VH, v: YtItem.Video, onClick: (YtItem.Video) -> Unit) {
            val ctx = h.card.context
            val d = ctx.resources.displayMetrics.density

            ThumbLoader.load(h.thumb, v.thumb, ctx.resources.displayMetrics.widthPixels / 2)
            h.title.set(v.title, 15f, Color.WHITE, bold = true, maxLines = 2)
            h.meta.set(metaLine(v), 12.5f, 0xFFAAAAAA.toInt(), maxLines = 1)

            when {
                v.isLive -> showBadge(h.badge, "LIVE", 0xE6FF0000.toInt(), d)
                v.duration > 0 -> showBadge(h.badge, Format.duration(v.duration), 0xCC000000.toInt(), d)
                else -> h.badge.visibility = View.GONE
            }
            h.card.setOnClickListener { onClick(v) }
        }

        private fun showBadge(badge: ImageView, label: String, color: Int, d: Float) {
            badge.setImageDrawable(VectorLabelDrawable(badge.context, label, 0, textSizeDp = 11f))
            badge.background = GradientDrawable().apply {
                setColor(color)
                cornerRadius = 6f * d
            }
            badge.visibility = View.VISIBLE
        }

        private fun metaLine(v: YtItem.Video): String {
            val parts = ArrayList<String>(3)
            if (v.channel.isNotBlank()) parts.add(v.channel)
            Format.count(v.views)?.let { parts.add("$it views") }
            if (!v.uploaded.isNullOrBlank()) parts.add(v.uploaded)
            return parts.joinToString("  \u00B7  ")
        }
    }
}

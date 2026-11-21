package com.srizwan.YouTube.history

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
import com.srizwan.YouTube.R
import com.srizwan.YouTube.data.YtHistory
import com.srizwan.YouTube.ui.Format
import com.srizwan.YouTube.ui.GlassDrawable
import com.srizwan.YouTube.ui.ThumbLoader
import com.srizwan.YouTube.ui.VectorLabelDrawable
import com.srizwan.YouTube.ui.VectorText

/**
 * The "watched" list: a glass row per video (16:9 thumbnail with the duration in the corner, title, channel,
 * how long ago it was watched) and a cross that removes it from the history. A tap plays it again.
 */
class WatchHistoryAdapter(
    private val onOpen: (YtHistory.Entry) -> Unit,
    private val onRemove: (YtHistory.Entry) -> Unit
) : RecyclerView.Adapter<WatchHistoryAdapter.VH>() {

    private val items = ArrayList<YtHistory.Entry>()

    class VH(
        val card: LinearLayout,
        val thumb: ImageView,
        val badge: ImageView,
        val title: VectorText,
        val meta: VectorText,
        val remove: ImageView
    ) : RecyclerView.ViewHolder(card)

    fun setAll(list: List<YtHistory.Entry>) {
        items.clear()
        items.addAll(list)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
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
        val thumbBox = FrameLayout(ctx).apply {
            clipToOutline = true
            outlineProvider = object : ViewOutlineProvider() {
                override fun getOutline(view: View, outline: Outline) {
                    outline.setRoundRect(0, 0, view.width, view.height, 12f * d)
                }
            }
            addView(thumb, FrameLayout.LayoutParams(-1, -1))
            addView(badge, FrameLayout.LayoutParams(-2, -2, Gravity.END or Gravity.BOTTOM).apply {
                setMargins(0, 0, dp(5), dp(5))
            })
        }
        val title = VectorText(ctx)
        val meta = VectorText(ctx)
        val info = LinearLayout(ctx).apply {
            orientation = LinearLayout.VERTICAL
            addView(title, LinearLayout.LayoutParams(-1, -2))
            addView(meta, LinearLayout.LayoutParams(-1, -2).apply { topMargin = dp(5) })
        }
        val remove = ImageView(ctx).apply {
            setImageDrawable(
                VectorLabelDrawable(ctx, null, R.drawable.ic_close, iconSizeDp = 20f, tint = 0xFFAAAAAA.toInt())
            )
            contentDescription = ctx.getString(R.string.yt_cd_remove_watch)
            setPadding(dp(9), dp(9), dp(9), dp(9))
        }
        val card = LinearLayout(ctx).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER_VERTICAL
            background = GlassDrawable(ctx, 18f)
            setPadding(dp(8), dp(8), dp(4), dp(8))
            isClickable = true
            addView(thumbBox, LinearLayout.LayoutParams(dp(144), dp(81)).apply { marginEnd = dp(12) })
            addView(info, LinearLayout.LayoutParams(0, -2, 1f))
            addView(remove, LinearLayout.LayoutParams(dp(38), dp(38)).apply { gravity = Gravity.TOP })
            layoutParams = RecyclerView.LayoutParams(-1, -2).apply {
                setMargins(dp(10), dp(6), dp(10), dp(6))
            }
        }
        return VH(card, thumb, badge, title, meta, remove)
    }

    override fun onBindViewHolder(h: VH, position: Int) {
        val e = items[position]
        val ctx = h.card.context
        val d = ctx.resources.displayMetrics.density

        ThumbLoader.load(h.thumb, e.thumb, (144 * d).toInt())
        h.title.set(e.title, 14.5f, Color.WHITE, bold = true, maxLines = 2)

        val parts = ArrayList<String>(2)
        if (e.channel.isNotBlank()) parts.add(e.channel)
        if (e.watchedAt > 0) parts.add(Format.ago(e.watchedAt))
        h.meta.set(parts.joinToString("  ·  "), 12.5f, 0xFFAAAAAA.toInt(), maxLines = 2)

        if (e.duration > 0) {
            h.badge.setImageDrawable(VectorLabelDrawable(ctx, Format.duration(e.duration), 0, textSizeDp = 11f))
            h.badge.background = GradientDrawable().apply {
                setColor(0xCC000000.toInt())
                cornerRadius = 6f * d
            }
            h.badge.visibility = View.VISIBLE
        } else {
            h.badge.visibility = View.GONE
        }

        h.card.setOnClickListener { onOpen(e) }
        h.remove.setOnClickListener {
            val pos = h.bindingAdapterPosition
            if (pos != RecyclerView.NO_POSITION) {
                items.removeAt(pos)
                notifyItemRemoved(pos)
                onRemove(e)
            }
        }
    }
}

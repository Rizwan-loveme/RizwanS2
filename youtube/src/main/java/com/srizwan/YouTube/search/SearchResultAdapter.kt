package com.srizwan.YouTube.search

import android.content.res.ColorStateList
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
import android.widget.ProgressBar
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.srizwan.YouTube.R
import com.srizwan.YouTube.data.YtItem
import com.srizwan.YouTube.home.VideoCardAdapter
import com.srizwan.YouTube.ui.Format
import com.srizwan.YouTube.ui.GlassDrawable
import com.srizwan.YouTube.ui.ThumbLoader
import com.srizwan.YouTube.ui.VectorLabelDrawable
import com.srizwan.YouTube.ui.VectorText

/**
 * Search results: three kinds of row in one list.
 *  - video: the same glass card as the home feed ([VideoCardAdapter.create] / [VideoCardAdapter.bind]);
 *  - channel: a round avatar, the name, the subscriber count and two lines of description;
 *  - playlist: a 16:9 thumbnail with the video count in the corner, the title and the owner.
 * An optional footer (a small red spinner) shows while the next page loads. All text is vector ([VectorText]).
 */
class SearchResultAdapter(
    private val onVideo: (YtItem.Video) -> Unit,
    private val onChannel: (YtItem.Channel) -> Unit,
    private val onPlaylist: (YtItem.Playlist) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val TYPE_VIDEO = 0
        const val TYPE_CHANNEL = 1
        const val TYPE_PLAYLIST = 2
        const val TYPE_FOOTER = 3
    }

    private val items = ArrayList<YtItem>()
    private var footer = false

    class ChannelVH(
        val card: LinearLayout,
        val avatar: ImageView,
        val name: VectorText,
        val meta: VectorText,
        val desc: VectorText
    ) : RecyclerView.ViewHolder(card)

    class PlaylistVH(
        val card: LinearLayout,
        val thumb: ImageView,
        val badge: ImageView,
        val title: VectorText,
        val meta: VectorText
    ) : RecyclerView.ViewHolder(card)

    class FooterVH(view: View) : RecyclerView.ViewHolder(view)

    fun setAll(list: List<YtItem>) {
        items.clear()
        items.addAll(list)
        notifyDataSetChanged()
    }

    fun append(list: List<YtItem>) {
        if (list.isEmpty()) return
        val start = items.size
        items.addAll(list)
        notifyItemRangeInserted(start, list.size)
    }

    /** Shows / hides the spinner after the last row. */
    fun setFooter(show: Boolean) {
        if (footer == show) return
        footer = show
        if (show) notifyItemInserted(items.size) else notifyItemRemoved(items.size)
    }

    override fun getItemCount(): Int = items.size + if (footer) 1 else 0

    override fun getItemViewType(position: Int): Int {
        if (position >= items.size) return TYPE_FOOTER
        return when (items[position]) {
            is YtItem.Video -> TYPE_VIDEO
            is YtItem.Channel -> TYPE_CHANNEL
            is YtItem.Playlist -> TYPE_PLAYLIST
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder = when (viewType) {
        TYPE_VIDEO -> VideoCardAdapter.create(parent)
        TYPE_CHANNEL -> createChannel(parent)
        TYPE_PLAYLIST -> createPlaylist(parent)
        else -> createFooter(parent)
    }

    override fun onBindViewHolder(h: RecyclerView.ViewHolder, position: Int) {
        if (position >= items.size) return
        when (h) {
            is VideoCardAdapter.VH -> VideoCardAdapter.bind(h, items[position] as YtItem.Video, onVideo)
            is ChannelVH -> bindChannel(h, items[position] as YtItem.Channel)
            is PlaylistVH -> bindPlaylist(h, items[position] as YtItem.Playlist)
            else -> Unit
        }
    }

    // ---- channel row ----

    private fun createChannel(parent: ViewGroup): ChannelVH {
        val ctx = parent.context
        val d = ctx.resources.displayMetrics.density
        fun dp(v: Int) = (v * d).toInt()

        val avatar = ImageView(ctx).apply {
            scaleType = ImageView.ScaleType.CENTER_CROP
            setBackgroundColor(0xFF2A2A2A.toInt())
            clipToOutline = true
            outlineProvider = object : ViewOutlineProvider() {
                override fun getOutline(view: View, outline: Outline) {
                    outline.setOval(0, 0, view.width, view.height)
                }
            }
        }
        val name = VectorText(ctx)
        val meta = VectorText(ctx)
        val desc = VectorText(ctx)
        val info = LinearLayout(ctx).apply {
            orientation = LinearLayout.VERTICAL
            addView(name, LinearLayout.LayoutParams(-1, -2))
            addView(meta, LinearLayout.LayoutParams(-1, -2).apply { topMargin = dp(3) })
            addView(desc, LinearLayout.LayoutParams(-1, -2).apply { topMargin = dp(5) })
        }
        val card = LinearLayout(ctx).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER_VERTICAL
            background = GlassDrawable(ctx, 18f)
            setPadding(dp(12), dp(12), dp(12), dp(12))
            isClickable = true
            addView(avatar, LinearLayout.LayoutParams(dp(68), dp(68)).apply { marginEnd = dp(14) })
            addView(info, LinearLayout.LayoutParams(0, -2, 1f))
            layoutParams = RecyclerView.LayoutParams(-1, -2).apply {
                setMargins(dp(10), dp(6), dp(10), dp(6))
            }
        }
        return ChannelVH(card, avatar, name, meta, desc)
    }

    private fun bindChannel(h: ChannelVH, c: YtItem.Channel) {
        val ctx = h.card.context
        ThumbLoader.load(h.avatar, c.thumb, (68 * ctx.resources.displayMetrics.density).toInt())
        h.name.set(c.title, 15.5f, Color.WHITE, bold = true, maxLines = 1)
        val subs = Format.count(c.subscribers)
        if (subs != null) {
            h.meta.set("$subs subscribers", 12.5f, 0xFFAAAAAA.toInt(), maxLines = 1)
            h.meta.visibility = View.VISIBLE
        } else {
            h.meta.visibility = View.GONE
        }
        if (!c.description.isNullOrBlank()) {
            h.desc.set(c.description, 12.5f, 0xFF8E8E8E.toInt(), maxLines = 2)
            h.desc.visibility = View.VISIBLE
        } else {
            h.desc.visibility = View.GONE
        }
        h.card.setOnClickListener { onChannel(c) }
    }

    // ---- playlist row ----

    private fun createPlaylist(parent: ViewGroup): PlaylistVH {
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
        val card = LinearLayout(ctx).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER_VERTICAL
            background = GlassDrawable(ctx, 18f)
            setPadding(dp(8), dp(8), dp(12), dp(8))
            isClickable = true
            addView(thumbBox, LinearLayout.LayoutParams(dp(144), dp(81)).apply { marginEnd = dp(12) })
            addView(info, LinearLayout.LayoutParams(0, -2, 1f))
            layoutParams = RecyclerView.LayoutParams(-1, -2).apply {
                setMargins(dp(10), dp(6), dp(10), dp(6))
            }
        }
        return PlaylistVH(card, thumb, badge, title, meta)
    }

    private fun bindPlaylist(h: PlaylistVH, p: YtItem.Playlist) {
        val ctx = h.card.context
        val d = ctx.resources.displayMetrics.density
        ThumbLoader.load(h.thumb, p.thumb, (144 * d).toInt())
        h.title.set(p.title, 14.5f, Color.WHITE, bold = true, maxLines = 3)

        val parts = ArrayList<String>(2)
        if (p.owner.isNotBlank()) parts.add(p.owner)
        Format.count(p.videoCount)?.let { parts.add("$it videos") }
        if (parts.isEmpty()) {
            h.meta.visibility = View.GONE
        } else {
            h.meta.set(parts.joinToString("  ·  "), 12.5f, 0xFFAAAAAA.toInt(), maxLines = 2)
            h.meta.visibility = View.VISIBLE
        }

        val count = Format.count(p.videoCount)
        if (count != null) {
            h.badge.setImageDrawable(
                VectorLabelDrawable(ctx, count, R.drawable.ic_playlist, textSizeDp = 11f, iconSizeDp = 14f)
            )
            h.badge.background = GradientDrawable().apply {
                setColor(0xCC000000.toInt())
                cornerRadius = 6f * d
            }
            h.badge.visibility = View.VISIBLE
        } else {
            h.badge.visibility = View.GONE
        }
        h.card.setOnClickListener { onPlaylist(p) }
    }

    // ---- footer ----

    private fun createFooter(parent: ViewGroup): FooterVH {
        val ctx = parent.context
        val d = ctx.resources.displayMetrics.density
        val bar = ProgressBar(ctx).apply {
            isIndeterminate = true
            indeterminateTintList = ColorStateList.valueOf(ContextCompat.getColor(ctx, R.color.yt_red))
        }
        val box = FrameLayout(ctx).apply {
            addView(bar, FrameLayout.LayoutParams((28 * d).toInt(), (28 * d).toInt(), Gravity.CENTER))
            layoutParams = RecyclerView.LayoutParams(-1, (56 * d).toInt())
        }
        return FooterVH(box)
    }
}

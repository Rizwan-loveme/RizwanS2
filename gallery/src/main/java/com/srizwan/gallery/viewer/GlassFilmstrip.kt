package com.srizwan.gallery.viewer

import android.content.Context
import android.graphics.Outline
import android.graphics.drawable.GradientDrawable
import android.util.DisplayMetrics
import android.view.View
import android.view.ViewGroup
import android.view.ViewOutlineProvider
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSmoothScroller
import androidx.recyclerview.widget.RecyclerView
import com.srizwan.gallery.R
import com.srizwan.gallery.data.GalleryImage
import com.srizwan.gallery.loader.ImageLoader
import com.srizwan.gallery.ui.GlassDrawable
import com.srizwan.gallery.ui.GlassUi
import kotlin.math.abs
import kotlin.math.max

/**
 * The glass filmstrip at the bottom of the viewer: a pill of small square thumbnails. The current picture keeps its
 * place in the CENTRE of the strip (it scrolls under it as you swipe) and has an accent ring; tapping a thumbnail goes
 * to that picture ([onPick]). Thumbnails come from [ImageLoader] (memory + disk cache, cancelled when a cell is
 * recycled). The strip hides itself when there is only one picture.
 */
internal class GlassFilmstrip(context: Context) : FrameLayout(context) {

    /** Called with the position of the thumbnail the user tapped. */
    var onPick: ((Int) -> Unit)? = null

    private val itemPx = GlassUi.dp(context, ITEM_DP)
    private val gapPx = GlassUi.dp(context, GAP_DP)
    private val cellPx = itemPx + gapPx * 2
    private val accent = ContextCompat.getColor(context, R.color.gl_accent)

    private val thumbAdapter = ThumbAdapter()
    private val layout = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
    private val list = RecyclerView(context)
    private var current = 0

    private val rounded = object : ViewOutlineProvider() {
        override fun getOutline(view: View, outline: Outline) {
            outline.setRoundRect(0, 0, view.width, view.height, GlassUi.dp(context, 9f).toFloat())
        }
    }

    init {
        background = GlassDrawable(context, 22f)
        list.layoutManager = layout
        list.adapter = thumbAdapter
        list.clipToPadding = false
        list.itemAnimator = null
        list.setHasFixedSize(true)
        list.overScrollMode = View.OVER_SCROLL_NEVER
        addView(list, LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, cellPx + GlassUi.dp(context, 8f)))
        // Padding of half the free width lets the first and the last picture reach the centre too.
        list.addOnLayoutChangeListener { v, _, _, _, _, _, _, _, _ ->
            val pad = max(0, (v.width - cellPx) / 2)
            if (v.paddingLeft != pad) {
                v.setPadding(pad, v.paddingTop, pad, v.paddingBottom)
                v.post { centerOn(current, smooth = false) }
            }
        }
    }

    fun setImages(images: List<GalleryImage>) {
        thumbAdapter.images = images
        thumbAdapter.notifyDataSetChanged()
        visibility = if (images.size > 1) View.VISIBLE else View.GONE
    }

    /** The picture at [index] changed on disk (rotation saved): its thumbnail is loaded again. */
    fun refresh(index: Int) {
        if (index in 0 until thumbAdapter.itemCount) thumbAdapter.notifyItemChanged(index)
    }

    /** Marks [index] as the current picture and brings it to the centre. */
    fun setCurrent(index: Int, smooth: Boolean) {
        val old = current
        current = index
        thumbAdapter.current = index
        if (old != index) {
            if (old in 0 until thumbAdapter.itemCount) thumbAdapter.notifyItemChanged(old)
            if (index in 0 until thumbAdapter.itemCount) thumbAdapter.notifyItemChanged(index)
        }
        centerOn(index, smooth)
    }

    private fun centerOn(index: Int, smooth: Boolean) {
        if (index !in 0 until thumbAdapter.itemCount) return
        val first = layout.findFirstVisibleItemPosition()
        if (!smooth || width == 0 || first < 0 || abs(index - first) > 14) {
            layout.scrollToPositionWithOffset(index, 0) // item start = padding start = the centre
        } else {
            val scroller = object : LinearSmoothScroller(context) {
                override fun getHorizontalSnapPreference(): Int = SNAP_TO_START
                override fun calculateSpeedPerPixel(displayMetrics: DisplayMetrics): Float = 70f / displayMetrics.densityDpi
            }
            scroller.targetPosition = index
            layout.startSmoothScroll(scroller)
        }
    }

    private class ThumbHolder(val cell: FrameLayout, val thumb: ImageView, val ring: View) : RecyclerView.ViewHolder(cell)

    private inner class ThumbAdapter : RecyclerView.Adapter<ThumbHolder>() {
        var images: List<GalleryImage> = emptyList()
        var current = -1

        override fun getItemCount(): Int = images.size

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ThumbHolder {
            val ctx = parent.context
            val cell = FrameLayout(ctx).apply {
                layoutParams = RecyclerView.LayoutParams(cellPx, cellPx)
                setPadding(gapPx, gapPx, gapPx, gapPx)
            }
            val thumb = ImageView(ctx).apply {
                scaleType = ImageView.ScaleType.CENTER_CROP
                outlineProvider = rounded
                clipToOutline = true
            }
            cell.addView(thumb, FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT))
            val ring = View(ctx).apply {
                visibility = View.GONE
                background = GradientDrawable().apply {
                    cornerRadius = GlassUi.dp(ctx, 9f).toFloat()
                    setStroke(GlassUi.dp(ctx, 2f), accent)
                    setColor(0)
                }
            }
            cell.addView(ring, FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT))
            val holder = ThumbHolder(cell, thumb, ring)
            cell.setOnClickListener {
                val p = holder.bindingAdapterPosition
                if (p != RecyclerView.NO_POSITION) onPick?.invoke(p)
            }
            return holder
        }

        override fun onBindViewHolder(holder: ThumbHolder, position: Int) {
            val image = images[position]
            val selected = position == current
            holder.thumb.contentDescription = image.name
            holder.ring.visibility = if (selected) View.VISIBLE else View.GONE
            holder.cell.alpha = if (selected) 1f else 0.62f
            ImageLoader.load(holder.thumb, image, itemPx)
        }

        override fun onViewRecycled(holder: ThumbHolder) {
            ImageLoader.cancel(holder.thumb)
        }
    }

    private companion object {
        const val ITEM_DP = 46f
        const val GAP_DP = 3f
    }
}

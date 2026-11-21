package com.srizwan.gallery.home

import android.graphics.drawable.GradientDrawable
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.srizwan.gallery.R
import com.srizwan.gallery.data.GalleryImage
import com.srizwan.gallery.loader.ImageLoader
import com.srizwan.gallery.ui.GlassUi
import com.srizwan.gallery.ui.VectorLabelDrawable
import com.srizwan.gallery.ui.VectorText
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale
import kotlin.math.max

/** One row of the Photos grid: a date header (spans every column) or a picture. */
internal sealed class PhotoItem {
    class Header(val epochDay: Long) : PhotoItem()

    /** [index] is the position of [image] in the picture-only list ([PhotosAdapter.images]). */
    class Photo(val image: GalleryImage, val index: Int) : PhotoItem()
}

/**
 * The Photos grid: date headers and square thumbnails. The thumbnails come from [ImageLoader] (cancelled when a row is
 * recycled). [columns] and [viewWidthPx] decide the thumbnail size that is asked for.
 *
 * Step 9 (multi-select): a tap calls [onClick] and a long press [onLongPress] (the screen decides what they mean: open
 * the viewer, or toggle / start selecting). While [setSelection] says the screen is selecting, every cell shows a round
 * check mark (filled in the accent colour when picked) and a picked thumbnail is tinted and a little smaller. Only these
 * overlays are bound again when the selection changes (a payload), so no thumbnail is reloaded.
 */
internal class PhotosAdapter(
    private val onClick: (index: Int) -> Unit,
    private val onLongPress: (index: Int) -> Unit = {}
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var items: List<PhotoItem> = emptyList()

    /** The pictures in display order (without headers); [PhotoItem.Photo.index] points into this list. */
    var images: List<GalleryImage> = emptyList()
        private set

    var columns: Int = 3
        private set

    /** Width of the list in pixels (set by the screen); 0 = use the screen width. */
    var viewWidthPx: Int = 0

    private var today: LocalDate = LocalDate.now()
    private val sameYear = DateTimeFormatter.ofPattern("EEE, d MMM", Locale.getDefault())
    private val otherYear = DateTimeFormatter.ofPattern("d MMM yyyy", Locale.getDefault())

    fun submit(items: List<PhotoItem>, images: List<GalleryImage>) {
        this.items = items
        this.images = images
        today = LocalDate.now()
        notifyDataSetChanged()
    }

    /**
     * The list got a new width (rotation, split screen, new insets): the thumbnails are asked for again at the new
     * size (the loader's caches make this cheap). Done after the layout pass; the very first width needs no refresh.
     */
    fun updateWidth(widthPx: Int, list: RecyclerView) {
        if (widthPx == viewWidthPx) return
        val first = viewWidthPx <= 0
        viewWidthPx = widthPx
        if (!first && items.isNotEmpty()) list.post { notifyDataSetChanged() }
    }

    fun setColumns(value: Int) {
        if (value == columns) return
        columns = value
        notifyDataSetChanged() // the cells ask for a thumbnail of the new size
    }

    fun isHeader(position: Int): Boolean = items.getOrNull(position) is PhotoItem.Header

    /** Index into [images] of the picture shown at adapter [position], or -1 for a header / an invalid position. */
    fun photoIndexAt(position: Int): Int = (items.getOrNull(position) as? PhotoItem.Photo)?.index ?: -1

    private var selecting = false
    private var selected: Set<String> = emptySet()

    /** Selection mode on / off and the picked paths. Only the check marks and tints are redrawn. */
    fun setSelection(selecting: Boolean, selected: Set<String>) {
        this.selecting = selecting
        this.selected = selected
        if (items.isNotEmpty()) notifyItemRangeChanged(0, items.size, PAYLOAD_SELECTION)
    }

    override fun getItemCount(): Int = items.size

    override fun getItemViewType(position: Int): Int =
        if (items[position] is PhotoItem.Header) TYPE_HEADER else TYPE_PHOTO

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val ctx = parent.context
        if (viewType == TYPE_HEADER) {
            val header = VectorText(ctx).apply {
                setPadding(GlassUi.dp(ctx, 14f), GlassUi.dp(ctx, 18f), GlassUi.dp(ctx, 14f), GlassUi.dp(ctx, 8f))
                layoutParams = RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            }
            return HeaderHolder(header)
        }
        val cell = SquareFrame(ctx).apply {
            val gap = GlassUi.dp(ctx, 1f)
            setPadding(gap, gap, gap, gap)
            layoutParams = RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        }
        val image = ImageView(ctx).apply { scaleType = ImageView.ScaleType.CENTER_CROP }
        cell.addView(image, FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT))
        val badge = ImageView(ctx).apply {
            visibility = View.GONE
            setImageDrawable(VectorLabelDrawable(ctx, "GIF", 0, textSizeDp = 10f))
            val ph = GlassUi.dp(ctx, 6f)
            val pv = GlassUi.dp(ctx, 4f)
            setPadding(ph, pv, ph, pv)
            background = GradientDrawable().apply {
                cornerRadius = GlassUi.dp(ctx, 8f).toFloat()
                setColor(0x99000000.toInt())
            }
        }
        cell.addView(
            badge,
            FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT,
                Gravity.BOTTOM or Gravity.START
            ).apply {
                val m = GlassUi.dp(ctx, 6f)
                setMargins(m, m, m, m)
            }
        )
        val dim = View(ctx).apply {
            visibility = View.GONE
            setBackgroundColor((ctx.getColor(R.color.gl_accent) and 0x00FFFFFF) or 0x55000000)
        }
        cell.addView(dim, FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT))
        val check = ImageView(ctx).apply {
            visibility = View.GONE
            val p = GlassUi.dp(ctx, 2f)
            setPadding(p, p, p, p)
        }
        val checkSize = GlassUi.dp(ctx, 26f)
        cell.addView(
            check,
            FrameLayout.LayoutParams(checkSize, checkSize, Gravity.TOP or Gravity.END).apply {
                val m = GlassUi.dp(ctx, 6f)
                setMargins(m, m, m, m)
            }
        )
        val holder = PhotoHolder(cell, image, badge, dim, check)
        cell.setOnClickListener { holder.index.takeIf { it >= 0 }?.let(onClick) }
        cell.setOnLongClickListener {
            val i = holder.index
            if (i >= 0) {
                onLongPress(i)
                true
            } else false
        }
        return holder
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int, payloads: MutableList<Any>) {
        if (payloads.isNotEmpty() && payloads.all { it === PAYLOAD_SELECTION }) {
            val item = items.getOrNull(position)
            if (holder is PhotoHolder && item is PhotoItem.Photo) bindSelection(holder, item.image)
            return
        }
        super.onBindViewHolder(holder, position, payloads)
    }

    private fun bindSelection(holder: PhotoHolder, image: GalleryImage) {
        val picked = selecting && image.path in selected
        holder.dim.visibility = if (picked) View.VISIBLE else View.GONE
        holder.check.visibility = if (selecting) View.VISIBLE else View.GONE
        val ctx = holder.itemView.context
        if (picked) {
            holder.check.setImageResource(R.drawable.gl_ic_check_circle)
            holder.check.setColorFilter(ctx.getColor(R.color.gl_accent))
        } else {
            holder.check.setImageResource(R.drawable.gl_ic_circle)
            holder.check.setColorFilter(0xE6FFFFFF.toInt())
        }
        val scale = if (picked) 0.88f else 1f
        holder.image.scaleX = scale
        holder.image.scaleY = scale
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (val item = items[position]) {
            is PhotoItem.Header -> {
                (holder.itemView as VectorText).set(dayLabel(holder.itemView, item.epochDay), 15f, 0xFFFFFFFF.toInt(), bold = true)
            }
            is PhotoItem.Photo -> {
                holder as PhotoHolder
                holder.index = item.index
                holder.image.contentDescription = item.image.name
                holder.badge.visibility = if (item.image.isGif) View.VISIBLE else View.GONE
                val width = if (viewWidthPx > 0) viewWidthPx else holder.itemView.resources.displayMetrics.widthPixels
                ImageLoader.load(holder.image, item.image, max(1, width / columns))
                bindSelection(holder, item.image)
            }
        }
    }

    override fun onViewRecycled(holder: RecyclerView.ViewHolder) {
        if (holder is PhotoHolder) {
            holder.index = -1
            ImageLoader.cancel(holder.image)
        }
    }

    private fun dayLabel(view: View, epochDay: Long): String {
        val ctx = view.context
        val day = LocalDate.ofEpochDay(epochDay)
        return when {
            day == today -> ctx.getString(R.string.gl_today)
            day == today.minusDays(1) -> ctx.getString(R.string.gl_yesterday)
            day.year == today.year -> day.format(sameYear)
            else -> day.format(otherYear)
        }
    }

    private class HeaderHolder(view: VectorText) : RecyclerView.ViewHolder(view)

    private class PhotoHolder(
        cell: SquareFrame,
        val image: ImageView,
        val badge: ImageView,
        val dim: View,
        val check: ImageView
    ) : RecyclerView.ViewHolder(cell) {
        var index: Int = -1
    }

    private companion object {
        const val TYPE_HEADER = 0
        const val TYPE_PHOTO = 1
        val PAYLOAD_SELECTION = Any()
    }
}

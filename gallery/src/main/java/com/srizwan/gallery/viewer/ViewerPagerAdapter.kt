package com.srizwan.gallery.viewer

import android.graphics.Bitmap
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.srizwan.gallery.data.GalleryImage
import com.srizwan.gallery.loader.ImageLoader

/**
 * The pages of the viewer's ViewPager2: one [ZoomImageView] per picture. A page shows a cached thumbnail at once (the
 * grid already decoded one, so there is no black flash) and loads the real picture behind it; a recycled page lets go
 * of its picture, tiles and animation. Step 8: a picture can be turned in the viewer (view only); the turn is remembered
 * here per path, so it survives a page being recycled, and a picture can be removed (deleted) or replaced (renamed).
 */
internal class ViewerPagerAdapter(
    private val listener: ZoomImageView.Listener
) : RecyclerView.Adapter<ViewerPagerAdapter.Holder>() {

    class Holder(val view: ZoomImageView) : RecyclerView.ViewHolder(view)

    var images: List<GalleryImage> = emptyList()
        private set

    private val live = HashSet<Holder>()

    /** View-only rotation of the pictures, in quarter turns clockwise, by path (absent = 0). */
    private val turns = HashMap<String, Int>()

    fun submit(list: List<GalleryImage>) {
        images = list
        notifyDataSetChanged()
    }

    /** Removes the picture at [position] (it was deleted). */
    fun removeAt(position: Int) {
        if (position !in images.indices) return
        turns.remove(images[position].path)
        images = images.toMutableList().also { it.removeAt(position) }
        notifyItemRemoved(position)
    }

    /** The picture at [position] is now [image] (renamed): the page is bound again. */
    fun replaceAt(position: Int, image: GalleryImage) {
        if (position !in images.indices) return
        val old = images[position].path
        turns.remove(old)?.let { if (it != 0) turns[image.path] = it }
        images = images.toMutableList().also { it[position] = image }
        notifyItemChanged(position)
    }

    /** The picture at [position] changed on disk (rotation saved) and its turn is cleared: load it again. */
    fun reload(position: Int, image: GalleryImage) {
        if (position !in images.indices) return
        turns.remove(images[position].path)
        images = images.toMutableList().also { it[position] = image }
        notifyItemChanged(position)
    }

    /** The view-only rotation of the picture at [path], in quarter turns clockwise. */
    fun turnsOf(path: String): Int = turns[path] ?: 0

    /** Sets the view-only rotation of the picture at [position] and turns its page now. */
    fun setTurns(position: Int, quarterTurns: Int) {
        val image = images.getOrNull(position) ?: return
        val t = ((quarterTurns % 4) + 4) % 4
        if (t == 0) turns.remove(image.path) else turns[image.path] = t
        viewAt(position)?.setTurns(t)
    }

    /** The page that shows position [position] right now, or null when it is not bound. */
    fun viewAt(position: Int): ZoomImageView? =
        live.firstOrNull { it.bindingAdapterPosition == position }?.view

    /** Sets every page except [position] back to "fit" (after a swipe, the neighbour you left is not left zoomed). */
    fun resetZoomExcept(position: Int) {
        for (h in live) if (h.bindingAdapterPosition != position) h.view.resetZoom(animated = false)
    }

    override fun getItemCount(): Int = images.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val v = ZoomImageView(parent.context).apply {
            layoutParams = RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
            listener = this@ViewerPagerAdapter.listener
        }
        return Holder(v)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        live.add(holder)
        val image = images[position]
        holder.view.contentDescription = image.name
        holder.view.show(image, previewFor(image), turns[image.path] ?: 0)
    }

    override fun onViewRecycled(holder: Holder) {
        holder.view.clear()
        live.remove(holder)
    }

    /** The biggest thumbnail of [image] that the grid / filmstrip already has in memory. */
    private fun previewFor(image: GalleryImage): Bitmap? {
        for (size in PREVIEW_SIZES) ImageLoader.cachedThumb(image, size)?.let { return it }
        return null
    }

    private companion object {
        val PREVIEW_SIZES = intArrayOf(768, 512, 384, 256, 192, 128)
    }
}
